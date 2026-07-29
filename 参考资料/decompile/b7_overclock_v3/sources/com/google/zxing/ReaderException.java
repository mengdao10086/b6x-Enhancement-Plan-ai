package com.google.zxing;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ReaderException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f21263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final StackTraceElement[] f21264b;

    static {
        f21263a = System.getProperty("surefire.test.class.path") != null;
        f21264b = new StackTraceElement[0];
    }

    public ReaderException() {
    }

    public static void a(boolean z10) {
        f21263a = z10;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public ReaderException(Throwable th2) {
        super(th2);
    }
}
