package zn;

import gm.j2;
import gm.l2;

/* JADX INFO: loaded from: classes5.dex */
public class m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f58851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f58852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f58853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.t f58854e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.u1 f58856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f58857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.o f58858i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.o f58859j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f58850a = new gm.t(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.i f58855f = new gm.i();

    public void a(String str, gm.h hVar) {
        this.f58855f.a(new e(new gm.y(str), new l2(hVar)));
    }

    public void b(e eVar) {
        this.f58855f.a(eVar);
    }

    public g c() {
        if (this.f58854e == null || this.f58853d == null || this.f58852c == null || this.f58858i == null || this.f58859j == null || this.f58851b == null || this.f58855f == null) {
            throw new IllegalStateException("not all mandatory fields set in V2 AttributeCertificateInfo generator");
        }
        gm.i iVar = new gm.i(9);
        iVar.a(this.f58850a);
        iVar.a(this.f58851b);
        iVar.a(this.f58852c);
        iVar.a(this.f58853d);
        iVar.a(this.f58854e);
        iVar.a(new d(this.f58858i, this.f58859j));
        iVar.a(new j2(this.f58855f));
        gm.u1 u1Var = this.f58856g;
        if (u1Var != null) {
            iVar.a(u1Var);
        }
        z zVar = this.f58857h;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return g.C(new j2(iVar));
    }

    public void d(gm.o oVar) {
        this.f58859j = oVar;
    }

    public void e(z zVar) {
        this.f58857h = zVar;
    }

    public void f(u1 u1Var) {
        this.f58857h = z.G(u1Var.b());
    }

    public void g(f0 f0Var) {
        this.f58851b = f0Var;
    }

    public void h(c cVar) {
        this.f58852c = cVar;
    }

    public void i(gm.u1 u1Var) {
        this.f58856g = u1Var;
    }

    public void j(gm.t tVar) {
        this.f58854e = tVar;
    }

    public void k(b bVar) {
        this.f58853d = bVar;
    }

    public void l(gm.o oVar) {
        this.f58858i = oVar;
    }
}
