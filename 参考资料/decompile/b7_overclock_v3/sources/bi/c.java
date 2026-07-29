package bi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9483h = "translationX";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f9484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f9485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f9486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f9487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9490g;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            c cVar = c.this;
            cVar.f(cVar.f9484a, cVar.f9485b);
            c.this.f9490g = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c cVar = c.this;
            cVar.f(cVar.f9484a, cVar.f9485b);
            c.this.f9490g = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            c cVar = c.this;
            cVar.e(cVar.f9484a, cVar.f9485b);
            c.this.f9490g = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c cVar = c.this;
            cVar.e(cVar.f9484a, cVar.f9485b);
            c.this.f9490g = false;
        }
    }

    public c(View view, View view2, boolean z10, long j10, long j11) {
        this.f9484a = view;
        this.f9485b = view2;
        this.f9489f = z10;
        this.f9487d = j10;
        this.f9488e = j11;
    }

    public AnimatorSet b(View view, View view2, boolean z10) {
        float[] fArr = new float[1];
        fArr[0] = z10 ? 0.0f : view.getWidth();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "translationX", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f9489f) {
            animatorSet.play(objectAnimatorOfFloat);
        } else {
            float[] fArr2 = new float[1];
            fArr2[0] = z10 ? 0.0f : view2.getWidth();
            animatorSet.playTogether(objectAnimatorOfFloat, ObjectAnimator.ofFloat(view2, "translationX", fArr2));
        }
        animatorSet.setDuration(this.f9488e);
        if (!z10) {
            animatorSet.setStartDelay(this.f9487d);
        }
        return animatorSet;
    }

    public void c() {
        if (this.f9484a == null || this.f9485b == null) {
            return;
        }
        if (this.f9490g) {
            this.f9486c.cancel();
        }
        AnimatorSet animatorSetB = b(this.f9484a, this.f9485b, false);
        this.f9486c = animatorSetB;
        animatorSetB.addListener(new b());
        this.f9486c.start();
        this.f9490g = true;
    }

    public boolean d() {
        return this.f9490g;
    }

    public void e(View view, View view2) {
        view.setVisibility(4);
        if (!this.f9489f) {
            view2.setVisibility(4);
        }
        view.setTranslationX(0.0f);
        view2.setTranslationX(0.0f);
    }

    public void f(View view, View view2) {
    }

    public void g(long j10) {
        this.f9487d = j10;
    }

    public void h() {
        if (this.f9484a == null || this.f9485b == null) {
            return;
        }
        if (this.f9490g) {
            this.f9486c.cancel();
        }
        if (this.f9484a.getVisibility() == 4 || this.f9485b.getVisibility() == 4) {
            this.f9484a.setVisibility(0);
            this.f9485b.setVisibility(0);
            AnimatorSet animatorSetB = b(this.f9484a, this.f9485b, true);
            this.f9486c = animatorSetB;
            animatorSetB.addListener(new a());
            this.f9486c.start();
            this.f9490g = true;
        }
    }
}
