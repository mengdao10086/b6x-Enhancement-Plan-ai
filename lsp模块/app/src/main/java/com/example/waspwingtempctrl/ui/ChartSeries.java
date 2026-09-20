package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.R;

import java.util.Locale;

/**
 * 一条曲线的静态定义与会话内开关状态。
 *
 * <p>图例顺序与默认开关（口径见 {@code 逻辑说明.md} 的「曲线」一节〈系列开关〉）：6 条曲线，
 * 默认除「冷端℃」「CPU℃」外全开；左轴 5 条（温度 ℃ 与风扇百 rpm 共轴），右轴恒 1 条（制冷）。
 *
 * <p>取值分两种口径，<b>不可混用</b>：
 * <ul>
 *   <li>{@link #value} —— 绘图与标注用，风扇折算为百 rpm（{@code 逻辑说明.md} 的「曲线」一节〈双纵轴〉）。</li>
 *   <li>{@link #axisValue} —— 仅纵轴上下限计算用，低于 {@code UI_RPM_AXIS_MIN} 的转速样本
 *       返回无效（按原始整数 rpm 比较），故低速段允许画到图外（{@code 逻辑说明.md} 的「曲线」一节〈双纵轴〉）。</li>
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
                new ChartSeries("cool", R.string.chart_series_cool, R.color.chart_series_cool,
                        AXIS_RIGHT, FMT_INT, true),
                new ChartSeries("rpm", R.string.chart_series_rpm, R.color.chart_series_rpm,
                        AXIS_LEFT, FMT_RPM, true),
                new ChartSeries("hot", R.string.chart_series_hot, R.color.chart_series_hot,
                        AXIS_LEFT, FMT_TEMP, true),
                new ChartSeries("cold", R.string.chart_series_cold, R.color.chart_series_cold,
                        AXIS_LEFT, FMT_TEMP, false),
                new ChartSeries("cpu", R.string.chart_series_cpu, R.color.chart_series_cpu,
                        AXIS_LEFT, FMT_TEMP, false),
        };
    }

    static boolean isRpm(ChartSeries s) {
        return "rpm".equals(s.id);
    }

    /** 绘图与标注取值：热端/电池走滤波值，风扇 ÷100 与 ℃ 共轴。 */
    static float value(ChartSeries s, ChartSample d) {
        switch (s.id) {
            case "batt":
                return d.battF;
            case "hot":
                return d.hotF;
            case "cold":
                return d.cold;
            case "cpu":
                return d.cpu;
            case "rpm":
                return ChartSample.valid(d.rpm) ? d.rpm / 100f : ChartSample.INVALID;
            case "cool":
                return d.cool;
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
