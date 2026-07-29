package g1;

import androidx.annotation.RestrictTo;
import g.x;
import g1.b;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final float f28915k = 10000.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f28916l = 1500.0f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f28917m = 200.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f28918n = 50.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f28919o = 0.2f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f28920p = 0.5f;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f28921q = 0.75f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final float f28922r = 1.0f;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final double f28923s = 62.5d;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final double f28924t = Double.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f28925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f28926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f28927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f28928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f28929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f28930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f28931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f28932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f28933i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b.p f28934j;

    public h() {
        this.f28925a = Math.sqrt(1500.0d);
        this.f28926b = 0.5d;
        this.f28927c = false;
        this.f28933i = Double.MAX_VALUE;
        this.f28934j = new b.p();
    }

    @Override // g1.f
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(float f10, float f11) {
        return ((double) Math.abs(f11)) < this.f28929e && ((double) Math.abs(f10 - d())) < this.f28928d;
    }

    @Override // g1.f
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float b(float f10, float f11) {
        float fD = f10 - d();
        double d10 = this.f28925a;
        return (float) (((-(d10 * d10)) * ((double) fD)) - (((d10 * 2.0d) * this.f28926b) * ((double) f11)));
    }

    public float c() {
        return (float) this.f28926b;
    }

    public float d() {
        return (float) this.f28933i;
    }

    public float e() {
        double d10 = this.f28925a;
        return (float) (d10 * d10);
    }

    public final void f() {
        if (this.f28927c) {
            return;
        }
        if (this.f28933i == Double.MAX_VALUE) {
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
        double d10 = this.f28926b;
        if (d10 > 1.0d) {
            double d11 = this.f28925a;
            this.f28930f = ((-d10) * d11) + (d11 * Math.sqrt((d10 * d10) - 1.0d));
            double d12 = this.f28926b;
            double d13 = this.f28925a;
            this.f28931g = ((-d12) * d13) - (d13 * Math.sqrt((d12 * d12) - 1.0d));
        } else if (d10 >= 0.0d && d10 < 1.0d) {
            this.f28932h = this.f28925a * Math.sqrt(1.0d - (d10 * d10));
        }
        this.f28927c = true;
    }

    public h g(@x(from = 0.0d) float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("Damping ratio must be non-negative");
        }
        this.f28926b = f10;
        this.f28927c = false;
        return this;
    }

    public h h(float f10) {
        this.f28933i = f10;
        return this;
    }

    public h i(@x(from = 0.0d, fromInclusive = false) float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f28925a = Math.sqrt(f10);
        this.f28927c = false;
        return this;
    }

    public void j(double d10) {
        double dAbs = Math.abs(d10);
        this.f28928d = dAbs;
        this.f28929e = dAbs * 62.5d;
    }

    public b.p k(double d10, double d11, long j10) {
        double dCos;
        double dPow;
        f();
        double d12 = j10 / 1000.0d;
        double d13 = d10 - this.f28933i;
        double d14 = this.f28926b;
        if (d14 > 1.0d) {
            double d15 = this.f28931g;
            double d16 = this.f28930f;
            double d17 = d13 - (((d15 * d13) - d11) / (d15 - d16));
            double d18 = ((d13 * d15) - d11) / (d15 - d16);
            dPow = (Math.pow(2.718281828459045d, d15 * d12) * d17) + (Math.pow(2.718281828459045d, this.f28930f * d12) * d18);
            double d19 = this.f28931g;
            double dPow2 = d17 * d19 * Math.pow(2.718281828459045d, d19 * d12);
            double d20 = this.f28930f;
            dCos = dPow2 + (d18 * d20 * Math.pow(2.718281828459045d, d20 * d12));
        } else if (d14 == 1.0d) {
            double d21 = this.f28925a;
            double d22 = d11 + (d21 * d13);
            double d23 = d13 + (d22 * d12);
            dPow = Math.pow(2.718281828459045d, (-d21) * d12) * d23;
            double dPow3 = d23 * Math.pow(2.718281828459045d, (-this.f28925a) * d12);
            double d24 = this.f28925a;
            dCos = (d22 * Math.pow(2.718281828459045d, (-d24) * d12)) + (dPow3 * (-d24));
        } else {
            double d25 = 1.0d / this.f28932h;
            double d26 = this.f28925a;
            double d27 = d25 * ((d14 * d26 * d13) + d11);
            double dPow4 = Math.pow(2.718281828459045d, (-d14) * d26 * d12) * ((Math.cos(this.f28932h * d12) * d13) + (Math.sin(this.f28932h * d12) * d27));
            double d28 = this.f28925a;
            double d29 = this.f28926b;
            double d30 = (-d28) * dPow4 * d29;
            double dPow5 = Math.pow(2.718281828459045d, (-d29) * d28 * d12);
            double d31 = this.f28932h;
            double dSin = (-d31) * d13 * Math.sin(d31 * d12);
            double d32 = this.f28932h;
            dCos = d30 + (dPow5 * (dSin + (d27 * d32 * Math.cos(d32 * d12))));
            dPow = dPow4;
        }
        b.p pVar = this.f28934j;
        pVar.f28905a = (float) (dPow + this.f28933i);
        pVar.f28906b = (float) dCos;
        return pVar;
    }

    public h(float f10) {
        this.f28925a = Math.sqrt(1500.0d);
        this.f28926b = 0.5d;
        this.f28927c = false;
        this.f28933i = Double.MAX_VALUE;
        this.f28934j = new b.p();
        this.f28933i = f10;
    }
}
