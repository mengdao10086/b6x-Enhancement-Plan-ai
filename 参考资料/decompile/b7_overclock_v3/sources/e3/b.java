package e3;

import com.blankj.utilcode.util.i0;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase() + i0.f11861z);
        }
        return stringBuffer.toString();
    }

    public static byte b(char c10) {
        return (byte) "0123456789ABCDEF".indexOf(c10);
    }

    public static byte[] c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length() / 2;
        char[] charArray = upperCase.toCharArray();
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (b(charArray[i11 + 1]) | (b(charArray[i11]) << 4));
        }
        return bArr;
    }

    public static String d(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        String strReplace = str.replace(i0.f11861z, "");
        int length = strReplace.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            try {
                bArr[i10] = (byte) (Integer.parseInt(strReplace.substring(i11, i11 + 2), 16) & 255);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        try {
            return new String(bArr, "gbk");
        } catch (Exception e11) {
            e11.printStackTrace();
            return strReplace;
        }
    }

    public static byte[] e(@n0 String str) {
        if (str != null) {
            char[] cArr = new char[1000];
            char[] charArray = str.toCharArray();
            int i10 = 0;
            for (int i11 = 0; i11 < charArray.length; i11++) {
                if (charArray[i11] != ' ') {
                    cArr[i10] = charArray[i11];
                    i10++;
                }
            }
            int i12 = i10 % 2 == 0 ? i10 : i10 + 1;
            if (i12 != 0) {
                int[] iArr = new int[i12];
                iArr[i12 - 1] = 0;
                for (int i13 = 0; i13 < i10; i13++) {
                    if (cArr[i13] >= '0' && cArr[i13] <= '9') {
                        iArr[i13] = cArr[i13] - '0';
                    } else if (cArr[i13] >= 'a' && cArr[i13] <= 'f') {
                        iArr[i13] = (cArr[i13] - 'a') + 10;
                    } else if (cArr[i13] >= 'A' && cArr[i13] <= 'F') {
                        iArr[i13] = (cArr[i13] - 'A') + 10;
                    }
                }
                int i14 = i12 / 2;
                byte[] bArr = new byte[i14];
                for (int i15 = 0; i15 < i14; i15++) {
                    int i16 = i15 * 2;
                    bArr[i15] = (byte) ((iArr[i16] * 16) + iArr[i16 + 1]);
                }
                return bArr;
            }
        }
        return new byte[0];
    }

    public static String f(String str) {
        String str2 = "";
        for (int i10 = 0; i10 < str.length(); i10++) {
            str2 = str2 + Integer.toHexString(str.charAt(i10));
        }
        return str2;
    }
}
