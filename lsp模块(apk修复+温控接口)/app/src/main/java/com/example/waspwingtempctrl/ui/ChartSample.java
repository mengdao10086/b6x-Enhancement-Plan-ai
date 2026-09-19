package com.example.waspwingtempctrl.ui;

/**
 * 曲线数据文件的一行样本。
 *
 * <p>列序与 C 端 {@code write_webui_data()} 完全一致（{@code tempctrl.c:2665}）：
 * {@code epoch,电池,CPU,热端,冷端,实际转速,实际制冷,目标制冷}。温度列已在解析层
 * ×0.1 折算为 ℃；哨兵值 -1（未就绪）一律转为 {@link #INVALID}，与 WebUI 的
 * {@code temp(v) = v>=0 ? v/10 : null} 同一口径（{@code 逻辑说明.md} 的「状态页数据源（C 每 1s 写数据文件）」一节）。
 *
 * <p>第 8 列（目标制冷）落盘但 WebUI 从未消费，本类同样不保留。
 */
final class ChartSample {

    /** 无效值哨兵（NaN）。原实现用 {@code null} 表示，绘制与滤波都以"无效即断档"处理。 */
    static final float INVALID = Float.NaN;

    /** Unix 秒（C 端 {@code (long)time(NULL)}）。 */
    final long t;
    /** 电池温度（℃）。 */
    final float batt;
    /** CPU 温度（℃）。 */
    final float cpu;
    /** 热端温度（℃）。 */
    final float hot;
    /** 冷端温度（℃）。 */
    final float cold;
    /** 实际风扇转速（原始 RPM，未折算）。 */
    final float rpm;
    /** 实际制冷强度（制冷档位）。 */
    final float cool;

    /** 电池滤波后的曲线值（仅该条参与滤波，{@code 逻辑说明.md} 的「曲线」一节〈热端与电池曲线滤波〉）。 */
    float battF = INVALID;
    /** 热端滤波后的曲线值（{@code 逻辑说明.md} 的「曲线」一节〈热端与电池曲线滤波〉）。 */
    float hotF = INVALID;

    ChartSample(long t, float batt, float cpu, float hot, float cold, float rpm, float cool) {
        this.t = t;
        this.batt = batt;
        this.cpu = cpu;
        this.hot = hot;
        this.cold = cold;
        this.rpm = rpm;
        this.cool = cool;
    }

    static boolean valid(float v) {
        return !Float.isNaN(v);
    }
}
