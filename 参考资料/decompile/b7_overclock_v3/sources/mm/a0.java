package mm;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f41273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public zn.b f41274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f41275d;

    public a0(gm.f0 f0Var) {
        this.f41272a = (gm.t) f0Var.K(0);
        this.f41273b = z.z(f0Var.K(1));
        this.f41274c = zn.b.z(f0Var.K(2));
        this.f41275d = (gm.z) f0Var.K(3);
    }

    public a0(z zVar, zn.b bVar, gm.z zVar2) {
        this.f41272a = new gm.t(4L);
        this.f41273b = zVar;
        this.f41274c = bVar;
        this.f41275d = zVar2;
    }

    public static a0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static a0 z(Object obj) {
        if (obj instanceof a0) {
            return (a0) obj;
        }
        if (obj != null) {
            return new a0(gm.f0.J(obj));
        }
        return null;
    }

    public z A() {
        return this.f41273b;
    }

    public zn.b B() {
        return this.f41274c;
    }

    public gm.t C() {
        return this.f41272a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f41272a);
        iVar.a(this.f41273b);
        iVar.a(this.f41274c);
        iVar.a(this.f41275d);
        return new j2(iVar);
    }

    public gm.z x() {
        return this.f41275d;
    }
}
