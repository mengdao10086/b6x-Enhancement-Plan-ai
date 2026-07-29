package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public abstract class o {
    public static void A(long j10, byte[] bArr, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            bArr[i12 + i10] = (byte) (255 & j10);
            j10 >>>= 8;
        }
    }

    public static void B(long[] jArr, int i10, int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            z(jArr[i10 + i13], bArr, i12);
            i12 += 8;
        }
    }

    public static void C(long[] jArr, byte[] bArr, int i10) {
        for (long j10 : jArr) {
            z(j10, bArr, i10);
            i10 += 8;
        }
    }

    public static byte[] D(long j10) {
        byte[] bArr = new byte[8];
        z(j10, bArr, 0);
        return bArr;
    }

    public static byte[] E(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        C(jArr, bArr, 0);
        return bArr;
    }

    public static void F(long j10, byte[] bArr, int i10) {
        m((int) (4294967295L & j10), bArr, i10);
        m((int) (j10 >>> 32), bArr, i10 + 4);
    }

    public static void G(long[] jArr, int i10, int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            F(jArr[i10 + i13], bArr, i12);
            i12 += 8;
        }
    }

    public static void H(long[] jArr, byte[] bArr, int i10) {
        for (long j10 : jArr) {
            F(j10, bArr, i10);
            i10 += 8;
        }
    }

    public static byte[] I(long j10) {
        byte[] bArr = new byte[8];
        F(j10, bArr, 0);
        return bArr;
    }

    public static byte[] J(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        H(jArr, bArr, 0);
        return bArr;
    }

    public static void K(short s10, byte[] bArr, int i10) {
        bArr[i10] = (byte) (s10 >>> 8);
        bArr[i10 + 1] = (byte) s10;
    }

    public static byte[] L(short s10) {
        byte[] bArr = new byte[2];
        K(s10, bArr, 0);
        return bArr;
    }

    public static void M(short s10, byte[] bArr, int i10) {
        bArr[i10] = (byte) s10;
        bArr[i10 + 1] = (byte) (s10 >>> 8);
    }

    public static byte[] N(short s10) {
        byte[] bArr = new byte[2];
        M(s10, bArr, 0);
        return bArr;
    }

    public static int a(byte[] bArr, int i10) {
        int i11 = bArr[i10] << 24;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 16);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] & 255) | i13 | ((bArr[i14] & 255) << 8);
    }

    public static void b(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = a(bArr, i10);
            i10 += 4;
        }
    }

    public static void c(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = a(bArr, i10);
            i10 += 4;
        }
    }

    public static long d(byte[] bArr, int i10) {
        int iA = a(bArr, i10);
        return (((long) a(bArr, i10 + 4)) & 4294967295L) | ((((long) iA) & 4294967295L) << 32);
    }

    public static void e(byte[] bArr, int i10, long[] jArr) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = d(bArr, i10);
            i10 += 8;
        }
    }

    public static void f(byte[] bArr, int i10, long[] jArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            jArr[i11 + i13] = d(bArr, i10);
            i10 += 8;
        }
    }

    public static short g(byte[] bArr, int i10) {
        return (short) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    public static void h(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >>> 24);
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public static void i(int[] iArr, int i10, int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            h(iArr[i10 + i13], bArr, i12);
            i12 += 4;
        }
    }

    public static void j(int[] iArr, byte[] bArr, int i10) {
        for (int i11 : iArr) {
            h(i11, bArr, i10);
            i10 += 4;
        }
    }

    public static byte[] k(int i10) {
        byte[] bArr = new byte[4];
        h(i10, bArr, 0);
        return bArr;
    }

    public static byte[] l(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        j(iArr, bArr, 0);
        return bArr;
    }

    public static void m(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void n(int[] iArr, int i10, int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < i11; i13++) {
            m(iArr[i10 + i13], bArr, i12);
            i12 += 4;
        }
    }

    public static void o(int[] iArr, byte[] bArr, int i10) {
        for (int i11 : iArr) {
            m(i11, bArr, i10);
            i10 += 4;
        }
    }

    public static byte[] p(int i10) {
        byte[] bArr = new byte[4];
        m(i10, bArr, 0);
        return bArr;
    }

    public static byte[] q(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        o(iArr, bArr, 0);
        return bArr;
    }

    public static int r(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void s(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = r(bArr, i10);
            i10 += 4;
        }
    }

    public static void t(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = r(bArr, i10);
            i10 += 4;
        }
    }

    public static int[] u(byte[] bArr, int i10, int i11) {
        int[] iArr = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i12] = r(bArr, i10);
            i10 += 4;
        }
        return iArr;
    }

    public static long v(byte[] bArr, int i10) {
        return ((((long) r(bArr, i10 + 4)) & 4294967295L) << 32) | (((long) r(bArr, i10)) & 4294967295L);
    }

    public static void w(byte[] bArr, int i10, long[] jArr) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = v(bArr, i10);
            i10 += 8;
        }
    }

    public static void x(byte[] bArr, int i10, long[] jArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            jArr[i11 + i13] = v(bArr, i10);
            i10 += 8;
        }
    }

    public static short y(byte[] bArr, int i10) {
        return (short) (((bArr[i10 + 1] & 255) << 8) | (bArr[i10] & 255));
    }

    public static void z(long j10, byte[] bArr, int i10) {
        h((int) (j10 >>> 32), bArr, i10);
        h((int) (j10 & 4294967295L), bArr, i10 + 4);
    }
}
