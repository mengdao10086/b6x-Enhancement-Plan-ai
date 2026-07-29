package bi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ObjectAnimator f9442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f9443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f9444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9445d;

    /* JADX INFO: renamed from: bi.a$a, reason: collision with other inner class name */
    public class C0097a extends AnimatorListenerAdapter {
        public C0097a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            a aVar = a.this;
            aVar.f(aVar.f9443b);
            a.this.f9445d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a aVar = a.this;
            aVar.f(aVar.f9443b);
            a.this.f9445d = false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            a aVar = a.this;
            aVar.e(aVar.f9443b);
            a.this.f9445d = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            a aVar = a.this;
            aVar.e(aVar.f9443b);
            a.this.f9445d = false;
        }
    }

    public a(View view, long j10) {
        this.f9443b = view;
        this.f9444c = j10;
    }

    public ObjectAnimator b(View view) {
        return ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f).setDuration(this.f9444c);
    }

    public ObjectAnimator c(View view) {
        return ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f).setDuration(this.f9444c);
    }

    public void d() {
        if (this.f9443b == null) {
            return;
        }
        if (this.f9445d) {
            this.f9442a.cancel();
        }
        ObjectAnimator objectAnimatorB = b(this.f9443b);
        this.f9442a = objectAnimatorB;
        objectAnimatorB.addListener(new b());
        this.f9442a.start();
        this.f9445d = true;
    }

    public void e(View view) {
        view.setVisibility(4);
    }

    public void f(View view) {
    }

    public void g() {
        if (this.f9443b == null) {
            return;
        }
        if (this.f9445d) {
            this.f9442a.cancel();
        }
        if (this.f9443b.getVisibility() != 0) {
            this.f9443b.setVisibility(0);
            if (this.f9445d) {
                this.f9442a.cancel();
            }
            ObjectAnimator objectAnimatorC = c(this.f9443b);
            this.f9442a = objectAnimatorC;
            objectAnimatorC.addListener(new C0097a());
            this.f9442a.start();
            this.f9445d = true;
        }
    }
}
