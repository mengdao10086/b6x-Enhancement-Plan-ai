package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class po extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ro f7133a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ to f2442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2444a;

    public po(to toVar, ro roVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2442a = toVar;
        this.f7133a = roVar;
        this.f2444a = viewPropertyAnimator;
        this.f2443a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2444a.setListener(null);
        this.f2443a.setAlpha(1.0f);
        this.f2443a.setTranslationX(0.0f);
        this.f2443a.setTranslationY(0.0f);
        this.f2442a.D(this.f7133a.f2765a, true);
        this.f2442a.l.remove(this.f7133a.f2765a);
        this.f2442a.W();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2442a.E(this.f7133a.f2765a, true);
    }
}
