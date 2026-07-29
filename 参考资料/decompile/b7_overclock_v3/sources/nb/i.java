package nb;

import ab.x;
import g.p0;
import hb.a0;
import hb.b0;
import hd.c0;
import hd.t;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements g {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f42056j = "XingSeeker";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f42057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f42058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f42059f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f42060g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f42061h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final long[] f42062i;

    public i(long j10, int i10, long j11) {
        this(j10, i10, j11, -1L, null);
    }

    @p0
    public static i b(long j10, long j11, x.a aVar, c0 c0Var) {
        int iK;
        int i10 = aVar.f523g;
        int i11 = aVar.f520d;
        int iO = c0Var.o();
        if ((iO & 1) != 1 || (iK = c0Var.K()) == 0) {
            return null;
        }
        long jH1 = u0.h1(iK, ((long) i10) * 1000000, i11);
        if ((iO & 6) != 6) {
            return new i(j11, aVar.f519c, jH1);
        }
        long jI = c0Var.I();
        long[] jArr = new long[100];
        for (int i12 = 0; i12 < 100; i12++) {
            jArr[i12] = c0Var.G();
        }
        if (j10 != -1) {
            long j12 = j11 + jI;
            if (j10 != j12) {
                t.n(f42056j, "XING data size mismatch: " + j10 + ", " + j12);
            }
        }
        return new i(j11, aVar.f519c, jH1, jI, jArr);
    }

    @Override // nb.g
    public long a(long j10) {
        long j11 = j10 - this.f42057d;
        if (!e() || j11 <= this.f42058e) {
            return 0L;
        }
        long[] jArr = (long[]) hd.a.k(this.f42062i);
        double d10 = (j11 * 256.0d) / this.f42060g;
        int iJ = u0.j(jArr, (long) d10, true, true);
        long jC = c(iJ);
        long j12 = jArr[iJ];
        int i10 = iJ + 1;
        long jC2 = c(i10);
        return jC + Math.round((j12 == (iJ == 99 ? 256L : jArr[i10]) ? 0.0d : (d10 - j12) / (r0 - j12)) * (jC2 - jC));
    }

    public final long c(int i10) {
        return (this.f42059f * ((long) i10)) / 100;
    }

    @Override // nb.g
    public long d() {
        return this.f42061h;
    }

    @Override // hb.a0
    public boolean e() {
        return this.f42062i != null;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        if (!e()) {
            return new a0.a(new b0(0L, this.f42057d + ((long) this.f42058e)));
        }
        long jU = u0.u(j10, 0L, this.f42059f);
        double d10 = (jU * 100.0d) / this.f42059f;
        double d11 = 0.0d;
        if (d10 > 0.0d) {
            if (d10 >= 100.0d) {
                d11 = 256.0d;
            } else {
                int i10 = (int) d10;
                double d12 = ((long[]) hd.a.k(this.f42062i))[i10];
                d11 = d12 + ((d10 - ((double) i10)) * ((i10 == 99 ? 256.0d : r3[i10 + 1]) - d12));
            }
        }
        return new a0.a(new b0(jU, this.f42057d + u0.u(Math.round((d11 / 256.0d) * this.f42060g), this.f42058e, this.f42060g - 1)));
    }

    @Override // hb.a0
    public long h() {
        return this.f42059f;
    }

    public i(long j10, int i10, long j11, long j12, @p0 long[] jArr) {
        this.f42057d = j10;
        this.f42058e = i10;
        this.f42059f = j11;
        this.f42062i = jArr;
        this.f42060g = j12;
        this.f42061h = j12 != -1 ? j10 + j12 : -1L;
    }
}
