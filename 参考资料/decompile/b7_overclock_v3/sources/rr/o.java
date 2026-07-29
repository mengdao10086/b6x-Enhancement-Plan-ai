package rr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49140a = 4294967295L;

    public static void A(int i10, long[] jArr, int i11, long[] jArr2, int i12) {
        System.arraycopy(jArr, i11, jArr2, i12, i10);
    }

    public static int A0(int i10, int[] iArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = i11 + i13;
            int i15 = iArr[i14];
            iArr[i14] = (i12 >>> 31) | (i15 << 1);
            i13++;
            i12 = i15;
        }
        return i12 >>> 31;
    }

    public static void B(int i10, long[] jArr, long[] jArr2) {
        System.arraycopy(jArr, 0, jArr2, 0, i10);
    }

    public static int B0(int i10, int[] iArr, int i11, int i12, int[] iArr2, int i13) {
        int i14 = 0;
        while (i14 < i10) {
            int i15 = iArr[i11 + i14];
            iArr2[i13 + i14] = (i12 >>> 31) | (i15 << 1);
            i14++;
            i12 = i15;
        }
        return i12 >>> 31;
    }

    public static long[] C(int i10, long[] jArr) {
        long[] jArr2 = new long[i10];
        System.arraycopy(jArr, 0, jArr2, 0, i10);
        return jArr2;
    }

    public static int C0(int i10, int[] iArr, int i11, int[] iArr2) {
        int i12 = 0;
        while (i12 < i10) {
            int i13 = iArr[i12];
            iArr2[i12] = (i11 >>> 31) | (i13 << 1);
            i12++;
            i11 = i13;
        }
        return i11 >>> 31;
    }

    public static int[] D(int i10) {
        return new int[i10];
    }

    public static long D0(int i10, long[] jArr, int i11, long j10, long[] jArr2, int i12) {
        int i13 = 0;
        while (i13 < i10) {
            long j11 = jArr[i11 + i13];
            jArr2[i12 + i13] = (j10 >>> 63) | (j11 << 1);
            i13++;
            j10 = j11;
        }
        return j10 >>> 63;
    }

    public static long[] E(int i10) {
        return new long[i10];
    }

    public static int E0(int i10, int[] iArr, int i11, int i12) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = iArr[i13];
            iArr[i13] = (i12 >>> (-i11)) | (i14 << i11);
            i13++;
            i12 = i14;
        }
        return i12 >>> (-i11);
    }

    public static int F(int i10, int i11, int[] iArr, int i12, int[] iArr2, int i13, int[] iArr3, int i14) {
        long j10 = ((long) (-(i11 & 1))) & 4294967295L;
        long j11 = 0;
        for (int i15 = 0; i15 < i10; i15++) {
            long j12 = j11 + ((((long) iArr[i12 + i15]) & 4294967295L) - (((long) iArr2[i13 + i15]) & j10));
            iArr3[i14 + i15] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int F0(int i10, int[] iArr, int i11, int i12, int i13) {
        int i14 = 0;
        while (i14 < i10) {
            int i15 = i11 + i14;
            int i16 = iArr[i15];
            iArr[i15] = (i13 >>> (-i12)) | (i16 << i12);
            i14++;
            i13 = i16;
        }
        return i13 >>> (-i12);
    }

    public static int G(int i10, int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) (-(i11 & 1))) & 4294967295L;
        long j11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) - (((long) iArr2[i12]) & j10));
            iArr3[i12] = (int) j12;
            j11 = j12 >> 32;
        }
        return (int) j11;
    }

    public static int G0(int i10, int[] iArr, int i11, int i12, int i13, int[] iArr2, int i14) {
        int i15 = 0;
        while (i15 < i10) {
            int i16 = iArr[i11 + i15];
            iArr2[i14 + i15] = (i13 >>> (-i12)) | (i16 << i12);
            i15++;
            i13 = i16;
        }
        return i13 >>> (-i12);
    }

    public static int H(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11] - 1;
            iArr[i11] = i12;
            if (i12 != -1) {
                return 0;
            }
        }
        return -1;
    }

    public static int H0(int i10, int[] iArr, int i11, int i12, int[] iArr2) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = iArr[i13];
            iArr2[i13] = (i12 >>> (-i11)) | (i14 << i11);
            i13++;
            i12 = i14;
        }
        return i12 >>> (-i11);
    }

    public static int I(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11] - 1;
            iArr2[i11] = i12;
            i11++;
            if (i12 != -1) {
                while (i11 < i10) {
                    iArr2[i11] = iArr[i11];
                    i11++;
                }
                return 0;
            }
        }
        return -1;
    }

    public static long I0(int i10, long[] jArr, int i11, int i12, long j10) {
        int i13 = 0;
        while (i13 < i10) {
            int i14 = i11 + i13;
            long j11 = jArr[i14];
            jArr[i14] = (j10 >>> (-i12)) | (j11 << i12);
            i13++;
            j10 = j11;
        }
        return j10 >>> (-i12);
    }

    public static int J(int i10, int[] iArr, int i11) {
        while (i11 < i10) {
            int i12 = iArr[i11] - 1;
            iArr[i11] = i12;
            if (i12 != -1) {
                return 0;
            }
            i11++;
        }
        return -1;
    }

    public static long J0(int i10, long[] jArr, int i11, int i12, long j10, long[] jArr2, int i13) {
        int i14 = 0;
        while (i14 < i10) {
            long j11 = jArr[i11 + i14];
            jArr2[i13 + i14] = (j10 >>> (-i12)) | (j11 << i12);
            i14++;
            j10 = j11;
        }
        return j10 >>> (-i12);
    }

    public static int K(int i10, int[] iArr, int i11, int i12) {
        while (i12 < i10) {
            int i13 = i11 + i12;
            int i14 = iArr[i13] - 1;
            iArr[i13] = i14;
            if (i14 != -1) {
                return 0;
            }
            i12++;
        }
        return -1;
    }

    public static void K0(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13;
        int i14 = i10 << 1;
        int i15 = 0;
        int i16 = i10;
        int i17 = i14;
        do {
            i16--;
            long j10 = ((long) iArr[i11 + i16]) & 4294967295L;
            long j11 = j10 * j10;
            int i18 = i17 - 1;
            iArr2[i12 + i18] = (i15 << 31) | ((int) (j11 >>> 33));
            i17 = i18 - 1;
            i13 = 1;
            iArr2[i12 + i17] = (int) (j11 >>> 1);
            i15 = (int) j11;
        } while (i16 > 0);
        long j12 = 0;
        int i19 = i12 + 2;
        while (i13 < i10) {
            long jM0 = j12 + (((long) M0(iArr, i11, i13, iArr2, i12)) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
            int i20 = i19 + 1;
            iArr2[i19] = (int) jM0;
            long j13 = (jM0 >>> 32) + (((long) iArr2[i20]) & 4294967295L);
            iArr2[i20] = (int) j13;
            j12 = j13 >>> 32;
            i13++;
            i19 = i20 + 1;
        }
        A0(i14, iArr2, i12, iArr[i11] << 31);
    }

    public static boolean L(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        boolean zW = W(i10, iArr, i11, iArr2, i12);
        if (zW) {
            O0(i10, iArr, i11, iArr2, i12, iArr3, i13);
        } else {
            O0(i10, iArr2, i12, iArr, i11, iArr3, i13);
        }
        return zW;
    }

    public static void L0(int i10, int[] iArr, int[] iArr2) {
        int i11;
        int i12 = i10 << 1;
        int i13 = 0;
        int i14 = i10;
        int i15 = i12;
        while (true) {
            i14--;
            long j10 = ((long) iArr[i14]) & 4294967295L;
            long j11 = j10 * j10;
            int i16 = i15 - 1;
            iArr2[i16] = (i13 << 31) | ((int) (j11 >>> 33));
            i15 = i16 - 1;
            i11 = 1;
            iArr2[i15] = (int) (j11 >>> 1);
            int i17 = (int) j11;
            if (i14 <= 0) {
                break;
            } else {
                i13 = i17;
            }
        }
        long j12 = 0;
        int i18 = 2;
        while (i11 < i10) {
            long jN0 = j12 + (((long) N0(iArr, i11, iArr2)) & 4294967295L) + (((long) iArr2[i18]) & 4294967295L);
            int i19 = i18 + 1;
            iArr2[i18] = (int) jN0;
            long j13 = (jN0 >>> 32) + (((long) iArr2[i19]) & 4294967295L);
            iArr2[i19] = (int) j13;
            j12 = j13 >>> 32;
            i11++;
            i18 = i19 + 1;
        }
        z0(i12, iArr2, iArr[0] << 31);
    }

    public static boolean M(int i10, int[] iArr, int[] iArr2) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static int M0(int[] iArr, int i10, int i11, int[] iArr2, int i12) {
        long j10 = ((long) iArr[i10 + i11]) & 4294967295L;
        long j11 = 0;
        int i13 = 0;
        int i14 = i12;
        do {
            int i15 = i11 + i14;
            long j12 = j11 + ((((long) iArr[i10 + i13]) & 4294967295L) * j10) + (((long) iArr2[i15]) & 4294967295L);
            iArr2[i15] = (int) j12;
            j11 = j12 >>> 32;
            i14++;
            i13++;
        } while (i13 < i11);
        return (int) j11;
    }

    public static int N(int i10, int[] iArr, int i11) {
        int i12 = i11 ^ iArr[0];
        for (int i13 = 1; i13 < i10; i13++) {
            i12 |= iArr[i13];
        }
        return (((i12 >>> 1) | (i12 & 1)) - 1) >> 31;
    }

    public static int N0(int[] iArr, int i10, int[] iArr2) {
        long j10 = ((long) iArr[i10]) & 4294967295L;
        long j11 = 0;
        int i11 = 0;
        do {
            int i12 = i10 + i11;
            long j12 = j11 + ((((long) iArr[i11]) & 4294967295L) * j10) + (((long) iArr2[i12]) & 4294967295L);
            iArr2[i12] = (int) j12;
            j11 = j12 >>> 32;
            i11++;
        } while (i11 < i10);
        return (int) j11;
    }

    public static int O(int i10, int[] iArr, int i11, int i12) {
        int i13 = i12 ^ iArr[i11];
        for (int i14 = 1; i14 < i10; i14++) {
            i13 |= iArr[i11 + i14];
        }
        return (((i13 >>> 1) | (i13 & 1)) - 1) >> 31;
    }

    public static int O0(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            long j11 = j10 + ((((long) iArr[i11 + i14]) & 4294967295L) - (4294967295L & ((long) iArr2[i12 + i14])));
            iArr3[i13 + i14] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int P(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            i13 |= iArr[i11 + i14] ^ iArr2[i12 + i14];
        }
        return (((i13 >>> 1) | (i13 & 1)) - 1) >> 31;
    }

    public static int P0(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + ((((long) iArr[i11]) & 4294967295L) - (4294967295L & ((long) iArr2[i11])));
            iArr3[i11] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int Q(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 |= iArr[i12] ^ iArr2[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static int Q0(int i10, int i11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i13]) & 4294967295L) - (((long) i11) & 4294967295L);
        iArr[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >> 32) + ((4294967295L & ((long) iArr[i14])) - 1);
        iArr[i14] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, i12 + 2);
    }

    public static int R(int i10, int[] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 |= iArr[i12];
        }
        return (((i11 >>> 1) | (i11 & 1)) - 1) >> 31;
    }

    public static int R0(int i10, int i11, int[] iArr, int i12, int i13) {
        int i14 = i12 + i13;
        long j10 = (((long) iArr[i14]) & 4294967295L) - (((long) i11) & 4294967295L);
        iArr[i14] = (int) j10;
        int i15 = i14 + 1;
        long j11 = (j10 >> 32) + ((4294967295L & ((long) iArr[i15])) - 1);
        iArr[i15] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i12, i13 + 2);
    }

    public static int S(int i10, int[] iArr, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            i12 |= iArr[i11 + i13];
        }
        return (((i12 >>> 1) | (i12 & 1)) - 1) >> 31;
    }

    public static int S0(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (((long) i11) & 4294967295L);
        iArr[0] = (int) j10;
        long j11 = (j10 >> 32) + ((4294967295L & ((long) iArr[1])) - 1);
        iArr[1] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, 2);
    }

    public static int[] T(int i10, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
            throw new IllegalArgumentException();
        }
        int i11 = (i10 + 31) >> 5;
        int[] iArrD = D(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            iArrD[i12] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrD;
    }

    public static int T0(int i10, int i11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i13]) & 4294967295L) - (((long) i11) & 4294967295L);
        iArr[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >> 32) + ((4294967295L & ((long) iArr[i14])) - 1);
        iArr[i14] = (int) j11;
        if ((j11 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i12, 2);
    }

    public static long[] U(int i10, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
            throw new IllegalArgumentException();
        }
        int i11 = (i10 + 63) >> 6;
        long[] jArrE = E(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            jArrE[i12] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrE;
    }

    public static int U0(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = i13 + i14;
            long j11 = j10 + (((((long) iArr3[i15]) & 4294967295L) - (((long) iArr[i11 + i14]) & 4294967295L)) - (4294967295L & ((long) iArr2[i12 + i14])));
            iArr3[i15] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int V(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= iArr.length) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static int V0(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((((long) iArr3[i11]) & 4294967295L) - (((long) iArr[i11]) & 4294967295L)) - (4294967295L & ((long) iArr2[i11])));
            iArr3[i11] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static boolean W(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            int i14 = iArr[i11 + i13] ^ Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE ^ iArr2[i12 + i13];
            if (i14 < i15) {
                return false;
            }
            if (i14 > i15) {
                return true;
            }
        }
        return true;
    }

    public static int W0(int i10, long j10, int[] iArr, int i11) {
        int i12 = i11 + 0;
        long j11 = (((long) iArr[i12]) & 4294967295L) - (j10 & 4294967295L);
        iArr[i12] = (int) j11;
        int i13 = i11 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i13])) - (j10 >>> 32));
        iArr[i13] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, i11 + 2);
    }

    public static boolean X(int i10, int[] iArr, int[] iArr2) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            int i12 = iArr[i11] ^ Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE ^ iArr2[i11];
            if (i12 < i13) {
                return false;
            }
            if (i12 > i13) {
                return true;
            }
        }
        return true;
    }

    public static int X0(int i10, long j10, int[] iArr, int i11, int i12) {
        int i13 = i11 + i12;
        long j11 = (((long) iArr[i13]) & 4294967295L) - (j10 & 4294967295L);
        iArr[i13] = (int) j11;
        int i14 = i13 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i14])) - (j10 >>> 32));
        iArr[i14] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i11, i12 + 2);
    }

    public static int Y(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11] + 1;
            iArr[i11] = i12;
            if (i12 != 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int Y0(int i10, long j10, int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) - (j10 & 4294967295L);
        iArr[0] = (int) j11;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[1])) - (j10 >>> 32));
        iArr[1] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, 2);
    }

    public static int Z(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0;
        while (i11 < i10) {
            int i12 = iArr[i11] + 1;
            iArr2[i11] = i12;
            i11++;
            if (i12 != 0) {
                while (i11 < i10) {
                    iArr2[i11] = iArr[i11];
                    i11++;
                }
                return 0;
            }
        }
        return 1;
    }

    public static int Z0(int i10, long j10, int[] iArr, int i11) {
        int i12 = i11 + 0;
        long j11 = (((long) iArr[i12]) & 4294967295L) - (j10 & 4294967295L);
        iArr[i12] = (int) j11;
        int i13 = i11 + 1;
        long j12 = (j11 >> 32) + ((4294967295L & ((long) iArr[i13])) - (j10 >>> 32));
        iArr[i13] = (int) j12;
        if ((j12 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i11, 2);
    }

    public static int a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (4294967295L & ((long) iArr2[i11]));
            iArr3[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int a0(int i10, int[] iArr, int i11) {
        while (i11 < i10) {
            int i12 = iArr[i11] + 1;
            iArr[i11] = i12;
            if (i12 != 0) {
                return 0;
            }
            i11++;
        }
        return 1;
    }

    public static int a1(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i12 + i13;
            long j11 = j10 + ((((long) iArr2[i14]) & 4294967295L) - (4294967295L & ((long) iArr[i11 + i13])));
            iArr2[i14] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int b(int i10, int i11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i13]) & 4294967295L) + (((long) i11) & 4294967295L);
        iArr[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[i14])) + 1;
        iArr[i14] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, i12 + 2);
    }

    public static int b0(int i10, int[] iArr, int i11, int i12) {
        while (i12 < i10) {
            int i13 = i11 + i12;
            int i14 = iArr[i13] + 1;
            iArr[i13] = i14;
            if (i14 != 0) {
                return 0;
            }
            i12++;
        }
        return 1;
    }

    public static int b1(int i10, int[] iArr, int[] iArr2) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + ((((long) iArr2[i11]) & 4294967295L) - (4294967295L & ((long) iArr[i11])));
            iArr2[i11] = (int) j11;
            j10 = j11 >> 32;
        }
        return (int) j10;
    }

    public static int c(int i10, int i11, int[] iArr, int i12, int i13) {
        int i14 = i12 + i13;
        long j10 = (((long) iArr[i14]) & 4294967295L) + (((long) i11) & 4294967295L);
        iArr[i14] = (int) j10;
        int i15 = i14 + 1;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[i15])) + 1;
        iArr[i15] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i12, i13 + 2);
    }

    public static boolean c0(int i10, int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i11 = 1; i11 < i10; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int c1(int i10, int i11, int[] iArr, int i12) {
        long j10 = (((long) iArr[i12]) & 4294967295L) - (4294967295L & ((long) i11));
        iArr[i12] = (int) j10;
        if ((j10 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, i12 + 1);
    }

    public static int d(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) i11) & 4294967295L);
        iArr[0] = (int) j10;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[1])) + 1;
        iArr[1] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, 2);
    }

    public static boolean d0(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int d1(int i10, int i11, int[] iArr, int i12, int i13) {
        int i14 = i12 + i13;
        long j10 = (((long) iArr[i14]) & 4294967295L) - (4294967295L & ((long) i11));
        iArr[i14] = (int) j10;
        if ((j10 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i12, i13 + 1);
    }

    public static int e(int i10, int i11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i13]) & 4294967295L) + (((long) i11) & 4294967295L);
        iArr[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >>> 32) + (4294967295L & ((long) iArr[i14])) + 1;
        iArr[i14] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i12, 2);
    }

    public static int e0(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            j10 = (j10 + ((((long) iArr[i11 + i13]) & 4294967295L) - (4294967295L & ((long) iArr2[i12 + i13])))) >> 32;
        }
        return (int) j10;
    }

    public static int e1(int i10, int i11, int[] iArr) {
        long j10 = (((long) iArr[0]) & 4294967295L) - (4294967295L & ((long) i11));
        iArr[0] = (int) j10;
        if ((j10 >> 32) == 0) {
            return 0;
        }
        return J(i10, iArr, 1);
    }

    public static int f(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = i13 + i14;
            long j11 = j10 + (((long) iArr[i11 + i14]) & 4294967295L) + (((long) iArr2[i12 + i14]) & 4294967295L) + (4294967295L & ((long) iArr3[i15]));
            iArr3[i15] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int f0(int i10, int[] iArr, int[] iArr2) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 = (j10 + ((((long) iArr[i11]) & 4294967295L) - (4294967295L & ((long) iArr2[i11])))) >> 32;
        }
        return (int) j10;
    }

    public static int f1(int i10, int i11, int[] iArr, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i13]) & 4294967295L) - (4294967295L & ((long) i11));
        iArr[i13] = (int) j10;
        if ((j10 >> 32) == 0) {
            return 0;
        }
        return K(i10, iArr, i12, 1);
    }

    public static int g(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (((long) iArr2[i11]) & 4294967295L) + (4294967295L & ((long) iArr3[i11]));
            iArr3[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static void g0(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        iArr3[i13 + i10] = m0(i10, iArr[i11], iArr2, i12, iArr3, i13);
        for (int i14 = 1; i14 < i10; i14++) {
            int i15 = i13 + i14;
            iArr3[i15 + i10] = o0(i10, iArr[i11 + i14], iArr2, i12, iArr3, i15);
        }
    }

    public static BigInteger g1(int i10, int[] iArr) {
        byte[] bArr = new byte[i10 << 2];
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = iArr[i11];
            if (i12 != 0) {
                org.bouncycastle.util.o.h(i12, bArr, ((i10 - 1) - i11) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int h(int i10, long j10, int[] iArr, int i11) {
        int i12 = i11 + 0;
        long j11 = (((long) iArr[i12]) & 4294967295L) + (j10 & 4294967295L);
        iArr[i12] = (int) j11;
        int i13 = i11 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i13])) + (j10 >>> 32);
        iArr[i13] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, i11 + 2);
    }

    public static void h0(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[i10] = n0(i10, iArr[0], iArr2, iArr3);
        for (int i11 = 1; i11 < i10; i11++) {
            iArr3[i11 + i10] = o0(i10, iArr[i11], iArr2, 0, iArr3, i11);
        }
    }

    public static void h1(int i10, int[] iArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i11] = 0;
        }
    }

    public static int i(int i10, long j10, int[] iArr, int i11, int i12) {
        int i13 = i11 + i12;
        long j11 = (((long) iArr[i13]) & 4294967295L) + (j10 & 4294967295L);
        iArr[i13] = (int) j11;
        int i14 = i13 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i14])) + (j10 >>> 32);
        iArr[i14] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i11, i12 + 2);
    }

    public static void i0(int[] iArr, int i10, int i11, int[] iArr2, int i12, int i13, int[] iArr3, int i14) {
        iArr3[i14 + i13] = m0(i13, iArr[i10], iArr2, i12, iArr3, i14);
        for (int i15 = 1; i15 < i11; i15++) {
            int i16 = i14 + i15;
            iArr3[i16 + i13] = o0(i13, iArr[i10 + i15], iArr2, i12, iArr3, i16);
        }
    }

    public static void i1(int i10, int[] iArr, int i11) {
        for (int i12 = 0; i12 < i10; i12++) {
            iArr[i11 + i12] = 0;
        }
    }

    public static int j(int i10, long j10, int[] iArr) {
        long j11 = (((long) iArr[0]) & 4294967295L) + (j10 & 4294967295L);
        iArr[0] = (int) j11;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[1])) + (j10 >>> 32);
        iArr[1] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, 2);
    }

    public static int j0(int i10, int i11, int[] iArr, int i12, int[] iArr2, int[] iArr3, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = ((long) i12) & 4294967295L;
        long j12 = 0;
        int i14 = 0;
        do {
            int i15 = i13 + i14;
            long j13 = j12 + ((((long) iArr[i14]) & 4294967295L) * j10) + ((((long) iArr2[i14]) & 4294967295L) * j11) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j13;
            j12 = j13 >>> 32;
            i14++;
        } while (i14 < i10);
        return (int) j12;
    }

    public static void j1(int i10, long[] jArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i11] = 0;
        }
    }

    public static int k(int i10, long j10, int[] iArr, int i11) {
        int i12 = i11 + 0;
        long j11 = (((long) iArr[i12]) & 4294967295L) + (j10 & 4294967295L);
        iArr[i12] = (int) j11;
        int i13 = i11 + 1;
        long j12 = (j11 >>> 32) + (4294967295L & ((long) iArr[i13])) + (j10 >>> 32);
        iArr[i13] = (int) j12;
        if ((j12 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i11, 2);
    }

    public static int k0(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = 0;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = i13 + i10;
            long jO0 = j10 + (((long) o0(i10, iArr[i11 + i14], iArr2, i12, iArr3, i13)) & 4294967295L) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) jO0;
            j10 = jO0 >>> 32;
            i13++;
        }
        return (int) j10;
    }

    public static int l(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i12 + i13;
            long j11 = j10 + (((long) iArr[i11 + i13]) & 4294967295L) + (4294967295L & ((long) iArr2[i14]));
            iArr2[i14] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int l0(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i11 + i10;
            long jO0 = j10 + (((long) o0(i10, iArr[i11], iArr2, 0, iArr3, i11)) & 4294967295L) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) jO0;
            j10 = jO0 >>> 32;
        }
        return (int) j10;
    }

    public static int m(int i10, int[] iArr, int i11, int[] iArr2, int i12, int i13) {
        long j10 = ((long) i13) & 4294967295L;
        for (int i14 = 0; i14 < i10; i14++) {
            int i15 = i12 + i14;
            long j11 = j10 + (((long) iArr[i11 + i14]) & 4294967295L) + (((long) iArr2[i15]) & 4294967295L);
            iArr2[i15] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int m0(int i10, int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = 0;
        int i14 = 0;
        do {
            long j12 = j11 + ((((long) iArr[i12 + i14]) & 4294967295L) * j10);
            iArr2[i13 + i14] = (int) j12;
            j11 = j12 >>> 32;
            i14++;
        } while (i14 < i10);
        return (int) j11;
    }

    public static int n(int i10, int[] iArr, int[] iArr2) {
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            long j11 = j10 + (((long) iArr[i11]) & 4294967295L) + (4294967295L & ((long) iArr2[i11]));
            iArr2[i11] = (int) j11;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int n0(int i10, int i11, int[] iArr, int[] iArr2) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = 0;
        int i12 = 0;
        do {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) * j10);
            iArr2[i12] = (int) j12;
            j11 = j12 >>> 32;
            i12++;
        } while (i12 < i10);
        return (int) j11;
    }

    public static int o(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = i11 + i13;
            int i15 = i12 + i13;
            long j11 = j10 + (((long) iArr[i14]) & 4294967295L) + (4294967295L & ((long) iArr2[i15]));
            int i16 = (int) j11;
            iArr[i14] = i16;
            iArr2[i15] = i16;
            j10 = j11 >>> 32;
        }
        return (int) j10;
    }

    public static int o0(int i10, int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        long j11 = 0;
        int i14 = 0;
        do {
            int i15 = i13 + i14;
            long j12 = j11 + ((((long) iArr[i12 + i14]) & 4294967295L) * j10) + (((long) iArr2[i15]) & 4294967295L);
            iArr2[i15] = (int) j12;
            j11 = j12 >>> 32;
            i14++;
        } while (i14 < i10);
        return (int) j11;
    }

    public static int p(int i10, int i11, int[] iArr, int i12) {
        long j10 = (((long) i11) & 4294967295L) + (4294967295L & ((long) iArr[i12]));
        iArr[i12] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, i12 + 1);
    }

    public static int p0(int i10, int i11, long j10, int[] iArr, int i12) {
        long j11 = ((long) i11) & 4294967295L;
        int i13 = i12 + 0;
        long j12 = ((j10 & 4294967295L) * j11) + (((long) iArr[i13]) & 4294967295L) + 0;
        iArr[i13] = (int) j12;
        long j13 = j11 * (j10 >>> 32);
        int i14 = i12 + 1;
        long j14 = (j12 >>> 32) + j13 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j14;
        int i15 = i12 + 2;
        long j15 = (j14 >>> 32) + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j15;
        if ((j15 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, i12 + 3);
    }

    public static int q(int i10, int i11, int[] iArr, int i12, int i13) {
        long j10 = ((long) i11) & 4294967295L;
        int i14 = i12 + i13;
        long j11 = j10 + (4294967295L & ((long) iArr[i14]));
        iArr[i14] = (int) j11;
        if ((j11 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i12, i13 + 1);
    }

    public static int q0(int i10, int[] iArr, int i11) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11 << 31;
            }
            int i12 = iArr[i10];
            iArr[i10] = (i11 << 31) | (i12 >>> 1);
            i11 = i12;
        }
    }

    public static int r(int i10, int i11, int[] iArr) {
        long j10 = (((long) i11) & 4294967295L) + (4294967295L & ((long) iArr[0]));
        iArr[0] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return a0(i10, iArr, 1);
    }

    public static int r0(int i10, int[] iArr, int i11, int i12) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i12 << 31;
            }
            int i13 = i11 + i10;
            int i14 = iArr[i13];
            iArr[i13] = (i12 << 31) | (i14 >>> 1);
            i12 = i14;
        }
    }

    public static int s(int i10, int i11, int[] iArr, int i12) {
        long j10 = (((long) i11) & 4294967295L) + (4294967295L & ((long) iArr[i12]));
        iArr[i12] = (int) j10;
        if ((j10 >>> 32) == 0) {
            return 0;
        }
        return b0(i10, iArr, i12, 1);
    }

    public static int s0(int i10, int[] iArr, int i11, int i12, int[] iArr2, int i13) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i12 << 31;
            }
            int i14 = iArr[i11 + i10];
            iArr2[i13 + i10] = (i12 << 31) | (i14 >>> 1);
            i12 = i14;
        }
    }

    public static int t(int i10, int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) (-(i11 & 1))) & 4294967295L;
        long j11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            long j12 = j11 + (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i12]) & j10);
            iArr3[i12] = (int) j12;
            j11 = j12 >>> 32;
        }
        return (int) j11;
    }

    public static int t0(int i10, int[] iArr, int i11, int[] iArr2) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11 << 31;
            }
            int i12 = iArr[i10];
            iArr2[i10] = (i11 << 31) | (i12 >>> 1);
            i11 = i12;
        }
    }

    public static void u(int i10, int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = -(i11 & 1);
        for (int i15 = 0; i15 < i10; i15++) {
            int i16 = i13 + i15;
            int i17 = iArr2[i16];
            iArr2[i16] = i17 ^ ((iArr[i12 + i15] ^ i17) & i14);
        }
    }

    public static int u0(int i10, int[] iArr, int i11, int i12) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i12 << (-i11);
            }
            int i13 = iArr[i10];
            iArr[i10] = (i12 << (-i11)) | (i13 >>> i11);
            i12 = i13;
        }
    }

    public static int v(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = i10 - 1; i13 >= 0; i13--) {
            int i14 = iArr[i11 + i13] ^ Integer.MIN_VALUE;
            int i15 = Integer.MIN_VALUE ^ iArr2[i12 + i13];
            if (i14 < i15) {
                return -1;
            }
            if (i14 > i15) {
                return 1;
            }
        }
        return 0;
    }

    public static int v0(int i10, int[] iArr, int i11, int i12, int i13) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i13 << (-i12);
            }
            int i14 = i11 + i10;
            int i15 = iArr[i14];
            iArr[i14] = (i13 << (-i12)) | (i15 >>> i12);
            i13 = i15;
        }
    }

    public static int w(int i10, int[] iArr, int[] iArr2) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            int i12 = iArr[i11] ^ Integer.MIN_VALUE;
            int i13 = Integer.MIN_VALUE ^ iArr2[i11];
            if (i12 < i13) {
                return -1;
            }
            if (i12 > i13) {
                return 1;
            }
        }
        return 0;
    }

    public static int w0(int i10, int[] iArr, int i11, int i12, int i13, int[] iArr2, int i14) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i13 << (-i12);
            }
            int i15 = iArr[i11 + i10];
            iArr2[i14 + i10] = (i13 << (-i12)) | (i15 >>> i12);
            i13 = i15;
        }
    }

    public static void x(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        System.arraycopy(iArr, i11, iArr2, i12, i10);
    }

    public static int x0(int i10, int[] iArr, int i11, int i12, int[] iArr2) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i12 << (-i11);
            }
            int i13 = iArr[i10];
            iArr2[i10] = (i12 << (-i11)) | (i13 >>> i11);
            i12 = i13;
        }
    }

    public static void y(int i10, int[] iArr, int[] iArr2) {
        System.arraycopy(iArr, 0, iArr2, 0, i10);
    }

    public static int y0(int i10, int[] iArr, int i11) {
        while (true) {
            i10--;
            if (i10 < 0) {
                return i11;
            }
            int i12 = iArr[i10];
            iArr[i10] = i11;
            i11 = i12;
        }
    }

    public static int[] z(int i10, int[] iArr) {
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }

    public static int z0(int i10, int[] iArr, int i11) {
        int i12 = 0;
        while (i12 < i10) {
            int i13 = iArr[i12];
            iArr[i12] = (i11 >>> 31) | (i13 << 1);
            i12++;
            i11 = i13;
        }
        return i11 >>> 31;
    }
}
