package cp;

import np.k2;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class l1 implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25447h = 256;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25448i = 512;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25449j = 1024;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25450k = 16;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25451l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25452m = 72;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25453n = 72;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25454o = 80;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f25455p = 80;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f25456q = 2004413935125273122L;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int[] f25457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int[] f25458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static int[] f25459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int[] f25460u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f25463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long[] f25464d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f25465e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f25466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f25467g;

    public static final class a extends d {
        public static final int A = 5;
        public static final int B = 20;
        public static final int C = 48;
        public static final int D = 41;
        public static final int E = 47;
        public static final int F = 28;
        public static final int G = 16;
        public static final int H = 25;
        public static final int I = 41;
        public static final int J = 9;
        public static final int K = 37;
        public static final int L = 31;
        public static final int M = 12;
        public static final int N = 47;
        public static final int O = 44;
        public static final int P = 30;
        public static final int Q = 16;
        public static final int R = 34;
        public static final int S = 56;
        public static final int T = 51;
        public static final int U = 4;
        public static final int V = 53;
        public static final int W = 42;
        public static final int X = 41;
        public static final int Y = 31;
        public static final int Z = 44;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int f25468a0 = 47;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int f25469b0 = 46;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f25470c = 24;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f25471c0 = 19;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f25472d = 13;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final int f25473d0 = 42;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f25474e = 8;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final int f25475e0 = 44;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f25476f = 47;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final int f25477f0 = 25;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f25478g = 8;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final int f25479g0 = 9;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f25480h = 17;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final int f25481h0 = 48;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f25482i = 22;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final int f25483i0 = 35;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f25484j = 37;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final int f25485j0 = 52;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f25486k = 38;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final int f25487k0 = 23;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f25488l = 19;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public static final int f25489l0 = 31;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f25490m = 10;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public static final int f25491m0 = 37;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f25492n = 55;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public static final int f25493n0 = 20;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f25494o = 49;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f25495p = 18;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f25496q = 23;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f25497r = 52;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f25498s = 33;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f25499t = 4;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f25500u = 51;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f25501v = 13;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f25502w = 34;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f25503x = 41;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f25504y = 59;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f25505z = 17;

        public a(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // cp.l1.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25458s;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            int i10 = 1;
            long j11 = jArr[1];
            long j12 = jArr[2];
            long j13 = jArr[3];
            long j14 = jArr[4];
            long j15 = jArr[5];
            long j16 = jArr[6];
            long j17 = jArr[7];
            long j18 = jArr[8];
            long j19 = jArr[9];
            long j20 = jArr[10];
            long j21 = jArr[11];
            long j22 = jArr[12];
            long jP = jArr[13];
            long j23 = jArr[14];
            long jP2 = jArr[15];
            int i11 = 19;
            while (i11 >= i10) {
                int i12 = iArr[i11];
                int i13 = iArr2[i11];
                int i14 = i12 + 1;
                long j24 = j10 - jArr3[i14];
                int i15 = i12 + 2;
                long j25 = j11 - jArr3[i15];
                int i16 = i12 + 3;
                long j26 = j12 - jArr3[i16];
                int i17 = i12 + 4;
                long j27 = j13 - jArr3[i17];
                int i18 = i12 + 5;
                long j28 = j14 - jArr3[i18];
                int i19 = i12 + 6;
                int[] iArr3 = iArr;
                int[] iArr4 = iArr2;
                long j29 = j15 - jArr3[i19];
                int i20 = i12 + 7;
                long j30 = j16 - jArr3[i20];
                int i21 = i12 + 8;
                long j31 = j17 - jArr3[i21];
                int i22 = i12 + 9;
                long j32 = j18 - jArr3[i22];
                int i23 = i12 + 10;
                long j33 = j19 - jArr3[i23];
                int i24 = i12 + 11;
                long j34 = j20 - jArr3[i24];
                int i25 = i12 + 12;
                long j35 = j21 - jArr3[i25];
                int i26 = i12 + 13;
                long j36 = j22 - jArr3[i26];
                int i27 = i12 + 14;
                int i28 = i13 + 1;
                long j37 = jP - (jArr3[i27] + jArr4[i28]);
                int i29 = i12 + 15;
                long j38 = j23 - (jArr3[i29] + jArr4[i13 + 2]);
                long[] jArr5 = jArr3;
                long j39 = i11;
                long jP3 = l1.p(jP2 - ((jArr3[i12 + 16] + j39) + 1), 9, j24);
                long j40 = j24 - jP3;
                long jP4 = l1.p(j35, 48, j26);
                long j41 = j26 - jP4;
                long jP5 = l1.p(j37, 35, j30);
                long j42 = j30 - jP5;
                long[] jArr6 = jArr4;
                long jP6 = l1.p(j33, 52, j28);
                long j43 = j28 - jP6;
                long jP7 = l1.p(j25, 23, j38);
                long j44 = j38 - jP7;
                long jP8 = l1.p(j29, 31, j32);
                long j45 = j32 - jP8;
                long jP9 = l1.p(j27, 37, j34);
                long j46 = j34 - jP9;
                long jP10 = l1.p(j31, 20, j36);
                long j47 = j36 - jP10;
                long jP11 = l1.p(jP10, 31, j40);
                long j48 = j40 - jP11;
                long jP12 = l1.p(jP8, 44, j41);
                long j49 = j41 - jP12;
                long jP13 = l1.p(jP9, 47, j43);
                long j50 = j43 - jP13;
                long jP14 = l1.p(jP7, 46, j42);
                long j51 = j42 - jP14;
                long jP15 = l1.p(jP3, 19, j47);
                long j52 = j47 - jP15;
                long jP16 = l1.p(jP5, 42, j44);
                long j53 = j44 - jP16;
                long jP17 = l1.p(jP4, 44, j45);
                long j54 = j45 - jP17;
                long jP18 = l1.p(jP6, 25, j46);
                long j55 = j46 - jP18;
                long jP19 = l1.p(jP18, 16, j48);
                long j56 = j48 - jP19;
                long jP20 = l1.p(jP16, 34, j49);
                long j57 = j49 - jP20;
                long jP21 = l1.p(jP17, 56, j51);
                long j58 = j51 - jP21;
                long jP22 = l1.p(jP15, 51, j50);
                long j59 = j50 - jP22;
                long jP23 = l1.p(jP11, 4, j55);
                long j60 = j55 - jP23;
                long jP24 = l1.p(jP13, 53, j52);
                long j61 = j52 - jP24;
                long jP25 = l1.p(jP12, 42, j53);
                long j62 = j53 - jP25;
                long jP26 = l1.p(jP14, 41, j54);
                long j63 = j54 - jP26;
                long jP27 = l1.p(jP26, 41, j56);
                long jP28 = l1.p(jP24, 9, j57);
                long jP29 = l1.p(jP25, 37, j59);
                long j64 = j59 - jP29;
                long jP30 = l1.p(jP23, 31, j58);
                long j65 = j58 - jP30;
                long jP31 = l1.p(jP19, 12, j63);
                long j66 = j63 - jP31;
                long jP32 = l1.p(jP21, 47, j60);
                long j67 = j60 - jP32;
                long jP33 = l1.p(jP20, 44, j61);
                long j68 = j61 - jP33;
                long jP34 = l1.p(jP22, 30, j62);
                long j69 = j62 - jP34;
                long j70 = (j56 - jP27) - jArr5[i12];
                long j71 = jP27 - jArr5[i14];
                long j72 = (j57 - jP28) - jArr5[i15];
                long j73 = jP28 - jArr5[i16];
                long j74 = j64 - jArr5[i17];
                long j75 = jP29 - jArr5[i18];
                long j76 = j65 - jArr5[i19];
                long j77 = jP30 - jArr5[i20];
                long j78 = j66 - jArr5[i21];
                long j79 = jP31 - jArr5[i22];
                long j80 = j67 - jArr5[i23];
                long j81 = jP32 - jArr5[i24];
                long j82 = j68 - jArr5[i25];
                long j83 = jP33 - (jArr5[i26] + jArr6[i13]);
                long j84 = j69 - (jArr5[i27] + jArr6[i28]);
                long jP35 = l1.p(jP34 - (jArr5[i29] + j39), 5, j70);
                long j85 = j70 - jP35;
                long jP36 = l1.p(j81, 20, j72);
                long j86 = j72 - jP36;
                long jP37 = l1.p(j83, 48, j76);
                long j87 = j76 - jP37;
                long jP38 = l1.p(j79, 41, j74);
                long j88 = j74 - jP38;
                long jP39 = l1.p(j71, 47, j84);
                long j89 = j84 - jP39;
                long jP40 = l1.p(j75, 28, j78);
                long j90 = j78 - jP40;
                long jP41 = l1.p(j73, 16, j80);
                long j91 = j80 - jP41;
                long jP42 = l1.p(j77, 25, j82);
                long j92 = j82 - jP42;
                long jP43 = l1.p(jP42, 33, j85);
                long j93 = j85 - jP43;
                long jP44 = l1.p(jP40, 4, j86);
                long j94 = j86 - jP44;
                long jP45 = l1.p(jP41, 51, j88);
                long j95 = j88 - jP45;
                long jP46 = l1.p(jP39, 13, j87);
                long j96 = j87 - jP46;
                long jP47 = l1.p(jP35, 34, j92);
                long j97 = j92 - jP47;
                long jP48 = l1.p(jP37, 41, j89);
                long j98 = j89 - jP48;
                long jP49 = l1.p(jP36, 59, j90);
                long j99 = j90 - jP49;
                long jP50 = l1.p(jP38, 17, j91);
                long j100 = j91 - jP50;
                long jP51 = l1.p(jP50, 38, j93);
                long j101 = j93 - jP51;
                long jP52 = l1.p(jP48, 19, j94);
                long j102 = j94 - jP52;
                long jP53 = l1.p(jP49, 10, j96);
                long j103 = j96 - jP53;
                long jP54 = l1.p(jP47, 55, j95);
                long j104 = j95 - jP54;
                long jP55 = l1.p(jP43, 49, j100);
                long j105 = j100 - jP55;
                long jP56 = l1.p(jP45, 18, j97);
                long j106 = j97 - jP56;
                long jP57 = l1.p(jP44, 23, j98);
                long j107 = j98 - jP57;
                long jP58 = l1.p(jP46, 52, j99);
                long j108 = j99 - jP58;
                long jP59 = l1.p(jP58, 24, j101);
                long j109 = j101 - jP59;
                long jP60 = l1.p(jP56, 13, j102);
                j12 = j102 - jP60;
                long jP61 = l1.p(jP57, 8, j104);
                long j110 = j104 - jP61;
                long jP62 = l1.p(jP55, 47, j103);
                long j111 = j103 - jP62;
                long jP63 = l1.p(jP51, 8, j108);
                long j112 = j108 - jP63;
                long jP64 = l1.p(jP53, 17, j105);
                long j113 = j105 - jP64;
                jP = l1.p(jP52, 22, j106);
                jP2 = l1.p(jP54, 37, j107);
                j23 = j107 - jP2;
                j21 = jP64;
                j22 = j106 - jP;
                iArr = iArr3;
                jArr4 = jArr6;
                jArr3 = jArr5;
                j18 = j112;
                j19 = jP63;
                i10 = 1;
                j14 = j110;
                j11 = jP59;
                i11 -= 2;
                j13 = jP60;
                iArr2 = iArr4;
                j17 = jP62;
                j20 = j113;
                j15 = jP61;
                j16 = j111;
                j10 = j109;
            }
            long[] jArr7 = jArr3;
            long[] jArr8 = jArr4;
            long j114 = j10 - jArr7[0];
            long j115 = j11 - jArr7[1];
            long j116 = j12 - jArr7[2];
            long j117 = j13 - jArr7[3];
            long j118 = j14 - jArr7[4];
            long j119 = j15 - jArr7[5];
            long j120 = j16 - jArr7[6];
            long j121 = j17 - jArr7[7];
            long j122 = j18 - jArr7[8];
            long j123 = j19 - jArr7[9];
            long j124 = j20 - jArr7[10];
            long j125 = j21 - jArr7[11];
            long j126 = j22 - jArr7[12];
            long j127 = jP - (jArr7[13] + jArr8[0]);
            long j128 = j23 - (jArr7[14] + jArr8[1]);
            long j129 = jP2 - jArr7[15];
            jArr2[0] = j114;
            jArr2[1] = j115;
            jArr2[2] = j116;
            jArr2[3] = j117;
            jArr2[4] = j118;
            jArr2[5] = j119;
            jArr2[6] = j120;
            jArr2[7] = j121;
            jArr2[8] = j122;
            jArr2[9] = j123;
            jArr2[10] = j124;
            jArr2[11] = j125;
            jArr2[12] = j126;
            jArr2[13] = j127;
            jArr2[14] = j128;
            jArr2[15] = j129;
        }

        @Override // cp.l1.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25458s;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            int i10 = 1;
            long j11 = jArr[1];
            long j12 = jArr[2];
            long j13 = jArr[3];
            long j14 = jArr[4];
            long j15 = jArr[5];
            long j16 = jArr[6];
            long j17 = jArr[7];
            long j18 = jArr[8];
            long j19 = jArr[9];
            long j20 = jArr[10];
            long j21 = jArr[11];
            long j22 = jArr[12];
            long j23 = jArr[13];
            long j24 = jArr[14];
            long j25 = jArr[15];
            long j26 = j10 + jArr3[0];
            long j27 = j11 + jArr3[1];
            long j28 = j12 + jArr3[2];
            long j29 = j13 + jArr3[3];
            long j30 = j14 + jArr3[4];
            long j31 = j15 + jArr3[5];
            long j32 = j16 + jArr3[6];
            long j33 = j17 + jArr3[7];
            long j34 = j18 + jArr3[8];
            long j35 = j19 + jArr3[9];
            long j36 = j20 + jArr3[10];
            long j37 = j21 + jArr3[11];
            long j38 = j22 + jArr3[12];
            long j39 = j23 + jArr3[13] + jArr4[0];
            long j40 = j24 + jArr3[14] + jArr4[1];
            long j41 = j29;
            long j42 = j31;
            long j43 = j33;
            long j44 = j35;
            long j45 = j37;
            long j46 = j39;
            long j47 = j25 + jArr3[15];
            while (i10 < 20) {
                int i11 = iArr[i10];
                int i12 = iArr2[i10];
                long j48 = j26 + j27;
                long jL = l1.l(j27, 24, j48);
                long j49 = j28 + j41;
                long jL2 = l1.l(j41, 13, j49);
                long[] jArr5 = jArr3;
                int[] iArr3 = iArr;
                int[] iArr4 = iArr2;
                long j50 = j42;
                long j51 = j30 + j50;
                long jL3 = l1.l(j50, 8, j51);
                int i13 = i10;
                long j52 = j43;
                long j53 = j32 + j52;
                long jL4 = l1.l(j52, 47, j53);
                long[] jArr6 = jArr4;
                long j54 = j44;
                long j55 = j34 + j54;
                long jL5 = l1.l(j54, 8, j55);
                long j56 = j45;
                long j57 = j36 + j56;
                long jL6 = l1.l(j56, 17, j57);
                long j58 = j46;
                long j59 = j38 + j58;
                long jL7 = l1.l(j58, 22, j59);
                long j60 = j47;
                long j61 = j40 + j60;
                long jL8 = l1.l(j60, 37, j61);
                long j62 = j48 + jL5;
                long jL9 = l1.l(jL5, 38, j62);
                long j63 = j49 + jL7;
                long jL10 = l1.l(jL7, 19, j63);
                long j64 = j53 + jL6;
                long jL11 = l1.l(jL6, 10, j64);
                long j65 = j51 + jL8;
                long jL12 = l1.l(jL8, 55, j65);
                long j66 = j57 + jL4;
                long jL13 = l1.l(jL4, 49, j66);
                long j67 = j59 + jL2;
                long jL14 = l1.l(jL2, 18, j67);
                long j68 = j61 + jL3;
                long jL15 = l1.l(jL3, 23, j68);
                long j69 = j55 + jL;
                long jL16 = l1.l(jL, 52, j69);
                long j70 = j62 + jL13;
                long jL17 = l1.l(jL13, 33, j70);
                long j71 = j63 + jL15;
                long jL18 = l1.l(jL15, 4, j71);
                long j72 = j65 + jL14;
                long jL19 = l1.l(jL14, 51, j72);
                long j73 = j64 + jL16;
                long jL20 = l1.l(jL16, 13, j73);
                long j74 = j67 + jL12;
                long jL21 = l1.l(jL12, 34, j74);
                long j75 = j68 + jL10;
                long jL22 = l1.l(jL10, 41, j75);
                long j76 = j69 + jL11;
                long jL23 = l1.l(jL11, 59, j76);
                long j77 = j66 + jL9;
                long jL24 = l1.l(jL9, 17, j77);
                long j78 = j70 + jL21;
                long jL25 = l1.l(jL21, 5, j78);
                long j79 = j71 + jL23;
                long jL26 = l1.l(jL23, 20, j79);
                long j80 = j73 + jL22;
                long jL27 = l1.l(jL22, 48, j80);
                long j81 = j72 + jL24;
                long jL28 = l1.l(jL24, 41, j81);
                long j82 = j75 + jL20;
                long jL29 = l1.l(jL20, 47, j82);
                long j83 = j76 + jL18;
                long jL30 = l1.l(jL18, 28, j83);
                long j84 = j77 + jL19;
                long jL31 = l1.l(jL19, 16, j84);
                long j85 = j74 + jL17;
                long jL32 = l1.l(jL17, 25, j85);
                long j86 = j78 + jArr5[i11];
                int i14 = i11 + 1;
                long j87 = jL29 + jArr5[i14];
                int i15 = i11 + 2;
                long j88 = j79 + jArr5[i15];
                int i16 = i11 + 3;
                long j89 = jL31 + jArr5[i16];
                int i17 = i11 + 4;
                long j90 = j81 + jArr5[i17];
                int i18 = i11 + 5;
                long j91 = jL30 + jArr5[i18];
                int i19 = i11 + 6;
                long j92 = j80 + jArr5[i19];
                int i20 = i11 + 7;
                long j93 = jL32 + jArr5[i20];
                int i21 = i11 + 8;
                long j94 = j83 + jArr5[i21];
                int i22 = i11 + 9;
                long j95 = jL28 + jArr5[i22];
                int i23 = i11 + 10;
                long j96 = j84 + jArr5[i23];
                int i24 = i11 + 11;
                long j97 = jL26 + jArr5[i24];
                int i25 = i11 + 12;
                long j98 = j85 + jArr5[i25];
                int i26 = i11 + 13;
                long j99 = jL27 + jArr5[i26] + jArr6[i12];
                int i27 = i11 + 14;
                int i28 = i12 + 1;
                long j100 = j82 + jArr5[i27] + jArr6[i28];
                int i29 = i11 + 15;
                long j101 = jArr5[i29];
                long j102 = i13;
                long j103 = jL25 + j101 + j102;
                long j104 = j86 + j87;
                long jL33 = l1.l(j87, 41, j104);
                long j105 = j88 + j89;
                long jL34 = l1.l(j89, 9, j105);
                long j106 = j90 + j91;
                long jL35 = l1.l(j91, 37, j106);
                long j107 = j92 + j93;
                long jL36 = l1.l(j93, 31, j107);
                long j108 = j94 + j95;
                long jL37 = l1.l(j95, 12, j108);
                long j109 = j96 + j97;
                long jL38 = l1.l(j97, 47, j109);
                long j110 = j98 + j99;
                long jL39 = l1.l(j99, 44, j110);
                long j111 = j100 + j103;
                long jL40 = l1.l(j103, 30, j111);
                long j112 = j104 + jL37;
                long jL41 = l1.l(jL37, 16, j112);
                long j113 = j105 + jL39;
                long jL42 = l1.l(jL39, 34, j113);
                long j114 = j107 + jL38;
                long jL43 = l1.l(jL38, 56, j114);
                long j115 = j106 + jL40;
                long jL44 = l1.l(jL40, 51, j115);
                long j116 = j109 + jL36;
                long jL45 = l1.l(jL36, 4, j116);
                long j117 = j110 + jL34;
                long jL46 = l1.l(jL34, 53, j117);
                long j118 = j111 + jL35;
                long jL47 = l1.l(jL35, 42, j118);
                long j119 = j108 + jL33;
                long jL48 = l1.l(jL33, 41, j119);
                long j120 = j112 + jL45;
                long jL49 = l1.l(jL45, 31, j120);
                long j121 = j113 + jL47;
                long jL50 = l1.l(jL47, 44, j121);
                long j122 = j115 + jL46;
                long jL51 = l1.l(jL46, 47, j122);
                long j123 = j114 + jL48;
                long jL52 = l1.l(jL48, 46, j123);
                long j124 = j117 + jL44;
                long jL53 = l1.l(jL44, 19, j124);
                long j125 = j118 + jL42;
                long jL54 = l1.l(jL42, 42, j125);
                long j126 = j119 + jL43;
                long jL55 = l1.l(jL43, 44, j126);
                long j127 = j116 + jL41;
                long jL56 = l1.l(jL41, 25, j127);
                long j128 = j120 + jL53;
                long jL57 = l1.l(jL53, 9, j128);
                long j129 = j121 + jL55;
                long jL58 = l1.l(jL55, 48, j129);
                long j130 = j123 + jL54;
                long jL59 = l1.l(jL54, 35, j130);
                long j131 = j122 + jL56;
                long jL60 = l1.l(jL56, 52, j131);
                long j132 = j125 + jL52;
                long jL61 = l1.l(jL52, 23, j132);
                long j133 = j126 + jL50;
                long jL62 = l1.l(jL50, 31, j133);
                long j134 = j127 + jL51;
                long jL63 = l1.l(jL51, 37, j134);
                long j135 = j124 + jL49;
                long jL64 = l1.l(jL49, 20, j135);
                long j136 = j128 + jArr5[i14];
                long j137 = jL61 + jArr5[i15];
                long j138 = j129 + jArr5[i16];
                long j139 = jL63 + jArr5[i17];
                long j140 = j131 + jArr5[i18];
                long j141 = jL62 + jArr5[i19];
                long j142 = j130 + jArr5[i20];
                long j143 = jL64 + jArr5[i21];
                long j144 = j133 + jArr5[i22];
                j44 = jL60 + jArr5[i23];
                j36 = j134 + jArr5[i24];
                j45 = jL58 + jArr5[i25];
                long j145 = j135 + jArr5[i26];
                j46 = jL59 + jArr5[i27] + jArr6[i28];
                long j146 = j132 + jArr5[i29] + jArr6[i12 + 2];
                j47 = jL57 + jArr5[i11 + 16] + j102 + 1;
                j43 = j143;
                j41 = j139;
                j42 = j141;
                j40 = j146;
                iArr2 = iArr4;
                j34 = j144;
                j32 = j142;
                j38 = j145;
                j27 = j137;
                iArr = iArr3;
                jArr4 = jArr6;
                jArr3 = jArr5;
                i10 = i13 + 2;
                j30 = j140;
                j26 = j136;
                j28 = j138;
            }
            jArr2[0] = j26;
            jArr2[1] = j27;
            jArr2[2] = j28;
            jArr2[3] = j41;
            jArr2[4] = j30;
            jArr2[5] = j42;
            jArr2[6] = j32;
            jArr2[7] = j43;
            jArr2[8] = j34;
            jArr2[9] = j44;
            jArr2[10] = j36;
            jArr2[11] = j45;
            jArr2[12] = j38;
            jArr2[13] = j46;
            jArr2[14] = j40;
            jArr2[15] = j47;
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f25506c = 14;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f25507d = 16;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f25508e = 52;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f25509f = 57;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f25510g = 23;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f25511h = 40;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f25512i = 5;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f25513j = 37;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f25514k = 25;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f25515l = 33;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f25516m = 46;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f25517n = 12;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f25518o = 58;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f25519p = 22;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f25520q = 32;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f25521r = 32;

        public b(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // cp.l1.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25459t;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            long j11 = jArr[1];
            long j12 = jArr[2];
            long jP = jArr[3];
            int i10 = 17;
            for (int i11 = 1; i10 >= i11; i11 = 1) {
                int i12 = iArr[i10];
                int i13 = iArr2[i10];
                int i14 = i12 + 1;
                long j13 = j10 - jArr3[i14];
                int i15 = i12 + 2;
                int i16 = i13 + 1;
                long j14 = j11 - (jArr3[i15] + jArr4[i16]);
                int i17 = i12 + 3;
                long j15 = j12 - (jArr3[i17] + jArr4[i13 + 2]);
                long j16 = i10;
                long jP2 = l1.p(jP - ((jArr3[i12 + 4] + j16) + 1), 32, j13);
                long j17 = j13 - jP2;
                int[] iArr3 = iArr;
                long jP3 = l1.p(j14, 32, j15);
                long j18 = j15 - jP3;
                long jP4 = l1.p(jP3, 58, j17);
                long j19 = j17 - jP4;
                long jP5 = l1.p(jP2, 22, j18);
                long j20 = j18 - jP5;
                long jP6 = l1.p(jP5, 46, j19);
                long j21 = j19 - jP6;
                long jP7 = l1.p(jP4, 12, j20);
                long j22 = j20 - jP7;
                long jP8 = l1.p(jP7, 25, j21);
                long jP9 = l1.p(jP6, 33, j22);
                long j23 = (j21 - jP8) - jArr3[i12];
                long j24 = jP8 - (jArr3[i14] + jArr4[i13]);
                long j25 = (j22 - jP9) - (jArr3[i15] + jArr4[i16]);
                long jP10 = l1.p(jP9 - (jArr3[i17] + j16), 5, j23);
                long j26 = j23 - jP10;
                long jP11 = l1.p(j24, 37, j25);
                long j27 = j25 - jP11;
                long jP12 = l1.p(jP11, 23, j26);
                long j28 = j26 - jP12;
                long jP13 = l1.p(jP10, 40, j27);
                long j29 = j27 - jP13;
                long jP14 = l1.p(jP13, 52, j28);
                long j30 = j28 - jP14;
                long jP15 = l1.p(jP12, 57, j29);
                long j31 = j29 - jP15;
                long jP16 = l1.p(jP15, 14, j30);
                j10 = j30 - jP16;
                jP = l1.p(jP14, 16, j31);
                j12 = j31 - jP;
                i10 -= 2;
                j11 = jP16;
                iArr = iArr3;
                iArr2 = iArr2;
            }
            long j32 = j10 - jArr3[0];
            long j33 = j11 - (jArr3[1] + jArr4[0]);
            long j34 = j12 - (jArr3[2] + jArr4[1]);
            long j35 = jP - jArr3[3];
            jArr2[0] = j32;
            jArr2[1] = j33;
            jArr2[2] = j34;
            jArr2[3] = j35;
        }

        @Override // cp.l1.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25459t;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            long j11 = jArr[1];
            long j12 = jArr[2];
            long j13 = jArr[3];
            long j14 = j10 + jArr3[0];
            long j15 = j11 + jArr3[1] + jArr4[0];
            long j16 = j12 + jArr3[2] + jArr4[1];
            long j17 = j13 + jArr3[3];
            int i10 = 1;
            while (i10 < 18) {
                int i11 = iArr[i10];
                int i12 = iArr2[i10];
                long j18 = j14 + j15;
                long jL = l1.l(j15, 14, j18);
                long j19 = j16 + j17;
                long jL2 = l1.l(j17, 16, j19);
                long j20 = j18 + jL2;
                long jL3 = l1.l(jL2, 52, j20);
                long j21 = j19 + jL;
                long jL4 = l1.l(jL, 57, j21);
                long j22 = j20 + jL4;
                long jL5 = l1.l(jL4, 23, j22);
                long j23 = j21 + jL3;
                long jL6 = l1.l(jL3, 40, j23);
                long j24 = j22 + jL6;
                long jL7 = l1.l(jL6, 5, j24);
                long j25 = j23 + jL5;
                long jL8 = l1.l(jL5, 37, j25);
                long j26 = j24 + jArr3[i11];
                int i13 = i11 + 1;
                long j27 = jL8 + jArr3[i13] + jArr4[i12];
                int i14 = i11 + 2;
                int i15 = i12 + 1;
                long j28 = j25 + jArr3[i14] + jArr4[i15];
                int i16 = i11 + 3;
                int[] iArr3 = iArr;
                long j29 = i10;
                long j30 = jL7 + jArr3[i16] + j29;
                long j31 = j26 + j27;
                long jL9 = l1.l(j27, 25, j31);
                long j32 = j28 + j30;
                long jL10 = l1.l(j30, 33, j32);
                long j33 = j31 + jL10;
                long jL11 = l1.l(jL10, 46, j33);
                long j34 = j32 + jL9;
                long jL12 = l1.l(jL9, 12, j34);
                long j35 = j33 + jL12;
                long jL13 = l1.l(jL12, 58, j35);
                long j36 = j34 + jL11;
                long jL14 = l1.l(jL11, 22, j36);
                long j37 = j35 + jL14;
                long jL15 = l1.l(jL14, 32, j37);
                long j38 = j36 + jL13;
                long jL16 = l1.l(jL13, 32, j38);
                j14 = j37 + jArr3[i13];
                j15 = jL16 + jArr3[i14] + jArr4[i15];
                j16 = j38 + jArr3[i16] + jArr4[i12 + 2];
                j17 = jL15 + jArr3[i11 + 4] + j29 + 1;
                i10 += 2;
                iArr = iArr3;
                iArr2 = iArr2;
            }
            jArr2[0] = j14;
            jArr2[1] = j15;
            jArr2[2] = j16;
            jArr2[3] = j17;
        }
    }

    public static final class c extends d {
        public static final int A = 25;
        public static final int B = 29;
        public static final int C = 39;
        public static final int D = 43;
        public static final int E = 8;
        public static final int F = 35;
        public static final int G = 56;
        public static final int H = 22;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f25522c = 46;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f25523d = 36;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f25524e = 19;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f25525f = 37;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f25526g = 33;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f25527h = 27;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f25528i = 14;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f25529j = 42;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f25530k = 17;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f25531l = 49;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f25532m = 36;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f25533n = 39;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f25534o = 44;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f25535p = 9;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f25536q = 54;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f25537r = 56;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f25538s = 39;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f25539t = 30;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f25540u = 34;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f25541v = 24;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f25542w = 13;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f25543x = 50;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f25544y = 10;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f25545z = 17;

        public c(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // cp.l1.d
        public void a(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25457r;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            int i10 = 1;
            long j11 = jArr[1];
            long j12 = jArr[2];
            long jP = jArr[3];
            long j13 = jArr[4];
            long j14 = jArr[5];
            long j15 = jArr[6];
            long jP2 = jArr[7];
            int i11 = 17;
            while (i11 >= i10) {
                int i12 = iArr[i11];
                int i13 = iArr2[i11];
                int i14 = i12 + 1;
                long j16 = j10 - jArr3[i14];
                int i15 = i12 + 2;
                long j17 = j11 - jArr3[i15];
                int i16 = i12 + 3;
                long j18 = j12 - jArr3[i16];
                int i17 = i12 + 4;
                long j19 = jP - jArr3[i17];
                int i18 = i12 + 5;
                long j20 = j13 - jArr3[i18];
                int i19 = i12 + 6;
                int i20 = i13 + 1;
                long j21 = j14 - (jArr3[i19] + jArr4[i20]);
                int i21 = i12 + 7;
                int[] iArr3 = iArr;
                int[] iArr4 = iArr2;
                long j22 = j15 - (jArr3[i21] + jArr4[i13 + 2]);
                long[] jArr5 = jArr3;
                long j23 = i11;
                long j24 = jP2 - ((jArr3[i12 + 8] + j23) + 1);
                int i22 = i11;
                long jP3 = l1.p(j17, 8, j22);
                long j25 = j22 - jP3;
                long jP4 = l1.p(j24, 35, j16);
                long j26 = j16 - jP4;
                long jP5 = l1.p(j21, 56, j18);
                long j27 = j18 - jP5;
                long jP6 = l1.p(j19, 22, j20);
                long j28 = j20 - jP6;
                long jP7 = l1.p(jP3, 25, j28);
                long j29 = j28 - jP7;
                long jP8 = l1.p(jP6, 29, j25);
                long j30 = j25 - jP8;
                long jP9 = l1.p(jP5, 39, j26);
                long j31 = j26 - jP9;
                long jP10 = l1.p(jP4, 43, j27);
                long j32 = j27 - jP10;
                long jP11 = l1.p(jP7, 13, j32);
                long j33 = j32 - jP11;
                long jP12 = l1.p(jP10, 50, j29);
                long j34 = j29 - jP12;
                long jP13 = l1.p(jP9, 10, j30);
                long j35 = j30 - jP13;
                long jP14 = l1.p(jP8, 17, j31);
                long j36 = j31 - jP14;
                long jP15 = l1.p(jP11, 39, j36);
                long jP16 = l1.p(jP14, 30, j33);
                long jP17 = l1.p(jP13, 34, j34);
                long j37 = j34 - jP17;
                long jP18 = l1.p(jP12, 24, j35);
                long j38 = (j36 - jP15) - jArr5[i12];
                long j39 = jP15 - jArr5[i14];
                long j40 = (j33 - jP16) - jArr5[i15];
                long j41 = jP16 - jArr5[i16];
                long j42 = j37 - jArr5[i17];
                long j43 = jP17 - (jArr5[i18] + jArr4[i13]);
                long j44 = (j35 - jP18) - (jArr5[i19] + jArr4[i20]);
                long j45 = jP18 - (jArr5[i21] + j23);
                long jP19 = l1.p(j39, 44, j44);
                long j46 = j44 - jP19;
                long jP20 = l1.p(j45, 9, j38);
                long j47 = j38 - jP20;
                long jP21 = l1.p(j43, 54, j40);
                long j48 = j40 - jP21;
                long jP22 = l1.p(j41, 56, j42);
                long j49 = j42 - jP22;
                long jP23 = l1.p(jP19, 17, j49);
                long j50 = j49 - jP23;
                long jP24 = l1.p(jP22, 49, j46);
                long j51 = j46 - jP24;
                long jP25 = l1.p(jP21, 36, j47);
                long j52 = j47 - jP25;
                long jP26 = l1.p(jP20, 39, j48);
                long j53 = j48 - jP26;
                long jP27 = l1.p(jP23, 33, j53);
                long j54 = j53 - jP27;
                long jP28 = l1.p(jP26, 27, j50);
                long j55 = j50 - jP28;
                long jP29 = l1.p(jP25, 14, j51);
                long j56 = j51 - jP29;
                long[] jArr6 = jArr4;
                long jP30 = l1.p(jP24, 42, j52);
                long j57 = j52 - jP30;
                long jP31 = l1.p(jP27, 46, j57);
                long j58 = j57 - jP31;
                jP = l1.p(jP30, 36, j54);
                long jP32 = l1.p(jP29, 19, j55);
                j13 = j55 - jP32;
                jP2 = l1.p(jP28, 37, j56);
                j15 = j56 - jP2;
                j12 = j54 - jP;
                j11 = jP31;
                j14 = jP32;
                i11 = i22 - 2;
                iArr2 = iArr4;
                jArr3 = jArr5;
                i10 = 1;
                j10 = j58;
                jArr4 = jArr6;
                iArr = iArr3;
            }
            long[] jArr7 = jArr3;
            long[] jArr8 = jArr4;
            long j59 = j10 - jArr7[0];
            long j60 = j11 - jArr7[1];
            long j61 = j12 - jArr7[2];
            long j62 = jP - jArr7[3];
            long j63 = j13 - jArr7[4];
            long j64 = j14 - (jArr7[5] + jArr8[0]);
            long j65 = j15 - (jArr7[6] + jArr8[1]);
            long j66 = jP2 - jArr7[7];
            jArr2[0] = j59;
            jArr2[1] = j60;
            jArr2[2] = j61;
            jArr2[3] = j62;
            jArr2[4] = j63;
            jArr2[5] = j64;
            jArr2[6] = j65;
            jArr2[7] = j66;
        }

        @Override // cp.l1.d
        public void b(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f25547b;
            long[] jArr4 = this.f25546a;
            int[] iArr = l1.f25457r;
            int[] iArr2 = l1.f25460u;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j10 = jArr[0];
            long j11 = jArr[1];
            long j12 = jArr[2];
            long j13 = jArr[3];
            long j14 = jArr[4];
            long j15 = jArr[5];
            long j16 = jArr[6];
            long j17 = jArr[7];
            long j18 = j10 + jArr3[0];
            long j19 = j11 + jArr3[1];
            long j20 = j12 + jArr3[2];
            long j21 = j13 + jArr3[3];
            long j22 = j14 + jArr3[4];
            long j23 = j15 + jArr3[5] + jArr4[0];
            long j24 = j16 + jArr3[6] + jArr4[1];
            long j25 = j21;
            long j26 = j23;
            long j27 = j17 + jArr3[7];
            int i10 = 1;
            while (i10 < 18) {
                int i11 = iArr[i10];
                int i12 = iArr2[i10];
                long j28 = j18 + j19;
                long jL = l1.l(j19, 46, j28);
                long j29 = j20 + j25;
                long jL2 = l1.l(j25, 36, j29);
                long[] jArr5 = jArr3;
                int[] iArr3 = iArr;
                long j30 = j26;
                long j31 = j22 + j30;
                long jL3 = l1.l(j30, 19, j31);
                int i13 = i10;
                long j32 = j27;
                long j33 = j24 + j32;
                long jL4 = l1.l(j32, 37, j33);
                long j34 = j29 + jL;
                long jL5 = l1.l(jL, 33, j34);
                long j35 = j31 + jL4;
                long jL6 = l1.l(jL4, 27, j35);
                long j36 = j33 + jL3;
                long jL7 = l1.l(jL3, 14, j36);
                long j37 = j28 + jL2;
                long jL8 = l1.l(jL2, 42, j37);
                long j38 = j35 + jL5;
                long jL9 = l1.l(jL5, 17, j38);
                long j39 = j36 + jL8;
                long jL10 = l1.l(jL8, 49, j39);
                long j40 = j37 + jL7;
                long jL11 = l1.l(jL7, 36, j40);
                long j41 = j34 + jL6;
                long jL12 = l1.l(jL6, 39, j41);
                long j42 = j39 + jL9;
                long jL13 = l1.l(jL9, 44, j42);
                long j43 = j40 + jL12;
                long jL14 = l1.l(jL12, 9, j43);
                long j44 = j41 + jL11;
                long jL15 = l1.l(jL11, 54, j44);
                long j45 = j38 + jL10;
                long jL16 = l1.l(jL10, 56, j45);
                long j46 = j43 + jArr5[i11];
                int i14 = i11 + 1;
                long j47 = jL13 + jArr5[i14];
                int i15 = i11 + 2;
                long j48 = j44 + jArr5[i15];
                int i16 = i11 + 3;
                long j49 = jL16 + jArr5[i16];
                int i17 = i11 + 4;
                long j50 = j45 + jArr5[i17];
                int i18 = i11 + 5;
                long j51 = jL15 + jArr5[i18] + jArr4[i12];
                int i19 = i11 + 6;
                int i20 = i12 + 1;
                long j52 = j42 + jArr5[i19] + jArr4[i20];
                int i21 = i11 + 7;
                long j53 = i13;
                long j54 = jL14 + jArr5[i21] + j53;
                long j55 = j46 + j47;
                long jL17 = l1.l(j47, 39, j55);
                long j56 = j48 + j49;
                long jL18 = l1.l(j49, 30, j56);
                long j57 = j50 + j51;
                long jL19 = l1.l(j51, 34, j57);
                long j58 = j52 + j54;
                long jL20 = l1.l(j54, 24, j58);
                long j59 = j56 + jL17;
                long jL21 = l1.l(jL17, 13, j59);
                long j60 = j57 + jL20;
                long jL22 = l1.l(jL20, 50, j60);
                long j61 = j58 + jL19;
                long jL23 = l1.l(jL19, 10, j61);
                long j62 = j55 + jL18;
                long jL24 = l1.l(jL18, 17, j62);
                long j63 = j60 + jL21;
                long jL25 = l1.l(jL21, 25, j63);
                long j64 = j61 + jL24;
                long jL26 = l1.l(jL24, 29, j64);
                long j65 = j62 + jL23;
                long jL27 = l1.l(jL23, 39, j65);
                long j66 = j59 + jL22;
                long jL28 = l1.l(jL22, 43, j66);
                long j67 = j64 + jL25;
                long jL29 = l1.l(jL25, 8, j67);
                long j68 = j65 + jL28;
                long jL30 = l1.l(jL28, 35, j68);
                long j69 = j66 + jL27;
                long jL31 = l1.l(jL27, 56, j69);
                long j70 = j63 + jL26;
                long jL32 = l1.l(jL26, 22, j70);
                long j71 = j68 + jArr5[i14];
                j19 = jL29 + jArr5[i15];
                long j72 = j69 + jArr5[i16];
                long j73 = jL32 + jArr5[i17];
                long j74 = j70 + jArr5[i18];
                long j75 = jL31 + jArr5[i19] + jArr4[i20];
                j24 = j67 + jArr5[i21] + jArr4[i12 + 2];
                j27 = jL30 + jArr5[i11 + 8] + j53 + 1;
                j22 = j74;
                j26 = j75;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr3 = jArr5;
                i10 = i13 + 2;
                j25 = j73;
                j20 = j72;
                j18 = j71;
            }
            jArr2[0] = j18;
            jArr2[1] = j19;
            jArr2[2] = j20;
            jArr2[3] = j25;
            jArr2[4] = j22;
            jArr2[5] = j26;
            jArr2[6] = j24;
            jArr2[7] = j27;
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f25546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f25547b;

        public d(long[] jArr, long[] jArr2) {
            this.f25547b = jArr;
            this.f25546a = jArr2;
        }

        public abstract void a(long[] jArr, long[] jArr2);

        public abstract void b(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        f25457r = iArr;
        f25458s = new int[iArr.length];
        f25459t = new int[iArr.length];
        f25460u = new int[iArr.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = f25457r;
            if (i10 >= iArr2.length) {
                return;
            }
            f25458s[i10] = i10 % 17;
            iArr2[i10] = i10 % 9;
            f25459t[i10] = i10 % 5;
            f25460u[i10] = i10 % 3;
            i10++;
        }
    }

    public l1(int i10) {
        d bVar;
        long[] jArr = new long[5];
        this.f25464d = jArr;
        int i11 = i10 / 8;
        this.f25461a = i11;
        int i12 = i11 / 8;
        this.f25462b = i12;
        this.f25463c = new long[i12];
        long[] jArr2 = new long[(i12 * 2) + 1];
        this.f25465e = jArr2;
        if (i10 == 256) {
            bVar = new b(jArr2, jArr);
        } else if (i10 == 512) {
            bVar = new c(jArr2, jArr);
        } else {
            if (i10 != 1024) {
                throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
            }
            bVar = new a(jArr2, jArr);
        }
        this.f25466f = bVar;
    }

    public static long i(byte[] bArr, int i10) {
        if (i10 + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        int i11 = i10 + 1;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 40);
        int i17 = i16 + 1;
        return ((((long) bArr[i17]) & 255) << 56) | j14 | ((((long) bArr[i16]) & 255) << 48);
    }

    public static long l(long j10, int i10, long j11) {
        return ((j10 >>> (-i10)) | (j10 << i10)) ^ j11;
    }

    public static void o(long j10, byte[] bArr, int i10) {
        if (i10 + 8 > bArr.length) {
            throw new IllegalArgumentException();
        }
        int i11 = i10 + 1;
        bArr[i10] = (byte) j10;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j10 >> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j10 >> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j10 >> 24);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j10 >> 32);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (j10 >> 40);
        bArr[i16] = (byte) (j10 >> 48);
        bArr[i16 + 1] = (byte) (j10 >> 56);
    }

    public static long p(long j10, int i10, long j11) {
        long j12 = j10 ^ j11;
        return (j12 << (-i10)) | (j12 >>> i10);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        byte[] bArrB;
        long[] jArr;
        long[] jArr2 = null;
        if (kVar instanceof k2) {
            k2 k2Var = (k2) kVar;
            bArrA = k2Var.a().a();
            bArrB = k2Var.b();
        } else {
            if (!(kVar instanceof np.n1)) {
                throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + kVar.getClass().getName());
            }
            bArrA = ((np.n1) kVar).a();
            bArrB = null;
        }
        if (bArrA == null) {
            jArr = null;
        } else {
            if (bArrA.length != this.f25461a) {
                throw new IllegalArgumentException("Threefish key must be same size as block (" + this.f25461a + " bytes)");
            }
            int i10 = this.f25462b;
            jArr = new long[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                jArr[i11] = i(bArrA, i11 * 8);
            }
        }
        if (bArrB != null) {
            if (bArrB.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[]{i(bArrB, 0), i(bArrB, 8)};
        }
        j(z10, jArr, jArr2);
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return "Threefish-" + (this.f25461a * 8);
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return this.f25461a;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) throws IllegalStateException, DataLengthException {
        int i12 = this.f25461a;
        if (i10 + i12 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        int i13 = 0;
        for (int i14 = 0; i14 < this.f25461a; i14 += 8) {
            this.f25463c[i14 >> 3] = i(bArr, i10 + i14);
        }
        long[] jArr = this.f25463c;
        k(jArr, jArr);
        while (true) {
            int i15 = this.f25461a;
            if (i13 >= i15) {
                return i15;
            }
            o(this.f25463c[i13 >> 3], bArr2, i11 + i13);
            i13 += 8;
        }
    }

    public void j(boolean z10, long[] jArr, long[] jArr2) {
        this.f25467g = z10;
        if (jArr != null) {
            m(jArr);
        }
        if (jArr2 != null) {
            n(jArr2);
        }
    }

    public int k(long[] jArr, long[] jArr2) throws IllegalStateException, DataLengthException {
        long[] jArr3 = this.f25465e;
        int i10 = this.f25462b;
        if (jArr3[i10] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i10) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i10) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.f25467g) {
            this.f25466f.b(jArr, jArr2);
        } else {
            this.f25466f.a(jArr, jArr2);
        }
        return this.f25462b;
    }

    public final void m(long[] jArr) {
        if (jArr.length != this.f25462b) {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.f25462b + " words)");
        }
        long j10 = f25456q;
        int i10 = 0;
        while (true) {
            int i11 = this.f25462b;
            if (i10 >= i11) {
                long[] jArr2 = this.f25465e;
                jArr2[i11] = j10;
                System.arraycopy(jArr2, 0, jArr2, i11 + 1, i11);
                return;
            } else {
                long[] jArr3 = this.f25465e;
                jArr3[i10] = jArr[i10];
                j10 ^= jArr3[i10];
                i10++;
            }
        }
    }

    public final void n(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.f25464d;
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr2[0] ^ jArr2[1];
        jArr2[3] = jArr2[0];
        jArr2[4] = jArr2[1];
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
