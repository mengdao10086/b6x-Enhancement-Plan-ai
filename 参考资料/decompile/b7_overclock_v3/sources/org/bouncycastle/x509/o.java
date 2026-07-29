package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes6.dex */
public class o extends X509CertSelector implements org.bouncycastle.util.q {
    public static o a(X509CertSelector x509CertSelector) {
        if (x509CertSelector == null) {
            throw new IllegalArgumentException("cannot create from null selector");
        }
        o oVar = new o();
        oVar.setAuthorityKeyIdentifier(x509CertSelector.getAuthorityKeyIdentifier());
        oVar.setBasicConstraints(x509CertSelector.getBasicConstraints());
        oVar.setCertificate(x509CertSelector.getCertificate());
        oVar.setCertificateValid(x509CertSelector.getCertificateValid());
        oVar.setMatchAllSubjectAltNames(x509CertSelector.getMatchAllSubjectAltNames());
        try {
            oVar.setPathToNames(x509CertSelector.getPathToNames());
            oVar.setExtendedKeyUsage(x509CertSelector.getExtendedKeyUsage());
            oVar.setNameConstraints(x509CertSelector.getNameConstraints());
            oVar.setPolicy(x509CertSelector.getPolicy());
            oVar.setSubjectPublicKeyAlgID(x509CertSelector.getSubjectPublicKeyAlgID());
            oVar.setSubjectAlternativeNames(x509CertSelector.getSubjectAlternativeNames());
            oVar.setIssuer(x509CertSelector.getIssuer());
            oVar.setKeyUsage(x509CertSelector.getKeyUsage());
            oVar.setPrivateKeyValid(x509CertSelector.getPrivateKeyValid());
            oVar.setSerialNumber(x509CertSelector.getSerialNumber());
            oVar.setSubject(x509CertSelector.getSubject());
            oVar.setSubjectKeyIdentifier(x509CertSelector.getSubjectKeyIdentifier());
            oVar.setSubjectPublicKey(x509CertSelector.getSubjectPublicKey());
            return oVar;
        } catch (IOException e10) {
            throw new IllegalArgumentException("error in passed in selector: " + e10);
        }
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (obj instanceof X509Certificate) {
            return super.match((X509Certificate) obj);
        }
        return false;
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector, org.bouncycastle.util.q
    public Object clone() {
        return (o) super.clone();
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
    public boolean match(Certificate certificate) {
        return M(certificate);
    }
}
