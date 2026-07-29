package xr;

/* JADX INFO: loaded from: classes6.dex */
public class b0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.z f55820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.z f55821b;

    public b0(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("sequence not length 2");
        }
        this.f55820a = gm.z.I(f0Var.K(0));
        this.f55821b = gm.z.I(f0Var.K(1));
    }

    public static b0 x(Object obj) {
        if (obj instanceof b0) {
            return (b0) obj;
        }
        if (obj != null) {
            return new b0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55820a, this.f55821b);
    }

    public gm.z y() {
        return this.f55821b;
    }

    public gm.z z() {
        return this.f55820a;
    }
}
