package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21578e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f[] f21580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f21581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21582d;

    public e(a aVar, c cVar) {
        this.f21579a = aVar;
        int iA = aVar.a();
        this.f21582d = iA;
        this.f21581c = cVar;
        this.f21580b = new f[iA + 2];
    }

    public static boolean b(d dVar, d dVar2) {
        if (dVar2 == null || !dVar2.g() || dVar2.a() != dVar.a()) {
            return false;
        }
        dVar.i(dVar2.c());
        return true;
    }

    public static int c(int i10, int i11, d dVar) {
        if (dVar == null || dVar.g()) {
            return i11;
        }
        if (!dVar.h(i10)) {
            return i11 + 1;
        }
        dVar.i(i10);
        return 0;
    }

    public final void a(f fVar) {
        if (fVar != null) {
            ((g) fVar).g(this.f21579a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i10 = 1; i10 < this.f21582d + 1; i10++) {
            d[] dVarArrD = this.f21580b[i10].d();
            for (int i11 = 0; i11 < dVarArrD.length; i11++) {
                if (dVarArrD[i11] != null && !dVarArrD[i11].g()) {
                    e(i10, i11, dVarArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i10, int i11, d[] dVarArr) {
        d dVar = dVarArr[i11];
        d[] dVarArrD = this.f21580b[i10 - 1].d();
        f[] fVarArr = this.f21580b;
        int i12 = i10 + 1;
        d[] dVarArrD2 = fVarArr[i12] != null ? fVarArr[i12].d() : dVarArrD;
        d[] dVarArr2 = new d[14];
        dVarArr2[2] = dVarArrD[i11];
        dVarArr2[3] = dVarArrD2[i11];
        if (i11 > 0) {
            int i13 = i11 - 1;
            dVarArr2[0] = dVarArr[i13];
            dVarArr2[4] = dVarArrD[i13];
            dVarArr2[5] = dVarArrD2[i13];
        }
        if (i11 > 1) {
            int i14 = i11 - 2;
            dVarArr2[8] = dVarArr[i14];
            dVarArr2[10] = dVarArrD[i14];
            dVarArr2[11] = dVarArrD2[i14];
        }
        if (i11 < dVarArr.length - 1) {
            int i15 = i11 + 1;
            dVarArr2[1] = dVarArr[i15];
            dVarArr2[6] = dVarArrD[i15];
            dVarArr2[7] = dVarArrD2[i15];
        }
        if (i11 < dVarArr.length - 2) {
            int i16 = i11 + 2;
            dVarArr2[9] = dVarArr[i16];
            dVarArr2[12] = dVarArrD[i16];
            dVarArr2[13] = dVarArrD2[i16];
        }
        for (int i17 = 0; i17 < 14 && !b(dVar, dVarArr2[i17]); i17++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        f[] fVarArr = this.f21580b;
        if (fVarArr[0] == null || fVarArr[this.f21582d + 1] == null) {
            return;
        }
        d[] dVarArrD = fVarArr[0].d();
        d[] dVarArrD2 = this.f21580b[this.f21582d + 1].d();
        for (int i10 = 0; i10 < dVarArrD.length; i10++) {
            if (dVarArrD[i10] != null && dVarArrD2[i10] != null && dVarArrD[i10].c() == dVarArrD2[i10].c()) {
                for (int i11 = 1; i11 <= this.f21582d; i11++) {
                    d dVar = this.f21580b[i11].d()[i10];
                    if (dVar != null) {
                        dVar.i(dVarArrD[i10].c());
                        if (!dVar.g()) {
                            this.f21580b[i11].d()[i10] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        f[] fVarArr = this.f21580b;
        if (fVarArr[0] == null) {
            return 0;
        }
        d[] dVarArrD = fVarArr[0].d();
        int i10 = 0;
        for (int i11 = 0; i11 < dVarArrD.length; i11++) {
            if (dVarArrD[i11] != null) {
                int iC = dVarArrD[i11].c();
                int iC2 = 0;
                for (int i12 = 1; i12 < this.f21582d + 1 && iC2 < 2; i12++) {
                    d dVar = this.f21580b[i12].d()[i11];
                    if (dVar != null) {
                        iC2 = c(iC, iC2, dVar);
                        if (!dVar.g()) {
                            i10++;
                        }
                    }
                }
            }
        }
        return i10;
    }

    public final int i() {
        f[] fVarArr = this.f21580b;
        int i10 = this.f21582d;
        if (fVarArr[i10 + 1] == null) {
            return 0;
        }
        d[] dVarArrD = fVarArr[i10 + 1].d();
        int i11 = 0;
        for (int i12 = 0; i12 < dVarArrD.length; i12++) {
            if (dVarArrD[i12] != null) {
                int iC = dVarArrD[i12].c();
                int iC2 = 0;
                for (int i13 = this.f21582d + 1; i13 > 0 && iC2 < 2; i13--) {
                    d dVar = this.f21580b[i13].d()[i12];
                    if (dVar != null) {
                        iC2 = c(iC, iC2, dVar);
                        if (!dVar.g()) {
                            i11++;
                        }
                    }
                }
            }
        }
        return i11;
    }

    public int j() {
        return this.f21582d;
    }

    public int k() {
        return this.f21579a.b();
    }

    public int l() {
        return this.f21579a.c();
    }

    public c m() {
        return this.f21581c;
    }

    public f n(int i10) {
        return this.f21580b[i10];
    }

    public f[] o() {
        a(this.f21580b[0]);
        a(this.f21580b[this.f21582d + 1]);
        int i10 = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i10) {
                break;
            }
            i10 = iD;
        }
        return this.f21580b;
    }

    public void p(c cVar) {
        this.f21581c = cVar;
    }

    public void q(int i10, f fVar) {
        this.f21580b[i10] = fVar;
    }

    public String toString() {
        f[] fVarArr = this.f21580b;
        f fVar = fVarArr[0];
        if (fVar == null) {
            fVar = fVarArr[this.f21582d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i10 = 0; i10 < fVar.d().length; i10++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i10));
                for (int i11 = 0; i11 < this.f21582d + 2; i11++) {
                    f[] fVarArr2 = this.f21580b;
                    if (fVarArr2[i11] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = fVarArr2[i11].d()[i10];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        formatter.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
