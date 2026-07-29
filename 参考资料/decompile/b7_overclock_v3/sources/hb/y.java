package hb;

import hb.a0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f30926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f30927e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f30928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f30929g;

    public y(long[] jArr, long[] jArr2, long j10) {
        hd.a.a(jArr.length == jArr2.length);
        int length = jArr2.length;
        boolean z10 = length > 0;
        this.f30929g = z10;
        if (!z10 || jArr2[0] <= 0) {
            this.f30926d = jArr;
            this.f30927e = jArr2;
        } else {
            int i10 = length + 1;
            long[] jArr3 = new long[i10];
            this.f30926d = jArr3;
            long[] jArr4 = new long[i10];
            this.f30927e = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.f30928f = j10;
    }

    @Override // hb.a0
    public boolean e() {
        return this.f30929g;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        if (!this.f30929g) {
            return new a0.a(b0.f30804c);
        }
        int iJ = u0.j(this.f30927e, j10, true, true);
        b0 b0Var = new b0(this.f30927e[iJ], this.f30926d[iJ]);
        if (b0Var.f30805a == j10 || iJ == this.f30927e.length - 1) {
            return new a0.a(b0Var);
        }
        int i10 = iJ + 1;
        return new a0.a(b0Var, new b0(this.f30927e[i10], this.f30926d[i10]));
    }

    @Override // hb.a0
    public long h() {
        return this.f30928f;
    }
}
