package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class g extends CertStoreSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CollectionCertStoreParameters f45448a;

    public g(CertStoreParameters certStoreParameters) throws InvalidAlgorithmParameterException {
        super(certStoreParameters);
        if (certStoreParameters instanceof CollectionCertStoreParameters) {
            this.f45448a = (CollectionCertStoreParameters) certStoreParameters;
            return;
        }
        throw new InvalidAlgorithmParameterException("org.bouncycastle.jce.provider.CertStoreCollectionSpi: parameter must be a CollectionCertStoreParameters object\n" + certStoreParameters.toString());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        ArrayList arrayList = new ArrayList();
        Iterator<?> it2 = this.f45448a.getCollection().iterator();
        if (cRLSelector == null) {
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof CRL) {
                    arrayList.add(next);
                }
            }
        } else {
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if ((next2 instanceof CRL) && cRLSelector.match((CRL) next2)) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        ArrayList arrayList = new ArrayList();
        Iterator<?> it2 = this.f45448a.getCollection().iterator();
        if (certSelector == null) {
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof Certificate) {
                    arrayList.add(next);
                }
            }
        } else {
            while (it2.hasNext()) {
                Object next2 = it2.next();
                if ((next2 instanceof Certificate) && certSelector.match((Certificate) next2)) {
                    arrayList.add(next2);
                }
            }
        }
        return arrayList;
    }
}
