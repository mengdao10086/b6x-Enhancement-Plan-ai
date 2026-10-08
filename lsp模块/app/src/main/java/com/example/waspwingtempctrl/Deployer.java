package com.example.waspwingtempctrl;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 部署链路核心。界面只允许调 {@link #probe()}、{@link #deploy()}、{@link #uninstall()}、
 * {@link #startDaemon()}、{@link #stopDaemon()}、{@link #buildDiagnostics()}，不得自己拼 shell、不得直接碰文件；
 * root 调用一律走 {@link RootShell}（I2）。本类方法全部阻塞，<b>禁止在主线程调用</b>。
 *
 * <p>I4 部署完成判据、二进制/脚本为何经私有目录中转 —— 详见 app/逻辑说明.md §2.1、§2.5。
 */
public final class Deployer {

    /** APK 内的 C 二进制（CI 注入，名字由 CI 决定，此处为接口约定）。 */
    public static final String BIN_ASSET = "tempctrl-arm64";
    /** 二进制最终落点（沿用 noexec 规避：模块目录挂载了 noexec，不能直接执行）。 */
    public static final String BIN_DEST = "/data/local/tmp/tempctrl";
    /** APK 内的 service.d 脚本模板（逐字节部署）。 */
    public static final String SCRIPT_ASSET = "deploy/b6x-tempctrl.sh";
    /** service.d 里的脚本名。 */
    public static final String SCRIPT_NAME = "b6x-tempctrl.sh";
    /** Magisk / APatch / KernelSU ≥10683 的 service.d 目录。 */
    public static final String SERVICE_D_MODERN = "/data/adb/service.d";
    /** KernelSU <10683 的旧 service.d 目录。 */
    public static final String SERVICE_D_KSU_LEGACY = "/data/adb/ksu/service.d";
    /** KernelSU 从此 versionCode 起支持 /data/adb/service.d。 */
    public static final int KSU_MODERN_VER_CODE = 10683;

    /**
     * 看门狗候选进程的 comm 白名单。**它只是省 fork 的快筛、不是判据**：身份判据只有「某参数整等于脚本路径」；
     * 真机 service.d 拉起的看门狗 comm 是 {@code busybox}、app 拉起的是 {@code sh} —— 曾只认 {@code sh} 漏掉后者
     * （「停止daemon」静默失效），白名单含它即为此。详见 app/逻辑说明.md §2.3。
     */
    private static final String WD_COMM_WHITELIST = "sh|ash|busybox|mksh|dash|toybox";
    /** C 端单实例锁退出码：已有实例在运行。 */
    public static final int EXIT_ALREADY_RUNNING = 2;

    /** 同步清单文件名（放私有目录，随卸载连目录一起删）。 */
    public static final String MANIFEST_NAME = "tempctrl_sync_manifest";
    /** 清单里的 APK 时间戳键（app 写、脚本读；两边字面量必须一致）。 */
    private static final String MANIFEST_KEY_APK_MTIME = "APK_MTIME";

    /**
     * 「自动更新」开关的配置键（定义在 {@code params.def.json} 的 webui 组；值落 {@code profile.conf}，
     * 脚本侧 grep 同一个键 —— 避免双份真相）。详见 app/逻辑说明.md §2.5。
     */
    public static final String KEY_UI_AUTO_UPDATE = "UI_AUTO_UPDATE";

    /**
     * root 探测的一次性落盘标记所在的 prefs 文件名与键。键名与文件名只在根包收口
     * （读写的类分处两个包），避免同一字面量写两份。详见 app/逻辑说明.md §2.5。
     */
    public static final String PREFS_ROOT_PROBE = "root_probe";
    /** 首次启动的 root 尝试标记（只试一次，被拒/失败都不再重试）。 */
    public static final String KEY_ROOT_TRIED = "root_tried";
    /** 已提示过「二进制哈希不一致」的 APK 侧 expected md5。 */
    public static final String KEY_HASH_PROMPTED_MD5 = "bin_hash_prompted_md5";
    /** 设备侧上次已知的二进制 md5（部署成功或探测确认一致时写入）。 */
    public static final String KEY_BIN_DEPLOYED_MD5 = "bin_deployed_md5";
    /**
     * 上次探测时 root 是否可用（{@code suOk} 的落盘快照）。落页判定用
     * {@link #rootNotYetGranted} 读它，据此决定自动更新开着时是否仍要把用户导向状态页。
     */
    public static final String KEY_ROOT_OK = "root_ok";

    private static final long START_COOLDOWN_MS = 10_000L;
    /** {@code kill}（SIGTERM）后等进程退出的轮数：C 端要等当前一轮跑完（≤5s，同脚本 {@code WAIT_LOOPS}），5 轮即够。
     *  详见 app/逻辑说明.md §2.2。 */
    private static final long KILL_WAIT_LOOPS = 5L;
    /** 强杀（{@code kill -9}）后的等待轮数：-9 已不可被忽略，只需一小段收尾时间。 */
    private static final long KILL9_WAIT_LOOPS = 3L;
    /**
     * 兜底超时（毫秒）。<b>只留给不在这条部署主链上的动作</b>（{@link #uninstall()}、{@link #stopDaemon()}）。
     * 主链各步按耗时分级（见下）——一刀切 120s 会把"某一步在设备上挂住"整体拖成分钟级等待。
     */
    private static final long EXEC_TIMEOUT_MS = 120_000L;
    /** 部署写盘趟：落盘 + 双侧 md5 + 状态回吐，全是文件操作，60s 对任何正常设备都绰绰有余。 */
    private static final long DEPLOY_WRITE_TIMEOUT_MS = 60_000L;
    /** 停旧起新趟（含设备侧最多一次重试）：等旧实例退出 ≤5s + 起新 sleep 2s，30s 足够。 */
    private static final long RESTART_TIMEOUT_MS = 30_000L;
    /** 省电白名单（已移出主链、后台 best-effort）：3 个包 × 几条 am/appops。取 20s 还有个作用——
     *  它一旦拿到串行锁就持有到本趟结束，故这也是"用户点击最多排在它后面多久"的上界。 */
    private static final long ALLOWLIST_TIMEOUT_MS = 20_000L;
    /**
     * {@link #probe()} 那趟 su 往返的超时：probe 只跑只读脚本、不等进程退出，故远短于兜底超时。
     * 取 15s 给慢设备 su 冷启动与首次授权框留余量。详见 app/逻辑说明.md §2.1。
     */
    private static final long PROBE_EXEC_TIMEOUT_MS = 15_000L;

    /**
     * asset 哈希的进程级 memo（key = asset 路径）。只在成功时写（否则瞬时失败会被永久记住）；
     * 不随 APK 更新失效（覆盖安装会杀进程）。详见 app/逻辑说明.md §2.1。
     */
    private static final Map<String, String> ASSET_MD5_MEMO = new ConcurrentHashMap<>();

    private static volatile Deployer instance;

    private final Context appContext;
    private final RootShell shell;
    private final ConfigStore configStore;

    /**
     * 拉起冷却（内存态，进程重启即失效）。只由 {@link #startDaemon()} 写（成功失败都写，防连点）；
     * {@link #deploy()} 成功时清零。详见 app/逻辑说明.md §2.2。
     */
    private volatile long lastStartAtMs;

    private Deployer(Context context) {
        this.appContext = context.getApplicationContext();
        this.shell = RootShell.get(this.appContext);
        this.configStore = ConfigStore.get(this.appContext);
    }

    public static Deployer get(Context context) {
        Deployer local = instance;
        if (local == null) {
            synchronized (Deployer.class) {
                local = instance;
                if (local == null) {
                    local = new Deployer(context);
                    instance = local;
                }
            }
        }
        return local;
    }

    /**
     * 是否需要重新部署 —— <b>只读缓存，不跑 su</b>，供启动落页判定调用（在 {@code ww-preload} 预热线程上）。
     * 判据：设备侧上次已知的二进制 md5（{@link #KEY_BIN_DEPLOYED_MD5}）与 APK 内 {@code assets/tempctrl-arm64}
     * 不一致；无缓存时退化为「首启判据」{@code !root_tried}。详见 app/逻辑说明.md §2.1。
     */
    public static boolean needsRedeploy(Context context) {
        Context app = context.getApplicationContext();
        // 先读 prefs：下面这一支与资产无关，故不为它白算资产 MD5（落页判定那条路上最贵的一步）。见 §2.1
        SharedPreferences prefs = app.getSharedPreferences(PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
        String cached = prefs.getString(KEY_BIN_DEPLOYED_MD5, null);
        if (cached == null || cached.isEmpty()) {
            if (prefs.getBoolean(KEY_ROOT_TRIED, false)) {
                return false;   // 已试过 root 却仍无缓存：不再自动引导（见 §2.1）
            }
            // 未试过 root：仍要"资产取不到 → 一律 false"这条护栏，故资产可比性还得问一次
            return !md5OfAssetOrEmpty(app, BIN_ASSET).isEmpty();
        }
        String expected = md5OfAssetOrEmpty(app, BIN_ASSET);
        if (expected.isEmpty()) {
            return false;
        }
        return !cached.equals(expected);
    }

    /**
     * 记下设备侧当前已知的二进制 md5（{@link #needsRedeploy} 的唯一数据来源）。空值不写。
     * 详见 app/逻辑说明.md §2.1。
     */
    public static void rememberDeployedBinMd5(Context context, String deviceBinMd5) {
        if (deviceBinMd5 == null || deviceBinMd5.isEmpty()) {
            return;
        }
        context.getApplicationContext()
                .getSharedPreferences(PREFS_ROOT_PROBE, Context.MODE_PRIVATE)
                .edit().putString(KEY_BIN_DEPLOYED_MD5, deviceBinMd5).apply();
    }

    /**
     * 「自动更新」开关当前是否开启（<b>默认开</b>）。读的是 {@link ConfigStore} 的内存快照、不阻塞；
     * 读不到即按默认值【开】处理。详见 app/逻辑说明.md §2.5。
     */
    public static boolean isAutoUpdateEnabled(Context context) {
        ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_AUTO_UPDATE);
        return value == null || value.intAt(0) != 0;
    }

    /**
     * 记下「本次探测 root 是否可用」（{@link #KEY_ROOT_OK} 的唯一写处），由探测路径在拿到
     * {@link Status#suOk} 后调一次。root 一旦消失（su 不通）也会被写成 false，于是"尚未取得 root"
     * 这个状态可再次成立——这正是"root 丢失后可再回状态页"的依据。
     */
    public static void rememberRootState(Context context, boolean suOk) {
        context.getApplicationContext()
                .getSharedPreferences(PREFS_ROOT_PROBE, Context.MODE_PRIVATE)
                .edit().putBoolean(KEY_ROOT_OK, suOk).apply();
    }

    /**
     * root 是否<b>尚未取得</b>（= 需要申请）。只读缓存、不跑 su，供启动落页判定在预热线程上调用。
     * 读不到（从未探测成功）即视为尚未取得。语义见 app/逻辑说明.md §5.1。
     */
    public static boolean rootNotYetGranted(Context context) {
        return !context.getApplicationContext()
                .getSharedPreferences(PREFS_ROOT_PROBE, Context.MODE_PRIVATE)
                .getBoolean(KEY_ROOT_OK, false);
    }

    // ==================== 状态 / 判定 ====================

    /**
     * 部署状态。{@link #describe()} 是唯一出屏形态，状态区与诊断信息共用同一份文本：
     * 结论行 + 二进制 / service.d 脚本 / 配置 / 守护进程 / 看门狗 shell 逐项 + 提示行。
     */
    public static final class Status {
        public final boolean suOk;
        public final boolean binExists;
        public final boolean binExecutable;
        public final boolean binHashOk;
        public final String binMd5;
        public final String binExpectedMd5;
        public final String scriptPath;
        public final boolean scriptPresent;
        public final boolean scriptHashOk;
        public final String scriptMd5;
        public final String scriptExpectedMd5;
        public final boolean configPresent;
        public final boolean configPathAligned;
        public final boolean daemonRunning;
        /** c-daemon 的 PID，空格分隔（{@link #daemonRunning} 为 false 时为空串）。 */
        public final String daemonPids;
        /**
         * 看门狗 shell 的个数与 PID（与 {@link #daemonRunning} 取自同一趟 su 往返）。
         *
         * <p>个数为 0 有两种情形，本行不区分：确实没有；或 su 不通（{@code WD_COUNT} 拿不到）——
         * 后者由结论行的「（无 su）」与提示行兜住，与 {@link #daemonRunning} 同一条约定。
         */
        public final int watchdogCount;
        /** 看门狗 shell 的 PID，空格分隔（{@link #watchdogCount} 为 0 时为空串）。 */
        public final String watchdogPids;
        /** I4 判据的结果。 */
        public final boolean deployed;
        /** 配置文件绝对路径（app 侧）。 */
        public final String configPath;
        public final List<String> notes;

        Status(boolean suOk, boolean binExists, boolean binExecutable, boolean binHashOk,
               String binMd5, String binExpectedMd5, String scriptPath, boolean scriptPresent,
               boolean scriptHashOk, String scriptMd5, String scriptExpectedMd5,
               boolean configPresent, boolean configPathAligned, boolean daemonRunning,
               String daemonPids, int watchdogCount, String watchdogPids,
               boolean deployed, String configPath, List<String> notes) {
            this.suOk = suOk;
            this.binExists = binExists;
            this.binExecutable = binExecutable;
            this.binHashOk = binHashOk;
            this.binMd5 = binMd5;
            this.binExpectedMd5 = binExpectedMd5;
            this.scriptPath = scriptPath;
            this.scriptPresent = scriptPresent;
            this.scriptHashOk = scriptHashOk;
            this.scriptMd5 = scriptMd5;
            this.scriptExpectedMd5 = scriptExpectedMd5;
            this.configPresent = configPresent;
            this.configPathAligned = configPathAligned;
            this.daemonRunning = daemonRunning;
            this.daemonPids = daemonPids;
            this.watchdogCount = watchdogCount;
            this.watchdogPids = watchdogPids;
            this.deployed = deployed;
            this.configPath = configPath;
            this.notes = Collections.unmodifiableList(notes);
        }

        /**
         * 部署状态：结论行 + 逐项 + 提示行（状态区与诊断信息都用这一份）。
         *
         * <p>逐项不因 su 不通而省略：结论行已带「（无 su）」，且提示行里会写明 root 通道不可用，
         * 「读到不存在」的原因因此有落点。
         */
        public String describe() {
            StringBuilder sb = new StringBuilder(summaryLine()).append('\n');
            sb.append("  二进制 ").append(BIN_DEST).append("：")
                    .append(!binExists ? "不存在" : (binExecutable ? "存在且可执行" : "存在但不可执行"))
                    .append(binHashOk ? "，哈希一致" : "，哈希不一致")
                    .append('\n');
            appendHashPair(sb, binExpectedMd5, binMd5);
            sb.append("  service.d 脚本：")
                    .append(scriptPresent ? scriptPath : "未安装")
                    .append(scriptPresent && !scriptHashOk ? "（哈希不一致）" : "").append('\n');
            if (scriptPresent) {
                appendHashPair(sb, scriptExpectedMd5, scriptMd5);
            }
            sb.append("  配置 ").append(configPath).append("：")
                    .append(configPresent ? "已存在" : "不存在（c-daemon 将用代码默认值）")
                    .append(configPathAligned ? "" : "，且与 C 端落点不一致").append('\n');
            sb.append("  c-daemon：").append(daemonRunning
                    ? "运行中" + (daemonPids.isEmpty() ? "" : "（PID " + daemonPids + "）")
                    : "未运行").append('\n');
            sb.append("  sh-watchdog：").append(watchdogLine()).append('\n');
            appendNotes(sb);
            return sb.toString();
        }

        /**
         * 「看门狗 shell」一行的取值（为让看门狗在界面上可见）：在此之前状态区只有前四项，看门狗既不在
         * "在跑"里也不在"没跑"里——「停机时它仍在跑」「同时有两个」都只能在 root shell 里才看得见。
         *
         * <p>个数直出，不做"正常/异常"判断：0 个在「刚点过停止daemon」和「首次部署前」都是正常的。
         * 只有 ≥2 才额外标一句——那是本轮要根治的双实例并存。
         */
        private String watchdogLine() {
            if (watchdogCount <= 0) {
                return "未检测到";
            }
            if (watchdogCount == 1) {
                return "运行中（PID " + watchdogPids + "）";
            }
            return "检测到 " + watchdogCount + " 个（PID " + watchdogPids + "）——多实例并存，异常";
        }

        /** 结论行（两种形态共用）：「无 su」紧跟其后 —— 它是部署未完成最常见的原因，单列容易被当成另一件事。 */
        private String summaryLine() {
            return "部署状态：" + (deployed ? "已完成" : "未完成") + (suOk ? "" : "（无 su）");
        }

        /**
         * 一组哈希（apk 侧 / 设备侧）。两值一致时合成一行——同一个串印两遍没有信息量；
         * 不一致时各占一行，位数一多并排就没法逐位比对。
         *
         * <p>apk 侧哈希为空（APK 内资源缺失）时无从比对，整组不给；该文件不在设备上时由调用处先判。
         */
        private void appendHashPair(StringBuilder sb, String expected, String actual) {
            if (expected.isEmpty()) {
                return;
            }
            if (expected.equals(actual)) {
                sb.append("    apk = 设备 = ").append(expected).append('\n');
                return;
            }
            sb.append("    apk  = ").append(expected).append('\n');
            sb.append("    设备 = ").append(actual.isEmpty() ? "—" : actual).append('\n');
        }

        /** 提示行：每条提示都是一个"需要用户知道"的异常（资源缺失、缺 md5sum、目录不一致、root 不通）。 */
        private void appendNotes(StringBuilder sb) {
            for (String note : notes) {
                sb.append("  提示：").append(note).append('\n');
            }
        }
    }

    /**
     * 探测部署状态。<b>阻塞</b>（root 往返一次）。
     *
     * @return 永不为 null；su 不可用时 {@link Status#suOk} 为 false，其余字段为 false/空
     */
    public Status probe() {
        String expectedBin = "";
        String expectedScript = "";
        List<String> notes = new ArrayList<>();
        try {
            expectedBin = md5OfAsset(BIN_ASSET);
            expectedScript = md5OfAsset(SCRIPT_ASSET);
        } catch (IOException e) {
            notes.add("APK 内资源不完整：" + e.getMessage());
        }

        RootShell.Result r = shell.exec(probeScript(), PROBE_EXEC_TIMEOUT_MS);
        if (!r.isOk()) {
            notes.add("root 通道不可用：" + r.describe());
        }
        return buildStatus(parseKv(r.stdout), r.isOk(), expectedBin, expectedScript, notes);
    }

    /**
     * 由一趟 su 回吐的 {@code KEY=VALUE} 组装 {@link Status}。三条路径共用：{@link #probe()}（探测趟）、
     * {@link #deploy()}（写盘趟末尾自带回吐）、{@link #startDaemon()}（拉起趟末尾自带回吐）——
     * 后两者不再"另起一趟 su 再探一次"（见 app/逻辑说明.md §2.1、§8.1）。
     *
     * @param suOk           该趟是否拿到正常退出码
     * @param expectedBin    APK 内二进制期望 md5（空串=不可比）
     * @param expectedScript APK 内脚本期望 md5（空串=不可比）
     * @param notes          调用方已有的提示行（本方法继续追加）
     */
    private Status buildStatus(Map<String, String> kv, boolean suOk, String expectedBin,
                               String expectedScript, List<String> notes) {
        if (kv.containsKey("MD5TOOL") && "0".equals(kv.get("MD5TOOL"))) {
            notes.add("设备缺少 md5sum，无法比对内容哈希（判定退化为存在性检查）");
        }
        String scriptPath = kv.get("SCRIPT");
        if (scriptPath == null) {
            scriptPath = "";
        }
        boolean binExists = "1".equals(kv.get("BIN_EXISTS"));
        boolean binExec = "1".equals(kv.get("BIN_EXEC"));
        String binMd5 = nvl(kv.get("BIN_MD5"));
        String scriptMd5 = nvl(kv.get("SCRIPT_MD5"));
        boolean binHashOk = !expectedBin.isEmpty() && expectedBin.equals(binMd5);
        boolean scriptPresent = !scriptPath.isEmpty();
        boolean scriptHashOk = scriptPresent && !expectedScript.isEmpty()
                && expectedScript.equals(scriptMd5);
        boolean aligned = configStore.isPathAlignedWithDaemon();
        if (!aligned) {
            notes.add("私有目录不一致：C 端读写 " + ConfigStore.DAEMON_PRIVATE_DIR
                    + "，app 实际能写 " + configStore.getPrivateDir().getAbsolutePath()
                    + " —— 配置与日志互不可见，需拍板改一处");
        }
        boolean deployed = suOk && binExists && binExec && binHashOk
                && scriptPresent && scriptHashOk;
        // 看门狗：个数与 PID 都来自同一趟 wd_pids()（缺键＝su 未通、值非法都退化为"未检测到"）
        int wdCount = 0;
        String wdCountRaw = nvl(kv.get("WD_COUNT")).trim();
        if (!wdCountRaw.isEmpty()) {
            try {
                wdCount = Integer.parseInt(wdCountRaw);
            } catch (NumberFormatException ignored) {
                wdCount = 0;
            }
        }
        return new Status(suOk, binExists, binExec, binHashOk, binMd5, expectedBin,
                scriptPath, scriptPresent, scriptHashOk, scriptMd5, expectedScript,
                configStore.exists(), aligned, "1".equals(kv.get("RUNNING")),
                nvl(kv.get("DAEMON_PIDS")), wdCount, nvl(kv.get("WD_PIDS")),
                deployed, configStore.getConfigFile().getAbsolutePath(), notes);
    }

    /**
     * 主动尝试获取 root（会触发系统授权框）。<b>阻塞</b>。
     *
     * <p>与 {@link #probe()} 的区别：probe 只读现状，本方法会真的发起一次 su 往返，
     * 用于"首次启动试一次"的场景。
     *
     * @return true 表示已确认拿到 uid=0
     */
    public boolean ensureRoot() {
        return shell.checkAlive();
    }

    // ==================== 部署 / 卸载 ====================

    /** 一次动作的结果。 */
    public static final class Result {
        public final boolean ok;
        /**
         * <b>盘面是否已就位</b>（只有 {@link Deployer#deploy()} 会置真）：二进制与脚本都已落盘且与 APK 内一致。
         * 比 {@link #ok} 弱；为什么必须单列 —— 详见 app/逻辑说明.md §2.2。
         */
        public final boolean placementsOk;
        public final String action;
        public final List<String> steps;
        public final String error;
        /**
         * 动作收尾时的那次探测结果，供调用方直接上屏（免掉自己再探一次 su 往返）。
         *
         * <p><b>为 null 的两种情形</b>：早退失败（连 root 都没跑成，没有任何现状可探）、
         * 以及本就不探测的动作（如 {@link Deployer#updateScript()}）。调用方据此退回
         * {@link #describe()}——那里有失败原因与已走过的步骤。
         */
        public final Status status;

        /**
         * 除 {@link Deployer#deploy()} 外的动作用这一条：它们不承担"把新二进制写上盘"这件事，
         * {@link #placementsOk} 无意义（恒假），调用方不得据此判断。
         */
        Result(boolean ok, String action, List<String> steps, String error, Status status) {
            this(ok, false, action, steps, error, status);
        }

        Result(boolean ok, boolean placementsOk, String action, List<String> steps, String error,
               Status status) {
            this.ok = ok;
            this.placementsOk = placementsOk;
            this.action = action;
            this.steps = Collections.unmodifiableList(steps);
            this.error = error;
            this.status = status;
        }

        /**
         * 动作 + 步骤 + 状态。状态部分走 {@link Status#describe()} 的简短版（状态区直接上屏），
         * 逐项细节看诊断信息。
         */
        public String describe() {
            StringBuilder sb = new StringBuilder();
            sb.append(action).append(ok ? "：成功" : "：失败");
            if (!error.isEmpty()) {
                sb.append("（").append(error).append("）");
            }
            sb.append('\n');
            for (String step : steps) {
                sb.append("· ").append(step).append('\n');
            }
            if (status != null) {
                sb.append(status.describe());
            }
            return sb.toString();
        }
    }

    /**
     * 一次性部署：资源落盘与授权 → 二进制就位 → service.d 脚本 → 配置保留写入 → 状态自检（与写盘同一趟 su 回吐）。
     * 省电白名单已移出主链（后台 best-effort，见 {@link #submitPowerAllowlistAsync()}）。
     * <b>只动盘、不重启守护进程</b>（"换完盘立刻拉起一次"由调用方接在部署之后）；
     * 调用方该看 {@link Result#placementsOk} 而非 {@link Result#ok}。<b>阻塞</b>。
     * 详见 app/逻辑说明.md §2.1、§2.2。
     */
    public Result deploy() {
        List<String> steps = new ArrayList<>();
        // 用户主动动作：清掉上一次的失败退避与缓存的 su 命令，等价于"重启 app"对通道的复位（不必真重启）
        shell.resetChannel();

        File stagedBin;
        File stagedScript;
        String binMd5;
        String scriptMd5;
        try {
            File staging = new File(configStore.getPrivateDir(), "deploy");
            if (!staging.isDirectory() && !staging.mkdirs()) {
                return new Result(false, "部署", steps, "私有目录中转目录创建失败：" + staging, null);
            }
            stagedBin = new File(staging, "tempctrl");
            stagedScript = new File(staging, SCRIPT_NAME);
            binMd5 = stageAsset(BIN_ASSET, stagedBin, true);
            steps.add("二进制已落到私有目录并授权：" + stagedBin + "（md5=" + binMd5 + "）");
            scriptMd5 = stageAsset(SCRIPT_ASSET, stagedScript, true);
            steps.add("脚本已落到私有目录并授权：" + stagedScript + "（md5=" + scriptMd5 + "）");
        } catch (IOException e) {
            return new Result(false, "部署", steps, e.getMessage(), null);
        }

        RootShell.Result r = shell.exec(deployScript(stagedBin, stagedScript), DEPLOY_WRITE_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "部署", steps, "root 执行失败：" + r.describe(), null);
        }
        String svcd = nvl(kv.get("SVCD"));
        String ksuVer = nvl(kv.get("KSU_VER"));
        steps.add("service.d 目录：" + svcd + (ksuVer.isEmpty() ? "" : "（KernelSU verCode=" + ksuVer + "）"));
        if (svcd.isEmpty()) {
            return new Result(false, "部署", steps, "未能确定 service.d 目录", null);
        }
        if (!"1".equals(kv.get("BIN_OK"))) {
            return new Result(false, "部署", steps,
                    "二进制就位失败（" + BIN_DEST + "）", null);
        }
        steps.add("二进制就位：" + BIN_DEST);
        if (!"1".equals(kv.get("SCRIPT_OK"))) {
            return new Result(false, "部署", steps,
                    "service.d 脚本写入失败（" + svcd + "）", null);
        }
        steps.add("service.d 脚本就位：" + svcd + "/" + SCRIPT_NAME);
        steps.add("已清旧版迁移残留 /data/local/tmp/tempctrl_last_dev（daemon 不再读写）");
        String deployedBinMd5 = nvl(kv.get("BIN_MD5"));
        String deployedScriptMd5 = nvl(kv.get("SCRIPT_MD5"));
        if (!binMd5.equals(deployedBinMd5) || !scriptMd5.equals(deployedScriptMd5)) {
            return new Result(false, "部署", steps,
                    "落盘内容与 APK 内资源不一致（apk=" + binMd5 + "/" + scriptMd5
                            + "，设备=" + deployedBinMd5 + "/" + deployedScriptMd5 + "）",
                    null);
        }
        steps.add("内容哈希核对通过（二进制与脚本均与 APK 内一致）");
        // 设备侧哈希已读回且核对通过：此刻的缓存就是设备上真实内容（供下次启动落页判定）
        rememberDeployedBinMd5(appContext, deployedBinMd5);

        ConfigStore.WriteResult cfg = configStore.writeFactoryIfAbsent();
        steps.add(cfg.describe());
        steps.add(preCreateRuntimeFiles());

        // 省电白名单与部署结果无关（代码自陈"不影响部署"），移出主链：后台 best-effort 补跑，
        // 通道忙/用户在操作就跳过本轮（下次部署或开机脚本补），不再阻塞这次部署的返回。
        submitPowerAllowlistAsync();
        steps.add("省电白名单已移交后台补跑（best-effort，仅对已安装的散热器控制 app 生效）");

        // 盘上确实换了新二进制：清掉拉起冷却，让紧随其后的自动拉起不被「防连点」挡下（否则旧进程继续跑旧映像）。
        // 防连点的语义只对「手动点拉起daemon」成立。见 §2.2。
        lastStartAtMs = 0L;
        // 状态与写盘同会话回吐：不再另起一趟 su 探测（见 §2.1/§8.1 与 buildStatus）。
        // 回吐缺失（脚本被截断等）则退回独立探测一趟 —— 行为等同提速前，不会因缺键误判"不存在"。
        Status st = kv.containsKey("BIN_EXISTS")
                ? buildStatus(kv, true, binMd5, scriptMd5, new ArrayList<>())
                : probe();
        steps.add(st.deployed ? "部署后自检通过"
                : "部署后自检未通过（内容或进程未符合判据）——盘面已就位，仍交由随后的拉起动作换进程");
        // placementsOk 恒真：三条硬判据（BIN_OK / SCRIPT_OK / 双侧哈希一致）都过了；自检未过也照回吐。
        return new Result(st.deployed, true, "部署", steps,
                st.deployed ? "" : "部署后自检未通过（盘面已就位）", st);
    }

    /**
     * 只重推 service.d 脚本：不动二进制、不碰配置，<b>但会重启守护进程</b>（脚本是常驻看门狗，
     * 只换盘上文件不重起，新判别逻辑要等重启手机才生效）。<b>不探测</b>（{@link Result#status} 恒为 null）。
     * <b>阻塞</b>。详见 app/逻辑说明.md §2.2。
     */
    public Result updateScript() {
        List<String> steps = new ArrayList<>();
        File staging = new File(configStore.getPrivateDir(), "deploy");
        if (!staging.isDirectory() && !staging.mkdirs()) {
            return new Result(false, "更新脚本", steps, "私有目录中转目录创建失败：" + staging, null);
        }
        File stagedScript = new File(staging, SCRIPT_NAME);
        String scriptMd5;
        try {
            scriptMd5 = stageAsset(SCRIPT_ASSET, stagedScript, true);
        } catch (IOException e) {
            return new Result(false, "更新脚本", steps, e.getMessage(), null);
        }
        steps.add("脚本已落到私有目录并授权：" + stagedScript + "（md5=" + scriptMd5 + "）");

        RootShell.Result r = shell.exec(updateScriptScript(stagedScript), RESTART_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "更新脚本", steps, "root 执行失败：" + r.describe(), null);
        }
        String svcd = nvl(kv.get("SVCD"));
        if (svcd.isEmpty()) {
            return new Result(false, "更新脚本", steps, "未能确定 service.d 目录", null);
        }
        steps.add("service.d 目录：" + svcd);
        if (!"1".equals(kv.get("SCRIPT_OK"))) {
            return new Result(false, "更新脚本", steps, "脚本写入失败（" + svcd + "）", null);
        }
        String onDevice = nvl(kv.get("SCRIPT_MD5"));
        if (!scriptMd5.equals(onDevice)) {
            return new Result(false, "更新脚本", steps,
                    "落盘脚本与 APK 内资源不一致（apk=" + scriptMd5 + "，设备=" + onDevice + "）",
                    null);
        }
        steps.add("脚本哈希核对通过：" + svcd + "/" + SCRIPT_NAME);
        // 重启那一趟的结果：见方法 javadoc（脚本换了必须连看门狗与守护进程一起换）
        if ("0".equals(kv.get("WD_ALIVE"))) {
            steps.add("1".equals(kv.get("WD_STARTED"))
                    ? "已停旧 sh-watchdog，并由磁盘上的新脚本重新拉起（新脚本自此生效）"
                    : "警告：看门狗脚本不在、且未能重新拉起（需重新部署）");
        }
        steps.add("1".equals(kv.get("STARTED"))
                ? "c-daemon 已重启（PID " + nvl(kv.get("NEW_PID")) + "）"
                : "警告：未探测到新的 c-daemon（它启动前要等亮屏，灭屏时会更晚一些）");
        return new Result(true, "更新脚本", steps, "", null);
    }

    /**
     * 卸载部署：停进程 → 删脚本/二进制/锁/status 双文件 → 删私有目录里的运行时产物。
     * <b>故意不清</b> {@code profile.conf}、省电白名单、{@code tempctrl_last_dev} 的新落点；
     * 它的旧落点残留另由 {@link #deploy()} 部署时主动清，此处卸载兜底再清一次。<b>阻塞</b>。详见 app/逻辑说明.md §2.4。
     */
    public Result uninstall() {
        List<String> steps = new ArrayList<>();
        RootShell.Result r = shell.exec(uninstallScript(), EXEC_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "卸载部署", steps, "root 执行失败：" + r.describe(), null);
        }
        boolean watchdogStopped = "1".equals(kv.get("WATCHDOG_STOPPED"));
        boolean daemonStopped = "1".equals(kv.get("DAEMON_STOPPED"));
        steps.add(watchdogStopped
                ? "已停止 sh-watchdog（先于 c-daemon 杀，否则它会重建日志并把 c-daemon 再拉起来）"
                : "警告：" + KILL_WAIT_LOOPS + " 秒内未能确认 sh-watchdog 已退出（脚本自身的自尽自检会在下一轮兜底）");
        if (daemonStopped) {
            steps.add("已停止运行中的 tempctrl");
        } else {
            steps.add("警告：" + KILL_WAIT_LOOPS + " 秒内未能确认 tempctrl 已退出，锁文件暂不删除（避免绕过单实例锁）");
        }
        steps.add("已删 service.d 脚本（两个候选目录都查了）");
        steps.add("已删 " + BIN_DEST + "（进程已停，可安全 unlink）");
        steps.add("已删 status 双文件（c-daemon 下次启动会重建；仍激活的 MainHook 读到缺失即视为断联）");
        steps.add("已删脚本自身日志 /data/local/tmp/tempctrl_service.log");
        steps.add("已删旧版迁移残留 /data/local/tmp/tempctrl_last_dev"
                + "（新版落点在飞智 app 自己的私有目录，各包各记，本类不碰）");
        steps.add(daemonStopped
                ? "已删兜底单实例锁 /data/local/tmp/tempctrl.lock（c-daemon 已确认停止）"
                : "保留兜底单实例锁 /data/local/tmp/tempctrl.lock（c-daemon 未确认停止，删了会绕过单实例锁）");
        steps.add("已删私有目录不可用时的兜底日志 /cache/tempctrl.log");

        if (daemonStopped && watchdogStopped) {
            List<String> removed = cleanPrivateRuntime();
            steps.add("已清私有目录运行时产物：" + (removed.isEmpty() ? "无" : join(removed, "、")));
            steps.add("保留 " + configStore.getConfigFile().getName() + "（用户配置）");
        } else {
            steps.add("私有目录运行时产物未删（进程可能仍在跑）");
        }

        Status st = probe();
        return new Result(!st.deployed, "卸载部署", steps, "", st);
    }

    // ==================== 拉起（界面手动入口） ====================

    /**
     * 重启守护进程（界面入口）。<b>先停再起</b>：C 端用非阻塞 {@code flock} 做单实例锁，"已在运行"不能当作
     * "无需拉起"。失败自动重试一次；冷却 {@value #START_COOLDOWN_MS} ms 保留（{@link #deploy()} 成功清零）。
     * <b>阻塞</b>。详见 app/逻辑说明.md §2.2。
     */
    public Result startDaemon() {
        List<String> steps = new ArrayList<>();
        // 用户主动动作：复位上一次的失败退避与缓存的 su 命令（与 deploy() 同一语义）
        shell.resetChannel();
        long now = System.currentTimeMillis();
        if (now - lastStartAtMs < START_COOLDOWN_MS) {
            long remain = (START_COOLDOWN_MS - (now - lastStartAtMs)) / 1000;
            steps.add("冷却中，请 " + remain + " 秒后重试");
            return new Result(false, "拉起daemon", steps, "冷却中", null);
        }
        lastStartAtMs = now;

        // 重试已在设备侧同一次 su 会话内做完（restartCore），故这里只跑一趟；
        // 状态由本趟回吐就地构造，不再另起一趟 probe()（见 app/逻辑说明.md §2.2）。
        Attempt a = restartOnce(steps);
        Status st;
        if (!a.suOk) {
            st = null;                       // 通道都没通：没有现状可探（与旧版 probe 失败同效）
        } else if (a.kv.containsKey("BIN_EXISTS")) {
            st = buildStatus(a.kv, true, md5OfAssetOrEmpty(appContext, BIN_ASSET),
                    md5OfAssetOrEmpty(appContext, SCRIPT_ASSET), new ArrayList<>());
        } else {
            st = probe();                    // 回吐缺失：退回独立探测（等同提速前的一次 su 往返）
        }
        return new Result(a.ok, "拉起daemon", steps, a.ok ? "" : a.error, st);
    }

    /** 跑一次完整的「先停再起」，把可读步骤追加进 {@code steps}。不判冷却（由调用方管）。
     *  <b>重试已在设备侧同一次 su 会话内完成</b>（见 {@link #restartCore()}），故调用方只跑一趟。
     *  详见 app/逻辑说明.md §2.2。 */
    private Attempt restartOnce(List<String> steps) {
        RootShell.Result r = shell.exec(restartScript(), RESTART_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Attempt(false, r.isOk(), kv, "root 执行失败：" + r.describe());
        }
        boolean viaWatchdog = "0".equals(kv.get("WD_ALIVE"));
        String oldPid = nvl(kv.get("OLD_PID"));
        if (viaWatchdog) {
            if (!"1".equals(kv.get("WD_STARTED"))) {
                steps.add("sh-watchdog 不在，且 service.d 脚本缺失（两个候选目录都没找到）");
                return new Attempt(false, true, kv, "看门狗脚本不存在（需先重新部署）");
            }
            steps.add("sh-watchdog 不在（如刚点过「停止daemon」），已重新拉起，由它停旧起新");
        } else if (!"1".equals(kv.get("OLD_STOPPED"))) {
            steps.add("检测到 c-daemon 在运行（PID " + oldPid + "），先停止它");
            steps.add(KILL_WAIT_LOOPS + " 秒内未退出，kill -9 后仍未退出");
            return new Attempt(false, true, kv,
                    "旧实例未退出，已放弃启动（否则新实例抢单实例锁必然失败）");
        } else if ("1".equals(kv.get("NOBIN"))) {
            steps.add(oldPid.isEmpty() ? "未检测到运行中的 c-daemon" : "已停止旧实例（PID " + oldPid + "）");
            return new Attempt(false, true, kv, "二进制不存在（需先部署）：" + BIN_DEST);
        } else {
            steps.add(oldPid.isEmpty() ? "未检测到运行中的 c-daemon，直接启动"
                    : "已停止旧实例（PID " + oldPid + "）");
            if ("1".equals(kv.get("OLD_KILLED"))) {
                steps.add("旧实例未响应 kill（SIGTERM），已用 kill -9 结束");
            }
        }
        if (!"1".equals(kv.get("STARTED"))) {
            steps.add(viaWatchdog
                    ? "看门狗已拉起，但尚未探测到 daemon（它启动前要等亮屏，灭屏时会等到亮屏才起）"
                    : "启动命令已执行，但未探测到新进程（未起或起后立即退出；设备侧已重试过一次）");
            return new Attempt(false, true, kv, "未启动");
        }
        steps.add((viaWatchdog ? "已由看门狗启动 tempctrl（PID " : "已拉起新实例（PID ")
                + nvl(kv.get("NEW_PID")) + "，已 renice -20）");
        steps.add("温控空窗约 0~" + (KILL_WAIT_LOOPS + KILL9_WAIT_LOOPS)
                + " 秒（只等旧实例退出；C 端无启动延时）");
        return new Attempt(true, true, kv, "");
    }

    /** 一次拉起尝试的结果：{@code ok}=新实例已起来；{@code kv}=该趟 su 回吐（用于就地构造 {@link Status}）。 */
    private static final class Attempt {
        final boolean ok;
        /** 该趟 su 是否正常返回（供 {@link #buildStatus} 的 {@code suOk}；只读，不影响 {@link #ok}）。 */
        final boolean suOk;
        final Map<String, String> kv;
        final String error;

        Attempt(boolean ok, boolean suOk, Map<String, String> kv, String error) {
            this.ok = ok;
            this.suOk = suOk;
            this.kv = kv;
            this.error = error;
        }
    }

    /**
     * 停止守护进程（界面入口）：<b>先停看门狗 shell、再停 daemon</b>，只杀进程、不删任何文件
     * （看门狗会每 {@code RESTART_INTERVAL} 秒把 daemon 拉回，故必须连它一起停）。
     * 与 {@link #uninstall()} 共用停止片段、区别是这里什么都不删。<b>阻塞</b>。详见 app/逻辑说明.md §2.2。
     */
    public Result stopDaemon() {
        List<String> steps = new ArrayList<>();
        RootShell.Result r = shell.exec(stopDaemonScript(), EXEC_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "停止daemon", steps, "root 执行失败：" + r.describe(), null);
        }
        boolean watchdogStopped = "1".equals(kv.get("WATCHDOG_STOPPED"));
        boolean daemonStopped = "1".equals(kv.get("DAEMON_STOPPED"));
        String wdPid = nvl(kv.get("WATCHDOG_PID"));
        String daemonPid = nvl(kv.get("DAEMON_PID"));
        steps.add(watchdogStopped
                ? (wdPid.isEmpty() ? "未检测到运行中的 sh-watchdog"
                        : "已停止 sh-watchdog（PID " + wdPid + "；先停它，否则它会把 c-daemon 拉回来）")
                : "警告：" + KILL_WAIT_LOOPS + " 秒内未能确认 sh-watchdog 已退出");
        steps.add(daemonStopped
                ? (daemonPid.isEmpty() ? "未检测到运行中的 tempctrl"
                        : "已停止运行中的 tempctrl（PID " + daemonPid + "）")
                : "警告：" + KILL_WAIT_LOOPS + " 秒内未能确认 tempctrl 已退出");
        boolean ok = watchdogStopped && daemonStopped;
        return new Result(ok, "停止daemon", steps, ok ? "" : "有进程未确认退出，见步骤", probe());
    }

    /** 诊断串：部署状态 + 配置状态 + root 诊断。阻塞。部署段与状态区同一份文本（describe）。 */
    public String buildDiagnostics() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== 部署 ===\n").append(probe().describe()).append('\n');
        sb.append("=== 配置 ===\n").append(configStore.describeState()).append('\n');
        sb.append("=== root ===\n").append(shell.buildDiagnostics());
        return sb.toString();
    }

    // ==================== 内部：资源落盘 ====================

    /**
     * 把 APK 内资源落到私有目录并授权（照 Scene 的做法：Framework File API +
     * {@code setExecutable(true,false)} 沿父目录链逐级向上，不调外部 chmod）。
     *
     * @return 落盘内容的 md5（十六进制小写）
     */
    private String stageAsset(String assetPath, File dest, boolean executable) throws IOException {
        MessageDigest digest = newDigest();
        InputStream in = null;
        FileOutputStream out = null;
        try {
            in = appContext.getAssets().open(assetPath);
            out = new FileOutputStream(dest, false);
            byte[] buf = new byte[64 * 1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
                digest.update(buf, 0, n);
            }
            out.flush();
            out.getFD().sync();
        } catch (IOException e) {
            throw new IOException("资源 " + assetPath + " 落盘失败：" + e.getMessage());
        } finally {
            closeQuietly(in);
            closeQuietly(out);
        }
        if (executable) {
            ensureExecutableUpTo(dest, configStore.getPrivateDir());
        }
        return toHex(digest.digest());
    }

    /** 只有 {@code setExecutable} 够：逐级向父目录链授权，否则中间目录缺 x 位仍执行不了。 */
    private static void ensureExecutableUpTo(File file, File stopAt) {
        File cur = file;
        while (cur != null) {
            cur.setExecutable(true, false);
            if (cur.equals(stopAt)) {
                return;
            }
            cur = cur.getParentFile();
        }
    }

    private String md5OfAsset(String assetPath) throws IOException {
        return md5OfAsset(appContext, assetPath);
    }

    /**
     * {@link #md5OfAsset(String)} 的静态入口：{@link #needsRedeploy} 无实例也须能算期望哈希。
     *
     * <p>带 {@link #ASSET_MD5_MEMO}：命中就直接回吐。失败不缓存（异常原样往外传），调用方
     * 该退化的退化（{@link #md5OfAssetOrEmpty}）。
     */
    private static String md5OfAsset(Context appContext, String assetPath) throws IOException {
        String memoized = ASSET_MD5_MEMO.get(assetPath);
        if (memoized != null) {
            return memoized;
        }
        String md5 = computeAssetMd5(appContext, assetPath);
        ASSET_MD5_MEMO.put(assetPath, md5);
        return md5;
    }

    /** 真正读 asset 并哈希（不带 memo，故失败照旧抛 IOException）。 */
    private static String computeAssetMd5(Context appContext, String assetPath) throws IOException {
        MessageDigest digest = newDigest();
        InputStream in = null;
        try {
            in = appContext.getAssets().open(assetPath);
            byte[] buf = new byte[64 * 1024];
            int n;
            while ((n = in.read(buf)) > 0) {
                digest.update(buf, 0, n);
            }
        } catch (IOException e) {
            throw new IOException("APK 内未找到 " + assetPath
                    + "（二进制由 CI 注入，本地构建不会有）", e);
        } finally {
            closeQuietly(in);
        }
        return toHex(digest.digest());
    }

    /** 期望哈希的"取不到就当没有"形态：缺失/读失败一律空串（判定方据此退化）。 */
    private static String md5OfAssetOrEmpty(Context appContext, String assetPath) {
        try {
            return md5OfAsset(appContext, assetPath);
        } catch (IOException e) {
            return "";
        }
    }

    /**
     * <b>防御性预创建</b>私有目录里的运行时文件（{@code tempctrl.log} / {@code tempctrl_webui.data} /
     * {@code tempctrl_coldmax}）。<b>标注：防御性、未经真机验证</b>（SELinux 标签假设）。只在不存在时创建；
     * 失败不阻断部署。刻意不用 {@link RootShell}。详见 app/逻辑说明.md §2.5、§10。
     */
    private String preCreateRuntimeFiles() {
        List<String> created = new ArrayList<>();
        List<String> kept = new ArrayList<>();
        List<String> failed = new ArrayList<>();
        for (String name : new String[]{"tempctrl.log", "tempctrl_webui.data", "tempctrl_coldmax"}) {
            File f = new File(configStore.getPrivateDir(), name);
            if (f.exists()) {
                kept.add(name);
                continue;
            }
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(f, true);
                fos.flush();
                created.add(name);
            } catch (IOException e) {
                failed.add(name + "（" + e.getMessage() + "）");
            } finally {
                closeQuietly(fos);
            }
        }
        StringBuilder sb = new StringBuilder("运行时文件预创建（防御性，未经真机验证）：");
        sb.append(created.isEmpty() ? "新建 0 个" : "新建 " + join(created, "、"));
        if (!kept.isEmpty()) {
            sb.append("；已存在未动 ").append(join(kept, "、"));
        }
        if (!failed.isEmpty()) {
            sb.append("；失败（不影响部署）").append(join(failed, "、"));
        }
        return sb.toString();
    }

    /**
     * 刷新「同步清单」—— service.d 脚本找不到解压工具时的降级来源（一份 {@code KEY=VALUE}，
     * 见 §2.5；时间戳是保鲜期）。只在 APK 换了才做。<b>阻塞</b>，只在后台线程调；失败记在返回值里。
     * 详见 app/逻辑说明.md §2.5。
     *
     * @return 需要上屏的失败说明；无需刷新或刷新成功时返回 null
     */
    public String writeSyncManifestIfNeeded() {
        long apkMtimeSec = apkFileMtimeSec();
        if (apkMtimeSec <= 0L) {
            // 取不到 APK 文件时间戳：无从判定清单是否过期，也就不写（脚本侧会退化为"不动作"）
            return null;
        }
        // APK 内资源不完整（本地构建没有 CI 注入的 asset）：probe() 已有提示行，此处静默跳过
        if (md5OfAssetOrEmpty(appContext, BIN_ASSET).isEmpty()
                || md5OfAssetOrEmpty(appContext, SCRIPT_ASSET).isEmpty()) {
            return null;
        }
        File manifest = new File(configStore.getPrivateDir(), MANIFEST_NAME);
        if (Long.toString(apkMtimeSec).equals(readManifestValue(manifest, MANIFEST_KEY_APK_MTIME))) {
            return null;   // APK 没换：清单还是新鲜的，一个字都不用动
        }
        File staging = new File(configStore.getPrivateDir(), "deploy");
        if (!staging.isDirectory() && !staging.mkdirs()) {
            return "同步清单未刷新：中转目录创建失败 " + staging;
        }
        File stagedBin = new File(staging, "tempctrl");
        File stagedScript = new File(staging, SCRIPT_NAME);
        try {
            String binMd5 = stageAsset(BIN_ASSET, stagedBin, true);
            String scriptMd5 = stageAsset(SCRIPT_ASSET, stagedScript, true);
            writeManifest(manifest, apkMtimeSec, binMd5, scriptMd5, stagedBin, stagedScript);
            return null;   // 静默：状态区不该因为一次清单刷新多出一行
        } catch (IOException e) {
            return "同步清单未刷新：" + e.getMessage();
        }
    }

    /** APK 自身文件的 mtime（秒）；与脚本侧 {@code stat -c %Y} 同口径，取不到返回 0。 */
    private long apkFileMtimeSec() {
        try {
            // getPackageCodePath() 就是 `pm path` 回吐的那份 base.apk —— 脚本侧 stat 的是同一个文件
            return new File(appContext.getPackageCodePath()).lastModified() / 1000L;
        } catch (RuntimeException e) {
            return 0L;   // 取不到（异常/文件不在）→ 调用方按"不写清单"退化
        }
    }

    /** 原子写清单（{@code .tmp} + rename，与 daemon 写 uiprefs 同一口径）：读到半截比读不到更坏。 */
    private static void writeManifest(File manifest, long apkMtimeSec, String binMd5, String scriptMd5,
                                      File bin, File script) throws IOException {
        File tmp = new File(manifest.getAbsolutePath() + ".tmp");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(tmp, false);
            out.write((MANIFEST_KEY_APK_MTIME + "=" + apkMtimeSec + "\n"
                    + "BIN_MD5=" + binMd5 + "\n"
                    + "SCRIPT_MD5=" + scriptMd5 + "\n"
                    + "BIN_SRC=" + bin.getAbsolutePath() + "\n"
                    + "SCRIPT_SRC=" + script.getAbsolutePath() + "\n")
                    .getBytes(StandardCharsets.UTF_8));
            out.flush();
            out.getFD().sync();
        } finally {
            closeQuietly(out);
        }
        if (!tmp.renameTo(manifest)) {
            tmp.delete();
            throw new IOException("同步清单改名失败：" + tmp);
        }
    }

    /** 读清单里某个键；读不到（文件不在/读失败/没这个键）一律空串。解析复用 {@link #parseKv}。 */
    private static String readManifestValue(File manifest, String key) {
        if (!manifest.isFile()) {
            return "";
        }
        InputStream in = null;
        try {
            long len = Math.min(manifest.length(), 64L * 1024L);
            byte[] raw = new byte[(int) len];
            in = new FileInputStream(manifest);
            int n = in.read(raw);
            if (n <= 0) {
                return "";
            }
            String value = parseKv(new String(raw, 0, n, StandardCharsets.UTF_8)).get(key);
            return value == null ? "" : value;
        } catch (IOException e) {
            return "";
        } finally {
            closeQuietly(in);
        }
    }

    /**
     * 删私有目录里的运行时产物（{@code profile.conf} 不在列，属用户配置）。清单/时间戳/看门狗标记也在列
     * （否则脚本会认为"本机部署过"、下次开机把卸载掉的重装回来）。详见 app/逻辑说明.md §2.5。
     */
    private List<String> cleanPrivateRuntime() {
        List<String> removed = new ArrayList<>();
        String[] names = {"tempctrl.lock", "tempctrl.log", "tempctrl_webui.data",
                MANIFEST_NAME, "tempctrl_deploy_stamp", "tempctrl_wd_spawn"};
        for (String name : names) {
            File f = new File(configStore.getPrivateDir(), name);
            if (f.exists() && f.delete()) {
                removed.add(name);
            }
        }
        File staging = new File(configStore.getPrivateDir(), "deploy");
        File[] children = staging.listFiles();
        if (children != null) {
            for (File c : children) {
                c.delete();
            }
        }
        if (staging.isDirectory() && staging.delete()) {
            removed.add("deploy/（中转副本）");
        }
        return removed;
    }

    // ==================== 内部：shell 片段 ====================

    /**
     * 两个「按 pid 找目标进程」的 shell 函数（设备端 su shell、toybox 环境）：{@code bin_pids()}（二进制实例）
     * 与 {@code wd_pids()}（看门狗 shell）。<b>身份判据只此一处</b>，{@link #killAndWaitSnippet} 与
     * {@code restartCore()} 共用；与 C 侧 {@code cmdline_has_script_arg()}、脚本 {@code running()} 同口径
     * （对 {@code (deleted)} 都算"在跑"）。详见 app/逻辑说明.md §2.3。
     */
    private static String pidsPreamble() {
        return "BIN=" + BIN_DEST + "\n"
                // 二进制实例＝/proc/<pid>/exe 末端锚定 $BIN（不命中 tempctrl_service.log 等兄弟文件）；
                // 末尾允许 " (deleted)"：部署用 mv 原子替换 $BIN，旧实例的 exe 随即显示成删除态、
                // 却仍持单实例锁，必须仍算"在跑"。见 §2.3
                + "bin_pids() {\n"
                + "    ls -l /proc/[0-9]*/exe 2>/dev/null"
                + " | grep -E -- \"-> $BIN( [(]deleted[)])?$\""
                + " | sed -n \"s#.* /proc/\\([0-9]*\\)/exe ->.*#\\1#p\"\n"
                + "}\n"
                // 看门狗 shell 的 exe 都是 /system/bin/sh，身份只由「某参数恰好等于候选脚本路径」定
                // （整行相等、非子串；binary 语义不依赖 grep）。见 §2.3
                + "wd_match() {\n"
                + "    a=$(tr '\\000' '\\n' < \"/proc/$1/cmdline\" 2>/dev/null)\n"
                + "    case \"$a\" in *" + SCRIPT_NAME + "*) ;; *) return 1 ;; esac\n"
                + "    printf '%s\\n' \"$a\" | grep -qx -- \"" + SERVICE_D_MODERN + "/" + SCRIPT_NAME + "\""
                + " || printf '%s\\n' \"$a\" | grep -qx -- \""
                + SERVICE_D_KSU_LEGACY + "/" + SCRIPT_NAME + "\"\n"
                + "}\n"
                // 先用 comm 白名单快筛（省 fork），一个不命中再全量兜底。见 §2.3
                + "wd_pids() {\n"
                + "    _wd_hit=0\n"
                + "    for c in $(grep -l -E '^(" + WD_COMM_WHITELIST + ")$' /proc/[0-9]*/comm 2>/dev/null); do\n"
                + "        p=${c#/proc/}; p=${p%/comm}\n"
                + "        if wd_match \"$p\"; then echo \"$p\"; _wd_hit=1; fi\n"
                + "    done\n"
                + "    [ \"$_wd_hit\" = 1 ] && return 0\n"
                // 全量兜底：一次 grep 扫全部 cmdline（原来逐 pid fork 一次 tr，真机数百~上千次，会把探测预算吃光）。
                // 命中候选再逐个 wd_match 精确确认；head -50 给候选数封顶，避免异常环境下无界。
                + "    for c in $(grep -l -- \"" + SCRIPT_NAME + "\" /proc/[0-9]*/cmdline 2>/dev/null | head -50); do\n"
                + "        p=${c#/proc/}; p=${p%/cmdline}\n"
                + "        wd_match \"$p\" && echo \"$p\"\n"
                + "    done\n"
                + "}\n";
    }

    private String probeScript() {
        return pidsPreamble() + probeTail();
    }

    /**
     * 探测的状态回吐段（<b>不含</b> {@link #pidsPreamble()}）：存在性 / 可执行 / md5 工具 / 二进制与脚本 md5 /
     * c-daemon 与看门狗 PID。与 {@link #probe()} 共用；部署趟与拉起趟也把它接在末尾——
     * "写完盘顺便报状态"，省掉一场独立的 su 往返（见 app/逻辑说明.md §2.1、§8.1）。
     */
    private static String probeTail() {
        return "[ -e \"$BIN\" ] && echo BIN_EXISTS=1 || echo BIN_EXISTS=0\n"
                + "[ -x \"$BIN\" ] && echo BIN_EXEC=1 || echo BIN_EXEC=0\n"
                + "if command -v md5sum > /dev/null 2>&1; then echo MD5TOOL=1; else echo MD5TOOL=0; fi\n"
                + "echo \"BIN_MD5=$(md5sum \"$BIN\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + "for d in " + SERVICE_D_KSU_LEGACY + " " + SERVICE_D_MODERN + "; do\n"
                + "  f=\"$d/" + SCRIPT_NAME + "\"\n"
                + "  if [ -f \"$f\" ]; then echo \"SCRIPT=$f\"; echo \"SCRIPT_MD5=$(md5sum \"$f\" 2>/dev/null | cut -d' ' -f1)\"; fi\n"
                + "done\n"
                // c-daemon 的 pid 列表只取一次：既出 RUNNING 也出 PID（不为第二件事再扫一趟 /proc）
                + "BIN_LIST=$(bin_pids)\n"
                + "[ -n \"$BIN_LIST\" ] && echo RUNNING=1 || echo RUNNING=0\n"
                + "set -- $BIN_LIST\n"
                + "echo \"DAEMON_PIDS=$*\"\n"
                // 看门狗同样上屏（不输出它，「停机时它仍在跑」「两个并存」在界面上完全不可观测）。
                // 先落到变量再一次取用：wd_pids 要扫全部 pid，不能为了计数再跑一次。
                // set -- 借位置参数数个数、$* 折成一行，省掉 wc/tr 各一次 fork。
                + "WD_LIST=$(wd_pids)\n"
                + "set -- $WD_LIST\n"
                + "echo \"WD_COUNT=$#\"\n"
                + "echo \"WD_PIDS=$*\"\n";
    }

    /**
     * 定位 service.d 目录的 shell 片段（含 KernelSU 新旧版本分界判定）。
     * 由 {@link #deployScript} 与 {@link #updateScriptScript} 共用，保证两处选目录的口径一致。
     */
    private static String serviceDirPreamble() {
        return "svcd=\"\"\n"
                + "ver=\"\"\n"
                + "if [ -d /data/adb/ksu ]; then\n"
                + "  ksud=$(command -v ksud 2>/dev/null || echo /data/adb/ksu/bin/ksud)\n"
                + "  ver=$(\"$ksud\" -V 2>/dev/null | sed -n 's/.*[^0-9]\\([0-9][0-9][0-9][0-9][0-9][0-9]*\\).*/\\1/p' | tail -1)\n"
                + "  if [ -n \"$ver\" ] && [ \"$ver\" -lt " + KSU_MODERN_VER_CODE + " ] 2>/dev/null; then svcd="
                + SERVICE_D_KSU_LEGACY + "; fi\n"
                + "fi\n"
                + "[ -n \"$svcd\" ] || svcd=" + SERVICE_D_MODERN + "\n"
                + "echo \"SVCD=$svcd\"\n"
                + "echo \"KSU_VER=$ver\"\n";
    }

    /** 把脚本装到 $svcd 并回吐 SCRIPT_OK（部署与单独更新脚本共用）。<b>先落 {@code .new} 再 {@code mv}</b>：
     *  脚本自己是常驻看门狗，覆写它在读的文件会读到半截；mv 换目录项，正在跑的 shell 继续持旧 inode。
     *  详见 app/逻辑说明.md §2.2。 */
    private static String scriptInstallSnippet(File stagedScript) {
        return "cp -f " + quote(stagedScript.getAbsolutePath()) + " \"$svcd/" + SCRIPT_NAME + ".new\" "
                + "&& chmod 0755 \"$svcd/" + SCRIPT_NAME + ".new\" "
                + "&& mv -f \"$svcd/" + SCRIPT_NAME + ".new\" \"$svcd/" + SCRIPT_NAME + "\" "
                + "&& echo SCRIPT_OK=1 || echo SCRIPT_OK=0\n"
                + "rm -f \"$svcd/" + SCRIPT_NAME + ".new\" 2>/dev/null\n";
    }

    /** 只重推脚本时的 shell（完全不碰 $BIN）。先停看门狗 shell，再由 {@link #restartCore()} 用磁盘上的
     *  新脚本把它拉起来。详见 app/逻辑说明.md §2.2。 */
    private String updateScriptScript(File stagedScript) {
        return pidsPreamble()
                + serviceDirPreamble()
                + "mkdir -p \"$svcd\" 2>&1\n"
                + scriptInstallSnippet(stagedScript)
                + "echo \"SCRIPT_MD5=$(md5sum \"$svcd/" + SCRIPT_NAME + "\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + killAndWaitSnippet("wd_pids", "WATCHDOG")
                + restartCore();
    }

    private String deployScript(File stagedBin, File stagedScript) {
        return pidsPreamble()
                + serviceDirPreamble()
                + "mkdir -p \"$svcd\" 2>&1\n"
                // 旧版迁移残留（daemon 侧预创建已删、无人读写）：部署顺手清掉，免得只在卸载时才清
                + "rm -f /data/local/tmp/tempctrl_last_dev\n"
                // 原子替换：先写 $BIN.new 再 mv。既避开"覆写正在运行的二进制 ETXTBSY"，也避开
                // "先删后落"被打断留下"二进制不存在"的半成品；在跑的旧进程继续持旧 inode 跑完自己那一轮。
                + "cp -f " + quote(stagedBin.getAbsolutePath()) + " \"$BIN.new\" && chmod 0755 \"$BIN.new\" "
                + "&& mv -f \"$BIN.new\" \"$BIN\" && echo BIN_OK=1 || echo BIN_OK=0\n"
                + "rm -f \"$BIN.new\" 2>/dev/null\n"
                + scriptInstallSnippet(stagedScript)
                // 末尾接探测尾段：md5 与运行状态随本趟一起回吐，不再另起一趟 su 探测
                + probeTail();
    }

    /**
     * 把省电白名单移到后台 best-effort 补跑：它自陈"不影响部署"，却要跑 3 个包 × 数条 am/appops，
     * 系统繁忙时可能挂住并拖满一整趟 su 上限。改用 {@link RootShell#tryExec} —— 拿不到通道就跳过本轮
     * （下次部署时补），既不阻塞部署返回，也不会在"部署刚返回、界面紧接着拉起 daemon"的空档里抢锁。
     */
    private void submitPowerAllowlistAsync() {
        Thread t = new Thread(() -> {
            try {
                shell.tryExec(powerAllowlistScript(), ALLOWLIST_TIMEOUT_MS);
            } catch (RuntimeException ignored) {
                // best-effort：失败不影响任何部署结果，也不上屏
            }
        }, "ww-power-allowlist");
        t.setDaemon(true);
        t.start();
    }

    /** 省电白名单批处理：<b>逐包</b>下发给已安装的散热器控制 app（包名取自 {@code R.array.xposed_scope}），
     *  四段命令共处同一个 su 会话；未安装的包跳过（判据 {@code [ -d /data/data/$PKG ]}）。
     *  可能挂住的命令用 {@code toybox timeout} 包一层（拿不到 toybox 则前缀为空，等同现状）。
     *  该整段已移出部署主链，见 {@link #submitPowerAllowlistAsync()}。详见 app/逻辑说明.md §2.5。 */
    private String powerAllowlistScript() {
        StringBuilder sb = new StringBuilder();
        sb.append("TOOL_TW=\"\"\n")
                .append("command -v toybox > /dev/null 2>&1 && TOOL_TW=\"toybox timeout 5\"\n");
        for (String pkg : appContext.getResources().getStringArray(R.array.xposed_scope)) {
            // 每包一段 if：$PKG 逐段重设，四段仍在同一个脚本里跑完（不拆成多次 su exec）
            sb.append("PKG=").append(pkg).append('\n')
                    .append("if [ -d \"/data/data/$PKG\" ]; then\n")
                    .append("  echo \"-- $PKG --\"\n")
                    .append("  echo \"-- deviceidle --\"; $TOOL_TW dumpsys deviceidle whitelist +$PKG 2>&1\n")
                    .append("  echo \"-- appops --\"; $TOOL_TW appops set $PKG RUN_IN_BACKGROUND allow 2>&1\n")
                    .append("  echo \"-- standby --\"; $TOOL_TW am set-standby-bucket $PKG active 2>&1\n")
                    .append("  echo \"-- unfreeze --\"; $TOOL_TW am unfreeze --sticky $PKG 2>&1 || $TOOL_TW am unfreeze $PKG 2>&1\n")
                    .append("fi\n");
        }
        return sb.toString();
    }

    private String uninstallScript() {
        // 停止序列与 stopDaemonScript() 同源（同一个片段），差别只在后面这堆 rm。
        return pidsPreamble()
                + killAndWaitSnippet("wd_pids", "WATCHDOG")
                + killAndWaitSnippet("bin_pids", "DAEMON")
                // 3) 两个进程都停稳后再删文件
                + "rm -f " + SERVICE_D_MODERN + "/" + SCRIPT_NAME + "\n"
                + "rm -f " + SERVICE_D_KSU_LEGACY + "/" + SCRIPT_NAME + "\n"
                + "rm -f \"$BIN\"\n"
                + "# 兜底单实例锁（C 端在私有目录不可用时用的那把，LOCK_FALLBACK_PATH）：只在 c-daemon 确认\n"
                + "# 已停之后删 —— 它若还在跑就握着这把锁，删掉文件会让新实例锁到新的 inode、单实例保护被绕过。\n"
                + "if [ \"$DAEMON_STOPPED\" = 1 ]; then rm -f /data/local/tmp/tempctrl.lock; fi\n"
                + "rm -f /data/local/tmp/tempctrl_b6x.status\n"
                + "rm -f /data/local/tmp/tempctrl_b7x.status\n"
                + "# c-daemon 转写给钩子的界面开关快照（钩子每次返回键读一次；删掉后钩子回退默认值）\n"
                + "rm -f /data/local/tmp/tempctrl_uiprefs\n"
                + "rm -f /data/local/tmp/tempctrl_service.log\n"
                + "# 旧版迁移残留 tempctrl_last_dev（daemon 侧预创建已删、无人读写）：顺手清掉。见 app/逻辑说明.md §2.4\n"
                + "rm -f /data/local/tmp/tempctrl_last_dev\n"
                + "# 私有目录不可用时 c-daemon 的兜底日志落点（/cache/<二进制名>.log），可能残留\n"
                + "rm -f /cache/tempctrl.log\n";
    }

    /**
     * 「先停再起」的完整 shell = {@code BIN=} + 目录定位 + {@link #restartCore()}。
     * <b>末尾不含 {@code exit}</b>：{@link RootShell#exec} 靠末尾结束标记回传退出码，脚本自退会让标记丢失、
     * 判通道失败。详见 app/逻辑说明.md §4.1。
     */
    private String restartScript() {
        return pidsPreamble() + serviceDirPreamble() + restartCore() + probeTail();
    }

    /**
     * 「先停再起」的核心片段（调用方负责备好 {@code BIN=} 与 {@code $svcd}），按看门狗在不在分两条路：
     * 看门狗在（常态）→ 只停/起 {@code $BIN}；看门狗不在 → 先拉起 service.d 脚本、由它把 daemon 带回来
     * （脚本不再先杀 daemon，见 C 侧「看门狗反向保活」）。详见 app/逻辑说明.md §2.2。
     */
    private static String restartCore() {
        return "WD=\"$svcd/" + SCRIPT_NAME + "\"\n"
                // 1) 看门狗在不在：用 wd_pids（见 pidsPreamble）
                + "[ -n \"$(wd_pids)\" ] && WD_ALIVE=1 || WD_ALIVE=0\n"
                + "echo \"WD_ALIVE=$WD_ALIVE\"\n"
                // 2) 两条路都要先把在跑的旧实例停稳（flock 的持有者必须先消失）
                + killAndWaitSnippet("bin_pids", "OLD")
                // 3) 看门狗不在就拉起它、由它停旧起新；在就自己起
                + "if [ \"$WD_ALIVE\" = \"0\" ]; then\n"
                + "  if [ -f \"$WD\" ]; then\n"
                + "    nohup sh \"$WD\" > /dev/null 2>&1 < /dev/null &\n"
                + "    echo WD_STARTED=1\n"
                + "  else\n"
                + "    echo WD_STARTED=0\n"
                + "  fi\n"
                + "  i=0\n"
                + "  while [ $i -lt " + KILL_WAIT_LOOPS + " ]; do\n"
                + "    [ -n \"$(bin_pids)\" ] && break\n"
                + "    sleep 1\n"
                + "    i=$((i + 1))\n"
                + "  done\n"
                + "  NEW_PID=$(bin_pids | head -1)\n"
                + "elif [ \"$OLD_STOPPED\" != \"1\" ]; then\n"
                // 旧实例没停稳就不启动：抢 flock 必失败，还要白等一次启动延时
                + "  NEW_PID=\"\"\n"
                + "elif [ ! -x \"$BIN\" ]; then\n"
                + "  echo NOBIN=1\n"
                + "  NEW_PID=\"\"\n"
                + "else\n"
                // 设备侧重试：起一次没等到就再起一次（原先是 app 侧整趟重来才做到 —— 多一趟 su + 多等 2s）。
                // 每轮先 sleep 2 再查 bin_pids；若第一轮其实起了只是慢，第二轮会因单实例锁立刻退出、不影响结果。
                + "  attempt=0\n"
                + "  NEW_PID=\"\"\n"
                + "  while [ $attempt -lt 2 ]; do\n"
                + "    attempt=$((attempt + 1))\n"
                + "    nohup \"$BIN\" >> /data/local/tmp/tempctrl_service.log 2>&1 < /dev/null &\n"
                + "    sleep 2\n"
                + "    NEW_PID=$(bin_pids | head -1)\n"
                + "    [ -n \"$NEW_PID\" ] && break\n"
                + "  done\n"
                + "fi\n"
                + "if [ -n \"$NEW_PID\" ]; then renice -n -20 -p \"$NEW_PID\" > /dev/null 2>&1; fi\n"
                // 4) 新 PID 必须与旧的不同，否则只是"读到了同一个残留进程"
                + "if [ -n \"$NEW_PID\" ] && [ \"$NEW_PID\" = \"$OLD_PID\" ]; then NEW_PID=\"\"; fi\n"
                + "if [ -n \"$NEW_PID\" ]; then echo STARTED=1; else echo STARTED=0; fi\n"
                + "echo \"NEW_PID=$NEW_PID\"\n";
    }

    /**
     * 停止的 shell：先杀看门狗 shell、再杀 daemon，各自「kill → 等 → kill -9 → 等」。
     * 只杀进程、<b>不删任何文件</b>（{@link #uninstallScript()} 用同一段片段，停稳之后才删）。
     */
    private String stopDaemonScript() {
        return pidsPreamble()
                // 先杀看门狗 shell：它的可执行映像就是 /system/bin/sh（与一切 shell 共享），故不能按
                // $BIN 找，用 wd_pids（某个参数恰好等于候选脚本路径，见 pidsPreamble）。
                // 不先杀它，它下一轮 tick 就会把刚停掉的守护进程再拉起来，「停止」不成立。
                + killAndWaitSnippet("wd_pids", "WATCHDOG")
                + killAndWaitSnippet("bin_pids", "DAEMON");
    }

    /**
     * 「按 pid 停进程 + 轮询等它真退出」的 shell 片段——<b>停止序列的唯一出处</b>：
     * {@code kill}(SIGTERM) → 轮询 ≤{@value #KILL_WAIT_LOOPS} 秒 → {@code kill -9} → 再轮询 ≤{@value #KILL9_WAIT_LOOPS} 秒。
     * 目标 pid 由 {@code pidSource}（{@code bin_pids}/{@code wd_pids}）提供；<b>不再用 {@code pkill -f}</b>。
     * 详见 app/逻辑说明.md §2.2。
     *
     * @param pidSource 打印目标 pid（每行一个）的 shell 函数名，调用方传字面量
     * @param tag       回吐键前缀，必须是合法的 shell 变量名片段（调用方传字面量）
     */
    private static String killAndWaitSnippet(String pidSource, String tag) {
        return tag + "_PIDS=$(" + pidSource + ")\n"
                + tag + "_PID=$(printf '%s\\n' \"$" + tag + "_PIDS\" | head -1)\n"
                + tag + "_STOPPED=1\n"
                + tag + "_KILLED=0\n"
                + "if [ -n \"$" + tag + "_PIDS\" ]; then\n"
                + "  for p in $" + tag + "_PIDS; do kill $p 2>/dev/null; done\n"
                + "  i=0\n"
                + "  while [ $i -lt " + KILL_WAIT_LOOPS + " ]; do\n"
                + "    " + tag + "_PIDS=$(" + pidSource + ")\n"
                + "    [ -z \"$" + tag + "_PIDS\" ] && break\n"
                + "    for p in $" + tag + "_PIDS; do kill $p 2>/dev/null; done\n"
                + "    sleep 1\n"
                + "    i=$((i + 1))\n"
                + "  done\n"
                + "  " + tag + "_PIDS=$(" + pidSource + ")\n"
                + "  if [ -n \"$" + tag + "_PIDS\" ]; then\n"
                + "    " + tag + "_KILLED=1\n"
                + "    for p in $" + tag + "_PIDS; do kill -9 $p 2>/dev/null; done\n"
                + "    i=0\n"
                + "    while [ $i -lt " + KILL9_WAIT_LOOPS + " ]; do\n"
                + "      " + tag + "_PIDS=$(" + pidSource + ")\n"
                + "      [ -z \"$" + tag + "_PIDS\" ] && break\n"
                + "      for p in $" + tag + "_PIDS; do kill -9 $p 2>/dev/null; done\n"
                + "      sleep 1\n"
                + "      i=$((i + 1))\n"
                + "    done\n"
                + "    if [ -n \"$(" + pidSource + ")\" ]; then " + tag + "_STOPPED=0; fi\n"
                + "  fi\n"
                + "fi\n"
                + "echo \"" + tag + "_PID=$" + tag + "_PID\"\n"
                + "echo \"" + tag + "_STOPPED=$" + tag + "_STOPPED\"\n"
                + "echo \"" + tag + "_KILLED=$" + tag + "_KILLED\"\n";
    }

    // ==================== 内部：小工具 ====================

    /** 解析 root 侧 {@code KEY=VALUE} 协议输出（只取每行第一个 '='）。 */
    private static Map<String, String> parseKv(String stdout) {
        Map<String, String> map = new LinkedHashMap<>();
        if (stdout == null) {
            return map;
        }
        for (String line : stdout.split("\n")) {
            String s = line.trim();
            int eq = s.indexOf('=');
            if (eq <= 0) {
                continue;
            }
            String key = s.substring(0, eq).trim();
            if (key.isEmpty() || key.indexOf(' ') >= 0) {
                continue;
            }
            map.put(key, s.substring(eq + 1).trim());
        }
        return map;
    }

    private static String nvl(String s) {
        return s == null ? "" : s;
    }

    private static String quote(String s) {
        return "'" + s.replace("'", "'\\''") + "'";
    }

    private static String join(List<String> list, String sep) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                sb.append(sep);
            }
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private static MessageDigest newDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 不可用", e);
        }
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            sb.append(Character.forDigit((b >> 4) & 0xF, 16));
            sb.append(Character.forDigit(b & 0xF, 16));
        }
        return sb.toString();
    }

    private static void closeQuietly(java.io.Closeable c) {
        if (c == null) {
            return;
        }
        try {
            c.close();
        } catch (IOException ignored) {
            // 只读/只写流关闭失败无影响
        }
    }
}
