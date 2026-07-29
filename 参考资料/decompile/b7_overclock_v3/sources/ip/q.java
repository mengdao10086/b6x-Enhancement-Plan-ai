package ip;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class q implements a0 {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f35559w = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.f f35560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f35561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f35563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f35564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f35567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f35568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f35569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f35570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f35571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35572m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f35573n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f35574o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final byte[] f35575p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f35576q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f35577r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f35578s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f35579t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f35580u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f35581v;

    public q() {
        this.f35561b = new byte[1];
        this.f35575p = new byte[16];
        this.f35576q = 0;
        this.f35560a = null;
    }

    public q(org.bouncycastle.crypto.f fVar) {
        this.f35561b = new byte[1];
        this.f35575p = new byte[16];
        this.f35576q = 0;
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        }
        this.f35560a = fVar;
    }

    public static final long e(int i10, int i11) {
        return (((long) i10) & 4294967295L) * ((long) i11);
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        if (this.f35560a == null) {
            bArrA = null;
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
            }
            v1 v1Var = (v1) kVar;
            bArrA = v1Var.a();
            kVar = v1Var.b();
        }
        if (!(kVar instanceof n1)) {
            throw new IllegalArgumentException("Poly1305 requires a key.");
        }
        g(((n1) kVar).a(), bArrA);
        reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        if (this.f35560a == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.f35560a.b();
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        if (i10 + 16 > bArr.length) {
            throw new OutputLengthException("Output buffer is too short.");
        }
        if (this.f35576q > 0) {
            f();
        }
        int i11 = this.f35578s;
        int i12 = this.f35577r;
        int i13 = i11 + (i12 >>> 26);
        int i14 = i12 & nr.b.f42627d;
        int i15 = this.f35579t + (i13 >>> 26);
        int i16 = i13 & nr.b.f42627d;
        int i17 = this.f35580u + (i15 >>> 26);
        int i18 = i15 & nr.b.f42627d;
        int i19 = this.f35581v + (i17 >>> 26);
        int i20 = i17 & nr.b.f42627d;
        int i21 = i14 + ((i19 >>> 26) * 5);
        int i22 = i19 & nr.b.f42627d;
        int i23 = i16 + (i21 >>> 26);
        int i24 = i21 & nr.b.f42627d;
        int i25 = i24 + 5;
        int i26 = i25 >>> 26;
        int i27 = i25 & nr.b.f42627d;
        int i28 = i26 + i23;
        int i29 = i28 >>> 26;
        int i30 = i28 & nr.b.f42627d;
        int i31 = i29 + i18;
        int i32 = i31 >>> 26;
        int i33 = i31 & nr.b.f42627d;
        int i34 = i32 + i20;
        int i35 = 67108863 & i34;
        int i36 = ((i34 >>> 26) + i22) - 67108864;
        int i37 = (i36 >>> 31) - 1;
        int i38 = ~i37;
        int i39 = (i24 & i38) | (i27 & i37);
        this.f35577r = i39;
        int i40 = (i23 & i38) | (i30 & i37);
        this.f35578s = i40;
        int i41 = (i18 & i38) | (i33 & i37);
        this.f35579t = i41;
        int i42 = (i35 & i37) | (i20 & i38);
        this.f35580u = i42;
        int i43 = (i22 & i38) | (i36 & i37);
        this.f35581v = i43;
        long j10 = (((long) (i39 | (i40 << 26))) & 4294967295L) + (((long) this.f35571l) & 4294967295L);
        long j11 = (((long) ((i40 >>> 6) | (i41 << 20))) & 4294967295L) + (((long) this.f35572m) & 4294967295L);
        long j12 = (((long) ((i41 >>> 12) | (i42 << 14))) & 4294967295L) + (((long) this.f35573n) & 4294967295L);
        long j13 = (((long) ((i42 >>> 18) | (i43 << 8))) & 4294967295L) + (4294967295L & ((long) this.f35574o));
        org.bouncycastle.util.o.m((int) j10, bArr, i10);
        long j14 = j11 + (j10 >>> 32);
        org.bouncycastle.util.o.m((int) j14, bArr, i10 + 4);
        long j15 = j12 + (j14 >>> 32);
        org.bouncycastle.util.o.m((int) j15, bArr, i10 + 8);
        org.bouncycastle.util.o.m((int) (j13 + (j15 >>> 32)), bArr, i10 + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return 16;
    }

    public final void f() {
        int i10 = this.f35576q;
        if (i10 < 16) {
            this.f35575p[i10] = 1;
            for (int i11 = i10 + 1; i11 < 16; i11++) {
                this.f35575p[i11] = 0;
            }
        }
        long jR = ((long) org.bouncycastle.util.o.r(this.f35575p, 0)) & 4294967295L;
        long jR2 = ((long) org.bouncycastle.util.o.r(this.f35575p, 4)) & 4294967295L;
        long jR3 = ((long) org.bouncycastle.util.o.r(this.f35575p, 8)) & 4294967295L;
        long jR4 = 4294967295L & ((long) org.bouncycastle.util.o.r(this.f35575p, 12));
        int i12 = (int) (((long) this.f35577r) + (jR & or.b.f44439a));
        this.f35577r = i12;
        this.f35578s = (int) (((long) this.f35578s) + ((((jR2 << 32) | jR) >>> 26) & or.b.f44439a));
        this.f35579t = (int) (((long) this.f35579t) + (((jR2 | (jR3 << 32)) >>> 20) & or.b.f44439a));
        this.f35580u = (int) (((long) this.f35580u) + ((((jR4 << 32) | jR3) >>> 14) & or.b.f44439a));
        int i13 = (int) (((long) this.f35581v) + (jR4 >>> 8));
        this.f35581v = i13;
        if (this.f35576q == 16) {
            this.f35581v = i13 + 16777216;
        }
        long jE = e(i12, this.f35562c) + e(this.f35578s, this.f35570k) + e(this.f35579t, this.f35569j) + e(this.f35580u, this.f35568i) + e(this.f35581v, this.f35567h);
        long jE2 = e(this.f35577r, this.f35563d) + e(this.f35578s, this.f35562c) + e(this.f35579t, this.f35570k) + e(this.f35580u, this.f35569j) + e(this.f35581v, this.f35568i);
        long jE3 = e(this.f35577r, this.f35564e) + e(this.f35578s, this.f35563d) + e(this.f35579t, this.f35562c) + e(this.f35580u, this.f35570k) + e(this.f35581v, this.f35569j);
        long jE4 = e(this.f35577r, this.f35565f) + e(this.f35578s, this.f35564e) + e(this.f35579t, this.f35563d) + e(this.f35580u, this.f35562c) + e(this.f35581v, this.f35570k);
        long jE5 = e(this.f35577r, this.f35566g) + e(this.f35578s, this.f35565f) + e(this.f35579t, this.f35564e) + e(this.f35580u, this.f35563d) + e(this.f35581v, this.f35562c);
        int i14 = ((int) jE) & nr.b.f42627d;
        long j10 = jE2 + (jE >>> 26);
        int i15 = ((int) j10) & nr.b.f42627d;
        long j11 = jE3 + (j10 >>> 26);
        this.f35579t = ((int) j11) & nr.b.f42627d;
        long j12 = jE4 + (j11 >>> 26);
        this.f35580u = ((int) j12) & nr.b.f42627d;
        long j13 = jE5 + (j12 >>> 26);
        this.f35581v = ((int) j13) & nr.b.f42627d;
        int i16 = i14 + (((int) (j13 >>> 26)) * 5);
        this.f35578s = i15 + (i16 >>> 26);
        this.f35577r = i16 & nr.b.f42627d;
    }

    public final void g(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        int i10 = 16;
        if (this.f35560a != null && (bArr2 == null || bArr2.length != 16)) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        int iR = org.bouncycastle.util.o.r(bArr, 0);
        int iR2 = org.bouncycastle.util.o.r(bArr, 4);
        int iR3 = org.bouncycastle.util.o.r(bArr, 8);
        int iR4 = org.bouncycastle.util.o.r(bArr, 12);
        this.f35562c = 67108863 & iR;
        int i11 = ((iR >>> 26) | (iR2 << 6)) & 67108611;
        this.f35563d = i11;
        int i12 = ((iR2 >>> 20) | (iR3 << 12)) & 67092735;
        this.f35564e = i12;
        int i13 = ((iR3 >>> 14) | (iR4 << 18)) & 66076671;
        this.f35565f = i13;
        int i14 = (iR4 >>> 8) & os.i.A;
        this.f35566g = i14;
        this.f35567h = i11 * 5;
        this.f35568i = i12 * 5;
        this.f35569j = i13 * 5;
        this.f35570k = i14 * 5;
        org.bouncycastle.crypto.f fVar = this.f35560a;
        if (fVar != null) {
            byte[] bArr3 = new byte[16];
            fVar.a(true, new n1(bArr, 16, 16));
            this.f35560a.d(bArr2, 0, bArr3, 0);
            bArr = bArr3;
            i10 = 0;
        }
        this.f35571l = org.bouncycastle.util.o.r(bArr, i10 + 0);
        this.f35572m = org.bouncycastle.util.o.r(bArr, i10 + 4);
        this.f35573n = org.bouncycastle.util.o.r(bArr, i10 + 8);
        this.f35574o = org.bouncycastle.util.o.r(bArr, i10 + 12);
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35576q = 0;
        this.f35581v = 0;
        this.f35580u = 0;
        this.f35579t = 0;
        this.f35578s = 0;
        this.f35577r = 0;
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) throws IllegalStateException {
        byte[] bArr = this.f35561b;
        bArr[0] = b10;
        update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) throws IllegalStateException, DataLengthException {
        int i12 = 0;
        while (i11 > i12) {
            if (this.f35576q == 16) {
                f();
                this.f35576q = 0;
            }
            int iMin = Math.min(i11 - i12, 16 - this.f35576q);
            System.arraycopy(bArr, i12 + i10, this.f35575p, this.f35576q, iMin);
            i12 += iMin;
            this.f35576q += iMin;
        }
    }
}
