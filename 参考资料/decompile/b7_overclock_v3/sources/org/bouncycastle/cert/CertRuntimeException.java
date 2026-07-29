package org.bouncycastle.cert;

/* JADX INFO: loaded from: classes5.dex */
public class CertRuntimeException extends RuntimeException {
    private Throwable cause;

    public CertRuntimeException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
