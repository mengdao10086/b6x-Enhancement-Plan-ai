package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import so.i1;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends i1 {
    public g0(X509Certificate x509Certificate) throws CertificateEncodingException {
        super(new mm.y(new JcaX509CertificateHolder(x509Certificate).y()), new org.bouncycastle.operator.jcajce.f(x509Certificate));
    }

    public g0(X509Certificate x509Certificate, cs.d dVar) throws CertificateEncodingException {
        super(new mm.y(new JcaX509CertificateHolder(x509Certificate).y()), dVar);
    }

    public g0(X509Certificate x509Certificate, zn.b bVar) throws CertificateEncodingException {
        super(new mm.y(new JcaX509CertificateHolder(x509Certificate).y()), new org.bouncycastle.operator.jcajce.f(bVar, x509Certificate.getPublicKey()));
    }

    public g0(byte[] bArr, cs.d dVar) {
        super(bArr, dVar);
    }

    public g0(byte[] bArr, PublicKey publicKey) {
        super(bArr, new org.bouncycastle.operator.jcajce.f(publicKey));
    }

    public g0(byte[] bArr, zn.b bVar, PublicKey publicKey) {
        super(bArr, new org.bouncycastle.operator.jcajce.f(bVar, publicKey));
    }

    public g0 b(gm.y yVar, String str) {
        ((org.bouncycastle.operator.jcajce.f) this.f50190a).f(yVar, str);
        return this;
    }

    public g0 c(String str) {
        ((org.bouncycastle.operator.jcajce.f) this.f50190a).g(str);
        return this;
    }

    public g0 d(Provider provider) {
        ((org.bouncycastle.operator.jcajce.f) this.f50190a).h(provider);
        return this;
    }
}
