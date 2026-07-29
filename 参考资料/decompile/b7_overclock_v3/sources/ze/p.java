package ze;

import com.google.zxing.BarcodeFormat;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public o k(ve.k kVar) {
        if (kVar.b() != BarcodeFormat.EAN_13) {
            return null;
        }
        String strC = t.c(kVar);
        if (strC.length() != 13) {
            return null;
        }
        if (strC.startsWith("978") || strC.startsWith("979")) {
            return new o(strC);
        }
        return null;
    }
}
