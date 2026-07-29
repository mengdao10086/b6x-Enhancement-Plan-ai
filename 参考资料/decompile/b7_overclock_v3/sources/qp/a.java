package qp;

import com.blankj.utilcode.util.ThreadUtils;
import jt.h;
import np.n1;

/* JADX INFO: loaded from: classes5.dex */
public class a implements f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f47531j = 2147483648L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f47532k = 140737488355328L;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f47533l = 4096;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f47534m = 262144;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f47535n = h.d("000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E1F");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pp.d f47536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.f f47537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f47539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f47540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f47541f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f47542g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f47543h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f47544i;

    public a(org.bouncycastle.crypto.f fVar, int i10, int i11, pp.d dVar, byte[] bArr, byte[] bArr2) {
        this.f47544i = false;
        this.f47536a = dVar;
        this.f47537b = fVar;
        this.f47538c = i10;
        this.f47540e = i11;
        this.f47539d = (fVar.c() * 8) + i10;
        this.f47544i = o(fVar);
        if (i11 > 256) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (n(fVar, i10) < i11) {
            throw new IllegalArgumentException("Requested security strength is not supported by block cipher and key size");
        }
        if (dVar.c() < i11) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        f(m(), bArr2, bArr);
    }

    @Override // qp.f
    public void a(byte[] bArr) {
        g(bArr);
    }

    @Override // qp.f
    public int b(byte[] bArr, byte[] bArr2, boolean z10) {
        byte[] bArrE;
        boolean z11 = this.f47544i;
        long j10 = this.f47543h;
        if (z11) {
            if (j10 > 2147483648L) {
                return -1;
            }
            if (g.d(bArr, 512)) {
                throw new IllegalArgumentException("Number of bits per request limited to 4096");
            }
        } else {
            if (j10 > 140737488355328L) {
                return -1;
            }
            if (g.d(bArr, 32768)) {
                throw new IllegalArgumentException("Number of bits per request limited to 262144");
            }
        }
        if (z10) {
            g(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            bArrE = e(bArr2, this.f47539d);
            h(bArrE, this.f47541f, this.f47542g);
        } else {
            bArrE = new byte[this.f47539d / 8];
        }
        int length = this.f47542g.length;
        byte[] bArr3 = new byte[length];
        this.f47537b.a(true, new n1(l(this.f47541f)));
        for (int i10 = 0; i10 <= bArr.length / length; i10++) {
            int i11 = i10 * length;
            int length2 = bArr.length - i11 > length ? length : bArr.length - (this.f47542g.length * i10);
            if (length2 != 0) {
                j(this.f47542g);
                this.f47537b.d(this.f47542g, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i11, length2);
            }
        }
        h(bArrE, this.f47541f, this.f47542g);
        this.f47543h++;
        return bArr.length * 8;
    }

    @Override // qp.f
    public int c() {
        return this.f47542g.length * 8;
    }

    public final void d(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int iC = this.f47537b.c();
        byte[] bArr5 = new byte[iC];
        int length = bArr4.length / iC;
        byte[] bArr6 = new byte[iC];
        this.f47537b.a(true, new n1(l(bArr2)));
        this.f47537b.d(bArr3, 0, bArr5, 0);
        for (int i10 = 0; i10 < length; i10++) {
            i(bArr6, bArr5, bArr4, i10 * iC);
            this.f47537b.d(bArr6, 0, bArr5, 0);
        }
        System.arraycopy(bArr5, 0, bArr, 0, bArr.length);
    }

    public final byte[] e(byte[] bArr, int i10) {
        int iC = this.f47537b.c();
        int length = bArr.length;
        int i11 = i10 / 8;
        int i12 = length + 8;
        byte[] bArr2 = new byte[((((i12 + 1) + iC) - 1) / iC) * iC];
        k(bArr2, length, 0);
        k(bArr2, i11, 4);
        System.arraycopy(bArr, 0, bArr2, 8, length);
        bArr2[i12] = -128;
        int i13 = this.f47538c;
        int i14 = (i13 / 8) + iC;
        byte[] bArr3 = new byte[i14];
        byte[] bArr4 = new byte[iC];
        byte[] bArr5 = new byte[iC];
        int i15 = i13 / 8;
        byte[] bArr6 = new byte[i15];
        System.arraycopy(f47535n, 0, bArr6, 0, i15);
        int i16 = 0;
        while (true) {
            int i17 = i16 * iC;
            if (i17 * 8 >= this.f47538c + (iC * 8)) {
                break;
            }
            k(bArr5, i16, 0);
            d(bArr4, bArr6, bArr5, bArr2);
            int i18 = i14 - i17;
            if (i18 > iC) {
                i18 = iC;
            }
            System.arraycopy(bArr4, 0, bArr3, i17, i18);
            i16++;
        }
        byte[] bArr7 = new byte[iC];
        System.arraycopy(bArr3, 0, bArr6, 0, i15);
        System.arraycopy(bArr3, i15, bArr7, 0, iC);
        byte[] bArr8 = new byte[i11];
        this.f47537b.a(true, new n1(l(bArr6)));
        int i19 = 0;
        while (true) {
            int i20 = i19 * iC;
            if (i20 >= i11) {
                return bArr8;
            }
            this.f47537b.d(bArr7, 0, bArr7, 0);
            int i21 = i11 - i20;
            if (i21 > iC) {
                i21 = iC;
            }
            System.arraycopy(bArr7, 0, bArr8, i20, i21);
            i19++;
        }
    }

    public final void f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrE = e(org.bouncycastle.util.a.C(bArr, bArr2, bArr3), this.f47539d);
        int iC = this.f47537b.c();
        byte[] bArr4 = new byte[(this.f47538c + 7) / 8];
        this.f47541f = bArr4;
        byte[] bArr5 = new byte[iC];
        this.f47542g = bArr5;
        h(bArrE, bArr4, bArr5);
        this.f47543h = 1L;
    }

    public final void g(byte[] bArr) {
        h(e(org.bouncycastle.util.a.B(m(), bArr), this.f47539d), this.f47541f, this.f47542g);
        this.f47543h = 1L;
    }

    public final void h(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        byte[] bArr4 = new byte[length];
        byte[] bArr5 = new byte[this.f47537b.c()];
        int iC = this.f47537b.c();
        this.f47537b.a(true, new n1(l(bArr2)));
        int i10 = 0;
        while (true) {
            int i11 = i10 * iC;
            if (i11 >= bArr.length) {
                i(bArr4, bArr, bArr4, 0);
                System.arraycopy(bArr4, 0, bArr2, 0, bArr2.length);
                System.arraycopy(bArr4, bArr2.length, bArr3, 0, bArr3.length);
                return;
            } else {
                j(bArr3);
                this.f47537b.d(bArr3, 0, bArr5, 0);
                int i12 = length - i11;
                if (i12 > iC) {
                    i12 = iC;
                }
                System.arraycopy(bArr5, 0, bArr4, i11, i12);
                i10++;
            }
        }
    }

    public final void i(byte[] bArr, byte[] bArr2, byte[] bArr3, int i10) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr2[i11] ^ bArr3[i11 + i10]);
        }
    }

    public final void j(byte[] bArr) {
        int i10 = 1;
        for (int i11 = 1; i11 <= bArr.length; i11++) {
            int i12 = (bArr[bArr.length - i11] & 255) + i10;
            i10 = i12 > 255 ? 1 : 0;
            bArr[bArr.length - i11] = (byte) i12;
        }
    }

    public final void k(byte[] bArr, int i10, int i11) {
        bArr[i11 + 0] = (byte) (i10 >> 24);
        bArr[i11 + 1] = (byte) (i10 >> 16);
        bArr[i11 + 2] = (byte) (i10 >> 8);
        bArr[i11 + 3] = (byte) i10;
    }

    public byte[] l(byte[] bArr) {
        if (!this.f47544i) {
            return bArr;
        }
        byte[] bArr2 = new byte[24];
        p(bArr, 0, bArr2, 0);
        p(bArr, 7, bArr2, 8);
        p(bArr, 14, bArr2, 16);
        return bArr2;
    }

    public final byte[] m() {
        byte[] bArrA = this.f47536a.a();
        if (bArrA.length >= (this.f47540e + 7) / 8) {
            return bArrA;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    public final int n(org.bouncycastle.crypto.f fVar, int i10) {
        if (o(fVar) && i10 == 168) {
            return 112;
        }
        if (fVar.b().equals(m5.b.f40641c)) {
            return i10;
        }
        return -1;
    }

    public final boolean o(org.bouncycastle.crypto.f fVar) {
        return fVar.b().equals("DESede") || fVar.b().equals("TDEA");
    }

    public final void p(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int i12 = i10 + 0;
        bArr2[i11 + 0] = (byte) (bArr[i12] & 254);
        int i13 = i10 + 1;
        bArr2[i11 + 1] = (byte) ((bArr[i12] << 7) | ((bArr[i13] & 252) >>> 1));
        int i14 = bArr[i13] << 6;
        int i15 = i10 + 2;
        bArr2[i11 + 2] = (byte) (i14 | ((bArr[i15] & ThreadUtils.f11619i) >>> 2));
        int i16 = bArr[i15] << 5;
        int i17 = i10 + 3;
        bArr2[i11 + 3] = (byte) (i16 | ((bArr[i17] & 240) >>> 3));
        int i18 = bArr[i17] << 4;
        int i19 = i10 + 4;
        bArr2[i11 + 4] = (byte) (i18 | ((bArr[i19] & 224) >>> 4));
        int i20 = bArr[i19] << 3;
        int i21 = i10 + 5;
        bArr2[i11 + 5] = (byte) (i20 | ((bArr[i21] & i1.a.f31667o7) >>> 5));
        int i22 = i10 + 6;
        bArr2[i11 + 6] = (byte) ((bArr[i21] << 2) | ((bArr[i22] & 128) >>> 6));
        int i23 = i11 + 7;
        bArr2[i23] = (byte) (bArr[i22] << 1);
        while (i11 <= i23) {
            byte b10 = bArr2[i11];
            bArr2[i11] = (byte) (((((b10 >> 7) ^ ((((((b10 >> 1) ^ (b10 >> 2)) ^ (b10 >> 3)) ^ (b10 >> 4)) ^ (b10 >> 5)) ^ (b10 >> 6))) ^ 1) & 1) | (b10 & 254));
            i11++;
        }
    }
}
