package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class z implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f42579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c0 f42582d;

    public z(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f42579a = bigInteger3;
        this.f42581c = bigInteger;
        this.f42580b = bigInteger2;
    }

    public z(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, c0 c0Var) {
        this.f42579a = bigInteger3;
        this.f42581c = bigInteger;
        this.f42580b = bigInteger2;
        this.f42582d = c0Var;
    }

    public BigInteger a() {
        return this.f42579a;
    }

    public BigInteger b() {
        return this.f42581c;
    }

    public BigInteger c() {
        return this.f42580b;
    }

    public c0 d() {
        return this.f42582d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return zVar.b().equals(this.f42581c) && zVar.c().equals(this.f42580b) && zVar.a().equals(this.f42579a);
    }

    public int hashCode() {
        return (b().hashCode() ^ c().hashCode()) ^ a().hashCode();
    }
}
