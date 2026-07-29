package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import so.b2;
import so.c2;
import so.x0;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f44558a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f44559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public so.d f44560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public so.d f44561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f44562e;

    public class b {
        public b() {
        }

        public cs.f a(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.b(str).b(org.bouncycastle.cms.jcajce.a.a(privateKey));
        }

        public cs.p b() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().b();
        }
    }

    public class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f44564b;

        public c(String str) {
            super();
            this.f44564b = str;
        }

        @Override // org.bouncycastle.cms.jcajce.i.b
        public cs.f a(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.b(str).f(this.f44564b).b(org.bouncycastle.cms.jcajce.a.a(privateKey));
        }

        @Override // org.bouncycastle.cms.jcajce.i.b
        public cs.p b() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().d(this.f44564b).b();
        }
    }

    public class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Provider f44566b;

        public d(Provider provider) {
            super();
            this.f44566b = provider;
        }

        @Override // org.bouncycastle.cms.jcajce.i.b
        public cs.f a(String str, PrivateKey privateKey) throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.b(str).g(this.f44566b).b(org.bouncycastle.cms.jcajce.a.a(privateKey));
        }

        @Override // org.bouncycastle.cms.jcajce.i.b
        public cs.p b() throws OperatorCreationException {
            return new org.bouncycastle.operator.jcajce.d().e(this.f44566b).b();
        }
    }

    public b2 a(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws OperatorCreationException, CertificateEncodingException {
        return d().a(this.f44558a.a(str, org.bouncycastle.cms.jcajce.a.a(privateKey)), new JcaX509CertificateHolder(x509Certificate));
    }

    public b2 b(String str, PrivateKey privateKey, X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        return d().a(this.f44558a.a(str, org.bouncycastle.cms.jcajce.a.a(privateKey)), x509CertificateHolder);
    }

    public b2 c(String str, PrivateKey privateKey, byte[] bArr) throws OperatorCreationException {
        return d().b(this.f44558a.a(str, org.bouncycastle.cms.jcajce.a.a(privateKey)), bArr);
    }

    public final c2 d() throws OperatorCreationException {
        c2 c2Var = new c2(this.f44558a.b());
        c2Var.e(this.f44559b);
        c2Var.d(this.f44562e);
        c2Var.f(this.f44560c);
        c2Var.g(this.f44561d);
        return c2Var;
    }

    public i e(zn.b bVar) {
        this.f44562e = bVar;
        return this;
    }

    public i f(boolean z10) {
        this.f44559b = z10;
        return this;
    }

    public i g(String str) throws OperatorCreationException {
        this.f44558a = new c(str);
        return this;
    }

    public i h(Provider provider) throws OperatorCreationException {
        this.f44558a = new d(provider);
        return this;
    }

    public i i(mm.b bVar) {
        this.f44560c = new x0(bVar);
        return this;
    }

    public i j(so.d dVar) {
        this.f44560c = dVar;
        return this;
    }

    public i k(so.d dVar) {
        this.f44561d = dVar;
        return this;
    }
}
