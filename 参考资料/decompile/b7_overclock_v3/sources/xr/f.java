package xr;

/* JADX INFO: loaded from: classes6.dex */
public class f extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f55892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f55893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n0 f55894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d2 f55895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t1 f55896e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.t f55897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h f55898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public n0 f55899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d2 f55900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t1 f55901e;

        public f a() {
            return new f(this.f55897a, this.f55898b, this.f55899c, this.f55900d, this.f55901e);
        }

        public a b(n0 n0Var) {
            this.f55899c = n0Var;
            return this;
        }

        public a c(t1 t1Var) {
            this.f55901e = t1Var;
            return this;
        }

        public a d(d2 d2Var) {
            this.f55900d = d2Var;
            return this;
        }

        public a e(h hVar) {
            this.f55898b = hVar;
            return this;
        }

        public a f(gm.t tVar) {
            this.f55897a = tVar;
            return this;
        }
    }

    public f(gm.t tVar, h hVar, n0 n0Var, d2 d2Var, t1 t1Var) {
        this.f55892a = tVar;
        this.f55893b = hVar;
        this.f55894c = n0Var;
        this.f55895d = d2Var;
        this.f55896e = t1Var;
    }

    public static a x() {
        return new a();
    }

    public static f y(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        gm.t tVarI = gm.t.I(f0VarJ.K(0));
        h hVarN = h.N(f0VarJ.K(1));
        n0 n0VarZ = n0.z(f0VarJ.K(2));
        d2 d2VarT = d2.T(f0VarJ.K(3));
        return new a().f(tVarI).e(hVarN).b(n0VarZ).d(d2VarT).c((t1) org.bouncycastle.oer.d.B(t1.class, f0VarJ.K(4))).a();
    }

    public t1 A() {
        return this.f55896e;
    }

    public d2 B() {
        return this.f55895d;
    }

    public h C() {
        return this.f55893b;
    }

    public gm.t D() {
        return this.f55892a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55892a, this.f55893b, this.f55894c, this.f55895d, org.bouncycastle.oer.d.z(this.f55896e));
    }

    public n0 z() {
        return this.f55894c;
    }
}
