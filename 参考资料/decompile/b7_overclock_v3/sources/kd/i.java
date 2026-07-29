package kd;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f37182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f37183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public TimeInterpolator f37184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37186e;

    public i(long j10, long j11) {
        this.f37184c = null;
        this.f37185d = 0;
        this.f37186e = 1;
        this.f37182a = j10;
        this.f37183b = j11;
    }

    @n0
    public static i b(@n0 ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f37185d = valueAnimator.getRepeatCount();
        iVar.f37186e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public static TimeInterpolator f(@n0 ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f37167b : interpolator instanceof AccelerateInterpolator ? a.f37168c : interpolator instanceof DecelerateInterpolator ? a.f37169d : interpolator;
    }

    public void a(@n0 Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f37182a;
    }

    public long d() {
        return this.f37183b;
    }

    @p0
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f37184c;
        return timeInterpolator != null ? timeInterpolator : a.f37167b;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f37185d;
    }

    public int h() {
        return this.f37186e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @n0
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j10, long j11, @n0 TimeInterpolator timeInterpolator) {
        this.f37185d = 0;
        this.f37186e = 1;
        this.f37182a = j10;
        this.f37183b = j11;
        this.f37184c = timeInterpolator;
    }
}
