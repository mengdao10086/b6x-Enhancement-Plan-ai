package lm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class m extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39929a;

    public m(gm.f0 f0Var) {
        this.f39929a = f0Var;
    }

    public m(o oVar) {
        this.f39929a = new j2(oVar);
    }

    public m(o[] oVarArr) {
        this.f39929a = new j2(oVarArr);
    }

    public static m x(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f39929a;
    }

    public o[] y() {
        int size = this.f39929a.size();
        o[] oVarArr = new o[size];
        for (int i10 = 0; i10 != size; i10++) {
            oVarArr[i10] = o.z(this.f39929a.K(i10));
        }
        return oVarArr;
    }
}
