package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21460d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21461e = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f21458b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f21459c = {3, 1, 1};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[][] f21462f = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        r.d(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iC = r.c(zArr, 0, f21458b, true);
        for (int i10 = 0; i10 < length; i10 += 2) {
            int iDigit = Character.digit(str.charAt(i10), 10);
            int iDigit2 = Character.digit(str.charAt(i10 + 1), 10);
            int[] iArr = new int[10];
            for (int i11 = 0; i11 < 5; i11++) {
                int i12 = i11 * 2;
                int[][] iArr2 = f21462f;
                iArr[i12] = iArr2[iDigit][i11];
                iArr[i12 + 1] = iArr2[iDigit2][i11];
            }
            iC += r.c(zArr, iC, iArr, true);
        }
        r.c(zArr, iC, f21459c, true);
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
