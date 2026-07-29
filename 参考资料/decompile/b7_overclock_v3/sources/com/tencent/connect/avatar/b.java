package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Rect f22489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f22490b;

    public b(Context context) {
        super(context);
        b();
    }

    private void b() {
        this.f22490b = new Paint();
    }

    public Rect a() {
        if (this.f22489a == null) {
            this.f22489a = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int iMin = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i10 = (measuredWidth - iMin) / 2;
            int i11 = (measuredHeight - iMin) / 2;
            this.f22489a.set(i10, i11, i10 + iMin, iMin + i11);
        }
        return this.f22489a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rectA = a();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f22490b.setStyle(Paint.Style.FILL);
        this.f22490b.setColor(Color.argb(100, 0, 0, 0));
        float f10 = measuredWidth;
        canvas.drawRect(0.0f, 0.0f, f10, rectA.top, this.f22490b);
        canvas.drawRect(0.0f, rectA.bottom, f10, measuredHeight, this.f22490b);
        canvas.drawRect(0.0f, rectA.top, rectA.left, rectA.bottom, this.f22490b);
        canvas.drawRect(rectA.right, rectA.top, f10, rectA.bottom, this.f22490b);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.f22490b.setStyle(Paint.Style.STROKE);
        this.f22490b.setColor(-1);
        canvas.drawRect(rectA.left, rectA.top, rectA.right - 1, rectA.bottom, this.f22490b);
    }
}
