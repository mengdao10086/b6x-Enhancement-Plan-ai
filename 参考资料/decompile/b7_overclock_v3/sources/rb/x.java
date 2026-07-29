package rb;

import hb.a;
import hd.p0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends hb.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f48394f = 100000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f48395g = 1000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f48396h = 20000;

    public static final class b implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f48397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final hd.c0 f48398b;

        public static void d(hd.c0 c0Var) {
            int iK;
            int iF = c0Var.f();
            if (c0Var.a() < 10) {
                c0Var.S(iF);
                return;
            }
            c0Var.T(9);
            int iG = c0Var.G() & 7;
            if (c0Var.a() < iG) {
                c0Var.S(iF);
                return;
            }
            c0Var.T(iG);
            if (c0Var.a() < 4) {
                c0Var.S(iF);
                return;
            }
            if (x.k(c0Var.d(), c0Var.e()) == 443) {
                c0Var.T(4);
                int iM = c0Var.M();
                if (c0Var.a() < iM) {
                    c0Var.S(iF);
                    return;
                }
                c0Var.T(iM);
            }
            while (c0Var.a() >= 4 && (iK = x.k(c0Var.d(), c0Var.e())) != 442 && iK != 441 && (iK >>> 8) == 1) {
                c0Var.T(4);
                if (c0Var.a() < 2) {
                    c0Var.S(iF);
                    return;
                }
                c0Var.S(Math.min(c0Var.f(), c0Var.e() + c0Var.M()));
            }
        }

        @Override // hb.a.f
        public a.e a(hb.l lVar, long j10) throws IOException {
            long position = lVar.getPosition();
            int iMin = (int) Math.min(com.google.android.exoplayer2.audio.j.f16899v, lVar.getLength() - position);
            this.f48398b.O(iMin);
            lVar.t(this.f48398b.d(), 0, iMin);
            return c(this.f48398b, j10, position);
        }

        @Override // hb.a.f
        public void b() {
            this.f48398b.P(u0.f31159f);
        }

        public final a.e c(hd.c0 c0Var, long j10, long j11) {
            int iE = -1;
            long j12 = -9223372036854775807L;
            int iE2 = -1;
            while (c0Var.a() >= 4) {
                if (x.k(c0Var.d(), c0Var.e()) != 442) {
                    c0Var.T(1);
                } else {
                    c0Var.T(4);
                    long jL = y.l(c0Var);
                    if (jL != ya.g.f56663b) {
                        long jB = this.f48397a.b(jL);
                        if (jB > j10) {
                            return j12 == ya.g.f56663b ? a.e.d(jB, j11) : a.e.e(j11 + ((long) iE2));
                        }
                        if (100000 + jB > j10) {
                            return a.e.e(j11 + ((long) c0Var.e()));
                        }
                        iE2 = c0Var.e();
                        j12 = jB;
                    }
                    d(c0Var);
                    iE = c0Var.e();
                }
            }
            return j12 != ya.g.f56663b ? a.e.f(j12, j11 + ((long) iE)) : a.e.f30796h;
        }

        public b(p0 p0Var) {
            this.f48397a = p0Var;
            this.f48398b = new hd.c0();
        }
    }

    public x(p0 p0Var, long j10, long j11) {
        super(new a.b(), new b(p0Var), j10, 0L, j10 + 1, 0L, j11, 188L, 1000);
    }

    public static int k(byte[] bArr, int i10) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }
}
