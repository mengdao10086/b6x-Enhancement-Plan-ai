package org.bouncycastle.cert.jcajce;

import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/* JADX INFO: loaded from: classes5.dex */
public class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44492a;

    public m(String str) {
        this.f44492a = str;
    }

    @Override // org.bouncycastle.cert.jcajce.a
    public CertificateFactory a(String str) throws CertificateException, NoSuchProviderException {
        return CertificateFactory.getInstance(str, this.f44492a);
    }
}
