package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.Protocol;

/**
 * 数据文件解析结果 + 曲线滤波。
 *
 * <p>解析口径见 app/逻辑说明.md §7.1（行格式权威在 {@code daemon/逻辑说明.md}〈状态页数据源〉）：
 * 按 {@code \n} 切行、<b>列数不足 {@link #COL_COUNT} 的整行跳过</b>（不中断、不产生断点）；
 * 温度列 {@code v>=0 ? v/10 : 无效}，转速/制冷列 {@code v>=0 ? v : 无效}，故哨兵 -1 变无效。
 * 另按「0 = 未就绪」再滤一次：热端/风扇/制冷 {@code v>0} 才有效；冷端 0℃ 合法，
 * 连续 {@link #COLD_ZERO_RUN} 个 0 才整段判无效。
 *
 * <p>行数上限 {@code rollingMaxLines}（= C 端 {@code WEBUI_DATA_MAX_LINES}）用环形覆盖保留
 * 最近 N 行，与 C 端压缩口径一致。
 *
 * <p>滤波<b>在解析后对全量样本做一次</b>（与显示窗口无关），窗口只做切片——同一份数据永远得到同一条曲线（见 app/逻辑说明.md §7.2）。
 */
final class ChartDataset {

    /**
     * 一行至少有这么多列才参与解析 —— <b>不是 C 端当前列数</b>。C 端已升到 12 列
     * （{@code tempctrl.c} 的 {@code WEBUI_DATA_COLS}/{@code WEBUI_ROW_FMT}），本值只作为旧行兼容下限：
     * 旧数据（8/10/11 列）照常解析，缺的列取无效，不整行丢弃。
     *
     * <p>列序（与 C 端 {@code write_webui_data()} 里 {@code fprintf} 的实参一一对应，
     * 权威声明在 {@code tempctrl.c} 的 {@code WEBUI_ROW_FMT} 上方注释）：
     * <pre>
     *   [0]  epoch      时间戳（Unix 秒）        → ChartSample.t
     *   [1]  batt       电池   0.1°C             → temp()
     *   [2]  cpu        CPU    0.1°C             → temp()
     *   [3]  热端            0.1°C              → temp()
     *   [4]  冷端            0.1°C              → temp()
     *   [5]  目标风速        设备回显设定档 RPM   → raw()
     *   [6]  目标制冷        设备回显设定档       → raw()
     *   [7]  下发目标制冷    0.1°C              → 不消费
     *   [8]  PID 输入        0.01°C              → pidInput()
     *   [9]  重算标记        0/1                 → asOne()
     *   [10] 实际制冷        设备运行档           → raw()
     *   [11] 实际风扇转速    设备 getSpeed RPM   → raw()
     * </pre>
     *
     * <p><b>[7] 下发目标制冷：写端有，读端有意不消费。</b>本界面（图例 + 实时数值列）
     * 都不展示下发目标制冷（{@code app/逻辑说明.md} §7.6〈实时数值列〉明确"不含目标制冷"）。
     * 界面消费的「目标制冷」是 [6] 设备回显的设定档，「实际制冷」是 [10] 运行档，两者语义不同。
     *
     * <p><b>[8] PID 输入 / [9] 重算标记 / [10] 实际制冷 / [11] 实际风扇转速：后加的可选列。</b>
     * 旧行缺列时对应项取无效/false，不会整行丢弃。
     */
    static final int COL_COUNT = Protocol.WEBUI_COLS_LEGACY_MIN;

    /** 冷端连续 0 的判定门槛：连续达到该点数才整段判无效（0℃ 对制冷片是合法读数）。 */
    static final int COLD_ZERO_RUN = 6;

    private static final int COL_TS = Protocol.WEBUI_COL_TS;
    private static final int COL_BATT = Protocol.WEBUI_COL_BATT;
    private static final int COL_CPU = Protocol.WEBUI_COL_CPU;
    private static final int COL_HOT = Protocol.WEBUI_COL_HOT;
    private static final int COL_COLD = Protocol.WEBUI_COL_COLD;
    /** 目标风速：设备回显的设定档（getRealWindLevel）。 */
    private static final int COL_RPM = Protocol.WEBUI_COL_RPM_SET;
    /** 目标制冷：设备回显的设定档。 */
    private static final int COL_COOL = Protocol.WEBUI_COL_COLD_SET;
    /** 实际制冷（设备运行档）：后加列，旧行没有 → 无效。 */
    private static final int COL_COOL_ACTUAL = Protocol.WEBUI_COL_COLD_RUN;
    /** 实际风扇转速（设备 getSpeed）：后加列，旧行（≤11 列）没有 → 无效。 */
    private static final int COL_RPM_ACTUAL = Protocol.WEBUI_COL_RPM_RUN;
    /** PID 输入（0.01°C）：后加列，旧行没有 → 无效。 */
    private static final int COL_PID = Protocol.WEBUI_COL_PID_INPUT;
    /** PID 重算标记（0/1）：后加列，旧行没有 → false。 */
    private static final int COL_RECOMP = Protocol.WEBUI_COL_RECOMPUTE;

