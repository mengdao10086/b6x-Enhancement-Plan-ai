package oa;

import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e extends a {
    public e(pa.a aVar) {
        super(aVar);
    }

    @Override // oa.a, oa.b, oa.f
    public d a(float f10, float f11) {
        la.a barData = ((pa.a) this.f43010a).getBarData();
        xa.f fVarJ = j(f11, f10);
        d dVarF = f((float) fVarJ.f54984d, f11, f10);
        if (dVarF == null) {
            return null;
        }
        qa.a aVar = (qa.a) barData.k(dVarF.d());
        if (aVar.U0()) {
            return l(dVarF, aVar, (float) fVarJ.f54984d, (float) fVarJ.f54983c);
        }
        xa.f.c(fVarJ);
        return dVarF;
    }

    @Override // oa.b
    public List<d> b(qa.e eVar, int i10, float f10, DataSet.Rounding rounding) {
        Entry entryU0;
        ArrayList arrayList = new ArrayList();
        List<Entry> listJ0 = eVar.J0(f10);
        if (listJ0.size() == 0 && (entryU0 = eVar.u0(f10, Float.NaN, rounding)) != null) {
            listJ0 = eVar.J0(entryU0.F());
        }
        if (listJ0.size() == 0) {
            return arrayList;
        }
        for (Entry entry : listJ0) {
            xa.f fVarF = ((pa.a) this.f43010a).a(eVar.a1()).f(entry.e(), entry.F());
            arrayList.add(new d(entry.F(), entry.e(), (float) fVarF.f54983c, (float) fVarF.f54984d, i10, eVar.a1()));
        }
        return arrayList;
    }

    @Override // oa.a, oa.b
    public float e(float f10, float f11, float f12, float f13) {
        return Math.abs(f11 - f13);
    }
}
