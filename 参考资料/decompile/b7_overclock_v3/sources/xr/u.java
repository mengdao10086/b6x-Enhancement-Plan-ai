package xr;

/* JADX INFO: loaded from: classes6.dex */
public class u extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f56050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c2 f56051b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q1 f56052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c2 f56053b;

        public u a() {
            return new u(this.f56052a, this.f56053b);
        }

        public a b(c2 c2Var) {
            this.f56053b = c2Var;
            return this;
        }

        public a c(q1 q1Var) {
            this.f56052a = q1Var;
            return this;
        }
    }

    public u(q1 q1Var, c2 c2Var) {
        this.f56050a = q1Var;
        this.f56051b = c2Var;
    }

    public static u y(Object obj) {
        if (obj == null || (obj instanceof u)) {
            return (u) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new u(q1.x(f0VarJ.K(0)), c2.y(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56050a, this.f56051b);
    }

    public c2 x() {
        return this.f56051b;
    }

    public q1 z() {
        return this.f56050a;
    }
}
