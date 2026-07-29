package lr;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f40348a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 511};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40349b = 511;

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        int iA = rr.o.a(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (iA > 511 || (iA == 511 && rr.o.M(16, iArr3, f40348a))) {
            iA = (iA + rr.o.Y(16, iArr3)) & 511;
        }
        iArr3[16] = iA;
    }

    public static void b(int[] iArr, int[] iArr2) {
        int iZ = rr.o.Z(16, iArr, iArr2) + iArr[16];
        if (iZ > 511 || (iZ == 511 && rr.o.M(16, iArr2, f40348a))) {
            iZ = (iZ + rr.o.Y(16, iArr2)) & 511;
        }
        iArr2[16] = iZ;
    }

    public static int[] c(BigInteger bigInteger) {
        int[] iArrT = rr.o.T(gg.b.f29450j0, bigInteger);
        if (rr.o.M(17, iArrT, f40348a)) {
            rr.o.h1(17, iArrT);
        }
        return iArrT;
    }

    public static void d(int[] iArr, int[] iArr2) {
        int i10 = iArr[16];
        iArr2[16] = (rr.o.t0(16, iArr, i10, iArr2) >>> 23) | (i10 >>> 1);
    }

    public static void e(int[] iArr, int[] iArr2, int[] iArr3) {
        rr.m.a(iArr, iArr2, iArr3);
        int i10 = iArr[16];
        int i11 = iArr2[16];
        iArr3[32] = rr.o.j0(16, i10, iArr2, i11, iArr, iArr3, 16) + (i10 * i11);
    }

    public static void f(int[] iArr, int[] iArr2) {
        rr.m.b(iArr, iArr2);
        int i10 = iArr[16];
        iArr2[32] = rr.o.o0(16, i10 << 1, iArr, 0, iArr2, 16) + (i10 * i10);
    }

    public static void g(int[] iArr, int[] iArr2) {
        rr.c.b(f40348a, iArr, iArr2);
    }

    public static int h(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 17; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static void i(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrD = rr.o.D(33);
        e(iArr, iArr2, iArrD);
        m(iArrD, iArr3);
    }

    public static void j(int[] iArr, int[] iArr2) {
        if (h(iArr) == 0) {
            rr.o.P0(17, f40348a, iArr, iArr2);
        } else {
            int[] iArr3 = f40348a;
            rr.o.P0(17, iArr3, iArr3, iArr2);
        }
    }

    public static void k(SecureRandom secureRandom, int[] iArr) {
        byte[] bArr = new byte[68];
        do {
            secureRandom.nextBytes(bArr);
            org.bouncycastle.util.o.t(bArr, 0, iArr, 0, 17);
            iArr[16] = iArr[16] & 511;
        } while (rr.o.f0(17, iArr, f40348a) == 0);
    }

    public static void l(SecureRandom secureRandom, int[] iArr) {
        do {
            k(secureRandom, iArr);
        } while (h(iArr) != 0);
    }

    public static void m(int[] iArr, int[] iArr2) {
        int i10 = iArr[32];
        int iW0 = (rr.o.w0(16, iArr, 16, 9, i10, iArr2, 0) >>> 23) + (i10 >>> 9) + rr.o.n(16, iArr, iArr2);
        if (iW0 > 511 || (iW0 == 511 && rr.o.M(16, iArr2, f40348a))) {
            iW0 = (iW0 + rr.o.Y(16, iArr2)) & 511;
        }
        iArr2[16] = iW0;
    }

    public static void n(int[] iArr) {
        int i10 = iArr[16];
        int iR = rr.o.r(16, i10 >>> 9, iArr) + (i10 & 511);
        if (iR > 511 || (iR == 511 && rr.o.M(16, iArr, f40348a))) {
            iR = (iR + rr.o.Y(16, iArr)) & 511;
        }
        iArr[16] = iR;
    }

    public static void o(int[] iArr, int[] iArr2) {
        int[] iArrD = rr.o.D(33);
        f(iArr, iArrD);
        m(iArrD, iArr2);
    }

    public static void p(int[] iArr, int i10, int[] iArr2) {
        int[] iArrD = rr.o.D(33);
        f(iArr, iArrD);
        while (true) {
            m(iArrD, iArr2);
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                f(iArr2, iArrD);
            }
        }
    }

    public static void q(int[] iArr, int[] iArr2, int[] iArr3) {
        int iP0 = (rr.o.P0(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (iP0 < 0) {
            iP0 = (iP0 + rr.o.H(16, iArr3)) & 511;
        }
        iArr3[16] = iP0;
    }

    public static void r(int[] iArr, int[] iArr2) {
        int i10 = iArr[16];
        iArr2[16] = (rr.o.C0(16, iArr, i10 << 23, iArr2) | (i10 << 1)) & 511;
    }
}
