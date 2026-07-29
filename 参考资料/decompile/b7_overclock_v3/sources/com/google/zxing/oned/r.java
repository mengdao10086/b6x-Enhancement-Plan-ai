package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes7.dex */
public abstract class r implements ve.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f21467a = Pattern.compile("[0-9]+");

    public static int c(boolean[] zArr, int i10, int[] iArr, boolean z10) {
        int i11 = 0;
        for (int i12 : iArr) {
            int i13 = 0;
            while (i13 < i12) {
                zArr[i10] = z10;
                i13++;
                i10++;
            }
            i11 += i12;
            z10 = !z10;
        }
        return i11;
    }

    public static void d(String str) {
        if (!f21467a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    public static af.b i(boolean[] zArr, int i10, int i11, int i12) {
        int length = zArr.length;
        int i13 = i12 + length;
        int iMax = Math.max(i10, i13);
        int iMax2 = Math.max(1, i11);
        int i14 = iMax / i13;
        int i15 = (iMax - (length * i14)) / 2;
        af.b bVar = new af.b(iMax, iMax2);
        int i16 = 0;
        while (i16 < length) {
            if (zArr[i16]) {
                bVar.t(i15, 0, i14, iMax2);
            }
            i16++;
            i15 += i14;
        }
        return bVar;
    }

    @Override // ve.n
    public final af.b a(String str, BarcodeFormat barcodeFormat, int i10, int i11) {
        return b(str, barcodeFormat, i10, i11, null);
    }

    @Override // ve.n
    public af.b b(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i10 + 'x' + i11);
        }
        Collection<BarcodeFormat> collectionH = h();
        if (collectionH == null || collectionH.contains(barcodeFormat)) {
            int iG = g();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    iG = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return i(f(str, map), i10, i11, iG);
        }
        throw new IllegalArgumentException("Can only encode " + collectionH + ", but got " + barcodeFormat);
    }

    public abstract boolean[] e(String str);

    public boolean[] f(String str, Map<EncodeHintType, ?> map) {
        return e(str);
    }

    public int g() {
        return 10;
    }

    public Collection<BarcodeFormat> h() {
        return null;
    }
}
