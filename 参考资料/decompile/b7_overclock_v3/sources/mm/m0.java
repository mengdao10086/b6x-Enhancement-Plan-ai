package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class m0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f41360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f41361b;

    public m0(gm.f0 f0Var) {
        this.f41360a = b0.y(f0Var.K(0));
        this.f41361b = (gm.z) f0Var.K(1);
    }

    public m0(b0 b0Var, gm.z zVar) {
        this.f41360a = b0Var;
        this.f41361b = zVar;
    }

    public static m0 A(Object obj) {
        if (obj instanceof m0) {
            return (m0) obj;
        }
        if (obj != null) {
            return new m0(gm.f0.J(obj));
        }
        return null;
    }

    public static m0 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41360a);
        iVar.a(this.f41361b);
        return new j2(iVar);
    }

    public gm.z x() {
        return this.f41361b;
    }

    public b0 y() {
        return this.f41360a;
    }
}
