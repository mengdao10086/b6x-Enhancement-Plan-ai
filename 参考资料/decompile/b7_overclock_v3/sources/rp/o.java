package rp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.a1;
import np.b1;
import np.c1;
import np.d1;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class o implements org.bouncycastle.crypto.p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a1 f49025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f49026h;

    @Override // org.bouncycastle.crypto.o
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        a1 a1Var;
        if (!z10) {
            a1Var = (d1) kVar;
        } else {
            if (kVar instanceof w1) {
                w1 w1Var = (w1) kVar;
                this.f49026h = w1Var.b();
                this.f49025g = (c1) w1Var.a();
                return;
            }
            this.f49026h = org.bouncycastle.crypto.n.f();
            a1Var = (c1) kVar;
        }
        this.f49025g = a1Var;
    }

    @Override // org.bouncycastle.crypto.o
    public BigInteger[] b(byte[] bArr) {
        BigInteger bigIntegerF;
        BigInteger bigInteger = new BigInteger(1, org.bouncycastle.util.a.L0(bArr));
        b1 b1VarD = this.f49025g.d();
        do {
            bigIntegerF = org.bouncycastle.util.b.f(b1VarD.c().bitLength(), this.f49026h);
        } while (bigIntegerF.compareTo(b1VarD.c()) >= 0);
        BigInteger bigIntegerMod = b1VarD.a().modPow(bigIntegerF, b1VarD.b()).mod(b1VarD.c());
        return new BigInteger[]{bigIntegerMod, bigIntegerF.multiply(bigInteger).add(((c1) this.f49025g).e().multiply(bigIntegerMod)).mod(b1VarD.c())};
    }

    @Override // org.bouncycastle.crypto.o
    public boolean c(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, org.bouncycastle.util.a.L0(bArr));
        b1 b1VarD = this.f49025g.d();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (bigIntegerValueOf.compareTo(bigInteger) >= 0 || b1VarD.c().compareTo(bigInteger) <= 0 || bigIntegerValueOf.compareTo(bigInteger2) >= 0 || b1VarD.c().compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigIntegerModPow = bigInteger3.modPow(b1VarD.c().subtract(new BigInteger("2")), b1VarD.c());
        return b1VarD.a().modPow(bigInteger2.multiply(bigIntegerModPow).mod(b1VarD.c()), b1VarD.b()).multiply(((d1) this.f49025g).e().modPow(b1VarD.c().subtract(bigInteger).multiply(bigIntegerModPow).mod(b1VarD.c()), b1VarD.b())).mod(b1VarD.b()).mod(b1VarD.c()).equals(bigInteger);
    }

    @Override // org.bouncycastle.crypto.p
    public BigInteger getOrder() {
        return this.f49025g.d().c();
    }
}
