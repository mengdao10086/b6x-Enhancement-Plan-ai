package mm;

import gm.i1;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g0 f41401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.h0 f41402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f41403d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.h0 f41404e;

    public t(gm.f0 f0Var) {
        this.f41400a = (gm.t) f0Var.K(0);
        gm.h hVarK = f0Var.K(1);
        int i10 = 2;
        if (hVarK instanceof gm.n0) {
            this.f41401b = g0.z((gm.n0) hVarK, false);
            hVarK = f0Var.K(2);
            i10 = 3;
        }
        this.f41402c = gm.h0.I(hVarK);
        int i11 = i10 + 1;
        this.f41403d = q.A(f0Var.K(i10));
        if (f0Var.size() > i11) {
            this.f41404e = gm.h0.H((gm.n0) f0Var.K(i11), false);
        }
    }

    public t(g0 g0Var, gm.h0 h0Var, q qVar, gm.h0 h0Var2) {
        this.f41400a = new gm.t(x(g0Var, h0Var, h0Var2));
        this.f41401b = g0Var;
        this.f41402c = h0Var;
        this.f41403d = qVar;
        this.f41404e = h0Var2;
    }

    public t(g0 g0Var, gm.h0 h0Var, q qVar, c cVar) {
        this.f41400a = new gm.t(x(g0Var, h0Var, gm.h0.I(cVar)));
        this.f41401b = g0Var;
        this.f41402c = h0Var;
        this.f41403d = qVar;
        this.f41404e = gm.h0.I(cVar);
    }

    public static t A(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(gm.f0.J(obj));
        }
        return null;
    }

    public static int x(g0 g0Var, gm.h0 h0Var, gm.h0 h0Var2) {
        if (g0Var != null || h0Var2 != null) {
            return 2;
        }
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            if (!o0.y(enumerationK.nextElement()).A().L(0)) {
                return 2;
            }
        }
        return 0;
    }

    public static t z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public g0 B() {
        return this.f41401b;
    }

    public gm.h0 C() {
        return this.f41402c;
    }

    public gm.h0 D() {
        return this.f41404e;
    }

    public gm.t E() {
        return this.f41400a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f41400a);
        g0 g0Var = this.f41401b;
        if (g0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) g0Var));
        }
        iVar.a(this.f41402c);
        iVar.a(this.f41403d);
        gm.h0 h0Var = this.f41404e;
        if (h0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) h0Var));
        }
        return new i1(iVar);
    }

    public q y() {
        return this.f41403d;
    }
}
