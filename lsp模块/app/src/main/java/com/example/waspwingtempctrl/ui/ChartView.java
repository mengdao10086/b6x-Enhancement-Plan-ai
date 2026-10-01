package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 曲线自绘控件。口径逐条对齐 {@code app/逻辑说明.md} §7。
 *
 * <p><b>性能硬约束</b>：{@code onDraw} 只画，全部几何量（轴与刻度、每系列 {@link Path}、标注位置与文本宽度、
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
    private static final float TICK_TEXT_DP = 10f;   // 刻度 / 标注 / 轴标题字号
    private static final float EMPTY_TEXT_DP = 12f;  // 「采样中…」字号
    private static final float SEAM_EXTRA_DP = 4f;   // 转速圆点允许下越界的量
    private static final float SEAM_BOTTOM_DP = 5f;  // 接缝离画布下沿的下限：圆点（半径 3.2 + 外圈 0.5）不许被裁
    private static final float LABEL_GAP_DP = 6f;    // 标签与端点的水平间距
    // 标签落在簇上方时相对簇顶端的抬升量（原 WebUI 同名口径：top − 4）；落下方的间距见 LABEL_H_DP + 1dp
    private static final float LABEL_LIFT_DP = 4f;
    // 标注行高：取 webui 同名常量 LABEL_H，不用实测 descent − ascent（见 app/逻辑说明.md §7.4）
    private static final float LABEL_H_DP = 11f;
    // 近同锚点判据：两条曲线末端相距不到该值就直接并成一组——它们视觉上本就是一个点。
    // 取 8dp（略大于圆点直径 6.4dp），宁可多并一点；见 app/逻辑说明.md §7.4。
    private static final float NEAR_DUP_DP = 8f;

    private final Paint gridPaint = new Paint();
    private final Paint tickPaint = new Paint();     // 左轴刻度（右对齐）
    private final Paint axisTextPaint = new Paint(); // 右轴刻度 / 轴标题（左对齐）
    private final Paint seriesPaint = new Paint();
    private final Paint haloPaint = new Paint();     // 文字 halo（STROKE）
    private final Paint labelPaint = new Paint();    // 文字填充（FILL）
    private final Paint dotPaint = new Paint();      // 圆点填充
    private final Paint dotHaloPaint = new Paint();  // 圆点外圈（STROKE）

    private final ChartSeries[] series = ChartSeries.createAll();

    private float density;
    /** 画布视觉底色（= 卡片底色）。本类不铺底色（避免与卡片形成第二个色块），此色只用于文字 halo 与圆点外圈。 */
    private int colorBg;
    private int colorGrid;
    private int colorAxis;
    private int[] seriesColors = new int[series.length];
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
    private float fSeamY;
    /** 两个轴标题的绘制 x：左标题左沿 = 最左那条刻度数字的左沿，右标题右沿 = 最右那条的右沿。 */
    private float titleLeftX;
    private float titleRightX;
    private float[] gridY;
    private String[] gridText;
    private String[] rightText;
    private Path[] paths;
    private ChartLabelOp[] labels;
    private ChartDotOp[] dots;

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
        // 描边文字的字号必须与 labelPaint 一致：halo 是「同一串字先描边再填色」，
        // 字号不同就描出一个与字形不重合的底色轮廓（原先漏设，halo 按 Paint 的默认字号画）
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
    }

    // ==================== 外部接口 ====================

    /** 数据与口径参数（主线程调用）。 */
    public void setData(@Nullable ChartWindow win, @Nullable ChartConfig cfg) {
        this.window = win;
        this.config = cfg;
        rebuild();
        invalidate();
    }

    /** 图例开关（主线程调用）：切换后轴范围与标注同步重算。 */
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

    int seriesCount() {
        return series.length;
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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        refreshThemeColors();
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
        if (seriesColors.length != series.length) {
            seriesColors = new int[series.length];
        }
        for (int i = 0; i < series.length; i++) {
            seriesColors[i] = res.getColor(series[i].colorRes, theme);
        }
        haloPaint.setColor(colorBg);
        dotHaloPaint.setColor(colorBg);
        colorsReady = true;
    }

    // ==================== 预计算 ====================

    /**
     * 算出本次绘制的全部几何量：轴定标 → 网格 → 断联空白 → 每系列 Path → 头部标注。
     */
    private void rebuild() {
        placeholder = null;
        gridY = null;
        gridText = null;
        rightText = null;
        paths = null;
        labels = null;
        dots = null;

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
            return;
        }
        // 接缝（转速圆点允许下越界的下限）：以绘图区下沿外扩、再被画布下沿收住，圆点才不被裁（见 §7.3）
        fSeamY = Math.min(fPadT + fH + SEAM_EXTRA_DP * density, h - SEAM_BOTTOM_DP * density);

        titleLeft = getContext().getString(R.string.chart_axis_left);
        titleRight = getContext().getString(R.string.chart_axis_right);

        ChartWindow win = window;
        if (win == null || win.samples.length < 2) {
            placeholder = getContext().getString(R.string.chart_waiting);
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
        // 右轴：下限恒 1，上限 = 窗口内制冷峰值夹进 [映射起始强度, 制冷上限]
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
            float cLow = config != null ? config.coldMapStart : 40;
            float cHigh = config != null ? config.coldMax : 190;
            float top = ChartSample.valid(peak) ? Math.max(cLow, Math.min(cHigh, peak)) : cHigh;
            rAxis = ChartAxis.range(1f, top);
        }
        if (lAxis == null && rAxis == null) {
            return;   // 双轴都不可画：只留底色
        }

        buildGrid(lAxis, rAxis);
        // 左右内边距要等刻度文字算好才能量（buildGrid 只依赖上下内边距，与它无关）
        applyAxisPads(w);
        if (fW <= 8f * density) {
            gridY = null;   // 窄到画不了：连网格一起撤掉，别只留一堆横线
            return;
        }
        buildPaths(win, lAxis, rAxis);
        buildMarkers(win, lAxis, rAxis);
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
            if (!(lSpan > 0f) || !(cSpan > 0f)) {
                rightText[i] = "";
                continue;
            }
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

    /** 每条开启系列一条 Path；断联处 moveTo 断开、不连桥（口径见 app/逻辑说明.md §7.2〈断联空白〉）。 */
    private void buildPaths(ChartWindow win, ChartAxis lAxis, ChartAxis rAxis) {
        paths = new Path[series.length];
        for (int si = 0; si < series.length; si++) {
            ChartSeries s = series[si];
            if (!s.on) {
                continue;
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
     * 头部标注：每条系列取最后一个有效样本作锚点。合并用**顺序贪心**——锚点按 y 升序，沿序扫、只与
     * **当前组的第一条**比：两者的标注纵向占位盒相交（或两锚点距离不到 {@link #NEAR_DUP_DP}）就并进来，
     * 一旦不交即**封组、不回头**（不再并查集跑传递闭包、不再迭代到不动点）。
     *
     * <p><b>组盒与落点同源</b>：每个锚点先各自算一次理想落点（{@link #placeSingleAnchors}），合并组的
     * 标签就画在该组**第一条**的落点上——判据用的盒与画出来的盒是同一个，故相邻两组必不重叠、组内
     * 锚点跨度有硬上界（一个文字盒高 + 上/下落点相对锚点的极差 ≈ 27.7dp）。每条的理想落点只算一次，
     * 不存在「合并 → 落点外移 → 又压上邻居」的反馈回路。详见 app/逻辑说明.md §7.4。
     *
     * <p><b>选边</b>：比较「锚点到上方最近障碍物」与「下方最近障碍物到锚点」的空隙，空隙更大的一侧
     * 放标签；障碍物 = 同页其它曲线的端点圆点（即相邻锚点的圆点边缘）与绘图区上下沿，<b>不含曲线中段</b>。
     * 两侧都放不下时同样取空隙更大的一侧。
     */
    private void buildMarkers(ChartWindow win, ChartAxis lAxis, ChartAxis rAxis) {
        List<ChartLabelOp> entries = new ArrayList<>();
        for (int si = 0; si < series.length; si++) {
            ChartSeries s = series[si];
            if (!s.on) {
                continue;
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
            // 只有风扇转速系列允许下越界到接缝；其余（含右轴制冷）钳在作图区下沿
            float yMax = ChartSeries.isRpm(s) ? fSeamY : fPadT + fH;
            if (ey < fPadT) {
                ey = fPadT;
            }
            if (ey > yMax) {
                ey = yMax;
            }
            entries.add(new ChartLabelOp(ChartSeries.format(s, lv), ex, ey, seriesColors[si]));
        }
        if (entries.isEmpty()) {
            return;
        }

        for (ChartLabelOp e : entries) {
            e.w = tickPaint.measureText(e.text);
            e.tx = e.x + LABEL_GAP_DP * density;
            if (e.tx + e.w > fPadL + fW) {
                e.tx = e.x - LABEL_GAP_DP * density - e.w;
            }
            if (e.tx < 2f * density) {
                e.tx = 2f * density;
            }
        }
        Collections.sort(entries, (a, b) -> Float.compare(a.y, b.y));

        Paint.FontMetrics fm = tickPaint.getFontMetrics();
        // 落位公式里的行高取 webui 同名常量（11dp）；判据用的真实文字占位走实测 descent − ascent
        // （≈ 11.7dp，比常量多 0.7dp）。两者口径不同是有意的，见 app/逻辑说明.md §7.4。
        float labelH = LABEL_H_DP * density;
        // 标注基线允许的最低位置：绘图区下沿 + 一行高再被「画布下沿 − descent」收住，否则最低那条标注
        // 会越出画布被裁。PAD_B_DP 缩到 4 后第一项恒高于第二项，实际恒取 h − descent（口径不变）。
        // 上侧不用额外钳制：ly 下限是 fPadT（17dp），已大于 10dp 文字的 ascent(≈9.3dp)
        float labelMaxY = Math.min(fPadT + fH + labelH, getHeight() - fm.descent);
        // 标注要占的高度：上方 = 抬升量 + 文字 ascent（负值取反）；下方 = 一行高 + 1dp 间隙 + 文字 descent
        float dotR = (DOT_RADIUS_DP + DOT_HALO_DP) * density;
        float needAbove = LABEL_LIFT_DP * density - fm.ascent;
        float needBelow = labelH + 1f * density + fm.descent;

        // 每个锚点先各自算一次理想落点（只此一次、不再随合并重算 → 无反馈回路）
        int n = entries.size();
        float[] lyS = new float[n];
        placeSingleAnchors(entries, lyS, dotR, needAbove, needBelow, labelMaxY);

        // 顺序贪心封组：只与当前组首成员比——两锚点过近（视觉同一处）或标注盒相交即并入，否则封组、不回头
        float nearDup = NEAR_DUP_DP * density;
        List<List<ChartLabelOp>> groups = new ArrayList<>();
        List<Float> groupLy = new ArrayList<>();
        List<ChartLabelOp> cur = new ArrayList<>();
        int first = 0;
        for (int i = 0; i < n; i++) {
            if (cur.isEmpty()) {
                cur.add(entries.get(i));
                first = i;
                continue;
            }
            boolean join = entries.get(i).y - entries.get(first).y <= nearDup
                    || overlapsVertically(lyS[first], lyS[i], fm);
            if (join) {
                cur.add(entries.get(i));
            } else {
                groups.add(cur);
                groupLy.add(lyS[first]);
                cur = new ArrayList<>();
                cur.add(entries.get(i));
                first = i;
            }
        }
        if (!cur.isEmpty()) {
            groups.add(cur);
            groupLy.add(lyS[first]);
        }

        List<ChartLabelOp> textOps = new ArrayList<>();
        List<ChartDotOp> dotOps = new ArrayList<>();
        float sep = tickPaint.measureText(" / ");
        for (int ci = 0; ci < groups.size(); ci++) {
            List<ChartLabelOp> cl = groups.get(ci);
            float ly = groupLy.get(ci);
            if (cl.size() == 1) {
                ChartLabelOp e = cl.get(0);
                textOps.add(new ChartLabelOp(e.text, e.tx, ly, e.color));
                dotOps.add(new ChartDotOp(e.x, e.y, e.color));
                continue;
            }
            float tx = clusterTx(cl, sep);
            for (int i = 0; i < cl.size(); i++) {
                ChartLabelOp e = cl.get(i);
                textOps.add(new ChartLabelOp(e.text, tx, ly, e.color));
                tx += e.w;
                if (i < cl.size() - 1) {
                    textOps.add(new ChartLabelOp(" / ", tx, ly, colorAxis));
                    tx += sep;
                }
            }
            for (ChartLabelOp e : cl) {
                dotOps.add(new ChartDotOp(e.x, e.y, e.color));
            }
        }
        labels = textOps.toArray(new ChartLabelOp[0]);
        dots = dotOps.toArray(new ChartDotOp[0]);
    }

    /**
     * 给每个锚点算各自的理想落点（单成员口径），按下标写进 ly。选边公式与旧 placeClusters 的单簇分支相同，
     * 但只调用一次、不再随合并重算——这是「顺序贪心能真正封住链」的前提（见 app/逻辑说明.md §7.4）。
     */
    private void placeSingleAnchors(List<ChartLabelOp> entries, float[] ly, float dotR,
                                    float needAbove, float needBelow, float labelMaxY) {
        int n = entries.size();
        for (int i = 0; i < n; i++) {
            float y = entries.get(i).y;
            // 空隙只量到最近的那个障碍物：相邻锚点的圆点边缘；该侧没有别的锚点时就量到绘图区上沿/下沿。
            // 障碍物不含曲线中段：标签压在某条曲线腰部这种情况本口径不判。
            float obstacleAbove = fPadT;
            if (i > 0) {
                obstacleAbove = Math.max(obstacleAbove, entries.get(i - 1).y + dotR);
            }
            float obstacleBelow = fPadT + fH;
            if (i + 1 < n) {
                obstacleBelow = Math.min(obstacleBelow, entries.get(i + 1).y - dotR);
            }
            float gapAbove = y - obstacleAbove;
            float gapBelow = obstacleBelow - y;
            // 两侧都放得下（或都放不下）→ 取空隙更大的一侧；只有一侧放得下 → 取那一侧
            boolean fitsAbove = gapAbove >= needAbove;
            boolean fitsBelow = gapBelow >= needBelow;
            boolean placeAbove = fitsAbove == fitsBelow ? gapAbove >= gapBelow : fitsAbove;
            float lyLine = placeAbove ? y - LABEL_LIFT_DP * density
                                      : y + LABEL_H_DP * density + 1f * density;
            if (lyLine < fPadT) {
                lyLine = fPadT;
            }
            if (lyLine > labelMaxY) {
                lyLine = labelMaxY;
            }
            ly[i] = lyLine;
        }
    }

    /** 合并组的横向起点：成员锚点 x 的均值 + 间距，右越界翻到左侧，左界钳到 2dp（横向口径不变）。 */
    private float clusterTx(List<ChartLabelOp> cl, float sep) {
        float cx = 0f;
        for (ChartLabelOp e : cl) {
            cx += e.x;
        }
        cx /= cl.size();
        float total = 0f;
        for (ChartLabelOp e : cl) {
            total += e.w;
        }
        total += sep * (cl.size() - 1);
        float tx = cx + LABEL_GAP_DP * density;
        if (tx + total > fPadL + fW) {
            tx = cx - LABEL_GAP_DP * density - total;
        }
        if (tx < 2f * density) {
            tx = 2f * density;
        }
        return tx;
    }

    /**
     * 两个标注基线位置的**纵向**占位盒是否相交。只判纵向、横向不参与——横向取舍见 app/逻辑说明.md §7.4。
     */
    private static boolean overlapsVertically(float lyA, float lyB, Paint.FontMetrics fm) {
        return lyB + fm.ascent < lyA + fm.descent && lyA + fm.ascent < lyB + fm.descent;
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

        // 1) 网格横线 + 左轴刻度 + 右轴刻度 + 轴标题
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
        canvas.drawText(titleLeft, titleLeftX, fPadT - 7f * density, axisTextPaint);

        // 2) 折线：先左轴系列，再右轴系列（后画者压先画者）
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

        // 4) 标注：先用背景色描边（halo）再填色，避免曲线穿过字形时同色糊在一起
        if (labels != null) {
            haloPaint.setColor(colorBg);
            haloPaint.setStrokeWidth(HALO_WIDTH_DP * density);
            labelPaint.setTextSize(TICK_TEXT_DP * density);
            haloPaint.setTextSize(TICK_TEXT_DP * density);   // 与 labelPaint 同字号，见 init
            for (ChartLabelOp e : labels) {
                labelPaint.setColor(e.color);
                canvas.drawText(e.text, e.x, e.y, haloPaint);   // STROKE 画笔 = 描边
                canvas.drawText(e.text, e.x, e.y, labelPaint);  // FILL 画笔 = 填色
            }
        }

        // 5) 头部圆点：填系列色 + 背景色外圈
        if (dots != null) {
            dotHaloPaint.setColor(colorBg);
            float r = DOT_RADIUS_DP * density;
            for (ChartDotOp e : dots) {
                dotPaint.setColor(e.color);
                canvas.drawCircle(e.x, e.y, r, dotPaint);
                canvas.drawCircle(e.x, e.y, r, dotHaloPaint);
            }
        }
    }

    /** 一条标注文本（位置/宽度/颜色在 rebuild 定死，onDraw 只画）。 */
    private static final class ChartLabelOp {
        final String text;
        final float x;
        final float y;
        final int color;
        /** 文本宽度（rebuild 测量，合并成簇时用）。 */
        float w;
        /** 左对齐起点（rebuild 算好）。 */
        float tx;

        ChartLabelOp(String text, float x, float y, int color) {
            this.text = text;
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    /** 一个头部圆点。 */
    private static final class ChartDotOp {
        final float x;
        final float y;
        final int color;

        ChartDotOp(float x, float y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
