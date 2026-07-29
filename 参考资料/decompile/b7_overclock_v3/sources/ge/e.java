package ge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import g.i1;
import g.n0;
import h2.b;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends k<ObjectAnimator> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f29282l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f29283m = 5400;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f29284n = 667;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f29285o = 667;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f29286p = 333;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f29287q = 333;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f29291u = -20;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f29292v = 250;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f29293w = 1520;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObjectAnimator f29296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObjectAnimator f29297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l1.b f29298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ge.c f29299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f29301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f29302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b.a f29303k;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f29288r = {0, 1350, 2700, 4050};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int[] f29289s = {667, 2017, 3367, 4717};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int[] f29290t = {1000, 2350, i6.a.f31860d, 5050};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Property<e, Float> f29294x = new c(Float.class, "animationFraction");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Property<e, Float> f29295y = new d(Float.class, "completeEndFraction");

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            e eVar = e.this;
            eVar.f29300h = (eVar.f29300h + 4) % e.this.f29299g.f29274c.length;
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            e.this.a();
            e eVar = e.this;
            b.a aVar = eVar.f29303k;
            if (aVar != null) {
                aVar.b(eVar.f29340a);
            }
        }
    }

    public class c extends Property<e, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.o());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Float f10) {
            eVar.t(f10.floatValue());
        }
    }

    public class d extends Property<e, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(e eVar) {
            return Float.valueOf(eVar.p());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(e eVar, Float f10) {
            eVar.u(f10.floatValue());
        }
    }

    public e(@n0 g gVar) {
        super(1);
        this.f29300h = 0;
        this.f29303k = null;
        this.f29299g = gVar;
        this.f29298f = new l1.b();
    }

    @Override // ge.k
    public void a() {
        ObjectAnimator objectAnimator = this.f29296d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // ge.k
    public void c() {
        s();
    }

    @Override // ge.k
    public void d(@n0 b.a aVar) {
        this.f29303k = aVar;
    }

    @Override // ge.k
    public void f() {
        ObjectAnimator objectAnimator = this.f29297e;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (this.f29340a.isVisible()) {
            this.f29297e.start();
        } else {
            a();
        }
    }

    @Override // ge.k
    public void g() {
        q();
        s();
        this.f29296d.start();
    }

    @Override // ge.k
    public void h() {
        this.f29303k = null;
    }

    public final float o() {
        return this.f29301i;
    }

    public final float p() {
        return this.f29302j;
    }

    public final void q() {
        if (this.f29296d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f29294x, 0.0f, 1.0f);
            this.f29296d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f29296d.setInterpolator(null);
            this.f29296d.setRepeatCount(-1);
            this.f29296d.addListener(new a());
        }
        if (this.f29297e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f29295y, 0.0f, 1.0f);
            this.f29297e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f29297e.setInterpolator(this.f29298f);
            this.f29297e.addListener(new b());
        }
    }

    public final void r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float fB = b(i10, f29290t[i11], 333);
            if (fB >= 0.0f && fB <= 1.0f) {
                int i12 = i11 + this.f29300h;
                int[] iArr = this.f29299g.f29274c;
                int length = i12 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int iA = vd.m.a(iArr[length], this.f29340a.getAlpha());
                int iA2 = vd.m.a(this.f29299g.f29274c[length2], this.f29340a.getAlpha());
                this.f29342c[0] = kd.c.b().evaluate(this.f29298f.getInterpolation(fB), Integer.valueOf(iA), Integer.valueOf(iA2)).intValue();
                return;
            }
        }
    }

    @i1
    public void s() {
        this.f29300h = 0;
        this.f29342c[0] = vd.m.a(this.f29299g.f29274c[0], this.f29340a.getAlpha());
        this.f29302j = 0.0f;
    }

    @i1
    public void t(float f10) {
        this.f29301i = f10;
        int i10 = (int) (f10 * 5400.0f);
        v(i10);
        r(i10);
        this.f29340a.invalidateSelf();
    }

    public final void u(float f10) {
        this.f29302j = f10;
    }

    public final void v(int i10) {
        float[] fArr = this.f29341b;
        float f10 = this.f29301i;
        fArr[0] = (f10 * 1520.0f) - 20.0f;
        fArr[1] = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            float fB = b(i10, f29288r[i11], 667);
            float[] fArr2 = this.f29341b;
            fArr2[1] = fArr2[1] + (this.f29298f.getInterpolation(fB) * 250.0f);
            float fB2 = b(i10, f29289s[i11], 667);
            float[] fArr3 = this.f29341b;
            fArr3[0] = fArr3[0] + (this.f29298f.getInterpolation(fB2) * 250.0f);
        }
        float[] fArr4 = this.f29341b;
        fArr4[0] = fArr4[0] + ((fArr4[1] - fArr4[0]) * this.f29302j);
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
    }
}
