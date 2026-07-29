package ft;

/* JADX INFO: loaded from: classes6.dex */
public final class v {
    public static void a(int i10, byte[] bArr, int i11) {
        int i12 = i11 + 1;
        bArr[i11] = (byte) i10;
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i10 >>> 8);
        bArr[i13] = (byte) (i10 >>> 16);
        bArr[i13 + 1] = (byte) (i10 >>> 24);
    }

    public static void b(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= 0; i13--) {
            bArr[i11 + i13] = (byte) (i10 >>> (i13 * 8));
        }
    }

    public static void c(long j10, byte[] bArr, int i10) {
        int i11 = i10 + 1;
        bArr[i10] = (byte) j10;
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j10 >>> 8);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j10 >>> 16);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j10 >>> 24);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j10 >>> 32);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (j10 >>> 40);
        bArr[i16] = (byte) (j10 >>> 48);
        bArr[i16 + 1] = (byte) (j10 >>> 56);
    }

    public static byte[] d(int i10) {
        return new byte[]{(byte) i10, (byte) (i10 >>> 8), (byte) (i10 >>> 16), (byte) (i10 >>> 24)};
    }

    public static byte[] e(long j10) {
        return new byte[]{(byte) j10, (byte) (j10 >>> 8), (byte) (j10 >>> 16), (byte) (j10 >>> 24), (byte) (j10 >>> 32), (byte) (j10 >>> 40), (byte) (j10 >>> 48), (byte) (j10 >>> 56)};
    }

    public static int f(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public static int g(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        int i14 = i12 + 1;
        return ((bArr[i14] & 255) << 24) | i13 | ((bArr[i12] & 255) << 16);
    }

    public static int h(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            i12 |= (bArr[i10 + i13] & 255) << (i13 * 8);
        }
        return i12;
    }

    public static long i(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        long j10 = bArr[i10] & 255;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((long) ((bArr[i11] & 255) << 8)) | ((long) ((bArr[i12] & 255) << 16));
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        long j14 = j13 | ((((long) bArr[i15]) & 255) << 40);
        return ((((long) bArr[i16 + 1]) & 255) << 56) | j14 | ((((long) bArr[i16]) & 255) << 48);
    }

    public static byte[] j(int[] iArr, int i10) {
        int length = iArr.length;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        while (i11 <= length - 2) {
            a(iArr[i11], bArr, i12);
            i11++;
            i12 += 4;
        }
        b(iArr[length - 1], bArr, i12, i10 - i12);
        return bArr;
    }

    public static int[] k(byte[] bArr) {
        int length = (bArr.length + 3) / 4;
        int length2 = bArr.length & 3;
        int[] iArr = new int[length];
        int i10 = 0;
        int i11 = 0;
        while (i10 <= length - 2) {
            iArr[i10] = g(bArr, i11);
            i10++;
            i11 += 4;
        }
        int i12 = length - 1;
        if (length2 != 0) {
            iArr[i12] = h(bArr, i11, length2);
        } else {
            iArr[i12] = g(bArr, i11);
        }
        return iArr;
    }
}
