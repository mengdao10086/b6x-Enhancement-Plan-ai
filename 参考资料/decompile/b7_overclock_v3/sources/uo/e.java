package uo;

import java.math.BigInteger;
import np.g0;
import np.l0;
import np.m0;

/* JADX INFO: loaded from: classes5.dex */
public class e implements org.bouncycastle.crypto.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f52362a;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52362a = (l0) kVar;
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52362a.d().a().v() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        m0 m0Var = (m0) kVar;
        g0 g0VarD = this.f52362a.d();
        if (!g0VarD.equals(m0Var.d())) {
            throw new IllegalStateException("ECDH public key has wrong domain parameters");
        }
        BigInteger bigIntegerE = this.f52362a.e();
        ir.i iVarA = ir.c.a(g0VarD.a(), m0Var.e());
        if (iVarA.v()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDH");
        }
        BigInteger bigIntegerC = g0VarD.c();
        if (!bigIntegerC.equals(ir.d.f35647b)) {
            bigIntegerE = g0VarD.d().multiply(bigIntegerE).mod(g0VarD.e());
            iVarA = ir.c.s(iVarA, bigIntegerC);
        }
        ir.i iVarB = iVarA.z(bigIntegerE).B();
        if (iVarB.v()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
        }
        return iVarB.f().v();
    }
}
