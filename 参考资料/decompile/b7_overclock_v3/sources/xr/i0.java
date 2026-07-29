package xr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class i0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f55926a;

    public i0(gm.t tVar) {
        int iL = org.bouncycastle.util.b.l(tVar.K());
        if (iL < 0 || iL > 65535) {
            throw new IllegalArgumentException("value out of range");
        }
        this.f55926a = tVar.K();
    }

    public static i0 x(Object obj) {
        if (obj instanceof i0) {
            return (i0) obj;
        }
        if (obj != null) {
            return new i0(gm.t.I(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.t(this.f55926a);
    }
}
