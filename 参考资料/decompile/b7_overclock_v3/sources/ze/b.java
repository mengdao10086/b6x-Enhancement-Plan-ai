package ze;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends t {
    public static String[] q(String str, String str2) {
        ArrayList arrayList = null;
        for (int i10 = 1; i10 <= 3; i10++) {
            String strG = t.g(str + i10 + ':', str2, '\r', true);
            if (strG == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(3);
            }
            arrayList.add(strG);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(t.f58546f);
    }

    @Override // ze.t
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public d k(ve.k kVar) {
        String strC = t.c(kVar);
        if (!strC.contains("MEMORY") || !strC.contains("\r\n")) {
            return null;
        }
        String strG = t.g("NAME1:", strC, '\r', true);
        String strG2 = t.g("NAME2:", strC, '\r', true);
        String[] strArrQ = q("TEL", strC);
        String[] strArrQ2 = q("MAIL", strC);
        String strG3 = t.g("MEMORY:", strC, '\r', false);
        String strG4 = t.g("ADD:", strC, '\r', true);
        return new d(t.j(strG), null, strG2, strArrQ, null, strArrQ2, null, null, strG3, strG4 != null ? new String[]{strG4} : null, null, null, null, null, null, null);
    }
}
