package jl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class d extends View implements il.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<kl.a> f36470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f36471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f36474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36475f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f36476g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f36477h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Path f36478i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Interpolator f36479j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f36480k;

    public d(Context context) {
        super(context);
        this.f36478i = new Path();
        this.f36479j = new LinearInterpolator();
        b(context);
    }

    @Override // il.c
    public void a(List<kl.a> list) {
        this.f36470a = list;
    }

    public final void b(Context context) {
        Paint paint = new Paint(1);
        this.f36471b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36472c = fl.b.a(context, 3.0d);
        this.f36475f = fl.b.a(context, 14.0d);
        this.f36474e = fl.b.a(context, 8.0d);
    }

    public boolean c() {
        return this.f36476g;
    }

    public int getLineColor() {
        return this.f36473d;
    }

    public int getLineHeight() {
        return this.f36472c;
    }

    public Interpolator getStartInterpolator() {
        return this.f36479j;
    }

    public int getTriangleHeight() {
        return this.f36474e;
    }

    public int getTriangleWidth() {
        return this.f36475f;
    }

    public float getYOffset() {
        return this.f36477h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f36471b.setColor(this.f36473d);
        if (this.f36476g) {
            canvas.drawRect(0.0f, (getHeight() - this.f36477h) - this.f36474e, getWidth(), ((getHeight() - this.f36477h) - this.f36474e) + this.f36472c, this.f36471b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.f36472c) - this.f36477h, getWidth(), getHeight() - this.f36477h, this.f36471b);
        }
        this.f36478i.reset();
        if (this.f36476g) {
            this.f36478i.moveTo(this.f36480k - (this.f36475f / 2), (getHeight() - this.f36477h) - this.f36474e);
            this.f36478i.lineTo(this.f36480k, getHeight() - this.f36477h);
            this.f36478i.lineTo(this.f36480k + (this.f36475f / 2), (getHeight() - this.f36477h) - this.f36474e);
        } else {
            this.f36478i.moveTo(this.f36480k - (this.f36475f / 2), getHeight() - this.f36477h);
            this.f36478i.lineTo(this.f36480k, (getHeight() - this.f36474e) - this.f36477h);
            this.f36478i.lineTo(this.f36480k + (this.f36475f / 2), getHeight() - this.f36477h);
        }
        this.f36478i.close();
        canvas.drawPath(this.f36478i, this.f36471b);
    }

    @Override // il.c
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // il.c
    public void onPageScrolled(int i10, float f10, int i11) {
        List<kl.a> list = this.f36470a;
        if (list == null || list.isEmpty()) {
            return;
        }
        kl.a aVarH = dl.b.h(this.f36470a, i10);
        kl.a aVarH2 = dl.b.h(this.f36470a, i10 + 1);
        int i12 = aVarH.f37414a;
        float f11 = i12 + ((aVarH.f37416c - i12) / 2);
        int i13 = aVarH2.f37414a;
        this.f36480k = f11 + (((i13 + ((aVarH2.f37416c - i13) / 2)) - f11) * this.f36479j.getInterpolation(f10));
        invalidate();
    }

    @Override // il.c
    public void onPageSelected(int i10) {
    }

    public void setLineColor(int i10) {
        this.f36473d = i10;
    }

    public void setLineHeight(int i10) {
        this.f36472c = i10;
    }

    public void setReverse(boolean z10) {
        this.f36476g = z10;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f36479j = interpolator;
        if (interpolator == null) {
            this.f36479j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i10) {
        this.f36474e = i10;
    }

    public void setTriangleWidth(int i10) {
        this.f36475f = i10;
    }

    public void setYOffset(float f10) {
        this.f36477h = f10;
    }
}
