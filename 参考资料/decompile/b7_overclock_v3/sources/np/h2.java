package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class h2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m0 f42429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m0 f42430b;

    public h2(m0 m0Var, m0 m0Var2) {
        Objects.requireNonNull(m0Var, "staticPublicKey cannot be null");
        Objects.requireNonNull(m0Var2, "ephemeralPublicKey cannot be null");
        if (!m0Var.d().equals(m0Var2.d())) {
            throw new IllegalArgumentException("Static and ephemeral public keys have different domain parameters");
        }
        this.f42429a = m0Var;
        this.f42430b = m0Var2;
    }

    public m0 a() {
        return this.f42430b;
    }

    public m0 b() {
        return this.f42429a;
    }
}
