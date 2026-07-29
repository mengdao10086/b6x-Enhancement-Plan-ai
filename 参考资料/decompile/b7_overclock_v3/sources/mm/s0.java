package mm;

import gm.i1;
import gm.l1;
import gm.n1;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class s0 extends gm.w {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final gm.t f41388i = new gm.t(1);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final gm.t f41389j = new gm.t(3);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final gm.t f41390k = new gm.t(4);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final gm.t f41391l = new gm.t(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h0 f41393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f41394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.h0 f41395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gm.h0 f41396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.h0 f41397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f41398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f41399h;

    public s0(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f41392a = gm.t.I(enumerationL.nextElement());
        this.f41393b = (gm.h0) enumerationL.nextElement();
        this.f41394c = n.A(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            gm.c0 c0Var = (gm.c0) enumerationL.nextElement();
            if (c0Var instanceof gm.n0) {
                gm.n0 n0Var = (gm.n0) c0Var;
                int iQ = n0Var.q();
                if (iQ == 0) {
                    this.f41398g = n0Var instanceof n1;
                    this.f41395d = gm.h0.H(n0Var, false);
                } else {
                    if (iQ != 1) {
                        throw new IllegalArgumentException("unknown tag value " + n0Var.q());
                    }
                    this.f41399h = n0Var instanceof n1;
                    this.f41396e = gm.h0.H(n0Var, false);
                }
            } else {
                this.f41397f = (gm.h0) c0Var;
            }
        }
    }

    public s0(gm.h0 h0Var, n nVar, gm.h0 h0Var2, gm.h0 h0Var3, gm.h0 h0Var4) {
        this.f41392a = x(nVar.y(), h0Var2, h0Var3, h0Var4);
        this.f41393b = h0Var;
        this.f41394c = nVar;
        this.f41395d = h0Var2;
        this.f41396e = h0Var3;
        this.f41397f = h0Var4;
        this.f41399h = h0Var3 instanceof l1;
        this.f41398g = h0Var2 instanceof l1;
    }

    public static s0 D(Object obj) {
        if (obj instanceof s0) {
            return (s0) obj;
        }
        if (obj != null) {
            return new s0(gm.f0.J(obj));
        }
        return null;
    }

    public gm.h0 A() {
        return this.f41395d;
    }

    public gm.h0 B() {
        return this.f41393b;
    }

    public n C() {
        return this.f41394c;
    }

    public gm.h0 E() {
        return this.f41397f;
    }

    public gm.t F() {
        return this.f41392a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(this.f41392a);
        iVar.a(this.f41393b);
        iVar.a(this.f41394c);
        gm.h0 h0Var = this.f41395d;
        if (h0Var != null) {
            iVar.a(this.f41398g ? new n1(false, 0, (gm.h) h0Var) : new n2(false, 0, (gm.h) h0Var));
        }
        gm.h0 h0Var2 = this.f41396e;
        if (h0Var2 != null) {
            iVar.a(this.f41399h ? new n1(false, 1, (gm.h) h0Var2) : new n2(false, 1, (gm.h) h0Var2));
        }
        iVar.a(this.f41397f);
        return new i1(iVar);
    }

    public final gm.t x(gm.y yVar, gm.h0 h0Var, gm.h0 h0Var2, gm.h0 h0Var3) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (h0Var != null) {
            Enumeration enumerationK = h0Var.K();
            z10 = false;
            z11 = false;
            z12 = false;
            while (enumerationK.hasMoreElements()) {
                Object objNextElement = enumerationK.nextElement();
                if (objNextElement instanceof gm.n0) {
                    gm.n0 n0VarT = gm.n0.T(objNextElement);
                    if (n0VarT.q() == 1) {
                        z11 = true;
                    } else if (n0VarT.q() == 2) {
                        z12 = true;
                    } else if (n0VarT.q() == 3) {
                        z10 = true;
                    }
                }
            }
        } else {
            z10 = false;
            z11 = false;
            z12 = false;
        }
        if (z10) {
            return new gm.t(5L);
        }
        if (h0Var2 != null) {
            Enumeration enumerationK2 = h0Var2.K();
            while (enumerationK2.hasMoreElements()) {
                if (enumerationK2.nextElement() instanceof gm.n0) {
                    z13 = true;
                }
            }
        }
        if (z13) {
            return f41391l;
        }
        if (z12) {
            return f41390k;
        }
        if (!z11 && !y(h0Var3) && k.I2.C(yVar)) {
            return f41388i;
        }
        return f41389j;
    }

    public final boolean y(gm.h0 h0Var) {
        Enumeration enumerationK = h0Var.K();
        while (enumerationK.hasMoreElements()) {
            if (v0.B(enumerationK.nextElement()).E().L(3)) {
                return true;
            }
        }
        return false;
    }

    public gm.h0 z() {
        return this.f41396e;
    }
}
