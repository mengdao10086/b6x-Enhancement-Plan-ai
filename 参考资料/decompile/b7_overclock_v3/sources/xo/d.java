package xo;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static BigInteger f55711a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BigInteger f55712b = BigInteger.valueOf(1);

    public static BigInteger a(s sVar, BigInteger bigInteger, BigInteger bigInteger2) {
        return i(sVar, bigInteger, bigInteger, bigInteger2);
    }

    public static BigInteger b(s sVar, BigInteger bigInteger, BigInteger bigInteger2) {
        byte[] bArrH = h(bigInteger2, (bigInteger.bitLength() + 7) / 8);
        sVar.update(bArrH, 0, bArrH.length);
        byte[] bArr = new byte[sVar.h()];
        sVar.c(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger c(s sVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return j(sVar, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger d(s sVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return j(sVar, bigInteger, bigInteger2, bigInteger3, bigInteger4);
    }

    public static BigInteger e(s sVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return i(sVar, bigInteger, bigInteger2, bigInteger3);
    }

    public static BigInteger f(s sVar, BigInteger bigInteger, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int iH = sVar.h();
        byte[] bArr4 = new byte[iH];
        sVar.update(bArr2, 0, bArr2.length);
        sVar.update((byte) 58);
        sVar.update(bArr3, 0, bArr3.length);
        sVar.c(bArr4, 0);
        sVar.update(bArr, 0, bArr.length);
        sVar.update(bArr4, 0, iH);
        sVar.c(bArr4, 0);
        return new BigInteger(1, bArr4);
    }

    public static BigInteger g(s sVar, BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        return org.bouncycastle.util.b.g(f55712b.shiftLeft(Math.min(256, bigInteger.bitLength() / 2) - 1), bigInteger.subtract(f55712b), secureRandom);
    }

    public static byte[] h(BigInteger bigInteger, int i10) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        if (bArrC.length >= i10) {
            return bArrC;
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(bArrC, 0, bArr, i10 - bArrC.length, bArrC.length);
        return bArr;
    }

    public static BigInteger i(s sVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int iBitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] bArrH = h(bigInteger2, iBitLength);
        byte[] bArrH2 = h(bigInteger3, iBitLength);
        sVar.update(bArrH, 0, bArrH.length);
        sVar.update(bArrH2, 0, bArrH2.length);
        byte[] bArr = new byte[sVar.h()];
        sVar.c(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger j(s sVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        int iBitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] bArrH = h(bigInteger2, iBitLength);
        byte[] bArrH2 = h(bigInteger3, iBitLength);
        byte[] bArrH3 = h(bigInteger4, iBitLength);
        sVar.update(bArrH, 0, bArrH.length);
        sVar.update(bArrH2, 0, bArrH2.length);
        sVar.update(bArrH3, 0, bArrH3.length);
        byte[] bArr = new byte[sVar.h()];
        sVar.c(bArr, 0);
        return new BigInteger(1, bArr);
    }

    public static BigInteger k(BigInteger bigInteger, BigInteger bigInteger2) throws CryptoException {
        BigInteger bigIntegerMod = bigInteger2.mod(bigInteger);
        if (bigIntegerMod.equals(f55711a)) {
            throw new CryptoException("Invalid public value: 0");
        }
        return bigIntegerMod;
    }
}
