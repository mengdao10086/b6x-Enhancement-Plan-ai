package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class BigIntegerMath {

    @VisibleForTesting
    public static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;

    @VisibleForTesting
    public static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double LN_10 = Math.log(10.0d);
    private static final double LN_2 = Math.log(2.0d);

    /* JADX INFO: renamed from: com.google.common.math.BigIntegerMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private BigIntegerMath() {
    }

    public static BigInteger binomial(int i10, int i11) {
        int i12;
        MathPreconditions.checkNonNegative("n", i10);
        MathPreconditions.checkNonNegative("k", i11);
        int i13 = 1;
        Preconditions.checkArgument(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        int[] iArr = LongMath.biggestBinomials;
        if (i11 < iArr.length && i10 <= iArr[i11]) {
            return BigInteger.valueOf(LongMath.binomial(i10, i11));
        }
        BigInteger bigIntegerDivide = BigInteger.ONE;
        long j10 = i10;
        long j11 = 1;
        int iLog2 = LongMath.log2(j10, RoundingMode.CEILING);
        while (true) {
            int i14 = iLog2;
            while (i13 < i11) {
                i12 = i10 - i13;
                i13++;
                i14 += iLog2;
                if (i14 >= 63) {
                    break;
                }
                j10 *= (long) i12;
                j11 *= (long) i13;
            }
            return bigIntegerDivide.multiply(BigInteger.valueOf(j10)).divide(BigInteger.valueOf(j11));
            bigIntegerDivide = bigIntegerDivide.multiply(BigInteger.valueOf(j10)).divide(BigInteger.valueOf(j11));
            j10 = i12;
            j11 = i13;
        }
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        long[] jArr = LongMath.factorials;
        if (i10 < jArr.length) {
            return BigInteger.valueOf(jArr[i10]);
        }
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i10, RoundingMode.CEILING) * i10, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j10 = jArr[length - 1];
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j10);
        long j11 = j10 >> iNumberOfTrailingZeros;
        int iLog2 = LongMath.log2(j11, RoundingMode.FLOOR) + 1;
        long j12 = length;
        int iLog22 = LongMath.log2(j12, RoundingMode.FLOOR) + 1;
        int i11 = 1 << (iLog22 - 1);
        while (j12 <= i10) {
            if ((((long) i11) & j12) != 0) {
                i11 <<= 1;
                iLog22++;
            }
            int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j12);
            long j13 = j12 >> iNumberOfTrailingZeros2;
            iNumberOfTrailingZeros += iNumberOfTrailingZeros2;
            if ((iLog22 - iNumberOfTrailingZeros2) + iLog2 >= 64) {
                arrayList.add(BigInteger.valueOf(j11));
                j11 = 1;
            }
            j11 *= j13;
            iLog2 = LongMath.log2(j11, RoundingMode.FLOOR) + 1;
            j12++;
        }
        if (j11 > 1) {
            arrayList.add(BigInteger.valueOf(j11));
        }
        return listProduct(arrayList).shiftLeft(iNumberOfTrailingZeros);
    }

    @GwtIncompatible
    public static boolean fitsInLong(BigInteger bigInteger) {
        return bigInteger.bitLength() <= 63;
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    public static BigInteger listProduct(List<BigInteger> list) {
        return listProduct(list, 0, list.size());
    }

    @GwtIncompatible
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int iCompareTo;
        MathPreconditions.checkPositive("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int iLog2 = (int) ((((double) log2(bigInteger, RoundingMode.FLOOR)) * LN_2) / LN_10);
        BigInteger bigIntegerPow = BigInteger.TEN.pow(iLog2);
        int iCompareTo2 = bigIntegerPow.compareTo(bigInteger);
        if (iCompareTo2 > 0) {
            do {
                iLog2--;
                bigIntegerPow = bigIntegerPow.divide(BigInteger.TEN);
                iCompareTo = bigIntegerPow.compareTo(bigInteger);
            } while (iCompareTo > 0);
        } else {
            BigInteger bigIntegerMultiply = BigInteger.TEN.multiply(bigIntegerPow);
            int i10 = iCompareTo2;
            int iCompareTo3 = bigIntegerMultiply.compareTo(bigInteger);
            while (iCompareTo3 <= 0) {
                iLog2++;
                BigInteger bigIntegerMultiply2 = BigInteger.TEN.multiply(bigIntegerMultiply);
                int iCompareTo4 = bigIntegerMultiply2.compareTo(bigInteger);
                BigInteger bigInteger2 = bigIntegerMultiply;
                bigIntegerMultiply = bigIntegerMultiply2;
                bigIntegerPow = bigInteger2;
                i10 = iCompareTo3;
                iCompareTo3 = iCompareTo4;
            }
            iCompareTo = i10;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(iCompareTo == 0);
            case 2:
            case 3:
                return iLog2;
            case 4:
            case 5:
                return bigIntegerPow.equals(bigInteger) ? iLog2 : iLog2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(bigIntegerPow.pow(2).multiply(BigInteger.TEN)) <= 0 ? iLog2 : iLog2 + 1;
            default:
                throw new AssertionError();
        }
    }

    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", (BigInteger) Preconditions.checkNotNull(bigInteger));
        int iBitLength = bigInteger.bitLength() - 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(bigInteger));
            case 2:
            case 3:
                return iBitLength;
            case 4:
            case 5:
                return isPowerOfTwo(bigInteger) ? iBitLength : iBitLength + 1;
            case 6:
            case 7:
            case 8:
                return iBitLength < 256 ? bigInteger.compareTo(SQRT2_PRECOMPUTED_BITS.shiftRight(256 - iBitLength)) <= 0 ? iBitLength : iBitLength + 1 : bigInteger.pow(2).bitLength() + (-1) < (iBitLength * 2) + 1 ? iBitLength : iBitLength + 1;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", bigInteger);
        if (fitsInLong(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger bigIntegerSqrtFloor = sqrtFloor(bigInteger);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(bigIntegerSqrtFloor.pow(2).equals(bigInteger));
            case 2:
            case 3:
                return bigIntegerSqrtFloor;
            case 4:
            case 5:
                int iIntValue = bigIntegerSqrtFloor.intValue();
                return iIntValue * iIntValue == bigInteger.intValue() && bigIntegerSqrtFloor.pow(2).equals(bigInteger) ? bigIntegerSqrtFloor : bigIntegerSqrtFloor.add(BigInteger.ONE);
            case 6:
            case 7:
            case 8:
                return bigIntegerSqrtFloor.pow(2).add(bigIntegerSqrtFloor).compareTo(bigInteger) >= 0 ? bigIntegerSqrtFloor : bigIntegerSqrtFloor.add(BigInteger.ONE);
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    private static BigInteger sqrtApproxWithDoubles(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible
    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        BigInteger bigIntegerShiftLeft;
        int iLog2 = log2(bigInteger, RoundingMode.FLOOR);
        if (iLog2 < 1023) {
            bigIntegerShiftLeft = sqrtApproxWithDoubles(bigInteger);
        } else {
            int i10 = (iLog2 - 52) & (-2);
            bigIntegerShiftLeft = sqrtApproxWithDoubles(bigInteger.shiftRight(i10)).shiftLeft(i10 >> 1);
        }
        BigInteger bigIntegerShiftRight = bigIntegerShiftLeft.add(bigInteger.divide(bigIntegerShiftLeft)).shiftRight(1);
        if (bigIntegerShiftLeft.equals(bigIntegerShiftRight)) {
            return bigIntegerShiftLeft;
        }
        while (true) {
            BigInteger bigIntegerShiftRight2 = bigIntegerShiftRight.add(bigInteger.divide(bigIntegerShiftRight)).shiftRight(1);
            if (bigIntegerShiftRight2.compareTo(bigIntegerShiftRight) >= 0) {
                return bigIntegerShiftRight;
            }
            bigIntegerShiftRight = bigIntegerShiftRight2;
        }
    }

    public static BigInteger listProduct(List<BigInteger> list, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return BigInteger.ONE;
        }
        if (i12 == 1) {
            return list.get(i10);
        }
        if (i12 == 2) {
            return list.get(i10).multiply(list.get(i10 + 1));
        }
        if (i12 == 3) {
            return list.get(i10).multiply(list.get(i10 + 1)).multiply(list.get(i10 + 2));
        }
        int i13 = (i11 + i10) >>> 1;
        return listProduct(list, i10, i13).multiply(listProduct(list, i13, i11));
    }
}
