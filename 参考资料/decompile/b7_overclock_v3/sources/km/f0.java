package km;

import gm.j2;
import gm.p2;
import gm.r0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xn.d f37485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.t f37486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.m f37487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f37488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.z f37489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r0 f37490f;

    public f0(gm.f0 f0Var) {
        int i10 = 3;
        if (f0Var.size() < 3 || f0Var.size() > 6) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37485a = xn.d.A(f0Var.K(0));
        this.f37486b = gm.t.I(f0Var.K(1));
        this.f37487c = zn.m.x(f0Var.K(2));
        if (f0Var.size() > 3 && (f0Var.K(3).b() instanceof gm.o)) {
            this.f37488d = gm.o.M(f0Var.K(3));
            i10 = 4;
        }
        if (f0Var.size() > i10 && (f0Var.K(i10).b() instanceof gm.z)) {
            this.f37489e = gm.z.I(f0Var.K(i10));
            i10++;
        }
        if (f0Var.size() <= i10 || !(f0Var.K(i10).b() instanceof r0)) {
            return;
        }
        this.f37490f = r0.I(f0Var.K(i10));
    }

    public f0(xn.d dVar, gm.t tVar, zn.m mVar, gm.o oVar, gm.z zVar, r0 r0Var) {
        this.f37485a = dVar;
        this.f37486b = tVar;
        this.f37487c = mVar;
        this.f37488d = oVar;
        this.f37489e = zVar;
        this.f37490f = r0Var;
    }

    public static f0 z(Object obj) {
        if (obj instanceof f0) {
            return (f0) obj;
        }
        if (obj != null) {
            return new f0(gm.f0.J(obj));
        }
        return null;
    }

    public gm.o A() {
        return this.f37488d;
    }

    public xn.d B() {
        return this.f37485a;
    }

    public byte[] C() {
        gm.z zVar = this.f37489e;
        if (zVar != null) {
            return org.bouncycastle.util.a.p(zVar.J());
        }
        return null;
    }

    public gm.z D() {
        return this.f37489e;
    }

    public zn.m E() {
        return this.f37487c;
    }

    public BigInteger F() {
        return this.f37486b.K();
    }

    public void G(r0 r0Var) {
        this.f37490f = r0Var;
    }

    public void H(gm.o oVar) {
        this.f37488d = oVar;
    }

    public void I(gm.z zVar) {
        this.f37489e = zVar;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(this.f37485a);
        iVar.a(this.f37486b);
        iVar.a(this.f37487c);
        gm.o oVar = this.f37488d;
        if (oVar != null) {
            iVar.a(oVar);
        }
        gm.z zVar = this.f37489e;
        if (zVar != null) {
            iVar.a(zVar);
        }
        r0 r0Var = this.f37490f;
        if (r0Var != null) {
            iVar.a(r0Var);
        }
        return new j2(iVar);
    }

    public p2 x() {
        r0 r0Var = this.f37490f;
        return (r0Var == null || (r0Var instanceof p2)) ? (p2) r0Var : new p2(this.f37490f.d());
    }

    public r0 y() {
        return this.f37490f;
    }
}
