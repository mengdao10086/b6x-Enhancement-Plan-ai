package io;

import cs.d0;
import cs.x;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import om.m;
import org.bouncycastle.cert.crmf.CRMFException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import pn.u;

/* JADX INFO: loaded from: classes5.dex */
public class d extends go.f {
    public d(x xVar, d0 d0Var) {
        super(xVar, d0Var);
    }

    public m f(PrivateKey privateKey) throws CRMFException, CertificateEncodingException {
        return b(u.z(privateKey.getEncoded()));
    }

    public m g(X509Certificate x509Certificate) throws CRMFException, CertificateEncodingException {
        return a(new JcaX509CertificateHolder(x509Certificate));
    }
}
