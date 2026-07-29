package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class g0 extends gm.t {
    public g0(long j10) {
        super(j10);
    }

    public g0(BigInteger bigInteger) {
        super(bigInteger);
    }

    public g0(byte[] bArr) {
        super(bArr);
    }

    public static g0 V(Object obj) {
        return obj instanceof g0 ? (g0) obj : new g0(gm.t.I(obj).K());
    }
}
