package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends a {
    @Override // ze.t
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public b0 k(ve.k kVar) {
        String strG = kVar.g();
        if (!strG.startsWith("MEBKM:")) {
            return null;
        }
        String strR = a.r("TITLE:", strG, true);
        String[] strArrQ = a.q("URL:", strG);
        if (strArrQ == null) {
            return null;
        }
        String str = strArrQ[0];
        if (c0.q(str)) {
            return new b0(str, strR);
        }
        return null;
    }
}
