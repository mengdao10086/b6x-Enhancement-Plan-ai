package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class z0 extends gm.t {
    public z0(long j10) {
        super(j10);
        W();
    }

    public z0(BigInteger bigInteger) {
        super(bigInteger);
        W();
    }

    public z0(byte[] bArr) {
        super(bArr);
        W();
    }

    public static z0 V(Object obj) {
        return obj instanceof z0 ? (z0) obj : new z0(gm.t.I(obj).K());
    }

    public final void W() {
        if (BigInteger.ZERO.compareTo(K()) >= 0) {
            throw new IllegalStateException("psid must be greater than zero");
        }
    }
}
