package kf;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.pdf417.decoder.i;
import java.util.ArrayList;
import java.util.Map;
import ve.j;
import ve.k;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements j, hf.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k[] f37236a = new k[0];

    public static k[] e(ve.b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException, ChecksumException, FormatException {
        ArrayList arrayList = new ArrayList();
        mf.b bVarD = mf.a.d(bVar, map, z10);
        for (l[] lVarArr : bVarD.b()) {
            af.d dVarI = i.i(bVarD.a(), lVarArr[4], lVarArr[5], lVarArr[6], lVarArr[7], h(lVarArr), f(lVarArr));
            k kVar = new k(dVarI.k(), dVarI.g(), lVarArr, BarcodeFormat.PDF_417);
            kVar.j(ResultMetadataType.ERROR_CORRECTION_LEVEL, dVarI.b());
            c cVar = (c) dVarI.f();
            if (cVar != null) {
                kVar.j(ResultMetadataType.PDF417_EXTRA_METADATA, cVar);
            }
            kVar.j(ResultMetadataType.ORIENTATION, Integer.valueOf(bVarD.c()));
            kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]L" + dVarI.j());
            arrayList.add(kVar);
        }
        return (k[]) arrayList.toArray(f37236a);
    }

    public static int f(l[] lVarArr) {
        return Math.max(Math.max(g(lVarArr[0], lVarArr[4]), (g(lVarArr[6], lVarArr[2]) * 17) / 18), Math.max(g(lVarArr[1], lVarArr[5]), (g(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    public static int g(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return 0;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    public static int h(l[] lVarArr) {
        return Math.min(Math.min(i(lVarArr[0], lVarArr[4]), (i(lVarArr[6], lVarArr[2]) * 17) / 18), Math.min(i(lVarArr[1], lVarArr[5]), (i(lVarArr[7], lVarArr[3]) * 17) / 18));
    }

    public static int i(l lVar, l lVar2) {
        if (lVar == null || lVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(lVar.c() - lVar2.c());
    }

    @Override // ve.j
    public k a(ve.b bVar) throws NotFoundException, ChecksumException, FormatException {
        return d(bVar, null);
    }

    @Override // hf.c
    public k[] b(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        try {
            return e(bVar, map, true);
        } catch (ChecksumException | FormatException unused) {
            throw NotFoundException.b();
        }
    }

    @Override // hf.c
    public k[] c(ve.b bVar) throws NotFoundException {
        return b(bVar, null);
    }

    @Override // ve.j
    public k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        k[] kVarArrE = e(bVar, map, false);
        if (kVarArrE.length == 0 || kVarArrE[0] == null) {
            throw NotFoundException.b();
        }
        return kVarArrE[0];
    }

    @Override // ve.j
    public void reset() {
    }
}
