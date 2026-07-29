package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class ASN1Exception extends IOException {
    private Throwable cause;

    public ASN1Exception(String str) {
        super(str);
    }

    public ASN1Exception(String str, Throwable th2) {
        super(str);
        this.cause = th2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
