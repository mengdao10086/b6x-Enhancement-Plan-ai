package org.bouncycastle.jce.exception;

import dr.a;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ExtIOException extends IOException implements a {
    private Throwable cause;

    public ExtIOException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable, dr.a
    public Throwable getCause() {
        return this.cause;
    }
}
