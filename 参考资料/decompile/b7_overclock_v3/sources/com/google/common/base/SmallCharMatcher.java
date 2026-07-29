package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    public static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j10, boolean z10, String str) {
        super(str);
        this.table = cArr;
        this.filter = j10;
        this.containsZero = z10;
    }

    private boolean checkFilter(int i10) {
        return 1 == ((this.filter >> i10) & 1);
    }

    @VisibleForTesting
    public static int chooseTableSize(int i10) {
        if (i10 == 1) {
            return 2;
        }
        int iHighestOneBit = Integer.highestOneBit(i10 - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < i10) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static CharMatcher from(BitSet bitSet, String str) {
        int i10;
        int iCardinality = bitSet.cardinality();
        boolean z10 = bitSet.get(0);
        int iChooseTableSize = chooseTableSize(iCardinality);
        char[] cArr = new char[iChooseTableSize];
        int i11 = iChooseTableSize - 1;
        int iNextSetBit = bitSet.nextSetBit(0);
        long j10 = 0;
        while (iNextSetBit != -1) {
            long j11 = (1 << iNextSetBit) | j10;
            int iSmear = smear(iNextSetBit);
            while (true) {
                i10 = iSmear & i11;
                if (cArr[i10] == 0) {
                    break;
                }
                iSmear = i10 + 1;
            }
            cArr[i10] = (char) iNextSetBit;
            iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
            j10 = j11;
        }
        return new SmallCharMatcher(cArr, j10, z10, str);
    }

    public static int smear(int i10) {
        return Integer.rotateLeft(i10 * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c10) {
        if (c10 == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c10)) {
            return false;
        }
        int length = this.table.length - 1;
        int iSmear = smear(c10) & length;
        int i10 = iSmear;
        do {
            char[] cArr = this.table;
            if (cArr[i10] == 0) {
                return false;
            }
            if (cArr[i10] == c10) {
                return true;
            }
            i10 = (i10 + 1) & length;
        } while (i10 != iSmear);
        return false;
    }

    @Override // com.google.common.base.CharMatcher
    public void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c10 : this.table) {
            if (c10 != 0) {
                bitSet.set(c10);
            }
        }
    }
}
