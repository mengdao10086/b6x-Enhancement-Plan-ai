package fo;

import cs.j;
import cs.n;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f28529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public lm.e f28530b;

    public b(lm.e eVar) {
        this(eVar, new j());
    }

    public b(lm.e eVar, n nVar) {
        this.f28529a = nVar;
        this.f28530b = eVar;
    }

    public d[] a() {
        lm.i[] iVarArrY = this.f28530b.y();
        int length = iVarArrY.length;
        d[] dVarArr = new d[length];
        for (int i10 = 0; i10 != length; i10++) {
            dVarArr[i10] = new d(this.f28529a, iVarArrY[i10]);
        }
        return dVarArr;
    }

    public lm.e b() {
        return this.f28530b;
    }
}
