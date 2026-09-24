package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.io.File;

/**
 * 曲线数据的一次读取 + 解析。<b>全部在后台线程调用</b>（唯一入口
 * {@link #read(Context, File, ChartConfig, String)}），主线程只消费返回的快照。
 *
 * <p>三条硬约束：
 * <ol>
 *   <li>读文件一律走 {@link AppFiles}（{@link AppFiles#readTailText(File, int)}），
 *       不自己开 {@code FileInputStream}/{@code RandomAccessFile}。</li>
 *   <li>失败一律不静默：{@link Snapshot#failureText} 里同时带上<b>本次失败的具体原因</b>与
 *       {@link AppFiles#diagnose(File)} 的原文（路径 + stat 结果 + errno + 提示），
 *       由界面原样铺在曲线区。</li>
 *   <li>直读失败是<b>正常路径</b>：SELinux 直读未真机验证，errno=13 就可能发生，
 *       界面必须给得出可诊断文本。</li>
 * </ol>
 */
final class ChartLoader {

    /** 尾读上限：C 端文件最多 780 行（约 40KB），这里给足余量，绝不整文件无界读。 */
    static final int TAIL_BYTES = 256 * 1024;

    private ChartLoader() {
    }

    /** 一次读取的完整结果。 */
    static final class Snapshot {

        final AppFiles.Probe probe;
        final boolean ok;
        /** ok=false 时非空：可直接上屏的诊断文本（含具体原因 + AppFiles.diagnose 原文）。 */
        final String failureText;
        /** ok=true 时的解析结果。 */
        final ChartDataset dataset;
        /** 内容指纹（size:mtime），用于跳过无变化的刷新。 */
        final String fingerprint;
        /** 内容与上次一致时为 true，界面应跳过本次刷新。 */
        final boolean unchanged;

        private Snapshot(AppFiles.Probe probe, boolean ok, String failureText, ChartDataset dataset,
                         String fingerprint, boolean unchanged) {
            this.probe = probe;
            this.ok = ok;
            this.failureText = failureText;
            this.dataset = dataset;
            this.fingerprint = fingerprint;
            this.unchanged = unchanged;
        }

        static Snapshot unchanged() {
            return new Snapshot(null, true, null, null, null, true);
        }
    }

    /**
     * 读一次并解析。
     *
     * @param appContext      主线程取出的 Application Context（只用于取字符串资源）
     * @param file            数据文件（主线程由 {@link AppFiles#dataFile(Context)} 取得）
     * @param cfg             曲线口径参数
     * @param lastFingerprint 上次成功的指纹，可为 null
     */
    @NonNull
    static Snapshot read(@NonNull Context appContext, @NonNull File file, @NonNull ChartConfig cfg,
                         @Nullable String lastFingerprint) {
        try {
            return readInternal(appContext, file, cfg, lastFingerprint);
        } catch (Throwable t) {
            // 兜底：任何意外都不能让曲线区静默留白
            return failure(AppFiles.probe(file),
                    "读取异常：" + t.getClass().getSimpleName() + ": " + t.getMessage()
                            + "\n\n" + AppFiles.diagnose(file));
        }
    }

    private static Snapshot readInternal(Context appContext, File file, ChartConfig cfg,
                                         String lastFingerprint) {
        AppFiles.Probe probe = AppFiles.probe(file);

        if (!probe.usable()) {
            // 不存在 / 不是普通文件 / 无读权限 / 0 字节 —— 一律上诊断原文
            String head;
            if (!probe.statOk) {
                head = appContext.getString(R.string.chart_fail_stat);
            } else if (!probe.isFile) {
                head = appContext.getString(R.string.chart_fail_not_file);
            } else if (!probe.canRead) {
                head = appContext.getString(R.string.chart_fail_no_perm);
            } else {
                head = appContext.getString(R.string.chart_fail_empty);
            }
            return failure(probe, head + "\n\n" + AppFiles.diagnose(file));
        }

        String fingerprint = probe.size + ":" + probe.mtimeMs;
        if (fingerprint.equals(lastFingerprint)) {
            return Snapshot.unchanged();
        }

        String text;
        try {
            text = AppFiles.readTailText(file, TAIL_BYTES);
        } catch (Throwable t) {
            // IOException 的消息里已带 path + 异常类型 + diagnose 串；两条信息都要能上屏
            return failure(probe, appContext.getString(R.string.chart_fail_read,
                    String.valueOf(t.getMessage())) + "\n\n" + AppFiles.diagnose(file));
        }

        ChartDataset ds = ChartDataset.parse(tailForParse(text, cfg.rollingMaxLines), cfg,
                cfg.rollingMaxLines);
        if (ds.parsedLines == 0) {
            return failure(probe, appContext.getString(R.string.chart_fail_parse_empty, probe.size)
                    + "\n\n" + AppFiles.diagnose(file));
        }
        return new Snapshot(probe, true, null, ds, fingerprint, false);
    }

    /**
     * 交给解析器的文本：窗口行数明显超出保留量时只取尾部，否则原样返回。
     *
     * <p>环形缓冲只留 {@code rollingMaxLines} 行（口径见 {@code 逻辑说明.md} 的「状态页数据源」
     * 一节），文件被撑大时再多行也留不下，却要在每秒的循环里逐行切分/解析一遍——所以解析量的
     * 上界必须跟着保留量走。
     *
     * <p>截断只在窗口行数超过 {@code 2 × 保留量} 时发生，因为界面「解析 / 跳过」
     * （见 {@code chart_info_parse_fmt}）报的是解析器实际扫过的行数，是给用户看数据文件的诊断；
     * 而 C 端文件最多膨胀到 780 行（{@code tempctrl.c} 的 {@code WEBUI_DATA_MAX_LINES} 720
     * 加 {@code WEBUI_COMPACT_EVERY} 60），远不到这个上界，故常规文件的诊断数字与截断前逐字
     * 一致，只有别的写入方撑大文件时才截尾。
     *
     * <p>按行边界切割，只动交给解析器的那段文本；{@link #TAIL_BYTES} 的读取上界（「绝不整文件
     * 无界读」的护栏）与文件的读取方式都不变。
     */
    private static String tailForParse(String text, int maxLines) {
        int cap = Math.max(1, maxLines);
        int limit = cap * 2;
        int contentEnd = text.length();
        while (contentEnd > 0 && text.charAt(contentEnd - 1) == '\n') {
            contentEnd--;   // 尾部换行不构成行（解析器本来就跳过空行）
        }
        if (contentEnd == 0) {
            return text;
        }
        int lines = 0;
        int bound = 0;
        for (int i = contentEnd - 1; i >= 0; i--) {
            if (text.charAt(i) != '\n') {
                continue;
            }
            lines++;
            if (lines == cap) {
                bound = i + 1;   // 自尾数第 cap 行的起点
            }
            if (lines >= limit) {
                return text.substring(bound);
            }
        }
        return text;
    }

    private static Snapshot failure(AppFiles.Probe probe, String text) {
        return new Snapshot(probe, false, text, null, null, false);
    }
}
