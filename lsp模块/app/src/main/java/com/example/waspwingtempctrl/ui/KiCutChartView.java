package com.example.waspwingtempctrl.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.waspwingtempctrl.R;

import java.util.List;
import java.util.Locale;

/**
 * 分段倍率表的实时倍率曲线：三条线（KDP 倍率 / 升倍率 / 降倍率，均 ×100 口径；KDP 更淡更细、画在下层）
 * + 一条红色竖虚线标「当前冷值」。每条线：<b>实线＝整条生效值曲线</b>，另有<b>同色虚线＝不生效候选</b>
 * 只在不生效区间画出（数据见 {@link Series}）——多簇倍率重合处取离候选平均值最近的那侧生效，另一侧即
 * 不生效候选；两者高度可以不同，虚线两端落在实线上（从一个开始分开的点接出、到重新合上的点接回）。
 *
 * <p>横轴 0…当前设备制冷上限（见 {@link KiCutData#coldMax}），纵轴<b>自适应定标</b>——与实时信息图同一套
 * {@link ChartAxis}（档位梯 1/2/3 + ≥5 的 5 倍数、3~5 段取离跨度/4 最近），<b>不额外加最小跨度兜底</b>；
 * 定标仍按 ×100 口径喂值，只在刻度标签上 ÷100 显示成原始倍率（{@code 0.5} / {@code 1} / {@code 1.5} …）。
 * 「100 = 不削」基准线恒画：中性值并入取值范围，故它总落在可视区内。
 *
 * <p>数据由调用方用 {@link KiCutTable#minCurve} 本地重算好后经 {@link #setCurves} 送上主线程，
 * <b>本控件不读文件、不做算法</b>；纵轴定标与其刻度标签在 {@link #setCurves} 里算好并缓存，onDraw 只消费。
 */
final class KiCutChartView extends View {

    /**
     * 一条曲线的三份并行数据（长度均 = {@code xMax + 1}）：生效值 / 不生效候选 / 该处是否存在不生效候选。
     * {@code shadow[i]} 在该处没有不生效候选时等于 {@code value[i]}（虚线与实线重合，自然看不见）。
     */
    static final class Series {
        final float[] value;
        final float[] shadow;
        final boolean[] inactive;

        Series(@NonNull float[] value, @NonNull float[] shadow, @NonNull boolean[] inactive) {
            this.value = value;
            this.shadow = shadow;
            this.inactive = inactive;
        }

        /** 按轴现算三份数据（只委托 {@link KiCutTable}；本控件仍不读文件、不做算法）。 */
        @NonNull
        static Series of(@NonNull List<KiCutTable.Cluster> clusters, int xMax, int axis) {
            return new Series(KiCutTable.effectiveCurve(clusters, xMax, axis),
                    KiCutTable.shadowCurve(clusters, xMax, axis),
                    KiCutTable.inactiveMask(clusters, xMax, axis));
        }

        /** 空数据（仅作字段默认值；{@link #setCurves} 上屏前不绘制）。 */
        @NonNull
        static Series empty() {
            return new Series(new float[0], new float[0], new boolean[0]);
        }
    }

    private static final float LINE_WIDTH_DP = 2f;
    /** KDP 那条更细（同族但更淡，不抢升/降两条的主角）。 */
    private static final float KDP_WIDTH_DP = 1.5f;
    private static final float GRID_WIDTH_DP = 1f;
    private static final float REF_WIDTH_DP = 1.5f;
    private static final float TICK_TEXT_DP = 10f;
    private static final float PAD_DP = 6f;
    private static final float TARGET_DASH_ON_DP = 5f;
    private static final float TARGET_DASH_OFF_DP = 3f;

    private final Paint gridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint refPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint upPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint dnPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint kdpPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint targetPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    /** 「不生效段」的虚线效果（口径与「当前冷值」竖虚线一致）；在 {@link #init()} 里按当前密度建。 */
    private DashPathEffect dashEffect;

