package org.bouncycastle.pkcs;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class PKCSIOException extends IOException {
    private Throwable cause;

    public PKCSIOException(String str) {
        super(str);
    }

    public PKCSIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
