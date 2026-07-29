package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import gm.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f52319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f52320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public y f52321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f52322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.f f52323e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f52324f;

    public k(f0 f0Var) {
        int size = f0Var.size();
        this.f52319a = t.I(f0Var.K(0));
        this.f52320b = h.z(f0Var.K(1));
        for (int i10 = 2; i10 < size; i10++) {
            if (f0Var.K(i10) instanceof y) {
                x(this.f52321c, i10, 2);
                this.f52321c = y.N(f0Var.K(i10));
            } else if (f0Var.K(i10) instanceof t) {
                x(this.f52322d, i10, 3);
                this.f52322d = t.I(f0Var.K(i10));
            } else if (f0Var.K(i10) instanceof gm.f) {
                x(this.f52323e, i10, 4);
                this.f52323e = gm.f.J(f0Var.K(i10));
            } else {
                if (!(f0Var.K(i10) instanceof n0)) {
                    throw new IllegalArgumentException("unidentified structure in sequence");
                }
                x(this.f52324f, i10, 5);
                n0 n0Var = (n0) f0Var.K(i10);
                if (n0Var.q() == 0) {
                    this.f52324f = z.F(n0Var, false);
                }
            }
        }
    }

    public k(h hVar, y yVar, t tVar, gm.f fVar, z zVar) {
        this.f52319a = new t(1L);
        this.f52320b = hVar;
        this.f52321c = yVar;
        this.f52322d = tVar;
        this.f52323e = fVar;
        this.f52324f = zVar;
    }

    public static k A(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    public h B() {
        return this.f52320b;
    }

    public t C() {
        return this.f52322d;
    }

    public y D() {
        return this.f52321c;
    }

    public t E() {
        return this.f52319a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(this.f52319a);
        iVar.a(this.f52320b);
        y yVar = this.f52321c;
        if (yVar != null) {
            iVar.a(yVar);
        }
        t tVar = this.f52322d;
        if (tVar != null) {
            iVar.a(tVar);
        }
        gm.f fVar = this.f52323e;
        if (fVar != null && fVar.L()) {
            iVar.a(this.f52323e);
        }
        z zVar = this.f52324f;
        if (zVar != null) {
            iVar.a(new n2(false, 0, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public final void x(Object obj, int i10, int i11) {
        if (obj != null || i10 > i11) {
            throw new IllegalArgumentException("badly placed optional in sequence");
        }
    }

    public gm.f y() {
        gm.f fVar = this.f52323e;
        return fVar == null ? gm.f.f29674e : fVar;
    }

    public z z() {
        return this.f52324f;
    }
}
