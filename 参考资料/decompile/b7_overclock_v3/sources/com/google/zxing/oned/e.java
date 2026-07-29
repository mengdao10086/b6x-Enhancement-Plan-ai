package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public final class e extends r {
    public static void j(int i10, int[] iArr) {
        for (int i11 = 0; i11 < 9; i11++) {
            int i12 = 1;
            if (((1 << (8 - i11)) & i10) != 0) {
                i12 = 2;
            }
            iArr[i11] = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String k(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.e.k(java.lang.String):java.lang.String");
    }

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (d.f21428e.indexOf(str.charAt(i10)) < 0) {
                str = k(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i10++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        j(d.f21430g, iArr);
        int iC = r.c(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iC2 = iC + r.c(zArr, iC, iArr2, false);
        for (int i11 = 0; i11 < length; i11++) {
            j(d.f21429f[d.f21428e.indexOf(str.charAt(i11))], iArr);
            int iC3 = iC2 + r.c(zArr, iC2, iArr, true);
            iC2 = iC3 + r.c(zArr, iC3, iArr2, false);
        }
        j(d.f21430g, iArr);
        r.c(zArr, iC2, iArr, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
