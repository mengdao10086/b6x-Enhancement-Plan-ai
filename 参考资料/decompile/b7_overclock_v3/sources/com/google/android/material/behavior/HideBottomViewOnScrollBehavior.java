package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import g.n0;
import g.p0;
import g.r;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes3.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19615f = 225;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19616g = 175;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19617h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f19618i = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final LinkedHashSet<b> f19619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c
    public int f19621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public ViewPropertyAnimator f19623e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f19623e = null;
        }
    }

    public interface b {
        void a(@n0 View view, @c int i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface c {
    }

    public HideBottomViewOnScrollBehavior() {
        this.f19619a = new LinkedHashSet<>();
        this.f19620b = 0;
        this.f19621c = 2;
        this.f19622d = 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean B(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, @n0 View view2, int i10, int i11) {
        return i10 == 2;
    }

    public void H(@n0 b bVar) {
        this.f19619a.add(bVar);
    }

    public final void I(@n0 V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f19623e = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    public void J() {
        this.f19619a.clear();
    }

    public boolean K() {
        return this.f19621c == 1;
    }

    public boolean L() {
        return this.f19621c == 2;
    }

    public void M(@n0 b bVar) {
        this.f19619a.remove(bVar);
    }

    public void N(@n0 V v10, @r int i10) {
        this.f19622d = i10;
        if (this.f19621c == 1) {
            v10.setTranslationY(this.f19620b + i10);
        }
    }

    public void O(@n0 V v10) {
        P(v10, true);
    }

    public void P(@n0 V v10, boolean z10) {
        if (K()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f19623e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        S(v10, 1);
        int i10 = this.f19620b + this.f19622d;
        if (z10) {
            I(v10, i10, 175L, kd.a.f37168c);
        } else {
            v10.setTranslationY(i10);
        }
    }

    public void Q(@n0 V v10) {
        R(v10, true);
    }

    public void R(@n0 V v10, boolean z10) {
        if (L()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f19623e;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            v10.clearAnimation();
        }
        S(v10, 2);
        if (z10) {
            I(v10, 0, 225L, kd.a.f37169d);
        } else {
            v10.setTranslationY(0);
        }
    }

    public final void S(@n0 V v10, @c int i10) {
        this.f19621c = i10;
        Iterator<b> it2 = this.f19619a.iterator();
        while (it2.hasNext()) {
            it2.next().a(v10, this.f19621c);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(@n0 CoordinatorLayout coordinatorLayout, @n0 V v10, int i10) {
        this.f19620b = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        return super.m(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, @n0 V v10, @n0 View view, int i10, int i11, int i12, int i13, int i14, @n0 int[] iArr) {
        if (i11 > 0) {
            O(v10);
        } else if (i11 < 0) {
            Q(v10);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19619a = new LinkedHashSet<>();
        this.f19620b = 0;
        this.f19621c = 2;
        this.f19622d = 0;
    }
}
