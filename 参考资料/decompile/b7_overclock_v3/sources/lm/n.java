package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39930a;

    public n(gm.f0 f0Var) {
        this.f39930a = f0Var;
    }

    public n(o oVar) {
        this.f39930a = new j2(oVar);
    }

    public n(o[] oVarArr) {
        this.f39930a = new j2(oVarArr);
    }

    public static n x(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39930a;
    }

    public o[] y() {
        int size = this.f39930a.size();
        o[] oVarArr = new o[size];
        for (int i10 = 0; i10 != size; i10++) {
            oVarArr[i10] = o.z(this.f39930a.K(i10));
        }
        return oVarArr;
    }
}
