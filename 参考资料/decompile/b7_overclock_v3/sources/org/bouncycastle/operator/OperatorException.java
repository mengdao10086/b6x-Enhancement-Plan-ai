package org.bouncycastle.operator;

/* JADX INFO: loaded from: classes6.dex */
public class OperatorException extends Exception {
    private Throwable cause;

    public OperatorException(String str) {
        super(str);
    }

    public OperatorException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
