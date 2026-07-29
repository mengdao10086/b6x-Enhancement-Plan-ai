package uo;

import java.math.BigInteger;
import np.g0;
import np.l0;
import np.m0;

/* JADX INFO: loaded from: classes5.dex */
public class f implements org.bouncycastle.crypto.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f52363a;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52363a = (l0) kVar;
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52363a.d().a().v() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        m0 m0Var = (m0) kVar;
        g0 g0VarD = this.f52363a.d();
        if (!g0VarD.equals(m0Var.d())) {
            throw new IllegalStateException("ECDHC public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = g0VarD.c().multiply(this.f52363a.e()).mod(g0VarD.e());
        ir.i iVarA = ir.c.a(g0VarD.a(), m0Var.e());
        if (iVarA.v()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        ir.i iVarB = iVarA.z(bigIntegerMod).B();
        if (iVarB.v()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        return iVarB.f().v();
    }
}
