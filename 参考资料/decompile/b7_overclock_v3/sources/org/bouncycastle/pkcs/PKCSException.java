package org.bouncycastle.pkcs;

/* JADX INFO: loaded from: classes6.dex */
public class PKCSException extends Exception {
    private Throwable cause;

    public PKCSException(String str) {
        super(str);
    }

    public PKCSException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
