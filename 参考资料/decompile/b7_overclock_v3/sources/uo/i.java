package uo;

import java.math.BigInteger;
import np.g0;
import np.l0;
import np.m0;
import np.p1;
import np.q1;
import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes5.dex */
public class i implements org.bouncycastle.crypto.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p1 f52366a;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52366a = (p1) kVar;
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52366a.c().d().a().v() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        if (p.d("org.bouncycastle.ec.disable_mqv")) {
            throw new IllegalStateException("ECMQV explicitly disabled");
        }
        q1 q1Var = (q1) kVar;
        l0 l0VarC = this.f52366a.c();
        g0 g0VarD = l0VarC.d();
        if (!g0VarD.equals(q1Var.b().d())) {
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        ir.i iVarB = e(g0VarD, l0VarC, this.f52366a.a(), this.f52366a.b(), q1Var.b(), q1Var.a()).B();
        if (iVarB.v()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        return iVarB.f().v();
    }

    public final ir.i e(g0 g0Var, l0 l0Var, l0 l0Var2, m0 m0Var, m0 m0Var2, m0 m0Var3) {
        BigInteger bigIntegerE = g0Var.e();
        int iBitLength = (bigIntegerE.bitLength() + 1) / 2;
        BigInteger bigIntegerShiftLeft = ir.d.f35647b.shiftLeft(iBitLength);
        ir.e eVarA = g0Var.a();
        ir.i iVarA = ir.c.a(eVarA, m0Var.e());
        ir.i iVarA2 = ir.c.a(eVarA, m0Var2.e());
        ir.i iVarA3 = ir.c.a(eVarA, m0Var3.e());
        BigInteger bigIntegerMod = l0Var.e().multiply(iVarA.f().v().mod(bigIntegerShiftLeft).setBit(iBitLength)).add(l0Var2.e()).mod(bigIntegerE);
        BigInteger bit = iVarA3.f().v().mod(bigIntegerShiftLeft).setBit(iBitLength);
        BigInteger bigIntegerMod2 = g0Var.c().multiply(bigIntegerMod).mod(bigIntegerE);
        return ir.c.v(iVarA2, bit.multiply(bigIntegerMod2).mod(bigIntegerE), iVarA3, bigIntegerMod2);
    }
}
