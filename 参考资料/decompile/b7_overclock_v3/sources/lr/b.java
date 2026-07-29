package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40144a = 4294967295L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40145b = {-1, -1, -1, -3};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40146c = {1, 0, 0, 4, -2, -1, 3, -4};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f40147d = {-1, -1, -1, -5, 1, 0, -4, 3};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40148e = 2147483646;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40149f = 2147483646;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.e.a(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && rr.e.u(iArr3, f40145b))) {
            d(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.i.b(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && rr.i.w(iArr3, f40146c))) {
            int[] iArr4 = f40147d;
            rr.o.n(iArr4.length, iArr4, iArr3);
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && rr.e.u(iArr2, f40145b))) {
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
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        iArr[3] = (int) (j11 + (4294967295L & ((long) iArr[3])) + 2);
    }

    public static int[] e(BigInteger bigInteger) {
        int[] iArrQ = rr.e.q(bigInteger);
        if ((iArrQ[3] >>> 1) >= 2147483646) {
            int[] iArr = f40145b;
            if (rr.e.u(iArrQ, iArr)) {
                rr.e.Q(iArr, iArrQ);
            }
        }
        return iArrQ;
    }

    public static void f(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(4, iArr, 0, iArr2);
        } else {
            rr.o.q0(4, iArr2, rr.e.a(iArr, f40145b, iArr2));
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        rr.c.b(f40145b, iArr, iArr2);
    }

    public static int h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrL = rr.e.l();
        rr.e.A(iArr, iArr2, iArrL);
        n(iArrL, iArr3);
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.e.F(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && rr.i.w(iArr3, f40146c))) {
            int[] iArr4 = f40147d;
            rr.o.n(iArr4.length, iArr4, iArr3);
        }
    }

    public static void k(int[] iArr, int[] iArr2) {
        if (h(iArr) == 0) {
            rr.e.N(f40145b, iArr, iArr2);
        } else {
            int[] iArr3 = f40145b;
            rr.e.N(iArr3, iArr3, iArr2);
        }
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[16];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 4);
        } while (rr.o.f0(4, iArr, f40145b) == 0);
    }

    public static void m(SecureRandom secureRandom, int[] iArr) {
        do {
            l(secureRandom, iArr);
        } while (h(iArr) != 0);
    }

    public static void n(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        long j11 = ((long) iArr[1]) & 4294967295L;
        long j12 = ((long) iArr[2]) & 4294967295L;
        long j13 = ((long) iArr[3]) & 4294967295L;
        long j14 = ((long) iArr[4]) & 4294967295L;
        long j15 = ((long) iArr[5]) & 4294967295L;
        long j16 = ((long) iArr[6]) & 4294967295L;
        long j17 = ((long) iArr[7]) & 4294967295L;
        long j18 = j13 + j17;
        long j19 = j16 + (j17 << 1);
        long j20 = j12 + j19;
        long j21 = j15 + (j19 << 1);
        long j22 = j11 + j21;
        long j23 = j14 + (j21 << 1);
        long j24 = j10 + j23;
        iArr2[0] = (int) j24;
        long j25 = j22 + (j24 >>> 32);
        iArr2[1] = (int) j25;
        long j26 = j20 + (j25 >>> 32);
        iArr2[2] = (int) j26;
        long j27 = j18 + (j23 << 1) + (j26 >>> 32);
        iArr2[3] = (int) j27;
        o((int) (j27 >>> 32), iArr2);
    }

    public static void o(int i10, int[] iArr) {
        while (i10 != 0) {
            long j10 = ((long) i10) & 4294967295L;
            long j11 = (((long) iArr[0]) & 4294967295L) + j10;
            iArr[0] = (int) j11;
            long j12 = j11 >> 32;
            if (j12 != 0) {
                long j13 = j12 + (((long) iArr[1]) & 4294967295L);
                iArr[1] = (int) j13;
                long j14 = (j13 >> 32) + (((long) iArr[2]) & 4294967295L);
                iArr[2] = (int) j14;
                j12 = j14 >> 32;
            }
            long j15 = j12 + (4294967295L & ((long) iArr[3])) + (j10 << 1);
            iArr[3] = (int) j15;
            i10 = (int) (j15 >> 32);
        }
        if ((iArr[3] >>> 1) < 2147483646 || !rr.e.u(iArr, f40145b)) {
            return;
        }
        d(iArr);
    }

    public static void p(int[] iArr, int[] iArr2) {
        int[] iArrL = rr.e.l();
        rr.e.L(iArr, iArrL);
        n(iArrL, iArr2);
    }

    public static void q(int[] iArr, int i10, int[] iArr2) {
        int[] iArrL = rr.e.l();
        rr.e.L(iArr, iArrL);
        while (true) {
            n(iArrL, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.e.L(iArr2, iArrL);
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
            long j13 = (j12 >> 32) + (((long) iArr[2]) & 4294967295L);
            iArr[2] = (int) j13;
            j11 = j13 >> 32;
        }
        iArr[3] = (int) (j11 + ((4294967295L & ((long) iArr[3])) - 2));
    }

    public static void s(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.e.N(iArr, iArr2, iArr3) != 0) {
            r(iArr3);
        }
    }

    public static void t(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40147d;
            rr.o.b1(iArr4.length, iArr4, iArr3);
        }
    }

    public static void u(int[] iArr, int[] iArr2) {
        if (rr.o.C0(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && rr.e.u(iArr2, f40145b))) {
            d(iArr2);
        }
    }
}
