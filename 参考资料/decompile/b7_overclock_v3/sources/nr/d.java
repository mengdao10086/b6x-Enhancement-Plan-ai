package nr;

/* JADX INFO: loaded from: classes6.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42635a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42636b = 268435455;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f42637c = 4294967295L;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f42638d = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    public static int A(int[] iArr) {
        int i10 = iArr[0] ^ 1;
        for (int i11 = 1; i11 < 16; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean B(int[] iArr) {
        return A(iArr) != 0;
    }

    public static int C(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            i10 |= iArr[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean D(int[] iArr) {
        return C(iArr) != 0;
    }

    public static void E(int[] iArr, int i10, int[] iArr2) {
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
        int i21 = iArr[10];
        int i22 = iArr[11];
        int i23 = iArr[12];
        int i24 = iArr[13];
        int i25 = iArr[14];
        int i26 = iArr[15];
        long j10 = i12;
        long j11 = i10;
        long j12 = j10 * j11;
        int i27 = ((int) j12) & f42636b;
        long j13 = ((long) i16) * j11;
        int i28 = ((int) j13) & f42636b;
        long j14 = ((long) i20) * j11;
        int i29 = ((int) j14) & f42636b;
        long j15 = ((long) i24) * j11;
        int i30 = ((int) j15) & f42636b;
        long j16 = (j12 >>> 28) + (((long) i13) * j11);
        iArr2[2] = ((int) j16) & f42636b;
        long j17 = (j13 >>> 28) + (((long) i17) * j11);
        iArr2[6] = ((int) j17) & f42636b;
        long j18 = (j14 >>> 28) + (((long) i21) * j11);
        iArr2[10] = ((int) j18) & f42636b;
        long j19 = (j15 >>> 28) + (((long) i25) * j11);
        iArr2[14] = ((int) j19) & f42636b;
        long j20 = (j16 >>> 28) + (((long) i14) * j11);
        iArr2[3] = ((int) j20) & f42636b;
        long j21 = (j17 >>> 28) + (((long) i18) * j11);
        iArr2[7] = ((int) j21) & f42636b;
        long j22 = (j18 >>> 28) + (((long) i22) * j11);
        iArr2[11] = ((int) j22) & f42636b;
        long j23 = (j19 >>> 28) + (((long) i26) * j11);
        iArr2[15] = ((int) j23) & f42636b;
        long j24 = j23 >>> 28;
        long j25 = (j20 >>> 28) + (((long) i15) * j11);
        iArr2[4] = ((int) j25) & f42636b;
        long j26 = (j21 >>> 28) + j24 + (((long) i19) * j11);
        iArr2[8] = ((int) j26) & f42636b;
        long j27 = (j22 >>> 28) + (((long) i23) * j11);
        iArr2[12] = ((int) j27) & f42636b;
        long j28 = j24 + (((long) i11) * j11);
        iArr2[0] = ((int) j28) & f42636b;
        iArr2[1] = i27 + ((int) (j28 >>> 28));
        iArr2[5] = i28 + ((int) (j25 >>> 28));
        iArr2[9] = i29 + ((int) (j26 >>> 28));
        iArr2[13] = i30 + ((int) (j27 >>> 28));
    }

    public static void F(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = iArr2[0];
        int i27 = iArr2[1];
        int i28 = iArr2[2];
        int i29 = iArr2[3];
        int i30 = iArr2[4];
        int i31 = iArr2[5];
        int i32 = iArr2[6];
        int i33 = iArr2[7];
        int i34 = iArr2[8];
        int i35 = iArr2[9];
        int i36 = iArr2[10];
        int i37 = iArr2[11];
        int i38 = iArr2[12];
        int i39 = iArr2[13];
        int i40 = iArr2[14];
        int i41 = iArr2[15];
        int i42 = i10 + i18;
        int i43 = i12 + i20;
        int i44 = i13 + i21;
        int i45 = i14 + i22;
        int i46 = i15 + i23;
        int i47 = i16 + i24;
        int i48 = i26 + i34;
        int i49 = i27 + i35;
        int i50 = i28 + i36;
        int i51 = i29 + i37;
        int i52 = i30 + i38;
        int i53 = i31 + i39;
        int i54 = i32 + i40;
        int i55 = i33 + i41;
        long j10 = i10;
        long j11 = i26;
        long j12 = j10 * j11;
        long j13 = i17;
        long j14 = i27;
        long j15 = j13 * j14;
        long j16 = i16;
        long j17 = i28;
        long j18 = j15 + (j16 * j17);
        long j19 = i15;
        long j20 = i29;
        long j21 = j18 + (j19 * j20);
        long j22 = i14;
        long j23 = i30;
        long j24 = j21 + (j22 * j23);
        long j25 = i13;
        long j26 = i31;
        long j27 = j24 + (j25 * j26);
        long j28 = i12;
        long j29 = i32;
        long j30 = j27 + (j28 * j29);
        long j31 = i11;
        long j32 = i33;
        long j33 = j30 + (j31 * j32);
        long j34 = i18;
        long j35 = i34;
        long j36 = j34 * j35;
        long j37 = i25;
        long j38 = i35;
        long j39 = j37 * j38;
        long j40 = i24;
        long j41 = i36;
        long j42 = j39 + (j40 * j41);
        long j43 = i23;
        long j44 = i37;
        long j45 = j42 + (j43 * j44);
        long j46 = i22;
        long j47 = i38;
        long j48 = j45 + (j46 * j47);
        long j49 = i21;
        long j50 = i39;
        long j51 = j48 + (j49 * j50);
        long j52 = i20;
        long j53 = i40;
        long j54 = j51 + (j52 * j53);
        long j55 = i19;
        long j56 = i41;
        long j57 = j54 + (j55 * j56);
        long j58 = i42;
        long j59 = i48;
        long j60 = j58 * j59;
        long j61 = i17 + i25;
        long j62 = i49;
        long j63 = j61 * j62;
        long j64 = i47;
        long j65 = i50;
        long j66 = j63 + (j64 * j65);
        long j67 = i46;
        long j68 = i51;
        long j69 = j66 + (j67 * j68);
        long j70 = i45;
        long j71 = i52;
        long j72 = j69 + (j70 * j71);
        long j73 = i44;
        long j74 = i53;
        long j75 = j72 + (j73 * j74);
        long j76 = i43;
        long j77 = i54;
        long j78 = j75 + (j76 * j77);
        long j79 = i11 + i19;
        long j80 = i55;
        long j81 = j78 + (j79 * j80);
        long j82 = ((j12 + j36) + j81) - j33;
        int i56 = ((int) j82) & f42636b;
        long j83 = j82 >>> 28;
        long j84 = ((j57 + j60) - j12) + j81;
        int i57 = ((int) j84) & f42636b;
        long j85 = (j31 * j11) + (j10 * j14);
        long j86 = (j37 * j41) + (j40 * j44) + (j43 * j47) + (j46 * j50) + (j49 * j53) + (j52 * j56);
        long j87 = (j79 * j59) + (j58 * j62);
        long j88 = (j61 * j65) + (j64 * j68) + (j67 * j71) + (j70 * j74) + (j73 * j77) + (j76 * j80);
        long j89 = j83 + (((j85 + ((j55 * j35) + (j34 * j38))) + j88) - ((((((j13 * j17) + (j16 * j20)) + (j19 * j23)) + (j22 * j26)) + (j25 * j29)) + (j28 * j32)));
        int i58 = ((int) j89) & f42636b;
        long j90 = (j84 >>> 28) + ((j86 + j87) - j85) + j88;
        int i59 = ((int) j90) & f42636b;
        long j91 = (j28 * j11) + (j31 * j14) + (j10 * j17);
        long j92 = (j37 * j44) + (j40 * j47) + (j43 * j50) + (j46 * j53) + (j49 * j56);
        long j93 = (j76 * j59) + (j79 * j62) + (j58 * j65);
        long j94 = (j61 * j68) + (j64 * j71) + (j67 * j74) + (j70 * j77) + (j73 * j80);
        long j95 = (j89 >>> 28) + (((j91 + (((j52 * j35) + (j55 * j38)) + (j34 * j41))) + j94) - (((((j13 * j20) + (j16 * j23)) + (j19 * j26)) + (j22 * j29)) + (j25 * j32)));
        int i60 = ((int) j95) & f42636b;
        long j96 = (j90 >>> 28) + ((j92 + j93) - j91) + j94;
        int i61 = ((int) j96) & f42636b;
        long j97 = (j25 * j11) + (j28 * j14) + (j31 * j17) + (j10 * j20);
        long j98 = (j37 * j47) + (j40 * j50) + (j43 * j53) + (j46 * j56);
        long j99 = (j73 * j59) + (j76 * j62) + (j79 * j65) + (j58 * j68);
        long j100 = (j61 * j71) + (j64 * j74) + (j67 * j77) + (j70 * j80);
        long j101 = (j95 >>> 28) + (((j97 + ((((j49 * j35) + (j52 * j38)) + (j55 * j41)) + (j34 * j44))) + j100) - ((((j13 * j23) + (j16 * j26)) + (j19 * j29)) + (j22 * j32)));
        int i62 = ((int) j101) & f42636b;
        long j102 = (j96 >>> 28) + ((j98 + j99) - j97) + j100;
        int i63 = ((int) j102) & f42636b;
        long j103 = (j22 * j11) + (j25 * j14) + (j28 * j17) + (j31 * j20) + (j10 * j23);
        long j104 = (j37 * j50) + (j40 * j53) + (j43 * j56);
        long j105 = (j70 * j59) + (j73 * j62) + (j76 * j65) + (j79 * j68) + (j58 * j71);
        long j106 = (j61 * j74) + (j64 * j77) + (j67 * j80);
        long j107 = (j101 >>> 28) + (((j103 + (((((j46 * j35) + (j49 * j38)) + (j52 * j41)) + (j55 * j44)) + (j34 * j47))) + j106) - (((j13 * j26) + (j16 * j29)) + (j19 * j32)));
        int i64 = ((int) j107) & f42636b;
        long j108 = (j102 >>> 28) + ((j104 + j105) - j103) + j106;
        int i65 = ((int) j108) & f42636b;
        long j109 = (j19 * j11) + (j22 * j14) + (j25 * j17) + (j28 * j20) + (j31 * j23) + (j10 * j26);
        long j110 = (j37 * j53) + (j40 * j56);
        long j111 = (j67 * j59) + (j70 * j62) + (j73 * j65) + (j76 * j68) + (j79 * j71) + (j58 * j74);
        long j112 = (j61 * j77) + (j64 * j80);
        long j113 = (j107 >>> 28) + (((j109 + ((((((j43 * j35) + (j46 * j38)) + (j49 * j41)) + (j52 * j44)) + (j55 * j47)) + (j34 * j50))) + j112) - ((j13 * j29) + (j16 * j32)));
        int i66 = ((int) j113) & f42636b;
        long j114 = (j108 >>> 28) + ((j110 + j111) - j109) + j112;
        int i67 = ((int) j114) & f42636b;
        long j115 = (j16 * j11) + (j19 * j14) + (j22 * j17) + (j25 * j20) + (j28 * j23) + (j31 * j26) + (j10 * j29);
        long j116 = j37 * j56;
        long j117 = (j64 * j59) + (j67 * j62) + (j70 * j65) + (j73 * j68) + (j76 * j71) + (j79 * j74) + (j58 * j77);
        long j118 = j61 * j80;
        long j119 = (j113 >>> 28) + (((j115 + (((((((j40 * j35) + (j43 * j38)) + (j46 * j41)) + (j49 * j44)) + (j52 * j47)) + (j55 * j50)) + (j34 * j53))) + j118) - (j13 * j32));
        int i68 = ((int) j119) & f42636b;
        long j120 = (j114 >>> 28) + ((j116 + j117) - j115) + j118;
        int i69 = ((int) j120) & f42636b;
        long j121 = (j11 * j13) + (j14 * j16) + (j19 * j17) + (j22 * j20) + (j25 * j23) + (j28 * j26) + (j31 * j29) + (j10 * j32);
        long j122 = (j37 * j35) + (j38 * j40) + (j43 * j41) + (j46 * j44) + (j49 * j47) + (j52 * j50) + (j55 * j53) + (j34 * j56);
        long j123 = (j61 * j59) + (j64 * j62) + (j67 * j65) + (j70 * j68) + (j73 * j71) + (j76 * j74) + (j79 * j77) + (j58 * j80);
        long j124 = (j119 >>> 28) + j121 + j122;
        int i70 = ((int) j124) & f42636b;
        long j125 = (j120 >>> 28) + (j123 - j121);
        int i71 = ((int) j125) & f42636b;
        long j126 = j125 >>> 28;
        long j127 = (j124 >>> 28) + j126 + ((long) i57);
        int i72 = ((int) j127) & f42636b;
        long j128 = j126 + ((long) i56);
        iArr3[0] = ((int) j128) & f42636b;
        iArr3[1] = i58 + ((int) (j128 >>> 28));
        iArr3[2] = i60;
        iArr3[3] = i62;
        iArr3[4] = i64;
        iArr3[5] = i66;
        iArr3[6] = i68;
        iArr3[7] = i70;
        iArr3[8] = i72;
        iArr3[9] = i59 + ((int) (j127 >>> 28));
        iArr3[10] = i61;
        iArr3[11] = i63;
        iArr3[12] = i65;
        iArr3[13] = i67;
        iArr3[14] = i69;
        iArr3[15] = i71;
    }

    public static void G(int[] iArr, int[] iArr2) {
        O(j(), iArr, iArr2);
    }

    public static void H(int[] iArr) {
        K(iArr, 1);
        K(iArr, -1);
    }

    public static void I(int[] iArr) {
        iArr[0] = 1;
        for (int i10 = 1; i10 < 16; i10++) {
            iArr[i10] = 0;
        }
    }

    public static void J(int[] iArr, int[] iArr2) {
        int[] iArrJ = j();
        M(iArr, iArrJ);
        F(iArr, iArrJ, iArrJ);
        int[] iArrJ2 = j();
        M(iArrJ, iArrJ2);
        F(iArr, iArrJ2, iArrJ2);
        int[] iArrJ3 = j();
        L(iArrJ2, 3, iArrJ3);
        F(iArrJ2, iArrJ3, iArrJ3);
        int[] iArrJ4 = j();
        L(iArrJ3, 3, iArrJ4);
        F(iArrJ2, iArrJ4, iArrJ4);
        int[] iArrJ5 = j();
        L(iArrJ4, 9, iArrJ5);
        F(iArrJ4, iArrJ5, iArrJ5);
        int[] iArrJ6 = j();
        M(iArrJ5, iArrJ6);
        F(iArr, iArrJ6, iArrJ6);
        int[] iArrJ7 = j();
        L(iArrJ6, 18, iArrJ7);
        F(iArrJ5, iArrJ7, iArrJ7);
        int[] iArrJ8 = j();
        L(iArrJ7, 37, iArrJ8);
        F(iArrJ7, iArrJ8, iArrJ8);
        int[] iArrJ9 = j();
        L(iArrJ8, 37, iArrJ9);
        F(iArrJ7, iArrJ9, iArrJ9);
        int[] iArrJ10 = j();
        L(iArrJ9, 111, iArrJ10);
        F(iArrJ9, iArrJ10, iArrJ10);
        int[] iArrJ11 = j();
        M(iArrJ10, iArrJ11);
        F(iArr, iArrJ11, iArrJ11);
        int[] iArrJ12 = j();
        L(iArrJ11, 223, iArrJ12);
        F(iArrJ12, iArrJ10, iArr2);
    }

    public static void K(int[] iArr, int i10) {
        int i11;
        int i12 = iArr[15];
        int i13 = i12 & f42636b;
        long j10 = (i12 >>> 28) + i10;
        int i14 = 0;
        long j11 = j10;
        while (true) {
            if (i14 >= 8) {
                break;
            }
            long j12 = j11 + (4294967295L & ((long) iArr[i14]));
            iArr[i14] = ((int) j12) & f42636b;
            j11 = j12 >> 28;
            i14++;
        }
        long j13 = j11 + j10;
        for (i11 = 8; i11 < 15; i11++) {
            long j14 = j13 + (((long) iArr[i11]) & 4294967295L);
            iArr[i11] = ((int) j14) & f42636b;
            j13 = j14 >> 28;
        }
        iArr[15] = i13 + ((int) j13);
    }

    public static void L(int[] iArr, int i10, int[] iArr2) {
        M(iArr, iArr2);
        while (true) {
            i10--;
            if (i10 <= 0) {
                return;
            } else {
                M(iArr2, iArr2);
            }
        }
    }

    public static void M(int[] iArr, int[] iArr2) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = i10 * 2;
        int i27 = i11 * 2;
        int i28 = i12 * 2;
        int i29 = i13 * 2;
        int i30 = i14 * 2;
        int i31 = i15 * 2;
        int i32 = i16 * 2;
        int i33 = i18 * 2;
        int i34 = i19 * 2;
        int i35 = i20 * 2;
        int i36 = i21 * 2;
        int i37 = i22 * 2;
        int i38 = i23 * 2;
        int i39 = i24 * 2;
        int i40 = i10 + i18;
        int i41 = i11 + i19;
        int i42 = i12 + i20;
        int i43 = i13 + i21;
        int i44 = i14 + i22;
        int i45 = i15 + i23;
        int i46 = i16 + i24;
        int i47 = i17 + i25;
        int i48 = i40 * 2;
        int i49 = i41 * 2;
        int i50 = i42 * 2;
        int i51 = i43 * 2;
        int i52 = i45 * 2;
        long j10 = i10;
        long j11 = j10 * j10;
        long j12 = i17;
        long j13 = i27;
        long j14 = j12 * j13;
        long j15 = i16;
        long j16 = i28;
        long j17 = j14 + (j15 * j16);
        long j18 = i15;
        long j19 = i29;
        long j20 = i14;
        long j21 = j17 + (j18 * j19) + (j20 * j20);
        long j22 = i18;
        long j23 = i25;
        long j24 = i34;
        long j25 = j23 * j24;
        long j26 = i24;
        long j27 = i35;
        long j28 = j25 + (j26 * j27);
        long j29 = i23;
        long j30 = i36;
        long j31 = j28 + (j29 * j30);
        long j32 = i22;
        long j33 = i40;
        long j34 = i47;
        long j35 = ((long) i49) & 4294967295L;
        long j36 = j34 * j35;
        long j37 = i46;
        long j38 = ((long) i50) & 4294967295L;
        long j39 = j36 + (j37 * j38);
        long j40 = i45;
        long j41 = ((long) i51) & 4294967295L;
        long j42 = j39 + (j40 * j41);
        long j43 = i44;
        long j44 = j42 + (j43 * j43);
        long j45 = ((j11 + (j22 * j22)) + j44) - j21;
        int i53 = ((int) j45) & f42636b;
        long j46 = (((j31 + (j32 * j32)) + (j33 * j33)) - j11) + j44;
        int i54 = ((int) j46) & f42636b;
        long j47 = j46 >>> 28;
        long j48 = i11;
        long j49 = i26;
        long j50 = j48 * j49;
        long j51 = i30;
        long j52 = (j12 * j16) + (j15 * j19) + (j18 * j51);
        long j53 = i19;
        long j54 = i33;
        long j55 = j53 * j54;
        long j56 = (j23 * j27) + (j26 * j30);
        long j57 = i37;
        long j58 = j56 + (j29 * j57);
        long j59 = i41;
        long j60 = ((long) i48) & 4294967295L;
        long j61 = (j34 * j38) + (j37 * j41);
        long j62 = ((long) (i44 * 2)) & 4294967295L;
        long j63 = j61 + (j40 * j62);
        long j64 = (j45 >>> 28) + (((j50 + j55) + j63) - j52);
        int i55 = ((int) j64) & f42636b;
        long j65 = j47 + ((j58 + (j59 * j60)) - j50) + j63;
        int i56 = ((int) j65) & f42636b;
        long j66 = j65 >>> 28;
        long j67 = i12;
        long j68 = (j67 * j49) + (j48 * j48);
        long j69 = (j12 * j19) + (j15 * j51) + (j18 * j18);
        long j70 = i20;
        long j71 = (j70 * j54) + (j53 * j53);
        long j72 = (j23 * j30) + (j26 * j57) + (j29 * j29);
        long j73 = i42;
        long j74 = (j73 * j60) + (j59 * j59);
        long j75 = (j34 * j41) + (j37 * j62) + (j40 * j40);
        long j76 = (j64 >>> 28) + (((j68 + j71) + j75) - j69);
        int i57 = ((int) j76) & f42636b;
        long j77 = j66 + ((j72 + j74) - j68) + j75;
        int i58 = ((int) j77) & f42636b;
        long j78 = i13;
        long j79 = (j78 * j49) + (j67 * j13);
        long j80 = i31;
        long j81 = (j12 * j51) + (j15 * j80);
        long j82 = i21;
        long j83 = (j82 * j54) + (j70 * j24);
        long j84 = i38;
        long j85 = (j23 * j57) + (j26 * j84);
        long j86 = i43;
        long j87 = (j86 * j60) + (j73 * j35);
        long j88 = j62 * j34;
        long j89 = ((long) i52) & 4294967295L;
        long j90 = j88 + (j37 * j89);
        long j91 = (j76 >>> 28) + (((j79 + j83) + j90) - j81);
        int i59 = ((int) j91) & f42636b;
        long j92 = (j77 >>> 28) + ((j85 + j87) - j79) + j90;
        int i60 = ((int) j92) & f42636b;
        long j93 = (j20 * j49) + (j78 * j13) + (j67 * j67);
        long j94 = (j32 * j54) + (j82 * j24) + (j70 * j70);
        long j95 = (j43 * j60) + (j86 * j35) + (j73 * j73);
        long j96 = (j34 * j89) + (j37 * j37);
        long j97 = (j91 >>> 28) + (((j93 + j94) + j96) - ((j12 * j80) + (j15 * j15)));
        int i61 = ((int) j97) & f42636b;
        long j98 = (j92 >>> 28) + ((((j23 * j84) + (j26 * j26)) + j95) - j93) + j96;
        int i62 = ((int) j98) & f42636b;
        long j99 = (j18 * j49) + (j20 * j13) + (j78 * j16);
        long j100 = (j29 * j54) + (j32 * j24) + (j82 * j27);
        long j101 = (j40 * j60) + (j43 * j35) + (j86 * j38);
        long j102 = (((long) (i46 * 2)) & 4294967295L) * j34;
        long j103 = (j97 >>> 28) + (((j99 + j100) + j102) - (((long) i32) * j12));
        int i63 = ((int) j103) & f42636b;
        long j104 = (j98 >>> 28) + (((((long) i39) * j23) + j101) - j99) + j102;
        int i64 = ((int) j104) & f42636b;
        long j105 = (j15 * j49) + (j18 * j13) + (j20 * j16) + (j78 * j78);
        long j106 = j34 * j34;
        long j107 = (j103 >>> 28) + (((j105 + ((((j26 * j54) + (j29 * j24)) + (j32 * j27)) + (j82 * j82))) + j106) - (j12 * j12));
        int i65 = ((int) j107) & f42636b;
        long j108 = (j104 >>> 28) + (((j23 * j23) + ((((j37 * j60) + (j40 * j35)) + (j43 * j38)) + (j86 * j86))) - j105) + j106;
        int i66 = ((int) j108) & f42636b;
        long j109 = (j12 * j49) + (j15 * j13) + (j18 * j16) + (j20 * j19);
        long j110 = (j107 >>> 28) + (j54 * j23) + (j26 * j24) + (j29 * j27) + (j32 * j30) + j109;
        int i67 = ((int) j110) & f42636b;
        long j111 = (j108 >>> 28) + (((((j60 * j34) + (j37 * j35)) + (j40 * j38)) + (j43 * j41)) - j109);
        int i68 = ((int) j111) & f42636b;
        long j112 = j111 >>> 28;
        long j113 = (j110 >>> 28) + j112 + ((long) i54);
        int i69 = ((int) j113) & f42636b;
        long j114 = j112 + ((long) i53);
        iArr2[0] = ((int) j114) & f42636b;
        iArr2[1] = i55 + ((int) (j114 >>> 28));
        iArr2[2] = i57;
        iArr2[3] = i59;
        iArr2[4] = i61;
        iArr2[5] = i63;
        iArr2[6] = i65;
        iArr2[7] = i67;
        iArr2[8] = i69;
        iArr2[9] = i56 + ((int) (j113 >>> 28));
        iArr2[10] = i58;
        iArr2[11] = i60;
        iArr2[12] = i62;
        iArr2[13] = i64;
        iArr2[14] = i66;
        iArr2[15] = i68;
    }

    public static boolean N(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrJ = j();
        int[] iArrJ2 = j();
        M(iArr, iArrJ);
        F(iArrJ, iArr2, iArrJ);
        M(iArrJ, iArrJ2);
        F(iArrJ, iArr, iArrJ);
        F(iArrJ2, iArr, iArrJ2);
        F(iArrJ2, iArr2, iArrJ2);
        int[] iArrJ3 = j();
        J(iArrJ2, iArrJ3);
        F(iArrJ3, iArrJ, iArrJ3);
        int[] iArrJ4 = j();
        M(iArrJ3, iArrJ4);
        F(iArrJ4, iArr2, iArrJ4);
        O(iArr, iArrJ4, iArrJ4);
        H(iArrJ4);
        if (!D(iArrJ4)) {
            return false;
        }
        i(iArrJ3, 0, iArr3, 0);
        return true;
    }

    public static void O(int[] iArr, int[] iArr2, int[] iArr3) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = iArr2[0];
        int i27 = iArr2[1];
        int i28 = iArr2[2];
        int i29 = iArr2[3];
        int i30 = iArr2[4];
        int i31 = iArr2[5];
        int i32 = iArr2[6];
        int i33 = iArr2[7];
        int i34 = iArr2[8];
        int i35 = iArr2[9];
        int i36 = iArr2[10];
        int i37 = iArr2[11];
        int i38 = iArr2[12];
        int i39 = iArr2[13];
        int i40 = iArr2[14];
        int i41 = (i11 + 536870910) - i27;
        int i42 = (i15 + 536870910) - i31;
        int i43 = (i19 + 536870910) - i35;
        int i44 = (i23 + 536870910) - i39;
        int i45 = (i25 + 536870910) - iArr2[15];
        int i46 = ((i12 + 536870910) - i28) + (i41 >>> 28);
        int i47 = i41 & f42636b;
        int i48 = ((i16 + 536870910) - i32) + (i42 >>> 28);
        int i49 = i42 & f42636b;
        int i50 = ((i20 + 536870910) - i36) + (i43 >>> 28);
        int i51 = i43 & f42636b;
        int i52 = ((i24 + 536870910) - i40) + (i44 >>> 28);
        int i53 = i44 & f42636b;
        int i54 = ((i13 + 536870910) - i29) + (i46 >>> 28);
        int i55 = i46 & f42636b;
        int i56 = ((i17 + 536870910) - i33) + (i48 >>> 28);
        int i57 = i48 & f42636b;
        int i58 = ((i21 + 536870910) - i37) + (i50 >>> 28);
        int i59 = i50 & f42636b;
        int i60 = i45 + (i52 >>> 28);
        int i61 = i52 & f42636b;
        int i62 = i60 >>> 28;
        int i63 = i60 & f42636b;
        int i64 = ((i10 + 536870910) - i26) + i62;
        int i65 = ((i14 + 536870910) - i30) + (i54 >>> 28);
        int i66 = i54 & f42636b;
        int i67 = ((i18 + 536870908) - i34) + i62 + (i56 >>> 28);
        int i68 = i56 & f42636b;
        int i69 = ((i22 + 536870910) - i38) + (i58 >>> 28);
        int i70 = i58 & f42636b;
        int i71 = i47 + (i64 >>> 28);
        int i72 = i64 & f42636b;
        int i73 = i49 + (i65 >>> 28);
        int i74 = i65 & f42636b;
        int i75 = i51 + (i67 >>> 28);
        int i76 = i67 & f42636b;
        int i77 = i53 + (i69 >>> 28);
        int i78 = i69 & f42636b;
        iArr3[0] = i72;
        iArr3[1] = i71;
        iArr3[2] = i55;
        iArr3[3] = i66;
        iArr3[4] = i74;
        iArr3[5] = i73;
        iArr3[6] = i57;
        iArr3[7] = i68;
        iArr3[8] = i76;
        iArr3[9] = i75;
        iArr3[10] = i59;
        iArr3[11] = i70;
        iArr3[12] = i78;
        iArr3[13] = i77;
        iArr3[14] = i61;
        iArr3[15] = i63;
    }

    public static void P(int[] iArr) {
        int[] iArrJ = j();
        iArrJ[0] = 1;
        O(iArr, iArrJ, iArr);
    }

    public static void Q(int[] iArr) {
        for (int i10 = 0; i10 < 16; i10++) {
            iArr[i10] = 0;
        }
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3) {
        for (int i10 = 0; i10 < 16; i10++) {
            iArr3[i10] = iArr[i10] + iArr2[i10];
        }
    }

    public static void b(int[] iArr) {
        iArr[0] = iArr[0] + 1;
    }

    public static void c(int[] iArr, int i10) {
        iArr[i10] = iArr[i10] + 1;
    }

    public static int d(int[] iArr, int[] iArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            i10 |= iArr[i11] ^ iArr2[i11];
        }
        return (((i10 >>> 1) | (i10 & 1)) - 1) >> 31;
    }

    public static boolean e(int[] iArr, int[] iArr2) {
        return d(iArr, iArr2) != 0;
    }

    public static void f(int[] iArr) {
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
        int i20 = iArr[10];
        int i21 = iArr[11];
        int i22 = iArr[12];
        int i23 = iArr[13];
        int i24 = iArr[14];
        int i25 = iArr[15];
        int i26 = i11 + (i10 >>> 28);
        int i27 = i10 & f42636b;
        int i28 = i15 + (i14 >>> 28);
        int i29 = i14 & f42636b;
        int i30 = i19 + (i18 >>> 28);
        int i31 = i18 & f42636b;
        int i32 = i23 + (i22 >>> 28);
        int i33 = i22 & f42636b;
        int i34 = i12 + (i26 >>> 28);
        int i35 = i26 & f42636b;
        int i36 = i16 + (i28 >>> 28);
        int i37 = i28 & f42636b;
        int i38 = i20 + (i30 >>> 28);
        int i39 = i30 & f42636b;
        int i40 = i24 + (i32 >>> 28);
        int i41 = i32 & f42636b;
        int i42 = i13 + (i34 >>> 28);
        int i43 = i34 & f42636b;
        int i44 = i17 + (i36 >>> 28);
        int i45 = i36 & f42636b;
        int i46 = i21 + (i38 >>> 28);
        int i47 = i38 & f42636b;
        int i48 = i25 + (i40 >>> 28);
        int i49 = i40 & f42636b;
        int i50 = i48 >>> 28;
        int i51 = i48 & f42636b;
        int i52 = i27 + i50;
        int i53 = i29 + (i42 >>> 28);
        int i54 = i42 & f42636b;
        int i55 = i31 + i50 + (i44 >>> 28);
        int i56 = i44 & f42636b;
        int i57 = i33 + (i46 >>> 28);
        int i58 = i46 & f42636b;
        int i59 = i35 + (i52 >>> 28);
        int i60 = i52 & f42636b;
        int i61 = i37 + (i53 >>> 28);
        int i62 = i53 & f42636b;
        int i63 = i39 + (i55 >>> 28);
        int i64 = i55 & f42636b;
        int i65 = i41 + (i57 >>> 28);
        int i66 = i57 & f42636b;
        iArr[0] = i60;
        iArr[1] = i59;
        iArr[2] = i43;
        iArr[3] = i54;
        iArr[4] = i62;
        iArr[5] = i61;
        iArr[6] = i45;
        iArr[7] = i56;
        iArr[8] = i64;
        iArr[9] = i63;
        iArr[10] = i47;
        iArr[11] = i58;
        iArr[12] = i66;
        iArr[13] = i65;
        iArr[14] = i49;
        iArr[15] = i51;
    }

    public static void g(int i10, int[] iArr, int i11, int[] iArr2, int i12) {
        for (int i13 = 0; i13 < 16; i13++) {
            int i14 = i12 + i13;
            int i15 = iArr2[i14];
            iArr2[i14] = i15 ^ ((iArr[i11 + i13] ^ i15) & i10);
        }
    }

    public static void h(int i10, int[] iArr) {
        int[] iArrJ = j();
        O(iArrJ, iArr, iArrJ);
        g(-i10, iArrJ, 0, iArr, 0);
    }

    public static void i(int[] iArr, int i10, int[] iArr2, int i11) {
        for (int i12 = 0; i12 < 16; i12++) {
            iArr2[i11 + i12] = iArr[i10 + i12];
        }
    }

    public static int[] j() {
        return new int[16];
    }

    public static int[] k(int i10) {
        return new int[i10 * 16];
    }

    public static void l(int i10, int[] iArr, int[] iArr2) {
        int i11 = 0 - i10;
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = iArr[i12];
            int i14 = iArr2[i12];
            int i15 = (i13 ^ i14) & i11;
            iArr[i12] = i13 ^ i15;
            iArr2[i12] = i14 ^ i15;
        }
    }

    public static void m(byte[] bArr, int i10, int[] iArr) {
        r(bArr, i10, iArr, 0);
        r(bArr, i10 + 7, iArr, 2);
        r(bArr, i10 + 14, iArr, 4);
        r(bArr, i10 + 21, iArr, 6);
        r(bArr, i10 + 28, iArr, 8);
        r(bArr, i10 + 35, iArr, 10);
        r(bArr, i10 + 42, iArr, 12);
        r(bArr, i10 + 49, iArr, 14);
    }

    public static void n(int[] iArr, int i10, int[] iArr2) {
        o(iArr, i10, iArr2, 0);
        o(iArr, i10 + 7, iArr2, 8);
    }

    public static void o(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        int i17 = iArr[i10 + 5];
        int i18 = iArr[i10 + 6];
        iArr2[i11 + 0] = i12 & f42636b;
        iArr2[i11 + 1] = ((i12 >>> 28) | (i13 << 4)) & f42636b;
        iArr2[i11 + 2] = ((i13 >>> 24) | (i14 << 8)) & f42636b;
        iArr2[i11 + 3] = ((i14 >>> 20) | (i15 << 12)) & f42636b;
        iArr2[i11 + 4] = ((i15 >>> 16) | (i16 << 16)) & f42636b;
        iArr2[i11 + 5] = ((i16 >>> 12) | (i17 << 20)) & f42636b;
        iArr2[i11 + 6] = ((i17 >>> 8) | (i18 << 24)) & f42636b;
        iArr2[i11 + 7] = i18 >>> 4;
    }

    public static int p(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        return ((bArr[i12 + 1] & 255) << 16) | i11 | ((bArr[i12] & 255) << 8);
    }

    public static int q(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void r(byte[] bArr, int i10, int[] iArr, int i11) {
        int iQ = q(bArr, i10);
        int iP = p(bArr, i10 + 4);
        iArr[i11] = 268435455 & iQ;
        iArr[i11 + 1] = (iP << 4) | (iQ >>> 28);
    }

    public static void s(int[] iArr, byte[] bArr, int i10) {
        x(iArr, 0, bArr, i10);
        x(iArr, 2, bArr, i10 + 7);
        x(iArr, 4, bArr, i10 + 14);
        x(iArr, 6, bArr, i10 + 21);
        x(iArr, 8, bArr, i10 + 28);
        x(iArr, 10, bArr, i10 + 35);
        x(iArr, 12, bArr, i10 + 42);
        x(iArr, 14, bArr, i10 + 49);
    }

    public static void t(int[] iArr, int[] iArr2, int i10) {
        u(iArr, 0, iArr2, i10);
        u(iArr, 8, iArr2, i10 + 7);
    }

    public static void u(int[] iArr, int i10, int[] iArr2, int i11) {
        int i12 = iArr[i10 + 0];
        int i13 = iArr[i10 + 1];
        int i14 = iArr[i10 + 2];
        int i15 = iArr[i10 + 3];
        int i16 = iArr[i10 + 4];
        int i17 = iArr[i10 + 5];
        int i18 = iArr[i10 + 6];
        int i19 = iArr[i10 + 7];
        iArr2[i11 + 0] = i12 | (i13 << 28);
        iArr2[i11 + 1] = (i13 >>> 4) | (i14 << 24);
        iArr2[i11 + 2] = (i14 >>> 8) | (i15 << 20);
        iArr2[i11 + 3] = (i15 >>> 12) | (i16 << 16);
        iArr2[i11 + 4] = (i16 >>> 16) | (i17 << 12);
        iArr2[i11 + 5] = (i17 >>> 20) | (i18 << 8);
        iArr2[i11 + 6] = (i19 << 4) | (i18 >>> 24);
    }

    public static void v(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i12 + 1] = (byte) (i10 >>> 16);
    }

    public static void w(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void x(int[] iArr, int i10, byte[] bArr, int i11) {
        int i12 = iArr[i10];
        int i13 = iArr[i10 + 1];
        w((i13 << 28) | i12, bArr, i11);
        v(i13 >>> 4, bArr, i11 + 4);
    }

    public static void y(int[] iArr, int[] iArr2) {
        int[] iArrJ = j();
        int[] iArr3 = new int[14];
        i(iArr, 0, iArrJ, 0);
        H(iArrJ);
        t(iArrJ, iArr3, 0);
        rr.c.l(f42638d, iArr3, iArr3);
        n(iArr3, 0, iArr2);
    }

    public static void z(int[] iArr, int[] iArr2) {
        int[] iArrJ = j();
        int[] iArr3 = new int[14];
        i(iArr, 0, iArrJ, 0);
        H(iArrJ);
        t(iArrJ, iArr3, 0);
        rr.c.m(f42638d, iArr3, iArr3);
        n(iArr3, 0, iArr2);
    }
}
