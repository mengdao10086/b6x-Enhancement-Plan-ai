package we;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.nio.charset.Charset;
import java.util.Map;
import ve.n;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements n {
    public static af.b c(String str, BarcodeFormat barcodeFormat, int i10, int i11, Charset charset, int i12, int i13) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return d(ye.c.f(str, i12, i13, charset), i10, i11);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + barcodeFormat);
    }

    public static af.b d(ye.a aVar, int i10, int i11) {
        af.b bVarC = aVar.c();
        if (bVarC == null) {
            throw new IllegalStateException();
        }
        int iM = bVarC.m();
        int i12 = bVarC.i();
        int iMax = Math.max(i10, iM);
        int iMax2 = Math.max(i11, i12);
        int iMin = Math.min(iMax / iM, iMax2 / i12);
        int i13 = (iMax - (iM * iMin)) / 2;
        int i14 = (iMax2 - (i12 * iMin)) / 2;
        af.b bVar = new af.b(iMax, iMax2);
        int i15 = 0;
        while (i15 < i12) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < iM) {
                if (bVarC.f(i17, i15)) {
                    bVar.t(i16, i14, iMin, iMin);
                }
                i17++;
                i16 += iMin;
            }
            i15++;
            i14 += iMin;
        }
        return bVar;
    }

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i12;
        int i13;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            Charset charsetForName = map.containsKey(encodeHintType) ? Charset.forName(map.get(encodeHintType).toString()) : null;
            EncodeHintType encodeHintType2 = EncodeHintType.ERROR_CORRECTION;
            int i14 = map.containsKey(encodeHintType2) ? Integer.parseInt(map.get(encodeHintType2).toString()) : 33;
            EncodeHintType encodeHintType3 = EncodeHintType.AZTEC_LAYERS;
            if (map.containsKey(encodeHintType3)) {
                charset = charsetForName;
                i12 = i14;
                i13 = Integer.parseInt(map.get(encodeHintType3).toString());
                return c(str, barcodeFormat, i10, i11, charset, i12, i13);
            }
            charset = charsetForName;
            i12 = i14;
        } else {
            charset = null;
            i12 = 33;
        }
        i13 = 0;
        return c(str, barcodeFormat, i10, i11, charset, i12, i13);
    }
}
