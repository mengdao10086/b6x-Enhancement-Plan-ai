package oa;

import java.util.List;
import la.q;
import xa.k;

/* JADX INFO: loaded from: classes3.dex */
public class i extends h<ja.i> {
    public i(ja.i iVar) {
        super(iVar);
    }

    @Override // oa.h
    public d b(int i10, float f10, float f11) {
        List<d> listC = c(i10);
        float fZ = ((ja.i) this.f43023a).Z(f10, f11) / ((ja.i) this.f43023a).getFactor();
        d dVar = null;
        float f12 = Float.MAX_VALUE;
        for (int i11 = 0; i11 < listC.size(); i11++) {
            d dVar2 = listC.get(i11);
            float fAbs = Math.abs(dVar2.j() - fZ);
            if (fAbs < f12) {
                dVar = dVar2;
                f12 = fAbs;
            }
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.github.mikephil.charting.data.Entry, la.f] */
    public List<d> c(int i10) {
        int i11 = i10;
        this.f43024b.clear();
        float fH = ((ja.i) this.f43023a).getAnimator().h();
        float fI = ((ja.i) this.f43023a).getAnimator().i();
        float sliceAngle = ((ja.i) this.f43023a).getSliceAngle();
        float factor = ((ja.i) this.f43023a).getFactor();
        xa.g gVarC = xa.g.c(0.0f, 0.0f);
        int i12 = 0;
        while (i12 < ((q) ((ja.i) this.f43023a).getData()).m()) {
            qa.j jVarK = ((q) ((ja.i) this.f43023a).getData()).k(i12);
            ?? Z = jVarK.Z(i11);
            float f10 = i11;
            k.B(((ja.i) this.f43023a).getCenterOffsets(), (Z.e() - ((ja.i) this.f43023a).getYChartMin()) * factor * fI, (sliceAngle * f10 * fH) + ((ja.i) this.f43023a).getRotationAngle(), gVarC);
            this.f43024b.add(new d(f10, Z.e(), gVarC.f54987c, gVarC.f54988d, i12, jVarK.a1()));
            i12++;
            i11 = i10;
        }
        return this.f43024b;
    }
}
