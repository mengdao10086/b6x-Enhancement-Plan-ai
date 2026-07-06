package a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f2612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TimeInterpolator f2613a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2614b;

    public qv(long j, long j2) {
        this.f2612a = 0L;
        this.f2614b = 300L;
        this.f2613a = null;
        this.f7242a = 0;
        this.b = 1;
        this.f2612a = j;
        this.f2614b = j2;
    }

    public qv(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f2612a = 0L;
        this.f2614b = 300L;
        this.f2613a = null;
        this.f7242a = 0;
        this.b = 1;
        this.f2612a = j;
        this.f2614b = j2;
        this.f2613a = timeInterpolator;
    }

    public static qv b(ValueAnimator valueAnimator) {
        qv qvVar = new qv(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        qvVar.f7242a = valueAnimator.getRepeatCount();
        qvVar.b = valueAnimator.getRepeatMode();
        return qvVar;
    }

    public static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? kv.b : interpolator instanceof AccelerateInterpolator ? kv.c : interpolator instanceof DecelerateInterpolator ? kv.d : interpolator;
    }

    public void a(Animator animator) {
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
        return this.f2612a;
    }

    public long d() {
        return this.f2614b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f2613a;
        return timeInterpolator != null ? timeInterpolator : kv.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qv)) {
            return false;
        }
        qv qvVar = (qv) obj;
        if (c() == qvVar.c() && d() == qvVar.d() && g() == qvVar.g() && h() == qvVar.h()) {
            return e().getClass().equals(qvVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f7242a;
    }

    public int h() {
        return this.b;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + qv.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }
}
