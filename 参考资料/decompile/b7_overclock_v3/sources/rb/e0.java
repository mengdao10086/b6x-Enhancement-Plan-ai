package rb;

import hb.a;
import hd.p0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 extends hb.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f47984f = 100000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f47985g = 940;

    public static final class a implements a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f47986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final hd.c0 f47987b = new hd.c0();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f47988c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f47989d;

        public a(int i10, p0 p0Var, int i11) {
            this.f47988c = i10;
            this.f47986a = p0Var;
            this.f47989d = i11;
        }

        @Override // hb.a.f
        public a.e a(hb.l lVar, long j10) throws IOException {
            long position = lVar.getPosition();
            int iMin = (int) Math.min(this.f47989d, lVar.getLength() - position);
            this.f47987b.O(iMin);
            lVar.t(this.f47987b.d(), 0, iMin);
            return c(this.f47987b, j10, position);
        }

        @Override // hb.a.f
        public void b() {
            this.f47987b.P(u0.f31159f);
        }

        public final a.e c(hd.c0 c0Var, long j10, long j11) {
            int iA;
            int iA2;
            int iF = c0Var.f();
            long j12 = -1;
            long j13 = -1;
            long j14 = -9223372036854775807L;
            while (c0Var.a() >= 188 && (iA2 = (iA = j0.a(c0Var.d(), c0Var.e(), iF)) + 188) <= iF) {
                long jB = j0.b(c0Var, iA, this.f47988c);
                if (jB != ya.g.f56663b) {
                    long jB2 = this.f47986a.b(jB);
                    if (jB2 > j10) {
                        return j14 == ya.g.f56663b ? a.e.d(jB2, j11) : a.e.e(j11 + j13);
                    }
                    if (100000 + jB2 > j10) {
                        return a.e.e(j11 + ((long) iA));
                    }
                    j13 = iA;
                    j14 = jB2;
                }
                c0Var.S(iA2);
                j12 = iA2;
            }
            return j14 != ya.g.f56663b ? a.e.f(j14, j11 + j12) : a.e.f30796h;
        }
    }

    public e0(p0 p0Var, long j10, long j11, int i10, int i11) {
        super(new a.b(), new a(i10, p0Var, i11), j10, 0L, j10 + 1, 0L, j11, 188L, f47985g);
    }
}
