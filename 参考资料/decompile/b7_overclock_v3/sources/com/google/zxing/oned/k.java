package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public final class k extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21445b = 67;

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + x.r(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
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
        boolean[] zArr = new boolean[67];
        int iC = r.c(zArr, 0, x.f21519f, true) + 0;
        for (int i10 = 0; i10 <= 3; i10++) {
            iC += r.c(zArr, iC, x.f21522i[Character.digit(str.charAt(i10), 10)], false);
        }
        int iC2 = iC + r.c(zArr, iC, x.f21520g, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            iC2 += r.c(zArr, iC2, x.f21522i[Character.digit(str.charAt(i11), 10)], true);
        }
        r.c(zArr, iC2, x.f21519f, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
