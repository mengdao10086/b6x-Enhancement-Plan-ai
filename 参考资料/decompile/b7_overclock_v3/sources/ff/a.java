package ff;

import af.b;
import af.d;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import gf.c;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l[] f28141b = new l[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f28142c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28143d = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f28144a = new c();

    public static b b(b bVar) throws NotFoundException {
        int[] iArrH = bVar.h();
        if (iArrH == null) {
            throw NotFoundException.b();
        }
        int i10 = iArrH[0];
        int i11 = iArrH[1];
        int i12 = iArrH[2];
        int i13 = iArrH[3];
        b bVar2 = new b(30, 33);
        for (int i14 = 0; i14 < 33; i14++) {
            int iMin = Math.min((((i14 * i13) + (i13 / 2)) / 33) + i11, i13 - 1);
            for (int i15 = 0; i15 < 30; i15++) {
                if (bVar.f(Math.min((((i15 * i12) + (i12 / 2)) + (((i14 & 1) * i12) / 2)) / 30, i12 - 1) + i10, iMin)) {
                    bVar2.s(i15, i14);
                }
            }
        }
        return bVar2;
    }

    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return d(bVar, null);
    }

    @Override // ve.j
    public k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        d dVarC = this.f28144a.c(b(bVar.b()), map);
        k kVar = new k(dVarC.k(), dVarC.g(), f28141b, BarcodeFormat.MAXICODE);
        String strB = dVarC.b();
        if (strB != null) {
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, strB);
        }
        return kVar;
    }

    @Override // ve.j
    public void reset() {
    }
}
