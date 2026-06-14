package com.omarea.ui;

import a.f92;
import a.m42;
import a.q31;
import a.v61;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class MemoryChartView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8398a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4882a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4883b;
    public int c;
    public int d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemoryChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4883b = 100;
        this.f8398a = 300.0f;
        this.b = 40.0f;
        this.e = 579373192;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.RamInfo);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.RamInfo)");
        this.f4881a = 100 - ((int) ((((double) typedArrayObtainStyledAttributes.getInteger(0, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(1, 1))));
        typedArrayObtainStyledAttributes.recycle();
        getColorAccent();
    }

    private final void getColorAccent() {
        this.e = getContext().getColor(2131099700);
    }

    public final void a(Canvas canvas) {
        Paint paint = this.f4882a;
        if (paint != null) {
            paint.setColor(579373192);
            float f = this.f8398a;
            canvas.drawArc(new RectF(0.0f, 0.0f, f, f), 0.0f, 360.0f, false, paint);
            int i = this.f4881a;
            if (i == 0) {
                return;
            }
            float f2 = i / this.f4883b;
            double d = f2;
            paint.setColor(d > 1.8d ? getFull() : d > 1.45d ? getVeryHigh() : d > 1.2d ? getHigh() : this.e);
            float f3 = 1;
            int i2 = (f2 > f3 ? (int) (((double) 50) * (((double) (f2 - f3)) / 0.8d)) : 0) + 125;
            if (i2 > 175) {
                i2 = 175;
            }
            paint.setAlpha(i2);
            paint.setStrokeCap(Paint.Cap.ROUND);
            float f4 = this.f8398a;
            canvas.drawArc(new RectF(0.0f, 0.0f, f4, f4), -90.0f, 1.0f + (this.f4881a * 3.6f), false, paint);
        }
    }

    public final void b() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.b);
        m42 m42Var = m42.f6769a;
        this.f4882a = paint;
    }

    public final void c(float f, float f2, float f3) {
        if (f2 == f && f == 0.0f) {
            this.f4881a = 0;
            this.f4883b = 100;
        } else {
            double d = f;
            this.f4881a = 100 - ((int) ((((double) f2) * 100.0d) / d));
            this.f4883b = (int) ((((double) f3) * 100.0d) / d);
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.d / 2;
        float f2 = this.f8398a;
        float f3 = 2;
        canvas.translate(f - (f2 / f3), (this.c / 2) - (f2 / f3));
        b();
        a(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.c = i2;
        this.b = i / 6;
        this.f8398a = (int) (((i > i2 ? i2 : i) * 0.9d) - ((double) r5));
    }
}
