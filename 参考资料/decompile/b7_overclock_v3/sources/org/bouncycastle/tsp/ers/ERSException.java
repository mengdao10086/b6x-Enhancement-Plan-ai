package org.bouncycastle.tsp.ers;

/* JADX INFO: loaded from: classes6.dex */
public class ERSException extends Exception {
    private final Throwable cause;

    public ERSException(String str) {
        this(str, null);
    }

    public ERSException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
