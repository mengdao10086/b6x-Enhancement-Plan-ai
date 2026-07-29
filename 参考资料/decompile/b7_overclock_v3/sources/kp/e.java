package kp;

import org.bouncycastle.util.l;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f39086a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f39087b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f39088c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f39089d = -520093696;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f39090e = -2233785415175766016L;

    public static void A(int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = i13 << 24;
        iArr[0] = (i14 >>> 7) ^ ((((i10 >>> 8) ^ i14) ^ (i14 >>> 1)) ^ (i14 >>> 2));
        iArr[1] = (i11 >>> 8) | (i10 << 24);
        iArr[2] = (i12 >>> 8) | (i11 << 24);
        iArr[3] = (i13 >>> 8) | (i12 << 24);
    }

    public static void B(int[] iArr, int[] iArr2) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        int i14 = i13 << 24;
        iArr2[0] = (i14 >>> 7) ^ ((((i10 >>> 8) ^ i14) ^ (i14 >>> 1)) ^ (i14 >>> 2));
        iArr2[1] = (i11 >>> 8) | (i10 << 24);
        iArr2[2] = (i12 >>> 8) | (i11 << 24);
        iArr2[3] = (i13 >>> 8) | (i12 << 24);
    }

    public static void C(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 << 56;
        jArr[0] = (j12 >>> 7) ^ ((((j10 >>> 8) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2));
        jArr[1] = (j10 << 56) | (j11 >>> 8);
    }

    public static void D(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 << 56;
        jArr2[0] = (j12 >>> 7) ^ ((((j10 >>> 8) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2));
        jArr2[1] = (j10 << 56) | (j11 >>> 8);
    }

    public static byte[] E() {
        byte[] bArr = new byte[16];
        bArr[0] = -128;
        return bArr;
    }

    public static int[] F() {
        int[] iArr = new int[4];
        iArr[0] = Integer.MIN_VALUE;
        return iArr;
    }

    public static long[] G() {
        return new long[]{Long.MIN_VALUE, 0};
    }

    public static long[] H() {
        return new long[]{4611686018427387904L, 0};
    }

    public static void I(long[] jArr, long[] jArr2) {
        long[] jArr3 = new long[4];
        rr.b.e(jArr[0], jArr3, 0);
        rr.b.e(jArr[1], jArr3, 2);
        long j10 = jArr3[0];
        long j11 = jArr3[1];
        long j12 = jArr3[2];
        long j13 = jArr3[3];
        long j14 = j12 ^ ((j13 << 57) ^ ((j13 << 63) ^ (j13 << 62)));
        jArr2[0] = j10 ^ ((((j14 >>> 1) ^ j14) ^ (j14 >>> 2)) ^ (j14 >>> 7));
        jArr2[1] = (j11 ^ ((((j13 >>> 1) ^ j13) ^ (j13 >>> 2)) ^ (j13 >>> 7))) ^ ((j14 << 57) ^ ((j14 << 63) ^ (j14 << 62)));
    }

    public static void J(byte[] bArr, int i10, byte[] bArr2, int i11, int i12) {
        while (true) {
            i12--;
            if (i12 < 0) {
                return;
            }
            int i13 = i10 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i11 + i12]);
        }
    }

    public static void K(byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int i13 = 0;
        do {
            bArr3[i12 + i13] = (byte) (bArr[i10 + i13] ^ bArr2[i11 + i13]);
            int i14 = i13 + 1;
            bArr3[i12 + i14] = (byte) (bArr[i10 + i14] ^ bArr2[i11 + i14]);
            int i15 = i14 + 1;
            bArr3[i12 + i15] = (byte) (bArr[i10 + i15] ^ bArr2[i11 + i15]);
            int i16 = i15 + 1;
            bArr3[i12 + i16] = (byte) (bArr[i10 + i16] ^ bArr2[i11 + i16]);
            i13 = i16 + 1;
        } while (i13 < 16);
    }

    public static void L(byte[] bArr, byte[] bArr2) {
        int i10 = 0;
        do {
            bArr[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            int i11 = i10 + 1;
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            int i12 = i11 + 1;
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i12]);
            int i13 = i12 + 1;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void M(byte[] bArr, byte[] bArr2, int i10) {
        int i11 = 0;
        do {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i10 + i11]);
            int i12 = i11 + 1;
            bArr[i12] = (byte) (bArr[i12] ^ bArr2[i10 + i12]);
            int i13 = i12 + 1;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i10 + i13]);
            int i14 = i13 + 1;
            bArr[i14] = (byte) (bArr[i14] ^ bArr2[i10 + i14]);
            i11 = i14 + 1;
        } while (i11 < 16);
    }

    public static void N(byte[] bArr, byte[] bArr2, int i10, int i11) {
        while (true) {
            i11--;
            if (i11 < 0) {
                return;
            } else {
                bArr[i11] = (byte) (bArr[i11] ^ bArr2[i10 + i11]);
            }
        }
    }

    public static void O(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i10 = 0;
        do {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
            int i11 = i10 + 1;
            bArr3[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
            int i12 = i11 + 1;
            bArr3[i12] = (byte) (bArr[i12] ^ bArr2[i12]);
            int i13 = i12 + 1;
            bArr3[i13] = (byte) (bArr[i13] ^ bArr2[i13]);
            i10 = i13 + 1;
        } while (i10 < 16);
    }

    public static void P(int[] iArr, int[] iArr2) {
        iArr[0] = iArr[0] ^ iArr2[0];
        iArr[1] = iArr[1] ^ iArr2[1];
        iArr[2] = iArr[2] ^ iArr2[2];
        iArr[3] = iArr2[3] ^ iArr[3];
    }

    public static void Q(int[] iArr, int[] iArr2, int[] iArr3) {
        iArr3[0] = iArr[0] ^ iArr2[0];
        iArr3[1] = iArr[1] ^ iArr2[1];
        iArr3[2] = iArr[2] ^ iArr2[2];
        iArr3[3] = iArr[3] ^ iArr2[3];
    }

    public static void R(long[] jArr, long[] jArr2) {
        jArr[0] = jArr[0] ^ jArr2[0];
        jArr[1] = jArr[1] ^ jArr2[1];
    }

    public static void S(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    public static byte a(byte[] bArr, byte[] bArr2) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            i10 |= bArr[i11] ^ bArr2[i11];
        }
        return (byte) ((((i10 >>> 1) | (i10 & 1)) - 1) >> 31);
    }

    public static int b(int[] iArr, int[] iArr2) {
        int i10 = (iArr[3] ^ iArr2[3]) | 0 | (iArr[0] ^ iArr2[0]) | (iArr[1] ^ iArr2[1]) | (iArr2[2] ^ iArr[2]);
        return (((i10 & 1) | (i10 >>> 1)) - 1) >> 31;
    }

    public static long c(long[] jArr, long[] jArr2) {
        long j10 = (jArr2[1] ^ jArr[1]) | (jArr[0] ^ jArr2[0]) | 0;
        return (((j10 & 1) | (j10 >>> 1)) - 1) >> 63;
    }

    public static void d(int[] iArr, byte[] bArr) {
        o.i(iArr, 0, 4, bArr, 0);
    }

    public static void e(long[] jArr, byte[] bArr) {
        o.B(jArr, 0, 2, bArr, 0);
    }

    public static byte[] f(int[] iArr) {
        byte[] bArr = new byte[16];
        o.i(iArr, 0, 4, bArr, 0);
        return bArr;
    }

    public static byte[] g(long[] jArr) {
        byte[] bArr = new byte[16];
        o.B(jArr, 0, 2, bArr, 0);
        return bArr;
    }

    public static void h(byte[] bArr, int[] iArr) {
        o.c(bArr, 0, iArr, 0, 4);
    }

    public static int[] i(byte[] bArr) {
        int[] iArr = new int[4];
        o.c(bArr, 0, iArr, 0, 4);
        return iArr;
    }

    public static void j(byte[] bArr, long[] jArr) {
        o.f(bArr, 0, jArr, 0, 2);
    }

    public static long[] k(byte[] bArr) {
        long[] jArr = new long[2];
        o.f(bArr, 0, jArr, 0, 2);
        return jArr;
    }

    public static void l(byte[] bArr, byte[] bArr2) {
        for (int i10 = 0; i10 < 16; i10++) {
            bArr2[i10] = bArr[i10];
        }
    }

    public static void m(int[] iArr, int[] iArr2) {
        iArr2[0] = iArr[0];
        iArr2[1] = iArr[1];
        iArr2[2] = iArr[2];
        iArr2[3] = iArr[3];
    }

    public static void n(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    public static void o(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j10 >> 63;
        jArr2[0] = ((j10 ^ (f39090e & j12)) << 1) | (j11 >>> 63);
        jArr2[1] = (j11 << 1) | (-j12);
    }

    public static long p(long j10, long j11) {
        long j12 = j10 & 1229782938247303441L;
        long j13 = j10 & 2459565876494606882L;
        long j14 = j10 & 4919131752989213764L;
        long j15 = j10 & (-8608480567731124088L);
        long j16 = j11 & 1229782938247303441L;
        long j17 = j11 & 2459565876494606882L;
        long j18 = j11 & 4919131752989213764L;
        long j19 = j11 & (-8608480567731124088L);
        long j20 = (((j12 * j16) ^ (j13 * j19)) ^ (j14 * j18)) ^ (j15 * j17);
        long j21 = (((j12 * j17) ^ (j13 * j16)) ^ (j14 * j19)) ^ (j15 * j18);
        long j22 = (((j12 * j18) ^ (j13 * j17)) ^ (j14 * j16)) ^ (j15 * j19);
        return (j20 & 1229782938247303441L) | (j21 & 2459565876494606882L) | (j22 & 4919131752989213764L) | (((((j12 * j19) ^ (j13 * j18)) ^ (j14 * j17)) ^ (j15 * j16)) & (-8608480567731124088L));
    }

    public static void q(byte[] bArr, byte[] bArr2) {
        long[] jArrK = k(bArr);
        s(jArrK, k(bArr2));
        e(jArrK, bArr);
    }

    public static void r(int[] iArr, int[] iArr2) {
        int i10 = iArr2[0];
        int i11 = iArr2[1];
        int i12 = iArr2[2];
        int i13 = iArr2[3];
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < 4; i18++) {
            int i19 = iArr[i18];
            for (int i20 = 0; i20 < 32; i20++) {
                int i21 = i19 >> 31;
                i19 <<= 1;
                i14 ^= i10 & i21;
                i15 ^= i11 & i21;
                i16 ^= i12 & i21;
                i17 ^= i21 & i13;
                int i22 = (i13 << 31) >> 8;
                i13 = (i13 >>> 1) | (i12 << 31);
                i12 = (i12 >>> 1) | (i11 << 31);
                i11 = (i11 >>> 1) | (i10 << 31);
                i10 = (i10 >>> 1) ^ (i22 & f39089d);
            }
        }
        iArr[0] = i14;
        iArr[1] = i15;
        iArr[2] = i16;
        iArr[3] = i17;
    }

    public static void s(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = jArr2[0];
        long j13 = jArr2[1];
        long jC = l.c(j10);
        long jC2 = l.c(j11);
        long jC3 = l.c(j12);
        long jC4 = l.c(j13);
        long jC5 = l.c(p(jC, jC3));
        long jP = p(j10, j12) << 1;
        long jC6 = l.c(p(jC2, jC4));
        long jP2 = p(j11, j13) << 1;
        long jC7 = l.c(p(jC ^ jC2, jC3 ^ jC4));
        long jP3 = ((p(j10 ^ j11, j12 ^ j13) << 1) ^ ((jC6 ^ jP) ^ jP2)) ^ ((jP2 << 62) ^ (jP2 << 57));
        jArr[0] = jC5 ^ ((jP3 >>> 7) ^ ((jP3 ^ (jP3 >>> 1)) ^ (jP3 >>> 2)));
        jArr[1] = ((jP3 << 57) ^ ((jP3 << 63) ^ (jP3 << 62))) ^ ((jC7 ^ ((jP ^ jC5) ^ jC6)) ^ (((jP2 ^ (jP2 >>> 1)) ^ (jP2 >>> 2)) ^ (jP2 >>> 7)));
    }

    public static void t(int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        iArr[0] = (((i13 << 31) >> 31) & f39089d) ^ (i10 >>> 1);
        iArr[1] = (i11 >>> 1) | (i10 << 31);
        iArr[2] = (i12 >>> 1) | (i11 << 31);
        iArr[3] = (i13 >>> 1) | (i12 << 31);
    }

    public static void u(int[] iArr, int[] iArr2) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int i12 = iArr[2];
        int i13 = iArr[3];
        iArr2[0] = (((i13 << 31) >> 31) & f39089d) ^ (i10 >>> 1);
        iArr2[1] = (i11 >>> 1) | (i10 << 31);
        iArr2[2] = (i12 >>> 1) | (i11 << 31);
        iArr2[3] = (i13 >>> 1) | (i12 << 31);
    }

    public static void v(long[] jArr) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        jArr[0] = (((j11 << 63) >> 63) & f39090e) ^ (j10 >>> 1);
        jArr[1] = (j10 << 63) | (j11 >>> 1);
    }

    public static void w(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        jArr2[0] = (((j11 << 63) >> 63) & f39090e) ^ (j10 >>> 1);
        jArr2[1] = (j10 << 63) | (j11 >>> 1);
    }

    public static void x(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 << 61;
        jArr2[0] = (j12 >>> 7) ^ ((((j10 >>> 3) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2));
        jArr2[1] = (j10 << 61) | (j11 >>> 3);
    }

    public static void y(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 << 60;
        jArr2[0] = (j12 >>> 7) ^ ((((j10 >>> 4) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2));
        jArr2[1] = (j10 << 60) | (j11 >>> 4);
    }

    public static void z(long[] jArr, long[] jArr2) {
        long j10 = jArr[0];
        long j11 = jArr[1];
        long j12 = j11 << 57;
        jArr2[0] = (j12 >>> 7) ^ ((((j10 >>> 7) ^ j12) ^ (j12 >>> 1)) ^ (j12 >>> 2));
        jArr2[1] = (j10 << 57) | (j11 >>> 7);
    }
}
