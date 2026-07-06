package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vr extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ as f7718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ba f3299a;

    public vr(as asVar, ba baVar) {
        this.f7718a = asVar;
        this.f3299a = baVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f3299a.remove(animator);
        this.f7718a.n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f7718a.n.add(animator);
    }
}
