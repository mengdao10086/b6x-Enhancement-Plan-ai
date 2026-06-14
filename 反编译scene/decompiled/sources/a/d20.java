package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class d20 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f5851a;

    public d20(e20 e20Var) {
        this.f5851a = e20Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        e20 e20Var = this.f5851a;
        ((f20) e20Var).f837a.setChecked(e20Var.f650b);
        this.f5851a.b.start();
    }
}
