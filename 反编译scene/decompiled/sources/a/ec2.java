package a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ec2 extends bc2 {
    public static final boolean A(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        f92.d(charSequence, "$this$contains");
        f92.d(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (N(charSequence, (String) charSequence2, 0, z, 2, null) >= 0) {
                return true;
            }
        } else if (L(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean B(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return z(charSequence, c, z);
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return A(charSequence, charSequence2, z);
    }

    public static final boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        f92.d(charSequence, "$this$endsWith");
        f92.d(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? bc2.o((String) charSequence, (String) charSequence2, false, 2, null) : a0(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean E(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return D(charSequence, charSequence2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
    
        return a.j42.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a.d42<java.lang.Integer, java.lang.String> F(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.ec2.F(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):a.d42");
    }

    public static final ea2 G(CharSequence charSequence) {
        f92.d(charSequence, "$this$indices");
        return new ea2(0, charSequence.length() - 1);
    }

    public static final int H(CharSequence charSequence) {
        f92.d(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int I(CharSequence charSequence, char c, int i, boolean z) {
        f92.d(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? O(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static final int J(CharSequence charSequence, String str, int i, boolean z) {
        f92.d(charSequence, "$this$indexOf");
        f92.d(str, "string");
        return (z || !(charSequence instanceof String)) ? L(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int K(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        ba2 ea2Var = !z2 ? new ea2(ga2.b(i, 0), ga2.d(i2, charSequence.length())) : ga2.g(ga2.d(i, H(charSequence)), ga2.b(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iA = ea2Var.a();
            int iB = ea2Var.b();
            int iC = ea2Var.c();
            if (iC >= 0) {
                if (iA > iB) {
                    return -1;
                }
            } else if (iA < iB) {
                return -1;
            }
            while (!bc2.q((String) charSequence2, 0, (String) charSequence, iA, charSequence2.length(), z)) {
                if (iA == iB) {
                    return -1;
                }
                iA += iC;
            }
            return iA;
        }
        int iA2 = ea2Var.a();
        int iB2 = ea2Var.b();
        int iC2 = ea2Var.c();
        if (iC2 >= 0) {
            if (iA2 > iB2) {
                return -1;
            }
        } else if (iA2 < iB2) {
            return -1;
        }
        while (!a0(charSequence2, 0, charSequence, iA2, charSequence2.length(), z)) {
            if (iA2 == iB2) {
                return -1;
            }
            iA2 += iC2;
        }
        return iA2;
    }

    public static /* synthetic */ int L(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return K(charSequence, charSequence2, i, i2, z, z2);
    }

    public static /* synthetic */ int M(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return I(charSequence, c, i, z);
    }

    public static /* synthetic */ int N(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return J(charSequence, str, i, z);
    }

    public static final int O(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        f92.d(charSequence, "$this$indexOfAny");
        f92.d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(u42.B(cArr), i);
        }
        int iB = ga2.b(i, 0);
        int iH = H(charSequence);
        if (iB > iH) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (ab2.d(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iB;
            }
            if (iB == iH) {
                return -1;
            }
            iB++;
        }
    }

    public static final int P(CharSequence charSequence, char c, int i, boolean z) {
        f92.d(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? T(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static final int Q(CharSequence charSequence, String str, int i, boolean z) {
        f92.d(charSequence, "$this$lastIndexOf");
        f92.d(str, "string");
        return (z || !(charSequence instanceof String)) ? K(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int R(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = H(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return P(charSequence, c, i, z);
    }

    public static /* synthetic */ int S(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = H(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return Q(charSequence, str, i, z);
    }

    public static final int T(CharSequence charSequence, char[] cArr, int i, boolean z) {
        f92.d(charSequence, "$this$lastIndexOfAny");
        f92.d(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(u42.B(cArr), i);
        }
        for (int iD = ga2.d(i, H(charSequence)); iD >= 0; iD--) {
            char cCharAt = charSequence.charAt(iD);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (ab2.d(cArr[i2], cCharAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return iD;
            }
        }
        return -1;
    }

    public static final pa2<String> U(CharSequence charSequence) {
        f92.d(charSequence, "$this$lineSequence");
        return f0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> V(CharSequence charSequence) {
        f92.d(charSequence, "$this$lines");
        return wa2.g(U(charSequence));
    }

    public static final CharSequence W(CharSequence charSequence, int i, char c) {
        f92.d(charSequence, "$this$padEnd");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        }
        if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i);
        sb.append(charSequence);
        int length = i - charSequence.length();
        int i2 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c);
                if (i2 == length) {
                    break;
                }
                i2++;
            }
        }
        return sb;
    }

    public static final String X(String str, int i, char c) {
        f92.d(str, "$this$padEnd");
        return W(str, i, c).toString();
    }

    public static final pa2<ea2> Y(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new db2(charSequence, i, i2, new cc2(s42.b(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ pa2 Z(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return Y(charSequence, strArr, i, z, i2);
    }

    public static final boolean a0(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        f92.d(charSequence, "$this$regionMatchesImpl");
        f92.d(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!ab2.d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final List<String> b0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        f92.d(charSequence, "$this$split");
        f92.d(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return c0(charSequence, str, z, i);
            }
        }
        Iterable iterableD = wa2.d(Z(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(z42.m(iterableD, 10));
        Iterator it = iterableD.iterator();
        while (it.hasNext()) {
            arrayList.add(i0(charSequence, (ea2) it.next()));
        }
        return arrayList;
    }

    public static final List<String> c0(CharSequence charSequence, String str, boolean z, int i) {
        int length = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int iJ = J(charSequence, str, 0, z);
        if (iJ == -1 || i == 1) {
            return x42.b(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? ga2.d(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iJ).toString());
            length = str.length() + iJ;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iJ = J(charSequence, str, length, z);
        } while (iJ != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List d0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return b0(charSequence, strArr, z, i);
    }

    public static final pa2<String> e0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        f92.d(charSequence, "$this$splitToSequence");
        f92.d(strArr, "delimiters");
        return wa2.e(Z(charSequence, strArr, 0, z, i, 2, null), new dc2(charSequence));
    }

    public static /* synthetic */ pa2 f0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return e0(charSequence, strArr, z, i);
    }

    public static final boolean g0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        f92.d(charSequence, "$this$startsWith");
        f92.d(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? bc2.x((String) charSequence, (String) charSequence2, false, 2, null) : a0(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean h0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return g0(charSequence, charSequence2, z);
    }

    public static final String i0(CharSequence charSequence, ea2 ea2Var) {
        f92.d(charSequence, "$this$substring");
        f92.d(ea2Var, "range");
        return charSequence.subSequence(ea2Var.g().intValue(), ea2Var.f().intValue() + 1).toString();
    }

    public static final String j0(String str, String str2, String str3) {
        f92.d(str, "$this$substringAfter");
        f92.d(str2, "delimiter");
        f92.d(str3, "missingDelimiterValue");
        int iN = N(str, str2, 0, false, 6, null);
        if (iN == -1) {
            return str3;
        }
        String strSubstring = str.substring(iN + str2.length(), str.length());
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String k0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return j0(str, str2, str3);
    }

    public static final String l0(String str, char c, String str2) {
        f92.d(str, "$this$substringAfterLast");
        f92.d(str2, "missingDelimiterValue");
        int iR = R(str, c, 0, false, 6, null);
        if (iR == -1) {
            return str2;
        }
        String strSubstring = str.substring(iR + 1, str.length());
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String m0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return l0(str, c, str2);
    }

    public static final String n0(String str, char c, String str2) {
        f92.d(str, "$this$substringBefore");
        f92.d(str2, "missingDelimiterValue");
        int iM = M(str, c, 0, false, 6, null);
        if (iM == -1) {
            return str2;
        }
        String strSubstring = str.substring(0, iM);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final String o0(String str, String str2, String str3) {
        f92.d(str, "$this$substringBefore");
        f92.d(str2, "delimiter");
        f92.d(str3, "missingDelimiterValue");
        int iN = N(str, str2, 0, false, 6, null);
        if (iN == -1) {
            return str3;
        }
        String strSubstring = str.substring(0, iN);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String p0(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return n0(str, c, str2);
    }

    public static /* synthetic */ String q0(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return o0(str, str2, str3);
    }

    public static final CharSequence r0(CharSequence charSequence) {
        f92.d(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zC = za2.c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence s0(CharSequence charSequence) {
        f92.d(charSequence, "$this$trimEnd");
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (za2.c(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1);
    }

    public static final boolean z(CharSequence charSequence, char c, boolean z) {
        f92.d(charSequence, "$this$contains");
        return M(charSequence, c, 0, z, 2, null) >= 0;
    }
}
