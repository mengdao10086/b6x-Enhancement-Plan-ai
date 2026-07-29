package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class v0 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f42553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42555c;

    public v0(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public v0(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        this.f42553a = bigInteger2;
        this.f42554b = bigInteger;
        this.f42555c = i10;
    }

    public BigInteger a() {
        return this.f42553a;
    }

    public int b() {
        return this.f42555c;
    }

    public BigInteger c() {
        return this.f42554b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return v0Var.c().equals(this.f42554b) && v0Var.a().equals(this.f42553a) && v0Var.b() == this.f42555c;
    }

    public int hashCode() {
        return (c().hashCode() ^ a().hashCode()) + this.f42555c;
    }
}
