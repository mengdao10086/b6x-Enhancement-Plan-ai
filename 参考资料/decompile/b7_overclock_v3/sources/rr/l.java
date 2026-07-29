package rr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l {
    public static void a(long[] jArr, int i10, long[] jArr2, int i11) {
        jArr2[i11 + 0] = jArr[i10 + 0];
        jArr2[i11 + 1] = jArr[i10 + 1];
        jArr2[i11 + 2] = jArr[i10 + 2];
        jArr2[i11 + 3] = jArr[i10 + 3];
        jArr2[i11 + 4] = jArr[i10 + 4];
        jArr2[i11 + 5] = jArr[i10 + 5];
        jArr2[i11 + 6] = jArr[i10 + 6];
    }

    public static void b(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    public static long[] c() {
        return new long[7];
    }

    public static long[] d() {
        return new long[14];
    }

    public static boolean e(long[] jArr, long[] jArr2) {
        for (int i10 = 6; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static long[] f(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 448) {
            throw new IllegalArgumentException();
        }
        long[] jArrC = c();
        for (int i10 = 0; i10 < 7; i10++) {
            jArrC[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrC;
    }

    public static boolean g(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 7; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(long[] jArr) {
        for (int i10 = 0; i10 < 7; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        h.u(iArr, iArr2, iArr3);
        h.t(iArr, 7, iArr2, 7, iArr3, 14);
        int iG = h.g(iArr3, 7, iArr3, 14);
        int iE = iG + h.e(iArr3, 21, iArr3, 14, h.e(iArr3, 0, iArr3, 7, 0) + iG);
        int[] iArrJ = h.j();
        int[] iArrJ2 = h.j();
        boolean z10 = h.l(iArr, 7, iArr, 0, iArrJ, 0) != h.l(iArr2, 7, iArr2, 0, iArrJ2, 0);
        int[] iArrK = h.k();
        h.u(iArrJ, iArrJ2, iArrK);
        o.p(28, iE + (z10 ? o.l(14, iArrK, 0, iArr3, 7) : o.a1(14, iArrK, 0, iArr3, 7)), iArr3, 21);
    }

    public static void j(int[] iArr, int[] iArr2) {
        h.G(iArr, iArr2);
        h.F(iArr, 7, iArr2, 14);
        int iG = h.g(iArr2, 7, iArr2, 14);
        int iE = iG + h.e(iArr2, 21, iArr2, 14, h.e(iArr2, 0, iArr2, 7, 0) + iG);
        int[] iArrJ = h.j();
        h.l(iArr, 7, iArr, 0, iArrJ, 0);
        int[] iArrK = h.k();
        h.G(iArrJ, iArrK);
        o.p(28, iE + o.a1(14, iArrK, 0, iArr2, 7), iArr2, 21);
    }

    public static BigInteger k(long[] jArr) {
        byte[] bArr = new byte[56];
        for (int i10 = 0; i10 < 7; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                org.bouncycastle.util.o.z(j10, bArr, (6 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
