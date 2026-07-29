package com.google.zxing.pdf417.decoder;

import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f21586d;

    public g(c cVar, boolean z10) {
        super(cVar);
        this.f21586d = z10;
    }

    public void g(a aVar) {
        d[] dVarArrD = d();
        m();
        l(dVarArrD, aVar);
        c cVarA = a();
        l lVarH = this.f21586d ? cVarA.h() : cVarA.i();
        l lVarB = this.f21586d ? cVarA.b() : cVarA.c();
        int iE = e((int) lVarH.d());
        int iE2 = e((int) lVarB.d());
        int iC = -1;
        int i10 = 0;
        int iMax = 1;
        while (iE < iE2) {
            if (dVarArrD[iE] != null) {
                d dVar = dVarArrD[iE];
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i10++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i10);
                        iC = dVar.c();
                    } else if (iC2 < 0 || dVar.c() >= aVar.c() || iC2 > iE) {
                        dVarArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z10 = iC2 >= iE;
                        for (int i11 = 1; i11 <= iC2 && !z10; i11++) {
                            z10 = dVarArrD[iE - i11] != null;
                        }
                        if (z10) {
                            dVarArrD[iE] = null;
                        } else {
                            iC = dVar.c();
                        }
                    }
                    i10 = 1;
                }
            }
            iE++;
        }
    }

    public final void h(a aVar) {
        c cVarA = a();
        l lVarH = this.f21586d ? cVarA.h() : cVarA.i();
        l lVarB = this.f21586d ? cVarA.b() : cVarA.c();
        int iE = e((int) lVarB.d());
        d[] dVarArrD = d();
        int iC = -1;
        int i10 = 0;
        int iMax = 1;
        for (int iE2 = e((int) lVarH.d()); iE2 < iE; iE2++) {
            if (dVarArrD[iE2] != null) {
                d dVar = dVarArrD[iE2];
                dVar.j();
                int iC2 = dVar.c() - iC;
                if (iC2 == 0) {
                    i10++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i10);
                        iC = dVar.c();
                    } else if (dVar.c() >= aVar.c()) {
                        dVarArrD[iE2] = null;
                    } else {
                        iC = dVar.c();
                    }
                    i10 = 1;
                }
            }
        }
    }

    public a i() {
        d[] dVarArrD = d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArrD) {
            if (dVar != null) {
                dVar.j();
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (!this.f21586d) {
                    iC += 2;
                }
                int i10 = iC % 3;
                if (i10 == 0) {
                    bVar2.c((iE * 3) + 1);
                } else if (i10 == 1) {
                    bVar4.c(iE / 3);
                    bVar3.c(iE % 3);
                } else if (i10 == 2) {
                    bVar.c(iE + 1);
                }
            }
        }
        if (bVar.b().length == 0 || bVar2.b().length == 0 || bVar3.b().length == 0 || bVar4.b().length == 0 || bVar.b()[0] < 1 || bVar2.b()[0] + bVar3.b()[0] < 3 || bVar2.b()[0] + bVar3.b()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.b()[0], bVar2.b()[0], bVar3.b()[0], bVar4.b()[0]);
        l(dVarArrD, aVar);
        return aVar;
    }

    public int[] j() {
        int iC;
        a aVarI = i();
        if (aVarI == null) {
            return null;
        }
        h(aVarI);
        int iC2 = aVarI.c();
        int[] iArr = new int[iC2];
        for (d dVar : d()) {
            if (dVar != null && (iC = dVar.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.f21586d;
    }

    public final void l(d[] dVarArr, a aVar) {
        for (int i10 = 0; i10 < dVarArr.length; i10++) {
            d dVar = dVarArr[i10];
            if (dVarArr[i10] != null) {
                int iE = dVar.e() % 30;
                int iC = dVar.c();
                if (iC > aVar.c()) {
                    dVarArr[i10] = null;
                } else {
                    if (!this.f21586d) {
                        iC += 2;
                    }
                    int i11 = iC % 3;
                    if (i11 != 0) {
                        if (i11 != 1) {
                            if (i11 == 2 && iE + 1 != aVar.a()) {
                                dVarArr[i10] = null;
                            }
                        } else if (iE / 3 != aVar.b() || iE % 3 != aVar.d()) {
                            dVarArr[i10] = null;
                        }
                    } else if ((iE * 3) + 1 != aVar.e()) {
                        dVarArr[i10] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (d dVar : d()) {
            if (dVar != null) {
                dVar.j();
            }
        }
    }

    @Override // com.google.zxing.pdf417.decoder.f
    public String toString() {
        return "IsLeft: " + this.f21586d + '\n' + super.toString();
    }
}
