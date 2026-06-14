package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class oo extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ to f2274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2275a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RecyclerView.d0 f2277a;
    public final /* synthetic */ int b;

    public oo(to toVar, RecyclerView.d0 d0Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f2274a = toVar;
        this.f2277a = d0Var;
        this.f7041a = i;
        this.f2275a = view;
        this.b = i2;
        this.f2276a = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.f7041a != 0) {
            this.f2275a.setTranslationX(0.0f);
        }
        if (this.b != 0) {
            this.f2275a.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2276a.setListener(null);
        this.f2274a.F(this.f2277a);
        this.f2274a.j.remove(this.f2277a);
        this.f2274a.W();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2274a.G(this.f2277a);
    }
}
