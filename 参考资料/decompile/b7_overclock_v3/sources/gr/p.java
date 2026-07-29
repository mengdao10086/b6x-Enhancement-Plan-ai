package gr;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f29964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f29965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f29966c;

    public p(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f29964a = bigInteger;
        this.f29965b = bigInteger2;
        this.f29966c = bigInteger3;
    }

    public BigInteger a() {
        return this.f29966c;
    }

    public BigInteger b() {
        return this.f29964a;
    }

    public BigInteger c() {
        return this.f29965b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f29966c.equals(pVar.f29966c) && this.f29964a.equals(pVar.f29964a) && this.f29965b.equals(pVar.f29965b);
    }

    public int hashCode() {
        return (this.f29966c.hashCode() ^ this.f29964a.hashCode()) ^ this.f29965b.hashCode();
    }
}
