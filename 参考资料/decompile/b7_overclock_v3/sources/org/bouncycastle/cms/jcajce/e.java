package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.cert.X509CertSelector;
import so.a2;
import so.h1;

/* JADX INFO: loaded from: classes5.dex */
public class e {
    public h1 a(X509CertSelector x509CertSelector) {
        try {
            return x509CertSelector.getSubjectKeyIdentifier() != null ? new h1(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber(), gm.z.I(x509CertSelector.getSubjectKeyIdentifier()).J()) : new h1(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber());
        } catch (IOException e10) {
            throw new IllegalArgumentException("unable to convert issuer: " + e10.getMessage());
        }
    }

    public a2 b(X509CertSelector x509CertSelector) {
        try {
            return x509CertSelector.getSubjectKeyIdentifier() != null ? new a2(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber(), gm.z.I(x509CertSelector.getSubjectKeyIdentifier()).J()) : new a2(xn.d.A(x509CertSelector.getIssuerAsBytes()), x509CertSelector.getSerialNumber());
        } catch (IOException e10) {
            throw new IllegalArgumentException("unable to convert issuer: " + e10.getMessage());
        }
    }
}
