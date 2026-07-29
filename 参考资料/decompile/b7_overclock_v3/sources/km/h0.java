package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f37507b;

    public h0(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37506a = a.z(f0Var.K(0));
        this.f37507b = n.z(f0Var.K(1));
    }

    public h0(a aVar, n nVar) {
        this.f37506a = aVar;
        this.f37507b = nVar;
    }

    public static h0 x(n0 n0Var, boolean z10) {
        return y(gm.f0.I(n0Var, z10));
    }

    public static h0 y(Object obj) {
        if (obj instanceof h0) {
            return (h0) obj;
        }
        if (obj != null) {
            return new h0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f37506a);
        iVar.a(this.f37507b);
        return new j2(iVar);
    }
}
