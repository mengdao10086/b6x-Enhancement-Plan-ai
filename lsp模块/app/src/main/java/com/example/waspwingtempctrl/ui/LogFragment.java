package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waspwingtempctrl.SetupActivity;
import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 日志页（D3）：按来源尾读日志（daemon / LSPosed）、跟随底部、关键词过滤、四类着色、失败可诊断。
 *
 * <p>来源由「日志文件」卡里的选择器切换；读取统一交给 {@link LogTailReader}
 * （daemon 直读私有目录，LSPosed 经 root 读 /data/adb 并只保留本模块条目），本类只负责渲染与刷新节奏。
 *
 * <p>线程纪律、刷新节奏、无变化跳过、自动跟随：见 {@code app/逻辑说明.md} §8.3。
 * 键盘"只覆盖、不顶起"与聚焦兜底由 {@link EdgeToEdge} 全 app 统一负责，本页不再自行接管窗口设置。
 *
 * <p>整行跨选：长按行进入选择模式（锚点高亮、暂停列表重绑），**保持按下直接上下滑动即扩选**
 * （手指到上下边缘会自动滚动并继续扩选），松手后也可点另一行扩展范围；底部操作条
 * 「复制 / 取消」，返回键等同取消。见 {@code app/逻辑说明.md} §9.4。
 */
