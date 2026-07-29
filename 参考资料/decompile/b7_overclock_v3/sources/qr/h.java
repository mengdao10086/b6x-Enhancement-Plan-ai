package qr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f47614a;

    public h(BigInteger bigInteger) {
        this.f47614a = bigInteger;
    }

    @Override // qr.b
    public int d() {
        return 1;
    }

    @Override // qr.b
    public BigInteger e() {
        return this.f47614a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f47614a.equals(((h) obj).f47614a);
        }
        return false;
    }

    public int hashCode() {
        return this.f47614a.hashCode();
    }
}
