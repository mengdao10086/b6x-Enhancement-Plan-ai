package com.example.waspwingtempctrl.ui;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.ConfigStore;
import com.example.waspwingtempctrl.ConfigStore.Snapshot;
import com.example.waspwingtempctrl.R;
import com.example.waspwingtempctrl.StartupTiming;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/**
 * 配置页的诊断区（<b>只读展示</b>）：{@link ConfigDiagnosticsText#describeState(ConfigStore, Snapshot)}
 * （含配置文件路径与大小、落点是否与守护进程一致、参数定义加载情况、未定义键与读取提示）与配置 mtime。
 * 调用方已读过盘时把那份快照传进来（{@link #refresh(Snapshot)}），本区不再多读一次 {@code profile.conf}。
 *
 * <p>整块默认折叠（收起态下只登记欠账、不上屏）；块内参数定义行与启动耗时各是一行独立的可折叠行
 * （前者收起只报文件名、点开原地换成键渲染自检计数并把配置 mtime 并入同一段文本；后者收起只报首帧、
 * 点开列各段明细）。两行都是<b>原地换文本 + 行高按内容补间</b>，箭头与行高同一时长。
 * 不提供任何写动作（I5）。
 * 只调 {@link ConfigStore} 的公开接口，读取在后台线程、主线程只做渲染。
 * 设计口径（收起欠账 / 在途排队 / 复用快照）见 app 逻辑说明.md §6.5。
 */
final class ConfigDiagnostics {

    private final ConfigStore store;
    private final ExecutorService io;
    private final Handler main;

    private final View body;
    private final ImageView arrowView;
    /** 参数定义行（块内可展开项）：文字按展开态原地切换（收起只报文件名、展开报自检计数 + 配置 mtime），换文本时行高补间。 */
    private final View defsRow;
    private final ImageView defsArrow;
    private final TextView defsView;
    /** 参数定义行的两态文案（由页面按自检结果写入，见 {@link #setDefsSummary}）。 */
    private CharSequence defsSummaryCollapsed;
    private CharSequence defsSummaryExpanded;
    /** 配置 mtime 展示文本，并入参数定义行展开态；首次成功读盘前为 null。 */
    private CharSequence mtimeText;
    private final TextView stateView;
    /** 启动耗时折叠行：收起只显示一行概要（首帧），点开才列各段明细（换文本时行高补间）。 */
    private final View timingRow;
    private final ImageView timingArrow;
    private final TextView timingView;
    /** 同体上方的「数据文件信息」行（曲线区经 ChartFragment.Host 写）：只读来判它此刻是不是还停在占位。 */
    private final TextView datafileView;

    private boolean expanded;
    /** 参数定义行自己的展开态（行文字按它原地切换；展开态文案里含配置 mtime）。 */
    private boolean defsExpanded;
    /** 启动耗时明细是否展开；概要为空（一个槽都没记）时恒为 false。 */
    private boolean timingExpanded;
    /** 最近一次上屏的配置诊断正文：面板展开时直接用它上屏，不再向后台要一份。 */
    private String lastState;
    /** 在途标记：一次刷新（后台取数 + 主线程上屏）没跑完就不再起第二个。 */
    private boolean refreshInFlight;
    /** 在途期间到达的请求：作废不得，等本轮结束再刷一次（见 {@link #refresh(Snapshot)}）。 */
    private boolean refreshQueued;
    /** 排队请求里"自读盘"那一路（磁盘可能刚被写过，比任何快照都新）。 */
    private boolean queuedSelfRead;
    /** 排队请求里最近一次带来的快照（有"自读盘"的请求时以自读盘为准）。 */
    private Snapshot queuedKnown;
    /**
     * 收起期间欠下的一次刷新（见 {@link #refresh(Snapshot)} 与 {@link #setExpanded(boolean)}）：
     * 收起时只登记、不上屏，展开那一刻再补；多次请求合并成一笔。见 app 逻辑说明.md §6.5。
     */
    private boolean pendingRefresh;
    private boolean pendingSelfRead;
    private Snapshot pendingKnown;
    private boolean released;

