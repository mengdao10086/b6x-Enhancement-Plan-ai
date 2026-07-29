package of;

import af.f;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.qrcode.decoder.d;
import com.google.zxing.qrcode.detector.c;
import java.util.List;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public class a implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l[] f43320b = new l[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f43321a = new d();

    public static af.b e(af.b bVar) throws NotFoundException {
        int[] iArrL = bVar.l();
        int[] iArrG = bVar.g();
        if (iArrL == null || iArrG == null) {
            throw NotFoundException.b();
        }
        float fG = g(iArrL, bVar);
        int i10 = iArrL[1];
        int i11 = iArrG[1];
        int i12 = iArrL[0];
        int i13 = iArrG[0];
        if (i12 >= i13 || i10 >= i11) {
            throw NotFoundException.b();
        }
        int i14 = i11 - i10;
        if (i14 != i13 - i12 && (i13 = i12 + i14) >= bVar.m()) {
            throw NotFoundException.b();
        }
        int iRound = Math.round(((i13 - i12) + 1) / fG);
        int iRound2 = Math.round((i14 + 1) / fG);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.b();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.b();
        }
        int i15 = (int) (fG / 2.0f);
        int i16 = i10 + i15;
        int i17 = i12 + i15;
        int i18 = (((int) ((iRound - 1) * fG)) + i17) - i13;
        if (i18 > 0) {
            if (i18 > i15) {
                throw NotFoundException.b();
            }
            i17 -= i18;
        }
        int i19 = (((int) ((iRound2 - 1) * fG)) + i16) - i11;
        if (i19 > 0) {
            if (i19 > i15) {
                throw NotFoundException.b();
            }
            i16 -= i19;
        }
        af.b bVar2 = new af.b(iRound, iRound2);
        for (int i20 = 0; i20 < iRound2; i20++) {
            int i21 = ((int) (i20 * fG)) + i16;
            for (int i22 = 0; i22 < iRound; i22++) {
                if (bVar.f(((int) (i22 * fG)) + i17, i21)) {
                    bVar2.s(i22, i20);
                }
            }
        }
        return bVar2;
    }

    public static float g(int[] iArr, af.b bVar) throws NotFoundException {
        int i10 = bVar.i();
        int iM = bVar.m();
        int i11 = iArr[0];
        boolean z10 = true;
        int i12 = iArr[1];
        int i13 = 0;
        while (i11 < iM && i12 < i10) {
            if (z10 != bVar.f(i11, i12)) {
                i13++;
                if (i13 == 5) {
                    break;
                }
                z10 = !z10;
            }
            i11++;
            i12++;
        }
        if (i11 == iM || i12 == i10) {
            throw NotFoundException.b();
        }
        return (i11 - iArr[0]) / 7.0f;
    }

    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return d(bVar, null);
    }

    @Override // ve.j
    public final k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        l[] lVarArrB;
        af.d dVarC;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            f fVarF = new c(bVar.b()).f(map);
            af.d dVarC2 = this.f43321a.c(fVarF.a(), map);
            lVarArrB = fVarF.b();
            dVarC = dVarC2;
        } else {
            dVarC = this.f43321a.c(e(bVar.b()), map);
            lVarArrB = f43320b;
        }
        if (dVarC.f() instanceof com.google.zxing.qrcode.decoder.f) {
            ((com.google.zxing.qrcode.decoder.f) dVarC.f()).a(lVarArrB);
        }
        k kVar = new k(dVarC.k(), dVarC.g(), lVarArrB, BarcodeFormat.QR_CODE);
        List<byte[]> listA = dVarC.a();
        if (listA != null) {
            kVar.j(ResultMetadataType.BYTE_SEGMENTS, listA);
        }
        String strB = dVarC.b();
        if (strB != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        if (dVarC.l()) {
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(dVarC.i()));
            kVar.j(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(dVarC.h()));
        }
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + dVarC.j());
        return kVar;
    }

    public final d f() {
        return this.f43321a;
    }

    @Override // ve.j
    public void reset() {
    }
}
