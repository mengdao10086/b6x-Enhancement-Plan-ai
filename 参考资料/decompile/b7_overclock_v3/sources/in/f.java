package in;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class f extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f32579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f32580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f32581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BigInteger f32582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BigInteger f32583e;

    public f(f0 f0Var) {
        if (f0Var.size() != 4 && f0Var.size() != 5) {
            throw new IllegalArgumentException("invalid sequence: size = " + f0Var.size());
        }
        this.f32579a = org.bouncycastle.util.a.p(z.I(f0Var.K(0)).J());
        this.f32580b = t.I(f0Var.K(1)).K();
        this.f32581c = t.I(f0Var.K(2)).K();
        this.f32582d = t.I(f0Var.K(3)).K();
        this.f32583e = f0Var.size() == 5 ? t.I(f0Var.K(4)).K() : null;
    }

    public f(byte[] bArr, int i10, int i11, int i12) {
        this(bArr, BigInteger.valueOf(i10), BigInteger.valueOf(i11), BigInteger.valueOf(i12), (BigInteger) null);
    }

    public f(byte[] bArr, int i10, int i11, int i12, int i13) {
        this(bArr, BigInteger.valueOf(i10), BigInteger.valueOf(i11), BigInteger.valueOf(i12), BigInteger.valueOf(i13));
    }

    public f(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f32579a = org.bouncycastle.util.a.p(bArr);
        this.f32580b = bigInteger;
        this.f32581c = bigInteger2;
        this.f32582d = bigInteger3;
        this.f32583e = bigInteger4;
    }

    public static f z(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f32583e;
    }

    public BigInteger B() {
        return this.f32582d;
    }

    public byte[] C() {
        return org.bouncycastle.util.a.p(this.f32579a);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(5);
        iVar.a(new f2(this.f32579a));
        iVar.a(new t(this.f32580b));
        iVar.a(new t(this.f32581c));
        iVar.a(new t(this.f32582d));
        if (this.f32583e != null) {
            iVar.a(new t(this.f32583e));
        }
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f32581c;
    }

    public BigInteger y() {
        return this.f32580b;
    }
}
