package com.google.zxing;

/* JADX INFO: loaded from: classes7.dex */
public final class ChecksumException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ChecksumException f21260c;

    static {
        ChecksumException checksumException = new ChecksumException();
        f21260c = checksumException;
        checksumException.setStackTrace(ReaderException.f21264b);
    }

    private ChecksumException() {
    }

    public static ChecksumException b() {
        return ReaderException.f21263a ? new ChecksumException() : f21260c;
    }

    public static ChecksumException c(Throwable th2) {
        return ReaderException.f21263a ? new ChecksumException(th2) : f21260c;
    }

    public ChecksumException(Throwable th2) {
        super(th2);
    }
}
