package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class z extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public y k(ve.k kVar) {
        String str;
        String strC = t.c(kVar);
        if (!strC.startsWith("tel:") && !strC.startsWith("TEL:")) {
            return null;
        }
        if (strC.startsWith("TEL:")) {
            str = "tel:" + strC.substring(4);
        } else {
            str = strC;
        }
        int iIndexOf = strC.indexOf(63, 4);
        return new y(iIndexOf < 0 ? strC.substring(4) : strC.substring(4, iIndexOf), str, null);
    }
}
