package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public class g extends r {
    @Deprecated
    public static int c(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int length = iArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i10 + 1;
            zArr[i10] = iArr[i11] != 0;
            i11++;
            i10 = i12;
        }
        return 9;
    }

    public static int j(boolean[] zArr, int i10, int i11) {
        for (int i12 = 0; i12 < 9; i12++) {
            boolean z10 = true;
            int i13 = i10 + i12;
            if (((1 << (8 - i12)) & i11) == 0) {
                z10 = false;
            }
            zArr[i13] = z10;
        }
        return 9;
    }

    public static int k(String str, int i10) {
        int iIndexOf = 0;
        int i11 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += f.f21435c.indexOf(str.charAt(length)) * i11;
            i11++;
            if (i11 > i10) {
                i11 = 1;
            }
        }
        return iIndexOf % 47;
    }

    public static String l(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length * 2);
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == 0) {
                sb2.append("bU");
            } else if (cCharAt <= 26) {
                sb2.append('a');
                sb2.append((char) ((cCharAt + 'A') - 1));
            } else if (cCharAt <= 31) {
                sb2.append('b');
                sb2.append((char) ((cCharAt + 'A') - 27));
            } else if (cCharAt == ' ' || cCharAt == '$' || cCharAt == '%' || cCharAt == '+') {
                sb2.append(cCharAt);
            } else if (cCharAt <= ',') {
                sb2.append('c');
                sb2.append((char) ((cCharAt + 'A') - 33));
            } else if (cCharAt <= '9') {
                sb2.append(cCharAt);
            } else if (cCharAt == ':') {
                sb2.append("cZ");
            } else if (cCharAt <= '?') {
                sb2.append('b');
                sb2.append((char) ((cCharAt + 'F') - 59));
            } else if (cCharAt == '@') {
                sb2.append("bV");
            } else if (cCharAt <= 'Z') {
                sb2.append(cCharAt);
            } else if (cCharAt <= '_') {
                sb2.append('b');
                sb2.append((char) ((cCharAt + 'K') - 91));
            } else if (cCharAt == '`') {
                sb2.append("bW");
            } else if (cCharAt <= 'z') {
                sb2.append('d');
                sb2.append((char) ((cCharAt + 'A') - 97));
            } else {
                if (cCharAt > 127) {
                    throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + cCharAt + "'");
                }
                sb2.append('b');
                sb2.append((char) (cCharAt + 'P' + com.blankj.utilcode.util.f.f11760c));
            }
        }
        return sb2.toString();
    }

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        String strL = l(str);
        int length = strL.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got " + length);
        }
        boolean[] zArr = new boolean[((strL.length() + 2 + 2) * 9) + 1];
        int iJ = j(zArr, 0, f.f21438f);
        for (int i10 = 0; i10 < length; i10++) {
            iJ += j(zArr, iJ, f.f21437e[f.f21435c.indexOf(strL.charAt(i10))]);
        }
        int iK = k(strL, 20);
        int[] iArr = f.f21437e;
        int iJ2 = iJ + j(zArr, iJ, iArr[iK]);
        int iJ3 = iJ2 + j(zArr, iJ2, iArr[k(strL + f.f21435c.charAt(iK), 15)]);
        zArr[iJ3 + j(zArr, iJ3, f.f21438f)] = true;
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.CODE_93);
    }
}
