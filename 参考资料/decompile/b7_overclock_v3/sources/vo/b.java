package vo;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f53317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f53318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f53319c;

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, false);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, boolean z10) {
        g.w(bigInteger, "p");
        g.w(bigInteger2, "q");
        g.w(bigInteger3, "g");
        if (!z10) {
            BigInteger bigInteger4 = g.f53334b;
            if (!bigInteger.subtract(bigInteger4).mod(bigInteger2).equals(g.f53333a)) {
                throw new IllegalArgumentException("p-1 must be evenly divisible by q");
            }
            if (bigInteger3.compareTo(BigInteger.valueOf(2L)) == -1 || bigInteger3.compareTo(bigInteger.subtract(bigInteger4)) == 1) {
                throw new IllegalArgumentException("g must be in [2, p-1]");
            }
            if (!bigInteger3.modPow(bigInteger2, bigInteger).equals(bigInteger4)) {
                throw new IllegalArgumentException("g^q mod p must equal 1");
            }
            if (!bigInteger.isProbablePrime(20)) {
                throw new IllegalArgumentException("p must be prime");
            }
            if (!bigInteger2.isProbablePrime(20)) {
                throw new IllegalArgumentException("q must be prime");
            }
        }
        this.f53317a = bigInteger;
        this.f53318b = bigInteger2;
        this.f53319c = bigInteger3;
    }

    public BigInteger a() {
        return this.f53319c;
    }

    public BigInteger b() {
        return this.f53317a;
    }

    public BigInteger c() {
        return this.f53318b;
    }
}
