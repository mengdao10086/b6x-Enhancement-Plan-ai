package xr;

/* JADX INFO: loaded from: classes6.dex */
public class a extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.z f55793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m1 f55794b;

    /* JADX INFO: renamed from: xr.a$a, reason: collision with other inner class name */
    public static class C0659a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.z f55795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m1 f55796b;

        public a a() {
            return new a(this.f55795a, this.f55796b);
        }

        public C0659a b(gm.z zVar) {
            this.f55795a = zVar;
            return this;
        }

        public C0659a c(m1 m1Var) {
            this.f55796b = m1Var;
            return this;
        }
    }

    public a(gm.z zVar, m1 m1Var) {
        this.f55793a = zVar;
        this.f55794b = m1Var;
    }

    public static a x(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new C0659a().b(gm.z.I(f0VarJ.K(0))).c(m1.x(f0VarJ.K(1))).a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55793a, this.f55794b);
    }
}
