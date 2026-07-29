package rr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49137a = 4294967295L;

    public static void A(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr[0]) & 4294967295L;
        long j17 = (j16 * j10) + 0;
        iArr3[0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j11);
        iArr3[1] = (int) j18;
        long j19 = (j18 >>> 32) + (j16 * j12);
        iArr3[2] = (int) j19;
        long j20 = (j19 >>> 32) + (j16 * j13);
        iArr3[3] = (int) j20;
        long j21 = (j20 >>> 32) + (j16 * j14);
        iArr3[4] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j15);
        iArr3[5] = (int) j22;
        int i10 = (int) (j22 >>> 32);
        iArr3[6] = i10;
        int i11 = 1;
        for (int i12 = 6; i11 < i12; i12 = 6) {
            long j23 = ((long) iArr[i11]) & 4294967295L;
            int i13 = i11 + 0;
            long j24 = (j23 * j10) + (((long) iArr3[i13]) & 4294967295L) + 0;
            iArr3[i13] = (int) j24;
            int i14 = i11 + 1;
            long j25 = j11;
            long j26 = (j24 >>> 32) + (j23 * j11) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j26;
            int i15 = i11 + 2;
            long j27 = j15;
            long j28 = (j26 >>> 32) + (j23 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j28;
            int i16 = i11 + 3;
            long j29 = (j28 >>> 32) + (j23 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j29;
            int i17 = i11 + 4;
            long j30 = (j29 >>> 32) + (j23 * j14) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j30;
            int i18 = i11 + 5;
            long j31 = (j30 >>> 32) + (j23 * j27) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j31;
            iArr3[i11 + 6] = (int) (j31 >>> 32);
            i11 = i14;
            j10 = j10;
            j11 = j25;
            j15 = j27;
        }
    }

    public static long B(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((long) iArr[i11 + 0]) & 4294967295L;
        long j12 = (j10 * j11) + (((long) iArr2[i12 + 0]) & 4294967295L) + 0;
        iArr3[i13 + 0] = (int) j12;
        long j13 = ((long) iArr[i11 + 1]) & 4294967295L;
        long j14 = (j12 >>> 32) + (j10 * j13) + j11 + (((long) iArr2[i12 + 1]) & 4294967295L);
        iArr3[i13 + 1] = (int) j14;
        long j15 = j14 >>> 32;
        long j16 = ((long) iArr[i11 + 2]) & 4294967295L;
        long j17 = j15 + (j10 * j16) + j13 + (((long) iArr2[i12 + 2]) & 4294967295L);
        iArr3[i13 + 2] = (int) j17;
        long j18 = ((long) iArr[i11 + 3]) & 4294967295L;
        long j19 = (j17 >>> 32) + (j10 * j18) + j16 + (((long) iArr2[i12 + 3]) & 4294967295L);
        iArr3[i13 + 3] = (int) j19;
        long j20 = ((long) iArr[i11 + 4]) & 4294967295L;
        long j21 = (j19 >>> 32) + (j10 * j20) + j18 + (((long) iArr2[i12 + 4]) & 4294967295L);
        iArr3[i13 + 4] = (int) j21;
        long j22 = ((long) iArr[i11 + 5]) & 4294967295L;
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (4294967295L & ((long) iArr2[i12 + 5]));
        iArr3[i13 + 5] = (int) j23;
        return (j23 >>> 32) + j22;
    }

    public static int C(int i10, long j10, int[] iArr, int i11) {
        long j11 = ((long) i10) & 4294967295L;
        long j12 = j10 & 4294967295L;
        int i12 = i11 + 0;
        long j13 = (j11 * j12) + (((long) iArr[i12]) & 4294967295L) + 0;
        iArr[i12] = (int) j13;
        long j14 = j10 >>> 32;
        long j15 = (j11 * j14) + j12;
        int i13 = i11 + 1;
        long j16 = (j13 >>> 32) + j15 + (((long) iArr[i13]) & 4294967295L);
        iArr[i13] = (int) j16;
        int i14 = i11 + 2;
        long j17 = (j16 >>> 32) + j14 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j17;
        int i15 = i11 + 3;
        long j18 = (j17 >>> 32) + (4294967295L & ((long) iArr[i15]));
        iArr[i15] = (int) j18;
        if ((j18 >>> 32) == 0) {
            return 0;
        }
        return o.b0(6, iArr, i11, 4);
    }

    public static int D(int i10, int i11, int[] iArr, int i12) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((long) i11) & 4294967295L;
        int i13 = i12 + 0;
        long j12 = (j10 * j11) + (((long) iArr[i13]) & 4294967295L) + 0;
        iArr[i13] = (int) j12;
        int i14 = i12 + 1;
        long j13 = (j12 >>> 32) + j11 + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j13;
        long j14 = j13 >>> 32;
        int i15 = i12 + 2;
        long j15 = j14 + (((long) iArr[i15]) & 4294967295L);
        iArr[i15] = (int) j15;
        if ((j15 >>> 32) == 0) {
            return 0;
        }
        return o.b0(6, iArr, i12, 3);
    }

    public static int E(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 5]) & 4294967295L;
        int i13 = i12;
        int i14 = 0;
        long j17 = 0;
        while (i14 < 6) {
            int i15 = i14;
            long j18 = ((long) iArr[i10 + i14]) & j10;
            int i16 = i13 + 0;
            long j19 = (j18 * j11) + (((long) iArr3[i16]) & j10) + 0;
            iArr3[i16] = (int) j19;
            int i17 = i13 + 1;
            long j20 = j12;
            long j21 = (j19 >>> 32) + (j18 * j12) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j21;
            int i18 = i13 + 2;
            long j22 = j13;
            long j23 = (j21 >>> 32) + (j18 * j13) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j23;
            int i19 = i13 + 3;
            long j24 = (j23 >>> 32) + (j18 * j14) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j24;
            int i20 = i13 + 4;
            long j25 = (j24 >>> 32) + (j18 * j15) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j25;
            int i21 = i13 + 5;
            long j26 = (j25 >>> 32) + (j18 * j16) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j26;
            int i22 = i13 + 6;
            long j27 = (j26 >>> 32) + (((long) iArr3[i22]) & 4294967295L) + j17;
            iArr3[i22] = (int) j27;
            j17 = j27 >>> 32;
            i14 = i15 + 1;
            i13 = i17;
            j11 = j11;
            j10 = 4294967295L;
            j12 = j20;
            j13 = j22;
        }
        return (int) j17;
    }

    public static int F(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = 0;
        long j10 = 4294967295L;
        long j11 = ((long) iArr2[0]) & 4294967295L;
        long j12 = ((long) iArr2[1]) & 4294967295L;
        long j13 = ((long) iArr2[2]) & 4294967295L;
        long j14 = ((long) iArr2[3]) & 4294967295L;
        long j15 = ((long) iArr2[4]) & 4294967295L;
        long j16 = ((long) iArr2[5]) & 4294967295L;
        long j17 = 0;
        while (i10 < 6) {
            long j18 = j16;
            long j19 = ((long) iArr[i10]) & j10;
            int i11 = i10 + 0;
            long j20 = j11;
            long j21 = (j19 * j11) + (((long) iArr3[i11]) & j10) + 0;
            iArr3[i11] = (int) j21;
            int i12 = i10 + 1;
            long j22 = (j21 >>> 32) + (j19 * j12) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j22;
            int i13 = i10 + 2;
            long j23 = (j22 >>> 32) + (j19 * j13) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j23;
            int i14 = i10 + 3;
            long j24 = (j23 >>> 32) + (j19 * j14) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j24;
            int i15 = i10 + 4;
            long j25 = (j24 >>> 32) + (j19 * j15) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j25;
            int i16 = i10 + 5;
            long j26 = (j25 >>> 32) + (j19 * j18) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j26;
            int i17 = i10 + 6;
            long j27 = (j26 >>> 32) + (((long) iArr3[i17]) & 4294967295L) + j17;
            iArr3[i17] = (int) j27;
            j17 = j27 >>> 32;
            i10 = i12;
            j10 = 4294967295L;
            j16 = j18;
            j11 = j20;
            j12 = j12;
            j13 = j13;
        }
        return (int) j17;
    }

    public static int G(int i10, int[] iArr, int[] iArr2, int i11) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = 0;
        int i12 = 0;
        do {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) * j10);
            iArr2[i11 + i12] = (int) j12;
            j11 = j12 >>> 32;
            i12++;
        } while (i12 < 6);
        return (int) j11;
    }

    public static int H(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        long j10 = ((long) i10) & 4294967295L;
        int i13 = i12 + 0;
        long j11 = ((((long) iArr[i11 + 0]) & 4294967295L) * j10) + (((long) iArr2[i13]) & 4294967295L) + 0;
        iArr2[i13] = (int) j11;
        int i14 = i12 + 1;
        long j12 = (j11 >>> 32) + ((((long) iArr[i11 + 1]) & 4294967295L) * j10) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j12;
        int i15 = i12 + 2;
        long j13 = (j12 >>> 32) + ((((long) iArr[i11 + 2]) & 4294967295L) * j10) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j13;
        int i16 = i12 + 3;
        long j14 = (j13 >>> 32) + ((((long) iArr[i11 + 3]) & 4294967295L) * j10) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j14;
        int i17 = i12 + 4;
        long j15 = (j14 >>> 32) + ((((long) iArr[i11 + 4]) & 4294967295L) * j10) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j15;
        int i18 = i12 + 5;
        long j16 = (j15 >>> 32) + (j10 * (((long) iArr[i11 + 5]) & 4294967295L)) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int I(int i10, long j10, int[] iArr, int i11) {
        long j11 = ((long) i10) & 4294967295L;
        int i12 = i11 + 0;
        long j12 = ((j10 & 4294967295L) * j11) + (((long) iArr[i12]) & 4294967295L) + 0;
        iArr[i12] = (int) j12;
        long j13 = j11 * (j10 >>> 32);
        int i13 = i11 + 1;
        long j14 = (j12 >>> 32) + j13 + (((long) iArr[i13]) & 4294967295L);
        iArr[i13] = (int) j14;
        int i14 = i11 + 2;
        long j15 = (j14 >>> 32) + (((long) iArr[i14]) & 4294967295L);
        iArr[i14] = (int) j15;
        if ((j15 >>> 32) == 0) {
            return 0;
        }
        return o.b0(6, iArr, i11, 3);
    }

    public static void J(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10 + 0]) & 4294967295L;
        int i12 = 0;
        int i13 = 12;
        int i14 = 5;
        while (true) {
            int i15 = i14 - 1;
            long j11 = ((long) iArr[i10 + i14]) & 4294967295L;
            long j12 = j11 * j11;
            int i16 = i13 - 1;
            iArr2[i11 + i16] = (i12 << 31) | ((int) (j12 >>> 33));
            i13 = i16 - 1;
            iArr2[i11 + i13] = (int) (j12 >>> 1);
            i12 = (int) j12;
            if (i15 <= 0) {
                long j13 = j10 * j10;
                iArr2[i11 + 0] = (int) j13;
                long j14 = ((long) iArr[i10 + 1]) & 4294967295L;
                int i17 = i11 + 2;
                long j15 = ((long) iArr2[i17]) & 4294967295L;
                long j16 = ((((long) (i12 << 31)) & 4294967295L) | (j13 >>> 33)) + (j14 * j10);
                int i18 = (int) j16;
                iArr2[i11 + 1] = (i18 << 1) | (((int) (j13 >>> 32)) & 1);
                int i19 = i18 >>> 31;
                long j17 = j15 + (j16 >>> 32);
                long j18 = ((long) iArr[i10 + 2]) & 4294967295L;
                int i20 = i11 + 3;
                long j19 = ((long) iArr2[i20]) & 4294967295L;
                int i21 = i11 + 4;
                long j20 = ((long) iArr2[i21]) & 4294967295L;
                long j21 = j17 + (j18 * j10);
                int i22 = (int) j21;
                iArr2[i17] = (i22 << 1) | i19;
                int i23 = i22 >>> 31;
                long j22 = j19 + (j21 >>> 32) + (j18 * j14);
                long j23 = j20 + (j22 >>> 32);
                long j24 = ((long) iArr[i10 + 3]) & 4294967295L;
                int i24 = i11 + 5;
                long j25 = (((long) iArr2[i24]) & 4294967295L) + (j23 >>> 32);
                int i25 = i11 + 6;
                long j26 = (((long) iArr2[i25]) & 4294967295L) + (j25 >>> 32);
                long j27 = (j22 & 4294967295L) + (j24 * j10);
                int i26 = (int) j27;
                iArr2[i20] = (i26 << 1) | i23;
                long j28 = (j23 & 4294967295L) + (j27 >>> 32) + (j24 * j14);
                long j29 = (j25 & 4294967295L) + (j28 >>> 32) + (j24 * j18);
                long j30 = j26 + (j29 >>> 32);
                long j31 = j29 & 4294967295L;
                long j32 = ((long) iArr[i10 + 4]) & 4294967295L;
                int i27 = i11 + 7;
                long j33 = (((long) iArr2[i27]) & 4294967295L) + (j30 >>> 32);
                long j34 = j30 & 4294967295L;
                int i28 = i11 + 8;
                long j35 = (((long) iArr2[i28]) & 4294967295L) + (j33 >>> 32);
                long j36 = (j28 & 4294967295L) + (j32 * j10);
                int i29 = (int) j36;
                iArr2[i21] = (i26 >>> 31) | (i29 << 1);
                int i30 = i29 >>> 31;
                long j37 = j31 + (j36 >>> 32) + (j32 * j14);
                long j38 = j34 + (j37 >>> 32) + (j32 * j18);
                long j39 = (j33 & 4294967295L) + (j38 >>> 32) + (j32 * j24);
                long j40 = j35 + (j39 >>> 32);
                long j41 = j39 & 4294967295L;
                long j42 = ((long) iArr[i10 + 5]) & 4294967295L;
                int i31 = i11 + 9;
                long j43 = (((long) iArr2[i31]) & 4294967295L) + (j40 >>> 32);
                int i32 = i11 + 10;
                long j44 = (((long) iArr2[i32]) & 4294967295L) + (j43 >>> 32);
                long j45 = (j37 & 4294967295L) + (j10 * j42);
                int i33 = (int) j45;
                iArr2[i24] = (i33 << 1) | i30;
                long j46 = (j38 & 4294967295L) + (j45 >>> 32) + (j42 * j14);
                long j47 = j41 + (j46 >>> 32) + (j42 * j18);
                long j48 = (j40 & 4294967295L) + (j47 >>> 32) + (j42 * j24);
                long j49 = (j43 & 4294967295L) + (j48 >>> 32) + (j42 * j32);
                long j50 = j44 + (j49 >>> 32);
                int i34 = (int) j46;
                iArr2[i25] = (i33 >>> 31) | (i34 << 1);
                int i35 = (int) j47;
                iArr2[i27] = (i34 >>> 31) | (i35 << 1);
                int i36 = (int) j48;
                iArr2[i28] = (i35 >>> 31) | (i36 << 1);
                int i37 = i36 >>> 31;
                int i38 = (int) j49;
                iArr2[i31] = i37 | (i38 << 1);
                int i39 = i38 >>> 31;
                int i40 = (int) j50;
                iArr2[i32] = i39 | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = i11 + 11;
                iArr2[i42] = i41 | ((iArr2[i42] + ((int) (j50 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void K(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 12;
        int i11 = 5;
        int i12 = 0;
        while (true) {
            int i13 = i11 - 1;
            long j11 = ((long) iArr[i11]) & 4294967295L;
            long j12 = j11 * j11;
            int i14 = i10 - 1;
            iArr2[i14] = (i12 << 31) | ((int) (j12 >>> 33));
            i10 = i14 - 1;
            iArr2[i10] = (int) (j12 >>> 1);
            int i15 = (int) j12;
            if (i13 <= 0) {
                long j13 = j10 * j10;
                iArr2[0] = (int) j13;
                long j14 = ((long) iArr[1]) & 4294967295L;
                long j15 = ((long) iArr2[2]) & 4294967295L;
                long j16 = ((((long) (i15 << 31)) & 4294967295L) | (j13 >>> 33)) + (j14 * j10);
                int i16 = (int) j16;
                iArr2[1] = (i16 << 1) | (((int) (j13 >>> 32)) & 1);
                int i17 = i16 >>> 31;
                long j17 = j15 + (j16 >>> 32);
                long j18 = ((long) iArr[2]) & 4294967295L;
                long j19 = ((long) iArr2[3]) & 4294967295L;
                long j20 = ((long) iArr2[4]) & 4294967295L;
                long j21 = j17 + (j18 * j10);
                int i18 = (int) j21;
                iArr2[2] = (i18 << 1) | i17;
                long j22 = j19 + (j21 >>> 32) + (j18 * j14);
                long j23 = j20 + (j22 >>> 32);
                long j24 = ((long) iArr[3]) & 4294967295L;
                long j25 = (((long) iArr2[5]) & 4294967295L) + (j23 >>> 32);
                long j26 = j23 & 4294967295L;
                long j27 = (((long) iArr2[6]) & 4294967295L) + (j25 >>> 32);
                long j28 = (j22 & 4294967295L) + (j24 * j10);
                int i19 = (int) j28;
                iArr2[3] = (i19 << 1) | (i18 >>> 31);
                int i20 = i19 >>> 31;
                long j29 = j26 + (j28 >>> 32) + (j24 * j14);
                long j30 = (j25 & 4294967295L) + (j29 >>> 32) + (j24 * j18);
                long j31 = j27 + (j30 >>> 32);
                long j32 = ((long) iArr[4]) & 4294967295L;
                long j33 = (((long) iArr2[7]) & 4294967295L) + (j31 >>> 32);
                long j34 = j31 & 4294967295L;
                long j35 = (((long) iArr2[8]) & 4294967295L) + (j33 >>> 32);
                long j36 = (j29 & 4294967295L) + (j32 * j10);
                int i21 = (int) j36;
                iArr2[4] = (i21 << 1) | i20;
                long j37 = (j30 & 4294967295L) + (j36 >>> 32) + (j32 * j14);
                long j38 = j34 + (j37 >>> 32) + (j32 * j18);
                long j39 = (j33 & 4294967295L) + (j38 >>> 32) + (j32 * j24);
                long j40 = j35 + (j39 >>> 32);
                long j41 = j39 & 4294967295L;
                long j42 = ((long) iArr[5]) & 4294967295L;
                long j43 = (((long) iArr2[9]) & 4294967295L) + (j40 >>> 32);
                long j44 = j40 & 4294967295L;
                long j45 = (((long) iArr2[10]) & 4294967295L) + (j43 >>> 32);
                long j46 = 4294967295L & j43;
                long j47 = (j37 & 4294967295L) + (j10 * j42);
                int i22 = (int) j47;
                iArr2[5] = (i22 << 1) | (i21 >>> 31);
                long j48 = (j38 & 4294967295L) + (j47 >>> 32) + (j42 * j14);
                long j49 = j41 + (j48 >>> 32) + (j42 * j18);
                long j50 = j44 + (j49 >>> 32) + (j42 * j24);
                long j51 = j46 + (j50 >>> 32) + (j42 * j32);
                long j52 = j45 + (j51 >>> 32);
                int i23 = (int) j48;
                iArr2[6] = (i22 >>> 31) | (i23 << 1);
                int i24 = (int) j49;
                iArr2[7] = (i23 >>> 31) | (i24 << 1);
                int i25 = (int) j50;
                iArr2[8] = (i24 >>> 31) | (i25 << 1);
                int i26 = (int) j51;
                iArr2[9] = (i25 >>> 31) | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j52;
                iArr2[10] = i27 | (i28 << 1);
                iArr2[11] = (i28 >>> 31) | ((iArr2[11] + ((int) (j52 >>> 32))) << 1);
                return;
            }
            i11 = i13;
            i12 = i15;
        }
    }

    public static int L(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((((long) iArr[i10 + 0]) & 4294967295L) - (((long) iArr2[i11 + 0]) & 4294967295L)) + 0;
        iArr3[i12 + 0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[i10 + 1]) & 4294967295L) - (((long) iArr2[i11 + 1]) & 4294967295L));
        iArr3[i12 + 1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[i10 + 2]) & 4294967295L) - (((long) iArr2[i11 + 2]) & 4294967295L));
        iArr3[i12 + 2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[i10 + 3]) & 4294967295L) - (((long) iArr2[i11 + 3]) & 4294967295L));
        iArr3[i12 + 3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[i10 + 4]) & 4294967295L) - (((long) iArr2[i11 + 4]) & 4294967295L));
        iArr3[i12 + 4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[i10 + 5]) & 4294967295L) - (((long) iArr2[i11 + 5]) & 4294967295L));
        iArr3[i12 + 5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static int M(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((((long) iArr[0]) & 4294967295L) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr[1]) & 4294967295L) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr[2]) & 4294967295L) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr[3]) & 4294967295L) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr[4]) & 4294967295L) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr[5]) & 4294967295L) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static int N(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((((long) iArr3[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) - (((long) iArr2[0]) & 4294967295L)) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >> 32) + (((((long) iArr3[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L)) - (((long) iArr2[1]) & 4294967295L));
        iArr3[1] = (int) j11;
        long j12 = (j11 >> 32) + (((((long) iArr3[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L)) - (((long) iArr2[2]) & 4294967295L));
        iArr3[2] = (int) j12;
        long j13 = (j12 >> 32) + (((((long) iArr3[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L)) - (((long) iArr2[3]) & 4294967295L));
        iArr3[3] = (int) j13;
        long j14 = (j13 >> 32) + (((((long) iArr3[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L)) - (((long) iArr2[4]) & 4294967295L));
        iArr3[4] = (int) j14;
        long j15 = (j14 >> 32) + (((((long) iArr3[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L)) - (((long) iArr2[5]) & 4294967295L));
        iArr3[5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static int O(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = i11 + 0;
        long j10 = ((((long) iArr2[i12]) & 4294967295L) - (((long) iArr[i10 + 0]) & 4294967295L)) + 0;
        iArr2[i12] = (int) j10;
        int i13 = i11 + 1;
        long j11 = (j10 >> 32) + ((((long) iArr2[i13]) & 4294967295L) - (((long) iArr[i10 + 1]) & 4294967295L));
        iArr2[i13] = (int) j11;
        int i14 = i11 + 2;
        long j12 = (j11 >> 32) + ((((long) iArr2[i14]) & 4294967295L) - (((long) iArr[i10 + 2]) & 4294967295L));
        iArr2[i14] = (int) j12;
        int i15 = i11 + 3;
        long j13 = (j12 >> 32) + ((((long) iArr2[i15]) & 4294967295L) - (((long) iArr[i10 + 3]) & 4294967295L));
        iArr2[i15] = (int) j13;
        int i16 = i11 + 4;
        long j14 = (j13 >> 32) + ((((long) iArr2[i16]) & 4294967295L) - (((long) iArr[i10 + 4]) & 4294967295L));
        iArr2[i16] = (int) j14;
        int i17 = i11 + 5;
        long j15 = (j14 >> 32) + ((((long) iArr2[i17]) & 4294967295L) - (((long) iArr[i10 + 5]) & 4294967295L));
        iArr2[i17] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static int P(int[] iArr, int[] iArr2) {
        long j10 = ((((long) iArr2[0]) & 4294967295L) - (((long) iArr[0]) & 4294967295L)) + 0;
        iArr2[0] = (int) j10;
        long j11 = (j10 >> 32) + ((((long) iArr2[1]) & 4294967295L) - (((long) iArr[1]) & 4294967295L));
        iArr2[1] = (int) j11;
        long j12 = (j11 >> 32) + ((((long) iArr2[2]) & 4294967295L) - (((long) iArr[2]) & 4294967295L));
        iArr2[2] = (int) j12;
        long j13 = (j12 >> 32) + ((((long) iArr2[3]) & 4294967295L) - (((long) iArr[3]) & 4294967295L));
        iArr2[3] = (int) j13;
        long j14 = (j13 >> 32) + ((((long) iArr2[4]) & 4294967295L) - (((long) iArr[4]) & 4294967295L));
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (4294967295L & ((long) iArr[5])));
        iArr2[5] = (int) j15;
        return (int) (j15 >> 32);
    }

    public static BigInteger Q(int[] iArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 6; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                org.bouncycastle.util.o.h(i11, bArr, (5 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static BigInteger R(long[] jArr) {
        byte[] bArr = new byte[24];
        for (int i10 = 0; i10 < 3; i10++) {
            long j10 = jArr[i10];
            if (j10 != 0) {
                org.bouncycastle.util.o.z(j10, bArr, (2 - i10) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void S(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
    }

    public static int a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        return (int) (j15 >>> 32);
    }

    public static int b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + (((long) iArr3[0]) & 4294967295L) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L) + (((long) iArr3[1]) & 4294967295L);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L) + (((long) iArr3[2]) & 4294967295L);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L) + (((long) iArr3[3]) & 4294967295L);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L) + (((long) iArr3[4]) & 4294967295L);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L) + (((long) iArr3[5]) & 4294967295L);
        iArr3[5] = (int) j15;
        return (int) (j15 >>> 32);
    }

    public static int c(int[] iArr, int i10, int[] iArr2, int i11, int i12) {
        int i13 = i11 + 0;
        long j10 = (((long) i12) & 4294967295L) + (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L);
        iArr2[i13] = (int) j10;
        int i14 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i14]) & 4294967295L);
        iArr2[i14] = (int) j11;
        int i15 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i15]) & 4294967295L);
        iArr2[i15] = (int) j12;
        int i16 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        iArr2[i16] = (int) j13;
        int i17 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i17]) & 4294967295L);
        iArr2[i17] = (int) j14;
        int i18 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (4294967295L & ((long) iArr2[i18]));
        iArr2[i18] = (int) j15;
        return (int) (j15 >>> 32);
    }

    public static int d(int[] iArr, int[] iArr2) {
        long j10 = (((long) iArr[0]) & 4294967295L) + (((long) iArr2[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[1]) & 4294967295L) + (((long) iArr2[1]) & 4294967295L);
        iArr2[1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[2]) & 4294967295L) + (((long) iArr2[2]) & 4294967295L);
        iArr2[2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[3]) & 4294967295L) + (((long) iArr2[3]) & 4294967295L);
        iArr2[3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[4]) & 4294967295L) + (((long) iArr2[4]) & 4294967295L);
        iArr2[4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (4294967295L & ((long) iArr2[5]));
        iArr2[5] = (int) j15;
        return (int) (j15 >>> 32);
    }

    public static int e(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = i10 + 0;
        int i13 = i11 + 0;
        long j10 = (((long) iArr[i12]) & 4294967295L) + (((long) iArr2[i13]) & 4294967295L) + 0;
        int i14 = (int) j10;
        iArr[i12] = i14;
        iArr2[i13] = i14;
        int i15 = i10 + 1;
        int i16 = i11 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i15]) & 4294967295L) + (((long) iArr2[i16]) & 4294967295L);
        int i17 = (int) j11;
        iArr[i15] = i17;
        iArr2[i16] = i17;
        int i18 = i10 + 2;
        int i19 = i11 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i18]) & 4294967295L) + (((long) iArr2[i19]) & 4294967295L);
        int i20 = (int) j12;
        iArr[i18] = i20;
        iArr2[i19] = i20;
        int i21 = i10 + 3;
        int i22 = i11 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i21]) & 4294967295L) + (((long) iArr2[i22]) & 4294967295L);
        int i23 = (int) j13;
        iArr[i21] = i23;
        iArr2[i22] = i23;
        int i24 = i10 + 4;
        int i25 = i11 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i24]) & 4294967295L) + (((long) iArr2[i25]) & 4294967295L);
        int i26 = (int) j14;
        iArr[i24] = i26;
        iArr2[i25] = i26;
        int i27 = i10 + 5;
        int i28 = i11 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i27]) & 4294967295L) + (4294967295L & ((long) iArr2[i28]));
        int i29 = (int) j15;
        iArr[i27] = i29;
        iArr2[i28] = i29;
        return (int) (j15 >>> 32);
    }

    public static void f(int[] iArr, int i10, int[] iArr2, int i11) {
        iArr2[i11 + 0] = iArr[i10 + 0];
        iArr2[i11 + 1] = iArr[i10 + 1];
        iArr2[i11 + 2] = iArr[i10 + 2];
        iArr2[i11 + 3] = iArr[i10 + 3];
        iArr2[i11 + 4] = iArr[i10 + 4];
        iArr2[i11 + 5] = iArr[i10 + 5];
    }

    public static void g(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
    }

    public static void h(long[] jArr, int i10, long[] jArr2, int i11) {
        jArr2[i11 + 0] = jArr[i10 + 0];
        jArr2[i11 + 1] = jArr[i10 + 1];
        jArr2[i11 + 2] = jArr[i10 + 2];
    }

    public static void i(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    public static int[] j() {
        return new int[6];
    }

    public static long[] k() {
        return new long[3];
    }

    public static int[] l() {
        return new int[12];
    }

    public static long[] m() {
        return new long[6];
    }

    public static boolean n(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        boolean zT = t(iArr, i10, iArr2, i11);
        if (zT) {
            L(iArr, i10, iArr2, i11, iArr3, i12);
        } else {
            L(iArr2, i11, iArr, i10, iArr3, i12);
        }
        return zT;
    }

    public static boolean o(int[] iArr, int[] iArr2) {
        for (int i10 = 5; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean p(long[] jArr, long[] jArr2) {
        for (int i10 = 2; i10 >= 0; i10--) {
            if (jArr[i10] != jArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] q(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        int[] iArrJ = j();
        for (int i10 = 0; i10 < 6; i10++) {
            iArrJ[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrJ;
    }

    public static long[] r(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 192) {
            throw new IllegalArgumentException();
        }
        long[] jArrK = k();
        for (int i10 = 0; i10 < 3; i10++) {
            jArrK[i10] = bigInteger.longValue();
            bigInteger = bigInteger.shiftRight(64);
        }
        return jArrK;
    }

    public static int s(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 6) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean t(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 5; i12 >= 0; i12--) {
            int i13 = iArr[i10 + i12] ^ Integer.MIN_VALUE;
            int i14 = Integer.MIN_VALUE ^ iArr2[i11 + i12];
            if (i13 < i14) {
                return false;
            }
            if (i13 > i14) {
                return true;
            }
        }
        return true;
    }

    public static boolean u(int[] iArr, int[] iArr2) {
        for (int i10 = 5; i10 >= 0; i10--) {
            int i11 = iArr[i10] ^ Integer.MIN_VALUE;
            int i12 = Integer.MIN_VALUE ^ iArr2[i10];
            if (i11 < i12) {
                return false;
            }
            if (i11 > i12) {
                return true;
            }
        }
        return true;
    }

    public static boolean v(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 6; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean w(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 3; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean x(int[] iArr) {
        for (int i10 = 0; i10 < 6; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean y(long[] jArr) {
        for (int i10 = 0; i10 < 3; i10++) {
            if (jArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void z(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr[i10 + 0]) & 4294967295L;
        long j17 = (j16 * j10) + 0;
        iArr3[i12 + 0] = (int) j17;
        long j18 = (j17 >>> 32) + (j16 * j11);
        iArr3[i12 + 1] = (int) j18;
        long j19 = (j18 >>> 32) + (j16 * j12);
        iArr3[i12 + 2] = (int) j19;
        long j20 = (j19 >>> 32) + (j16 * j13);
        iArr3[i12 + 3] = (int) j20;
        long j21 = (j20 >>> 32) + (j16 * j14);
        iArr3[i12 + 4] = (int) j21;
        long j22 = (j21 >>> 32) + (j16 * j15);
        iArr3[i12 + 5] = (int) j22;
        iArr3[i12 + 6] = (int) (j22 >>> 32);
        int i13 = 1;
        int i14 = i12;
        int i15 = 1;
        while (i15 < 6) {
            i14 += i13;
            long j23 = ((long) iArr[i10 + i15]) & 4294967295L;
            int i16 = i14 + 0;
            long j24 = (j23 * j10) + (((long) iArr3[i16]) & 4294967295L) + 0;
            iArr3[i16] = (int) j24;
            int i17 = i14 + 1;
            long j25 = j15;
            long j26 = (j24 >>> 32) + (j23 * j11) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j26;
            int i18 = i14 + 2;
            long j27 = (j26 >>> 32) + (j23 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j27;
            int i19 = i14 + 3;
            long j28 = (j27 >>> 32) + (j23 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j28;
            int i20 = i14 + 4;
            long j29 = (j28 >>> 32) + (j23 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j29;
            int i21 = i14 + 5;
            long j30 = (j29 >>> 32) + (j23 * j25) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j30;
            iArr3[i14 + 6] = (int) (j30 >>> 32);
            i15++;
            j12 = j12;
            j15 = j25;
            i13 = 1;
        }
    }
}
