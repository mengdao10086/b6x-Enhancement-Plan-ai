package zn;

/* JADX INFO: loaded from: classes5.dex */
public class r1 extends gm.w implements z1, pn.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f1 f58935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f58936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.d f58937d;

    public r1(gm.f0 f0Var) {
        this.f58934a = f0Var;
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f58935b = f1.A(f0Var.K(0));
        this.f58936c = b.z(f0Var.K(1));
        this.f58937d = gm.u1.S(f0Var.K(2));
    }

    public static r1 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static r1 z(Object obj) {
        if (obj instanceof r1) {
            return (r1) obj;
        }
        if (obj != null) {
            return new r1(gm.f0.J(obj));
        }
        return null;
    }

    public xn.d A() {
        return this.f58935b.B();
    }

    public gm.t B() {
        return this.f58935b.D();
    }

    public gm.d C() {
        return this.f58937d;
    }

    public b D() {
        return this.f58936c;
    }

    public j1 E() {
        return this.f58935b.F();
    }

    public xn.d F() {
        return this.f58935b.G();
    }

    public c1 G() {
        return this.f58935b.H();
    }

    public f1 H() {
        return this.f58935b;
    }

    public int I() {
        return this.f58935b.J();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58934a;
    }

    public j1 x() {
        return this.f58935b.x();
    }
}
