package rg;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
public class e extends d implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f48777e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48774b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f48775c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f48776d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f48778f = new Path();

    public e() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(30, 3600);
        this.f48777e = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(10000L);
        this.f48777e.setInterpolator(null);
        this.f48777e.setRepeatCount(-1);
        this.f48777e.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@n0 Canvas canvas) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        float f10 = iWidth;
        float fMax = Math.max(1.0f, f10 / 22.0f);
        if (this.f48774b != iWidth || this.f48775c != iHeight) {
            this.f48778f.reset();
            float f11 = f10 - fMax;
            float f12 = iHeight / 2.0f;
            this.f48778f.addCircle(f11, f12, fMax, Path.Direction.CW);
            float f13 = f10 - (5.0f * fMax);
            this.f48778f.addRect(f13, f12 - fMax, f11, f12 + fMax, Path.Direction.CW);
            this.f48778f.addCircle(f13, f12, fMax, Path.Direction.CW);
            this.f48774b = iWidth;
            this.f48775c = iHeight;
        }
        canvas.save();
        float f14 = f10 / 2.0f;
        float f15 = iHeight / 2.0f;
        canvas.rotate(this.f48776d, f14, f15);
        for (int i10 = 0; i10 < 12; i10++) {
            this.f48773a.setAlpha((i10 + 5) * 17);
            canvas.rotate(30.0f, f14, f15);
            canvas.drawPath(this.f48778f, this.f48773a);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f48777e.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f48776d = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f48777e.isRunning()) {
            return;
        }
        this.f48777e.addUpdateListener(this);
        this.f48777e.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f48777e.isRunning()) {
            this.f48777e.removeAllListeners();
            this.f48777e.removeAllUpdateListeners();
            this.f48777e.cancel();
        }
    }
}
