package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class i0 extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g0 f42437c;

    public i0(g0 g0Var, SecureRandom secureRandom) {
        super(secureRandom, g0Var.e().bitLength());
        this.f42437c = g0Var;
    }

    public g0 c() {
        return this.f42437c;
    }
}
