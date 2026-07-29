package nr;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42630a = 56;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42631b = 56;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42632c = 156326;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42633d = 39082;

    public static class a extends d {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f42634a = new b();
    }

    public static boolean a(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        h(bArr, i10, bArr2, i11, bArr3, i12);
        return !org.bouncycastle.util.a.e(bArr3, i12, 56);
    }

    public static int b(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void c(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < 14; i11++) {
            iArr[i11] = b(bArr, (i11 * 4) + i10);
        }
        iArr[0] = iArr[0] & (-4);
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
    }

    public static void d(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & 252);
        bArr[55] = (byte) (bArr[55] | 128);
    }

    public static void e(byte[] bArr, int i10, byte[] bArr2, int i11) {
        i(bArr, i10, bArr2, i11);
    }

    public static void f(int[] iArr, int[] iArr2) {
        int[] iArrJ = d.j();
        int[] iArrJ2 = d.j();
        d.a(iArr, iArr2, iArrJ);
        d.O(iArr, iArr2, iArrJ2);
        d.M(iArrJ, iArrJ);
        d.M(iArrJ2, iArrJ2);
        d.F(iArrJ, iArrJ2, iArr);
        d.O(iArrJ, iArrJ2, iArrJ);
        d.E(iArrJ, f42633d, iArr2);
        d.a(iArr2, iArrJ2, iArr2);
        d.F(iArr2, iArrJ, iArr2);
    }

    public static void g() {
        or.b.P();
    }

    public static void h(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int[] iArr = new int[14];
        c(bArr, i10, iArr);
        int[] iArrJ = d.j();
        d.m(bArr2, i11, iArrJ);
        int[] iArrJ2 = d.j();
        d.i(iArrJ, 0, iArrJ2, 0);
        int[] iArrJ3 = d.j();
        iArrJ3[0] = 1;
        int[] iArrJ4 = d.j();
        iArrJ4[0] = 1;
        int[] iArrJ5 = d.j();
        int[] iArrJ6 = d.j();
        int[] iArrJ7 = d.j();
        int i13 = 447;
        int i14 = 1;
        while (true) {
            d.a(iArrJ4, iArrJ5, iArrJ6);
            d.O(iArrJ4, iArrJ5, iArrJ4);
            d.a(iArrJ2, iArrJ3, iArrJ5);
            d.O(iArrJ2, iArrJ3, iArrJ2);
            d.F(iArrJ6, iArrJ2, iArrJ6);
            d.F(iArrJ4, iArrJ5, iArrJ4);
            d.M(iArrJ5, iArrJ5);
            d.M(iArrJ2, iArrJ2);
            d.O(iArrJ5, iArrJ2, iArrJ7);
            d.E(iArrJ7, f42633d, iArrJ3);
            d.a(iArrJ3, iArrJ2, iArrJ3);
            d.F(iArrJ3, iArrJ7, iArrJ3);
            d.F(iArrJ2, iArrJ5, iArrJ2);
            d.O(iArrJ6, iArrJ4, iArrJ5);
            d.a(iArrJ6, iArrJ4, iArrJ4);
            d.M(iArrJ4, iArrJ4);
            d.M(iArrJ5, iArrJ5);
            d.F(iArrJ5, iArrJ, iArrJ5);
            i13--;
            int i15 = (iArr[i13 >>> 5] >>> (i13 & 31)) & 1;
            int i16 = i14 ^ i15;
            d.l(i16, iArrJ2, iArrJ4);
            d.l(i16, iArrJ3, iArrJ5);
            if (i13 < 2) {
                break;
            } else {
                i14 = i15;
            }
        }
        for (int i17 = 0; i17 < 2; i17++) {
            f(iArrJ2, iArrJ3);
        }
        d.y(iArrJ3, iArrJ3);
        d.F(iArrJ2, iArrJ3, iArrJ2);
        d.H(iArrJ2);
        d.s(iArrJ2, bArr3, i12);
    }

    public static void i(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[] iArrJ = d.j();
        int[] iArrJ2 = d.j();
        or.b.V(b.f42634a, bArr, i10, iArrJ, iArrJ2);
        d.y(iArrJ, iArrJ);
        d.F(iArrJ, iArrJ2, iArrJ);
        d.M(iArrJ, iArrJ);
        d.H(iArrJ);
        d.s(iArrJ, bArr2, i11);
    }
}
