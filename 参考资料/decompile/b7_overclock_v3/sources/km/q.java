package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f37549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final mm.n f37550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final zn.b f37551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f37552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f37553e;

    public q(gm.f0 f0Var) {
        if (f0Var.size() != 5) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37549a = j0.x(f0Var.K(0));
        this.f37550b = mm.n.A(f0Var.K(1));
        this.f37551c = zn.b.z(f0Var.K(2));
        this.f37552d = zn.b.z(f0Var.K(3));
        this.f37553e = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(4)).J());
    }

    public q(j0 j0Var, mm.n nVar, zn.b bVar, zn.b bVar2, byte[] bArr) {
        this.f37549a = j0Var;
        this.f37550b = nVar;
        this.f37551c = bVar;
        this.f37552d = bVar2;
        this.f37553e = org.bouncycastle.util.a.p(bArr);
    }

    public static q y(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f37551c;
    }

    public byte[] B() {
        return org.bouncycastle.util.a.p(this.f37553e);
    }

    public zn.b C() {
        return this.f37552d;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(5);
        iVar.a(this.f37549a);
        iVar.a(this.f37550b);
        iVar.a(this.f37551c);
        iVar.a(this.f37552d);
        iVar.a(new f2(this.f37553e));
        return new j2(iVar);
    }

    public mm.n x() {
        return this.f37550b;
    }

    public j0 z() {
        return this.f37549a;
    }
}
