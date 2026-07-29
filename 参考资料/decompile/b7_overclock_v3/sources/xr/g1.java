package xr;

/* JADX INFO: loaded from: classes6.dex */
public class g1 extends gm.w implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f2 f55915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f2 f55916b;

    public g1(f2 f2Var, f2 f2Var2) {
        this.f55915a = f2Var;
        this.f55916b = f2Var2;
    }

    public static g1 x(Object obj) {
        if (obj instanceof g1) {
            return (g1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new g1(f2.x(f0VarJ.K(0)), f2.x(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.h[]{this.f55915a, this.f55916b});
    }

    public f2 y() {
        return this.f55915a;
    }

    public f2 z() {
        return this.f55916b;
    }
}
