package xr;

/* JADX INFO: loaded from: classes6.dex */
public class b1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z0 f55822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s1 f55823b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z0 f55824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public s1 f55825b;

        public b1 a() {
            return new b1(this.f55824a, this.f55825b);
        }

        public a b(z0 z0Var) {
            this.f55824a = z0Var;
            return this;
        }

        public a c(s1 s1Var) {
            this.f55825b = s1Var;
            return this;
        }
    }

    public b1(z0 z0Var, s1 s1Var) {
        this.f55822a = z0Var;
        this.f55823b = s1Var;
    }

    public static a x() {
        return new a();
    }

    public static b1 y(Object obj) {
        if (obj instanceof b1) {
            return (b1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new b1(z0.V(f0VarJ.K(0)), (s1) org.bouncycastle.oer.d.B(s1.class, f0VarJ.K(1)));
    }

    public s1 A() {
        return this.f55823b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55822a, org.bouncycastle.oer.d.z(this.f55823b));
    }

    public z0 z() {
        return this.f55822a;
    }
}