    ConfigDiagnostics(@NonNull View pageRoot, @NonNull ConfigStore store, @NonNull ExecutorService io,
                      @NonNull Handler main) {
        this.store = store;
        this.io = io;
        this.main = main;

        body = pageRoot.findViewById(R.id.config_diag_body);
        arrowView = pageRoot.findViewById(R.id.config_diag_arrow);
        defsRow = pageRoot.findViewById(R.id.config_diag_defs_row);
        defsArrow = pageRoot.findViewById(R.id.config_diag_defs_arrow);
        defsView = pageRoot.findViewById(R.id.config_diag_defs);
        // 兜底文案：定义没加载起来时也要有一行可读内容（失败原因由页面写进同一格）；
        // 正常路径由 ConfigFormFragment 写入两态文案（分项数字只有页面知道）
        CharSequence defsName = pageRoot.getContext().getString(
                R.string.config_diag_defs_name, ConfigStore.PARAMS_ASSET);
        defsSummaryCollapsed = defsName;
        defsSummaryExpanded = defsName;   // 自检还没跑：展开态先与收起态同文
        applyDefsSummary();
        defsRow.setOnClickListener(v -> toggleDefs());
        // 长按整行复制行内文字：展开态已含配置 mtime，整段一并复制（不留独立的 mtime 视图）
        TextCopy.copyOnLongPress(defsRow, defsView::getText);
        stateView = pageRoot.findViewById(R.id.config_diag_text);
        datafileView = pageRoot.findViewById(R.id.config_diag_datafile_text);
        timingRow = pageRoot.findViewById(R.id.config_diag_timing_row);
        timingArrow = pageRoot.findViewById(R.id.config_diag_timing_arrow);
        timingView = pageRoot.findViewById(R.id.config_diag_timing);
        // 短按展开、长按复制同挂整行（子 TextView 挂长按会消费触摸，整行点击就收不到）
        TextCopy.copyOnLongPress(timingRow, timingView::getText);
        timingRow.setOnClickListener(v -> toggleTiming());
        refreshTimingSummary();

        // 「诊断信息」标题行控制整块；参数定义行只原地切换自己那一行的文案（内容已并入行文本）
        pageRoot.findViewById(R.id.config_diag_header).setOnClickListener(v -> setExpanded(!expanded));
        pageRoot.findViewById(R.id.config_diag_refresh).setOnClickListener(v -> refresh());
        setExpanded(false);
    }

    void setExpanded(boolean value) {
        expanded = value;
        // 正文先定、再量高、最后箭头用同一次返回的时长转——箭头与面板同生共灭，不另设箭头常量
        final long duration;
        if (!value) {
            duration = Motion.animateHeight(body, false);
        } else if (pendingRefresh || lastState == null) {
            // 正文还要读盘才回来：先只放一行占位、动画展开到占位高（不露旧正文、不闪帧），
            // 正文上屏时再由 apply() 从当前高度续动画到最终实高——两段动画，见 app 逻辑说明.md §8.4
            stateView.setText(placeholderText());
            duration = Motion.animateHeight(body, true);
            flushPending();
        } else {
            // 有现成正文：**先上屏、再量高**——量高发生在正文之上，展开时长与终点才是最终实高（末尾不跳）。
            // 只读几个静态槽位，无 IO、无后台线程
            stateView.setText(lastState);
            duration = Motion.animateHeight(body, true);
        }
        // 一副图标两种状态：展开转 90° 指向下、收起指右；时长来自上面那一次面板计算
        // （面板直接落位时 duration<0，箭头也直接落位）。角度与无障碍描述口径统一在 Motion.syncExpandArrow
        Motion.syncExpandArrow(arrowView, value, duration);
    }

    /**
     * 正文位该放的占位文本：同体上方的「数据文件信息」行此刻若仍停在「读取中…」（曲线区首份数据还没
     * 回来，它的 XML 初值就是这个），就让它当这一屏<b>唯一</b>的占位、正文位留空——否则一屏会同时出现
     * 两行一模一样的「读取中…」。两行都回来后各自照常上屏，故只在占位这一步去重。
     */
    private CharSequence placeholderText() {
        String loading = body.getContext().getString(R.string.chart_loading);
        if (datafileView != null && loading.contentEquals(datafileView.getText())) {
            return "";
        }
        return loading;
    }

