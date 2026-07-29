package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class g extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f42268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f42269b;

    public g(f0 f0Var) {
        this.f42268a = h.x(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f42269b = k.x((n0) f0Var.K(1), true);
        }
    }

    public g(h hVar, k kVar) {
        this.f42268a = hVar;
        this.f42269b = kVar;
    }

    public static g x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
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

    public h A() {
        return this.f42268a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f42268a);
        k kVar = this.f42269b;
        if (kVar != null) {
            iVar.a(new n2(true, 0, (gm.h) kVar));
        }
        return new j2(iVar);
    }

    public k z() {
        return this.f42269b;
    }
}
