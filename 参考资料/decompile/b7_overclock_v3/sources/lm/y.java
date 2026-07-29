package lm;

import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w f40026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f40027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.d f40028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.f0 f40029d;

    public y(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f40026a = w.A(enumerationL.nextElement());
        this.f40027b = s.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            if (n0Var.q() == 0) {
                this.f40028c = u1.R(n0Var, true);
            } else {
                this.f40029d = gm.f0.I(n0Var, true);
            }
        }
    }

    public y(w wVar, s sVar) {
        this(wVar, sVar, null, null);
    }

    public y(w wVar, s sVar, gm.d dVar) {
        this(wVar, sVar, dVar, null);
    }

    public y(w wVar, s sVar, gm.d dVar, b[] bVarArr) {
        this.f40026a = wVar;
        this.f40027b = sVar;
        this.f40028c = dVar;
        if (bVarArr != null) {
            this.f40029d = new j2(bVarArr);
        }
    }

    public static y B(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj != null) {
            return new y(gm.f0.J(obj));
        }
        return null;
    }

    public w A() {
        return this.f40026a;
    }

    public gm.d C() {
        return this.f40028c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f40026a);
        iVar.a(this.f40027b);
        x(iVar, 0, this.f40028c);
        x(iVar, 1, this.f40029d);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, int i10, gm.h hVar) {
        if (hVar != null) {
            iVar.a(new n2(true, i10, hVar));
        }
    }

    public s y() {
        return this.f40027b;
    }

    public b[] z() {
        gm.f0 f0Var = this.f40029d;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        b[] bVarArr = new b[size];
        for (int i10 = 0; i10 < size; i10++) {
            bVarArr[i10] = b.x(this.f40029d.K(i10));
        }
        return bVarArr;
    }
}
