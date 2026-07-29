package hp;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.e2;
import np.m1;
import np.n1;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.q;
import org.bouncycastle.crypto.w;

/* JADX INFO: loaded from: classes5.dex */
public class b implements w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f31393d = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f31394e = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f31395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f31396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e2 f31397c;

    public b(q qVar, SecureRandom secureRandom) {
        this.f31395a = qVar;
        this.f31396b = secureRandom;
    }

    @Override // org.bouncycastle.crypto.w
    public void a(k kVar) throws IllegalArgumentException {
        if (!(kVar instanceof e2)) {
            throw new IllegalArgumentException("RSA key required");
        }
        this.f31397c = (e2) kVar;
    }

    @Override // org.bouncycastle.crypto.w
    public k b(byte[] bArr, int i10, int i11) throws IllegalArgumentException {
        if (this.f31397c.c()) {
            throw new IllegalArgumentException("Public key required for encryption");
        }
        BigInteger bigIntegerE = this.f31397c.e();
        BigInteger bigIntegerD = this.f31397c.d();
        BigInteger bigIntegerG = org.bouncycastle.util.b.g(f31393d, bigIntegerE.subtract(f31394e), this.f31396b);
        byte[] bArrB = org.bouncycastle.util.b.b((bigIntegerE.bitLength() + 7) / 8, bigIntegerG.modPow(bigIntegerD, bigIntegerE));
        System.arraycopy(bArrB, 0, bArr, i10, bArrB.length);
        return f(bigIntegerE, bigIntegerG, i11);
    }

    @Override // org.bouncycastle.crypto.w
    public k c(byte[] bArr, int i10, int i11, int i12) throws IllegalArgumentException {
        if (!this.f31397c.c()) {
            throw new IllegalArgumentException("Private key required for decryption");
        }
        BigInteger bigIntegerE = this.f31397c.e();
        BigInteger bigIntegerD = this.f31397c.d();
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return f(bigIntegerE, new BigInteger(1, bArr2).modPow(bigIntegerD, bigIntegerE), i12);
    }

    public k d(byte[] bArr, int i10) {
        return c(bArr, 0, bArr.length, i10);
    }

    public k e(byte[] bArr, int i10) {
        return b(bArr, 0, i10);
    }

    public n1 f(BigInteger bigInteger, BigInteger bigInteger2, int i10) {
        this.f31395a.a(new m1(org.bouncycastle.util.b.b((bigInteger.bitLength() + 7) / 8, bigInteger2), null));
        byte[] bArr = new byte[i10];
        this.f31395a.b(bArr, 0, i10);
        return new n1(bArr);
    }
}
