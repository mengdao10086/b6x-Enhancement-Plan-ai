package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public final class UnsignedInts {
    public static final long INT_MASK = 4294967295L;

    public enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                if (iArr[i10] != iArr2[i10]) {
                    return UnsignedInts.compare(iArr[i10], iArr2[i10]);
                }
            }
            return iArr.length - iArr2.length;
        }
    }

    private UnsignedInts() {
    }

    public static int checkedCast(long j10) {
        Preconditions.checkArgument((j10 >> 32) == 0, "out of range: %s", j10);
        return (int) j10;
    }

    public static int compare(int i10, int i11) {
        return Ints.compare(flip(i10), flip(i11));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest parseRequestFromString = ParseRequest.fromString(str);
        try {
            return parseUnsignedInt(parseRequestFromString.rawValue, parseRequestFromString.radix);
        } catch (NumberFormatException e10) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e10);
            throw numberFormatException;
        }
    }

    public static int divide(int i10, int i11) {
        return (int) (toLong(i10) / toLong(i11));
    }

    public static int flip(int i10) {
        return i10 ^ Integer.MIN_VALUE;
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(iArr.length * 5);
        sb2.append(toString(iArr[0]));
        for (int i10 = 1; i10 < iArr.length; i10++) {
            sb2.append(str);
            sb2.append(toString(iArr[i10]));
        }
        return sb2.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int iFlip = flip(iArr[0]);
        for (int i10 = 1; i10 < iArr.length; i10++) {
            int iFlip2 = flip(iArr[i10]);
            if (iFlip2 > iFlip) {
                iFlip = iFlip2;
            }
        }
        return flip(iFlip);
    }

    public static int min(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0);
        int iFlip = flip(iArr[0]);
        for (int i10 = 1; i10 < iArr.length; i10++) {
            int iFlip2 = flip(iArr[i10]);
            if (iFlip2 < iFlip) {
                iFlip = iFlip2;
            }
        }
        return flip(iFlip);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int remainder(int i10, int i11) {
        return (int) (toLong(i10) % toLong(i11));
    }

    public static int saturatedCast(long j10) {
        if (j10 <= 0) {
            return 0;
        }
        if (j10 >= 4294967296L) {
            return -1;
        }
        return (int) j10;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i10) {
        return ((long) i10) & 4294967295L;
    }

    public static String toString(int i10) {
        return toString(i10, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i10) {
        Preconditions.checkNotNull(str);
        long j10 = Long.parseLong(str, i10);
        if ((4294967295L & j10) == j10) {
            return (int) j10;
        }
        throw new NumberFormatException("Input " + str + " in base " + i10 + " is not in the range of an unsigned integer");
    }

    public static String toString(int i10, int i11) {
        return Long.toString(((long) i10) & 4294967295L, i11);
    }

    public static void sort(int[] iArr, int i10, int i11) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i10, i11, iArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            iArr[i12] = flip(iArr[i12]);
        }
        Arrays.sort(iArr, i10, i11);
        while (i10 < i11) {
            iArr[i10] = flip(iArr[i10]);
            i10++;
        }
    }

    public static void sortDescending(int[] iArr, int i10, int i11) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i10, i11, iArr.length);
        for (int i12 = i10; i12 < i11; i12++) {
            iArr[i12] = Integer.MAX_VALUE ^ iArr[i12];
        }
        Arrays.sort(iArr, i10, i11);
        while (i10 < i11) {
            iArr[i10] = iArr[i10] ^ Integer.MAX_VALUE;
            i10++;
        }
    }
}
