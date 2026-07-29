package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class d0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f37437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f37438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f37439c;

    public d0(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37437a = zn.b.z(f0Var.K(0));
        this.f37438b = zn.b.z(f0Var.K(1));
        this.f37439c = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(2)).J());
    }

    public d0(zn.b bVar, zn.b bVar2, byte[] bArr) {
        this.f37437a = bVar;
        this.f37438b = bVar2;
        this.f37439c = org.bouncycastle.util.a.p(bArr);
    }

    public static d0 x(Object obj) {
        if (obj instanceof d0) {
            return (d0) obj;
        }
        if (obj != null) {
            return new d0(gm.f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f37439c);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37437a);
        iVar.a(this.f37438b);
        iVar.a(new f2(A()));
        return new j2(iVar);
    }

    public zn.b y() {
        return this.f37437a;
    }

    public zn.b z() {
        return this.f37438b;
    }
}
