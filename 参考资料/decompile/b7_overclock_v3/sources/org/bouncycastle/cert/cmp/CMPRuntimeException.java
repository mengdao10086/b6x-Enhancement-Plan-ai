package org.bouncycastle.cert.cmp;

/* JADX INFO: loaded from: classes5.dex */
public class CMPRuntimeException extends RuntimeException {
    private Throwable cause;

    public CMPRuntimeException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
