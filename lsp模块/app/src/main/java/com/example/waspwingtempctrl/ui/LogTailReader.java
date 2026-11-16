package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.AppFiles;
import com.example.waspwingtempctrl.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 日志尾读 + 截断 + 分级 + 过滤。**全部在后台线程调用**（唯一入口是
 * {@link #read(Context, Source, String, String, String)}）。
 *
 * <p>两条来源共用同一份 {@link Snapshot} 与渲染路径：
 * <ul>
 *   <li>{@link Source#DAEMON}：app 私有目录里的守护进程日志，同 uid 直读 {@link AppFiles}；</li>
 *   <li>{@link Source#LSPOSED}：/data/adb 下的 LSPosed 模块日志，由 {@link LogLsposedReader}
 *       经 root 读最新一份并只保留本模块条目。</li>
 * </ul>
 *
 * <p>硬约束（只读尾部 / 渲染行数上限 / 单行字符上限）与过滤顺序：见 {@code app/逻辑说明.md} §8.3。
 */
final class LogTailReader {

    /** 尾读上限：等价 {@code tail -c 200KB}（口径见 {@code app/逻辑说明.md} §8.3）。 */
    static final int TAIL_BYTES = 200 * 1024;

    /** 单次渲染的行数上限（性能硬约束，列表走 RecyclerView 虚拟化，不一次性全排版）。 */
    static final int MAX_LINES = 3000;

    /**
     * 单行显示上限（字符数）：正常日志行远小于它。只防外部写入 / 文件损坏造成的超长行
     * （尾读上限内可整行无换行）把大段文本塞进一个 TextView、在主线程排版时卡死。
     * 截断后追加一条可见提示，不静默吞内容。
     */
    static final int MAX_LINE_CHARS = 4096;

    /** 日志来源。 */
    enum Source {
        /** 守护进程日志（app 私有目录，同 uid 直读）。 */
        DAEMON,
        /** LSPosed 模块日志（/data/adb/lspd/log，需要 root）。 */
        LSPOSED
    }

    private LogTailReader() {
    }

    /**
     * 一次尾读的完整结果。读取失败时 {@link #ok} 为 false，{@link #failureText}
     * 携带必须原样上屏的诊断原文。
     */
    static final class Snapshot {

        /** 本次读取的来源；{@link #unchanged()} 时为 null。 */
        final Source source;
        /** 实际读取的文件路径（LSPosed 无文件时为 glob 形式）。 */
        final String path;
        final boolean statOk;
        final long size;
        final long mtimeMs;
        final boolean ok;
        /** ok=false 时非空：可直接显示的诊断文本。 */
        final String failureText;
        /** 命中过滤的行（已按行数上限截断）。 */
        final List<LogLine> lines;
        /** 尾读得到的总行数（daemon 为过滤前，LSPosed 为已筛出的 b6x 条目数）。 */
        final int tailLines;
        /** 参与匹配的行数 = min(tailLines, lineLimit)，即界面上的「最近 N 行」。 */
        final int candidateLines;
        /** 本来源的渲染行数上限（daemon 3000 / LSPosed 1200）。 */
        final int lineLimit;
        /** 本来源的尾读字节上限（daemon 200k / LSPosed 400k），只用于统计行展示。 */
        final int byteLimit;
        /** 内容指纹（来源:size:mtime），用于跳过无变化的刷新。 */
        final String fingerprint;
        /** 内容与关键词都与上次一致时为 true，界面应直接跳过本次刷新。 */
        final boolean unchanged;

        private Snapshot(Source source, String path, boolean statOk, long size, long mtimeMs,
                         boolean ok, String failureText, List<LogLine> lines, int tailLines,
                         int candidateLines, int lineLimit, int byteLimit, String fingerprint,
                         boolean unchanged) {
            this.source = source;
            this.path = path;
            this.statOk = statOk;
            this.size = size;
            this.mtimeMs = mtimeMs;
            this.ok = ok;
            this.failureText = failureText;
            this.lines = lines;
            this.tailLines = tailLines;
            this.candidateLines = candidateLines;
            this.lineLimit = lineLimit;
            this.byteLimit = byteLimit;
            this.fingerprint = fingerprint;
            this.unchanged = unchanged;
        }

        static Snapshot unchanged() {
            return new Snapshot(null, null, false, 0L, 0L, true, null,
                    Collections.emptyList(), 0, 0, 0, 0, null, true);
        }
    }

    /** 构造一个失败快照（诊断原文由调用方给出）。 */
    static Snapshot failure(Source source, String path, boolean statOk, long size, long mtimeMs,
                            String failureText, int lineLimit, int byteLimit) {
        return new Snapshot(source, path, statOk, size, mtimeMs, false, failureText,
                Collections.emptyList(), 0, 0, lineLimit, byteLimit, null, false);
    }

    /** 构造一个成功快照。 */
    static Snapshot success(Source source, String path, boolean statOk, long size, long mtimeMs,
                            List<LogLine> lines, int tailLines, int candidateLines,
                            int lineLimit, int byteLimit, String fingerprint) {
        return new Snapshot(source, path, statOk, size, mtimeMs, true, null, lines, tailLines,
                candidateLines, lineLimit, byteLimit, fingerprint, false);
    }

    /**
     * 读一次。
     *
     * @param appContext    主线程取出的 Application Context（只用于取字符串资源）
     * @param source        来源（daemon / LSPosed）
     * @param keyword       关键词，空串表示不过滤
     * @param lastFingerprint 上次成功渲染的内容指纹，可为 null
     * @param lastKeyword     上次过滤用的关键词，可为 null
     */
    @NonNull
    static Snapshot read(@NonNull Context appContext, @NonNull Source source, @Nullable String keyword,
                         @Nullable String lastFingerprint, @Nullable String lastKeyword) {
        if (source == Source.LSPOSED) {
            return LogLsposedReader.read(appContext, keyword, lastFingerprint, lastKeyword);
        }
        File file = AppFiles.logFile(appContext);
        try {
            return readInternal(appContext, file, keyword, lastFingerprint, lastKeyword);
        } catch (Throwable t) {
            // 兜底：任何意外都不能让页面静默留白
            AppFiles.Probe probe = AppFiles.probe(file);
            return daemonFailure(probe, "读取异常：" + t.getClass().getSimpleName() + ": " + t.getMessage()
                    + "\n\n" + AppFiles.diagnose(file));
        }
    }

    private static Snapshot readInternal(Context appContext, File file, String keyword,
                                         String lastFingerprint, String lastKeyword) {
        AppFiles.Probe probe = AppFiles.probe(file);

        if (!probe.usable()) {
            // 不存在 / 不是普通文件 / 无读权限 / 0 字节 —— 一律上诊断原文
            String text = AppFiles.diagnose(file);
            if (probe.statOk && probe.size == 0L) {
                text = text + appContext.getString(R.string.log_empty_file_hint) + "\n";
            }
            return daemonFailure(probe, text);
        }

        String fingerprint = "daemon:" + probe.size + ":" + probe.mtimeMs;
        String kw = keyword == null ? "" : keyword.trim();
        if (fingerprint.equals(lastFingerprint) && kw.equals(lastKeyword)) {
            return Snapshot.unchanged();
        }

        String text;
        try {
            text = AppFiles.readTailText(file, TAIL_BYTES);
        } catch (Throwable t) {
            return daemonFailure(probe, String.valueOf(t.getMessage()) + "\n\n" + AppFiles.diagnose(file));
        }

        // 先不分配地定出「内容末尾」与「最近 MAX_LINES 行的起点」，只对这一小段 split：
        // 把 200KB 窗口整个切成数组会白造几千个永远不上屏的 String。
        int contentEnd = text.length();
        while (contentEnd > 0 && text.charAt(contentEnd - 1) == '\n') {
            contentEnd--;   // 与 split("\n", -1) 后剥掉尾部空串同义
        }
        int nls = 0;
        int windowNl = -1;
        for (int i = contentEnd - 1; i >= 0; i--) {
            if (text.charAt(i) == '\n') {
                nls++;
                if (nls == MAX_LINES) {
                    windowNl = i;   // 自尾数第 MAX_LINES 个换行 = 窗口起点的前一个字符
                }
            }
        }
        int end = contentEnd == 0 ? 0 : nls + 1;
        int candidate = Math.min(end, MAX_LINES);
        String[] tail = text.substring(end > MAX_LINES ? windowNl + 1 : 0, contentEnd)
                .split("\n", -1);

        String kwLower = kw.toLowerCase(Locale.ROOT);
        List<LogLine> out = new ArrayList<>();
        for (int i = 0; i < candidate; i++) {
            String body = stripCr(tail[i]);
            boolean truncated = body.length() > MAX_LINE_CHARS;
            if (truncated) {
                // 只留前 MAX_LINE_CHARS 个字符参与匹配与分级；提示附加在显示文本尾部
                body = body.substring(0, MAX_LINE_CHARS);
            }
            if (!kwLower.isEmpty() && !body.toLowerCase(Locale.ROOT).contains(kwLower)) {
                continue;
            }
            String display = truncated
                    ? body + appContext.getString(R.string.log_line_truncated, MAX_LINE_CHARS)
                    : body;
            out.add(new LogLine(display, LogClassifier.classify(body)));
        }
        return success(Source.DAEMON, probe.path, probe.statOk, probe.size, probe.mtimeMs,
                out, end, candidate, MAX_LINES, TAIL_BYTES, fingerprint);
    }

    private static Snapshot daemonFailure(AppFiles.Probe probe, String failureText) {
        return failure(Source.DAEMON, probe.path, probe.statOk, probe.size, probe.mtimeMs,
                failureText, MAX_LINES, TAIL_BYTES);
    }

    /** C 端只写 {@code \n}；若文件被外部工具写成 CRLF，行尾的 {@code \r} 会渲染成怪字符，故剥掉。 */
    static String stripCr(String line) {
        if (line.endsWith("\r")) {
            return line.substring(0, line.length() - 1);
        }
        return line;
    }
}
