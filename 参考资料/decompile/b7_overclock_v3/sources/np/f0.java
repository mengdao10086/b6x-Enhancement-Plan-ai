package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class f0 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f42394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m0 f42395b;

    public f0(m0 m0Var, m0 m0Var2) {
        Objects.requireNonNull(m0Var, "staticPublicKey cannot be null");
        Objects.requireNonNull(m0Var2, "ephemeralPublicKey cannot be null");
        if (!m0Var.d().equals(m0Var2.d())) {
            throw new IllegalArgumentException("static and ephemeral public keys have different domain parameters");
        }
        this.f42394a = m0Var;
        this.f42395b = m0Var2;
    }

    public m0 a() {
        return this.f42395b;
    }

    public m0 b() {
        return this.f42394a;
    }
}
