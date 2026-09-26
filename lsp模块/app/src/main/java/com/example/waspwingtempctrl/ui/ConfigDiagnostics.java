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
 * （含配置文件路径与大小、落点是否与守护进程一致、参数定义加载情况（键数或失败原因）、
 * 文件里的未定义键与读取提示）与配置 mtime。调用方已读过盘时把那份快照传进来
 * （{@link #refresh(Snapshot)}），本区不再多读一次 {@code profile.conf}。
 *
 * <p>本区整块默认折叠（{@code config_diag_body} 初始 gone）：数据文件信息、键渲染自检
 * （由 {@link ConfigFormFragment} 写进 {@code config_diag_selfcheck}）与本节正文都在折叠体内，
 * 展开才占高度。本类只管自己的两个 TextView，不碰自检那份（它每次刷新都会被整段覆盖）。
 *
 * <p>本区不提供任何写动作：出厂配置由 {@link com.example.waspwingtempctrl.Deployer} 在部署时写出
 * （{@code ConfigStore.writeFactoryIfAbsent()} 的 javadoc 明确"界面不要自己调"），
 * 界面另开一个写入口就是绕过 I5 的重复写入路径。
 *
 * <p><b>启动耗时是追加在正文之后的</b>（见 {@link StartupTiming}）：既有的诊断正文一个字不动，只在
 * 其后空一行接一段"启动各段耗时"。它落在本折叠体内（默认收起），故不新增开关也不会常驻界面；
 * 展开时重算一次，好让比"建表"更晚的时间点也现出来。真机排障用，不参与任何判断。
 *
 * <p><b>收起态下不上屏</b>：本区整块默认收起，收起期间的刷新只登记一笔欠账（见 {@link #refresh(Snapshot)}），
 * 展开那一刻才现算现上屏——启动链上那一次"建表触发的刷新"因此不再落在关键路径上；数字一个都不少
 * （展开即见），只是"何时算、何时上屏"推迟到用户真的看得见的时候。
 *
 * <p>只调 {@link ConfigStore} 的公开接口，不碰文件、不拼 shell；读取在后台线程，主线程只做渲染。
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
     * 收起期间欠下的一次刷新（见 {@link #refresh(Snapshot)} 与 {@link #setExpanded(boolean)}）。
     *
     * <p>本区整块默认收起，收起时它一个字都看不见：为它跑一趟后台、再往三个不可见的 TextView 里
     * setText（正文那次还会把整块标脏、连带一次整页重排），在启动链上是纯开销。故收起时只登记这一笔，
     * 展开那一刻再补。多次请求合并成一笔，口径与"在途排队"那三个字段一致（自读盘优先、否则取最新快照）。
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
        // 一副图标两种状态：图标本身指向右，展开时顺时针转 90° 指向下（同分组卡头）
        arrowView.setRotation(value ? ARROW_EXPANDED_ROTATION : 0f);
        arrowView.setContentDescription(body.getContext().getString(
                value ? R.string.config_action_collapse : R.string.config_action_expand));
        if (!value) {
            return;
        }
        // 展开那一刻才是用户看它的时候。两种情况都走"现算现上屏"：一是收起期间欠下的那一笔
        // （见 refresh），二是压根没上过屏（例如定义没到位那条路，或页面刚建好就展开）
        if (pendingRefresh || lastState == null) {
            flushPending();
            return;
        }
        // 有现成正文：用最近一次那份重算追加段，好让比"建表"更晚的时间点（首帧 / 撤占位层）也现出来。
        // 只读几个静态槽位，无 IO、无后台线程
        stateView.setText(lastState + timingBlock());
    }

    /**
     * 补上收起期间欠下的那一笔刷新（没有欠账时按"自读盘"补一次，用于"一次都没上过屏"）。
     *
     * <p>与 {@link #refresh(Snapshot)} 的在途排队同构：合并规则一致，只是触发时机从"这一轮结束后"
     * 换成"展开那一刻"。
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
     * 后台刷新诊断信息，复用调用方刚读到的快照。
     *
     * <p>配置页每次刷新都是「读一次盘 → 上屏值 → 上屏诊断」：把那份快照传进来，
     * 本类与 {@link ConfigStore#describeState(Snapshot)} 都不再各读一次 {@code profile.conf}。
     * mtime 也取快照自己的字段。
     *
     * <p><b>在途期间到达的请求排队重跑，不丢</b>：一次刷新要跑一趟后台（自读盘时还要读文件），
     * 期间的请求若直接丢掉，写盘刚触发的刷新就可能被吞掉，诊断区一直停在改盘之前的状态。
     * 故在途时只登记"还欠一次刷新"（{@link #queuedKnown} 记下最新的快照），本轮上屏后立刻再刷一次。
     * 两路请求合一时以"自读盘"为准：它读的是磁盘当下状态，而快照可能正是写盘之前的那一份。
     *
     * <p><b>收起态下只登记、不上屏</b>（见 {@link #pendingRefresh}）：收起时整块都看不见，为它跑一趟
     * 后台 + 三次 setText 在启动链上是纯开销；展开那一刻由 {@link #setExpanded(boolean)} 补上。
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
