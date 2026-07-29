package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.y f37495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.h0 f37496c;

    public g0(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37494a = a.z(f0Var.K(0));
        this.f37495b = gm.y.N(f0Var.K(1));
        this.f37496c = gm.h0.I(f0Var.K(2));
    }

    public g0(a aVar, gm.y yVar, gm.h0 h0Var) {
        this.f37494a = aVar;
        this.f37495b = yVar;
        this.f37496c = h0Var;
    }

    public static g0 A(Object obj) {
        if (obj instanceof g0) {
            return (g0) obj;
        }
        if (obj != null) {
            return new g0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(new gm.h[]{this.f37494a, this.f37495b, this.f37496c});
    }

    public gm.y x() {
        return this.f37495b;
    }

    public gm.h0 y() {
        return this.f37496c;
    }

    public a z() {
        return this.f37494a;
    }
}
