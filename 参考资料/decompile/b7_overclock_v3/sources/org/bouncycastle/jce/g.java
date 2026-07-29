package org.bouncycastle.jce;

import gm.c0;
import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import zn.d1;
import zn.f1;
import zn.w1;

/* JADX INFO: loaded from: classes5.dex */
public class g {
    public static j a(X509CRL x509crl) throws CRLException {
        try {
            return new j(w1.G(d1.z(c0.D(x509crl.getTBSCertList())).A()));
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    public static j b(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new j(w1.G(f1.A(c0.D(x509Certificate.getTBSCertificate())).B()));
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    public static j c(X509Certificate x509Certificate) throws CertificateEncodingException {
        try {
            return new j(w1.G(f1.A(c0.D(x509Certificate.getTBSCertificate())).G()));
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }
}
