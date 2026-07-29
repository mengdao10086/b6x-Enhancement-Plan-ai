package so;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class l1 implements org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f50224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f50225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f50226c;

    public l1(xn.d dVar, BigInteger bigInteger) {
        c(dVar, bigInteger);
    }

    public l1(xn.d dVar, BigInteger bigInteger, byte[] bArr) {
        c(dVar, bigInteger);
        d(bArr);
    }

    public l1(byte[] bArr) {
        d(bArr);
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return false;
    }

    public final boolean a(Object obj, Object obj2) {
        return obj != null ? obj.equals(obj2) : obj2 == null;
    }

    public xn.d b() {
        return this.f50225b;
    }

    public final void c(xn.d dVar, BigInteger bigInteger) {
        this.f50225b = dVar;
        this.f50226c = bigInteger;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return new l1(this.f50225b, this.f50226c, this.f50224a);
    }

    public final void d(byte[] bArr) {
        this.f50224a = bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return org.bouncycastle.util.a.g(this.f50224a, l1Var.f50224a) && a(this.f50226c, l1Var.f50226c) && a(this.f50225b, l1Var.f50225b);
    }

    public int hashCode() {
        int iS0 = org.bouncycastle.util.a.s0(this.f50224a);
        BigInteger bigInteger = this.f50226c;
        if (bigInteger != null) {
            iS0 ^= bigInteger.hashCode();
        }
        xn.d dVar = this.f50225b;
        return dVar != null ? iS0 ^ dVar.hashCode() : iS0;
    }
}
