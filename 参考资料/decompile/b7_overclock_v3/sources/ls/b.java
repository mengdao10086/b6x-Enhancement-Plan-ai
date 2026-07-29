package ls;

/* JADX INFO: loaded from: classes6.dex */
public class b {
    public int a(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    public int b(byte[] bArr, int i10) {
        int i11 = i10 + 1;
        int i12 = i11 + 1;
        int i13 = (bArr[i10] & 255) | ((bArr[i11] & 255) << 8);
        int i14 = i12 + 1;
        return ((bArr[i14] & 255) << 24) | i13 | ((bArr[i12] & 255) << 16);
    }

    public byte[] c(byte[][] bArr) {
        byte[] bArr2 = new byte[bArr.length * bArr[0].length];
        int length = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            System.arraycopy(bArr[i10], 0, bArr2, length, bArr[i10].length);
            length += bArr[i10].length;
        }
        return bArr2;
    }

    public int d(int i10) {
        int i11 = 1;
        int i12 = 2;
        while (i12 < i10) {
            i12 <<= 1;
            i11++;
        }
        return i11;
    }

    public byte[] e(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public void f(String str, byte[] bArr) {
        System.out.println(str);
        int i10 = 0;
        for (byte b10 : bArr) {
            System.out.println(i10 + "; " + ((int) b10));
            i10++;
        }
    }

    public void g(String str, byte[][] bArr) {
        System.out.println(str);
        int i10 = 0;
        for (byte[] bArr2 : bArr) {
            for (int i11 = 0; i11 < bArr[0].length; i11++) {
                System.out.println(i10 + "; " + ((int) bArr2[i11]));
                i10++;
            }
        }
    }

    public boolean h(int i10) {
        int i11 = 1;
        while (i11 < i10) {
            i11 <<= 1;
        }
        return i10 == i11;
    }
}
