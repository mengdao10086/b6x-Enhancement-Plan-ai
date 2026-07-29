package jl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class e extends View implements il.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f36481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Interpolator f36485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Interpolator f36486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<kl.a> f36487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f36488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f36489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f36490j;

    public e(Context context) {
        super(context);
        this.f36485e = new LinearInterpolator();
        this.f36486f = new LinearInterpolator();
        this.f36489i = new RectF();
        b(context);
    }

    @Override // il.c
    public void a(List<kl.a> list) {
        this.f36487g = list;
    }

    public final void b(Context context) {
        Paint paint = new Paint(1);
        this.f36488h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f36481a = fl.b.a(context, 6.0d);
        this.f36482b = fl.b.a(context, 10.0d);
    }

    public Interpolator getEndInterpolator() {
        return this.f36486f;
    }

    public int getFillColor() {
        return this.f36483c;
    }

    public int getHorizontalPadding() {
        return this.f36482b;
    }

    public Paint getPaint() {
        return this.f36488h;
    }

    public float getRoundRadius() {
        return this.f36484d;
    }

    public Interpolator getStartInterpolator() {
        return this.f36485e;
    }

    public int getVerticalPadding() {
        return this.f36481a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f36488h.setColor(this.f36483c);
        RectF rectF = this.f36489i;
        float f10 = this.f36484d;
        canvas.drawRoundRect(rectF, f10, f10, this.f36488h);
    }

    @Override // il.c
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // il.c
    public void onPageScrolled(int i10, float f10, int i11) {
        List<kl.a> list = this.f36487g;
        if (list == null || list.isEmpty()) {
            return;
        }
        kl.a aVarH = dl.b.h(this.f36487g, i10);
        kl.a aVarH2 = dl.b.h(this.f36487g, i10 + 1);
        RectF rectF = this.f36489i;
        int i12 = aVarH.f37418e;
        rectF.left = (i12 - this.f36482b) + ((aVarH2.f37418e - i12) * this.f36486f.getInterpolation(f10));
        RectF rectF2 = this.f36489i;
        rectF2.top = aVarH.f37419f - this.f36481a;
        int i13 = aVarH.f37420g;
        rectF2.right = this.f36482b + i13 + ((aVarH2.f37420g - i13) * this.f36485e.getInterpolation(f10));
        RectF rectF3 = this.f36489i;
        rectF3.bottom = aVarH.f37421h + this.f36481a;
        if (!this.f36490j) {
            this.f36484d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // il.c
    public void onPageSelected(int i10) {
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f36486f = interpolator;
        if (interpolator == null) {
            this.f36486f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i10) {
        this.f36483c = i10;
    }

    public void setHorizontalPadding(int i10) {
        this.f36482b = i10;
    }

    public void setRoundRadius(float f10) {
        this.f36484d = f10;
        this.f36490j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f36485e = interpolator;
        if (interpolator == null) {
            this.f36485e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i10) {
        this.f36481a = i10;
    }
}