    /** 全量样本（已滤波）。 */
    final ChartSample[] all;
    /** 通过列数校验的行数。 */
    final int parsedLines;
    /** 列数不足 8 被丢掉的行数。 */
    final int skippedLines;

    private ChartDataset(ChartSample[] all, int parsedLines, int skippedLines) {
        this.all = all;
        this.parsedLines = parsedLines;
        this.skippedLines = skippedLines;
    }

    static ChartDataset parse(String text, ChartConfig cfg, int maxLines) {
        int cap = Math.max(1, maxLines);
        ChartSample[] ring = new ChartSample[cap];
        int total = 0;
        int skipped = 0;
        String[] lines = text.split("\n", -1);
        for (String raw : lines) {
            String line = raw.trim();   // 兼容 CRLF：trim 一并去掉行尾 \r
            if (line.isEmpty()) {
                continue;
            }
            String[] p = line.split(",", -1);
            if (p.length < COL_COUNT) {
                skipped++;
                continue;
            }
            Long ts = parseLong(p[COL_TS]);
            Integer cpuRaw = parseInt(p[COL_CPU]);
            ring[total % cap] = new ChartSample(
                    ts != null ? ts : 0L,
                    cpuRaw != null ? cpuRaw : -1,
                    temp(parseInt(p[COL_BATT])),
                    temp(cpuRaw),
                    tempNonZero(parseInt(p[COL_HOT])),
                    temp(parseInt(p[COL_COLD])),
                    rawNonZero(parseInt(p[COL_RPM])),
                    rawNonZero(parseInt(p[COL_COOL])),
                    rawNonZero(p.length > COL_COOL_ACTUAL ? parseInt(p[COL_COOL_ACTUAL]) : null),
                    rawNonZero(p.length > COL_RPM_ACTUAL ? parseInt(p[COL_RPM_ACTUAL]) : null),
                    pidInput(p.length > COL_PID ? parseInt(p[COL_PID]) : null),
                    p.length > COL_RECOMP && asOne(p[COL_RECOMP]));
            total++;
        }
        int keep = Math.min(total, cap);
        int start = total <= cap ? 0 : total % cap;
        ChartSample[] out = new ChartSample[keep];
        for (int i = 0; i < keep; i++) {
            out[i] = ring[(start + i) % cap];
        }
        applyColdZeroRuns(out, cfg == null ? 0 : cfg.gapDetectSec);
        if (cfg != null) {
            applyOne(out, true, cfg.alpha, cfg.quantStep);
            applyOne(out, false, cfg.alpha, cfg.quantStep);
            applyCpuSmooth(out, cfg.cpuFilterAlpha, cfg.gapDetectSec);
        }
        return new ChartDataset(out, total, skipped);
    }

    // ==================== 列解析 ====================

