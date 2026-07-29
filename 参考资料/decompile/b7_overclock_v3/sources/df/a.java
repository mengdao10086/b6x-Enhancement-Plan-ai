package df;

import af.d;
import af.f;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.datamatrix.decoder.c;
import java.util.List;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l[] f26245b = new l[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f26246a = new c();

    public static af.b b(af.b bVar) throws NotFoundException {
        int[] iArrL = bVar.l();
        int[] iArrG = bVar.g();
        if (iArrL == null || iArrG == null) {
            throw NotFoundException.b();
        }
        int iC = c(iArrL, bVar);
        int i10 = iArrL[1];
        int i11 = iArrG[1];
        int i12 = iArrL[0];
        int i13 = ((iArrG[0] - i12) + 1) / iC;
        int i14 = ((i11 - i10) + 1) / iC;
        if (i13 <= 0 || i14 <= 0) {
            throw NotFoundException.b();
        }
        int i15 = iC / 2;
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        af.b bVar2 = new af.b(i13, i14);
        for (int i18 = 0; i18 < i14; i18++) {
            int i19 = (i18 * iC) + i16;
            for (int i20 = 0; i20 < i13; i20++) {
                if (bVar.f((i20 * iC) + i17, i19)) {
                    bVar2.s(i20, i18);
                }
            }
        }
        return bVar2;
    }

    public static int c(int[] iArr, af.b bVar) throws NotFoundException {
        int iM = bVar.m();
        int i10 = iArr[0];
        int i11 = iArr[1];
        while (i10 < iM && bVar.f(i10, i11)) {
            i10++;
        }
        if (i10 == iM) {
            throw NotFoundException.b();
        }
        int i12 = i10 - iArr[0];
        if (i12 != 0) {
            return i12;
        }
        throw NotFoundException.b();
    }

    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return d(bVar, null);
    }

    @Override // ve.j
    public k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] lVarArrB;
        d dVarB;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarB = new ef.a(bVar.b()).b();
            d dVarB2 = this.f26246a.b(fVarB.a());
            lVarArrB = fVarB.b();
            dVarB = dVarB2;
        } else {
            dVarB = this.f26246a.b(b(bVar.b()));
            lVarArrB = f26245b;
        }
        k kVar = new k(dVarB.k(), dVarB.g(), lVarArrB, BarcodeFormat.DATA_MATRIX);
        List<byte[]> listA = dVarB.a();
        if (listA != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarB.b();
        if (strB != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]d" + dVarB.j());
        return kVar;
    }

    @Override // ve.j
    public void reset() {
    }
}
