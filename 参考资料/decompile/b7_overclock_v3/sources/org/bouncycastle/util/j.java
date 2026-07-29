package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46044a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f46045b = 32;

    public static int a(int i10) {
        return Integer.numberOfLeadingZeros(i10);
    }

    public static int b(int i10) {
        return Integer.numberOfTrailingZeros(i10);
    }

    public static int c(int i10) {
        return Integer.reverse(i10);
    }

    public static int d(int i10) {
        return Integer.reverseBytes(i10);
    }

    public static int e(int i10, int i11) {
        return Integer.rotateLeft(i10, i11);
    }

    public static int f(int i10, int i11) {
        return Integer.rotateRight(i10, i11);
    }

    public static Integer g(int i10) {
        return Integer.valueOf(i10);
    }
}
