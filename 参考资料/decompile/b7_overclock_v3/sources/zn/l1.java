package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n2 f58817a = new n2(true, 0, (gm.h) new gm.t(0));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f58819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xn.d f58820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j1 f58821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j1 f58822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xn.d f58823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c1 f58824h;

    public e1 a() {
        if (this.f58818b == null || this.f58819c == null || this.f58820d == null || this.f58821e == null || this.f58822f == null || this.f58823g == null || this.f58824h == null) {
            throw new IllegalStateException("not all mandatory fields set in V1 TBScertificate generator");
        }
        gm.i iVar = new gm.i(6);
        iVar.a(this.f58818b);
        iVar.a(this.f58819c);
        iVar.a(this.f58820d);
        gm.i iVar2 = new gm.i(2);
        iVar2.a(this.f58821e);
        iVar2.a(this.f58822f);
        iVar.a(new j2(iVar2));
        iVar.a(this.f58823g);
        iVar.a(this.f58824h);
        return e1.A(new j2(iVar));
    }

    public void b(gm.q0 q0Var) {
        this.f58822f = new j1(q0Var);
    }

    public void c(j1 j1Var) {
        this.f58822f = j1Var;
    }

    public void d(xn.d dVar) {
        this.f58820d = dVar;
    }

    public void e(w1 w1Var) {
        this.f58820d = xn.d.A(w1Var.b());
    }

    public void f(gm.t tVar) {
        this.f58818b = tVar;
    }

    public void g(b bVar) {
        this.f58819c = bVar;
    }

    public void h(gm.q0 q0Var) {
        this.f58821e = new j1(q0Var);
    }

    public void i(j1 j1Var) {
        this.f58821e = j1Var;
    }

    public void j(xn.d dVar) {
        this.f58823g = dVar;
    }

    public void k(w1 w1Var) {
        this.f58823g = xn.d.A(w1Var.b());
    }

    public void l(c1 c1Var) {
        this.f58824h = c1Var;
    }
}
