package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class w extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f42558c;

    public w(SecureRandom secureRandom, z zVar) {
        super(secureRandom, zVar.b().bitLength() - 1);
        this.f42558c = zVar;
    }

    public z c() {
        return this.f42558c;
    }
}
