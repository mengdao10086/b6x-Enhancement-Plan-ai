package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f40273a = {-21389, -2, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40274b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40275c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40276d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40277e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40278f = 21389;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.f.a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && rr.f.o(iArr3, f40273a))) {
            rr.o.d(5, f40278f, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(10, iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && rr.o.X(10, iArr3, f40274b))) {
            int[] iArr4 = f40275c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(10, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && rr.f.o(iArr2, f40273a))) {
            rr.o.d(5, f40278f, iArr2);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] iArrL = rr.f.l(bigInteger);
        if (iArrL[4] == -1) {
            int[] iArr = f40273a;
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
            rr.o.q0(5, iArr2, rr.f.a(iArr, f40273a, iArr2));
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.c.b(f40273a, iArr, iArr2);
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
        if (rr.f.x(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && rr.o.X(10, iArr3, f40274b))) {
            int[] iArr4 = f40275c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(10, iArr3, iArr4.length);
            }
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (g(iArr) == 0) {
            rr.f.F(f40273a, iArr, iArr2);
        } else {
            int[] iArr3 = f40273a;
            rr.f.F(iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[20];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 5);
        } while (rr.o.f0(5, iArr, f40273a) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (g(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        if (rr.f.u(f40278f, rr.f.t(f40278f, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && rr.f.o(iArr2, f40273a))) {
            rr.o.d(5, f40278f, iArr2);
        }
    }

    public static void n(int i10, int[] iArr) {
        if ((i10 == 0 || rr.f.v(f40278f, i10, iArr, 0) == 0) && !(iArr[4] == -1 && rr.f.o(iArr, f40273a))) {
            return;
        }
        rr.o.d(5, f40278f, iArr);
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
            rr.o.S0(5, f40278f, iArr3);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(10, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40275c;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(10, iArr3, iArr4.length);
            }
        }
    }

    public static void s(int[] iArr, int[] iArr2) {
        if (rr.o.C0(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && rr.f.o(iArr2, f40273a))) {
            rr.o.d(5, f40278f, iArr2);
        }
    }
}
