package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class q extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f35845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f35846b;

    public q(f0 f0Var) {
        if (!t.I(f0Var.K(0)).L(0)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f35845a = org.bouncycastle.util.a.p(z.I(f0Var.K(1)).J());
        this.f35846b = org.bouncycastle.util.a.p(z.I(f0Var.K(2)).J());
    }

    public q(byte[] bArr, byte[] bArr2) {
        this.f35845a = org.bouncycastle.util.a.p(bArr);
        this.f35846b = org.bouncycastle.util.a.p(bArr2);
    }

    public static q x(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        iVar.a(new t(0L));
        iVar.a(new f2(this.f35845a));
        iVar.a(new f2(this.f35846b));
        return new j2(iVar);
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f35845a);
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f35846b);
    }
}
