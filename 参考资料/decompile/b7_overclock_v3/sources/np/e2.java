package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class e2 extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f42389d = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f42390e = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42392c;

    public e2(boolean z10, BigInteger bigInteger, BigInteger bigInteger2) {
        super(z10);
        if (!z10 && (bigInteger2.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA publicExponent is even");
        }
        this.f42391b = f(bigInteger);
        this.f42392c = bigInteger2;
    }

    public BigInteger d() {
        return this.f42392c;
    }

    public BigInteger e() {
        return this.f42391b;
    }

    public final BigInteger f(BigInteger bigInteger) {
        if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        }
        if (org.bouncycastle.util.p.d("org.bouncycastle.rsa.allow_unsafe_mod") || bigInteger.gcd(f42389d).equals(f42390e)) {
            return bigInteger;
        }
        throw new IllegalArgumentException("RSA modulus has a small prime factor");
    }
}
