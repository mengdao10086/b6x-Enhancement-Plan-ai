package xo;

import java.math.BigInteger;
import java.security.SecureRandom;
import np.i2;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f55677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f55678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f55679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SecureRandom f55680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f55681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f55682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f55683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BigInteger f55684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BigInteger f55685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BigInteger f55686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BigInteger f55687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public BigInteger f55688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BigInteger f55689m;

    public final BigInteger a() {
        return this.f55679c.modPow(this.f55685i, this.f55677a).multiply(this.f55682f).mod(this.f55677a).modPow(this.f55683g, this.f55677a);
    }

    public BigInteger b(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerK = d.k(this.f55677a, bigInteger);
        this.f55682f = bigIntegerK;
        this.f55685i = d.e(this.f55681e, this.f55677a, bigIntegerK, this.f55684h);
        BigInteger bigIntegerA = a();
        this.f55686j = bigIntegerA;
        return bigIntegerA;
    }

    public BigInteger c() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f55682f;
        if (bigInteger3 == null || (bigInteger = this.f55687k) == null || (bigInteger2 = this.f55686j) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger bigIntegerD = d.d(this.f55681e, this.f55677a, bigInteger3, bigInteger, bigInteger2);
        this.f55688l = bigIntegerD;
        return bigIntegerD;
    }

    public BigInteger d() throws CryptoException {
        BigInteger bigInteger = this.f55686j;
        if (bigInteger == null || this.f55687k == null || this.f55688l == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerB = d.b(this.f55681e, this.f55677a, bigInteger);
        this.f55689m = bigIntegerB;
        return bigIntegerB;
    }

    public BigInteger e() {
        BigInteger bigIntegerA = d.a(this.f55681e, this.f55677a, this.f55678b);
        this.f55683g = h();
        BigInteger bigIntegerMod = bigIntegerA.multiply(this.f55679c).mod(this.f55677a).add(this.f55678b.modPow(this.f55683g, this.f55677a)).mod(this.f55677a);
        this.f55684h = bigIntegerMod;
        return bigIntegerMod;
    }

    public void f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, s sVar, SecureRandom secureRandom) {
        this.f55677a = bigInteger;
        this.f55678b = bigInteger2;
        this.f55679c = bigInteger3;
        this.f55680d = secureRandom;
        this.f55681e = sVar;
    }

    public void g(i2 i2Var, BigInteger bigInteger, s sVar, SecureRandom secureRandom) {
        f(i2Var.b(), i2Var.a(), bigInteger, sVar, secureRandom);
    }

    public BigInteger h() {
        return d.g(this.f55681e, this.f55677a, this.f55678b, this.f55680d);
    }

    public boolean i(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f55682f;
        if (bigInteger4 == null || (bigInteger2 = this.f55684h) == null || (bigInteger3 = this.f55686j) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        }
        if (!d.c(this.f55681e, this.f55677a, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f55687k = bigInteger;
        return true;
    }
}
