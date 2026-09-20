package com.example.waspwingtempctrl;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>I4（已冻结）：部署完成判定</b> + <b>I5 的一半：界面 ↔ 部署的调用边界</b>。
 *
 * <p>界面（线 D）只允许调本类的 {@link #probe()}、{@link #deploy()}、{@link #uninstall()}、
 * {@link #startDaemon()}、{@link #buildDiagnostics()}，<b>不得自己拼 shell、不得直接碰文件</b>。
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
 * 本类不拼 {@code Runtime.exec("su ...")}。除 {@link #isRunning()} 之外全部方法阻塞，
 * <b>禁止在主线程调用</b>。
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

    private static final long START_COOLDOWN_MS = 10_000L;
    private static final long KILL_WAIT_LOOPS = 30L;
    private static final long EXEC_TIMEOUT_MS = 120_000L;

    private static volatile Deployer instance;

    private final Context appContext;
    private final RootShell shell;
    private final ConfigStore configStore;

    /** 拉起冷却（内存态，进程重启即失效）。 */
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

    // ==================== 状态 / 判定 ====================

    /** 部署状态（{@link #describe()} 直接可显示）。 */
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
        /** 各步骤的原始输出（诊断用）。 */
        public final String rawOutput;
        /** 配置文件绝对路径（app 侧）。 */
        public final String configPath;
        public final List<String> notes;

        Status(boolean suOk, boolean binExists, boolean binExecutable, boolean binHashOk,
               String binMd5, String binExpectedMd5, String scriptPath, boolean scriptPresent,
               boolean scriptHashOk, String scriptMd5, String scriptExpectedMd5,
               boolean configPresent, boolean configPathAligned, boolean daemonRunning,
               boolean deployed, String rawOutput, String configPath, List<String> notes) {
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
            this.rawOutput = rawOutput;
            this.configPath = configPath;
            this.notes = Collections.unmodifiableList(notes);
        }

        public String describe() {
            StringBuilder sb = new StringBuilder();
            // 「无 su」紧跟部署状态：它是部署未完成最常见的原因，单列一行容易被当成另一件事
            sb.append("部署状态：").append(deployed ? "已完成" : "未完成")
                    .append(suOk ? "" : "（无 su）").append('\n');
            sb.append("  二进制 ").append(BIN_DEST).append("：")
                    .append(!binExists ? "不存在" : (binExecutable ? "存在且可执行" : "存在但不可执行"))
                    .append(binHashOk ? "，哈希一致" : "，哈希不一致")
                    .append('\n');
            // 两组哈希各占两行：并排时位数一多就无法逐位比对
            if (!binExpectedMd5.isEmpty()) {
                sb.append("    apk  = ").append(binExpectedMd5).append('\n');
                sb.append("    设备 = ").append(binMd5.isEmpty() ? "—" : binMd5).append('\n');
            }
            sb.append("  service.d 脚本：")
                    .append(scriptPresent ? scriptPath : "未安装")
                    .append(scriptPresent && !scriptHashOk ? "（哈希不一致）" : "").append('\n');
            if (scriptPresent && !scriptExpectedMd5.isEmpty()) {
                sb.append("    apk  = ").append(scriptExpectedMd5).append('\n');
                sb.append("    设备 = ").append(scriptMd5.isEmpty() ? "—" : scriptMd5).append('\n');
            }
            sb.append("  配置 ").append(configPath).append("：")
                    .append(configPresent ? "已存在" : "不存在（守护进程将用代码默认值）")
                    .append(configPathAligned ? "" : "，且与 C 端落点不一致").append('\n');
            sb.append("  守护进程：").append(daemonRunning ? "运行中" : "未运行").append('\n');
            for (String note : notes) {
                sb.append("  提示：").append(note).append('\n');
            }
            return sb.toString();
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

        RootShell.Result r = shell.exec(probeScript(), EXEC_TIMEOUT_MS);
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
                deployed, r.stdout, configStore.getConfigFile().getAbsolutePath(), notes);
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
        public final String rawOutput;
        public final Status status;

        Result(boolean ok, String action, List<String> steps, String error,
               String rawOutput, Status status) {
            this.ok = ok;
            this.action = action;
            this.steps = Collections.unmodifiableList(steps);
            this.error = error;
            this.rawOutput = rawOutput;
            this.status = status;
        }

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
     * 一次性部署：资源落盘与授权 → 二进制就位 → service.d 脚本 → 省电白名单 → 配置保留写入。
     *
     * <p><b>配置保留</b>：{@code profile.conf} 不存在时才写出厂值（取自 params.json 的
     * {@code factory}），已存在则一个字都不覆盖。
     *
     * <p>任一硬步骤失败即返回 {@code ok=false}（配置与白名单失败不算硬失败，记在 steps 里）。
     * <b>阻塞</b>（root 往返 2 次 + 落盘）。
     */
    public Result deploy() {
        List<String> steps = new ArrayList<>();
        StringBuilder raw = new StringBuilder();

        File stagedBin;
        File stagedScript;
        String binMd5;
        String scriptMd5;
        try {
            File staging = new File(configStore.getPrivateDir(), "deploy");
            if (!staging.isDirectory() && !staging.mkdirs()) {
                return new Result(false, "部署", steps, "私有目录中转目录创建失败：" + staging, "", null);
            }
            stagedBin = new File(staging, "tempctrl");
            stagedScript = new File(staging, SCRIPT_NAME);
            binMd5 = stageAsset(BIN_ASSET, stagedBin, true);
            steps.add("二进制已落到私有目录并授权：" + stagedBin + "（md5=" + binMd5 + "）");
            scriptMd5 = stageAsset(SCRIPT_ASSET, stagedScript, true);
            steps.add("脚本已落到私有目录并授权：" + stagedScript + "（md5=" + scriptMd5 + "）");
        } catch (IOException e) {
            return new Result(false, "部署", steps, e.getMessage(), "", null);
        }

        RootShell.Result r = shell.exec(deployScript(stagedBin, stagedScript), EXEC_TIMEOUT_MS);
        raw.append(r.stdout);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "部署", steps, "root 执行失败：" + r.describe(), raw.toString(), null);
        }
        String svcd = nvl(kv.get("SVCD"));
        String ksuVer = nvl(kv.get("KSU_VER"));
        steps.add("service.d 目录：" + svcd + (ksuVer.isEmpty() ? "" : "（KernelSU verCode=" + ksuVer + "）"));
        if (svcd.isEmpty()) {
            return new Result(false, "部署", steps, "未能确定 service.d 目录", raw.toString(), null);
        }
        if (!"1".equals(kv.get("BIN_OK"))) {
            return new Result(false, "部署", steps,
                    "二进制就位失败（" + BIN_DEST + "），root 侧输出见原始输出", raw.toString(), null);
        }
        steps.add("二进制就位：" + BIN_DEST);
        if (!"1".equals(kv.get("SCRIPT_OK"))) {
            return new Result(false, "部署", steps,
                    "service.d 脚本写入失败（" + svcd + "）", raw.toString(), null);
        }
        steps.add("service.d 脚本就位：" + svcd + "/" + SCRIPT_NAME);
        String deployedBinMd5 = nvl(kv.get("BIN_MD5"));
        String deployedScriptMd5 = nvl(kv.get("SCRIPT_MD5"));
        if (!binMd5.equals(deployedBinMd5) || !scriptMd5.equals(deployedScriptMd5)) {
            return new Result(false, "部署", steps,
                    "落盘内容与 APK 内资源不一致（apk=" + binMd5 + "/" + scriptMd5
                            + "，设备=" + deployedBinMd5 + "/" + deployedScriptMd5 + "）",
                    raw.toString(), null);
        }
        steps.add("内容哈希核对通过（二进制与脚本均与 APK 内一致）");

        ConfigStore.WriteResult cfg = configStore.writeFactoryIfAbsent();
        steps.add(cfg.describe());
        steps.add(preCreateRuntimeFiles());

        RootShell.Result pr = shell.exec(powerAllowlistScript(), EXEC_TIMEOUT_MS);
        raw.append("\n[省电白名单]\n").append(pr.stdout).append(pr.stderr);
        steps.add(pr.isOk() ? "省电白名单批处理已下发（输出见原始输出）"
                : "省电白名单下发失败（不影响部署）：" + pr.describe());

        Status st = probe();
        return new Result(st.deployed, "部署", steps, st.deployed ? "" : "部署后自检未通过", raw.toString(), st);
    }

    /**
     * 只重推 service.d 脚本：不动二进制、不重启守护进程、不碰配置。<b>阻塞</b>（root 往返 1 次）。
     *
     * <p>用途：{@link #probe()} 发现设备上的脚本与 APK 内资源哈希不一致时自动纠正。脚本是纯文本、
     * 无运行态，重推无损；二进制若不一致仍须走完整 {@link #deploy()}（重推会重启守护进程，代价高得多）。
     */
    public Result updateScript() {
        List<String> steps = new ArrayList<>();
        File staging = new File(configStore.getPrivateDir(), "deploy");
        if (!staging.isDirectory() && !staging.mkdirs()) {
            return new Result(false, "更新脚本", steps, "私有目录中转目录创建失败：" + staging, "", null);
        }
        File stagedScript = new File(staging, SCRIPT_NAME);
        String scriptMd5;
        try {
            scriptMd5 = stageAsset(SCRIPT_ASSET, stagedScript, true);
        } catch (IOException e) {
            return new Result(false, "更新脚本", steps, e.getMessage(), "", null);
        }
        steps.add("脚本已落到私有目录并授权：" + stagedScript + "（md5=" + scriptMd5 + "）");

        RootShell.Result r = shell.exec(updateScriptScript(stagedScript), EXEC_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "更新脚本", steps, "root 执行失败：" + r.describe(), r.stdout, null);
        }
        String svcd = nvl(kv.get("SVCD"));
        if (svcd.isEmpty()) {
            return new Result(false, "更新脚本", steps, "未能确定 service.d 目录", r.stdout, null);
        }
        steps.add("service.d 目录：" + svcd);
        if (!"1".equals(kv.get("SCRIPT_OK"))) {
            return new Result(false, "更新脚本", steps, "脚本写入失败（" + svcd + "）", r.stdout, null);
        }
        String onDevice = nvl(kv.get("SCRIPT_MD5"));
        if (!scriptMd5.equals(onDevice)) {
            return new Result(false, "更新脚本", steps,
                    "落盘脚本与 APK 内资源不一致（apk=" + scriptMd5 + "，设备=" + onDevice + "）",
                    r.stdout, null);
        }
        steps.add("脚本哈希核对通过：" + svcd + "/" + SCRIPT_NAME);
        return new Result(true, "更新脚本", steps, "", r.stdout, null);
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
     *   <li>省电白名单（deviceidle / appops / standby bucket）—— 对仍装着的 LSPosed 模块同样有益，
     *       且用户可在系统设置里自行撤销。</li>
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
            return new Result(false, "卸载部署", steps, "root 执行失败：" + r.describe(),
                    r.stdout + r.stderr, null);
        }
        boolean watchdogStopped = "1".equals(kv.get("WATCHDOG_STOPPED"));
        boolean daemonStopped = "1".equals(kv.get("STOPPED"));
        steps.add(watchdogStopped
                ? "已停止看门狗 shell（先于守护进程杀，否则它会重建日志并把守护进程再拉起来）"
                : "警告：30 秒内未能确认看门狗 shell 已退出（脚本自身的自尽自检会在下一轮兜底）");
        if (daemonStopped) {
            steps.add("已停止运行中的 tempctrl");
        } else {
            steps.add("警告：30 秒内未能确认 tempctrl 已退出，锁文件暂不删除（避免绕过单实例锁）");
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
        return new Result(!st.deployed, "卸载部署", steps, "", r.stdout + r.stderr, st);
    }

    // ==================== 拉起（界面手动入口） ====================

    /**
     * 手动拉起守护进程（界面入口）。先判活、再冷却，然后直接执行启动命令，
     * 由 C 端单实例锁兜底幂等（已有实例时新实例返回退出码 {@value #EXIT_ALREADY_RUNNING}）。
     *
     * <p><b>阻塞</b>。注意：这条路起的进程仍在该 app 的 cgroup 内，
     * 常驻仍以 {@code service.d} 为主（见 {@link #deploy()}）。
     */
    public Result startDaemon() {
        List<String> steps = new ArrayList<>();
        if (isRunning()) {
            steps.add("守护进程已在运行，无需拉起");
            return new Result(true, "拉起", steps, "", "", probe());
        }
        long now = System.currentTimeMillis();
        if (now - lastStartAtMs < START_COOLDOWN_MS) {
            long remain = (START_COOLDOWN_MS - (now - lastStartAtMs)) / 1000;
            steps.add("冷却中，请 " + remain + " 秒后重试");
            return new Result(false, "拉起", steps, "冷却中", "", null);
        }
        lastStartAtMs = now;
        RootShell.Result r = shell.exec(startScript(), EXEC_TIMEOUT_MS);
        Map<String, String> kv = parseKv(r.stdout);
        if (!r.isOk()) {
            return new Result(false, "拉起", steps, "root 执行失败：" + r.describe(),
                    r.stdout + r.stderr, null);
        }
        if ("1".equals(kv.get("NOBIN"))) {
            return new Result(false, "拉起", steps, "二进制不存在（需先部署）：" + BIN_DEST,
                    r.stdout, null);
        }
        if ("1".equals(kv.get("ALREADY"))) {
            steps.add("探测到已有实例在运行");
            return new Result(true, "拉起", steps, "", r.stdout, probe());
        }
        boolean started = "1".equals(kv.get("STARTED"));
        steps.add(started ? "已拉起并确认存活（已 renice -20）"
                : "启动命令已执行但未探测到进程（退出码 2 = 已有实例在跑）");
        return new Result(started, "拉起", steps, started ? "" : "未探测到进程", r.stdout, probe());
    }

    /** 守护进程是否在运行（非缓存，阻塞；root 往返一次）。 */
    public boolean isRunning() {
        RootShell.Result r = shell.exec("pgrep -f " + BIN_DEST + " > /dev/null 2>&1 && echo RUN=1 || echo RUN=0\n", 15_000L);
        return "1".equals(parseKv(r.stdout).get("RUN"));
    }

    /** 诊断串：部署状态 + 配置状态 + root 诊断。阻塞。 */
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

    /** 删私有目录里的运行时产物；返回删除成功的文件名。{@code profile.conf} 不在列（用户配置）。 */
    private List<String> cleanPrivateRuntime() {
        List<String> removed = new ArrayList<>();
        String[] names = {"tempctrl.lock", "tempctrl.log", "tempctrl_webui.data"};
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

    private String probeScript() {
        return "BIN=" + BIN_DEST + "\n"
                + "[ -e \"$BIN\" ] && echo BIN_EXISTS=1 || echo BIN_EXISTS=0\n"
                + "[ -x \"$BIN\" ] && echo BIN_EXEC=1 || echo BIN_EXEC=0\n"
                + "if command -v md5sum > /dev/null 2>&1; then echo MD5TOOL=1; else echo MD5TOOL=0; fi\n"
                + "echo \"BIN_MD5=$(md5sum \"$BIN\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + "for d in " + SERVICE_D_KSU_LEGACY + " " + SERVICE_D_MODERN + "; do\n"
                + "  f=\"$d/" + SCRIPT_NAME + "\"\n"
                + "  if [ -f \"$f\" ]; then echo \"SCRIPT=$f\"; echo \"SCRIPT_MD5=$(md5sum \"$f\" 2>/dev/null | cut -d' ' -f1)\"; fi\n"
                + "done\n"
                + "pgrep -f \"$BIN\" > /dev/null 2>&1 && echo RUNNING=1 || echo RUNNING=0\n";
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

    /** 把脚本装到 $svcd 并回吐 SCRIPT_OK 的片段（部署与单独更新脚本共用）。 */
    private static String scriptInstallSnippet(File stagedScript) {
        return "cp -f " + quote(stagedScript.getAbsolutePath()) + " \"$svcd/" + SCRIPT_NAME + "\" "
                + "&& chmod 0755 \"$svcd/" + SCRIPT_NAME + "\" && echo SCRIPT_OK=1 || echo SCRIPT_OK=0\n";
    }

    /** 只重推脚本时的 shell（完全不碰 $BIN）。 */
    private String updateScriptScript(File stagedScript) {
        return serviceDirPreamble()
                + "mkdir -p \"$svcd\" 2>&1\n"
                + scriptInstallSnippet(stagedScript)
                + "echo \"SCRIPT_MD5=$(md5sum \"$svcd/" + SCRIPT_NAME + "\" 2>/dev/null | cut -d' ' -f1)\"\n";
    }

    private String deployScript(File stagedBin, File stagedScript) {
        return "BIN=" + BIN_DEST + "\n"
                + serviceDirPreamble()
                + "mkdir -p \"$svcd\" 2>&1\n"
                + "cp -f " + quote(stagedBin.getAbsolutePath()) + " \"$BIN\" && chmod 0755 \"$BIN\" "
                + "&& echo BIN_OK=1 || echo BIN_OK=0\n"
                + scriptInstallSnippet(stagedScript)
                + "echo \"BIN_MD5=$(md5sum \"$BIN\" 2>/dev/null | cut -d' ' -f1)\"\n"
                + "echo \"SCRIPT_MD5=$(md5sum \"$svcd/" + SCRIPT_NAME + "\" 2>/dev/null | cut -d' ' -f1)\"\n";
    }

    private String powerAllowlistScript() {
        String pkg = appContext.getPackageName();
        return "PKG=" + pkg + "\n"
                + "echo \"-- deviceidle --\"; dumpsys deviceidle whitelist +$PKG 2>&1\n"
                + "echo \"-- appops --\"; appops set $PKG RUN_IN_BACKGROUND allow 2>&1\n"
                + "echo \"-- standby --\"; am set-standby-bucket $PKG active 2>&1\n"
                + "echo \"-- unfreeze --\"; am unfreeze --sticky $PKG 2>&1 || am unfreeze $PKG 2>&1\n";
    }

    private String uninstallScript() {
        return "BIN=" + BIN_DEST + "\n"
                // 1) 先杀看门狗 shell：它的 cmdline 是本脚本路径、不含 $BIN，只 pkill $BIN 抓不到它。
                //    不先杀它，它下一轮 tick 会把刚删掉的日志文件重建出来，还可能把守护进程再拉起来。
                + "pkill -f " + SCRIPT_NAME + " 2>/dev/null\n"
                + "i=0\n"
                + "while [ $i -lt " + KILL_WAIT_LOOPS + " ]; do\n"
                + "  pgrep -f " + SCRIPT_NAME + " > /dev/null 2>&1 || break\n"
                + "  sleep 1\n"
                + "  i=$((i + 1))\n"
                + "done\n"
                + "pgrep -f " + SCRIPT_NAME + " > /dev/null 2>&1 && echo WATCHDOG_STOPPED=0 || echo WATCHDOG_STOPPED=1\n"
                // 2) 再杀守护进程并轮询等它真退出
                + "pkill -f \"$BIN\" 2>/dev/null\n"
                + "i=0\n"
                + "while [ $i -lt " + KILL_WAIT_LOOPS + " ]; do\n"
                + "  pgrep -f \"$BIN\" > /dev/null 2>&1 || break\n"
                + "  sleep 1\n"
                + "  i=$((i + 1))\n"
                + "done\n"
                + "pgrep -f \"$BIN\" > /dev/null 2>&1 && echo STOPPED=0 || echo STOPPED=1\n"
                // 3) 两个进程都停稳后再删文件
                + "rm -f " + SERVICE_D_MODERN + "/" + SCRIPT_NAME + "\n"
                + "rm -f " + SERVICE_D_KSU_LEGACY + "/" + SCRIPT_NAME + "\n"
                + "rm -f \"$BIN\"\n"
                + "# 旧版迁移残留：C 端锁文件已迁到私有目录（tempctrl.lock，由 app 侧在确认进程退出后清）。\n"
                + "# 这里删的是老版本留在 /data/local/tmp 的那一份，不是重复代码，别删这一行。\n"
                + "rm -f /data/local/tmp/tempctrl.lock\n"
                + "rm -f /data/local/tmp/tempctrl_b6x.status\n"
                + "rm -f /data/local/tmp/tempctrl_b7x.status\n"
                + "rm -f /data/local/tmp/tempctrl_service.log\n"
                + "# 旧版迁移残留：老版本把 tempctrl_last_dev 放在这里（daemon 侧的预创建已删、现已无人读写），\n"
                + "# 它不会自己消失，故卸载时一并清掉。\n"
                + "# 与新落点区分：新落点是飞智 app 自己的私有目录（各包各记），不属本次部署产物，本脚本不碰。\n"
                + "rm -f /data/local/tmp/tempctrl_last_dev\n"
                + "# 私有目录不可用时守护进程的兜底日志落点（/cache/<二进制名>.log），可能残留\n"
                + "rm -f /cache/tempctrl.log\n";
    }

    private String startScript() {
        return "BIN=" + BIN_DEST + "\n"
                + "if pgrep -f \"$BIN\" > /dev/null 2>&1; then\n"
                + "  echo ALREADY=1\n"
                + "elif [ ! -x \"$BIN\" ]; then\n"
                + "  echo NOBIN=1\n"
                + "else\n"
                + "  nohup \"$BIN\" >> /data/local/tmp/tempctrl_service.log 2>&1 < /dev/null &\n"
                + "  sleep 2\n"
                + "  if pgrep -f \"$BIN\" > /dev/null 2>&1; then\n"
                + "    pid=$(pgrep -f \"$BIN\" | head -1)\n"
                + "    renice -n -20 -p \"$pid\" > /dev/null 2>&1\n"
                + "    echo STARTED=1\n"
                + "  else\n"
                + "    echo STARTED=0\n"
                + "  fi\n"
                + "fi\n";
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

    /** 只读探针：读 {@link #BIN_DEST} 内容需要 root，界面侧不要用。 */
    static byte[] readAll(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream(8192);
            byte[] buf = new byte[8192];
            int n;
            while ((n = in.read(buf)) > 0) {
                out.write(buf, 0, n);
            }
            return out.toByteArray();
        } finally {
            closeQuietly(in);
        }
    }
}
