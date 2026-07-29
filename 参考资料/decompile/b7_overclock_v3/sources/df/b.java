package df;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.k;
import ve.n;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements n {
    public static af.b c(com.google.zxing.qrcode.encoder.b bVar, int i10, int i11) {
        af.b bVar2;
        int iE = bVar.e();
        int iD = bVar.d();
        int iMax = Math.max(i10, iE);
        int iMax2 = Math.max(i11, iD);
        int iMin = Math.min(iMax / iE, iMax2 / iD);
        int i12 = (iMax - (iE * iMin)) / 2;
        int i13 = (iMax2 - (iD * iMin)) / 2;
        if (i11 < iD || i10 < iE) {
            bVar2 = new af.b(iE, iD);
            i12 = 0;
            i13 = 0;
        } else {
            bVar2 = new af.b(i10, i11);
        }
        bVar2.b();
        int i14 = 0;
        while (i14 < iD) {
            int i15 = i12;
            int i16 = 0;
            while (i16 < iE) {
                if (bVar.b(i16, i14) == 1) {
                    bVar2.t(i15, i13, iMin, iMin);
                }
                i16++;
                i15 += iMin;
            }
            i14++;
            i13 += iMin;
        }
        return bVar2;
    }

    public static af.b d(e eVar, k kVar, int i10, int i11) {
        int i12 = kVar.i();
        int iH = kVar.h();
        com.google.zxing.qrcode.encoder.b bVar = new com.google.zxing.qrcode.encoder.b(kVar.k(), kVar.j());
        int i13 = 0;
        for (int i14 = 0; i14 < iH; i14++) {
            if (i14 % kVar.f21359e == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < kVar.k(); i16++) {
                    bVar.h(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < i12; i18++) {
                if (i18 % kVar.f21358d == 0) {
                    bVar.h(i17, i13, true);
                    i17++;
                }
                bVar.h(i17, i13, eVar.e(i18, i14));
                i17++;
                int i19 = kVar.f21358d;
                if (i18 % i19 == i19 - 1) {
                    bVar.h(i17, i13, i14 % 2 == 0);
                    i17++;
                }
            }
            i13++;
            int i20 = kVar.f21359e;
            if (i14 % i20 == i20 - 1) {
                int i21 = 0;
                for (int i22 = 0; i22 < kVar.k(); i22++) {
                    bVar.h(i21, i13, true);
                    i21++;
                }
                i13++;
            }
        }
        return c(bVar, i10, i11);
    }

    @Override // ve.n
    public af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return b(str, barcodeFormat, i10, i11, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    @Override // ve.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public af.b b(java.lang.String r8, com.google.zxing.BarcodeFormat r9, int r10, int r11, java.util.Map<com.google.zxing.EncodeHintType, ?> r12) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: df.b.b(java.lang.String, com.google.zxing.BarcodeFormat, int, int, java.util.Map):af.b");
    }
}
