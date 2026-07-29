package hr;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.s;
import xc.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31427a = 211;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f31428b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f31429c = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f31430d = BigInteger.valueOf(3);

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f31431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public BigInteger f31432b;

        public b(boolean z10, BigInteger bigInteger) {
            this.f31431a = z10;
            this.f31432b = bigInteger;
        }

        public static b g() {
            return new b(false, null);
        }

        public static b h() {
            return new b(true, null);
        }

        public static b i(BigInteger bigInteger) {
            return new b(true, bigInteger);
        }

        public BigInteger d() {
            return this.f31432b;
        }

        public boolean e() {
            return this.f31431a && this.f31432b == null;
        }

        public boolean f() {
            return this.f31431a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public BigInteger f31433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f31434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f31435c;

        public c(BigInteger bigInteger, byte[] bArr, int i10) {
            this.f31433a = bigInteger;
            this.f31434b = bArr;
            this.f31435c = i10;
        }

        public BigInteger a() {
            return this.f31433a;
        }

        public int b() {
            return this.f31435c;
        }

        public byte[] c() {
            return this.f31434b;
        }
    }

    public static void a(BigInteger bigInteger, String str) {
        if (bigInteger == null || bigInteger.signum() < 1 || bigInteger.bitLength() < 2) {
            throw new IllegalArgumentException("'" + str + "' must be non-null and >= 2");
        }
    }

    public static b b(BigInteger bigInteger, SecureRandom secureRandom, int i10) {
        BigInteger bigIntegerModPow;
        boolean z10;
        a(bigInteger, "candidate");
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        }
        if (i10 < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        if (bigInteger.bitLength() == 2) {
            return b.g();
        }
        if (!bigInteger.testBit(0)) {
            return b.i(f31429c);
        }
        BigInteger bigIntegerSubtract = bigInteger.subtract(f31428b);
        BigInteger bigIntegerSubtract2 = bigInteger.subtract(f31429c);
        int lowestSetBit = bigIntegerSubtract.getLowestSetBit();
        BigInteger bigIntegerShiftRight = bigIntegerSubtract.shiftRight(lowestSetBit);
        for (int i11 = 0; i11 < i10; i11++) {
            BigInteger bigIntegerG = org.bouncycastle.util.b.g(f31429c, bigIntegerSubtract2, secureRandom);
            BigInteger bigIntegerGcd = bigIntegerG.gcd(bigInteger);
            BigInteger bigInteger2 = f31428b;
            if (bigIntegerGcd.compareTo(bigInteger2) > 0) {
                return b.i(bigIntegerGcd);
            }
            BigInteger bigIntegerModPow2 = bigIntegerG.modPow(bigIntegerShiftRight, bigInteger);
            if (!bigIntegerModPow2.equals(bigInteger2) && !bigIntegerModPow2.equals(bigIntegerSubtract)) {
                int i12 = 1;
                while (true) {
                    if (i12 >= lowestSetBit) {
                        bigIntegerModPow = bigIntegerModPow2;
                        break;
                    }
                    bigIntegerModPow = bigIntegerModPow2.modPow(f31429c, bigInteger);
                    if (bigIntegerModPow.equals(bigIntegerSubtract)) {
                        z10 = true;
                        break;
                    }
                    if (bigIntegerModPow.equals(f31428b)) {
                        break;
                    }
                    i12++;
                    bigIntegerModPow2 = bigIntegerModPow;
                }
                z10 = false;
                if (!z10) {
                    BigInteger bigInteger3 = f31428b;
                    if (!bigIntegerModPow.equals(bigInteger3)) {
                        bigIntegerModPow2 = bigIntegerModPow.modPow(f31429c, bigInteger);
                        if (bigIntegerModPow2.equals(bigInteger3)) {
                            bigIntegerModPow2 = bigIntegerModPow;
                        }
                    }
                    BigInteger bigIntegerGcd2 = bigIntegerModPow2.subtract(bigInteger3).gcd(bigInteger);
                    return bigIntegerGcd2.compareTo(bigInteger3) > 0 ? b.i(bigIntegerGcd2) : b.h();
                }
            }
        }
        return b.g();
    }

    public static int c(byte[] bArr) {
        int iMin = Math.min(4, bArr.length);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iMin) {
            int i12 = i10 + 1;
            i11 |= (bArr[bArr.length - i12] & 255) << (i10 * 8);
            i10 = i12;
        }
        return i11;
    }

    public static c d(s sVar, int i10, byte[] bArr) {
        if (sVar == null) {
            throw new IllegalArgumentException("'hash' cannot be null");
        }
        if (i10 < 2) {
            throw new IllegalArgumentException("'length' must be >= 2");
        }
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("'inputSeed' cannot be null or empty");
        }
        return j(sVar, i10, org.bouncycastle.util.a.p(bArr));
    }

    public static boolean e(BigInteger bigInteger) {
        a(bigInteger, "candidate");
        return h(bigInteger);
    }

    public static void f(s sVar, byte[] bArr, byte[] bArr2, int i10) {
        sVar.update(bArr, 0, bArr.length);
        sVar.c(bArr2, i10);
    }

    public static BigInteger g(s sVar, byte[] bArr, int i10) {
        int iH = sVar.h();
        int i11 = i10 * iH;
        byte[] bArr2 = new byte[i11];
        for (int i12 = 0; i12 < i10; i12++) {
            i11 -= iH;
            f(sVar, bArr, bArr2, i11);
            k(bArr, 1);
        }
        return new BigInteger(1, bArr2);
    }

    public static boolean h(BigInteger bigInteger) {
        int iIntValue = bigInteger.mod(BigInteger.valueOf(223092870)).intValue();
        if (iIntValue % 2 != 0 && iIntValue % 3 != 0 && iIntValue % 5 != 0 && iIntValue % 7 != 0 && iIntValue % 11 != 0 && iIntValue % 13 != 0 && iIntValue % 17 != 0 && iIntValue % 19 != 0 && iIntValue % 23 != 0) {
            int iIntValue2 = bigInteger.mod(BigInteger.valueOf(58642669)).intValue();
            if (iIntValue2 % 29 != 0 && iIntValue2 % 31 != 0 && iIntValue2 % 37 != 0 && iIntValue2 % 41 != 0 && iIntValue2 % 43 != 0) {
                int iIntValue3 = bigInteger.mod(BigInteger.valueOf(600662303)).intValue();
                if (iIntValue3 % 47 != 0 && iIntValue3 % 53 != 0 && iIntValue3 % 59 != 0 && iIntValue3 % 61 != 0 && iIntValue3 % 67 != 0) {
                    int iIntValue4 = bigInteger.mod(BigInteger.valueOf(33984931)).intValue();
                    if (iIntValue4 % 71 != 0 && iIntValue4 % 73 != 0 && iIntValue4 % 79 != 0 && iIntValue4 % 83 != 0) {
                        int iIntValue5 = bigInteger.mod(BigInteger.valueOf(89809099)).intValue();
                        if (iIntValue5 % 89 != 0 && iIntValue5 % 97 != 0 && iIntValue5 % 101 != 0 && iIntValue5 % 103 != 0) {
                            int iIntValue6 = bigInteger.mod(BigInteger.valueOf(167375713)).intValue();
                            if (iIntValue6 % 107 != 0 && iIntValue6 % 109 != 0 && iIntValue6 % 113 != 0 && iIntValue6 % 127 != 0) {
                                int iIntValue7 = bigInteger.mod(BigInteger.valueOf(371700317)).intValue();
                                if (iIntValue7 % 131 != 0 && iIntValue7 % 137 != 0 && iIntValue7 % 139 != 0 && iIntValue7 % WaspWingInfo.COLD_LEVEL_STANDARD_B7 != 0) {
                                    int iIntValue8 = bigInteger.mod(BigInteger.valueOf(645328247)).intValue();
                                    if (iIntValue8 % rc.c.f48463k0 != 0 && iIntValue8 % 157 != 0 && iIntValue8 % 163 != 0 && iIntValue8 % 167 != 0) {
                                        int iIntValue9 = bigInteger.mod(BigInteger.valueOf(1070560157)).intValue();
                                        if (iIntValue9 % WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN != 0 && iIntValue9 % 179 != 0 && iIntValue9 % 181 != 0 && iIntValue9 % 191 != 0) {
                                            int iIntValue10 = bigInteger.mod(BigInteger.valueOf(1596463769)).intValue();
                                            if (iIntValue10 % s0.c.f49294u != 0 && iIntValue10 % 197 != 0 && iIntValue10 % 199 != 0 && iIntValue10 % f31427a != 0) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean i(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i10, BigInteger bigInteger4) {
        BigInteger bigIntegerModPow = bigInteger4.modPow(bigInteger3, bigInteger);
        if (bigIntegerModPow.equals(f31428b) || bigIntegerModPow.equals(bigInteger2)) {
            return true;
        }
        for (int i11 = 1; i11 < i10; i11++) {
            bigIntegerModPow = bigIntegerModPow.modPow(f31429c, bigInteger);
            if (bigIntegerModPow.equals(bigInteger2)) {
                return true;
            }
            if (bigIntegerModPow.equals(f31428b)) {
                return false;
            }
        }
        return false;
    }

    public static c j(s sVar, int i10, byte[] bArr) {
        C0373a c0373a;
        int iH = sVar.h();
        C0373a c0373a2 = null;
        int i11 = 1;
        if (i10 < 33) {
            byte[] bArr2 = new byte[iH];
            byte[] bArr3 = new byte[iH];
            int i12 = 0;
            do {
                f(sVar, bArr, bArr2, 0);
                k(bArr, 1);
                f(sVar, bArr, bArr3, 0);
                k(bArr, 1);
                i12++;
                long jC = ((long) (((c(bArr2) ^ c(bArr3)) & ((-1) >>> (32 - i10))) | (1 << (i10 - 1)) | 1)) & 4294967295L;
                if (n(jC)) {
                    return new c(BigInteger.valueOf(jC), bArr, i12);
                }
            } while (i12 <= i10 * 4);
            throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
        }
        c cVarJ = j(sVar, (i10 + 3) / 2, bArr);
        BigInteger bigIntegerA = cVarJ.a();
        byte[] bArrC = cVarJ.c();
        int iB = cVarJ.b();
        int i13 = i10 - 1;
        int i14 = (i13 / (iH * 8)) + 1;
        BigInteger bigIntegerG = g(sVar, bArrC, i14);
        BigInteger bigInteger = f31428b;
        BigInteger bit = bigIntegerG.mod(bigInteger.shiftLeft(i13)).setBit(i13);
        BigInteger bigIntegerShiftLeft = bigIntegerA.shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bit.subtract(bigInteger).divide(bigIntegerShiftLeft).add(bigInteger).shiftLeft(1);
        BigInteger bigIntegerAdd = bigIntegerShiftLeft2.multiply(bigIntegerA).add(bigInteger);
        int i15 = iB;
        int i16 = 0;
        while (true) {
            if (bigIntegerAdd.bitLength() > i10) {
                BigInteger bigInteger2 = f31428b;
                bigIntegerShiftLeft2 = bigInteger2.shiftLeft(i13).subtract(bigInteger2).divide(bigIntegerShiftLeft).add(bigInteger2).shiftLeft(i11);
                bigIntegerAdd = bigIntegerShiftLeft2.multiply(bigIntegerA).add(bigInteger2);
            }
            i15 += i11;
            if (h(bigIntegerAdd)) {
                c0373a = c0373a2;
                k(bArrC, i14);
            } else {
                BigInteger bigIntegerAdd2 = g(sVar, bArrC, i14).mod(bigIntegerAdd.subtract(f31430d)).add(f31429c);
                BigInteger bigIntegerAdd3 = bigIntegerShiftLeft2.add(BigInteger.valueOf(i16));
                BigInteger bigIntegerModPow = bigIntegerAdd2.modPow(bigIntegerAdd3, bigIntegerAdd);
                BigInteger bigInteger3 = f31428b;
                if (bigIntegerAdd.gcd(bigIntegerModPow.subtract(bigInteger3)).equals(bigInteger3) && bigIntegerModPow.modPow(bigIntegerA, bigIntegerAdd).equals(bigInteger3)) {
                    return new c(bigIntegerAdd, bArrC, i15);
                }
                c0373a = null;
                bigIntegerShiftLeft2 = bigIntegerAdd3;
                i16 = 0;
            }
            if (i15 >= (i10 * 4) + iB) {
                throw new IllegalStateException("Too many iterations in Shawe-Taylor Random_Prime Routine");
            }
            i16 += 2;
            bigIntegerAdd = bigIntegerAdd.add(bigIntegerShiftLeft);
            c0373a2 = c0373a;
            i11 = 1;
        }
    }

    public static void k(byte[] bArr, int i10) {
        int length = bArr.length;
        while (i10 > 0) {
            length--;
            if (length < 0) {
                return;
            }
            int i11 = i10 + (bArr[length] & 255);
            bArr[length] = (byte) i11;
            i10 = i11 >>> 8;
        }
    }

    public static boolean l(BigInteger bigInteger, SecureRandom secureRandom, int i10) {
        a(bigInteger, "candidate");
        if (secureRandom == null) {
            throw new IllegalArgumentException("'random' cannot be null");
        }
        if (i10 < 1) {
            throw new IllegalArgumentException("'iterations' must be > 0");
        }
        if (bigInteger.bitLength() == 2) {
            return true;
        }
        if (!bigInteger.testBit(0)) {
            return false;
        }
        BigInteger bigIntegerSubtract = bigInteger.subtract(f31428b);
        BigInteger bigIntegerSubtract2 = bigInteger.subtract(f31429c);
        int lowestSetBit = bigIntegerSubtract.getLowestSetBit();
        BigInteger bigIntegerShiftRight = bigIntegerSubtract.shiftRight(lowestSetBit);
        for (int i11 = 0; i11 < i10; i11++) {
            if (!i(bigInteger, bigIntegerSubtract, bigIntegerShiftRight, lowestSetBit, org.bouncycastle.util.b.g(f31429c, bigIntegerSubtract2, secureRandom))) {
                return false;
            }
        }
        return true;
    }

    public static boolean m(BigInteger bigInteger, BigInteger bigInteger2) {
        a(bigInteger, "candidate");
        a(bigInteger2, d.W);
        BigInteger bigInteger3 = f31428b;
        if (bigInteger2.compareTo(bigInteger.subtract(bigInteger3)) >= 0) {
            throw new IllegalArgumentException("'base' must be < ('candidate' - 1)");
        }
        if (bigInteger.bitLength() == 2) {
            return true;
        }
        BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger3);
        int lowestSetBit = bigIntegerSubtract.getLowestSetBit();
        return i(bigInteger, bigIntegerSubtract, bigIntegerSubtract.shiftRight(lowestSetBit), lowestSetBit, bigInteger2);
    }

    public static boolean n(long j10) {
        if ((j10 >>> 32) != 0) {
            throw new IllegalArgumentException("Size limit exceeded");
        }
        if (j10 <= 5) {
            return j10 == 2 || j10 == 3 || j10 == 5;
        }
        if ((1 & j10) == 0 || j10 % 3 == 0 || j10 % 5 == 0) {
            return false;
        }
        long[] jArr = {1, 7, 11, 13, 17, 19, 23, 29};
        long j11 = 0;
        int i10 = 1;
        while (true) {
            if (i10 >= 8) {
                j11 += 30;
                if (j11 * j11 >= j10) {
                    return true;
                }
                i10 = 0;
            } else {
                if (j10 % (jArr[i10] + j11) == 0) {
                    return j10 < 30;
                }
                i10++;
            }
        }
    }
}
