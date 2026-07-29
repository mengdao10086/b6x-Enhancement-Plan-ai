package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class e0 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f42382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l0 f42383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m0 f42384c;

    public e0(l0 l0Var, l0 l0Var2) {
        this(l0Var, l0Var2, null);
    }

    public e0(l0 l0Var, l0 l0Var2, m0 m0Var) {
        Objects.requireNonNull(l0Var, "staticPrivateKey cannot be null");
        Objects.requireNonNull(l0Var2, "ephemeralPrivateKey cannot be null");
        g0 g0VarD = l0Var.d();
        if (!g0VarD.equals(l0Var2.d())) {
            throw new IllegalArgumentException("static and ephemeral private keys have different domain parameters");
        }
        if (m0Var == null) {
            m0Var = new m0(new ir.k().a(g0VarD.b(), l0Var2.e()), g0VarD);
        } else if (!g0VarD.equals(m0Var.d())) {
            throw new IllegalArgumentException("ephemeral public key has different domain parameters");
        }
        this.f42382a = l0Var;
        this.f42383b = l0Var2;
        this.f42384c = m0Var;
    }

    public l0 a() {
        return this.f42383b;
    }

    public m0 b() {
        return this.f42384c;
    }

    public l0 c() {
        return this.f42382a;
    }
}
