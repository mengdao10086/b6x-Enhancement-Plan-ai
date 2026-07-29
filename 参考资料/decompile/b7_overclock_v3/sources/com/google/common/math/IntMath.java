package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import s0.c;
import w.w;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
public final class IntMath {

    @VisibleForTesting
    public static final int FLOOR_SQRT_MAX_INT = 46340;

    @VisibleForTesting
    public static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;

    @VisibleForTesting
    public static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;

    @VisibleForTesting
    public static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    @VisibleForTesting
    public static final int[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    @VisibleForTesting
    public static final int[] halfPowersOf10 = {3, 31, w.a.f53655q, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    @VisibleForTesting
    public static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, c.f49294u, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
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

    private IntMath() {
    }

    public static int binomial(int i10, int i11) {
        MathPreconditions.checkNonNegative("n", i10);
        MathPreconditions.checkNonNegative("k", i11);
        int i12 = 0;
        Preconditions.checkArgument(i11 <= i10, "k (%s) > n (%s)", i11, i10);
        if (i11 > (i10 >> 1)) {
            i11 = i10 - i11;
        }
        int[] iArr = biggestBinomials;
        if (i11 >= iArr.length || i10 > iArr[i11]) {
            return Integer.MAX_VALUE;
        }
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return i10;
        }
        long j10 = 1;
        while (i12 < i11) {
            long j11 = j10 * ((long) (i10 - i12));
            i12++;
            j10 = j11 / ((long) i12);
        }
        return (int) j10;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i10) {
        MathPreconditions.checkPositive("x", i10);
        if (i10 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i10 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i10 + ") not representable as an int");
    }

    public static int checkedAdd(int i10, int i11) {
        long j10 = ((long) i10) + ((long) i11);
        int i12 = (int) j10;
        MathPreconditions.checkNoOverflow(j10 == ((long) i12), "checkedAdd", i10, i11);
        return i12;
    }

    public static int checkedMultiply(int i10, int i11) {
        long j10 = ((long) i10) * ((long) i11);
        int i12 = (int) j10;
        MathPreconditions.checkNoOverflow(j10 == ((long) i12), "checkedMultiply", i10, i11);
        return i12;
    }

    public static int checkedPow(int i10, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        if (i10 == -2) {
            MathPreconditions.checkNoOverflow(i11 < 32, "checkedPow", i10, i11);
            return (i11 & 1) == 0 ? 1 << i11 : (-1) << i11;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            MathPreconditions.checkNoOverflow(i11 < 31, "checkedPow", i10, i11);
            return 1 << i11;
        }
        int iCheckedMultiply = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return checkedMultiply(iCheckedMultiply, i10);
            }
            if ((i11 & 1) != 0) {
                iCheckedMultiply = checkedMultiply(iCheckedMultiply, i10);
            }
            i11 >>= 1;
            if (i11 > 0) {
                MathPreconditions.checkNoOverflow((-46340 <= i10) & (i10 <= 46340), "checkedPow", i10, i11);
                i10 *= i10;
            }
        }
        return iCheckedMultiply;
    }

    public static int checkedSubtract(int i10, int i11) {
        long j10 = ((long) i10) - ((long) i11);
        int i12 = (int) j10;
        MathPreconditions.checkNoOverflow(j10 == ((long) i12), "checkedSubtract", i10, i11);
        return i12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L5c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.AnonymousClass1.$SwitchMap$java$math$RoundingMode
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L47
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L58
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            r7 = r0 & 1
            if (r7 == 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r6 = r6 & r7
            if (r6 == 0) goto L57
            goto L58
        L47:
            if (r1 <= 0) goto L57
            goto L58
        L4a:
            if (r5 <= 0) goto L57
            goto L58
        L4d:
            if (r5 >= 0) goto L57
            goto L58
        L50:
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            com.google.common.math.MathPreconditions.checkRoundingUnnecessary(r2)
        L57:
            r2 = 0
        L58:
            if (r2 == 0) goto L5b
            int r0 = r0 + r5
        L5b:
            return r0
        L5c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int factorial(int i10) {
        MathPreconditions.checkNonNegative("n", i10);
        int[] iArr = factorials;
        if (i10 < iArr.length) {
            return iArr[i10];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i10) {
        MathPreconditions.checkPositive("x", i10);
        return Integer.highestOneBit(i10);
    }

    public static int gcd(int i10, int i11) {
        MathPreconditions.checkNonNegative("a", i10);
        MathPreconditions.checkNonNegative("b", i11);
        if (i10 == 0) {
            return i11;
        }
        if (i11 == 0) {
            return i10;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
        int iNumberOfTrailingZeros2 = i10 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(i11);
        int i12 = i11 >> iNumberOfTrailingZeros3;
        while (iNumberOfTrailingZeros2 != i12) {
            int i13 = iNumberOfTrailingZeros2 - i12;
            int i14 = (i13 >> 31) & i13;
            int i15 = (i13 - i14) - i14;
            i12 += i14;
            iNumberOfTrailingZeros2 = i15 >> Integer.numberOfTrailingZeros(i15);
        }
        return iNumberOfTrailingZeros2 << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
    }

    public static boolean isPowerOfTwo(int i10) {
        return (i10 > 0) & ((i10 & (i10 + (-1))) == 0);
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int i10) {
        return LongMath.isPrime(i10);
    }

    @VisibleForTesting
    public static int lessThanBranchFree(int i10, int i11) {
        return (~(~(i10 - i11))) >>> 31;
    }

    @GwtIncompatible
    public static int log10(int i10, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkPositive("x", i10);
        int iLog10Floor = log10Floor(i10);
        int i11 = powersOf10[iLog10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i10 == i11);
            case 2:
            case 3:
                return iLog10Floor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(i11, i10);
                return iLog10Floor + iLessThanBranchFree;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree(halfPowersOf10[iLog10Floor], i10);
                return iLog10Floor + iLessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int log10Floor(int i10) {
        byte b10 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i10)];
        return b10 - lessThanBranchFree(i10, powersOf10[b10]);
    }

    public static int log2(int i10, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i10);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i10 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
                return (31 - iNumberOfLeadingZeros) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> iNumberOfLeadingZeros, i10);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static int mean(int i10, int i11) {
        return (i10 & i11) + ((i10 ^ i11) >> 1);
    }

    public static int mod(int i10, int i11) {
        if (i11 > 0) {
            int i12 = i10 % i11;
            return i12 >= 0 ? i12 : i12 + i11;
        }
        throw new ArithmeticException("Modulus " + i11 + " must be > 0");
    }

    @GwtIncompatible
    public static int pow(int i10, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        if (i10 == -2) {
            if (i11 < 32) {
                return (i11 & 1) == 0 ? 1 << i11 : -(1 << i11);
            }
            return 0;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            if (i11 < 32) {
                return 1 << i11;
            }
            return 0;
        }
        int i12 = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return i10 * i12;
            }
            i12 *= (i11 & 1) == 0 ? 1 : i10;
            i10 *= i10;
            i11 >>= 1;
        }
        return i12;
    }

    @Beta
    public static int saturatedAdd(int i10, int i11) {
        return Ints.saturatedCast(((long) i10) + ((long) i11));
    }

    @Beta
    public static int saturatedMultiply(int i10, int i11) {
        return Ints.saturatedCast(((long) i10) * ((long) i11));
    }

    @Beta
    public static int saturatedPow(int i10, int i11) {
        MathPreconditions.checkNonNegative("exponent", i11);
        if (i10 == -2) {
            return i11 >= 32 ? (i11 & 1) + Integer.MAX_VALUE : (i11 & 1) == 0 ? 1 << i11 : (-1) << i11;
        }
        if (i10 == -1) {
            return (i11 & 1) == 0 ? 1 : -1;
        }
        if (i10 == 0) {
            return i11 == 0 ? 1 : 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2) {
            if (i11 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << i11;
        }
        int i12 = ((i10 >>> 31) & i11 & 1) + Integer.MAX_VALUE;
        int iSaturatedMultiply = 1;
        while (i11 != 0) {
            if (i11 == 1) {
                return saturatedMultiply(iSaturatedMultiply, i10);
            }
            if ((i11 & 1) != 0) {
                iSaturatedMultiply = saturatedMultiply(iSaturatedMultiply, i10);
            }
            i11 >>= 1;
            if (i11 > 0) {
                if ((-46340 > i10) || (i10 > 46340)) {
                    return i12;
                }
                i10 *= i10;
            }
        }
        return iSaturatedMultiply;
    }

    @Beta
    public static int saturatedSubtract(int i10, int i11) {
        return Ints.saturatedCast(((long) i10) - ((long) i11));
    }

    @GwtIncompatible
    public static int sqrt(int i10, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkNonNegative("x", i10);
        int iSqrtFloor = sqrtFloor(i10);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(iSqrtFloor * iSqrtFloor == i10);
            case 2:
            case 3:
                return iSqrtFloor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(iSqrtFloor * iSqrtFloor, i10);
                return iSqrtFloor + iLessThanBranchFree;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree((iSqrtFloor * iSqrtFloor) + iSqrtFloor, i10);
                return iSqrtFloor + iLessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int sqrtFloor(int i10) {
        return (int) Math.sqrt(i10);
    }
}
