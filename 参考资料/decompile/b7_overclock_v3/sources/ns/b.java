package ns;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public static short a(int i10, int i11, int i12, int i13) {
        return (short) (((((d(i10) + d(i11)) + d(i12)) + d(i13)) - 98312) >>> 31);
    }

    public static int b(int i10) {
        int i11 = i10 >> 31;
        return (i10 ^ i11) - i11;
    }

    public static int c(int[] iArr, int i10, int i11, int i12) {
        int i13 = (i12 * 2730) >> 25;
        int i14 = i13 - ((12288 - (i12 - (i13 * l.f42666c))) >> 31);
        iArr[i10] = (i14 >> 1) + (i14 & 1);
        int i15 = i14 - 1;
        iArr[i11] = (i15 >> 1) + (i15 & 1);
        return b(i12 - ((iArr[i10] * 2) * l.f42666c));
    }

    public static int d(int i10) {
        int i11 = (i10 * 2730) >> 27;
        int i12 = i11 - ((49155 - (i10 - (49156 * i11))) >> 31);
        return b((((i12 >> 1) + (i12 & 1)) * 98312) - i10);
    }

    public static void e(short[] sArr, short[] sArr2, byte[] bArr, byte b10) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b10;
        byte[] bArr3 = new byte[32];
        a.a(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 + 0;
            int i12 = ((bArr3[i10 >>> 3] >>> (i10 & 7)) & 1) * 4;
            int i13 = i10 + 256;
            int i14 = i10 + 512;
            int i15 = i10 + 768;
            int iC = (24577 - (((c(iArr, 0, 4, (sArr2[i11] * 8) + i12) + c(iArr, 1, 5, (sArr2[i13] * 8) + i12)) + c(iArr, 2, 6, (sArr2[i14] * 8) + i12)) + c(iArr, 3, 7, (sArr2[i15] * 8) + i12))) >> 31;
            int i16 = ~iC;
            iArr2[0] = (i16 & iArr[0]) ^ (iC & iArr[4]);
            iArr2[1] = (i16 & iArr[1]) ^ (iC & iArr[5]);
            iArr2[2] = (i16 & iArr[2]) ^ (iC & iArr[6]);
            iArr2[3] = (i16 & iArr[3]) ^ (iArr[7] & iC);
            sArr[i11] = (short) ((iArr2[0] - iArr2[3]) & 3);
            sArr[i13] = (short) ((iArr2[1] - iArr2[3]) & 3);
            sArr[i14] = (short) ((iArr2[2] - iArr2[3]) & 3);
            sArr[i15] = (short) (3 & ((-iC) + (iArr2[3] * 2)));
        }
    }

    public static void f(byte[] bArr, short[] sArr, short[] sArr2) {
        org.bouncycastle.util.a.d0(bArr, (byte) 0);
        int[] iArr = new int[4];
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 + 0;
            int i12 = i10 + 768;
            iArr[0] = ((sArr[i11] * 8) + 196624) - (((sArr2[i11] * 2) + sArr2[i12]) * l.f42666c);
            int i13 = i10 + 256;
            iArr[1] = ((sArr[i13] * 8) + 196624) - (((sArr2[i13] * 2) + sArr2[i12]) * l.f42666c);
            int i14 = i10 + 512;
            iArr[2] = ((sArr[i14] * 8) + 196624) - (((sArr2[i14] * 2) + sArr2[i12]) * l.f42666c);
            iArr[3] = ((sArr[i12] * 8) + 196624) - (sArr2[i12] * 12289);
            int i15 = i10 >>> 3;
            bArr[i15] = (byte) ((a(iArr[0], iArr[1], iArr[2], iArr[3]) << (i10 & 7)) | bArr[i15]);
        }
    }
}
