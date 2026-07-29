package vm;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import zn.s0;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f53243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f53244b;

    public g(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f53243a = f0.J(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f53244b = f0.J(f0Var.K(1));
        }
    }

    public g(c cVar) {
        this.f53243a = new j2(cVar);
    }

    public static g y(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f53243a);
        f0 f0Var = this.f53244b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public c[] x() {
        c[] cVarArr = new c[this.f53243a.size()];
        for (int i10 = 0; i10 != this.f53243a.size(); i10++) {
            cVarArr[i10] = c.y(this.f53243a.K(i10));
        }
        return cVarArr;
    }

    public s0[] z() {
        f0 f0Var = this.f53244b;
        if (f0Var == null) {
            return null;
        }
        s0[] s0VarArr = new s0[f0Var.size()];
        for (int i10 = 0; i10 != this.f53244b.size(); i10++) {
            s0VarArr[i10] = s0.x(this.f53244b.K(i10));
        }
        return s0VarArr;
    }
}
