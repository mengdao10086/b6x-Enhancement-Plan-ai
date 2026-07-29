package vm;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import zn.s0;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f53245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f53246b;

    public h(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f53245a = f0.J(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f53246b = f0.J(f0Var.K(1));
        }
    }

    public h(d dVar) {
        this.f53245a = new j2(dVar);
    }

    public h(d[] dVarArr) {
        this.f53245a = new j2(dVarArr);
    }

    public h(d[] dVarArr, s0[] s0VarArr) {
        this.f53245a = new j2(dVarArr);
        if (s0VarArr != null) {
            this.f53246b = new j2(s0VarArr);
        }
    }

    public static h y(Object obj) {
        if (obj == null || (obj instanceof h)) {
            return (h) obj;
        }
        if (obj instanceof f0) {
            return new h((f0) obj);
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f53245a);
        f0 f0Var = this.f53246b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public d[] x() {
        d[] dVarArr = new d[this.f53245a.size()];
        for (int i10 = 0; i10 != this.f53245a.size(); i10++) {
            dVarArr[i10] = d.z(this.f53245a.K(i10));
        }
        return dVarArr;
    }

    public s0[] z() {
        f0 f0Var = this.f53246b;
        if (f0Var == null) {
            return null;
        }
        s0[] s0VarArr = new s0[f0Var.size()];
        for (int i10 = 0; i10 != this.f53246b.size(); i10++) {
            s0VarArr[i10] = s0.x(this.f53246b.K(i10));
        }
        return s0VarArr;
    }
}
