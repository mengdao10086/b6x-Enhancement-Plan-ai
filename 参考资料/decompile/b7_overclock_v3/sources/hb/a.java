package hb;

import g.p0;
import hb.a0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f30772e = 262144;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0367a f30773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f30774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public c f30775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f30776d;

    /* JADX INFO: renamed from: hb.a$a, reason: collision with other inner class name */
    public static class C0367a implements a0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f30777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f30778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f30779f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f30780g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f30781h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f30782i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f30783j;

        public C0367a(d dVar, long j10, long j11, long j12, long j13, long j14, long j15) {
            this.f30777d = dVar;
            this.f30778e = j10;
            this.f30779f = j11;
            this.f30780g = j12;
            this.f30781h = j13;
            this.f30782i = j14;
            this.f30783j = j15;
        }

        @Override // hb.a0
        public boolean e() {
            return true;
        }

        @Override // hb.a0
        public a0.a g(long j10) {
            return new a0.a(new b0(j10, c.h(this.f30777d.a(j10), this.f30779f, this.f30780g, this.f30781h, this.f30782i, this.f30783j)));
        }

        @Override // hb.a0
        public long h() {
            return this.f30778e;
        }

        public long k(long j10) {
            return this.f30777d.a(j10);
        }
    }

    public static final class b implements d {
        @Override // hb.a.d
        public long a(long j10) {
            return j10;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f30785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f30786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f30787d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f30788e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f30789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f30790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f30791h;

        public c(long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f30784a = j10;
            this.f30785b = j11;
            this.f30787d = j12;
            this.f30788e = j13;
            this.f30789f = j14;
            this.f30790g = j15;
            this.f30786c = j16;
            this.f30791h = h(j11, j12, j13, j14, j15, j16);
        }

        public static long h(long j10, long j11, long j12, long j13, long j14, long j15) {
            if (j13 + 1 >= j14 || j11 + 1 >= j12) {
                return j13;
            }
            long j16 = (long) ((j10 - j11) * ((j14 - j13) / (j12 - j11)));
            return u0.u(((j16 + j13) - j15) - (j16 / 20), j13, j14 - 1);
        }

        public final long i() {
            return this.f30790g;
        }

        public final long j() {
            return this.f30789f;
        }

        public final long k() {
            return this.f30791h;
        }

        public final long l() {
            return this.f30784a;
        }

        public final long m() {
            return this.f30785b;
        }

        public final void n() {
            this.f30791h = h(this.f30785b, this.f30787d, this.f30788e, this.f30789f, this.f30790g, this.f30786c);
        }

        public final void o(long j10, long j11) {
            this.f30788e = j10;
            this.f30790g = j11;
            n();
        }

        public final void p(long j10, long j11) {
            this.f30787d = j10;
            this.f30789f = j11;
            n();
        }
    }

    public interface d {
        long a(long j10);
    }

    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f30792d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30793e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f30794f = -2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f30795g = -3;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f30796h = new e(-3, ya.g.f56663b, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f30798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f30799c;

        public e(int i10, long j10, long j11) {
            this.f30797a = i10;
            this.f30798b = j10;
            this.f30799c = j11;
        }

        public static e d(long j10, long j11) {
            return new e(-1, j10, j11);
        }

        public static e e(long j10) {
            return new e(0, ya.g.f56663b, j10);
        }

        public static e f(long j10, long j11) {
            return new e(-2, j10, j11);
        }
    }

    public interface f {
        e a(l lVar, long j10) throws IOException;

        void b();
    }

    public a(d dVar, f fVar, long j10, long j11, long j12, long j13, long j14, long j15, int i10) {
        this.f30774b = fVar;
        this.f30776d = i10;
        this.f30773a = new C0367a(dVar, j10, j11, j12, j13, j14, j15);
    }

    public c a(long j10) {
        return new c(j10, this.f30773a.k(j10), this.f30773a.f30779f, this.f30773a.f30780g, this.f30773a.f30781h, this.f30773a.f30782i, this.f30773a.f30783j);
    }

    public final a0 b() {
        return this.f30773a;
    }

    public int c(l lVar, z zVar) throws IOException {
        while (true) {
            c cVar = (c) hd.a.k(this.f30775c);
            long j10 = cVar.j();
            long jI = cVar.i();
            long jK = cVar.k();
            if (jI - j10 <= this.f30776d) {
                e(false, j10);
                return g(lVar, j10, zVar);
            }
            if (!i(lVar, jK)) {
                return g(lVar, jK, zVar);
            }
            lVar.n();
            e eVarA = this.f30774b.a(lVar, cVar.m());
            int i10 = eVarA.f30797a;
            if (i10 == -3) {
                e(false, jK);
                return g(lVar, jK, zVar);
            }
            if (i10 == -2) {
                cVar.p(eVarA.f30798b, eVarA.f30799c);
            } else {
                if (i10 != -1) {
                    if (i10 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(lVar, eVarA.f30799c);
                    e(true, eVarA.f30799c);
                    return g(lVar, eVarA.f30799c, zVar);
                }
                cVar.o(eVarA.f30798b, eVarA.f30799c);
            }
        }
    }

    public final boolean d() {
        return this.f30775c != null;
    }

    public final void e(boolean z10, long j10) {
        this.f30775c = null;
        this.f30774b.b();
        f(z10, j10);
    }

    public void f(boolean z10, long j10) {
    }

    public final int g(l lVar, long j10, z zVar) {
        if (j10 == lVar.getPosition()) {
            return 0;
        }
        zVar.f30930a = j10;
        return 1;
    }

    public final void h(long j10) {
        c cVar = this.f30775c;
        if (cVar == null || cVar.l() != j10) {
            this.f30775c = a(j10);
        }
    }

    public final boolean i(l lVar, long j10) throws IOException {
        long position = j10 - lVar.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        lVar.o((int) position);
        return true;
    }
}
