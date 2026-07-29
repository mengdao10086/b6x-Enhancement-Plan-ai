package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class p implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f42497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f42498b;

    public p(s sVar, s sVar2) {
        Objects.requireNonNull(sVar, "staticPublicKey cannot be null");
        Objects.requireNonNull(sVar2, "ephemeralPublicKey cannot be null");
        if (!sVar.d().equals(sVar2.d())) {
            throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
        }
        this.f42497a = sVar;
        this.f42498b = sVar2;
    }

    public s a() {
        return this.f42498b;
    }

    public s b() {
        return this.f42497a;
    }
}
