package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class f extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f42393c;

    public f(SecureRandom secureRandom, h hVar) {
        super(secureRandom, d(hVar));
        this.f42393c = hVar;
    }

    public static int d(h hVar) {
        return hVar.d().bitLength();
    }

    public h c() {
        return this.f42393c;
    }
}
