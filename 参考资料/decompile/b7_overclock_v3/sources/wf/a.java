package wf;

import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                sb2.append(0);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    public static int b(byte[] bArr) {
        return ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    public static String c(byte[] bArr) {
        int[] iArr = new int[4];
        String str = "";
        if (bArr.length == 4) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                iArr[i10] = bArr[i10] & 255;
                String str2 = str + iArr[i10];
                if (i10 < 3) {
                    str2 = str2 + j3.b.f36044h;
                }
                str = str2;
            }
        }
        return str;
    }

    public static byte d(byte[] bArr, int i10) {
        byte b10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            b10 = (byte) (b10 ^ bArr[i11]);
        }
        return b10;
    }

    public static boolean e(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null || bArr2.length == 0 || bArr == bArr2) {
            return true;
        }
        return new String(bArr).contains(new String(bArr2));
    }

    public static long f(byte[] bArr, int i10, int i11) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i10, i11);
        return crc32.getValue();
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return bArr2;
    }

    public static byte[] h(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[(length - i10) - 1] = (byte) (m(charArray[i11 + 1]) | (m(charArray[i11]) << 4));
        }
        return bArr;
    }

    public static byte[] i(int i10) {
        return new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 24) & 255)};
    }

    public static boolean j(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2 == null;
        }
        if (bArr2 == null) {
            return true;
        }
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr2.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public static String l(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append((char) b10);
        }
        return stringBuffer.toString();
    }

    public static int m(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    public static byte[] n(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        String strReplace = str.replace(ag.c.f654g, "");
        if (strReplace == null || strReplace.trim().equals("")) {
            return new byte[0];
        }
        byte[] bArr = new byte[strReplace.length() / 2];
        for (int i10 = 0; i10 < strReplace.length() / 2; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) Integer.parseInt(strReplace.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    public static String o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b10)));
            stringBuffer.append(ag.c.f654g);
        }
        return stringBuffer.toString();
    }
}
