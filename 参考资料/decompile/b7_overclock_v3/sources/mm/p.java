package mm;

import gm.f2;
import gm.i1;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f41369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f41370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.z f41371d;

    public p(gm.f0 f0Var) {
        this.f41368a = (gm.t) f0Var.K(0);
        this.f41369b = zn.b.z(f0Var.K(1));
        this.f41370c = n.A(f0Var.K(2));
        this.f41371d = gm.z.I(f0Var.K(3));
    }

    public p(zn.b bVar, n nVar, byte[] bArr) {
        this.f41368a = new gm.t(0L);
        this.f41369b = bVar;
        this.f41370c = nVar;
        this.f41371d = new f2(bArr);
    }

    public static p A(gm.n0 n0Var, boolean z10) {
        return B(gm.f0.I(n0Var, z10));
    }

    public static p B(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(gm.f0.J(obj));
        }
        return null;
    }

    public gm.t C() {
        return this.f41368a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(4);
        iVar.a(this.f41368a);
        iVar.a(this.f41369b);
        iVar.a(this.f41370c);
        iVar.a(this.f41371d);
        return new i1(iVar);
    }

    public byte[] x() {
        return this.f41371d.J();
    }

    public zn.b y() {
        return this.f41369b;
    }

    public n z() {
        return this.f41370c;
    }
}
