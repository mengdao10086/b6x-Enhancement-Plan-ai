package xr;

/* JADX INFO: loaded from: classes6.dex */
public class p0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f55996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f55997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f55998c;

    public p0(gm.f0 f0Var) {
        if (f0Var.size() != 2 && f0Var.size() != 3) {
            throw new IllegalArgumentException("sequence must be size 2 or 3");
        }
        this.f55996a = i0.x(f0Var.K(2));
        this.f55997b = q0.N(f0Var.K(2));
        this.f55998c = b0.x(f0Var.K(2));
    }

    public static p0 x(Object obj) {
        if (obj instanceof p0) {
            return (p0) obj;
        }
        if (obj != null) {
            return new p0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.i());
    }
}
