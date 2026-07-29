package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class o implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f42489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f42490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f42491c;

    public o(r rVar, r rVar2) {
        this(rVar, rVar2, null);
    }

    public o(r rVar, r rVar2, s sVar) {
        Objects.requireNonNull(rVar, "staticPrivateKey cannot be null");
        Objects.requireNonNull(rVar2, "ephemeralPrivateKey cannot be null");
        q qVarD = rVar.d();
        if (!qVarD.equals(rVar2.d())) {
            throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
        }
        if (sVar == null) {
            sVar = new s(qVarD.b().multiply(rVar2.e()), qVarD);
        } else if (!qVarD.equals(sVar.d())) {
            throw new IllegalArgumentException("Ephemeral public key has different domain parameters");
        }
        this.f42489a = rVar;
        this.f42490b = rVar2;
        this.f42491c = sVar;
    }

    public r a() {
        return this.f42490b;
    }

    public s b() {
        return this.f42491c;
    }

    public r c() {
        return this.f42489a;
    }
}
