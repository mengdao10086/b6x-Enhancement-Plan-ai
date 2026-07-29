package jl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a extends View implements il.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<kl.a> f36436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f36437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f36438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f36440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f36441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f36442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36443h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f36444i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Path f36445j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List<Integer> f36446k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Interpolator f36447l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Interpolator f36448m;

    public a(Context context) {
        super(context);
        this.f36445j = new Path();
        this.f36447l = new AccelerateInterpolator();
        this.f36448m = new DecelerateInterpolator();
        c(context);
    }

    @Override // il.c
    public void a(List<kl.a> list) {
        this.f36436a = list;
    }

    public final void b(Canvas canvas) {
        this.f36445j.reset();
        float height = (getHeight() - this.f36441f) - this.f36442g;
        this.f36445j.moveTo(this.f36440e, height);
        this.f36445j.lineTo(this.f36440e, height - this.f36439d);
        Path path = this.f36445j;
        float f10 = this.f36440e;
        float f11 = this.f36438c;
        path.quadTo(f10 + ((f11 - f10) / 2.0f), height, f11, height - this.f36437b);
        this.f36445j.lineTo(this.f36438c, this.f36437b + height);
        Path path2 = this.f36445j;
        float f12 = this.f36440e;
        path2.quadTo(((this.f36438c - f12) / 2.0f) + f12, height, f12, this.f36439d + height);
        this.f36445j.close();
        canvas.drawPath(this.f36445j, this.f36444i);
    }

    public final void c(Context context) {
        Paint paint = new Paint(1);
        this.f36444i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36442g = fl.b.a(context, 3.5d);
        this.f36443h = fl.b.a(context, 2.0d);
        this.f36441f = fl.b.a(context, 1.5d);
    }

    public float getMaxCircleRadius() {
        return this.f36442g;
    }

    public float getMinCircleRadius() {
        return this.f36443h;
    }

    public float getYOffset() {
        return this.f36441f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f36438c, (getHeight() - this.f36441f) - this.f36442g, this.f36437b, this.f36444i);
        canvas.drawCircle(this.f36440e, (getHeight() - this.f36441f) - this.f36442g, this.f36439d, this.f36444i);
        b(canvas);
    }

    @Override // il.c
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // il.c
    public void onPageScrolled(int i10, float f10, int i11) {
        List<kl.a> list = this.f36436a;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f36446k;
        if (list2 != null && list2.size() > 0) {
            this.f36444i.setColor(fl.a.a(f10, this.f36446k.get(Math.abs(i10) % this.f36446k.size()).intValue(), this.f36446k.get(Math.abs(i10 + 1) % this.f36446k.size()).intValue()));
        }
        kl.a aVarH = dl.b.h(this.f36436a, i10);
        kl.a aVarH2 = dl.b.h(this.f36436a, i10 + 1);
        int i12 = aVarH.f37414a;
        float f11 = i12 + ((aVarH.f37416c - i12) / 2);
        int i13 = aVarH2.f37414a;
        float f12 = (i13 + ((aVarH2.f37416c - i13) / 2)) - f11;
        this.f36438c = (this.f36447l.getInterpolation(f10) * f12) + f11;
        this.f36440e = f11 + (f12 * this.f36448m.getInterpolation(f10));
        float f13 = this.f36442g;
        this.f36437b = f13 + ((this.f36443h - f13) * this.f36448m.getInterpolation(f10));
        float f14 = this.f36443h;
        this.f36439d = f14 + ((this.f36442g - f14) * this.f36447l.getInterpolation(f10));
        invalidate();
    }

    @Override // il.c
    public void onPageSelected(int i10) {
    }

    public void setColors(Integer... numArr) {
        this.f36446k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f36448m = interpolator;
        if (interpolator == null) {
            this.f36448m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f10) {
        this.f36442g = f10;
    }

    public void setMinCircleRadius(float f10) {
        this.f36443h = f10;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f36447l = interpolator;
        if (interpolator == null) {
            this.f36447l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f10) {
        this.f36441f = f10;
    }
}
