package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import g.n0;
import java.util.ArrayList;
import java.util.List;
import kd.b;
import kd.i;

/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f21190h = 75;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f21191i = 150;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f21192j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f21193k = 150;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f21194f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f21195g;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f21197b;

        public a(boolean z10, View view) {
            this.f21196a = z10;
            this.f21197b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f21196a) {
                return;
            }
            this.f21197b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f21196a) {
                this.f21197b.setVisibility(0);
            }
        }
    }

    public FabTransformationScrimBehavior() {
        this.f21194f = new i(75L, 150L);
        this.f21195g = new i(0L, 150L);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean E(@n0 CoordinatorLayout coordinatorLayout, @n0 View view, @n0 MotionEvent motionEvent) {
        return super.E(coordinatorLayout, view, motionEvent);
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @n0
    public AnimatorSet M(@n0 View view, @n0 View view2, boolean z10, boolean z11) {
        ArrayList arrayList = new ArrayList();
        N(view2, z10, z11, arrayList, new ArrayList());
        AnimatorSet animatorSet = new AnimatorSet();
        b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2));
        return animatorSet;
    }

    public final void N(@n0 View view, boolean z10, boolean z11, @n0 List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        i iVar = z10 ? this.f21194f : this.f21195g;
        if (z10) {
            if (!z11) {
                view.setAlpha(0.0f);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f);
        }
        iVar.a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean f(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof FloatingActionButton;
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21194f = new i(75L, 150L);
        this.f21195g = new i(0L, 150L);
    }
}
