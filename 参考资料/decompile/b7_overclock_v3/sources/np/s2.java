package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class s2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f42538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f42539b;

    public s2(c cVar, c cVar2) {
        Objects.requireNonNull(cVar, "staticPublicKey cannot be null");
        if (!(cVar instanceof q2) && !(cVar instanceof n2)) {
            throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
        }
        Objects.requireNonNull(cVar2, "ephemeralPublicKey cannot be null");
        if (!cVar.getClass().isAssignableFrom(cVar2.getClass())) {
            throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
        }
        this.f42538a = cVar;
        this.f42539b = cVar2;
    }

    public c a() {
        return this.f42539b;
    }

    public c b() {
        return this.f42538a;
    }
}
