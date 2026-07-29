package mm;

import gm.i1;
import gm.n1;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.y f41362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f41363b;

    public n(gm.f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f41362a = (gm.y) f0Var.K(0);
        if (f0Var.size() > 1) {
            gm.n0 n0Var = (gm.n0) f0Var.K(1);
            if (!n0Var.W() || n0Var.q() != 0) {
                throw new IllegalArgumentException("Bad tag for 'content'");
            }
            this.f41363b = n0Var.U();
        }
    }

    public n(gm.y yVar, gm.h hVar) {
        this.f41362a = yVar;
        this.f41363b = hVar;
    }

    public static n A(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(gm.f0.J(obj));
        }
        return null;
    }

    public static n z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41362a);
        gm.h hVar = this.f41363b;
        if (hVar != null) {
            iVar.a(new n1(0, hVar));
        }
        return new i1(iVar);
    }

    public gm.h x() {
        return this.f41363b;
    }

    public gm.y y() {
        return this.f41362a;
    }
}
