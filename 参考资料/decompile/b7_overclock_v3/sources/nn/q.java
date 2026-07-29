package nn;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import zn.b0;
import zn.u1;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class q extends w {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final t f42301f = new t(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f42302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f42303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f42304c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f42305d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42306e;

    public q(f0 f0Var) {
        int i10 = 0;
        if ((f0Var.K(0) instanceof n0) && ((n0) f0Var.K(0)).q() == 0) {
            this.f42306e = true;
            this.f42302a = t.H((n0) f0Var.K(0), true);
            i10 = 1;
        } else {
            this.f42302a = f42301f;
        }
        if (f0Var.K(i10) instanceof n0) {
            this.f42303b = b0.y((n0) f0Var.K(i10), true);
            i10++;
        }
        int i11 = i10 + 1;
        this.f42304c = (f0) f0Var.K(i10);
        if (f0Var.size() == i11 + 1) {
            this.f42305d = z.F((n0) f0Var.K(i11), true);
        }
    }

    public q(b0 b0Var, f0 f0Var, u1 u1Var) {
        this.f42302a = f42301f;
        this.f42303b = b0Var;
        this.f42304c = f0Var;
        this.f42305d = z.G(u1Var);
    }

    public q(b0 b0Var, f0 f0Var, z zVar) {
        this.f42302a = f42301f;
        this.f42303b = b0Var;
        this.f42304c = f0Var;
        this.f42305d = zVar;
    }

    public static q x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static q y(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(f0.J(obj));
        }
        return null;
    }

    public f0 A() {
        return this.f42304c;
    }

    public b0 B() {
        return this.f42303b;
    }

    public t C() {
        return this.f42302a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(4);
        if (!this.f42302a.C(f42301f) || this.f42306e) {
            iVar.a(new n2(true, 0, (gm.h) this.f42302a));
        }
        b0 b0Var = this.f42303b;
        if (b0Var != null) {
            iVar.a(new n2(true, 1, (gm.h) b0Var));
        }
        iVar.a(this.f42304c);
        z zVar = this.f42305d;
        if (zVar != null) {
            iVar.a(new n2(true, 2, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public z z() {
        return this.f42305d;
    }
}
