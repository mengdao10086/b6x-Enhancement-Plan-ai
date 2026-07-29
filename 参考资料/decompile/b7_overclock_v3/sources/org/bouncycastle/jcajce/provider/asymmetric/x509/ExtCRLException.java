package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

/* JADX INFO: loaded from: classes7.dex */
class ExtCRLException extends CRLException {
    public Throwable cause;

    public ExtCRLException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
