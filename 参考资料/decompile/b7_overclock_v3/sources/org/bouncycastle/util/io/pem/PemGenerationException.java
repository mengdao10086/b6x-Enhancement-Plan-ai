package org.bouncycastle.util.io.pem;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class PemGenerationException extends IOException {
    private Throwable cause;

    public PemGenerationException(String str) {
        super(str);
    }

    public PemGenerationException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
