package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * 日志尾读 + 截断 + 分级 + 过滤。**全部在后台线程调用**（唯一入口是
 * {@link #read(Context, File, String, String, String)}）。
 *
 * <p>三条硬约束：
 * <ol>
 *   <li>只读文件末尾 {@link #TAIL_BYTES} 字节，语义等价 {@code tail -c 400KB}
 *       （口径见 {@code 逻辑说明.md}（仓库根）的「日志页」一节），绝不整文件读入。</li>
 *   <li>读取一律走 {@link AppFiles}（{@link AppFiles#readTailText(File, int)}），
 *       不自己开 {@code FileInputStream}，失败信息才不会丢。</li>
 *   <li>渲染行数上限 {@link #MAX_LINES}：400KB 全量上屏会卡死，只保留尾部这么多行，
 *       界面必须显式写出这个截断。</li>
 * </ol>
 *
 * <p><b>过滤顺序</b>：先按 {@link #MAX_LINES} 截出「最近 N 行」，再在其中做关键词匹配。
 * 因此界面上的「最近 N 行」就是匹配分母，含义与显示一致（命中范围仅限该窗口）。
 */
final class LogTailReader {

    /** 尾读上限：等价 {@code tail -c 400KB}（口径见 {@code 逻辑说明.md} 的「日志页」一节）。 */
    static final int TAIL_BYTES = 400 * 1024;

    /** 单次渲染的行数上限（性能硬约束）。 */
    static final int MAX_LINES = 2000;

    private LogTailReader() {
    }

    /**
     * 一次尾读的完整结果。读取失败时 {@link #ok} 为 false，{@link #failureText}
     * 携带必须原样上屏的诊断原文。
     */
    static final class Snapshot {

        final AppFiles.Probe probe;
        final boolean ok;
        /** ok=false 时非空：可直接显示的诊断文本。 */
        final String failureText;
        /** 命中过滤的行（已按 MAX_LINES 截断）。 */
        final List<LogLine> lines;
        /** 尾读得到的总行数（过滤前）。 */
        final int tailLines;
        /** 参与匹配的行数 = min(tailLines, MAX_LINES)，即界面上的「最近 N 行」。 */
        final int candidateLines;
        /** 内容指纹（size:mtime），用于跳过无变化的刷新。 */
        final String fingerprint;
        /** 内容与关键词都与上次一致时为 true，界面应直接跳过本次刷新。 */
        final boolean unchanged;

        private Snapshot(AppFiles.Probe probe, boolean ok, String failureText, List<LogLine> lines,
                         int tailLines, int candidateLines, String fingerprint, boolean unchanged) {
            this.probe = probe;
            this.ok = ok;
            this.failureText = failureText;
            this.lines = lines;
            this.tailLines = tailLines;
            this.candidateLines = candidateLines;
            this.fingerprint = fingerprint;
            this.unchanged = unchanged;
        }

        static Snapshot unchanged() {
            return new Snapshot(null, true, null, Collections.emptyList(), 0, 0, null, true);
        }
    }

    /**
     * 读一次。
     *
     * @param appContext    主线程取出的 Application Context（只用于取字符串资源）
     * @param file          日志文件（主线程由 {@link AppFiles#logFile(Context)} 取得）
     * @param keyword       关键词，空串表示不过滤
     * @param lastFingerprint 上次成功渲染的内容指纹，可为 null
     * @param lastKeyword     上次过滤用的关键词，可为 null
     */
    @NonNull
    static Snapshot read(@NonNull Context appContext, @NonNull File file, @Nullable String keyword,
                         @Nullable String lastFingerprint, @Nullable String lastKeyword) {
        try {
            return readInternal(appContext, file, keyword, lastFingerprint, lastKeyword);
        } catch (Throwable t) {
            // 兜底：任何意外都不能让页面静默留白
            AppFiles.Probe probe = AppFiles.probe(file);
            return failure(probe, "读取异常：" + t.getClass().getSimpleName() + ": " + t.getMessage()
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
            return failure(probe, text);
        }

        String fingerprint = probe.size + ":" + probe.mtimeMs;
        String kw = keyword == null ? "" : keyword.trim();
        if (fingerprint.equals(lastFingerprint) && kw.equals(lastKeyword)) {
            return Snapshot.unchanged();
        }

        String text;
        try {
            text = AppFiles.readTailText(file, TAIL_BYTES);
        } catch (Throwable t) {
            return failure(probe, String.valueOf(t.getMessage()) + "\n\n" + AppFiles.diagnose(file));
        }

        String[] all = text.split("\n", -1);
        int end = all.length;
        while (end > 0 && all[end - 1].isEmpty()) {
            end--;
        }
        int start = Math.max(0, end - MAX_LINES);
        int candidate = end - start;

        String kwLower = kw.toLowerCase(Locale.ROOT);
        List<LogLine> out = new ArrayList<>();
        for (int i = start; i < end; i++) {
            String line = stripCr(all[i]);
            if (!kwLower.isEmpty() && !line.toLowerCase(Locale.ROOT).contains(kwLower)) {
                continue;
            }
            out.add(new LogLine(line, LogClassifier.classify(line)));
        }
        return new Snapshot(probe, true, null, out, end, candidate, fingerprint, false);
    }

    private static Snapshot failure(AppFiles.Probe probe, String failureText) {
        return new Snapshot(probe, false, failureText, Collections.emptyList(), 0, 0, null, false);
    }

    /** C 端只写 {@code \n}；若文件被外部工具写成 CRLF，行尾的 {@code \r} 会渲染成怪字符，故剥掉。 */
    private static String stripCr(String line) {
        if (line.endsWith("\r")) {
            return line.substring(0, line.length() - 1);
        }
        return line;
    }
}
