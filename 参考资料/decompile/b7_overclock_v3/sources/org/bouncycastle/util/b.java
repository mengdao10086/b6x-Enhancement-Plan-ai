package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f46036e = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f46032a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f46033b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f46034c = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f46035d = BigInteger.valueOf(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final BigInteger f46037f = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f46038g = BigInteger.valueOf(743).bitLength();

    public static void a(BigInteger bigInteger, byte[] bArr, int i10, int i11) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i11) {
            System.arraycopy(byteArray, 0, bArr, i10, i11);
            return;
        }
        int i12 = (byteArray[0] != 0 || byteArray.length == 1) ? 0 : 1;
        int length = byteArray.length - i12;
        if (length > i11) {
            throw new IllegalArgumentException("standard length exceeded for value");
        }
        int i13 = (i11 - length) + i10;
        a.e0(bArr, i10, i13, (byte) 0);
        System.arraycopy(byteArray, i12, bArr, i13, length);
    }

    public static byte[] b(int i10, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i10) {
            return byteArray;
        }
        int i11 = 0;
        if (byteArray[0] == 0 && byteArray.length != 1) {
            i11 = 1;
        }
        int length = byteArray.length - i11;
        if (length > i10) {
            throw new IllegalArgumentException("standard length exceeded for value");
        }
        byte[] bArr = new byte[i10];
        System.arraycopy(byteArray, i11, bArr, i10 - length, length);
        return bArr;
    }

    public static byte[] c(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0 || byteArray.length == 1) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static byte d(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 7) {
            return bigInteger.byteValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static byte[] e(int i10, SecureRandom secureRandom) throws IllegalArgumentException {
        if (i10 < 1) {
            throw new IllegalArgumentException("bitLength must be at least 1");
        }
        int i11 = (i10 + 7) / 8;
        byte[] bArr = new byte[i11];
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & ((byte) (255 >>> ((i11 * 8) - i10))));
        return bArr;
    }

    public static BigInteger f(int i10, SecureRandom secureRandom) {
        return new BigInteger(1, e(i10, secureRandom));
    }

    public static BigInteger g(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerF;
        int iCompareTo = bigInteger.compareTo(bigInteger2);
        if (iCompareTo >= 0) {
            if (iCompareTo <= 0) {
                return bigInteger;
            }
            throw new IllegalArgumentException("'min' may not be greater than 'max'");
        }
        if (bigInteger.bitLength() > bigInteger2.bitLength() / 2) {
            bigIntegerF = g(f46032a, bigInteger2.subtract(bigInteger), secureRandom);
        } else {
            for (int i10 = 0; i10 < 1000; i10++) {
                BigInteger bigIntegerF2 = f(bigInteger2.bitLength(), secureRandom);
                if (bigIntegerF2.compareTo(bigInteger) >= 0 && bigIntegerF2.compareTo(bigInteger2) <= 0) {
                    return bigIntegerF2;
                }
            }
            bigIntegerF = f(bigInteger2.subtract(bigInteger).bitLength() - 1, secureRandom);
        }
        return bigIntegerF.add(bigInteger);
    }

    public static BigInteger h(int i10, int i11, SecureRandom secureRandom) {
        BigInteger bigInteger;
        if (i10 < 2) {
            throw new IllegalArgumentException("bitLength < 2");
        }
        if (i10 == 2) {
            return secureRandom.nextInt() < 0 ? f46034c : f46035d;
        }
        do {
            byte[] bArrE = e(i10, secureRandom);
            bArrE[0] = (byte) (((byte) (1 << (7 - ((bArrE.length * 8) - i10)))) | bArrE[0]);
            int length = bArrE.length - 1;
            bArrE[length] = (byte) (bArrE[length] | 1);
            bigInteger = new BigInteger(1, bArrE);
            if (i10 > f46038g) {
                while (!bigInteger.gcd(f46037f).equals(f46033b)) {
                    bigInteger = bigInteger.add(f46034c);
                }
            }
        } while (!bigInteger.isProbablePrime(i11));
        return bigInteger;
    }

    public static BigInteger i(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static BigInteger j(byte[] bArr, int i10, int i11) {
        if (i10 != 0 || i11 != bArr.length) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }

    public static int k(BigInteger bigInteger) {
        if (bigInteger.equals(f46032a)) {
            return 1;
        }
        return (bigInteger.bitLength() + 7) / 8;
    }

    public static int l(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 31) {
            return bigInteger.intValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static long m(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new ArithmeticException("BigInteger out of long range");
    }

    public static BigInteger n(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        }
        if (bigInteger.signum() != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            bigInteger2 = bigInteger2.mod(bigInteger);
        }
        int iBitLength = bigInteger.bitLength();
        int[] iArrT = rr.o.T(iBitLength, bigInteger);
        int[] iArrT2 = rr.o.T(iBitLength, bigInteger2);
        int length = iArrT.length;
        int[] iArrD = rr.o.D(length);
        if (rr.c.l(iArrT, iArrT2, iArrD) != 0) {
            return rr.o.g1(length, iArrD);
        }
        throw new ArithmeticException("BigInteger not invertible.");
    }

    public static BigInteger o(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        }
        if (bigInteger.signum() != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        BigInteger bigInteger3 = f46033b;
        if (bigInteger.equals(bigInteger3)) {
            return f46032a;
        }
        if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            bigInteger2 = bigInteger2.mod(bigInteger);
        }
        if (bigInteger2.equals(bigInteger3)) {
            return bigInteger3;
        }
        int iBitLength = bigInteger.bitLength();
        int[] iArrT = rr.o.T(iBitLength, bigInteger);
        int[] iArrT2 = rr.o.T(iBitLength, bigInteger2);
        int length = iArrT.length;
        int[] iArrD = rr.o.D(length);
        if (rr.c.m(iArrT, iArrT2, iArrD)) {
            return rr.o.g1(length, iArrD);
        }
        throw new ArithmeticException("BigInteger not invertible.");
    }

    public static short p(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 15) {
            return bigInteger.shortValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }
}
