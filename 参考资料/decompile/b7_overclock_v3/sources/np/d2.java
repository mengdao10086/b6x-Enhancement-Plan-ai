package np;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class d2 extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f42380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f42381d;

    public d2(BigInteger bigInteger, SecureRandom secureRandom, int i10, int i11) {
        super(secureRandom, i10);
        if (i10 < 12) {
            throw new IllegalArgumentException("key strength too small");
        }
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("public exponent cannot be even");
        }
        this.f42380c = bigInteger;
        this.f42381d = i11;
    }

    public int c() {
        return this.f42381d;
    }

    public BigInteger d() {
        return this.f42380c;
    }
}
