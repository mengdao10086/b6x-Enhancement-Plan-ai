package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46046a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f46047b = 64;

    public static int a(long j10) {
        return Long.numberOfLeadingZeros(j10);
    }

    public static int b(long j10) {
        return Long.numberOfTrailingZeros(j10);
    }

    public static long c(long j10) {
        return Long.reverse(j10);
    }

    public static long d(long j10) {
        return Long.reverseBytes(j10);
    }

    public static long e(long j10, int i10) {
        return Long.rotateLeft(j10, i10);
    }

    public static long f(long j10, int i10) {
        return Long.rotateRight(j10, i10);
    }

    public static Long g(long j10) {
        return Long.valueOf(j10);
    }
}
