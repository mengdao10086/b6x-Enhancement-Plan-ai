package mm;

import gm.i1;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f41312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h0 f41313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f41314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f41315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f41316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public gm.h0 f41317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public gm.z f41318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public gm.h0 f41319i;

    public f(gm.f0 f0Var) {
        this.f41311a = (gm.t) f0Var.K(0);
        gm.h hVarK = f0Var.K(1);
        int i10 = 2;
        if (hVarK instanceof gm.n0) {
            this.f41312b = g0.z((gm.n0) hVarK, false);
            hVarK = f0Var.K(2);
            i10 = 3;
        }
        this.f41313c = gm.h0.I(hVarK);
        int i11 = i10 + 1;
        this.f41314d = zn.b.z(f0Var.K(i10));
        int i12 = i11 + 1;
        gm.h hVarK2 = f0Var.K(i11);
        if (hVarK2 instanceof gm.n0) {
            this.f41315e = zn.b.y((gm.n0) hVarK2, false);
            int i13 = i12 + 1;
            gm.h hVarK3 = f0Var.K(i12);
            i12 = i13;
            hVarK2 = hVarK3;
        }
        this.f41316f = n.A(hVarK2);
        int i14 = i12 + 1;
        gm.h hVarK4 = f0Var.K(i12);
        if (hVarK4 instanceof gm.n0) {
            this.f41317g = gm.h0.H((gm.n0) hVarK4, false);
            hVarK4 = f0Var.K(i14);
            i14++;
        }
        this.f41318h = gm.z.I(hVarK4);
        if (f0Var.size() > i14) {
            this.f41319i = gm.h0.H((gm.n0) f0Var.K(i14), false);
        }
    }

    public f(g0 g0Var, gm.h0 h0Var, zn.b bVar, zn.b bVar2, n nVar, gm.h0 h0Var2, gm.z zVar, gm.h0 h0Var3) {
        if (!(bVar2 == null && h0Var2 == null) && (bVar2 == null || h0Var2 == null)) {
            throw new IllegalArgumentException("digestAlgorithm and authAttrs must be set together");
        }
        this.f41311a = new gm.t(x(g0Var));
        this.f41312b = g0Var;
        this.f41314d = bVar;
        this.f41315e = bVar2;
        this.f41313c = h0Var;
        this.f41316f = nVar;
        this.f41317g = h0Var2;
        this.f41318h = zVar;
        this.f41319i = h0Var3;
    }

    public static f B(gm.n0 n0Var, boolean z10) {
        return C(gm.f0.I(n0Var, z10));
    }

    public static f C(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(gm.f0.J(obj));
        }
        return null;
    }

    public static int x(g0 g0Var) {
        int i10 = 0;
        if (g0Var == null) {
            return 0;
        }
        Enumeration enumerationK = g0Var.y().K();
        while (true) {
            if (!enumerationK.hasMoreElements()) {
                break;
            }
            Object objNextElement = enumerationK.nextElement();
            if (objNextElement instanceof gm.n0) {
                gm.n0 n0Var = (gm.n0) objNextElement;
                if (n0Var.q() == 2) {
                    i10 = 1;
                } else if (n0Var.q() == 3) {
                    i10 = 3;
                    break;
                }
            }
        }
        if (g0Var.x() != null) {
            Enumeration enumerationK2 = g0Var.x().K();
            while (enumerationK2.hasMoreElements()) {
                Object objNextElement2 = enumerationK2.nextElement();
                if ((objNextElement2 instanceof gm.n0) && ((gm.n0) objNextElement2).q() == 1) {
                    return 3;
                }
            }
        }
        return i10;
    }

    public n A() {
        return this.f41316f;
    }

    public gm.z D() {
        return this.f41318h;
    }

    public zn.b E() {
        return this.f41314d;
    }

    public g0 F() {
        return this.f41312b;
    }

    public gm.h0 G() {
        return this.f41313c;
    }

    public gm.h0 H() {
        return this.f41319i;
    }

    public gm.t I() {
        return this.f41311a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(9);
        iVar.a(this.f41311a);
        g0 g0Var = this.f41312b;
        if (g0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) g0Var));
        }
        iVar.a(this.f41313c);
        iVar.a(this.f41314d);
        zn.b bVar = this.f41315e;
        if (bVar != null) {
            iVar.a(new n2(false, 1, (gm.h) bVar));
        }
        iVar.a(this.f41316f);
        gm.h0 h0Var = this.f41317g;
        if (h0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) h0Var));
        }
        iVar.a(this.f41318h);
        gm.h0 h0Var2 = this.f41319i;
        if (h0Var2 != null) {
            iVar.a(new n2(false, 3, (gm.h) h0Var2));
        }
        return new i1(iVar);
    }

    public gm.h0 y() {
        return this.f41317g;
    }

    public zn.b z() {
        return this.f41315e;
    }
}
