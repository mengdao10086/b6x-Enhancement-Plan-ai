package ef;

import af.b;
import af.f;
import af.k;
import bf.c;
import com.google.zxing.NotFoundException;
import ve.l;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f26980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f26981b;

    public a(b bVar) throws NotFoundException {
        this.f26980a = bVar;
        this.f26981b = new c(bVar);
    }

    public static l f(l lVar, float f10, float f11) {
        float fC = lVar.c();
        float fD = lVar.d();
        return new l(fC < f10 ? fC - 1.0f : fC + 1.0f, fD < f11 ? fD - 1.0f : fD + 1.0f);
    }

    public static b g(b bVar, l lVar, l lVar2, l lVar3, l lVar4, int i10, int i11) throws NotFoundException {
        float f10 = i10 - 0.5f;
        float f11 = i11 - 0.5f;
        return k.b().c(bVar, i10, i11, 0.5f, 0.5f, f10, 0.5f, f10, f11, 0.5f, f11, lVar.c(), lVar.d(), lVar4.c(), lVar4.d(), lVar3.c(), lVar3.d(), lVar2.c(), lVar2.d());
    }

    public static l h(l lVar, l lVar2, int i10) {
        float f10 = i10 + 1;
        return new l(lVar.c() + ((lVar2.c() - lVar.c()) / f10), lVar.d() + ((lVar2.d() - lVar.d()) / f10));
    }

    public final l a(l[] lVarArr) {
        l lVar = lVarArr[0];
        l lVar2 = lVarArr[1];
        l lVar3 = lVarArr[2];
        l lVar4 = lVarArr[3];
        int iJ = j(lVar, lVar4);
        l lVarH = h(lVar, lVar2, (j(lVar2, lVar4) + 1) * 4);
        l lVarH2 = h(lVar3, lVar2, (iJ + 1) * 4);
        int iJ2 = j(lVarH, lVar4);
        int iJ3 = j(lVarH2, lVar4);
        float f10 = iJ2 + 1;
        l lVar5 = new l(lVar4.c() + ((lVar3.c() - lVar2.c()) / f10), lVar4.d() + ((lVar3.d() - lVar2.d()) / f10));
        float f11 = iJ3 + 1;
        l lVar6 = new l(lVar4.c() + ((lVar.c() - lVar2.c()) / f11), lVar4.d() + ((lVar.d() - lVar2.d()) / f11));
        if (e(lVar5)) {
            return (e(lVar6) && j(lVarH, lVar5) + j(lVarH2, lVar5) <= j(lVarH, lVar6) + j(lVarH2, lVar6)) ? lVar6 : lVar5;
        }
        if (e(lVar6)) {
            return lVar6;
        }
        return null;
    }

    public f b() throws NotFoundException {
        int iMax;
        int i10;
        l[] lVarArrD = d(c(this.f26981b.c()));
        lVarArrD[3] = a(lVarArrD);
        if (lVarArrD[3] == null) {
            throw NotFoundException.b();
        }
        l[] lVarArrI = i(lVarArrD);
        l lVar = lVarArrI[0];
        l lVar2 = lVarArrI[1];
        l lVar3 = lVarArrI[2];
        l lVar4 = lVarArrI[3];
        int iJ = j(lVar, lVar4) + 1;
        int iJ2 = j(lVar3, lVar4) + 1;
        if ((iJ & 1) == 1) {
            iJ++;
        }
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if (iJ * 4 >= iJ2 * 6 || iJ2 * 4 >= iJ * 6) {
            iMax = iJ;
            i10 = iJ2;
        } else {
            iMax = Math.max(iJ, iJ2);
            i10 = iMax;
        }
        return new f(g(this.f26980a, lVar, lVar2, lVar3, lVar4, iMax, i10), new l[]{lVar, lVar2, lVar3, lVar4});
    }

    public final l[] c(l[] lVarArr) {
        l lVar = lVarArr[0];
        l lVar2 = lVarArr[1];
        l lVar3 = lVarArr[3];
        l lVar4 = lVarArr[2];
        int iJ = j(lVar, lVar2);
        int iJ2 = j(lVar2, lVar3);
        int iJ3 = j(lVar3, lVar4);
        int iJ4 = j(lVar4, lVar);
        l[] lVarArr2 = {lVar4, lVar, lVar2, lVar3};
        if (iJ > iJ2) {
            lVarArr2[0] = lVar;
            lVarArr2[1] = lVar2;
            lVarArr2[2] = lVar3;
            lVarArr2[3] = lVar4;
            iJ = iJ2;
        }
        if (iJ > iJ3) {
            lVarArr2[0] = lVar2;
            lVarArr2[1] = lVar3;
            lVarArr2[2] = lVar4;
            lVarArr2[3] = lVar;
        } else {
            iJ3 = iJ;
        }
        if (iJ3 > iJ4) {
            lVarArr2[0] = lVar3;
            lVarArr2[1] = lVar4;
            lVarArr2[2] = lVar;
            lVarArr2[3] = lVar2;
        }
        return lVarArr2;
    }

    public final l[] d(l[] lVarArr) {
        l lVar = lVarArr[0];
        l lVar2 = lVarArr[1];
        l lVar3 = lVarArr[2];
        l lVar4 = lVarArr[3];
        int iJ = (j(lVar, lVar4) + 1) * 4;
        if (j(h(lVar2, lVar3, iJ), lVar) < j(h(lVar3, lVar2, iJ), lVar4)) {
            lVarArr[0] = lVar;
            lVarArr[1] = lVar2;
            lVarArr[2] = lVar3;
            lVarArr[3] = lVar4;
        } else {
            lVarArr[0] = lVar2;
            lVarArr[1] = lVar3;
            lVarArr[2] = lVar4;
            lVarArr[3] = lVar;
        }
        return lVarArr;
    }

    public final boolean e(l lVar) {
        return lVar.c() >= 0.0f && lVar.c() <= ((float) (this.f26980a.m() - 1)) && lVar.d() > 0.0f && lVar.d() <= ((float) (this.f26980a.i() - 1));
    }

    public final l[] i(l[] lVarArr) {
        l lVar = lVarArr[0];
        l lVar2 = lVarArr[1];
        l lVar3 = lVarArr[2];
        l lVar4 = lVarArr[3];
        int iJ = j(lVar, lVar4) + 1;
        l lVarH = h(lVar, lVar2, (j(lVar3, lVar4) + 1) * 4);
        l lVarH2 = h(lVar3, lVar2, iJ * 4);
        int iJ2 = j(lVarH, lVar4) + 1;
        int iJ3 = j(lVarH2, lVar4) + 1;
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if ((iJ3 & 1) == 1) {
            iJ3++;
        }
        float fC = (((lVar.c() + lVar2.c()) + lVar3.c()) + lVar4.c()) / 4.0f;
        float fD = (((lVar.d() + lVar2.d()) + lVar3.d()) + lVar4.d()) / 4.0f;
        l lVarF = f(lVar, fC, fD);
        l lVarF2 = f(lVar2, fC, fD);
        l lVarF3 = f(lVar3, fC, fD);
        l lVarF4 = f(lVar4, fC, fD);
        int i10 = iJ3 * 4;
        int i11 = iJ2 * 4;
        return new l[]{h(h(lVarF, lVarF2, i10), lVarF4, i11), h(h(lVarF2, lVarF, i10), lVarF3, i11), h(h(lVarF3, lVarF4, i10), lVarF2, i11), h(h(lVarF4, lVarF3, i10), lVarF, i11)};
    }

    public final int j(l lVar, l lVar2) {
        int iC = (int) lVar.c();
        int iD = (int) lVar.d();
        int iC2 = (int) lVar2.c();
        int iMin = Math.min(this.f26980a.i() - 1, (int) lVar2.d());
        int i10 = 0;
        boolean z10 = Math.abs(iMin - iD) > Math.abs(iC2 - iC);
        if (z10) {
            iD = iC;
            iC = iD;
            iMin = iC2;
            iC2 = iMin;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iMin - iD);
        int i11 = (-iAbs) / 2;
        int i12 = iD < iMin ? 1 : -1;
        int i13 = iC >= iC2 ? -1 : 1;
        boolean zF = this.f26980a.f(z10 ? iD : iC, z10 ? iC : iD);
        while (iC != iC2) {
            boolean zF2 = this.f26980a.f(z10 ? iD : iC, z10 ? iC : iD);
            if (zF2 != zF) {
                i10++;
                zF = zF2;
            }
            i11 += iAbs2;
            if (i11 > 0) {
                if (iD == iMin) {
                    break;
                }
                iD += i12;
                i11 -= iAbs;
            }
            iC += i13;
        }
        return i10;
    }
}
