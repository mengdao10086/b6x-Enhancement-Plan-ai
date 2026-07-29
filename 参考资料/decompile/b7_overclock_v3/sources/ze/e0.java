package ze;

import com.blankj.utilcode.util.PermissionUtils;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class e0 extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58465g = Pattern.compile("BEGIN:VCARD", 2);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f58466h = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f58467i = Pattern.compile("\r\n[ \t]");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f58468j = Pattern.compile("\\\\[nN]");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Pattern f58469k = Pattern.compile("\\\\([,;\\\\])");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f58470l = Pattern.compile(hb.u.f30904o);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f58471m = Pattern.compile(";");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f58472n = Pattern.compile("(?<!\\\\);+");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Pattern f58473o = Pattern.compile(ag.c.f654g);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Pattern f58474p = Pattern.compile("[;,]");

    public static String[] A(Collection<List<String>> collection) {
        String strSubstring;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                int i10 = 1;
                while (true) {
                    if (i10 >= list.size()) {
                        strSubstring = null;
                        break;
                    }
                    strSubstring = list.get(i10);
                    int iIndexOf = strSubstring.indexOf(61);
                    if (iIndexOf < 0) {
                        break;
                    }
                    if (PermissionUtils.PermissionActivityImpl.f11522a.equalsIgnoreCase(strSubstring.substring(0, iIndexOf))) {
                        strSubstring = strSubstring.substring(iIndexOf + 1);
                        break;
                    }
                    i10++;
                }
                arrayList.add(strSubstring);
            }
        }
        return (String[]) arrayList.toArray(t.f58546f);
    }

    public static String q(CharSequence charSequence, String str) {
        char cCharAt;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 < length) {
            char cCharAt2 = charSequence.charAt(i10);
            if (cCharAt2 != '\n' && cCharAt2 != '\r') {
                if (cCharAt2 != '=') {
                    w(byteArrayOutputStream, str, sb2);
                    sb2.append(cCharAt2);
                } else if (i10 < length - 2 && (cCharAt = charSequence.charAt(i10 + 1)) != '\r' && cCharAt != '\n') {
                    i10 += 2;
                    char cCharAt3 = charSequence.charAt(i10);
                    int iL = t.l(cCharAt);
                    int iL2 = t.l(cCharAt3);
                    if (iL >= 0 && iL2 >= 0) {
                        byteArrayOutputStream.write((iL << 4) + iL2);
                    }
                }
            }
            i10++;
        }
        w(byteArrayOutputStream, str, sb2);
        return sb2.toString();
    }

    public static void r(Iterable<List<String>> iterable) {
        int iIndexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i10 = 0;
                int i11 = 0;
                while (i10 < 4 && (iIndexOf = str.indexOf(59, i11)) >= 0) {
                    strArr[i10] = str.substring(i11, iIndexOf);
                    i10++;
                    i11 = iIndexOf + 1;
                }
                strArr[i10] = str.substring(i11);
                StringBuilder sb2 = new StringBuilder(100);
                v(strArr, 3, sb2);
                v(strArr, 1, sb2);
                v(strArr, 2, sb2);
                v(strArr, 0, sb2);
                v(strArr, 4, sb2);
                list.set(0, sb2.toString().trim());
            }
        }
    }

    public static boolean s(CharSequence charSequence) {
        return charSequence == null || f58466h.matcher(charSequence).matches();
    }

    public static List<String> t(CharSequence charSequence, String str, boolean z10, boolean z11) {
        List<List<String>> listU = u(charSequence, str, z10, z11);
        if (listU == null || listU.isEmpty()) {
            return null;
        }
        return listU.get(0);
    }

    public static List<List<String>> u(CharSequence charSequence, String str, boolean z10, boolean z11) {
        ArrayList arrayList;
        boolean z12;
        String str2;
        String str3;
        int iIndexOf;
        int i10;
        String strReplaceAll;
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        ArrayList arrayList2 = null;
        while (i12 < length) {
            int i13 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i12 > 0) {
                i12--;
            }
            if (!matcher.find(i12)) {
                break;
            }
            int iEnd = matcher.end(i11);
            String strGroup = matcher.group(1);
            if (strGroup != null) {
                String[] strArrSplit = f58471m.split(strGroup);
                int length2 = strArrSplit.length;
                int i14 = 0;
                arrayList = null;
                z12 = false;
                str2 = null;
                str3 = null;
                while (i14 < length2) {
                    String str4 = strArrSplit[i14];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] strArrSplit2 = f58470l.split(str4, i13);
                    if (strArrSplit2.length > 1) {
                        String str5 = strArrSplit2[0];
                        String str6 = strArrSplit2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            z12 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i14++;
                    i13 = 2;
                }
            } else {
                arrayList = null;
                z12 = false;
                str2 = null;
                str3 = null;
            }
            int i15 = iEnd;
            while (true) {
                iIndexOf = str.indexOf(10, i15);
                if (iIndexOf < 0) {
                    break;
                }
                if (iIndexOf < str.length() - 1) {
                    int i16 = iIndexOf + 1;
                    if (str.charAt(i16) == ' ' || str.charAt(i16) == '\t') {
                        i15 = iIndexOf + 2;
                    }
                }
                if (!z12 || ((iIndexOf < 1 || str.charAt(iIndexOf - 1) != '=') && (iIndexOf < 2 || str.charAt(iIndexOf - 2) != '='))) {
                    break;
                }
                i15 = iIndexOf + 1;
            }
            if (iIndexOf < 0) {
                i10 = length;
            } else if (iIndexOf <= iEnd) {
                i10 = iIndexOf + 1;
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                }
                if (iIndexOf >= 1 && str.charAt(iIndexOf - 1) == '\r') {
                    iIndexOf--;
                }
                String strSubstring = str.substring(iEnd, iIndexOf);
                if (z10) {
                    strSubstring = strSubstring.trim();
                }
                if (z12) {
                    strReplaceAll = q(strSubstring, str2);
                    if (z11) {
                        strReplaceAll = f58472n.matcher(strReplaceAll).replaceAll("\n").trim();
                    }
                } else {
                    if (z11) {
                        strSubstring = f58472n.matcher(strSubstring).replaceAll("\n").trim();
                    }
                    strReplaceAll = f58469k.matcher(f58468j.matcher(f58467i.matcher(strSubstring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if ("uri".equals(str3)) {
                    try {
                        strReplaceAll = URI.create(strReplaceAll).getSchemeSpecificPart();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                if (arrayList == null) {
                    ArrayList arrayList3 = new ArrayList(1);
                    arrayList3.add(strReplaceAll);
                    arrayList2.add(arrayList3);
                    i10 = iIndexOf + 1;
                } else {
                    arrayList.add(0, strReplaceAll);
                    arrayList2.add(arrayList);
                    i10 = iIndexOf + 1;
                }
            }
            i12 = i10;
            i11 = 0;
        }
        return arrayList2;
    }

    public static void v(String[] strArr, int i10, StringBuilder sb2) {
        if (strArr[i10] == null || strArr[i10].isEmpty()) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append(zc.f.f58383m);
        }
        sb2.append(strArr[i10]);
    }

    public static void w(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb2) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb2.append(str2);
        }
    }

    public static String y(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String[] z(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it2 = collection.iterator();
        while (it2.hasNext()) {
            String str = it2.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(t.f58546f);
    }

    @Override // ze.t
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public d k(ve.k kVar) {
        String strC = t.c(kVar);
        Matcher matcher = f58465g.matcher(strC);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> listU = u("FN", strC, true, false);
        if (listU == null) {
            listU = u("N", strC, true, false);
            r(listU);
        }
        List<String> listT = t("NICKNAME", strC, true, false);
        String[] strArrSplit = listT == null ? null : f58473o.split(listT.get(0));
        List<List<String>> listU2 = u("TEL", strC, true, false);
        List<List<String>> listU3 = u("EMAIL", strC, true, false);
        List<String> listT2 = t(zc.h.f58423v, strC, false, false);
        List<List<String>> listU4 = u("ADR", strC, true, true);
        List<String> listT3 = t("ORG", strC, true, true);
        List<String> listT4 = t("BDAY", strC, true, false);
        List<String> list = (listT4 == null || s(listT4.get(0))) ? listT4 : null;
        List<String> listT5 = t("TITLE", strC, true, false);
        List<List<String>> listU5 = u("URL", strC, true, false);
        List<String> listT6 = t("IMPP", strC, true, false);
        List<String> listT7 = t("GEO", strC, true, false);
        String[] strArrSplit2 = listT7 == null ? null : f58474p.split(listT7.get(0));
        return new d(z(listU), strArrSplit, null, z(listU2), A(listU2), z(listU3), A(listU3), y(listT6), y(listT2), z(listU4), A(listU4), y(listT3), y(list), y(listT5), z(listU5), (strArrSplit2 == null || strArrSplit2.length == 2) ? strArrSplit2 : null);
    }
}
