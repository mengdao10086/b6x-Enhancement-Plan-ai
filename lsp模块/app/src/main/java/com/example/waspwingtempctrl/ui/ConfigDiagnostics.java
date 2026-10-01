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
 * 配置页的诊断区（<b>只读展示</b>）：{@link ConfigStore#describeState(ConfigStore.Snapshot)}
 * （含配置文件路径与大小、落点是否与守护进程一致、参数定义加载情况、未定义键与读取提示）与配置 mtime。
 * 调用方已读过盘时把那份快照传进来（{@link #refresh(Snapshot)}），本区不再多读一次 {@code profile.conf}。
 *
 * <p>整块默认折叠（收起态下只登记欠账、不上屏）；启动耗时追加在正文之后；不提供任何写动作（I5）。
 * 只调 {@link ConfigStore} 的公开接口，读取在后台线程、主线程只做渲染。
 * 设计口径（收起欠账 / 在途排队 / 复用快照）见 app 逻辑说明.md §6.5。
 */
final class ConfigDiagnostics {

    /** 展开态的箭头旋转角：图标指向右，顺时针 90° 即指向下（收起态不转，同分组卡头）。 */
    private static final float ARROW_EXPANDED_ROTATION = 90f;

    private final ConfigStore store;
    private final ExecutorService io;
    private final Handler main;

    private final View body;
    private final ImageView arrowView;
    private final TextView mtimeView;
    private final TextView stateView;

    private boolean expanded;
    /** 最近一次上屏的配置诊断正文（不含启动耗时段）：展开时用它重算一次追加段（见 {@link #setExpanded}）。 */
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
        mtimeView = pageRoot.findViewById(R.id.config_diag_mtime);
        stateView = pageRoot.findViewById(R.id.config_diag_text);

        pageRoot.findViewById(R.id.config_diag_header).setOnClickListener(v -> setExpanded(!expanded));
        pageRoot.findViewById(R.id.config_diag_refresh).setOnClickListener(v -> refresh());
        setExpanded(false);
    }

    void setExpanded(boolean value) {
        expanded = value;
        body.setVisibility(value ? View.VISIBLE : View.GONE);
        // 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下（同分组卡头）；
        // 150ms ease-out 转过去（系统关动画时由 Motion 直落）
        Motion.rotate(arrowView, value ? ARROW_EXPANDED_ROTATION : 0f);
        arrowView.setContentDescription(body.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
        if (!value) {
            return;
        }
        // 展开那一刻才是用户看它的时候：欠账或压根没上过屏，都走"现算现上屏"（见 app 逻辑说明.md §6.5）
        if (pendingRefresh || lastState == null) {
            flushPending();
            return;
        }
        // 有现成正文：用最近一次那份重算追加段，好让比"建表"更晚的时间点（首帧 / 段二收尾）也现出来。
        // 只读几个静态槽位，无 IO、无后台线程
        stateView.setText(lastState + timingBlock());
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
     * 启动耗时段的追加形态：正文之后空一行接上；没量到任何一段（{@link StartupTiming#report()} 为空）
     * 就一个字符都不加，既有诊断文本保持逐字不变。
     */
    private static String timingBlock() {
        String report = StartupTiming.report();
        return report.isEmpty() ? "" : "\n\n" + report;
    }

    /** 后台重读诊断信息（落点一致性 / 参数定义 / 未定义键 / mtime）：没有现成快照，自己读一次。 */
    void refresh() {
        refresh(null);
    }

    /**
     * 后台刷新诊断信息，复用调用方刚读到的快照（与本类、{@link ConfigStore#describeState(Snapshot)}
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
                        final String state = store.describeState(snapshot);
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

    private void apply(Snapshot snapshot, String state) {
        refreshInFlight = false;
        if (released) {
            return;
        }
        lastState = state;
        // 正文之后追加启动耗时（旁路数据，只读几个静态槽位；没量到就什么都不加）
        stateView.setText(state + timingBlock());
        // 记账（旁路）：诊断正文上屏那一刻（首次写入胜出；诊断区在折叠体内，与首屏无关）
        StartupTiming.mark(StartupTiming.MARK_DIAG_APPLY);
        if (snapshot.exists) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                    .format(new Date(snapshot.mtimeMs));
            mtimeView.setText(mtimeView.getContext().getString(R.string.config_diag_mtime, time));
        } else {
            mtimeView.setText(mtimeView.getContext().getString(R.string.config_diag_mtime_missing));
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
