package mm;

import gm.i1;
import gm.n1;

/* JADX INFO: loaded from: classes5.dex */
public class s extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f41386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h0 f41387c;

    public s(gm.f0 f0Var) {
        this.f41385a = gm.t.I(f0Var.K(0));
        this.f41386b = q.A(f0Var.K(1));
        if (f0Var.size() == 3) {
            this.f41387c = gm.h0.H((gm.n0) f0Var.K(2), false);
        }
    }

    public s(q qVar) {
        this(qVar, null);
    }

    public s(q qVar, gm.h0 h0Var) {
        this.f41385a = new gm.t(h0Var == null ? 0L : 2L);
        this.f41386b = qVar;
        this.f41387c = h0Var;
    }

    public static s y(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(gm.f0.J(obj));
        }
        return null;
    }

    public gm.t A() {
        return this.f41385a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41385a);
        iVar.a(this.f41386b);
        gm.h0 h0Var = this.f41387c;
        if (h0Var != null) {
            iVar.a(new n1(false, 1, (gm.h) h0Var));
        }
        return new i1(iVar);
    }

    public q x() {
        return this.f41386b;
    }

    public gm.h0 z() {
        return this.f41387c;
    }
}
