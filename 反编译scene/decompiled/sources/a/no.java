package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class no extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ to f6936a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewPropertyAnimator f2126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RecyclerView.d0 f2127a;

    public no(to toVar, RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f6936a = toVar;
        this.f2127a = d0Var;
        this.f2125a = view;
        this.f2126a = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f2125a.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2126a.setListener(null);
        this.f6936a.B(this.f2127a);
        this.f6936a.i.remove(this.f2127a);
        this.f6936a.W();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f6936a.C(this.f2127a);
    }
}
