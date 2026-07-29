package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f28628d = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SecureRandom f28631c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final BigInteger f28632a = BigInteger.valueOf(2);

        public static BigInteger[] a(int i10, int i11, SecureRandom secureRandom) {
            BigInteger bigIntegerH;
            BigInteger bigIntegerAdd;
            int i12 = i10 - 1;
            while (true) {
                bigIntegerH = org.bouncycastle.util.b.h(i12, 2, secureRandom);
                bigIntegerAdd = bigIntegerH.shiftLeft(1).add(e.f28628d);
                if (bigIntegerAdd.isProbablePrime(i11) && (i11 <= 2 || bigIntegerH.isProbablePrime(i11))) {
                    break;
                }
            }
            return new BigInteger[]{bigIntegerAdd, bigIntegerH};
        }

        public static BigInteger b(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger bigIntegerModPow;
            BigInteger bigIntegerSubtract = bigInteger.subtract(f28632a);
            do {
                BigInteger bigInteger2 = f28632a;
                bigIntegerModPow = org.bouncycastle.util.b.g(bigInteger2, bigIntegerSubtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (bigIntegerModPow.equals(e.f28628d));
            return bigIntegerModPow;
        }
    }

    public np.h b() {
        BigInteger bigIntegerB;
        BigInteger bigInteger = a.a(this.f28629a, this.f28630b, this.f28631c)[1];
        BigInteger bigIntegerB2 = a.b(bigInteger, this.f28631c);
        do {
            bigIntegerB = a.b(bigInteger, this.f28631c);
        } while (bigIntegerB2.equals(bigIntegerB));
        return new np.h(bigInteger, bigIntegerB2, bigIntegerB, new zo.e0());
    }

    public np.h c(np.q qVar) {
        BigInteger bigIntegerB;
        BigInteger bigIntegerF = qVar.f();
        BigInteger bigIntegerB2 = qVar.b();
        do {
            bigIntegerB = a.b(bigIntegerF, this.f28631c);
        } while (bigIntegerB2.equals(bigIntegerB));
        return new np.h(bigIntegerF, bigIntegerB2, bigIntegerB, new zo.e0());
    }

    public void d(int i10, int i11, SecureRandom secureRandom) {
        this.f28629a = i10;
        this.f28630b = i11;
        this.f28631c = secureRandom;
    }
}
