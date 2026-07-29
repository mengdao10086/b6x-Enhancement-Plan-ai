package xr;

/* JADX INFO: loaded from: classes6.dex */
public class b2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e0 f55826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c2 f55827b;

    public b2(e0 e0Var, c2 c2Var) {
        this.f55826a = e0Var;
        this.f55827b = c2Var;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55826a, this.f55827b);
    }

    public c2 x() {
        return this.f55827b;
    }

    public e0 y() {
        return this.f55826a;
    }
}
