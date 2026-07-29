package xr;

/* JADX INFO: loaded from: classes6.dex */
public class f2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o0 f55902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f55903b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public o0 f55904a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r0 f55905b;

        public f2 a() {
            return new f2(this.f55904a, this.f55905b);
        }

        public a b(o0 o0Var) {
            this.f55904a = o0Var;
            return this;
        }

        public a c(r0 r0Var) {
            this.f55905b = r0Var;
            return this;
        }
    }

    public f2(o0 o0Var, r0 r0Var) {
        this.f55902a = o0Var;
        this.f55903b = r0Var;
    }

    public static f2 x(Object obj) {
        if (obj instanceof f2) {
            return (f2) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new f2(o0.X(f0VarJ.K(0)), r0.X(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.h[]{this.f55902a, this.f55903b});
    }

    public o0 y() {
        return this.f55902a;
    }

    public r0 z() {
        return this.f55903b;
    }
}
