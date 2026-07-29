package km;

import gm.j2;
import gm.p2;
import gm.r0;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f37525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f37527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f37528d;

    public k(gm.f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() < 2 || f0Var.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37525a = h.x(f0Var.K(0));
        this.f37526b = gm.f0.J(f0Var.K(1));
        if (f0Var.size() > 2) {
            if (f0Var.size() == 4) {
                this.f37527c = r0.I(f0Var.K(2));
                hVarK = f0Var.K(3);
            } else if (f0Var.K(2) instanceof r0) {
                this.f37527c = r0.I(f0Var.K(2));
            } else {
                this.f37527c = null;
                hVarK = f0Var.K(2);
            }
            this.f37528d = z.x(hVarK);
            return;
        }
        this.f37527c = null;
        this.f37528d = null;
    }

    public k(h hVar, gm.f0 f0Var, r0 r0Var, z zVar) {
        this.f37525a = hVar;
        this.f37526b = f0Var;
        this.f37527c = r0Var;
        this.f37528d = zVar;
    }

    public static k y(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(gm.f0.J(obj));
        }
        return null;
    }

    public p2 A() {
        r0 r0Var = this.f37527c;
        return (r0Var == null || (r0Var instanceof p2)) ? (p2) r0Var : new p2(this.f37527c.d());
    }

    public r0 B() {
        return this.f37527c;
    }

    public h C() {
        return this.f37525a;
    }

    public boolean D() {
        return this.f37528d != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f37525a);
        iVar.a(this.f37526b);
        r0 r0Var = this.f37527c;
        if (r0Var != null) {
            iVar.a(r0Var);
        }
        z zVar = this.f37528d;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public a[] x() {
        return k0.c(this.f37526b);
    }

    public z z() {
        return this.f37528d;
    }
}
