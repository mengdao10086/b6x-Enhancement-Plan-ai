package org.bouncycastle.util;

/* JADX INFO: loaded from: classes6.dex */
public class StreamParsingException extends Exception {
    public Throwable _e;

    public StreamParsingException(String str, Throwable th2) {
        super(str);
        this._e = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this._e;
    }
}
