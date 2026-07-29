package uo;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.q;
import np.r;
import np.s;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f52327e = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f52328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f52329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f52330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f52331d;

    public BigInteger a(s sVar, BigInteger bigInteger) {
        if (!sVar.d().equals(this.f52329b)) {
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        }
        BigInteger bigIntegerF = this.f52329b.f();
        BigInteger bigIntegerE = sVar.e();
        if (bigIntegerE != null) {
            BigInteger bigInteger2 = f52327e;
            if (bigIntegerE.compareTo(bigInteger2) > 0 && bigIntegerE.compareTo(bigIntegerF.subtract(bigInteger2)) < 0) {
                BigInteger bigIntegerModPow = bigIntegerE.modPow(this.f52330c, bigIntegerF);
                if (bigIntegerModPow.equals(bigInteger2)) {
                    throw new IllegalStateException("Shared key can't be 1");
                }
                return bigInteger.modPow(this.f52328a.e(), bigIntegerF).multiply(bigIntegerModPow).mod(bigIntegerF);
            }
        }
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    }

    public BigInteger b() {
        fp.j jVar = new fp.j();
        jVar.a(new np.m(this.f52331d, this.f52329b));
        org.bouncycastle.crypto.c cVarB = jVar.b();
        this.f52330c = ((r) cVarB.a()).e();
        return ((s) cVarB.b()).e();
    }

    public void c(org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f52331d = w1Var.b();
            kVar = w1Var.a();
        } else {
            this.f52331d = org.bouncycastle.crypto.n.f();
        }
        np.c cVar = (np.c) kVar;
        if (!(cVar instanceof r)) {
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        }
        r rVar = (r) cVar;
        this.f52328a = rVar;
        this.f52329b = rVar.d();
    }
}
