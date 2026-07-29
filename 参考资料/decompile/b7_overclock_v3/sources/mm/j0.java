package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f41346b;

    public j0(gm.f0 f0Var) {
        this.f41345a = gm.y.N(f0Var.K(0));
        this.f41346b = f0Var.K(1);
    }

    public j0(gm.y yVar, gm.h hVar) {
        this.f41345a = yVar;
        this.f41346b = hVar;
    }

    public static j0 x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static j0 y(Object obj) {
        if (obj instanceof j0) {
            return (j0) obj;
        }
        if (obj != null) {
            return new j0(gm.f0.J(obj));
        }
        return null;
    }

    public gm.h A() {
        return this.f41346b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41345a);
        iVar.a(this.f41346b);
        return new j2(iVar);
    }

    public gm.y z() {
        return this.f41345a;
    }
}