    private float density;
    private int colorGrid;
    private int colorAxis;
    private int colorUp;
    private int colorDn;
    private int colorKdp;
    private int colorTarget;
    private boolean colorsReady;

    private Series up = Series.empty();
    private Series dn = Series.empty();
    private Series kdp = Series.empty();
    private int xMax = 190;
    private int target = -1;
    /** 横轴刻度（表里各点冷值 ∪ {0, xMax}，去重升序）；由 {@link #setCurves} 注入、onDraw 消费。 */
    private int[] ticks = new int[0];

    // ---- setCurves 产物：纵轴定标与其刻度；onDraw 只消费 ----
    private ChartAxis axis;
    private float[] axisTicks = new float[0];
    private String[] axisLabels = new String[0];

    public KiCutChartView(Context context) {
        super(context);
        init();
    }

    public KiCutChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public KiCutChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        density = getResources().getDisplayMetrics().density;
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setStrokeWidth(GRID_WIDTH_DP * density);
        refPaint.setStyle(Paint.Style.STROKE);
        refPaint.setStrokeWidth(REF_WIDTH_DP * density);
        textPaint.setTextSize(TICK_TEXT_DP * density);
        textPaint.setTextAlign(Paint.Align.CENTER);
        for (Paint p : new Paint[]{upPaint, dnPaint, targetPaint}) {
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(LINE_WIDTH_DP * density);
        }
        kdpPaint.setStyle(Paint.Style.STROKE);
        kdpPaint.setStrokeWidth(KDP_WIDTH_DP * density);
        dashEffect = new DashPathEffect(
                new float[]{TARGET_DASH_ON_DP * density, TARGET_DASH_OFF_DP * density}, 0f);
        targetPaint.setPathEffect(dashEffect);
    }

    /**
     * 上屏一批曲线数据（主线程）：三条线各自的 {@link Series} 长度均 = {@code xMax + 1}，逐格取值；
     * {@code xTicks} 是横轴刻度（表里各点的冷值 ∪ {0, xMax}，去重升序，<b>不抽稀</b>、允许重叠）。
     */
    void setCurves(@NonNull Series up, @NonNull Series dn, @NonNull Series kdp, int xMax,
                   int target, @NonNull int[] xTicks) {
        this.up = up;
        this.dn = dn;
        this.kdp = kdp;
        this.xMax = Math.max(1, xMax);
        this.target = target;
        this.ticks = xTicks;
        fitAxis();
        invalidate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        float d = getResources().getDisplayMetrics().density;
        if (d != density) {
            density = d;
            init();
        }
        colorsReady = false;
        invalidate();
    }

    private void loadColors() {
        colorGrid = getResources().getColor(R.color.app_outline_variant, getContext().getTheme());
        colorAxis = getResources().getColor(R.color.chart_axis, getContext().getTheme());
        colorUp = getResources().getColor(R.color.ki_cut_up, getContext().getTheme());
        colorDn = getResources().getColor(R.color.ki_cut_down, getContext().getTheme());
        colorKdp = getResources().getColor(R.color.ki_cut_kdp, getContext().getTheme());
        colorTarget = getResources().getColor(R.color.ki_cut_target, getContext().getTheme());
        colorsReady = true;
    }

    /**
     * 纵轴定标：取值范围 = 三条曲线<b>的生效值与不生效候选值一并</b>并入中性值（100 = 不削），
     * 再照 {@link ChartAxis#fit} 求整档轴。并入 shadow 值是为了不让虚线被定标裁掉；
     * 并入中性值只为「基准线恒可见」，不改定标算法本身（无最小跨度兜底）。
     */
    private void fitAxis() {
        float mn = Float.POSITIVE_INFINITY;
        float mx = Float.NEGATIVE_INFINITY;
        for (Series s : new Series[]{up, dn, kdp}) {
            for (float[] arr : new float[][]{s.value, s.shadow}) {
                for (float v : arr) {
                    if (v < mn) {
                        mn = v;
                    }
                    if (v > mx) {
                        mx = v;
                    }
                }
            }
        }
        if (mn == Float.POSITIVE_INFINITY || mx == Float.NEGATIVE_INFINITY) {
            mn = KiCutTable.NEUTRAL;
            mx = KiCutTable.NEUTRAL;
        }
        if (KiCutTable.NEUTRAL < mn) {
            mn = KiCutTable.NEUTRAL;
        }
        if (KiCutTable.NEUTRAL > mx) {
            mx = KiCutTable.NEUTRAL;
        }
        axis = ChartAxis.fit(mn, mx);
        axisTicks = ChartAxis.ticksOf(axis.min, axis.max, axis.step);
        axisLabels = new String[axisTicks.length];
        for (int i = 0; i < axisTicks.length; i++) {
            axisLabels[i] = ratioLabel(axisTicks[i]);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!colorsReady) {
            loadColors();
        }
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0 || axis == null || axisLabels.length == 0) {
            return;
        }
        float pad = PAD_DP * density;
        float labelH = -textPaint.getFontMetrics().ascent + textPaint.getFontMetrics().descent;
        float labelW = 0f;
        for (String s : axisLabels) {
            labelW = Math.max(labelW, textPaint.measureText(s));
        }
        float padL = labelW + pad;
        float plotL = padL;
        float plotR = w - pad;
        float plotT = pad;
        float plotB = h - labelH - pad;
        if (plotR - plotL < 4f || plotB - plotT < 4f) {
            return;
        }

        // 纵轴网格 + 刻度（原始倍率标签）；y 由 ChartAxis 定标给出
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        textPaint.setColor(colorAxis);
        textPaint.setTextAlign(Paint.Align.RIGHT);
        gridPaint.setColor(colorGrid);
        for (int i = 0; i < axisTicks.length; i++) {
            float y = axis.y(axisTicks[i], plotT, plotB - plotT);
            canvas.drawLine(plotL, y, plotR, y, gridPaint);
            canvas.drawText(axisLabels[i], plotL - pad / 2f, y - (fm.ascent + fm.descent) / 2f, textPaint);
        }
        // 「100 = 不削」基准线：恒画（中性值已并入轴范围，故必在可视区内），比网格线更实
        refPaint.setColor(colorAxis);
        float refY = axis.y(KiCutTable.NEUTRAL, plotT, plotB - plotT);
        canvas.drawLine(plotL, refY, plotR, refY, refPaint);

        // 横轴刻度 + 刻度数字：刻度由调用方给定（表里各点冷值 ∪ {0, xMax}），不抽稀、允许重叠
        textPaint.setTextAlign(Paint.Align.CENTER);
        for (int x : ticks) {
            float px = gridX(x, plotL, plotR);
            canvas.drawLine(px, plotT, px, plotB, gridPaint);
            String text = label(x);
            float half = textPaint.measureText(text) / 2f;
            canvas.drawText(text, Math.min(Math.max(px, half), w - half), h - pad / 2f, textPaint);
        }

        // 三条曲线：KDP 在下层（更淡更细，不抢眼），升/降在上层；每条按生效（实线）/不生效（同色虚线）分段
        kdpPaint.setColor(colorKdp);
        upPaint.setColor(colorUp);
        dnPaint.setColor(colorDn);
        drawSeries(canvas, kdp, kdpPaint, plotL, plotR, plotT, plotB);
        drawSeries(canvas, up, upPaint, plotL, plotR, plotT, plotB);
        drawSeries(canvas, dn, dnPaint, plotL, plotR, plotT, plotB);

        // 当前冷值：一条红色竖虚线
        if (target >= 0 && target <= xMax) {
            targetPaint.setColor(colorTarget);
            float px = gridX(target, plotL, plotR);
            canvas.drawLine(px, plotT, px, plotB, targetPaint);
        }
    }

    /**
     * 画一条曲线：<b>实线＝整条生效值曲线</b>（实际生效的那个值恒画实线，全线连续）；
     * <b>虚线＝不生效候选</b>，只在不生效区间（{@code inactive=true} 的极大连续区间）单独画同色虚线。
     * 虚线两端各向外多取一格（该处 {@code shadow == value}，落在实线上），故与实线相接、不悬空；
     * 区间之间不连线，故一轴可有多段独立的虚线（如两簇交叉时前后各一段）。
     */
    private void drawSeries(Canvas canvas, Series s, Paint paint, float plotL, float plotR,
                            float plotT, float plotB) {
        paint.setPathEffect(null);
        canvas.drawPath(fullPath(s.value, plotL, plotR, plotT, plotB), paint);
        paint.setPathEffect(dashEffect);
        canvas.drawPath(inactiveRunsPath(s, plotL, plotR, plotT, plotB), paint);
        paint.setPathEffect(null);
    }

    /** 整条折线（逐格连起来）。 */
    private Path fullPath(float[] values, float plotL, float plotR, float plotT, float plotB) {
        Path p = new Path();
        for (int x = 0; x < values.length; x++) {
            float px = gridX(x, plotL, plotR);
            float py = axis.y(values[x], plotT, plotB - plotT);
            if (x == 0) {
                p.moveTo(px, py);
            } else {
                p.lineTo(px, py);
            }
        }
        return p;
    }

    /**
     * 把连续「不生效」区间各并成一条折线段，可多段；区间之间不连线。粒度＝逐整数冷值，段在此并合。
     *
     * <p>端点处理：区间两端各向外多取一格，该格 {@code shadow == value} 本就在实线上；但若区间贴住
     * {@code x=0} 或 {@code x=xMax}，那一侧无法外延，此时**该端点格改用生效值**（{@code value}），
     * 令虚线端点落回实线、不悬空——同时保留「此处存在一个被舍弃的候选」的信息。
     */
    private Path inactiveRunsPath(Series s, float plotL, float plotR, float plotT, float plotB) {
        Path p = new Path();
        int n = s.value.length;
        int x = 0;
        while (x < n) {
            if (!inactiveAt(s.inactive, x)) {
                x++;
                continue;
            }
            int start = x;
            while (x < n && inactiveAt(s.inactive, x)) {
                x++;
            }
            int end = x - 1;
            int from = Math.max(0, start - 1);
            int to = Math.min(n - 1, end + 1);
            for (int i = from; i <= to; i++) {
                // 贴边无法外延的端点格（start==0 的 from / end==xMax 的 to）：改用生效值，端点落回实线
                boolean clampedEdge = (i == from && from == start) || (i == to && to == end);
                float v = clampedEdge ? s.value[i] : s.shadow[i];
                float px = gridX(i, plotL, plotR);
                float py = axis.y(v, plotT, plotB - plotT);
                if (i == from) {
                    p.moveTo(px, py);
                } else {
                    p.lineTo(px, py);
                }
            }
        }
        return p;
    }

    private static boolean inactiveAt(boolean[] inactive, int x) {
        return x >= 0 && x < inactive.length && inactive[x];
    }

    private float gridX(int x, float plotL, float plotR) {
        float t = x <= 0 ? 0f : (x >= xMax ? 1f : x / (float) xMax);
        return plotL + t * (plotR - plotL);
    }

    /** 纵轴刻度标签：原始倍率（×100 除以 100），最多两位小数、去掉多余尾零（50→0.5、100→1、150→1.5）。 */
    private static String ratioLabel(float centi) {
        // 轴首档 lo==0 时 ChartAxis.ticksOf 会给出 -0.0f（Math.ceil(-1e-9)*step），
        // 不拦会经 %.2f 去尾零渲染成 "-0"；-0.0f == 0f 为真，这一句同时盖住 ±0。
        if (centi == 0f) {
            return "0";
        }
        String s = String.format(Locale.US, "%.2f", centi / 100f);
        while (s.endsWith("0")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith(".")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }

    private static String label(int v) {
        return String.format(Locale.US, "%d", v);
    }
}
