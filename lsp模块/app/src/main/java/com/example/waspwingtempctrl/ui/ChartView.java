package com.example.waspwingtempctrl.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 曲线自绘控件。口径逐条对齐 {@code app/逻辑说明.md} §7。
 *
 * <p><b>性能硬约束</b>：{@code onDraw} 只画，全部几何量（轴与刻度、每系列 {@link Path}、末端圆点与标签、
 * 断联空白）都在 {@link #rebuild()} 里算好并缓存，<b>绝不在 onDraw 内重建 Path</b>（口径见 app/逻辑说明.md §7）。
 *
 * <p><b>本控件不读文件</b>：数据由 {@link ChartLoader} 在后台线程读好后经
 * {@link #setData(ChartWindow, ChartConfig)} 送上主线程。
 *
 * <p><b>配色</b>：全部运行时按当前主题取（{@code getColor(id, theme)}），本类不出现任何十六进制色值；
 * 底色 / 网格线 / 曲线配色的取色口径见 app/逻辑说明.md §7.5。
 */
public class ChartView extends View {

    // ---- 口径常量（CSS px → dp，绘制时乘 density）----
    // 左右内边距不是定值：按本次刻度文字实测宽 + TICK_GAP_DP 现算（见 applyAxisPads）。
    // 上下内边距与接缝的推导见 app/逻辑说明.md §7.3。
    private static final int TICK_GAP_DP = 4;        // 刻度数字与绘图区左沿 / 画布右沿之间的间隙
    // 上内边距 17：硬下限，不能再小（再低轴标题会被画到画布外裁掉）
    private static final int PAD_T_DP = 17;
    // 下内边距 4：与 PAD_T 合计 21；再小则网格线贴下沿、且与画布下沿的拖柄横条相碰
    private static final int PAD_B_DP = 4;
    private static final float LINE_WIDTH_DP = 1.6f; // 折线
    private static final float GRID_WIDTH_DP = 1f;   // 网格
    private static final float HALO_WIDTH_DP = 3f;   // 文字 halo
    private static final float DOT_RADIUS_DP = 3.2f; // 头部圆点
    private static final float DOT_HALO_DP = 1f;     // 圆点外圈
    // 竖虚线：与网格线同宽同色（透明度含在网格色里），3dp 实 / 3dp 空
    private static final float DASH_ON_DP = 3f;
    private static final float DASH_OFF_DP = 3f;
    // 按住查看：高亮虚线用轴色约 70% 透明；数值面板底 = 底色约 85% 透明、圆角 4dp
    private static final float TOUCH_LINE_ALPHA = 0.7f;
    private static final float TOUCH_PANEL_ALPHA = 0.85f;
    private static final float TOUCH_PANEL_RADIUS_DP = 4f;
    private static final float TOUCH_PANEL_TOP_DP = 2f;   // 面板顶距绘图区上沿
    private static final float TOUCH_PANEL_GAP_DP = 6f;   // 面板与高亮虚线的水平间距
    private static final float TOUCH_PANEL_PAD_X_DP = 3f;
    private static final float TOUCH_PANEL_PAD_Y_DP = 2f;
    private static final long TOUCH_PANEL_SIDE_MS = 140L; // 换边过渡时长
    // pid 曲线相邻两次重算样本的最大间隔（控制 5s + 写行落后 1s）；超过即视为不连续、不连线
    private static final float PID_CHAIN_MAX_SEC = 6f;
    // pid 曲线的孤立样本（前后都没有相邻重算点）：只画一个实心圆点，不连线、不描边
    private static final float PID_DOT_RADIUS_DP = LINE_WIDTH_DP * 1.3f;
    private static final float TICK_TEXT_DP = 10f;   // 刻度 / 轴标题 / 按住查看字号
    private static final float EMPTY_TEXT_DP = 12f;  // 「采样中…」字号
    // 末端数值标签与端点的水平间距、标签相对端点的抬升量（沿用原多系列标注口径）
    private static final float LABEL_GAP_DP = 6f;
    private static final float LABEL_LIFT_DP = 4f;
    // 按住查看的数值行高（webui 同名常量 LABEL_H）
    private static final float LABEL_H_DP = 11f;
    // 无左轴（左轴系列全关或窗口内无有效左轴值）时，整图横线改按右轴值域等分 4 段（5 条）
    private static final int RIGHT_ONLY_GRID_SEGMENTS = 4;

    private final Paint gridPaint = new Paint();
    private final Paint tickPaint = new Paint();     // 左轴刻度（右对齐）
    private final Paint axisTextPaint = new Paint(); // 右轴刻度 / 轴标题（左对齐）
    private final Paint seriesPaint = new Paint();
    private final Paint haloPaint = new Paint();     // 文字 halo（STROKE）
    private final Paint labelPaint = new Paint();
    private final Paint dotPaint = new Paint();
    private final Paint dotHaloPaint = new Paint();
    private final Paint dashPaint = new Paint();     // 重算位置竖虚线（与网格同宽同色）
    private final Paint highlightPaint = new Paint(); // 按住查看的高亮竖虚线（与重算虚线同节奏）
    private final Paint panelPaint = new Paint();     // 按住查看的数值面板底色

    private final ChartSeries[] series = ChartSeries.createAll();

    private float density;
    /** 画布视觉底色（= 卡片底色）。本类不铺底色（避免与卡片形成第二个色块），此色只用于文字 halo 与圆点外圈。 */
    private int colorBg;
    private int colorGrid;
    private int colorAxis;
    /** 按住查看的高亮虚线色（轴色 + 约 70% 透明）。 */
    private int colorHighlight;
    /** 按住查看的数值面板底色（底色 + 约 85% 透明）。 */
    private int colorPanel;
    private final int[] seriesColors = new int[series.length];
    private boolean colorsReady;

    private ChartWindow window;
    private ChartConfig config;

    // ---- rebuild 产物：onDraw 只消费 ----
    private String placeholder;
    private String titleLeft;
    private String titleRight;
    private float fPadL;
    private float fPadR;
    private float fPadT;
    private float fW;
    private float fH;
    /** 两个轴标题的绘制 x：左标题左沿 = 最左那条刻度数字的左沿，右标题右沿 = 最右那条的右沿。 */
    private float titleLeftX;
    private float titleRightX;
    private float[] gridY;
    private String[] gridText;
    private String[] rightText;
    private Path[] paths;
    private ChartDotOp[] dots;
    /** 末端数值标签（成对系列里当前强调的实际/目标两条，最多两条）。 */
    private ChartLabelOp[] endLabels;
    /** PID 重算标记：竖向虚线（x 坐标）。 */
    private float[] dashXs;
    /** pid 曲线的孤立样本点（x/y 同长，颜色恒为 pid 系列色）。 */
    private float[] pidDotX;
    private float[] pidDotY;
    private int pidDotColor;
    private int pidDotCount;

    // ---- 按住查看：触摸回调里算好，onDraw 只画 ----
    private boolean touchActive;
    /** 手指 x（已钳进绘图区）。 */
    private float touchRawX;
    /** 高亮虚线的 x（已吸附到笔宽栅格）。 */
    private float touchDashX;
    /** 最近的样本下标；-1 = 无。 */
    private int touchSample = -1;
    /** 最近样本的时间戳：窗口每秒滑动时同一数组下标可能换人，靠它发现样本已变。 */
    private long touchSampleT;
    private String[] touchTexts;
    private int[] touchColors;
    private float[] touchTextY;
    private int touchRowCount;
    private float touchPanelL;
    private float touchPanelT;
    private float touchPanelR;
    private float touchPanelB;
    private float touchTextX;
    private float touchPanelW;
    /** 换边过渡：非 null = 正在从换边那一刻的绘制位置滑向新一侧。 */
    private ValueAnimator panelSideAnim;
    /** 换边过渡的固定起点（换边时刻的绘制 x）。 */
    private float panelSideFromL;
    /** 换边过渡的当前目标 x（同侧移动时每帧跟随手指更新）。 */
    private float panelSideToL;
    /** 当前目标侧：true = 右。用于判定是否换边。 */
    private boolean panelOnRight;
    /** 本段按住是否已落过位：首帧直接出现，不补间。 */
    private boolean panelPlaced;

    public ChartView(Context context) {
        super(context);
        init();
    }

    public ChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        density = getResources().getDisplayMetrics().density;
        gridPaint.setAntiAlias(true);
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setStrokeWidth(GRID_WIDTH_DP * density);
        tickPaint.setAntiAlias(true);
        tickPaint.setTextSize(TICK_TEXT_DP * density);
        tickPaint.setTextAlign(Paint.Align.RIGHT);
        axisTextPaint.setAntiAlias(true);
        axisTextPaint.setTextSize(TICK_TEXT_DP * density);
        axisTextPaint.setTextAlign(Paint.Align.LEFT);
        seriesPaint.setAntiAlias(true);
        seriesPaint.setStyle(Paint.Style.STROKE);
        seriesPaint.setStrokeWidth(LINE_WIDTH_DP * density);
        haloPaint.setAntiAlias(true);
        haloPaint.setStyle(Paint.Style.STROKE);
        haloPaint.setStrokeWidth(HALO_WIDTH_DP * density);
        haloPaint.setTextSize(TICK_TEXT_DP * density);
        labelPaint.setAntiAlias(true);
        labelPaint.setStyle(Paint.Style.FILL);
        labelPaint.setTextSize(TICK_TEXT_DP * density);
        labelPaint.setTextAlign(Paint.Align.LEFT);
        dotPaint.setAntiAlias(true);
        dotPaint.setStyle(Paint.Style.FILL);
        dotHaloPaint.setAntiAlias(true);
        dotHaloPaint.setStyle(Paint.Style.STROKE);
        dotHaloPaint.setStrokeWidth(DOT_HALO_DP * density);
        dashPaint.setAntiAlias(true);
        dashPaint.setStyle(Paint.Style.STROKE);
        dashPaint.setStrokeWidth(GRID_WIDTH_DP * density);
        dashPaint.setPathEffect(new DashPathEffect(
                new float[]{DASH_ON_DP * density, DASH_OFF_DP * density}, 0f));
        highlightPaint.setAntiAlias(true);
        highlightPaint.setStyle(Paint.Style.STROKE);
        highlightPaint.setStrokeWidth(GRID_WIDTH_DP * density);
        highlightPaint.setPathEffect(new DashPathEffect(
                new float[]{DASH_ON_DP * density, DASH_OFF_DP * density}, 0f));
        panelPaint.setAntiAlias(true);
        panelPaint.setStyle(Paint.Style.FILL);
    }

    // ==================== 外部接口 ====================

    /** 数据与口径参数（主线程调用）。 */
    public void setData(@Nullable ChartWindow win, @Nullable ChartConfig cfg) {
        boolean configChanged = this.config != cfg;
        this.window = win;
        this.config = cfg;
        if (!colorsReady || configChanged) {
            loadColors();   // 交换开关改变强调角色 → 线色要按新角色重取
        }
        rebuild();
        invalidate();
    }

    /** 图例开关（主线程调用）：切换后轴范围与末端圆点同步重算。 */
    public void setSeriesEnabled(int index, boolean on) {
        if (index < 0 || index >= series.length) {
            return;
        }
        series[index].on = on;
        rebuild();
        invalidate();
    }

    /** 图例项定义（只读）。 */
    ChartSeries seriesAt(int index) {
        return series[index];
    }

    /** 当前配置下的图例/按住查看显示顺序（存的是系列数组下标；交换开关只换成对两条的槽位）。 */
    int[] seriesOrder(@Nullable ChartConfig cfg) {
        return ChartSeries.displayOrder(series, cfg);
    }

    /** 主题/字体变化后重新取色并重算（本类不缓存跨主题的色值）。 */
    public void refreshThemeColors() {
        float d = getResources().getDisplayMetrics().density;
        if (d != density) {
            density = d;
            init();
        }
        loadColors();
        rebuild();
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        rebuild();
    }

    // ==================== 配色 ====================

    private void loadColors() {
        Resources res = getResources();
        Theme theme = getContext().getTheme();
        // 底色 = 卡片底色（halo 与圆点外圈靠它遮住穿过的曲线）；见 app/逻辑说明.md §7.5
        colorBg = res.getColor(R.color.app_surface_container, theme);
        // 网格线走主题分隔线色（可见度论证见 app/逻辑说明.md §7.5）
        colorGrid = res.getColor(R.color.app_outline_variant, theme);
        colorAxis = res.getColor(R.color.chart_axis, theme);
        for (int i = 0; i < series.length; i++) {
            // 强调方取不透明色、参考方取同 RGB 半透明色；交换开关因此同时交换两条线的颜色
            seriesColors[i] = res.getColor(ChartSeries.colorRes(series[i], config), theme);
        }
        haloPaint.setColor(colorBg);
        dotHaloPaint.setColor(colorBg);
        colorHighlight = withAlpha(colorAxis, TOUCH_LINE_ALPHA);
        colorPanel = withAlpha(colorBg, TOUCH_PANEL_ALPHA);
        colorsReady = true;
    }

    /** 给已有色值换一个透明度（不动 RGB）。 */
    private static int withAlpha(int color, float alpha) {
        int a = Math.round(255f * alpha);
        return (color & 0x00FFFFFF) | (a << 24);
    }

    // ==================== 预计算 ====================

    /**
     * 算出本次绘制的全部几何量：轴定标 → 网格 → 断联空白 → 每系列 Path → 末端圆点。
     */
    private void rebuild() {
        placeholder = null;
        gridY = null;
        gridText = null;
        rightText = null;
        paths = null;
        dots = null;
        endLabels = null;
        dashXs = null;
        pidDotX = null;
        pidDotY = null;
        pidDotCount = 0;

        if (!colorsReady) {
            loadColors();
        }
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        float padT = PAD_T_DP * density;
        float padB = PAD_B_DP * density;
        fPadT = padT;
        fH = h - padT - padB;
        if (fH <= 8f * density) {
            clearTouch();
            return;
        }
        titleLeft = getContext().getString(R.string.chart_axis_left);
        titleRight = getContext().getString(R.string.chart_axis_right);

        ChartWindow win = window;
        if (win == null || win.samples.length < 2) {
            placeholder = getContext().getString(R.string.chart_waiting);
            clearTouch();
            return;
        }
        List<ChartSeries> left = new ArrayList<>();
        List<ChartSeries> right = new ArrayList<>();
        for (ChartSeries s : series) {
            if (!s.on) {
                continue;
            }
            (s.axis == ChartSeries.AXIS_LEFT ? left : right).add(s);
        }
        if (left.isEmpty() && right.isEmpty()) {
            placeholder = getContext().getString(R.string.chart_no_series);
            clearTouch();
            return;
        }

        int rpmMin = config != null ? config.rpmAxisMin : 0;
        // 左轴：先按"排除低于转速下限的样本"求范围；全被滤掉时退回不过滤（口径见 app/逻辑说明.md §7.3〈双纵轴〉）
        ChartAxis lAxis = null;
        float[] ext = extent(left, win, rpmMin, true);
        if (ext == null) {
            ext = extent(left, win, rpmMin, false);
        }
        if (ext != null) {
            lAxis = ChartAxis.fit(ext[0], ext[1]);
        }
        // 右轴：下限恒 1，上限 = max(制冷上限, 窗口内实际制冷峰值)，再夹进映射起始强度与峰值
        ChartAxis rAxis = null;
        if (!right.isEmpty()) {
            float peak = ChartSample.INVALID;
            for (ChartSample d : win.samples) {
                for (ChartSeries s : right) {
                    float v = ChartSeries.value(s, d);
                    if (ChartSample.valid(v) && (!ChartSample.valid(peak) || v > peak)) {
                        peak = v;
                    }
                }
            }
            // 实际制冷峰值按数据语义取 id=coolActual，不受交换开关与图例开关影响；
            // 窗口内无有效值时退回配置上限。上限至少覆盖实际制冷，避免末端点无故越界。
            float actualPeak = ChartSample.INVALID;
            for (ChartSeries s : series) {
                if (!"coolActual".equals(s.id)) {
                    continue;
                }
                for (ChartSample d : win.samples) {
                    float v = ChartSeries.value(s, d);
                    if (ChartSample.valid(v) && (!ChartSample.valid(actualPeak) || v > actualPeak)) {
                        actualPeak = v;
                    }
                }
                break;
            }
            float cLow = config != null ? config.coldMapStart : 40;
            float configuredHigh = config != null ? config.coldMax : 190;
            float cHigh = ChartSample.valid(actualPeak)
                    ? Math.max(configuredHigh, actualPeak) : configuredHigh;
            float top = ChartSample.valid(peak) ? Math.max(cLow, Math.min(cHigh, peak)) : cHigh;
            rAxis = ChartAxis.range(1f, top);
        }
        if (lAxis == null && rAxis == null) {
            clearTouch();
            return;   // 双轴都不可画：只留底色
        }

        if (lAxis != null) {
            buildGrid(lAxis, rAxis);
        } else {
            // 左轴不可画（左轴系列全关或窗口内无有效值）但右轴可画：仍要建一套横线，
            // 否则 gridY 为 null，onDraw 会连右轴曲线/圆点一起跳过（见 app/逻辑说明.md §7.3）。
            buildRightOnlyGrid(rAxis);
        }
        // 左右内边距要等刻度文字算好才能量（buildGrid 只依赖上下内边距，与它无关）
        applyAxisPads(w);
        if (fW <= 8f * density) {
            gridY = null;   // 窄到画不了：连网格一起撤掉，别只留一堆横线
            clearTouch();
            return;
        }
        buildPaths(win, lAxis, rAxis);
        buildPidPath(win, lAxis);
        buildPidSingles(win, lAxis);
        buildRecomputeMarks(win);
        buildMarkers(win, lAxis, rAxis);
        // 数据每秒刷新会重算几何：手指还按着就按新窗口重定位一次（文本仅在下标/时间戳变化时重算）
        if (touchActive) {
            updateTouch(touchRawX);
        }
    }

    /**
     * pid 曲线：只有重算样本才有值。相邻两次重算的间隔 ≤{@link #PID_CHAIN_MAX_SEC}（连续两个控制周期
     * 都重算）才连线；相隔更远的两次重算不连成假线。单点由 {@link #buildPidSingles} 画成圆点。
     */
    private void buildPidPath(ChartWindow win, ChartAxis lAxis) {
        if (lAxis == null) {
            return;
        }
        int si = pidSeriesIndex();
        if (si < 0 || !series[si].on) {
            return;
        }
        Path p = new Path();
        boolean any = false;
        int prev = -1;
        float prevX = 0f;
        float prevY = 0f;
        for (int i = 0; i < win.samples.length; i++) {
            ChartSample d = win.samples[i];
            float v = ChartSeries.value(series[si], d);
            if (!ChartSample.valid(v)) {
                continue;
            }
            float x = fPadL + fW * win.u[i];
            float y = lAxis.y(v, fPadT, fH);
            if (prev >= 0 && !win.broken[i] && isPidNeighbor(win.samples[prev], d)) {
                p.moveTo(prevX, prevY);
                p.lineTo(x, y);
                any = true;
            }
            prev = i;
            prevX = x;
            prevY = y;
        }
        if (any) {
            paths[si] = p;
        }
    }

    /**
     * pid 曲线的孤立样本：前后都没有「相邻重算点」（时间差 ≤{@link #PID_CHAIN_MAX_SEC}、无断联）
     * 时只画点、不连线。
     */
    private void buildPidSingles(ChartWindow win, ChartAxis lAxis) {
        if (lAxis == null) {
            return;
        }
        int si = pidSeriesIndex();
        if (si < 0 || !series[si].on) {
            return;
        }
        int n = win.samples.length;
        int[] idx = new int[n];
        int m = 0;
        for (int i = 0; i < n; i++) {
            if (ChartSample.valid(ChartSeries.value(series[si], win.samples[i]))) {
                idx[m++] = i;
            }
        }
        float[] xs = new float[m];
        float[] ys = new float[m];
        int count = 0;
        for (int j = 0; j < m; j++) {
            int i = idx[j];
            boolean hasPrev = j > 0 && !win.broken[i]
                    && isPidNeighbor(win.samples[idx[j - 1]], win.samples[i]);
            boolean hasNext = j + 1 < m && !win.broken[idx[j + 1]]
                    && isPidNeighbor(win.samples[i], win.samples[idx[j + 1]]);
            if (hasPrev || hasNext) {
                continue;
            }
            xs[count] = fPadL + fW * win.u[i];
            ys[count] = lAxis.y(ChartSeries.value(series[si], win.samples[i]), fPadT, fH);
            count++;
        }
        if (count == 0) {
            return;
        }
        pidDotX = new float[count];
        pidDotY = new float[count];
        System.arraycopy(xs, 0, pidDotX, 0, count);
        System.arraycopy(ys, 0, pidDotY, 0, count);
        pidDotColor = seriesColors[si];
        pidDotCount = count;
    }

    /** 相邻两次重算样本是否算「连续」：时间差在控制周期内。 */
    private static boolean isPidNeighbor(ChartSample a, ChartSample b) {
        long dt = b.t - a.t;
        return dt >= 0 && dt <= (long) PID_CHAIN_MAX_SEC;
    }

    private int pidSeriesIndex() {
        for (int k = 0; k < series.length; k++) {
            if ("pid".equals(series[k].id)) {
                return k;
            }
        }
        return -1;
    }

    /**
     * PID 重算标记（{@code UI_CHART_VIEW} 第 2 槽）：每个重算位置画一条竖虚线，与网格同宽同色（含透明度）。
     * 重算位置与系列开关无关——它是「控制层在这一秒算过一次」的事实。
     */
    private void buildRecomputeMarks(ChartWindow win) {
        if (config == null || !config.markDash) {
            return;
        }
        int n = win.samples.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (win.samples[i].recomp) {
                count++;
            }
        }
        if (count == 0) {
            return;
        }
        float[] xs = new float[count];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (win.samples[i].recomp) {
                xs[k++] = snapDashX(fPadL + fW * win.u[i]);
            }
        }
        Arrays.sort(xs);
        // 相邻重算点的 x 相差不到一笔宽时两条线会叠成一条宽线：按 x 升序去重，保留先出现（左侧）的那条
        int m = 0;
        float minGap = 1f * density;
        for (int i = 0; i < xs.length; i++) {
            if (m > 0 && xs[i] - xs[m - 1] < minGap) {
                continue;
            }
            xs[m++] = xs[i];
        }
        dashXs = Arrays.copyOf(xs, m);
    }

    /**
     * 把竖线的 x 吸附到笔宽栅格（像素）：笔宽落在半像素列时，抗锯齿会把 1dp 线摊到 4 列像素上，
     * 视觉上明显变宽变糊；对齐后每条线渲染宽度一致。
     */
    private float snapDashX(float xPx) {
        float swPx = GRID_WIDTH_DP * density;
        return Math.round(xPx - swPx / 2f) + swPx / 2f;
    }

    /**
     * 定左右内边距与两个轴标题的绘制位置：<b>两侧只留刻度数字的宽度</b>，标题收进"数字块"里、
     * 不挤压曲线空间（口径见 app/逻辑说明.md §7.3）。
     *
     * <p>量的都是绘制用字号（{@value #TICK_TEXT_DP}sp），故这里对两支画笔先设一次字号，
     * 免得量到 onDraw 上一帧留下的字号（占位文字用的是 {@value #EMPTY_TEXT_DP}sp）。
     */
    private void applyAxisPads(int w) {
        float gap = TICK_GAP_DP * density;
        tickPaint.setTextSize(TICK_TEXT_DP * density);
        axisTextPaint.setTextSize(TICK_TEXT_DP * density);
        float leftMax = 0f;
        if (gridText != null) {
            for (String text : gridText) {
                leftMax = Math.max(leftMax, tickPaint.measureText(text));
            }
        }
        float rightMax = 0f;
        if (rightText != null) {
            for (String text : rightText) {
                rightMax = Math.max(rightMax, axisTextPaint.measureText(text));
            }
        }
        fPadL = leftMax + gap;
        fPadR = rightMax > 0f ? rightMax + gap : gap;
        fW = w - fPadL - fPadR;
        titleLeftX = fPadL - gap - leftMax;
        titleRightX = fPadL + fW + gap + rightMax;
    }

    /** 轴数据范围（未 padding）。{@code axisOnly} 决定是否叠加转速下限门槛。 */
    private static float[] extent(List<ChartSeries> list, ChartWindow win, int rpmMin,
                                  boolean axisOnly) {
        float mn = Float.POSITIVE_INFINITY;
        float mx = Float.NEGATIVE_INFINITY;
        for (ChartSeries s : list) {
            for (ChartSample d : win.samples) {
                float v = axisOnly ? ChartSeries.axisValue(s, d, rpmMin) : ChartSeries.value(s, d);
                if (!ChartSample.valid(v)) {
                    continue;
                }
                if (v < mn) {
                    mn = v;
                }
                if (v > mx) {
                    mx = v;
                }
            }
        }
        if (mn == Float.POSITIVE_INFINITY || mx == Float.NEGATIVE_INFINITY) {
            return null;
        }
        return new float[]{mn, mx};
    }

    /** 整图唯一一套横线（位置由左轴刻度决定）；右轴只在同一高度标整数，不画线。 */
    private void buildGrid(ChartAxis lAxis, ChartAxis rAxis) {
        if (lAxis == null) {
            return;
        }
        float[] vals = ChartAxis.ticksOf(lAxis.min, lAxis.max, lAxis.step);
        gridY = new float[vals.length];
        gridText = new String[vals.length];
        for (int i = 0; i < vals.length; i++) {
            gridY[i] = lAxis.y(vals[i], fPadT, fH);
            gridText[i] = ChartAxis.fmtTick(vals[i], lAxis.step);
        }
        if (rAxis == null) {
            return;
        }
        float lSpan = lAxis.max - lAxis.min;
        float cSpan = rAxis.max - rAxis.min;
        rightText = new String[vals.length];
        for (int i = 0; i < vals.length; i++) {
            int n = Math.round(rAxis.min + cSpan * (vals[i] - lAxis.min) / lSpan);
            if (n < rAxis.min) {
                n = (int) Math.floor(rAxis.min);
            }
            if (n > rAxis.max) {
                n = (int) Math.floor(rAxis.max);
            }
            rightText[i] = String.valueOf(n);
        }
    }

    /**
     * 只有右轴可画时的横线。<b>判据 = {@code lAxis == null}</b>：既覆盖「所有左轴系列都被关掉」，
     * 也覆盖「左轴系列仍开着、但窗口内没有任何有效左轴值」（两者都定不出左轴）；
     * 右轴系列有任一开启时 {@code rAxis} 必然非 null（无有效制冷数据也会退到配置上限），故本分支必可画。
     *
     * <p>网格与 Y 轴刻度<b>改按右轴（制冷档位）的量纲定</b>：把右轴值域
     * [{@link ChartAxis#min}, {@link ChartAxis#max}] 等分 {@link #RIGHT_ONLY_GRID_SEGMENTS} 段，
     * 右标签取该高度的制冷值四舍五入（值域过窄时相邻重复标签只显示第一条）；左轴无刻度、左轴标题不画。
     * 左轴存在时仍走 {@link #buildGrid}，本方法不参与。
     */
    private void buildRightOnlyGrid(ChartAxis rAxis) {
        int lines = RIGHT_ONLY_GRID_SEGMENTS + 1;
        gridY = new float[lines];
        gridText = new String[lines];
        rightText = new String[lines];
        float span = rAxis.max - rAxis.min;
        String lastLabel = null;
        for (int i = 0; i < lines; i++) {
            float frac = 1f - i / (float) RIGHT_ONLY_GRID_SEGMENTS;   // 顶 → 底
            float v = rAxis.min + span * frac;
            gridY[i] = rAxis.y(v, fPadT, fH);
            gridText[i] = "";   // 左轴无刻度：保留空串占位，onDraw 照常调用（空串不显示）
            String label = String.valueOf(Math.round(v));
            if (label.equals(lastLabel)) {
                rightText[i] = "";   // 窄值域四舍五入会重复：只留首条，避免叠字
            } else {
                rightText[i] = label;
                lastLabel = label;
            }
        }
        titleLeft = null;   // 无左轴：不画左轴标题
    }

    /** 每条开启系列一条 Path；断联处 moveTo 断开、不连桥（口径见 app/逻辑说明.md §7.2〈断联空白〉）。 */
    private void buildPaths(ChartWindow win, ChartAxis lAxis, ChartAxis rAxis) {
        paths = new Path[series.length];
        for (int si = 0; si < series.length; si++) {
            ChartSeries s = series[si];
            if (!s.on) {
                continue;
            }
            if ("pid".equals(s.id)) {
                continue;   // 稀疏样本单独连线，见 buildPidPath
            }
            ChartAxis ax = s.axis == ChartSeries.AXIS_LEFT ? lAxis : rAxis;
            if (ax == null) {
                continue;
            }
            Path p = new Path();
            boolean started = false;
            for (int i = 0; i < win.samples.length; i++) {
                if (i > 0 && win.broken[i]) {
                    started = false;
                }
                float v = ChartSeries.value(s, win.samples[i]);
                if (!ChartSample.valid(v)) {
                    continue;
                }
                float x = fPadL + fW * win.u[i];
                float y = ax.y(v, fPadT, fH);
                if (started) {
                    p.lineTo(x, y);
                } else {
                    p.moveTo(x, y);
                    started = true;
                }
            }
            if (started) {
                paths[si] = p;
            }
        }
    }

    /**
     * 末端标记：每条开启系列取最后一个有效样本；圆点按 {@link ChartSeries#drawsEndDot} 决定是否画，
     * 数值标签按 {@link ChartSeries#drawsEndLabel} 决定是否生成（只剩成对系列的强调方，最多两条；
     * 位置见 {@link #placeEndpointLabel}）。按住查看面板里的数值由 {@link #buildTouchRows} 单独生成。
     */
    private void buildMarkers(ChartWindow win, ChartAxis lAxis, ChartAxis rAxis) {
        List<ChartDotOp> dotOps = new ArrayList<>();
        List<ChartLabelOp> labelOps = new ArrayList<>();
        for (int si = 0; si < series.length; si++) {
            ChartSeries s = series[si];
            if (!s.on) {
                continue;
            }
            if ("pid".equals(s.id)) {
                continue;   // pid 稀疏曲线由 buildPidSingles 单独画点
            }
            boolean wantDot = ChartSeries.drawsEndDot(s, config);
            boolean wantLabel = ChartSeries.drawsEndLabel(s, config);
            if (!wantDot && !wantLabel) {
                continue;   // 参考方（半透明那条）既不画圆点也不标数值
            }
            ChartAxis ax = s.axis == ChartSeries.AXIS_LEFT ? lAxis : rAxis;
            if (ax == null) {
                continue;
            }
            int last = -1;
            float lv = ChartSample.INVALID;
            for (int i = win.samples.length - 1; i >= 0; i--) {
                float v = ChartSeries.value(s, win.samples[i]);
                if (ChartSample.valid(v)) {
                    last = i;
                    lv = v;
                    break;
                }
            }
            if (last < 0) {
                continue;
            }
            float ex = fPadL + fW * win.u[last];
            float ey = ax.y(lv, fPadT, fH);
            // 风扇转速低于纵轴下限时，圆点落到画布下沿：下半被画布裁掉、只露上半边，
            // 直观表示"已在轴下限之外"。其余系列钳在作图区下沿。
            boolean overflow = false;
            if (ey > fPadT + fH) {
                if (ChartSeries.isRpm(s)) {
                    ey = getHeight();
                    overflow = true;   // 只露半个的越界点，绘制时放到最后
                } else {
                    ey = fPadT + fH;
                }
            }
            if (ey < fPadT) {
                ey = fPadT;   // 制冷等其余系列一律钳在绘图区上沿
            }
            if (wantDot) {
                dotOps.add(new ChartDotOp(ex, ey, seriesColors[si], overflow));
            }
            if (wantLabel) {
                labelOps.add(placeEndpointLabel(s, lv, ex, ey, seriesColors[si], labelOps));
            }
        }
        dots = dotOps.isEmpty() ? null : dotOps.toArray(new ChartDotOp[0]);
        endLabels = labelOps.isEmpty() ? null : labelOps.toArray(new ChartLabelOp[0]);
    }

    /**
     * 单个末端数值标签的落位（沿用原多系列标注的单锚点口径）：
     * 横向放锚点右侧 {@link #LABEL_GAP_DP}，右越界翻到左侧，左界钳到 2dp；
     * 纵向比较锚点上下空隙，优先选放得下且空隙更大的一侧，两侧都放不下时取空隙更大的一侧，
     * 再钳在绘图区上沿与「画布下沿 − descent」之间。最多两条标签（实际制冷 / 实际rpm）同高时，
     * 后放的一条上下错开一行，避免两条数字叠在一起。
     */
    private ChartLabelOp placeEndpointLabel(ChartSeries s, float v, float ex, float ey, int color,
                                            List<ChartLabelOp> placed) {
        String text = ChartSeries.format(s, v);
        float textW = tickPaint.measureText(text);
        Paint.FontMetrics fm = tickPaint.getFontMetrics();
        float labelH = LABEL_H_DP * density;
        float needAbove = LABEL_LIFT_DP * density - fm.ascent;
        float needBelow = labelH + 1f * density + fm.descent;
        float labelMaxY = Math.min(fPadT + fH + labelH, getHeight() - fm.descent);
        float gapAbove = ey - fPadT;
        float gapBelow = (fPadT + fH) - ey;
        boolean fitsAbove = gapAbove >= needAbove;
        boolean fitsBelow = gapBelow >= needBelow;
        boolean placeAbove = fitsAbove == fitsBelow ? gapAbove >= gapBelow : fitsAbove;
        float ly = placeAbove ? ey - LABEL_LIFT_DP * density
                              : ey + LABEL_H_DP * density + 1f * density;
        if (ly < fPadT) {
            ly = fPadT;
        }
        if (ly > labelMaxY) {
            ly = labelMaxY;
        }
        float tx = ex + LABEL_GAP_DP * density;
        if (tx + textW > fPadL + fW) {
            tx = ex - LABEL_GAP_DP * density - textW;
        }
        if (tx < 2f * density) {
            tx = 2f * density;
        }
        float rowStep = LABEL_H_DP * density + 1f * density;
        if (overlapsLabel(placed, tx, textW, ly)) {
            float down = ly + rowStep;
            float up = ly - rowStep;
            if (down <= labelMaxY && !overlapsLabel(placed, tx, textW, down)) {
                ly = down;
            } else if (up >= fPadT && !overlapsLabel(placed, tx, textW, up)) {
                ly = up;
            } else {
                ly = Math.max(fPadT, Math.min(labelMaxY, down));
            }
        }
        return new ChartLabelOp(text, tx, ly, textW, color);
    }

    /** 新标签与已放标签是否在横纵两个方向都相交（纵向按一行字高判定）。 */
    private boolean overlapsLabel(List<ChartLabelOp> placed, float tx, float textW, float ly) {
        float lineH = LABEL_H_DP * density;
        for (ChartLabelOp p : placed) {
            boolean xHit = tx < p.x + p.w && p.x < tx + textW;
            boolean yHit = Math.abs(p.y - ly) < lineH;
            if (xHit && yHit) {
                return true;
            }
        }
        return false;
    }

    // ==================== 按住查看 ====================

    /**
     * 图内按下即生效（无需长按）：在手指 x 处画高亮竖虚线并显示各已启用系列在该时刻的数值；
     * 移动跟随，抬手 / 取消立即消失。落在绘图区外不消费。文本只在最近样本变化时重算，
     * 几何量全部在触摸回调里定稿，onDraw 仍只画。
     */
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (!canInspect() || !inPlot(e.getX(), e.getY())) {
                    return false;
                }
                // 触摸期间别让父容器（页面纵向滚动 / ViewPager2 翻页）抢走手势
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                updateTouch(e.getX());
                invalidate();
                return touchActive;
            case MotionEvent.ACTION_MOVE:
                if (!touchActive) {
                    return false;
                }
                updateTouch(e.getX());
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (!touchActive) {
                    return false;
                }
                clearTouch();
                invalidate();
                return true;
            default:
                return touchActive;
        }
    }

    /** 数据为空 / 占位态 / 尚无绘图区时不响应。 */
    private boolean canInspect() {
        return placeholder == null && gridY != null && window != null
                && window.samples.length > 0 && fW > 0f;
    }

    private boolean inPlot(float x, float y) {
        return x >= fPadL && x <= fPadL + fW && y >= fPadT && y <= fPadT + fH;
    }

    /** 按手指 x 更新高亮线与数值面板；最近样本未变（下标与时间戳都相同）时不重排文本。 */
    private void updateTouch(float x) {
        if (!canInspect()) {
            clearTouch();
            return;
        }
        float cx = Math.max(fPadL, Math.min(fPadL + fW, x));
        touchRawX = cx;
        touchDashX = snapDashX(cx);
        int idx = nearestSampleIndex(cx);
        if (idx < 0) {
            clearTouch();
            return;
        }
        touchActive = true;
        long t = window.samples[idx].t;
        if (idx != touchSample || t != touchSampleT) {
            touchSample = idx;
            touchSampleT = t;
            buildTouchRows(idx);
        }
        placeTouchPanel();
    }

    /** 窗口内离给定 x 最近的样本（不插值）。u 单调不减，二分查找。 */
    private int nearestSampleIndex(float xPx) {
        ChartWindow win = window;
        if (win == null || win.samples.length == 0 || fW <= 0f) {
            return -1;
        }
        float u = (xPx - fPadL) / fW;
        int lo = 0;
        int hi = win.u.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (win.u[mid] < u) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (lo > 0) {
            float dPrev = Math.abs(win.u[lo - 1] - u);
            float dCur = Math.abs(win.u[lo] - u);
            if (dPrev <= dCur) {
                lo--;
            }
        }
        return lo;
    }

    /**
     * 该样本上「已启用」的系列 → 行文本 / 颜色 / 面板尺寸。行顺序与图例一致（交换开关同样换位）；
     * pid 与成对系列的强调方无值也保留行；图例第二行起点前留 rowH/3 空白作两段分割。
     * 只在触摸回调里调用。
     */
    private void buildTouchRows(int idx) {
        tickPaint.setTextSize(TICK_TEXT_DP * density);
        ChartSample d = window.samples[idx];
        String[] texts = new String[series.length];
        int[] colors = new int[series.length];
        float maxW = 0f;
        int n = 0;
        int[] order = ChartSeries.displayOrder(series, config);
        // 图例第二行起点（pid）在显示顺序中的位置。即使该系列被关闭，分割也按这个阈值位置插入，
        // 不因行被过滤而丢失。
        int legendBreak = -1;
        for (int oi = 0; oi < order.length; oi++) {
            if (ChartSeries.startsLegendRow(series[order[oi]])) {
                legendBreak = oi;
                break;
            }
        }
        int dividerBefore = -1;
        for (int oi = 0; oi < order.length; oi++) {
            int si = order[oi];
            ChartSeries s = series[si];
            if (!s.on) {
                continue;
            }
            // pid 稀疏（只有重算行有值）：取按住点左侧最近的有效值。pid 与成对系列的强调方
            // 无论有无值都保留行，避免按住滑动时该行忽隐忽现；无值显示「-」。
            float v = "pid".equals(s.id) ? pidTouchValue(idx) : ChartSeries.value(s, d);
            if (!ChartSeries.keepsTouchRow(s, config) && !ChartSample.valid(v)) {
                continue;
            }
            if (legendBreak >= 0 && oi >= legendBreak && dividerBefore < 0) {
                dividerBefore = n;   // 这一行起往下整体让出 rowH/3 的分段空白
            }
            String text = getContext().getString(s.labelRes) + " "
                    + (ChartSample.valid(v) ? ChartSeries.format(s, v) : "-");
            texts[n] = text;
            colors[n] = seriesColors[si];
            maxW = Math.max(maxW, tickPaint.measureText(text));
            n++;
        }
        touchTexts = texts;
        touchColors = colors;
        touchRowCount = n;
        if (n == 0) {
            return;
        }
        Paint.FontMetrics fm = tickPaint.getFontMetrics();
        float rowH = LABEL_H_DP * density;
        float padY = TOUCH_PANEL_PAD_Y_DP * density;
        float dividerH = rowH / 3f;
        float dividerTotal = dividerBefore >= 0 ? dividerH : 0f;
        touchPanelW = maxW + 2f * TOUCH_PANEL_PAD_X_DP * density;
        touchPanelT = fPadT + TOUCH_PANEL_TOP_DP * density;
        touchPanelB = touchPanelT + 2f * padY + rowH * n + dividerTotal;
        if (touchTextY == null || touchTextY.length < n) {
            touchTextY = new float[n];
        }
        for (int i = 0; i < n; i++) {
            float y = touchPanelT + padY + i * rowH - fm.ascent;
            if (dividerBefore >= 0 && i >= dividerBefore) {
                y += dividerH;
            }
            touchTextY[i] = y;
        }
    }

    /**
     * 按住查看的 pid 取值：从 {@code idx} 起向左找第一个有效 pid 样本（含当前样本）。
     * 左侧一个都没有时返回 {@link ChartSample#INVALID}，由调用方显示「-」。
     */
    private float pidTouchValue(int idx) {
        ChartSample[] samples = window.samples;
        int si = pidSeriesIndex();
        if (si < 0) {
            return ChartSample.INVALID;
        }
        ChartSeries pid = series[si];
        for (int i = idx; i >= 0; i--) {
            float v = ChartSeries.value(pid, samples[i]);
            if (ChartSample.valid(v)) {
                return v;
            }
        }
        return ChartSample.INVALID;
    }

    /**
     * 面板默认贴高亮虚线右侧 6dp，右越界翻到左侧，再横向钳进绘图区。
     *
     * <p>首帧出现与同侧跟随手指都直接落位；只有**换边**走约 140ms 的过渡（见
     * {@link #startPanelSideAnim}）。动画进行中仍在同一侧时只更新目标，终点每帧跟随手指；
     * 快速来回越界则从当前绘制位置重新起步，不抖不跳。
     */
    private void placeTouchPanel() {
        if (touchRowCount == 0) {
            return;
        }
        final float gap = TOUCH_PANEL_GAP_DP * density;
        final float right = touchDashX + gap;
        final boolean onRight = right + touchPanelW <= fPadL + fW;
        final float targetL = clampPanelL(onRight ? right : touchDashX - gap - touchPanelW);

        if (!panelPlaced) {
            panelPlaced = true;   // 首帧出现：直接落位
            panelOnRight = onRight;
            applyPanelL(targetL);
            return;
        }
        if (onRight != panelOnRight) {
            // 换边（含动画中快速来回越界）：从当前绘制位置重新起步
            panelOnRight = onRight;
            startPanelSideAnim(targetL);
            return;
        }
        if (panelSideAnim != null) {
            panelSideToL = targetL;   // 动画中同侧：终点跟随最新目标，不重启
            return;
        }
        applyPanelL(targetL);   // 同侧跟随手指：即时
    }

    /** 把面板左沿钳进绘图区：面板比绘图区还宽时贴左界，宁可右溢也不越出左界。 */
    private float clampPanelL(float l) {
        final float maxL = fPadL + fW - touchPanelW;
        if (l > maxL) {
            l = maxL;
        }
        if (l < fPadL) {
            l = fPadL;
        }
        return l;
    }

    /** 把面板落位到左沿 {@code l}：右沿与文字 x 由此派生，onDraw 只读这几个字段。 */
    private void applyPanelL(float l) {
        touchPanelL = l;
        touchPanelR = l + touchPanelW;
        touchTextX = l + TOUCH_PANEL_PAD_X_DP * density;
    }

    /**
     * 换边过渡：进度 0→1 的 140ms ease-out，起点固定为换边那一刻的绘制位置，
     * 终点每帧取 {@link #panelSideToL}（同侧移动时会被更新）。被打断时由下一次换边
     * 从当前绘制位置重新起算。
     */
    private void startPanelSideAnim(float targetL) {
        cancelPanelSideAnim();
        panelSideFromL = touchPanelL;
        panelSideToL = targetL;
        if (!Motion.enabled(getContext())) {
            applyPanelL(targetL);
            return;
        }
        final ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(TOUCH_PANEL_SIDE_MS);
        anim.setInterpolator(Motion.easeOut());
        anim.addUpdateListener(a -> {
            final float p = (float) a.getAnimatedValue();
            applyPanelL(panelSideFromL + (panelSideToL - panelSideFromL) * p);
            invalidate();
        });
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (panelSideAnim != anim) {
                    return;   // 已被新的换边动画接管，不作收尾
                }
                panelSideAnim = null;
                applyPanelL(panelSideToL);
                invalidate();
            }
        });
        panelSideAnim = anim;
        anim.start();
    }

    /** 中止换边过渡；旧动画的收尾因对不上号而空跑。 */
    private void cancelPanelSideAnim() {
        final ValueAnimator running = panelSideAnim;
        panelSideAnim = null;
        if (running != null) {
            running.cancel();
        }
    }

    /** 结束按住查看：取消换边过渡、清状态并复位父容器的拦截开关。面板消失仍即时。 */
    private void clearTouch() {
        cancelPanelSideAnim();
        panelPlaced = false;
        touchActive = false;
        touchSample = -1;
        touchRowCount = 0;
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        cancelPanelSideAnim();
        panelPlaced = false;
        super.onDetachedFromWindow();
    }

    // ==================== 绘制（无计算、无分配） ====================

    @Override
    protected void onDraw(Canvas canvas) {
        // 不自铺底色：底色由卡片给（画布透明），否则卡内会多出一块直角色块
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        if (placeholder != null) {
            tickPaint.setTextAlign(Paint.Align.CENTER);
            tickPaint.setColor(colorAxis);
            tickPaint.setTextSize(EMPTY_TEXT_DP * density);
            canvas.drawText(placeholder, w / 2f, h / 2f, tickPaint);
            return;
        }
        if (gridY == null) {
            return;
        }

        gridPaint.setColor(colorGrid);
        tickPaint.setColor(colorAxis);
        tickPaint.setTextSize(TICK_TEXT_DP * density);
        tickPaint.setTextAlign(Paint.Align.RIGHT);
        axisTextPaint.setColor(colorAxis);
        axisTextPaint.setTextSize(TICK_TEXT_DP * density);
        for (int i = 0; i < gridY.length; i++) {
            canvas.drawLine(fPadL, gridY[i], fPadL + fW, gridY[i], gridPaint);
            canvas.drawText(gridText[i], fPadL - TICK_GAP_DP * density, gridY[i] + 3f * density, tickPaint);
        }
        if (rightText != null) {
            float rightX = fPadL + fW + TICK_GAP_DP * density;
            for (int i = 0; i < rightText.length; i++) {
                canvas.drawText(rightText[i], rightX, gridY[i] + 3f * density, axisTextPaint);
            }
            // 右轴标题右沿与右侧刻度数字的右沿平齐（数字是左对齐的，右沿要按数字宽算）
            axisTextPaint.setTextAlign(Paint.Align.RIGHT);
            canvas.drawText(titleRight, titleRightX, fPadT - 7f * density, axisTextPaint);
            axisTextPaint.setTextAlign(Paint.Align.LEFT);
        }
        // 左轴标题左沿与左侧刻度数字的左沿平齐（数字是右对齐的，左沿按最宽那条算）
        // 无左轴时 titleLeft 为 null（buildRightOnlyGrid），此时不画
        if (titleLeft != null) {
            canvas.drawText(titleLeft, titleLeftX, fPadT - 7f * density, axisTextPaint);
        }

        // 重算位置竖虚线：压在网格之上、曲线之下（与网格同宽同色，含透明度）
        if (dashXs != null && dashXs.length > 0) {
            dashPaint.setColor(colorGrid);
            for (float x : dashXs) {
                canvas.drawLine(x, fPadT, x, fPadT + fH, dashPaint);
            }
        }

        // 折线先左轴、后右轴（后画者压先画者）
        if (paths != null) {
            for (int pass = 0; pass < 2; pass++) {
                int wantAxis = pass == 0 ? ChartSeries.AXIS_LEFT : ChartSeries.AXIS_RIGHT;
                for (int si = 0; si < paths.length; si++) {
                    if (paths[si] == null || series[si].axis != wantAxis) {
                        continue;
                    }
                    seriesPaint.setColor(seriesColors[si]);
                    canvas.drawPath(paths[si], seriesPaint);
                }
            }
        }

        // pid 曲线的孤立样本点：半径 = 线宽 ×1.3 的普通实心圆
        if (pidDotCount > 0) {
            dotPaint.setColor(pidDotColor);
            float pr = PID_DOT_RADIUS_DP * density;
            for (int i = 0; i < pidDotCount; i++) {
                canvas.drawCircle(pidDotX[i], pidDotY[i], pr, dotPaint);
            }
        }

        // 按住查看：高亮虚线压在曲线之上；数值面板垫底色块
        if (touchActive) {
            highlightPaint.setColor(colorHighlight);
            canvas.drawLine(touchDashX, fPadT, touchDashX, fPadT + fH, highlightPaint);
            if (touchRowCount > 0) {
                panelPaint.setColor(colorPanel);
                float radius = TOUCH_PANEL_RADIUS_DP * density;
                canvas.drawRoundRect(touchPanelL, touchPanelT, touchPanelR, touchPanelB,
                        radius, radius, panelPaint);
                labelPaint.setTextSize(TICK_TEXT_DP * density);
                for (int i = 0; i < touchRowCount; i++) {
                    labelPaint.setColor(touchColors[i]);
                    canvas.drawText(touchTexts[i], touchTextX, touchTextY[i], labelPaint);
                }
            }
        }

        // 末端数值标签（成对系列的强调方，最多两条）：先描边（halo）再填色，避免曲线穿过字形时同色糊在一起
        if (endLabels != null) {
            haloPaint.setColor(colorBg);
            labelPaint.setTextSize(TICK_TEXT_DP * density);
            haloPaint.setTextSize(TICK_TEXT_DP * density);
            for (ChartLabelOp e : endLabels) {
                labelPaint.setColor(e.color);
                canvas.drawText(e.text, e.x, e.y, haloPaint);
                canvas.drawText(e.text, e.x, e.y, labelPaint);
            }
        }

        if (dots != null) {
            dotHaloPaint.setColor(colorBg);
            float r = DOT_RADIUS_DP * density;
            for (ChartDotOp e : dots) {
                if (!e.overflow) {
                    drawEndpointDot(canvas, e, r);
                }
            }
            // 越界点半露在绘图区外，最后画，保证不被普通端点（含 pid 点、另一条末端点）盖住
            for (ChartDotOp e : dots) {
                if (e.overflow) {
                    drawEndpointDot(canvas, e, r);
                }
            }
        }
    }

    /** 画一个末端圆点：先实心填充再描背景色 halo（口径与改动前一致）。 */
    private void drawEndpointDot(Canvas canvas, ChartDotOp e, float r) {
        dotPaint.setColor(e.color);
        canvas.drawCircle(e.x, e.y, r, dotPaint);
        canvas.drawCircle(e.x, e.y, r, dotHaloPaint);
    }

    /** 一条末端数值标签（位置/颜色在 rebuild 定死，onDraw 只画）。 */
    private static final class ChartLabelOp {
        final String text;
        final float x;
        final float y;
        final float w;
        final int color;

        ChartLabelOp(String text, float x, float y, float w, int color) {
            this.text = text;
            this.x = x;
            this.y = y;
            this.w = w;
            this.color = color;
        }
    }

    private static final class ChartDotOp {
        final float x;
        final float y;
        final int color;
        /** true = 越界只露半个（rpm 低于下限），绘制时放到最后。 */
        final boolean overflow;

        ChartDotOp(float x, float y, int color, boolean overflow) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.overflow = overflow;
        }
    }
}
