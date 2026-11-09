package com.example.waspwingtempctrl.ui;

/**
 * 曲线数据文件的一行样本。
 *
 * <p>列序与 C 端 {@code write_webui_data()} 里 {@code fprintf(wf, WEBUI_ROW_FMT, ...)} 的格式串完全一致：
 * {@code epoch,电池,CPU,热端,冷端,实际转速,目标制冷,下发目标制冷,PID输入,PID重算标记,实际制冷}。
 * 温度列已在解析层 ×0.1 折算为 ℃；哨兵值 -1（未就绪）一律转为 {@link #INVALID}，即
 * {@code v>=0 ? v/10 : 无效}（口径见 {@code lsp模块/daemon/逻辑说明.md} 的「状态页数据源（C 每 1s 写数据文件）」一节）。
 * PID 输入列单位是 0.01°C，解析层按 ×0.01 折算。
 *
 * <p>第 8 列（下发目标制冷）落盘但本界面不消费；第 9/10/11 列为后加的可选列——旧行缺列时
 * 对应项取 {@link #INVALID}/false，不整行丢弃。第 7 列与第 11 列语义不同：前者是设备回显的
 * 设定档（{@link #cool}），后者是设备实际运行档（{@link #coolActual}）。
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
    /** 冷端温度（℃）。解析层判定「连续 0 段」后可用 {@link #invalidateCold()} 改为无效。 */
    float cold;
    /** 实际风扇转速（原始 RPM，未折算）。 */
    final float rpm;
    /** 目标制冷（设备回显的设定档）。 */
    final float cool;
    /** 实际制冷（设备运行档；旧行没有第 11 列 → {@link #INVALID}）。 */
    final float coolActual;
    /** PID 实际输入（守护进程滤波后的电池温度，℃）；只有重算样本有值，其余行为 {@link #INVALID}。 */
    final float pid;
    /** 本行是否由 PID 重算触发（曲线上的重算标记点）。 */
    final boolean recomp;

    /** 电池滤波后的曲线值（仅该条参与滤波，{@code app/逻辑说明.md} §7.2〈热端与电池曲线滤波〉）。 */
    float battF = INVALID;
    /** 热端滤波后的曲线值（{@code app/逻辑说明.md} §7.2〈热端与电池曲线滤波〉）。 */
    float hotF = INVALID;

    ChartSample(long t, float batt, float cpu, float hot, float cold, float rpm, float cool,
                float coolActual, float pid, boolean recomp) {
        this.t = t;
        this.batt = batt;
        this.cpu = cpu;
        this.hot = hot;
        this.cold = cold;
        this.rpm = rpm;
        this.cool = cool;
        this.coolActual = coolActual;
        this.pid = pid;
        this.recomp = recomp;
    }

    static boolean valid(float v) {
        return !Float.isNaN(v);
    }

    /** 把一个「属于连续 0 段」的冷端样本判为无效（整段丢弃，见 {@code ChartDataset}）。 */
    void invalidateCold() {
        cold = INVALID;
    }
}