public class LogFragment extends Fragment
        implements SetupActivity.PageAware, LogListAdapter.LineGestureListener {

    /** 自动刷新间隔：两个来源各自按这个节拍刷新一次（daemon 直读 / LSPosed 走 root）。 */
    private static final long REFRESH_INTERVAL_MS = 5000L;
    /** 输入关键词后的去抖间隔（过滤本身在后台线程做）。 */
    private static final long FILTER_DEBOUNCE_MS = 250L;
    /** 拖动扩选：离列表上下边界几行以内开始自动滚动（按可见行实测行高换算）。 */
    private static final int DRAG_EDGE_ROWS = 3;
    /** 拖动扩选：自动滚动速度区间（dp/秒）——刚进入触发带取最小，贴到边界取最大，中间线性。 */
    private static final int DRAG_SCROLL_MIN_DP_PER_SEC = 80;
    private static final int DRAG_SCROLL_MAX_DP_PER_SEC = 3200;
    /** 拖动扩选：自动滚动的拍间隔。 */
    private static final long DRAG_SCROLL_INTERVAL_MS = 16L;

    /** 来源选择器的选项顺序（与 {@code R.array.log_source_entries} 一致）。 */
    private static final int SOURCE_DAEMON = 0;
    private static final int SOURCE_LSPOSED = 1;
    /** 旋转 / 重建时保留用户选的来源。 */
    private static final String KEY_SOURCE = "log_source_index";

    /**
     * 本页是否为当前页（外壳 ViewPager2 广播，见 {@code PageAware}）：切页不再 hide/show、
     * 也不派发 onPause，故「是不是当前页」只能自己记着。
     */
    private boolean pageVisible;

    private LogListView listView;
    private LogListAdapter adapter;
    private TextView infoView;
    private TextView timeView;
    private TextView countView;
    private TextView statView;
    private TextView emptyView;
    private TextView failureView;
    private View failureScroll;
    private View followButton;
    private View selectionBar;
    private View selectionCopyButton;
    private View selectionCancelButton;
    private EditText filterInput;
    /** 日志来源选择器（daemon / LSPosed），与配置页 enum 键同源的按钮组。 */
    private MaterialButtonToggleGroup sourceGroup;
    /** 两个来源按钮的运行时 id（{@link View#generateViewId()}）。 */
    private int sourceDaemonId;
    private int sourceLsposedId;
    /** 当前来源下标，见 {@link #SOURCE_DAEMON} / {@link #SOURCE_LSPOSED}。 */
    private int sourceIndex = SOURCE_DAEMON;

    /** 选择模式下接管返回键（只在「本页可见且在选择」时启用）。 */
    private OnBackPressedCallback selectionBackCallback;

    /**
     * 拖动扩选是否进行中：长按时置位、抬手/取消时清除。
     * 只有它成立时才接管列表触摸，其余时间一律放行，普通滚动与滚动条拖拽不受影响。
     */
    private boolean dragSelecting;
    /** 最近一次手指坐标（边缘自动滚动的每一拍用它继续扩选）。 */
    private float dragX;
    private float dragY;
    /** 边缘自动滚动的每拍位移：正=向下、负=向上、0=停。 */
    private int autoScrollDy;
    /** 自动滚动的定时链是否在跑：只由定时器驱动，MOVE 不得重投（否则拍频等于触摸频率）。 */
    private boolean autoScrollRunning;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    /** 定时刷新开关；与视图状态解耦，便于三处入口重复调用。 */
    private boolean refreshing;
    /** 是否跟随底部（由滚动位置驱动，不靠猜）。 */
    private boolean following = true;
    /**
     * 每个来源各一根后台读取线程与一份缓存：两个来源都持续加载，换源时直接用缓存上屏，
     * 不现读现等。线程存活时该来源不再起新的（防重入）。
     */
    private final Thread[] workers = new Thread[2];
    private final SourceCache[] caches = new SourceCache[2];
    /** 当前已上屏列表的渲染指纹（与来源绑定；换源/关键词变化时清空，强制重绘一次）。 */
    private String onScreenLinesFp;
    /** 换源淡出淡入进行中：期间到达的新快照只进缓存，等动画把当前来源画出来时再用。 */
    private boolean sourceSwapPending;
    /** 上次自动跟随滚到的行数；相同且已在底部就不再滚，避免反复唤醒滚动条。 */
    private int lastFollowCount = -1;
    /** 用户正在拖动/惯性滑动：期间到达的快照先挂起，回到 IDLE 再上屏（避免滑动中行数跳变）。 */
    private boolean scrolling;
    private LogTailReader.Snapshot pendingSnap;
    private String pendingKeyword;

    /** 一个来源最近一次读取结果。{@code fileFp} 只用于让读取层跳过「文件没变」的重复解析。 */
    private static final class SourceCache {
        final LogTailReader.Snapshot snapshot;
        final String keyword;
        @Nullable
        final String fileFp;

        SourceCache(LogTailReader.Snapshot snapshot, String keyword, @Nullable String fileFp) {
            this.snapshot = snapshot;
            this.keyword = keyword;
            this.fileFp = fileFp;
        }
    }

    private final Runnable tick = new Runnable() {
        @Override
        public void run() {
            if (!refreshing) {
                return;
            }
            loadBoth();
            mainHandler.postDelayed(this, REFRESH_INTERVAL_MS);
        }
    };

    private final Runnable filterDebounce = new Runnable() {
        @Override
        public void run() {
            if (!refreshing) {
                return;   // 页面已不可见，不为了过滤白跑一次 IO
            }
            // 关键词变了：两份缓存都不再代表当前过滤结果，作废后两个来源一起重读
            caches[0] = null;
            caches[1] = null;
            pendingSnap = null;        // 挂起的旧关键词快照不能在新过滤下上屏
            pendingKeyword = null;
            onScreenLinesFp = null;
            loadBoth();
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_log, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = requireContext();
        if (savedInstanceState != null) {
            sourceIndex = clampSource(savedInstanceState.getInt(KEY_SOURCE, SOURCE_DAEMON));
        }

        sourceGroup = view.findViewById(R.id.log_source_group);
        listView = view.findViewById(R.id.log_list);
        infoView = view.findViewById(R.id.log_info_text);
        timeView = view.findViewById(R.id.log_time_text);
        countView = view.findViewById(R.id.log_count_text);
        statView = view.findViewById(R.id.log_stat_text);
        emptyView = view.findViewById(R.id.log_empty_text);
        failureView = view.findViewById(R.id.log_failure_text);
        failureScroll = view.findViewById(R.id.log_failure_scroll);
        followButton = view.findViewById(R.id.log_follow_btn);
        selectionBar = view.findViewById(R.id.log_selection_bar);
        selectionCopyButton = view.findViewById(R.id.log_selection_copy_btn);
        selectionCancelButton = view.findViewById(R.id.log_selection_cancel_btn);
        filterInput = view.findViewById(R.id.log_filter_input);

        adapter = new LogListAdapter(context, this);
        // 滚动条几何量由 LogListView 统一按「像素 + 冻结的平均行高」上报，见其类注释
        listView.setLayoutManager(new LinearLayoutManager(context));
        // 日志行不做增删动画：整批替换时动画只会变成闪烁
        listView.setItemAnimator(null);
        listView.setAdapter(adapter);
        // 手指一抬起就补上挂起的快照；没有惯性时 scrolling 已回到 IDLE，不会在滑动中重绑
        listView.setOnTouchEndListener(() -> {
            if (!scrolling) {
                flushPendingSnapshot();
            }
        });
        // 滚动条常显 + 加粗（见 fragment_log.xml），这里才接得上"按住滚动条拖动"
        ScrollbarDrag.attach(listView);
        // 长按后不抬手、直接滑动即扩选：接管发生在长按之后，见 dragSelectTouchListener
        listView.addOnItemTouchListener(dragSelectTouchListener);
        listView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView rv, int dx, int dy) {
                // 滚到底（无法再向下滚）即恢复跟随；离开底部即暂停跟随
                following = !rv.canScrollVertically(1);
                updateFollowButton();
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rv, int newState) {
                scrolling = newState != RecyclerView.SCROLL_STATE_IDLE;
                if (!scrolling) {
                    flushPendingSnapshot();
                }
            }
        });

        followButton.setOnClickListener(v -> {
            following = true;
            int count = adapter.getItemCount();
            if (count > 0) {
                listView.smoothScrollToPosition(count - 1);
            }
            updateFollowButton();
        });

        selectionCopyButton.setOnClickListener(v -> copySelectedLines());
        selectionCancelButton.setOnClickListener(v -> exitSelection());

        selectionBackCallback = new OnBackPressedCallback(false) {
            @Override
            public void handleOnBackPressed() {
                exitSelection();
            }
        };
        requireActivity().getOnBackPressedDispatcher()
                .addCallback(getViewLifecycleOwner(), selectionBackCallback);

        filterInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mainHandler.removeCallbacks(filterDebounce);
                mainHandler.postDelayed(filterDebounce, FILTER_DEBOUNCE_MS);
            }
        });

        // 来源选择器：复用配置页 enum 键 / 曲线页窗口档位的按钮组与按钮布局，单选必选。
        String[] sourceLabels = getResources().getStringArray(R.array.log_source_entries);
        sourceDaemonId = addSourceButton(sourceGroup, sourceLabels[SOURCE_DAEMON]);
        sourceLsposedId = addSourceButton(sourceGroup, sourceLabels[SOURCE_LSPOSED]);
        sourceGroup.check(sourceIndex == SOURCE_LSPOSED ? sourceLsposedId : sourceDaemonId);
        sourceGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                selectSource(checkedId == sourceLsposedId ? SOURCE_LSPOSED : SOURCE_DAEMON);
                updateSourceButtonAlpha(true);
            }
        });
        updateSourceButtonAlpha(false);   // 初始选中态直接落位，页面打开时不播过渡

        infoView.setText(R.string.log_loading);
        timeView.setText("");
        statView.setText(R.string.log_loading);
        countView.setText("");
        lastFollowCount = -1;
        // 视图重建后必须重画一次：指纹是「这套视图已经渲染过」的标记，沿用旧值会让第一拍被跳过
        onScreenLinesFp = null;
        TextCopy.installPathSelection(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (pageVisible && isResumed()) {
            startRefresh();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (pageVisible) {
            startRefresh();   // startRefresh 立即刷一拍，两个来源同时补最新
        }
    }

    @Override
    public void onPause() {
        stopRefresh();
        super.onPause();
    }

    @Override
    public void onStop() {
        stopRefresh();
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SOURCE, sourceIndex);
    }

    @Override
    public void onPageVisible(boolean visible) {
        pageVisible = visible;
        // 非当前页只是被压到 STARTED（不派发 onPause），不在这里停就一直后台刷
        if (visible) {
            startRefresh();
        } else {
            stopRefresh();
        }
        // 别的页在台前时不要抢返回键；选择状态保留，回到本页再恢复接管
        syncSelectionBackCallback();
    }

    @Override
    public void onDestroyView() {
        stopRefresh();
        mainHandler.removeCallbacksAndMessages(null);
        // 选择状态、返回键回调、行手势回调都必须断开，否则适配器/调度器会反向持有本 Fragment
        if (selectionBackCallback != null) {
            selectionBackCallback.remove();
            selectionBackCallback = null;
        }
        endDragSelect();
        if (listView != null) {
            listView.removeOnItemTouchListener(dragSelectTouchListener);
        }
        if (adapter != null) {
            adapter.clearSelection();
            adapter.clearGestureListener();
        }
        listView = null;
        adapter = null;
        infoView = null;
        timeView = null;
        countView = null;
        statView = null;
        emptyView = null;
        failureView = null;
        failureScroll = null;
        followButton = null;
        selectionBar = null;
        selectionCopyButton = null;
        selectionCancelButton = null;
        filterInput = null;
        sourceGroup = null;
        super.onDestroyView();
    }

    // ==================== 刷新节奏 ====================

    /**
     * 切换来源：<b>不现读现等</b>——两个来源一直在后台刷新，这里直接取那份缓存；内容整体
     * 淡出→换数据→淡入（与状态页「部署状态」同一套时长/曲线），避免硬切闪屏。
     */
    private void selectSource(int index) {
        int next = clampSource(index);
        if (next == sourceIndex) {
            return;
        }
        sourceIndex = next;
        if (isSelectingLines()) {
            exitSelection();   // 选中区间属于旧来源的行，换源后不能再沿用
        }
        following = true;   // 换了一份日志，默认仍看最新
        lastFollowCount = -1;
        onScreenLinesFp = null;
        sourceSwapPending = true;
        // 缓存可能还没有（首次进页/刚清过滤关键词）：立刻补一次，不等下一拍 5 秒
        loadNow(currentSource());
        // 按窗口分组：文件信息窗口（信息/时间/统计/命中）只淡化不模糊；
        // 日志显示窗口（列表 + 空态 + 失败区）保持原有模糊。
        // 列表占屏超过 30%：本次一次性解除面积上限，接受整张列表离屏滤波的代价（低频动作）。
        Motion.crossFadeMixedUncapped(() -> {
            sourceSwapPending = false;
            SourceCache cache = caches[sourceIndex];
            if (listView == null) {
                return;
            }
            if (cache != null && cache.keyword.equals(currentKeyword())) {
                render(cache.snapshot, cache.keyword);
            } else {
                showLoadingState();
            }
        }, new View[]{listView, emptyView, failureScroll},
                new View[]{infoView, timeView, statView, countView});
    }

    /** 读不到缓存时的占位：与首进页一致，绝不留旧来源的行。 */
    private void showLoadingState() {
        if (infoView != null) {
            setTextIfChanged(infoView, getString(R.string.log_loading));
        }
        if (timeView != null) {
            setTextIfChanged(timeView, "");
        }
        if (statView != null) {
            setTextIfChanged(statView, getString(R.string.log_loading));
        }
        if (countView != null) {
            countView.setVisibility(View.GONE);
            setTextIfChanged(countView, "");
        }
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
        if (failureScroll != null) {
            failureScroll.setVisibility(View.GONE);
        }
        if (listView != null) {
            listView.setVisibility(View.VISIBLE);
        }
        if (adapter != null) {
            adapter.submit(java.util.Collections.emptyList());
        }
        updateFollowButton();
    }

    /** 复用曲线页档位按钮的布局，加进来源按钮组；返回运行时生成的按钮 id。 */
    private int addSourceButton(MaterialButtonToggleGroup group, String label) {
        MaterialButton button = (MaterialButton) getLayoutInflater()
                .inflate(R.layout.item_chart_window_button, group, false);
        button.setId(View.generateViewId());
        button.setText(label);
        button.setAllCaps(false);   // 保留 daemon / LSPosed 原始大小写
        group.addView(button);
        return button.getId();
    }

    /**
     * 选中态过渡：选中按钮恢复不透明，另一个压暗；口径由 {@link Motion#syncSelectedAlpha} 统一。
     * {@code animate = false} 用于首帧落位——页面打开时不该自己播一段动画。
     */
    private void updateSourceButtonAlpha(boolean animate) {
        if (sourceGroup == null) {
            return;
        }
        Motion.syncSelectedAlpha(sourceGroup, sourceGroup.getCheckedButtonId(), animate);
    }

    /** 下标只可能是 0 / 1；越界（旧版本保存值）按 daemon 处理。 */
    private static int clampSource(int index) {
        return index == SOURCE_LSPOSED ? SOURCE_LSPOSED : SOURCE_DAEMON;
    }

    /** 来源 → 缓存/线程槽位（与 SOURCE_D / SOURCE_L 常量一致）。 */
    private static int slotOf(LogTailReader.Source source) {
        return source == LogTailReader.Source.LSPOSED ? SOURCE_LSPOSED : SOURCE_DAEMON;
    }

    private LogTailReader.Source currentSource() {
        return sourceIndex == SOURCE_LSPOSED
                ? LogTailReader.Source.LSPOSED
                : LogTailReader.Source.DAEMON;
    }

    /** 幂等：重复调用只生效一次。 */
    private void startRefresh() {
        if (refreshing) {
            return;
        }
        refreshing = true;
        mainHandler.removeCallbacks(tick);
        mainHandler.post(tick);
    }

    /** 幂等：未在刷新时调用无副作用。 */
    private void stopRefresh() {
        refreshing = false;
        mainHandler.removeCallbacks(tick);
    }

    /** 两个来源各刷一次：页面可见时每 5 秒都跑，切换来源因此不必现读。 */
    private void loadBoth() {
        loadNow(LogTailReader.Source.DAEMON);
        loadNow(LogTailReader.Source.LSPOSED);
    }

    /** 起一次指定来源的后台读取（该来源已有读取在跑就跳过，靠 5 秒定时补上）。 */
    private void loadNow(LogTailReader.Source source) {
        if (listView == null || !isAdded()) {
            return;
        }
        int slot = slotOf(source);
        Thread running = workers[slot];
        if (running != null && running.isAlive()) {
            return;   // 防重入：同一来源同时只跑一根读取线程
        }
        final Context appContext = requireContext().getApplicationContext();
        final String keyword = currentKeyword();
        SourceCache cache = caches[slot];
        boolean sameKeyword = cache != null && keyword.equals(cache.keyword);
        final String fileFp = sameKeyword ? cache.fileFp : null;
        final String lastKw = sameKeyword ? cache.keyword : null;

        Thread thread = new Thread(() -> {
            final LogTailReader.Snapshot snap =
                    LogTailReader.read(appContext, source, keyword, fileFp, lastKw);
            mainHandler.post(() -> {
                if (listView == null) {
                    return;   // 视图已销毁
                }
                applySnapshot(source, snap, keyword);
            });
        }, "ww-log-" + slot);
        thread.setDaemon(true);
        workers[slot] = thread;
        thread.start();
    }

    private String currentKeyword() {
        if (filterInput == null || filterInput.getText() == null) {
            return "";
        }
        return filterInput.getText().toString().trim();
    }

    /** 一次读取的结果先入缓存（两个来源各自独立），只有当前来源才上屏。 */
    private void applySnapshot(LogTailReader.Source source, LogTailReader.Snapshot snap,
                               String keyword) {
        if (snap.unchanged) {
            return;   // 文件与关键词都没变：缓存与视图都保持原样
        }
        int slot = slotOf(source);
        // 非当前来源 / 换源动画中 / 滑动挂起：先把结果入缓存，上屏时再用
        if (source != currentSource() || sourceSwapPending) {
            caches[slot] = new SourceCache(snap, keyword, snap.ok ? snap.fingerprint : null);
            return;
        }
        // 触摸滚动由 scrolling 覆盖；按住滚动条拖动（ScrollbarDrag 用 scrollBy，状态仍是 IDLE）
        // 靠 userTouching 覆盖——否则 5 秒刷新会在拖动中整批重绑，表现为顿挫与拇指跳位
        if (scrolling || (listView != null && listView.isUserTouching())) {
            pendingSnap = snap;          // 手势中不重绑列表：结束后再套用最新这份
            pendingKeyword = keyword;
            caches[slot] = new SourceCache(snap, keyword, snap.ok ? snap.fingerprint : null);
            return;
        }
        boolean applied = render(snap, keyword);
        if (!applied) {
            onScreenLinesFp = null;   // 选中中跳过：下一拍必须重绘，不能被指纹短路
        }
        // 失败快照、或本次因选中跳过 → 不记 fileFp，下一拍整读重绘（选择结束后内容能补上）
        caches[slot] = new SourceCache(snap, keyword,
                snap.ok && applied ? snap.fingerprint : null);
        // 读的这段时间里关键词又变了 → 立刻按新关键词两个来源补一次
        if (!keyword.equals(currentKeyword())) {
            caches[0] = null;
            caches[1] = null;
            pendingSnap = null;        // 挂起的旧关键词快照不能在新过滤下上屏
            pendingKeyword = null;
            onScreenLinesFp = null;
            loadBoth();
        }
    }

    /** 滑动停止：把挂起的最新快照画出来（内容照常跟随，不为了稳定而停止刷新）。 */
    private void flushPendingSnapshot() {
        if (pendingSnap == null || listView == null) {
            return;
        }
        LogTailReader.Snapshot snap = pendingSnap;
        String keyword = pendingKeyword;
        pendingSnap = null;
        pendingKeyword = null;
        if (!keyword.equals(currentKeyword())) {
            loadBoth();   // 滑动期间关键词变了：这份快照作废，按新关键词重读
            return;
        }
        if (snap.source == currentSource()) {
            render(snap, keyword);
        }
    }

    // ==================== 渲染（主线程） ====================

    /**
     * 上屏。文本行只在内容变化时 setText；列表只在<b>渲染指纹变化</b>时重绑——
     * 文件 mtime/size 变了但可见行没变（例如只追加了被过滤掉的行）时，不触发列表重新布局，
     * 滚动条拇指长度因此不会跟着刷新抖动。
     *
     * @return true = 已处理；false = 因整行选择中或视图已销毁而跳过
     */
    private boolean render(LogTailReader.Snapshot snap, String keyword) {
        if (infoView == null) {
            return false;
        }
        // 正在选中的控件本轮不重写：setText 会清掉选择与手柄。其余控件照常刷新，选择结束后下一轮自动补上
        if (!TextCopy.isSelecting(infoView)) {
            setTextIfChanged(infoView, buildInfoText(snap));
        }
        if (!TextCopy.isSelecting(timeView)) {
            setTextIfChanged(timeView, buildTimeText(snap));
        }
        if (!TextCopy.isSelecting(statView)) {
            setTextIfChanged(statView, buildStatText(snap));
        }
        updateCountView(snap, keyword);

        if (!snap.ok) {
            // 选择期间不切视图：列表一旦让位给诊断，高亮与操作条就失去了作用对象
            if (isSelectingLines()) {
                return false;
            }
            String fp = "F:" + snap.source + ":" + snap.path + ":" + snap.failureText;
            // 诊断文本每次按当前「展示完整路径」口径重算：开关切换后同一条失败也能换显示
            setTextIfChanged(failureView, PathDisplay.format(requireContext(),
                    getString(R.string.log_failure_title) + "\n\n" + snap.failureText));
            if (!fp.equals(onScreenLinesFp)) {
                // 失败：原样展示诊断，列表与跟随入口全部让位
                adapter.submit(java.util.Collections.emptyList());
                failureScroll.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                followButton.setVisibility(View.GONE);
                onScreenLinesFp = fp;
            }
            return true;
        }

        // 选择期间不重绑列表：新一批行会顶掉选中区间（下标对不上），高亮也跟着失效。
        // 这里只暂停列表本身，信息行/统计行已在上方按各自的选择状态单独处理
        if (isSelectingLines()) {
            return false;
        }
        String fp = linesFingerprint(snap, keyword);
        if (!fp.equals(onScreenLinesFp)) {
            // 不在底部时先记视口锚点：行数达上限后头部行被挤掉，重绑会让内容整体上移
            ScrollAnchor anchor = following ? null : captureScrollAnchor();
            failureScroll.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
            adapter.submit(snap.lines);
            restoreScrollAnchor(anchor, snap.lines);

            boolean empty = snap.lines.isEmpty();
            emptyView.setVisibility(empty ? View.VISIBLE : View.GONE);
            if (empty) {
                if (keyword.isEmpty()) {
                    emptyView.setText(snap.source == LogTailReader.Source.LSPOSED
                            ? getString(R.string.log_empty_no_b6x)
                            : getString(R.string.log_empty_no_lines));
                } else {
                    emptyView.setText(getString(R.string.log_empty_no_hit, keyword, snap.candidateLines));
                }
            }
            onScreenLinesFp = fp;
        }

        if (following) {
            int count = adapter.getItemCount();
            // 行数没变且已经停在底部就不重复滚：每次 scrollToPosition 都会唤醒滚动条（亮灭闪烁）
            if (count > 0 && (count != lastFollowCount || listView.canScrollVertically(1))) {
                listView.scrollToPosition(count - 1);
            }
            lastFollowCount = count;
        }
        updateFollowButton();
        return true;
    }

    /** 列表可见内容的指纹：关键词 + 来源 + 参与匹配的行数 + 每行文本与级别。 */
    private static String linesFingerprint(LogTailReader.Snapshot snap, String keyword) {
        int h = keyword.hashCode();
        h = 31 * h + snap.source.ordinal();
        h = 31 * h + snap.candidateLines;
        for (LogLine line : snap.lines) {
            h = 31 * h + line.text.hashCode();
            h = 31 * h + line.level.ordinal();
        }
        return "L:" + snap.lines.size() + ":" + h;
    }

    /** 视口锚点：重绑前记录首/次可见行文本、旧下标与首个可见行的顶部偏移。 */
    private static final class ScrollAnchor {
        final String firstText;
        @Nullable
        final String secondText;
        final int firstIndex;
        final int firstOffset;

        ScrollAnchor(String firstText, @Nullable String secondText, int firstIndex, int firstOffset) {
            this.firstText = firstText;
            this.secondText = secondText;
            this.firstIndex = firstIndex;
            this.firstOffset = firstOffset;
        }
    }

    /** 重绑前取锚点；列表尚未布局（无可见行）时返回 null。 */
    @Nullable
    private ScrollAnchor captureScrollAnchor() {
        if (listView == null || adapter == null
                || !(listView.getLayoutManager() instanceof LinearLayoutManager)) {
            return null;
        }
        LinearLayoutManager manager = (LinearLayoutManager) listView.getLayoutManager();
        int first = manager.findFirstVisibleItemPosition();
        if (first == RecyclerView.NO_POSITION) {
            return null;
        }
        View firstView = manager.findViewByPosition(first);
        String firstText = lineTextOf(firstView);
        if (firstText == null) {
            return null;
        }
        String secondText = first + 1 < adapter.getItemCount()
                ? lineTextOf(manager.findViewByPosition(first + 1))
                : null;
        return new ScrollAnchor(firstText, secondText, first,
                firstView.getTop() - listView.getPaddingTop());
    }

    /** 行视图里的日志文本；不是日志行时返回 null。 */
    @Nullable
    private static String lineTextOf(@Nullable View row) {
        if (row == null) {
            return null;
        }
        View text = row.findViewById(R.id.log_line_text);
        return text instanceof TextView ? ((TextView) text).getText().toString() : null;
    }

    /** 重绑后按文本找回锚行并滚回原位；首个锚丢失用第二个，都丢则保持现状。 */
    private void restoreScrollAnchor(@Nullable ScrollAnchor anchor, List<LogLine> lines) {
        if (anchor == null || listView == null || following) {
            return;
        }
        if (scrolling || listView.isUserTouching()) {
            return;   // 手指在列表上时不纠偏
        }
        int position = findAnchorPosition(lines, anchor.firstText, anchor.firstIndex);
        if (position < 0) {
            position = findAnchorPosition(lines, anchor.secondText, anchor.firstIndex + 1);
        }
        if (position < 0 || !(listView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        ((LinearLayoutManager) listView.getLayoutManager())
                .scrollToPositionWithOffset(position, anchor.firstOffset);
    }

    /** 文本命中行下标：优先取不晚于 expected 的最近一次，避免重复行锚到很后面。 */
    private static int findAnchorPosition(List<LogLine> lines, @Nullable String text, int expected) {
        if (text == null) {
            return -1;
        }
        int nearestBefore = -1;
        for (int i = 0; i < lines.size(); i++) {
            if (!text.equals(lines.get(i).text)) {
                continue;
            }
            if (i <= expected) {
                nearestBefore = i;
            } else if (nearestBefore < 0) {
                return i;   // 锚行只出现在更靠后的位置：按第一次命中处理
            }
        }
        return nearestBefore;
    }

    /** 文本没变就不碰控件：避免无谓的重排（滚动条长度依赖列表，不依赖这些行，但少一次算一次）。 */
    private static void setTextIfChanged(@Nullable TextView view, @Nullable CharSequence text) {
        if (view == null) {
            return;
        }
        CharSequence now = view.getText();
        if (!TextUtils.equals(now, text == null ? "" : text)) {
            view.setText(text);
        }
    }

    // ==================== 整行选择 ====================

    /** 是否处于整行选择模式。选择期间不重绑列表（rebind 会顶掉选中区间与高亮）。 */
    private boolean isSelectingLines() {
        return adapter != null && adapter.isSelecting();
    }

    @Override
    public void onLineLongPress(int position) {
        if (adapter == null || selectionBar == null) {
            return;
        }
        adapter.beginSelection(position);
        selectionBar.setVisibility(View.VISIBLE);
        syncSelectionBackCallback();
        // 选择期间「回到底部」让位，避免与操作条挤在同一角落
        updateFollowButton();
        // 长按生效时手指仍按着屏幕：从这里起，本次手势的后续移动用于扩选而不是滚动列表
        dragSelecting = true;
        autoScrollDy = 0;
        // 纵向拖动扩选期间禁止外层 ViewPager2 抢手势翻页：否则稍微斜一点就整页滑走，选择也被取消
        requestParentDisallowIntercept(true);
    }

    @Override
    public void onLineClick(int position) {
        if (adapter == null || !adapter.isSelecting()) {
            return;
        }
        // 只选中一行时再次点它 = 取消选择；选多行时点任意行照旧收拢/扩展区间
        if (adapter.isSoleSelection(position)) {
            exitSelection();
        } else {
            adapter.extendSelectionTo(position);
        }
    }

    /**
     * 拖动扩选的手势入口：只在「长按后手指未抬起」期间接管。
     *
     * <p>返回 true 会让 RecyclerView 取消本次滚动并把手势交给本监听，因此
     * 只有 {@link #dragSelecting} 成立时才接管；其余触摸一律返回 false 放行，
     * 普通滚动、列表项点击、滚动条拖拽都不受影响。
     */
    private final RecyclerView.OnItemTouchListener dragSelectTouchListener =
            new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    return handleDragSelectTouch(rv, e);
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                    handleDragSelectTouch(rv, e);
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                    // 不参与父容器的手势裁决；本监听本来就只在拖动扩选期间接管
                }
            };

    /** @return true = 已消费该事件（拖动扩选中） */
    private boolean handleDragSelectTouch(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        if (!dragSelecting) {
            return false;
        }
        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_MOVE:
                dragX = e.getX();
                dragY = e.getY();
                extendSelectionAt(dragX, dragY);
                updateAutoScroll(rv);
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // 抬手只结束拖动：选择保留，复制仍由操作条的「复制」按钮触发
                endDragSelect();
                return true;
            default:
                return true;
        }
    }

    /** 把选择焦点移到手指所在的日志行；手指落在列表空白处时取最近的可见行。 */
    private void extendSelectionAt(float x, float y) {
        if (listView == null || adapter == null) {
            return;
        }
        View child = listView.findChildViewUnder(x, y);
        if (child != null) {
            int position = listView.getChildAdapterPosition(child);
            if (position != RecyclerView.NO_POSITION) {
                adapter.extendSelectionTo(position);
            }
            return;
        }
        // 列表不满一屏或手指超出内容区：仍以最近的一行为目标，保证拖动始终有扩选目标
        if (!(listView.getLayoutManager() instanceof LinearLayoutManager) || listView.getChildCount() == 0) {
            return;
        }
        LinearLayoutManager manager = (LinearLayoutManager) listView.getLayoutManager();
        int nearest = (y < listView.getPaddingTop())
                ? manager.findFirstVisibleItemPosition()
                : manager.findLastVisibleItemPosition();
        if (nearest != RecyclerView.NO_POSITION) {
            adapter.extendSelectionTo(nearest);
        }
    }

    /**
     * 手指进入上/下触发带时启动持续滚动；离开触发带即停。
     *
     * <p>触发带高度 = 三行日志（按可见行实测行高），越靠近边界速度越快（见 {@link #autoScrollStepPx}）。
     *
     * <p>拍频只由定时器决定：MOVE 仅更新 {@link #autoScrollDy} 与续跑状态，**不重投定时器**。
     * 若每次 MOVE 都 remove + post，等于每个触摸事件额外多滚一拍，120Hz 屏幕上拍频翻倍，
     * 表现为「一直滑动比按住不动滚得快」。
     */
    private void updateAutoScroll(@NonNull RecyclerView rv) {
        int band = DRAG_EDGE_ROWS * rowHeightPx(rv);
        int height = rv.getHeight();
        int dy = 0;
        if (dragY < band) {
            dy = -autoScrollStepPx((band - dragY) / (float) band);
        } else if (dragY > height - band) {
            dy = autoScrollStepPx((dragY - (height - band)) / (float) band);
        }
        autoScrollDy = dy;
        if (dy != 0 && !autoScrollRunning) {
            autoScrollRunning = true;
            mainHandler.postDelayed(autoScrollTick, DRAG_SCROLL_INTERVAL_MS);
        } else if (dy == 0 && autoScrollRunning) {
            autoScrollRunning = false;
            mainHandler.removeCallbacks(autoScrollTick);
        }
    }

    /** 单行高度（px）：取首个可见行；列表尚未布局时按 24dp 估算。 */
    private int rowHeightPx(@NonNull RecyclerView rv) {
        if (rv.getChildCount() > 0) {
            int height = rv.getChildAt(0).getHeight();
            if (height > 0) {
                return height;
            }
        }
        return Math.round(24 * getResources().getDisplayMetrics().density);
    }

    /**
     * 每拍滚动像素：{@code intensity} 0=刚进入触发带、1=贴到边界（超出按 1 算）。
     * 速度在 最小~最大 dp/秒 之间线性插值，再按拍间隔折成本拍像素，至少 1px。
     */
    private int autoScrollStepPx(float intensity) {
        if (intensity < 0f) {
            intensity = 0f;
        }
        if (intensity > 1f) {
            intensity = 1f;
        }
        float dps = DRAG_SCROLL_MIN_DP_PER_SEC
                + (DRAG_SCROLL_MAX_DP_PER_SEC - DRAG_SCROLL_MIN_DP_PER_SEC) * intensity;
        float density = getResources().getDisplayMetrics().density;
        int px = Math.round(dps * density * DRAG_SCROLL_INTERVAL_MS / 1000f);
        return px < 1 ? 1 : px;
    }

    /** 边缘自动滚动的一拍：滚一小步后按同一坐标重新扩选，滚出新行即自动纳入选择。 */
    private final Runnable autoScrollTick = new Runnable() {
        @Override
        public void run() {
            if (!dragSelecting || listView == null || autoScrollDy == 0) {
                autoScrollRunning = false;
                return;
            }
            listView.scrollBy(0, autoScrollDy);
            extendSelectionAt(dragX, dragY);
            mainHandler.postDelayed(this, DRAG_SCROLL_INTERVAL_MS);
        }
    };

    /** 结束拖动扩选（抬手、取消、销毁视图都走这里）。选择本身不清除。 */
    private void endDragSelect() {
        dragSelecting = false;
        autoScrollDy = 0;
        autoScrollRunning = false;
        mainHandler.removeCallbacks(autoScrollTick);
        requestParentDisallowIntercept(false);
    }

    /** 请求（或撤销）父容器不要截获本次手势；列表尚未附着时会静默跳过。 */
    private void requestParentDisallowIntercept(boolean disallow) {
        if (listView == null || listView.getParent() == null) {
            return;
        }
        listView.getParent().requestDisallowInterceptTouchEvent(disallow);
    }

    /** 复制选中区间的整行文本（行间以换行连接），成功后退出选择模式。 */
    private void copySelectedLines() {
        if (adapter == null || !adapter.isSelecting()) {
            return;
        }
        TextCopy.copy(requireContext(), adapter.selectedText());
        exitSelection();
    }

    /** 退出选择模式：清高亮、收起操作条、交还返回键、恢复跟随按钮的显隐逻辑。 */
    private void exitSelection() {
        endDragSelect();
        if (adapter != null) {
            adapter.clearSelection();
        }
        if (selectionBar != null) {
            selectionBar.setVisibility(View.GONE);
        }
        syncSelectionBackCallback();
        updateFollowButton();
    }

    /** 返回键只在「本页可见 + 处于选择模式」时接管，切到别的页不再吞掉返回。 */
    private void syncSelectionBackCallback() {
        if (selectionBackCallback != null) {
            selectionBackCallback.setEnabled(isSelectingLines() && pageVisible);
        }
    }

    private void updateFollowButton() {
        if (followButton == null || listView == null || adapter == null) {
            return;
        }
        boolean show = listView.getVisibility() == View.VISIBLE
                && !following
                && !isSelectingLines()
                && adapter.getItemCount() > 0;
        followButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /** 信息条首行：只有路径本身，不带标签字样；显示长短随「展示完整路径」开关。 */
    private CharSequence buildInfoText(LogTailReader.Snapshot snap) {
        if (snap.path == null) {
            return getString(R.string.log_loading);
        }
        // 信息行整条就是一条路径：用显式区间，glob / 含空格的文件名也能整条可点
        return PathDisplay.forSinglePath(requireContext(), getString(R.string.log_info_fmt, snap.path));
    }

    /** 次行左半：修改时间（同一行的右半是 {@link #buildStatText} 的行数统计）。 */
    private String buildTimeText(LogTailReader.Snapshot snap) {
        return (snap.statOk && snap.mtimeMs > 0L)
                ? TIME_FMT.format(new Date(snap.mtimeMs))
                : getString(R.string.log_value_unknown);
    }

    /**
     * 统计行（与修改时间同一行、右对齐）：行数 / 渲染上限行数，文件大小 / 尾读上限。
     * 行数取参与匹配的最近 N 行（{@link LogTailReader.Snapshot#candidateLines}），
     * 大小取文件字节数（超过上限即说明尾读被截断）。
     */
    private String buildStatText(LogTailReader.Snapshot snap) {
        if (snap.path == null) {
            return getString(R.string.log_loading);
        }
        if (!snap.ok) {
            return getString(R.string.log_stat_failed);
        }
        return getString(R.string.log_stat_fmt, snap.candidateLines, snap.lineLimit,
                formatK(snap.size), formatK(snap.byteLimit));
    }

    /** 命中计数只在有关键词时才有意义；无关键词时行数信息统一在「日志文件」卡的统计行。 */
    private void updateCountView(LogTailReader.Snapshot snap, String keyword) {
        if (TextCopy.isSelecting(countView)) {
            return;   // 选中期间不改文本/可见性；选择结束后下一轮刷新补上
        }
        boolean filtered = snap.ok && !keyword.isEmpty();
        countView.setVisibility(filtered ? View.VISIBLE : View.GONE);
        setTextIfChanged(countView,
                filtered ? getString(R.string.log_count_hit_fmt, snap.lines.size()) : "");
    }

    /** 字节 → k（1024 进制）文本，最多 1 位小数且整数不补 {@code .0}：1843 → "1.8"、204800 → "200"。 */
    private static String formatK(long bytes) {
        String text = String.format(Locale.US, "%.1f", bytes / 1024.0);
        return text.endsWith(".0") ? text.substring(0, text.length() - 2) : text;
    }

    private static final SimpleDateFormat TIME_FMT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /**
     * 日志列表：把滚动条几何量固定到「像素空间 + 冻结的平均行高」。
     *
     * <p>为什么默认实现会抖：{@code RecyclerView} 把滚动条映射到<b>条目空间</b>——拇指长度
     * = 当前可见条目数 / 总条目数。日志行高随折行长度不等，滑动时屏幕里的行高组合不断变化，
     * 可见条目数随之反复增减，拇指长度就周期性伸缩（高行多时可见条目少 → 拇指短、移动慢）。
     * 关掉平滑滚动条只是把外推值从「像素」换成「条目数」，比值口径不变，抖动照旧；副作用是
     * {@code computeVerticalScrollOffset} 的单位从像素变成条目，{@link ScrollbarDrag} 把
     * 拖动增量当像素交给 {@code scrollBy}，拖动因此变慢。
     *
     * <p>这里重写三个几何量，统一用像素：
     * <ul>
     *   <li>extent = 视口高度（常量）；</li>
     *   <li>range = 条目数 × 平均行高。平均行高只在 IDLE / 首次布局时按屏幕内子项重算，
     *       滑动中不更新；列表数据在滑动中也被 {@link LogFragment} 挂起，不整批重绑。
     *       因此整段滑动里 range / extent 恒定，拇指长度不动；</li>
     *   <li>offset = (首个可见条目 + 该条目内已滑过的比例) × 平均行高，跨条目连续，无跳变。</li>
     * </ul>
     *
     * <p>开销：每次调用只读已绑定的十来个子项与一个首可见下标，O(可见行)；平均行高只在停稳时
     * 扫一遍屏幕内子项。不做全量预测量、不缓存逐行高度，上千行与几十行同代价。
     */
    public static final class LogListView extends RecyclerView {
        /** 平均行高尚未量到时的估算值（与 {@link #rowHeightPx} 的兜底同口径）。 */
        private static final float DEFAULT_ROW_DP = 24f;

        /** 平均行高（px）；滑动中冻结，只在 IDLE / 首次布局时更新。 */
        private float avgRowPx;

        /** 手指是否仍按在列表上（含按在滚动条上拖动：那种手势不改变滚动状态）。 */
        private boolean userTouching;

        /** 手指抬起（非惯性滑动）时回调，用于补上挂起的快照。 */
        @Nullable
        private Runnable touchEndListener;

        public LogListView(@NonNull Context context) {
            this(context, null);
        }

        public LogListView(@NonNull Context context, @Nullable AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public LogListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            addOnScrollListener(new OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView rv, int newState) {
                    // 只在停稳时更新平均行高：滑动中改它会直接改拇指长度
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        refreshAverageRowHeight();
                    }
                }
            });
        }

        void setOnTouchEndListener(@Nullable Runnable listener) {
            touchEndListener = listener;
        }

        boolean isUserTouching() {
            return userTouching;
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            switch (ev.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    userTouching = true;
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    userTouching = false;
                    if (touchEndListener != null) {
                        // 等本次事件（可能还在起惯性）分发给 RecyclerView 之后再补快照
                        post(touchEndListener);
                    }
                    break;
                default:
                    break;
            }
            return super.dispatchTouchEvent(ev);
        }

        @Override
        protected void onLayout(boolean changed, int l, int t, int r, int b) {
            super.onLayout(changed, l, t, r, b);
            if (avgRowPx <= 0f) {
                refreshAverageRowHeight();
            }
        }

        @Override
        protected void onDetachedFromWindow() {
            // 手势被窗口切换打断时可能收不到 UP/CANCEL：避免 userTouching 卡在 true
            userTouching = false;
            super.onDetachedFromWindow();
        }

        @Override
        public int computeVerticalScrollExtent() {
            return Math.max(1, getHeight() - getPaddingTop() - getPaddingBottom());
        }

        @Override
        public int computeVerticalScrollRange() {
            int count = getAdapter() == null ? 0 : getAdapter().getItemCount();
            if (count <= 0) {
                return 1;
            }
            long range = (long) Math.ceil(count * (double) rowHeightPx());
            return (int) Math.min(Integer.MAX_VALUE,
                    Math.max(computeVerticalScrollExtent() + 1L, range));
        }

        @Override
        public int computeVerticalScrollOffset() {
            int extent = computeVerticalScrollExtent();
            int range = computeVerticalScrollRange();
            if (range <= extent) {
                return 0;
            }
            // 注意：这里绝不能调 canScrollVertically()——View.canScrollVertically 会回调
            // computeVerticalScrollOffset()，形成无限递归（StackOverflowError）。
            // 边界改由已绑定子项的位置直接判断。
            if (!(getLayoutManager() instanceof LinearLayoutManager)) {
                return 0;
            }
            LinearLayoutManager manager = (LinearLayoutManager) getLayoutManager();
            int first = manager.findFirstVisibleItemPosition();
            if (first == RecyclerView.NO_POSITION) {
                return 0;
            }
            View firstView = manager.findViewByPosition(first);
            if (firstView == null) {
                return 0;
            }
            int count = getAdapter() == null ? 0 : getAdapter().getItemCount();
            int last = manager.findLastVisibleItemPosition();
            View lastView = last == RecyclerView.NO_POSITION ? null : manager.findViewByPosition(last);
            if (last == count - 1 && lastView != null
                    && manager.getDecoratedBottom(lastView) <= getHeight() - getPaddingBottom()) {
                // 最后一条已完整露出：内容不足一屏 → 0；已滚到底 → 贴底
                return first == 0 ? 0 : range - extent;
            }
            float fraction = 0f;
            int height = firstView.getHeight();
            if (height > 0) {
                int scrolled = getPaddingTop() - manager.getDecoratedTop(firstView);
                fraction = Math.min(1f, Math.max(0f, scrolled / (float) height));
            }
            long offset = (long) ((first + fraction) * (double) rowHeightPx());
            return (int) Math.max(0L, Math.min(offset, (long) range - extent));
        }

        /** 当前平均行高（px）；还没量到按 24dp 估算。 */
        private float rowHeightPx() {
            if (avgRowPx > 0f) {
                return avgRowPx;
            }
            return DEFAULT_ROW_DP * getResources().getDisplayMetrics().density;
        }

        /** 用屏幕内已绑定的子项重算平均行高；没有已量高的子项时保留旧值。 */
        private void refreshAverageRowHeight() {
            int count = getChildCount();
            if (count == 0) {
                return;
            }
            long sum = 0L;
            int measured = 0;
            for (int i = 0; i < count; i++) {
                int height = getChildAt(i).getHeight();
                if (height > 0) {
                    sum += height;
                    measured++;
                }
            }
            if (measured > 0) {
                avgRowPx = sum / (float) measured;
            }
        }
    }
}
