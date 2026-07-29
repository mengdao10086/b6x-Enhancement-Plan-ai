package km;

import gm.j2;
import gm.p2;
import gm.r0;

/* JADX INFO: loaded from: classes5.dex */
public class i extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f37508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f37510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f37511d;

    public static class a extends gm.w implements gm.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f37512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f37513b;

        public a(c0 c0Var) {
            this(null, c0Var);
        }

        public a(e eVar) {
            this(eVar, null);
        }

        public a(e eVar, c0 c0Var) {
            this.f37512a = eVar;
            this.f37513b = c0Var;
        }

        public static a y(Object obj) {
            if (obj instanceof a) {
                return (a) obj;
            }
            if (obj instanceof gm.h) {
                gm.c0 c0VarB = ((gm.h) obj).b();
                if (c0VarB instanceof gm.t) {
                    return new a(e.x(c0VarB));
                }
                if (c0VarB instanceof gm.f0) {
                    return new a(c0.x(c0VarB));
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }

        @Override // gm.w, gm.h
        public gm.c0 b() {
            c0 c0Var = this.f37513b;
            return c0Var != null ? c0Var.b() : this.f37512a.b();
        }

        public boolean z() {
            return this.f37512a != null;
        }
    }

    public i(gm.f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() < 2 || f0Var.size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37508a = h.x(f0Var.K(0));
        this.f37509b = gm.f0.J(f0Var.K(1));
        if (f0Var.size() <= 3) {
            if (f0Var.size() <= 2) {
                this.f37510c = null;
            } else if (f0Var.K(2) instanceof r0) {
                this.f37510c = r0.I(f0Var.K(2));
            } else {
                this.f37510c = null;
                hVarK = f0Var.K(2);
            }
            this.f37511d = null;
            return;
        }
        this.f37510c = r0.I(f0Var.K(2));
        hVarK = f0Var.K(3);
        this.f37511d = a.y(hVarK);
    }

    public i(h hVar, gm.f0 f0Var, r0 r0Var, a aVar) {
        this.f37508a = hVar;
        this.f37509b = f0Var;
        this.f37510c = r0Var;
        this.f37511d = aVar;
    }

    public static i z(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(gm.f0.J(obj));
        }
        return null;
    }

    public a A() {
        return this.f37511d;
    }

    public p2 B() {
        r0 r0Var = this.f37510c;
        return (r0Var == null || (r0Var instanceof p2)) ? (p2) r0Var : new p2(this.f37510c.d());
    }

    public r0 C() {
        return this.f37510c;
    }

    public boolean D() {
        return this.f37511d != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f37508a);
        iVar.a(this.f37509b);
        r0 r0Var = this.f37510c;
        if (r0Var != null) {
            iVar.a(r0Var);
        }
        a aVar = this.f37511d;
        if (aVar != null) {
            iVar.a(aVar);
        }
        return new j2(iVar);
    }

    public km.a[] x() {
        return k0.c(this.f37509b);
    }

    public h y() {
        return this.f37508a;
    }
}
