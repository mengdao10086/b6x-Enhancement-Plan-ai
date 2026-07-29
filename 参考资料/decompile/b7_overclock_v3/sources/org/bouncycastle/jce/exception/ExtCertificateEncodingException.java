package org.bouncycastle.jce.exception;

import dr.a;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public class ExtCertificateEncodingException extends CertificateEncodingException implements a {
    private Throwable cause;

    public ExtCertificateEncodingException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable, dr.a
    public Throwable getCause() {
        return this.cause;
    }
}
