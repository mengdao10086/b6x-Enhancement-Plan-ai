package org.bouncycastle.jcajce.provider.util;

import javax.crypto.BadPaddingException;

/* JADX INFO: loaded from: classes5.dex */
public class BadBlockException extends BadPaddingException {
    private final Throwable cause;

    public BadBlockException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
