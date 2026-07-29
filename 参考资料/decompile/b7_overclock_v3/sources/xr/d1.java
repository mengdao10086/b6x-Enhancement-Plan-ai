package xr;

/* JADX INFO: loaded from: classes6.dex */
public class d1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a2 f55851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f55852b;

    public d1(a2 a2Var, b bVar) {
        this.f55851a = a2Var;
        this.f55852b = bVar;
    }

    public static d1 y(Object obj) {
        if (obj instanceof d1) {
            return (d1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new d1(a2.N(f0VarJ.K(0)), b.y(f0VarJ.K(1)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55851a, this.f55852b);
    }

    public b x() {
        return this.f55852b;
    }

    public a2 z() {
        return this.f55851a;
    }
}
