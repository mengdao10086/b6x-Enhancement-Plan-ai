package oo;

import java.util.Collection;
import java.util.Iterator;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.m;
import org.bouncycastle.util.q;
import org.bouncycastle.util.s;

/* JADX INFO: loaded from: classes5.dex */
public class b implements no.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f44372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public xn.d f44373b;

    public class a implements q {
        public a() {
        }

        @Override // org.bouncycastle.util.q
        public boolean M(Object obj) {
            return ((X509CRLHolder) obj).f().equals(b.this.f44373b);
        }

        @Override // org.bouncycastle.util.q
        public Object clone() {
            return this;
        }
    }

    public b(xn.d dVar, s sVar) {
        this.f44373b = dVar;
        this.f44372a = sVar;
    }

    @Override // org.bouncycastle.util.m
    public m d() {
        return new b(this.f44373b, this.f44372a);
    }

    @Override // org.bouncycastle.util.m
    public void i(m mVar) {
        b bVar = (b) mVar;
        this.f44373b = bVar.f44373b;
        this.f44372a = bVar.f44372a;
    }

    @Override // no.c
    public void j(no.d dVar, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        Collection collectionA = this.f44372a.a(new a());
        if (collectionA.isEmpty()) {
            throw new CertPathValidationException("CRL for " + this.f44373b + " not found");
        }
        Iterator it2 = collectionA.iterator();
        while (it2.hasNext()) {
            if (((X509CRLHolder) it2.next()).k(x509CertificateHolder.l()) != null) {
                throw new CertPathValidationException("Certificate revoked");
            }
        }
        this.f44373b = x509CertificateHolder.o();
    }
}
