package a;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xo implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yo f7908a;

    public xo(yo yoVar) {
        this.f7908a = yoVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.f7908a.f3753a.setAlpha(iFloatValue);
        this.f7908a.f3752a.setAlpha(iFloatValue);
        this.f7908a.w();
    }
}
