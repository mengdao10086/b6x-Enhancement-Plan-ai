package oa;

import com.github.mikephil.charting.data.BarEntry;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b<pa.a> {
    public a(pa.a aVar) {
        super(aVar);
    }

    @Override // oa.b, oa.f
    public d a(float f10, float f11) {
        d dVarA = super.a(f10, f11);
        if (dVarA == null) {
            return null;
        }
        xa.f fVarJ = j(f10, f11);
        qa.a aVar = (qa.a) ((pa.a) this.f43010a).getBarData().k(dVarA.d());
        if (aVar.U0()) {
            return l(dVarA, aVar, (float) fVarJ.f54983c, (float) fVarJ.f54984d);
        }
        xa.f.c(fVarJ);
        return dVarA;
    }

    @Override // oa.b
    public la.c d() {
        return ((pa.a) this.f43010a).getBarData();
    }

    @Override // oa.b
    public float e(float f10, float f11, float f12, float f13) {
        return Math.abs(f10 - f12);
    }

    public int k(j[] jVarArr, float f10) {
        if (jVarArr == null || jVarArr.length == 0) {
            return 0;
        }
        int i10 = 0;
        for (j jVar : jVarArr) {
            if (jVar.a(f10)) {
                return i10;
            }
            i10++;
        }
        int iMax = Math.max(jVarArr.length - 1, 0);
        if (f10 > jVarArr[iMax].f43026b) {
            return iMax;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d l(d dVar, qa.a aVar, float f10, float f11) {
        BarEntry barEntry = (BarEntry) aVar.y(f10, f11);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.b0() == null) {
            return dVar;
        }
        j[] jVarArrZ = barEntry.Z();
        if (jVarArrZ.length <= 0) {
            return null;
        }
        int iK = k(jVarArrZ, f11);
        xa.f fVarF = ((pa.a) this.f43010a).a(aVar.a1()).f(dVar.h(), jVarArrZ[iK].f43026b);
        d dVar2 = new d(barEntry.F(), barEntry.e(), (float) fVarF.f54983c, (float) fVarF.f54984d, dVar.d(), iK, dVar.b());
        xa.f.c(fVarF);
        return dVar2;
    }
}
