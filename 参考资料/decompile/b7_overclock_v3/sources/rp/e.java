package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.g0;
import np.j0;
import np.l0;
import np.m0;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class e implements org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f48988i = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j0 f48989g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f48990h;

    public static BigInteger e(BigInteger bigInteger, ir.f fVar) {
        return h(fVar.v(), bigInteger.bitLength() - 1);
    }

    public static BigInteger f(BigInteger bigInteger, SecureRandom secureRandom) {
        return org.bouncycastle.util.b.f(bigInteger.bitLength() - 1, secureRandom);
    }

    public static ir.f g(ir.e eVar, byte[] bArr) {
        return eVar.n(h(new BigInteger(1, org.bouncycastle.util.a.L0(bArr)), eVar.v()));
    }

    public static BigInteger h(BigInteger bigInteger, int i10) {
        return bigInteger.bitLength() > i10 ? bigInteger.mod(f48988i.shiftLeft(i10)) : bigInteger;
    }

    @Override // org.bouncycastle.crypto.o
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        j0 j0Var;
        if (z10) {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f48990h = w1Var.b();
                kVar = w1Var.a();
            } else {
                this.f48990h = org.bouncycastle.crypto.n.f();
            }
            j0Var = (l0) kVar;
        } else {
            j0Var = (m0) kVar;
        }
        this.f48989g = j0Var;
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        g0 g0VarD = this.f48989g.d();
        ir.e eVarA = g0VarD.a();
        ir.f fVarG = g(eVarA, bArr);
        if (fVarG.j()) {
            fVarG = eVarA.n(f48988i);
        }
        BigInteger bigIntegerE = g0VarD.e();
        BigInteger bigIntegerE2 = ((l0) this.f48989g).e();
        ir.h hVarD = d();
        while (true) {
            BigInteger bigIntegerF = f(bigIntegerE, this.f48990h);
            ir.f fVarF = hVarD.a(g0VarD.b(), bigIntegerF).B().f();
            if (!fVarF.j()) {
                BigInteger bigIntegerE3 = e(bigIntegerE, fVarG.k(fVarF));
                if (bigIntegerE3.signum() != 0) {
                    BigInteger bigIntegerMod = bigIntegerE3.multiply(bigIntegerE2).add(bigIntegerF).mod(bigIntegerE);
                    if (bigIntegerMod.signum() != 0) {
                        return new BigInteger[]{bigIntegerE3, bigIntegerMod};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger.signum() <= 0 || bigInteger2.signum() <= 0) {
            return false;
        }
        g0 g0VarD = this.f48989g.d();
        BigInteger bigIntegerE = g0VarD.e();
        if (bigInteger.compareTo(bigIntegerE) >= 0 || bigInteger2.compareTo(bigIntegerE) >= 0) {
            return false;
        }
        ir.e eVarA = g0VarD.a();
        ir.f fVarG = g(eVarA, bArr);
        if (fVarG.j()) {
            fVarG = eVarA.n(f48988i);
        }
        ir.i iVarB = ir.c.v(g0VarD.b(), bigInteger2, ((m0) this.f48989g).e(), bigInteger).B();
        return !iVarB.v() && e(bigIntegerE, fVarG.k(iVarB.f())).compareTo(bigInteger) == 0;
    }

    public ir.h d() {
        return new ir.k();
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f48989g.d().e();
    }
}
