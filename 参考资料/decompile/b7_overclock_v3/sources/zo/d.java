package zo;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: classes5.dex */
public class d implements org.bouncycastle.crypto.v, org.bouncycastle.util.m, org.bouncycastle.crypto.m0 {
    public static final int A = 32;
    public static final int B = 64;
    public static final int C = 0;
    public static final int D = 1;
    public static final int E = 2;
    public static final int F = 3;
    public static final int G = 4;
    public static final int H = 5;
    public static final int I = 6;
    public static final int J = 7;
    public static final int K = 8;
    public static final int L = 9;
    public static final int M = 10;
    public static final int N = 11;
    public static final int O = 12;
    public static final int P = 13;
    public static final int Q = 14;
    public static final int R = 15;
    public static final byte[] S = {2, 6, 3, 10, 7, 0, 4, 13, 1, 11, 12, 5, 9, 14, 15, 8};
    public static final byte[] T = {16, 12, 8, 7};
    public static final int[] U = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f59218q = "Already outputting";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f59219r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f59220s = 7;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f59221t = 64;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f59222u = 1024;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f59223v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f59224w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f59225x = 4;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f59226y = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f59227z = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f59228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f59229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f59230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f59231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f59232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f59233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Stack f59234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f59235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f59236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f59237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f59239l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f59240m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f59241n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f59242o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f59243p;

    public d() {
        this(32);
    }

    public d(int i10) {
        this.f59228a = new byte[64];
        this.f59229b = new int[8];
        this.f59230c = new int[8];
        this.f59231d = new int[16];
        this.f59232e = new int[16];
        this.f59233f = new byte[16];
        this.f59234g = new Stack();
        this.f59235h = i10;
        p(null);
    }

    public d(d dVar) {
        this.f59228a = new byte[64];
        this.f59229b = new int[8];
        this.f59230c = new int[8];
        this.f59231d = new int[16];
        this.f59232e = new int[16];
        this.f59233f = new byte[16];
        this.f59234g = new Stack();
        this.f59235h = dVar.f59235h;
        i(dVar);
    }

    public final void A() {
        byte b10 = 0;
        while (true) {
            byte[] bArr = this.f59233f;
            if (b10 >= bArr.length) {
                return;
            }
            bArr[b10] = S[bArr[b10]];
            b10 = (byte) (b10 + 1);
        }
    }

    public final void B() {
        while (!this.f59234g.isEmpty()) {
            System.arraycopy((int[]) this.f59234g.pop(), 0, this.f59232e, 0, 8);
            System.arraycopy(this.f59230c, 0, this.f59232e, 8, 8);
            w();
            if (this.f59234g.isEmpty()) {
                D();
            }
            l();
        }
    }

    public final void C() {
        this.f59241n = 0L;
        this.f59242o = 0;
    }

    public final void D() {
        int[] iArr = this.f59231d;
        iArr[15] = iArr[15] | 8;
        this.f59239l = iArr[15];
        this.f59240m = iArr[14];
        this.f59241n = 0L;
        this.f59236i = true;
        this.f59237j = -1L;
        System.arraycopy(iArr, 0, this.f59230c, 0, 8);
    }

    public final void a() {
        if (!this.f59236i) {
            for (int i10 = 0; i10 < 8; i10++) {
                int[] iArr = this.f59230c;
                int[] iArr2 = this.f59231d;
                iArr[i10] = iArr2[i10 + 8] ^ iArr2[i10];
            }
            return;
        }
        for (int i11 = 0; i11 < 8; i11++) {
            int[] iArr3 = this.f59231d;
            int i12 = i11 + 8;
            iArr3[i11] = iArr3[i11] ^ iArr3[i12];
            iArr3[i12] = iArr3[i12] ^ this.f59230c[i11];
        }
        for (int i13 = 0; i13 < 16; i13++) {
            org.bouncycastle.util.o.m(this.f59231d[i13], this.f59228a, i13 * 4);
        }
        this.f59243p = 0;
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "BLAKE3";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        return f(bArr, i10, h());
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new d(this);
    }

    @Override // org.bouncycastle.crypto.m0
    public int e(byte[] bArr, int i10, int i11) {
        int i12;
        if (!this.f59236i) {
            n(this.f59243p);
        }
        if (i11 >= 0) {
            long j10 = this.f59237j;
            if (j10 < 0 || i11 <= j10) {
                int i13 = this.f59243p;
                if (i13 < 64) {
                    int iMin = Math.min(i11, 64 - i13);
                    System.arraycopy(this.f59228a, this.f59243p, bArr, i10, iMin);
                    this.f59243p += iMin;
                    i10 += iMin;
                    i12 = i11 - iMin;
                } else {
                    i12 = i11;
                }
                while (i12 > 0) {
                    y();
                    int iMin2 = Math.min(i12, 64);
                    System.arraycopy(this.f59228a, 0, bArr, i10, iMin2);
                    this.f59243p += iMin2;
                    i10 += iMin2;
                    i12 -= iMin2;
                }
                this.f59237j -= (long) i11;
                return i11;
            }
        }
        throw new IllegalArgumentException("Insufficient bytes remaining");
    }

