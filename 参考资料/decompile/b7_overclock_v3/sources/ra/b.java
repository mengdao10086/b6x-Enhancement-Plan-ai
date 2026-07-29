package ra;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import w.w;
import xa.i;
import xa.l;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"NewApi"})
public abstract class b extends e implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ObjectAnimator f47885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f47886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f47887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f47888l;

    public b(l lVar, float f10, float f11, i iVar, View view, float f12, float f13, long j10) {
        super(lVar, f10, f11, iVar, view);
        this.f47887k = f12;
        this.f47888l = f13;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, w.c.S, 0.0f, 1.0f);
        this.f47885i = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(j10);
        this.f47885i.addUpdateListener(this);
        this.f47885i.addListener(this);
    }

    public float d() {
        return this.f47886j;
    }

    public float e() {
        return this.f47887k;
    }

    public float f() {
        return this.f47888l;
    }

    public abstract void g();

    public void h() {
        this.f47885i.removeAllListeners();
        this.f47885i.removeAllUpdateListeners();
        this.f47885i.reverse();
        this.f47885i.addUpdateListener(this);
        this.f47885i.addListener(this);
    }

    public void i(float f10) {
        this.f47886j = f10;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        try {
            g();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        try {
            g();
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }

    @Override // java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        this.f47885i.start();
    }
}
