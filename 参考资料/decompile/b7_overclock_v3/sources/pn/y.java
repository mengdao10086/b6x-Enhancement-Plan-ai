package pn;

import gm.f0;
import gm.j2;
import gm.n0;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f46889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f46891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f46892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f46893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f46894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f46895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BigInteger f46896i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f0 f46897j;

    public y(f0 f0Var) {
        this.f46897j = null;
        Enumeration enumerationL = f0Var.L();
        int iQ = ((gm.t) enumerationL.nextElement()).Q();
        if (iQ < 0 || iQ > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.f46888a = iQ;
        this.f46889b = ((gm.t) enumerationL.nextElement()).K();
        this.f46890c = ((gm.t) enumerationL.nextElement()).K();
        this.f46891d = ((gm.t) enumerationL.nextElement()).K();
        this.f46892e = ((gm.t) enumerationL.nextElement()).K();
        this.f46893f = ((gm.t) enumerationL.nextElement()).K();
        this.f46894g = ((gm.t) enumerationL.nextElement()).K();
        this.f46895h = ((gm.t) enumerationL.nextElement()).K();
        this.f46896i = ((gm.t) enumerationL.nextElement()).K();
        if (enumerationL.hasMoreElements()) {
            this.f46897j = (f0) enumerationL.nextElement();
        }
    }

    public y(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.f46897j = null;
        this.f46888a = 0;
        this.f46889b = bigInteger;
        this.f46890c = bigInteger2;
        this.f46891d = bigInteger3;
        this.f46892e = bigInteger4;
        this.f46893f = bigInteger5;
        this.f46894g = bigInteger6;
        this.f46895h = bigInteger7;
        this.f46896i = bigInteger8;
    }

    public static y A(n0 n0Var, boolean z10) {
        return B(f0.I(n0Var, z10));
    }

    public static y B(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj instanceof f0) {
            return new y((f0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BigInteger C() {
        return this.f46889b;
    }

    public BigInteger D() {
        return this.f46892e;
    }

    public BigInteger E() {
        return this.f46893f;
    }

    public BigInteger F() {
        return this.f46891d;
    }

    public BigInteger G() {
        return this.f46890c;
    }

    public int H() {
        return this.f46888a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(10);
        iVar.a(new gm.t(this.f46888a));
        iVar.a(new gm.t(C()));
        iVar.a(new gm.t(G()));
        iVar.a(new gm.t(F()));
        iVar.a(new gm.t(D()));
        iVar.a(new gm.t(E()));
        iVar.a(new gm.t(y()));
        iVar.a(new gm.t(z()));
        iVar.a(new gm.t(x()));
        f0 f0Var = this.f46897j;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f46896i;
    }

    public BigInteger y() {
        return this.f46894g;
    }

    public BigInteger z() {
        return this.f46895h;
    }
}
