package no.nordicsemi.android.dfu.internal.exception;

import ee.a;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteDfuExtendedErrorException extends RemoteDfuException {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mError;

    public RemoteDfuExtendedErrorException(final String message, final int extendedError) {
        super(message, 11);
        this.mError = extendedError;
    }

    public int getExtendedErrorNumber() {
        return this.mError;
    }

    @Override // no.nordicsemi.android.dfu.internal.exception.RemoteDfuException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (extended error " + this.mError + a.f26979d;
    }
}
