package xr;

/* JADX INFO: loaded from: classes6.dex */
public class i extends gm.w implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2 f55922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2 f55923b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f2 f55924a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g2 f55925b;

        public i a() {
            return new i(this.f55924a, this.f55925b);
        }

        public a b(f2 f2Var) {
            this.f55924a = f2Var;
            return this;
        }

        public a c(g2 g2Var) {
            this.f55925b = g2Var;
            return this;
        }
    }

    public i(f2 f2Var, g2 g2Var) {
        this.f55922a = f2Var;
        this.f55923b = g2Var;
    }

    public static i y(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new i(f2.x(f0VarJ.K(0)), g2.x(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55922a, this.f55923b);
    }

    public f2 x() {
        return this.f55922a;
    }

    public g2 z() {
        return this.f55923b;
    }
}
