package gm;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class k extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f29722c = new a(k.class, 10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k[] f29723d = new k[12];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29725b;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return k.G(f2Var.J(), false);
        }
    }

    public k(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f29724a = BigInteger.valueOf(i10).toByteArray();
        this.f29725b = 0;
    }

    public k(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f29724a = bigInteger.toByteArray();
        this.f29725b = 0;
    }

    public k(byte[] bArr) {
        this(bArr, true);
    }

    public k(byte[] bArr, boolean z10) {
        if (t.R(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if ((bArr[0] & 128) != 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f29724a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
        this.f29725b = t.U(bArr);
    }

    public static k G(byte[] bArr, boolean z10) {
        if (bArr.length > 1) {
            return new k(bArr, z10);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i10 = bArr[0] & 255;
        k[] kVarArr = f29723d;
        if (i10 >= kVarArr.length) {
            return new k(bArr, z10);
        }
        k kVar = kVarArr[i10];
        if (kVar != null) {
            return kVar;
        }
        k kVar2 = new k(bArr, z10);
        kVarArr[i10] = kVar2;
        return kVar2;
    }

    public static k H(n0 n0Var, boolean z10) {
        return (k) f29722c.f(n0Var, z10);
    }

    public static k I(Object obj) {
        if (obj == null || (obj instanceof k)) {
            return (k) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (k) f29722c.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29724a.length);
    }

    public BigInteger J() {
        return new BigInteger(this.f29724a);
    }

    public boolean K(int i10) {
        byte[] bArr = this.f29724a;
        int length = bArr.length;
        int i11 = this.f29725b;
        return length - i11 <= 4 && t.P(bArr, i11, -1) == i10;
    }

    public boolean L(BigInteger bigInteger) {
        return bigInteger != null && t.P(this.f29724a, this.f29725b, -1) == bigInteger.intValue() && J().equals(bigInteger);
    }

    public int M() {
        byte[] bArr = this.f29724a;
        int length = bArr.length;
        int i10 = this.f29725b;
        if (length - i10 <= 4) {
            return t.P(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29724a);
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof k) {
            return org.bouncycastle.util.a.g(this.f29724a, ((k) c0Var).f29724a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 10, this.f29724a);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
