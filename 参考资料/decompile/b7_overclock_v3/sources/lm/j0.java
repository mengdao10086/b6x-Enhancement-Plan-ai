package lm;

import gm.j2;
import gm.n0;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f39916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f0 f39917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.f0 f39918c;

    public j0(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f39916a = gm.f0.J(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0VarT = n0.T(enumerationL.nextElement());
            int iQ = n0VarT.q();
            gm.f0 f0VarI = gm.f0.I(n0VarT, true);
            if (iQ == 0) {
                this.f39917b = f0VarI;
            } else {
                this.f39918c = f0VarI;
            }
        }
    }

    public static j0 z(Object obj) {
        if (obj instanceof j0) {
            return (j0) obj;
        }
        if (obj != null) {
            return new j0(gm.f0.J(obj));
        }
        return null;
    }

    public om.c[] A() {
        gm.f0 f0Var = this.f39917b;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        om.c[] cVarArr = new om.c[size];
        for (int i10 = 0; i10 != size; i10++) {
            cVarArr[i10] = om.c.y(this.f39917b.K(i10));
        }
        return cVarArr;
    }

    public b0[] B() {
        int size = this.f39916a.size();
        b0[] b0VarArr = new b0[size];
        for (int i10 = 0; i10 != size; i10++) {
            b0VarArr[i10] = b0.z(this.f39916a.K(i10));
        }
        return b0VarArr;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39916a);
        x(iVar, 0, this.f39917b);
        x(iVar, 1, this.f39918c);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public zn.p[] y() {
        gm.f0 f0Var = this.f39918c;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        zn.p[] pVarArr = new zn.p[size];
        for (int i10 = 0; i10 != size; i10++) {
            pVarArr[i10] = zn.p.y(this.f39918c.K(i10));
        }
        return pVarArr;
    }
}
