package com.google.zxing;

/* JADX INFO: loaded from: classes7.dex */
public final class FormatException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FormatException f21261c;

    static {
        FormatException formatException = new FormatException();
        f21261c = formatException;
        formatException.setStackTrace(ReaderException.f21264b);
    }

    private FormatException() {
    }

    public static FormatException b() {
        return ReaderException.f21263a ? new FormatException() : f21261c;
    }

    public static FormatException c(Throwable th2) {
        return ReaderException.f21263a ? new FormatException(th2) : f21261c;
    }

    public FormatException(Throwable th2) {
        super(th2);
    }
}
