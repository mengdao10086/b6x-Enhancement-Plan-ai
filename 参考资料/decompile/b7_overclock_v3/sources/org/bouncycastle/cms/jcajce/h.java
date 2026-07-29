package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.f2;
import so.v0;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cs.p f44546b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f44545a = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public so.j0 f44547c = new v0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cs.g0 f44548d = new cs.l();

    public class b {
        public b() {
        }

        public cs.h a(PublicKey publicKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().e(publicKey);
        }

        public cs.h b(X509Certificate x509Certificate) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().f(x509Certificate);
        }

        public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new org.bouncycastle.operator.jcajce.c().g(x509CertificateHolder);
        }

        public cs.p d() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().b();
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f44550b;

        public c(String str) {
            super();
            this.f44550b = str;
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h a(PublicKey publicKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44550b).e(publicKey);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h b(X509Certificate x509Certificate) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44550b).f(x509Certificate);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44550b).g(x509CertificateHolder);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.p d() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().d(this.f44550b).b();
        }
    }

    public class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Provider f44552b;

        public d(Provider provider) {
            super();
            this.f44552b = provider;
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h a(PublicKey publicKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44552b).e(publicKey);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h b(X509Certificate x509Certificate) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44552b).f(x509Certificate);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44552b).g(x509CertificateHolder);
        }

        @Override // org.bouncycastle.cms.jcajce.h.b
        public cs.p d() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().e(this.f44552b).b();
        }
    }

    public h(cs.p pVar) {
        this.f44546b = pVar;
    }

    public f2 a(PublicKey publicKey) throws OperatorCreationException {
        return new f2(this.f44547c, this.f44548d, this.f44545a.a(publicKey), this.f44546b);
    }

    public f2 b(X509Certificate x509Certificate) throws OperatorCreationException {
        return new f2(this.f44547c, this.f44548d, this.f44545a.b(x509Certificate), this.f44546b);
    }

    public f2 c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return new f2(this.f44547c, this.f44548d, this.f44545a.c(x509CertificateHolder), this.f44546b);
    }

    public h d(String str) {
        this.f44545a = new c(str);
        return this;
    }

    public h e(Provider provider) {
        this.f44545a = new d(provider);
        return this;
    }

    public h f(cs.g0 g0Var) {
        this.f44548d = g0Var;
        return this;
    }

    public h g(so.j0 j0Var) {
        this.f44547c = j0Var;
        return this;
    }
}
