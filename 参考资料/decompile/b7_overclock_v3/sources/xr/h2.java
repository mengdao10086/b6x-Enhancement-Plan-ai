package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class h2 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55921a;

    public h2(int i10) {
        this.f55921a = y(i10);
    }

    public h2(BigInteger bigInteger) {
        this.f55921a = bigInteger.intValue();
    }

    public static h2 x(Object obj) {
        return obj instanceof h2 ? (h2) obj : new h2(gm.t.I(obj).K());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.t(this.f55921a);
    }

    public int y(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Uint16 must be >= 0");
        }
        if (i10 <= 255) {
            return i10;
        }
        throw new IllegalArgumentException("Uint16 must be <= 0xFF");
    }
}
