package jl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class b extends View implements il.c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f36449m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36450n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36451o = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Interpolator f36453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f36454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f36456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f36457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f36458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f36460i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<kl.a> f36461j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Integer> f36462k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RectF f36463l;

    public b(Context context) {
        super(context);
        this.f36453b = new LinearInterpolator();
        this.f36454c = new LinearInterpolator();
        this.f36463l = new RectF();
        b(context);
    }

    @Override // il.c
    public void a(List<kl.a> list) {
        this.f36461j = list;
    }

    public final void b(Context context) {
        Paint paint = new Paint(1);
        this.f36460i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36456e = fl.b.a(context, 3.0d);
        this.f36458g = fl.b.a(context, 10.0d);
    }

    public List<Integer> getColors() {
        return this.f36462k;
    }

    public Interpolator getEndInterpolator() {
        return this.f36454c;
    }

    public float getLineHeight() {
        return this.f36456e;
    }

    public float getLineWidth() {
        return this.f36458g;
    }

    public int getMode() {
        return this.f36452a;
    }

    public Paint getPaint() {
        return this.f36460i;
    }

    public float getRoundRadius() {
        return this.f36459h;
    }

    public Interpolator getStartInterpolator() {
        return this.f36453b;
    }

    public float getXOffset() {
        return this.f36457f;
    }

    public float getYOffset() {
        return this.f36455d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f36463l;
        float f10 = this.f36459h;
        canvas.drawRoundRect(rectF, f10, f10, this.f36460i);
    }

    @Override // il.c
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // il.c
    public void onPageScrolled(int i10, float f10, int i11) {
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int i12;
        List<kl.a> list = this.f36461j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f36462k;
        if (list2 != null && list2.size() > 0) {
            this.f36460i.setColor(fl.a.a(f10, this.f36462k.get(Math.abs(i10) % this.f36462k.size()).intValue(), this.f36462k.get(Math.abs(i10 + 1) % this.f36462k.size()).intValue()));
        }
        kl.a aVarH = dl.b.h(this.f36461j, i10);
        kl.a aVarH2 = dl.b.h(this.f36461j, i10 + 1);
        int i13 = this.f36452a;
        if (i13 == 0) {
            float f16 = aVarH.f37414a;
            f15 = this.f36457f;
            f11 = f16 + f15;
            f14 = aVarH2.f37414a + f15;
            f12 = aVarH.f37416c - f15;
            i12 = aVarH2.f37416c;
        } else {
            if (i13 != 1) {
                f11 = aVarH.f37414a + ((aVarH.f() - this.f36458g) / 2.0f);
                float f17 = aVarH2.f37414a + ((aVarH2.f() - this.f36458g) / 2.0f);
                f12 = ((aVarH.f() + this.f36458g) / 2.0f) + aVarH.f37414a;
                f13 = ((aVarH2.f() + this.f36458g) / 2.0f) + aVarH2.f37414a;
                f14 = f17;
                this.f36463l.left = f11 + ((f14 - f11) * this.f36453b.getInterpolation(f10));
                this.f36463l.right = f12 + ((f13 - f12) * this.f36454c.getInterpolation(f10));
                this.f36463l.top = (getHeight() - this.f36456e) - this.f36455d;
                this.f36463l.bottom = getHeight() - this.f36455d;
                invalidate();
            }
            float f18 = aVarH.f37418e;
            f15 = this.f36457f;
            f11 = f18 + f15;
            f14 = aVarH2.f37418e + f15;
            f12 = aVarH.f37420g - f15;
            i12 = aVarH2.f37420g;
        }
        f13 = i12 - f15;
        this.f36463l.left = f11 + ((f14 - f11) * this.f36453b.getInterpolation(f10));
        this.f36463l.right = f12 + ((f13 - f12) * this.f36454c.getInterpolation(f10));
        this.f36463l.top = (getHeight() - this.f36456e) - this.f36455d;
        this.f36463l.bottom = getHeight() - this.f36455d;
        invalidate();
    }

    @Override // il.c
    public void onPageSelected(int i10) {
    }

    public void setColors(Integer... numArr) {
        this.f36462k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f36454c = interpolator;
        if (interpolator == null) {
            this.f36454c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f10) {
        this.f36456e = f10;
    }

    public void setLineWidth(float f10) {
        this.f36458g = f10;
    }

    public void setMode(int i10) {
        if (i10 == 2 || i10 == 0 || i10 == 1) {
            this.f36452a = i10;
            return;
        }
        throw new IllegalArgumentException("mode " + i10 + " not supported.");
    }

    public void setRoundRadius(float f10) {
        this.f36459h = f10;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f36453b = interpolator;
        if (interpolator == null) {
            this.f36453b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f10) {
        this.f36457f = f10;
    }

    public void setYOffset(float f10) {
        this.f36455d = f10;
    }
}
