package com.example.waspwingtempctrl.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
 * <p><b>线程</b>：所有 File IO 在后台线程（{@link LogTailReader#read}）；主线程只做渲染。
 * Context 一律在主线程取出后捕获进闭包，后台线程不再调 {@code requireContext()}。
 *
 * <p><b>刷新</b>：页面可见时每 {@link #REFRESH_INTERVAL_MS} 毫秒重读一次；
 * 外壳用 add/hide/show 切页（见 {@code SetupActivity}），被隐藏的 Fragment 生命周期仍是
 * RESUMED，所以除了 {@code onPause}/{@code onResume}，{@code onHiddenChanged} 也必须停/启刷新。
 * 三处都走幂等的 {@link #startRefresh()} / {@link #stopRefresh()}。
 *
 * <p><b>无变化跳过</b>：内容指纹（size:mtime）与关键词都没变时，{@link LogTailReader} 直接返回
 * {@code unchanged}，不触碰 UI —— 否则每 2 秒重建一次 2000 行列表会白白抖动。
 *
 * <p><b>软键盘</b>：日志窗口压在页面最下方，键盘弹出时不顶起页面（只覆盖）。窗口的
 * softInputMode 是 Activity 级设置，故本页可见时接管、离开时还原，三处入口与刷新同一套。
 */
public class LogFragment extends Fragment {

    /** 自动刷新间隔。 */
    private static final long REFRESH_INTERVAL_MS = 2000L;
    /** 输入关键词后的去抖间隔（过滤本身在后台线程做）。 */
    private static final long FILTER_DEBOUNCE_MS = 250L;

    private RecyclerView listView;
    private LogListAdapter adapter;
    private TextView infoView;
    private TextView countView;
    private TextView tailView;
    private TextView emptyView;
    private TextView failureView;
    private View failureScroll;
    private View followButton;
    private EditText filterInput;

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
    /** 接管前的窗口 softInputMode；null 表示未接管。 */
    private Integer savedSoftInputMode;

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
        tailView = view.findViewById(R.id.log_tail_text);
        emptyView = view.findViewById(R.id.log_empty_text);
        failureView = view.findViewById(R.id.log_failure_text);
        failureScroll = view.findViewById(R.id.log_failure_scroll);
        followButton = view.findViewById(R.id.log_follow_btn);
        filterInput = view.findViewById(R.id.log_filter_input);

        adapter = new LogListAdapter(context);
        listView.setLayoutManager(new LinearLayoutManager(context));
        // 日志行不做增删动画：整批替换时动画只会变成闪烁
        listView.setItemAnimator(null);
        listView.setAdapter(adapter);
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
        countView.setText("");
        lastFollowCount = -1;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isHidden()) {
            startRefresh();
            pinImeOverlap();
        }
    }

    @Override
    public void onPause() {
        stopRefresh();
        restoreImeMode();
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        // 隐藏时生命周期仍是 RESUMED，不在这里停就一直在后台刷
        if (hidden) {
            stopRefresh();
            restoreImeMode();
        } else if (isResumed()) {
            startRefresh();
            pinImeOverlap();
        }
    }

    @Override
    public void onDestroyView() {
        stopRefresh();
        restoreImeMode();
        mainHandler.removeCallbacksAndMessages(null);
        listView = null;
        adapter = null;
        infoView = null;
        countView = null;
        tailView = null;
        emptyView = null;
        failureView = null;
        failureScroll = null;
        followButton = null;
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

    // ==================== 软键盘：只覆盖、不顶起 ====================

    /**
     * 接管窗口 softInputMode：键盘弹出时窗口不重排（日志窗口保持原高度，被键盘盖住即可）。
     * 幂等：已接管时无副作用。窗口设置是 Activity 级的，所以必须与 {@link #restoreImeMode()} 成对。
     */
    private void pinImeOverlap() {
        if (savedSoftInputMode != null) {
            return;
        }
        Activity activity = getActivity();
        Window window = activity == null ? null : activity.getWindow();
        if (window == null) {
            return;
        }
        savedSoftInputMode = window.getAttributes().softInputMode;
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
                | WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED);
    }

    /** 幂等：未接管时无副作用，还原后其他页面（配置页输入框）恢复原来的键盘行为。 */
    private void restoreImeMode() {
        if (savedSoftInputMode == null) {
            return;
        }
        Activity activity = getActivity();
        Window window = activity == null ? null : activity.getWindow();
        if (window != null) {
            window.setSoftInputMode(savedSoftInputMode);
        }
        savedSoftInputMode = null;
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
        infoView.setText(buildInfoText(snap));
        tailView.setText(buildTailText(snap));
        updateCountView(snap, keyword);

        if (!snap.ok) {
            // 失败：原样展示诊断，列表与跟随入口全部让位
            adapter.submit(java.util.Collections.emptyList());
            failureView.setText(getString(R.string.log_failure_title) + "\n\n" + snap.failureText);
            failureScroll.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
            emptyView.setVisibility(View.GONE);
            followButton.setVisibility(View.GONE);
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

    private void updateFollowButton() {
        if (followButton == null || listView == null || adapter == null) {
            return;
        }
        boolean show = listView.getVisibility() == View.VISIBLE
                && !following
                && adapter.getItemCount() > 0;
        followButton.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    /** 顶部信息条：路径 / 修改时间（诊断的一部分）。 */
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
     * 底部统计行：已读取行数 / 渲染上限行数，文件大小 / 尾读上限。
     * 行数取参与匹配的最近 N 行（{@link LogTailReader.Snapshot#candidateLines}），
     * 大小取文件字节数（超过上限即说明尾读被截断）。
     */
    private String buildTailText(LogTailReader.Snapshot snap) {
        AppFiles.Probe p = snap.probe;
        if (p == null) {
            return getString(R.string.log_loading);
        }
        if (!snap.ok) {
            return getString(R.string.log_tail_failed);
        }
        return getString(R.string.log_tail_fmt, snap.candidateLines, LogTailReader.MAX_LINES,
                formatK(p.size), formatK(LogTailReader.TAIL_BYTES));
    }

    /** 命中计数只在有关键词时才有意义；无关键词时行数信息统一在底部统计行。 */
    private void updateCountView(LogTailReader.Snapshot snap, String keyword) {
        boolean filtered = snap.ok && !keyword.isEmpty();
        countView.setVisibility(filtered ? View.VISIBLE : View.GONE);
        countView.setText(filtered ? getString(R.string.log_count_hit_fmt, snap.lines.size()) : "");
    }

    /** 字节 → k（1024 进制）文本，最多 1 位小数且整数不补 {@code .0}：1843 → "1.8"、409600 → "400"。 */
    private static String formatK(long bytes) {
        String text = String.format(Locale.US, "%.1f", bytes / 1024.0);
        return text.endsWith(".0") ? text.substring(0, text.length() - 2) : text;
    }

    private static final SimpleDateFormat TIME_FMT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
}
