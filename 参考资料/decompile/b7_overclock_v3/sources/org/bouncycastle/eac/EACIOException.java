package org.bouncycastle.eac;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class EACIOException extends IOException {
    private Throwable cause;

    public EACIOException(String str) {
        super(str);
    }

    public EACIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
