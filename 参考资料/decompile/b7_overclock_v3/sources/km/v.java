package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f37563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f37564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f37565c;

    public v(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37563a = zn.b.z(f0Var.K(0));
        this.f37564b = zn.b.z(f0Var.K(1));
        this.f37565c = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(2)).J());
    }

    public v(zn.b bVar, zn.b bVar2, byte[] bArr) {
        this.f37563a = bVar;
        this.f37564b = bVar2;
        this.f37565c = org.bouncycastle.util.a.p(bArr);
    }

    public static v x(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj != null) {
            return new v(gm.f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f37565c);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37563a);
        iVar.a(this.f37564b);
        iVar.a(new f2(A()));
        return new j2(iVar);
    }

    public zn.b y() {
        return this.f37564b;
    }

    public zn.b z() {
        return this.f37563a;
    }
}
