package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class w0 extends gm.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w0 f56084f = new w0(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w0 f56085g = new w0(2);

    public w0(long j10) {
        super(j10);
    }

    public w0(BigInteger bigInteger) {
        super(bigInteger);
    }

    public w0(byte[] bArr) {
        super(bArr);
    }

    public static w0 V(Object obj) {
        return obj instanceof w0 ? (w0) obj : obj instanceof gm.t ? new w0(((gm.t) obj).K()) : V(gm.t.I(obj));
    }
}
