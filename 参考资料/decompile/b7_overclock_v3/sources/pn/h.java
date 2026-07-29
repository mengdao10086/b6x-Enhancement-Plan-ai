package pn;

import gm.f0;
import gm.j2;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f46764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f46765c;

    public h(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f46763a = gm.t.I(enumerationL.nextElement());
        this.f46764b = gm.t.I(enumerationL.nextElement());
        this.f46765c = enumerationL.hasMoreElements() ? (gm.t) enumerationL.nextElement() : null;
    }

    public h(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        this.f46763a = new gm.t(bigInteger);
        this.f46764b = new gm.t(bigInteger2);
        this.f46765c = i10 != 0 ? new gm.t(i10) : null;
    }

    public static h y(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f46763a.J();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f46763a);
        iVar.a(this.f46764b);
        if (z() != null) {
            iVar.a(this.f46765c);
        }
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f46764b.J();
    }

    public BigInteger z() {
        gm.t tVar = this.f46765c;
        if (tVar == null) {
            return null;
        }
        return tVar.J();
    }
}
