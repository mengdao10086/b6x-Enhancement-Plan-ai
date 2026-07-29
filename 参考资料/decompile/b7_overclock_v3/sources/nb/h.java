package nb;

import ab.x;
import g.p0;
import hb.a0;
import hb.b0;
import hd.c0;
import hd.t;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f42051h = "VbriSeeker";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f42052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f42053e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f42054f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f42055g;

    public h(long[] jArr, long[] jArr2, long j10, long j11) {
        this.f42052d = jArr;
        this.f42053e = jArr2;
        this.f42054f = j10;
        this.f42055g = j11;
    }

    @p0
    public static h b(long j10, long j11, x.a aVar, c0 c0Var) {
        int iG;
        c0Var.T(10);
        int iO = c0Var.o();
        if (iO <= 0) {
            return null;
        }
        int i10 = aVar.f520d;
        long jH1 = u0.h1(iO, 1000000 * ((long) (i10 >= 32000 ? 1152 : 576)), i10);
        int iM = c0Var.M();
        int iM2 = c0Var.M();
        int iM3 = c0Var.M();
        c0Var.T(2);
        long j12 = j11 + ((long) aVar.f519c);
        long[] jArr = new long[iM];
        long[] jArr2 = new long[iM];
        int i11 = 0;
        long j13 = j11;
        while (i11 < iM) {
            int i12 = iM2;
            long j14 = j12;
            jArr[i11] = (((long) i11) * jH1) / ((long) iM);
            jArr2[i11] = Math.max(j13, j14);
            if (iM3 == 1) {
                iG = c0Var.G();
            } else if (iM3 == 2) {
                iG = c0Var.M();
            } else if (iM3 == 3) {
                iG = c0Var.J();
            } else {
                if (iM3 != 4) {
                    return null;
                }
                iG = c0Var.K();
            }
            j13 += (long) (iG * i12);
            i11++;
            j12 = j14;
            iM2 = i12;
        }
        if (j10 != -1 && j10 != j13) {
            t.n(f42051h, "VBRI data size mismatch: " + j10 + ", " + j13);
        }
        return new h(jArr, jArr2, jH1, j13);
    }

    @Override // nb.g
    public long a(long j10) {
        return this.f42052d[u0.j(this.f42053e, j10, true, true)];
    }

    @Override // nb.g
    public long d() {
        return this.f42055g;
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        int iJ = u0.j(this.f42052d, j10, true, true);
        b0 b0Var = new b0(this.f42052d[iJ], this.f42053e[iJ]);
        if (b0Var.f30805a >= j10 || iJ == this.f42052d.length - 1) {
            return new a0.a(b0Var);
        }
        int i10 = iJ + 1;
        return new a0.a(b0Var, new b0(this.f42052d[i10], this.f42053e[i10]));
    }

    @Override // hb.a0
    public long h() {
        return this.f42054f;
    }
}
