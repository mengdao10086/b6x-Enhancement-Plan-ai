package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f28662a = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f28663b = BigInteger.valueOf(2);

    public static BigInteger[] a(int i10, int i11, SecureRandom secureRandom) {
        int i12 = i10 - 1;
        int i13 = i10 >>> 2;
        while (true) {
            BigInteger bigIntegerH = org.bouncycastle.util.b.h(i12, 2, secureRandom);
            BigInteger bigIntegerAdd = bigIntegerH.shiftLeft(1).add(f28662a);
            if (bigIntegerAdd.isProbablePrime(i11) && (i11 <= 2 || bigIntegerH.isProbablePrime(i11 - 2))) {
                if (ir.b0.i(bigIntegerAdd) >= i13) {
                    return new BigInteger[]{bigIntegerAdd, bigIntegerH};
                }
            }
        }
    }

    public static BigInteger b(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerSubtract = bigInteger.subtract(f28663b);
        do {
            BigInteger bigInteger3 = f28663b;
            bigIntegerModPow = org.bouncycastle.util.b.g(bigInteger3, bigIntegerSubtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (bigIntegerModPow.equals(f28662a));
        return bigIntegerModPow;
    }
}
