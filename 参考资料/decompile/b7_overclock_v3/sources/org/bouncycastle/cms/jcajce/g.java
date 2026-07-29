package org.bouncycastle.cms.jcajce;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.b2;
import so.c2;
import so.w0;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c2 f44544a;

    public g(cs.p pVar) {
        this(pVar, new w0());
    }

    public g(cs.p pVar, so.k0 k0Var) {
        this.f44544a = new c2(pVar, k0Var);
    }

    public b2 a(cs.f fVar, X509Certificate x509Certificate) throws OperatorCreationException, CertificateEncodingException {
        return b(fVar, new JcaX509CertificateHolder(x509Certificate));
    }

    public b2 b(cs.f fVar, X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return this.f44544a.a(fVar, x509CertificateHolder);
    }

    public b2 c(cs.f fVar, byte[] bArr) throws OperatorCreationException {
        return this.f44544a.b(fVar, bArr);
    }

    public g d(zn.b bVar) {
        this.f44544a.d(bVar);
        return this;
    }

    public g e(boolean z10) {
        this.f44544a.e(z10);
        return this;
    }

    public g f(so.d dVar) {
        this.f44544a.f(dVar);
        return this;
    }

    public g g(so.d dVar) {
        this.f44544a.g(dVar);
        return this;
    }
}
