package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends q {
    public static final String N7 = "android:clipBounds:bounds";
    public static final String M7 = "android:clipBounds:clip";
    public static final String[] O7 = {M7};

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f7848a;

        public a(View view) {
            this.f7848a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u0.M1(this.f7848a, null);
        }
    }

    public d() {
    }

    public final void H0(g2.q qVar) {
        View view = qVar.f28973b;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rectP = u0.P(view);
        qVar.f28972a.put(M7, rectP);
        if (rectP == null) {
            qVar.f28972a.put(N7, new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.q
    @n0
    public String[] a0() {
        return O7;
    }

    @Override // androidx.transition.q
    public void j(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    public void m(@n0 g2.q qVar) {
        H0(qVar);
    }

    @Override // androidx.transition.q
    @p0
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        ObjectAnimator objectAnimatorOfObject = null;
        if (qVar != null && qVar2 != null && qVar.f28972a.containsKey(M7) && qVar2.f28972a.containsKey(M7)) {
            Rect rect = (Rect) qVar.f28972a.get(M7);
            Rect rect2 = (Rect) qVar2.f28972a.get(M7);
            boolean z10 = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) qVar.f28972a.get(N7);
            } else if (rect2 == null) {
                rect2 = (Rect) qVar2.f28972a.get(N7);
            }
            if (rect.equals(rect2)) {
                return null;
            }
            u0.M1(qVar2.f28973b, rect);
            objectAnimatorOfObject = ObjectAnimator.ofObject(qVar2.f28973b, (Property<View, V>) g2.z.f28994d, (TypeEvaluator) new g2.n(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z10) {
                objectAnimatorOfObject.addListener(new a(qVar2.f28973b));
            }
        }
        return objectAnimatorOfObject;
    }

    public d(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
