package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import ee.a;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@CanIgnoreReturnValue
@GwtCompatible
final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRangeForRoundingInputs(boolean z10, double d10, RoundingMode roundingMode) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d10 + " and rounding mode " + roundingMode);
    }

    public static void checkNoOverflow(boolean z10, String str, int i10, int i11) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + a.f26978c + i10 + ", " + i11 + a.f26979d);
    }

    public static int checkNonNegative(@NullableDecl String str, int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " (" + i10 + ") must be >= 0");
    }

    public static int checkPositive(@NullableDecl String str, int i10) {
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " (" + i10 + ") must be > 0");
    }

    public static void checkRoundingUnnecessary(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }

    public static void checkNoOverflow(boolean z10, String str, long j10, long j11) {
        if (z10) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + a.f26978c + j10 + ", " + j11 + a.f26979d);
    }

    public static long checkNonNegative(@NullableDecl String str, long j10) {
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " (" + j10 + ") must be >= 0");
    }

    public static long checkPositive(@NullableDecl String str, long j10) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " (" + j10 + ") must be > 0");
    }

    public static BigInteger checkNonNegative(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    public static BigInteger checkPositive(@NullableDecl String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    public static double checkNonNegative(@NullableDecl String str, double d10) {
        if (d10 >= 0.0d) {
            return d10;
        }
        throw new IllegalArgumentException(str + " (" + d10 + ") must be >= 0");
    }
}
