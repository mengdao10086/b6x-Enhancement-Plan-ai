package gr;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class q implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f29967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f29968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f29969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f29970d;

    public q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f29967a = bigInteger;
        this.f29968b = bigInteger2;
        this.f29969c = bigInteger3;
        this.f29970d = bigInteger4;
    }

    public BigInteger a() {
        return this.f29970d;
    }

    public BigInteger b() {
        return this.f29968b;
    }

    public BigInteger c() {
        return this.f29969c;
    }

    public BigInteger d() {
        return this.f29967a;
    }
}
