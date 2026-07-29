package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class j extends x {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f21444k = new int[4];

    @Override // com.google.zxing.oned.x
    public int l(af.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f21444k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iL = aVar.l();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < iL; i11++) {
            sb2.append((char) (x.j(aVar, iArr2, i10, x.f21522i) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = x.n(aVar, i10, true, x.f21520g)[1];
        for (int i14 = 0; i14 < 4 && i13 < iL; i14++) {
            sb2.append((char) (x.j(aVar, iArr2, i13, x.f21522i) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // com.google.zxing.oned.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_8;
    }
}
