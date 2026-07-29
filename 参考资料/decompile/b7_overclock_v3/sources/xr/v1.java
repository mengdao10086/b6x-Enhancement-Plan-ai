package xr;

/* JADX INFO: loaded from: classes6.dex */
public class v1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f56077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f56078b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public l0 f56079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public d0 f56080b;

        public v1 a() {
            return new v1(this.f56079a, this.f56080b);
        }

        public a b(l0 l0Var) {
            this.f56079a = l0Var;
            return this;
        }

        public a c(d0 d0Var) {
            this.f56080b = d0Var;
            return this;
        }
    }

    public v1(l0 l0Var, d0 d0Var) {
        this.f56077a = l0Var;
        this.f56078b = d0Var;
    }

    public static v1 A(Object obj) {
        if (obj instanceof v1) {
            return (v1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new v1(l0.z(f0VarJ.K(0)), d0.y(f0VarJ.K(1)));
    }

    public static a x() {
        return new a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.i());
    }

    public l0 y() {
        return this.f56077a;
    }

    public d0 z() {
        return this.f56078b;
    }
}
