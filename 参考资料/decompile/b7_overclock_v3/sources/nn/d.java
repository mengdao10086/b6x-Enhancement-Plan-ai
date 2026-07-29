package nn;

import gm.c0;
import gm.c2;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.r;
import gm.t;
import gm.w;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f42253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t f42254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.o f42255c;

    public d(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            n0 n0Var = (n0) enumerationL.nextElement();
            int iQ = n0Var.q();
            if (iQ == 0) {
                this.f42253a = r.H(n0Var, true);
            } else if (iQ == 1) {
                this.f42254b = t.H(n0Var, true);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("unknown tag number: " + n0Var.q());
                }
                this.f42255c = gm.o.L(n0Var, true);
            }
        }
    }

    public static d B(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public r A() {
        return this.f42253a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        r rVar = this.f42253a;
        if (rVar != null) {
            iVar.a(new n2(true, 0, (gm.h) rVar));
        }
        t tVar = this.f42254b;
        if (tVar != null) {
            iVar.a(new n2(true, 1, (gm.h) tVar));
        }
        gm.o oVar = this.f42255c;
        if (oVar != null) {
            iVar.a(new n2(true, 2, (gm.h) oVar));
        }
        return new j2(iVar);
    }

    public t x() {
        return this.f42254b;
    }

    public gm.o y() {
        return this.f42255c;
    }

    public c2 z() {
        r rVar = this.f42253a;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f42253a.d(), false);
    }
}
