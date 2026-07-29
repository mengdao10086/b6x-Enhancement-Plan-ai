package org.bouncycastle.x509;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.PKIXParameters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class h {
    public static Set a(m mVar, PKIXParameters pKIXParameters) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        try {
            b(hashSet, mVar, pKIXParameters.getCertStores());
            return hashSet;
        } catch (AnnotatedException e10) {
            throw new AnnotatedException("Exception obtaining complete CRLs.", e10);
        }
    }

    public static void b(HashSet hashSet, m mVar, List list) throws AnnotatedException {
        AnnotatedException annotatedException;
        AnnotatedException annotatedException2 = null;
        boolean z10 = false;
        for (Object obj : list) {
            if (obj instanceof r) {
                try {
                    hashSet.addAll(((r) obj).a(mVar));
                    z10 = true;
                } catch (StoreException e10) {
                    annotatedException = new AnnotatedException("Exception searching in X.509 CRL store.", e10);
                    annotatedException2 = annotatedException;
                }
            } else {
                try {
                    hashSet.addAll(((CertStore) obj).getCRLs(mVar));
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
