package com.omarea.common.ui;

import a.b30;
import a.f92;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ProgressCircle extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f4803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f4804a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f4805b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Paint f4806b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4807c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Paint f4808c;
    public final int d;
    public int e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f8357a = 300.0f;
        this.b = 10.0f;
        this.f4807c = 20;
        this.d = -7829368;
        this.c = 35.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b30.ProgressState);
        f92.c(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….styleable.ProgressState)");
        this.f4803a = (int) ((((double) typedArrayObtainStyledAttributes.getInteger(b30.ProgressState_current, 1)) * 100.0d) / ((double) typedArrayObtainStyledAttributes.getInteger(b30.ProgressState_total, 1)));
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            android.graphics.Paint r1 = r0.f4804a
            a.f92.b(r1)
            r2 = 579373192(0x22888888, float:3.700743E-18)
            r1.setColor(r2)
            android.graphics.RectF r4 = new android.graphics.RectF
            float r1 = r0.f8357a
            r2 = 0
            r4.<init>(r2, r2, r1, r1)
            android.graphics.Paint r8 = r0.f4804a
            a.f92.b(r8)
            r5 = 0
            r6 = 1135869952(0x43b40000, float:360.0)
            r7 = 0
            r3 = r17
            r3.drawArc(r4, r5, r6, r7, r8)
            float r1 = r0.c
            r3 = 48
            float r3 = (float) r3
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L48
            int r3 = r0.f4805b
            r4 = 11
            if (r3 >= r4) goto L33
            goto L48
        L33:
            r3 = 44
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L40
            int r1 = r0.f4803a
            r3 = 16
            if (r1 >= r3) goto L59
        L40:
            android.graphics.Paint r1 = r0.f4804a
            a.f92.b(r1)
            r3 = -65536(0xffffffffffff0000, float:NaN)
            goto L56
        L48:
            android.graphics.Paint r1 = r0.f4804a
            a.f92.b(r1)
            r3 = 255(0xff, float:3.57E-43)
            r4 = 15
            r5 = 0
            int r3 = android.graphics.Color.rgb(r3, r4, r5)
        L56:
            r1.setColor(r3)
        L59:
            android.graphics.Paint r1 = r0.f4804a
            a.f92.b(r1)
            android.graphics.Paint$Cap r3 = android.graphics.Paint.Cap.ROUND
            r1.setStrokeCap(r3)
            int r1 = r0.f4803a
            r3 = 1
            if (r1 >= r3) goto L6e
            int r1 = r0.f4805b
            r3 = 2
            if (r1 > r3) goto L6e
            return
        L6e:
            int r1 = r0.f4805b
            r3 = 98
            if (r1 < r3) goto L8b
            android.graphics.RectF r5 = new android.graphics.RectF
            float r1 = r0.f8357a
            r5.<init>(r2, r2, r1, r1)
            r6 = -1028390912(0xffffffffc2b40000, float:-90.0)
            r7 = 1135869952(0x43b40000, float:360.0)
            r8 = 0
            android.graphics.Paint r9 = r0.f4804a
            a.f92.b(r9)
            r4 = r17
            r4.drawArc(r5, r6, r7, r8, r9)
            goto La7
        L8b:
            android.graphics.RectF r11 = new android.graphics.RectF
            float r1 = r0.f8357a
            r11.<init>(r2, r2, r1, r1)
            r12 = -1028390912(0xffffffffc2b40000, float:-90.0)
            int r1 = r0.f4805b
            float r1 = (float) r1
            r2 = 1080452710(0x40666666, float:3.6)
            float r13 = r1 * r2
            r14 = 0
            android.graphics.Paint r15 = r0.f4804a
            a.f92.b(r15)
            r10 = r17
            r10.drawArc(r11, r12, r13, r14, r15)
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.common.ui.ProgressCircle.b(android.graphics.Canvas):void");
    }

    public final void c() {
        Paint paint = new Paint();
        this.f4804a = paint;
        f92.b(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.f4804a;
        f92.b(paint2);
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint3 = this.f4804a;
        f92.b(paint3);
        paint3.setStrokeWidth(this.b);
        Paint paint4 = new Paint();
        this.f4806b = paint4;
        f92.b(paint4);
        paint4.setAntiAlias(true);
        Paint paint5 = this.f4806b;
        f92.b(paint5);
        paint5.setColor(this.d);
        Paint paint6 = this.f4806b;
        f92.b(paint6);
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.f4806b;
        f92.b(paint7);
        paint7.setStrokeWidth(1.0f);
        Paint paint8 = this.f4806b;
        f92.b(paint8);
        paint8.setTextSize(this.f4807c);
        Paint paint9 = new Paint();
        this.f4808c = paint9;
        f92.b(paint9);
        paint9.setAntiAlias(true);
        Paint paint10 = this.f4808c;
        f92.b(paint10);
        paint10.setStyle(Paint.Style.FILL);
        Paint paint11 = this.f4808c;
        f92.b(paint11);
        paint11.setStrokeWidth(20.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        float f = this.f / 2;
        float f2 = this.f8357a;
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
        this.b = a(context, 10.0f);
        Context context2 = getContext();
        f92.c(context2, "context");
        this.f4807c = a(context2, 18.0f);
        this.f8357a = (int) (((i > i2 ? i2 : i) * 0.9d) - ((double) r5));
    }
}
