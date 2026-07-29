package zo;

/* JADX INFO: loaded from: classes5.dex */
public class r0 {
    public static byte[] a(byte b10) {
        return org.bouncycastle.util.a.B(c(8L), new byte[]{b10});
    }

    public static byte[] b(byte[] bArr, int i10, int i11) {
        return bArr.length == i11 ? org.bouncycastle.util.a.B(c(i11 * 8), bArr) : org.bouncycastle.util.a.B(c(i11 * 8), org.bouncycastle.util.a.W(bArr, i10, i11 + i10));
    }

    public static byte[] c(long j10) {
        byte b10 = 1;
        long j11 = j10;
        while (true) {
            j11 >>= 8;
            if (j11 == 0) {
                break;
            }
            b10 = (byte) (b10 + 1);
        }
        byte[] bArr = new byte[b10 + 1];
        bArr[0] = b10;
        for (int i10 = 1; i10 <= b10; i10++) {
            bArr[i10] = (byte) (j10 >> ((b10 - i10) * 8));
        }
        return bArr;
    }

    public static byte[] d(long j10) {
        byte b10 = 1;
        long j11 = j10;
        while (true) {
            j11 >>= 8;
            if (j11 == 0) {
                break;
            }
            b10 = (byte) (b10 + 1);
        }
        byte[] bArr = new byte[b10 + 1];
        bArr[b10] = b10;
        for (int i10 = 0; i10 < b10; i10++) {
            bArr[i10] = (byte) (j10 >> (((b10 - i10) - 1) * 8));
        }
        return bArr;
    }
}
