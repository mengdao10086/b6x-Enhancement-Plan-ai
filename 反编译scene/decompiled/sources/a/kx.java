package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kx extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f6650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ix f1693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1694a;
    public float b;

    public kx(ix ixVar) {
        this.f1693a = ixVar;
    }

    public /* synthetic */ kx(ix ixVar, ax axVar) {
        this(ixVar);
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1693a.d0((int) this.b);
        this.f1694a = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.f1694a) {
            iz izVar = this.f1693a.f1418a;
            this.f6650a = izVar == null ? 0.0f : izVar.w();
            this.b = a();
            this.f1694a = true;
        }
        ix ixVar = this.f1693a;
        float f = this.f6650a;
        ixVar.d0((int) (f + ((this.b - f) * valueAnimator.getAnimatedFraction())));
    }
}
