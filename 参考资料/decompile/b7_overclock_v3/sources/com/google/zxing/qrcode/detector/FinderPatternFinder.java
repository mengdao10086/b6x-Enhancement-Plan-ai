package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ve.l;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public class FinderPatternFinder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21617f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final EstimatedModuleComparator f21618g = new EstimatedModuleComparator();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21619h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21620i = 97;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d> f21622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f21624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f21625e;

    public static final class EstimatedModuleComparator implements Comparator<d>, Serializable {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }
    }

    public FinderPatternFinder(af.b bVar) {
        this(bVar, null);
    }

    public static float a(int[] iArr, int i10) {
        return ((i10 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void f(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void g(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean j(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 2.0f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    public static boolean k(int[] iArr) {
        int i10 = 0;
        for (int i11 = 0; i11 < 5; i11++) {
            int i12 = iArr[i11];
            if (i12 == 0) {
                return false;
            }
            i10 += i12;
        }
        if (i10 < 7) {
            return false;
        }
        float f10 = i10 / 7.0f;
        float f11 = f10 / 1.333f;
        return Math.abs(f10 - ((float) iArr[0])) < f11 && Math.abs(f10 - ((float) iArr[1])) < f11 && Math.abs((f10 * 3.0f) - ((float) iArr[2])) < 3.0f * f11 && Math.abs(f10 - ((float) iArr[3])) < f11 && Math.abs(f10 - ((float) iArr[4])) < f11;
    }

    public static double t(d dVar, d dVar2) {
        double dC = dVar.c() - dVar2.c();
        double d10 = dVar.d() - dVar2.d();
        return (dC * dC) + (d10 * d10);
    }

    @Deprecated
    public final void b(int[] iArr) {
        f(iArr);
    }

    public final boolean c(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int[] iArrL = l();
        int i15 = 0;
        while (i10 >= i15 && i11 >= i15 && this.f21621a.f(i11 - i15, i10 - i15)) {
            iArrL[2] = iArrL[2] + 1;
            i15++;
        }
        if (iArrL[2] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && !this.f21621a.f(i11 - i15, i10 - i15)) {
            iArrL[1] = iArrL[1] + 1;
            i15++;
        }
        if (iArrL[1] == 0) {
            return false;
        }
        while (i10 >= i15 && i11 >= i15 && this.f21621a.f(i11 - i15, i10 - i15)) {
            iArrL[0] = iArrL[0] + 1;
            i15++;
        }
        if (iArrL[0] == 0) {
            return false;
        }
        int i16 = this.f21621a.i();
        int iM = this.f21621a.m();
        int i17 = 1;
        while (true) {
            int i18 = i10 + i17;
            if (i18 >= i16 || (i14 = i11 + i17) >= iM || !this.f21621a.f(i14, i18)) {
                break;
            }
            iArrL[2] = iArrL[2] + 1;
            i17++;
        }
        while (true) {
            int i19 = i10 + i17;
            if (i19 >= i16 || (i13 = i11 + i17) >= iM || this.f21621a.f(i13, i19)) {
                break;
            }
            iArrL[3] = iArrL[3] + 1;
            i17++;
        }
        if (iArrL[3] == 0) {
            return false;
        }
        while (true) {
            int i20 = i10 + i17;
            if (i20 >= i16 || (i12 = i11 + i17) >= iM || !this.f21621a.f(i12, i20)) {
                break;
            }
            iArrL[4] = iArrL[4] + 1;
            i17++;
        }
        if (iArrL[4] == 0) {
            return false;
        }
        return k(iArrL);
    }

    public final float d(int i10, int i11, int i12, int i13) {
        af.b bVar = this.f21621a;
        int iM = bVar.m();
        int[] iArrL = l();
        int i14 = i10;
        while (i14 >= 0 && bVar.f(i14, i11)) {
            iArrL[2] = iArrL[2] + 1;
            i14--;
        }
        if (i14 < 0) {
            return Float.NaN;
        }
        while (i14 >= 0 && !bVar.f(i14, i11) && iArrL[1] <= i12) {
            iArrL[1] = iArrL[1] + 1;
            i14--;
        }
        if (i14 < 0 || iArrL[1] > i12) {
            return Float.NaN;
        }
        while (i14 >= 0 && bVar.f(i14, i11) && iArrL[0] <= i12) {
            iArrL[0] = iArrL[0] + 1;
            i14--;
        }
        if (iArrL[0] > i12) {
            return Float.NaN;
        }
        int i15 = i10 + 1;
        while (i15 < iM && bVar.f(i15, i11)) {
            iArrL[2] = iArrL[2] + 1;
            i15++;
        }
        if (i15 == iM) {
            return Float.NaN;
        }
        while (i15 < iM && !bVar.f(i15, i11) && iArrL[3] < i12) {
            iArrL[3] = iArrL[3] + 1;
            i15++;
        }
        if (i15 == iM || iArrL[3] >= i12) {
            return Float.NaN;
        }
        while (i15 < iM && bVar.f(i15, i11) && iArrL[4] < i12) {
            iArrL[4] = iArrL[4] + 1;
            i15++;
        }
        if (iArrL[4] < i12 && Math.abs(((((iArrL[0] + iArrL[1]) + iArrL[2]) + iArrL[3]) + iArrL[4]) - i13) * 5 < i13 && j(iArrL)) {
            return a(iArrL, i15);
        }
        return Float.NaN;
    }

    public final float e(int i10, int i11, int i12, int i13) {
        af.b bVar = this.f21621a;
        int i14 = bVar.i();
        int[] iArrL = l();
        int i15 = i10;
        while (i15 >= 0 && bVar.f(i11, i15)) {
            iArrL[2] = iArrL[2] + 1;
            i15--;
        }
        if (i15 < 0) {
            return Float.NaN;
        }
        while (i15 >= 0 && !bVar.f(i11, i15) && iArrL[1] <= i12) {
            iArrL[1] = iArrL[1] + 1;
            i15--;
        }
        if (i15 < 0 || iArrL[1] > i12) {
            return Float.NaN;
        }
        while (i15 >= 0 && bVar.f(i11, i15) && iArrL[0] <= i12) {
            iArrL[0] = iArrL[0] + 1;
            i15--;
        }
        if (iArrL[0] > i12) {
            return Float.NaN;
        }
        int i16 = i10 + 1;
        while (i16 < i14 && bVar.f(i11, i16)) {
            iArrL[2] = iArrL[2] + 1;
            i16++;
        }
        if (i16 == i14) {
            return Float.NaN;
        }
        while (i16 < i14 && !bVar.f(i11, i16) && iArrL[3] < i12) {
            iArrL[3] = iArrL[3] + 1;
            i16++;
        }
        if (i16 == i14 || iArrL[3] >= i12) {
            return Float.NaN;
        }
        while (i16 < i14 && bVar.f(i11, i16) && iArrL[4] < i12) {
            iArrL[4] = iArrL[4] + 1;
            i16++;
        }
        if (iArrL[4] < i12 && Math.abs(((((iArrL[0] + iArrL[1]) + iArrL[2]) + iArrL[3]) + iArrL[4]) - i13) * 5 < i13 * 2 && j(iArrL)) {
            return a(iArrL, i16);
        }
        return Float.NaN;
    }

    public final e h(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int i10 = this.f21621a.i();
        int iM = this.f21621a.m();
        int i11 = (i10 * 3) / gg.b.f29469o;
        if (i11 < 3 || z10) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        int i12 = i11 - 1;
        boolean zQ = false;
        while (i12 < i10 && !zQ) {
            f(iArr);
            int i13 = 0;
            int i14 = 0;
            while (i13 < iM) {
                if (this.f21621a.f(i13, i12)) {
                    if ((i14 & 1) == 1) {
                        i14++;
                    }
                    iArr[i14] = iArr[i14] + 1;
                } else if ((i14 & 1) != 0) {
                    iArr[i14] = iArr[i14] + 1;
                } else if (i14 != 4) {
                    i14++;
                    iArr[i14] = iArr[i14] + 1;
                } else if (j(iArr) && o(iArr, i12, i13)) {
                    if (this.f21623c) {
                        zQ = q();
                    } else {
                        int i15 = i();
                        if (i15 > iArr[2]) {
                            i12 += (i15 - iArr[2]) - 2;
                            i13 = iM - 1;
                        }
                    }
                    f(iArr);
                    i11 = 2;
                    i14 = 0;
                } else {
                    g(iArr);
                    i14 = 3;
                }
                i13++;
            }
            if (j(iArr) && o(iArr, i12, iM)) {
                i11 = iArr[0];
                if (this.f21623c) {
                    zQ = q();
                }
            }
            i12 += i11;
        }
        d[] dVarArrR = r();
        l.e(dVarArrR);
        return new e(dVarArrR);
    }

    public final int i() {
        if (this.f21622b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.f21622b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.f21623c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    public final int[] l() {
        f(this.f21624d);
        return this.f21624d;
    }

    public final af.b m() {
        return this.f21621a;
    }

    public final List<d> n() {
        return this.f21622b;
    }

    public final boolean o(int[] iArr, int i10, int i11) {
        boolean z10 = false;
        int i12 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iA = (int) a(iArr, i11);
        float fE = e(i10, iA, iArr[2], i12);
        if (!Float.isNaN(fE)) {
            int i13 = (int) fE;
            float fD = d(iA, i13, iArr[2], i12);
            if (!Float.isNaN(fD) && c(i13, (int) fD)) {
                float f10 = i12 / 7.0f;
                int i14 = 0;
                while (true) {
                    if (i14 >= this.f21622b.size()) {
                        break;
                    }
                    d dVar = this.f21622b.get(i14);
                    if (dVar.f(f10, fE, fD)) {
                        this.f21622b.set(i14, dVar.g(fE, fD, f10));
                        z10 = true;
                        break;
                    }
                    i14++;
                }
                if (!z10) {
                    d dVar2 = new d(fD, fE, f10);
                    this.f21622b.add(dVar2);
                    m mVar = this.f21625e;
                    if (mVar != null) {
                        mVar.a(dVar2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final boolean p(int[] iArr, int i10, int i11, boolean z10) {
        return o(iArr, i10, i11);
    }

    public final boolean q() {
        int size = this.f21622b.size();
        float fAbs = 0.0f;
        int i10 = 0;
        float fI = 0.0f;
        for (d dVar : this.f21622b) {
            if (dVar.h() >= 2) {
                i10++;
                fI += dVar.i();
            }
        }
        if (i10 < 3) {
            return false;
        }
        float f10 = fI / size;
        Iterator<d> it2 = this.f21622b.iterator();
        while (it2.hasNext()) {
            fAbs += Math.abs(it2.next().i() - f10);
        }
        return fAbs <= fI * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.zxing.qrcode.detector.d[] r() throws com.google.zxing.NotFoundException {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.r():com.google.zxing.qrcode.detector.d[]");
    }

    @Deprecated
    public final void s(int[] iArr) {
        g(iArr);
    }

    public FinderPatternFinder(af.b bVar, m mVar) {
        this.f21621a = bVar;
        this.f21622b = new ArrayList();
        this.f21624d = new int[5];
        this.f21625e = mVar;
    }
}
