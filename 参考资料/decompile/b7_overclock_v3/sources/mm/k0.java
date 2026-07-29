package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class k0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f41349b;

    public k0(gm.f0 f0Var) {
        this.f41348a = gm.y.N(f0Var.K(0));
        this.f41349b = f0Var.K(1);
    }

    public k0(gm.y yVar, gm.h hVar) {
        this.f41348a = yVar;
        this.f41349b = hVar;
    }

    public static k0 A(Object obj) {
        if (obj instanceof k0) {
            return (k0) obj;
        }
        if (obj != null) {
            return new k0(gm.f0.J(obj));
        }
        return null;
    }

    public static k0 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41348a);
        iVar.a(this.f41349b);
        return new j2(iVar);
    }

    public gm.h x() {
        return this.f41349b;
    }

    public gm.y y() {
        return this.f41348a;
    }
}
