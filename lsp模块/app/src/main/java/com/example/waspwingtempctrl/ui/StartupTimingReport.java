package com.example.waspwingtempctrl.ui;

import com.example.waspwingtempctrl.StartupTiming;

/**
 * 启动耗时的展示层（只读）：概要一行与展开明细。
 *
 * <p>记账 API 仍在 {@link StartupTiming}；这里只通过 {@link StartupTiming#slot(int)} 读槽位，
 * 不参与任何判断。lite 不引用本类，故展示代码不会进 lite 产物。
 */
final class StartupTimingReport {

    private StartupTimingReport() {
    }

    /**
     * 折叠态的一行概要：优先给「首帧」这个端到端读数（各段并行、耗时不可相加，故没有真正的"总耗时"）；
     * 未记到首帧时退回落页判定的耗时；一个槽都没记过返回空串（调用方据此不显示这一行）。
     */
    static String summary() {
        if (!anyRecorded()) {
            return "";
        }
        long firstFrame = StartupTiming.slot(StartupTiming.MARK_FIRST_DRAW * 2);
        if (firstFrame >= 0) {
            return "启动耗时：首帧 " + firstFrame + " ms";
        }
        long landing = StartupTiming.slot(StartupTiming.LANDING * 2 + 1);
        if (landing >= 0) {
            return "启动耗时：落页判定 " + landing + " ms";
        }
        return "启动耗时：已记录（点开看各段）";
    }

    /** 拼展示文本（多行，不带前后空行）；一个槽都没记过返回空串。 */
    static String report() {
        try {
            if (!anyRecorded()) {
                return "";
            }
            StringBuilder sb = new StringBuilder(720);
            sb.append("启动耗时（相对 onCreate 首行，ms）");
            sb.append("\n起 = 该段开始时距首行的毫秒数；后台各段并行，耗时不可相加");
            appendSpan(sb, "落页判定", StartupTiming.LANDING);
            appendSpan(sb, "配置定义", StartupTiming.DEF_LOAD);
            appendSpan(sb, "配置首份快照", StartupTiming.SNAP_LOAD);
            appendSpan(sb, "曲线口径", StartupTiming.CHART_CFG);
            appendSpan(sb, "曲线数据首读", StartupTiming.CHART_DATA);
            appendSpan(sb, "建表·首屏", StartupTiming.FORM_BUILD_HEAD);
            appendSpan(sb, "建表·可见后", StartupTiming.FORM_BUILD_ROWS);
            appendSubs(sb);
            sb.append("\n预制造 · 命中 ").append(counter(StartupTiming.PRE_HIT))
                    .append(" · 未命中 ").append(counter(StartupTiming.PRE_MISS))
                    .append(" · 段二起已备 ").append(moment(StartupTiming.POOL_AT_ROWS_BEGIN))
                    .append(" · 段二末已备 ").append(moment(StartupTiming.POOL_AT_ROWS_END));
            sb.append("\n预制造 · 失败 ").append(moment(StartupTiming.MARK_PRE_FAIL))
                    .append(" · 未就绪 ").append(moment(StartupTiming.MARK_PRE_NOT_READY))
                    .append(" · 无实例 ").append(moment(StartupTiming.MARK_PRE_NO_INSTANCE))
                    .append(" · 已关门 ").append(moment(StartupTiming.MARK_PRE_CLOSED))
                    .append(" · 身份不符 ").append(moment(StartupTiming.MARK_PRE_OWNER_MISMATCH))
                    .append(" · 已启动 ").append(moment(StartupTiming.MARK_PRE_ALREADY_STARTED));
            sb.append("\n未命中构成 · 卡 ").append(counter(StartupTiming.MISS_GROUP))
                    .append(" · 行 ").append(counter(StartupTiming.MISS_ROW))
                    .append(" · 开关 ").append(counter(StartupTiming.MISS_KEY_SWITCH))
                    .append(" · 枚举组 ").append(counter(StartupTiming.MISS_ENUM_GROUP))
                    .append(" · 枚举钮 ").append(counter(StartupTiming.MISS_ENUM_BUTTON))
                    .append(" · 字段开关 ").append(counter(StartupTiming.MISS_FIELD_SWITCH))
                    .append(" · 字段 ").append(counter(StartupTiming.MISS_FIELD));
            sb.append("\n时间点 · 首读IO 起 ").append(moment(StartupTiming.MARK_CFG_IO_BEGIN))
                    .append(" · 完成 ").append(moment(StartupTiming.MARK_CFG_IO_DONE));
            sb.append("\n时间点 · onCreate 结束 ").append(moment(StartupTiming.MARK_ONCREATE_END))
                    .append(" · 判定放行 ").append(moment(StartupTiming.MARK_LANDING_WAKE))
                    .append(" · 首帧 ").append(moment(StartupTiming.MARK_FIRST_DRAW));
            sb.append("\n时间点 · 落页等待 ").append(moment(StartupTiming.MARK_LANDING_AWAIT))
                    .append(" · 首页视图 ").append(moment(StartupTiming.MARK_PAGE_VIEW_1))
                    .append(" · 三页视图 ").append(moment(StartupTiming.MARK_PAGE_VIEW_ALL))
                    .append(" · 页面选中 ").append(moment(StartupTiming.MARK_PAGE_SELECTED));
            sb.append("\n时间点 · 数据到位 ").append(moment(StartupTiming.MARK_FORM_DATA))
                    .append(" · 建表后首帧 ").append(moment(StartupTiming.MARK_AFTER_BUILD_FRAME))
                    .append(" · 曲线数据 ").append(moment(StartupTiming.MARK_CHART_DATA))
                    .append(" · 诊断上屏 ").append(moment(StartupTiming.MARK_DIAG_APPLY));
            return sb.toString();
        } catch (Throwable t) {
            return "";
        }
    }

