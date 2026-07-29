package xr;

/* JADX INFO: loaded from: classes6.dex */
public class e2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v1 f55888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f55889b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public v1 f55890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f0 f55891b;

        public e2 a() {
            return new e2(this.f55890a, this.f55891b);
        }

        public a b(f0 f0Var) {
            this.f55891b = f0Var;
            return this;
        }

        public a c(v1 v1Var) {
            this.f55890a = v1Var;
            return this;
        }
    }

    public e2(v1 v1Var, f0 f0Var) {
        this.f55888a = v1Var;
        this.f55889b = f0Var;
    }

    public static e2 y(Object obj) {
        if (obj instanceof e2) {
            return (e2) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new a().c(v1.A(f0VarJ.K(0))).b(f0.x(f0VarJ.K(1))).a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.h[]{this.f55888a, this.f55889b});
    }

    public f0 x() {
        return this.f55889b;
    }

    public v1 z() {
        return this.f55888a;
    }
}
