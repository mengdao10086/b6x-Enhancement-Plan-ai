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

/**
 * root 通道封装。零第三方依赖，只用 {@link Runtime#exec(String[])}。
 *
 * <p>做法照 Scene（`a/a70.java`）：`su -v` 嗅探 → 命令行选型 → 持久化 →
 * 判活看通道连通性（不看进程）→ 退避重连。改进项：结束标记 + 读超时 + 退出码回传。
 *
 * <p><b>线程模型</b>：除 {@link #getSuCommand()}、{@link #getRecommendedSuCommand()}、
 * {@link #isSuCommandManual()}、{@link #isAlive()} 这四个纯读缓存的方法外，其余公开方法都会阻塞 I/O，
 * <b>禁止在主线程调用</b>。
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

    /** root shell 里 PATH 的补充段（只追加，不覆盖 su 自带的 PATH）。 */
    private static final String PATH_SUFFIX = "/data/adb/magisk:/data/adb/ksu/bin:/data/adb/ap/bin";

    private static volatile RootShell instance;

    private final SharedPreferences prefs;
    private final AtomicInteger seq = new AtomicInteger();

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
        if (!alive && System.currentTimeMillis() < nextProbeAtMs) {
            return false;
        }
        detectSuType(false);

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

        for (String candidate : candidates) {
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

    // ==================== 执行 ====================

    /** 用 root 通道执行脚本，默认超时 {@value #DEFAULT_TIMEOUT_MS} ms。 */
    public Result exec(String script) {
        return exec(script, DEFAULT_TIMEOUT_MS);
    }

    /**
     * 用 root 通道执行脚本（多行 sh 脚本，按行顺序在同一 shell 内执行）。
     * 脚本不得为空，也不得包含 `exit`（会导致结束标记丢失，判为通道失败）。
     *
     * <p>不退避：调用方显式要求执行就真执行；失败会更新退避窗口，供 {@link #checkAlive()} 使用。
     */
    public Result exec(String script, long timeoutMs) {
        detectSuType(false);
        String command = workingCommand != null ? workingCommand : getSuCommand();
        Result r = runOnce(command, script, timeoutMs);
        if (r.isOk()) {
            markAlive();
        } else if (r.channelFailed) {
            markDead();
            lastError = command + " → " + r.describe();
        }
        return r;
    }

    // ==================== 诊断 ====================

    /** 诊断串（当前模式 / SU CMD / 通道状态 / 当前用户）。会阻塞探测一次。 */
    public String buildDiagnostics() {
        Result who = runOnce(getSuCommand(), "id", PROBE_TIMEOUT_MS);
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
                process.destroy();
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
