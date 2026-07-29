package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f37547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f37548c;

    public p(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37546a = a.z(f0Var.K(0));
        this.f37547b = zn.b.z(f0Var.K(1));
        this.f37548c = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(2)).J());
    }

    public p(a aVar, zn.b bVar, byte[] bArr) {
        this.f37546a = aVar;
        this.f37547b = bVar;
        this.f37548c = org.bouncycastle.util.a.p(bArr);
    }

    public static p y(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f37547b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37546a);
        iVar.a(this.f37547b);
        iVar.a(new f2(this.f37548c));
        return new j2(iVar);
    }

    public a x() {
        return this.f37546a;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f37548c);
    }
}
