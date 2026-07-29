package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class t0 extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v0 f42543c;

    public t0(SecureRandom secureRandom, v0 v0Var) {
        super(secureRandom, d(v0Var));
        this.f42543c = v0Var;
    }

    public static int d(v0 v0Var) {
        return v0Var.b() != 0 ? v0Var.b() : v0Var.c().bitLength();
    }

    public v0 c() {
        return this.f42543c;
    }
}
