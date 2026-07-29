package ze;

import com.just.agentweb.DefaultWebClient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class u extends t {
    public static void q(Collection<String> collection, Collection<String> collection2, String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }

    @Override // ze.t
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public v k(ve.k kVar) {
        String str;
        String strC = t.c(kVar);
        String str2 = null;
        if (!strC.startsWith(DefaultWebClient.C) && !strC.startsWith("SMS:") && !strC.startsWith("mms:") && !strC.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> mapM = t.m(strC);
        boolean z10 = false;
        if (mapM == null || mapM.isEmpty()) {
            str = null;
        } else {
            str2 = mapM.get(u0.c.f51794h);
            str = mapM.get("body");
            z10 = true;
        }
        int iIndexOf = strC.indexOf(63, 4);
        String strSubstring = (iIndexOf < 0 || !z10) ? strC.substring(4) : strC.substring(4, iIndexOf);
        int i10 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i11 = i10 + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i11);
            if (iIndexOf2 <= i10) {
                q(arrayList, arrayList2, strSubstring.substring(i11));
                String[] strArr = t.f58546f;
                return new v((String[]) arrayList.toArray(strArr), (String[]) arrayList2.toArray(strArr), str2, str);
            }
            q(arrayList, arrayList2, strSubstring.substring(i11, iIndexOf2));
            i10 = iIndexOf2;
        }
    }
}
