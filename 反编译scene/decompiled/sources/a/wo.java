package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class wo extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yo f7807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3461a = false;

    public wo(yo yoVar) {
        this.f7807a = yoVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f3461a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f3461a) {
            this.f3461a = false;
            return;
        }
        if (((Float) this.f7807a.f3751a.getAnimatedValue()).floatValue() == 0.0f) {
            yo yoVar = this.f7807a;
            yoVar.o = 0;
            yoVar.z(0);
        } else {
            yo yoVar2 = this.f7807a;
            yoVar2.o = 2;
            yoVar2.w();
        }
    }
}
