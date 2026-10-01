package com.example.waspwingtempctrl.ui;

/**
 * 显示窗口：按档位/行数上限切片，并算好断联空白。
 *
 * <p>时间轴口径（x 公式、正常段 1 行 = 1 格、断联处按 {@code min(dt, gapMaxSec)} 封顶补偿、时间戳只用于
 * 裁剪与断联判定、裁剪先按条数再按时间收紧）见 app/逻辑说明.md §7.2。
 */
final class ChartWindow {

    /** 窗口内样本。 */
    final ChartSample[] samples;
    /** 归一化 x ∈ [0,1]（乘 W 加 padL 即为画布 x）。 */
    final float[] u;
    /** {@code broken[i]=true}：第 i 点之前有断联，落笔要断开（不连桥）。 */
    final boolean[] broken;
    /** 窗口内的断联段数。 */
    final int breaks;
    /** 窗口内断联的真实秒数合计（含封顶前）。 */
    final int breakSeconds;

    private ChartWindow(ChartSample[] samples, float[] u, boolean[] broken, int breaks,
                        int breakSeconds) {
        this.samples = samples;
        this.u = u;
        this.broken = broken;
        this.breaks = breaks;
        this.breakSeconds = breakSeconds;
    }

    static ChartWindow of(ChartDataset ds, int winSec, int maxLines, int detectSec, int maxSec) {
        ChartSample[] all = ds.all;
        int n = all.length;
        if (n == 0) {
            return new ChartWindow(new ChartSample[0], new float[0], new boolean[0], 0, 0);
        }
        int win = Math.max(1, winSec);
        int cap = Math.max(1, maxLines);
        int start = Math.max(0, Math.max(n - win, n - cap));
        long lastT = all[n - 1].t;
        while (start < n - 1 && all[start].t < lastT - win) {
            start++;
        }
        int len = n - start;
        ChartSample[] samples = new ChartSample[len];
        System.arraycopy(all, start, samples, 0, len);

        float[] gap = new float[len];
        boolean[] broken = new boolean[len];
        float totalGap = 0f;
        int breaks = 0;
        int breakSeconds = 0;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                long dt = samples[i].t - samples[i - 1].t;
                if (dt > detectSec) {
                    totalGap += Math.min(dt, maxSec);
                    broken[i] = true;
                    breaks++;
                    breakSeconds += (int) dt;
                }
            }
            gap[i] = totalGap;
        }
        float totalUnits = (len > 1 ? len - 1 : 0) + totalGap;
        float[] u = new float[len];
        for (int i = 0; i < len; i++) {
            u[i] = totalUnits > 0f ? (i + gap[i]) / totalUnits : 0f;
        }
        return new ChartWindow(samples, u, broken, breaks, breakSeconds);
    }
}
