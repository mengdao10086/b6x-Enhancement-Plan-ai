package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class o extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f35835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f35836b;

    public o(f0 f0Var) {
        if (!t.I(f0Var.K(0)).L(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f35835a = org.bouncycastle.util.a.p(z.I(f0Var.K(1)).J());
        this.f35836b = org.bouncycastle.util.a.p(z.I(f0Var.K(2)).J());
    }

    public o(byte[] bArr, byte[] bArr2) {
        this.f35835a = org.bouncycastle.util.a.p(bArr);
        this.f35836b = org.bouncycastle.util.a.p(bArr2);
    }

    public static o x(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(0L));
        iVar.a(new f2(this.f35835a));
        iVar.a(new f2(this.f35836b));
        return new j2(iVar);
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f35835a);
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f35836b);
    }
}
