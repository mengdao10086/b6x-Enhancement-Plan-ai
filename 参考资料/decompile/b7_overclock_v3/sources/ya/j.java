package ya;

import android.os.SystemClock;
import com.google.common.primitives.Longs;
import ya.v0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements t0 {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f56795t = 0.97f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f56796u = 1.03f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f56797v = 1000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f56798w = 0.1f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final long f56799x = 500;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final float f56800y = 0.999f;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f56801z = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f56802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f56803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f56804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f56805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f56806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f56807f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f56808g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f56809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f56810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f56811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f56812k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f56813l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f56814m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f56815n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f56816o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f56817p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f56818q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f56819r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f56820s;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f56821a = 0.97f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f56822b = 1.03f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f56823c = 1000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f56824d = 1.0E-7f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f56825e = g.c(20);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f56826f = g.c(500);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f56827g = 0.999f;

        public j a() {
            return new j(this.f56821a, this.f56822b, this.f56823c, this.f56824d, this.f56825e, this.f56826f, this.f56827g);
        }

        public b b(float f10) {
            hd.a.a(f10 >= 1.0f);
            this.f56822b = f10;
            return this;
        }

        public b c(float f10) {
            hd.a.a(0.0f < f10 && f10 <= 1.0f);
            this.f56821a = f10;
            return this;
        }

        public b d(long j10) {
            hd.a.a(j10 > 0);
            this.f56825e = g.c(j10);
            return this;
        }

        public b e(float f10) {
            hd.a.a(f10 >= 0.0f && f10 < 1.0f);
            this.f56827g = f10;
            return this;
        }

        public b f(long j10) {
            hd.a.a(j10 > 0);
            this.f56823c = j10;
            return this;
        }

        public b g(float f10) {
            hd.a.a(f10 > 0.0f);
            this.f56824d = f10 / 1000000.0f;
            return this;
        }

        public b h(long j10) {
            hd.a.a(j10 >= 0);
            this.f56826f = g.c(j10);
            return this;
        }
    }

    public static long h(long j10, long j11, float f10) {
        return (long) ((j10 * f10) + ((1.0f - f10) * j11));
    }

    @Override // ya.t0
    public void a(v0.f fVar) {
        this.f56809h = g.c(fVar.f57178a);
        this.f56812k = g.c(fVar.f57179b);
        this.f56813l = g.c(fVar.f57180c);
        float f10 = fVar.f57181d;
        if (f10 == -3.4028235E38f) {
            f10 = this.f56802a;
        }
        this.f56816o = f10;
        float f11 = fVar.f57182e;
        if (f11 == -3.4028235E38f) {
            f11 = this.f56803b;
        }
        this.f56815n = f11;
        g();
    }

    @Override // ya.t0
    public float b(long j10, long j11) {
        if (this.f56809h == g.f56663b) {
            return 1.0f;
        }
        i(j10, j11);
        if (this.f56818q != g.f56663b && SystemClock.elapsedRealtime() - this.f56818q < this.f56804c) {
            return this.f56817p;
        }
        this.f56818q = SystemClock.elapsedRealtime();
        f(j10);
        long j12 = j10 - this.f56814m;
        if (Math.abs(j12) < this.f56806e) {
            this.f56817p = 1.0f;
        } else {
            this.f56817p = hd.u0.s((this.f56805d * j12) + 1.0f, this.f56816o, this.f56815n);
        }
        return this.f56817p;
    }

    @Override // ya.t0
    public long c() {
        return this.f56814m;
    }

    @Override // ya.t0
    public void d() {
        long j10 = this.f56814m;
        if (j10 == g.f56663b) {
            return;
        }
        long j11 = j10 + this.f56807f;
        this.f56814m = j11;
        long j12 = this.f56813l;
        if (j12 != g.f56663b && j11 > j12) {
            this.f56814m = j12;
        }
        this.f56818q = g.f56663b;
    }

    @Override // ya.t0
    public void e(long j10) {
        this.f56810i = j10;
        g();
    }

    public final void f(long j10) {
        long j11 = this.f56819r + (this.f56820s * 3);
        if (this.f56814m > j11) {
            float fC = g.c(this.f56804c);
            this.f56814m = Longs.max(j11, this.f56811j, this.f56814m - (((long) ((this.f56817p - 1.0f) * fC)) + ((long) ((this.f56815n - 1.0f) * fC))));
            return;
        }
        long jU = hd.u0.u(j10 - ((long) (Math.max(0.0f, this.f56817p - 1.0f) / this.f56805d)), this.f56814m, j11);
        this.f56814m = jU;
        long j12 = this.f56813l;
        if (j12 == g.f56663b || jU <= j12) {
            return;
        }
        this.f56814m = j12;
    }

    public final void g() {
        long j10 = this.f56809h;
        if (j10 != g.f56663b) {
            long j11 = this.f56810i;
            if (j11 != g.f56663b) {
                j10 = j11;
            }
            long j12 = this.f56812k;
            if (j12 != g.f56663b && j10 < j12) {
                j10 = j12;
            }
            long j13 = this.f56813l;
            if (j13 != g.f56663b && j10 > j13) {
                j10 = j13;
            }
        } else {
            j10 = -9223372036854775807L;
        }
        if (this.f56811j == j10) {
            return;
        }
        this.f56811j = j10;
        this.f56814m = j10;
        this.f56819r = g.f56663b;
        this.f56820s = g.f56663b;
        this.f56818q = g.f56663b;
    }

    public final void i(long j10, long j11) {
        long j12 = j10 - j11;
        long j13 = this.f56819r;
        if (j13 == g.f56663b) {
            this.f56819r = j12;
            this.f56820s = 0L;
        } else {
            long jMax = Math.max(j12, h(j13, j12, this.f56808g));
            this.f56819r = jMax;
            this.f56820s = h(this.f56820s, Math.abs(j12 - jMax), this.f56808g);
        }
    }

    public j(float f10, float f11, long j10, float f12, long j11, long j12, float f13) {
        this.f56802a = f10;
        this.f56803b = f11;
        this.f56804c = j10;
        this.f56805d = f12;
        this.f56806e = j11;
        this.f56807f = j12;
        this.f56808g = f13;
        this.f56809h = g.f56663b;
        this.f56810i = g.f56663b;
        this.f56812k = g.f56663b;
        this.f56813l = g.f56663b;
        this.f56816o = f10;
        this.f56815n = f11;
        this.f56817p = 1.0f;
        this.f56818q = g.f56663b;
        this.f56811j = g.f56663b;
        this.f56814m = g.f56663b;
        this.f56819r = g.f56663b;
        this.f56820s = g.f56663b;
    }
}
