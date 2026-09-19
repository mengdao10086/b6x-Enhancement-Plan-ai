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
 * 曲线自绘控件（D2）。口径逐条对齐 WebUI 的 {@code drawChart()}，依据与行号见
 * {@code .claude/路线A-线D-曲线口径.md}。
 *
 * <p><b>性能硬约束</b>：{@code onDraw} 只做 drawColor / drawLine / drawRect / drawPath /
 * drawCircle / drawText。全部几何量（轴与刻度、每系列 {@link Path}、标注位置与文本宽度、
 * 断联空白）都在 {@link #rebuild()} 里算好并缓存；rebuild 只在数据/窗口/系列开关/尺寸/配色
 * 变化时触发，<b>绝不在 onDraw 内重建 Path</b>。
 *
 * <p><b>本控件不读文件</b>：数据由 {@link ChartLoader} 在后台线程读好后经
 * {@link #setData(ChartWindow, ChartConfig)} 送上主线程。
 *
 * <p><b>配色</b>：全部运行时按当前主题取（{@code getColor(id, theme)}），深色由
 * {@code values-night/colors.xml} 同名覆盖；本类不出现任何十六进制色值。
 */
public class ChartView extends View {

    // ---- 口径常量（CSS px → dp，绘制时乘 density）----
    private static final int PAD_H_DP = 36;          // padL = padR = 36
    private static final int PAD_V_DP = 16;          // padT = padB = 16（原 padB = 4 + 12 外扩）
    private static final float LINE_WIDTH_DP = 1.6f; // 折线
    private static final float GRID_WIDTH_DP = 1f;   // 网格
    private static final float HALO_WIDTH_DP = 3f;   // 文字 halo
    private static final float DOT_RADIUS_DP = 3.2f; // 头部圆点
    private static final float DOT_HALO_DP = 1f;     // 圆点外圈
    private static final float TICK_TEXT_DP = 10f;   // 刻度 / 标注 / 轴标题字号
    private static final float EMPTY_TEXT_DP = 12f;  // 「采样中…」字号
    private static final float SEAM_EXTRA_DP = 4f;   // 转速圆点允许下越界的量
    private static final float LABEL_GAP_DP = 6f;    // 标签与端点的水平间距

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
    private float fPadT;
    private float fW;
    private float fH;
    private float fSeamY;
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
        colorBg = res.getColor(R.color.chart_bg, theme);
        colorGrid = res.getColor(R.color.chart_grid, theme);
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
        float padH = PAD_H_DP * density;
        float padV = PAD_V_DP * density;
        fPadL = padH;
        fPadT = padV;
        fW = w - 2f * padH;
        fH = h - 2f * padV;
        if (fW <= 8f * density || fH <= 8f * density) {
            return;
        }
        fSeamY = Math.min(fPadT + fH + SEAM_EXTRA_DP * density, h - 1f);

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
        // 左轴：先按"排除低于转速下限的样本"求范围；全被滤掉时退回不过滤（口径见 逻辑说明.md 的「曲线」一节〈双纵轴〉）
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
        buildPaths(win, lAxis, rAxis);
        buildMarkers(win, lAxis, rAxis);
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

    /** 每条开启系列一条 Path；断联处 moveTo 断开、不连桥（口径见 逻辑说明.md 的「曲线」一节〈断联空白〉）。 */
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

    /** 头部标注：每条系列的最后一个有效样本；垂直近者合并成一行（与簇首比距离）。 */
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

        float mergeY = (config != null ? config.labelMergePx : 9) * density;
        List<List<ChartLabelOp>> clusters = new ArrayList<>();
        List<ChartLabelOp> cur = null;
        for (ChartLabelOp e : entries) {
            if (cur != null && e.y - cur.get(0).y < mergeY) {
                cur.add(e);
            } else {
                cur = new ArrayList<>();
                cur.add(e);
                clusters.add(cur);
            }
        }

        Paint.FontMetrics fm = tickPaint.getFontMetrics();
        float labelH = fm.descent - fm.ascent;
        List<ChartLabelOp> textOps = new ArrayList<>();
        List<ChartDotOp> dotOps = new ArrayList<>();
        for (List<ChartLabelOp> cl : clusters) {
            float top = cl.get(0).y;
            float bot = cl.get(cl.size() - 1).y;
            float ly;
            if (bot > fPadT + fH) {
                ly = top - 4f * density;                  // 簇最低点已越界 → 改放上方
            } else if ((top - fPadT) >= (fPadT + fH - bot)) {
                ly = top - 4f * density;                  // 上方空间大 → 放上面
            } else {
                ly = bot + labelH + 1f * density;         // 下方空间大 → 放下面
            }
            if (ly < fPadT) {
                ly = fPadT;
            }
            if (ly > fPadT + fH + labelH) {
                ly = fPadT + fH + labelH;
            }

            if (cl.size() == 1) {
                ChartLabelOp e = cl.get(0);
                textOps.add(new ChartLabelOp(e.text, e.tx, ly, e.color));
                dotOps.add(new ChartDotOp(e.x, e.y, e.color));
                continue;
            }
            float cx = 0f;
            for (ChartLabelOp e : cl) {
                cx += e.x;
            }
            cx /= cl.size();
            float sep = tickPaint.measureText(" / ");
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

    // ==================== 绘制（无计算、无分配） ====================

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(colorBg);
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
            canvas.drawText(gridText[i], fPadL - 4f * density, gridY[i] + 3f * density, tickPaint);
        }
        if (rightText != null) {
            for (int i = 0; i < rightText.length; i++) {
                canvas.drawText(rightText[i], fPadL + fW + 4f * density,
                        gridY[i] + 3f * density, axisTextPaint);
            }
            canvas.drawText(titleRight, fPadL + fW + 4f * density, fPadT - 7f * density, axisTextPaint);
        }
        canvas.drawText(titleLeft, 2f * density, fPadT - 7f * density, axisTextPaint);

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