    private static void appendSpan(StringBuilder sb, String label, int slot) {
        sb.append('\n').append(label)
                .append(" · 起 ").append(value(StartupTiming.slot(slot * 2)))
                .append(" · 耗时 ").append(value(StartupTiming.slot(slot * 2 + 1)));
    }

    private static void appendSubs(StringBuilder sb) {
        if (!anySubRecorded()) {
            return;
        }
        sb.append("\n细分 · 控件制造 ").append(ms(StartupTiming.FORM_SUB_INFLATE))
                .append(" · 说明画笔 ").append(ms(StartupTiming.FORM_SUB_PAINT))
                .append(" · 文本实测宽 ").append(ms(StartupTiming.FORM_SUB_MEASURE));
        sb.append("\n细分 · 值回填 ").append(ms(StartupTiming.FORM_SUB_FILL))
                .append(" · 挂载 ").append(ms(StartupTiming.FORM_SUB_ATTACH))
                .append(" · 自检 ").append(ms(StartupTiming.FORM_SUB_SELFCHECK));
        sb.append("\n细分 · 徽标 ").append(ms(StartupTiming.FORM_SUB_BADGE))
                .append(" · 诊断提交 ").append(ms(StartupTiming.FORM_SUB_DIAG_SUBMIT));
        long sum = 0L;
        for (int i = 0; i < StartupTiming.subCount(); i++) {
            sum += Math.max(0L, StartupTiming.slot((StartupTiming.FORM_SUB_INFLATE + i) * 2 + 1));
        }
        sb.append(" · 合计 ").append(sum);
    }

    private static String ms(int slot) {
        return value(StartupTiming.slot(slot * 2 + 1));
    }

    private static boolean anySubRecorded() {
        for (int i = 0; i < StartupTiming.subCount(); i++) {
            if (StartupTiming.slot((StartupTiming.FORM_SUB_INFLATE + i) * 2) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static String moment(int slot) {
        return value(StartupTiming.slot(slot * 2));
    }

    private static String counter(int slot) {
        return Long.toString(Math.max(0L, StartupTiming.slot(slot * 2 + 1)));
    }

    private static String value(long v) {
        return v < 0 ? "—" : Long.toString(v);
    }

    private static boolean anyRecorded() {
        for (int i = 0; i < StartupTiming.slotCount() * 2; i++) {
            if (StartupTiming.slot(i) >= 0) {
                return true;
            }
        }
        return false;
    }
}
