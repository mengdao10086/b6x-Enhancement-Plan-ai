package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import g.i;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public AnimatorSet f21169e;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f21169e = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    @i
    public boolean K(View view, View view2, boolean z10, boolean z11) {
        AnimatorSet animatorSet = this.f21169e;
        boolean z12 = animatorSet != null;
        if (z12) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSetM = M(view, view2, z10, z12);
        this.f21169e = animatorSetM;
        animatorSetM.addListener(new a());
        this.f21169e.start();
        if (!z11) {
            this.f21169e.end();
        }
        return true;
    }

    @n0
    public abstract AnimatorSet M(View view, View view2, boolean z10, boolean z11);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
