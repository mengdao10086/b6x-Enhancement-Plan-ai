package mm;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h0 f41325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h0 f41326b;

    public g0(gm.f0 f0Var) {
        gm.n0 n0Var;
        int size = f0Var.size();
        if (size != 0) {
            if (size == 1) {
                n0Var = (gm.n0) f0Var.K(0);
                int iQ = n0Var.q();
                if (iQ == 0) {
                    this.f41325a = gm.h0.H(n0Var, false);
                    return;
                } else if (iQ != 1) {
                    throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + n0Var.q());
                }
            } else {
                if (size != 2) {
                    throw new IllegalArgumentException("OriginatorInfo too big");
                }
                this.f41325a = gm.h0.H((gm.n0) f0Var.K(0), false);
                n0Var = (gm.n0) f0Var.K(1);
            }
            this.f41326b = gm.h0.H(n0Var, false);
        }
    }

    public g0(gm.h0 h0Var, gm.h0 h0Var2) {
        this.f41325a = h0Var;
        this.f41326b = h0Var2;
    }

    public static g0 A(Object obj) {
        if (obj instanceof g0) {
            return (g0) obj;
        }
        if (obj != null) {
            return new g0(gm.f0.J(obj));
        }
        return null;
    }

    public static g0 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        gm.h0 h0Var = this.f41325a;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        gm.h0 h0Var2 = this.f41326b;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var2));
        }
        return new j2(iVar);
    }

    public gm.h0 x() {
        return this.f41326b;
    }

    public gm.h0 y() {
        return this.f41325a;
    }
}
