package org.bouncycastle.cert.jcajce;

import gm.y;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import zn.c1;
import zn.j1;

/* JADX INFO: loaded from: classes5.dex */
public class l extends p000do.j {
    public l(X509Certificate x509Certificate) throws CertificateEncodingException {
        super(new JcaX509CertificateHolder(x509Certificate));
    }

    public l(X509Certificate x509Certificate, BigInteger bigInteger, Date date, Date date2, X500Principal x500Principal, PublicKey publicKey) {
        this(x509Certificate.getSubjectX500Principal(), bigInteger, date, date2, x500Principal, publicKey);
    }

    public l(X509Certificate x509Certificate, BigInteger bigInteger, Date date, Date date2, xn.d dVar, PublicKey publicKey) {
        this(xn.d.A(x509Certificate.getSubjectX500Principal().getEncoded()), bigInteger, date, date2, dVar, publicKey);
    }

    public l(X500Principal x500Principal, BigInteger bigInteger, Date date, Date date2, X500Principal x500Principal2, PublicKey publicKey) {
        super(xn.d.A(x500Principal.getEncoded()), bigInteger, date, date2, xn.d.A(x500Principal2.getEncoded()), c1.A(publicKey.getEncoded()));
    }

    public l(xn.d dVar, BigInteger bigInteger, Date date, Date date2, xn.d dVar2, PublicKey publicKey) {
        super(dVar, bigInteger, date, date2, dVar2, c1.A(publicKey.getEncoded()));
    }

    public l(xn.d dVar, BigInteger bigInteger, j1 j1Var, j1 j1Var2, xn.d dVar2, PublicKey publicKey) {
        super(dVar, bigInteger, j1Var, j1Var2, dVar2, c1.A(publicKey.getEncoded()));
    }

    public l r(y yVar, boolean z10, X509Certificate x509Certificate) throws CertificateEncodingException {
        f(yVar, z10, new JcaX509CertificateHolder(x509Certificate));
        return this;
    }
}
