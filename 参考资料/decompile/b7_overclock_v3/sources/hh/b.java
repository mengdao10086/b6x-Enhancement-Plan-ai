package hh;

import zc.f;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31292a = System.getProperty("line.separator");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f31293b = new char[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f31294c;

    static {
        char c10 = 'A';
        int i10 = 0;
        while (c10 <= 'Z') {
            f31293b[i10] = c10;
            c10 = (char) (c10 + 1);
            i10++;
        }
        char c11 = 'a';
        while (c11 <= 'z') {
            f31293b[i10] = c11;
            c11 = (char) (c11 + 1);
            i10++;
        }
        char c12 = '0';
        while (c12 <= '9') {
            f31293b[i10] = c12;
            c12 = (char) (c12 + 1);
            i10++;
        }
        char[] cArr = f31293b;
        cArr[i10] = '+';
        cArr[i10 + 1] = f.f58380j;
        f31294c = new byte[128];
        int i11 = 0;
        while (true) {
            byte[] bArr = f31294c;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        for (int i12 = 0; i12 < 64; i12++) {
            f31294c[f31293b[i12]] = (byte) i12;
        }
    }

    public static byte[] a(String str) {
        return b(str.toCharArray());
    }

    public static byte[] b(char[] cArr) {
        return c(cArr, 0, cArr.length);
    }

    public static byte[] c(char[] cArr, int i10, int i11) {
        int i12;
        char c10;
        int i13;
        char c11;
        if (i11 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i11 > 0 && cArr[(i10 + i11) - 1] == '=') {
            i11--;
        }
        int i14 = (i11 * 3) / 4;
        byte[] bArr = new byte[i14];
        int i15 = i11 + i10;
        int i16 = 0;
        while (i10 < i15) {
            int i17 = i10 + 1;
            char c12 = cArr[i10];
            int i18 = i17 + 1;
            char c13 = cArr[i17];
            if (i18 < i15) {
                i12 = i18 + 1;
                c10 = cArr[i18];
            } else {
                i12 = i18;
                c10 = 'A';
            }
            if (i12 < i15) {
                i13 = i12 + 1;
                c11 = cArr[i12];
            } else {
                i13 = i12;
                c11 = 'A';
            }
            if (c12 > 127 || c13 > 127 || c10 > 127 || c11 > 127) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte[] bArr2 = f31294c;
            byte b10 = bArr2[c12];
            byte b11 = bArr2[c13];
            byte b12 = bArr2[c10];
            byte b13 = bArr2[c11];
            if (b10 < 0 || b11 < 0 || b12 < 0 || b13 < 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            int i19 = (b10 << 2) | (b11 >>> 4);
            int i20 = ((b11 & 15) << 4) | (b12 >>> 2);
            int i21 = ((b12 & 3) << 6) | b13;
            int i22 = i16 + 1;
            bArr[i16] = (byte) i19;
            if (i22 < i14) {
                bArr[i22] = (byte) i20;
                i22++;
            }
            if (i22 < i14) {
                bArr[i22] = (byte) i21;
                i16 = i22 + 1;
            } else {
                i16 = i22;
            }
            i10 = i13;
        }
        return bArr;
    }

    public static byte[] d(String str) {
        char[] cArr = new char[str.length()];
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char cCharAt = str.charAt(i11);
            if (cCharAt != ' ' && cCharAt != '\r' && cCharAt != '\n' && cCharAt != '\t') {
                cArr[i10] = cCharAt;
                i10++;
            }
        }
        return c(cArr, 0, i10);
    }

    public static String e(String str) {
        return new String(a(str));
    }

    public static char[] f(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public static char[] g(byte[] bArr, int i10) {
        return h(bArr, 0, i10);
    }

    public static char[] h(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = ((i11 * 4) + 2) / 3;
        char[] cArr = new char[((i11 + 2) / 3) * 4];
        int i16 = i11 + i10;
        int i17 = 0;
        while (i10 < i16) {
            int i18 = i10 + 1;
            int i19 = bArr[i10] & 255;
            if (i18 < i16) {
                i12 = i18 + 1;
                i13 = bArr[i18] & 255;
            } else {
                i12 = i18;
                i13 = 0;
            }
            if (i12 < i16) {
                i14 = bArr[i12] & 255;
                i12++;
            } else {
                i14 = 0;
            }
            int i20 = i19 >>> 2;
            int i21 = ((i19 & 3) << 4) | (i13 >>> 4);
            int i22 = ((i13 & 15) << 2) | (i14 >>> 6);
            int i23 = i14 & 63;
            int i24 = i17 + 1;
            char[] cArr2 = f31293b;
            cArr[i17] = cArr2[i20];
            int i25 = i24 + 1;
            cArr[i24] = cArr2[i21];
            char c10 = '=';
            cArr[i25] = i25 < i15 ? cArr2[i22] : '=';
            int i26 = i25 + 1;
            if (i26 < i15) {
                c10 = cArr2[i23];
            }
            cArr[i26] = c10;
            i17 = i26 + 1;
            i10 = i12;
        }
        return cArr;
    }

    public static String i(byte[] bArr) {
        return j(bArr, 0, bArr.length, 76, f31292a);
    }

    public static String j(byte[] bArr, int i10, int i11, int i12, String str) {
        int i13 = (i12 * 3) / 4;
        if (i13 <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb2 = new StringBuilder((((i11 + 2) / 3) * 4) + ((((i11 + i13) - 1) / i13) * str.length()));
        int i14 = 0;
        while (i14 < i11) {
            int iMin = Math.min(i11 - i14, i13);
            sb2.append(h(bArr, i10 + i14, iMin));
            sb2.append(str);
            i14 += iMin;
        }
        return sb2.toString().trim();
    }

    public static String k(String str) {
        return new String(f(str.getBytes()));
    }
}
