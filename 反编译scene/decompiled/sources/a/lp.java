package a;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class lp implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mp f6728a;

    public lp(mp mpVar) {
        this.f6728a = mpVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6728a.c(valueAnimator.getAnimatedFraction());
    }
}
