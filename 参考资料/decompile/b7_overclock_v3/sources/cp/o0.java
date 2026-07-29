package cp;

import np.a2;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class o0 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static byte[] f25587c = {i1.a.E7, tc.a.f51065w, -7, -60, 25, -35, -75, -19, 40, -23, -3, 121, 74, -96, i1.a.f31659n7, -99, i1.a.f31707t7, 126, 55, -125, rc.a.f48411c0, 118, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, 125, 50, -67, -113, 64, -21, -122, -73, 123, 11, -16, -107, rc.a.V, 34, 92, 107, 78, -126, 84, -42, 101, -109, i1.a.f31759z7, jt.l.f36952t, -78, 28, 115, 86, i1.a.f31667o7, 20, -89, -116, -15, -36, 18, 117, i1.a.f31732w7, 31, 59, -66, -28, -47, 66, 61, -44, jt.l.f36949q, -93, 60, -74, rc.a.Y, pq.b.f46991h, -65, 14, i1.a.B7, 70, 105, 7, 87, rc.a.Z, -14, 29, -101, rp.u.f49086t, -108, 67, 3, -8, 17, i1.a.f31714u7, -10, -112, -17, 62, -25, 6, i1.a.f31691r7, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, -128, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, 42, -106, 26, -46, pq.b.f46993j, 90, 21, 73, 116, 75, -97, -48, 94, 4, 24, -92, -20, i1.a.f31683q7, -32, 65, pq.b.f46992i, 15, 81, i1.a.f31741x7, -52, rc.a.W, -111, -81, jt.l.f36951s, -95, -12, pq.b.f46994k, 57, -103, 124, 58, -123, 35, -72, -76, 122, -4, 2, 54, 91, rc.a.X, 85, -105, 49, rc.a.f48413e0, 93, -6, -104, -29, -118, -110, -82, 5, -33, rc.a.f48409a0, 16, 103, 108, -70, i1.a.f31723v7, -45, 0, -26, i1.a.A7, -31, -98, -88, rc.a.f48412d0, 99, 22, 1, okio.w0.f44229a, o5.b.f42741j, -30, -119, -87, 13, 56, 52, 27, -85, 51, -1, -80, -69, 72, 12, 95, -71, -79, i1.a.f31750y7, rc.a.f48414f0, i1.a.f31699s7, -13, -37, 71, -27, -91, -100, 119, 10, -90, 32, 104, -2, 127, i1.a.f31675p7, -83};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25588d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f25589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25590b;

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f25590b = z10;
        if (kVar instanceof a2) {
            a2 a2Var = (a2) kVar;
            this.f25589a = g(a2Var.a(), a2Var.b());
        } else if (kVar instanceof np.n1) {
            byte[] bArrA = ((np.n1) kVar).a();
            this.f25589a = g(bArrA, bArrA.length * 8);
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC2 init - " + kVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "RC2";
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.f
    public final int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (this.f25589a == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        }
        if (i10 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f25590b) {
            f(bArr, i10, bArr2, i11);
            return 8;
        }
        e(bArr, i10, bArr2, i11);
        return 8;
    }

    public final void e(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iH = ((bArr[i10 + 7] & 255) << 8) + (bArr[i10 + 6] & 255);
        int iH2 = ((bArr[i10 + 5] & 255) << 8) + (bArr[i10 + 4] & 255);
        int iH3 = ((bArr[i10 + 3] & 255) << 8) + (bArr[i10 + 2] & 255);
        int iH4 = ((bArr[i10 + 1] & 255) << 8) + (bArr[i10 + 0] & 255);
        for (int i12 = 60; i12 >= 44; i12 -= 4) {
            iH = h(iH, 11) - ((((~iH2) & iH4) + (iH3 & iH2)) + this.f25589a[i12 + 3]);
            iH2 = h(iH2, 13) - ((((~iH3) & iH) + (iH4 & iH3)) + this.f25589a[i12 + 2]);
            iH3 = h(iH3, 14) - ((((~iH4) & iH2) + (iH & iH4)) + this.f25589a[i12 + 1]);
            iH4 = h(iH4, 15) - ((((~iH) & iH3) + (iH2 & iH)) + this.f25589a[i12]);
        }
        int[] iArr = this.f25589a;
        int iH5 = iH - iArr[iH2 & 63];
        int iH6 = iH2 - iArr[iH3 & 63];
        int iH7 = iH3 - iArr[iH4 & 63];
        int iH8 = iH4 - iArr[iH5 & 63];
        for (int i13 = 40; i13 >= 20; i13 -= 4) {
            iH5 = h(iH5, 11) - ((((~iH6) & iH8) + (iH7 & iH6)) + this.f25589a[i13 + 3]);
            iH6 = h(iH6, 13) - ((((~iH7) & iH5) + (iH8 & iH7)) + this.f25589a[i13 + 2]);
            iH7 = h(iH7, 14) - ((((~iH8) & iH6) + (iH5 & iH8)) + this.f25589a[i13 + 1]);
            iH8 = h(iH8, 15) - ((((~iH5) & iH7) + (iH6 & iH5)) + this.f25589a[i13]);
        }
        int[] iArr2 = this.f25589a;
        int iH9 = iH5 - iArr2[iH6 & 63];
        int iH10 = iH6 - iArr2[iH7 & 63];
        int iH11 = iH7 - iArr2[iH8 & 63];
        int iH12 = iH8 - iArr2[iH9 & 63];
        for (int i14 = 16; i14 >= 0; i14 -= 4) {
            iH9 = h(iH9, 11) - ((((~iH10) & iH12) + (iH11 & iH10)) + this.f25589a[i14 + 3]);
            iH10 = h(iH10, 13) - ((((~iH11) & iH9) + (iH12 & iH11)) + this.f25589a[i14 + 2]);
            iH11 = h(iH11, 14) - ((((~iH12) & iH10) + (iH9 & iH12)) + this.f25589a[i14 + 1]);
            iH12 = h(iH12, 15) - ((((~iH9) & iH11) + (iH10 & iH9)) + this.f25589a[i14]);
        }
        bArr2[i11 + 0] = (byte) iH12;
        bArr2[i11 + 1] = (byte) (iH12 >> 8);
        bArr2[i11 + 2] = (byte) iH11;
        bArr2[i11 + 3] = (byte) (iH11 >> 8);
        bArr2[i11 + 4] = (byte) iH10;
        bArr2[i11 + 5] = (byte) (iH10 >> 8);
        bArr2[i11 + 6] = (byte) iH9;
        bArr2[i11 + 7] = (byte) (iH9 >> 8);
    }

    public final void f(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int iH = ((bArr[i10 + 7] & 255) << 8) + (bArr[i10 + 6] & 255);
        int iH2 = ((bArr[i10 + 5] & 255) << 8) + (bArr[i10 + 4] & 255);
        int iH3 = ((bArr[i10 + 3] & 255) << 8) + (bArr[i10 + 2] & 255);
        int iH4 = ((bArr[i10 + 1] & 255) << 8) + (bArr[i10 + 0] & 255);
        for (int i12 = 0; i12 <= 16; i12 += 4) {
            iH4 = h(iH4 + ((~iH) & iH3) + (iH2 & iH) + this.f25589a[i12], 1);
            iH3 = h(iH3 + ((~iH4) & iH2) + (iH & iH4) + this.f25589a[i12 + 1], 2);
            iH2 = h(iH2 + ((~iH3) & iH) + (iH4 & iH3) + this.f25589a[i12 + 2], 3);
            iH = h(iH + ((~iH2) & iH4) + (iH3 & iH2) + this.f25589a[i12 + 3], 5);
        }
        int[] iArr = this.f25589a;
        int iH5 = iH4 + iArr[iH & 63];
        int iH6 = iH3 + iArr[iH5 & 63];
        int iH7 = iH2 + iArr[iH6 & 63];
        int iH8 = iH + iArr[iH7 & 63];
        for (int i13 = 20; i13 <= 40; i13 += 4) {
            iH5 = h(iH5 + ((~iH8) & iH6) + (iH7 & iH8) + this.f25589a[i13], 1);
            iH6 = h(iH6 + ((~iH5) & iH7) + (iH8 & iH5) + this.f25589a[i13 + 1], 2);
            iH7 = h(iH7 + ((~iH6) & iH8) + (iH5 & iH6) + this.f25589a[i13 + 2], 3);
            iH8 = h(iH8 + ((~iH7) & iH5) + (iH6 & iH7) + this.f25589a[i13 + 3], 5);
        }
        int[] iArr2 = this.f25589a;
        int iH9 = iH5 + iArr2[iH8 & 63];
        int iH10 = iH6 + iArr2[iH9 & 63];
        int iH11 = iH7 + iArr2[iH10 & 63];
        int iH12 = iH8 + iArr2[iH11 & 63];
        for (int i14 = 44; i14 < 64; i14 += 4) {
            iH9 = h(iH9 + ((~iH12) & iH10) + (iH11 & iH12) + this.f25589a[i14], 1);
            iH10 = h(iH10 + ((~iH9) & iH11) + (iH12 & iH9) + this.f25589a[i14 + 1], 2);
            iH11 = h(iH11 + ((~iH10) & iH12) + (iH9 & iH10) + this.f25589a[i14 + 2], 3);
            iH12 = h(iH12 + ((~iH11) & iH9) + (iH10 & iH11) + this.f25589a[i14 + 3], 5);
        }
        bArr2[i11 + 0] = (byte) iH9;
        bArr2[i11 + 1] = (byte) (iH9 >> 8);
        bArr2[i11 + 2] = (byte) iH10;
        bArr2[i11 + 3] = (byte) (iH10 >> 8);
        bArr2[i11 + 4] = (byte) iH11;
        bArr2[i11 + 5] = (byte) (iH11 >> 8);
        bArr2[i11 + 6] = (byte) iH12;
        bArr2[i11 + 7] = (byte) (iH12 >> 8);
    }

    public final int[] g(byte[] bArr, int i10) {
        int[] iArr = new int[128];
        for (int i11 = 0; i11 != bArr.length; i11++) {
            iArr[i11] = bArr[i11] & 255;
        }
        int length = bArr.length;
        if (length < 128) {
            int i12 = iArr[length - 1];
            int i13 = 0;
            while (true) {
                int i14 = i13 + 1;
                i12 = f25587c[(i12 + iArr[i13]) & 255] & 255;
                int i15 = length + 1;
                iArr[length] = i12;
                if (i15 >= 128) {
                    break;
                }
                length = i15;
                i13 = i14;
            }
        }
        int i16 = (i10 + 7) >> 3;
        int i17 = 128 - i16;
        int i18 = f25587c[(255 >> ((-i10) & 7)) & iArr[i17]] & 255;
        iArr[i17] = i18;
        for (int i19 = i17 - 1; i19 >= 0; i19--) {
            i18 = f25587c[i18 ^ iArr[i19 + i16]] & 255;
            iArr[i19] = i18;
        }
        int[] iArr2 = new int[64];
        for (int i20 = 0; i20 != 64; i20++) {
            int i21 = i20 * 2;
            iArr2[i20] = iArr[i21] + (iArr[i21 + 1] << 8);
        }
        return iArr2;
    }

    public final int h(int i10, int i11) {
        int i12 = i10 & 65535;
        return (i12 >> (16 - i11)) | (i12 << i11);
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