    @Override // org.bouncycastle.crypto.m0
    public int f(byte[] bArr, int i10, int i11) {
        if (this.f59236i) {
            throw new IllegalStateException(f59218q);
        }
        int iE = e(bArr, i10, i11);
        reset();
        return iE;
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return this.f59235h;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        d dVar = (d) mVar;
        this.f59241n = dVar.f59241n;
        this.f59242o = dVar.f59242o;
        this.f59238k = dVar.f59238k;
        this.f59236i = dVar.f59236i;
        this.f59237j = dVar.f59237j;
        this.f59239l = dVar.f59239l;
        this.f59240m = dVar.f59240m;
        int[] iArr = dVar.f59230c;
        int[] iArr2 = this.f59230c;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = dVar.f59229b;
        int[] iArr4 = this.f59229b;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = dVar.f59232e;
        int[] iArr6 = this.f59232e;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        this.f59234g.clear();
        Iterator it2 = dVar.f59234g.iterator();
        while (it2.hasNext()) {
            this.f59234g.push(org.bouncycastle.util.a.s((int[]) it2.next()));
        }
        byte[] bArr = dVar.f59228a;
        byte[] bArr2 = this.f59228a;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f59243p = dVar.f59243p;
    }

    public final void k() {
        for (long j10 = this.f59241n; j10 > 0 && (j10 & 1) != 1; j10 >>= 1) {
            System.arraycopy((int[]) this.f59234g.pop(), 0, this.f59232e, 0, 8);
            System.arraycopy(this.f59230c, 0, this.f59232e, 8, 8);
            w();
            l();
        }
        this.f59234g.push(org.bouncycastle.util.a.R(this.f59230c, 8));
    }

    public final void l() {
        r();
        int i10 = 0;
        while (true) {
            z();
            if (i10 >= 6) {
                a();
                return;
            } else {
                A();
                i10++;
            }
        }
    }

    public final void m(byte[] bArr, int i10) {
        q(64, false);
        u(bArr, i10);
        l();
        if (this.f59242o == 0) {
            k();
        }
    }

    public final void n(int i10) {
        q(i10, true);
        u(this.f59228a, 0);
        l();
        B();
    }

    public final void o() {
        this.f59241n++;
        this.f59242o = 0;
    }

    public void p(np.d dVar) {
        byte[] bArrD = dVar == null ? null : dVar.d();
        byte[] bArrC = dVar != null ? dVar.c() : null;
        reset();
        if (bArrD != null) {
            s(bArrD);
            org.bouncycastle.util.a.d0(bArrD, (byte) 0);
            return;
        }
        v();
        if (bArrC == null) {
            this.f59238k = 0;
            return;
        }
        this.f59238k = 32;
        update(bArrC, 0, bArrC.length);
        c(this.f59228a, 0);
        t();
        reset();
    }

    public final void q(int i10, boolean z10) {
        System.arraycopy(this.f59242o == 0 ? this.f59229b : this.f59230c, 0, this.f59231d, 0, 8);
        System.arraycopy(U, 0, this.f59231d, 8, 4);
        int[] iArr = this.f59231d;
        long j10 = this.f59241n;
        iArr[12] = (int) j10;
        iArr[13] = (int) (j10 >> 32);
        iArr[14] = i10;
        int i11 = this.f59238k;
        int i12 = this.f59242o;
        iArr[15] = i11 + (i12 == 0 ? 1 : 0) + (z10 ? 2 : 0);
        int i13 = i12 + i10;
        this.f59242o = i13;
        if (i13 >= 1024) {
            o();
            int[] iArr2 = this.f59231d;
            iArr2[15] = iArr2[15] | 2;
        }
        if (z10 && this.f59234g.isEmpty()) {
            D();
        }
    }

