package fp;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f28636a = {rc.a.f48414f0, 47, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, jt.l.f36951s, 81, 82, 83, 84, 85, 86, 87, o5.b.f42741j, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, pq.b.f46992i, pq.b.f46991h, pq.b.f46994k, pq.b.f46993j, 114, 115, 116, 117, 118, 119, tc.a.f51065w, 121, 122, jt.l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f28637b = new byte[128];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f28638c = "2y";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f28639d;

    static {
        HashSet hashSet = new HashSet();
        f28639d = hashSet;
        hashSet.add("2");
        hashSet.add("2x");
        hashSet.add("2a");
        hashSet.add(f28638c);
        hashSet.add("2b");
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = f28637b;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = f28636a;
            if (i10 >= bArr2.length) {
                return;
            }
            f28637b[bArr2[i10]] = (byte) i10;
            i10++;
        }
    }

    public static boolean a(String str, byte[] bArr) {
        if (bArr != null) {
            return e(str, org.bouncycastle.util.a.p(bArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    public static boolean b(String str, char[] cArr) {
        if (cArr != null) {
            return e(str, Strings.n(cArr));
        }
        throw new IllegalArgumentException("Missing password.");
    }

    public static String c(String str, byte[] bArr, byte[] bArr2, int i10) {
        String string;
        if (!f28639d.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        }
        StringBuilder sb2 = new StringBuilder(60);
        sb2.append('$');
        sb2.append(str);
        sb2.append('$');
        if (i10 < 10) {
            string = "0" + i10;
        } else {
            string = Integer.toString(i10);
        }
        sb2.append(string);
        sb2.append('$');
        g(sb2, bArr2);
        g(sb2, b.e(bArr, bArr2, i10));
        return sb2.toString();
    }

    public static byte[] d(String str) {
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        if (charArray.length != 22) {
            throw new DataLengthException("Invalid base64 salt length: " + charArray.length + " , 22 required.");
        }
        for (char c10 : charArray) {
            if (c10 > 'z' || c10 < '.' || (c10 > '9' && c10 < 'A')) {
                throw new IllegalArgumentException("Salt string contains invalid character: " + ((int) c10));
            }
        }
        char[] cArr = new char[24];
        System.arraycopy(charArray, 0, cArr, 0, charArray.length);
        for (int i10 = 0; i10 < 24; i10 += 4) {
            byte[] bArr = f28637b;
            byte b10 = bArr[cArr[i10]];
            byte b11 = bArr[cArr[i10 + 1]];
            byte b12 = bArr[cArr[i10 + 2]];
            byte b13 = bArr[cArr[i10 + 3]];
            byteArrayOutputStream.write((b10 << 2) | (b11 >> 4));
            byteArrayOutputStream.write((b11 << 4) | (b12 >> 2));
            byteArrayOutputStream.write(b13 | (b12 << 6));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byte[] bArr2 = new byte[16];
        System.arraycopy(byteArray, 0, bArr2, 0, 16);
        return bArr2;
    }

    public static boolean e(String str, byte[] bArr) {
        String strSubstring;
        if (str == null) {
            throw new IllegalArgumentException("Missing bcryptString.");
        }
        if (str.charAt(1) != '2') {
            throw new IllegalArgumentException("not a Bcrypt string");
        }
        int length = str.length();
        if (length != 60 && (length != 59 || str.charAt(2) != '$')) {
            throw new DataLengthException("Bcrypt String length: " + length + ", 60 required.");
        }
        int i10 = 3;
        if (str.charAt(2) == '$') {
            if (str.charAt(0) != '$' || str.charAt(5) != '$') {
                throw new IllegalArgumentException("Invalid Bcrypt String format.");
            }
        } else if (str.charAt(0) != '$' || str.charAt(3) != '$' || str.charAt(6) != '$') {
            throw new IllegalArgumentException("Invalid Bcrypt String format.");
        }
        if (str.charAt(2) == '$') {
            strSubstring = str.substring(1, 2);
        } else {
            strSubstring = str.substring(1, 3);
            i10 = 4;
        }
        if (!f28639d.contains(strSubstring)) {
            throw new IllegalArgumentException("Bcrypt version '" + strSubstring + "' is not supported by this implementation");
        }
        String strSubstring2 = str.substring(i10, i10 + 2);
        try {
            int i11 = Integer.parseInt(strSubstring2);
            if (i11 >= 4 && i11 <= 31) {
                return Strings.b(str, f(strSubstring, bArr, d(str.substring(str.lastIndexOf(36) + 1, length - 31)), i11));
            }
            throw new IllegalArgumentException("Invalid cost factor: " + i11 + ", 4 < cost < 31 expected.");
        } catch (NumberFormatException unused) {
            throw new IllegalArgumentException("Invalid cost factor: " + strSubstring2);
        }
    }

    public static String f(String str, byte[] bArr, byte[] bArr2, int i10) {
        if (!f28639d.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        }
        if (bArr2 == null) {
            throw new IllegalArgumentException("Salt required.");
        }
        if (bArr2.length != 16) {
            throw new DataLengthException("16 byte salt required: " + bArr2.length);
        }
        if (i10 < 4 || i10 > 31) {
            throw new IllegalArgumentException("Invalid cost factor.");
        }
        int length = bArr.length < 72 ? bArr.length + 1 : 72;
        byte[] bArr3 = new byte[length];
        if (length > bArr.length) {
            length = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr3, 0, length);
        org.bouncycastle.util.a.d0(bArr, (byte) 0);
        String strC = c(str, bArr3, bArr2, i10);
        org.bouncycastle.util.a.d0(bArr3, (byte) 0);
        return strC;
    }

    public static void g(StringBuilder sb2, byte[] bArr) {
        boolean z10;
        if (bArr.length != 24 && bArr.length != 16) {
            throw new DataLengthException("Invalid length: " + bArr.length + ", 24 for key or 16 for salt expected");
        }
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[18];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr = bArr2;
            z10 = true;
        } else {
            bArr[bArr.length - 1] = 0;
            z10 = false;
        }
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int i11 = bArr[i10] & 255;
            int i12 = bArr[i10 + 1] & 255;
            int i13 = bArr[i10 + 2] & 255;
            byte[] bArr3 = f28636a;
            sb2.append((char) bArr3[(i11 >>> 2) & 63]);
            sb2.append((char) bArr3[((i11 << 4) | (i12 >>> 4)) & 63]);
            sb2.append((char) bArr3[((i12 << 2) | (i13 >>> 6)) & 63]);
            sb2.append((char) bArr3[i13 & 63]);
        }
        int length2 = sb2.length();
        sb2.setLength(z10 ? length2 - 2 : length2 - 1);
    }

    public static String h(String str, byte[] bArr, byte[] bArr2, int i10) {
        if (bArr != null) {
            return f(str, org.bouncycastle.util.a.p(bArr), bArr2, i10);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String i(String str, char[] cArr, byte[] bArr, int i10) {
        if (cArr != null) {
            return f(str, Strings.n(cArr), bArr, i10);
        }
        throw new IllegalArgumentException("Password required.");
    }

    public static String j(byte[] bArr, byte[] bArr2, int i10) {
        return h(f28638c, bArr, bArr2, i10);
    }

    public static String k(char[] cArr, byte[] bArr, int i10) {
        return i(f28638c, cArr, bArr, i10);
    }
}