    private static Integer parseInt(String s) {
        try {
            return Integer.valueOf(Integer.parseInt(s.trim()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static Long parseLong(String s) {
        try {
            return Long.valueOf(Long.parseLong(s.trim()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static float temp(Integer v) {
        return v != null && v >= 0 ? v / 10f : ChartSample.INVALID;
    }

    private static float raw(Integer v) {
        return v != null && v >= 0 ? v : ChartSample.INVALID;
    }

    /** 热端温度：0 是宿主对象在首帧有效回传前的默认值，不是 0.0℃，按无效处理。 */
    private static float tempNonZero(Integer v) {
        return v != null && v > 0 ? v / 10f : ChartSample.INVALID;
    }

    /** 风扇转速/制冷档位：设备未启动时回传 0，按无效处理（不画到 0）。 */
    private static float rawNonZero(Integer v) {
        return v != null && v > 0 ? v : ChartSample.INVALID;
    }

    /** PID 输入：C 端按 0.01°C 写，只有重算行有值，其余行（含旧数据）为 -1 → 无效。 */
    private static float pidInput(Integer v) {
        return v != null && v >= 0 ? v / 100f : ChartSample.INVALID;
    }

    /** 重算标记：非 0 即真。 */
    private static boolean asOne(String s) {
        Integer v = parseInt(s);
        return v != null && v != 0;
    }

    /**
     * 冷端 0 的整段判定：0℃ 对制冷片是合法读数，单点 0 照常画；连续达到 {@link #COLD_ZERO_RUN} 个 0
     * 才说明是宿主默认值，<b>整段（含最早那几个）</b>判无效。时间戳差 &gt; {@code gapDetectSec} 的
     * 断联处不算连续（C 端断联期间不写行）。
     */
    private static void applyColdZeroRuns(ChartSample[] s, int gapDetectSec) {
        int runStart = -1;
        long prevT = 0L;
        for (int i = 0; i < s.length; i++) {
            ChartSample d = s[i];
            if (gapDetectSec > 0 && d.t > 0 && prevT > 0 && d.t - prevT > gapDetectSec) {
                runStart = -1;
            }
            prevT = d.t;
            if (d.cold != 0f) {   // NaN 同样不等于 0，结束本段
                runStart = -1;
                continue;
            }
            if (runStart < 0) {
                runStart = i;
            }
            int run = i - runStart + 1;
            if (run == COLD_ZERO_RUN) {
                for (int j = runStart; j < i; j++) {
                    s[j].invalidateCold();
                }
            }
            if (run >= COLD_ZERO_RUN) {
                d.invalidateCold();
            }
        }
    }

    // ==================== 滤波 ====================

    private static void applyOne(ChartSample[] s, boolean hot, float alpha, float step) {
        int n = s.length;
        int[] seg = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            float v = src(s[i], hot);
            if (!ChartSample.valid(v)) {
                setOut(s[i], hot, ChartSample.INVALID);
                if (m > 0) {
                    smoothSegment(s, seg, m, hot, alpha, step);
                    m = 0;
                }
                continue;
            }
            seg[m++] = i;
        }
        if (m > 0) {
            smoothSegment(s, seg, m, hot, alpha, step);
        }
    }

    /**
     * 一段连续有效样本：先零相位双向 EMA，再最小步长格点吸附。两级各自独立关闭；<b>无论走哪条分支，
     * 段内每个样本的输出字段都会被赋值</b>。（算法口径见 app/逻辑说明.md §7.2〈热端与电池曲线滤波〉）
     */
    private static void smoothSegment(ChartSample[] s, int[] idx, int m, boolean hot,
                                      float alpha, float step) {
        if (alpha > 0f && alpha < 0.999f) {
            float prev = src(s[idx[0]], hot);
            setOut(s[idx[0]], hot, prev);
            for (int j = 1; j < m; j++) {
                prev += alpha * (src(s[idx[j]], hot) - prev);
                setOut(s[idx[j]], hot, prev);
            }
            float cur = getOut(s[idx[m - 1]], hot);
            for (int j = m - 2; j >= 0; j--) {
                cur += alpha * (getOut(s[idx[j]], hot) - cur);
                setOut(s[idx[j]], hot, cur);
            }
        } else {
            for (int j = 0; j < m; j++) {
                setOut(s[idx[j]], hot, src(s[idx[j]], hot));
            }
        }
        if (!(step > 0f)) {
            return;
        }
        // 锚点对齐 step 整格；偏差达 0.9 格才吸附（> 半格不抖动，< 1 格稳态能跨过末级台阶）
        float q = Math.round(getOut(s[idx[0]], hot) / step) * step;
        float thr = step * 0.9f;
        setOut(s[idx[0]], hot, q);
        for (int j = 1; j < m; j++) {
            float dx = getOut(s[idx[j]], hot) - q;
            if (dx >= thr || dx <= -thr) {
                q += step * Math.round(dx / step);
            }
            setOut(s[idx[j]], hot, q);
        }
    }

    // ==================== 「C平滑」：CPU 温度复刻 daemon 滤波 ====================

    /**
     * C 端控制周期（秒）：{@code update_cpu_filtered()} 只在主循环的 5 秒控制块里被调用
     * （{@code tempctrl.c} 的 {@code main_loop()} 由 {@code mono_now() - last_ctrl >= 5} 触发），
     * 而曲线数据行是每 1 秒写一行。故「每行都滤波」与 daemon 实际值不同，必须按 5 秒节奏推进状态。
     */
    static final int CPU_SMOOTH_PERIOD_SEC = 5;

    /**
     * 复刻 daemon 的 {@code cpu_filtered_temp}（{@code tempctrl.c:2188 update_cpu_filtered}）：
     * <ul>
     *   <li>输入取第 2 列<b>原始整数</b>（0.1℃，滤波前）；</li>
     *   <li>首次直接取原始值（{@code first_run} 分支），不从 0 爬；</li>
     *   <li>此后每个控制周期按 {@link #emaDir} 推进一次；</li>
     *   <li>CPU 无效（{@code cpu_now < 0}）或电池无效（{@code pid_collect_inputs} 早退）时不推进状态；</li>
     *   <li>时间戳缺口视同 daemon 重启后的 {@code first_run=1}：下一个控制周期重新直取。</li>
     * </ul>
     *
     * <p><b>控制周期相位</b>：daemon 的 5 秒节拍以自身启动时刻为相位，界面无从得知。段内行是逐秒
     * 连续的，故用「重算行」（第 10 列 = 1，只在控制周期里置位）反推段内相位；段内没有重算行时按
     * 「段首即相位 0」处理。两种情况推进次数都对，差别只在本轮取到哪一行的 CPU 值（最多偏 4 秒）。
     */
    private static void applyCpuSmooth(ChartSample[] s, int alphaPct, int gapDetectSec) {
        int alpha = alphaPct < 1 ? 1 : Math.min(alphaPct, 100);   // 与 C 端 clamp(1,100) 同口径
        int start = 0;
        while (start < s.length) {
            // 段 = 时间戳连续的一段（缺口/回退即切段；daemon 重启后 first_run=1，与切段同构）
            int end = start + 1;
            long prevT = s[start].t;
            while (end < s.length) {
                long t = s[end].t;
                if (prevT > 0L && t > 0L && (t - prevT > gapDetectSec || t < prevT)) {
                    break;
                }
                prevT = t;
                end++;
            }
            applyCpuSmoothSegment(s, start, end, alpha);
            start = end;
        }
    }

    /** 一段连续行内的滤波推进：段首相位由该段首个重算行反推（无则 0）。 */
    private static void applyCpuSmoothSegment(ChartSample[] s, int from, int to, int alpha) {
        int phase = 0;
        for (int k = from; k < to; k++) {
            if (s[k].recomp) {
                phase = (k - from) % CPU_SMOOTH_PERIOD_SEC;
                break;
            }
        }
        int state = 0;            // 0.1℃ 整数状态（同 cpu_filtered_temp）
        boolean seeded = false;
        for (int k = from; k < to; k++) {
            ChartSample d = s[k];
            boolean tick = Math.floorMod(k - from - phase, CPU_SMOOTH_PERIOD_SEC) == 0;
            if (tick && d.cpuRaw >= 0 && ChartSample.valid(d.batt)) {
                if (!seeded) {
                    state = d.cpuRaw;
                    seeded = true;
                } else {
                    state = emaDir(d.cpuRaw, state, alpha);
                }
            }
            d.cpuSmooth = seeded ? state / 10f : ChartSample.INVALID;
        }
    }

    /**
     * C 端 {@code EMA_DIR}（{@code tempctrl.c:51}）的逐位复刻：{@code alphaPct} 是<b>新值权重</b>
     * （越大越接近原始值），整数除法向 0 截断；新值更大且除不尽时再进一格，
     * 解决「渐进但永远差一格」的问题。
     */
    static int emaDir(int newVal, int oldVal, int alphaPct) {
        int num = newVal * alphaPct + oldVal * (100 - alphaPct);
        int r = num / 100;                       // Java 与 C 同为向 0 截断
        if (newVal > oldVal && num % 100 > 0) {
            r++;
        }
        return r;
    }

    private static float src(ChartSample d, boolean hot) {
        return hot ? d.hot : d.batt;
    }

    private static float getOut(ChartSample d, boolean hot) {
        return hot ? d.hotF : d.battF;
    }

    private static void setOut(ChartSample d, boolean hot, float v) {
        if (hot) {
            d.hotF = v;
        } else {
            d.battF = v;
        }
    }
}
