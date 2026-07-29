package zn;

import gm.j2;
import gm.n2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class r0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f58932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f58933b;

    public r0(gm.f0 f0Var) {
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            if (n0VarT.q() == 0) {
                this.f58932a = gm.t.H(n0VarT, false).K();
            } else {
                if (n0VarT.q() != 1) {
                    throw new IllegalArgumentException("Unknown tag encountered.");
                }
                this.f58933b = gm.t.H(n0VarT, false).K();
            }
        }
    }

    public r0(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f58932a = bigInteger;
        this.f58933b = bigInteger2;
    }

    public static r0 x(z zVar) {
        return z(z.E(zVar, y.f59079w));
    }

    public static r0 z(Object obj) {
        if (obj instanceof r0) {
            return (r0) obj;
        }
        if (obj != null) {
            return new r0(gm.f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f58932a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        if (this.f58932a != null) {
            iVar.a(new n2(false, 0, (gm.h) new gm.t(this.f58932a)));
        }
        if (this.f58933b != null) {
            iVar.a(new n2(false, 1, (gm.h) new gm.t(this.f58933b)));
        }
        return new j2(iVar);
    }

    public BigInteger y() {
        return this.f58933b;
    }
}
