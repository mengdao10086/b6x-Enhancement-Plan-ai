package zn;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f58739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f58740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f58741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f58742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.t f58743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f58744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.f0 f58745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.d f58746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public z f58747i;

    public g(gm.f0 f0Var) {
        if (f0Var.size() < 6 || f0Var.size() > 9) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        int i10 = 0;
        if (f0Var.K(0) instanceof gm.t) {
            this.f58739a = gm.t.I(f0Var.K(0));
            i10 = 1;
        } else {
            this.f58739a = new gm.t(0L);
        }
        this.f58740b = f0.z(f0Var.K(i10));
        this.f58741c = c.y(f0Var.K(i10 + 1));
        this.f58742d = b.z(f0Var.K(i10 + 2));
        this.f58743e = gm.t.I(f0Var.K(i10 + 3));
        this.f58744f = d.x(f0Var.K(i10 + 4));
        this.f58745g = gm.f0.J(f0Var.K(i10 + 5));
        for (int i11 = i10 + 6; i11 < f0Var.size(); i11++) {
            gm.h hVarK = f0Var.K(i11);
            if (hVarK instanceof gm.d) {
                this.f58746h = gm.d.K(f0Var.K(i11));
            } else if ((hVarK instanceof gm.f0) || (hVarK instanceof z)) {
                this.f58747i = z.G(f0Var.K(i11));
            }
        }
    }

    public static g B(gm.n0 n0Var, boolean z10) {
        return C(gm.f0.I(n0Var, z10));
    }

    public static g C(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(gm.f0.J(obj));
        }
        return null;
    }

    public f0 A() {
        return this.f58740b;
    }

    public c D() {
        return this.f58741c;
    }

    public gm.d E() {
        return this.f58746h;
    }

    public gm.t F() {
        return this.f58743e;
    }

    public b G() {
        return this.f58742d;
    }

    public gm.t H() {
        return this.f58739a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(9);
        if (!this.f58739a.L(0)) {
            iVar.a(this.f58739a);
        }
        iVar.a(this.f58740b);
        iVar.a(this.f58741c);
        iVar.a(this.f58742d);
        iVar.a(this.f58743e);
        iVar.a(this.f58744f);
        iVar.a(this.f58745g);
        gm.d dVar = this.f58746h;
        if (dVar != null) {
            iVar.a(dVar);
        }
        z zVar = this.f58747i;
        if (zVar != null) {
            iVar.a(zVar);
        }
        return new j2(iVar);
    }

    public d x() {
        return this.f58744f;
    }

    public gm.f0 y() {
        return this.f58745g;
    }

    public z z() {
        return this.f58747i;
    }
}
