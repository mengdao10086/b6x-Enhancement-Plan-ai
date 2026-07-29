package ze;

import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f58505g = Pattern.compile(ag.c.f654g);

    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public h k(ve.k kVar) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String strC = t.c(kVar);
        if (!strC.startsWith(u0.c.f51788b) && !strC.startsWith("MAILTO:")) {
            if (j.s(strC)) {
                return new h(strC);
            }
            return null;
        }
        String strSubstring = strC.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        try {
            String strP = t.p(strSubstring);
            String[] strArrSplit = !strP.isEmpty() ? f58505g.split(strP) : null;
            Map<String, String> mapM = t.m(strC);
            if (mapM != null) {
                if (strArrSplit == null && (str3 = mapM.get("to")) != null) {
                    strArrSplit = f58505g.split(str3);
                }
                String str4 = mapM.get(u0.c.f51792f);
                String[] strArrSplit2 = str4 != null ? f58505g.split(str4) : null;
                String str5 = mapM.get(u0.c.f51793g);
                String[] strArrSplit3 = str5 != null ? f58505g.split(str5) : null;
                String str6 = mapM.get(u0.c.f51794h);
                str2 = mapM.get("body");
                strArr = strArrSplit;
                strArr3 = strArrSplit3;
                strArr2 = strArrSplit2;
                str = str6;
            } else {
                strArr = strArrSplit;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new h(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
