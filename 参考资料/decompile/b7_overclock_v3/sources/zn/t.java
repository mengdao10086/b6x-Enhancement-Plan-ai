package zn;

import gm.f2;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class t extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f58943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f58944b;

    public t(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f58944b = b.z(enumerationL.nextElement());
        this.f58943a = gm.z.I(enumerationL.nextElement()).J();
    }

    public t(b bVar, byte[] bArr) {
        this.f58943a = org.bouncycastle.util.a.p(bArr);
        this.f58944b = bVar;
    }

    public static t A(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(gm.f0.J(obj));
        }
        return null;
    }

    public static t z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58944b);
        iVar.a(new f2(this.f58943a));
        return new j2(iVar);
    }

    public b x() {
        return this.f58944b;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f58943a);
    }
}
