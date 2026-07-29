package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f40324a = {-4553, -2, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40325b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40326c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40327d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40328e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40329f = 4553;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.g.a(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && rr.g.u(iArr3, f40324a))) {
            rr.o.d(6, f40329f, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && rr.o.X(12, iArr3, f40325b))) {
            int[] iArr4 = f40326c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(12, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && rr.g.u(iArr2, f40324a))) {
            rr.o.d(6, f40329f, iArr2);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] iArrQ = rr.g.q(bigInteger);
        if (iArrQ[5] == -1) {
            int[] iArr = f40324a;
            if (rr.g.u(iArrQ, iArr)) {
                rr.g.P(iArr, iArrQ);
            }
        }
        return iArrQ;
    }

    public static void e(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(6, iArr, 0, iArr2);
        } else {
            rr.o.q0(6, iArr2, rr.g.a(iArr, f40324a, iArr2));
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.c.b(f40324a, iArr, iArr2);
    }

    public static int g(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 6; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrL = rr.g.l();
        rr.g.A(iArr, iArr2, iArrL);
        m(iArrL, iArr3);
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.g.F(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && rr.o.X(12, iArr3, f40325b))) {
            int[] iArr4 = f40326c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(12, iArr3, iArr4.length);
            }
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (g(iArr) == 0) {
            rr.g.M(f40324a, iArr, iArr2);
        } else {
            int[] iArr3 = f40324a;
            rr.g.M(iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[24];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 6);
        } while (rr.o.f0(6, iArr, f40324a) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (g(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        if (rr.g.C(f40329f, rr.g.B(f40329f, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && rr.g.u(iArr2, f40324a))) {
            rr.o.d(6, f40329f, iArr2);
        }
    }

    public static void n(int i10, int[] iArr) {
        if ((i10 == 0 || rr.g.D(f40329f, i10, iArr, 0) == 0) && !(iArr[5] == -1 && rr.g.u(iArr, f40324a))) {
            return;
        }
        rr.o.d(6, f40329f, iArr);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrL = rr.g.l();
        rr.g.K(iArr, iArrL);
        m(iArrL, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrL = rr.g.l();
        rr.g.K(iArr, iArrL);
        while (true) {
            m(iArrL, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.g.K(iArr2, iArrL);
            }
        }
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.g.M(iArr, iArr2, iArr3) != 0) {
            rr.o.S0(6, f40329f, iArr3);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(12, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40326c;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(12, iArr3, iArr4.length);
            }
        }
    }

    public static void s(int[] iArr, int[] iArr2) {
        if (rr.o.C0(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && rr.g.u(iArr2, f40324a))) {
            rr.o.d(6, f40329f, iArr2);
        }
    }
}
