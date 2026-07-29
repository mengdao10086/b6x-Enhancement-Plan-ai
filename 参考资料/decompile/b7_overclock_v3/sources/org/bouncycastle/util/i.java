package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class i {
    public static boolean a(String str, int i10) {
        try {
            int i11 = Integer.parseInt(str);
            return i11 >= 0 && i11 <= i10;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean b(String str) {
        return c(str) || e(str);
    }

    public static boolean c(String str) {
        int iIndexOf;
        int i10;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + j3.b.f36044h;
        int i11 = 0;
        int i12 = 0;
        while (i11 < str2.length() && (iIndexOf = str2.indexOf(46, i11)) > i11) {
            if (i12 == 4) {
                return false;
            }
            try {
                i10 = Integer.parseInt(str2.substring(i11, iIndexOf));
            } catch (NumberFormatException unused) {
            }
            if (i10 < 0 || i10 > 255) {
                return false;
            }
            i11 = iIndexOf + 1;
            i12++;
        }
        return i12 == 4;
    }

    public static boolean d(String str) {
        int iIndexOf = str.indexOf(fh.a.f28350w);
        String strSubstring = str.substring(iIndexOf + 1);
        if (iIndexOf <= 0 || !c(str.substring(0, iIndexOf))) {
            return false;
        }
        return c(strSubstring) || a(strSubstring, 32);
    }

    public static boolean e(String str) {
        int iIndexOf;
        int i10;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + ":";
        int i11 = 0;
        int i12 = 0;
        boolean z10 = false;
        while (i11 < str2.length() && (iIndexOf = str2.indexOf(58, i11)) >= i11) {
            if (i12 == 8) {
                return false;
            }
            if (i11 != iIndexOf) {
                String strSubstring = str2.substring(i11, iIndexOf);
                if (iIndexOf != str2.length() - 1 || strSubstring.indexOf(46) <= 0) {
                    try {
                        i10 = Integer.parseInt(str2.substring(i11, iIndexOf), 16);
                    } catch (NumberFormatException unused) {
                    }
                    if (i10 < 0 || i10 > 65535) {
                        return false;
                    }
                } else {
                    if (!c(strSubstring)) {
                        return false;
                    }
                    i12++;
                }
            } else {
                if (iIndexOf != 1 && iIndexOf != str2.length() - 1 && z10) {
                    return false;
                }
                z10 = true;
            }
            i11 = iIndexOf + 1;
            i12++;
        }
        return i12 == 8 || z10;
    }

    public static boolean f(String str) {
        int iIndexOf = str.indexOf(fh.a.f28350w);
        String strSubstring = str.substring(iIndexOf + 1);
        if (iIndexOf <= 0 || !e(str.substring(0, iIndexOf))) {
            return false;
        }
        return e(strSubstring) || a(strSubstring, 128);
    }

    public static boolean g(String str) {
        return d(str) || f(str);
    }
}
