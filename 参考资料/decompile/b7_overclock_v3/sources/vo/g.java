package vo;

import ip.k;
import java.math.BigInteger;
import java.security.SecureRandom;
import np.n1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.a0;
import org.bouncycastle.crypto.s;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f53333a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f53334b = BigInteger.valueOf(1);

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return bigInteger3.modPow(bigInteger4, bigInteger);
    }

    public static BigInteger b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        return bigInteger2.multiply(bigInteger3).multiply(bigInteger4).mod(bigInteger);
    }

    public static BigInteger c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.modPow(bigInteger3, bigInteger);
    }

    public static BigInteger d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, String str, s sVar) {
        sVar.reset();
        q(sVar, bigInteger);
        q(sVar, bigInteger2);
        q(sVar, bigInteger3);
        p(sVar, str);
        byte[] bArr = new byte[sVar.h()];
        sVar.c(bArr, 0);
        return new BigInteger(bArr);
    }

    public static BigInteger e(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6) {
        return bigInteger3.modPow(bigInteger4.multiply(bigInteger5).negate().mod(bigInteger2), bigInteger).multiply(bigInteger6).modPow(bigInteger4, bigInteger);
    }

    public static byte[] f(BigInteger bigInteger, s sVar) {
        sVar.reset();
        o(sVar, bigInteger);
        n(sVar, "JPAKE_KC");
        byte[] bArr = new byte[sVar.h()];
        sVar.c(bArr, 0);
        return bArr;
    }

    public static BigInteger g(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, s sVar) {
        byte[] bArrF = f(bigInteger5, sVar);
        k kVar = new k(sVar);
        byte[] bArr = new byte[kVar.d()];
        kVar.a(new n1(bArrF));
        r(kVar, "KC_1_U");
        r(kVar, str);
        r(kVar, str2);
        s(kVar, bigInteger);
        s(kVar, bigInteger2);
        s(kVar, bigInteger3);
        s(kVar, bigInteger4);
        kVar.c(bArr, 0);
        org.bouncycastle.util.a.d0(bArrF, (byte) 0);
        return new BigInteger(bArr);
    }

    public static BigInteger h(char[] cArr) {
        return new BigInteger(Strings.n(cArr));
    }

    public static BigInteger i(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger3).mod(bigInteger);
    }

    public static BigInteger[] j(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, String str, s sVar, SecureRandom secureRandom) {
        BigInteger bigIntegerG = org.bouncycastle.util.b.g(f53333a, bigInteger2.subtract(f53334b), secureRandom);
        BigInteger bigIntegerModPow = bigInteger3.modPow(bigIntegerG, bigInteger);
        return new BigInteger[]{bigIntegerModPow, bigIntegerG.subtract(bigInteger5.multiply(d(bigInteger3, bigIntegerModPow, bigInteger4, str, sVar))).mod(bigInteger2)};
    }

    public static BigInteger k(BigInteger bigInteger, SecureRandom secureRandom) {
        return org.bouncycastle.util.b.g(f53333a, bigInteger.subtract(f53334b), secureRandom);
    }

    public static BigInteger l(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = f53334b;
        return org.bouncycastle.util.b.g(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    public static byte[] m(int i10) {
        return new byte[]{(byte) (i10 >>> 24), (byte) (i10 >>> 16), (byte) (i10 >>> 8), (byte) i10};
    }

    public static void n(s sVar, String str) {
        byte[] bArrM = Strings.m(str);
        sVar.update(bArrM, 0, bArrM.length);
        org.bouncycastle.util.a.d0(bArrM, (byte) 0);
    }

    public static void o(s sVar, BigInteger bigInteger) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        sVar.update(bArrC, 0, bArrC.length);
        org.bouncycastle.util.a.d0(bArrC, (byte) 0);
    }

    public static void p(s sVar, String str) {
        byte[] bArrM = Strings.m(str);
        sVar.update(m(bArrM.length), 0, 4);
        sVar.update(bArrM, 0, bArrM.length);
        org.bouncycastle.util.a.d0(bArrM, (byte) 0);
    }

    public static void q(s sVar, BigInteger bigInteger) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        sVar.update(m(bArrC.length), 0, 4);
        sVar.update(bArrC, 0, bArrC.length);
        org.bouncycastle.util.a.d0(bArrC, (byte) 0);
    }

    public static void r(a0 a0Var, String str) {
        byte[] bArrM = Strings.m(str);
        a0Var.update(bArrM, 0, bArrM.length);
        org.bouncycastle.util.a.d0(bArrM, (byte) 0);
    }

    public static void s(a0 a0Var, BigInteger bigInteger) {
        byte[] bArrC = org.bouncycastle.util.b.c(bigInteger);
        a0Var.update(bArrC, 0, bArrC.length);
        org.bouncycastle.util.a.d0(bArrC, (byte) 0);
    }

    public static void t(BigInteger bigInteger) throws CryptoException {
        if (bigInteger.equals(f53334b)) {
            throw new CryptoException("ga is equal to 1.  It should not be.  The chances of this happening are on the order of 2^160 for a 160-bit q.  Try again.");
        }
    }

    public static void u(BigInteger bigInteger) throws CryptoException {
        if (bigInteger.equals(f53334b)) {
            throw new CryptoException("g^x validation failed.  g^x should not be 1.");
        }
    }

    public static void v(String str, String str2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, s sVar, BigInteger bigInteger6) throws CryptoException {
        if (!g(str2, str, bigInteger3, bigInteger4, bigInteger, bigInteger2, bigInteger5, sVar).equals(bigInteger6)) {
            throw new CryptoException("Partner MacTag validation failed. Therefore, the password, MAC, or digest algorithm of each participant does not match.");
        }
    }

    public static void w(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException(str + " must not be null");
    }

    public static void x(String str, String str2) throws CryptoException {
        if (str.equals(str2)) {
            throw new CryptoException("Both participants are using the same participantId (" + str + "). This is not allowed. Each participant must use a unique participantId.");
        }
    }

    public static void y(String str, String str2) throws CryptoException {
        if (str.equals(str2)) {
            return;
        }
        throw new CryptoException("Received payload from incorrect partner (" + str2 + "). Expected to receive payload from " + str + j3.b.f36044h);
    }

    public static void z(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger[] bigIntegerArr, String str, s sVar) throws CryptoException {
        BigInteger bigInteger5 = bigIntegerArr[0];
        BigInteger bigInteger6 = bigIntegerArr[1];
        BigInteger bigIntegerD = d(bigInteger3, bigInteger5, bigInteger4, str, sVar);
        if (bigInteger4.compareTo(f53333a) != 1 || bigInteger4.compareTo(bigInteger) != -1 || bigInteger4.modPow(bigInteger2, bigInteger).compareTo(f53334b) != 0 || bigInteger3.modPow(bigInteger6, bigInteger).multiply(bigInteger4.modPow(bigIntegerD, bigInteger)).mod(bigInteger).compareTo(bigInteger5) != 0) {
            throw new CryptoException("Zero-knowledge proof validation failed");
        }
    }
}
