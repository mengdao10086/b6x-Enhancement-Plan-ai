package km;

import gm.j2;
import gm.n0;
import zn.y0;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xn.d f37557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b0 f37558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.o f37559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y0 f37560d;

    public t(gm.f0 f0Var) {
        int i10 = 1;
        if (f0Var.size() < 1 || f0Var.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37557a = xn.d.A(f0Var.K(0));
        if (f0Var.size() > 1 && (f0Var.K(1).b() instanceof n0)) {
            this.f37558b = zn.b0.z(f0Var.K(1));
            i10 = 2;
        }
        if (f0Var.size() > i10 && (f0Var.K(i10).b() instanceof gm.o)) {
            this.f37559c = gm.o.M(f0Var.K(i10));
            i10++;
        }
        if (f0Var.size() <= i10 || !(f0Var.K(i10).b() instanceof gm.d)) {
            return;
        }
        this.f37560d = new y0(gm.d.K(f0Var.K(i10)));
    }

    public t(xn.d dVar, zn.b0 b0Var, gm.o oVar, y0 y0Var) {
        this.f37557a = dVar;
        this.f37558b = b0Var;
        this.f37559c = oVar;
        this.f37560d = y0Var;
    }

    public static t x(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(gm.f0.J(obj));
        }
        return null;
    }

    public gm.o A() {
        return this.f37559c;
    }

    public zn.b0 B() {
        return this.f37558b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f37557a);
        zn.b0 b0Var = this.f37558b;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        gm.o oVar = this.f37559c;
        if (oVar != null) {
            iVar.a(oVar);
        }
        y0 y0Var = this.f37560d;
        if (y0Var != null) {
            iVar.a(y0Var);
        }
        return new j2(iVar);
    }

    public xn.d y() {
        return this.f37557a;
    }

    public y0 z() {
        return this.f37560d;
    }
}
