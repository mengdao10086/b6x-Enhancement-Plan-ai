package ha;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import g.v0;
import ha.b;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f30743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f30744b = 1.0f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f30745c = 1.0f;

    public a() {
    }

    @v0(11)
    public void a(int i10) {
        b(i10, b.f30747b);
    }

    @v0(11)
    public void b(int i10, b.c0 c0Var) {
        ObjectAnimator objectAnimatorL = l(i10, c0Var);
        objectAnimatorL.addUpdateListener(this.f30743a);
        objectAnimatorL.start();
    }

    @v0(11)
    public void c(int i10, int i11) {
        b.c0 c0Var = b.f30747b;
        e(i10, i11, c0Var, c0Var);
    }

    @v0(11)
    public void d(int i10, int i11, b.c0 c0Var) {
        ObjectAnimator objectAnimatorL = l(i10, c0Var);
        ObjectAnimator objectAnimatorM = m(i11, c0Var);
        if (i10 > i11) {
            objectAnimatorL.addUpdateListener(this.f30743a);
        } else {
            objectAnimatorM.addUpdateListener(this.f30743a);
        }
        objectAnimatorL.start();
        objectAnimatorM.start();
    }

    @v0(11)
    public void e(int i10, int i11, b.c0 c0Var, b.c0 c0Var2) {
        ObjectAnimator objectAnimatorL = l(i10, c0Var);
        ObjectAnimator objectAnimatorM = m(i11, c0Var2);
        if (i10 > i11) {
            objectAnimatorL.addUpdateListener(this.f30743a);
        } else {
            objectAnimatorM.addUpdateListener(this.f30743a);
        }
        objectAnimatorL.start();
        objectAnimatorM.start();
    }

    @v0(11)
    public void f(int i10) {
        g(i10, b.f30747b);
    }

    @v0(11)
    public void g(int i10, b.c0 c0Var) {
        ObjectAnimator objectAnimatorM = m(i10, c0Var);
        objectAnimatorM.addUpdateListener(this.f30743a);
        objectAnimatorM.start();
    }

    public float h() {
        return this.f30745c;
    }

    public float i() {
        return this.f30744b;
    }

    public void j(float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.f30745c = f10;
    }

    public void k(float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.f30744b = f10;
    }

    @v0(11)
    public final ObjectAnimator l(int i10, b.c0 c0Var) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.setDuration(i10);
        return objectAnimatorOfFloat;
    }

    @v0(11)
    public final ObjectAnimator m(int i10, b.c0 c0Var) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(c0Var);
        objectAnimatorOfFloat.setDuration(i10);
        return objectAnimatorOfFloat;
    }

    @v0(11)
    public a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f30743a = animatorUpdateListener;
    }
}
