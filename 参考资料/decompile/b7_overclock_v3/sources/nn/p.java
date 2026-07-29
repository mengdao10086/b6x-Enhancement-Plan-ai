package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import zn.u1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class p extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f42296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f42297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.o f42298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f42299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public z f42300e;

    public p(f0 f0Var) {
        n0 n0Var;
        this.f42296a = b.z(f0Var.K(0));
        this.f42297b = c.y(f0Var.K(1));
        this.f42298c = gm.o.M(f0Var.K(2));
        if (f0Var.size() > 4) {
            this.f42299d = gm.o.L((n0) f0Var.K(3), true);
            n0Var = (n0) f0Var.K(4);
        } else {
            if (f0Var.size() <= 3) {
                return;
            }
            n0Var = (n0) f0Var.K(3);
            if (n0Var.q() == 0) {
                this.f42299d = gm.o.L(n0Var, true);
                return;
            }
        }
        this.f42300e = z.F(n0Var, true);
    }

    public p(b bVar, c cVar, gm.o oVar, gm.o oVar2, u1 u1Var) {
        this(bVar, cVar, oVar, oVar2, z.G(u1Var));
    }

    public p(b bVar, c cVar, gm.o oVar, gm.o oVar2, z zVar) {
        this.f42296a = bVar;
        this.f42297b = cVar;
        this.f42298c = oVar;
        this.f42299d = oVar2;
        this.f42300e = zVar;
    }

    public static p A(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(f0.J(obj));
        }
        return null;
    }

    public static p z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    public gm.o B() {
        return this.f42299d;
    }

    public z C() {
        return this.f42300e;
    }

    public gm.o D() {
        return this.f42298c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f42296a);
        iVar.a(this.f42297b);
        iVar.a(this.f42298c);
        gm.o oVar = this.f42299d;
        if (oVar != null) {
            iVar.a(new n2(true, 0, (gm.h) oVar));
        }
        z zVar = this.f42300e;
        if (zVar != null) {
            iVar.a(new n2(true, 1, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public b x() {
        return this.f42296a;
    }

    public c y() {
        return this.f42297b;
    }
}
