package mm;

import gm.c2;
import gm.j2;
import gm.p2;

/* JADX INFO: loaded from: classes5.dex */
public class e0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f f41307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.r0 f41308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.r f41309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f41310d;

    public e0(gm.f0 f0Var) {
        this.f41307a = gm.f.J(f0Var.K(0));
        int i10 = 1;
        if (1 < f0Var.size() && (f0Var.K(1) instanceof gm.r0)) {
            this.f41308b = gm.r0.I(f0Var.K(1));
            i10 = 2;
        }
        if (i10 < f0Var.size() && (f0Var.K(i10) instanceof gm.r)) {
            this.f41309c = gm.r.I(f0Var.K(i10));
            i10++;
        }
        if (i10 < f0Var.size()) {
            this.f41310d = c.z(f0Var.K(i10));
        }
    }

    public e0(gm.f fVar, gm.r0 r0Var, gm.r rVar, c cVar) {
        this.f41307a = fVar;
        this.f41308b = r0Var;
        this.f41309c = rVar;
        this.f41310d = cVar;
    }

    public static e0 z(Object obj) {
        if (obj instanceof e0) {
            return (e0) obj;
        }
        if (obj != null) {
            return new e0(gm.f0.J(obj));
        }
        return null;
    }

    public c2 A() {
        gm.r rVar = this.f41309c;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f41309c.d(), false);
    }

    public gm.r B() {
        return this.f41309c;
    }

    public c C() {
        return this.f41310d;
    }

    public boolean D() {
        return this.f41307a.L();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f41307a);
        gm.r0 r0Var = this.f41308b;
        if (r0Var != null) {
            iVar.a(r0Var);
        }
        gm.r rVar = this.f41309c;
        if (rVar != null) {
            iVar.a(rVar);
        }
        c cVar = this.f41310d;
        if (cVar != null) {
            iVar.a(cVar);
        }
        return new j2(iVar);
    }

    public p2 x() {
        gm.r0 r0Var = this.f41308b;
        return (r0Var == null || (r0Var instanceof p2)) ? (p2) r0Var : new p2(this.f41308b.d());
    }

    public gm.r0 y() {
        return this.f41308b;
    }
}
