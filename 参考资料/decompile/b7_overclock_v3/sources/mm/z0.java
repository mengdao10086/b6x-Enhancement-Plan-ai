package mm;

import gm.c2;
import gm.i1;

/* JADX INFO: loaded from: classes5.dex */
public class z0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.r f41439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f41440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f41441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f41442e;

    public z0(gm.f0 f0Var) {
        this.f41438a = gm.t.I(f0Var.K(0));
        int i10 = 1;
        if (f0Var.K(1) instanceof gm.r) {
            this.f41439b = gm.r.I(f0Var.K(1));
            i10 = 2;
        }
        if ((f0Var.K(i10) instanceof e0) || (f0Var.K(i10) instanceof gm.f0)) {
            this.f41440c = e0.z(f0Var.K(i10));
            i10++;
        }
        if (f0Var.K(i10) instanceof gm.z) {
            this.f41441d = gm.z.I(f0Var.K(i10));
            i10++;
        }
        this.f41442e = v.z(f0Var.K(i10));
    }

    public z0(gm.r rVar, e0 e0Var, gm.z zVar, v vVar) {
        this.f41438a = new gm.t(1L);
        this.f41439b = rVar;
        this.f41440c = e0Var;
        this.f41441d = zVar;
        this.f41442e = vVar;
    }

    public static z0 A(Object obj) {
        return (obj == null || (obj instanceof z0)) ? (z0) obj : new z0(gm.f0.J(obj));
    }

    public e0 B() {
        return this.f41440c;
    }

    public v C() {
        return this.f41442e;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f41438a);
        gm.r rVar = this.f41439b;
        if (rVar != null) {
            iVar.a(rVar);
        }
        e0 e0Var = this.f41440c;
        if (e0Var != null) {
            iVar.a(e0Var);
        }
        gm.z zVar = this.f41441d;
        if (zVar != null) {
            iVar.a(zVar);
        }
        iVar.a(this.f41442e);
        return new i1(iVar);
    }

    public gm.z x() {
        return this.f41441d;
    }

    public c2 y() {
        gm.r rVar = this.f41439b;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f41439b.d(), false);
    }

    public gm.r z() {
        return this.f41439b;
    }
}
