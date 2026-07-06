package a;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u10 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f7554a;

    public u10(e20 e20Var) {
        this.f7554a = e20Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        ((f20) this.f7554a).f837a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
