package bo;

import gm.c0;
import gm.d0;
import gm.f0;
import gm.h;
import gm.i;
import gm.i2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.o;
import gm.t;
import gm.w;
import java.math.BigInteger;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f9504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f9505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f9506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public xn.b f9507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public xn.b f9509f;

    public b(a aVar, BigInteger bigInteger, o oVar, xn.b bVar, String str, xn.b bVar2) {
        this.f9504a = aVar;
        this.f9506c = oVar;
        this.f9508e = str;
        this.f9505b = bigInteger;
        this.f9509f = bVar2;
        this.f9507d = bVar;
    }

    public b(f0 f0Var) {
        if (f0Var.size() < 1) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        this.f9504a = a.y(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0VarT = n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f9505b = t.H(n0VarT, false).K();
            } else if (iQ == 1) {
                this.f9506c = o.L(n0VarT, false);
            } else if (iQ == 2) {
                this.f9507d = xn.b.x(n0VarT, true);
            } else if (iQ == 3) {
                this.f9508e = d0.H(n0VarT, false).d();
            } else {
                if (iQ != 4) {
                    throw new IllegalArgumentException("Bad tag number: " + n0VarT.q());
                }
                this.f9509f = xn.b.x(n0VarT, true);
            }
        }
    }

    public static b z(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof f0) {
            return new b((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public BigInteger A() {
        return this.f9505b;
    }

    public a B() {
        return this.f9504a;
    }

    public xn.b C() {
        return this.f9507d;
    }

    public xn.b D() {
        return this.f9509f;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(6);
        iVar.a(this.f9504a);
        if (this.f9505b != null) {
            iVar.a(new n2(false, 0, (h) new t(this.f9505b)));
        }
        o oVar = this.f9506c;
        if (oVar != null) {
            iVar.a(new n2(false, 1, (h) oVar));
        }
        xn.b bVar = this.f9507d;
        if (bVar != null) {
            iVar.a(new n2(true, 2, (h) bVar));
        }
        if (this.f9508e != null) {
            iVar.a(new n2(false, 3, (h) new i2(this.f9508e, true)));
        }
        xn.b bVar2 = this.f9509f;
        if (bVar2 != null) {
            iVar.a(new n2(true, 4, (h) bVar2));
        }
        return new j2(iVar);
    }

    public o x() {
        return this.f9506c;
    }

    public String y() {
        return this.f9508e;
    }
}
