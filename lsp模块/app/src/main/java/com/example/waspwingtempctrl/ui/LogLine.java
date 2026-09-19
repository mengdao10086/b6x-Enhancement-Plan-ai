package com.example.waspwingtempctrl.ui;

import androidx.annotation.NonNull;

/**
 * 尾读后的一行日志：原始文本 + 判定出的级别。
 *
 * <p>级别只由 {@link LogClassifier} 判定；本类不碰颜色（颜色是界面的事，见
 * {@link LogListAdapter}）。
 */
final class LogLine {

    /** 四类 + 兜底。{@link #PLAIN} 用普通前景色，不套用日志分级色。 */
    enum Level {
        /** 错误：C 端「失败 / 无法 / 异常」类。 */
        ERROR,
        /** 警告：C 端「拒绝 / 超时 / 未就绪 / 断联」类（降级但继续运行）。 */
        WARN,
        /** 调试：C 端 {@code [DEBUG]} / {@code [PID]} 分区调试行。 */
        DEBUG,
        /** 信息：C 端正常输出的带时间戳行。 */
        INFO,
        /** 兜底：不符合 C 端任何已知行格式（如文件被外部截断留下的半行、空行）。 */
        PLAIN
    }

    final String text;
    final Level level;

    LogLine(@NonNull String text, @NonNull Level level) {
        this.text = text;
        this.level = level;
    }
}
