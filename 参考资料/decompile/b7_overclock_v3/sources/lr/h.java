package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f40222a = 4294967295L;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40223b = {Integer.MAX_VALUE, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40224c = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f40225d = {-1, -1073741826, -1, -1, -1, 1, 1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40226e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40227f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f40228g = -2147483647;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.f.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && rr.f.o(iArr3, f40223b))) {
            rr.o.r(5, f40228g, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(10, iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && rr.o.X(10, iArr3, f40224c))) {
            int[] iArr4 = f40225d;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(10, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && rr.f.o(iArr2, f40223b))) {
            rr.o.r(5, f40228g, iArr2);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] iArrL = rr.f.l(bigInteger);
        if (iArrL[4] == -1) {
            int[] iArr = f40223b;
            if (rr.f.o(iArrL, iArr)) {
                rr.f.I(iArr, iArrL);
            }
        }
        return iArrL;
    }

    public static void e(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(5, iArr, 0, iArr2);
        } else {
            rr.o.q0(5, iArr2, rr.f.a(iArr, f40223b, iArr2));
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.c.b(f40223b, iArr, iArr2);
    }

    public static int g(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrI = rr.f.i();
        rr.f.s(iArr, iArr2, iArrI);
        m(iArrI, iArr3);
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.f.x(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && rr.o.X(10, iArr3, f40224c))) {
            int[] iArr4 = f40225d;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(10, iArr3, iArr4.length);
            }
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (g(iArr) == 0) {
            rr.f.F(f40223b, iArr, iArr2);
        } else {
            int[] iArr3 = f40223b;
            rr.f.F(iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[20];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 5);
        } while (rr.o.f0(5, iArr, f40223b) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (g(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[5]) & 4294967295L;
        long j11 = ((long) iArr[6]) & 4294967295L;
        long j12 = ((long) iArr[7]) & 4294967295L;
        long j13 = ((long) iArr[8]) & 4294967295L;
        long j14 = ((long) iArr[9]) & 4294967295L;
        long j15 = (((long) iArr[0]) & 4294967295L) + j10 + (j10 << 31) + 0;
        iArr2[0] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[1]) & 4294967295L) + j11 + (j11 << 31);
        iArr2[1] = (int) j16;
        long j17 = (j16 >>> 32) + (((long) iArr[2]) & 4294967295L) + j12 + (j12 << 31);
        iArr2[2] = (int) j17;
        long j18 = (j17 >>> 32) + (((long) iArr[3]) & 4294967295L) + j13 + (j13 << 31);
        iArr2[3] = (int) j18;
        long j19 = (j18 >>> 32) + (4294967295L & ((long) iArr[4])) + j14 + (j14 << 31);
        iArr2[4] = (int) j19;
        n((int) (j19 >>> 32), iArr2);
    }

    public static void n(int i10, int[] iArr) {
        if ((i10 == 0 || rr.f.B(f40228g, i10, iArr, 0) == 0) && !(iArr[4] == -1 && rr.f.o(iArr, f40223b))) {
            return;
        }
        rr.o.r(5, f40228g, iArr);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrI = rr.f.i();
        rr.f.D(iArr, iArrI);
        m(iArrI, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrI = rr.f.i();
        rr.f.D(iArr, iArrI);
        while (true) {
            m(iArrI, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.f.D(iArr2, iArrI);
            }
        }
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.f.F(iArr, iArr2, iArr3) != 0) {
            rr.o.e1(5, f40228g, iArr3);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40225d;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(10, iArr3, iArr4.length);
            }
        }
    }

    public static void s(int[] iArr, int[] iArr2) {
        if (rr.o.C0(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && rr.f.o(iArr2, f40223b))) {
            rr.o.r(5, f40228g, iArr2);
        }
    }
}
