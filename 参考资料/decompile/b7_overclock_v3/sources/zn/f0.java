package zn;

import gm.j2;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class f0 extends gm.w {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58721e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58722f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f58723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f58724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o0 f58725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f58726d;

    public f0(gm.f0 f0Var) {
        this.f58726d = 1;
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i10));
            int iQ = n0VarT.q();
            if (iQ == 0) {
                this.f58723a = h0.x(n0VarT, false);
            } else if (iQ == 1) {
                this.f58724b = c0.z(n0VarT, false);
            } else {
                if (iQ != 2) {
                    throw new IllegalArgumentException("unknown tag in Holder");
                }
                this.f58725c = o0.z(n0VarT, false);
            }
        }
        this.f58726d = 1;
    }

    public f0(gm.n0 n0Var) {
        this.f58726d = 1;
        int iQ = n0Var.q();
        if (iQ == 0) {
            this.f58723a = h0.x(n0Var, true);
        } else {
            if (iQ != 1) {
                throw new IllegalArgumentException("unknown tag in Holder");
            }
            this.f58724b = c0.z(n0Var, true);
        }
        this.f58726d = 0;
    }

    public f0(c0 c0Var) {
        this(c0Var, 1);
    }

    public f0(c0 c0Var, int i10) {
        this.f58724b = c0Var;
        this.f58726d = i10;
    }

    public f0(h0 h0Var) {
        this(h0Var, 1);
    }

    public f0(h0 h0Var, int i10) {
        this.f58723a = h0Var;
        this.f58726d = i10;
    }

    public f0(o0 o0Var) {
        this.f58726d = 1;
        this.f58725c = o0Var;
    }

    public static f0 z(Object obj) {
        if (obj instanceof f0) {
            return (f0) obj;
        }
        if (obj instanceof gm.n0) {
            return new f0(gm.n0.T(obj));
        }
        if (obj != null) {
            return new f0(gm.f0.J(obj));
        }
        return null;
    }

    public o0 A() {
        return this.f58725c;
    }

    public int B() {
        return this.f58726d;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        if (this.f58726d != 1) {
            c0 c0Var = this.f58724b;
            return c0Var != null ? new n2(true, 1, (gm.h) c0Var) : new n2(true, 0, (gm.h) this.f58723a);
        }
        gm.i iVar = new gm.i(3);
        h0 h0Var = this.f58723a;
        if (h0Var != null) {
            iVar.a(new n2(false, 0, (gm.h) h0Var));
        }
        c0 c0Var2 = this.f58724b;
        if (c0Var2 != null) {
            iVar.a(new n2(false, 1, (gm.h) c0Var2));
        }
        o0 o0Var = this.f58725c;
        if (o0Var != null) {
            iVar.a(new n2(false, 2, (gm.h) o0Var));
        }
        return new j2(iVar);
    }

    public h0 x() {
        return this.f58723a;
    }

    public c0 y() {
        return this.f58724b;
    }
}
