package com.example.waspwingtempctrl.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 状态页「操作记录」的落盘归档：私有目录下的 {@code <files>/oplog/} 子目录，一次启动一个文件
 * （该次启动没有记录就不建文件）。
 *
 * <p><b>写入口径</b>：不依赖 {@code onDestroy} —— 记录产生的当下就写通落盘（进程被杀是常态），
 * 故「上一轮的记录」无需快照时机，杀进程时文件里已有全部内容。
 *
 * <p><b>淘汰口径</b>：全部归档文件合计 ≤ {@link #LIMIT_BYTES}，超限时从最旧端整份删除；
 * 最新一份永不被删 —— 单次启动的记录本身不截断，故单份自身超限时保留（此时合计会短暂超过上限）。
 * 文件名带本会话启动毫秒数，故「最旧」按落盘时间判定。
 *
 * <p>本类<b>不含任何 Android 类型</b>（只碰 {@link File}），可在 JVM 上直接验证。
 * 界面边界、提示行与文档见 逻辑说明.md §8.1。
 */
public final class OpLog {

    /** 归档子目录名（app 私有目录下）。 */
    public static final String DIR_NAME = "oplog";

    /** 归档文件扩展名。 */
    static final String EXT = ".log";

    /** 全部归档文件合计上限。 */
    public static final long LIMIT_BYTES = 64L * 1024L;

    private static volatile OpLog instance;

    /** 一次归档快照，供界面提示行渲染。 */
    public static final class Info {
        /** 归档目录。 */
        public final File dir;
        /** 归档文件份数。 */
        public final int count;
        /** 归档文件合计字节数。 */
        public final long bytes;
        /** 归档是否可用（目录可建、最近一次写入未失败）。 */
        public final boolean available;
        /** 不可用时的缘由（异常类型 + 短信息），可用时为空串。 */
        public final String reason;

        Info(File dir, int count, long bytes, boolean available, String reason) {
            this.dir = dir;
            this.count = count;
            this.bytes = bytes;
            this.available = available;
            this.reason = reason;
        }
    }

    private final File dir;
    private boolean sessionStarted;
    private long sessionStartMs;
    /** 本会话文件；惰性创建（首条记录时才建，故无记录不建文件）。 */
    private File sessionFile;
    /** 本次会话起点时既有归档的份数与字节（淘汰后缓存）；本会话文件的增量在 {@link #snapshot()} 里相加。 */
    private int baseCount;
    private long baseBytes;
    private boolean degraded;
    private String failureReason = "";

    private OpLog(File filesDir) {
        this.dir = new File(filesDir, DIR_NAME);
    }

    /** 进程内单例（归档目录随 app 固定，取一次即可）。 */
    public static OpLog get(File filesDir) {
        OpLog local = instance;
        if (local == null) {
            synchronized (OpLog.class) {
                local = instance;
                if (local == null) {
                    local = new OpLog(filesDir);
                    instance = local;
                }
            }
        }
        return local;
    }

    /** 每进程仅一次：建目录 → 淘汰到上限 → 记住本会话起点。失败只降级，不抛出。 */
    public void beginSession() {
        if (sessionStarted) {
            return;
        }
        sessionStarted = true;
        sessionStartMs = System.currentTimeMillis();
        try {
            ensureDir();
            evict();
            // 淘汰后把既有归档的份数/字节缓存下来：此后 snapshot() 不必重扫目录
            File[] remaining = list();
            baseCount = remaining.length;
            baseBytes = sum(remaining);
        } catch (Throwable t) {
            degrade(t);
        }
    }

    /** 追加一条记录并同步落盘。失败只降级，不抛出、不打断界面。 */
    public void append(String recordLine) {
        if (!sessionStarted) {
            beginSession();
        }
        try {
            if (sessionFile == null) {
                ensureDir();
                sessionFile = uniqueFile(sessionStartMs);
                write(sessionFile, "# 会话开始 " + fmt(sessionStartMs) + "\n", false);
            }
            write(sessionFile, recordLine + "\n", true);
            degraded = false;
            failureReason = "";
        } catch (Throwable t) {
            degrade(t);
        }
    }

    /** 当前归档快照（供提示行）。O(1)：用 {@link #beginSession()} 缓存的基数加本会话文件当前长度。 */
    public Info snapshot() {
        if (!sessionStarted) {
            // 尚未起会话（理论上界面不会走到）：退回实时扫描，宁可慢也不给错数
            File[] files = list();
            return new Info(dir, files.length, sum(files), !degraded, failureReason);
        }
        int count = baseCount + (sessionFile != null ? 1 : 0);
        long bytes = baseBytes + (sessionFile != null ? sessionFile.length() : 0L);
        return new Info(dir, count, bytes, !degraded, failureReason);
    }

    private static long sum(File[] files) {
        long total = 0L;
        for (File f : files) {
            total += f.length();
        }
        return total;
    }

    // ==================== 内部 ====================

    private void ensureDir() throws IOException {
        if (!dir.isDirectory() && !dir.mkdirs()) {
            throw new IOException("无法创建目录 " + dir.getAbsolutePath());
        }
    }

    /** 从最旧端整份删除，直到合计 ≤ 上限或只剩最新一份（最新一份永不被删）。 */
    private void evict() {
        File[] ordered = list();
        Arrays.sort(ordered, new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                int byTime = Long.compare(a.lastModified(), b.lastModified());
                return byTime != 0 ? byTime : a.getName().compareTo(b.getName());
            }
        });
        long total = 0L;
        for (File f : ordered) {
            total += f.length();
        }
        // 只遍历到倒数第二个：最后一份（最新）无论多大都保留
        for (int i = 0; i < ordered.length - 1; i++) {
            if (total <= LIMIT_BYTES) {
                break;
            }
            long size = ordered[i].length();
            if (ordered[i].delete()) {
                total -= size;
            }
        }
    }

    /** 归档文件（仅普通文件、按扩展名筛），按文件名升序返回（顺序确定，便于验证）。 */
    private File[] list() {
        File[] all = dir.listFiles();
        if (all == null) {
            return new File[0];
        }
        List<File> out = new ArrayList<>();
        for (File f : all) {
            if (f.isFile() && f.getName().endsWith(EXT)) {
                out.add(f);
            }
        }
        File[] arr = out.toArray(new File[0]);
        Arrays.sort(arr, new Comparator<File>() {
            @Override
            public int compare(File a, File b) {
                return a.getName().compareTo(b.getName());
            }
        });
        return arr;
    }

    /** 本会话文件名 {@code s<毫秒>.log}；撞名（同毫秒二次启动 / 时钟回拨）加 {@code -2/-3…} 保证不覆盖。 */
    private File uniqueFile(long epochMillis) {
        File f = new File(dir, "s" + epochMillis + EXT);
        int n = 2;
        while (f.exists()) {
            f = new File(dir, "s" + epochMillis + "-" + n + EXT);
            n++;
        }
        return f;
    }

    private static void write(File file, String text, boolean append) throws IOException {
        FileOutputStream out = new FileOutputStream(file, append);
        try {
            out.write(text.getBytes(StandardCharsets.UTF_8));
            out.flush();
        } finally {
            out.close();
        }
    }

    private void degrade(Throwable t) {
        degraded = true;
        String message = t.getClass().getSimpleName() + ": " + t.getMessage();
        failureReason = message.length() > 120 ? message.substring(0, 120) : message;
    }

    private static String fmt(long ms) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(ms));
    }
}
