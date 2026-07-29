package mm;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class o0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f41367a;

    public o0(gm.c0 c0Var) {
        this.f41367a = c0Var;
    }

    public o0(a0 a0Var) {
        this.f41367a = new n2(false, 2, (gm.h) a0Var);
    }

    public o0(c0 c0Var) {
        this.f41367a = new n2(false, 1, (gm.h) c0Var);
    }

    public o0(d0 d0Var) {
        this.f41367a = d0Var;
    }

    public o0(j0 j0Var) {
        this.f41367a = new n2(false, 4, (gm.h) j0Var);
    }

    public o0(l0 l0Var) {
        this.f41367a = new n2(false, 3, (gm.h) l0Var);
    }

    public static o0 y(Object obj) {
        if (obj == null || (obj instanceof o0)) {
            return (o0) obj;
        }
        if (obj instanceof gm.f0) {
            return new o0((gm.f0) obj);
        }
        if (obj instanceof gm.n0) {
            return new o0((gm.n0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public gm.t A() {
        gm.h hVar = this.f41367a;
        if (!(hVar instanceof gm.n0)) {
            return d0.y(hVar).B();
        }
        gm.n0 n0Var = (gm.n0) hVar;
        int iQ = n0Var.q();
        if (iQ == 1) {
            return c0.x(n0Var, false).D();
        }
        if (iQ == 2) {
            return z(n0Var).C();
        }
        if (iQ == 3) {
            return l0.y(n0Var, false).C();
        }
        if (iQ == 4) {
            return new gm.t(0L);
        }
        throw new IllegalStateException("unknown tag");
    }

    public boolean B() {
        return this.f41367a instanceof gm.n0;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41367a.b();
    }

    public gm.h x() {
        gm.h hVar = this.f41367a;
        if (!(hVar instanceof gm.n0)) {
            return d0.y(hVar);
        }
        gm.n0 n0Var = (gm.n0) hVar;
        int iQ = n0Var.q();
        if (iQ == 1) {
            return c0.x(n0Var, false);
        }
        if (iQ == 2) {
            return z(n0Var);
        }
        if (iQ == 3) {
            return l0.y(n0Var, false);
        }
        if (iQ == 4) {
            return j0.x(n0Var, false);
        }
        throw new IllegalStateException("unknown tag");
    }

    public final a0 z(gm.n0 n0Var) {
        return a0.y(n0Var, n0Var.W());
    }
}
