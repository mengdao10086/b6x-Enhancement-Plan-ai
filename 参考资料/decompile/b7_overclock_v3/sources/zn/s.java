package zn;

import gm.j2;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class s extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f58938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f58940c;

    public s(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        this.f58938a = gm.t.I(enumerationL.nextElement());
        this.f58939b = gm.t.I(enumerationL.nextElement());
        this.f58940c = gm.t.I(enumerationL.nextElement());
    }

    public s(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f58938a = new gm.t(bigInteger);
        this.f58939b = new gm.t(bigInteger2);
        this.f58940c = new gm.t(bigInteger3);
    }

    public static s y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static s z(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(gm.f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f58938a.J();
    }

    public BigInteger B() {
        return this.f58939b.J();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f58938a);
        iVar.a(this.f58939b);
        iVar.a(this.f58940c);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f58940c.J();
    }
}
