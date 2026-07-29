package org.bouncycastle.cert.crmf;

/* JADX INFO: loaded from: classes5.dex */
public class CRMFException extends Exception {
    private Throwable cause;

    public CRMFException(String str) {
        this(str, null);
    }

    public CRMFException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
