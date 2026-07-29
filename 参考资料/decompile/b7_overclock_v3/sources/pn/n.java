package pn;

import gm.f0;
import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class n extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f46773d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.t f46774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f46775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46776c;

    public n(f0 f0Var) {
        this.f46774a = zn.t.A(f0Var.K(0));
        this.f46775b = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(1)).J());
        this.f46776c = f0Var.size() == 3 ? gm.t.I(f0Var.K(2)).K() : f46773d;
    }

    public n(zn.t tVar, byte[] bArr, int i10) {
        this.f46774a = tVar;
        this.f46775b = org.bouncycastle.util.a.p(bArr);
        this.f46776c = BigInteger.valueOf(i10);
    }

    public static n x(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f46775b);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f46774a);
        iVar.a(new f2(this.f46775b));
        if (!this.f46776c.equals(f46773d)) {
            iVar.a(new gm.t(this.f46776c));
        }
        return new j2(iVar);
    }

    public BigInteger y() {
        return this.f46776c;
    }

    public zn.t z() {
        return this.f46774a;
    }
}
