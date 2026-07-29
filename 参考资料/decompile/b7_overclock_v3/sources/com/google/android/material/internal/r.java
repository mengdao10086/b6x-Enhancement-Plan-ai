package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class r extends androidx.transition.q {
    public static final String M7 = "android:textscale:scale";

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f20491a;

        public a(TextView textView) {
            this.f20491a = textView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@n0 ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f20491a.setScaleX(fFloatValue);
            this.f20491a.setScaleY(fFloatValue);
        }
    }

    public final void H0(@n0 g2.q qVar) {
        View view = qVar.f28973b;
        if (view instanceof TextView) {
            qVar.f28972a.put(M7, Float.valueOf(((TextView) view).getScaleX()));
        }
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
    public Animator q(@n0 ViewGroup viewGroup, @p0 g2.q qVar, @p0 g2.q qVar2) {
        if (qVar == null || qVar2 == null || !(qVar.f28973b instanceof TextView)) {
            return null;
        }
        View view = qVar2.f28973b;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = qVar.f28972a;
        Map<String, Object> map2 = qVar2.f28972a;
        float fFloatValue = map.get(M7) != null ? ((Float) map.get(M7)).floatValue() : 1.0f;
        float fFloatValue2 = map2.get(M7) != null ? ((Float) map2.get(M7)).floatValue() : 1.0f;
        if (fFloatValue == fFloatValue2) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new a(textView));
        return valueAnimatorOfFloat;
    }
}
