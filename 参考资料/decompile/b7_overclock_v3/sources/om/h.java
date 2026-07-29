package om;

import gm.j2;
import gm.n2;
import gm.u1;
import zn.c1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f44293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f44294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f44295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xn.d f44296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n f44297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xn.d f44298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c1 f44299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u1 f44300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public u1 f44301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f44302j;

    public final void a(gm.i iVar, int i10, boolean z10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(z10, i10, hVar));
        }
    }

    public g b() {
        gm.i iVar = new gm.i(10);
        a(iVar, 0, false, this.f44293a);
        a(iVar, 1, false, this.f44294b);
        a(iVar, 2, false, this.f44295c);
        a(iVar, 3, true, this.f44296d);
        a(iVar, 4, false, this.f44297e);
        a(iVar, 5, true, this.f44298f);
        a(iVar, 6, false, this.f44299g);
        a(iVar, 7, false, this.f44300h);
        a(iVar, 8, false, this.f44301i);
        a(iVar, 9, false, this.f44302j);
        return g.y(new j2(iVar));
    }

    public h c(z zVar) {
        this.f44302j = zVar;
        return this;
    }

    public h d(zn.u1 u1Var) {
        return c(z.G(u1Var));
    }

    public h e(xn.d dVar) {
        this.f44296d = dVar;
        return this;
    }

    public h f(u1 u1Var) {
        this.f44300h = u1Var;
        return this;
    }

    public h g(c1 c1Var) {
        this.f44299g = c1Var;
        return this;
    }

    public h h(gm.t tVar) {
        this.f44294b = tVar;
        return this;
    }

    public h i(zn.b bVar) {
        this.f44295c = bVar;
        return this;
    }

    public h j(xn.d dVar) {
        this.f44298f = dVar;
        return this;
    }

    public h k(u1 u1Var) {
        this.f44301i = u1Var;
        return this;
    }

    public h l(n nVar) {
        this.f44297e = nVar;
        return this;
    }

    public h m(int i10) {
        this.f44293a = new gm.t(i10);
        return this;
    }
}
