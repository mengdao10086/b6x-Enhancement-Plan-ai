package zn;

import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f f58774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58775b;

    public j(int i10) {
        this.f58774a = gm.f.K(false);
        this.f58775b = null;
        this.f58774a = gm.f.K(true);
        this.f58775b = new gm.t(i10);
    }

    public j(gm.f0 f0Var) {
        this.f58774a = gm.f.K(false);
        this.f58775b = null;
        if (f0Var.size() == 0) {
            this.f58774a = null;
            this.f58775b = null;
            return;
        }
        if (f0Var.K(0) instanceof gm.f) {
            this.f58774a = gm.f.J(f0Var.K(0));
        } else {
            this.f58774a = null;
            this.f58775b = gm.t.I(f0Var.K(0));
        }
        if (f0Var.size() > 1) {
            if (this.f58774a == null) {
                throw new IllegalArgumentException("wrong sequence in constructor");
            }
            this.f58775b = gm.t.I(f0Var.K(1));
        }
    }

    public j(boolean z10) {
        this.f58774a = gm.f.K(false);
        this.f58775b = null;
        if (z10) {
            this.f58774a = gm.f.K(true);
        } else {
            this.f58774a = null;
        }
        this.f58775b = null;
    }

    public static j x(z zVar) {
        return z(z.E(zVar, y.f59063j));
    }

    public static j y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static j z(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof t1) {
            return z(t1.a((t1) obj));
        }
        if (obj != null) {
            return new j(gm.f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        gm.t tVar = this.f58775b;
        if (tVar != null) {
            return tVar.K();
        }
        return null;
    }

    public boolean B() {
        gm.f fVar = this.f58774a;
        return fVar != null && fVar.L();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        gm.f fVar = this.f58774a;
        if (fVar != null) {
            iVar.a(fVar);
        }
        gm.t tVar = this.f58775b;
        if (tVar != null) {
            iVar.a(tVar);
        }
        return new j2(iVar);
    }

    public String toString() {
        StringBuilder sb2;
        if (this.f58775b == null) {
            sb2 = new StringBuilder();
            sb2.append("BasicConstraints: isCa(");
            sb2.append(B());
            sb2.append(ee.a.f26979d);
        } else {
            sb2 = new StringBuilder();
            sb2.append("BasicConstraints: isCa(");
            sb2.append(B());
            sb2.append("), pathLenConstraint = ");
            sb2.append(this.f58775b.K());
        }
        return sb2.toString();
    }
}
