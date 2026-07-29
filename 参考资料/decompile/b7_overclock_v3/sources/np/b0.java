package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class b0 extends x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f42359d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f42360e = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42361c;

    public b0(BigInteger bigInteger, z zVar) {
        super(false, zVar);
        this.f42361c = f(bigInteger, zVar);
    }

    public BigInteger e() {
        return this.f42361c;
    }

    public final BigInteger f(BigInteger bigInteger, z zVar) {
        if (zVar == null) {
            return bigInteger;
        }
        BigInteger bigInteger2 = f42360e;
        if (bigInteger2.compareTo(bigInteger) > 0 || zVar.b().subtract(bigInteger2).compareTo(bigInteger) < 0 || !f42359d.equals(bigInteger.modPow(zVar.c(), zVar.b()))) {
            throw new IllegalArgumentException("y value does not appear to be in correct group");
        }
        return bigInteger;
    }
}
