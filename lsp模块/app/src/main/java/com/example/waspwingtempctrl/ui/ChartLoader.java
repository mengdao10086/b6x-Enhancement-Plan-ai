package com.example.waspwingtempctrl.ui;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;

import java.io.File;

/**
 * 曲线数据的一次读取 + 解析。<b>全部在后台线程调用</b>：读取入口
 * {@link #read(Context, File, ChartConfig, String)}，另有进程级预热入口 {@link #warmUp(Context)}
 * （供 {@code SetupActivity} 的冷启动预热调）；主线程只消费返回的快照。
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
 *
 * <p><b>进程级缓存</b>：最近一次成功读取的结果（含解析产物）按数据文件指纹（{@code size:mtime}）
 * 留一份。曲线页每次重新可见都会强制重读（口径可能变，指纹一并作废），那时文件往往根本没变
 * —— 命中即复用解析产物，不再读 256KB 也不再逐行解析。<b>只缓存解析产物</b>（{@code ChartDataset}），
 * 不缓存原始文本；失败一律不进缓存（下次照旧重读，诊断信息绝不陈旧）。
 * 返回的 {@link Snapshot} 因此<b>可能被多处共用</b>：只读。
 */
public final class ChartLoader {

    /** 尾读上限：C 端文件最多 780 行（约 40KB），这里给足余量，绝不整文件无界读。 */
    static final int TAIL_BYTES = 256 * 1024;

    /** 最近一次成功读取的结果 + 它对应的数据文件指纹（不可变，故 volatile 一次读写即一致）。 */
    private static final class Cached {
        final String fingerprint;
        final Snapshot snapshot;

        Cached(String fingerprint, Snapshot snapshot) {
            this.fingerprint = fingerprint;
            this.snapshot = snapshot;
        }
    }

    private static volatile Cached cached;

    private ChartLoader() {
    }

    // ==================== 进程级预热 ====================

    /**
     * 预热曲线首帧：先把曲线口径备好（{@link ChartConfig} 的进程级缓存），再读一次数据文件
     * （解析产物进 {@link #read} 的进程级缓存），曲线页第一次刷新即可命中。冷启动时由
     * {@code SetupActivity} 的预热线程调，<b>只在后台线程调</b>（内有同步 IO）。
     *
     * <p>纯优化，故失败不抛也不再报：读不到就什么都留不下，各入口随后照旧自己读一次、失败时
     * 照旧把诊断原文铺在曲线区（既有路径不受本方法影响）。不新增定时器 —— 它只跑这一次。
     */
    public static void warmUp(Context context) {
        try {
            Context app = context.getApplicationContext();
            // 记账（旁路）：曲线口径首次加载。首次写入胜出，故曲线页若抢先自读，这次只报它的命中耗时
            // 而不会覆盖那一次（见 ChartFragment.loadConfigTimed 的同槽位）
            long startedAt = StartupTiming.now();
            ChartConfig cfg = ChartConfig.load(app);
            StartupTiming.span(StartupTiming.CHART_CFG, startedAt);
            read(app, AppFiles.dataFile(app), cfg, null);
        } catch (Throwable ignored) {
            // 预热失败无副作用：缓存没写进去，后续读取照旧走完整路径
        }
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
        Cached hit = cached;
        if (hit != null && fingerprint.equals(hit.fingerprint)) {
            // 进程内已解过这一份内容（但调用方手上没有可比的指纹）：读盘与解析都不必再做
            return hit.snapshot;
        }

        String text;
        // 记账（旁路）：只量"真读盘 + 真解析"这一段（上面几处缓存命中都已早退，不在此计时）；
        // 首次写入胜出，故预热与曲线页自读并发时，报的是先完成的那一次真实成本
        long startedAt = StartupTiming.now();
        try {
            text = AppFiles.readTailText(file, TAIL_BYTES);
        } catch (Throwable t) {
            // IOException 的消息里已带 path + 异常类型 + diagnose 串；两条信息都要能上屏
            return failure(probe, appContext.getString(R.string.chart_fail_read,
                    String.valueOf(t.getMessage())) + "\n\n" + AppFiles.diagnose(file));
        }

        ChartDataset ds = ChartDataset.parse(tailForParse(text, cfg.rollingMaxLines), cfg,
                cfg.rollingMaxLines);
        StartupTiming.span(StartupTiming.CHART_DATA, startedAt);
        if (ds.parsedLines == 0) {
            return failure(probe, appContext.getString(R.string.chart_fail_parse_empty, probe.size)
                    + "\n\n" + AppFiles.diagnose(file));
        }
        Snapshot snapshot = new Snapshot(probe, true, null, ds, fingerprint, false);
        cached = new Cached(fingerprint, snapshot);
        return snapshot;
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
