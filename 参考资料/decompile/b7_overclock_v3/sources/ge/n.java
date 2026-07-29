package ge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import g.i1;
import g.n0;
import g.p0;
import h2.b;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends k<ObjectAnimator> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f29348j = 667;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f29349k = 333;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Property<n, Float> f29350l = new b(Float.class, "animationFraction");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f29351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public l1.b f29352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f29353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f29354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f29355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f29356i;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            n nVar = n.this;
            nVar.f29354g = (nVar.f29354g + 1) % n.this.f29353f.f29274c.length;
            n.this.f29355h = true;
        }
    }

    public class b extends Property<n, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(n nVar) {
            return Float.valueOf(nVar.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(n nVar, Float f10) {
            nVar.r(f10.floatValue());
        }
    }

    public n(@n0 q qVar) {
        super(3);
        this.f29354g = 1;
        this.f29353f = qVar;
        this.f29352e = new l1.b();
    }

    @Override // ge.k
    public void a() {
        ObjectAnimator objectAnimator = this.f29351d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ge.k
    public void c() {
        q();
    }

    @Override // ge.k
    public void d(@p0 b.a aVar) {
    }

    @Override // ge.k
    public void f() {
    }

    @Override // ge.k
    public void g() {
        o();
        q();
        this.f29351d.start();
    }

    @Override // ge.k
    public void h() {
    }

    public final float n() {
        return this.f29356i;
    }

    public final void o() {
        if (this.f29351d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f29350l, 0.0f, 1.0f);
            this.f29351d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f29351d.setInterpolator(null);
            this.f29351d.setRepeatCount(-1);
            this.f29351d.addListener(new a());
        }
    }

    public final void p() {
        if (!this.f29355h || this.f29341b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.f29342c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = vd.m.a(this.f29353f.f29274c[this.f29354g], this.f29340a.getAlpha());
        this.f29355h = false;
    }

    @i1
    public void q() {
        this.f29355h = true;
        this.f29354g = 1;
        Arrays.fill(this.f29342c, vd.m.a(this.f29353f.f29274c[0], this.f29340a.getAlpha()));
    }

    @i1
    public void r(float f10) {
        this.f29356i = f10;
        s((int) (f10 * 333.0f));
        p();
        this.f29340a.invalidateSelf();
    }

    public final void s(int i10) {
        this.f29341b[0] = 0.0f;
        float fB = b(i10, 0, 667);
        float[] fArr = this.f29341b;
        float interpolation = this.f29352e.getInterpolation(fB);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.f29341b;
        float interpolation2 = this.f29352e.getInterpolation(fB + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.f29341b[5] = 1.0f;
    }
}
