package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
final class DoubleUtils {
    public static final int EXPONENT_BIAS = 1023;
    public static final long EXPONENT_MASK = 9218868437227405312L;
    public static final long IMPLICIT_BIT = 4503599627370496L;

    @VisibleForTesting
    public static final long ONE_BITS = 4607182418800017408L;
    public static final int SIGNIFICAND_BITS = 52;
    public static final long SIGNIFICAND_MASK = 4503599627370495L;
    public static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    public static double bigToDouble(BigInteger bigInteger) {
        BigInteger bigIntegerAbs = bigInteger.abs();
        boolean z10 = true;
        int iBitLength = bigIntegerAbs.bitLength() - 1;
        if (iBitLength < 63) {
            return bigInteger.longValue();
        }
        if (iBitLength > 1023) {
            return ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        }
        int i10 = (iBitLength - 52) - 1;
        long jLongValue = bigIntegerAbs.shiftRight(i10).longValue();
        long j10 = (jLongValue >> 1) & SIGNIFICAND_MASK;
        if ((jLongValue & 1) == 0 || ((j10 & 1) == 0 && bigIntegerAbs.getLowestSetBit() >= i10)) {
            z10 = false;
        }
        if (z10) {
            j10++;
        }
        return Double.longBitsToDouble(((((long) (iBitLength + 1023)) << 52) + j10) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
    }

    public static double ensureNonNegative(double d10) {
        Preconditions.checkArgument(!Double.isNaN(d10));
        if (d10 > 0.0d) {
            return d10;
        }
        return 0.0d;
    }

    public static long getSignificand(double d10) {
        Preconditions.checkArgument(isFinite(d10), "not a normal value");
        int exponent = Math.getExponent(d10);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10) & SIGNIFICAND_MASK;
        return exponent == -1023 ? jDoubleToRawLongBits << 1 : jDoubleToRawLongBits | IMPLICIT_BIT;
    }

    public static boolean isFinite(double d10) {
        return Math.getExponent(d10) <= 1023;
    }

    public static boolean isNormal(double d10) {
        return Math.getExponent(d10) >= -1022;
    }

    public static double nextDown(double d10) {
        return -Math.nextUp(-d10);
    }

    public static double scaleNormalize(double d10) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(d10) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
