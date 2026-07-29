package of;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.c;
import com.google.zxing.qrcode.encoder.f;
import java.util.Map;
import ve.n;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43322a = 4;

    public static af.b c(f fVar, int i10, int i11, int i12) {
        com.google.zxing.qrcode.encoder.b bVarC = fVar.c();
        if (bVarC == null) {
            throw new IllegalStateException();
        }
        int iE = bVarC.e();
        int iD = bVarC.d();
        int i13 = i12 * 2;
        int i14 = iE + i13;
        int i15 = i13 + iD;
        int iMax = Math.max(i10, i14);
        int iMax2 = Math.max(i11, i15);
        int iMin = Math.min(iMax / i14, iMax2 / i15);
        int i16 = (iMax - (iE * iMin)) / 2;
        int i17 = (iMax2 - (iD * iMin)) / 2;
        af.b bVar = new af.b(iMax, iMax2);
        int i18 = 0;
        while (i18 < iD) {
            int i19 = i16;
            int i20 = 0;
            while (i20 < iE) {
                if (bVarC.b(i20, i18) == 1) {
                    bVar.t(i19, i17, iMin, iMin);
                }
                i20++;
                i19 += iMin;
            }
            i18++;
            i17 += iMin;
        }
        return bVar;
    }

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) throws WriterException {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i10 + 'x' + i11);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i12 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i12 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return c(c.p(str, errorCorrectionLevelValueOf, map), i10, i11, i12);
    }
}
