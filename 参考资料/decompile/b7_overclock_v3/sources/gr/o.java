package gr;

import java.math.BigInteger;
import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class o implements KeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f29960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f29961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f29962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f29963d;

    public o(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f29960a = bigInteger;
        this.f29961b = bigInteger2;
        this.f29962c = bigInteger3;
        this.f29963d = bigInteger4;
    }

    public BigInteger a() {
        return this.f29963d;
    }

    public BigInteger b() {
        return this.f29961b;
    }

    public BigInteger c() {
        return this.f29962c;
    }

    public BigInteger d() {
        return this.f29960a;
    }
}
