package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public final class i extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21443b = 95;

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + x.r(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
            }
            try {
                if (!x.i(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        r.d(str);
        int i10 = h.f21441l[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iC = r.c(zArr, 0, x.f21519f, true) + 0;
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit += 10;
            }
            iC += r.c(zArr, iC, x.f21523j[iDigit], false);
        }
        int iC2 = iC + r.c(zArr, iC, x.f21520g, false);
        for (int i12 = 7; i12 <= 12; i12++) {
            iC2 += r.c(zArr, iC2, x.f21522i[Character.digit(str.charAt(i12), 10)], true);
        }
        r.c(zArr, iC2, x.f21519f, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
