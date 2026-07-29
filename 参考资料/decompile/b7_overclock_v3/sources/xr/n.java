package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class n extends g2 {
    public n(int i10) {
        super(i10);
    }

    public n(BigInteger bigInteger) {
        super(bigInteger);
    }

    public static n z(Object obj) {
        return obj instanceof n ? (n) obj : new n(gm.t.I(obj).K());
    }
}
