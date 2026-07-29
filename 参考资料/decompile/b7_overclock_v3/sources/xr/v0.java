package xr;

/* JADX INFO: loaded from: classes6.dex */
public class v0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f56073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f56074b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e0 f56075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public v f56076b;

        public v0 a() {
            return new v0(this.f56075a, this.f56076b);
        }

        public a b(v vVar) {
            this.f56076b = vVar;
            return this;
        }

        public a c(e0 e0Var) {
            this.f56075a = e0Var;
            return this;
        }
    }

    public v0(e0 e0Var, v vVar) {
        this.f56073a = e0Var;
        this.f56074b = vVar;
    }

    public static v0 y(Object obj) {
        if (obj instanceof v0) {
            return (v0) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new v0(e0.x(f0VarJ.K(0)), v.y(f0VarJ.K(0)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f56073a, this.f56074b);
    }

    public v x() {
        return this.f56074b;
    }

    public e0 z() {
        return this.f56073a;
    }
}
