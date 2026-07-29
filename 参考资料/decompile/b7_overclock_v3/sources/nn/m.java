package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.o f42289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.m f42290b;

    public m(f0 f0Var) {
        this.f42289a = gm.o.M(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f42290b = zn.m.x(gm.k.H((n0) f0Var.K(1), true));
        }
    }

    public m(gm.o oVar, zn.m mVar) {
        this.f42289a = oVar;
        this.f42290b = mVar;
    }

    public static m x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static m y(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(f0.J(obj));
        }
        return null;
    }

    public gm.o A() {
        return this.f42289a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42289a);
        zn.m mVar = this.f42290b;
        if (mVar != null) {
            iVar.a(new n2(true, 0, (gm.h) mVar));
        }
        return new j2(iVar);
    }

    public zn.m z() {
        return this.f42290b;
    }
}
