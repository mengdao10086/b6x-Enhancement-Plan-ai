package no.nordicsemi.android.dfu.internal.exception;

import ee.a;

/* JADX INFO: loaded from: classes5.dex */
public class DfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public DfuException(final String message, final int state) {
        super(message);
        this.mError = state;
    }

    public int getErrorNumber() {
        return this.mError;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + (this.mError & (-16385)) + a.f26979d;
    }
}
