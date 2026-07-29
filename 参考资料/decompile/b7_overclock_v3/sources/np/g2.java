package np;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class g2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f42416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l0 f42417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ir.i f42418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l0 f42419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ir.i f42420e;

    public g2(boolean z10, l0 l0Var, l0 l0Var2) {
        Objects.requireNonNull(l0Var, "staticPrivateKey cannot be null");
        Objects.requireNonNull(l0Var2, "ephemeralPrivateKey cannot be null");
        g0 g0VarD = l0Var.d();
        if (!g0VarD.equals(l0Var2.d())) {
            throw new IllegalArgumentException("Static and ephemeral private keys have different domain parameters");
        }
        ir.k kVar = new ir.k();
        this.f42416a = z10;
        this.f42417b = l0Var;
        this.f42418c = kVar.a(g0VarD.b(), l0Var.e()).B();
        this.f42419d = l0Var2;
        this.f42420e = kVar.a(g0VarD.b(), l0Var2.e()).B();
    }

    public l0 a() {
        return this.f42419d;
    }

    public ir.i b() {
        return this.f42420e;
    }

    public l0 c() {
        return this.f42417b;
    }

    public ir.i d() {
        return this.f42418c;
    }

    public boolean e() {
        return this.f42416a;
    }
}
