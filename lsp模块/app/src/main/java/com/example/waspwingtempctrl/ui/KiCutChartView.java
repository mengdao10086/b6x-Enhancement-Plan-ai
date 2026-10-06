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

import java.util.Locale;

/**
 * KI 分段削减表的实时倍率曲线：两条线（KI 升倍率 / KI 降倍率，×100 口径）+ 一条红色竖虚线标「此刻目标冷值」。
 *
 * <p>横轴 0…当前设备制冷上限（见 {@link KiCutData#coldMax}），纵轴恒 0…200（100 = 不削）。数据由调用方
 * 用 {@link KiCutTable#minCurve} 本地重算好后经 {@link #setCurves} 送上主线程，<b>本控件不读文件、不做算法</b>。
 */
final class KiCutChartView extends View {

    /** 纵轴满量程（倍率 ×100）：200 = 两倍增益。 */
    private static final int Y_MAX = 200;
    /** 纵轴网格线（含 100 这条"不削"基准线）。 */
    private static final int[] Y_TICKS = {0, 50, 100, 150, 200};
    /** 横轴刻度段数（0 / 四分之一 … / 上限）。 */
    private static final int X_TICKS = 4;

    private static final float LINE_WIDTH_DP = 2f;
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
    private final Paint targetPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private float density;
    private int colorGrid;
    private int colorAxis;
    private int colorUp;
    private int colorDn;
    private int colorTarget;
    private boolean colorsReady;

    private float[] up = new float[0];
    private float[] dn = new float[0];
    private int xMax = 190;
    private int target = -1;

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
        targetPaint.setPathEffect(new DashPathEffect(
                new float[]{TARGET_DASH_ON_DP * density, TARGET_DASH_OFF_DP * density}, 0f));
    }

    /** 上屏一批曲线数据（主线程）：{@code up}/{@code dn} 长度 = {@code xMax + 1}，逐格取值。 */
    void setCurves(@NonNull float[] up, @NonNull float[] dn, int xMax, int target) {
        this.up = up;
        this.dn = dn;
        this.xMax = Math.max(1, xMax);
        this.target = target;
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
        colorTarget = getResources().getColor(R.color.ki_cut_target, getContext().getTheme());
        colorsReady = true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!colorsReady) {
            loadColors();
        }
        int w = getWidth();
        int h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        float pad = PAD_DP * density;
        float labelH = -textPaint.getFontMetrics().ascent + textPaint.getFontMetrics().descent;
        float padL = textPaint.measureText(label(Y_MAX)) + pad;
        float plotL = padL;
        float plotR = w - pad;
        float plotT = pad;
        float plotB = h - labelH - pad;
        if (plotR - plotL < 4f || plotB - plotT < 4f) {
            return;
        }

        // 纵轴网格 + 刻度；100 那条是"不削"基准线，用轴色画得更实
        Paint.FontMetrics fm = textPaint.getFontMetrics();
        textPaint.setColor(colorAxis);
        textPaint.setTextAlign(Paint.Align.RIGHT);
        gridPaint.setColor(colorGrid);
        refPaint.setColor(colorAxis);
        for (int v : Y_TICKS) {
            float y = valueY(v, plotT, plotB);
            canvas.drawLine(plotL, y, plotR, y, v == KiCutTable.NEUTRAL ? refPaint : gridPaint);
            canvas.drawText(label(v), plotL - pad / 2f, y - (fm.ascent + fm.descent) / 2f, textPaint);
        }

        // 横轴刻度 + 刻度数字
        textPaint.setTextAlign(Paint.Align.CENTER);
        for (int i = 0; i <= X_TICKS; i++) {
            int x = Math.round(xMax * (i / (float) X_TICKS));
            float px = gridX(x, plotL, plotR);
            canvas.drawLine(px, plotT, px, plotB, gridPaint);
            String text = label(x);
            float half = textPaint.measureText(text) / 2f;
            canvas.drawText(text, Math.min(Math.max(px, half), w - half), h - pad / 2f, textPaint);
        }

        // 两条曲线
        upPaint.setColor(colorUp);
        dnPaint.setColor(colorDn);
        canvas.drawPath(path(up, plotL, plotR, plotT, plotB), upPaint);
        canvas.drawPath(path(dn, plotL, plotR, plotT, plotB), dnPaint);

        // 此刻目标冷值：一条红色竖虚线
        if (target >= 0 && target <= xMax) {
            targetPaint.setColor(colorTarget);
            float px = gridX(target, plotL, plotR);
            canvas.drawLine(px, plotT, px, plotB, targetPaint);
        }
    }

    /** 逐格折线：{@code values[i]} 是 x=i 处的倍率。 */
    private Path path(float[] values, float plotL, float plotR, float plotT, float plotB) {
        Path p = new Path();
        boolean started = false;
        for (int x = 0; x < values.length; x++) {
            float px = gridX(x, plotL, plotR);
            float py = valueY(values[x], plotT, plotB);
            if (started) {
                p.lineTo(px, py);
            } else {
                p.moveTo(px, py);
                started = true;
            }
        }
        return p;
    }

    private float gridX(int x, float plotL, float plotR) {
        float t = x <= 0 ? 0f : (x >= xMax ? 1f : x / (float) xMax);
        return plotL + t * (plotR - plotL);
    }

    private float valueY(float v, float plotT, float plotB) {
        float clamped = v < 0f ? 0f : (v > Y_MAX ? Y_MAX : v);
        return plotB - (clamped / (float) Y_MAX) * (plotB - plotT);
    }

    private static String label(int v) {
        return String.format(Locale.US, "%d", v);
    }
}
