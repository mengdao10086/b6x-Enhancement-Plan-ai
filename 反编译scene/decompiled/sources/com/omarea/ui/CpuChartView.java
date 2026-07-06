package com.omarea.ui;

import a.f92;
import a.q31;
import a.v61;
import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CpuChartView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4856a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4857b;
    public int c;
    public int d;
    public int e;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            CpuChartView cpuChartView = CpuChartView.this;
            f92.c(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            cpuChartView.f4857b = ((Integer) animatedValue).intValue();
            CpuChartView.this.invalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f8387a = 300.0f;
        this.b = 40.0f;
        this.e = 579373192;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.RamInfo);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.RamInfo)");
        this.f4855a = 100 - ((int) ((((double) typedArrayObtainStyledAttributes.getInteger(0, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(1, 1))));
        typedArrayObtainStyledAttributes.recycle();
        getColorAccent();
    }

    private final void getColorAccent() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
        this.e = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(int i) {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f4857b, i);
        f92.c(valueAnimatorOfInt, "va");
        valueAnimatorOfInt.setDuration(200L);
        valueAnimatorOfInt.setInterpolator(new DecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new a());
        valueAnimatorOfInt.start();
    }

    public final int c(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void d(Canvas canvas) {
        RectF rectF;
        float f;
        float f2;
        Paint paint = this.f4856a;
        if (paint != null) {
            paint.setColor(579373192);
            float f3 = this.f8387a;
            canvas.drawArc(new RectF(0.0f, 0.0f, f3, f3), 0.0f, 360.0f, false, paint);
            int i = this.f4855a;
            paint.setColor(i > 85 ? getVeryHigh() : i > 65 ? getHigh() : this.e);
            int i2 = this.f4855a;
            paint.setAlpha(i2 <= 50 ? ((int) ((i2 / 100.0f) * 255)) + 127 : 255);
            paint.setStrokeCap(Paint.Cap.ROUND);
            if (this.f4855a >= 1 || this.f4857b > 2) {
                if (this.f4857b >= 98) {
                    float f4 = this.f8387a;
                    rectF = new RectF(0.0f, 0.0f, f4, f4);
                    f = -90.0f;
                    f2 = 360.0f;
                } else {
                    float f5 = this.f8387a;
                    rectF = new RectF(0.0f, 0.0f, f5, f5);
                    f = -90.0f;
                    f2 = 3.6f * this.f4857b;
                }
                canvas.drawArc(rectF, f, f2, false, paint);
            }
        }
    }

    public final void e() {
        Paint paint = new Paint();
        this.f4856a = paint;
        f92.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.f4856a;
        f92.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f4856a;
        f92.b(paint3);
        paint3.setStrokeWidth(this.b);
    }

    public final void f(float f, float f2) {
        this.f4855a = (f2 == f && f == 0.0f) ? 0 : 100 - ((int) ((((double) f2) * 100.0d) / ((double) f)));
        if (Math.abs(this.f4855a - this.f4857b) > 10) {
            b(this.f4855a);
        } else {
            this.f4857b = this.f4855a;
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.d / 2;
        float f2 = this.f8387a;
        float f3 = 2;
        canvas.translate(f - (f2 / f3), (this.c / 2) - (f2 / f3));
        e();
        d(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.c = i2;
        this.b = i / 7;
        Context context = getContext();
        f92.c(context, "context");
        c(context, 18.0f);
        this.f8387a = (int) (((i > i2 ? i2 : i) * 0.9d) - ((double) r5));
    }
}
