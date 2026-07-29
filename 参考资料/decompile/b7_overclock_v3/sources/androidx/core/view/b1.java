package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4834e = 2113929216;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f4835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Runnable f4836b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f4837c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4838d = -1;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1 f4839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f4840b;

        public a(c1 c1Var, View view) {
            this.f4839a = c1Var;
            this.f4840b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f4839a.a(this.f4840b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f4839a.b(this.f4840b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f4839a.c(this.f4840b);
        }
    }

    @g.v0(16)
    public static class b {
        @g.u
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withEndAction(runnable);
        }

        @g.u
        public static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator) {
            return viewPropertyAnimator.withLayer();
        }

        @g.u
        public static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, Runnable runnable) {
            return viewPropertyAnimator.withStartAction(runnable);
        }
    }

    @g.v0(18)
    public static class c {
        @g.u
        public static Interpolator a(ViewPropertyAnimator viewPropertyAnimator) {
            return (Interpolator) viewPropertyAnimator.getInterpolator();
        }
    }

    @g.v0(19)
    public static class d {
        @g.u
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            return viewPropertyAnimator.setUpdateListener(animatorUpdateListener);
        }
    }

    @g.v0(21)
    public static class e {
        @g.u
        public static ViewPropertyAnimator a(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.translationZ(f10);
        }

        @g.u
        public static ViewPropertyAnimator b(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.translationZBy(f10);
        }

        @g.u
        public static ViewPropertyAnimator c(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.z(f10);
        }

        @g.u
        public static ViewPropertyAnimator d(ViewPropertyAnimator viewPropertyAnimator, float f10) {
            return viewPropertyAnimator.zBy(f10);
        }
    }

    public static class f implements c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b1 f4842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4843b;

        public f(b1 b1Var) {
            this.f4842a = b1Var;
        }

        @Override // androidx.core.view.c1
        public void a(@g.n0 View view) {
            Object tag = view.getTag(b1.f4834e);
            c1 c1Var = tag instanceof c1 ? (c1) tag : null;
            if (c1Var != null) {
                c1Var.a(view);
            }
        }

        @Override // androidx.core.view.c1
        @SuppressLint({"WrongConstant"})
        public void b(@g.n0 View view) {
            int i10 = this.f4842a.f4838d;
            if (i10 > -1) {
                view.setLayerType(i10, null);
                this.f4842a.f4838d = -1;
            }
            b1 b1Var = this.f4842a;
            Runnable runnable = b1Var.f4837c;
            if (runnable != null) {
                b1Var.f4837c = null;
                runnable.run();
            }
            Object tag = view.getTag(b1.f4834e);
            c1 c1Var = tag instanceof c1 ? (c1) tag : null;
            if (c1Var != null) {
                c1Var.b(view);
            }
            this.f4843b = true;
        }

        @Override // androidx.core.view.c1
        public void c(@g.n0 View view) {
            this.f4843b = false;
            if (this.f4842a.f4838d > -1) {
                view.setLayerType(2, null);
            }
            b1 b1Var = this.f4842a;
            Runnable runnable = b1Var.f4836b;
            if (runnable != null) {
                b1Var.f4836b = null;
                runnable.run();
            }
            Object tag = view.getTag(b1.f4834e);
            c1 c1Var = tag instanceof c1 ? (c1) tag : null;
            if (c1Var != null) {
                c1Var.c(view);
            }
        }
    }

    public b1(View view) {
        this.f4835a = new WeakReference<>(view);
    }

    @g.n0
    public b1 A(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().translationXBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 B(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().translationY(f10);
        }
        return this;
    }

    @g.n0
    public b1 C(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().translationYBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 D(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            e.a(view.animate(), f10);
        }
        return this;
    }

    @g.n0
    public b1 E(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            e.b(view.animate(), f10);
        }
        return this;
    }

    @g.n0
    public b1 F(@g.n0 Runnable runnable) {
        View view = this.f4835a.get();
        if (view != null) {
            b.a(view.animate(), runnable);
        }
        return this;
    }

    @SuppressLint({"WrongConstant"})
    @g.n0
    public b1 G() {
        View view = this.f4835a.get();
        if (view != null) {
            b.b(view.animate());
        }
        return this;
    }

    @g.n0
    public b1 H(@g.n0 Runnable runnable) {
        View view = this.f4835a.get();
        if (view != null) {
            b.c(view.animate(), runnable);
        }
        return this;
    }

    @g.n0
    public b1 I(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().x(f10);
        }
        return this;
    }

    @g.n0
    public b1 J(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().xBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 K(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().y(f10);
        }
        return this;
    }

    @g.n0
    public b1 L(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().yBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 M(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            e.c(view.animate(), f10);
        }
        return this;
    }

    @g.n0
    public b1 N(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            e.d(view.animate(), f10);
        }
        return this;
    }

    @g.n0
    public b1 b(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().alpha(f10);
        }
        return this;
    }

    @g.n0
    public b1 c(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().alphaBy(f10);
        }
        return this;
    }

    public void d() {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public long e() {
        View view = this.f4835a.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    @g.p0
    public Interpolator f() {
        View view = this.f4835a.get();
        if (view != null) {
            return c.a(view.animate());
        }
        return null;
    }

    public long g() {
        View view = this.f4835a.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    @g.n0
    public b1 i(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotation(f10);
        }
        return this;
    }

    @g.n0
    public b1 j(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotationBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 k(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotationX(f10);
        }
        return this;
    }

    @g.n0
    public b1 l(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotationXBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 m(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotationY(f10);
        }
        return this;
    }

    @g.n0
    public b1 n(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().rotationYBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 o(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().scaleX(f10);
        }
        return this;
    }

    @g.n0
    public b1 p(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().scaleXBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 q(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().scaleY(f10);
        }
        return this;
    }

    @g.n0
    public b1 r(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().scaleYBy(f10);
        }
        return this;
    }

    @g.n0
    public b1 s(long j10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().setDuration(j10);
        }
        return this;
    }

    @g.n0
    public b1 t(@g.p0 Interpolator interpolator) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    @g.n0
    public b1 u(@g.p0 c1 c1Var) {
        View view = this.f4835a.get();
        if (view != null) {
            v(view, c1Var);
        }
        return this;
    }

    public final void v(View view, c1 c1Var) {
        if (c1Var != null) {
            view.animate().setListener(new a(c1Var, view));
        } else {
            view.animate().setListener(null);
        }
    }

    @g.n0
    public b1 w(long j10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().setStartDelay(j10);
        }
        return this;
    }

    @g.n0
    public b1 x(@g.p0 final e1 e1Var) {
        final View view = this.f4835a.get();
        if (view != null) {
            d.a(view.animate(), e1Var != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.a1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    e1Var.a(view);
                }
            } : null);
        }
        return this;
    }

    public void y() {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().start();
        }
    }

    @g.n0
    public b1 z(float f10) {
        View view = this.f4835a.get();
        if (view != null) {
            view.animate().translationX(f10);
        }
        return this;
    }
}
