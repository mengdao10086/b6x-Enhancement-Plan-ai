package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class DoubleMath {

    @VisibleForTesting
    public static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;
    private static final double LN_2 = Math.log(2.0d);

    @VisibleForTesting
    public static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
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
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private DoubleMath() {
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    private static double checkFinite(double d10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d10));
        return d10;
    }

    public static double factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        if (i10 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d10 = 1.0d;
        int i11 = i10 & (-16);
        while (true) {
            i11++;
            if (i11 > i10) {
                return d10 * everySixteenthFactorial[i10 >> 4];
            }
            d10 *= (double) i11;
        }
    }

    public static int fuzzyCompare(double d10, double d11, double d12) {
        if (fuzzyEquals(d10, d11, d12)) {
            return 0;
        }
        if (d10 < d11) {
            return -1;
        }
        if (d10 > d11) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d10), Double.isNaN(d11));
    }

    public static boolean fuzzyEquals(double d10, double d11, double d12) {
        MathPreconditions.checkNonNegative("tolerance", d12);
        return Math.copySign(d10 - d11, 1.0d) <= d12 || d10 == d11 || (Double.isNaN(d10) && Double.isNaN(d11));
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d10) {
        return DoubleUtils.isFinite(d10) && (d10 == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d10)) <= Math.getExponent(d10));
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d10) {
        if (d10 <= 0.0d || !DoubleUtils.isFinite(d10)) {
            return false;
        }
        long significand = DoubleUtils.getSignificand(d10);
        return (significand & (significand - 1)) == 0;
    }

    public static double log2(double d10) {
        return Math.log(d10) / LN_2;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double dCheckFinite = checkFinite(dArr[0]);
        long j10 = 1;
        for (int i10 = 1; i10 < dArr.length; i10++) {
            checkFinite(dArr[i10]);
            j10++;
            dCheckFinite += (dArr[i10] - dCheckFinite) / j10;
        }
        return dCheckFinite;
    }

    @GwtIncompatible
    public static double roundIntermediate(double d10, RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(d10)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d10));
                return d10;
            case 2:
                return (d10 >= 0.0d || isMathematicalInteger(d10)) ? d10 : ((long) d10) - 1;
            case 3:
                return (d10 <= 0.0d || isMathematicalInteger(d10)) ? d10 : ((long) d10) + 1;
            case 4:
                return d10;
            case 5:
                if (isMathematicalInteger(d10)) {
                    return d10;
                }
                return ((long) d10) + ((long) (d10 > 0.0d ? 1 : -1));
            case 6:
                return Math.rint(d10);
            case 7:
                double dRint = Math.rint(d10);
                return Math.abs(d10 - dRint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : dRint;
            case 8:
                double dRint2 = Math.rint(d10);
                return Math.abs(d10 - dRint2) == 0.5d ? d10 : dRint2;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d10, RoundingMode roundingMode) {
        double dRoundIntermediate = roundIntermediate(d10, roundingMode);
        if ((dRoundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE) && (MIN_LONG_AS_DOUBLE - dRoundIntermediate < 1.0d)) {
            return BigInteger.valueOf((long) dRoundIntermediate);
        }
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(dRoundIntermediate)).shiftLeft(Math.getExponent(dRoundIntermediate) - 52);
        return dRoundIntermediate < 0.0d ? bigIntegerShiftLeft.negate() : bigIntegerShiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d10, RoundingMode roundingMode) {
        double dRoundIntermediate = roundIntermediate(d10, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((dRoundIntermediate < 2.147483648E9d) & (dRoundIntermediate > -2.147483649E9d), d10, roundingMode);
        return (int) dRoundIntermediate;
    }

    @GwtIncompatible
    public static long roundToLong(double d10, RoundingMode roundingMode) {
        double dRoundIntermediate = roundIntermediate(d10, roundingMode);
        MathPreconditions.checkInRangeForRoundingInputs((MIN_LONG_AS_DOUBLE - dRoundIntermediate < 1.0d) & (dRoundIntermediate < MAX_LONG_AS_DOUBLE_PLUS_ONE), d10, roundingMode);
        return (long) dRoundIntermediate;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int log2(double r5, java.math.RoundingMode r7) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            int r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r4 <= 0) goto L10
            boolean r2 = com.google.common.math.DoubleUtils.isFinite(r5)
            if (r2 == 0) goto L10
            r2 = 1
            goto L11
        L10:
            r2 = 0
        L11:
            java.lang.String r3 = "x must be positive and finite"
            com.google.common.base.Preconditions.checkArgument(r2, r3)
            int r2 = java.lang.Math.getExponent(r5)
            boolean r3 = com.google.common.math.DoubleUtils.isNormal(r5)
            if (r3 != 0) goto L2b
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r5 = r5 * r0
            int r5 = log2(r5, r7)
            int r5 = r5 + (-52)
            return r5
        L2b:
            int[] r3 = com.google.common.math.DoubleMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r7 = r7.ordinal()
            r7 = r3[r7]
            switch(r7) {
                case 1: goto L63;
                case 2: goto L6a;
                case 3: goto L5c;
                case 4: goto L52;
                case 5: goto L4a;
                case 6: goto L3c;
                case 7: goto L3c;
                case 8: goto L3c;
                default: goto L36;
            }
        L36:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L3c:
            double r5 = com.google.common.math.DoubleUtils.scaleNormalize(r5)
            double r5 = r5 * r5
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L6a
            r0 = 1
            goto L6a
        L4a:
            if (r2 < 0) goto L4d
            r0 = 1
        L4d:
            boolean r5 = isPowerOfTwo(r5)
            goto L59
        L52:
            if (r2 >= 0) goto L55
            r0 = 1
        L55:
            boolean r5 = isPowerOfTwo(r5)
        L59:
            r5 = r5 ^ r1
            r0 = r0 & r5
            goto L6a
        L5c:
            boolean r5 = isPowerOfTwo(r5)
            r0 = r5 ^ 1
            goto L6a
        L63:
            boolean r5 = isPowerOfTwo(r5)
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r5)
        L6a:
            if (r0 == 0) goto L6e
            int r2 = r2 + 1
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.DoubleMath.log2(double, java.math.RoundingMode):int");
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j10 = 0;
        for (int i10 : iArr) {
            j10 += (long) i10;
        }
        return j10 / ((double) iArr.length);
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d10 = jArr[0];
        long j10 = 1;
        for (int i10 = 1; i10 < jArr.length; i10++) {
            j10++;
            d10 += (jArr[i10] - d10) / j10;
        }
        return d10;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it2) {
        Preconditions.checkArgument(it2.hasNext(), "Cannot take mean of 0 values");
        double dCheckFinite = checkFinite(it2.next().doubleValue());
        long j10 = 1;
        while (it2.hasNext()) {
            j10++;
            dCheckFinite += (checkFinite(it2.next().doubleValue()) - dCheckFinite) / j10;
        }
        return dCheckFinite;
    }
}
