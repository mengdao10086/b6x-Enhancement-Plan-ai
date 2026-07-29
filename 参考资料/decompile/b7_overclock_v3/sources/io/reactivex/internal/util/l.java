package io.reactivex.internal.util;

/* JADX INFO: loaded from: classes5.dex */
public final class l {
    public l() {
        throw new IllegalStateException("No instances!");
    }

    public static boolean a(int i10) {
        return (i10 & (i10 + (-1))) == 0;
    }

    public static int b(int i10) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i10 - 1));
    }
}
