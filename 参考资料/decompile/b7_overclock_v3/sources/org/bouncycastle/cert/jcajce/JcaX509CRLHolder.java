package org.bouncycastle.cert.jcajce;

import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import org.bouncycastle.cert.X509CRLHolder;
import zn.p;

/* JADX INFO: loaded from: classes5.dex */
public class JcaX509CRLHolder extends X509CRLHolder {
    public JcaX509CRLHolder(X509CRL x509crl) throws CRLException {
        super(p.y(x509crl.getEncoded()));
    }
}
