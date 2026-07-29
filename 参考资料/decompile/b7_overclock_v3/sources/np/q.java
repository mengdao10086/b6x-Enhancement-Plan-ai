package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class q implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f42507h = 160;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f42508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f42511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f42512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v f42514g;

    public q(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10) {
        this(bigInteger, bigInteger2, bigInteger3, a(i10), i10, null, null);
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11) {
        this(bigInteger, bigInteger2, bigInteger3, i10, i11, null, null);
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, int i11, BigInteger bigInteger4, v vVar) {
        if (i11 != 0) {
            if (i11 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i11 < i10) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i10 > bigInteger.bitLength() && !org.bouncycastle.util.p.d("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f42508a = bigInteger2;
        this.f42509b = bigInteger;
        this.f42510c = bigInteger3;
        this.f42512e = i10;
        this.f42513f = i11;
        this.f42511d = bigInteger4;
        this.f42514g = vVar;
    }

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, v vVar) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, vVar);
    }

    public static int a(int i10) {
        if (i10 != 0 && i10 < 160) {
            return i10;
        }
        return 160;
    }

    public BigInteger b() {
        return this.f42508a;
    }

    public BigInteger c() {
        return this.f42511d;
    }

    public int d() {
        return this.f42513f;
    }

    public int e() {
        return this.f42512e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (g() != null) {
            if (!g().equals(qVar.g())) {
                return false;
            }
        } else if (qVar.g() != null) {
            return false;
        }
        return qVar.f().equals(this.f42509b) && qVar.b().equals(this.f42508a);
    }

    public BigInteger f() {
        return this.f42509b;
    }

    public BigInteger g() {
        return this.f42510c;
    }

    public v h() {
        return this.f42514g;
    }

    public int hashCode() {
        return (f().hashCode() ^ b().hashCode()) ^ (g() != null ? g().hashCode() : 0);
    }
}
