package np;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class c2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e2 f42373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f42374b;

    public c2(e2 e2Var, BigInteger bigInteger) {
        if (e2Var instanceof f2) {
            throw new IllegalArgumentException("RSA parameters should be for a public key");
        }
        this.f42373a = e2Var;
        this.f42374b = bigInteger;
    }

    public BigInteger a() {
        return this.f42374b;
    }

    public e2 b() {
        return this.f42373a;
    }
}
