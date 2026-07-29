package jr;

import cp.n1;
import java.math.BigInteger;
import java.security.SecureRandom;
import rr.i;
import rr.o;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f36899a = 4294967295L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f36901c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f36903e = 19;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f36900b = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f36902d = {n1.E, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        i.b(iArr, iArr2, iArr3);
        if (i.w(iArr3, f36900b)) {
            t(iArr3);
        }
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        o.a(16, iArr, iArr2, iArr3);
        if (o.X(16, iArr3, f36902d)) {
            s(iArr3);
        }
    }

    public static void c(int[] iArr, int[] iArr2) {
        o.Z(8, iArr, iArr2);
        if (i.w(iArr2, f36900b)) {
            t(iArr2);
        }
    }

    public static int d(int[] iArr) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int[] iArr2 = f36902d;
        long j11 = j10 + (((long) iArr2[0]) & 4294967295L);
        iArr[0] = (int) j11;
        long jA0 = j11 >> 32;
        if (jA0 != 0) {
            jA0 = o.a0(8, iArr, 1);
        }
        long j12 = jA0 + ((((long) iArr[8]) & 4294967295L) - 19);
        iArr[8] = (int) j12;
        long J = j12 >> 32;
        if (J != 0) {
            J = o.J(15, iArr, 9);
        }
        long j13 = J + (((long) iArr[15]) & 4294967295L) + (4294967295L & ((long) (iArr2[15] + 1)));
        iArr[15] = (int) j13;
        return (int) (j13 >> 32);
    }

    public static int e(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - 19;
        iArr[0] = (int) j10;
        long J = j10 >> 32;
        if (J != 0) {
            J = o.J(7, iArr, 1);
        }
        long j11 = J + (4294967295L & ((long) iArr[7])) + 2147483648L;
        iArr[7] = (int) j11;
        return (int) (j11 >> 32);
    }

    public static int[] f(BigInteger bigInteger) {
        int[] iArrS = i.s(bigInteger);
        while (true) {
            int[] iArr = f36900b;
            if (!i.w(iArrS, iArr)) {
                return iArrS;
            }
            i.T(iArr, iArrS);
        }
    }

    public static void g(int[] iArr, int[] iArr2) {
        if ((iArr[0] & 1) == 0) {
            o.t0(8, iArr, 0, iArr2);
        } else {
            i.b(iArr, f36900b, iArr2);
            o.q0(8, iArr2, 0);
        }
    }

    public static void h(int[] iArr, int[] iArr2) {
        rr.c.b(f36900b, iArr, iArr2);
    }

    public static int i(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void j(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrN = i.n();
        i.C(iArr, iArr2, iArrN);
        o(iArrN, iArr3);
    }

    public static void k(int[] iArr, int[] iArr2, int[] iArr3) {
        i.H(iArr, iArr2, iArr3);
        if (o.X(16, iArr3, f36902d)) {
            s(iArr3);
        }
    }

    public static void l(int[] iArr, int[] iArr2) {
        if (i(iArr) == 0) {
            i.Q(f36900b, iArr, iArr2);
        } else {
            int[] iArr3 = f36900b;
            i.Q(iArr3, iArr3, iArr2);
        }
    }

    public static void m(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[32];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 8);
            iArr[7] = iArr[7] & Integer.MAX_VALUE;
        } while (o.f0(8, iArr, f36900b) == 0);
    }

    public static void n(SecureRandom secureRandom, int[] iArr) {
        do {
            m(secureRandom, iArr);
        } while (i(iArr) != 0);
    }

    public static void o(int[] iArr, int[] iArr2) {
        int i10 = iArr[7];
        o.B0(8, iArr, 8, i10, iArr2, 0);
        int iJ = i.J(19, iArr, iArr2) << 1;
        int i11 = iArr2[7];
        iArr2[7] = (i11 & Integer.MAX_VALUE) + o.r(7, (iJ + ((i11 >>> 31) - (i10 >>> 31))) * 19, iArr2);
        if (i.w(iArr2, f36900b)) {
            t(iArr2);
        }
    }

    public static void p(int i10, int[] iArr) {
        int i11 = iArr[7];
        iArr[7] = (i11 & Integer.MAX_VALUE) + o.r(7, ((i10 << 1) | (i11 >>> 31)) * 19, iArr);
        if (i.w(iArr, f36900b)) {
            t(iArr);
        }
    }

    public static void q(int[] iArr, int[] iArr2) {
        int[] iArrN = i.n();
        i.O(iArr, iArrN);
        o(iArrN, iArr2);
    }

    public static void r(int[] iArr, int i10, int[] iArr2) {
        int[] iArrN = i.n();
        i.O(iArr, iArrN);
        while (true) {
            o(iArrN, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                i.O(iArr2, iArrN);
            }
        }
    }

    public static int s(int[] iArr) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int[] iArr2 = f36902d;
        long j11 = j10 - (((long) iArr2[0]) & 4294967295L);
        iArr[0] = (int) j11;
        long J = j11 >> 32;
        if (J != 0) {
            J = o.J(8, iArr, 1);
        }
        long j12 = J + (((long) iArr[8]) & 4294967295L) + 19;
        iArr[8] = (int) j12;
        long jA0 = j12 >> 32;
        if (jA0 != 0) {
            jA0 = o.a0(15, iArr, 9);
        }
        long j13 = jA0 + ((((long) iArr[15]) & 4294967295L) - (4294967295L & ((long) (iArr2[15] + 1))));
        iArr[15] = (int) j13;
        return (int) (j13 >> 32);
    }

    public static int t(int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + 19;
        iArr[0] = (int) j10;
        long jA0 = j10 >> 32;
        if (jA0 != 0) {
            jA0 = o.a0(7, iArr, 1);
        }
        long j11 = jA0 + ((4294967295L & ((long) iArr[7])) - 2147483648L);
        iArr[7] = (int) j11;
        return (int) (j11 >> 32);
    }

    public static void u(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i.Q(iArr, iArr2, iArr3) != 0) {
            e(iArr3);
        }
    }

    public static void v(int[] iArr, int[] iArr2, int[] iArr3) {
        if (o.P0(16, iArr, iArr2, iArr3) != 0) {
            d(iArr3);
        }
    }

    public static void w(int[] iArr, int[] iArr2) {
        o.C0(8, iArr, 0, iArr2);
        if (i.w(iArr2, f36900b)) {
            t(iArr2);
        }
    }
}
