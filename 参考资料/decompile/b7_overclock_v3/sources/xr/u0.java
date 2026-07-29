package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class u0 extends gm.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f56054f = new BigInteger("-1799999999");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f56055g = new BigInteger("1800000000");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f56056h = new BigInteger("1800000001");

    public u0(long j10) {
        super(j10);
        V();
    }

    public u0(BigInteger bigInteger) {
        super(bigInteger);
        V();
    }

    public u0(byte[] bArr) {
        super(bArr);
        V();
    }

    public static u0 W(Object obj) {
        return obj instanceof u0 ? (u0) obj : new u0(gm.t.I(obj).K());
    }

    public void V() {
        BigInteger bigIntegerK = K();
        if (bigIntegerK.compareTo(f56054f) < 0) {
            throw new IllegalStateException("one eighty degree int cannot be less than -1799999999");
        }
        if (!bigIntegerK.equals(f56056h) && bigIntegerK.compareTo(f56055g) > 0) {
            throw new IllegalStateException("one eighty degree int cannot be greater than 1800000000");
        }
    }
}
