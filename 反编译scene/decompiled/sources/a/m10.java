package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m10 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6758a;

    public m10(q10 q10Var) {
        this.f6758a = q10Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        ((f20) this.f6758a).f838a.setEndIconVisible(true);
    }
}
