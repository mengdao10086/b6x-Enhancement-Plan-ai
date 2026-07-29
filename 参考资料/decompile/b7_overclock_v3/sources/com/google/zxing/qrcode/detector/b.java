package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import ve.m;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21627a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f21629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f21631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f21633g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final m f21635i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f21628b = new ArrayList(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f21634h = new int[3];

    public b(af.b bVar, int i10, int i11, int i12, int i13, float f10, m mVar) {
        this.f21627a = bVar;
        this.f21629c = i10;
        this.f21630d = i11;
        this.f21631e = i12;
        this.f21632f = i13;
        this.f21633g = f10;
        this.f21635i = mVar;
    }

    public static float a(int[] iArr, int i10) {
        return (i10 - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i10, int i11, int i12, int i13) {
        af.b bVar = this.f21627a;
        int i14 = bVar.i();
        int[] iArr = this.f21634h;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i15 = i10;
        while (i15 >= 0 && bVar.f(i11, i15) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i15--;
        }
        if (i15 < 0 || iArr[1] > i12) {
            return Float.NaN;
        }
        while (i15 >= 0 && !bVar.f(i11, i15) && iArr[0] <= i12) {
            iArr[0] = iArr[0] + 1;
            i15--;
        }
        if (iArr[0] > i12) {
            return Float.NaN;
        }
        int i16 = i10 + 1;
        while (i16 < i14 && bVar.f(i11, i16) && iArr[1] <= i12) {
            iArr[1] = iArr[1] + 1;
            i16++;
        }
        if (i16 == i14 || iArr[1] > i12) {
            return Float.NaN;
        }
        while (i16 < i14 && !bVar.f(i11, i16) && iArr[2] <= i12) {
            iArr[2] = iArr[2] + 1;
            i16++;
        }
        if (iArr[2] <= i12 && Math.abs(((iArr[0] + iArr[1]) + iArr[2]) - i13) * 5 < i13 * 2 && d(iArr)) {
            return a(iArr, i16);
        }
        return Float.NaN;
    }

    public a c() throws NotFoundException {
        a aVarE;
        a aVarE2;
        int i10 = this.f21629c;
        int i11 = this.f21632f;
        int i12 = this.f21631e + i10;
        int i13 = this.f21630d + (i11 / 2);
        int[] iArr = new int[3];
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i14 & 1) == 0 ? (i14 + 1) / 2 : -((i14 + 1) / 2)) + i13;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i16 = i10;
            while (i16 < i12 && !this.f21627a.f(i16, i15)) {
                i16++;
            }
            int i17 = 0;
            while (i16 < i12) {
                if (!this.f21627a.f(i16, i15)) {
                    if (i17 == 1) {
                        i17++;
                    }
                    iArr[i17] = iArr[i17] + 1;
                } else if (i17 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i17 != 2) {
                    i17++;
                    iArr[i17] = iArr[i17] + 1;
                } else {
                    if (d(iArr) && (aVarE2 = e(iArr, i15, i16)) != null) {
                        return aVarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i17 = 1;
                }
                i16++;
            }
            if (d(iArr) && (aVarE = e(iArr, i15, i12)) != null) {
                return aVarE;
            }
        }
        if (this.f21628b.isEmpty()) {
            throw NotFoundException.b();
        }
        return this.f21628b.get(0);
    }

    public final boolean d(int[] iArr) {
        float f10 = this.f21633g;
        float f11 = f10 / 2.0f;
        for (int i10 = 0; i10 < 3; i10++) {
            if (Math.abs(f10 - iArr[i10]) >= f11) {
                return false;
            }
        }
        return true;
    }

    public final a e(int[] iArr, int i10, int i11) {
        int i12 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i11);
        float fB = b(i10, (int) fA, iArr[1] * 2, i12);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f10 = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (a aVar : this.f21628b) {
            if (aVar.f(f10, fB, fA)) {
                return aVar.g(fB, fA, f10);
            }
        }
        a aVar2 = new a(fA, fB, f10);
        this.f21628b.add(aVar2);
        m mVar = this.f21635i;
        if (mVar == null) {
            return null;
        }
        mVar.a(aVar2);
        return null;
    }
}
