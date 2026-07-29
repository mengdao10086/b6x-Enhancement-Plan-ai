package ze;

import com.google.zxing.BarcodeFormat;

/* JADX INFO: loaded from: classes7.dex */
public final class s extends t {
    @Override // ze.t
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public r k(ve.k kVar) {
        BarcodeFormat barcodeFormatB = kVar.b();
        if (barcodeFormatB != BarcodeFormat.UPC_A && barcodeFormatB != BarcodeFormat.UPC_E && barcodeFormatB != BarcodeFormat.EAN_8 && barcodeFormatB != BarcodeFormat.EAN_13) {
            return null;
        }
        String strC = t.c(kVar);
        if (t.d(strC, strC.length())) {
            return new r(strC, (barcodeFormatB == BarcodeFormat.UPC_E && strC.length() == 8) ? com.google.zxing.oned.z.s(strC) : strC);
        }
        return null;
    }
}
