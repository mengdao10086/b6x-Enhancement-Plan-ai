package uo;

import java.math.BigInteger;
import np.q;
import np.r;
import np.s;
import np.w1;

/* JADX INFO: loaded from: classes5.dex */
public class b implements org.bouncycastle.crypto.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f52332c = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f52333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f52334b;

    @Override // org.bouncycastle.crypto.e
    public void a(org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        np.c cVar = (np.c) kVar;
        if (!(cVar instanceof r)) {
            throw new IllegalArgumentException("DHEngine expects DHPrivateKeyParameters");
        }
        r rVar = (r) cVar;
        this.f52333a = rVar;
        this.f52334b = rVar.d();
    }

    @Override // org.bouncycastle.crypto.e
    public int b() {
        return (this.f52333a.d().f().bitLength() + 7) / 8;
    }

    @Override // org.bouncycastle.crypto.e
    public BigInteger c(org.bouncycastle.crypto.k kVar) {
        s sVar = (s) kVar;
        if (!sVar.d().equals(this.f52334b)) {
            throw new IllegalArgumentException("Diffie-Hellman public key has wrong parameters.");
        }
        BigInteger bigIntegerF = this.f52334b.f();
        BigInteger bigIntegerE = sVar.e();
        if (bigIntegerE != null) {
            BigInteger bigInteger = f52332c;
            if (bigIntegerE.compareTo(bigInteger) > 0 && bigIntegerE.compareTo(bigIntegerF.subtract(bigInteger)) < 0) {
                BigInteger bigIntegerModPow = bigIntegerE.modPow(this.f52333a.e(), bigIntegerF);
                if (bigIntegerModPow.equals(bigInteger)) {
                    throw new IllegalStateException("Shared key can't be 1");
                }
                return bigIntegerModPow;
            }
        }
        throw new IllegalArgumentException("Diffie-Hellman public key is weak");
    }
}
