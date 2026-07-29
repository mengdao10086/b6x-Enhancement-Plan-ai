package kr;

import java.math.BigInteger;
import java.security.SecureRandom;
import rr.i;
import rr.o;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f39105a = 4294967295L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f39106b = {-1, -1, 0, -1, -1, -1, -1, -2};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f39107c = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39108d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f39109e = Integer.MAX_VALUE;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i.b(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= Integer.MAX_VALUE && i.w(iArr3, f39106b))) {
            d(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (o.a(16, iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && o.X(16, iArr3, f39107c))) {
            o.b1(16, f39107c, iArr3);
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (o.Z(8, iArr, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && i.w(iArr2, f39106b))) {
            d(iArr2);
        }
    }

    public static void d(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            j11 = j12 >> 32;
        }
        long j13 = j11 + ((((long) iArr[2]) & 4294967295L) - 1);
        iArr[2] = (int) j13;
        long j14 = (j13 >> 32) + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j14;
        long j15 = j14 >> 32;
        if (j15 != 0) {
            long j16 = j15 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j16;
            long j17 = (j16 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j18;
            j15 = j18 >> 32;
        }
        iArr[7] = (int) (j15 + (4294967295L & ((long) iArr[7])) + 1);
    }

    public static int[] e(BigInteger bigInteger) {
        int[] iArrS = i.s(bigInteger);
        if ((iArrS[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = f39106b;
            if (i.w(iArrS, iArr)) {
                i.T(iArr, iArrS);
            }
        }
        return iArrS;
    }

    public static void f(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            o.t0(8, iArr, 0, iArr2);
        } else {
            o.q0(8, iArr2, i.b(iArr, f39106b, iArr2));
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        rr.c.b(f39106b, iArr, iArr2);
    }

    public static int h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrN = i.n();
        i.C(iArr, iArr2, iArrN);
        n(iArrN, iArr3);
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i.H(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && o.X(16, iArr3, f39107c))) {
            o.b1(16, f39107c, iArr3);
        }
    }

    public static void k(int[] iArr, int[] iArr2) {
        if (h(iArr) == 0) {
            i.Q(f39106b, iArr, iArr2);
        } else {
            int[] iArr3 = f39106b;
            i.Q(iArr3, iArr3, iArr2);
        }
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 8);
        } while (o.f0(8, iArr, f39106b) == 0);
    }

    public static void m(SecureRandom secureRandom, int[] iArr) {
        do {
            l(secureRandom, iArr);
        } while (h(iArr) != 0);
    }

    public static void n(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[8]) & 4294967295L;
        long j11 = ((long) iArr[9]) & 4294967295L;
        long j12 = ((long) iArr[10]) & 4294967295L;
        long j13 = ((long) iArr[11]) & 4294967295L;
        long j14 = ((long) iArr[12]) & 4294967295L;
        long j15 = ((long) iArr[13]) & 4294967295L;
        long j16 = ((long) iArr[14]) & 4294967295L;
        long j17 = ((long) iArr[15]) & 4294967295L;
        long j18 = j12 + j13;
        long j19 = j15 + j16;
        long j20 = j19 + (j17 << 1);
        long j21 = j10 + j11 + j19;
        long j22 = j18 + j14 + j17 + j21;
        long j23 = (((long) iArr[0]) & 4294967295L) + j22 + j15 + j16 + j17 + 0;
        iArr2[0] = (int) j23;
        long j24 = (j23 >> 32) + (((((long) iArr[1]) & 4294967295L) + j22) - j10) + j16 + j17;
        iArr2[1] = (int) j24;
        long j25 = (j24 >> 32) + ((((long) iArr[2]) & 4294967295L) - j21);
        iArr2[2] = (int) j25;
        long j26 = (j25 >> 32) + ((((((long) iArr[3]) & 4294967295L) + j22) - j11) - j12) + j15;
        iArr2[3] = (int) j26;
        long j27 = (j26 >> 32) + ((((((long) iArr[4]) & 4294967295L) + j22) - j18) - j10) + j16;
        iArr2[4] = (int) j27;
        long j28 = (j27 >> 32) + (((long) iArr[5]) & 4294967295L) + j20 + j12;
        iArr2[5] = (int) j28;
        long j29 = (j28 >> 32) + (((long) iArr[6]) & 4294967295L) + j13 + j16 + j17;
        iArr2[6] = (int) j29;
        long j30 = (j29 >> 32) + (4294967295L & ((long) iArr[7])) + j22 + j20 + j14;
        iArr2[7] = (int) j30;
        o((int) (j30 >> 32), iArr2);
    }

    public static void o(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) + j11 + 0;
            iArr[0] = (int) j12;
            long j13 = j12 >> 32;
            if (j13 != 0) {
                long j14 = j13 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j14;
                j13 = j14 >> 32;
            }
            long j15 = j13 + ((((long) iArr[2]) & 4294967295L) - j11);
            iArr[2] = (int) j15;
            long j16 = (j15 >> 32) + (((long) iArr[3]) & 4294967295L) + j11;
            iArr[3] = (int) j16;
            long j17 = j16 >> 32;
            if (j17 != 0) {
                long j18 = j17 + (((long) iArr[4]) & 4294967295L);
                iArr[4] = (int) j18;
                long j19 = (j18 >> 32) + (((long) iArr[5]) & 4294967295L);
                iArr[5] = (int) j19;
                long j20 = (j19 >> 32) + (((long) iArr[6]) & 4294967295L);
                iArr[6] = (int) j20;
                j17 = j20 >> 32;
            }
            long j21 = j17 + (4294967295L & ((long) iArr[7])) + j11;
            iArr[7] = (int) j21;
            j10 = j21 >> 32;
        } else {
            j10 = 0;
        }
        if (j10 != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && i.w(iArr, f39106b))) {
            d(iArr);
        }
    }

    public static void p(int[] iArr, int[] iArr2) {
        int[] iArrN = i.n();
        i.O(iArr, iArrN);
        n(iArrN, iArr2);
    }

    public static void q(int[] iArr, int i10, int[] iArr2) {
        int[] iArrN = i.n();
        i.O(iArr, iArrN);
        while (true) {
            n(iArrN, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                i.O(iArr2, iArrN);
            }
        }
    }

    public static void r(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            j11 = j12 >> 32;
        }
        long j13 = j11 + (((long) iArr[2]) & 4294967295L) + 1;
        iArr[2] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j14;
        long j15 = j14 >> 32;
        if (j15 != 0) {
            long j16 = j15 + (((long) iArr[4]) & 4294967295L);
            iArr[4] = (int) j16;
            long j17 = (j16 >> 32) + (((long) iArr[5]) & 4294967295L);
            iArr[5] = (int) j17;
            long j18 = (j17 >> 32) + (((long) iArr[6]) & 4294967295L);
            iArr[6] = (int) j18;
            j15 = j18 >> 32;
        }
        iArr[7] = (int) (j15 + ((4294967295L & ((long) iArr[7])) - 1));
    }

    public static void s(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i.Q(iArr, iArr2, iArr3) != 0) {
            r(iArr3);
        }
    }

    public static void t(int[] iArr, int[] iArr2, int[] iArr3) {
        if (o.P0(16, iArr, iArr2, iArr3) != 0) {
            o.n(16, f39107c, iArr3);
        }
    }

    public static void u(int[] iArr, int[] iArr2) {
        if (o.C0(8, iArr, 0, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && i.w(iArr2, f39106b))) {
            d(iArr2);
        }
    }
}
