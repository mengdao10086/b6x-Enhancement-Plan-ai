package org.bouncycastle.tsp;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class TSPIOException extends IOException {
    public Throwable underlyingException;

    public TSPIOException(String str) {
        super(str);
    }

    public TSPIOException(String str, Throwable th2) {
        super(str);
        this.underlyingException = th2;
    }

    public Exception a() {
        return (Exception) this.underlyingException;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlyingException;
    }
}
