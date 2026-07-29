package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f35752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f35753b;

    public b(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f35752a = t.I(f0Var.K(0));
            this.f35753b = z.I(f0Var.K(1)).J();
        } else {
            throw new IllegalArgumentException("size of seq = " + f0Var.size());
        }
    }

    public b(byte[] bArr) {
        this.f35752a = new t(0L);
        this.f35753b = bArr;
    }

    public static b x(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(this.f35752a);
        iVar.a(new f2(this.f35753b));
        return new j2(iVar);
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f35753b);
    }
}
