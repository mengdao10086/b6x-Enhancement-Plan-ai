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
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f44571a = new b();

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
        public final String f44573b;

        public c(String str) {
            super();
            this.f44573b = str;
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h a(PublicKey publicKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44573b).e(publicKey);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h b(X509Certificate x509Certificate) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44573b).f(x509Certificate);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new org.bouncycastle.operator.jcajce.c().l(this.f44573b).g(x509CertificateHolder);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.p d() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().d(this.f44573b).b();
        }
    }

    public class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Provider f44575b;

        public d(Provider provider) {
            super();
            this.f44575b = provider;
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h a(PublicKey publicKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44575b).e(publicKey);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h b(X509Certificate x509Certificate) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44575b).f(x509Certificate);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.h c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
            return new org.bouncycastle.operator.jcajce.c().m(this.f44575b).g(x509CertificateHolder);
        }

        @Override // org.bouncycastle.cms.jcajce.j.b
        public cs.p d() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().e(this.f44575b).b();
        }
    }

    public f2 a(PublicKey publicKey) throws OperatorCreationException {
        return new f2(new v0(), new cs.l(), this.f44571a.a(publicKey), this.f44571a.d());
    }

    public f2 b(X509Certificate x509Certificate) throws OperatorCreationException {
        return new f2(new v0(), new cs.l(), this.f44571a.b(x509Certificate), this.f44571a.d());
    }

    public f2 c(X509CertificateHolder x509CertificateHolder) throws OperatorCreationException, CertificateException {
        return new f2(new v0(), new cs.l(), this.f44571a.c(x509CertificateHolder), this.f44571a.d());
    }

    public j d(String str) {
        this.f44571a = new c(str);
        return this;
    }

    public j e(Provider provider) {
        this.f44571a = new d(provider);
        return this;
    }
}
