package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.q;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    public static class a extends AnimatorListenerAdapter implements q.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f8014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f8015b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8016c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f8017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f8018e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f8019f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f8020g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f8021h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f8022i;

        public a(View view, View view2, int i10, int i11, float f10, float f11) {
            this.f8015b = view;
            this.f8014a = view2;
            this.f8016c = i10 - Math.round(view.getTranslationX());
            this.f8017d = i11 - Math.round(view.getTranslationY());
            this.f8021h = f10;
            this.f8022i = f11;
            int i12 = R.id.transition_position;
            int[] iArr = (int[]) view2.getTag(i12);
            this.f8018e = iArr;
            if (iArr != null) {
                view2.setTag(i12, null);
            }
        }

        @Override // androidx.transition.q.h
        public void a(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void b(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void c(@n0 q qVar) {
            this.f8015b.setTranslationX(this.f8021h);
            this.f8015b.setTranslationY(this.f8022i);
            qVar.p0(this);
        }

        @Override // androidx.transition.q.h
        public void d(@n0 q qVar) {
        }

        @Override // androidx.transition.q.h
        public void e(@n0 q qVar) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f8018e == null) {
                this.f8018e = new int[2];
            }
            this.f8018e[0] = Math.round(this.f8016c + this.f8015b.getTranslationX());
            this.f8018e[1] = Math.round(this.f8017d + this.f8015b.getTranslationY());
            this.f8014a.setTag(R.id.transition_position, this.f8018e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f8019f = this.f8015b.getTranslationX();
            this.f8020g = this.f8015b.getTranslationY();
            this.f8015b.setTranslationX(this.f8021h);
            this.f8015b.setTranslationY(this.f8022i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f8015b.setTranslationX(this.f8019f);
            this.f8015b.setTranslationY(this.f8020g);
        }
    }

    @p0
    public static Animator a(@n0 View view, @n0 g2.q qVar, int i10, int i11, float f10, float f11, float f12, float f13, @p0 TimeInterpolator timeInterpolator, @n0 q qVar2) {
        float f14;
        float f15;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) qVar.f28973b.getTag(R.id.transition_position)) != null) {
            f14 = (r4[0] - i10) + translationX;
            f15 = (r4[1] - i11) + translationY;
        } else {
            f14 = f10;
            f15 = f11;
        }
        int iRound = i10 + Math.round(f14 - translationX);
        int iRound2 = i11 + Math.round(f15 - translationY);
        view.setTranslationX(f14);
        view.setTranslationY(f15);
        if (f14 == f12 && f15 == f13) {
            return null;
        }
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f14, f12), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f15, f13));
        a aVar = new a(view, qVar.f28973b, iRound, iRound2, translationX, translationY);
        qVar2.a(aVar);
        objectAnimatorOfPropertyValuesHolder.addListener(aVar);
        androidx.transition.a.a(objectAnimatorOfPropertyValuesHolder, aVar);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(timeInterpolator);
        return objectAnimatorOfPropertyValuesHolder;
    }
}
