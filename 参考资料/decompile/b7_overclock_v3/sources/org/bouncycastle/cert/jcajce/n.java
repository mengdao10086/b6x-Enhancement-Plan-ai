package org.bouncycastle.cert.jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* JADX INFO: loaded from: classes5.dex */
public class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f44493a;

    public n(Provider provider) {
        this.f44493a = provider;
    }

    @Override // org.bouncycastle.cert.jcajce.a
    public CertificateFactory a(String str) throws CertificateException {
        return CertificateFactory.getInstance(str, this.f44493a);
    }
}
