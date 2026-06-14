package com.google.android.material.behavior;

import a.kv;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8280a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewPropertyAnimator f4559a;
    public int b;
    public int c;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f4559a = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f8280a = 0;
        this.b = 2;
        this.c = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8280a = 0;
        this.b = 2;
        this.c = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public final void F(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.f4559a = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new a());
    }

    public void G(V v) {
        if (this.b == 1) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4559a;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 1;
        F(v, this.f8280a + this.c, 175L, kv.c);
    }

    public void H(V v) {
        if (this.b == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f4559a;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v.clearAnimation();
        }
        this.b = 2;
        F(v, 0, 225L, kv.d);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.f8280a = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            G(v);
        } else if (i2 < 0) {
            H(v);
        }
    }
}
