package com.example.waspwingtempctrl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * root 通道封装。零第三方依赖，只用 {@link Runtime#exec(String[])}；做法照 Scene（{@code a/a70.java}）。
 *
 * <p><b>线程模型</b>：除 {@link #getSuCommand()}、{@link #getRecommendedSuCommand()}、
 * {@link #isSuCommandManual()}、{@link #isAlive()} 四个纯读缓存的方法外，其余公开方法都会阻塞 I/O，
 * <b>禁止在主线程调用</b>。
 *
 * <p>通道协议、超时与「脚本自退会被判成通道失败」—— 详见 app/逻辑说明.md §4.1。
 */
public final class RootShell {

    /** root 类型。UNKNOWN 表示 `su -v` 未能识别（或 su 不可用）。 */
    public enum SuType {
        MAGISK, KERNELSU, APATCH, UNKNOWN
    }

    // ---- 调优常量 ----
    private static final String PREFS = "root_shell";
    private static final String KEY_SU_CMD = "su_cmd";
    private static final String KEY_SU_TYPE = "su_type";

    private static final long DEFAULT_TIMEOUT_MS = 30_000L;
    private static final long SNIFF_TIMEOUT_MS = 5_000L;
    private static final long PROBE_TIMEOUT_MS = 8_000L;
    private static final long BACKOFF_MIN_MS = 1_000L;
    private static final long BACKOFF_MAX_MS = 60_000L;

    /** 后台 best-effort（{@link #tryExec}）的门禁：距最近一次交互式 {@code exec} 至少空闲这么久才取锁让路。 */
    private static final long BG_IDLE_MS = 5_000L;
    /** 后台 best-effort 取不到锁时最多等这么久（其间每 {@value #BG_RETRY_MS}ms 重试一次）后放弃本轮。 */
    private static final long BG_WAIT_MAX_MS = 60_000L;
    private static final long BG_RETRY_MS = 1_000L;

    /** root shell 里 PATH 的补充段（只追加，不覆盖 su 自带的 PATH）。 */
    private static final String PATH_SUFFIX = "/data/adb/magisk:/data/adb/ksu/bin:/data/adb/ap/bin";

    private static volatile RootShell instance;

    private final SharedPreferences prefs;
    private final AtomicInteger seq = new AtomicInteger();

    /** 串行锁：同一时刻只允许一个 su 会话。交互动作（{@code exec}/{@code checkAlive}）阻塞等待；后台用 tryLock。 */
    private final ReentrantLock execLock = new ReentrantLock();
    /** 最近一次交互式 {@code exec} 的时刻（毫秒）。{@link #tryExec} 据此给交互动作让路。 */
    private volatile long lastInteractiveAtMs;

    /** 嗅探结果缓存（持久化，重启后免重嗅探）。 */
    private volatile SuType suType = SuType.UNKNOWN;
    private volatile boolean suTypeDetected;

    /** 实测能跑通并拿到 uid=0 的命令；内存态，不持久化。 */
    private volatile String workingCommand;

    /** 判活缓存 + 退避窗口。 */
    private volatile boolean alive;
    private volatile int failures;
    private volatile long nextProbeAtMs;
    private volatile String lastError = "";

    private RootShell(Context context) {
        this.prefs = context.getApplicationContext()
                .getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        String cached = prefs.getString(KEY_SU_TYPE, null);
        if (cached != null) {
            try {
                suType = SuType.valueOf(cached);
                suTypeDetected = true;
            } catch (IllegalArgumentException ignored) {
                // 旧值不可识别 → 当作未探测
            }
        }
    }

    public static RootShell get(Context context) {
        RootShell local = instance;
        if (local == null) {
            synchronized (RootShell.class) {
                local = instance;
                if (local == null) {
                    local = new RootShell(context);
                    instance = local;
                }
            }
        }
        return local;
    }

    // ==================== 嗅探 / 选型 ====================

    /**
     * 执行 `su -v` 嗅探 root 类型并持久化。
     *
     * @param force true 时忽略缓存重新嗅探
     */
    public SuType detectSuType(boolean force) {
        if (!force && suTypeDetected) {
            return suType;
        }
        SuType detected = sniffSuType();
        suType = detected;
        suTypeDetected = true;
        prefs.edit().putString(KEY_SU_TYPE, detected.name()).apply();
        return detected;
    }

    /**
     * 按选型表推导的命令行（不含手动覆盖）。
     * SDK≥30 + KernelSU → `su -M`；SDK≥30 + APATCH → `magisk su -mm`；
     * SDK&lt;30 或 MAGISK/UNKNOWN → `su`。
     */
    public String getRecommendedSuCommand() {
        SuType type = suType;
        if (Build.VERSION.SDK_INT < 30) {
            return "su";
        }
        switch (type) {
            case KERNELSU:
                return "su -M";
            case APATCH:
                return "magisk su -mm";
            default:
                return "su";
        }
    }

    /** 当前生效的命令行：手动值优先，否则取 {@link #getRecommendedSuCommand()}。不阻塞。 */
    public String getSuCommand() {
        String manual = manualSuCommand();
        if (manual != null) {
            return manual;
        }
        return getRecommendedSuCommand();
    }

    /** 是否被用户手动覆盖过。不阻塞。 */
    public boolean isSuCommandManual() {
        return manualSuCommand() != null;
    }

    private String manualSuCommand() {
        String manual = prefs.getString(KEY_SU_CMD, "");
        if (manual == null || manual.trim().isEmpty()) {
            return null;
        }
        return manual.trim();
    }

    // ==================== 判活 ====================

    /** 判活缓存，不阻塞、不探测。 */
    public boolean isAlive() {
        return alive;
    }

    /**
     * 阻塞探测通道连通性（跑一次 `id` 并要求 uid=0），命中退避窗口时直接返回 false 不探测。
     * 自动模式下会依次尝试「选型命令 → 裸 `su`」，把跑通的那个记为 {@link #workingCommand}。
     */
    public boolean checkAlive() {
        execLock.lock();
        try {
            return checkAliveLocked();
        } finally {
            execLock.unlock();
        }
    }

    private boolean checkAliveLocked() {
        if (!alive && System.currentTimeMillis() < nextProbeAtMs) {
            return false;
        }
        detectSuType(false);

        for (String candidate : suCandidates()) {
            Result r = runOnce(candidate, "id", PROBE_TIMEOUT_MS);
            if (r.isOk() && r.stdout.contains("uid=0")) {
                workingCommand = candidate;
                markAlive();
                return true;
            }
            lastError = candidate + " → " + r.describe();
        }
        markDead();
        return false;
    }

    /**
     * 依次要尝试的 su 命令行：实测可用 → 当前推荐 → 裸 {@code su}（去重；被手动覆盖过则不追加裸 su）。
     * {@link #checkAlive()} 与 {@link #exec} 共用，保证"选型表推出来的命令不灵时还能退回裸 su" —
     * 这正是"通道在进程内坏掉只能重启 app"的恢复路径（缓存命令失效时不再卡死）。
     */
    private List<String> suCandidates() {
        List<String> candidates = new ArrayList<>();
        if (workingCommand != null) {
            candidates.add(workingCommand);
        }
        String primary = getSuCommand();
        if (!candidates.contains(primary)) {
            candidates.add(primary);
        }
        if (!isSuCommandManual() && !candidates.contains("su")) {
            candidates.add("su");
        }
        return candidates;
    }

    // ==================== 执行 ====================

    /** 用 root 通道执行脚本，默认超时 {@value #DEFAULT_TIMEOUT_MS} ms。 */
    public Result exec(String script) {
        return exec(script, DEFAULT_TIMEOUT_MS);
    }

    /**
     * 用 root 通道执行脚本（多行 sh 脚本，按行顺序在同一 shell 内执行）。
     * 脚本不得为空，也<b>不得包含 {@code exit}</b>（会导致结束标记丢失，判为通道失败）。
     * <b>不退避</b>：调用方显式要求执行就真执行；失败只更新退避窗口。
     *
     * <p><b>通道自愈</b>：按 {@link #suCandidates()} 依次尝试；<b>只在该命令"通道失败且非超时"时</b>换下一条
     * （脚本自己返回非 0 与超时都不换 —— 前者说明命令没问题、重跑是重复执行，后者换命令不会更快）。
     * 这也顺带清掉了"缓存的实测命令失效后 exec 永远失败"这一处无自愈路径。详见 app/逻辑说明.md §4.1、§4.2。
     */
    public Result exec(String script, long timeoutMs) {
        execLock.lock();
        try {
            detectSuType(false);
            Result last = null;
            for (String candidate : suCandidates()) {
                Result r = runOnce(candidate, script, timeoutMs);
                if (r.isOk()) {
                    workingCommand = candidate;
                    markAlive();
                    return r;
                }
                last = r;
                if (!r.channelFailed || r.timedOut) {
                    break;
                }
            }
            if (last != null && last.channelFailed) {
                markDead();
                lastError = last.command + " → " + last.describe();
            }
            if (last == null) {
                return Result.channelFailure(getSuCommand(), "无可用 su 命令", 0L);
            }
            return last;
        } finally {
            // 记"交互动作**结束**时刻"：若记开始时刻，一趟跑了 8s 的部署刚返回就会让后台任务
            // 立刻满足"空闲 ≥5s"，与紧随其后的拉起 daemon 抢锁。
            lastInteractiveAtMs = System.currentTimeMillis();
            execLock.unlock();
        }
    }

    /**
     * 后台 best-effort 执行（省电白名单这类"不影响动作结果"的收尾工作专用）。
     * 只在「串行锁空闲 <b>且</b> 距最近一次交互式 {@code exec} ≥{@value #BG_IDLE_MS}ms」时取锁执行 ——
     * 这条门禁保证它不会在"部署刚返回、界面紧接着要拉起 daemon"的空档里抢到锁、把交互动作堵在后面。
     * 取不到就每 {@value #BG_RETRY_MS}ms 重试，超过 {@value #BG_WAIT_MAX_MS}ms 放弃本轮（返回 {@code channelFailed}）。
     * <b>不改动 alive/退避状态</b>：后台失败不该污染交互路径的通道判断。
     */
    public Result tryExec(String script, long timeoutMs) {
        long deadline = System.currentTimeMillis() + BG_WAIT_MAX_MS;
        while (true) {
            if (System.currentTimeMillis() - lastInteractiveAtMs >= BG_IDLE_MS && execLock.tryLock()) {
                try {
                    detectSuType(false);
                    String command = workingCommand != null ? workingCommand : getSuCommand();
                    Result r = runOnce(command, script, timeoutMs);
                    if (r.isOk()) {
                        markAlive();
                    }
                    return r;
                } finally {
                    execLock.unlock();
                }
            }
            if (System.currentTimeMillis() >= deadline) {
                return Result.channelFailure(getSuCommand(),
                        "后台任务跳过：通道忙或交互动作仍在进行", 0L);
            }
            try {
                Thread.sleep(BG_RETRY_MS);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                return Result.channelFailure(getSuCommand(), "后台任务已取消", 0L);
            }
        }
    }

    /**
     * 复位进程内的通道状态：清掉「失败计数 + 退避窗口」与缓存的实测命令，让下一次 {@code exec}
     * 重新按推荐命令选型。用于<b>用户主动发起</b>的动作入口（部署 / 拉起）——语义是"现在就要，
     * 别被上一次的失败退避挡着"。这些状态都是内存态，故本方法等价于"用户重启 app"对通道的效果，
     * 只是不必真的重启。不会主动发起 su 往返（不触发授权框）。
     */
    public void resetChannel() {
        failures = 0;
        nextProbeAtMs = 0L;
        workingCommand = null;
    }

    // ==================== 诊断 ====================

    /** 诊断串（当前模式 / SU CMD / 通道状态 / 当前用户）。会阻塞探测一次。 */
    public String buildDiagnostics() {
        Result who;
        execLock.lock();
        try {
            who = runOnce(getSuCommand(), "id", PROBE_TIMEOUT_MS);
        } finally {
            execLock.unlock();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("模式: ").append(suType).append(suTypeDetected ? "（已探测）" : "（未探测）").append('\n');
        sb.append("SU CMD: ").append(getSuCommand())
                .append(isSuCommandManual() ? "（手动）" : "（自动）").append('\n');
        if (workingCommand != null) {
            sb.append("实测可用: ").append(workingCommand).append('\n');
        }
        sb.append("通道: ").append(who.isOk() ? "连通" : "不通").append('\n');
        sb.append("当前用户: ").append(who.isOk() ? who.stdout.trim() : "—").append('\n');
        sb.append("SDK: ").append(Build.VERSION.SDK_INT).append('\n');
        if (!lastError.isEmpty()) {
            sb.append("最近错误: ").append(lastError).append('\n');
        }
        if (!who.isOk()) {
            sb.append("本次探测: ").append(who.describe()).append('\n');
        }
        return sb.toString();
    }

    // ==================== 内部：嗅探 ====================

    private SuType sniffSuType() {
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"su", "-v"});
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8));
            // 结束标记：与 Scene 的写法一致
            writer.write("exit 0\nexit 0\n");
            writer.flush();
            writer.close();
            String out = readBounded(process.getInputStream(), SNIFF_TIMEOUT_MS);
            String upper = out.trim().toUpperCase(Locale.ROOT);
            if (upper.contains("MAGISK")) {
                return SuType.MAGISK;
            }
            if (upper.contains("KERNELSU")) {
                return SuType.KERNELSU;
            }
            if (upper.contains("APATCH")) {
                return SuType.APATCH;
            }
            return SuType.UNKNOWN;
        } catch (Exception e) {
            lastError = "su -v 嗅探失败: " + e.getMessage();
            return SuType.UNKNOWN;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    /** 有界读取：超时后放弃，返回已读到的部分。 */
    private static String readBounded(InputStream in, long timeoutMs) {
        final StringBuffer buffer = new StringBuffer();
        Thread reader = new Thread(() -> {
            try (BufferedReader r = new BufferedReader(
                    new InputStreamReader(in, StandardCharsets.UTF_8))) {
                char[] chunk = new char[512];
                int n;
                while ((n = r.read(chunk)) > 0) {
                    buffer.append(chunk, 0, n);
                }
            } catch (IOException ignored) {
                // 进程被 destroy 时正常出现
            }
        }, "ww-su-sniff");
        reader.setDaemon(true);
        reader.start();
        try {
            reader.join(timeoutMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return buffer.toString();
    }

    // ==================== 内部：通道 ====================

    private Channel openChannel(String command) throws IOException {
        String[] argv = command.trim().split("\\s+");
        Process process = Runtime.getRuntime().exec(argv);
        return new Channel(command, process, seq.incrementAndGet());
    }

    private Result runOnce(String command, String script, long timeoutMs) {
        long start = System.currentTimeMillis();
        Channel channel;
        try {
            channel = openChannel(command);
        } catch (IOException e) {
            markDead();
            return Result.channelFailure(command, "无法启动 su 进程: " + e.getMessage(),
                    System.currentTimeMillis() - start);
        }
        try {
            return channel.run(script, timeoutMs);
        } finally {
            channel.close();
        }
    }

    private void markAlive() {
        alive = true;
        failures = 0;
        nextProbeAtMs = 0L;
        lastError = "";
    }

    private void markDead() {
        alive = false;
        failures++;
        long delay = BACKOFF_MIN_MS << Math.min(failures - 1, 6);
        nextProbeAtMs = System.currentTimeMillis() + Math.min(delay, BACKOFF_MAX_MS);
    }

    // ==================== 内部：执行结果 ====================

    /** 一次执行的结果。{@code channelFailed} 为 true 表示 su 未授权 / 进程起不来 / 通道断 / 超时。 */
    public static final class Result {
        public final String command;
        public final int exitCode;
        public final String stdout;
        public final String stderr;
        public final boolean timedOut;
        public final long elapsedMs;
        public final boolean channelFailed;

        Result(String command, int exitCode, String stdout, String stderr,
               boolean timedOut, long elapsedMs, boolean channelFailed) {
            this.command = command;
            this.exitCode = exitCode;
            this.stdout = stdout;
            this.stderr = stderr;
            this.timedOut = timedOut;
            this.elapsedMs = elapsedMs;
            this.channelFailed = channelFailed;
        }

        static Result channelFailure(String command, String message, long elapsedMs) {
            return new Result(command, -1, "", message, false, elapsedMs, true);
        }

        /** 通道正常且退出码为 0。 */
        public boolean isOk() {
            return !channelFailed && exitCode == 0;
        }

        public String describe() {
            if (channelFailed && !timedOut && exitCode < 0 && !stderr.isEmpty()) {
                return stderr + "（" + elapsedMs + "ms）";
            }
            String head = timedOut ? "超时" : "退出码 " + exitCode;
            String tail = stderr.trim();
            return head + "（" + elapsedMs + "ms）" + (tail.isEmpty() ? "" : " " + tail);
        }
    }

    // ==================== 内部：通道实现 ====================

    /**
     * su 进程 + 双流收割线程 + 结束标记协议。
     * 脚本写入 stdin，末尾追加 `echo "<marker> $?"`；读取端扫到该行即拿到退出码。
     */
    private static final class Channel {

        private final String command;
        private final Process process;
        private final BufferedWriter stdin;
        private final String marker;
        private final LinkedBlockingQueue<String> stdout = new LinkedBlockingQueue<>();
        private final LinkedBlockingQueue<String> stderr = new LinkedBlockingQueue<>();
        private volatile boolean stdoutEof;
        private volatile boolean stderrEof;

        Channel(String command, Process process, int id) throws IOException {
            this.command = command;
            this.process = process;
            this.marker = "__WW_END_" + id + "__";
            this.stdin = new BufferedWriter(
                    new OutputStreamWriter(process.getOutputStream(), StandardCharsets.UTF_8));
            startGobbler(process.getInputStream(), stdout, () -> stdoutEof = true);
            startGobbler(process.getErrorStream(), stderr, () -> stderrEof = true);
            try {
                // 只追加，不覆盖 su 自带 PATH
                stdin.write("export PATH=\"$PATH:" + PATH_SUFFIX + "\"\n");
                stdin.flush();
            } catch (IOException e) {
                close();
                throw e;
            }
        }

        private void startGobbler(InputStream in, LinkedBlockingQueue<String> sink, Runnable onEof) {
            Thread t = new Thread(() -> {
                try (BufferedReader r = new BufferedReader(
                        new InputStreamReader(in, StandardCharsets.UTF_8))) {
                    String line;
                    while ((line = r.readLine()) != null) {
                        sink.offer(line);
                    }
                } catch (IOException ignored) {
                    // 进程结束时正常出现
                } finally {
                    if (onEof != null) {
                        onEof.run();
                    }
                }
            }, "ww-su-gobbler");
            t.setDaemon(true);
            t.start();
        }

        /** 双流都 EOF 才算通道断开；只看一路会在进程仍活着时误判。 */
        boolean isDead() {
            return stdoutEof && stderrEof;
        }

        Result run(String script, long timeoutMs) {
            long start = System.currentTimeMillis();
            StringBuilder out = new StringBuilder();
            StringBuilder err = new StringBuilder();
            boolean timedOut = false;
            int exitCode = -1;

            try {
                stdin.write(script);
                stdin.write('\n');
                stdin.write("echo \"" + marker + " $?\"\n");
                stdin.flush();
            } catch (IOException e) {
                drainTo(stderr, err);
                return new Result(command, -1, out.toString(), "写入 su 通道失败: " + e.getMessage(),
                        false, System.currentTimeMillis() - start, true);
            }

            long deadline = start + timeoutMs;
            while (true) {
                long remain = deadline - System.currentTimeMillis();
                if (remain <= 0) {
                    timedOut = true;
                    break;
                }
                String line;
                try {
                    line = stdout.poll(remain, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    timedOut = true;
                    break;
                }
                if (line == null) {
                    if (isDead()) {
                        break;      // 通道断开且没拿到结束标记
                    }
                    timedOut = true;
                    break;
                }
                if (line.startsWith(marker)) {
                    exitCode = parseExitCode(line.substring(marker.length()).trim());
                    break;
                }
                out.append(line).append('\n');
            }

            if (timedOut) {
                // 超时只 destroy() 会留下"客户端已死、su 会话可能仍在设备侧跑"的窗口：
                // 先给 500ms 收尾，仍在就 destroyForcibly()（SIGKILL），尽早把会话槽位还回去。
                process.destroy();
                try {
                    if (!process.waitFor(500L, TimeUnit.MILLISECONDS)) {
                        process.destroyForcibly();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    process.destroyForcibly();
                }
            }
            drainTo(stdout, out);
            drainTo(stderr, err);

            boolean channelFailed = timedOut || exitCode < 0;
            return new Result(command, exitCode, out.toString(), err.toString(),
                    timedOut, System.currentTimeMillis() - start, channelFailed);
        }

        private static int parseExitCode(String text) {
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                return -1;
            }
        }

        private static void drainTo(LinkedBlockingQueue<String> queue, StringBuilder sink) {
            List<String> tmp = new ArrayList<>();
            queue.drainTo(tmp);
            for (String line : tmp) {
                sink.append(line).append('\n');
            }
        }

        void close() {
            try {
                stdin.write("exit\n");
                stdin.flush();
            } catch (IOException ignored) {
                // 通道已断
            }
            try {
                stdin.close();
            } catch (IOException ignored) {
                // 忽略
            }
            process.destroy();
        }
    }
}
