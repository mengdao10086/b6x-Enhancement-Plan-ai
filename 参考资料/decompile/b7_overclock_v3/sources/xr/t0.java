package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class t0 extends gm.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f56039f = new BigInteger("-900000000");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f56040g = new BigInteger("900000000");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f56041h = new BigInteger("900000001");

    public t0(long j10) {
        super(j10);
        V();
    }

    public t0(BigInteger bigInteger) {
        super(bigInteger);
        V();
    }

    public t0(byte[] bArr) {
        super(bArr);
        V();
    }

    public static t0 W(Object obj) {
        return obj instanceof t0 ? (t0) obj : new t0(gm.t.I(obj).K());
    }

    public void V() {
        BigInteger bigIntegerK = K();
        if (bigIntegerK.compareTo(f56039f) < 0) {
            throw new IllegalStateException("ninety degree int cannot be less than -900000000");
        }
        if (!bigIntegerK.equals(f56041h) && bigIntegerK.compareTo(f56040g) > 0) {
            throw new IllegalStateException("ninety degree int cannot be greater than 900000000");
        }
    }
}
