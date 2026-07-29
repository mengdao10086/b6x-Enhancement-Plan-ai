package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class m extends g2 implements j1 {
    public m(int i10) {
        super(i10);
    }

    public m(BigInteger bigInteger) {
        super(bigInteger);
    }

    public static m z(Object obj) {
        return obj instanceof m ? (m) obj : new m(gm.t.I(obj).K());
    }
}
