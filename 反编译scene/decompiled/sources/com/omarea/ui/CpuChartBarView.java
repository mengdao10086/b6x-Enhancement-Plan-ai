package com.omarea.ui;

import a.d52;
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
public final class CpuChartBarView extends q31 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedBlockingQueue<Integer> f4853a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4854b;
    public int c;
    public int d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuChartBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4851a = 5;
        this.f4854b = 35;
        this.c = 255;
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>();
        int i = this.f4851a;
        for (int i2 = 0; i2 < i; i2++) {
            linkedBlockingQueue.add(0);
        }
        m42 m42Var = m42.f6769a;
        this.f4853a = linkedBlockingQueue;
        this.d = 579373192;
        getColorAccent();
    }

    private final void getColorAccent() {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent});
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttributes(attrsArray)");
        this.d = typedArrayObtainStyledAttributes.getColor(0, -16777216);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(float f, float f2) throws InterruptedException {
        if (f2 == f && f == 0.0f) {
            this.f4853a.put(0);
        } else {
            this.f4853a.put(Integer.valueOf(100 - ((int) ((((double) f2) * 100.0d) / ((double) f)))));
        }
        if (this.f4853a.size() > this.f4851a) {
            this.f4853a.poll();
        }
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float fIntValue;
        float f;
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        if (this.f4852a == null) {
            Paint paint = new Paint();
            this.f4852a = paint;
            f92.b(paint);
            paint.setAntiAlias(true);
            Paint paint2 = this.f4852a;
            f92.b(paint2);
            paint2.setStyle(Paint.Style.FILL);
            this.b = getWidth() / this.f4851a;
            Paint paint3 = this.f4852a;
            f92.b(paint3);
            paint3.setStrokeWidth(0.0f);
        }
        float f2 = this.b;
        int i = 0;
        for (Integer num : this.f4853a) {
            Paint paint4 = this.f4852a;
            f92.b(paint4);
            paint4.setColor(num.intValue() > 85 ? getVeryHigh() : num.intValue() > 65 ? getHigh() : this.d);
            Paint paint5 = this.f4852a;
            if (paint5 != null) {
                paint5.setAlpha(Math.min(this.f4854b + ((int) (((num.intValue() / 100.0f) / 2) * 255)), this.c));
            }
            if (num.intValue() <= 5) {
                float f3 = this.f8386a;
                fIntValue = f3 - (f3 / 20);
            } else if (num.intValue() >= 98) {
                f = 0.0f;
                float f4 = i * f2;
                float f5 = this.f8386a;
                Paint paint6 = this.f4852a;
                f92.b(paint6);
                canvas.drawRoundRect(f4 + (0.05f * f2), f, f4 + (0.95f * f2), f5, 5.0f, 5.0f, paint6);
                i++;
            } else {
                f92.c(num, "ratio");
                fIntValue = ((100 - num.intValue()) * this.f8386a) / 100;
            }
            f = fIntValue;
            float f42 = i * f2;
            float f52 = this.f8386a;
            Paint paint62 = this.f4852a;
            f92.b(paint62);
            canvas.drawRoundRect(f42 + (0.05f * f2), f, f42 + (0.95f * f2), f52, 5.0f, 5.0f, paint62);
            i++;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8386a = i2;
    }

    public final void setAccentColor(int i) {
        this.d = i;
    }

    public final void setData(Integer[] numArr) {
        f92.d(numArr, "data");
        this.f4851a = numArr.length;
        this.f4853a.clear();
        d52.p(this.f4853a, numArr);
        invalidate();
    }

    public final void setMaxAlpha(int i) {
        this.c = i;
    }

    public final void setMaxHistory(int i) {
        this.f4851a = i;
        while (this.f4853a.size() < i) {
            this.f4853a.put(0);
        }
        while (this.f4853a.size() > i) {
            this.f4853a.poll();
        }
        this.b = getWidth() / i;
    }

    public final void setMinAlpha(int i) {
        this.f4854b = i;
    }
}
