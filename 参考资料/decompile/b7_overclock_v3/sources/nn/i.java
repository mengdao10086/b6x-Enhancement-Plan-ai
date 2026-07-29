package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f42277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f42278b;

    public i(f0 f0Var) {
        this.f42277a = b.z(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f42278b = z.F((n0) f0Var.K(1), true);
        }
    }

    public i(b bVar, z zVar) {
        this.f42277a = bVar;
        this.f42278b = zVar;
    }

    public static i x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static i y(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    public z A() {
        return this.f42278b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42277a);
        z zVar = this.f42278b;
        if (zVar != null) {
            iVar.a(new n2(true, 0, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public b z() {
        return this.f42277a;
    }
}
