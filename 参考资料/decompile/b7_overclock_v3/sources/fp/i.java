package fp;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f28649a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f28650b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f28651c = BigInteger.valueOf(2);

    public BigInteger a(np.q qVar, SecureRandom secureRandom) {
        BigInteger bigIntegerG;
        BigInteger bit;
        int iD = qVar.d();
        if (iD != 0) {
            int i10 = iD >>> 2;
            do {
                bit = org.bouncycastle.util.b.f(iD, secureRandom).setBit(iD - 1);
            } while (ir.b0.i(bit) < i10);
            return bit;
        }
        BigInteger bigInteger = f28651c;
        int iE = qVar.e();
        BigInteger bigIntegerShiftLeft = iE != 0 ? f28650b.shiftLeft(iE - 1) : bigInteger;
        BigInteger bigIntegerG2 = qVar.g();
        if (bigIntegerG2 == null) {
            bigIntegerG2 = qVar.f();
        }
        BigInteger bigIntegerSubtract = bigIntegerG2.subtract(bigInteger);
        int iBitLength = bigIntegerSubtract.bitLength() >>> 2;
        do {
            bigIntegerG = org.bouncycastle.util.b.g(bigIntegerShiftLeft, bigIntegerSubtract, secureRandom);
        } while (ir.b0.i(bigIntegerG) < iBitLength);
        return bigIntegerG;
    }

    public BigInteger b(np.q qVar, BigInteger bigInteger) {
        return qVar.b().modPow(bigInteger, qVar.f());
    }
}
