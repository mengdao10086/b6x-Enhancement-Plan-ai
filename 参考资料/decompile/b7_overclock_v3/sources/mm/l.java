package mm;

import gm.i1;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f41352c;

    public l(gm.f0 f0Var) {
        this.f41350a = (gm.t) f0Var.K(0);
        this.f41351b = zn.b.z(f0Var.K(1));
        this.f41352c = n.A(f0Var.K(2));
    }

    public l(zn.b bVar, n nVar) {
        this.f41350a = new gm.t(0L);
        this.f41351b = bVar;
        this.f41352c = nVar;
    }

    public static l A(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(gm.f0.J(obj));
        }
        return null;
    }

    public static l z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public gm.t B() {
        return this.f41350a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41350a);
        iVar.a(this.f41351b);
        iVar.a(this.f41352c);
        return new i1(iVar);
    }

    public zn.b x() {
        return this.f41351b;
    }

    public n y() {
        return this.f41352c;
    }
}
