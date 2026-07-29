package fp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.e2;
import np.f2;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class l0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static BigInteger f28664c = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static BigInteger f28665d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e2 f28666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f28667b;

    public BigInteger a() {
        e2 e2Var = this.f28666a;
        if (e2Var == null) {
            throw new IllegalStateException("generator not initialised");
        }
        BigInteger bigIntegerE = e2Var.e();
        int iBitLength = bigIntegerE.bitLength() - 1;
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(iBitLength, this.f28667b);
            BigInteger bigIntegerGcd = bigIntegerF.gcd(bigIntegerE);
            if (!bigIntegerF.equals(f28664c) && !bigIntegerF.equals(f28665d) && bigIntegerGcd.equals(f28665d)) {
                return bigIntegerF;
            }
        }
    }

    public void b(org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f28666a = (e2) w1Var.a();
            secureRandomF = w1Var.b();
        } else {
            this.f28666a = (e2) kVar;
            secureRandomF = org.bouncycastle.crypto.n.f();
        }
        this.f28667b = secureRandomF;
        if (this.f28666a instanceof f2) {
            throw new IllegalArgumentException("generator requires RSA public key");
        }
    }
}
