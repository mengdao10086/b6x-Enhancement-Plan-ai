package gm;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class t extends c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f29805c = new a(t.class, 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f29806d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f29807e = 255;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f29808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29809b;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 e(f2 f2Var) {
            return t.G(f2Var.J());
        }
    }

    public t(long j10) {
        this.f29808a = BigInteger.valueOf(j10).toByteArray();
        this.f29809b = 0;
    }

    public t(BigInteger bigInteger) {
        this.f29808a = bigInteger.toByteArray();
        this.f29809b = 0;
    }

    public t(byte[] bArr) {
        this(bArr, true);
    }

    public t(byte[] bArr, boolean z10) {
        if (R(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f29808a = z10 ? org.bouncycastle.util.a.p(bArr) : bArr;
        this.f29809b = U(bArr);
    }

    public static t G(byte[] bArr) {
        return new t(bArr, false);
    }

    public static t H(n0 n0Var, boolean z10) {
        return (t) f29805c.f(n0Var, z10);
    }

    public static t I(Object obj) {
        if (obj == null || (obj instanceof t)) {
            return (t) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (t) f29805c.c((byte[]) obj);
        } catch (Exception e10) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e10.toString());
        }
    }

    public static int P(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int iMax = Math.max(i10, length - 4);
        int i12 = i11 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i12;
            }
            i12 = (i12 << 8) | (bArr[iMax] & 255);
        }
    }

    public static boolean R(byte[] bArr) {
        int length = bArr.length;
        if (length != 0) {
            return (length == 1 || bArr[0] != (bArr[1] >> 7) || org.bouncycastle.util.p.d("org.bouncycastle.asn1.allow_unsafe_integer")) ? false : true;
        }
        return true;
    }

    public static long S(byte[] bArr, int i10, int i11) {
        int length = bArr.length;
        int iMax = Math.max(i10, length - 8);
        long j10 = i11 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return j10;
            }
            j10 = (j10 << 8) | ((long) (bArr[iMax] & 255));
        }
    }

    public static int U(byte[] bArr) {
        int length = bArr.length - 1;
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            if (bArr[i10] != (bArr[i11] >> 7)) {
                break;
            }
            i10 = i11;
        }
        return i10;
    }

    @Override // gm.c0
    public int A(boolean z10) {
        return b0.i(z10, this.f29808a.length);
    }

    public BigInteger J() {
        return new BigInteger(1, this.f29808a);
    }

    public BigInteger K() {
        return new BigInteger(this.f29808a);
    }

    public boolean L(int i10) {
        byte[] bArr = this.f29808a;
        int length = bArr.length;
        int i11 = this.f29809b;
        return length - i11 <= 4 && P(bArr, i11, -1) == i10;
    }

    public boolean M(long j10) {
        byte[] bArr = this.f29808a;
        int length = bArr.length;
        int i10 = this.f29809b;
        return length - i10 <= 8 && S(bArr, i10, -1) == j10;
    }

    public boolean N(BigInteger bigInteger) {
        return bigInteger != null && P(this.f29808a, this.f29809b, -1) == bigInteger.intValue() && K().equals(bigInteger);
    }

    public int O() {
        byte[] bArr = this.f29808a;
        int length = bArr.length;
        int i10 = this.f29809b;
        int i11 = length - i10;
        if (i11 > 4 || (i11 == 4 && (bArr[i10] & 128) != 0)) {
            throw new ArithmeticException("ASN.1 Integer out of positive int range");
        }
        return P(bArr, i10, 255);
    }

    public int Q() {
        byte[] bArr = this.f29808a;
        int length = bArr.length;
        int i10 = this.f29809b;
        if (length - i10 <= 4) {
            return P(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long T() {
        byte[] bArr = this.f29808a;
        int length = bArr.length;
        int i10 = this.f29809b;
        if (length - i10 <= 8) {
            return S(bArr, i10, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        return org.bouncycastle.util.a.s0(this.f29808a);
    }

    public String toString() {
        return K().toString();
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (c0Var instanceof t) {
            return org.bouncycastle.util.a.g(this.f29808a, ((t) c0Var).f29808a);
        }
        return false;
    }

    @Override // gm.c0
    public void y(b0 b0Var, boolean z10) throws IOException {
        b0Var.r(z10, 2, this.f29808a);
    }

    @Override // gm.c0
    public boolean z() {
        return false;
    }
}
