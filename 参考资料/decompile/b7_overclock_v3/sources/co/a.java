package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f11089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f11090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f11091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f11092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f11093e;

    public a(f0 f0Var) {
        if (f0Var.size() < 3 || f0Var.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        this.f11089a = t.I(enumerationL.nextElement());
        this.f11090b = t.I(enumerationL.nextElement());
        this.f11091c = t.I(enumerationL.nextElement());
        gm.h hVarB = B(enumerationL);
        if (hVarB != null && (hVarB instanceof t)) {
            this.f11092d = t.I(hVarB);
            hVarB = B(enumerationL);
        }
        if (hVarB != null) {
            this.f11093e = c.y(hVarB.b());
        }
    }

    public a(t tVar, t tVar2, t tVar3, t tVar4, c cVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (tVar2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (tVar3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f11089a = tVar;
        this.f11090b = tVar2;
        this.f11091c = tVar3;
        this.f11092d = tVar4;
        this.f11093e = cVar;
    }

    public a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, c cVar) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (bigInteger3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f11089a = new t(bigInteger);
        this.f11090b = new t(bigInteger2);
        this.f11091c = new t(bigInteger3);
        this.f11092d = new t(bigInteger4);
        this.f11093e = cVar;
    }

    public static gm.h B(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (gm.h) enumeration.nextElement();
        }
        return null;
    }

    public static a y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static a z(Object obj) {
        if (obj == null || (obj instanceof a)) {
            return (a) obj;
        }
        if (obj instanceof f0) {
            return new a((f0) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    public t A() {
        return this.f11092d;
    }

    public t C() {
        return this.f11089a;
    }

    public t D() {
        return this.f11091c;
    }

    public c E() {
        return this.f11093e;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f11089a);
        iVar.a(this.f11090b);
        iVar.a(this.f11091c);
        t tVar = this.f11092d;
        if (tVar != null) {
            iVar.a(tVar);
        }
        c cVar = this.f11093e;
        if (cVar != null) {
            iVar.a(cVar);
        }
        return new j2(iVar);
    }

    public t x() {
        return this.f11090b;
    }
}
