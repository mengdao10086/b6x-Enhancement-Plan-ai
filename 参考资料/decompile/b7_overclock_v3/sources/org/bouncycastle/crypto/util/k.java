package org.bouncycastle.crypto.util;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k {
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

    public static long c(byte[] bArr, int i10) {
        int iA = a(bArr, i10);
        return (((long) a(bArr, i10 + 4)) & 4294967295L) | ((((long) iA) & 4294967295L) << 32);
    }

    public static void d(byte[] bArr, int i10, long[] jArr) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = c(bArr, i10);
            i10 += 8;
        }
    }

    public static void e(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) (i10 >>> 24);
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 16);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 8);
        bArr[i13 + 1] = (byte) i10;
    }

    public static void f(int[] iArr, byte[] bArr, int i10) {
        for (int i11 : iArr) {
            e(i11, bArr, i10);
            i10 += 4;
        }
    }

    public static byte[] g(int i10) {
        byte[] bArr = new byte[4];
        e(i10, bArr, 0);
        return bArr;
    }

    public static byte[] h(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        f(iArr, bArr, 0);
        return bArr;
    }

    public static void i(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        int i12 = i11 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        int i13 = i12 + 1;
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void j(int[] iArr, byte[] bArr, int i10) {
        for (int i11 : iArr) {
            i(i11, bArr, i10);
            i10 += 4;
        }
    }

    public static byte[] k(int i10) {
        byte[] bArr = new byte[4];
        i(i10, bArr, 0);
        return bArr;
    }

    public static byte[] l(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        j(iArr, bArr, 0);
        return bArr;
    }

    public static int m(byte[] bArr, int i10) {
        int i11 = bArr[i10] & 255;
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i12] & 255) << 8);
        int i14 = i12 + 1;
        return (bArr[i14 + 1] << 24) | i13 | ((bArr[i14] & 255) << 16);
    }

    public static void n(byte[] bArr, int i10, int[] iArr) {
        for (int i11 = 0; i11 < iArr.length; i11++) {
            iArr[i11] = m(bArr, i10);
            i10 += 4;
        }
    }

    public static void o(byte[] bArr, int i10, int[] iArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            iArr[i11 + i13] = m(bArr, i10);
            i10 += 4;
        }
    }

    public static long p(byte[] bArr, int i10) {
        return ((((long) m(bArr, i10 + 4)) & 4294967295L) << 32) | (((long) m(bArr, i10)) & 4294967295L);
    }

    public static void q(byte[] bArr, int i10, long[] jArr) {
        for (int i11 = 0; i11 < jArr.length; i11++) {
            jArr[i11] = p(bArr, i10);
            i10 += 8;
        }
    }

    public static void r(long j10, byte[] bArr, int i10) {
        e((int) (j10 >>> 32), bArr, i10);
        e((int) (j10 & 4294967295L), bArr, i10 + 4);
    }

    public static void s(long[] jArr, byte[] bArr, int i10) {
        for (long j10 : jArr) {
            r(j10, bArr, i10);
            i10 += 8;
        }
    }

    public static byte[] t(long j10) {
        byte[] bArr = new byte[8];
        r(j10, bArr, 0);
        return bArr;
    }

    public static byte[] u(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        s(jArr, bArr, 0);
        return bArr;
    }

    public static void v(long j10, byte[] bArr, int i10) {
        i((int) (4294967295L & j10), bArr, i10);
        i((int) (j10 >>> 32), bArr, i10 + 4);
    }

    public static void w(long[] jArr, byte[] bArr, int i10) {
        for (long j10 : jArr) {
            v(j10, bArr, i10);
            i10 += 8;
        }
    }

    public static byte[] x(long j10) {
        byte[] bArr = new byte[8];
        v(j10, bArr, 0);
        return bArr;
    }

    public static byte[] y(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        w(jArr, bArr, 0);
        return bArr;
    }
}
