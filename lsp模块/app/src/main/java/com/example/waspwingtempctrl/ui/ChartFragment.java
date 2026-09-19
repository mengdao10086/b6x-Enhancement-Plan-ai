package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.waspwingtempctrl.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 曲线页（D2）：档位选择 + 图例 + 自绘画布 + 失败可诊断。
 *
 * <p>绘制口径在 {@link ChartView}（自绘）与 {@link ChartAxis}/{@link ChartDataset}/
 * {@link ChartWindow} 内，逐条对齐 {@code 逻辑说明.md}（仓库根）的「曲线」一节。
 *
 * <p><b>线程</b>：文件读取、{@code profile.conf} 与 {@code params.json} 的读取全部在后台线程
 * （{@link ChartLoader}/{@link ChartConfig}）；主线程只做渲染。Context 一律在主线程取出后
 * 捕获进闭包，后台线程不再调 {@code requireContext()}。
 *
 * <p><b>刷新</b>：页面可见时每 {@link #REFRESH_INTERVAL_MS} 毫秒重读一次（C 端约 1 秒一行）。
 * 外壳用 add/hide/show 切页（见 {@code SetupActivity}），被隐藏的 Fragment 生命周期仍是
 * RESUMED，所以除 {@code onPause}/{@code onResume} 外 {@code onHiddenChanged} 也必须停/启刷新，
 * 三处都走幂等的 {@link #startRefresh()}/{@link #stopRefresh()}。
 */
public class ChartFragment extends Fragment {

    /** 自动刷新间隔（C 端 write_webui_data 约 1s 一行）。 */
    private static final long REFRESH_INTERVAL_MS = 1000L;

    /** 整块控件行缩放时的可用宽余量（原实现 0.96，即 4% 缓冲）。 */
    private static final float FIT_LIMIT_RATIO = 0.96f;

    /** 缩放下限（原实现 max(0.5, fitLimit/total)）。 */
    private static final float MIN_SCALE = 0.5f;

    private ChartView chartView;
    private TextView infoView;
    private ScrollView failureScroll;
    private TextView failureText;
    private FrameLayout toolsClip;
    private LinearLayout toolsRow;
    private LinearLayout legendRow;
    private MaterialButtonToggleGroup windowGroup;

    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    /** 定时刷新开关；与视图状态解耦，便于三处入口重复调用。 */
    private boolean refreshing;
    /** 当前在跑的后台读取线程；存活时不再起新的。 */
    private Thread worker;

    private File dataFile;
    private ChartConfig config;
    private ChartDataset dataset;
    private String lastFingerprint;
    /** 页面重新可见时置位：下次刷新顺带重读配置（用户可能在配置页改过口径键）。 */
    private boolean configStale;

    /** 当前窗口档位（秒）；-1 表示配置尚未加载。 */
    private int windowSec = -1;
    private AppFiles.Probe lastProbe;
    private boolean lastOk;
    private int lastBreaks;
    private int lastBreakSeconds;
    private int lastToolsWidth = -1;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = requireContext();

        chartView = view.findViewById(R.id.chart_view);
        infoView = view.findViewById(R.id.chart_info_text);
        failureScroll = view.findViewById(R.id.chart_failure_scroll);
        failureText = view.findViewById(R.id.chart_failure_text);
        toolsClip = view.findViewById(R.id.chart_tools_clip);
        toolsRow = view.findViewById(R.id.chart_tools_row);
        legendRow = view.findViewById(R.id.chart_legend_row);
        windowGroup = view.findViewById(R.id.chart_window_group);

        dataFile = AppFiles.dataFile(context);
        infoView.setText(context.getString(R.string.chart_loading));

        buildLegend();
        // 档位切换监听只挂一次：按钮可能被整体重建（配置重读后档位集合变化），
        // 挂在按钮上会随重建丢/重复，挂在组上不会。
        windowGroup.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (!isChecked) {
                return;
            }
            View child = group.findViewById(checkedId);
            if (child == null || !(child.getTag() instanceof Integer)) {
                return;
            }
            int sec = (Integer) child.getTag();
            if (sec == windowSec) {
                return;
            }
            windowSec = sec;
            rebuildWindow();
            fitToolsRow();
        });
        // 控件行宽度变化（首次布局 / 旋转）后重算整体缩放；宽度没变就跳过，避免布局回环
        toolsClip.addOnLayoutChangeListener((v, l, t, r, b, ol, ot, or, ob) -> {
            int w = r - l;
            if (w != lastToolsWidth) {
                lastToolsWidth = w;
                fitToolsRow();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (chartView != null) {
            chartView.refreshThemeColors();   // 主题色可能在页面之外变化过
        }
        if (!isHidden()) {
            configStale = true;               // 页面可见即重读配置（用户可能刚在配置页改过）
            startRefresh();
        }
    }

    @Override
    public void onPause() {
        stopRefresh();
        super.onPause();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        // 隐藏时生命周期仍是 RESUMED，不在这里停就一直在后台刷
        if (hidden) {
            stopRefresh();
        } else if (isResumed()) {
            configStale = true;   // 从别的页切回来：重读一次配置口径
            startRefresh();
        }
    }

    @Override
    public void onDestroyView() {
        stopRefresh();
        mainHandler.removeCallbacksAndMessages(null);
        chartView = null;
        infoView = null;
        failureScroll = null;
        failureText = null;
        toolsClip = null;
        toolsRow = null;
        legendRow = null;
        windowGroup = null;
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

    /** 起一次后台读取（已有读取在跑就跳过，靠 1 秒定时补上）。 */
    private void loadNow() {
        if (chartView == null || !isAdded() || dataFile == null) {
            return;
        }
        if (worker != null && worker.isAlive()) {
            return;
        }
        final Context appContext = requireContext().getApplicationContext();
        final File file = dataFile;
        // 配置未就绪或已过期（页面刚重新可见）→ 传 null，让后台重新加载配置
        final ChartConfig cfgNow = configStale ? null : config;
        configStale = false;
        // 配置重读时指纹一并作废：否则内容没变会被当成"无变化"而跳过整次刷新
        final String fingerprint = cfgNow != null ? lastFingerprint : null;

        Thread thread = new Thread(() -> {
            ChartConfig cfg = cfgNow != null ? cfgNow : ChartConfig.load(appContext);
            ChartLoader.Snapshot snap = ChartLoader.read(appContext, file, cfg, fingerprint);
            mainHandler.post(() -> applySnapshot(cfg, snap));
        }, "ww-chart");
        thread.setDaemon(true);
        worker = thread;
        thread.start();
    }

    // ==================== 渲染（主线程） ====================

    private void applySnapshot(ChartConfig cfg, ChartLoader.Snapshot snap) {
        if (chartView == null || !isAdded()) {
            return;
        }
        // 配置首次到位或重读（页面重新可见时重读）→ 重建档位按钮；
        // 当前档位不在新档位集合里才回落默认，避免每次切页都把用户选的档位冲掉
        boolean configChanged = config != cfg;
        config = cfg;
        boolean windowInvalid = windowSec <= 0 || !containsOption(cfg, windowSec);
        if (windowInvalid) {
            windowSec = cfg.windowDefaultSec;
        }
        if (configChanged || windowInvalid) {
            buildWindowButtons();
        }
        if (snap.unchanged) {
            return;
        }
        lastProbe = snap.probe;
        lastOk = snap.ok;

        if (!snap.ok) {
            // 失败：原样展示诊断，画布让位（绝不静默留白）
            lastFingerprint = null;
            dataset = null;
            chartView.setVisibility(View.GONE);
            chartView.setData(null, cfg);
            failureText.setText(getString(R.string.chart_failure_title) + "\n\n" + snap.failureText);
            failureScroll.setVisibility(View.VISIBLE);
            updateInfoText();
            return;
        }
        lastFingerprint = snap.fingerprint;
        dataset = snap.dataset;
        failureScroll.setVisibility(View.GONE);
        chartView.setVisibility(View.VISIBLE);
        rebuildWindow();
    }

    /** 窗口/档位变化只重算窗口切片与轴，不重新读文件。 */
    private void rebuildWindow() {
        if (chartView == null || dataset == null || config == null || windowSec <= 0) {
            return;
        }
        ChartWindow win = ChartWindow.of(dataset, windowSec, config.rollingMaxLines,
                config.gapDetectSec, config.gapMaxSec);
        lastBreaks = win.breaks;
        lastBreakSeconds = win.breakSeconds;
        chartView.setData(win, config);
        updateInfoText();
    }

    /** 顶部信息条：路径 / 大小 / 修改时间 / 解析量 / 档位与行数上限（+ 回落说明）。 */
    private void updateInfoText() {
        if (infoView == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String path = dataFile != null ? dataFile.getAbsolutePath() : getString(R.string.chart_value_unknown);
        sb.append(getString(R.string.chart_info_path_fmt, path));

        AppFiles.Probe p = lastProbe;
        boolean statOk = p != null && p.statOk;
        String size = statOk ? getString(R.string.chart_size_fmt, p.size)
                : getString(R.string.chart_size_unknown);
        String time = statOk && p.mtimeMs > 0L ? TIME_FMT.format(new Date(p.mtimeMs))
                : getString(R.string.chart_value_unknown);
        sb.append('\n').append(getString(R.string.chart_info_meta_fmt, size, time));

        if (lastOk && dataset != null && config != null && windowSec > 0) {
            sb.append('\n').append(getString(R.string.chart_info_parse_fmt,
                    dataset.parsedLines, dataset.skippedLines, windowSec, config.rollingMaxLines));
            if (lastBreaks > 0) {
                sb.append('\n').append(getString(R.string.chart_info_break_fmt, lastBreaks, lastBreakSeconds));
            }
        } else {
            sb.append('\n').append(getString(R.string.chart_render_failed));
        }
        if (config != null) {
            for (String note : config.notes) {
                sb.append('\n').append("⚠ ").append(note);
            }
        }
        infoView.setText(sb.toString());
    }

    // ==================== 控件构建 ====================

    /** 图例：6 条曲线，默认开关照 {@code 逻辑说明.md} 的「曲线」一节〈系列开关〉；勾选框着色 = 该曲线的 chart_series_* 色。 */
    private void buildLegend() {
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        legendRow.removeAllViews();
        for (int i = 0; i < chartView.seriesCount(); i++) {
            final int index = i;
            ChartSeries s = chartView.seriesAt(i);
            CheckBox box = (CheckBox) inflater.inflate(R.layout.item_chart_legend, legendRow, false);
            box.setText(s.labelRes);
            box.setChecked(s.on);
            int color = requireContext().getResources().getColor(s.colorRes, requireContext().getTheme());
            box.setButtonTintList(ColorStateList.valueOf(color));
            box.setOnCheckedChangeListener((button, checked) -> chartView.setSeriesEnabled(index, checked));
            legendRow.addView(box);
        }
    }

    /** 档位按钮来自 params.json 的 chart.windowOptionsSec（读不到时用回落常量）。 */
    private void buildWindowButtons() {
        if (windowGroup == null || config == null) {
            return;
        }
        LayoutInflater inflater = LayoutInflater.from(requireContext());
        windowGroup.removeAllViews();
        for (int sec : config.windowOptions) {
            MaterialButton b = (MaterialButton) inflater.inflate(
                    R.layout.item_chart_window_button, windowGroup, false);
            b.setId(View.generateViewId());
            b.setText(getString(R.string.chart_window_btn_fmt, sec));
            b.setTag(sec);
            windowGroup.addView(b);
        }
        // 选中当前档位（监听已挂在组上，重复 check 同值会被自身的相等判断挡掉）
        for (int i = 0; i < windowGroup.getChildCount(); i++) {
            View child = windowGroup.getChildAt(i);
            if (child.getTag() instanceof Integer && (Integer) child.getTag() == windowSec) {
                windowGroup.check(child.getId());
                break;
            }
        }
        fitToolsRow();
    }

    private static boolean containsOption(ChartConfig cfg, int sec) {
        for (int v : cfg.windowOptions) {
            if (v == sec) {
                return true;
            }
        }
        return false;
    }

    /**
     * 档位 + 图例整块等比缩放（口径清单 §7）：量出自然宽，超过可用宽 × 0.96 时整块
     * {@code setScaleX/Y}（pivot 左上）。最小 0.5，不做复位按钮。
     */
    private void fitToolsRow() {
        if (toolsRow == null || toolsClip == null) {
            return;
        }
        int avail = toolsClip.getWidth() - toolsClip.getPaddingLeft() - toolsClip.getPaddingRight();
        if (avail <= 0) {
            return;
        }
        toolsRow.setScaleX(1f);
        toolsRow.setScaleY(1f);
        int spec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        toolsRow.measure(spec, spec);
        int total = toolsRow.getMeasuredWidth();
        int naturalH = toolsRow.getMeasuredHeight();
        if (total <= 0 || naturalH <= 0) {
            return;
        }
        float fitLimit = avail * FIT_LIMIT_RATIO;
        float z = total > fitLimit ? Math.max(MIN_SCALE, fitLimit / total) : 1f;
        toolsRow.setPivotX(0f);
        toolsRow.setPivotY(0f);
        toolsRow.setScaleX(z);
        toolsRow.setScaleY(z);
        // 容器高度跟着缩放后的实际高度走，否则底部留一片空白
        int wantH = Math.max(1, Math.round(naturalH * z));
        ViewGroup.LayoutParams lp = toolsClip.getLayoutParams();
        if (lp != null && lp.height != wantH) {
            lp.height = wantH;
            toolsClip.setLayoutParams(lp);
        }
    }

    private static final SimpleDateFormat TIME_FMT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
}
