package com.flydigi.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class WaterWaveView extends View {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f13553p = 25;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f13554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f13555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f13556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f13557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f13558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Interpolator f13560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f13561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f13562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f13563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Paint f13564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f13566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<a> f13567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f13568o;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f13569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f13570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13571c;

        public a() {
            a();
        }

        public void a() {
            this.f13569a = 0.0f;
            this.f13570b = WaterWaveView.this.f13557d;
            this.f13571c = WaterWaveView.this.f13559f;
        }

        public String toString() {
            return "Wave [radius=" + this.f13569a + ", width=" + this.f13570b + ", color=" + this.f13571c + "]";
        }
    }

    public WaterWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13560g = new CycleInterpolator(0.5f);
        Paint paint = new Paint();
        this.f13563j = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f13564k = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        this.f13565l = false;
        this.f13567n = new ArrayList();
        c();
    }

    public final void c() {
        e(60.0f, 2.0f, 1.0f, 5.0f, Color.parseColor("#0074ff"));
    }

    public void d() {
        this.f13567n.clear();
        postInvalidate();
    }

    public void e(float f10, float f11, float f12, float f13, int i10) {
        this.f13555b = f10;
        this.f13556c = f11;
        this.f13557d = f12;
        this.f13558e = f13;
        setWaveColor(i10);
        d();
    }

    public final void f() {
        a aVar = this.f13567n.isEmpty() ? null : this.f13567n.get(0);
        if (aVar == null || aVar.f13569a >= this.f13555b) {
            a aVar2 = this.f13568o;
            if (aVar2 != null) {
                this.f13568o = null;
                aVar2.a();
            } else {
                aVar2 = new a();
            }
            this.f13567n.add(0, aVar2);
        }
        float f10 = this.f13558e - this.f13557d;
        int size = this.f13567n.size();
        for (int i10 = 0; i10 < size; i10++) {
            a aVar3 = this.f13567n.get(i10);
            float f11 = aVar3.f13569a;
            float f12 = f11 / this.f13554a;
            if (f12 > 1.0f) {
                f12 = 1.0f;
            }
            aVar3.f13570b = this.f13557d + (f12 * f10);
            aVar3.f13569a = f11 + this.f13556c;
            aVar3.f13571c = (((int) (this.f13560g.getInterpolation(f12) * 255.0f)) << 24) | (this.f13559f & 16777215);
        }
        int i11 = size - 1;
        a aVar4 = this.f13567n.get(i11);
        if (aVar4.f13569a > this.f13554a + (aVar4.f13570b / 2.0f)) {
            this.f13567n.remove(i11);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f();
        for (a aVar : this.f13567n) {
            this.f13563j.setColor(aVar.f13571c);
            this.f13563j.setStrokeWidth(aVar.f13570b);
            canvas.drawCircle(this.f13561h, this.f13562i, aVar.f13569a, this.f13563j);
        }
        float f10 = this.f13566m;
        if (f10 > 0.0f) {
            canvas.drawCircle(this.f13561h, this.f13562i, f10, this.f13564k);
        }
        postInvalidateDelayed(25L);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        float fMin;
        super.onLayout(z10, i10, i11, i12, i13);
        this.f13561h = getWidth() / 2;
        float height = getHeight() / 2;
        this.f13562i = height;
        if (this.f13565l) {
            float f10 = this.f13561h;
            fMin = (float) Math.sqrt((f10 * f10) + (height * height));
        } else {
            fMin = Math.min(this.f13561h, height);
        }
        if (this.f13554a != fMin) {
            this.f13554a = fMin;
            d();
        }
    }

    public void setFillAllView(boolean z10) {
        this.f13565l = z10;
        d();
    }

    public void setFillWaveSourceShapeRadius(float f10) {
        this.f13566m = f10;
    }

    public void setWaveColor(int i10) {
        this.f13559f = i10;
        this.f13564k.setColor(i10);
    }

    public WaterWaveView(Context context) {
        super(context);
        this.f13560g = new CycleInterpolator(0.5f);
        Paint paint = new Paint();
        this.f13563j = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.f13564k = paint2;
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        this.f13565l = false;
        this.f13567n = new ArrayList();
        c();
    }
}
