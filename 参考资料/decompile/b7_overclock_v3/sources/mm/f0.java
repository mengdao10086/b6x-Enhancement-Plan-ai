package mm;

import gm.n2;
import zn.b1;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f41320a;

    public f0(gm.c0 c0Var) {
        this.f41320a = c0Var;
    }

    public f0(gm.z zVar) {
        this(new b1(zVar.J()));
    }

    public f0(h0 h0Var) {
        this.f41320a = new n2(false, 1, (gm.h) h0Var);
    }

    public f0(y yVar) {
        this.f41320a = yVar;
    }

    public f0(b1 b1Var) {
        this.f41320a = new n2(false, 0, (gm.h) b1Var);
    }

    public static f0 y(gm.n0 n0Var, boolean z10) {
        if (z10) {
            return z(n0Var.U());
        }
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public static f0 z(Object obj) {
        if (obj == null || (obj instanceof f0)) {
            return (f0) obj;
        }
        if ((obj instanceof y) || (obj instanceof gm.f0)) {
            return new f0(y.x(obj));
        }
        if (obj instanceof gm.n0) {
            gm.n0 n0Var = (gm.n0) obj;
            if (n0Var.q() == 0) {
                return new f0(b1.y(n0Var, false));
            }
            if (n0Var.q() == 1) {
                return new f0(h0.y(n0Var, false));
            }
        }
        throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: " + obj.getClass().getName());
    }

    public y A() {
        gm.h hVar = this.f41320a;
        if (hVar instanceof y) {
            return (y) hVar;
        }
        return null;
    }

    public h0 B() {
        gm.h hVar = this.f41320a;
        if ((hVar instanceof gm.n0) && ((gm.n0) hVar).q() == 1) {
            return h0.y((gm.n0) this.f41320a, false);
        }
        return null;
    }

    public b1 C() {
        gm.h hVar = this.f41320a;
        if ((hVar instanceof gm.n0) && ((gm.n0) hVar).q() == 0) {
            return b1.y((gm.n0) this.f41320a, false);
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f41320a.b();
    }

    public gm.h x() {
        return this.f41320a;
    }
}
