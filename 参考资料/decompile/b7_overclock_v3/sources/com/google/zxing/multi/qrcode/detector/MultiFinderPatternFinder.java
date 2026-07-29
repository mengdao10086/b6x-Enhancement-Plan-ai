package com.google.zxing.multi.qrcode.detector;

import af.b;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.d;
import com.google.zxing.qrcode.detector.e;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import ve.l;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public final class MultiFinderPatternFinder extends FinderPatternFinder {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final e[] f21365j = new e[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d[] f21366k = new d[0];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d[][] f21367l = new d[0][];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final float f21368m = 180.0f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final float f21369n = 9.0f;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final float f21370o = 0.05f;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final float f21371p = 0.5f;

    public static final class ModuleSizeComparator implements Comparator<d>, Serializable {
        private ModuleSizeComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            double dI = dVar2.i() - dVar.i();
            if (dI < 0.0d) {
                return -1;
            }
            return dI > 0.0d ? 1 : 0;
        }
    }

    public MultiFinderPatternFinder(b bVar, m mVar) {
        super(bVar, mVar);
    }

    public e[] u(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z10 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        b bVarM = m();
        int i10 = bVarM.i();
        int iM = bVarM.m();
        int i11 = (i10 * 3) / gg.b.f29469o;
        if (i11 < 3 || z10) {
            i11 = 3;
        }
        int[] iArr = new int[5];
        for (int i12 = i11 - 1; i12 < i10; i12 += i11) {
            FinderPatternFinder.f(iArr);
            int i13 = 0;
            for (int i14 = 0; i14 < iM; i14++) {
                if (bVarM.f(i14, i12)) {
                    if ((i13 & 1) == 1) {
                        i13++;
                    }
                    iArr[i13] = iArr[i13] + 1;
                } else if ((i13 & 1) != 0) {
                    iArr[i13] = iArr[i13] + 1;
                } else if (i13 != 4) {
                    i13++;
                    iArr[i13] = iArr[i13] + 1;
                } else if (FinderPatternFinder.j(iArr) && o(iArr, i12, i14)) {
                    FinderPatternFinder.f(iArr);
                    i13 = 0;
                } else {
                    FinderPatternFinder.g(iArr);
                    i13 = 3;
                }
            }
            if (FinderPatternFinder.j(iArr)) {
                o(iArr, i12, iM);
            }
        }
        d[][] dVarArrV = v();
        ArrayList arrayList = new ArrayList();
        for (d[] dVarArr : dVarArrV) {
            l.e(dVarArr);
            arrayList.add(new e(dVarArr));
        }
        return arrayList.isEmpty() ? f21365j : (e[]) arrayList.toArray(f21365j);
    }

    public final d[][] v() throws NotFoundException {
        ArrayList arrayList;
        int i10;
        ArrayList arrayList2 = new ArrayList();
        for (d dVar : n()) {
            if (dVar.h() >= 2) {
                arrayList2.add(dVar);
            }
        }
        int size = arrayList2.size();
        int i11 = 3;
        if (size < 3) {
            throw NotFoundException.b();
        }
        char c10 = 0;
        if (size == 3) {
            return new d[][]{(d[]) arrayList2.toArray(f21366k)};
        }
        Collections.sort(arrayList2, new ModuleSizeComparator());
        ArrayList arrayList3 = new ArrayList();
        int i12 = 0;
        while (i12 < size - 2) {
            d dVar2 = (d) arrayList2.get(i12);
            if (dVar2 != null) {
                int i13 = i12 + 1;
                while (i13 < size - 1) {
                    d dVar3 = (d) arrayList2.get(i13);
                    if (dVar3 != null) {
                        float fI = (dVar2.i() - dVar3.i()) / Math.min(dVar2.i(), dVar3.i());
                        float f10 = 0.05f;
                        float f11 = 0.5f;
                        if (Math.abs(dVar2.i() - dVar3.i()) > 0.5f && fI >= 0.05f) {
                            break;
                        }
                        int i14 = i13 + 1;
                        while (i14 < size) {
                            d dVar4 = (d) arrayList2.get(i14);
                            if (dVar4 != null) {
                                float fI2 = (dVar3.i() - dVar4.i()) / Math.min(dVar3.i(), dVar4.i());
                                if (Math.abs(dVar3.i() - dVar4.i()) > f11 && fI2 >= f10) {
                                    break;
                                }
                                d[] dVarArr = new d[i11];
                                dVarArr[c10] = dVar2;
                                dVarArr[1] = dVar3;
                                dVarArr[2] = dVar4;
                                l.e(dVarArr);
                                e eVar = new e(dVarArr);
                                float fB = l.b(eVar.b(), eVar.a());
                                float fB2 = l.b(eVar.c(), eVar.a());
                                float fB3 = l.b(eVar.b(), eVar.c());
                                float fI3 = (fB + fB3) / (dVar2.i() * 2.0f);
                                if (fI3 > 180.0f || fI3 < 9.0f || Math.abs((fB - fB3) / Math.min(fB, fB3)) >= 0.1f) {
                                    arrayList = arrayList2;
                                    i10 = size;
                                } else {
                                    double d10 = fB;
                                    arrayList = arrayList2;
                                    i10 = size;
                                    double d11 = fB3;
                                    float fSqrt = (float) Math.sqrt((d10 * d10) + (d11 * d11));
                                    if (Math.abs((fB2 - fSqrt) / Math.min(fB2, fSqrt)) < 0.1f) {
                                        arrayList3.add(dVarArr);
                                    }
                                }
                            } else {
                                arrayList = arrayList2;
                                i10 = size;
                            }
                            i14++;
                            size = i10;
                            arrayList2 = arrayList;
                            i11 = 3;
                            c10 = 0;
                            f10 = 0.05f;
                            f11 = 0.5f;
                        }
                    }
                    i13++;
                    size = size;
                    arrayList2 = arrayList2;
                    i11 = 3;
                    c10 = 0;
                }
            }
            i12++;
            size = size;
            arrayList2 = arrayList2;
            i11 = 3;
            c10 = 0;
        }
        if (arrayList3.isEmpty()) {
            throw NotFoundException.b();
        }
        return (d[][]) arrayList3.toArray(f21367l);
    }
}
