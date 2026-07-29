package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f40197a = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f40198b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f40199c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40200d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40201e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40202f = 977;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.i.b(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && rr.i.w(iArr3, f40197a))) {
            rr.o.d(8, f40202f, iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.a(16, iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && rr.o.X(16, iArr3, f40198b))) {
            int[] iArr4 = f40199c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(16, iArr3, iArr4.length);
            }
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        if (rr.o.Z(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && rr.i.w(iArr2, f40197a))) {
            rr.o.d(8, f40202f, iArr2);
        }
    }

    public static int[] d(BigInteger bigInteger) {
        int[] iArrS = rr.i.s(bigInteger);
        if (iArrS[7] == -1) {
            int[] iArr = f40197a;
            if (rr.i.w(iArrS, iArr)) {
                rr.i.T(iArr, iArrS);
            }
        }
        return iArrS;
    }

    public static void e(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            rr.o.t0(8, iArr, 0, iArr2);
        } else {
            rr.o.q0(8, iArr2, rr.i.b(iArr, f40197a, iArr2));
        }
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.c.b(f40197a, iArr, iArr2);
    }

    public static int g(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void h(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrN = rr.i.n();
        rr.i.C(iArr, iArr2, iArrN);
        m(iArrN, iArr3);
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.i.H(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && rr.o.X(16, iArr3, f40198b))) {
            int[] iArr4 = f40199c;
            if (rr.o.n(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.a0(16, iArr3, iArr4.length);
            }
        }
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (g(iArr) == 0) {
            rr.i.Q(f40197a, iArr, iArr2);
        } else {
            int[] iArr3 = f40197a;
            rr.i.Q(iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 8);
        } while (rr.o.f0(8, iArr, f40197a) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (g(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        if (rr.i.E(f40202f, rr.i.D(f40202f, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && rr.i.w(iArr2, f40197a))) {
            rr.o.d(8, f40202f, iArr2);
        }
    }

    public static void n(int i10, int[] iArr) {
        if ((i10 == 0 || rr.i.F(f40202f, i10, iArr, 0) == 0) && !(iArr[7] == -1 && rr.i.w(iArr, f40197a))) {
            return;
        }
        rr.o.d(8, f40202f, iArr);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrN = rr.i.n();
        rr.i.O(iArr, iArrN);
        m(iArrN, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrN = rr.i.n();
        rr.i.O(iArr, iArrN);
        while (true) {
            m(iArrN, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                rr.i.O(iArr2, iArrN);
            }
        }
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.i.Q(iArr, iArr2, iArr3) != 0) {
            rr.o.S0(8, f40202f, iArr3);
        }
    }

    public static void r(int[] iArr, int[] iArr2, int[] iArr3) {
        if (rr.o.P0(16, iArr, iArr2, iArr3) != 0) {
            int[] iArr4 = f40199c;
            if (rr.o.b1(iArr4.length, iArr4, iArr3) != 0) {
                rr.o.J(16, iArr3, iArr4.length);
            }
        }
    }

    public static void s(int[] iArr, int[] iArr2) {
        if (rr.o.C0(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && rr.i.w(iArr2, f40197a))) {
            rr.o.d(8, f40202f, iArr2);
        }
    }
}
