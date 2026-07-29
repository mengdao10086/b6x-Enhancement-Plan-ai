package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a0 {
    public static final String T7 = "android:fade:transitionAlpha";
    public static final String U7 = "Fade";
    public static final int V7 = 1;
    public static final int W7 = 2;

    public class a extends t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7874a;

        public a(View view) {
            this.f7874a = view;
        }

        @Override // androidx.transition.t, androidx.transition.q.h
        public void c(@n0 q qVar) {
            g2.z.h(this.f7874a, 1.0f);
            g2.z.a(this.f7874a);
            qVar.p0(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7877b = false;

        public b(View view) {
            this.f7876a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            g2.z.h(this.f7876a, 1.0f);
            if (this.f7877b) {
                this.f7876a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (u0.L0(this.f7876a) && this.f7876a.getLayerType() == 0) {
                this.f7877b = true;
                this.f7876a.setLayerType(2, null);
            }
        }
    }

    public i(int i10) {
        P0(i10);
    }

    public static float R0(g2.q qVar, float f10) {
        Float f11;
        return (qVar == null || (f11 = (Float) qVar.f28972a.get(T7)) == null) ? f10 : f11.floatValue();
    }

    @Override // androidx.transition.a0
    @p0
    public Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        float fR0 = R0(qVar, 0.0f);
        return Q0(view, fR0 != 1.0f ? fR0 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.a0
    @p0
    public Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        g2.z.e(view);
        return Q0(view, R0(qVar, 1.0f), 0.0f);
    }

    public final Animator Q0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        g2.z.h(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, g2.z.f28993c, f11);
        objectAnimatorOfFloat.addListener(new b(view));
        a(new a(view));
        return objectAnimatorOfFloat;
    }

    @Override // androidx.transition.a0, androidx.transition.q
    public void m(@n0 g2.q qVar) {
        super.m(qVar);
        qVar.f28972a.put(T7, Float.valueOf(g2.z.c(qVar.f28973b)));
    }

    public i() {
    }

    @SuppressLint({"RestrictedApi"})
    public i(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f7923f);
        P0(j0.n.k(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, I0()));
        typedArrayObtainStyledAttributes.recycle();
    }
}
