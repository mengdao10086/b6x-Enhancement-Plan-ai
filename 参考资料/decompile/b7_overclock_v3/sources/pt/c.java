package pt;

import et.e;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import zc.f;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f47063a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String b(String str) {
        try {
            return URLDecoder.decode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String c(String str, String str2, String str3) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes(str3));
            return i(messageDigest.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String d(String str, int i10) {
        return e(str, i10, "...");
    }

    public static String e(String str, int i10, String str2) {
        if (str == null || str.length() <= i10) {
            return str;
        }
        return str.substring(0, i10 - str2.length()) + str2;
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static String g(String str) {
        try {
            return URLEncoder.encode(str, "ISO-8859-1");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static List<String> h(String str, String str2) {
        String[] strArrT = t(str, true);
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrT) {
            if (str3.contains(str2)) {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    public static String i(byte[] bArr) {
        int length = bArr.length * 2;
        char[] cArr = new char[length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            int i13 = bArr[i11] & 255;
            int i14 = i10 + 1;
            char[] cArr2 = f47063a;
            cArr[i10] = cArr2[i13 >>> 4];
            i10 = i14 + 1;
            cArr[i14] = cArr2[i13 & 15];
            i11 = i12;
        }
        return new String(cArr);
    }

    public static String j(Iterable<?> iterable, String str) {
        if (iterable == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<?> it2 = iterable.iterator();
        char cCharAt = str.length() == 1 ? str.charAt(0) : (char) 0;
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                if (cCharAt != 0) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append(str);
                }
            }
        }
        return sb2.toString();
    }

    public static String k(int[] iArr, String str) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(Math.max(16, (str.length() + 1) * iArr.length));
        char cCharAt = str.length() == 1 ? str.charAt(0) : (char) 0;
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 != 0) {
                if (cCharAt != 0) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append(str);
                }
            }
            sb2.append(iArr[i10]);
        }
        return sb2.toString();
    }

    public static String l(String[] strArr, String str) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(Math.max(16, (str.length() + 1) * strArr.length));
        char cCharAt = str.length() == 1 ? str.charAt(0) : (char) 0;
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (i10 != 0) {
                if (cCharAt != 0) {
                    sb2.append(cCharAt);
                } else {
                    sb2.append(str);
                }
            }
            sb2.append(strArr[i10]);
        }
        return sb2.toString();
    }

    public static String m(String str) {
        return c(str, "MD5", "UTF-8");
    }

    public static byte[] n(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Illegal string length: " + length);
        }
        int i10 = length / 2;
        byte[] bArr = new byte[i10];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int i13 = i12 + 1;
            bArr[i11] = (byte) ((o(str.charAt(i12)) << 4) | o(str.charAt(i13)));
            i11++;
            i12 = i13 + 1;
        }
        return bArr;
    }

    public static int o(char c10) {
        if ('0' <= c10 && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'A';
        if ('A' > c10 || c10 > 'F') {
            c11 = 'a';
            if ('a' > c10 || c10 > 'f') {
                throw new IllegalArgumentException("Illegal hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    public static String p(String str) {
        return (str.length() <= 1 || str.charAt(0) != '#') ? str.equals("apos") ? "'" : str.equals("quot") ? "\"" : str.equals(f.f58385o) ? ">" : str.equals(f.f58384n) ? "<" : str.equals(f.f58386p) ? "&" : str : str.charAt(1) == 'x' ? String.valueOf((char) Integer.parseInt(str.substring(2), 16)) : String.valueOf((char) Integer.parseInt(str.substring(1)));
    }

    public static String q(String str) {
        return c(str, e.f27137f, "UTF-8");
    }

    public static String r(String str) {
        return c(str, "SHA-256", "UTF-8");
    }

    public static String[] s(String str, char c10) {
        String[] strArr = new String[32];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int iIndexOf = str.indexOf(c10, i10);
            if (iIndexOf == -1) {
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, i11 + 1);
                strArr2[i11] = str.substring(i10);
                return strArr2;
            }
            if (i11 == strArr.length) {
                strArr = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            }
            strArr[i11] = str.substring(i10, iIndexOf);
            i10 = iIndexOf + 1;
            i11++;
        }
    }

    public static String[] t(String str, boolean z10) {
        return z10 ? str.split("[\n\r]+") : str.split("\\r?\\n");
    }
}
