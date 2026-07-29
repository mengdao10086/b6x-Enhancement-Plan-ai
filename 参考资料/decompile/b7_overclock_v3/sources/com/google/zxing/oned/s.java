package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class s extends x {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final x f21507k = new h();

    public static ve.k s(ve.k kVar) throws FormatException {
        String strG = kVar.g();
        if (strG.charAt(0) != '0') {
            throw FormatException.b();
        }
        ve.k kVar2 = new ve.k(strG.substring(1), null, kVar.f(), BarcodeFormat.UPC_A);
        if (kVar.e() != null) {
            kVar2.i(kVar.e());
        }
        return kVar2;
    }

    @Override // com.google.zxing.oned.q, ve.j
    public ve.k a(ve.b bVar) throws NotFoundException, FormatException {
        return s(this.f21507k.a(bVar));
    }

    @Override // com.google.zxing.oned.x, com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return s(this.f21507k.b(i10, aVar, map));
    }

    @Override // com.google.zxing.oned.q, ve.j
    public ve.k d(ve.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return s(this.f21507k.d(bVar, map));
    }

    @Override // com.google.zxing.oned.x
    public int l(af.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        return this.f21507k.l(aVar, iArr, sb2);
    }

    @Override // com.google.zxing.oned.x
    public ve.k m(int i10, af.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return s(this.f21507k.m(i10, aVar, iArr, map));
    }

    @Override // com.google.zxing.oned.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}
