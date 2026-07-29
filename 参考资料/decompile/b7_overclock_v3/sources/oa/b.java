package oa;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import java.util.ArrayList;
import java.util.List;
import pa.b;

/* JADX INFO: loaded from: classes3.dex */
public class b<T extends pa.b> implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f43010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<d> f43011b = new ArrayList();

    public b(T t10) {
        this.f43010a = t10;
    }

    @Override // oa.f
    public d a(float f10, float f11) {
        xa.f fVarJ = j(f10, f11);
        float f12 = (float) fVarJ.f54983c;
        xa.f.c(fVarJ);
        return f(f12, f10, f11);
    }

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
            xa.f fVarF = this.f43010a.a(eVar.a1()).f(entry.F(), entry.e());
            arrayList.add(new d(entry.F(), entry.e(), (float) fVarF.f54983c, (float) fVarF.f54984d, i10, eVar.a1()));
        }
        return arrayList;
    }

    public d c(List<d> list, float f10, float f11, YAxis.AxisDependency axisDependency, float f12) {
        d dVar = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar2 = list.get(i10);
            if (axisDependency == null || dVar2.b() == axisDependency) {
                float fE = e(f10, f11, dVar2.i(), dVar2.k());
                if (fE < f12) {
                    dVar = dVar2;
                    f12 = fE;
                }
            }
        }
        return dVar;
    }

    public la.c d() {
        return this.f43010a.getData();
    }

    public float e(float f10, float f11, float f12, float f13) {
        return (float) Math.hypot(f10 - f12, f11 - f13);
    }

    public d f(float f10, float f11, float f12) {
        List<d> listH = h(f10, f11, f12);
        if (listH.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float fI = i(listH, f12, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return c(listH, f11, f12, fI < i(listH, f12, axisDependency2) ? axisDependency : axisDependency2, this.f43010a.getMaxHighlightDistance());
    }

    public float g(d dVar) {
        return dVar.k();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [qa.e] */
    public List<d> h(float f10, float f11, float f12) {
        this.f43011b.clear();
        la.c cVarD = d();
        if (cVarD == null) {
            return this.f43011b;
        }
        int iM = cVarD.m();
        for (int i10 = 0; i10 < iM; i10++) {
            ?? K = cVarD.k(i10);
            if (K.i1()) {
                this.f43011b.addAll(b(K, i10, f10, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f43011b;
    }

    public float i(List<d> list, float f10, YAxis.AxisDependency axisDependency) {
        float f11 = Float.MAX_VALUE;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if (dVar.b() == axisDependency) {
                float fAbs = Math.abs(g(dVar) - f10);
                if (fAbs < f11) {
                    f11 = fAbs;
                }
            }
        }
        return f11;
    }

    public xa.f j(float f10, float f11) {
        return this.f43010a.a(YAxis.AxisDependency.LEFT).j(f10, f11);
    }
}
