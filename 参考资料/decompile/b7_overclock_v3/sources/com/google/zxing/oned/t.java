package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class t implements ve.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f21508a = new i();

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (barcodeFormat != BarcodeFormat.UPC_A) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
        }
        return this.f21508a.b('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
    }
}
