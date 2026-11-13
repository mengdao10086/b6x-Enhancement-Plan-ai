package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.R;

import java.util.Locale;

/**
 * 一条曲线的静态定义与会话内开关状态。
 *
 * <p>图例顺序与默认开关（口径见 {@code app/逻辑说明.md} §7.6〈系列开关〉）：9 条曲线，
 * 默认除「冷端℃」「CPU℃」外全开；左轴 7 条（温度 ℃ 与风扇百 rpm 共轴），右轴 2 条
 * （目标制冷 / 实际制冷）。图例两行 5+4：第一行 电池℃ / 实际制冷 / 实际rpm / 热端℃ / 冷端℃，
 * 第二行 pid ℃ / 目标制冷 / 目标rpm / CPU℃。
 *
 * <p>取值分两种口径，<b>不可混用</b>：
 * <ul>
 *   <li>{@link #value} —— 绘图与标注用，风扇折算为百 rpm（{@code app/逻辑说明.md} §7.3〈双纵轴〉）。</li>
 *   <li>{@link #axisValue} —— 仅纵轴上下限计算用，低于 {@code UI_RPM_AXIS_MIN} 的转速样本
 *       返回无效（按原始整数 rpm 比较），故低速段允许画到图外（{@code app/逻辑说明.md} §7.3〈双纵轴〉）。</li>
 * </ul>
 *
 * <p><b>强调 / 参考</b>：制冷与风扇各是一对「实际 / 目标」。同一时刻每对只有一条是强调方
 * （不透明实线 + 末端圆点 + 末端数值），另一条是参考方（同 RGB 半透明、无圆点无数值）。
 * 默认强调「实际」，{@code UI_CHART_SWAP} 的第 1/2 值分别控制制冷对/风扇对是否换成强调「目标」。
 * 判定只此一处 {@link #emphasized}，图例位置、颜色、线样式、末端圆点/数值、按住查看全部由它派生。
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
                // 实际制冷：强调方，图例第一行第二个
                new ChartSeries("coolActual", R.string.chart_series_cool_actual,
                        R.color.chart_series_cool_actual, AXIS_RIGHT, FMT_INT, true),
                // 实际rpm：强调方，图例第一行第三个
                new ChartSeries("rpmActual", R.string.chart_series_rpm_actual,
                        R.color.chart_series_rpm_actual, AXIS_LEFT, FMT_RPM, true),
                new ChartSeries("hot", R.string.chart_series_hot, R.color.chart_series_hot,
                        AXIS_LEFT, FMT_TEMP, true),
                new ChartSeries("cold", R.string.chart_series_cold, R.color.chart_series_cold,
                        AXIS_LEFT, FMT_TEMP, false),
                // pid ℃ 是第二行行首
                new ChartSeries("pid", R.string.chart_series_pid, R.color.chart_series_pid,
                        AXIS_LEFT, FMT_TEMP, true),
                // 目标制冷：参考方（默认），图例第二行第二个
                new ChartSeries("cool", R.string.chart_series_cool, R.color.chart_series_cool,
                        AXIS_RIGHT, FMT_INT, true),
                // 目标rpm：参考方（默认），图例第二行第三个
                new ChartSeries("rpm", R.string.chart_series_rpm, R.color.chart_series_rpm,
                        AXIS_LEFT, FMT_RPM, true),
                new ChartSeries("cpu", R.string.chart_series_cpu, R.color.chart_series_cpu,
                        AXIS_LEFT, FMT_TEMP, false),
        };
    }

    static boolean isCoolPair(ChartSeries s) {
        return "coolActual".equals(s.id) || "cool".equals(s.id);
    }

    static boolean isRpmPair(ChartSeries s) {
        return "rpmActual".equals(s.id) || "rpm".equals(s.id);
    }

    static boolean isRpm(ChartSeries s) {
        return isRpmPair(s);
    }

    static boolean isPair(ChartSeries s) {
        return isCoolPair(s) || isRpmPair(s);
    }

    /**
     * <b>单一强调判定</b>：成对系列里当前谁是强调方。默认（槽值 0）强调「实际」；
     * 制冷对只看 {@link ChartConfig#swapCool}，风扇对只看 {@link ChartConfig#swapRpm}，
     * 两对互不影响。非成对系列返回 {@code true}（不参与强调/参考切换）。
     */
    static boolean emphasized(ChartSeries s, ChartConfig cfg) {
        if (!isPair(s)) {
            return true;
        }
        boolean swap = cfg != null && (isCoolPair(s) ? cfg.swapCool : cfg.swapRpm);
        boolean isActual = "coolActual".equals(s.id) || "rpmActual".equals(s.id);
        return isActual != swap;   // 强调方 = 实际方 XOR 该对的交换
    }

    /**
     * 按强调角色取色：强调方用同对的不透明色，参考方用同 RGB 的半透明色。
     * 交换开关因此同时交换两条线的颜色，而不只是交换位置。
     */
    static int colorRes(ChartSeries s, ChartConfig cfg) {
        if (isCoolPair(s)) {
            return emphasized(s, cfg) ? R.color.chart_series_cool_actual : R.color.chart_series_cool;
        }
        if (isRpmPair(s)) {
            return emphasized(s, cfg) ? R.color.chart_series_rpm_actual : R.color.chart_series_rpm;
        }
        return s.colorRes;
    }

    /** 是否绘制末端圆点：成对系列只有强调方画；其余系列保持原样（pid 的稀疏圆点另有来源）。 */
    static boolean drawsEndDot(ChartSeries s, ChartConfig cfg) {
        return !isPair(s) || emphasized(s, cfg);
    }

    /** 是否绘制末端数值标签：成对系列的强调方画，其余系列都不标。 */
    static boolean drawsEndLabel(ChartSeries s, ChartConfig cfg) {
        return isPair(s) && emphasized(s, cfg);
    }

    /**
     * 图例是否在该条之前另起一行（经 {@link WrapRowLayout#setBreakBefore} 施加）。
     *
     * <p>{@code true} 的是「pid ℃ / 目标制冷 / 目标rpm / CPU℃」这一行：pid ℃ 作为第二行行首；
     * 第一行是 电池℃ / 实际制冷 / 实际rpm / 热端℃ / 冷端℃。两行 5+4，图例顺序即
     * {@link #displayOrder} 的显示顺序。
     */
    static boolean startsLegendRow(ChartSeries s) {
        return "pid".equals(s.id);
    }

    /**
     * 按住查看时即使当前样本无值也保留该行（显示「-」）：pid 稀疏；成对系列的强调方
     * 可能因未就绪或旧行缺列而无值（尤其实际rpm 在旧 11 列行里恒无效）。
     */
    static boolean keepsTouchRow(ChartSeries s, ChartConfig cfg) {
        return "pid".equals(s.id) || (isPair(s) && emphasized(s, cfg));
    }

    /**
     * 图例/按住查看的显示顺序（存的是 {@code all} 的数组下标）。默认即数组顺序；
     * 交换开关只把对应一对的两条槽位对调，断行位置（pid ℃）不变。
     */
    static int[] displayOrder(ChartSeries[] all, ChartConfig cfg) {
        int[] order = new int[all.length];
        for (int i = 0; i < all.length; i++) {
            order[i] = i;
        }
        // 位置也由强调判定派生：强调方占默认槽位（第一行对应格），参考方换到第二行对应格
        int iCoolActual = indexOf(all, "coolActual");
        if (iCoolActual >= 0 && !emphasized(all[iCoolActual], cfg)) {
            swapSlots(order, iCoolActual, indexOf(all, "cool"));
        }
        int iRpmActual = indexOf(all, "rpmActual");
        if (iRpmActual >= 0 && !emphasized(all[iRpmActual], cfg)) {
            swapSlots(order, iRpmActual, indexOf(all, "rpm"));
        }
        return order;
    }

    private static int indexOf(ChartSeries[] all, String id) {
        for (int i = 0; i < all.length; i++) {
            if (id.equals(all[i].id)) {
                return i;
            }
        }
        return -1;
    }

    private static void swapSlots(int[] order, int a, int b) {
        int pa = -1;
        int pb = -1;
        for (int i = 0; i < order.length; i++) {
            if (order[i] == a) {
                pa = i;
            } else if (order[i] == b) {
                pb = i;
            }
        }
        if (pa >= 0 && pb >= 0) {
            order[pa] = b;
            order[pb] = a;
        }
    }

    /** 原始 rpm 值（轴门槛按原始整数比较）：实际rpm 取第 12 列，目标rpm 取第 6 列。 */
    private static float rawRpm(ChartSeries s, ChartSample d) {
        return "rpmActual".equals(s.id) ? d.rpmActual : d.rpmTarget;
    }

    /** 绘图与按住查看取值：热端/电池走滤波值，两条 rpm 都 ÷100 与 ℃ 共轴。 */
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
            case "rpmActual": {
                float raw = rawRpm(s, d);
                return ChartSample.valid(raw) ? raw / 100f : ChartSample.INVALID;
            }
            case "cool":
                return d.cool;
            case "coolActual":
                return d.coolActual;
            default:
                return ChartSample.INVALID;
        }
    }

    /** 轴取值：在 {@link #value} 之上叠加转速下限门槛（两条 rpm 都生效）。 */
    static float axisValue(ChartSeries s, ChartSample d, int rpmAxisMin) {
        if (isRpm(s)) {
            float raw = rawRpm(s, d);
            if (rpmAxisMin > 0 && ChartSample.valid(raw) && raw < rpmAxisMin) {
                return ChartSample.INVALID;
            }
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
