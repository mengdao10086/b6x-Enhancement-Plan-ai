package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class o0 extends t0 {
    public o0(long j10) {
        super(j10);
    }

    public o0(BigInteger bigInteger) {
        super(bigInteger);
    }

    public o0(byte[] bArr) {
        super(bArr);
    }

    public static o0 X(Object obj) {
        return obj instanceof o0 ? (o0) obj : obj instanceof t0 ? new o0(((t0) obj).K()) : new o0(gm.t.I(obj).K());
    }
}
