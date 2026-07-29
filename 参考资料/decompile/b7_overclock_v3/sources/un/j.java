package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.o;
import gm.t;
import gm.w;
import gm.y;
import java.util.Enumeration;
import zn.b0;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f52309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f52310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f52311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public t f52312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f52313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f52314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.f f52315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public t f52316h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b0 f52317i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z f52318j;

    public j(f0 f0Var) {
        w wVar;
        Enumeration enumerationL = f0Var.L();
        this.f52309a = t.I(enumerationL.nextElement());
        this.f52310b = y.N(enumerationL.nextElement());
        this.f52311c = h.z(enumerationL.nextElement());
        this.f52312d = t.I(enumerationL.nextElement());
        this.f52313e = o.M(enumerationL.nextElement());
        gm.f fVarK = gm.f.K(false);
        while (true) {
            this.f52315g = fVarK;
            while (enumerationL.hasMoreElements()) {
                wVar = (w) enumerationL.nextElement();
                if (wVar instanceof n0) {
                    n0 n0Var = (n0) wVar;
                    int iQ = n0Var.q();
                    if (iQ == 0) {
                        this.f52317i = b0.y(n0Var, true);
                    } else {
                        if (iQ != 1) {
                            throw new IllegalArgumentException("Unknown tag value " + n0Var.q());
                        }
                        this.f52318j = z.F(n0Var, false);
                    }
                } else if ((wVar instanceof f0) || (wVar instanceof a)) {
                    this.f52314f = a.x(wVar);
                } else if (wVar instanceof gm.f) {
                    break;
                } else if (wVar instanceof t) {
                    this.f52316h = t.I(wVar);
                }
            }
            return;
            fVarK = gm.f.J(wVar);
        }
    }

    public j(y yVar, h hVar, t tVar, o oVar, a aVar, gm.f fVar, t tVar2, b0 b0Var, z zVar) {
        this.f52309a = new t(1L);
        this.f52310b = yVar;
        this.f52311c = hVar;
        this.f52312d = tVar;
        this.f52313e = oVar;
        this.f52314f = aVar;
        this.f52315g = fVar;
        this.f52316h = tVar2;
        this.f52317i = b0Var;
        this.f52318j = zVar;
    }

    public static j A(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    public h B() {
        return this.f52311c;
    }

    public t C() {
        return this.f52316h;
    }

    public gm.f D() {
        return this.f52315g;
    }

    public y E() {
        return this.f52310b;
    }

    public t F() {
        return this.f52312d;
    }

    public b0 G() {
        return this.f52317i;
    }

    public t H() {
        return this.f52309a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(10);
        iVar.a(this.f52309a);
        iVar.a(this.f52310b);
        iVar.a(this.f52311c);
        iVar.a(this.f52312d);
        iVar.a(this.f52313e);
        a aVar = this.f52314f;
        if (aVar != null) {
            iVar.a(aVar);
        }
        gm.f fVar = this.f52315g;
        if (fVar != null && fVar.L()) {
            iVar.a(this.f52315g);
        }
        t tVar = this.f52316h;
        if (tVar != null) {
            iVar.a(tVar);
        }
        b0 b0Var = this.f52317i;
        if (b0Var != null) {
            iVar.a(new n2(true, 0, (gm.h) b0Var));
        }
        z zVar = this.f52318j;
        if (zVar != null) {
            iVar.a(new n2(false, 1, (gm.h) zVar));
        }
        return new j2(iVar);
    }

    public a x() {
        return this.f52314f;
    }

    public z y() {
        return this.f52318j;
    }

    public o z() {
        return this.f52313e;
    }
}
