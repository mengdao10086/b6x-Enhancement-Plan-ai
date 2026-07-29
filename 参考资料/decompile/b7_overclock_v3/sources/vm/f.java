package vm;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import zn.s0;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f53241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f53242b;

    public f(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f53241a = f0.J(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f53242b = f0.J(f0Var.K(1));
        }
    }

    public f(e eVar) {
        this.f53241a = new j2(eVar);
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f53241a);
        f0 f0Var = this.f53242b;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public e[] x() {
        e[] eVarArr = new e[this.f53241a.size()];
        for (int i10 = 0; i10 != this.f53241a.size(); i10++) {
            eVarArr[i10] = e.z(this.f53241a.K(i10));
        }
        return eVarArr;
    }

    public s0[] z() {
        f0 f0Var = this.f53242b;
        if (f0Var == null) {
            return null;
        }
        s0[] s0VarArr = new s0[f0Var.size()];
        for (int i10 = 0; i10 != this.f53242b.size(); i10++) {
            s0VarArr[i10] = s0.x(this.f53242b.K(i10));
        }
        return s0VarArr;
    }
}
