package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class m extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f42478c;

    public m(SecureRandom secureRandom, q qVar) {
        super(secureRandom, d(qVar));
        this.f42478c = qVar;
    }

    public static int d(q qVar) {
        return qVar.d() != 0 ? qVar.d() : qVar.f().bitLength();
    }

    public q c() {
        return this.f42478c;
    }
}
