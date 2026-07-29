package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends a {
    public static String t(String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + zc.f.f58383m + str.substring(0, iIndexOf);
    }

    @Override // ze.t
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public d k(ve.k kVar) {
        String[] strArrQ;
        String strC = t.c(kVar);
        if (!strC.startsWith("MECARD:") || (strArrQ = a.q("N:", strC)) == null) {
            return null;
        }
        String strT = t(strArrQ[0]);
        String strR = a.r("SOUND:", strC, true);
        String[] strArrQ2 = a.q("TEL:", strC);
        String[] strArrQ3 = a.q("EMAIL:", strC);
        String strR2 = a.r("NOTE:", strC, false);
        String[] strArrQ4 = a.q("ADR:", strC);
        String strR3 = a.r("BDAY:", strC, true);
        return new d(t.j(strT), null, strR, strArrQ2, null, strArrQ3, null, null, strR2, strArrQ4, null, a.r("ORG:", strC, true), !t.d(strR3, 8) ? null : strR3, null, a.q("URL:", strC), null);
    }
}
