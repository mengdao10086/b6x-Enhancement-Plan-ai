package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class z0 extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b1 f42583c;

    public z0(SecureRandom secureRandom, b1 b1Var) {
        super(secureRandom, b1Var.b().bitLength() - 1);
        this.f42583c = b1Var;
    }

    public b1 c() {
        return this.f42583c;
    }
}
