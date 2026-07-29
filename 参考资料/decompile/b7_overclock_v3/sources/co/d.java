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
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f11097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f11098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f11099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f11100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f11101e;

    public d(f0 f0Var) {
        if (f0Var.size() < 3 || f0Var.size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        this.f11097a = t.I(enumerationL.nextElement());
        this.f11098b = t.I(enumerationL.nextElement());
        this.f11099c = t.I(enumerationL.nextElement());
        gm.h hVarB = B(enumerationL);
        if (hVarB == null || !(hVarB instanceof t)) {
            this.f11100d = null;
        } else {
            this.f11100d = t.I(hVarB);
            hVarB = B(enumerationL);
        }
        if (hVarB != null) {
            this.f11101e = h.y(hVarB.b());
        } else {
            this.f11101e = null;
        }
    }

    public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, h hVar) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (bigInteger3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f11097a = new t(bigInteger);
        this.f11098b = new t(bigInteger2);
        this.f11099c = new t(bigInteger3);
        this.f11100d = bigInteger4 != null ? new t(bigInteger4) : null;
        this.f11101e = hVar;
    }

    public static gm.h B(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (gm.h) enumeration.nextElement();
        }
        return null;
    }

    public static d y(n0 n0Var, boolean z10) {
        return z(f0.I(n0Var, z10));
    }

    public static d z(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        t tVar = this.f11100d;
        if (tVar == null) {
            return null;
        }
        return tVar.J();
    }

    public BigInteger C() {
        return this.f11097a.J();
    }

    public BigInteger D() {
        return this.f11099c.J();
    }

    public h E() {
        return this.f11101e;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f11097a);
        iVar.a(this.f11098b);
        iVar.a(this.f11099c);
        t tVar = this.f11100d;
        if (tVar != null) {
            iVar.a(tVar);
        }
        h hVar = this.f11101e;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f11098b.J();
    }
}
