package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int i10, double d10) {
        int iMax = Math.max(i10, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d10 * ((double) iHighestOneBit)))) {
            return iHighestOneBit;
        }
        int i11 = iHighestOneBit << 1;
        if (i11 > 0) {
            return i11;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i10, int i11, double d10) {
        return ((double) i10) > d10 * ((double) i11) && i11 < 1073741824;
    }

    public static int smear(int i10) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i10) * C1), 15)) * C2);
    }

    public static int smearedHash(@NullableDecl Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
