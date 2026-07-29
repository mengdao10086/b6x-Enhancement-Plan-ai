package uo;

import java.math.BigInteger;
import np.g0;
import np.l0;
import np.m0;
import org.bouncycastle.crypto.i0;

/* JADX INFO: loaded from: classes5.dex */
public class g implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l0 f52364a;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52364a = (l0) kVar;
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52364a.d().a().v() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        return e((m0) kVar).f().v();
    }

    @Override // org.bouncycastle.crypto.i0
    public np.c d(org.bouncycastle.crypto.k kVar) {
        return new m0(e((m0) kVar), this.f52364a.d());
    }

    public final ir.i e(m0 m0Var) {
        g0 g0VarD = this.f52364a.d();
        if (!g0VarD.equals(m0Var.d())) {
            throw new IllegalStateException("ECDHC public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = g0VarD.c().multiply(this.f52364a.e()).mod(g0VarD.e());
        ir.i iVarA = ir.c.a(g0VarD.a(), m0Var.e());
        if (iVarA.v()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDHC");
        }
        ir.i iVarB = iVarA.z(bigIntegerMod).B();
        if (iVarB.v()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDHC");
        }
        return iVarB;
    }
}
