package la;

import com.github.mikephil.charting.data.Entry;

/* JADX INFO: loaded from: classes3.dex */
public class p extends k<qa.i> {
    public p() {
    }

    public qa.i Q() {
        return (qa.i) this.f39513i.get(0);
    }

    @Override // la.k
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public qa.i k(int i10) {
        if (i10 == 0) {
            return Q();
        }
        return null;
    }

    @Override // la.k
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public qa.i l(String str, boolean z10) {
        if (z10) {
            if (str.equalsIgnoreCase(((qa.i) this.f39513i.get(0)).J())) {
                return (qa.i) this.f39513i.get(0);
            }
            return null;
        }
        if (str.equals(((qa.i) this.f39513i.get(0)).J())) {
            return (qa.i) this.f39513i.get(0);
        }
        return null;
    }

    public float T() {
        float fE = 0.0f;
        for (int i10 = 0; i10 < Q().e1(); i10++) {
            fE += Q().Z(i10).e();
        }
        return fE;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void U(qa.i iVar) {
        this.f39513i.clear();
        this.f39513i.add(iVar);
        E();
    }

    @Override // la.k
    public Entry s(oa.d dVar) {
        return Q().Z((int) dVar.h());
    }

    public p(qa.i iVar) {
        super(iVar);
    }
}
