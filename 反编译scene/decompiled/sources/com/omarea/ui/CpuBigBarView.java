package com.omarea.ui;

import a.f92;
import a.m42;
import a.q31;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CpuBigBarView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8385a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f4847a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4848a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedBlockingQueue<Integer> f4849a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4850b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuBigBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4847a = 10;
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        int i = this.f4847a;
        for (int i2 = 0; i2 < i; i2++) {
            linkedBlockingQueue.add(0);
        }
        m42 m42Var = m42.f6769a;
        this.f4849a = linkedBlockingQueue;
        this.f4850b = 579373192;
        getColorAccent();
    }

    private final void getColorAccent() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
        this.f4850b = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(float f, float f2) throws InterruptedException {
        if (f2 == f && f == 0.0f) {
            this.f4849a.put(0);
        } else {
            this.f4849a.put(Integer.valueOf(100 - ((int) ((((double) f2) * 100.0d) / ((double) f)))));
        }
        if (this.f4849a.size() > this.f4847a) {
            this.f4849a.poll();
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float fIntValue;
        float f;
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f4848a == null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            m42 m42Var = m42.f6769a;
            this.f4848a = paint;
            this.b = getWidth() / this.f4847a;
            Paint paint2 = this.f4848a;
            f92.b(paint2);
            paint2.setStrokeWidth(0.0f);
        }
        int i = 0;
        float f2 = this.b;
        for (Integer num : this.f4849a) {
            Paint paint3 = this.f4848a;
            f92.b(paint3);
            paint3.setColor(num.intValue() > 85 ? getVeryHigh() : num.intValue() > 65 ? getHigh() : this.f4850b);
            paint3.setAlpha(((int) (((num.intValue() / 100.0f) / 2) * 255)) + 35);
            if (num.intValue() <= 2) {
                fIntValue = this.f8385a - 10.0f;
            } else if (num.intValue() >= 98) {
                f = 0.0f;
                float f3 = i * f2;
                float f4 = this.f8385a;
                Paint paint4 = this.f4848a;
                f92.b(paint4);
                canvas.drawRoundRect(f3 + (0.05f * f2), f, f3 + (0.95f * f2), f4, 5.0f, 5.0f, paint4);
                i++;
            } else {
                f92.c(num, "ratio");
                fIntValue = ((100 - num.intValue()) * this.f8385a) / 100;
            }
            f = fIntValue;
            float f32 = i * f2;
            float f42 = this.f8385a;
            Paint paint42 = this.f4848a;
            f92.b(paint42);
            canvas.drawRoundRect(f32 + (0.05f * f2), f, f32 + (0.95f * f2), f42, 5.0f, 5.0f, paint42);
            i++;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8385a = i2;
    }
}
