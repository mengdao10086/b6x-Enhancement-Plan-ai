package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* JADX INFO: loaded from: classes5.dex */
public class b extends a {
    @Override // org.bouncycastle.cert.jcajce.a
    public CertificateFactory a(String str) throws CertificateException {
        return CertificateFactory.getInstance(str);
    }
}
