package om;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class d extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f44275a;

    public d(f0 f0Var) {
        this.f44275a = f0Var;
    }

    public d(e eVar) {
        this.f44275a = new j2(eVar);
    }

    public d(e[] eVarArr) {
        this.f44275a = new j2(eVarArr);
    }

    public static d x(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f44275a;
    }

    public e[] y() {
        int size = this.f44275a.size();
        e[] eVarArr = new e[size];
        for (int i10 = 0; i10 != size; i10++) {
            eVarArr[i10] = e.A(this.f44275a.K(i10));
        }
        return eVarArr;
    }
}
