package ft;

import com.blankj.utilcode.util.i0;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f28754a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] c(byte[][] bArr) {
        int length = bArr[0].length;
        byte[] bArr2 = new byte[bArr.length * length];
        int i10 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i10, length);
            i10 += length;
        }
        return bArr2;
    }

    public static int d(byte[] bArr) {
        int i10 = 1;
        for (byte b10 : bArr) {
            i10 = (i10 * 31) + b10;
        }
        return i10;
    }

    public static int e(byte[][] bArr) {
        int iD = 1;
        for (byte[] bArr2 : bArr) {
            iD = (iD * 31) + d(bArr2);
        }
        return iD;
    }

    public static int f(byte[][][] bArr) {
        int iE = 1;
        for (byte[][] bArr2 : bArr) {
            iE = (iE * 31) + e(bArr2);
        }
        return iE;
    }

    public static boolean g(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        boolean z10 = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            z10 &= bArr[length] == bArr2[length];
        }
        return z10;
    }

    public static boolean h(byte[][] bArr, byte[][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean zG = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            zG &= g(bArr[length], bArr2[length]);
        }
        return zG;
    }

    public static boolean i(byte[][][] bArr, byte[][][] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        boolean zG = true;
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length].length != bArr2[length].length) {
                return false;
            }
            for (int length2 = bArr[length].length - 1; length2 >= 0; length2--) {
                zG &= g(bArr[length][length2], bArr2[length][length2]);
            }
        }
        return zG;
    }

    public static byte[] j(String str) {
        char[] charArray = str.toUpperCase().toCharArray();
        int i10 = 0;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if ((charArray[i11] >= '0' && charArray[i11] <= '9') || (charArray[i11] >= 'A' && charArray[i11] <= 'F')) {
                i10++;
            }
        }
        byte[] bArr = new byte[(i10 + 1) >> 1];
        int i12 = i10 & 1;
        for (int i13 = 0; i13 < charArray.length; i13++) {
            if (charArray[i13] >= '0' && charArray[i13] <= '9') {
                int i14 = i12 >> 1;
                bArr[i14] = (byte) (bArr[i14] << 4);
                bArr[i14] = (byte) (bArr[i14] | (charArray[i13] - '0'));
            } else if (charArray[i13] >= 'A' && charArray[i13] <= 'F') {
                int i15 = i12 >> 1;
                bArr[i15] = (byte) (bArr[i15] << 4);
                bArr[i15] = (byte) (bArr[i15] | ((charArray[i13] - 'A') + 10));
            }
            i12++;
        }
        return bArr;
    }

    public static byte[][] k(byte[] bArr, int i10) throws ArrayIndexOutOfBoundsException {
        if (i10 > bArr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        byte[][] bArr2 = {new byte[i10], new byte[bArr.length - i10]};
        System.arraycopy(bArr, 0, bArr2[0], 0, i10);
        System.arraycopy(bArr, i10, bArr2[1], 0, bArr.length - i10);
        return bArr2;
    }

    public static byte[] l(byte[] bArr, int i10) {
        return m(bArr, i10, bArr.length);
    }

    public static byte[] m(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        byte[] bArr2 = new byte[i12];
        System.arraycopy(bArr, i10, bArr2, 0, i12);
        return bArr2;
    }

    public static String n(byte[] bArr) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            byte b10 = bArr[i10];
            for (int i11 = 0; i11 < 8; i11++) {
                str = str + ((b10 >>> i11) & 1);
            }
            if (i10 != bArr.length - 1) {
                str = str + i0.f11861z;
            }
        }
        return str;
    }

    public static char[] o(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            cArr[i10] = (char) bArr[i10];
        }
        return cArr;
    }

    public static String p(byte[] bArr) {
        String str = "";
        for (int i10 = 0; i10 < bArr.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            char[] cArr = f28754a;
            sb2.append(cArr[(bArr[i10] >>> 4) & 15]);
            str = sb2.toString() + cArr[bArr[i10] & 15];
        }
        return str;
    }

    public static String q(byte[] bArr, String str, String str2) {
        String str3 = new String(str);
        for (int i10 = 0; i10 < bArr.length; i10++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            char[] cArr = f28754a;
            sb2.append(cArr[(bArr[i10] >>> 4) & 15]);
            str3 = sb2.toString() + cArr[bArr[i10] & 15];
            if (i10 < bArr.length - 1) {
                str3 = str3 + str2;
            }
        }
        return str3;
    }

    public static byte[] r(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length];
        for (int length = bArr.length - 1; length >= 0; length--) {
            bArr3[length] = (byte) (bArr[length] ^ bArr2[length]);
        }
        return bArr3;
    }
}
