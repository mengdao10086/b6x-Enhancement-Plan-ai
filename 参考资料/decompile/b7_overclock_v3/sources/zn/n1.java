package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class n1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f58863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f58864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o0 f58865c;

    public n1(gm.f0 f0Var) {
        int i10;
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        if (f0Var.K(0) instanceof gm.n0) {
            i10 = 0;
        } else {
            this.f58863a = c0.A(f0Var.K(0));
            i10 = 1;
        }
        while (i10 != f0Var.size()) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            if (n0VarT.q() == 0) {
                this.f58864b = h0.x(n0VarT, false);
            } else {
                if (n0VarT.q() != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + n0VarT.q());
                }
                this.f58865c = o0.z(n0VarT, false);
            }
            i10++;
        }
    }

    public n1(c0 c0Var) {
        this(c0Var, null, null);
    }

    public n1(c0 c0Var, h0 h0Var) {
        this(c0Var, h0Var, null);
    }

    public n1(c0 c0Var, h0 h0Var, o0 o0Var) {
        this.f58863a = c0Var;
        this.f58864b = h0Var;
        this.f58865c = o0Var;
    }

    public n1(c0 c0Var, o0 o0Var) {
        this(c0Var, null, o0Var);
    }

    public static n1 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static n1 z(Object obj) {
        if (obj instanceof n1) {
            return (n1) obj;
        }
        if (obj != null) {
            return new n1(gm.f0.J(obj));
        }
        return null;
    }

    public c0 A() {
        return this.f58863a;
    }

    public o0 B() {
        return this.f58865c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        c0 c0Var = this.f58863a;
        if (c0Var != null) {
            iVar.a(c0Var);
        }
        h0 h0Var = this.f58864b;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        o0 o0Var = this.f58865c;
        if (o0Var != null) {
            iVar.a(new n2(false, 1, (gm.h) o0Var));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f58864b;
    }
}
