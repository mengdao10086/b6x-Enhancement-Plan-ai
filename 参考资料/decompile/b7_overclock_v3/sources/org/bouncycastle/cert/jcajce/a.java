package org.bouncycastle.cert.jcajce;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {
    public abstract CertificateFactory a(String str) throws CertificateException, NoSuchProviderException;

    public CertificateFactory b(String str) throws CertificateException, NoSuchProviderException {
        return a(str);
    }
}
