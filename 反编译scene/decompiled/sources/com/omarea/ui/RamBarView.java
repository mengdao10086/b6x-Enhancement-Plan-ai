package com.omarea.ui;

import a.f92;
import a.m42;
import a.q31;
import a.v61;
import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class RamBarView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8399a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4885a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RamBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.e = 579373192;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v61.RamInfo);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…trs, R.styleable.RamInfo)");
        this.f4884a = 100 - ((int) ((((double) typedArrayObtainStyledAttributes.getInteger(0, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(1, 1))));
        typedArrayObtainStyledAttributes.recycle();
        getColorAccent();
    }

    public static /* synthetic */ void f(RamBarView ramBarView, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        ramBarView.e(f, f2, f3, f4);
    }

    private final void getColorAccent() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
        this.e = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void b(Canvas canvas) {
        int i;
        float f;
        Paint paint = this.f4885a;
        if (paint != null) {
            paint.setColor(579373192);
            float f2 = this.d;
            int i2 = this.c;
            canvas.drawRoundRect(0.0f, 0.0f, f2, i2, i2 / 2.0f, i2 / 2.0f, paint);
            int i3 = this.f4884a;
            float f3 = i3;
            float f4 = this.f8399a;
            int full = f3 > ((float) 90) + f4 ? getFull() : ((float) i3) > ((float) 85) + f4 ? getVeryHigh() : ((float) i3) > ((float) 80) + f4 ? getHigh() : this.e;
            int i4 = this.b;
            if (i4 == 0 || i4 == 100) {
                i = this.f4884a;
                f = 1.0f;
            } else {
                f = 0.5f;
                c(canvas, i4, full, 0.5f);
                i = this.f4884a;
            }
            c(canvas, i, full, f);
        }
    }

    public final void c(Canvas canvas, int i, int i2, float f) {
        Paint paint = this.f4885a;
        if (paint != null) {
            paint.setColor(i2);
            float f2 = i;
            float f3 = ((f2 > 75 + this.f8399a ? (int) (50 * (((f2 - r11) - r0) / 25)) : 0) + 125) * f;
            paint.setAlpha((f3 > ((float) 175) ? 175 : Float.valueOf(f3)).intValue());
            float f4 = (this.d / 100.0f) * f2;
            int i3 = this.c;
            canvas.drawRoundRect(0.0f, 0.0f, f4, i3, i3 / 2.0f, i3 / 2.0f, paint);
        }
    }

    public final void d() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(this.c);
        m42 m42Var = m42.f6769a;
        this.f4885a = paint;
    }

    public final void e(float f, float f2, float f3, float f4) {
        int i;
        if (f2 == f && f == 0.0f) {
            i = 0;
            this.f4884a = 0;
        } else {
            double d = f;
            this.f4884a = 100 - ((int) ((((double) f2) * 100.0d) / d));
            i = 100 - ((int) ((((double) f4) * 100.0d) / d));
        }
        this.b = i;
        this.f8399a = f3;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        canvas.translate(0.0f, 0.0f);
        d();
        b(canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = i;
        this.c = i2;
        Context context = getContext();
        f92.c(context, "context");
        a(context, 8.0f);
        Context context2 = getContext();
        f92.c(context2, "context");
        a(context2, 18.0f);
    }
}
