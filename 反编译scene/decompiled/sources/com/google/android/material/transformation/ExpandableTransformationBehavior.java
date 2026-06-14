package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f8340a;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ExpandableTransformationBehavior.this.f8340a = null;
        }
    }

    public ExpandableTransformationBehavior() {
    }

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior
    public boolean H(View view, View view2, boolean z, boolean z2) {
        boolean z3 = this.f8340a != null;
        if (z3) {
            this.f8340a.cancel();
        }
        AnimatorSet animatorSetJ = J(view, view2, z, z3);
        this.f8340a = animatorSetJ;
        animatorSetJ.addListener(new a());
        this.f8340a.start();
        if (!z2) {
            this.f8340a.end();
        }
        return true;
    }

    public abstract AnimatorSet J(View view, View view2, boolean z, boolean z2);
}
