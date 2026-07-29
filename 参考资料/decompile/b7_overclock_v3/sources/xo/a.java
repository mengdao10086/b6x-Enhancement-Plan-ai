package xo;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.i2;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f55664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f55665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f55666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f55667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f55668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f55669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f55670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f55671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BigInteger f55672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BigInteger f55673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BigInteger f55674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f55675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SecureRandom f55676m;

    public BigInteger a() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f55667d;
        if (bigInteger3 == null || (bigInteger = this.f55668e) == null || (bigInteger2 = this.f55671h) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger bigIntegerC = d.c(this.f55675l, this.f55664a, bigInteger3, bigInteger, bigInteger2);
        this.f55672i = bigIntegerC;
        return bigIntegerC;
    }

    public final BigInteger b() {
        BigInteger bigIntegerA = d.a(this.f55675l, this.f55664a, this.f55665b);
        return this.f55668e.subtract(this.f55665b.modPow(this.f55669f, this.f55664a).multiply(bigIntegerA).mod(this.f55664a)).mod(this.f55664a).modPow(this.f55670g.multiply(this.f55669f).add(this.f55666c), this.f55664a);
    }

    public BigInteger c(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerK = d.k(this.f55664a, bigInteger);
        this.f55668e = bigIntegerK;
        this.f55670g = d.e(this.f55675l, this.f55664a, this.f55667d, bigIntegerK);
        BigInteger bigIntegerB = b();
        this.f55671h = bigIntegerB;
        return bigIntegerB;
    }

    public BigInteger d() throws CryptoException {
        BigInteger bigInteger = this.f55671h;
        if (bigInteger == null || this.f55672i == null || this.f55673j == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerB = d.b(this.f55675l, this.f55664a, bigInteger);
        this.f55674k = bigIntegerB;
        return bigIntegerB;
    }

    public BigInteger e(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f55669f = d.f(this.f55675l, this.f55664a, bArr, bArr2, bArr3);
        BigInteger bigIntegerH = h();
        this.f55666c = bigIntegerH;
        BigInteger bigIntegerModPow = this.f55665b.modPow(bigIntegerH, this.f55664a);
        this.f55667d = bigIntegerModPow;
        return bigIntegerModPow;
    }

    public void f(BigInteger bigInteger, BigInteger bigInteger2, s sVar, SecureRandom secureRandom) {
        this.f55664a = bigInteger;
        this.f55665b = bigInteger2;
        this.f55675l = sVar;
        this.f55676m = secureRandom;
    }

    public void g(i2 i2Var, s sVar, SecureRandom secureRandom) {
        f(i2Var.b(), i2Var.a(), sVar, secureRandom);
    }

    public BigInteger h() {
        return d.g(this.f55675l, this.f55664a, this.f55665b, this.f55676m);
    }

    public boolean i(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f55667d;
        if (bigInteger4 == null || (bigInteger2 = this.f55672i) == null || (bigInteger3 = this.f55671h) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        }
        if (!d.d(this.f55675l, this.f55664a, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f55673j = bigInteger;
        return true;
    }
}
