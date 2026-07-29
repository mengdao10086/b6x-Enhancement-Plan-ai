package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class w extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public v k(ve.k kVar) {
        String strSubstring;
        String strC = t.c(kVar);
        if (!strC.startsWith("smsto:") && !strC.startsWith("SMSTO:") && !strC.startsWith("mmsto:") && !strC.startsWith("MMSTO:")) {
            return null;
        }
        String strSubstring2 = strC.substring(6);
        int iIndexOf = strSubstring2.indexOf(58);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring2.substring(iIndexOf + 1);
            strSubstring2 = strSubstring2.substring(0, iIndexOf);
        } else {
            strSubstring = null;
        }
        return new v(strSubstring2, (String) null, (String) null, strSubstring);
    }
}
