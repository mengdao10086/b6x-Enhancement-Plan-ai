package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qo extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ro f7224a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ to f2587a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2589a;

    public qo(to toVar, ro roVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f2587a = toVar;
        this.f7224a = roVar;
        this.f2589a = viewPropertyAnimator;
        this.f2588a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2589a.setListener(null);
        this.f2588a.setAlpha(1.0f);
        this.f2588a.setTranslationX(0.0f);
        this.f2588a.setTranslationY(0.0f);
        this.f2587a.D(this.f7224a.f2766b, false);
        this.f2587a.l.remove(this.f7224a.f2766b);
        this.f2587a.W();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2587a.E(this.f7224a.f2766b, false);
    }
}
