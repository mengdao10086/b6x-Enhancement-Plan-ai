package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.f0 f37429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.f0 f37431c;

    public b0(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37429a = gm.f0.J(f0Var.K(0));
        this.f37430b = gm.f0.J(f0Var.K(1));
        this.f37431c = gm.f0.J(f0Var.K(2));
    }

    public static b0 A(Object obj) {
        if (obj instanceof b0) {
            return (b0) obj;
        }
        if (obj != null) {
            return new b0(gm.f0.J(obj));
        }
        return null;
    }

    public static b0 z(n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public gm.f0 B() {
        return this.f37431c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37429a);
        iVar.a(this.f37430b);
        iVar.a(this.f37431c);
        return new j2(iVar);
    }

    public gm.f0 x() {
        return this.f37430b;
    }

    public gm.f0 y() {
        return this.f37429a;
    }
}
