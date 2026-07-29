package cp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.e2;
import np.f2;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class x0 implements org.bouncycastle.crypto.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f25733d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z0 f25734a = new z0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e2 f25735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f25736c;

    @Override // org.bouncycastle.crypto.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        SecureRandom secureRandomF;
        this.f25734a.e(z10, kVar);
        if (!(kVar instanceof w1)) {
            e2 e2Var = (e2) kVar;
            this.f25735b = e2Var;
            if (e2Var instanceof f2) {
                secureRandomF = org.bouncycastle.crypto.n.f();
                this.f25736c = secureRandomF;
                return;
            }
            this.f25736c = null;
        }
        w1 w1Var = (w1) kVar;
        e2 e2Var2 = (e2) w1Var.a();
        this.f25735b = e2Var2;
        if (e2Var2 instanceof f2) {
            secureRandomF = w1Var.b();
            this.f25736c = secureRandomF;
            return;
        }
        this.f25736c = null;
    }

    @Override // org.bouncycastle.crypto.b
    public int b() {
        return this.f25734a.c();
    }

    @Override // org.bouncycastle.crypto.b
    public byte[] c(byte[] bArr, int i10, int i11) {
        BigInteger bigIntegerF;
        f2 f2Var;
        BigInteger bigIntegerJ;
        if (this.f25735b == null) {
            throw new IllegalStateException("RSA engine not initialised");
        }
        BigInteger bigIntegerA = this.f25734a.a(bArr, i10, i11);
        e2 e2Var = this.f25735b;
        if (!(e2Var instanceof f2) || (bigIntegerJ = (f2Var = (f2) e2Var).j()) == null) {
            bigIntegerF = this.f25734a.f(bigIntegerA);
        } else {
            BigInteger bigIntegerE = f2Var.e();
            BigInteger bigInteger = f25733d;
            BigInteger bigIntegerG = org.bouncycastle.util.b.g(bigInteger, bigIntegerE.subtract(bigInteger), this.f25736c);
            bigIntegerF = this.f25734a.f(bigIntegerG.modPow(bigIntegerJ, bigIntegerE).multiply(bigIntegerA).mod(bigIntegerE)).multiply(org.bouncycastle.util.b.n(bigIntegerE, bigIntegerG)).mod(bigIntegerE);
            if (!bigIntegerA.equals(bigIntegerF.modPow(bigIntegerJ, bigIntegerE))) {
                throw new IllegalStateException("RSA engine faulty decryption/signing detected");
            }
        }
        return this.f25734a.b(bigIntegerF);
    }

    @Override // org.bouncycastle.crypto.b
    public int d() {
        return this.f25734a.d();
    }
}