    public final void r() {
        byte b10 = 0;
        while (true) {
            byte[] bArr = this.f59233f;
            if (b10 >= bArr.length) {
                return;
            }
            bArr[b10] = b10;
            b10 = (byte) (b10 + 1);
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        C();
        this.f59243p = 0;
        this.f59236i = false;
        org.bouncycastle.util.a.d0(this.f59228a, (byte) 0);
    }

    public final void s(byte[] bArr) {
        for (int i10 = 0; i10 < 8; i10++) {
            this.f59229b[i10] = org.bouncycastle.util.o.r(bArr, i10 * 4);
        }
        this.f59238k = 16;
    }

    public final void t() {
        System.arraycopy(this.f59231d, 0, this.f59229b, 0, 8);
        this.f59238k = 64;
    }

    public final void u(byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 16; i11++) {
            this.f59232e[i11] = org.bouncycastle.util.o.r(bArr, (i11 * 4) + i10);
        }
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        if (this.f59236i) {
            throw new IllegalStateException(f59218q);
        }
        byte[] bArr = this.f59228a;
        if (bArr.length - this.f59243p == 0) {
            m(bArr, 0);
            org.bouncycastle.util.a.d0(this.f59228a, (byte) 0);
            this.f59243p = 0;
        }
        byte[] bArr2 = this.f59228a;
        int i10 = this.f59243p;
        bArr2[i10] = b10;
        this.f59243p = i10 + 1;
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        if (bArr == null || i11 == 0) {
            return;
        }
        if (this.f59236i) {
            throw new IllegalStateException(f59218q);
        }
        int i14 = this.f59243p;
        if (i14 != 0) {
            i12 = 64 - i14;
            if (i12 >= i11) {
                System.arraycopy(bArr, i10, this.f59228a, i14, i11);
                i13 = this.f59243p + i11;
                this.f59243p = i13;
            } else {
                System.arraycopy(bArr, i10, this.f59228a, i14, i12);
                m(this.f59228a, 0);
                this.f59243p = 0;
                org.bouncycastle.util.a.d0(this.f59228a, (byte) 0);
            }
        } else {
            i12 = 0;
        }
        int i15 = (i10 + i11) - 64;
        int i16 = i12 + i10;
        while (i16 < i15) {
            m(bArr, i16);
            i16 += 64;
        }
        int i17 = i10 + (i11 - i16);
        System.arraycopy(bArr, i16, this.f59228a, 0, i17);
        i13 = this.f59243p + i17;
        this.f59243p = i13;
    }

    public final void v() {
        System.arraycopy(U, 0, this.f59229b, 0, 8);
    }

    public final void w() {
        System.arraycopy(this.f59229b, 0, this.f59231d, 0, 8);
        System.arraycopy(U, 0, this.f59231d, 8, 4);
        int[] iArr = this.f59231d;
        iArr[12] = 0;
        iArr[13] = 0;
        iArr[14] = 64;
        iArr[15] = this.f59238k | 4;
    }

    public final void x(int i10, int i11, int i12, int i13, int i14) {
        int i15 = i10 << 1;
        int[] iArr = this.f59231d;
        int i16 = i15 + 1;
        iArr[i11] = iArr[i11] + iArr[i12] + this.f59232e[this.f59233f[i15]];
        int i17 = iArr[i14] ^ iArr[i11];
        byte[] bArr = T;
        iArr[i14] = org.bouncycastle.util.j.f(i17, bArr[0]);
        int[] iArr2 = this.f59231d;
        iArr2[i13] = iArr2[i13] + iArr2[i14];
        iArr2[i12] = org.bouncycastle.util.j.f(iArr2[i12] ^ iArr2[i13], bArr[1]);
        int[] iArr3 = this.f59231d;
        iArr3[i11] = iArr3[i11] + iArr3[i12] + this.f59232e[this.f59233f[i16]];
        iArr3[i14] = org.bouncycastle.util.j.f(iArr3[i11] ^ iArr3[i14], bArr[2]);
        int[] iArr4 = this.f59231d;
        iArr4[i13] = iArr4[i13] + iArr4[i14];
        iArr4[i12] = org.bouncycastle.util.j.f(iArr4[i12] ^ iArr4[i13], bArr[3]);
    }

    public final void y() {
        this.f59241n++;
        System.arraycopy(this.f59230c, 0, this.f59231d, 0, 8);
        System.arraycopy(U, 0, this.f59231d, 8, 4);
        int[] iArr = this.f59231d;
        long j10 = this.f59241n;
        iArr[12] = (int) j10;
        iArr[13] = (int) (j10 >> 32);
        iArr[14] = this.f59240m;
        iArr[15] = this.f59239l;
        l();
    }

    public final void z() {
        x(0, 0, 4, 8, 12);
        x(1, 1, 5, 9, 13);
        x(2, 2, 6, 10, 14);
        x(3, 3, 7, 11, 15);
        x(4, 0, 5, 10, 15);
        x(5, 1, 6, 11, 12);
        x(6, 2, 7, 8, 13);
        x(7, 3, 4, 9, 14);
    }
}
