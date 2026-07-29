package zn;

/* JADX INFO: loaded from: classes5.dex */
public class f1 extends gm.w implements z1, pn.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f58728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.t f58729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f58730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public xn.d f58731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j1 f58732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j1 f58733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public xn.d f58734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c1 f58735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public gm.d f58736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public gm.d f58737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public u1 f58738l;

    public f1(gm.f0 f0Var) {
        int i10;
        this.f58727a = f0Var;
        if (f0Var.K(0) instanceof gm.n0) {
            this.f58728b = gm.t.H((gm.n0) f0Var.K(0), true);
            i10 = 0;
        } else {
            this.f58728b = new gm.t(0L);
            i10 = -1;
        }
        this.f58729c = gm.t.I(f0Var.K(i10 + 1));
        this.f58730d = b.z(f0Var.K(i10 + 2));
        this.f58731e = xn.d.A(f0Var.K(i10 + 3));
        gm.f0 f0Var2 = (gm.f0) f0Var.K(i10 + 4);
        this.f58732f = j1.z(f0Var2.K(0));
        this.f58733g = j1.z(f0Var2.K(1));
        this.f58734h = xn.d.A(f0Var.K(i10 + 5));
        int i11 = i10 + 6;
        this.f58735i = c1.A(f0Var.K(i11));
        for (int size = (f0Var.size() - i11) - 1; size > 0; size--) {
            gm.n0 n0VarT = gm.n0.T(f0Var.K(i11 + size));
            int iQ = n0VarT.q();
            if (iQ == 1) {
                this.f58736j = gm.d.J(n0VarT, false);
            } else if (iQ == 2) {
                this.f58737k = gm.d.J(n0VarT, false);
            } else if (iQ == 3) {
                this.f58738l = u1.D(n0VarT);
            }
        }
    }

    public static f1 A(Object obj) {
        if (obj instanceof f1) {
            return (f1) obj;
        }
        if (obj != null) {
            return new f1(gm.f0.J(obj));
        }
        return null;
    }

    public static f1 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public xn.d B() {
        return this.f58731e;
    }

    public gm.d C() {
        return this.f58736j;
    }

    public gm.t D() {
        return this.f58729c;
    }

    public b E() {
        return this.f58730d;
    }

    public j1 F() {
        return this.f58732f;
    }

    public xn.d G() {
        return this.f58734h;
    }

    public c1 H() {
        return this.f58735i;
    }

    public gm.d I() {
        return this.f58737k;
    }

    public int J() {
        return this.f58728b.Q() + 1;
    }

    public gm.t K() {
        return this.f58728b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58727a;
    }

    public j1 x() {
        return this.f58733g;
    }

    public u1 y() {
        return this.f58738l;
    }
}
