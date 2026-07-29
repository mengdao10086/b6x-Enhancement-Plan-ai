package com.google.zxing;

/* JADX INFO: loaded from: classes7.dex */
public final class NotFoundException extends ReaderException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NotFoundException f21262c;

    static {
        NotFoundException notFoundException = new NotFoundException();
        f21262c = notFoundException;
        notFoundException.setStackTrace(ReaderException.f21264b);
    }

    private NotFoundException() {
    }

    public static NotFoundException b() {
        return ReaderException.f21263a ? new NotFoundException() : f21262c;
    }
}
