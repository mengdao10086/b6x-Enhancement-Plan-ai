package pn;

import gm.f0;
import gm.i1;
import gm.n0;
import gm.n1;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f46766a;

    public i(f0 f0Var) {
        if (!((gm.t) f0Var.K(0)).L(0)) {
            throw new IllegalArgumentException("sequence not version 0");
        }
        this.f46766a = f0.J(f0Var.K(1));
    }

    public i(gm.y yVar, zn.b bVar, gm.h hVar) {
        gm.i iVar = new gm.i(3);
        iVar.a(yVar);
        iVar.a(bVar.b());
        iVar.a(new n1(false, 0, hVar));
        this.f46766a = new i1(iVar);
    }

    public static i A(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new gm.t(0L));
        iVar.a(this.f46766a);
        return new i1(iVar);
    }

    public gm.z x() {
        if (this.f46766a.size() == 3) {
            return gm.z.H(n0.T(this.f46766a.K(2)), false);
        }
        return null;
    }

    public gm.y y() {
        return gm.y.N(this.f46766a.K(0));
    }

    public zn.b z() {
        return zn.b.z(this.f46766a.K(1));
    }
}
