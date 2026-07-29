package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f40413a = {-6803, -2, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40414b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40415c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40416d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40417e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40418f = 6803;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.b(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && rr.h.q(iArr3, f40413a))) {
            rr.o.d(7, f40418f, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(14, iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && rr.o.X(14, iArr3, f40414b))) {
            int[] iArr4 = f40415c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(14, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && rr.h.q(iArr2, f40413a))) {
            rr.o.d(7, f40418f, iArr2);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] iArrN = rr.h.n(bigInteger);
        if (iArrN[6] == -1 && rr.h.q(iArrN, f40413a)) {
            rr.o.d(7, f40418f, iArrN);
        }
        return iArrN;
    }

    public static void e(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(7, iArr, 0, iArr2);
        } else {
            rr.o.q0(7, iArr2, rr.h.b(iArr, f40413a, iArr2));
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.c.b(f40413a, iArr, iArr2);
    }

    public static int g(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrK = rr.h.k();
        rr.h.u(iArr, iArr2, iArrK);
        m(iArrK, iArr3);
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.z(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && rr.o.X(14, iArr3, f40414b))) {
            int[] iArr4 = f40415c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(14, iArr3, iArr4.length);
            }
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (g(iArr) == 0) {
            rr.h.I(f40413a, iArr, iArr2);
        } else {
            int[] iArr3 = f40413a;
            rr.h.I(iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[28];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 7);
        } while (rr.o.f0(7, iArr, f40413a) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (g(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        if (rr.h.w(f40418f, rr.h.v(f40418f, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && rr.h.q(iArr2, f40413a))) {
            rr.o.d(7, f40418f, iArr2);
        }
    }

    public static void n(int i10, int[] iArr) {
        if ((i10 == 0 || rr.h.x(f40418f, i10, iArr, 0) == 0) && !(iArr[6] == -1 && rr.h.q(iArr, f40413a))) {
            return;
        }
        rr.o.d(7, f40418f, iArr);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrK = rr.h.k();
        rr.h.G(iArr, iArrK);
        m(iArrK, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrK = rr.h.k();
        rr.h.G(iArr, iArrK);
        while (true) {
            m(iArrK, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.h.G(iArr2, iArrK);
            }
        }
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.h.I(iArr, iArr2, iArr3) != 0) {
            rr.o.S0(7, f40418f, iArr3);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(14, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40415c;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(14, iArr3, iArr4.length);
            }
        }
    }

    public static void s(int[] iArr, int[] iArr2) {
        if (rr.o.C0(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && rr.h.q(iArr2, f40413a))) {
            rr.o.d(7, f40418f, iArr2);
        }
    }
}