    /**
     * 补上收起期间欠下的那一笔刷新（没有欠账时按"自读盘"补一次，用于"一次都没上过屏"）；
     * 与 {@link #refresh(Snapshot)} 的在途排队同构。
     */
    private void flushPending() {
        final Snapshot next = pendingSelfRead ? null : pendingKnown;
        pendingRefresh = false;
        pendingSelfRead = false;
        pendingKnown = null;
        refresh(next);
    }

    /**
     * 启动耗时折叠行：概要为空（一个槽都没记）时整行不显示；收起态每次刷新都更新概要，
     * 展开态保持用户正在看的那份明细、不被后台刷新打断。
     */
    private void refreshTimingSummary() {
        String summary = StartupTimingReport.summary();
        boolean expandable = !summary.isEmpty();
        timingRow.setVisibility(expandable ? View.VISIBLE : View.GONE);
        timingRow.setClickable(expandable);
        if (!expandable) {
            timingExpanded = false;
        }
        if (!timingExpanded) {
            timingView.setText(summary);
            Motion.syncExpandArrow(timingArrow, false, -1L);
        }
    }

    /**
     * 点参数定义行：<b>原地换文案</b>（收起只报文件名、展开报键渲染自检计数 + 配置 mtime），
     * 行高按内容变化补间，三角与行高同一时长（不可补间时退回 180ms）。交互与启动耗时行同一套。
     */
    private void toggleDefs() {
        int from = defsRow.getHeight();
        defsExpanded = !defsExpanded;
        applyDefsSummary();
        long duration = Motion.animateHeightChange(defsRow, from, measureRowHeight(defsRow));
        Motion.syncExpandArrow(defsArrow, defsExpanded, duration >= 0 ? duration : 180L);
    }

    /**
     * 写「参数定义」行的两态文案：数字只有页面算得出（见 {@code ConfigFormFragment#renderSelfCheck}）。
     * 当前展开态那一句立刻上屏，另一句留到下次切换。
     */
    void setDefsSummary(@NonNull CharSequence collapsed, @NonNull CharSequence expanded) {
        defsSummaryCollapsed = collapsed;
        defsSummaryExpanded = expanded;
        applyDefsSummary();
    }

    /** 按当前展开态把「参数定义」行的文字写回（两态文案的唯一落点；展开态并入配置 mtime）。 */
    private void applyDefsSummary() {
        defsView.setText(defsExpanded
                ? (mtimeText == null ? defsSummaryExpanded : defsSummaryExpanded + "\n" + mtimeText)
                : defsSummaryCollapsed);
    }

    /** 点启动耗时行：展开看各段明细，再点收起（行高补间，三角与行高同一时长；不可补间时退回 180ms）。 */
    private void toggleTiming() {
        if (StartupTimingReport.summary().isEmpty()) {
            return;
        }
        int from = timingRow.getHeight();
        timingExpanded = !timingExpanded;
        timingView.setText(timingExpanded ? StartupTimingReport.report() : StartupTimingReport.summary());
        long duration = Motion.animateHeightChange(timingRow, from, measureRowHeight(timingRow));
        Motion.syncExpandArrow(timingArrow, timingExpanded, duration >= 0 ? duration : 180L);
    }

    /**
     * 量行容器在当前宽度下的自然高（须在换文本之后调用）。宽还没布局（为 0）时返回 0，
     * 调用方据此直接落位、不补间——量不出最终宽时量出的高不可信。
     */
    private static int measureRowHeight(@NonNull View row) {
        int width = row.getWidth();
        if (width <= 0) {
            return 0;
        }
        row.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        return row.getMeasuredHeight();
    }

    /** 后台重读诊断信息（落点一致性 / 参数定义 / 未定义键 / mtime）：没有现成快照，自己读一次。 */
    void refresh() {
        refresh(null);
    }

    /**
     * 后台刷新诊断信息，复用调用方刚读到的快照（与本类、{@link ConfigDiagnosticsText#describeState(ConfigStore, Snapshot)}
     * 都不再各读一次 {@code profile.conf}；mtime 也取快照自己的字段）。在途期间到达的请求排队重跑、不丢；
     * 收起态下只登记、不上屏。见 app 逻辑说明.md §6.5。
     *
     * @param known 调用方刚读到的快照；null = 本类自己读一次
     */
    void refresh(@Nullable Snapshot known) {
        if (released || io.isShutdown()) {
            return;
        }
        if (!expanded) {
            pendingRefresh = true;
            if (known == null) {
                pendingSelfRead = true;
            } else {
                pendingKnown = known;
            }
            return;
        }
        if (refreshInFlight) {
            refreshQueued = true;
            if (known == null) {
                queuedSelfRead = true;
            } else {
                queuedKnown = known;
            }
            return;
        }
        start(known);
    }

