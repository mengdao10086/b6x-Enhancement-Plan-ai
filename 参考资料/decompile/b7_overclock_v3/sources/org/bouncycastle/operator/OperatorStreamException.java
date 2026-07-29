package org.bouncycastle.operator;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class OperatorStreamException extends IOException {
    private Throwable cause;

    public OperatorStreamException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
