package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class r2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f42527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f42528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f42529c;

    public r2(c cVar, c cVar2) {
        this(cVar, cVar2, null);
    }

    public r2(c cVar, c cVar2, c cVar3) {
        Objects.requireNonNull(cVar, "staticPrivateKey cannot be null");
        boolean z10 = cVar instanceof p2;
        if (!z10 && !(cVar instanceof m2)) {
            throw new IllegalArgumentException("only X25519 and X448 paramaters can be used");
        }
        Objects.requireNonNull(cVar2, "ephemeralPrivateKey cannot be null");
        if (!cVar.getClass().isAssignableFrom(cVar2.getClass())) {
            throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
        }
        if (cVar3 == null) {
            cVar3 = cVar2 instanceof p2 ? ((p2) cVar2).e() : ((m2) cVar2).e();
        } else {
            if ((cVar3 instanceof q2) && !z10) {
                throw new IllegalArgumentException("ephemeral public key has different domain parameters");
            }
            if ((cVar3 instanceof n2) && !(cVar instanceof m2)) {
                throw new IllegalArgumentException("ephemeral public key has different domain parameters");
            }
        }
        this.f42527a = cVar;
        this.f42528b = cVar2;
        this.f42529c = cVar3;
    }

    public c a() {
        return this.f42528b;
    }

    public c b() {
        return this.f42529c;
    }

    public c c() {
        return this.f42527a;
    }
}
