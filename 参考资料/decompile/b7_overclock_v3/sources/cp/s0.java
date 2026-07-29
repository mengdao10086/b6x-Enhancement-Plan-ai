package cp;

import np.b2;

/* JADX INFO: loaded from: classes5.dex */
public class s0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25642d = 64;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25643e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f25644f = -5196783011329398165L;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f25645g = -7046029254386353131L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25646a = 12;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f25647b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25648c;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof b2)) {
            throw new IllegalArgumentException("invalid parameter passed to RC564 init - " + kVar.getClass().getName());
        }
        b2 b2Var = (b2) kVar;
        this.f25648c = z10;
        this.f25646a = b2Var.b();
        j(b2Var.a());
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "RC5-64";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        return this.f25648c ? g(bArr, i10, bArr2, i11) : f(bArr, i10, bArr2, i11);
    }

    public final long e(byte[] bArr, int i10) {
        long j10 = 0;
        for (int i11 = 7; i11 >= 0; i11--) {
            j10 = (j10 << 8) + ((long) (bArr[i11 + i10] & 255));
        }
        return j10;
    }

    public final int f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        long jE = e(bArr, i10);
        long jE2 = e(bArr, i10 + 8);
        for (int i12 = this.f25646a; i12 >= 1; i12--) {
            int i13 = i12 * 2;
            jE2 = i(jE2 - this.f25647b[i13 + 1], jE) ^ jE;
            jE = i(jE - this.f25647b[i13], jE2) ^ jE2;
        }
        k(jE - this.f25647b[0], bArr2, i11);
        k(jE2 - this.f25647b[1], bArr2, i11 + 8);
        return 16;
    }

    public final int g(byte[] bArr, int i10, byte[] bArr2, int i11) {
        long jE = e(bArr, i10) + this.f25647b[0];
        long jE2 = e(bArr, i10 + 8) + this.f25647b[1];
        for (int i12 = 1; i12 <= this.f25646a; i12++) {
            int i13 = i12 * 2;
            jE = h(jE ^ jE2, jE2) + this.f25647b[i13];
            jE2 = h(jE2 ^ jE, jE) + this.f25647b[i13 + 1];
        }
        k(jE, bArr2, i11);
        k(jE2, bArr2, i11 + 8);
        return 16;
    }

    public final long h(long j10, long j11) {
        long j12 = j11 & 63;
        return (j10 >>> ((int) (64 - j12))) | (j10 << ((int) j12));
    }

    public final long i(long j10, long j11) {
        long j12 = j11 & 63;
        return (j10 << ((int) (64 - j12))) | (j10 >>> ((int) j12));
    }

    public final void j(byte[] bArr) {
        long[] jArr;
        int length = (bArr.length + 7) / 8;
        long[] jArr2 = new long[length];
        for (int i10 = 0; i10 != bArr.length; i10++) {
            int i11 = i10 / 8;
            jArr2[i11] = jArr2[i11] + (((long) (bArr[i10] & 255)) << ((i10 % 8) * 8));
        }
        long[] jArr3 = new long[(this.f25646a + 1) * 2];
        this.f25647b = jArr3;
        jArr3[0] = -5196783011329398165L;
        int i12 = 1;
        while (true) {
            jArr = this.f25647b;
            if (i12 >= jArr.length) {
                break;
            }
            jArr[i12] = jArr[i12 - 1] + f25645g;
            i12++;
        }
        int length2 = length > jArr.length ? length * 3 : jArr.length * 3;
        long jH = 0;
        long jH2 = 0;
        int length3 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < length2; i14++) {
            long[] jArr4 = this.f25647b;
            jH = h(jArr4[length3] + jH + jH2, 3L);
            jArr4[length3] = jH;
            jH2 = h(jArr2[i13] + jH + jH2, jH2 + jH);
            jArr2[i13] = jH2;
            length3 = (length3 + 1) % this.f25647b.length;
            i13 = (i13 + 1) % length;
        }
    }

    public final void k(long j10, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i11 + i10] = (byte) j10;
            j10 >>>= 8;
        }
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
