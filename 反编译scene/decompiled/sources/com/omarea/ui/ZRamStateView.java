package com.omarea.ui;

import a.f92;
import a.q31;
import a.v61;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ZRamStateView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4893a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4894a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4895b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f4896b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Paint f4897c;
    public final int d;
    public int e;
    public int f;
    public int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZRamStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f8408a = 300.0f;
        this.b = 40.0f;
        this.c = 20;
        this.d = -7829368;
        this.g = 579373192;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.RamInfo);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.RamInfo)");
        this.f4893a = 100 - ((int) ((((double) typedArrayObtainStyledAttributes.getInteger(0, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(1, 1))));
        typedArrayObtainStyledAttributes.recycle();
        getColorAccent();
    }

    private final void getColorAccent() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
        this.g = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Canvas canvas) {
        int i;
        int i2 = this.f4893a;
        int veryHigh = i2 > 89 ? getVeryHigh() : i2 > 80 ? getHigh() : this.g;
        Paint paint = this.f4894a;
        f92.b(paint);
        paint.setColor(Color.argb(35, Color.red(veryHigh), Color.green(veryHigh), Color.blue(veryHigh)));
        float f = this.f8408a;
        RectF rectF = new RectF(0.0f, 0.0f, f, f);
        Paint paint2 = this.f4894a;
        f92.b(paint2);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, paint2);
        if (this.f4893a == 0) {
            return;
        }
        Paint paint3 = this.f4894a;
        f92.b(paint3);
        paint3.setColor(veryHigh);
        int i3 = this.f4893a;
        if (i3 > 50) {
            Paint paint4 = this.f4894a;
            if (paint4 != null) {
                paint4.setAlpha(255);
            }
        } else {
            Paint paint5 = this.f4894a;
            if (paint5 != null) {
                paint5.setAlpha(((int) ((i3 / 100.0f) * 255)) + 127);
            }
        }
        Paint paint6 = this.f4894a;
        f92.b(paint6);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        float f2 = this.f8408a;
        Paint paint7 = this.f4894a;
        f92.b(paint7);
        canvas.drawArc(new RectF(0.0f, 0.0f, f2, f2), -90.0f, (this.f4895b * 3.6f) + 1.0f, false, paint7);
        int i4 = this.f4895b;
        int i5 = this.f4893a;
        if (i4 < i5) {
            i = i4 + 1;
        } else if (i4 <= i5) {
            return;
        } else {
            i = i4 - 1;
        }
        this.f4895b = i;
        invalidate();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f4894a = paint;
        f92.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.f4894a;
        f92.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f4894a;
        f92.b(paint3);
        paint3.setStrokeWidth(this.b);
        Paint paint4 = new Paint();
        this.f4896b = paint4;
        f92.b(paint4);
        paint4.setAntiAlias(true);
        Paint paint5 = this.f4896b;
        f92.b(paint5);
        paint5.setColor(this.d);
        Paint paint6 = this.f4896b;
        f92.b(paint6);
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.f4896b;
        f92.b(paint7);
        paint7.setStrokeWidth(1.0f);
        Paint paint8 = this.f4896b;
        f92.b(paint8);
        paint8.setTextSize(this.c);
        Paint paint9 = new Paint();
        this.f4897c = paint9;
        f92.b(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.f4897c;
        f92.b(paint10);
        paint10.setStyle(Paint.Style.FILL);
        Paint paint11 = this.f4897c;
        f92.b(paint11);
        paint11.setStrokeWidth(2.0f);
    }

    public final void d(float f, float f2) {
        this.f4893a = (f2 == f && f == 0.0f) ? 0 : 100 - ((int) ((((double) f2) * 100.0d) / ((double) f)));
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.f / 2;
        float f2 = this.f8408a;
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
        this.b = i * 0.15f;
        Context context = getContext();
        f92.c(context, "context");
        this.c = a(context, 18.0f);
        this.f8408a = (int) (((i > i2 ? i2 : i) * 0.9d) - ((double) r5));
    }
}
