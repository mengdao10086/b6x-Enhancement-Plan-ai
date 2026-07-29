package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q[] f21463b = new q[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q[] f21464a;

    public o(Map<DecodeHintType, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z10 = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new p(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new d(z10));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new f());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new c());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new m());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new a());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new p001if.e());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new jf.d());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new p(map));
            arrayList.add(new d());
            arrayList.add(new a());
            arrayList.add(new f());
            arrayList.add(new c());
            arrayList.add(new m());
            arrayList.add(new p001if.e());
            arrayList.add(new jf.d());
        }
        this.f21464a = (q[]) arrayList.toArray(f21463b);
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        for (q qVar : this.f21464a) {
            try {
                return qVar.b(i10, aVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.b();
    }

    @Override // com.google.zxing.oned.q, ve.j
    public void reset() {
        for (q qVar : this.f21464a) {
            qVar.reset();
        }
    }
}
