package org.bouncycastle.jce.provider;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class q {
    public static Set a(jq.e eVar, Date date, List list, List list2) throws AnnotatedException {
        HashSet<X509CRL> hashSet = new HashSet();
        try {
            b(hashSet, eVar, list2);
            b(hashSet, eVar, list);
            HashSet hashSet2 = new HashSet();
            for (X509CRL x509crl : hashSet) {
                Date nextUpdate = x509crl.getNextUpdate();
                if (nextUpdate == null || nextUpdate.after(date)) {
                    X509Certificate x509CertificateC = eVar.c();
                    if (x509CertificateC == null || x509crl.getThisUpdate().before(x509CertificateC.getNotAfter())) {
                        hashSet2.add(x509crl);
                    }
                }
            }
            return hashSet2;
        } catch (AnnotatedException e10) {
            throw new AnnotatedException("Exception obtaining complete CRLs.", e10);
        }
    }

    public static void b(HashSet hashSet, jq.e eVar, List list) throws AnnotatedException {
        AnnotatedException annotatedException;
        AnnotatedException annotatedException2 = null;
        boolean z10 = false;
        for (Object obj : list) {
            if (obj instanceof org.bouncycastle.util.s) {
                try {
                    hashSet.addAll(((org.bouncycastle.util.s) obj).a(eVar));
                    z10 = true;
                } catch (StoreException e10) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e10);
                    annotatedException2 = annotatedException;
                }
            } else {
                try {
                    hashSet.addAll(jq.e.b(eVar, (CertStore) obj));
                    z10 = true;
                } catch (CertStoreException e11) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e11);
                    annotatedException2 = annotatedException;
                }
            }
        }
        if (!z10 && annotatedException2 != null) {
            throw annotatedException2;
        }
    }
}
