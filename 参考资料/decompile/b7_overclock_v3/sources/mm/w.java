package mm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f41425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f41426b;

    public w(gm.f0 f0Var) {
        this.f41425a = gm.z.I(f0Var.K(0)).J();
        this.f41426b = f0Var.size() == 2 ? gm.t.I(f0Var.K(1)).Q() : 12;
    }

    public w(byte[] bArr, int i10) {
        this.f41425a = org.bouncycastle.util.a.p(bArr);
        this.f41426b = i10;
    }

    public static w y(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if (obj != null) {
            return new w(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new f2(this.f41425a));
        if (this.f41426b != 12) {
            iVar.a(new gm.t(this.f41426b));
        }
        return new j2(iVar);
    }

    public int x() {
        return this.f41426b;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f41425a);
    }
}
