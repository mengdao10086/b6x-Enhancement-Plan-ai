package mm;

import gm.j2;
import gm.u1;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f41329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u1 f41330b;

    public h0(gm.f0 f0Var) {
        this.f41329a = zn.b.z(f0Var.K(0));
        this.f41330b = (u1) f0Var.K(1);
    }

    public h0(zn.b bVar, byte[] bArr) {
        this.f41329a = bVar;
        this.f41330b = new u1(bArr);
    }

    public static h0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static h0 z(Object obj) {
        if (obj instanceof h0) {
            return (h0) obj;
        }
        if (obj != null) {
            return new h0(gm.f0.J(obj));
        }
        return null;
    }

    public u1 A() {
        return this.f41330b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f41329a);
        iVar.a(this.f41330b);
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f41329a;
    }
}
