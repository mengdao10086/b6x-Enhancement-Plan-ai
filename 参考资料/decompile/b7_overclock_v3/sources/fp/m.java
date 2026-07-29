package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class m implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f28668h = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public np.w f28669g;

    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    public static BigInteger d(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigIntegerG;
        int iBitLength = bigInteger.bitLength() >>> 2;
        do {
            BigInteger bigInteger2 = f28668h;
            bigIntegerG = org.bouncycastle.util.b.g(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
        } while (ir.b0.i(bigIntegerG) < iBitLength);
        return bigIntegerG;
    }

    @Override // org.bouncycastle.crypto.d
    public void a(org.bouncycastle.crypto.y yVar) {
        this.f28669g = (np.w) yVar;
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        np.z zVarC = this.f28669g.c();
        BigInteger bigIntegerD = d(zVarC.c(), this.f28669g.a());
        return new org.bouncycastle.crypto.c((np.c) new np.b0(c(zVarC.b(), zVarC.a(), bigIntegerD), zVarC), (np.c) new np.a0(bigIntegerD, zVarC));
    }
}
