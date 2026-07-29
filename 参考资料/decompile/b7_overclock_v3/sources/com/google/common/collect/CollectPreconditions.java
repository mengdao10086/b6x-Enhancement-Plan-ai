package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
final class CollectPreconditions {
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    @CanIgnoreReturnValue
    public static int checkNonnegative(int i10, String str) {
        if (i10 >= 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i10);
    }

    public static void checkPositive(int i10, String str) {
        if (i10 > 0) {
            return;
        }
        throw new IllegalArgumentException(str + " must be positive but was: " + i10);
    }

    public static void checkRemove(boolean z10) {
        Preconditions.checkState(z10, "no calls to next() since the last call to remove()");
    }

    @CanIgnoreReturnValue
    public static long checkNonnegative(long j10, String str) {
        if (j10 >= 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j10);
    }
}
