package org.bouncycastle.operator;

/* JADX INFO: loaded from: classes6.dex */
public class RuntimeOperatorException extends RuntimeException {
    private Throwable cause;

    public RuntimeOperatorException(String str) {
        super(str);
    }

    public RuntimeOperatorException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
