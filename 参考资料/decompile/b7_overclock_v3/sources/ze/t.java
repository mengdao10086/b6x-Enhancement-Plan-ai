package ze;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public abstract class t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f58545e = "\ufeff";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t[] f58541a = {new f(), new c(), new j(), new b(), new e0(), new e(), new f0(), new i(), new x(), new z(), new u(), new w(), new n(), new j0(), new d0(), new c0(), new p(), new s(), new l(), new h0()};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f58542b = Pattern.compile("\\d+");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f58543c = Pattern.compile("&");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f58544d = Pattern.compile(hb.u.f30904o);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f58546f = new String[0];

    public static void a(CharSequence charSequence, Map<String, String> map) {
        String[] strArrSplit = f58544d.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], p(strArrSplit[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static int b(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (int i12 = i10 - 1; i12 >= 0 && charSequence.charAt(i12) == '\\'; i12--) {
            i11++;
        }
        return i11;
    }

    public static String c(ve.k kVar) {
        String strG = kVar.g();
        return strG.startsWith(f58545e) ? strG.substring(1) : strG;
    }

    public static boolean d(CharSequence charSequence, int i10) {
        return charSequence != null && i10 > 0 && i10 == charSequence.length() && f58542b.matcher(charSequence).matches();
    }

    public static boolean e(CharSequence charSequence, int i10, int i11) {
        int i12;
        return charSequence != null && i11 > 0 && charSequence.length() >= (i12 = i11 + i10) && f58542b.matcher(charSequence.subSequence(i10, i12)).matches();
    }

    public static String[] f(String str, String str2, char c10, boolean z10) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < length) {
            int iIndexOf = str2.indexOf(str, i10);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z11 = true;
            int length3 = length2;
            while (z11) {
                int iIndexOf2 = str2.indexOf(c10, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (b(str2, iIndexOf2) % 2 != 0) {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strO = o(str2.substring(length2, iIndexOf2));
                    if (z10) {
                        strO = strO.trim();
                    }
                    if (!strO.isEmpty()) {
                        arrayList2.add(strO);
                    }
                    length3 = iIndexOf2 + 1;
                }
                z11 = false;
            }
            i10 = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(f58546f);
    }

    public static String g(String str, String str2, char c10, boolean z10) {
        String[] strArrF = f(str, str2, c10, z10);
        if (strArrF == null) {
            return null;
        }
        return strArrF[0];
    }

    public static void h(String str, StringBuilder sb2) {
        if (str != null) {
            sb2.append('\n');
            sb2.append(str);
        }
    }

    public static void i(String[] strArr, StringBuilder sb2) {
        if (strArr != null) {
            for (String str : strArr) {
                sb2.append('\n');
                sb2.append(str);
            }
        }
    }

    public static String[] j(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    public static int l(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    public static Map<String, String> m(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        HashMap map = new HashMap(3);
        for (String str2 : f58543c.split(str.substring(iIndexOf + 1))) {
            a(str2, map);
        }
        return map;
    }

    public static q n(ve.k kVar) {
        for (t tVar : f58541a) {
            q qVarK = tVar.k(kVar);
            if (qVarK != null) {
                return qVarK;
            }
        }
        return new a0(kVar.g(), null);
    }

    public static String o(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length - 1);
        sb2.append(str.toCharArray(), 0, iIndexOf);
        boolean z10 = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z10 || cCharAt != '\\') {
                sb2.append(cCharAt);
                z10 = false;
            } else {
                z10 = true;
            }
            iIndexOf++;
        }
        return sb2.toString();
    }

    public static String p(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public abstract q k(ve.k kVar);
}
