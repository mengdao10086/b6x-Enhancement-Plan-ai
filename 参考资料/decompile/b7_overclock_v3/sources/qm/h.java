package qm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f47501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f47502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f47503c;

    public h(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f47501a = org.bouncycastle.util.a.p(z.I(f0Var.K(0)).J());
            this.f47503c = org.bouncycastle.util.a.p(z.I(f0Var.K(1)).J());
            this.f47502b = null;
        } else if (f0Var.size() == 3) {
            this.f47501a = org.bouncycastle.util.a.p(z.I(f0Var.K(0)).J());
            this.f47502b = org.bouncycastle.util.a.p(z.H(n0.T(f0Var.K(1)), false).J());
            this.f47503c = org.bouncycastle.util.a.p(z.I(f0Var.K(2)).J());
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + f0Var.size());
        }
    }

    public h(byte[] bArr, byte[] bArr2) {
        this(bArr, null, bArr2);
    }

    public h(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f47501a = org.bouncycastle.util.a.p(bArr);
        this.f47502b = org.bouncycastle.util.a.p(bArr2);
        this.f47503c = org.bouncycastle.util.a.p(bArr3);
    }

    public static h y(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f47502b);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(new f2(this.f47501a));
        if (this.f47502b != null) {
            iVar.a(new n2(false, 0, (gm.h) new f2(this.f47501a)));
        }
        iVar.a(new f2(this.f47503c));
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f47501a);
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f47503c);
    }
}
