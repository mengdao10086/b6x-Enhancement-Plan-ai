package lm;

import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f39933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f39934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.f0 f39935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.f0 f39936d;

    public p(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f39933a = b0.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0VarT = n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f39934b = b.x(n0VarT.U());
            } else if (iQ == 1) {
                this.f39935c = gm.f0.J(n0VarT.U());
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("unknown tag number: " + n0VarT.q());
                }
                this.f39936d = gm.f0.J(n0VarT.U());
            }
        }
    }

    public static p z(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(gm.f0.J(obj));
        }
        return null;
    }

    public j[] A() {
        gm.f0 f0Var = this.f39936d;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        j[] jVarArr = new j[size];
        for (int i10 = 0; i10 != size; i10++) {
            jVarArr[i10] = j.y(this.f39936d.K(i10));
        }
        return jVarArr;
    }

    public b B() {
        return this.f39934b;
    }

    public b0 C() {
        return this.f39933a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f39933a);
        x(iVar, 0, this.f39934b);
        x(iVar, 1, this.f39935c);
        x(iVar, 2, this.f39936d);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public b[] y() {
        gm.f0 f0Var = this.f39935c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        b[] bVarArr = new b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = b.x(this.f39935c.K(i10));
        }
        return bVarArr;
    }
}
