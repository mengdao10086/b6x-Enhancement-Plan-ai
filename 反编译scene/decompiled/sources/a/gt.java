package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gt extends AnimatorListenerAdapter implements zr, qq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6240a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f1059a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ViewGroup f1060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1061a;
    public boolean b;
    public boolean c = false;

    public gt(View view, int i, boolean z) {
        this.f1059a = view;
        this.f6240a = i;
        this.f1060a = (ViewGroup) view.getParent();
        this.f1061a = z;
        g(true);
    }

    @Override // a.zr
    public void a(as asVar) {
        g(false);
    }

    @Override // a.zr
    public void b(as asVar) {
        g(true);
    }

    @Override // a.zr
    public void c(as asVar) {
    }

    @Override // a.zr
    public void d(as asVar) {
    }

    @Override // a.zr
    public void e(as asVar) {
        f();
        asVar.P(this);
    }

    public final void f() {
        if (!this.c) {
            ys.h(this.f1059a, this.f6240a);
            ViewGroup viewGroup = this.f1060a;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }

    public final void g(boolean z) {
        ViewGroup viewGroup;
        if (!this.f1061a || this.b == z || (viewGroup = this.f1060a) == null) {
            return;
        }
        this.b = z;
        ps.c(viewGroup, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.c = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        f();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.qq
    public void onAnimationPause(Animator animator) {
        if (this.c) {
            return;
        }
        ys.h(this.f1059a, this.f6240a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.qq
    public void onAnimationResume(Animator animator) {
        if (this.c) {
            return;
        }
        ys.h(this.f1059a, 0);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
