package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21407b = 51;

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(z.s(str));
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!x.i(z.s(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.d(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = z.f21528m[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iC = r.c(zArr, 0, x.f21519f, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit2 += 10;
            }
            iC += r.c(zArr, iC, x.f21523j[iDigit2], false);
        }
        r.c(zArr, iC, x.f21521h, false);
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
