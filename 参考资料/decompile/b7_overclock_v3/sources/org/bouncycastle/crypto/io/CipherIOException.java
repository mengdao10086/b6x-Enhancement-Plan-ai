package org.bouncycastle.crypto.io;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class CipherIOException extends IOException {
    private static final long serialVersionUID = 1;
    private final Throwable cause;

    public CipherIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
