package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f21448b = 0.38f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float f21449c = 0.5f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21450d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21451e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21452f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f21453g = {6, 8, 10, 12, 14};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f21454h = {1, 1, 1, 1};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[][] f21455i = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[][] f21456j = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21457a = -1;

    public static int h(int[] iArr) throws NotFoundException {
        int length = f21456j.length;
        float f10 = 0.38f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float fE = q.e(iArr, f21456j[i11], 0.5f);
            if (fE < f10) {
                i10 = i11;
                f10 = fE;
            } else if (fE == f10) {
                i10 = -1;
            }
        }
        if (i10 >= 0) {
            return i10 % 10;
        }
        throw NotFoundException.b();
    }

    public static void j(af.a aVar, int i10, int i11, StringBuilder sb2) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            q.f(aVar, i10, iArr);
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                iArr2[i12] = iArr[i13];
                iArr3[i12] = iArr[i13 + 1];
            }
            sb2.append((char) (h(iArr2) + 48));
            sb2.append((char) (h(iArr3) + 48));
            for (int i14 = 0; i14 < 10; i14++) {
                i10 += iArr[i14];
            }
        }
    }

    public static int[] l(af.a aVar, int i10, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iL = aVar.l();
        int i11 = i10;
        boolean z10 = false;
        int i12 = 0;
        while (i10 < iL) {
            if (aVar.h(i10) != z10) {
                iArr2[i12] = iArr2[i12] + 1;
            } else {
                if (i12 != length - 1) {
                    i12++;
                } else {
                    if (q.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i11, i10};
                    }
                    i11 += iArr2[0] + iArr2[1];
                    int i13 = i12 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i12] = 0;
                    i12--;
                }
                iArr2[i12] = 1;
                z10 = !z10;
            }
            i10++;
        }
        throw NotFoundException.b();
    }

    public static int m(af.a aVar) throws NotFoundException {
        int iL = aVar.l();
        int iJ = aVar.j(0);
        if (iJ != iL) {
            return iJ;
        }
        throw NotFoundException.b();
    }

    @Override // com.google.zxing.oned.q
    public ve.k b(int i10, af.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z10;
        int[] iArrK = k(aVar);
        int[] iArrI = i(aVar);
        StringBuilder sb2 = new StringBuilder(20);
        j(aVar, iArrK[1], iArrI[0], sb2);
        String string = sb2.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f21453g;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= length2) {
                z10 = false;
                break;
            }
            int i13 = iArr[i11];
            if (length == i13) {
                z10 = true;
                break;
            }
            if (i13 > i12) {
                i12 = i13;
            }
            i11++;
        }
        if (!z10 && length > i12) {
            z10 = true;
        }
        if (!z10) {
            throw FormatException.b();
        }
        float f10 = i10;
        ve.k kVar = new ve.k(string, null, new ve.l[]{new ve.l(iArrK[1], f10), new ve.l(iArrI[0], f10)}, BarcodeFormat.ITF);
        kVar.j(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]I0");
        return kVar;
    }

    public final int[] i(af.a aVar) throws NotFoundException {
        int[] iArrL;
        aVar.p();
        try {
            int iM = m(aVar);
            try {
                iArrL = l(aVar, iM, f21455i[0]);
            } catch (NotFoundException unused) {
                iArrL = l(aVar, iM, f21455i[1]);
            }
            n(aVar, iArrL[0]);
            int i10 = iArrL[0];
            iArrL[0] = aVar.l() - iArrL[1];
            iArrL[1] = aVar.l() - i10;
            return iArrL;
        } finally {
            aVar.p();
        }
    }

    public final int[] k(af.a aVar) throws NotFoundException {
        int[] iArrL = l(aVar, m(aVar), f21454h);
        this.f21457a = (iArrL[1] - iArrL[0]) / 4;
        n(aVar, iArrL[0]);
        return iArrL;
    }

    public final void n(af.a aVar, int i10) throws NotFoundException {
        int iMin = Math.min(this.f21457a * 10, i10);
        for (int i11 = i10 - 1; iMin > 0 && i11 >= 0 && !aVar.h(i11); i11--) {
            iMin--;
        }
        if (iMin != 0) {
            throw NotFoundException.b();
        }
    }
}
