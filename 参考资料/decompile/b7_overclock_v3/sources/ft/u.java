package ft;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.math.BigInteger;
import java.security.SecureRandom;
import lr.f0;
import no.nordicsemi.android.dfu.DfuBaseService;
import w.w;
import za.h1;

/* JADX INFO: loaded from: classes6.dex */
public final class u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f28811f = 152125131763605L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f28806a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f28807b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f28808c = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f28809d = BigInteger.valueOf(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f28810e = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SecureRandom f28812g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f28813h = {0, 1, 0, -1, 0, -1, 0, 1};

    public static long A(long j10, long j11) {
        long j12 = j10 % j11;
        return j12 < 0 ? j12 + j11 : j12;
    }

    public static int B(int i10, int i11) {
        return BigInteger.valueOf(i10).modInverse(BigInteger.valueOf(i11)).intValue();
    }

    public static long C(long j10, long j11) {
        return BigInteger.valueOf(j10).modInverse(BigInteger.valueOf(j11)).longValue();
    }

    public static int D(int i10, int i11, int i12) {
        if (i12 <= 0 || i12 * i12 > Integer.MAX_VALUE || i11 < 0) {
            return 0;
        }
        int i13 = ((i10 % i12) + i12) % i12;
        int i14 = 1;
        while (i11 > 0) {
            if ((i11 & 1) == 1) {
                i14 = (i14 * i13) % i12;
            }
            i13 = (i13 * i13) % i12;
            i11 >>>= 1;
        }
        return i14;
    }

    public static BigInteger E(long j10) {
        if (j10 <= 1) {
            return BigInteger.valueOf(2L);
        }
        if (j10 == 2) {
            return BigInteger.valueOf(3L);
        }
        boolean z10 = false;
        long j11 = 0;
        for (long j12 = j10 + 1 + (j10 & 1); j12 <= (j10 << 1) && !z10; j12 += 2) {
            for (long j13 = 3; j13 <= (j12 >> 1) && !z10; j13 += 2) {
                if (j12 % j13 == 0) {
                    z10 = true;
                }
            }
            if (!z10) {
                j11 = j12;
            }
            z10 = !z10;
        }
        return BigInteger.valueOf(j11);
    }

    public static BigInteger F(BigInteger bigInteger) {
        return G(bigInteger, 20);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.math.BigInteger G(java.math.BigInteger r7, int r8) {
        /*
            int r0 = r7.signum()
            if (r0 < 0) goto Lb0
            int r0 = r7.signum()
            if (r0 == 0) goto Lb0
            java.math.BigInteger r0 = ft.u.f28807b
            boolean r1 = r7.equals(r0)
            if (r1 == 0) goto L16
            goto Lb0
        L16:
            java.math.BigInteger r7 = r7.add(r0)
            r1 = 0
            boolean r1 = r7.testBit(r1)
            if (r1 != 0) goto L25
        L21:
            java.math.BigInteger r7 = r7.add(r0)
        L25:
            int r0 = r7.bitLength()
            r1 = 6
            if (r0 <= r1) goto La1
            r0 = 152125131763605(0x8a5b6470af95, double:7.515980147347E-310)
            java.math.BigInteger r0 = java.math.BigInteger.valueOf(r0)
            java.math.BigInteger r0 = r7.remainder(r0)
            long r0 = r0.longValue()
            r2 = 3
            long r2 = r0 % r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 5
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 7
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 11
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 13
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 17
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 19
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 23
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 29
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 31
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 37
            long r2 = r0 % r2
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L9e
            r2 = 41
            long r0 = r0 % r2
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto La1
        L9e:
            java.math.BigInteger r0 = ft.u.f28808c
            goto L21
        La1:
            int r0 = r7.bitLength()
            r1 = 4
            if (r0 >= r1) goto La9
            return r7
        La9:
            boolean r0 = r7.isProbablePrime(r8)
            if (r0 == 0) goto L9e
            return r7
        Lb0:
            java.math.BigInteger r7 = ft.u.f28808c
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ft.u.G(java.math.BigInteger, int):java.math.BigInteger");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0012, code lost:
    
        r2 = r2 - 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int H(int r2) {
        /*
            r0 = 2
            if (r2 > r0) goto L5
            r2 = 1
            return r2
        L5:
            r1 = 3
            if (r2 != r1) goto L9
            return r0
        L9:
            r0 = r2 & 1
            if (r0 != 0) goto L10
            int r2 = r2 + (-1)
            goto L12
        L10:
            int r2 = r2 + (-2)
        L12:
            if (r2 <= r1) goto L1b
            boolean r0 = s(r2)
            if (r0 != 0) goto L1b
            goto L10
        L1b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ft.u.H(int):int");
    }

    public static BigInteger I(byte[] bArr) {
        return J(bArr, 0, bArr.length);
    }

    public static BigInteger J(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11 + 1];
        bArr2[0] = 0;
        System.arraycopy(bArr, i10, bArr2, 1, i11);
        return new BigInteger(bArr2);
    }

    public static int K(int i10, int i11) {
        int i12 = i10 % i11;
        if (i12 == 0) {
            throw new IllegalArgumentException(i10 + " is not an element of Z/(" + i11 + "Z)^*; it is not meaningful to compute its order.");
        }
        int i13 = 1;
        while (i12 != 1) {
            i12 = (i12 * i10) % i11;
            if (i12 < 0) {
                i12 += i11;
            }
            i13++;
        }
        return i13;
    }

    public static boolean L(BigInteger bigInteger) {
        int[] iArr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, WaspWingInfo.COLD_LEVEL_STANDARD_B7, rc.c.f48463k0, 157, 163, 167, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 179, 181, 191, s0.c.f49294u, 197, 199, hr.a.f31427a, 223, 227, 229, 233, 239, 241, mb.e.f41067u1, 257, 263, 269, 271, 277, 281, DfuBaseService.NOTIFICATION_ID, 293, 307, 311, 313, w.a.f53656r, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, gg.b.f29477q, 397, 401, 409, 419, 421, 431, 433, 439, rb.a0.f47912q, 449, 457, 461, 463, 467, 479, 487, 491, 499, w.g.f53772k, 509, gg.b.f29450j0, gg.b.f29462m0, gg.b.K0, gg.b.T0, gg.b.f29439g1, 563, 569, 571, 577, 587, 593, 599, 601, w.e.f53735w, 613, 617, 619, 631, 641, gg.b.Z, gg.b.f29442h0, 653, 659, 661, 673, gg.b.X0, 683, 691, w.h.f53791k, 709, 719, 727, 733, 739, 743, 751, 757, 761, gg.b.f29459l1, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, kf.a.f37226a, 937, 941, 947, 953, 967, 971, f0.f40202f, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, h1.V, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499};
        for (int i10 = 0; i10 < 239; i10++) {
            if (bigInteger.mod(BigInteger.valueOf(iArr[i10])).equals(f28806a)) {
                return false;
            }
        }
        return true;
    }

    public static int M(int i10, int i11) {
        int i12 = 1;
        while (i11 > 0) {
            if ((i11 & 1) == 1) {
                i12 *= i10;
            }
            i10 *= i10;
            i11 >>>= 1;
        }
        return i12;
    }

    public static long N(long j10, int i10) {
        long j11 = 1;
        while (i10 > 0) {
            if ((i10 & 1) == 1) {
                j11 *= j10;
            }
            j10 *= j10;
            i10 >>>= 1;
        }
        return j11;
    }

    public static BigInteger O(BigInteger bigInteger) {
        if (f28812g == null) {
            f28812g = org.bouncycastle.crypto.n.f();
        }
        return P(bigInteger, f28812g);
    }

    public static BigInteger P(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (secureRandom == null && (secureRandom = f28812g) == null) {
            secureRandom = org.bouncycastle.crypto.n.f();
        }
        for (int i10 = 0; i10 < 20; i10++) {
            bigIntegerValueOf = org.bouncycastle.util.b.f(iBitLength, secureRandom);
            if (bigIntegerValueOf.compareTo(bigInteger) < 0) {
                return bigIntegerValueOf;
            }
        }
        return bigIntegerValueOf.mod(bigInteger);
    }

    public static BigInteger Q(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger.subtract(bigInteger2).mod(bigInteger3.subtract(bigInteger2)).add(bigInteger2);
    }

    public static BigInteger R(BigInteger bigInteger, BigInteger bigInteger2) throws IllegalArgumentException {
        BigInteger bigIntegerShiftLeft;
        BigInteger bigInteger3 = f28806a;
        BigInteger bigIntegerAdd = bigInteger;
        if (bigIntegerAdd.compareTo(bigInteger3) < 0) {
            bigIntegerAdd = bigInteger.add(bigInteger2);
        }
        if (bigIntegerAdd.equals(bigInteger3)) {
            return bigInteger3;
        }
        if (bigInteger2.equals(f28808c)) {
            return bigIntegerAdd;
        }
        if (bigInteger2.testBit(0) && bigInteger2.testBit(1)) {
            if (t(bigIntegerAdd, bigInteger2) == 1) {
                return bigIntegerAdd.modPow(bigInteger2.add(f28807b).shiftRight(2), bigInteger2);
            }
            throw new IllegalArgumentException("No quadratic residue: " + bigIntegerAdd + ", " + bigInteger2);
        }
        BigInteger bigIntegerSubtract = bigInteger2.subtract(f28807b);
        long j10 = 0;
        while (!bigIntegerSubtract.testBit(0)) {
            j10++;
            bigIntegerSubtract = bigIntegerSubtract.shiftRight(1);
        }
        BigInteger bigInteger4 = f28807b;
        BigInteger bigIntegerShiftRight = bigIntegerSubtract.subtract(bigInteger4).shiftRight(1);
        BigInteger bigIntegerModPow = bigIntegerAdd.modPow(bigIntegerShiftRight, bigInteger2);
        BigInteger bigIntegerRemainder = bigIntegerModPow.multiply(bigIntegerModPow).remainder(bigInteger2).multiply(bigIntegerAdd).remainder(bigInteger2);
        BigInteger bigIntegerRemainder2 = bigIntegerModPow.multiply(bigIntegerAdd).remainder(bigInteger2);
        if (bigIntegerRemainder.equals(bigInteger4)) {
            return bigIntegerRemainder2;
        }
        BigInteger bigIntegerAdd2 = f28808c;
        while (t(bigIntegerAdd2, bigInteger2) == 1) {
            bigIntegerAdd2 = bigIntegerAdd2.add(f28807b);
        }
        BigInteger bigIntegerModPow2 = bigIntegerAdd2.modPow(bigIntegerShiftRight.multiply(f28808c).add(f28807b), bigInteger2);
        for (int i10 = 1; bigIntegerRemainder.compareTo(f28807b) == i10; i10 = 1) {
            long j11 = 0;
            BigInteger bigIntegerMod = bigIntegerRemainder;
            while (true) {
                bigIntegerShiftLeft = f28807b;
                if (bigIntegerMod.equals(bigIntegerShiftLeft)) {
                    break;
                }
                bigIntegerMod = bigIntegerMod.multiply(bigIntegerMod).mod(bigInteger2);
                j11++;
            }
            long j12 = j10 - j11;
            if (j12 == 0) {
                throw new IllegalArgumentException("No quadratic residue: " + bigIntegerAdd + ", " + bigInteger2);
            }
            for (long j13 = 0; j13 < j12 - 1; j13++) {
                bigIntegerShiftLeft = bigIntegerShiftLeft.shiftLeft(1);
            }
            BigInteger bigIntegerModPow3 = bigIntegerModPow2.modPow(bigIntegerShiftLeft, bigInteger2);
            bigIntegerRemainder2 = bigIntegerRemainder2.multiply(bigIntegerModPow3).remainder(bigInteger2);
            bigIntegerModPow2 = bigIntegerModPow3.multiply(bigIntegerModPow3).remainder(bigInteger2);
            bigIntegerRemainder = bigIntegerRemainder.multiply(bigIntegerModPow2).mod(bigInteger2);
            j10 = j11;
        }
        return bigIntegerRemainder2;
    }

    public static BigInteger S(BigInteger bigInteger) {
        int i10;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerMultiply = f28806a;
        if (bigInteger.compareTo(bigIntegerMultiply) < 0) {
            throw new ArithmeticException("cannot extract root of negative number" + bigInteger + j3.b.f36044h);
        }
        int iBitLength = bigInteger.bitLength();
        if ((iBitLength & 1) != 0) {
            int i11 = iBitLength - 1;
            bigIntegerAdd = bigIntegerMultiply;
            bigIntegerMultiply = bigIntegerMultiply.add(f28807b);
            i10 = i11;
        } else {
            i10 = iBitLength;
            bigIntegerAdd = bigIntegerMultiply;
        }
        while (i10 > 0) {
            BigInteger bigInteger2 = f28809d;
            BigInteger bigIntegerMultiply2 = bigIntegerAdd.multiply(bigInteger2);
            int i12 = i10 - 1;
            int i13 = bigInteger.testBit(i12) ? 2 : 0;
            i10 = i12 - 1;
            bigIntegerAdd = bigIntegerMultiply2.add(BigInteger.valueOf(i13 + (bigInteger.testBit(i10) ? 1 : 0)));
            BigInteger bigIntegerMultiply3 = bigIntegerMultiply.multiply(bigInteger2);
            BigInteger bigInteger3 = f28807b;
            BigInteger bigIntegerAdd2 = bigIntegerMultiply3.add(bigInteger3);
            bigIntegerMultiply = bigIntegerMultiply.multiply(f28808c);
            if (bigIntegerAdd.compareTo(bigIntegerAdd2) != -1) {
                bigIntegerMultiply = bigIntegerMultiply.add(bigInteger3);
                bigIntegerAdd = bigIntegerAdd.subtract(bigIntegerAdd2);
            }
        }
        return bigIntegerMultiply;
    }

    public static BigInteger a(int i10, int i11) {
        BigInteger bigIntegerDivide = f28807b;
        if (i10 == 0) {
            return i11 == 0 ? bigIntegerDivide : f28806a;
        }
        if (i11 > (i10 >>> 1)) {
            i11 = i10 - i11;
        }
        for (int i12 = 1; i12 <= i11; i12++) {
            bigIntegerDivide = bigIntegerDivide.multiply(BigInteger.valueOf(i10 - (i12 - 1))).divide(BigInteger.valueOf(i12));
        }
        return bigIntegerDivide;
    }

    public static int b(int i10) {
        int i11 = 0;
        while (i10 != 0) {
            i11 += i10 & 1;
            i10 >>>= 1;
        }
        return i11;
    }

    public static int c(int i10) {
        int i11 = 1;
        int i12 = 0;
        while (i11 < i10) {
            i11 <<= 1;
            i12++;
        }
        return i12;
    }

    public static int d(BigInteger bigInteger) {
        int i10 = 0;
        for (BigInteger bigIntegerShiftLeft = f28807b; bigIntegerShiftLeft.compareTo(bigInteger) < 0; bigIntegerShiftLeft = bigIntegerShiftLeft.shiftLeft(1)) {
            i10++;
        }
        return i10;
    }

    public static int e(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 < 0) {
            i10 = -i10;
        }
        int i11 = 0;
        while (i10 > 0) {
            i11++;
            i10 >>>= 8;
        }
        return i11;
    }

    public static int f(long j10) {
        if (j10 == 0) {
            return 1;
        }
        if (j10 < 0) {
            j10 = -j10;
        }
        int i10 = 0;
        while (j10 > 0) {
            i10++;
            j10 >>>= 8;
        }
        return i10;
    }

    public static BigInteger g(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.signum() < 0 ? g(bigInteger.negate(), bigInteger2).negate() : bigInteger2.signum() < 0 ? g(bigInteger, bigInteger2.negate()).negate() : bigInteger.shiftLeft(1).add(bigInteger2).divide(bigInteger2.shiftLeft(1));
    }

    public static BigInteger[] h(BigInteger[] bigIntegerArr, BigInteger bigInteger) {
        BigInteger[] bigIntegerArr2 = new BigInteger[bigIntegerArr.length];
        for (int i10 = 0; i10 < bigIntegerArr.length; i10++) {
            bigIntegerArr2[i10] = g(bigIntegerArr[i10], bigInteger);
        }
        return bigIntegerArr2;
    }

    public static int[] i(int i10, int i11) {
        BigInteger[] bigIntegerArrJ = j(BigInteger.valueOf(i10), BigInteger.valueOf(i11));
        return new int[]{bigIntegerArrJ[0].intValue(), bigIntegerArrJ[1].intValue(), bigIntegerArrJ[2].intValue()};
    }

    public static BigInteger[] j(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = f28807b;
        BigInteger bigIntegerDivide = f28806a;
        if (bigInteger2.signum() != 0) {
            BigInteger bigInteger4 = bigInteger;
            BigInteger bigInteger5 = bigInteger2;
            while (bigInteger5.signum() != 0) {
                BigInteger[] bigIntegerArrDivideAndRemainder = bigInteger4.divideAndRemainder(bigInteger5);
                BigInteger bigInteger6 = bigIntegerArrDivideAndRemainder[0];
                BigInteger bigInteger7 = bigIntegerArrDivideAndRemainder[1];
                BigInteger bigInteger8 = bigIntegerDivide;
                bigIntegerDivide = bigInteger3.subtract(bigInteger6.multiply(bigIntegerDivide));
                bigInteger3 = bigInteger8;
                bigInteger4 = bigInteger5;
                bigInteger5 = bigInteger7;
            }
            bigIntegerDivide = bigInteger4.subtract(bigInteger.multiply(bigInteger3)).divide(bigInteger2);
            bigInteger = bigInteger4;
        }
        return new BigInteger[]{bigInteger, bigInteger3, bigIntegerDivide};
    }

    public static float k(float f10, int i10) {
        float f11 = 1.0f;
        while (i10 > 0) {
            f11 *= f10;
            i10--;
        }
        return f11;
    }

    public static int l(int i10) {
        if (i10 <= 0) {
            return -1;
        }
        int i11 = 0;
        for (int i12 = i10 >>> 1; i12 > 0; i12 >>>= 1) {
            i11++;
        }
        return i11;
    }

    public static int m(BigInteger bigInteger) {
        int i10 = -1;
        for (BigInteger bigIntegerShiftLeft = f28807b; bigIntegerShiftLeft.compareTo(bigInteger) <= 0; bigIntegerShiftLeft = bigIntegerShiftLeft.shiftLeft(1)) {
            i10++;
        }
        return i10;
    }

    public static int n(int i10, int i11) {
        return BigInteger.valueOf(i10).gcd(BigInteger.valueOf(i11)).intValue();
    }

    public static float o(int i10, int i11) {
        float fK;
        float fK2 = i10 / i11;
        float f10 = 0.0f;
        while (Math.abs(f10 - fK2) > 1.0E-4d) {
            while (true) {
                fK = k(fK2, i11);
                if (Float.isInfinite(fK)) {
                    fK2 = (fK2 + f10) / 2.0f;
                }
            }
            f10 = fK2;
            fK2 -= (fK - i10) / (i11 * k(fK2, i11 - 1));
        }
        return fK2;
    }

    public static byte[] p(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.abs().toByteArray();
        if ((bigInteger.bitLength() & 7) != 0) {
            return byteArray;
        }
        int iBitLength = bigInteger.bitLength() >> 3;
        byte[] bArr = new byte[iBitLength];
        System.arraycopy(byteArray, 1, bArr, 0, iBitLength);
        return bArr;
    }

    public static boolean q(int[] iArr) {
        for (int i10 = 1; i10 < iArr.length; i10++) {
            if (iArr[i10 - 1] >= iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    public static int r(int i10, int i11) {
        if (i10 <= 0) {
            return -1;
        }
        int i12 = 0;
        while (i10 > 1) {
            if (i10 % i11 != 0) {
                return -1;
            }
            i10 /= i11;
            i12++;
        }
        return i12;
    }

    public static boolean s(int i10) {
        if (i10 < 2) {
            return false;
        }
        if (i10 == 2) {
            return true;
        }
        if ((i10 & 1) == 0) {
            return false;
        }
        if (i10 < 42) {
            int i11 = 0;
            while (true) {
                int[] iArr = f28810e;
                if (i11 >= iArr.length) {
                    break;
                }
                if (i10 == iArr[i11]) {
                    return true;
                }
                i11++;
            }
        }
        if (i10 % 3 == 0 || i10 % 5 == 0 || i10 % 7 == 0 || i10 % 11 == 0 || i10 % 13 == 0 || i10 % 17 == 0 || i10 % 19 == 0 || i10 % 23 == 0 || i10 % 29 == 0 || i10 % 31 == 0 || i10 % 37 == 0 || i10 % 41 == 0) {
            return false;
        }
        return BigInteger.valueOf(i10).isProbablePrime(20);
    }

    public static int t(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerAdd = f28806a;
        if (bigInteger2.equals(bigIntegerAdd)) {
            return bigInteger.abs().equals(f28807b) ? 1 : 0;
        }
        if (!bigInteger.testBit(0) && !bigInteger2.testBit(0)) {
            return 0;
        }
        long j10 = 1;
        if (bigInteger2.signum() == -1) {
            bigInteger2 = bigInteger2.negate();
            if (bigInteger.signum() == -1) {
                j10 = -1;
            }
        }
        while (!bigInteger2.testBit(0)) {
            bigIntegerAdd = bigIntegerAdd.add(f28807b);
            bigInteger2 = bigInteger2.divide(f28808c);
        }
        if (bigIntegerAdd.testBit(0)) {
            j10 *= (long) f28813h[bigInteger.intValue() & 7];
        }
        if (bigInteger.signum() < 0) {
            if (bigInteger2.testBit(1)) {
                j10 = -j10;
            }
            bigInteger = bigInteger.negate();
        }
        while (bigInteger.signum() != 0) {
            BigInteger bigIntegerAdd2 = f28806a;
            while (!bigInteger.testBit(0)) {
                bigIntegerAdd2 = bigIntegerAdd2.add(f28807b);
                bigInteger = bigInteger.divide(f28808c);
            }
            if (bigIntegerAdd2.testBit(0)) {
                j10 *= (long) f28813h[bigInteger2.intValue() & 7];
            }
            if (bigInteger.compareTo(bigInteger2) >= 0) {
                BigInteger bigInteger3 = bigInteger2;
                bigInteger2 = bigInteger;
                bigInteger = bigInteger3;
            } else if (bigInteger2.testBit(1) && bigInteger.testBit(1)) {
                j10 = -j10;
            }
            BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger);
            bigInteger2 = bigInteger;
            bigInteger = bigIntegerSubtract;
        }
        if (bigInteger2.equals(f28807b)) {
            return (int) j10;
        }
        return 0;
    }

    public static BigInteger u(BigInteger[] bigIntegerArr) {
        int length = bigIntegerArr.length;
        BigInteger bigIntegerDivide = bigIntegerArr[0];
        for (int i10 = 1; i10 < length; i10++) {
            bigIntegerDivide = bigIntegerDivide.multiply(bigIntegerArr[i10]).divide(bigIntegerDivide.gcd(bigIntegerArr[i10]));
        }
        return bigIntegerDivide;
    }

    public static int v(int i10) {
        if (i10 < 0) {
            i10 = -i10;
        }
        if (i10 == 0) {
            return 1;
        }
        if ((i10 & 1) == 0) {
            return 2;
        }
        for (int i11 = 3; i11 <= i10 / i11; i11 += 2) {
            if (i10 % i11 == 0) {
                return i11;
            }
        }
        return i10;
    }

    public static double w(double d10) {
        double d11 = 1.0d;
        if (d10 > 0.0d && d10 < 1.0d) {
            return -w(1.0d / d10);
        }
        int i10 = 0;
        double d12 = d10;
        while (d12 > 2.0d) {
            d12 /= 2.0d;
            i10++;
            d11 *= 2.0d;
        }
        return ((double) i10) + y(d10 / d11);
    }

    public static double x(long j10) {
        return ((double) m(BigInteger.valueOf(j10))) + y(j10 / ((double) (1 << r0)));
    }

    public static double y(double d10) {
        double[] dArr = {1.0d, 0.5849625007211562d, 0.32192809488736235d, 0.16992500144231237d, 0.0874628412503394d, 0.044394119358453436d, 0.02236781302845451d, 0.01122725542325412d, 0.005624549193878107d, 0.0028150156070540383d, 0.0014081943928083889d, 7.042690112466433E-4d, 3.5217748030102726E-4d, 1.7609948644250602E-4d, 8.80524301221769E-5d, 4.4026886827316716E-5d, 2.2013611360340496E-5d, 1.1006847667481442E-5d, 5.503434330648604E-6d, 2.751719789561283E-6d, 1.375860550841138E-6d, 6.879304394358497E-7d, 3.4396526072176454E-7d, 1.7198264061184464E-7d, 8.599132286866321E-8d, 4.299566207501687E-8d, 2.1497831197679756E-8d, 1.0748915638882709E-8d, 5.374457829452062E-9d, 2.687228917228708E-9d, 1.3436144592400231E-9d, 6.718072297764289E-10d, 3.3590361492731876E-10d, 1.6795180747343547E-10d, 8.397590373916176E-11d, 4.1987951870191886E-11d, 2.0993975935248694E-11d, 1.0496987967662534E-11d, 5.2484939838408146E-12d, 2.624246991922794E-12d, 1.3121234959619935E-12d, 6.56061747981146E-13d, 3.2803087399061026E-13d, 1.6401543699531447E-13d, 8.200771849765956E-14d, 4.1003859248830365E-14d, 2.0501929624415328E-14d, 1.02509648122077E-14d, 5.1254824061038595E-15d, 2.5627412030519317E-15d, 1.2813706015259665E-15d, 6.406853007629834E-16d, 3.203426503814917E-16d, 1.6017132519074588E-16d, 8.008566259537294E-17d, 4.004283129768647E-17d, 2.0021415648843235E-17d, 1.0010707824421618E-17d, 5.005353912210809E-18d, 2.5026769561054044E-18d, 1.2513384780527022E-18d, 6.256692390263511E-19d, 3.1283461951317555E-19d, 1.5641730975658778E-19d, 7.820865487829389E-20d, 3.9104327439146944E-20d, 1.9552163719573472E-20d, 9.776081859786736E-21d, 4.888040929893368E-21d, 2.444020464946684E-21d, 1.222010232473342E-21d, 6.11005116236671E-22d, 3.055025581183355E-22d, 1.5275127905916775E-22d, 7.637563952958387E-23d, 3.818781976479194E-23d, 1.909390988239597E-23d, 9.546954941197984E-24d, 4.773477470598992E-24d, 2.386738735299496E-24d, 1.193369367649748E-24d, 5.96684683824874E-25d, 2.98342341912437E-25d, 1.491711709562185E-25d, 7.458558547810925E-26d, 3.7292792739054626E-26d, 1.8646396369527313E-26d, 9.323198184763657E-27d, 4.661599092381828E-27d, 2.330799546190914E-27d, 1.165399773095457E-27d, 5.826998865477285E-28d, 2.9134994327386427E-28d, 1.4567497163693213E-28d, 7.283748581846607E-29d, 3.6418742909233034E-29d, 1.8209371454616517E-29d, 9.104685727308258E-30d, 4.552342863654129E-30d, 2.2761714318270646E-30d};
        double d11 = 1.0d;
        double d12 = 0.0d;
        double d13 = 1.0d;
        for (int i10 = 0; i10 < 53; i10++) {
            double d14 = (d11 * d13) + d11;
            if (d14 <= d10) {
                d12 += dArr[i10];
                d11 = d14;
            }
            d13 *= 0.5d;
        }
        return d12;
    }

    public static int z(int i10) {
        int i11 = 0;
        if (i10 != 0) {
            for (int i12 = 1; (i10 & i12) == 0; i12 <<= 1) {
                i11++;
            }
        }
        return i11;
    }
}
