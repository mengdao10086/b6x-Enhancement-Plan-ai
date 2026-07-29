package org.bouncycastle.cert.jcajce;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.s;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f44485c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f44483a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f44484b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JcaX509CertificateConverter f44486d = new JcaX509CertificateConverter();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JcaX509CRLConverter f44487e = new JcaX509CRLConverter();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f44488f = "Collection";

    public f a(X509CRLHolder x509CRLHolder) {
        this.f44484b.add(x509CRLHolder);
        return this;
    }

    public f b(s sVar) {
        this.f44484b.addAll(sVar.a(null));
        return this;
    }

    public f c(X509CertificateHolder x509CertificateHolder) {
        this.f44483a.add(x509CertificateHolder);
        return this;
    }

    public f d(s sVar) {
        this.f44483a.addAll(sVar.a(null));
        return this;
    }

    public CertStore e() throws GeneralSecurityException {
        CollectionCertStoreParameters collectionCertStoreParametersF = f(this.f44486d, this.f44487e);
        Object obj = this.f44485c;
        return obj instanceof String ? CertStore.getInstance(this.f44488f, collectionCertStoreParametersF, (String) obj) : obj instanceof Provider ? CertStore.getInstance(this.f44488f, collectionCertStoreParametersF, (Provider) obj) : CertStore.getInstance(this.f44488f, collectionCertStoreParametersF);
    }

    public final CollectionCertStoreParameters f(JcaX509CertificateConverter jcaX509CertificateConverter, JcaX509CRLConverter jcaX509CRLConverter) throws CertificateException, CRLException {
        ArrayList arrayList = new ArrayList(this.f44483a.size() + this.f44484b.size());
        Iterator it2 = this.f44483a.iterator();
        while (it2.hasNext()) {
            arrayList.add(jcaX509CertificateConverter.a((X509CertificateHolder) it2.next()));
        }
        Iterator it3 = this.f44484b.iterator();
        while (it3.hasNext()) {
            arrayList.add(jcaX509CRLConverter.a((X509CRLHolder) it3.next()));
        }
        return new CollectionCertStoreParameters(arrayList);
    }

    public f g(String str) {
        this.f44486d.b(str);
        this.f44487e.b(str);
        this.f44485c = str;
        return this;
    }

    public f h(Provider provider) {
        this.f44486d.c(provider);
        this.f44487e.c(provider);
        this.f44485c = provider;
        return this;
    }

    public f i(String str) {
        this.f44488f = str;
        return this;
    }
}
