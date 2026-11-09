package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.R;

import java.util.Locale;

/**
 * 一条曲线的静态定义与会话内开关状态。
 *
 * <p>图例顺序与默认开关（口径见 {@code app/逻辑说明.md} §7.6〈系列开关〉）：8 条曲线，
 * 默认除「冷端℃」「CPU℃」外全开；左轴 6 条（温度 ℃ 与风扇百 rpm 共轴），右轴 2 条
 * （目标制冷 / 实际制冷）。
 *
 * <p>取值分两种口径，<b>不可混用</b>：
 * <ul>
 *   <li>{@link #value} —— 绘图与标注用，风扇折算为百 rpm（{@code app/逻辑说明.md} §7.3〈双纵轴〉）。</li>
 *   <li>{@link #axisValue} —— 仅纵轴上下限计算用，低于 {@code UI_RPM_AXIS_MIN} 的转速样本
 *       返回无效（按原始整数 rpm 比较），故低速段允许画到图外（{@code app/逻辑说明.md} §7.3〈双纵轴〉）。</li>
 * </ul>
 */
final class ChartSeries {

    static final int AXIS_LEFT = 0;
    static final int AXIS_RIGHT = 1;

    /** 标注格式：温度一位小数 + ℃。 */
    static final int FMT_TEMP = 0;
    /** 标注格式：实际 rpm 整数（内部值已 ÷100）。 */
    static final int FMT_RPM = 1;
    /** 标注格式：整数原值（制冷档位）。 */
    static final int FMT_INT = 2;

    /** 数据字段标识。 */
    final String id;
    final int labelRes;
    final int colorRes;
    final int axis;
    final int fmt;
    /** 会话内开关（图例可切换）。 */
    boolean on;

    private ChartSeries(String id, int labelRes, int colorRes, int axis, int fmt, boolean on) {
        this.id = id;
        this.labelRes = labelRes;
        this.colorRes = colorRes;
        this.axis = axis;
        this.fmt = fmt;
        this.on = on;
    }

    static ChartSeries[] createAll() {
        return new ChartSeries[]{
                new ChartSeries("batt", R.string.chart_series_batt, R.color.chart_series_batt,
                        AXIS_LEFT, FMT_TEMP, true),
                // 实际制冷：不透明绿色实线，图例第一行第二个
                new ChartSeries("coolActual", R.string.chart_series_cool_actual,
                        R.color.chart_series_cool_actual, AXIS_RIGHT, FMT_INT, true),
                new ChartSeries("rpm", R.string.chart_series_rpm, R.color.chart_series_rpm,
                        AXIS_LEFT, FMT_RPM, true),
                new ChartSeries("hot", R.string.chart_series_hot, R.color.chart_series_hot,
                        AXIS_LEFT, FMT_TEMP, true),
                new ChartSeries("pid", R.string.chart_series_pid, R.color.chart_series_pid,
                        AXIS_LEFT, FMT_TEMP, true),
                // 目标制冷：同 RGB、60% 透明（与 pid ℃ 同款），图例第二行第二个
                new ChartSeries("cool", R.string.chart_series_cool, R.color.chart_series_cool,
                        AXIS_RIGHT, FMT_INT, true),
                new ChartSeries("cold", R.string.chart_series_cold, R.color.chart_series_cold,
                        AXIS_LEFT, FMT_TEMP, false),
                new ChartSeries("cpu", R.string.chart_series_cpu, R.color.chart_series_cpu,
                        AXIS_LEFT, FMT_TEMP, false),
        };
    }

    static boolean isRpm(ChartSeries s) {
        return "rpm".equals(s.id);
    }

    /** 是否绘制末端圆点：默认是；目标制冷只保留曲线、不画端点圆点（pid 的稀疏圆点另有来源，不受此开关影响）。 */
    static boolean drawsEndDot(ChartSeries s) {
        return !"cool".equals(s.id);
    }

    /**
     * 图例是否在该条之前另起一行（经 {@link WrapRowLayout#setBreakBefore} 施加）。
     *
     * <p>{@code true} 的是「pid ℃ / 目标制冷 / 冷端℃ / CPU℃」这一行：pid ℃ 作为第二行行首；
     * 第一行是 电池℃ / 实际制冷 / 风扇rpm / 热端℃。两行各 4 条，图例顺序即 {@link #createAll} 的数组顺序。
     */
    static boolean startsLegendRow(ChartSeries s) {
        return "pid".equals(s.id);
    }

    /** 按住查看时即使当前样本无值也保留该行（显示「-」）：pid 稀疏、实际制冷常为未就绪 -1。 */
    static boolean keepsTouchRow(ChartSeries s) {
        return "pid".equals(s.id) || "coolActual".equals(s.id);
    }

    /** 绘图与按住查看取值：热端/电池走滤波值，风扇 ÷100 与 ℃ 共轴。 */
    static float value(ChartSeries s, ChartSample d) {
        switch (s.id) {
            case "batt":
                return d.battF;
            case "hot":
                return d.hotF;
            case "pid":
                return d.pid;
            case "cold":
                return d.cold;
            case "cpu":
                return d.cpu;
            case "rpm":
                return ChartSample.valid(d.rpm) ? d.rpm / 100f : ChartSample.INVALID;
            case "cool":
                return d.cool;
            case "coolActual":
                return d.coolActual;
            default:
                return ChartSample.INVALID;
        }
    }

    /** 轴取值：在 {@link #value} 之上叠加转速下限门槛。 */
    static float axisValue(ChartSeries s, ChartSample d, int rpmAxisMin) {
        if (isRpm(s) && rpmAxisMin > 0 && ChartSample.valid(d.rpm) && d.rpm < rpmAxisMin) {
            return ChartSample.INVALID;
        }
        return value(s, d);
    }

    /** 头部标注文本：温度 ℃ 一位小数、风扇换算回实际 rpm、制冷为原值整数。 */
    static String format(ChartSeries s, float v) {
        switch (s.fmt) {
            case FMT_TEMP:
                return String.format(Locale.US, "%.1f℃", v);
            case FMT_RPM:
                return Math.round(v * 100f) + "rpm";
            default:
                return String.valueOf(Math.round(v));
        }
    }
}
