package com.example.waspwingtempctrl.ui;

import java.util.Arrays;
import java.util.Locale;

/**
 * 纵轴定标（口径见 {@code 逻辑说明.md} 的「曲线」一节〈双纵轴〉）。
 *
 * <p>档位梯：1、2、3，加所有 ≥5 的 5 的整数倍（无亚单位档位）。候选档位限定在
 * {@code [跨度/5, 跨度)} 内（该区间枚举完备：步长 ≥ 跨度时段数 ≤2、步长 < 跨度/5 时
 * 段数 ≥6，都不合格）；在能形成 3~5 段的候选里取离 {@code 跨度/4} 最近者，无候选则
 * 取离目标最近的档位。上下限按档位 floor/ceil 扩张，<b>绝不裁点</b>。
 */
final class ChartAxis {

    private static final int[] TICK_SMALL = {1, 2, 3, 5};
    private static final int SEG_MIN = 3;
    private static final int SEG_MAX = 5;
    private static final float PREF = 4f;

    final float min;
    final float max;
    final float step;

    private ChartAxis(float min, float max, float step) {
        this.min = min;
        this.max = max;
        this.step = step;
    }

    /**
     * 直接指定上下限的轴（右轴用：下限恒为 1、上限浮动，<b>不自算刻度</b>，故 step 无意义）。
     * 上限不大于下限时抬到下限 + 1，保证 (max-min) 恒正、{@link #y} 不退化为除零。
     */
    static ChartAxis range(float min, float max) {
        if (!(max > min)) {
            max = min + 1f;
        }
        return new ChartAxis(min, max, 0f);
    }

    /** 由数据最小/最大求整档轴（保证 min ≤ dmin、max ≥ dmax）。 */
    static ChartAxis fit(float dmin, float dmax) {
        if (!(dmax > dmin)) {
            dmax = dmin + 1f;
        }
        float span = dmax - dmin;
        float step = pickStep(dmin, dmax, span);
        return new ChartAxis((float) Math.floor(dmin / step) * step,
                (float) Math.ceil(dmax / step) * step, step);
    }

    /** 值 → 画布 y（口径见 {@code 逻辑说明.md} 的「曲线」一节〈双纵轴〉）。 */
    float y(float v, float padT, float h) {
        return padT + h * (1f - (v - min) / (max - min));
    }

    private static float pickStep(float dmin, float dmax, float span) {
        float target = span / PREF;
        float[] cands = ladderIn(span / 5f * (1f - 1e-9f), span * (1f + 1e-9f));
        float bestStep = 0f;
        float bestD = Float.MAX_VALUE;
        boolean hasBest = false;
        for (float st : cands) {
            float lo = (float) Math.floor(dmin / st) * st;
            float hi = (float) Math.ceil(dmax / st) * st;
            int segments = ticksOf(lo, hi, st).length - 1;
            if (segments < SEG_MIN || segments > SEG_MAX) {
                continue;
            }
            float dist = Math.abs(st - target);
            if (!hasBest || dist < bestD) {
                hasBest = true;
                bestStep = st;
                bestD = dist;
            }
        }
        return hasBest ? bestStep : nearestLadder(target);
    }

    /** 枚举 [lo, hi] 内的全部档位（升序）。5 由 5 的倍数分支产出，故首循环只取 1/2/3。 */
    private static float[] ladderIn(float lo, float hi) {
        float[] tmp = new float[128];
        int n = 0;
        for (int i = 0; i < 3; i++) {
            if (TICK_SMALL[i] >= lo && TICK_SMALL[i] <= hi) {
                tmp[n++] = TICK_SMALL[i];
            }
        }
        int k0 = Math.max(1, (int) Math.ceil(lo / 5f - 1e-9f));
        for (int k = k0; 5f * k <= hi + 1e-9f && n < tmp.length; k++) {
            tmp[n++] = 5f * k;
        }
        return Arrays.copyOf(tmp, n);
    }

    /** 离 t 最近的档位（闭式，无搜索）；平局取较小档位。 */
    private static float nearestLadder(float t) {
        if (!(t > 1f)) {
            return 1f;
        }
        if (t < 5f) {
            float best = 1f;
            float bd = Float.MAX_VALUE;
            for (int i = 0; i < TICK_SMALL.length; i++) {
                float d = Math.abs(TICK_SMALL[i] - t);
                if (d < bd) {
                    bd = d;
                    best = TICK_SMALL[i];
                }
            }
            return best;
        }
        float a = 5f * (float) Math.floor(t / 5f);
        float b = 5f * (float) Math.ceil(t / 5f);
        return (t - a) <= (b - t) ? Math.max(1f, a) : b;
    }

    /** 轴按 step 渲染出的刻度值数组（非整档对齐补原点刻度，末档补 max）。 */
    static float[] ticksOf(float lo, float hi, float step) {
        if (!(step > 0f)) {
            return new float[]{lo, hi};
        }
        float[] tmp = new float[256];
        int n = 0;
        float firstMult = (float) Math.ceil(lo / step - 1e-9) * step;
        if (Math.abs(lo - firstMult) > step * 1e-6f) {
            tmp[n++] = lo;
        }
        for (float v = firstMult; v <= hi + 1e-9f && n < tmp.length - 1; v += step) {
            tmp[n++] = v;
        }
        float lastMult = (float) Math.floor(hi / step + 1e-9) * step;
        if (hi - lastMult > step * 1e-6f && n < tmp.length) {
            tmp[n++] = hi;
        }
        return Arrays.copyOf(tmp, n);
    }

    /** 按 step 决定小数位（整数去掉 .0）。 */
    static String fmtTick(float v, float step) {
        String s = trimNum(step);
        int dot = s.indexOf('.');
        int dec = dot >= 0 ? Math.min(2, s.length() - dot - 1) : 0;
        String t = String.format(Locale.US, "%." + dec + "f", v);
        if (dec > 0 && t.endsWith(".0")) {
            t = t.substring(0, t.length() - 2);
        }
        return t;
    }

    private static String trimNum(float step) {
        if (step == Math.floor(step) && !Float.isInfinite(step)) {
            return String.valueOf((long) step);
        }
        return String.valueOf(step);
    }
}
