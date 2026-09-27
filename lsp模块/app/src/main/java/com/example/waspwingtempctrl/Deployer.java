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
 * <b>I4（已冻结）：部署完成判定</b> + <b>I5 的一半：界面 ↔ 部署的调用边界</b>。
 *
 * <p>界面（线 D）只允许调本类的 {@link #probe()}、{@link #deploy()}、{@link #uninstall()}、
 * {@link #startDaemon()}、{@link #stopDaemon()}、{@link #buildDiagnostics()}，
 * <b>不得自己拼 shell、不得直接碰文件</b>。
 *
 * <h3>I4 的判据（只用 APK 侧可得的信息，因此不许要求 C 端加 --version 之类开关）</h3>
 * <pre>
 * deployed = su 通道可用
 *          ∧ /data/local/tmp/tempctrl 存在
 *          ∧ 可执行
 *          ∧ md5 与 APK 内 assets/tempctrl-arm64 一致
 *          ∧ service.d 脚本存在
 *          ∧ md5 与 APK 内 assets/deploy/b6x-tempctrl.sh 一致    ← 脚本逐字节部署，故可直接比哈希
 * </pre>
 * 配置存在、守护进程在跑<b>不算</b>完成判据（配置允许缺失、进程允许未起），只作状态展示。
 *
 * <h3>root 调用一律走 {@link RootShell}（I2）</h3>
 * 本类不拼 {@code Runtime.exec("su ...")}。全部方法阻塞，<b>禁止在主线程调用</b>。
 *
 * <h3>为什么二进制/脚本要经过私有目录中转</h3>
 * {@code /data/local/tmp} 与 {@code /data/adb} 都不是 app 能写的目录，
 * 因此先用 Framework 的 File API 把 APK 内资源落到私有目录并授权（照 Scene 的做法），
 * 再由 root 的 {@code cp} 就位。{@code chmod} 只出现在 root 侧、作用于 root 拥有的路径，
 * 不用于 app 自己的落盘（app 侧一律 {@code setExecutable(true,false)} + 沿父目录链逐级向上）。
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
    /** C 端单实例锁退出码：已有实例在运行。 */
    public static final int EXIT_ALREADY_RUNNING = 2;

    /** 同步清单文件名（放私有目录，随卸载连目录一起删）。 */
    public static final String MANIFEST_NAME = "tempctrl_sync_manifest";
    /** 清单里的 APK 时间戳键（app 写、脚本读；两边字面量必须一致）。 */
    private static final String MANIFEST_KEY_APK_MTIME = "APK_MTIME";

    /**
     * 「自动更新」开关的配置键。
     *
     * <p>键定义在 {@code params.def.json} 的 webui 组（{@code daemonConsumes=false}，界面自用），
     * 值落在 {@code profile.conf}：之所以不另写一份标记文件，是为了让<b>脚本侧读同一个键</b>
     * （{@code b6x-tempctrl.sh} 直接 grep profile.conf），避免"界面写一处、脚本读另一处"的双份真相。
     */
    public static final String KEY_UI_AUTO_UPDATE = "UI_AUTO_UPDATE";

    /**
     * root 探测的一次性落盘标记所在的 prefs 文件名与键。
     *
     * <p><b>为什么集中在 {@code Deployer}</b>：写读这两处的类分处两个包（{@code Deployer} 在根包、
     * {@code ui/StatusFragment} 在 ui 包），键名与文件名只在根包收口，避免同一字面量写两份。
     */
    public static final String PREFS_ROOT_PROBE = "root_probe";
    /** 首次启动的 root 尝试标记（只试一次，被拒/失败都不再重试）。 */
    public static final String KEY_ROOT_TRIED = "root_tried";
    /** 已提示过「二进制哈希不一致」的 APK 侧 expected md5。 */
    public static final String KEY_HASH_PROMPTED_MD5 = "bin_hash_prompted_md5";
    /** 设备侧上次已知的二进制 md5（部署成功或探测确认一致时写入）。 */
    public static final String KEY_BIN_DEPLOYED_MD5 = "bin_deployed_md5";

    private static final long START_COOLDOWN_MS = 10_000L;
    /**
     * 发 {@code kill}（SIGTERM）后轮询等进程退出的秒数。
     *
     * <p>C 端装了 SIGTERM 处理器——收到只置退出标志，要等当前一轮跑完，一轮最长约 5 秒
     * （同部署脚本 {@code WAIT_LOOPS} 的注记），5 轮即够；实测用不到那么久，原为 30 轮。
     */
    private static final long KILL_WAIT_LOOPS = 5L;
    /** 强杀（{@code kill -9}）后的等待轮数：-9 已不可被忽略，只需一小段收尾时间。 */
    private static final long KILL9_WAIT_LOOPS = 3L;
    /** 拉起失败后重试前的停顿（毫秒）：给旧实例收尾、单实例锁释放留一点时间。 */
    private static final long RETRY_PAUSE_MS = 2_000L;
    private static final long EXEC_TIMEOUT_MS = 120_000L;
    /**
     * {@link #probe()} 那一趟 su 往返的超时。
     *
     * <p>probe 只跑只读脚本（存在性 / md5sum / 扫 /proc 判活），不等任何进程退出，故远短于
     * {@link #EXEC_TIMEOUT_MS} —— 那个长度是 deploy / uninstall 轮询等进程退出才需要的。
     * 取 15 秒：给慢设备上 su 冷启动与首次授权框留余量，又不再让状态区干等两分钟。
     */
    private static final long PROBE_EXEC_TIMEOUT_MS = 15_000L;

    /**
     * asset 哈希的进程级 memo（key = asset 路径）。
     *
     * <p>APK 内的 asset 在进程存活期间不可能变，故一次算过的哈希可以一直用；而两处调用点的代价都不轻：
     * {@link #needsRedeploy} 是冷启动落页判定的必经一步（{@code SetupActivity} 把它连判定一起放在
     * {@code ww-preload} 预热线程上，见 {@code SetupActivity#preload}），{@link #probe()} 每次要算两份、
     * 而 probe 是每个动作的收尾（一次部署要跑好几次）。asset 无 {@code noCompress}，
     * 每次都要实时解压再哈希，memo 于是把「每动作数份」降成「每进程各一份」。
     *
     * <p>用 {@link ConcurrentHashMap} 而非 HashMap：probe 与 needsRedeploy 各自在自己的后台线程上调用
     * （后者是预热线程），两侧都会写。并发撞上同一路径时只是重复算一次（结果幂等），故不加锁互斥。
     *
     * <p><b>只在成功时写</b>：asset 缺失/读错误照旧抛 {@link IOException}、不进表 ——
     * 否则一次瞬时失败会被永久记住，此后连重试的机会都没有。
     *
     * <p>不随 APK 更新失效：覆盖安装会杀掉本进程，新进程自然是空表。
     */
    private static final Map<String, String> ASSET_MD5_MEMO = new ConcurrentHashMap<>();

    private static volatile Deployer instance;

    private final Context appContext;
    private final RootShell shell;
    private final ConfigStore configStore;

    /**
     * 拉起冷却（内存态，进程重启即失效）。
     *
     * <p>只由 {@link #startDaemon()} 写入（成功失败都写，防连点）；{@link #deploy()} 成功时清零 ——
     * 那时候盘上刚换过二进制，紧随其后的自动拉起必须能起（见 {@link #deploy()}）。
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
     * 是否需要重新部署 —— <b>只读缓存，不跑 su</b>，供启动落页判定调用（{@code SetupActivity} 已把整个
     * 判定连它一起放在 {@code ww-preload} 预热线程上，见 {@code SetupActivity#preload}，故不在主线程）。
     *
     * <p>判据：设备上上次已知的二进制 md5（{@link #KEY_BIN_DEPLOYED_MD5}）与 APK 内
     * {@code assets/tempctrl-arm64} 的 md5 不一致。缓存来自「部署成功」或「探测确认一致」两条路径
     * （见 {@link #rememberDeployedBinMd5}），因此它表达的是"上次看到的设备侧内容"，
     * 不保证此刻设备上仍是这个值 —— 实时状态仍以 {@link #probe()} 为准。
     *
     * <p>无缓存时退化为「首启判据」{@code !root_tried}：从没部署过（也没试过 root）＝需要去状态页，
     * 让首次授权/部署入口仍可达；已经试过 root 却仍无缓存（被拒、或部署从未成功）
     * ＝不再自动引导，落回用户设定的起始页。
     *
     * <p>APK 内取不到二进制（本地构建没有 CI 注入的 asset）→ 无从比对，一律 false。
     *
     * <p><b>求值顺序</b>：先读 {@code SharedPreferences}、后算资产哈希 —— 只调换顺序，判据逐分支不变。
     * 资产哈希（解压 + 哈希）是这里有同步 IO 的一步，且它是落页判定那条路上最贵的一步；而"已试过
     * root 却无缓存"这一支的结果与资产无关，故那条路上不再白算它。
     */
    public static boolean needsRedeploy(Context context) {
        Context app = context.getApplicationContext();
        // 先读 SharedPreferences：下面这一支（从没部署过）的判据只有"试过 root 没有"，与资产是否可比
        // 无关，故不再为它白算一遍资产 MD5（解压 + 哈希）。这是落页判定那条路上最贵的一步。
        SharedPreferences prefs = app.getSharedPreferences(PREFS_ROOT_PROBE, Context.MODE_PRIVATE);
        String cached = prefs.getString(KEY_BIN_DEPLOYED_MD5, null);
        if (cached == null || cached.isEmpty()) {
            if (prefs.getBoolean(KEY_ROOT_TRIED, false)) {
                return false;   // 已试过 root 却仍无缓存：不再自动引导（见上一段"无缓存时退化"的判据）
            }
            // 未试过 root：仍要"资产取不到 → 一律 false"这条既有护栏，故资产可比性还是得问一次
            // （本地构建没有 CI 注入的 asset 时，正是靠它不把用户引到状态页去）
            return !md5OfAssetOrEmpty(app, BIN_ASSET).isEmpty();
        }
        String expected = md5OfAssetOrEmpty(app, BIN_ASSET);
        if (expected.isEmpty()) {
            return false;
        }
        return !cached.equals(expected);
    }

    /**
     * 记下设备侧当前已知的二进制 md5（{@link #needsRedeploy} 的唯一数据来源）。
     *
     * <p>两处调用：{@link #deploy()} 成功就位并读回设备侧哈希之后；状态页探测到
     * {@link Status#binHashOk} 为真时。空值不写（宁可保留旧值，也不把缓存清成"从没部署过"）。
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
     * 「自动更新」开关当前是否开启（<b>默认开</b>）。
     *
     * <p>键是 {@link #KEY_UI_AUTO_UPDATE}，值落在 {@code profile.conf}；<b>脚本侧读的是同一个键</b>
     * （{@code b6x-tempctrl.sh} 直接 grep 该文件），故界面与脚本不会各有一份真相。
     * 读不到（键还没落到设备上的 profile.conf、或定义尚未发布）即按默认值【开】处理，
     * 与定义的 {@code default} 一致 —— 口径与 {@code SetupActivity#isDeployEntryEnabled} 相同。
     *
     * <p>不阻塞（读的是 {@link ConfigStore} 的内存快照）。
     */
    public static boolean isAutoUpdateEnabled(Context context) {
        ConfigStore.Value value = ConfigStore.get(context).get(KEY_UI_AUTO_UPDATE);
        return value == null || value.intAt(0) != 0;
    }

    // ==================== 状态 / 判定 ====================

    /**
     * 部署状态。{@link #describe()} 是唯一出屏形态，状态区与诊断信息共用同一份文本：
     * 结论行 + 二进制 / service.d 脚本 / 配置 / 守护进程逐项 + 提示行。
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
        /** I4 判据的结果。 */
        public final boolean deployed;
        /** 配置文件绝对路径（app 侧）。 */
        public final String configPath;
        public final List<String> notes;

        Status(boolean suOk, boolean binExists, boolean binExecutable, boolean binHashOk,
               String binMd5, String binExpectedMd5, String scriptPath, boolean scriptPresent,
               boolean scriptHashOk, String scriptMd5, String scriptExpectedMd5,
               boolean configPresent, boolean configPathAligned, boolean daemonRunning,
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
                    .append(configPresent ? "已存在" : "不存在（守护进程将用代码默认值）")
                    .append(configPathAligned ? "" : "，且与 C 端落点不一致").append('\n');
            sb.append("  守护进程：").append(daemonRunning ? "运行中" : "未运行").append('\n');
            appendNotes(sb);
            return sb.toString();
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
        Map<String, String> kv = parseKv(r.stdout);
        boolean suOk = r.isOk();
        if (!suOk) {
            notes.add("root 通道不可用：" + r.describe());
        }
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
        return new Status(suOk, binExists, binExec, binHashOk, binMd5, expectedBin,
                scriptPath, scriptPresent, scriptHashOk, scriptMd5, expectedScript,
                configStore.exists(), aligned, "1".equals(kv.get("RUNNING")),
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

        Result(boolean ok, String action, List<String> steps, String error, Status status) {
            this.ok = ok;
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
     * 一次性部署：资源落盘与授权 → 二进制就位 → service.d 脚本 → 配置保留写入 →
     * 省电白名单（下发给已安装的散热器控制 app，见 {@link #powerAllowlistScript()}）。
     *
     * <p><b>配置保留</b>：{@code profile.conf} 不存在时才写出厂值（取自 params.json 的
     * {@code factory}），已存在则一个字都不覆盖。
     *
     * <p><b>本方法只动盘、不重启守护进程</b>：盘上换了新二进制，不重启进程它就一直在跑旧映像、
     * 等于没更新。"换完盘立刻拉起一次"接在部署之后，由调用方负责——状态页在部署结果上屏后
     * 自动调一次 {@link #startDaemon()}，与手动点「拉起daemon」走的是同一条路径。
     *
     * <p>任一硬步骤失败即返回 {@code ok=false}（配置与白名单失败不算硬失败，记在 steps 里）。
     * <b>阻塞</b>（root 往返 3 次 + 落盘 + 若干次 probe）。
     */
    public Result deploy() {
        List<String> steps = new ArrayList<>();

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

        RootShell.Result r = shell.exec(deployScript(stagedBin, stagedScript), EXEC_TIMEOUT_MS);
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

        RootShell.Result pr = shell.exec(powerAllowlistScript(), EXEC_TIMEOUT_MS);
        // 文案不写"已下发"：没装散热器控制 app 时脚本整段跳过、什么也没下发，退出码同样是 0。
        steps.add(pr.isOk() ? "省电白名单批处理已执行（仅对已安装的散热器控制 app 生效）"
                : "省电白名单下发失败（不影响部署）：" + pr.describe());

        // 到位即止：拉起daemon 不在本方法里做（见 javadoc）——界面在部署上屏后再自动调一次
        // startDaemon()，那是独立的一段（自己的忙态、操作记录与进度条）。
        Status st = probe();
        if (st.deployed) {
            // 盘上确实换了新二进制：清掉拉起冷却，让紧随其后的自动拉起不被「防连点」挡下 ——
            // 挡下的后果是旧进程继续跑旧映像，正是本方法 javadoc 警告的「等于没更新」，
            // 且没有任何自动补偿。防连点的语义只对「手动点拉起daemon」成立，那条路径一个字不动。
            lastStartAtMs = 0L;
        }
        return new Result(st.deployed, "部署", steps, st.deployed ? "" : "部署后自检未通过", st);
    }

    /**
     * 只重推 service.d 脚本：不动二进制、不碰配置，<b>但会重启守护进程</b>。<b>阻塞</b>（root 往返 1 次）。
     *
     * <p>用途：{@link #probe()} 发现设备上的脚本与 APK 内资源哈希不一致时自动纠正。脚本是纯文本、
     * 无运行态，重推无损；二进制若不一致仍须走完整 {@link #deploy()}。
     *
     * <p><b>为什么要连守护进程一起重启</b>：脚本与二进制同属"部署产物"、按同一份 APK 配套发布，
     * 脚本变了就等于这次部署产物变了；且 service.d 脚本本身就是常驻的看门狗 shell（每
     * {@code RESTART_INTERVAL} 秒一轮），只换盘上文件、不重起它，那一层仍然跑旧脚本的内存映像
     * ——新脚本里改掉的判别逻辑要等重启手机才生效。故这里<b>先把看门狗 shell 停掉</b>，再由
     * {@link #restartScript()} 的同一段逻辑用<b>磁盘上的新脚本</b>把它拉起来。
     *
     * <p>守护进程的停旧起新<b>不靠脚本</b>：{@code restartCore()} 在决定是否拉起脚本之前就已经把旧
     * 实例停稳（含 {@code kill -9} 升级），脚本只负责把新的拉起来（脚本自身已不再先杀守护进程——见
     * {@code tempctrl.c} 的「看门狗反向保活」：两侧统一为"先查后拉、存在即不重复拉起"）。
     * 代价与「拉起daemon」同级：温控空窗 ≤{@value #KILL_WAIT_LOOPS}+{@value #KILL9_WAIT_LOOPS} 秒。
     *
     * <p><b>不探测</b>：返回的 {@link Result#status} 恒为 null（多一趟 su 往返不划算）。
     * 重启的成败写在 {@link Result#steps} 里，调用方据此上屏。
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

        RootShell.Result r = shell.exec(updateScriptScript(stagedScript), EXEC_TIMEOUT_MS);
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
                    ? "已停旧看门狗 shell，并由磁盘上的新脚本重新拉起（新脚本自此生效）"
                    : "警告：看门狗脚本不在、且未能重新拉起（需重新部署）");
        }
        steps.add("1".equals(kv.get("STARTED"))
                ? "守护进程已重启（PID " + nvl(kv.get("NEW_PID")) + "）"
                : "警告：未探测到新的守护进程（它启动前要等亮屏，灭屏时会更晚一些）");
        return new Result(true, "更新脚本", steps, "", null);
    }

    /**
     * 卸载部署：停进程 → 删脚本/二进制/锁/status 双文件 → 删私有目录里的运行时产物。
     *
     * <p>清完之后 {@code /data/local/tmp/} 侧不再有本次部署的残留；私有目录里只剩
     * {@code profile.conf}（用户配置）。
     *
     * <p><b>故意不清的东西</b>（每条都有理由）：
     * <ul>
     *   <li>私有目录的 {@code profile.conf} —— 用户配置，卸载部署≠删配置；重装后仍在。</li>
     *   <li>省电白名单（deviceidle / appops / standby bucket）—— 下发对象是<b>散热器控制 app</b>
     *       （见 {@link #powerAllowlistScript()}，不是本界面 app）。对它仍然有益：钩子跑在散热器
     *       app 进程里，那个进程被冻结/回收即断链；且用户可在系统设置里自行撤销。</li>
     *   <li>{@code tempctrl_last_dev} 的<b>新落点</b>（飞智 app 自己的私有目录
     *       {@code /data/data/<飞智包名>/files/}，各包各记）—— 既不属本次部署的产物，
     *       也不在我们有权清理的目录里，<b>本类不碰</b>。</li>
     * </ul>
     *
     * <p>唯一例外是 {@code tempctrl_last_dev} 的<b>旧落点</b>
     * {@code /data/local/tmp/tempctrl_last_dev}：它是老版本的迁移残留（daemon 侧的预创建已删、
     * 现已无人读写），不会自己消失，所以卸载时顺手清掉 —— 这与上面「不碰新落点」并不矛盾。
     *
     * <p><b>阻塞</b>。
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
                ? "已停止看门狗 shell（先于守护进程杀，否则它会重建日志并把守护进程再拉起来）"
                : "警告：" + KILL_WAIT_LOOPS + " 秒内未能确认看门狗 shell 已退出（脚本自身的自尽自检会在下一轮兜底）");
        if (daemonStopped) {
            steps.add("已停止运行中的 tempctrl");
        } else {
            steps.add("警告：" + KILL_WAIT_LOOPS + " 秒内未能确认 tempctrl 已退出，锁文件暂不删除（避免绕过单实例锁）");
        }
        steps.add("已删 service.d 脚本（两个候选目录都查了）");
        steps.add("已删 " + BIN_DEST + "（进程已停，可安全 unlink）");
        steps.add("已删 status 双文件（守护进程下次启动会重建；仍激活的 MainHook 读到缺失即视为断联）");
        steps.add("已删脚本自身日志 /data/local/tmp/tempctrl_service.log");
        steps.add("已删旧版迁移残留 /data/local/tmp/tempctrl_last_dev"
                + "（新版落点在飞智 app 自己的私有目录，各包各记，本类不碰）");
        steps.add("已删旧版锁文件残留 /data/local/tmp/tempctrl.lock"
                + "（C 端锁文件已迁私有目录，那份由本类在确认进程退出后清）");
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
     * 重启守护进程（界面入口）。<b>先停再起</b>：C 端用非阻塞 {@code flock} 做单实例锁，
     * 旧实例还在时新实例会立刻以退出码 {@value #EXIT_ALREADY_RUNNING} 退出，
     * 所以"已在运行"不能当作"无需拉起"——那正是"点了没反应"的原因。
     *
     * <p>停止序列照 {@link #uninstall()} 的口径：{@code kill} → 轮询等 ≤{@value #KILL_WAIT_LOOPS} 秒
     * → {@code kill -9} → 再轮询 ≤{@value #KILL9_WAIT_LOOPS} 秒；仍未退出则<b>放弃启动</b>
     * 并如实回吐（抢锁必然失败，静默失败比报错更难查）。
     *
     * <p><b>失败自动重试一次</b>：等 {@value #RETRY_PAUSE_MS} ms 再跑一遍完整序列。确定性失败
     * 不重试——冷却是拒绝而非失败（先于重试返回）、二进制不存在重试必然同样失败；其余
     * （root 通道失败、旧实例未退出、新实例没起来）都再试一次。
     *
     * <p><b>代价</b>：只等旧实例退出的最多 {@value #KILL_WAIT_LOOPS} + {@value #KILL9_WAIT_LOOPS} 秒
     * （C 端已无启动延时），即一次点击约 0~8 秒温控空窗；失败重试会再叠一次，步骤里都会写明。
     * 冷却 {@value #START_COOLDOWN_MS} ms 保留（防连点）；但 {@link #deploy()} 成功后会把它清零
     * ——那时候盘上刚换过二进制，这条自动拉起必须能起（见 {@link #deploy()}）。
     *
     * <p><b>阻塞</b>。注意：这条路起的进程仍在该 app 的 cgroup 内，
     * 常驻仍以 {@code service.d} 为主（见 {@link #deploy()}）。
     */
    public Result startDaemon() {
        List<String> steps = new ArrayList<>();
        long now = System.currentTimeMillis();
        if (now - lastStartAtMs < START_COOLDOWN_MS) {
            long remain = (START_COOLDOWN_MS - (now - lastStartAtMs)) / 1000;
            steps.add("冷却中，请 " + remain + " 秒后重试");
            return new Result(false, "拉起daemon", steps, "冷却中", null);
        }
        lastStartAtMs = now;

        Attempt a = restartOnce(steps);
        if (a.retryable && pauseBeforeRetry()) {
            steps.add("拉起未成功（" + a.error + "），自动重试一次");
            a = restartOnce(steps);
        }
        return new Result(a.ok, "拉起daemon", steps, a.ok ? "" : a.error, probe());
    }

    /**
     * 跑一次完整的「先停再起」，把可读步骤追加进 {@code steps}。
     *
     * <p>不判冷却（由调用方管），只回吐这一次的成败、失败原因、以及是否值得再试一次——
     * 可重试＝root 通道失败 / 旧实例未退出 / 未探测到新进程；不可重试＝二进制不存在
     * （重试必然同样失败）。
     */
    private Attempt restartOnce(List<String> steps) {
        RootShell.Result r = shell.exec(restartScript(), EXEC_TIMEOUT_MS);
        if (!r.isOk()) {
            return new Attempt(false, true, "root 执行失败：" + r.describe());
        }
        Map<String, String> kv = parseKv(r.stdout);
        boolean viaWatchdog = "0".equals(kv.get("WD_ALIVE"));
        String oldPid = nvl(kv.get("OLD_PID"));
        if (viaWatchdog) {
            if (!"1".equals(kv.get("WD_STARTED"))) {
                steps.add("看门狗 shell 不在，且 service.d 脚本缺失（两个候选目录都没找到）");
                return new Attempt(false, false, "看门狗脚本不存在（需先重新部署）");
            }
            steps.add("看门狗 shell 不在（如刚点过「停止daemon」），已重新拉起，由它停旧起新");
        } else if (!"1".equals(kv.get("OLD_STOPPED"))) {
            steps.add("检测到守护进程在运行（PID " + oldPid + "），先停止它");
            steps.add(KILL_WAIT_LOOPS + " 秒内未退出，kill -9 后仍未退出");
            return new Attempt(false, true,
                    "旧实例未退出，已放弃启动（否则新实例抢单实例锁必然失败）");
        } else if ("1".equals(kv.get("NOBIN"))) {
            steps.add(oldPid.isEmpty() ? "未检测到运行中的守护进程" : "已停止旧实例（PID " + oldPid + "）");
            return new Attempt(false, false, "二进制不存在（需先部署）：" + BIN_DEST);
        } else {
            steps.add(oldPid.isEmpty() ? "未检测到运行中的守护进程，直接启动"
                    : "已停止旧实例（PID " + oldPid + "）");
            if ("1".equals(kv.get("OLD_KILLED"))) {
                steps.add("旧实例未响应 kill（SIGTERM），已用 kill -9 结束");
            }
        }
        if (!"1".equals(kv.get("STARTED"))) {
            steps.add(viaWatchdog
                    ? "看门狗已拉起，但尚未探测到 daemon（它启动前要等亮屏，灭屏时会等到亮屏才起）"
                    : "启动命令已执行，但未探测到新进程（未起或起后立即退出）");
            return new Attempt(false, true, "未启动");
        }
        steps.add((viaWatchdog ? "已由看门狗启动 tempctrl（PID " : "已拉起新实例（PID ")
                + nvl(kv.get("NEW_PID")) + "，已 renice -20）");
        steps.add("温控空窗约 0~" + (KILL_WAIT_LOOPS + KILL9_WAIT_LOOPS)
                + " 秒（只等旧实例退出；C 端无启动延时）");
        return new Attempt(true, false, "");
    }

    /** 一次拉起尝试的结果：{@code ok}=新实例已起来；{@code retryable}=值得再试一次。 */
    private static final class Attempt {
        final boolean ok;
        final boolean retryable;
        final String error;

        Attempt(boolean ok, boolean retryable, String error) {
            this.ok = ok;
            this.retryable = retryable;
            this.error = error;
        }
    }

    /** 重试前的停顿；被中断则不重试（恢复中断标志，按上一次的结果返回）。 */
    private static boolean pauseBeforeRetry() {
        try {
            Thread.sleep(RETRY_PAUSE_MS);
            return true;
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * 停止守护进程（界面入口）：<b>先停看门狗 shell、再停 daemon</b>，只杀进程，不删任何文件。
     *
     * <p><b>为什么必须连看门狗一起停</b>：它每 {@code RESTART_INTERVAL} 秒检查一次「daemon 不在就
     * 拉起」，只杀 daemon 的话最多 5 分钟就被它拉回来，「停止」不成立。代价是看门狗要重启手机
     * （由 {@code service.d} 拉起）才会回到常驻；期间恢复靠 {@link #startDaemon()}——它会发现
     * 看门狗不在并把看门狗一起拉起来——或重新 {@link #deploy()}。
     *
     * <p>与 {@link #uninstall()} 的区别：两者停的是同一对进程（共用 {@link #killAndWaitSnippet}），
     * 但卸载停稳之后还要删文件，这里什么都不删。<b>阻塞</b>。
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
                ? (wdPid.isEmpty() ? "未检测到运行中的看门狗 shell"
                        : "已停止看门狗 shell（PID " + wdPid + "；它在 daemon 之前杀，否则会把 daemon 拉回来）")
                : "警告：" + KILL_WAIT_LOOPS + " 秒内未能确认看门狗 shell 已退出");
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
     * <b>防御性预创建</b>私有目录里的两个运行时文件（{@code tempctrl.log} / {@code tempctrl_webui.data}）。
     *
     * <p><b>标注：防御性、未经真机验证</b>。前提是一个未经验证的假设：这两个文件原本由 root 的守护进程
     * 在 app 私有目录里创建，权限层面 app 大概率读得到（0644 / 目录 0771），
     * 但 <b>SELinux 标签层面未必</b>（非 app 域创建的文件不一定是 {@code app_data_file}）。
     * 由 app 用自己的 uid 先建，属主与标签就是对的；守护进程之后是<b>追加写既有文件</b>
     * （{@code fopen(path,"a")}）与<b>原地 ftruncate 轮转</b>（不 rename、不重建），
     * 因此不会把标签改回 root。
     *
     * <p>边界：只在<b>不存在时</b>创建，已存在一个字都不碰；创建失败<b>不阻断部署</b>（非必需品），
     * 只在步骤里记一行。二进制被改名或 {@code LOG_FILE} 被改成别的名字时，本条不覆盖那个名字。
     *
     * <p>刻意不用 {@link RootShell}：由 root 创建就回到了要规避的那个标签问题上。
     */
    private String preCreateRuntimeFiles() {
        List<String> created = new ArrayList<>();
        List<String> kept = new ArrayList<>();
        List<String> failed = new ArrayList<>();
        for (String name : new String[]{"tempctrl.log", "tempctrl_webui.data"}) {
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
     * 刷新「同步清单」—— service.d 脚本在设备上找不到可用解压工具时的<b>降级来源</b>。
     *
     * <p>正常路径下脚本自己解 APK 取资源（`busybox/toybox/unzip` 三选一），用不到本清单；
     * 三个都不可用时它才退而读这份清单。清单是一份 {@code KEY=VALUE}：
     * <pre>
     * APK_MTIME=&lt;base.apk 的 mtime，秒&gt;        ← 与脚本侧 {@code stat -c %Y} 同口径
     * BIN_MD5 / SCRIPT_MD5=&lt;期望内容哈希&gt;
     * BIN_SRC / SCRIPT_SRC=&lt;私有目录里中转副本的绝对路径&gt;
     * </pre>
     * <b>时间戳是这份清单的保鲜期</b>：脚本只在「清单里的 APK_MTIME 与当前 APK 文件一致」时才用它
     * —— 否则清单描述的是旧 APK，照它装就是装旧内容（宁可不动，也不能装错）。
     *
     * <p><b>只在 APK 换了才做</b>：判据是一次 {@code stat}（比较清单里记的 mtime 与当前 APK 文件的
     * mtime），所以每次进状态页顺手调都不亏；真刷新时才解压两份 asset 并复刻到中转副本。
     * <b>清单不存在</b>（老版本升上来 / 用户刚清过数据）也走刷新，故降级路不会因为"从没写过清单"而瞎。
     *
     * <p>清单与副本都在私有目录（随系统卸载连目录一起删，不需要动卸载清理清单）。
     * <b>阻塞</b>（解压 + 写盘），只在后台线程调；失败不抛异常，记在返回值里。
     *
     * @return 需要上屏的失败说明；无需刷新或刷新成功时返回 null
     */
    public String writeSyncManifestIfNeeded() {
        long apkMtimeSec = apkFileMtimeSec();
        if (apkMtimeSec <= 0L) {
            // 取不到 APK 文件时间戳：无从判定清单是否过期，也就不写（脚本侧会退化为"不动作"）
            return null;
        }
        // APK 内资源不完整（本地构建没有 CI 注入的 asset）：probe() 已有"APK 内资源不完整"的提示行，
        // 这里静默跳过，不重复报一遍（两份哈希的 memo 命中，代价只是一次查表）
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
     * 删私有目录里的运行时产物；返回删除成功的文件名。{@code profile.conf} 不在列（用户配置）。
     *
     * <p>清单与时间戳记录（{@link #MANIFEST_NAME} / {@code tempctrl_deploy_stamp}）也在列：
     * 它们描述的是"部署产物当前是什么样"。卸载之后不清掉，脚本侧那份「上次核对通过」的记录
     * 会让 {@code service.d} 脚本认为"本机部署过"，下次开机把刚卸载掉的东西又装回来。
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
     * 两个「按 pid 找目标进程」的 shell 函数（跑在设备端 su shell 里、toybox 环境）。
     *
     * <p><b>为什么替掉 {@code pgrep -f}</b>：那是 cmdline 子串匹配，凡命令行里出现过该串的进程都被
     * 算进来。对 {@code $BIN} 尤其糟——该路径同时是 {@code tempctrl_service.log} / {@code tempctrl_uiprefs} /
     * {@code tempctrl_*.status} 等一串兄弟文件名的前缀，而后果不只是"多杀一个无关进程"：等待循环会
     * 永远等不到"已退出"（无关进程不受我们的 signal 影响），{@code <TAG>_STOPPED} 恒 0，
     * 「拉起daemon」直接判「旧实例未退出，已放弃启动」——一次无关进程就能让该功能硬失败。
     *
     * <p><b>判据只剩这一处</b>：{@link #killAndWaitSnippet}（停）与 {@link #restartCore()}（判活 / 取 PID）
     * 共用这两个函数，故"判有没有在跑"与"判停没停稳"不可能给出不同结论。判据与 service.d 脚本的
     * {@code running()} 同源（{@code /proc/<pid>/exe} 的指向），差别只在脚本那边不必管
     * {@code (deleted)}——它不再承担"换掉在跑实例"的职责。
     */
    private static String pidsPreamble() {
        return "BIN=" + BIN_DEST + "\n"
                // 二进制实例＝/proc/<pid>/exe 的指向**恰好**是 $BIN（末端锚定，故不会命中
                // tempctrl_service.log / tempctrl_*.status 那些兄弟文件）。
                // 末尾允许 " (deleted)"：部署流程是 rm -f 后 cp（`deployScript()`），而旧实例可能正跑着
                // 那个被 unlink 的 inode —— 此时它的 exe 显示成 "<路径> (deleted)"，但它**仍持着单实例锁**，
                // 必须仍算"在跑"、仍要能被停掉；否则新实例以退出码 2 退出，盘上的新二进制永远不生效
                // （正是 deploy() 警告过的"等于没更新"）。二元括号写成 [(] [)]，不在 ERE 里用转义括号。
                + "bin_pids() {\n"
                + "    ls -l /proc/[0-9]*/exe 2>/dev/null"
                + " | grep -E -- \"-> $BIN( [(]deleted[)])?$\""
                + " | sed -n \"s#.* /proc/\\([0-9]*\\)/exe ->.*#\\1#p\"\n"
                + "}\n"
                // 看门狗 shell：exe 判不出来（一切 shell 的 exe 都是 /system/bin/sh），故改为看两件事：
                //   ① 进程映像就是 shell（/proc/<pid>/comm == sh —— 内核按 execve 的可执行文件名给，
                //      与 argv[0] 无关）；
                //   ② 它的某个**参数恰好等于**候选脚本路径（不是子串：cp/rm/md5sum 的实参、部署中转
                //      副本 <staging>/b6x-tempctrl.sh、".new" 后缀、只是提到过该文件名的进程，一概不算）。
                // 合起来命中的就是"另一个正在跑本脚本的实例"（含 `sh <路径>`、shebang 直 exec、
                // `sh -c '<路径>'` 三种形态；本 app 自己的 su shell 参数为空，天然不命中）。
                // 先按 comm 一次 grep 筛出 shell（每 pid 省掉后面的 fork），再把 NUL 换成换行做成文本
                // 管道后用 grep -qx（整行相等）——不依赖 grep 的二进制文件语义，也不用 -z。
                + "wd_pids() {\n"
                + "    for c in $(grep -l '^sh$' /proc/[0-9]*/comm 2>/dev/null); do\n"
                + "        p=${c#/proc/}; p=${p%/comm}\n"
                + "        a=$(tr '\\000' '\\n' < \"/proc/$p/cmdline\" 2>/dev/null)\n"
                + "        case \"$a\" in *" + SCRIPT_NAME + "*) ;; *) continue ;; esac\n"
                + "        if printf '%s\\n' \"$a\" | grep -qx -- \"" + SERVICE_D_MODERN + "/" + SCRIPT_NAME + "\""
                + " || printf '%s\\n' \"$a\" | grep -qx -- \""
                + SERVICE_D_KSU_LEGACY + "/" + SCRIPT_NAME + "\"; then\n"
                + "            echo \"$p\"\n"
                + "        fi\n"
                + "    done\n"
                + "}\n";
    }

    private String probeScript() {
        return pidsPreamble()
                + "[ -e \"$BIN\" ] && echo BIN_EXISTS=1 || echo BIN_EXISTS=0\n"
                + "[ -x \"$BIN\" ] && echo BIN_EXEC=1 || echo BIN_EXEC=0\n"
                + "if command -v md5sum > /dev/null 2>&1; then echo MD5TOOL=1; else echo MD5TOOL=0; fi\n"
                + "echo \"BIN_MD5=$(md5sum \"$BIN\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + "for d in " + SERVICE_D_KSU_LEGACY + " " + SERVICE_D_MODERN + "; do\n"
                + "  f=\"$d/" + SCRIPT_NAME + "\"\n"
                + "  if [ -f \"$f\" ]; then echo \"SCRIPT=$f\"; echo \"SCRIPT_MD5=$(md5sum \"$f\" 2>/dev/null | cut -d' ' -f1)\"; fi\n"
                + "done\n"
                + "[ -n \"$(bin_pids)\" ] && echo RUNNING=1 || echo RUNNING=0\n";
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

    /**
     * 把脚本装到 $svcd 并回吐 SCRIPT_OK 的片段（部署与单独更新脚本共用）。
     *
     * <p><b>先落 {@code .new} 再 {@code mv}</b>：这个脚本自己就是常驻的看门狗 shell，
     * 覆写它正在读的那个文件会让 sh "边写边读"读到半截内容；{@code mv} 换的是目录项，
     * 正在跑的那个 shell 继续持旧 inode，读写两边互不干扰。失败路径顺手清掉半个 {@code .new}。
     */
    private static String scriptInstallSnippet(File stagedScript) {
        return "cp -f " + quote(stagedScript.getAbsolutePath()) + " \"$svcd/" + SCRIPT_NAME + ".new\" "
                + "&& chmod 0755 \"$svcd/" + SCRIPT_NAME + ".new\" "
                + "&& mv -f \"$svcd/" + SCRIPT_NAME + ".new\" \"$svcd/" + SCRIPT_NAME + "\" "
                + "&& echo SCRIPT_OK=1 || echo SCRIPT_OK=0\n"
                + "rm -f \"$svcd/" + SCRIPT_NAME + ".new\" 2>/dev/null\n";
    }

    /**
     * 只重推脚本时的 shell（完全不碰 $BIN）。
     *
     * <p>脚本换完要连看门狗与守护进程一起换：<b>先停看门狗 shell</b>（{@link #killAndWaitSnippet}），
     * 再由 {@link #restartCore()} 走"看门狗不在"那条路——它会用磁盘上的<b>新脚本</b>把看门狗拉起来，
     * 由它把守护进程停旧起新。只重启守护进程是不够的，原因见 {@link #updateScript()} 的 javadoc。
     */
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
        return "BIN=" + BIN_DEST + "\n"
                + serviceDirPreamble()
                + "mkdir -p \"$svcd\" 2>&1\n"
                // 先删再落：旧实例可能正跑着这个文件，直接 cp 覆写会 ETXTBSY（unlink 则不受影响，
                // 在跑的进程继续持旧 inode 跑完自己那一轮）。随后的自动拉起会把新二进制换上去。
                + "rm -f \"$BIN\"\n"
                + "cp -f " + quote(stagedBin.getAbsolutePath()) + " \"$BIN\" && chmod 0755 \"$BIN\" "
                + "&& echo BIN_OK=1 || echo BIN_OK=0\n"
                + scriptInstallSnippet(stagedScript)
                + "echo \"BIN_MD5=$(md5sum \"$BIN\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + "echo \"SCRIPT_MD5=$(md5sum \"$svcd/" + SCRIPT_NAME + "\" 2>/dev/null | cut -d' ' -f1)\"\n";
    }

    /**
     * 省电白名单批处理：<b>逐包</b>下发给已安装的散热器控制 app，四段命令共处同一个 su 会话。
     *
     * <p><b>为什么目标不是本 app</b>：本 app 是纯界面（manifest 里零 service / receiver / provider），
     * 没有任何后台职责；控制链路两端是守护进程与<b>跑在散热器 app 进程里的钩子</b>，
     * 那个进程被冻结/回收才是真会断链的事。故目标改为散热器控制 app，且不再包含本 app。
     *
     * <p><b>包名从哪来</b>：{@code R.array.xposed_scope}（老 B6X / 新 B6X / B7X-farsef）。
     * Java 侧就这一份：{@code MainHook} 里的同名常量是 private，且那个类只由 LSPosed 在宿主进程里
     * 加载（本进程引用它会 NoClassDefFoundError）；C 端另有自己的 {@code APP_PKG_*} 宏。
     * 故复用作用域数组而不另写字面量 —— 作用域增删与此处目标同步，正是想要的对应关系。
     *
     * <p><b>只对装了的下发</b>：未安装的包跑这 4 条会白起两个 {@code app_process} 并往输出里灌报错。
     * 判据取 {@code [ -d /data/data/$PKG ]}（零 fork 的廉价判据，与守护进程自己判「已安装」的一级
     * stat 判据同源，见 {@code tempctrl.c} 的 {@code HOST_DATA_DIR}）；为此起一次 {@code pm} 不划算。
     *
     * <p><b>每次部署照旧无条件下发</b>（不做"先判后发"）：用户撤销白名单后再部署会重新加回，
     * 这与 {@link #uninstall()} 不清理白名单的口径一致。
     */
    private String powerAllowlistScript() {
        StringBuilder sb = new StringBuilder();
        for (String pkg : appContext.getResources().getStringArray(R.array.xposed_scope)) {
            // 每包一段 if：$PKG 逐段重设，四段仍在同一个脚本里跑完（不拆成多次 su exec）
            sb.append("PKG=").append(pkg).append('\n')
                    .append("if [ -d \"/data/data/$PKG\" ]; then\n")
                    .append("  echo \"-- $PKG --\"\n")
                    .append("  echo \"-- deviceidle --\"; dumpsys deviceidle whitelist +$PKG 2>&1\n")
                    .append("  echo \"-- appops --\"; appops set $PKG RUN_IN_BACKGROUND allow 2>&1\n")
                    .append("  echo \"-- standby --\"; am set-standby-bucket $PKG active 2>&1\n")
                    .append("  echo \"-- unfreeze --\"; am unfreeze --sticky $PKG 2>&1 || am unfreeze $PKG 2>&1\n")
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
                + "# 旧版迁移残留：C 端锁文件已迁到私有目录（tempctrl.lock，由 app 侧在确认进程退出后清）。\n"
                + "# 这里删的是老版本留在 /data/local/tmp 的那一份，不是重复代码，别删这一行。\n"
                + "rm -f /data/local/tmp/tempctrl.lock\n"
                + "rm -f /data/local/tmp/tempctrl_b6x.status\n"
                + "rm -f /data/local/tmp/tempctrl_b7x.status\n"
                + "# 守护进程转写给钩子的界面开关快照（钩子每次返回键读一次；删掉后钩子回退默认值）\n"
                + "rm -f /data/local/tmp/tempctrl_uiprefs\n"
                + "rm -f /data/local/tmp/tempctrl_service.log\n"
                + "# 旧版迁移残留：老版本把 tempctrl_last_dev 放在这里（daemon 侧的预创建已删、现已无人读写），\n"
                + "# 它不会自己消失，故卸载时一并清掉。\n"
                + "# 与新落点区分：新落点是飞智 app 自己的私有目录（各包各记），不属本次部署产物，本脚本不碰。\n"
                + "rm -f /data/local/tmp/tempctrl_last_dev\n"
                + "# 私有目录不可用时守护进程的兜底日志落点（/cache/<二进制名>.log），可能残留\n"
                + "rm -f /cache/tempctrl.log\n";
    }

    /**
     * 「先停再起」的完整 shell = {@code BIN=} + 目录定位 + {@link #restartCore()}。
     *
     * <p>不含 {@code exit}：{@link RootShell#exec} 靠脚本末尾的结束标记回传退出码，
     * 脚本自己退出会让标记丢失、整次调用被判成通道失败（见 {@code RootShell} 的说明）。
     */
    private String restartScript() {
        return pidsPreamble() + serviceDirPreamble() + restartCore();
    }

    /**
     * 「先停再起」的核心片段（调用方负责备好 {@code BIN=} 与 {@code $svcd}），<b>按看门狗在不在分两条路</b>：
     * <ul>
     *   <li>看门狗 shell 存活（常态）→ 只停/起 {@code $BIN}：看门狗自己的 tick 会兜住后续的进程级
     *       死亡，不必也不该动它（杀了它常驻保障就没了）。</li>
     *   <li>看门狗 shell 不在（例如刚点过「停止daemon」，或 {@link #updateScript()} 刚把它停掉）
     *       → 把 service.d 脚本拉起来，由它把 daemon 带回来（脚本启动时<b>不再</b>先杀 daemon：
     *       "先杀"由上一步 {@link #killAndWaitSnippet} 负责，脚本内部是"存在即不重复拉起"，
     *       见 {@code tempctrl.c} 的「看门狗反向保活」）——这是
     *       「停止daemon」之后唯一能恢复常驻的路（service.d 脚本平时只由系统在开机时拉起），
     *       也是「换了新脚本」之后让新脚本立刻生效的路。</li>
     * </ul>
     *
     * <p>看门狗脚本第一步是<b>等亮屏</b>，灭屏时它会一直等到亮屏才启动 daemon，故第二条路要等；
     * 调用方据此区分「看门狗还没轮到」与「新实例真的没起来」（见 {@code restartOnce}）。
     */
    private static String restartCore() {
        return "WD=\"$svcd/" + SCRIPT_NAME + "\"\n"
                // 1) 看门狗在不在：用 wd_pids（exe 判不出来——一切 shell 的 exe 都是 /system/bin/sh，
                //    改判「影像为 sh 且某个参数恰好等于候选脚本路径」，见 pidsPreamble）
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
                + "  nohup \"$BIN\" >> /data/local/tmp/tempctrl_service.log 2>&1 < /dev/null &\n"
                + "  sleep 2\n"
                + "  NEW_PID=$(bin_pids | head -1)\n"
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
                // $BIN 找，用 wd_pids（映像为 sh 且某个参数恰好等于候选脚本路径，见 pidsPreamble）。
                // 不先杀它，它下一轮 tick 就会把刚停掉的守护进程再拉起来，「停止」不成立。
                + killAndWaitSnippet("wd_pids", "WATCHDOG")
                + killAndWaitSnippet("bin_pids", "DAEMON");
    }

    /**
     * 「按 pid 停进程 + 轮询等它真退出」的 shell 片段——<b>停止序列的唯一出处</b>：
     * {@code kill}（SIGTERM）→ 轮询 ≤{@value #KILL_WAIT_LOOPS} 秒 → {@code kill -9}
     * → 再轮询 ≤{@value #KILL9_WAIT_LOOPS} 秒。等它真退出是必须的：C 端用非阻塞 {@code flock}
     * 做单实例锁，旧实例还在时新实例会立刻以退出码 {@value #EXIT_ALREADY_RUNNING} 退出。
     *
     * <p>目标 pid 由 {@code pidSource} 提供（{@code bin_pids} / {@code wd_pids}，见
     * {@link #pidsPreamble()}）：<b>不再用 {@code pkill -f}</b>——子串匹配会牵连无关进程，且"杀"
     * 与"等"会用两套判据。等待期内每轮重新取一次 pid 并再杀一遍（保留旧 {@code pkill} 的语义：
     * 等待期内新冒出来的同类进程也一并停掉）。
     *
     * <p>回吐 {@code <TAG>_PID} / {@code <TAG>_STOPPED} / {@code <TAG>_KILLED}；
     * PID 为空串表示本来就没在跑，此时 STOPPED=1（没在跑也算已停稳）。{@code <TAG>_PID} 取首次
     * 快照的第一个（供上屏与 {@code restartCore()} 的"新 PID 不得等于旧 PID"判据用）。
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
