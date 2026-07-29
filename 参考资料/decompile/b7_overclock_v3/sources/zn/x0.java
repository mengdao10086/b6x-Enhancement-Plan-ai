package zn;

import gm.j2;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class x0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f59055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f59056b;

    public x0(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            Enumeration enumerationL = f0Var.L();
            this.f59055a = gm.t.I(enumerationL.nextElement()).J();
            this.f59056b = gm.t.I(enumerationL.nextElement()).J();
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public x0(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f59055a = bigInteger;
        this.f59056b = bigInteger2;
    }

    public static x0 x(gm.n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static x0 y(Object obj) {
        if (obj == null || (obj instanceof x0)) {
            return (x0) obj;
        }
        if (obj instanceof gm.f0) {
            return new x0((gm.f0) obj);
        }
        throw new IllegalArgumentException("Invalid RSAPublicKeyStructure: " + obj.getClass().getName());
    }

    public BigInteger A() {
        return this.f59056b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new gm.t(z()));
        iVar.a(new gm.t(A()));
        return new j2(iVar);
    }

    public BigInteger z() {
        return this.f59055a;
    }
}
