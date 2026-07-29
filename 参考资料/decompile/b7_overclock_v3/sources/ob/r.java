package ob;

import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f43311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f43312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f43313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f43314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f43315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f43316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f43317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f43318h;

    public r(o oVar, long[] jArr, int[] iArr, int i10, long[] jArr2, int[] iArr2, long j10) {
        hd.a.a(iArr.length == jArr2.length);
        hd.a.a(jArr.length == jArr2.length);
        hd.a.a(iArr2.length == jArr2.length);
        this.f43311a = oVar;
        this.f43313c = jArr;
        this.f43314d = iArr;
        this.f43315e = i10;
        this.f43316f = jArr2;
        this.f43317g = iArr2;
        this.f43318h = j10;
        this.f43312b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j10) {
        for (int iJ = u0.j(this.f43316f, j10, true, false); iJ >= 0; iJ--) {
            if ((this.f43317g[iJ] & 1) != 0) {
                return iJ;
            }
        }
        return -1;
    }

    public int b(long j10) {
        for (int iF = u0.f(this.f43316f, j10, true, false); iF < this.f43316f.length; iF++) {
            if ((this.f43317g[iF] & 1) != 0) {
                return iF;
            }
        }
        return -1;
    }
}
