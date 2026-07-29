package zn;

import gm.f2;
import gm.j2;
import gm.n2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class o1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final gm.f0[] f58877h = {g(0), g(1), g(2), g(3), g(4), g(5), g(6), g(7), g(8), g(9), g(10)};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f58879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xn.d f58880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j1 f58881d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f58878a = new gm.t(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j1 f58882e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f58883f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.i f58884g = new gm.i();

    public static gm.f0 f(gm.o oVar) {
        gm.i iVar = new gm.i(2);
        try {
            iVar.a(y.f59069n);
            iVar.a(new f2(oVar.getEncoded()));
            return new j2(iVar);
        } catch (IOException e10) {
            throw new IllegalArgumentException("error encoding reason: " + e10);
        }
    }

    public static gm.f0 g(int i10) {
        gm.i iVar = new gm.i(2);
        m mVarZ = m.z(i10);
        try {
            iVar.a(y.f59067l);
            iVar.a(new f2(mVarZ.getEncoded()));
            return new j2(iVar);
        } catch (IOException e10) {
            throw new IllegalArgumentException("error encoding reason: " + e10);
        }
    }

    public void a(gm.t tVar, gm.q0 q0Var, int i10) {
        b(tVar, new j1(q0Var), i10);
    }

    public void b(gm.t tVar, j1 j1Var, int i10) {
        c(tVar, j1Var, i10, null);
    }

    public void c(gm.t tVar, j1 j1Var, int i10, gm.o oVar) {
        j2 j2Var;
        gm.f0 f0VarG;
        if (i10 != 0) {
            gm.i iVar = new gm.i(2);
            gm.f0[] f0VarArr = f58877h;
            if (i10 >= f0VarArr.length) {
                f0VarG = g(i10);
            } else {
                if (i10 < 0) {
                    throw new IllegalArgumentException("invalid reason value: " + i10);
                }
                f0VarG = f0VarArr[i10];
            }
            iVar.a(f0VarG);
            if (oVar != null) {
                iVar.a(f(oVar));
            }
            j2Var = new j2(iVar);
        } else {
            if (oVar == null) {
                d(tVar, j1Var, null);
                return;
            }
            j2Var = new j2(f(oVar));
        }
        i(tVar, j1Var, j2Var);
    }

    public void d(gm.t tVar, j1 j1Var, z zVar) {
        gm.i iVar = new gm.i(3);
        iVar.a(tVar);
        iVar.a(j1Var);
        if (zVar != null) {
            iVar.a(zVar);
        }
        e(new j2(iVar));
    }

    public void e(gm.f0 f0Var) {
        this.f58884g.a(f0Var);
    }

    public d1 h() {
        if (this.f58879b == null || this.f58880c == null || this.f58881d == null) {
            throw new IllegalStateException("Not all mandatory fields set in V2 TBSCertList generator.");
        }
        gm.i iVar = new gm.i(7);
        iVar.a(this.f58878a);
        iVar.a(this.f58879b);
        iVar.a(this.f58880c);
        iVar.a(this.f58881d);
        j1 j1Var = this.f58882e;
        if (j1Var != null) {
            iVar.a(j1Var);
        }
        if (this.f58884g.i() != 0) {
            iVar.a(new j2(this.f58884g));
        }
        z zVar = this.f58883f;
        if (zVar != null) {
            iVar.a(new n2(0, zVar));
        }
        return new d1(new j2(iVar));
    }

    public final void i(gm.t tVar, j1 j1Var, gm.f0 f0Var) {
        gm.i iVar = new gm.i(3);
        iVar.a(tVar);
        iVar.a(j1Var);
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        e(new j2(iVar));
    }

    public void j(z zVar) {
        this.f58883f = zVar;
    }

    public void k(u1 u1Var) {
        j(z.G(u1Var));
    }

    public void l(xn.d dVar) {
        this.f58880c = dVar;
    }

    public void m(w1 w1Var) {
        this.f58880c = xn.d.A(w1Var.b());
    }

    public void n(gm.q0 q0Var) {
        this.f58882e = new j1(q0Var);
    }

    public void o(j1 j1Var) {
        this.f58882e = j1Var;
    }

    public void p(b bVar) {
        this.f58879b = bVar;
    }

    public void q(gm.q0 q0Var) {
        this.f58881d = new j1(q0Var);
    }

    public void r(j1 j1Var) {
        this.f58881d = j1Var;
    }
}
