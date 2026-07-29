package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x[] f21465b = new x[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x[] f21466a;

    public p(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new h());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new s());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new j());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new z());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new h());
            arrayList.add(new j());
            arrayList.add(new z());
        }
        this.f21466a = (x[]) arrayList.toArray(f21465b);
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int[] iArrP = x.p(aVar);
        for (x xVar : this.f21466a) {
            try {
                ve.k kVarM = xVar.m(i10, aVar, iArrP, map);
                boolean z10 = kVarM.b() == BarcodeFormat.EAN_13 && kVarM.g().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z11 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z10 || !z11) {
                    return kVarM;
                }
                ve.k kVar = new ve.k(kVarM.g().substring(1), kVarM.d(), kVarM.f(), BarcodeFormat.UPC_A);
                kVar.i(kVarM.e());
                return kVar;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.b();
    }

    @Override // com.google.zxing.oned.q, ve.j
    public void reset() {
        for (x xVar : this.f21466a) {
            xVar.reset();
        }
    }
}
