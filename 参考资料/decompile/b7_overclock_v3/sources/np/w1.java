package np;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class w1 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f42560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public org.bouncycastle.crypto.k f42561b;

    public w1(org.bouncycastle.crypto.k kVar) {
        this(kVar, null);
    }

    public w1(org.bouncycastle.crypto.k kVar, SecureRandom secureRandom) {
        this.f42560a = org.bouncycastle.crypto.n.g(secureRandom);
        this.f42561b = kVar;
    }

    public org.bouncycastle.crypto.k a() {
        return this.f42561b;
    }

    public SecureRandom b() {
        return this.f42560a;
    }
}
