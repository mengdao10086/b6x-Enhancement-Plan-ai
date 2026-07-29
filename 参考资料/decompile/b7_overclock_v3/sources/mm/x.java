package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class x extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f41428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f41429b;

    public x(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
        }
        this.f41428a = zn.b.z(f0Var.K(0));
        this.f41429b = zn.b.z(f0Var.K(1));
    }

    public x(zn.b bVar, zn.b bVar2) {
        this.f41428a = bVar;
        this.f41429b = bVar2;
    }

    public static x y(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41428a);
        iVar.a(this.f41429b);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f41429b;
    }

    public zn.b z() {
        return this.f41428a;
    }
}
