package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40150a = 4294967295L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40151b = {1, 0, 0, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40152c = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f40153d = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40154e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40155f = -1;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.b(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && rr.h.q(iArr3, f40151b))) {
            d(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && rr.o.X(14, iArr3, f40152c))) {
            int[] iArr4 = f40153d;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(14, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && rr.h.q(iArr2, f40151b))) {
            d(iArr2);
        }
    }

    public static void d(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        long j14 = j11 + (4294967295L & ((long) iArr[3])) + 1;
        iArr[3] = (int) j14;
        if ((j14 >> 32) != 0) {
            rr.o.a0(7, iArr, 4);
        }
    }

    public static int[] e(BigInteger bigInteger) {
        int[] iArrN = rr.h.n(bigInteger);
        if (iArrN[6] == -1) {
            int[] iArr = f40151b;
            if (rr.h.q(iArrN, iArr)) {
                rr.h.L(iArr, iArrN);
            }
        }
        return iArrN;
    }

    public static void f(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(7, iArr, 0, iArr2);
        } else {
            rr.o.q0(7, iArr2, rr.h.b(iArr, f40151b, iArr2));
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        rr.c.b(f40151b, iArr, iArr2);
    }

    public static int h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrK = rr.h.k();
        rr.h.u(iArr, iArr2, iArrK);
        n(iArrK, iArr3);
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.z(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && rr.o.X(14, iArr3, f40152c))) {
            int[] iArr4 = f40153d;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(14, iArr3, iArr4.length);
            }
        }
    }

    public static void k(int[] iArr, int[] iArr2) {
        if (h(iArr) == 0) {
            rr.h.I(f40151b, iArr, iArr2);
        } else {
            int[] iArr3 = f40151b;
            rr.h.I(iArr3, iArr3, iArr2);
        }
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 7);
        } while (rr.o.f0(7, iArr, f40151b) == 0);
    }

    public static void m(SecureRandom secureRandom, int[] iArr) {
        do {
            l(secureRandom, iArr);
        } while (h(iArr) != 0);
    }

    public static void n(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[10]) & 4294967295L;
        long j11 = ((long) iArr[11]) & 4294967295L;
        long j12 = ((long) iArr[12]) & 4294967295L;
        long j13 = ((long) iArr[13]) & 4294967295L;
        long j14 = ((((long) iArr[7]) & 4294967295L) + j11) - 1;
        long j15 = (((long) iArr[8]) & 4294967295L) + j12;
        long j16 = (((long) iArr[9]) & 4294967295L) + j13;
        long j17 = ((((long) iArr[0]) & 4294967295L) - j14) + 0;
        long j18 = j17 & 4294967295L;
        long j19 = (j17 >> 32) + ((((long) iArr[1]) & 4294967295L) - j15);
        iArr2[1] = (int) j19;
        long j20 = (j19 >> 32) + ((((long) iArr[2]) & 4294967295L) - j16);
        iArr2[2] = (int) j20;
        long j21 = (j20 >> 32) + (((((long) iArr[3]) & 4294967295L) + j14) - j10);
        long j22 = j21 & 4294967295L;
        long j23 = (j21 >> 32) + (((((long) iArr[4]) & 4294967295L) + j15) - j11);
        iArr2[4] = (int) j23;
        long j24 = (j23 >> 32) + (((((long) iArr[5]) & 4294967295L) + j16) - j12);
        iArr2[5] = (int) j24;
        long j25 = (j24 >> 32) + (((((long) iArr[6]) & 4294967295L) + j10) - j13);
        iArr2[6] = (int) j25;
        long j26 = (j25 >> 32) + 1;
        long j27 = j22 + j26;
        long j28 = j18 - j26;
        iArr2[0] = (int) j28;
        long j29 = j28 >> 32;
        if (j29 != 0) {
            long j30 = j29 + (((long) iArr2[1]) & 4294967295L);
            iArr2[1] = (int) j30;
            long j31 = (j30 >> 32) + (4294967295L & ((long) iArr2[2]));
            iArr2[2] = (int) j31;
            j27 += j31 >> 32;
        }
        iArr2[3] = (int) j27;
        if (((j27 >> 32) == 0 || rr.o.a0(7, iArr2, 4) == 0) && !(iArr2[6] == -1 && rr.h.q(iArr2, f40151b))) {
            return;
        }
        d(iArr2);
    }

    public static void o(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = ((((long) iArr[0]) & 4294967295L) - j11) + 0;
            iArr[0] = (int) j12;
            long j13 = j12 >> 32;
            if (j13 != 0) {
                long j14 = j13 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j14;
                long j15 = (j14 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j15;
                j13 = j15 >> 32;
            }
            long j16 = j13 + (4294967295L & ((long) iArr[3])) + j11;
            iArr[3] = (int) j16;
            j10 = j16 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 == 0 || rr.o.a0(7, iArr, 4) == 0) && !(iArr[6] == -1 && rr.h.q(iArr, f40151b))) {
            return;
        }
        d(iArr);
    }

    public static void p(int[] iArr, int[] iArr2) {
        int[] iArrK = rr.h.k();
        rr.h.G(iArr, iArrK);
        n(iArrK, iArr2);
    }

    public static void q(int[] iArr, int i10, int[] iArr2) {
        int[] iArrK = rr.h.k();
        rr.h.G(iArr, iArrK);
        while (true) {
            n(iArrK, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.h.G(iArr2, iArrK);
            }
        }
    }

    public static void r(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = j10 >> 32;
        if (j11 != 0) {
            long j12 = j11 + (((long) iArr[1]) & 4294967295L);
            iArr[1] = (int) j12;
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        long j14 = j11 + ((4294967295L & ((long) iArr[3])) - 1);
        iArr[3] = (int) j14;
        if ((j14 >> 32) != 0) {
            rr.o.J(7, iArr, 4);
        }
    }

    public static void s(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.I(iArr, iArr2, iArr3) != 0) {
            r(iArr3);
        }
    }

    public static void t(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40153d;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(14, iArr3, iArr4.length);
            }
        }
    }

    public static void u(int[] iArr, int[] iArr2) {
        if (rr.o.C0(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && rr.h.q(iArr2, f40151b))) {
            d(iArr2);
        }
    }
}
