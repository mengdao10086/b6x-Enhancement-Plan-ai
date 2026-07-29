package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class t implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f42540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f42541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f42542c;

    public t(r rVar, r rVar2) {
        this(rVar, rVar2, null);
    }

    public t(r rVar, r rVar2, s sVar) {
        Objects.requireNonNull(rVar, "staticPrivateKey cannot be null");
        Objects.requireNonNull(rVar2, "ephemeralPrivateKey cannot be null");
        q qVarD = rVar.d();
        if (!qVarD.equals(rVar2.d())) {
            throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
        }
        if (sVar == null) {
            sVar = new s(qVarD.b().modPow(rVar2.e(), qVarD.f()), qVarD);
        } else if (!qVarD.equals(sVar.d())) {
            throw new IllegalArgumentException("ephemeral public key has different domain parameters");
        }
        this.f42540a = rVar;
        this.f42541b = rVar2;
        this.f42542c = sVar;
    }

    public r a() {
        return this.f42541b;
    }

    public s b() {
        return this.f42542c;
    }

    public r c() {
        return this.f42540a;
    }
}
