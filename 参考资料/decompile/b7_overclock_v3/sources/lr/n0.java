package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40301a = 4294967295L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40302b = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40303c = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f40304d = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40305e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40306f = -1;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && rr.o.X(12, iArr3, f40302b))) {
            d(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && rr.o.X(24, iArr3, f40303c))) {
            int[] iArr4 = f40304d;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(24, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && rr.o.X(12, iArr2, f40302b))) {
            d(iArr2);
        }
    }

    public static void d(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - 1);
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + (((long) iArr[3]) & 4294967295L) + 1;
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + (4294967295L & ((long) iArr[4])) + 1;
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            rr.o.a0(12, iArr, 5);
        }
    }

    public static int[] e(BigInteger bigInteger) {
        int[] iArrT = rr.o.T(384, bigInteger);
        if (iArrT[11] == -1) {
            int[] iArr = f40302b;
            if (rr.o.X(12, iArrT, iArr)) {
                rr.o.b1(12, iArr, iArrT);
            }
        }
        return iArrT;
    }

    public static void f(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(12, iArr, 0, iArr2);
        } else {
            rr.o.q0(12, iArr2, rr.o.a(12, iArr, f40302b, iArr2));
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        rr.c.b(f40302b, iArr, iArr2);
    }

    public static int h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 12; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrD = rr.o.D(24);
        rr.k.a(iArr, iArr2, iArrD);
        m(iArrD, iArr3);
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (h(iArr) == 0) {
            rr.o.P0(12, f40302b, iArr, iArr2);
        } else {
            int[] iArr3 = f40302b;
            rr.o.P0(12, iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[48];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 12);
        } while (rr.o.f0(12, iArr, f40302b) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (h(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[16]) & 4294967295L;
        long j11 = ((long) iArr[17]) & 4294967295L;
        long j12 = ((long) iArr[18]) & 4294967295L;
        long j13 = ((long) iArr[19]) & 4294967295L;
        long j14 = ((long) iArr[20]) & 4294967295L;
        long j15 = ((long) iArr[21]) & 4294967295L;
        long j16 = ((long) iArr[22]) & 4294967295L;
        long j17 = ((long) iArr[23]) & 4294967295L;
        long j18 = ((((long) iArr[12]) & 4294967295L) + j14) - 1;
        long j19 = (((long) iArr[13]) & 4294967295L) + j16;
        long j20 = (((long) iArr[14]) & 4294967295L) + j16 + j17;
        long j21 = (((long) iArr[15]) & 4294967295L) + j17;
        long j22 = j11 + j15;
        long j23 = j15 - j17;
        long j24 = j16 - j17;
        long j25 = j18 + j23;
        long j26 = (((long) iArr[0]) & 4294967295L) + j25 + 0;
        iArr2[0] = (int) j26;
        long j27 = (j26 >> 32) + (((((long) iArr[1]) & 4294967295L) + j17) - j18) + j19;
        iArr2[1] = (int) j27;
        long j28 = (j27 >> 32) + (((((long) iArr[2]) & 4294967295L) - j15) - j19) + j20;
        iArr2[2] = (int) j28;
        long j29 = (j28 >> 32) + ((((long) iArr[3]) & 4294967295L) - j20) + j21 + j25;
        iArr2[3] = (int) j29;
        long j30 = (j29 >> 32) + (((((((long) iArr[4]) & 4294967295L) + j10) + j15) + j19) - j21) + j25;
        iArr2[4] = (int) j30;
        long j31 = (j30 >> 32) + ((((long) iArr[5]) & 4294967295L) - j10) + j19 + j20 + j22;
        iArr2[5] = (int) j31;
        long j32 = (j31 >> 32) + (((((long) iArr[6]) & 4294967295L) + j12) - j11) + j20 + j21;
        iArr2[6] = (int) j32;
        long j33 = (j32 >> 32) + ((((((long) iArr[7]) & 4294967295L) + j10) + j13) - j12) + j21;
        iArr2[7] = (int) j33;
        long j34 = (j33 >> 32) + (((((((long) iArr[8]) & 4294967295L) + j10) + j11) + j14) - j13);
        iArr2[8] = (int) j34;
        long j35 = (j34 >> 32) + (((((long) iArr[9]) & 4294967295L) + j12) - j14) + j22;
        iArr2[9] = (int) j35;
        long j36 = (j35 >> 32) + ((((((long) iArr[10]) & 4294967295L) + j12) + j13) - j23) + j24;
        iArr2[10] = (int) j36;
        long j37 = (j36 >> 32) + ((((((long) iArr[11]) & 4294967295L) + j13) + j14) - j24);
        iArr2[11] = (int) j37;
        n((int) ((j37 >> 32) + 1), iArr2);
    }

    public static void n(int i10, int[] iArr) {
        long j10;
        if (i10 != 0) {
            long j11 = ((long) i10) & 4294967295L;
            long j12 = (((long) iArr[0]) & 4294967295L) + j11 + 0;
            iArr[0] = (int) j12;
            long j13 = (j12 >> 32) + ((((long) iArr[1]) & 4294967295L) - j11);
            iArr[1] = (int) j13;
            long j14 = j13 >> 32;
            if (j14 != 0) {
                long j15 = j14 + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j15;
                j14 = j15 >> 32;
            }
            long j16 = j14 + (((long) iArr[3]) & 4294967295L) + j11;
            iArr[3] = (int) j16;
            long j17 = (j16 >> 32) + (4294967295L & ((long) iArr[4])) + j11;
            iArr[4] = (int) j17;
            j10 = j17 >> 32;
        } else {
            j10 = 0;
        }
        if ((j10 == 0 || rr.o.a0(12, iArr, 5) == 0) && !(iArr[11] == -1 && rr.o.X(12, iArr, f40302b))) {
            return;
        }
        d(iArr);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrD = rr.o.D(24);
        rr.k.b(iArr, iArrD);
        m(iArrD, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrD = rr.o.D(24);
        rr.k.b(iArr, iArrD);
        while (true) {
            m(iArrD, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.k.b(iArr2, iArrD);
            }
        }
    }

    public static void q(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 1;
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + (((long) iArr[1]) & 4294967295L) + 1;
        iArr[1] = (int) j11;
        long j12 = j11 >> 32;
        if (j12 != 0) {
            long j13 = j12 + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j12 = j13 >> 32;
        }
        long j14 = j12 + ((((long) iArr[3]) & 4294967295L) - 1);
        iArr[3] = (int) j14;
        long j15 = (j14 >> 32) + ((4294967295L & ((long) iArr[4])) - 1);
        iArr[4] = (int) j15;
        if ((j15 >> 32) != 0) {
            rr.o.J(12, iArr, 5);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(12, iArr, iArr2, iArr3) != 0) {
            q(iArr3);
        }
    }

    public static void s(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(24, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40304d;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(24, iArr3, iArr4.length);
            }
        }
    }

    public static void t(int[] iArr, int[] iArr2) {
        if (rr.o.C0(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && rr.o.X(12, iArr2, f40302b))) {
            d(iArr2);
        }
    }
}
