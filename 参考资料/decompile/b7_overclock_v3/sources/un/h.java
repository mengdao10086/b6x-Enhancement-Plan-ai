package un;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f52306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f52307b;

    public h(f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("sequence has wrong number of elements");
        }
        this.f52306a = zn.b.z(f0Var.K(0));
        this.f52307b = z.I(f0Var.K(1)).J();
    }

    public h(zn.b bVar, byte[] bArr) {
        this.f52306a = bVar;
        this.f52307b = org.bouncycastle.util.a.p(bArr);
    }

    public static h z(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52306a);
        iVar.a(new f2(this.f52307b));
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f52306a;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f52307b);
    }
}
