package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class h1 extends g2 {
    public h1(int i10) {
        super(i10);
    }

    public h1(BigInteger bigInteger) {
        super(bigInteger);
    }

    public static h1 z(Object obj) {
        return obj instanceof h1 ? (h1) obj : new h1(gm.t.I(obj).K());
    }
}
