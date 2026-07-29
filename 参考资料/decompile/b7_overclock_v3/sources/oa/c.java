package oa;

import com.github.mikephil.charting.data.DataSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class c extends b<pa.f> implements f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f43012c;

    public c(pa.f fVar, pa.a aVar) {
        super(fVar);
        this.f43012c = aVar.getBarData() == null ? null : new a(aVar);
    }

    @Override // oa.b
    public List<d> h(float f10, float f11, float f12) {
        this.f43011b.clear();
        List<la.c> listQ = ((pa.f) this.f43010a).getCombinedData().Q();
        for (int i10 = 0; i10 < listQ.size(); i10++) {
            la.c cVar = listQ.get(i10);
            a aVar = this.f43012c;
            if (aVar == null || !(cVar instanceof la.a)) {
                int iM = cVar.m();
                for (int i11 = 0; i11 < iM; i11++) {
                    qa.e eVarK = listQ.get(i10).k(i11);
                    if (eVarK.i1()) {
                        for (d dVar : b(eVarK, i11, f10, DataSet.Rounding.CLOSEST)) {
                            dVar.m(i10);
                            this.f43011b.add(dVar);
                        }
                    }
                }
            } else {
                d dVarA = aVar.a(f11, f12);
                if (dVarA != null) {
                    dVarA.m(i10);
                    this.f43011b.add(dVarA);
                }
            }
        }
        return this.f43011b;
    }
}
