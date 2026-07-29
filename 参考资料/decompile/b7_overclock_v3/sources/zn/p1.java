package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n2 f58892a = new n2(true, 0, (gm.h) new gm.t(2));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f58894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xn.d f58895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j1 f58896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j1 f58897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xn.d f58898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c1 f58899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z f58900i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f58901j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gm.u1 f58902k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public gm.u1 f58903l;

    public e1 a() {
        if (this.f58893b == null || this.f58894c == null || this.f58895d == null || this.f58896e == null || this.f58897f == null || ((this.f58898g == null && !this.f58901j) || this.f58899h == null)) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        gm.i iVar = new gm.i(10);
        iVar.a(this.f58892a);
        iVar.a(this.f58893b);
        iVar.a(this.f58894c);
        iVar.a(this.f58895d);
        gm.i iVar2 = new gm.i(2);
        iVar2.a(this.f58896e);
        iVar2.a(this.f58897f);
        iVar.a(new j2(iVar2));
        gm.h j2Var = this.f58898g;
        if (j2Var == null) {
            j2Var = new j2();
        }
        iVar.a(j2Var);
        iVar.a(this.f58899h);
        gm.u1 u1Var = this.f58902k;
        if (u1Var != null) {
            iVar.a(new n2(false, 1, (gm.h) u1Var));
        }
        gm.u1 u1Var2 = this.f58903l;
        if (u1Var2 != null) {
            iVar.a(new n2(false, 2, (gm.h) u1Var2));
        }
        z zVar = this.f58900i;
        if (zVar != null) {
            iVar.a(new n2(true, 3, (gm.h) zVar));
        }
        return e1.A(new j2(iVar));
    }

    public void b(gm.q0 q0Var) {
        this.f58897f = new j1(q0Var);
    }

    public void c(j1 j1Var) {
        this.f58897f = j1Var;
    }

    public void d(z zVar) {
        y yVarZ;
        this.f58900i = zVar;
        if (zVar == null || (yVarZ = zVar.z(y.f59061h)) == null || !yVarZ.D()) {
            return;
        }
        this.f58901j = true;
    }

    public void e(u1 u1Var) {
        d(z.G(u1Var));
    }

    public void f(xn.d dVar) {
        this.f58895d = dVar;
    }

    public void g(w1 w1Var) {
        this.f58895d = xn.d.A(w1Var);
    }

    public void h(gm.u1 u1Var) {
        this.f58902k = u1Var;
    }

    public void i(gm.t tVar) {
        this.f58893b = tVar;
    }

    public void j(b bVar) {
        this.f58894c = bVar;
    }

    public void k(gm.q0 q0Var) {
        this.f58896e = new j1(q0Var);
    }

    public void l(j1 j1Var) {
        this.f58896e = j1Var;
    }

    public void m(xn.d dVar) {
        this.f58898g = dVar;
    }

    public void n(w1 w1Var) {
        this.f58898g = xn.d.A(w1Var.b());
    }

    public void o(c1 c1Var) {
        this.f58899h = c1Var;
    }

    public void p(gm.u1 u1Var) {
        this.f58903l = u1Var;
    }
}
