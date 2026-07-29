package org.bouncycastle.jce.exception;

import dr.a;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;

/* JADX INFO: loaded from: classes5.dex */
public class ExtCertPathBuilderException extends CertPathBuilderException implements a {
    private Throwable cause;

    public ExtCertPathBuilderException(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    public ExtCertPathBuilderException(String str, Throwable th2, CertPath certPath, int i10) {
        super(str, th2);
        this.cause = th2;
    }

    @Override // java.lang.Throwable, dr.a
    public Throwable getCause() {
        return this.cause;
    }
}
