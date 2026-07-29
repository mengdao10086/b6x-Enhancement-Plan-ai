package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class y extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.y f37573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.h f37574c;

    public y(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37572a = a.z(f0Var.K(0));
        this.f37573b = gm.y.N(f0Var.K(1));
        this.f37574c = f0Var.K(2);
    }

    public y(a aVar, gm.y yVar, gm.h hVar) {
        this.f37572a = aVar;
        this.f37573b = yVar;
        this.f37574c = hVar;
    }

    public static y y(n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static y z(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj != null) {
            return new y(gm.f0.J(obj));
        }
        return null;
    }

    public gm.y A() {
        return this.f37573b;
    }

    public gm.h B() {
        return this.f37574c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37572a);
        iVar.a(this.f37573b);
        iVar.a(this.f37574c);
        return new j2(iVar);
    }

    public a x() {
        return this.f37572a;
    }
}
