package com.example.waspwingtempctrl.ui;

/**
 * 数据文件解析结果 + 曲线滤波（口径清单 §2/§3/§10）。
 *
 * <p>解析口径见 {@code 逻辑说明.md} 的「状态页数据源（C 每 1s 写数据文件）」一节：
 * 按 {@code \n} 切行、<b>列数不足 8 的整行跳过</b>（不中断、不产生断点）；温度列
 * {@code v>=0 ? v/10 : 无效}，转速/制冷列 {@code v>=0 ? v : 无效}，故哨兵 -1 变无效。
 *
 * <p>行数上限 {@code rollingMaxLines}（= C 端 {@code WEBUI_DATA_MAX_LINES}）用环形覆盖保留
 * 最近 N 行，与 C 端压缩口径一致。
 *
 * <p>滤波<b>在解析后对全量样本做一次</b>（与显示窗口无关），窗口只做切片——原实现
 * {@code drawChart 每次重绘对整段样本重算}（口径见 {@code 逻辑说明.md} 的「曲线」一节〈分段处理〉），同一份数据永远得到同一条曲线。
 */
final class ChartDataset {

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
            if (p.length < 8) {
                skipped++;
                continue;
            }
            Long ts = parseLong(p[0]);
            ring[total % cap] = new ChartSample(
                    ts != null ? ts : 0L,
                    temp(parseInt(p[1])),
                    temp(parseInt(p[2])),
                    temp(parseInt(p[3])),
                    temp(parseInt(p[4])),
                    raw(parseInt(p[5])),
                    raw(parseInt(p[6])));
            total++;
        }
        int keep = Math.min(total, cap);
        int start = total <= cap ? 0 : total % cap;
        ChartSample[] out = new ChartSample[keep];
        for (int i = 0; i < keep; i++) {
            out[i] = ring[(start + i) % cap];
        }
        if (cfg != null) {
            applyOne(out, true, cfg.alpha, cfg.quantStep);
            applyOne(out, false, cfg.alpha, cfg.quantStep);
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
     * 一段连续有效样本：先零相位双向 EMA（前向一遍 + 反向一遍，反向以段末前向值为初值做
     * 末端延拓），再最小步长格点吸附。两级各自独立关闭；<b>无论走哪条分支，段内每个样本的
     * 输出字段都会被赋值</b>。
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
