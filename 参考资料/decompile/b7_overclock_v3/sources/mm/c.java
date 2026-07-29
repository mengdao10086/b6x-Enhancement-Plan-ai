package mm;

import gm.b3;

/* JADX INFO: loaded from: classes5.dex */
public class c extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h0 f41285a;

    public c(gm.h0 h0Var) {
        this.f41285a = h0Var;
    }

    public c(gm.i iVar) {
        this.f41285a = new b3(iVar);
    }

    public static c y(gm.n0 n0Var, boolean z10) {
        return z(gm.h0.H(n0Var, z10));
    }

    public static c z(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(gm.h0.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41285a;
    }

    public a[] x() {
        int size = this.f41285a.size();
        a[] aVarArr = new a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = a.A(this.f41285a.J(i10));
        }
        return aVarArr;
    }
}
