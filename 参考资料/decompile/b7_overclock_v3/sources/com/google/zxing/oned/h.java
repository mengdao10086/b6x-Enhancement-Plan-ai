package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends x {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f21441l = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f21442k = new int[4];

    public static void s(StringBuilder sb2, int i10) throws NotFoundException {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f21441l[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw NotFoundException.b();
    }

    @Override // com.google.zxing.oned.x
    public int l(af.a aVar, int[] iArr, StringBuilder sb2) throws NotFoundException {
        int[] iArr2 = this.f21442k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iL = aVar.l();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < iL; i12++) {
            int iJ = x.j(aVar, iArr2, i10, x.f21523j);
            sb2.append((char) ((iJ % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (iJ >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        s(sb2, i11);
        int i14 = x.n(aVar, i10, true, x.f21520g)[1];
        for (int i15 = 0; i15 < 6 && i14 < iL; i15++) {
            sb2.append((char) (x.j(aVar, iArr2, i14, x.f21522i) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        return i14;
    }

    @Override // com.google.zxing.oned.x
    public BarcodeFormat q() {
        return BarcodeFormat.EAN_13;
    }
}
