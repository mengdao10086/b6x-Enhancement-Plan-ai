package mm;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y0 f41415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public un.g f41416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.f0 f41417c;

    public v(gm.n0 n0Var) {
        if (n0Var.q() == 0) {
            this.f41415a = y0.y(n0Var, false);
        } else if (n0Var.q() == 1) {
            this.f41416b = un.g.A(n0Var, false);
        } else {
            if (n0Var.q() != 2) {
                throw new IllegalArgumentException("unknown tag in Evidence");
            }
            this.f41417c = gm.f0.I(n0Var, false);
        }
    }

    public v(y0 y0Var) {
        this.f41415a = y0Var;
    }

    public v(un.g gVar) {
        this.f41416b = gVar;
    }

    public static v y(gm.n0 n0Var, boolean z10) {
        return z(n0Var.U());
    }

    public static v z(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof gm.n0) {
            return new v(gm.n0.T(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public y0 A() {
        return this.f41415a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        y0 y0Var = this.f41415a;
        if (y0Var != null) {
            return new n2(false, 0, (gm.h) y0Var);
        }
        un.g gVar = this.f41416b;
        return gVar != null ? new n2(false, 1, (gm.h) gVar) : new n2(false, 2, (gm.h) this.f41417c);
    }

    public un.g x() {
        return this.f41416b;
    }
}
