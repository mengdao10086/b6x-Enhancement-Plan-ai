package org.bouncycastle.mime;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class MimeIOException extends IOException {
    private Throwable cause;

    public MimeIOException(String str) {
        super(str);
    }

    public MimeIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
