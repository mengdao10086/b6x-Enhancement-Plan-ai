package a;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o10 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6969a;

    public o10(q10 q10Var) {
        this.f6969a = q10Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((f20) this.f6969a).f837a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
