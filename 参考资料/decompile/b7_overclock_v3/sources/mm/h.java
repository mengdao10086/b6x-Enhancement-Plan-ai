package mm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f41327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41328b;

    public h(gm.f0 f0Var) {
        this.f41327a = gm.z.I(f0Var.K(0)).J();
        this.f41328b = f0Var.size() == 2 ? gm.t.I(f0Var.K(1)).Q() : 12;
    }

    public h(byte[] bArr, int i10) {
        this.f41327a = org.bouncycastle.util.a.p(bArr);
        this.f41328b = i10;
    }

    public static h y(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new f2(this.f41327a));
        if (this.f41328b != 12) {
            iVar.a(new gm.t(this.f41328b));
        }
        return new j2(iVar);
    }

    public int x() {
        return this.f41328b;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f41327a);
    }
}
