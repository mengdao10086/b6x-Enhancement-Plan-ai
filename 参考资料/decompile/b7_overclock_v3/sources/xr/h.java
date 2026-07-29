package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class h extends gm.k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h f55918e = new h(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h f55919f = new h(1);

    public h(int i10) {
        super(i10);
    }

    public static h N(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        BigInteger bigIntegerJ = gm.k.I(obj).J();
        int iIntValue = bigIntegerJ.intValue();
        if (iIntValue == 0) {
            return f55918e;
        }
        if (iIntValue == 1) {
            return f55919f;
        }
        throw new IllegalArgumentException("unaccounted enum value " + bigIntegerJ);
    }
}
