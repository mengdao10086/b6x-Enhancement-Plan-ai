package uo;

import java.math.BigInteger;
import np.p;
import np.q;
import np.r;
import np.s;

/* JADX INFO: loaded from: classes5.dex */
public class k implements org.bouncycastle.crypto.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f52370b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public np.o f52371a;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        this.f52371a = (np.o) kVar;
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52371a.c().d().f().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        p pVar = (p) kVar;
        r rVarC = this.f52371a.c();
        if (!this.f52371a.c().d().equals(pVar.b().d())) {
            throw new IllegalStateException("MQV public key components have wrong domain parameters");
        }
        if (this.f52371a.c().d().g() == null) {
            throw new IllegalStateException("MQV key domain parameters do not have Q set");
        }
        BigInteger bigIntegerE = e(rVarC.d(), rVarC, pVar.b(), this.f52371a.a(), this.f52371a.b(), pVar.a());
        if (bigIntegerE.equals(f52370b)) {
            throw new IllegalStateException("1 is not a valid agreement value for MQV");
        }
        return bigIntegerE;
    }

    public final BigInteger e(q qVar, r rVar, s sVar, r rVar2, s sVar2, s sVar3) {
        BigInteger bigIntegerG = qVar.g();
        BigInteger bigIntegerPow = BigInteger.valueOf(2L).pow((bigIntegerG.bitLength() + 1) / 2);
        return sVar3.e().multiply(sVar.e().modPow(sVar3.e().mod(bigIntegerPow).add(bigIntegerPow), qVar.f())).modPow(rVar2.e().add(sVar2.e().mod(bigIntegerPow).add(bigIntegerPow).multiply(rVar.e())).mod(bigIntegerG), qVar.f());
    }
}
