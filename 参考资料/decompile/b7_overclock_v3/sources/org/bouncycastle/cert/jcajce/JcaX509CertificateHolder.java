package org.bouncycastle.cert.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import zn.o;

/* JADX INFO: loaded from: classes5.dex */
public class JcaX509CertificateHolder extends X509CertificateHolder {
    public JcaX509CertificateHolder(X509Certificate x509Certificate) throws CertificateEncodingException {
        super(o.z(x509Certificate.getEncoded()));
    }
}