    /** 起一次刷新（主线程调；{@link #refreshInFlight} 由本方法与 {@link #apply} 一进一出地持有）。 */
    private void start(@Nullable Snapshot known) {
        refreshInFlight = true;
        try {
            io.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Snapshot snapshot = known != null ? known : store.read();
                        // 参数定义行由本类单独上屏（与清理按钮同排），正文只放落点/数量/提示
                        final String state = ConfigDiagnosticsText.describePathsAndNotes(store, snapshot);
                        main.post(new Runnable() {
                            @Override
                            public void run() {
                                apply(snapshot, state);
                            }
                        });
                    } catch (RuntimeException e) {
                        // 读盘抛了：本轮作废，但在途标记必须清掉——留着会把后面的请求一起吞掉
                        main.post(new Runnable() {
                            @Override
                            public void run() {
                                refreshInFlight = false;
                                if (released) {
                                    return;   // 页面已销毁：连失败文案也不写（与 apply 同构）
                                }
                                showLoadFailure(e);
                                runQueued();
                            }
                        });
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            // 页面已销毁：这一轮不成立，同样别把在途标记留在 true 上
            refreshInFlight = false;
        }
    }

    /**
     * 读盘失败：正文位立刻给出真实失败文案（<b>不留「读取中…」占位</b>），展开态下从当前高度动画过去。
     * 复用曲线区已有的「读取失败：…」前缀，不新增字符串资源；失败后 {@link #lastState} 保持 null，
     * 下次展开会重新走占位 + 取数。
     */
    private void showLoadFailure(RuntimeException e) {
        stateView.setText(stateView.getContext().getString(R.string.chart_fail_read, e.toString()));
        if (expanded) {
            Motion.animateHeight(body, true);
        }
    }

    private void apply(Snapshot snapshot, String state) {
        refreshInFlight = false;
        if (released) {
            return;
        }
        lastState = state;
        // 正选中时跳过本轮：setText 会清掉选择与手柄；选择结束后补上这一版正文
        if (TextCopy.isSelecting(stateView)) {
            TextCopy.runWhenSelectionEnds(stateView, () -> stateView.setText(lastState));
        } else {
            stateView.setText(state);
        }
        // 记账（旁路）：诊断正文上屏那一刻（首次写入胜出；诊断区在折叠体内，与首屏无关）
        StartupTiming.mark(StartupTiming.MARK_DIAG_APPLY);
        refreshTimingSummary();
        if (snapshot.exists) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date(snapshot.mtimeMs));
            mtimeText = defsView.getContext().getString(R.string.config_diag_mtime, time);
        } else {
            mtimeText = defsView.getContext().getString(R.string.config_diag_mtime_missing);
        }
        // mtime 已并入参数定义行：此刻正展开着就立刻重写行文本（**先写文本、再量高**，否则展开时高度会跳）
        if (defsExpanded) {
            applyDefsSummary();
        }
        // 正文已就绪：此刻展开着就**从当前高度续动画到最终实高**——既补上"占位→正文"的第二段，
        // 也让展开态下的内容变化走动画。量高发生在正文与行文本已定之后，故终点即最终实高（末尾不跳）
        if (expanded) {
            Motion.animateHeight(body, true);
        }
        runQueued();
    }

    /** 本轮结束后：在途期间来的请求立刻补一轮（一个都不丢），没有就歇着。 */
    private void runQueued() {
        if (!refreshQueued) {
            return;
        }
        final Snapshot next = queuedSelfRead ? null : queuedKnown;
        refreshQueued = false;
        queuedSelfRead = false;
        queuedKnown = null;
        refresh(next);
    }

    /** 页面视图销毁时调：断开视图引用，避免后台回调打到已销毁的视图上。 */
    void release() {
        released = true;
    }
}
