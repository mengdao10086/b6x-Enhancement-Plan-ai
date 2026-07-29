package zn;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e1 f58867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f58868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.d f58869d;

    public o(gm.f0 f0Var) {
        this.f58866a = f0Var;
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f58867b = e1.A(f0Var.K(0));
        this.f58868c = b.z(f0Var.K(1));
        this.f58869d = gm.d.K(f0Var.K(2));
    }

    public static o y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static o z(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(gm.f0.J(obj));
        }
        return null;
    }

    public xn.d A() {
        return this.f58867b.B();
    }

    public gm.t B() {
        return this.f58867b.D();
    }

    public gm.d C() {
        return this.f58869d;
    }

    public b D() {
        return this.f58868c;
    }

    public j1 E() {
        return this.f58867b.F();
    }

    public xn.d F() {
        return this.f58867b.G();
    }

    public c1 G() {
        return this.f58867b.H();
    }

    public e1 H() {
        return this.f58867b;
    }

    public gm.t I() {
        return this.f58867b.J();
    }

    public int J() {
        return this.f58867b.K();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58866a;
    }

    public j1 x() {
        return this.f58867b.x();
    }
}
