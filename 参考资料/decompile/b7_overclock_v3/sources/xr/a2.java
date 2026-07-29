package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a2 extends gm.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a2 f55812e = new a2(0);

    public a2(int i10) {
        super(i10);
        if (i10 != 0) {
            throw new IllegalArgumentException("ordinal can only be zero");
        }
    }

    public static a2 N(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof a2) {
            return (a2) obj;
        }
        BigInteger bigIntegerJ = gm.k.I(obj).J();
        if (bigIntegerJ.intValue() == 0) {
            return f55812e;
        }
        throw new IllegalArgumentException("unaccounted enum value " + bigIntegerJ);
    }
}
