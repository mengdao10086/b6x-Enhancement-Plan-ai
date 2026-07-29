package no.nordicsemi.android.dfu.internal.exception;

import ee.a;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteDfuException extends Exception {
    private static final long serialVersionUID = -6901728550661937942L;
    private final int mState;

    public RemoteDfuException(final String message, final int state) {
        super(message);
        this.mState = state;
    }

    public int getErrorNumber() {
        return this.mState;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return super.getMessage() + " (error " + this.mState + a.f26979d;
    }
}
