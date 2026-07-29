package en;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import java.util.Enumeration;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f27040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f27041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f27042c;

    public c(f0 f0Var) {
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        gm.h hVar = (gm.h) enumerationL.nextElement();
        if (hVar instanceof n0) {
            n0 n0Var = (n0) hVar;
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f27040a = b0.y(n0Var, true);
            } else {
                if (iQ != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + n0Var.q());
                }
                this.f27041b = f.x(n0Var, true);
            }
            hVar = (gm.h) enumerationL.nextElement();
        }
        if (hVar instanceof n0) {
            n0 n0Var2 = (n0) hVar;
            if (n0Var2.q() != 1) {
                throw new IllegalArgumentException("Bad tag number: " + n0Var2.q());
            }
            this.f27041b = f.x(n0Var2, true);
            hVar = (gm.h) enumerationL.nextElement();
        }
        this.f27042c = f0.J(hVar);
        if (enumerationL.hasMoreElements()) {
            throw new IllegalArgumentException("Bad object encountered: " + enumerationL.nextElement().getClass());
        }
    }

    public c(b0 b0Var, f fVar, h[] hVarArr) {
        this.f27040a = b0Var;
        this.f27041b = fVar;
        this.f27042c = new j2(hVarArr);
    }

    public static c y(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof f0) {
            return new c((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public h[] A() {
        h[] hVarArr = new h[this.f27042c.size()];
        Enumeration enumerationL = this.f27042c.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            hVarArr[i10] = h.y(enumerationL.nextElement());
            i10++;
        }
        return hVarArr;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        b0 b0Var = this.f27040a;
        if (b0Var != null) {
            iVar.a(new n2(true, 0, (gm.h) b0Var));
        }
        f fVar = this.f27041b;
        if (fVar != null) {
            iVar.a(new n2(true, 1, (gm.h) fVar));
        }
        iVar.a(this.f27042c);
        return new j2(iVar);
    }

    public b0 x() {
        return this.f27040a;
    }

    public f z() {
        return this.f27041b;
    }
}
