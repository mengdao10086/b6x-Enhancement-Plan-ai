package ap;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class l {
    public static BigInteger a(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerF = org.bouncycastle.util.b.f(iBitLength, secureRandom);
            if (!bigIntegerF.equals(ir.d.f35646a) && bigIntegerF.compareTo(bigInteger) < 0) {
                return bigIntegerF;
            }
        }
    }
}
