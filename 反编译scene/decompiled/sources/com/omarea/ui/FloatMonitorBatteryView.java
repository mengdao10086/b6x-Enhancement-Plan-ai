package com.omarea.ui;

import a.f92;
import a.q31;
import a.v61;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class FloatMonitorBatteryView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f8389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f4858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4859a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4860a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4861b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f4862b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Paint f4863c;
    public final int d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FloatMonitorBatteryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4858a = 300.0f;
        this.b = 40.0f;
        this.c = 20;
        this.d = -7829368;
        this.f8389a = 35.0d;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.RamInfo);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.RamInfo)");
        this.f4859a = 100 - ((int) ((((double) typedArrayObtainStyledAttributes.getInteger(0, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(1, 1))));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Canvas canvas) {
        int i;
        Paint paint = this.f4860a;
        f92.b(paint);
        paint.setColor(587202559);
        float f = this.f4858a;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        Paint paint2 = this.f4860a;
        f92.b(paint2);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, paint2);
        Paint paint3 = this.f4860a;
        f92.b(paint3);
        double d = this.f8389a;
        paint3.setColor((d >= ((double) 48) || this.f4861b < 11) ? getFull() : (d > ((double) 44) || (i = this.f4859a) < 16) ? getVeryHigh() : (d > ((double) 41) || i < 31) ? getHigh() : d > ((double) 20) ? getMiddle() : getColorPrimary());
        Paint paint4 = this.f4860a;
        f92.b(paint4);
        paint4.setStrokeCap(Paint.Cap.ROUND);
        if (this.f4859a >= 1 || this.f4861b > 2) {
            if (this.f4861b >= 98) {
                float f2 = this.f4858a;
                RectF rectF2 = new RectF(0.0f, 0.0f, f2, f2);
                Paint paint5 = this.f4860a;
                f92.b(paint5);
                canvas.drawArc(rectF2, -90.0f, 360.0f, false, paint5);
                return;
            }
            float f3 = this.f4858a;
            Paint paint6 = this.f4860a;
            f92.b(paint6);
            canvas.drawArc(new RectF(0.0f, 0.0f, f3, f3), -90.0f, this.f4861b * 3.6f, false, paint6);
        }
    }

    public final void c() {
        Paint paint = new Paint();
        this.f4860a = paint;
        f92.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.f4860a;
        f92.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f4860a;
        f92.b(paint3);
        paint3.setStrokeWidth(this.b);
        Paint paint4 = new Paint();
        this.f4862b = paint4;
        f92.b(paint4);
        paint4.setAntiAlias(true);
        Paint paint5 = this.f4862b;
        f92.b(paint5);
        paint5.setColor(this.d);
        Paint paint6 = this.f4862b;
        f92.b(paint6);
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.f4862b;
        f92.b(paint7);
        paint7.setStrokeWidth(1.0f);
        Paint paint8 = this.f4862b;
        f92.b(paint8);
        paint8.setTextSize(this.c);
        Paint paint9 = new Paint();
        this.f4863c = paint9;
        f92.b(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.f4863c;
        f92.b(paint10);
        paint10.setStyle(Paint.Style.FILL);
        Paint paint11 = this.f4863c;
        f92.b(paint11);
        paint11.setStrokeWidth(2.0f);
    }

    public final void d(double d, double d2, double d3) {
        this.f4859a = (d2 == d && d == 0.0d) ? 0 : 100 - ((int) ((d2 * 100.0d) / d));
        this.f8389a = d3;
        this.f4861b = this.f4859a;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.f / 2;
        float f2 = this.f4858a;
        float f3 = 2;
        canvas.translate(f - (f2 / f3), (this.e / 2) - (f2 / f3));
        c();
        b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f = i;
        this.e = i2;
        Context context = getContext();
        f92.c(context, "context");
        this.b = a(context, 4.0f);
        Context context2 = getContext();
        f92.c(context2, "context");
        this.c = a(context2, 18.0f);
        this.f4858a = (int) (((i > i2 ? i2 : i) * 0.9d) - ((double) r5));
    }
}
