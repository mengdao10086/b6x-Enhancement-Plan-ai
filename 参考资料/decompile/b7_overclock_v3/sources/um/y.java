package um;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.p2;
import gm.r0;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xn.b f52281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.b f52282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f52283c;

    public y(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f52281a = xn.b.x(n0Var, true);
            } else if (iQ == 1) {
                this.f52282b = xn.b.x(n0Var, true);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("illegal tag");
                }
                this.f52283c = n0Var.W() ? f0.I(n0Var, true) : f0.I(n0Var, false);
                f0 f0Var2 = this.f52283c;
                if (f0Var2 != null && f0Var2.size() > 6) {
                    throw new IllegalArgumentException("postal address must contain less than 6 strings");
                }
            }
        }
    }

    public y(r0 r0Var, r0 r0Var2, f0 f0Var) {
        this(xn.b.y(r0Var), xn.b.y(r0Var2), f0Var);
    }

    public y(xn.b bVar, xn.b bVar2, f0 f0Var) {
        if (f0Var != null && f0Var.size() > 6) {
            throw new IllegalArgumentException("postal address must contain less than 6 strings");
        }
        this.f52281a = bVar;
        this.f52282b = bVar2;
        this.f52283c = f0Var;
    }

    public y(xn.b bVar, xn.b bVar2, xn.b[] bVarArr) {
        this(bVar, bVar2, new j2(bVarArr));
    }

    public static y z(Object obj) {
        return (obj == null || (obj instanceof y)) ? (y) obj : new y(f0.J(obj));
    }

    public xn.b A() {
        return this.f52282b;
    }

    public p2 B() {
        if (this.f52282b == null) {
            return null;
        }
        return new p2(A().d());
    }

    public xn.b[] C() {
        f0 f0Var = this.f52283c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        xn.b[] bVarArr = new xn.b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = xn.b.y(this.f52283c.K(i10));
        }
        return bVarArr;
    }

    public f0 D() {
        return this.f52283c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        xn.b bVar = this.f52281a;
        if (bVar != null) {
            iVar.a(new n2(true, 0, (gm.h) bVar));
        }
        xn.b bVar2 = this.f52282b;
        if (bVar2 != null) {
            iVar.a(new n2(true, 1, (gm.h) bVar2));
        }
        f0 f0Var = this.f52283c;
        if (f0Var != null) {
            iVar.a(new n2(true, 2, (gm.h) f0Var));
        }
        return new j2(iVar);
    }

    public xn.b x() {
        return this.f52281a;
    }

    public p2 y() {
        if (this.f52281a == null) {
            return null;
        }
        return new p2(x().d());
    }
}
