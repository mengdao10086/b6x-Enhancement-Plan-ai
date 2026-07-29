package hb;

import hb.a0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements a0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f30826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f30827e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f30828f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long[] f30829g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long[] f30830h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f30831i;

    public e(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.f30827e = iArr;
        this.f30828f = jArr;
        this.f30829g = jArr2;
        this.f30830h = jArr3;
        int length = iArr.length;
        this.f30826d = length;
        if (length > 0) {
            this.f30831i = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f30831i = 0L;
        }
    }

    public int b(long j10) {
        return u0.j(this.f30830h, j10, true, true);
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        int iB = b(j10);
        b0 b0Var = new b0(this.f30830h[iB], this.f30828f[iB]);
        if (b0Var.f30805a >= j10 || iB == this.f30826d - 1) {
            return new a0.a(b0Var);
        }
        int i10 = iB + 1;
        return new a0.a(b0Var, new b0(this.f30830h[i10], this.f30828f[i10]));
    }

    @Override // hb.a0
    public long h() {
        return this.f30831i;
    }

    public String toString() {
        return "ChunkIndex(length=" + this.f30826d + ", sizes=" + Arrays.toString(this.f30827e) + ", offsets=" + Arrays.toString(this.f30828f) + ", timeUs=" + Arrays.toString(this.f30830h) + ", durationsUs=" + Arrays.toString(this.f30829g) + ee.a.f26979d;
    }
}
