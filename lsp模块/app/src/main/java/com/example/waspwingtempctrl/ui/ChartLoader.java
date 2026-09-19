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

        ChartDataset ds = ChartDataset.parse(text, cfg, cfg.rollingMaxLines);
        if (ds.parsedLines == 0) {
            return failure(probe, appContext.getString(R.string.chart_fail_parse_empty, probe.size)
                    + "\n\n" + AppFiles.diagnose(file));
        }
        return new Snapshot(probe, true, null, ds, fingerprint, false);
    }

    private static Snapshot failure(AppFiles.Probe probe, String text) {
        return new Snapshot(probe, false, text, null, null, false);
    }
}
