package a;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class p10 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f7072a;

    public p10(q10 q10Var) {
        this.f7072a = q10Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        ((f20) this.f7072a).f837a.setScaleX(fFloatValue);
        ((f20) this.f7072a).f837a.setScaleY(fFloatValue);
    }
}
