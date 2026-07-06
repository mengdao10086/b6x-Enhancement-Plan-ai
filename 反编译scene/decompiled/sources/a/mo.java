package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class mo extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ to f6827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f1964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RecyclerView.d0 f1965a;

    public mo(to toVar, RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f6827a = toVar;
        this.f1965a = d0Var;
        this.f1964a = viewPropertyAnimator;
        this.f1963a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1964a.setListener(null);
        this.f1963a.setAlpha(1.0f);
        this.f6827a.H(this.f1965a);
        this.f6827a.k.remove(this.f1965a);
        this.f6827a.W();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f6827a.I(this.f1965a);
    }
}
