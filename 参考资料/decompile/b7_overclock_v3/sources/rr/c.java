package rr;

import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49132a = 1073741823;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f49133b = 4294967295L;

    public static int a(int i10, int[] iArr, int[] iArr2) {
        int i11 = i10 - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i12 + iArr[i13] + iArr2[i13];
            iArr[i13] = 1073741823 & i14;
            i12 = i14 >> 30;
        }
        int i15 = i12 + iArr[i11] + iArr2[i11];
        iArr[i11] = i15;
        return i15 >> 30;
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (l(iArr, iArr2, iArr3) == 0) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3) {
        if (!m(iArr, iArr2, iArr3)) {
            throw new ArithmeticException("Inverse does not exist.");
        }
    }

    public static void d(int i10, int i11, int[] iArr) {
        int i12 = i10 - 1;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = i13 + ((iArr[i14] ^ i11) - i11);
            iArr[i14] = 1073741823 & i15;
            i13 = i15 >> 30;
        }
        iArr[i12] = i13 + ((iArr[i12] ^ i11) - i11);
    }

    public static void e(int i10, int i11, int[] iArr, int[] iArr2) {
        int i12 = i10 - 1;
        int i13 = iArr[i12] >> 31;
        int i14 = 0;
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = i14 + (((iArr[i15] + (iArr2[i15] & i13)) ^ i11) - i11);
            iArr[i15] = 1073741823 & i16;
            i14 = i16 >> 30;
        }
        iArr[i12] = i14 + (((iArr[i12] + (i13 & iArr2[i12])) ^ i11) - i11);
        int i17 = iArr[i12] >> 31;
        int i18 = 0;
        for (int i19 = 0; i19 < i12; i19++) {
            int i20 = i18 + iArr[i19] + (iArr2[i19] & i17);
            iArr[i19] = i20 & 1073741823;
            i18 = i20 >> 30;
        }
        iArr[i12] = i18 + iArr[i12] + (i17 & iArr2[i12]);
    }

    public static void f(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = 0;
        long j10 = 0;
        while (i10 > 0) {
            while (i13 < Math.min(32, i10)) {
                j10 |= ((long) iArr[i11]) << i13;
                i13 += 30;
                i11++;
            }
            iArr2[i12] = (int) j10;
            j10 >>>= 32;
            i13 -= 32;
            i10 -= 32;
            i12++;
        }
    }

    public static int g(int i10, int i11, int i12, int[] iArr) {
        int i13 = 1;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        for (int i17 = 0; i17 < 30; i17++) {
            int i18 = i10 >> 31;
            int i19 = -(i12 & 1);
            int i20 = i12 + (((i11 ^ i18) - i18) & i19);
            i15 += ((i13 ^ i18) - i18) & i19;
            i16 += ((i14 ^ i18) - i18) & i19;
            int i21 = i18 & i19;
            i10 = (i10 ^ i21) - (i21 + 1);
            i11 += i20 & i21;
            i12 = i20 >> 1;
            i13 = (i13 + (i15 & i21)) << 1;
            i14 = (i14 + (i21 & i16)) << 1;
        }
        iArr[0] = i13;
        iArr[1] = i14;
        iArr[2] = i15;
        iArr[3] = i16;
        return i10;
    }

    public static int h(int i10, int i11, int i12, int[] iArr) {
        int i13;
        int i14 = i10;
        int i15 = i11;
        int i16 = i12;
        int i17 = 30;
        int i18 = 1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1;
        while (true) {
            int iB = org.bouncycastle.util.j.b(((-1) << i17) | i16);
            int i22 = i16 >> iB;
            i18 <<= iB;
            i19 <<= iB;
            i14 -= iB;
            i17 -= iB;
            if (i17 <= 0) {
                iArr[0] = i18;
                iArr[1] = i19;
                iArr[2] = i20;
                iArr[3] = i21;
                return i14;
            }
            if (i14 < 0) {
                i14 = -i14;
                int i23 = -i15;
                int i24 = -i18;
                int i25 = -i19;
                int i26 = i14 + 1;
                if (i26 > i17) {
                    i26 = i17;
                }
                i13 = ((-1) >>> (32 - i26)) & 63 & (i22 * i23 * ((i22 * i22) - 2));
                i22 = i23;
                i15 = i22;
                int i27 = i20;
                i20 = i24;
                i18 = i27;
                int i28 = i21;
                i21 = i25;
                i19 = i28;
            } else {
                int i29 = i14 + 1;
                if (i29 > i17) {
                    i29 = i17;
                }
                i13 = ((-1) >>> (32 - i29)) & 15 & ((-((((i15 + 1) & 4) << 1) + i15)) * i22);
            }
            i16 = i22 + (i15 * i13);
            i20 += i18 * i13;
            i21 += i13 * i19;
        }
    }

    public static void i(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = 0;
        long j10 = 0;
        while (i10 > 0) {
            if (i13 < Math.min(30, i10)) {
                j10 |= (((long) iArr[i11]) & 4294967295L) << i13;
                i13 += 32;
                i11++;
            }
            iArr2[i12] = ((int) j10) & 1073741823;
            j10 >>>= 30;
            i13 -= 30;
            i10 -= 30;
            i12++;
        }
    }

    public static int j(int i10) {
        return ((i10 * 49) + (i10 < 46 ? 80 : 47)) / 17;
    }

    public static int k(int i10) {
        int i11 = (2 - (i10 * i10)) * i10;
        int i12 = i11 * (2 - (i10 * i11));
        int i13 = i12 * (2 - (i10 * i12));
        return i13 * (2 - (i10 * i13));
    }

    public static int l(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iA = (length << 5) - org.bouncycastle.util.j.a(iArr[length - 1]);
        int i10 = (iA + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i10];
        int[] iArr6 = new int[i10];
        int[] iArr7 = new int[i10];
        int[] iArr8 = new int[i10];
        int[] iArr9 = new int[i10];
        char c10 = 0;
        iArr6[0] = 1;
        i(iA, iArr2, 0, iArr8, 0);
        i(iA, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i10);
        int iK = k(iArr9[0]);
        int iJ = j(iA);
        int i11 = -1;
        int i12 = 0;
        while (i12 < iJ) {
            int iG = g(i11, iArr7[c10], iArr8[c10], iArr4);
            p(i10, iArr5, iArr6, iArr4, iK, iArr9);
            q(i10, iArr7, iArr8, iArr4);
            i12 += 30;
            i11 = iG;
            iJ = iJ;
            c10 = 0;
        }
        int i13 = iArr7[i10 - 1] >> 31;
        d(i10, i13, iArr7);
        e(i10, i13, iArr5, iArr9);
        f(iA, iArr5, 0, iArr3, 0);
        return o.N(i10, iArr7, 1) & o.R(i10, iArr8);
    }

    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    public static boolean m(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int iA = (length << 5) - org.bouncycastle.util.j.a(iArr[length - 1]);
        int i10 = (iA + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i10];
        int[] iArr6 = new int[i10];
        int[] iArr7 = new int[i10];
        int[] iArr8 = new int[i10];
        int[] iArr9 = new int[i10];
        ?? r92 = 0;
        iArr6[0] = 1;
        i(iA, iArr2, 0, iArr8, 0);
        i(iA, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i10);
        int i11 = i10 - 1;
        int iA2 = (-1) - (org.bouncycastle.util.j.a(iArr8[i11] | 1) - (((i10 * 30) + 2) - iA));
        int iK = k(iArr9[0]);
        int iJ = j(iA);
        int i12 = i10;
        int i13 = 0;
        while (!o.d0(i12, iArr8)) {
            if (i13 >= iJ) {
                return r92;
            }
            int i14 = i13 + 30;
            int iH = h(iA2, iArr7[r92], iArr8[r92], iArr4);
            int i15 = i12;
            int i16 = iJ;
            int[] iArr10 = iArr6;
            p(i10, iArr5, iArr6, iArr4, iK, iArr9);
            q(i15, iArr7, iArr8, iArr4);
            int i17 = i15 - 1;
            int i18 = iArr7[i17];
            int i19 = iArr8[i17];
            int i20 = i15 - 2;
            if (((i20 >> 31) | ((i18 >> 31) ^ i18) | ((i19 >> 31) ^ i19)) == 0) {
                iArr7[i20] = (i18 << 30) | iArr7[i20];
                iArr8[i20] = iArr8[i20] | (i19 << 30);
                i12 = i15 - 1;
            } else {
                i12 = i15;
            }
            i13 = i14;
            iA2 = iH;
            iJ = i16;
            iArr6 = iArr10;
            r92 = 0;
        }
        int i21 = i12;
        int i22 = iArr7[i21 - 1] >> 31;
        int iN = iArr5[i11] >> 31;
        if (iN < 0) {
            iN = a(i10, iArr5, iArr9);
        }
        if (i22 < 0) {
            iN = n(i10, iArr5);
            n(i21, iArr7);
        }
        if (!o.c0(i21, iArr7)) {
            return false;
        }
        if (iN < 0) {
            a(i10, iArr5, iArr9);
        }
        f(iA, iArr5, 0, iArr3, 0);
        return true;
    }

    public static int n(int i10, int[] iArr) {
        int i11 = i10 - 1;
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            int i14 = i12 - iArr[i13];
            iArr[i13] = 1073741823 & i14;
            i12 = i14 >> 30;
        }
        int i15 = i12 - iArr[i11];
        iArr[i11] = i15;
        return i15 >> 30;
    }

    public static int[] o(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] iArrD = o.D(length);
        int i10 = length - 1;
        int i11 = iArr[i10];
        int i12 = i11 | (i11 >>> 1);
        int i13 = i12 | (i12 >>> 2);
        int i14 = i13 | (i13 >>> 4);
        int i15 = i14 | (i14 >>> 8);
        int i16 = i15 | (i15 >>> 16);
        do {
            for (int i17 = 0; i17 != length; i17++) {
                iArrD[i17] = random.nextInt();
            }
            iArrD[i10] = iArrD[i10] & i16;
        } while (o.X(length, iArrD, iArr));
        return iArrD;
    }

    public static void p(int i10, int[] iArr, int[] iArr2, int[] iArr3, int i11, int[] iArr4) {
        int i12 = i10;
        int i13 = iArr3[0];
        int i14 = iArr3[1];
        int i15 = iArr3[2];
        int i16 = iArr3[3];
        int i17 = i12 - 1;
        int i18 = iArr[i17] >> 31;
        int i19 = iArr2[i17] >> 31;
        int i20 = (i13 & i18) + (i14 & i19);
        int i21 = (i18 & i15) + (i19 & i16);
        int i22 = iArr4[0];
        long j10 = i13;
        long j11 = iArr[0];
        long j12 = i14;
        long j13 = iArr2[0];
        long j14 = (j10 * j11) + (j12 * j13);
        long j15 = i15;
        long j16 = i16;
        long j17 = (j11 * j15) + (j13 * j16);
        long j18 = i22;
        long j19 = i20 - (((((int) j14) * i11) + i20) & 1073741823);
        int i23 = i17;
        long j20 = i21 - (((((int) j17) * i11) + i21) & 1073741823);
        long j21 = (j17 + (j18 * j20)) >> 30;
        long j22 = (j14 + (j18 * j19)) >> 30;
        int i24 = 1;
        while (i24 < i12) {
            int i25 = iArr4[i24];
            long j23 = j21;
            long j24 = iArr[i24];
            int i26 = i24;
            long j25 = iArr2[i24];
            long j26 = j20;
            long j27 = i25;
            long j28 = j22 + (j10 * j24) + (j12 * j25) + (j27 * j19);
            long j29 = j23 + (j24 * j15) + (j25 * j16) + (j27 * j26);
            int i27 = i26 - 1;
            iArr[i27] = ((int) j28) & 1073741823;
            j22 = j28 >> 30;
            iArr2[i27] = ((int) j29) & 1073741823;
            j21 = j29 >> 30;
            i24 = i26 + 1;
            i12 = i10;
            i23 = i23;
            j20 = j26;
        }
        int i28 = i23;
        iArr[i28] = (int) j22;
        iArr2[i28] = (int) j21;
    }

    public static void q(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        int i11 = iArr3[0];
        int i12 = iArr3[1];
        int i13 = iArr3[2];
        int i14 = iArr3[3];
        long j10 = i11;
        long j11 = iArr[0];
        long j12 = i12;
        long j13 = iArr2[0];
        long j14 = i13;
        long j15 = i14;
        long j16 = ((j10 * j11) + (j12 * j13)) >> 30;
        long j17 = ((j11 * j14) + (j13 * j15)) >> 30;
        int i15 = 1;
        while (i15 < i10) {
            int i16 = iArr[i15];
            int i17 = iArr2[i15];
            int i18 = i15;
            long j18 = i16;
            long j19 = j10 * j18;
            long j20 = j10;
            long j21 = i17;
            long j22 = j16 + j19 + (j12 * j21);
            long j23 = j17 + (j18 * j14) + (j21 * j15);
            int i19 = i18 - 1;
            iArr[i19] = ((int) j22) & 1073741823;
            j16 = j22 >> 30;
            iArr2[i19] = 1073741823 & ((int) j23);
            j17 = j23 >> 30;
            i15 = i18 + 1;
            j10 = j20;
        }
        int i20 = i10 - 1;
        iArr[i20] = (int) j16;
        iArr2[i20] = (int) j17;
    }
}
