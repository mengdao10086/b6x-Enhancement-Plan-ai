package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            int iMin = Math.min(jArr.length, jArr2.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                if (jArr[i10] != jArr2[i10]) {
                    return UnsignedLongs.compare(jArr[i10], jArr2[i10]);
                }
            }
            return jArr.length - jArr2.length;
        }
    }

    public static final class ParseOverflowDetection {
        public static final long[] maxValueDivs = new long[37];
        public static final int[] maxValueMods = new int[37];
        public static final int[] maxSafeDigits = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = i10;
                maxValueDivs[i10] = UnsignedLongs.divide(-1L, j10);
                maxValueMods[i10] = (int) UnsignedLongs.remainder(-1L, j10);
                maxSafeDigits[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        public static boolean overflowInParse(long j10, int i10, int i11) {
            if (j10 < 0) {
                return true;
            }
            long[] jArr = maxValueDivs;
            if (j10 < jArr[i11]) {
                return false;
            }
            return j10 > jArr[i11] || i10 > maxValueMods[i11];
        }
    }

    private UnsignedLongs() {
    }

    public static int compare(long j10, long j11) {
        return Longs.compare(flip(j10), flip(j11));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest parseRequestFromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedLong(parseRequestFromString.rawValue, parseRequestFromString.radix);
        } catch (NumberFormatException e10) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static long divide(long j10, long j11) {
        if (j11 < 0) {
            return compare(j10, j11) < 0 ? 0L : 1L;
        }
        if (j10 >= 0) {
            return j10 / j11;
        }
        long j12 = ((j10 >>> 1) / j11) << 1;
        return j12 + ((long) (compare(j10 - (j12 * j11), j11) < 0 ? 0 : 1));
    }

    private static long flip(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(jArr.length * 5);
        sb2.append(toString(jArr[0]));
        for (int i10 = 1; i10 < jArr.length; i10++) {
            sb2.append(str);
            sb2.append(toString(jArr[i10]));
        }
        return sb2.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long jFlip = flip(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long jFlip2 = flip(jArr[i10]);
            if (jFlip2 > jFlip) {
                jFlip = jFlip2;
            }
        }
        return flip(jFlip);
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long jFlip = flip(jArr[0]);
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long jFlip2 = flip(jArr[i10]);
            if (jFlip2 < jFlip) {
                jFlip = jFlip2;
            }
        }
        return flip(jFlip);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j10, long j11) {
        if (j11 < 0) {
            return compare(j10, j11) < 0 ? j10 : j10 - j11;
        }
        if (j10 >= 0) {
            return j10 % j11;
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (compare(j12, j11) < 0) {
            j11 = 0;
        }
        return j12 - j11;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j10) {
        return toString(j10, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i10) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        if (i10 < 2 || i10 > 36) {
            throw new NumberFormatException("illegal radix: " + i10);
        }
        int i11 = ParseOverflowDetection.maxSafeDigits[i10] - 1;
        long j10 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            int iDigit = Character.digit(str.charAt(i12), i10);
            if (iDigit == -1) {
                throw new NumberFormatException(str);
            }
            if (i12 > i11 && ParseOverflowDetection.overflowInParse(j10, iDigit, i10)) {
                throw new NumberFormatException("Too large for unsigned long: " + str);
            }
            j10 = (j10 * ((long) i10)) + ((long) iDigit);
        }
        return j10;
    }

    public static String toString(long j10, int i10) {
        Preconditions.checkArgument(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        if (j10 == 0) {
            return "0";
        }
        if (j10 > 0) {
            return Long.toString(j10, i10);
        }
        int i11 = 64;
        char[] cArr = new char[64];
        int i12 = i10 - 1;
        if ((i10 & i12) == 0) {
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
            do {
                i11--;
                cArr[i11] = Character.forDigit(((int) j10) & i12, i10);
                j10 >>>= iNumberOfTrailingZeros;
            } while (j10 != 0);
        } else {
            long jDivide = (i10 & 1) == 0 ? (j10 >>> 1) / ((long) (i10 >>> 1)) : divide(j10, i10);
            long j11 = i10;
            cArr[63] = Character.forDigit((int) (j10 - (jDivide * j11)), i10);
            i11 = 63;
            while (jDivide > 0) {
                i11--;
                cArr[i11] = Character.forDigit((int) (jDivide % j11), i10);
                jDivide /= j11;
            }
        }
        return new String(cArr, i11, 64 - i11);
    }

    public static void sort(long[] jArr, int i10, int i11) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = flip(jArr[i12]);
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = flip(jArr[i10]);
            i10++;
        }
    }

    public static void sortDescending(long[] jArr, int i10, int i11) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i10, i11, jArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            jArr[i12] = Long.MAX_VALUE ^ jArr[i12];
        }
        Arrays.sort(jArr, i10, i11);
        while (i10 < i11) {
            jArr[i10] = jArr[i10] ^ Long.MAX_VALUE;
            i10++;
        }
    }
}
