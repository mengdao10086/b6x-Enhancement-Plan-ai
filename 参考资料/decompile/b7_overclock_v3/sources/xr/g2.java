package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class g2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55917a;

    public g2(int i10) {
        this.f55917a = y(i10);
    }

    public g2(BigInteger bigInteger) {
        this.f55917a = bigInteger.intValue();
    }

    public static g2 x(Object obj) {
        return obj instanceof g2 ? (g2) obj : new g2(gm.t.I(obj).K());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.t(this.f55917a);
    }

    public int y(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Uint16 must be >= 0");
        }
        if (i10 <= 65535) {
            return i10;
        }
        throw new IllegalArgumentException("Uint16 must be <= 0xFFFF");
    }
}
