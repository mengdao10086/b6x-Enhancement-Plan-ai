package km;

import gm.j2;
import gm.n0;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mm.n f37515b;

    public i0(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37514a = a.z(f0Var.K(0));
        this.f37515b = mm.n.A(f0Var.K(1));
    }

    public i0(a aVar, mm.n nVar) {
        this.f37514a = aVar;
        this.f37515b = nVar;
    }

    public static i0 A(Object obj) {
        if (obj instanceof i0) {
            return (i0) obj;
        }
        if (obj != null) {
            return new i0(gm.f0.J(obj));
        }
        return null;
    }

    public static i0 z(n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f37514a);
        iVar.a(this.f37515b);
        return new j2(iVar);
    }

    public a x() {
        return this.f37514a;
    }

    public mm.n y() {
        return this.f37515b;
    }
}
