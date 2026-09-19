package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.system.ErrnoException;
import android.system.Os;
import android.system.StructStat;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 界面直读守护进程产物的统一入口（曲线数据 / 日志页共用）。
 *
 * <p><b>不需要 root</b>：两个数据文件都落在 app 私有目录，同 uid 普通 File IO 即可读。
 *
 * <p><b>但这是一个未真机验证的假设</b>：文件由 <b>root 的守护进程</b>创建，SELinux 标签层面 app 能否直读
 * 尚未验证。因此本类<b>不吞异常</b>：读取失败一律抛出带「路径 + 异常类型 + errno 文案」的
 * {@link IOException}，界面必须把 {@link #diagnose(File)} 的结果原样展示，不许静默留白。
 *
 * <p>本类不做任何 root 读取兜底（先用直读，真机验证后再说）。
 */
public final class AppFiles {

    /** 守护进程日志文件名（C 端私有目录内固定名）。 */
    public static final String LOG_NAME = "tempctrl.log";
    /** 曲线时序数据文件名（C 端 write_webui_data 落盘）。 */
    public static final String DATA_NAME = "tempctrl_webui.data";

    private AppFiles() {
    }

    /** app 侧私有目录（{@code /data/data/<包名>/files}）。 */
    public static File privateDir(Context context) {
        return context.getFilesDir();
    }

    public static File logFile(Context context) {
        return new File(privateDir(context), LOG_NAME);
    }

    public static File dataFile(Context context) {
        return new File(privateDir(context), DATA_NAME);
    }

    /** 一次探测的原始结果，不抛异常（供诊断串使用）。 */
    public static final class Probe {
        public final File file;
        public final String path;
        /** stat(2) 是否成功。false 时 {@link #errnoText} 有值。 */
        public final boolean statOk;
        public final long size;
        public final long mtimeMs;
        public final boolean isFile;
        public final boolean canRead;
        /** stat 失败时的 errno 文案，如 {@code EACCES (Permission denied)}；成功时为空串。 */
        public final String errnoText;

        Probe(File file, boolean statOk, long size, long mtimeMs, boolean isFile, boolean canRead,
              String errnoText) {
            this.file = file;
            this.path = file.getAbsolutePath();
            this.statOk = statOk;
            this.size = size;
            this.mtimeMs = mtimeMs;
            this.isFile = isFile;
            this.canRead = canRead;
            this.errnoText = errnoText;
        }

        /** 文件可读且非空 → 可以尝试读内容。 */
        public boolean usable() {
            return statOk && isFile && canRead && size > 0;
        }
    }

    /**
     * 探测文件状态。用 {@code Os.stat} 而不是 {@code File.exists()}，因为前者能给出<b>真实 errno</b>
     * （{@code File.exists()} 把「权限不足」和「不存在」都吞成 false，无法诊断）。
     */
    public static Probe probe(File file) {
        try {
            StructStat st = Os.stat(file.getAbsolutePath());
            boolean isFile = (st.st_mode & android.system.OsConstants.S_IFMT)
                    == android.system.OsConstants.S_IFREG;
            return new Probe(file, true, st.st_size, st.st_mtime * 1000L, isFile,
                    file.canRead(), "");
        } catch (ErrnoException e) {
            return new Probe(file, false, -1L, 0L, false, file.canRead(),
                    "errno=" + e.errno + " (" + safeStrerror(e.errno) + ")");
        } catch (Throwable t) {
            return new Probe(file, false, -1L, 0L, false, file.canRead(),
                    t.getClass().getSimpleName() + ": " + t.getMessage());
        }
    }

    private static String safeStrerror(int errno) {
        try {
            return Os.strerror(errno);
        } catch (Throwable t) {
            return "未知";
        }
    }

    /**
     * 多行诊断串。<b>读取失败时界面必须展示这一段</b>，不要用「暂无数据」之类的话盖过去。
     *
     * <p>包含：具体路径、stat 结果、errno、以及与本文件落点相关的两条已知风险提示。
     */
    public static String diagnose(File file) {
        Probe p = probe(file);
        StringBuilder sb = new StringBuilder();
        sb.append("路径：").append(p.path).append('\n');
        if (p.statOk) {
            sb.append("状态：stat 成功")
                    .append(p.isFile ? "，普通文件" : "，不是普通文件")
                    .append('\n');
            sb.append("大小：").append(p.size).append(" 字节\n");
            sb.append("修改时间：").append(fmtTime(p.mtimeMs)).append('\n');
            sb.append("可读：").append(p.canRead ? "是" : "否（canRead=false）").append('\n');
            if (!p.canRead) {
                sb.append("提示：文件存在但 app 无读权限（守护进程以 root 的 umask 创建）。\n");
            }
        } else {
            sb.append("状态：stat 失败 —— ").append(p.errnoText).append('\n');
            sb.append("提示：errno=2/ENOENT 表示守护进程还没写过这个文件（或落点在别处）；\n");
            sb.append("      errno=13/EACCES 表示 SELinux 标签层面拒绝，需真机确认策略。\n");
        }
        sb.append("守护进程侧固定落点（仅供参考，app 无权直读）：")
                .append(com.example.waspwingtempctrl.ConfigStore.DAEMON_PRIVATE_DIR).append('\n');
        sb.append("若两者不一致，界面读到的路径与守护进程实际写入的路径不是同一个，")
                .append("需先修正包名口径（见进展文件未决项）。");
        return sb.toString();
    }

    /** 读取文件尾部至多 {@code maxBytes} 字节，并从下一个换行处开始（避免半截行）。 */
    public static byte[] readTail(File file, int maxBytes) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            long length = raf.length();
            long start = Math.max(0L, length - maxBytes);
            raf.seek(start);
            byte[] buf = new byte[(int) Math.min(Integer.MAX_VALUE, length - start)];
            int read = 0;
            while (read < buf.length) {
                int n = raf.read(buf, read, buf.length - read);
                if (n < 0) {
                    break;
                }
                read += n;
            }
            if (start > 0) {
                // 丢弃第一段半截行
                int nl = -1;
                for (int i = 0; i < read; i++) {
                    if (buf[i] == '\n') {
                        nl = i;
                        break;
                    }
                }
                if (nl < 0) {
                    // 尾部整块都没有换行 —— 只能整块给出
                    return copyOf(buf, 0, read);
                }
                return copyOf(buf, nl + 1, read - nl - 1);
            }
            return copyOf(buf, 0, read);
        } catch (IOException e) {
            throw new IOException("读取失败 path=" + file.getAbsolutePath()
                    + " 类型=" + e.getClass().getName() + " 详情=" + e.getMessage()
                    + " ｜ " + oneLine(diagnose(file)), e);
        } catch (Throwable t) {
            throw new IOException("读取失败 path=" + file.getAbsolutePath()
                    + " 类型=" + t.getClass().getName() + " 详情=" + t.getMessage(), t);
        }
    }

    /** 尾读并解码为文本。 */
    public static String readTailText(File file, int maxBytes) throws IOException {
        return decode(readTail(file, maxBytes));
    }

    /** 解码字节为文本（UTF-8，非法字节替换）。 */
    public static String decode(byte[] bytes) {
        Charset cs = StandardCharsets.UTF_8;
        return new String(bytes, cs);
    }

    private static byte[] copyOf(byte[] src, int from, int len) {
        byte[] out = new byte[len];
        System.arraycopy(src, from, out, 0, len);
        return out;
    }

    private static String oneLine(String text) {
        return text.replace('\n', ' ');
    }

    private static String fmtTime(long ms) {
        if (ms <= 0L) {
            return "—";
        }
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.US)
                .format(new java.util.Date(ms));
    }
}
