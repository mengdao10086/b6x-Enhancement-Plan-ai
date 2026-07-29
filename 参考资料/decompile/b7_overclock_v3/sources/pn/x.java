package pn;

import gm.f0;
import gm.j2;
import gm.n0;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f46878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f46879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f46881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f46882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f46883f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f46884g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f46885h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BigInteger f46886i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f0 f46887j;

    public x(f0 f0Var) {
        this.f46887j = null;
        Enumeration enumerationL = f0Var.L();
        gm.t tVar = (gm.t) enumerationL.nextElement();
        int iQ = tVar.Q();
        if (iQ < 0 || iQ > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.f46878a = tVar.K();
        this.f46879b = ((gm.t) enumerationL.nextElement()).K();
        this.f46880c = ((gm.t) enumerationL.nextElement()).K();
        this.f46881d = ((gm.t) enumerationL.nextElement()).K();
        this.f46882e = ((gm.t) enumerationL.nextElement()).K();
        this.f46883f = ((gm.t) enumerationL.nextElement()).K();
        this.f46884g = ((gm.t) enumerationL.nextElement()).K();
        this.f46885h = ((gm.t) enumerationL.nextElement()).K();
        this.f46886i = ((gm.t) enumerationL.nextElement()).K();
        if (enumerationL.hasMoreElements()) {
            this.f46887j = (f0) enumerationL.nextElement();
        }
    }

    public x(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.f46887j = null;
        this.f46878a = BigInteger.valueOf(0L);
        this.f46879b = bigInteger;
        this.f46880c = bigInteger2;
        this.f46881d = bigInteger3;
        this.f46882e = bigInteger4;
        this.f46883f = bigInteger5;
        this.f46884g = bigInteger6;
        this.f46885h = bigInteger7;
        this.f46886i = bigInteger8;
    }

    public static x A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static x B(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(f0.J(obj));
        }
        return null;
    }

    public BigInteger C() {
        return this.f46879b;
    }

    public BigInteger D() {
        return this.f46882e;
    }

    public BigInteger E() {
        return this.f46883f;
    }

    public BigInteger F() {
        return this.f46881d;
    }

    public BigInteger G() {
        return this.f46880c;
    }

    public BigInteger H() {
        return this.f46878a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(10);
        iVar.a(new gm.t(this.f46878a));
        iVar.a(new gm.t(C()));
        iVar.a(new gm.t(G()));
        iVar.a(new gm.t(F()));
        iVar.a(new gm.t(D()));
        iVar.a(new gm.t(E()));
        iVar.a(new gm.t(y()));
        iVar.a(new gm.t(z()));
        iVar.a(new gm.t(x()));
        f0 f0Var = this.f46887j;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f46886i;
    }

    public BigInteger y() {
        return this.f46884g;
    }

    public BigInteger z() {
        return this.f46885h;
    }
}
