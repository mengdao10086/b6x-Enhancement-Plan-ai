package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class b1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f42362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e1 f42365d;

    public b1(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f42362a = bigInteger;
        this.f42363b = bigInteger2;
        this.f42364c = bigInteger3;
    }

    public b1(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, e1 e1Var) {
        this.f42364c = bigInteger3;
        this.f42362a = bigInteger;
        this.f42363b = bigInteger2;
        this.f42365d = e1Var;
    }

    public BigInteger a() {
        return this.f42364c;
    }

    public BigInteger b() {
        return this.f42362a;
    }

    public BigInteger c() {
        return this.f42363b;
    }

    public e1 d() {
        return this.f42365d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        return b1Var.b().equals(this.f42362a) && b1Var.c().equals(this.f42363b) && b1Var.a().equals(this.f42364c);
    }

    public int hashCode() {
        return (this.f42362a.hashCode() ^ this.f42363b.hashCode()) ^ this.f42364c.hashCode();
    }
}
