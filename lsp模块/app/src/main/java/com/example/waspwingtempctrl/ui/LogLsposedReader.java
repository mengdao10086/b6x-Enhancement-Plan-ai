package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.RootShell;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * LSPosed 模块日志来源：经 {@link RootShell} 读 {@code /data/adb/lspd/log} 下最新一份
 * {@code modules_*.log}，只保留本模块（{@value #MODULE_PKG}）的条目。
 *
 * <p>格式（每行 header，异常堆栈续行以 {@code \tat } 开头）：
 * <pre>
 * [ 2026-11-14T22:31:25.792  1000: 2789: 2789 I/LSPosedFramework ] (进程)[模块包名,XposedBridge,hash] 消息体
 * </pre>
 *
 * <p>三条规则：
 * <ul>
 *   <li>按方括号内<b>逗号前的模块包名</b>匹配，不用 hash；</li>
 *   <li>header 保留时其后的续行一并保留，header 被过滤时续行丢弃；</li>
 *   <li>展示时去掉固定前缀，只留精简时间 + 消息体。</li>
 * </ul>
 *
 * <p>读盘只读文件尾部 {@link #TAIL_BYTES} 字节（root 侧 {@code tail -c}），不整文件读入。
 * 400k 折算行数见 {@link #MAX_LINES}。
 */
final class LogLsposedReader {

    /** LSPosed 模块日志目录（固定路径，root 可读）。 */
    static final String LOG_DIR = "/data/adb/lspd/log";
    /** 目录下最新一份模块日志的 glob（也用于界面上的路径展示）。 */
    static final String LOG_GLOB = LOG_DIR + "/modules_*.log";

    /** 本模块包名：LSPosed 日志里方括号内逗号前的第一段。 */
    private static final String MODULE_PKG = "com.example.waspwingtempctrl";

    /** 解析上限：与 daemon 日志窗口同口径的 400k（byte）。 */
    static final int TAIL_BYTES = 400 * 1024;

    /**
     * 行数上限取 1200 行（超过时只保留尾部）。
     * 尾读字节上限 400k 在实测平均行长 315.9 字节（样本
     * {@code modules_2026-11-14T22_31_24.363893 (7).log} 中本模块 565 条 header 共
     * 178,506 字节含换行）下约合 1296 行；1200 是行数硬上限，留出余量避免尾部窗口
     * 随字节上限截断位置来回跳。
     */
    static final int MAX_LINES = 1200;

    private static final long EXEC_TIMEOUT_MS = 15_000L;

    /** root 脚本输出里的分节标记（正常日志行不会以它们开头）。 */
    private static final String MARK_PATH = "__WW_LOG_PATH__";
    private static final String MARK_STAT = "__WW_LOG_STAT__";
    private static final String MARK_NONE = "__WW_LOG_NONE__";

    private LogLsposedReader() {
    }

    @NonNull
    static LogTailReader.Snapshot read(@NonNull Context appContext, @Nullable String keyword,
                                       @Nullable String lastFingerprint,
                                       @Nullable String lastKeyword) {
        try {
            return readInternal(appContext, keyword, lastFingerprint, lastKeyword);
        } catch (Throwable t) {
            return failure("状态：读取异常 —— " + t.getClass().getSimpleName() + ": "
                    + t.getMessage() + "\n");
        }
    }

    private static LogTailReader.Snapshot readInternal(Context appContext, String keyword,
                                                       String lastFingerprint,
                                                       String lastKeyword) {
        RootShell.Result result = RootShell.get(appContext).exec(buildScript(), EXEC_TIMEOUT_MS);
        if (!result.isOk()) {
            return failure("状态：root 读取失败 —— " + result.describe() + "\n"
                    + "提示：/data/adb 普通应用不可读，需要授予 root 权限。\n");
        }

        String path = null;
        boolean none = false;
        long size = 0L;
        long mtimeMs = 0L;
        StringBuilder content = new StringBuilder();
        for (String line : result.stdout.split("\n", -1)) {
            if (line.equals(MARK_NONE)) {
                none = true;
            } else if (line.startsWith(MARK_PATH)) {
                path = line.substring(MARK_PATH.length());
            } else if (line.startsWith(MARK_STAT)) {
                long[] stat = parseStat(line.substring(MARK_STAT.length()));
                size = stat[0];
                mtimeMs = stat[1];
            } else {
                content.append(line).append('\n');
            }
        }

        if (path == null || path.isEmpty()) {
            return none
                    ? failure("状态：未找到日志文件（ls 无匹配）\n"
                            + "提示：LSPosed 尚未写过模块日志，或日志目录不在默认位置。\n")
                    : failure("状态：root 脚本未返回文件路径（输出格式异常）。\n");
        }

        String fingerprint = "lsposed:" + path + ":" + size + ":" + mtimeMs;
        String kw = keyword == null ? "" : keyword.trim();
        if (fingerprint.equals(lastFingerprint) && kw.equals(lastKeyword)) {
            return LogTailReader.Snapshot.unchanged();
        }

        List<Display> kept = filter(content.toString());
        int from = Math.max(0, kept.size() - MAX_LINES);
        List<Display> window = kept.subList(from, kept.size());

        // 尾部截断可能从某条 header 的续行开始：丢掉开头的无主续行，保持「续行必属于上一条 header」。
        int start = 0;
        while (start < window.size() && !window.get(start).header) {
            start++;
        }
        int candidate = window.size() - start;

        String kwLower = kw.toLowerCase(Locale.ROOT);
        List<LogLine> out = new ArrayList<>();
        for (int i = start; i < window.size(); i++) {
            Display display = window.get(i);
            String body = display.text;
            boolean truncated = body.length() > LogTailReader.MAX_LINE_CHARS;
            if (truncated) {
                body = body.substring(0, LogTailReader.MAX_LINE_CHARS);
            }
            if (!kwLower.isEmpty() && !body.toLowerCase(Locale.ROOT).contains(kwLower)) {
                continue;
            }
            String shown = truncated
                    ? body + appContext.getString(R.string.log_line_truncated, LogTailReader.MAX_LINE_CHARS)
                    : body;
            out.add(new LogLine(shown, display.level));
        }
        return LogTailReader.success(LogTailReader.Source.LSPOSED, path, true, size, mtimeMs,
                out, kept.size(), candidate, MAX_LINES, TAIL_BYTES, fingerprint);
    }

    /**
     * 解析整段文本：只保留本模块 header 及其续行。
     * 返回的是<b>按文件顺序</b>的 b6x 条目（尚未做行数截断与关键词过滤）。
     */
    private static List<Display> filter(String text) {
        List<Display> out = new ArrayList<>();
        boolean keep = false;
        LogLine.Level keepLevel = LogLine.Level.PLAIN;
        for (String raw : text.split("\n", -1)) {
            String line = LogTailReader.stripCr(raw);
            if (line.startsWith("----part ")) {
                keep = false;   // LSPosed 分段标记：不属于任何 header
                continue;
            }
            Header header = parseHeader(line);
            if (header != null) {
                keep = MODULE_PKG.equals(header.pkg);
                keepLevel = header.level;
                if (keep) {
                    out.add(new Display(header.display, true, header.level));
                }
                continue;
            }
            if (!keep || line.trim().isEmpty()) {
                continue;
            }
            out.add(new Display(line, false, keepLevel));
        }
        return out;
    }

    /**
     * 解析一条 header。不是 header（含续行、分隔行、被尾读截断的半行）返回 null。
     * 结构：{@code [ 时间 pid tid tid 级别/tag ] (进程)[模块,类,hash] 消息体}
     */
    @Nullable
    private static Header parseHeader(String line) {
        if (!line.startsWith("[ ")) {
            return null;
        }
        int close = line.indexOf("] ");
        if (close < 0) {
            return null;
        }
        int procOpen = line.indexOf('(', close + 2);
        if (procOpen < 0) {
            return null;
        }
        int procClose = line.indexOf(')', procOpen + 1);
        if (procClose < 0) {
            return null;
        }
        int modOpen = line.indexOf('[', procClose + 1);
        if (modOpen < 0) {
            return null;
        }
        int modClose = line.indexOf(']', modOpen + 1);
        if (modClose < 0) {
            return null;
        }
        int comma = line.indexOf(',', modOpen + 1);
        if (comma < 0 || comma > modClose) {
            return null;
        }
        String pkg = line.substring(modOpen + 1, comma).trim();
        String message = line.substring(modClose + 1).trim();
        String prefix = line.substring(2, close).trim();
        String time = compactTime(prefix);
        String display;
        if (time.isEmpty()) {
            display = message;
        } else if (message.isEmpty()) {
            display = time;
        } else {
            display = time + " " + message;
        }
        return new Header(pkg, display, levelOf(prefix));
    }

    /** 前缀里的级别字母（{@code I/LSPosedFramework} 中的 I）→ 日志分级色。 */
    private static LogLine.Level levelOf(String prefix) {
        if (prefix.contains(" E/") || prefix.contains(" F/")) {
            return LogLine.Level.ERROR;
        }
        if (prefix.contains(" W/")) {
            return LogLine.Level.WARN;
        }
        if (prefix.contains(" D/") || prefix.contains(" V/")) {
            return LogLine.Level.DEBUG;
        }
        if (prefix.contains(" I/")) {
            return LogLine.Level.INFO;
        }
        return LogLine.Level.PLAIN;
    }

    /** {@code 2026-11-14T22:32:41.153} → {@code 22:32:41.153}；取不到时间返回空串。 */
    private static String compactTime(String prefix) {
        int space = prefix.indexOf(' ');
        String time = space > 0 ? prefix.substring(0, space) : prefix;
        if (time.isEmpty() || !Character.isDigit(time.charAt(0))) {
            return "";
        }
        int t = time.indexOf('T');
        if (t >= 0 && time.length() >= t + 13) {
            return time.substring(t + 1);
        }
        return time;
    }

    /** root 脚本：找最新一份 modules_*.log → 输出路径 / stat → 只读尾部 400k。 */
    private static String buildScript() {
        return "f=$(ls -1t " + LOG_GLOB + " 2>/dev/null | head -n 1)\n"
                + "if [ -z \"$f\" ]; then\n"
                + "  echo " + MARK_NONE + "\n"
                + "else\n"
                + "  echo \"" + MARK_PATH + "$f\"\n"
                + "  s=$(stat -c '%s %Y' \"$f\" 2>/dev/null)\n"
                + "  [ -n \"$s\" ] || s=\"$(wc -c < \"$f\" 2>/dev/null) 0\"\n"
                + "  echo \"" + MARK_STAT + "$s\"\n"
                + "  tail -c " + TAIL_BYTES + " \"$f\"\n"
                + "fi";
    }

    /** {@code "size mtimeSeconds"} → {@code [size, mtimeMs]}；解析失败给 0。 */
    private static long[] parseStat(String text) {
        String[] parts = text.trim().split("\\s+");
        long size = parts.length > 0 ? parseLong(parts[0]) : 0L;
        long seconds = parts.length > 1 ? parseLong(parts[1]) : 0L;
        return new long[]{Math.max(0L, size), Math.max(0L, seconds) * 1000L};
    }

    private static long parseLong(String text) {
        try {
            return Long.parseLong(text.trim());
        } catch (NumberFormatException e) {
            return 0L;
        }
    }

    private static LogTailReader.Snapshot failure(String detail) {
        return LogTailReader.failure(LogTailReader.Source.LSPOSED, LOG_GLOB, false, 0L, 0L,
                "路径：" + LOG_GLOB + "\n" + detail, MAX_LINES, TAIL_BYTES);
    }

    /** 已处理的一行：是否 header（用于截断后丢弃无主续行）+ 显示文本 + 级别。 */
    private static final class Display {
        final String text;
        final boolean header;
        final LogLine.Level level;

        Display(String text, boolean header, LogLine.Level level) {
            this.text = text;
            this.header = header;
            this.level = level;
        }
    }

    private static final class Header {
        final String pkg;
        final String display;
        final LogLine.Level level;

        Header(String pkg, String display, LogLine.Level level) {
            this.pkg = pkg;
            this.display = display;
            this.level = level;
        }
    }
}
