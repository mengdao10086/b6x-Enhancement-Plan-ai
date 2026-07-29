package org.bouncycastle.tsp;

/* JADX INFO: loaded from: classes6.dex */
public class TSPException extends Exception {
    public Throwable underlyingException;

    public TSPException(String str) {
        super(str);
    }

    public TSPException(String str, Throwable th2) {
        super(str);
        this.underlyingException = th2;
    }

    public Exception a() {
        return (Exception) this.underlyingException;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.underlyingException;
    }
}
