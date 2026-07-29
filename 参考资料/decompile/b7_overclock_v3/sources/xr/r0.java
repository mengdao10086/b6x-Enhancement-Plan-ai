package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class r0 extends u0 {
    public r0(long j10) {
        super(j10);
    }

    public r0(BigInteger bigInteger) {
        super(bigInteger);
    }

    public r0(byte[] bArr) {
        super(bArr);
    }

    public static r0 X(Object obj) {
        return obj instanceof r0 ? (r0) obj : obj instanceof u0 ? new r0(((u0) obj).K()) : new r0(gm.t.I(obj).K());
    }
}
