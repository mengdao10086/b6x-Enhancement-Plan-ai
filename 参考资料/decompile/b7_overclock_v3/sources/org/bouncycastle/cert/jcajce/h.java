package org.bouncycastle.cert.jcajce;

import java.security.Provider;
import java.security.cert.CertificateException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class h implements p000do.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.operator.jcajce.c f44489a = new org.bouncycastle.operator.jcajce.c();

    @Override // p000do.e
    public cs.h a(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        try {
            return this.f44489a.g(x509CertificateHolder);
        } catch (CertificateException e10) {
            throw new OperatorCreationException("Unable to process certificate: " + e10.getMessage(), e10);
        }
    }

    @Override // p000do.e
    public cs.h b(c1 c1Var) throws OperatorCreationException {
        return this.f44489a.h(c1Var);
    }

    public h c(String str) {
        this.f44489a.l(str);
        return this;
    }

    public h d(Provider provider) {
        this.f44489a.m(provider);
        return this;
    }
}
