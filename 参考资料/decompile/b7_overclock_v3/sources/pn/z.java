package pn;

import gm.f0;
import gm.j2;
import gm.n0;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class z extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f46898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f46899b;

    public z(f0 f0Var) {
        if (f0Var.size() == 2) {
            Enumeration enumerationL = f0Var.L();
            this.f46898a = gm.t.I(enumerationL.nextElement()).J();
            this.f46899b = gm.t.I(enumerationL.nextElement()).J();
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public z(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f46898a = bigInteger;
        this.f46899b = bigInteger2;
    }

    public static z x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
    }

    public static z y(Object obj) {
        if (obj instanceof z) {
            return (z) obj;
        }
        if (obj != null) {
            return new z(f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f46899b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new gm.t(z()));
        iVar.a(new gm.t(A()));
        return new j2(iVar);
    }

    public BigInteger z() {
        return this.f46898a;
    }
}
