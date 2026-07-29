package rr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f49138a = 4294967295L;

    public static int A(int i10, int[] iArr) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((((long) iArr[0]) & 4294967295L) * j10) + 0;
        iArr[0] = (int) j11;
        long j12 = (j11 >>> 32) + ((((long) iArr[1]) & 4294967295L) * j10);
        iArr[1] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr[2]) & 4294967295L) * j10);
        iArr[2] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr[3]) & 4294967295L) * j10);
        iArr[3] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr[4]) & 4294967295L) * j10);
        iArr[4] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr[5]) & 4294967295L) * j10);
        iArr[5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * (4294967295L & ((long) iArr[6])));
        iArr[6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int B(int i10, int[] iArr, int[] iArr2) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = ((((long) iArr2[0]) & 4294967295L) * j10) + (((long) iArr[0]) & 4294967295L) + 0;
        iArr2[0] = (int) j11;
        long j12 = (j11 >>> 32) + ((((long) iArr2[1]) & 4294967295L) * j10) + (((long) iArr[1]) & 4294967295L);
        iArr2[1] = (int) j12;
        long j13 = (j12 >>> 32) + ((((long) iArr2[2]) & 4294967295L) * j10) + (((long) iArr[2]) & 4294967295L);
        iArr2[2] = (int) j13;
        long j14 = (j13 >>> 32) + ((((long) iArr2[3]) & 4294967295L) * j10) + (((long) iArr[3]) & 4294967295L);
        iArr2[3] = (int) j14;
        long j15 = (j14 >>> 32) + ((((long) iArr2[4]) & 4294967295L) * j10) + (((long) iArr[4]) & 4294967295L);
        iArr2[4] = (int) j15;
        long j16 = (j15 >>> 32) + ((((long) iArr2[5]) & 4294967295L) * j10) + (((long) iArr[5]) & 4294967295L);
        iArr2[5] = (int) j16;
        long j17 = (j16 >>> 32) + (j10 * (((long) iArr2[6]) & 4294967295L)) + (4294967295L & ((long) iArr[6]));
        iArr2[6] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int C(int i10, int[] iArr, int[] iArr2, int i11) {
        long j10 = ((long) i10) & 4294967295L;
        long j11 = 0;
        int i12 = 0;
        do {
            long j12 = j11 + ((((long) iArr[i12]) & 4294967295L) * j10);
            iArr2[i11 + i12] = (int) j12;
            j11 = j12 >>> 32;
            i12++;
        } while (i12 < 7);
        return (int) j11;
    }

    public static int D(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
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
        long j16 = (j15 >>> 32) + ((((long) iArr[i11 + 5]) & 4294967295L) * j10) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j16;
        int i19 = i12 + 6;
        long j17 = (j16 >>> 32) + (j10 * (((long) iArr[i11 + 6]) & 4294967295L)) + (((long) iArr2[i19]) & 4294967295L);
        iArr2[i19] = (int) j17;
        return (int) (j17 >>> 32);
    }

    public static int E(int i10, long j10, int[] iArr, int i11) {
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
        return o.b0(7, iArr, i11, 3);
    }

    public static void F(int[] iArr, int i10, int[] iArr2, int i11) {
        long j10 = ((long) iArr[i10 + 0]) & 4294967295L;
        int i12 = 0;
        int i13 = 14;
        int i14 = 6;
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
                long j45 = (j37 & 4294967295L) + (j42 * j10);
                int i33 = (int) j45;
                iArr2[i24] = i30 | (i33 << 1);
                int i34 = i33 >>> 31;
                long j46 = (j38 & 4294967295L) + (j45 >>> 32) + (j42 * j14);
                long j47 = j41 + (j46 >>> 32) + (j42 * j18);
                long j48 = (j40 & 4294967295L) + (j47 >>> 32) + (j42 * j24);
                long j49 = (j43 & 4294967295L) + (j48 >>> 32) + (j42 * j32);
                long j50 = j44 + (j49 >>> 32);
                long j51 = j49 & 4294967295L;
                long j52 = ((long) iArr[i10 + 6]) & 4294967295L;
                int i35 = i11 + 11;
                long j53 = (((long) iArr2[i35]) & 4294967295L) + (j50 >>> 32);
                long j54 = j50 & 4294967295L;
                int i36 = i11 + 12;
                long j55 = (((long) iArr2[i36]) & 4294967295L) + (j53 >>> 32);
                long j56 = (j46 & 4294967295L) + (j10 * j52);
                int i37 = (int) j56;
                iArr2[i25] = (i37 << 1) | i34;
                long j57 = (j47 & 4294967295L) + (j56 >>> 32) + (j52 * j14);
                long j58 = (j48 & 4294967295L) + (j57 >>> 32) + (j52 * j18);
                long j59 = j51 + (j58 >>> 32) + (j52 * j24);
                long j60 = j54 + (j59 >>> 32) + (j52 * j32);
                long j61 = (j53 & 4294967295L) + (j60 >>> 32) + (j52 * j42);
                long j62 = j55 + (j61 >>> 32);
                int i38 = (int) j57;
                iArr2[i27] = (i37 >>> 31) | (i38 << 1);
                int i39 = (int) j58;
                iArr2[i28] = (i38 >>> 31) | (i39 << 1);
                int i40 = (int) j59;
                iArr2[i31] = (i39 >>> 31) | (i40 << 1);
                int i41 = i40 >>> 31;
                int i42 = (int) j60;
                iArr2[i32] = i41 | (i42 << 1);
                int i43 = i42 >>> 31;
                int i44 = (int) j61;
                iArr2[i35] = i43 | (i44 << 1);
                int i45 = i44 >>> 31;
                int i46 = (int) j62;
                iArr2[i36] = i45 | (i46 << 1);
                int i47 = i46 >>> 31;
                int i48 = i11 + 13;
                iArr2[i48] = i47 | ((iArr2[i48] + ((int) (j62 >>> 32))) << 1);
                return;
            }
            i14 = i15;
        }
    }

    public static void G(int[] iArr, int[] iArr2) {
        long j10 = ((long) iArr[0]) & 4294967295L;
        int i10 = 14;
        int i11 = 6;
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
                iArr2[3] = (i18 >>> 31) | (i19 << 1);
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
                long j46 = (j37 & 4294967295L) + (j42 * j10);
                int i22 = (int) j46;
                iArr2[5] = (i22 << 1) | (i21 >>> 31);
                long j47 = (j38 & 4294967295L) + (j46 >>> 32) + (j42 * j14);
                long j48 = j41 + (j47 >>> 32) + (j42 * j18);
                long j49 = j44 + (j48 >>> 32) + (j42 * j24);
                long j50 = (j43 & 4294967295L) + (j49 >>> 32) + (j42 * j32);
                long j51 = j45 + (j50 >>> 32);
                long j52 = j50 & 4294967295L;
                long j53 = ((long) iArr[6]) & 4294967295L;
                long j54 = (((long) iArr2[11]) & 4294967295L) + (j51 >>> 32);
                long j55 = j51 & 4294967295L;
                long j56 = (((long) iArr2[12]) & 4294967295L) + (j54 >>> 32);
                long j57 = 4294967295L & j54;
                long j58 = (j47 & 4294967295L) + (j10 * j53);
                int i23 = (int) j58;
                iArr2[6] = (i22 >>> 31) | (i23 << 1);
                int i24 = i23 >>> 31;
                long j59 = (j48 & 4294967295L) + (j58 >>> 32) + (j53 * j14);
                long j60 = (j49 & 4294967295L) + (j59 >>> 32) + (j53 * j18);
                long j61 = j52 + (j60 >>> 32) + (j53 * j24);
                long j62 = j55 + (j61 >>> 32) + (j53 * j32);
                long j63 = j57 + (j62 >>> 32) + (j53 * j42);
                long j64 = j56 + (j63 >>> 32);
                int i25 = (int) j59;
                iArr2[7] = i24 | (i25 << 1);
                int i26 = (int) j60;
                iArr2[8] = (i25 >>> 31) | (i26 << 1);
                int i27 = (int) j61;
                iArr2[9] = (i26 >>> 31) | (i27 << 1);
                int i28 = i27 >>> 31;
                int i29 = (int) j62;
                iArr2[10] = i28 | (i29 << 1);
                int i30 = i29 >>> 31;
                int i31 = (int) j63;
                iArr2[11] = i30 | (i31 << 1);
                int i32 = i31 >>> 31;
                int i33 = (int) j64;
                iArr2[12] = i32 | (i33 << 1);
                iArr2[13] = (i33 >>> 31) | ((iArr2[13] + ((int) (j64 >>> 32))) << 1);
                return;
            }
            i11 = i13;
            i12 = i15;
        }
    }

    public static int H(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
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
        long j16 = (j15 >> 32) + ((((long) iArr[i10 + 6]) & 4294967295L) - (((long) iArr2[i11 + 6]) & 4294967295L));
        iArr3[i12 + 6] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static int I(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j16 = (j15 >> 32) + ((((long) iArr[6]) & 4294967295L) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static int J(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j16 = (j15 >> 32) + (((((long) iArr3[6]) & 4294967295L) - (((long) iArr[6]) & 4294967295L)) - (((long) iArr2[6]) & 4294967295L));
        iArr3[6] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static int K(int[] iArr, int i10, int[] iArr2, int i11) {
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
        int i18 = i11 + 6;
        long j16 = (j15 >> 32) + ((((long) iArr2[i18]) & 4294967295L) - (((long) iArr[i10 + 6]) & 4294967295L));
        iArr2[i18] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static int L(int[] iArr, int[] iArr2) {
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
        long j15 = (j14 >> 32) + ((((long) iArr2[5]) & 4294967295L) - (((long) iArr[5]) & 4294967295L));
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + ((((long) iArr2[6]) & 4294967295L) - (4294967295L & ((long) iArr[6])));
        iArr2[6] = (int) j16;
        return (int) (j16 >> 32);
    }

    public static BigInteger M(int[] iArr) {
        byte[] bArr = new byte[28];
        for (int i10 = 0; i10 < 7; i10++) {
            int i11 = iArr[i10];
            if (i11 != 0) {
                org.bouncycastle.util.o.h(i11, bArr, (6 - i10) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static void N(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
    }

    public static int a(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i11 + 0]) & 4294967295L) + 0;
        iArr3[i12 + 0] = (int) j10;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i11 + 1]) & 4294967295L);
        iArr3[i12 + 1] = (int) j11;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i11 + 2]) & 4294967295L);
        iArr3[i12 + 2] = (int) j12;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i11 + 3]) & 4294967295L);
        iArr3[i12 + 3] = (int) j13;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i11 + 4]) & 4294967295L);
        iArr3[i12 + 4] = (int) j14;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i11 + 5]) & 4294967295L);
        iArr3[i12 + 5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i11 + 6]) & 4294967295L);
        iArr3[i12 + 6] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int b(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int c(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        int i13 = i12 + 0;
        long j10 = (((long) iArr[i10 + 0]) & 4294967295L) + (((long) iArr2[i11 + 0]) & 4294967295L) + (((long) iArr3[i13]) & 4294967295L) + 0;
        iArr3[i13] = (int) j10;
        int i14 = i12 + 1;
        long j11 = (j10 >>> 32) + (((long) iArr[i10 + 1]) & 4294967295L) + (((long) iArr2[i11 + 1]) & 4294967295L) + (((long) iArr3[i14]) & 4294967295L);
        iArr3[i14] = (int) j11;
        int i15 = i12 + 2;
        long j12 = (j11 >>> 32) + (((long) iArr[i10 + 2]) & 4294967295L) + (((long) iArr2[i11 + 2]) & 4294967295L) + (((long) iArr3[i15]) & 4294967295L);
        iArr3[i15] = (int) j12;
        int i16 = i12 + 3;
        long j13 = (j12 >>> 32) + (((long) iArr[i10 + 3]) & 4294967295L) + (((long) iArr2[i11 + 3]) & 4294967295L) + (((long) iArr3[i16]) & 4294967295L);
        iArr3[i16] = (int) j13;
        int i17 = i12 + 4;
        long j14 = (j13 >>> 32) + (((long) iArr[i10 + 4]) & 4294967295L) + (((long) iArr2[i11 + 4]) & 4294967295L) + (((long) iArr3[i17]) & 4294967295L);
        iArr3[i17] = (int) j14;
        int i18 = i12 + 5;
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i11 + 5]) & 4294967295L) + (((long) iArr3[i18]) & 4294967295L);
        iArr3[i18] = (int) j15;
        int i19 = i12 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (((long) iArr2[i11 + 6]) & 4294967295L) + (((long) iArr3[i19]) & 4294967295L);
        iArr3[i19] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int d(int[] iArr, int[] iArr2, int[] iArr3) {
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
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (((long) iArr2[6]) & 4294967295L) + (((long) iArr3[6]) & 4294967295L);
        iArr3[6] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int e(int[] iArr, int i10, int[] iArr2, int i11, int i12) {
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
        long j15 = (j14 >>> 32) + (((long) iArr[i10 + 5]) & 4294967295L) + (((long) iArr2[i18]) & 4294967295L);
        iArr2[i18] = (int) j15;
        int i19 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i10 + 6]) & 4294967295L) + (4294967295L & ((long) iArr2[i19]));
        iArr2[i19] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int f(int[] iArr, int[] iArr2) {
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
        long j15 = (j14 >>> 32) + (((long) iArr[5]) & 4294967295L) + (((long) iArr2[5]) & 4294967295L);
        iArr2[5] = (int) j15;
        long j16 = (j15 >>> 32) + (((long) iArr[6]) & 4294967295L) + (4294967295L & ((long) iArr2[6]));
        iArr2[6] = (int) j16;
        return (int) (j16 >>> 32);
    }

    public static int g(int[] iArr, int i10, int[] iArr2, int i11) {
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
        long j15 = (j14 >>> 32) + (((long) iArr[i27]) & 4294967295L) + (((long) iArr2[i28]) & 4294967295L);
        int i29 = (int) j15;
        iArr[i27] = i29;
        iArr2[i28] = i29;
        int i30 = i10 + 6;
        int i31 = i11 + 6;
        long j16 = (j15 >>> 32) + (((long) iArr[i30]) & 4294967295L) + (4294967295L & ((long) iArr2[i31]));
        int i32 = (int) j16;
        iArr[i30] = i32;
        iArr2[i31] = i32;
        return (int) (j16 >>> 32);
    }

    public static void h(int[] iArr, int i10, int[] iArr2, int i11) {
        iArr2[i11 + 0] = iArr[i10 + 0];
        iArr2[i11 + 1] = iArr[i10 + 1];
        iArr2[i11 + 2] = iArr[i10 + 2];
        iArr2[i11 + 3] = iArr[i10 + 3];
        iArr2[i11 + 4] = iArr[i10 + 4];
        iArr2[i11 + 5] = iArr[i10 + 5];
        iArr2[i11 + 6] = iArr[i10 + 6];
    }

    public static void i(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
        iArr2[4] = iArr[4];
        iArr2[5] = iArr[5];
        iArr2[6] = iArr[6];
    }

    public static int[] j() {
        return new int[7];
    }

    public static int[] k() {
        return new int[14];
    }

    public static boolean l(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        boolean zP = p(iArr, i10, iArr2, i11);
        if (zP) {
            H(iArr, i10, iArr2, i11, iArr3, i12);
        } else {
            H(iArr2, i11, iArr, i10, iArr3, i12);
        }
        return zP;
    }

    public static boolean m(int[] iArr, int[] iArr2) {
        for (int i10 = 6; i10 >= 0; i10--) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int[] n(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 224) {
            throw new IllegalArgumentException();
        }
        int[] iArrJ = j();
        for (int i10 = 0; i10 < 7; i10++) {
            iArrJ[i10] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return iArrJ;
    }

    public static int o(int[] iArr, int i10) {
        int i11;
        if (i10 == 0) {
            i11 = iArr[0];
        } else {
            int i12 = i10 >> 5;
            if (i12 < 0 || i12 >= 7) {
                return 0;
            }
            i11 = iArr[i12] >>> (i10 & 31);
        }
        return i11 & 1;
    }

    public static boolean p(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 6; i12 >= 0; i12--) {
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

    public static boolean q(int[] iArr, int[] iArr2) {
        for (int i10 = 6; i10 >= 0; i10--) {
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

    public static boolean r(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i10 = 1; i10 < 7; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int[] iArr) {
        for (int i10 = 0; i10 < 7; i10++) {
            if (iArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void t(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 6]) & 4294967295L;
        long j17 = ((long) iArr[i10 + 0]) & 4294967295L;
        long j18 = (j17 * j10) + 0;
        iArr3[i12 + 0] = (int) j18;
        long j19 = (j18 >>> 32) + (j17 * j11);
        iArr3[i12 + 1] = (int) j19;
        long j20 = (j19 >>> 32) + (j17 * j12);
        iArr3[i12 + 2] = (int) j20;
        long j21 = (j20 >>> 32) + (j17 * j13);
        iArr3[i12 + 3] = (int) j21;
        long j22 = (j21 >>> 32) + (j17 * j14);
        iArr3[i12 + 4] = (int) j22;
        long j23 = (j22 >>> 32) + (j17 * j15);
        iArr3[i12 + 5] = (int) j23;
        long j24 = j16;
        long j25 = (j23 >>> 32) + (j17 * j24);
        iArr3[i12 + 6] = (int) j25;
        iArr3[i12 + 7] = (int) (j25 >>> 32);
        int i13 = 1;
        int i14 = i12;
        int i15 = 1;
        while (i15 < 7) {
            i14 += i13;
            long j26 = ((long) iArr[i10 + i15]) & 4294967295L;
            int i16 = i14 + 0;
            long j27 = (j26 * j10) + (((long) iArr3[i16]) & 4294967295L) + 0;
            iArr3[i16] = (int) j27;
            int i17 = i14 + 1;
            long j28 = j24;
            long j29 = (j27 >>> 32) + (j26 * j11) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j29;
            int i18 = i14 + 2;
            long j30 = j12;
            long j31 = (j29 >>> 32) + (j26 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j31;
            int i19 = i14 + 3;
            long j32 = (j31 >>> 32) + (j26 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j32;
            int i20 = i14 + 4;
            long j33 = (j32 >>> 32) + (j26 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j33;
            int i21 = i14 + 5;
            long j34 = (j33 >>> 32) + (j26 * j15) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j34;
            int i22 = i14 + 6;
            long j35 = (j34 >>> 32) + (j26 * j28) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j35;
            iArr3[i14 + 7] = (int) (j35 >>> 32);
            i15++;
            j12 = j30;
            j24 = j28;
            j13 = j13;
            i13 = 1;
        }
    }

    public static void u(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = ((long) iArr[0]) & 4294967295L;
        long j18 = (j17 * j10) + 0;
        iArr3[0] = (int) j18;
        long j19 = (j18 >>> 32) + (j17 * j11);
        iArr3[1] = (int) j19;
        long j20 = (j19 >>> 32) + (j17 * j12);
        iArr3[2] = (int) j20;
        long j21 = (j20 >>> 32) + (j17 * j13);
        iArr3[3] = (int) j21;
        long j22 = (j21 >>> 32) + (j17 * j14);
        iArr3[4] = (int) j22;
        long j23 = (j22 >>> 32) + (j17 * j15);
        iArr3[5] = (int) j23;
        long j24 = (j23 >>> 32) + (j17 * j16);
        iArr3[6] = (int) j24;
        int i10 = (int) (j24 >>> 32);
        iArr3[7] = i10;
        int i11 = 1;
        for (int i12 = 7; i11 < i12; i12 = 7) {
            long j25 = ((long) iArr[i11]) & 4294967295L;
            int i13 = i11 + 0;
            long j26 = (j25 * j10) + (((long) iArr3[i13]) & 4294967295L) + 0;
            iArr3[i13] = (int) j26;
            int i14 = i11 + 1;
            long j27 = j11;
            long j28 = (j26 >>> 32) + (j25 * j11) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j28;
            int i15 = i11 + 2;
            long j29 = j15;
            long j30 = (j28 >>> 32) + (j25 * j12) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j30;
            int i16 = i11 + 3;
            long j31 = (j30 >>> 32) + (j25 * j13) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j31;
            int i17 = i11 + 4;
            long j32 = (j31 >>> 32) + (j25 * j14) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j32;
            int i18 = i11 + 5;
            long j33 = (j32 >>> 32) + (j25 * j29) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j33;
            int i19 = i11 + 6;
            long j34 = (j33 >>> 32) + (j25 * j16) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j34;
            iArr3[i11 + 7] = (int) (j34 >>> 32);
            i11 = i14;
            j10 = j10;
            j11 = j27;
            j15 = j29;
        }
    }

    public static long v(int i10, int[] iArr, int i11, int[] iArr2, int i12, int[] iArr3, int i13) {
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
        long j23 = (j21 >>> 32) + (j10 * j22) + j20 + (((long) iArr2[i12 + 5]) & 4294967295L);
        iArr3[i13 + 5] = (int) j23;
        long j24 = ((long) iArr[i11 + 6]) & 4294967295L;
        long j25 = (j23 >>> 32) + (j10 * j24) + j22 + (4294967295L & ((long) iArr2[i12 + 6]));
        iArr3[i13 + 6] = (int) j25;
        return (j25 >>> 32) + j24;
    }

    public static int w(int i10, long j10, int[] iArr, int i11) {
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
        return o.b0(7, iArr, i11, 4);
    }

    public static int x(int i10, int i11, int[] iArr, int i12) {
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
        return o.b0(7, iArr, i12, 3);
    }

    public static int y(int[] iArr, int i10, int[] iArr2, int i11, int[] iArr3, int i12) {
        long j10 = ((long) iArr2[i11 + 0]) & 4294967295L;
        long j11 = ((long) iArr2[i11 + 1]) & 4294967295L;
        long j12 = ((long) iArr2[i11 + 2]) & 4294967295L;
        long j13 = ((long) iArr2[i11 + 3]) & 4294967295L;
        long j14 = ((long) iArr2[i11 + 4]) & 4294967295L;
        long j15 = ((long) iArr2[i11 + 5]) & 4294967295L;
        long j16 = ((long) iArr2[i11 + 6]) & 4294967295L;
        int i13 = i12;
        long j17 = 0;
        int i14 = 0;
        while (i14 < 7) {
            int i15 = i14;
            long j18 = ((long) iArr[i10 + i14]) & 4294967295L;
            int i16 = i13 + 0;
            long j19 = j10;
            long j20 = (j18 * j10) + (((long) iArr3[i16]) & 4294967295L) + 0;
            long j21 = j16;
            iArr3[i16] = (int) j20;
            int i17 = i13 + 1;
            long j22 = (j20 >>> 32) + (j18 * j11) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j22;
            int i18 = i13 + 2;
            long j23 = (j22 >>> 32) + (j18 * j12) + (((long) iArr3[i18]) & 4294967295L);
            iArr3[i18] = (int) j23;
            int i19 = i13 + 3;
            long j24 = (j23 >>> 32) + (j18 * j13) + (((long) iArr3[i19]) & 4294967295L);
            iArr3[i19] = (int) j24;
            int i20 = i13 + 4;
            long j25 = (j24 >>> 32) + (j18 * j14) + (((long) iArr3[i20]) & 4294967295L);
            iArr3[i20] = (int) j25;
            int i21 = i13 + 5;
            long j26 = (j25 >>> 32) + (j18 * j15) + (((long) iArr3[i21]) & 4294967295L);
            iArr3[i21] = (int) j26;
            int i22 = i13 + 6;
            long j27 = (j26 >>> 32) + (j18 * j21) + (((long) iArr3[i22]) & 4294967295L);
            iArr3[i22] = (int) j27;
            int i23 = i13 + 7;
            long j28 = (j27 >>> 32) + (((long) iArr3[i23]) & 4294967295L) + j17;
            iArr3[i23] = (int) j28;
            j17 = j28 >>> 32;
            i14 = i15 + 1;
            i13 = i17;
            j16 = j21;
            j10 = j19;
            j11 = j11;
        }
        return (int) j17;
    }

    public static int z(int[] iArr, int[] iArr2, int[] iArr3) {
        long j10 = ((long) iArr2[0]) & 4294967295L;
        long j11 = ((long) iArr2[1]) & 4294967295L;
        long j12 = ((long) iArr2[2]) & 4294967295L;
        long j13 = ((long) iArr2[3]) & 4294967295L;
        long j14 = ((long) iArr2[4]) & 4294967295L;
        long j15 = ((long) iArr2[5]) & 4294967295L;
        long j16 = ((long) iArr2[6]) & 4294967295L;
        long j17 = 0;
        int i10 = 0;
        while (i10 < 7) {
            long j18 = j16;
            long j19 = ((long) iArr[i10]) & 4294967295L;
            int i11 = i10 + 0;
            long j20 = j15;
            long j21 = (j19 * j10) + (((long) iArr3[i11]) & 4294967295L) + 0;
            iArr3[i11] = (int) j21;
            int i12 = i10 + 1;
            long j22 = j11;
            long j23 = (j21 >>> 32) + (j19 * j11) + (((long) iArr3[i12]) & 4294967295L);
            iArr3[i12] = (int) j23;
            int i13 = i10 + 2;
            long j24 = (j23 >>> 32) + (j19 * j12) + (((long) iArr3[i13]) & 4294967295L);
            iArr3[i13] = (int) j24;
            int i14 = i10 + 3;
            long j25 = (j24 >>> 32) + (j19 * j13) + (((long) iArr3[i14]) & 4294967295L);
            iArr3[i14] = (int) j25;
            int i15 = i10 + 4;
            long j26 = (j25 >>> 32) + (j19 * j14) + (((long) iArr3[i15]) & 4294967295L);
            iArr3[i15] = (int) j26;
            int i16 = i10 + 5;
            long j27 = (j26 >>> 32) + (j19 * j20) + (((long) iArr3[i16]) & 4294967295L);
            iArr3[i16] = (int) j27;
            int i17 = i10 + 6;
            long j28 = (j27 >>> 32) + (j19 * j18) + (((long) iArr3[i17]) & 4294967295L);
            iArr3[i17] = (int) j28;
            int i18 = i10 + 7;
            long j29 = (j28 >>> 32) + (((long) iArr3[i18]) & 4294967295L) + j17;
            iArr3[i18] = (int) j29;
            j17 = j29 >>> 32;
            i10 = i12;
            j16 = j18;
            j15 = j20;
            j11 = j22;
        }
        return (int) j17;
    }
}
