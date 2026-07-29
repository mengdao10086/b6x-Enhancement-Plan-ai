package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52297a;

    public e(f0 f0Var) {
        this.f52297a = f0Var;
    }

    public e(mm.a[] aVarArr) {
        this.f52297a = new j2(aVarArr);
    }

    public static e y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static e z(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52297a;
    }

    public mm.a[] x() {
        int size = this.f52297a.size();
        mm.a[] aVarArr = new mm.a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = mm.a.A(this.f52297a.K(i10));
        }
        return aVarArr;
    }
}
