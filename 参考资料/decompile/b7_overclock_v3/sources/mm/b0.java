package mm;

import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f41283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p0 f41284b;

    public b0(p0 p0Var) {
        this.f41283a = null;
        this.f41284b = p0Var;
    }

    public b0(y yVar) {
        this.f41283a = yVar;
        this.f41284b = null;
    }

    public static b0 x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static b0 y(Object obj) {
        if (obj == null || (obj instanceof b0)) {
            return (b0) obj;
        }
        if (obj instanceof gm.f0) {
            return new b0(y.x(obj));
        }
        if (obj instanceof gm.n0) {
            gm.n0 n0Var = (gm.n0) obj;
            if (n0Var.q() == 0) {
                return new b0(p0.y(n0Var, false));
            }
        }
        throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier: " + obj.getClass().getName());
    }

    public p0 A() {
        return this.f41284b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        y yVar = this.f41283a;
        return yVar != null ? yVar.b() : new n2(false, 0, (gm.h) this.f41284b);
    }

    public y z() {
        return this.f41283a;
    }
}
