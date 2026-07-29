package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class k extends CertStoreSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jce.d f45470a;

    public k(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof org.bouncycastle.jce.d) {
            this.f45470a = (org.bouncycastle.jce.d) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException("org.bouncycastle.jce.provider.MultiCertStoreSpi: parameter must be a MultiCertStoreParameters object\n" + certStoreParameters.toString());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        boolean zB = this.f45470a.b();
        Iterator it2 = this.f45470a.a().iterator();
        List arrayList = zB ? new ArrayList() : Collections.EMPTY_LIST;
        while (it2.hasNext()) {
            Collection<? extends CRL> cRLs = ((CertStore) it2.next()).getCRLs(cRLSelector);
            if (zB) {
                arrayList.addAll(cRLs);
            } else if (!cRLs.isEmpty()) {
                return cRLs;
            }
        }
        return arrayList;
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        boolean zB = this.f45470a.b();
        Iterator it2 = this.f45470a.a().iterator();
        List arrayList = zB ? new ArrayList() : Collections.EMPTY_LIST;
        while (it2.hasNext()) {
            Collection<? extends Certificate> certificates = ((CertStore) it2.next()).getCertificates(certSelector);
            if (zB) {
                arrayList.addAll(certificates);
            } else if (!certificates.isEmpty()) {
                return certificates;
            }
        }
        return arrayList;
    }
}
