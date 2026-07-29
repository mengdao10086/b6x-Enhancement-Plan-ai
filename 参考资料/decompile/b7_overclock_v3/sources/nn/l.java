package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import zn.u1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class l extends w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f42282g = new t(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f42284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f42285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.o f42286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f0 f42287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f42288f;

    public l(f0 f0Var) {
        int i10 = 0;
        if ((f0Var.K(0) instanceof n0) && ((n0) f0Var.K(0)).q() == 0) {
            this.f42283a = true;
            this.f42284b = t.H((n0) f0Var.K(0), true);
            i10 = 1;
        } else {
            this.f42284b = f42282g;
        }
        int i11 = i10 + 1;
        this.f42285c = j.y(f0Var.K(i10));
        int i12 = i11 + 1;
        this.f42286d = gm.o.M(f0Var.K(i11));
        int i13 = i12 + 1;
        this.f42287e = (f0) f0Var.K(i12);
        if (f0Var.size() > i13) {
            this.f42288f = z.F((n0) f0Var.K(i13), true);
        }
    }

    public l(t tVar, j jVar, gm.o oVar, f0 f0Var, z zVar) {
        this.f42284b = tVar;
        this.f42285c = jVar;
        this.f42286d = oVar;
        this.f42287e = f0Var;
        this.f42288f = zVar;
    }

    public l(j jVar, gm.o oVar, f0 f0Var, u1 u1Var) {
        this(f42282g, jVar, gm.o.M(oVar), f0Var, z.G(u1Var));
    }

    public l(j jVar, gm.o oVar, f0 f0Var, z zVar) {
        this(f42282g, jVar, oVar, f0Var, zVar);
    }

    public static l x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static l y(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    public j A() {
        return this.f42285c;
    }

    public z B() {
        return this.f42288f;
    }

    public f0 C() {
        return this.f42287e;
    }

    public t D() {
        return this.f42284b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        if (this.f42283a || !this.f42284b.C(f42282g)) {
            iVar.a(new n2(true, 0, (gm.h) this.f42284b));
        }
        iVar.a(this.f42285c);
        iVar.a(this.f42286d);
        iVar.a(this.f42287e);
        z zVar = this.f42288f;
        if (zVar != null) {
            iVar.a(new n2(true, 1, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public gm.o z() {
        return this.f42286d;
    }
}
