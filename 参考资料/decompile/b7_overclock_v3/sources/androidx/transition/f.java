package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends q {
    public static final String M7 = "android:changeScroll:x";
    public static final String N7 = "android:changeScroll:y";
    public static final String[] O7 = {M7, N7};

    public f() {
    }

    public final void H0(g2.q qVar) {
        qVar.f28972a.put(M7, Integer.valueOf(qVar.f28973b.getScrollX()));
        qVar.f28972a.put(N7, Integer.valueOf(qVar.f28973b.getScrollY()));
    }

    @Override // androidx.transition.q
    @p0
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
        ObjectAnimator objectAnimatorOfInt;
        ObjectAnimator objectAnimatorOfInt2 = null;
        if (qVar == null || qVar2 == null) {
            return null;
        }
        View view = qVar2.f28973b;
        int iIntValue = ((Integer) qVar.f28972a.get(M7)).intValue();
        int iIntValue2 = ((Integer) qVar2.f28972a.get(M7)).intValue();
        int iIntValue3 = ((Integer) qVar.f28972a.get(N7)).intValue();
        int iIntValue4 = ((Integer) qVar2.f28972a.get(N7)).intValue();
        if (iIntValue != iIntValue2) {
            view.setScrollX(iIntValue);
            objectAnimatorOfInt = ObjectAnimator.ofInt(view, "scrollX", iIntValue, iIntValue2);
        } else {
            objectAnimatorOfInt = null;
        }
        if (iIntValue3 != iIntValue4) {
            view.setScrollY(iIntValue3);
            objectAnimatorOfInt2 = ObjectAnimator.ofInt(view, "scrollY", iIntValue3, iIntValue4);
        }
        return w.c(objectAnimatorOfInt, objectAnimatorOfInt2);
    }

    public f(@n0 Context context, @n0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
