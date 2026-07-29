package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.u0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements View.OnTouchListener {
    public static final int A = 315;
    public static final int B = 1575;
    public static final float C = Float.MAX_VALUE;
    public static final float D = 0.2f;
    public static final int K0 = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final float f5194k0 = 1.0f;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f5195k1 = 500;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f5196r = 0.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f5197s = Float.MAX_VALUE;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f5198t = 0.0f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5199u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5200v = 1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f5201v1 = 500;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5202w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5203x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5204y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5205z = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f5208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f5209d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f5212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5213h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5217l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f5218m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f5219n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f5220o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f5221p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f5222q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0046a f5206a = new C0046a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f5207b = new AccelerateInterpolator();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f5210e = {0.0f, 0.0f};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f5211f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f5214i = {0.0f, 0.0f};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f5215j = {0.0f, 0.0f};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f5216k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f5225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f5226d;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f5232j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f5233k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5227e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f5231i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5228f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5229g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5230h = 0;

        public void a() {
            if (this.f5228f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j10 = jCurrentAnimationTimeMillis - this.f5228f;
            this.f5228f = jCurrentAnimationTimeMillis;
            float f10 = j10 * fG;
            this.f5229g = (int) (this.f5225c * f10);
            this.f5230h = (int) (f10 * this.f5226d);
        }

        public int b() {
            return this.f5229g;
        }

        public int c() {
            return this.f5230h;
        }

        public int d() {
            float f10 = this.f5225c;
            return (int) (f10 / Math.abs(f10));
        }

        public final float e(long j10) {
            if (j10 < this.f5227e) {
                return 0.0f;
            }
            long j11 = this.f5231i;
            if (j11 < 0 || j10 < j11) {
                return a.e((j10 - r0) / this.f5223a, 0.0f, 1.0f) * 0.5f;
            }
            float f10 = this.f5232j;
            return (1.0f - f10) + (f10 * a.e((j10 - j11) / this.f5233k, 0.0f, 1.0f));
        }

        public int f() {
            float f10 = this.f5226d;
            return (int) (f10 / Math.abs(f10));
        }

        public final float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public boolean h() {
            return this.f5231i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f5231i + ((long) this.f5233k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5233k = a.f((int) (jCurrentAnimationTimeMillis - this.f5227e), 0, this.f5224b);
            this.f5232j = e(jCurrentAnimationTimeMillis);
            this.f5231i = jCurrentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f5224b = i10;
        }

        public void k(int i10) {
            this.f5223a = i10;
        }

        public void l(float f10, float f11) {
            this.f5225c = f10;
            this.f5226d = f11;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f5227e = jCurrentAnimationTimeMillis;
            this.f5231i = -1L;
            this.f5228f = jCurrentAnimationTimeMillis;
            this.f5232j = 0.5f;
            this.f5229g = 0;
            this.f5230h = 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f5220o) {
                if (aVar.f5218m) {
                    aVar.f5218m = false;
                    aVar.f5206a.m();
                }
                C0046a c0046a = a.this.f5206a;
                if (c0046a.h() || !a.this.x()) {
                    a.this.f5220o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f5219n) {
                    aVar2.f5219n = false;
                    aVar2.c();
                }
                c0046a.a();
                a.this.l(c0046a.b(), c0046a.c());
                u0.p1(a.this.f5208c, this);
            }
        }
    }

    public a(@n0 View view) {
        this.f5208c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        r(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        s(f12, f12);
        n(1);
        q(Float.MAX_VALUE, Float.MAX_VALUE);
        v(0.2f, 0.2f);
        w(1.0f, 1.0f);
        m(K0);
        u(500);
        t(500);
    }

    public static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    public static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    public void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f5208c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final float d(int i10, float f10, float f11, float f12) {
        float fH = h(this.f5210e[i10], f11, this.f5211f[i10], f10);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f13 = this.f5214i[i10];
        float f14 = this.f5215j[i10];
        float f15 = this.f5216k[i10];
        float f16 = f13 * f12;
        return fH > 0.0f ? e(fH * f16, f14, f15) : -e((-fH) * f16, f14, f15);
    }

    public final float g(float f10, float f11) {
        if (f11 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.f5212g;
        if (i10 == 0 || i10 == 1) {
            if (f10 < f11) {
                if (f10 >= 0.0f) {
                    return 1.0f - (f10 / f11);
                }
                if (this.f5220o && i10 == 1) {
                    return 1.0f;
                }
            }
        } else if (i10 == 2 && f10 < 0.0f) {
            return f10 / (-f11);
        }
        return 0.0f;
    }

    public final float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float fE = e(f10 * f11, 0.0f, f12);
        float fG = g(f11 - f13, fE) - g(f13, fE);
        if (fG < 0.0f) {
            interpolation = -this.f5207b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f5207b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    public boolean i() {
        return this.f5221p;
    }

    public boolean j() {
        return this.f5222q;
    }

    public final void k() {
        if (this.f5218m) {
            this.f5220o = false;
        } else {
            this.f5206a.i();
        }
    }

    public abstract void l(int i10, int i11);

    @n0
    public a m(int i10) {
        this.f5213h = i10;
        return this;
    }

    @n0
    public a n(int i10) {
        this.f5212g = i10;
        return this;
    }

    public a o(boolean z10) {
        if (this.f5221p && !z10) {
            k();
        }
        this.f5221p = z10;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f5221p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.k()
            goto L58
        L1a:
            r5.f5219n = r2
            r5.f5217l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f5208c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f5208c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f5206a
            r7.l(r0, r6)
            boolean r6 = r5.f5220o
            if (r6 != 0) goto L58
            boolean r6 = r5.x()
            if (r6 == 0) goto L58
            r5.y()
        L58:
            boolean r6 = r5.f5222q
            if (r6 == 0) goto L61
            boolean r6 = r5.f5220o
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(boolean z10) {
        this.f5222q = z10;
        return this;
    }

    @n0
    public a q(float f10, float f11) {
        float[] fArr = this.f5211f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @n0
    public a r(float f10, float f11) {
        float[] fArr = this.f5216k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    @n0
    public a s(float f10, float f11) {
        float[] fArr = this.f5215j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    @n0
    public a t(int i10) {
        this.f5206a.j(i10);
        return this;
    }

    @n0
    public a u(int i10) {
        this.f5206a.k(i10);
        return this;
    }

    @n0
    public a v(float f10, float f11) {
        float[] fArr = this.f5210e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    @n0
    public a w(float f10, float f11) {
        float[] fArr = this.f5214i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public boolean x() {
        C0046a c0046a = this.f5206a;
        int iF = c0046a.f();
        int iD = c0046a.d();
        return (iF != 0 && b(iF)) || (iD != 0 && a(iD));
    }

    public final void y() {
        int i10;
        if (this.f5209d == null) {
            this.f5209d = new b();
        }
        this.f5220o = true;
        this.f5218m = true;
        if (this.f5217l || (i10 = this.f5213h) <= 0) {
            this.f5209d.run();
        } else {
            u0.q1(this.f5208c, this.f5209d, i10);
        }
        this.f5217l = true;
    }
}
