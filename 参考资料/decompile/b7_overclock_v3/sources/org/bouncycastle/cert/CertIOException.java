package org.bouncycastle.cert;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class CertIOException extends IOException {
    private Throwable cause;

    public CertIOException(String str) {
        super(str);
    }

    public CertIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
