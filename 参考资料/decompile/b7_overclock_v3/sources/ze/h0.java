package ze;

import com.google.zxing.BarcodeFormat;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class h0 extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58503g = Pattern.compile("[IOQ]");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f58504h = Pattern.compile("[A-Z0-9]{17}");

    public static char q(int i10) {
        if (i10 < 10) {
            return (char) (i10 + 48);
        }
        if (i10 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    public static boolean r(CharSequence charSequence) {
        int i10 = 0;
        int iW = 0;
        while (i10 < charSequence.length()) {
            int i11 = i10 + 1;
            iW += w(i11) * v(charSequence.charAt(i10));
            i10 = i11;
        }
        return charSequence.charAt(8) == q(iW % 11);
    }

    public static String s(CharSequence charSequence) {
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        if (cCharAt == '9') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                return "BR";
            }
            if (cCharAt2 < '3' || cCharAt2 > '9') {
                return null;
            }
            return "BR";
        }
        if (cCharAt == 'S') {
            if (cCharAt2 >= 'A' && cCharAt2 <= 'M') {
                return "UK";
            }
            if (cCharAt2 < 'N' || cCharAt2 > 'T') {
                return null;
            }
            return "DE";
        }
        if (cCharAt == 'Z') {
            if (cCharAt2 < 'A' || cCharAt2 > 'R') {
                return null;
            }
            return "IT";
        }
        switch (cCharAt) {
            case '1':
            case '4':
            case '5':
                return "US";
            case '2':
                return "CA";
            case '3':
                if (cCharAt2 < 'A' || cCharAt2 > 'W') {
                    return null;
                }
                return "MX";
            default:
                switch (cCharAt) {
                    case 'J':
                        if (cCharAt2 < 'A' || cCharAt2 > 'T') {
                            return null;
                        }
                        return "JP";
                    case 'K':
                        if (cCharAt2 < 'L' || cCharAt2 > 'R') {
                            return null;
                        }
                        return "KO";
                    case 'L':
                        return "CN";
                    case 'M':
                        if (cCharAt2 < 'A' || cCharAt2 > 'E') {
                            return null;
                        }
                        return "IN";
                    default:
                        switch (cCharAt) {
                            case 'V':
                                if (cCharAt2 >= 'F' && cCharAt2 <= 'R') {
                                    return "FR";
                                }
                                if (cCharAt2 < 'S' || cCharAt2 > 'W') {
                                    return null;
                                }
                                return "ES";
                            case 'W':
                                return "DE";
                            case 'X':
                                if (cCharAt2 == '0') {
                                    return "RU";
                                }
                                if (cCharAt2 < '3' || cCharAt2 > '9') {
                                    return null;
                                }
                                return "RU";
                            default:
                                return null;
                        }
                }
        }
    }

    public static int t(char c10) {
        if (c10 >= 'E' && c10 <= 'H') {
            return (c10 - 'E') + 1984;
        }
        if (c10 >= 'J' && c10 <= 'N') {
            return (c10 - 'J') + 1988;
        }
        if (c10 == 'P') {
            return 1993;
        }
        if (c10 >= 'R' && c10 <= 'T') {
            return (c10 - ft.w.f28818g) + 1994;
        }
        if (c10 >= 'V' && c10 <= 'Y') {
            return (c10 - 'V') + 1997;
        }
        if (c10 >= '1' && c10 <= '9') {
            return (c10 - '1') + 2001;
        }
        if (c10 < 'A' || c10 > 'D') {
            throw new IllegalArgumentException();
        }
        return (c10 - 'A') + 2010;
    }

    public static int v(char c10) {
        if (c10 >= 'A' && c10 <= 'I') {
            return (c10 - 'A') + 1;
        }
        if (c10 >= 'J' && c10 <= 'R') {
            return (c10 - 'J') + 1;
        }
        if (c10 >= 'S' && c10 <= 'Z') {
            return (c10 - 'S') + 2;
        }
        if (c10 < '0' || c10 > '9') {
            throw new IllegalArgumentException();
        }
        return c10 - '0';
    }

    public static int w(int i10) {
        if (i10 >= 1 && i10 <= 7) {
            return 9 - i10;
        }
        if (i10 == 8) {
            return 10;
        }
        if (i10 == 9) {
            return 0;
        }
        if (i10 < 10 || i10 > 17) {
            throw new IllegalArgumentException();
        }
        return 19 - i10;
    }

    @Override // ze.t
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public g0 k(ve.k kVar) {
        if (kVar.b() != BarcodeFormat.CODE_39) {
            return null;
        }
        String strTrim = f58503g.matcher(kVar.g()).replaceAll("").trim();
        if (!f58504h.matcher(strTrim).matches()) {
            return null;
        }
        try {
            if (!r(strTrim)) {
                return null;
            }
            String strSubstring = strTrim.substring(0, 3);
            return new g0(strTrim, strSubstring, strTrim.substring(3, 9), strTrim.substring(9, 17), s(strSubstring), strTrim.substring(3, 8), t(strTrim.charAt(9)), strTrim.charAt(10), strTrim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
