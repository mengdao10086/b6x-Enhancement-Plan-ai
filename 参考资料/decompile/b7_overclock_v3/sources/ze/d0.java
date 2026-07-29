package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class d0 extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public b0 k(ve.k kVar) {
        int iIndexOf;
        String strC = t.c(kVar);
        if ((strC.startsWith("urlto:") || strC.startsWith("URLTO:")) && (iIndexOf = strC.indexOf(58, 6)) >= 0) {
            return new b0(strC.substring(iIndexOf + 1), iIndexOf > 6 ? strC.substring(6, iIndexOf) : null);
        }
        return null;
    }
}
