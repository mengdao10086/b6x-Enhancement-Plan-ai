package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.j0;
import np.l0;
import np.m0;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class h implements org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j0 f48996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f48997h;

    @Override // org.bouncycastle.crypto.o
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        j0 j0Var;
        if (!z10) {
            j0Var = (m0) kVar;
        } else {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f48997h = w1Var.b();
                this.f48996g = (l0) w1Var.a();
                return;
            }
            this.f48997h = org.bouncycastle.crypto.n.f();
            j0Var = (l0) kVar;
        }
        this.f48996g = j0Var;
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, org.bouncycastle.util.a.L0(bArr));
        g0 g0VarD = this.f48996g.d();
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerE2 = ((l0) this.f48996g).e();
        ir.h hVarD = d();
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(bigIntegerE.bitLength(), this.f48997h);
            BigInteger bigInteger2 = ir.d.f35646a;
            if (!bigIntegerF.equals(bigInteger2)) {
                BigInteger bigIntegerMod = hVarD.a(g0VarD.b(), bigIntegerF).B().f().v().mod(bigIntegerE);
                if (bigIntegerMod.equals(bigInteger2)) {
                    continue;
                } else {
                    BigInteger bigIntegerMod2 = bigIntegerF.multiply(bigInteger).add(bigIntegerE2.multiply(bigIntegerMod)).mod(bigIntegerE);
                    if (!bigIntegerMod2.equals(bigInteger2)) {
                        return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                    }
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, org.bouncycastle.util.a.L0(bArr));
        BigInteger bigIntegerE = this.f48996g.d().e();
        BigInteger bigInteger4 = ir.d.f35647b;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(bigIntegerE) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(bigIntegerE) >= 0) {
            return false;
        }
        BigInteger bigIntegerO = org.bouncycastle.util.b.o(bigIntegerE, bigInteger3);
        ir.i iVarB = ir.c.v(this.f48996g.d().b(), bigInteger2.multiply(bigIntegerO).mod(bigIntegerE), ((m0) this.f48996g).e(), bigIntegerE.subtract(bigInteger).multiply(bigIntegerO).mod(bigIntegerE)).B();
        if (iVarB.v()) {
            return false;
        }
        return iVarB.f().v().mod(bigIntegerE).equals(bigInteger);
    }

    public ir.h d() {
        return new ir.k();
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f48996g.d().e();
    }
}
