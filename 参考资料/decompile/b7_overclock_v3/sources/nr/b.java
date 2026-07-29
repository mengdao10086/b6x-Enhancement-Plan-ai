package nr;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42624a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42625b = 16777215;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42626c = 33554431;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42627d = 67108863;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f42628e = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f42629f = {34513072, 59165138, 4688974, 3500415, 6194736, 33281959, 54535759, 32551604, 163342, 5703241};

    public static boolean A(int[] iArr) {
        return z(iArr) != 0;
    }

    public static int B(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean C(int[] iArr) {
        return B(iArr) != 0;
    }

    public static void D(int[] iArr, int i10, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr[1];
        int i13 = iArr[2];
        int i14 = iArr[3];
        int i15 = iArr[4];
        int i16 = iArr[5];
        int i17 = iArr[6];
        int i18 = iArr[7];
        int i19 = iArr[8];
        int i20 = iArr[9];
        long j10 = i10;
        long j11 = ((long) i13) * j10;
        int i21 = ((int) j11) & f42626c;
        long j12 = ((long) i15) * j10;
        int i22 = ((int) j12) & f42626c;
        long j13 = ((long) i18) * j10;
        int i23 = ((int) j13) & f42626c;
        long j14 = ((long) i20) * j10;
        int i24 = ((int) j14) & f42626c;
        long j15 = ((j14 >> 25) * 38) + (((long) i11) * j10);
        iArr2[0] = ((int) j15) & f42627d;
        long j16 = (j12 >> 25) + (((long) i16) * j10);
        iArr2[5] = ((int) j16) & f42627d;
        long j17 = (j15 >> 26) + (((long) i12) * j10);
        iArr2[1] = ((int) j17) & f42627d;
        long j18 = (j11 >> 25) + (((long) i14) * j10);
        iArr2[3] = ((int) j18) & f42627d;
        long j19 = (j16 >> 26) + (((long) i17) * j10);
        iArr2[6] = ((int) j19) & f42627d;
        long j20 = (j13 >> 25) + (((long) i19) * j10);
        iArr2[8] = ((int) j20) & f42627d;
        iArr2[2] = i21 + ((int) (j17 >> 26));
        iArr2[4] = i22 + ((int) (j18 >> 26));
        iArr2[7] = i23 + ((int) (j19 >> 26));
        iArr2[9] = i24 + ((int) (j20 >> 26));
    }

    public static void E(int[] iArr, int[] iArr2, int[] iArr3) {
        int i10 = iArr[0];
        int i11 = iArr2[0];
        int i12 = iArr[1];
        int i13 = iArr2[1];
        int i14 = iArr[2];
        int i15 = iArr2[2];
        int i16 = iArr[3];
        int i17 = iArr2[3];
        int i18 = iArr[4];
        int i19 = iArr2[4];
        int i20 = iArr[5];
        int i21 = iArr2[5];
        int i22 = iArr[6];
        int i23 = iArr2[6];
        int i24 = iArr[7];
        int i25 = iArr2[7];
        int i26 = iArr[8];
        int i27 = iArr2[8];
        int i28 = iArr[9];
        int i29 = iArr2[9];
        long j10 = i10;
        long j11 = i11;
        long j12 = j10 * j11;
        long j13 = i13;
        long j14 = i12;
        long j15 = (j10 * j13) + (j14 * j11);
        long j16 = i15;
        long j17 = i14;
        long j18 = (j10 * j16) + (j14 * j13) + (j17 * j11);
        long j19 = ((j14 * j16) + (j17 * j13)) << 1;
        long j20 = i17;
        long j21 = j10 * j20;
        long j22 = i16;
        long j23 = j19 + j21 + (j22 * j11);
        long j24 = (j17 * j16) << 1;
        long j25 = i19;
        long j26 = (j10 * j25) + (j14 * j20) + (j22 * j13);
        long j27 = i18;
        long j28 = j24 + j26 + (j11 * j27);
        long j29 = ((((j14 * j25) + (j17 * j20)) + (j22 * j16)) + (j27 * j13)) << 1;
        long j30 = (((j17 * j25) + (j27 * j16)) << 1) + (j22 * j20);
        long j31 = (j22 * j25) + (j27 * j20);
        long j32 = (j27 * j25) << 1;
        long j33 = i20;
        long j34 = i21;
        long j35 = j33 * j34;
        long j36 = i23;
        long j37 = i22;
        long j38 = (j33 * j36) + (j37 * j34);
        long j39 = i25;
        long j40 = i24;
        long j41 = (j33 * j39) + (j37 * j36) + (j40 * j34);
        long j42 = i27;
        long j43 = i26;
        long j44 = (((j37 * j39) + (j40 * j36)) << 1) + (j33 * j42) + (j43 * j34);
        long j45 = (j40 * j39) << 1;
        long j46 = i29;
        long j47 = (j33 * j46) + (j37 * j42) + (j43 * j36);
        long j48 = i28;
        long j49 = j45 + j47 + (j34 * j48);
        long j50 = j12 - (((((j37 * j46) + (j40 * j42)) + (j43 * j39)) + (j48 * j36)) * 76);
        long j51 = j15 - (((((j40 * j46) + (j48 * j39)) << 1) + (j43 * j42)) * 38);
        long j52 = j18 - (((j43 * j46) + (j42 * j48)) * 38);
        long j53 = j23 - ((j48 * j46) * 76);
        long j54 = j29 - j35;
        long j55 = j30 - j38;
        long j56 = j31 - j41;
        long j57 = j32 - j44;
        int i30 = i10 + i20;
        int i31 = i12 + i22;
        int i32 = i14 + i24;
        int i33 = i15 + i25;
        int i34 = i16 + i26;
        int i35 = i18 + i28;
        long j58 = i30;
        long j59 = i11 + i21;
        long j60 = i13 + i23;
        long j61 = i31;
        long j62 = (j58 * j60) + (j61 * j59);
        long j63 = i33;
        long j64 = i32;
        long j65 = (j58 * j63) + (j61 * j60) + (j64 * j59);
        long j66 = ((j61 * j63) + (j64 * j60)) << 1;
        long j67 = i17 + i27;
        long j68 = i34;
        long j69 = i19 + i29;
        long j70 = i35;
        long j71 = ((((j61 * j69) + (j64 * j67)) + (j68 * j63)) + (j70 * j60)) << 1;
        long j72 = (((j64 * j69) + (j70 * j63)) << 1) + (j68 * j67);
        long j73 = j57 + ((j66 + ((j58 * j67) + (j68 * j59))) - j53);
        int i36 = ((int) j73) & f42627d;
        long j74 = (j73 >> 26) + (((((j64 * j63) << 1) + ((((j58 * j69) + (j61 * j67)) + (j68 * j60)) + (j59 * j70))) - j28) - j49);
        int i37 = ((int) j74) & f42626c;
        long j75 = j50 + ((((j74 >> 25) + j71) - j54) * 38);
        iArr3[0] = ((int) j75) & f42627d;
        long j76 = (j75 >> 26) + j51 + ((j72 - j55) * 38);
        iArr3[1] = ((int) j76) & f42627d;
        long j77 = (j76 >> 26) + j52 + ((((j68 * j69) + (j70 * j67)) - j56) * 38);
        iArr3[2] = ((int) j77) & f42626c;
        long j78 = (j77 >> 25) + j53 + ((((j70 * j69) << 1) - j57) * 38);
        iArr3[3] = ((int) j78) & f42627d;
        long j79 = (j78 >> 26) + j28 + (j49 * 38);
        iArr3[4] = ((int) j79) & f42626c;
        long j80 = (j79 >> 25) + j54 + ((j58 * j59) - j50);
        iArr3[5] = ((int) j80) & f42627d;
        long j81 = (j80 >> 26) + j55 + (j62 - j51);
        iArr3[6] = ((int) j81) & f42627d;
        long j82 = (j81 >> 26) + j56 + (j65 - j52);
        iArr3[7] = ((int) j82) & f42626c;
        long j83 = (j82 >> 25) + ((long) i36);
        iArr3[8] = ((int) j83) & f42627d;
        iArr3[9] = i37 + ((int) (j83 >> 26));
    }

    public static void F(int[] iArr, int[] iArr2) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr2[i10] = -iArr[i10];
        }
    }

    public static void G(int[] iArr) {
        int i10 = (iArr[9] >>> 23) & 1;
        J(iArr, i10);
        J(iArr, -i10);
    }

    public static void H(int[] iArr) {
        iArr[0] = 1;
        for (int i10 = 1; i10 < 10; i10++) {
            iArr[i10] = 0;
        }
    }

    public static void I(int[] iArr, int[] iArr2, int[] iArr3) {
        L(iArr, iArr2);
        E(iArr, iArr2, iArr2);
        int[] iArrK = k();
        L(iArr2, iArrK);
        E(iArr, iArrK, iArrK);
        K(iArrK, 2, iArrK);
        E(iArr2, iArrK, iArrK);
        int[] iArrK2 = k();
        K(iArrK, 5, iArrK2);
        E(iArrK, iArrK2, iArrK2);
        int[] iArrK3 = k();
        K(iArrK2, 5, iArrK3);
        E(iArrK, iArrK3, iArrK3);
        K(iArrK3, 10, iArrK);
        E(iArrK2, iArrK, iArrK);
        K(iArrK, 25, iArrK2);
        E(iArrK, iArrK2, iArrK2);
        K(iArrK2, 25, iArrK3);
        E(iArrK, iArrK3, iArrK3);
        K(iArrK3, 50, iArrK);
        E(iArrK2, iArrK, iArrK);
        K(iArrK, 125, iArrK2);
        E(iArrK, iArrK2, iArrK2);
        K(iArrK2, 2, iArrK);
        E(iArrK, iArr, iArr3);
    }

    public static void J(int[] iArr, int i10) {
        int i11 = iArr[9];
        long j10 = ((long) (((i11 >> 24) + i10) * 19)) + ((long) iArr[0]);
        iArr[0] = ((int) j10) & f42627d;
        long j11 = (j10 >> 26) + ((long) iArr[1]);
        iArr[1] = ((int) j11) & f42627d;
        long j12 = (j11 >> 26) + ((long) iArr[2]);
        iArr[2] = ((int) j12) & f42626c;
        long j13 = (j12 >> 25) + ((long) iArr[3]);
        iArr[3] = ((int) j13) & f42627d;
        long j14 = (j13 >> 26) + ((long) iArr[4]);
        iArr[4] = ((int) j14) & f42626c;
        long j15 = (j14 >> 25) + ((long) iArr[5]);
        iArr[5] = ((int) j15) & f42627d;
        long j16 = (j15 >> 26) + ((long) iArr[6]);
        iArr[6] = ((int) j16) & f42627d;
        long j17 = (j16 >> 26) + ((long) iArr[7]);
        iArr[7] = 33554431 & ((int) j17);
        long j18 = (j17 >> 25) + ((long) iArr[8]);
        iArr[8] = 67108863 & ((int) j18);
        iArr[9] = (16777215 & i11) + ((int) (j18 >> 26));
    }

    public static void K(int[] iArr, int i10, int[] iArr2) {
        L(iArr, iArr2);
        while (true) {
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                L(iArr2, iArr2);
            }
        }
    }

    public static void L(int[] iArr, int[] iArr2) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = iArr[4];
        int i15 = iArr[5];
        int i16 = iArr[6];
        int i17 = iArr[7];
        int i18 = iArr[8];
        int i19 = iArr[9];
        long j10 = i10;
        long j11 = j10 * j10;
        long j12 = i11 * 2;
        long j13 = j10 * j12;
        long j14 = i12 * 2;
        long j15 = i11;
        long j16 = (j10 * j14) + (j15 * j15);
        long j17 = i13 * 2;
        long j18 = (j12 * j14) + (j10 * j17);
        long j19 = i14 * 2;
        long j20 = (((long) i12) * j14) + (j10 * j19) + (j15 * j17);
        long j21 = (j12 * j19) + (j17 * j14);
        long j22 = i13;
        long j23 = (j14 * j19) + (j22 * j22);
        long j24 = j22 * j19;
        long j25 = ((long) i14) * j19;
        int i20 = i19 * 2;
        long j26 = i15;
        long j27 = j26 * j26;
        long j28 = i16 * 2;
        long j29 = j26 * j28;
        long j30 = i17 * 2;
        long j31 = i16;
        long j32 = (j26 * j30) + (j31 * j31);
        long j33 = i18 * 2;
        long j34 = (j28 * j30) + (j26 * j33);
        long j35 = i20;
        long j36 = (((long) i17) * j30) + (j26 * j35) + (j31 * j33);
        long j37 = i18;
        long j38 = j11 - (((j28 * j35) + (j33 * j30)) * 38);
        long j39 = j13 - (((j30 * j35) + (j37 * j37)) * 38);
        long j40 = j16 - ((j37 * j35) * 38);
        long j41 = j18 - ((((long) i19) * j35) * 38);
        long j42 = j21 - j27;
        long j43 = j23 - j29;
        long j44 = j24 - j32;
        long j45 = j25 - j34;
        int i21 = i11 + i16;
        int i22 = i12 + i17;
        int i23 = i13 + i18;
        int i24 = i14 + i19;
        long j46 = i10 + i15;
        long j47 = j46 * j46;
        long j48 = i21 * 2;
        long j49 = j46 * j48;
        long j50 = i22 * 2;
        long j51 = i21;
        long j52 = (j46 * j50) + (j51 * j51);
        long j53 = i23 * 2;
        long j54 = (j48 * j50) + (j46 * j53);
        long j55 = i24 * 2;
        long j56 = (((long) i22) * j50) + (j46 * j55) + (j51 * j53);
        long j57 = (j48 * j55) + (j53 * j50);
        long j58 = i23;
        long j59 = (j50 * j55) + (j58 * j58);
        long j60 = j58 * j55;
        long j61 = ((long) i24) * j55;
        long j62 = j45 + (j54 - j41);
        int i25 = ((int) j62) & f42627d;
        long j63 = (j62 >> 26) + ((j56 - j20) - j36);
        int i26 = ((int) j63) & f42626c;
        long j64 = j38 + ((((j63 >> 25) + j57) - j42) * 38);
        iArr2[0] = ((int) j64) & f42627d;
        long j65 = (j64 >> 26) + j39 + ((j59 - j43) * 38);
        iArr2[1] = ((int) j65) & f42627d;
        long j66 = (j65 >> 26) + j40 + ((j60 - j44) * 38);
        iArr2[2] = ((int) j66) & f42626c;
        long j67 = (j66 >> 25) + j41 + ((j61 - j45) * 38);
        iArr2[3] = ((int) j67) & f42627d;
        long j68 = (j67 >> 26) + j20 + (38 * j36);
        iArr2[4] = ((int) j68) & f42626c;
        long j69 = (j68 >> 25) + j42 + (j47 - j38);
        iArr2[5] = ((int) j69) & f42627d;
        long j70 = (j69 >> 26) + j43 + (j49 - j39);
        iArr2[6] = ((int) j70) & f42627d;
        long j71 = (j70 >> 26) + j44 + (j52 - j40);
        iArr2[7] = ((int) j71) & f42626c;
        long j72 = (j71 >> 25) + ((long) i25);
        iArr2[8] = ((int) j72) & f42627d;
        iArr2[9] = i26 + ((int) (j72 >> 26));
    }

    public static boolean M(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrK = k();
        int[] iArrK2 = k();
        E(iArr, iArr2, iArrK);
        L(iArr2, iArrK2);
        E(iArrK, iArrK2, iArrK);
        L(iArrK2, iArrK2);
        E(iArrK2, iArrK, iArrK2);
        int[] iArrK3 = k();
        int[] iArrK4 = k();
        I(iArrK2, iArrK3, iArrK4);
        E(iArrK4, iArrK, iArrK4);
        int[] iArrK5 = k();
        L(iArrK4, iArrK5);
        E(iArrK5, iArr2, iArrK5);
        N(iArrK5, iArr, iArrK3);
        G(iArrK3);
        if (C(iArrK3)) {
            j(iArrK4, 0, iArr3, 0);
            return true;
        }
        a(iArrK5, iArr, iArrK3);
        G(iArrK3);
        if (!C(iArrK3)) {
            return false;
        }
        E(iArrK4, f42629f, iArr3);
        return true;
    }

    public static void N(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr3[i10] = iArr[i10] - iArr2[i10];
        }
    }

    public static void O(int[] iArr) {
        iArr[0] = iArr[0] - 1;
    }

    public static void P(int[] iArr) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr[i10] = 0;
        }
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 10; i10++) {
            iArr3[i10] = iArr[i10] + iArr2[i10];
        }
    }

    public static void b(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void c(int[] iArr, int i10) {
        iArr[i10] = iArr[i10] + 1;
    }

    public static void d(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        for (int i10 = 0; i10 < 10; i10++) {
            int i11 = iArr[i10];
            int i12 = iArr2[i10];
            iArr3[i10] = i11 + i12;
            iArr4[i10] = i11 - i12;
        }
    }

    public static int e(int[] iArr, int[] iArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 10; i11++) {
            i10 |= iArr[i11] ^ iArr2[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean f(int[] iArr, int[] iArr2) {
        return e(iArr, iArr2) != 0;
    }

    public static void g(int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = iArr[4];
        int i15 = iArr[5];
        int i16 = iArr[6];
        int i17 = iArr[7];
        int i18 = iArr[8];
        int i19 = iArr[9];
        int i20 = i12 + (i11 >> 26);
        int i21 = i11 & f42627d;
        int i22 = i14 + (i13 >> 26);
        int i23 = i13 & f42627d;
        int i24 = i17 + (i16 >> 26);
        int i25 = i16 & f42627d;
        int i26 = i19 + (i18 >> 26);
        int i27 = i18 & f42627d;
        int i28 = i23 + (i20 >> 25);
        int i29 = i20 & f42626c;
        int i30 = i15 + (i22 >> 25);
        int i31 = i22 & f42626c;
        int i32 = i27 + (i24 >> 25);
        int i33 = i24 & f42626c;
        int i34 = i10 + ((i26 >> 25) * 38);
        int i35 = i26 & f42626c;
        int i36 = i21 + (i34 >> 26);
        int i37 = i34 & f42627d;
        int i38 = i25 + (i30 >> 26);
        int i39 = i30 & f42627d;
        int i40 = i29 + (i36 >> 26);
        int i41 = i36 & f42627d;
        int i42 = i31 + (i28 >> 26);
        int i43 = i28 & f42627d;
        int i44 = i33 + (i38 >> 26);
        int i45 = i38 & f42627d;
        int i46 = i35 + (i32 >> 26);
        int i47 = i32 & f42627d;
        iArr[0] = i37;
        iArr[1] = i41;
        iArr[2] = i40;
        iArr[3] = i43;
        iArr[4] = i42;
        iArr[5] = i39;
        iArr[6] = i45;
        iArr[7] = i44;
        iArr[8] = i47;
        iArr[9] = i46;
    }

    public static void h(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 10; i13++) {
            int i14 = i12 + i13;
            int i15 = iArr2[i14];
            iArr2[i14] = i15 ^ ((iArr[i11 + i13] ^ i15) & i10);
        }
    }

    public static void i(int i10, int[] iArr) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 10; i12++) {
            iArr[i12] = (iArr[i12] ^ i11) - i11;
        }
    }

    public static void j(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < 10; i12++) {
            iArr2[i11 + i12] = iArr[i10 + i12];
        }
    }

    public static int[] k() {
        return new int[10];
    }

    public static int[] l(int i10) {
        return new int[i10 * 10];
    }

    public static void m(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 10; i12++) {
            int i13 = iArr[i12];
            int i14 = iArr2[i12];
            int i15 = (i13 ^ i14) & i11;
            iArr[i12] = i13 ^ i15;
            iArr2[i12] = i14 ^ i15;
        }
    }

    public static void n(byte[] bArr, int i10, int[] iArr) {
        p(bArr, i10, iArr, 0);
        p(bArr, i10 + 16, iArr, 5);
        iArr[9] = iArr[9] & 16777215;
    }

    public static void o(int[] iArr, int i10, int[] iArr2) {
        q(iArr, i10, iArr2, 0);
        q(iArr, i10 + 4, iArr2, 5);
        iArr2[9] = iArr2[9] & 16777215;
    }

    public static void p(byte[] bArr, int i10, int[] iArr, int i11) {
        int iR = r(bArr, i10 + 0);
        int iR2 = r(bArr, i10 + 4);
        int iR3 = r(bArr, i10 + 8);
        int iR4 = r(bArr, i10 + 12);
        iArr[i11 + 0] = iR & f42627d;
        iArr[i11 + 1] = ((iR >>> 26) | (iR2 << 6)) & f42627d;
        iArr[i11 + 2] = ((iR3 << 12) | (iR2 >>> 20)) & f42626c;
        iArr[i11 + 3] = ((iR4 << 19) | (iR3 >>> 13)) & f42627d;
        iArr[i11 + 4] = iR4 >>> 7;
    }

    public static void q(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        iArr2[i11 + 0] = i12 & f42627d;
        iArr2[i11 + 1] = ((i12 >>> 26) | (i13 << 6)) & f42627d;
        iArr2[i11 + 2] = ((i14 << 12) | (i13 >>> 20)) & f42626c;
        iArr2[i11 + 3] = ((i15 << 19) | (i14 >>> 13)) & f42627d;
        iArr2[i11 + 4] = i15 >>> 7;
    }

    public static int r(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void s(int[] iArr, byte[] bArr, int i10) {
        u(iArr, 0, bArr, i10);
        u(iArr, 5, bArr, i10 + 16);
    }

    public static void t(int[] iArr, int[] iArr2, int i10) {
        v(iArr, 0, iArr2, i10);
        v(iArr, 5, iArr2, i10 + 4);
    }

    public static void u(int[] iArr, int i10, byte[] bArr, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        w((i13 << 26) | i12, bArr, i11 + 0);
        w((i13 >>> 6) | (i14 << 20), bArr, i11 + 4);
        w((i14 >>> 12) | (i15 << 13), bArr, i11 + 8);
        w((i16 << 7) | (i15 >>> 19), bArr, i11 + 12);
    }

    public static void v(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        iArr2[i11 + 0] = i12 | (i13 << 26);
        iArr2[i11 + 1] = (i13 >>> 6) | (i14 << 20);
        iArr2[i11 + 2] = (i14 >>> 12) | (i15 << 13);
        iArr2[i11 + 3] = (i16 << 7) | (i15 >>> 19);
    }

    public static void w(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void x(int[] iArr, int[] iArr2) {
        int[] iArrK = k();
        int[] iArr3 = new int[8];
        j(iArr, 0, iArrK, 0);
        G(iArrK);
        t(iArrK, iArr3, 0);
        rr.c.l(f42628e, iArr3, iArr3);
        o(iArr3, 0, iArr2);
    }

    public static void y(int[] iArr, int[] iArr2) {
        int[] iArrK = k();
        int[] iArr3 = new int[8];
        j(iArr, 0, iArrK, 0);
        G(iArrK);
        t(iArrK, iArr3, 0);
        rr.c.m(f42628e, iArr3, iArr3);
        o(iArr3, 0, iArr2);
    }

    public static int z(int[] iArr) {
        int i10 = iArr[0] ^ 1;
        for (int i11 = 1; i11 < 10; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }
}
