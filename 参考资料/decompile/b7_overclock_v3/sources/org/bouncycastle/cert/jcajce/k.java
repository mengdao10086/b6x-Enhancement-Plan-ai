package org.bouncycastle.cert.jcajce;

import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes5.dex */
public class k extends p000do.i {
    public k(X509CRL x509crl) throws CRLException {
        super(new JcaX509CRLHolder(x509crl));
    }

    public k(X509Certificate x509Certificate, Date date) {
        this(x509Certificate.getSubjectX500Principal(), date);
    }

    public k(X500Principal x500Principal, Date date) {
        super(xn.d.A(x500Principal.getEncoded()), date);
    }
}
