package zn;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f58816a;

    public l(BigInteger bigInteger) {
        if (org.bouncycastle.util.b.f46032a.compareTo(bigInteger) > 0) {
            throw new IllegalArgumentException("Invalid CRL number : not in (0..MAX)");
        }
        this.f58816a = bigInteger;
    }

    public static l y(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(gm.t.I(obj).K());
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.t(this.f58816a);
    }

    public String toString() {
        return "CRLNumber: " + x();
    }

    public BigInteger x() {
        return this.f58816a;
    }
}
