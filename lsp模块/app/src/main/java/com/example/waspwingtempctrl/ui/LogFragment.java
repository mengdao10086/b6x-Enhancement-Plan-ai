package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.example.waspwingtempctrl.AppFiles;
import com.example.waspwingtempctrl.SetupActivity;
import com.example.waspwingtempctrl.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日志页（D3）：尾读守护进程日志、跟随底部、关键词过滤、四类着色、失败可诊断。
 *
 * <p>读文件统一走 {@link AppFiles}（{@link LogTailReader} 内部调用），本类只负责渲染与刷新节奏。
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

    /** 自动刷新间隔。 */
    private static final long REFRESH_INTERVAL_MS = 2000L;
    /** 输入关键词后的去抖间隔（过滤本身在后台线程做）。 */
    private static final long FILTER_DEBOUNCE_MS = 250L;
    /** 拖动扩选：离列表上下边界几行以内开始自动滚动（按可见行实测行高换算）。 */
    private static final int DRAG_EDGE_ROWS = 3;
    /** 拖动扩选：自动滚动速度区间（dp/秒）——刚进入触发带取最小，贴到边界取最大，中间线性。 */
    private static final int DRAG_SCROLL_MIN_DP_PER_SEC = 80;
    private static final int DRAG_SCROLL_MAX_DP_PER_SEC = 3200;
    /** 拖动扩选：自动滚动的拍间隔。 */
    private static final long DRAG_SCROLL_INTERVAL_MS = 16L;

    /**
     * 本页是否为当前页（外壳 ViewPager2 广播，见 {@code PageAware}）：切页不再 hide/show、
     * 也不派发 onPause，故「是不是当前页」只能自己记着。
     */
    private boolean pageVisible;

    private RecyclerView listView;
    private LogListAdapter adapter;
    private TextView infoView;
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
    /** 当前在跑的后台读取线程；存活时不再起新的。 */
    private Thread worker;
    private String lastFingerprint;
    private String lastKeyword;
    /** 上次自动跟随滚到的行数；相同且已在底部就不再滚，避免反复唤醒滚动条。 */
    private int lastFollowCount = -1;

    private final Runnable tick = new Runnable() {
        @Override
        public void run() {
            if (!refreshing) {
                return;
            }
            loadNow();
            mainHandler.postDelayed(this, REFRESH_INTERVAL_MS);
        }
    };

    private final Runnable filterDebounce = new Runnable() {
        @Override
        public void run() {
            if (!refreshing) {
                return;   // 页面已不可见，不为了过滤白跑一次 IO
            }
            loadNow();
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

        listView = view.findViewById(R.id.log_list);
        infoView = view.findViewById(R.id.log_info_text);
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
        listView.setLayoutManager(new LinearLayoutManager(context));
        // 日志行不做增删动画：整批替换时动画只会变成闪烁
        listView.setItemAnimator(null);
        listView.setAdapter(adapter);
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

        infoView.setText(R.string.log_loading);
        statView.setText(R.string.log_loading);
        countView.setText("");
        lastFollowCount = -1;
        TextCopy.installPathSelection(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (pageVisible) {
            startRefresh();
        }
    }

    @Override
    public void onPause() {
        stopRefresh();
        super.onPause();
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
        super.onDestroyView();
    }

    // ==================== 刷新节奏 ====================

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

    /** 起一次后台读取（已有读取在跑就跳过，靠 2 秒定时补上）。 */
    private void loadNow() {
        if (listView == null || !isAdded()) {
            return;
        }
        if (worker != null && worker.isAlive()) {
            return;
        }
        final Context appContext = requireContext().getApplicationContext();
        final File file = AppFiles.logFile(appContext);
        final String keyword = currentKeyword();
        final String fingerprint = lastFingerprint;
        final String lastKw = lastKeyword;

        Thread thread = new Thread(() -> {
            final LogTailReader.Snapshot snap =
                    LogTailReader.read(appContext, file, keyword, fingerprint, lastKw);
            mainHandler.post(() -> {
                if (listView == null) {
                    return;
                }
                applySnapshot(snap, keyword);
            });
        }, "ww-log");
        thread.setDaemon(true);
        worker = thread;
        thread.start();
    }

    private String currentKeyword() {
        if (filterInput == null || filterInput.getText() == null) {
            return "";
        }
        return filterInput.getText().toString().trim();
    }

    private void applySnapshot(LogTailReader.Snapshot snap, String keyword) {
        if (snap.unchanged) {
            return;
        }
        render(snap, keyword);
        // 读的这段时间里关键词又变了 → 立刻按新关键词补一次
        if (!keyword.equals(currentKeyword())) {
            loadNow();
        }
    }

    // ==================== 渲染（主线程） ====================

    private void render(LogTailReader.Snapshot snap, String keyword) {
        if (infoView == null) {
            return;
        }
        // 正在选中的控件本轮不重写：setText 会清掉选择与手柄。其余控件照常刷新，选择结束后下一轮自动补上
        if (!TextCopy.isSelecting(infoView)) {
            infoView.setText(buildInfoText(snap));
        }
        if (!TextCopy.isSelecting(statView)) {
            statView.setText(buildStatText(snap));
        }
        updateCountView(snap, keyword);

        if (!snap.ok) {
            // 选择期间不切视图：列表一旦让位给诊断，高亮与操作条就失去了作用对象
            if (isSelectingLines()) {
                return;
            }
            // 失败：原样展示诊断，列表与跟随入口全部让位
            adapter.submit(java.util.Collections.emptyList());
            failureView.setText(getString(R.string.log_failure_title) + "\n\n" + snap.failureText);
            failureScroll.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            emptyView.setVisibility(View.GONE);
            followButton.setVisibility(View.GONE);
            return;
        }

        // 选择期间不重绑列表：新一批行会顶掉选中区间（下标对不上），高亮也跟着失效。
        // 这里只暂停列表本身，信息行/统计行已在上方按各自的选择状态单独处理
        if (isSelectingLines()) {
            return;
        }
        failureScroll.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
        adapter.submit(snap.lines);

        boolean empty = snap.lines.isEmpty();
        emptyView.setVisibility(empty ? View.VISIBLE : View.GONE);
        if (empty) {
            emptyView.setText(keyword.isEmpty()
                    ? getString(R.string.log_empty_no_lines)
                    : getString(R.string.log_empty_no_hit, keyword, snap.candidateLines));
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
        if (adapter != null && adapter.isSelecting()) {
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

    /** 信息条首行：路径 / 修改时间（诊断的一部分）。 */
    private String buildInfoText(LogTailReader.Snapshot snap) {
        AppFiles.Probe p = snap.probe;
        if (p == null) {
            return getString(R.string.log_loading);
        }
        String time = (p.statOk && p.mtimeMs > 0L)
                ? TIME_FMT.format(new Date(p.mtimeMs))
                : getString(R.string.log_value_unknown);
        return getString(R.string.log_info_fmt, p.path, time);
    }

    /**
     * 统计行（同在「日志文件」卡里，紧跟路径/修改时间）：已读取行数 / 渲染上限行数，
     * 文件大小 / 尾读上限。
     * 行数取参与匹配的最近 N 行（{@link LogTailReader.Snapshot#candidateLines}），
     * 大小取文件字节数（超过上限即说明尾读被截断）。
     */
    private String buildStatText(LogTailReader.Snapshot snap) {
        AppFiles.Probe p = snap.probe;
        if (p == null) {
            return getString(R.string.log_loading);
        }
        if (!snap.ok) {
            return getString(R.string.log_stat_failed);
        }
        return getString(R.string.log_stat_fmt, snap.candidateLines, LogTailReader.MAX_LINES,
                formatK(p.size), formatK(LogTailReader.TAIL_BYTES));
    }

    /** 命中计数只在有关键词时才有意义；无关键词时行数信息统一在「日志文件」卡的统计行。 */
    private void updateCountView(LogTailReader.Snapshot snap, String keyword) {
        if (TextCopy.isSelecting(countView)) {
            return;   // 选中期间不改文本/可见性；选择结束后下一轮刷新补上
        }
        boolean filtered = snap.ok && !keyword.isEmpty();
        countView.setVisibility(filtered ? View.VISIBLE : View.GONE);
        countView.setText(filtered ? getString(R.string.log_count_hit_fmt, snap.lines.size()) : "");
    }

    /** 字节 → k（1024 进制）文本，最多 1 位小数且整数不补 {@code .0}：1843 → "1.8"、204800 → "200"。 */
    private static String formatK(long bytes) {
        String text = String.format(Locale.US, "%.1f", bytes / 1024.0);
        return text.endsWith(".0") ? text.substring(0, text.length() - 2) : text;
    }

    private static final SimpleDateFormat TIME_FMT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
}
