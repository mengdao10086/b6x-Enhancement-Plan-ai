package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Principal;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.Certificate;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import jq.i;
import jq.j;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes5.dex */
public class o extends CertPathBuilderSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Exception f45495a;

    public static Collection b(org.bouncycastle.x509.k kVar, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof org.bouncycastle.util.s) {
                try {
                    hashSet.addAll(((org.bouncycastle.util.s) obj).a(kVar));
                } catch (StoreException e10) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e10);
                }
            }
        }
        return hashSet;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.security.cert.CertPathBuilderResult a(org.bouncycastle.x509.l r7, java.security.cert.X509Certificate r8, jq.j r9, java.util.List r10) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.o.a(org.bouncycastle.x509.l, java.security.cert.X509Certificate, jq.j, java.util.List):java.security.cert.CertPathBuilderResult");
    }

    @Override // java.security.cert.CertPathBuilderSpi
    public CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        jq.j jVarE;
        boolean z10 = certPathParameters instanceof PKIXBuilderParameters;
        if (!z10 && !(certPathParameters instanceof org.bouncycastle.x509.e) && !(certPathParameters instanceof jq.j)) {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + jq.j.class.getName() + j3.b.f36044h);
        }
        List arrayList = new ArrayList();
        if (z10) {
            j.b bVar = new j.b((PKIXBuilderParameters) certPathParameters);
            if (certPathParameters instanceof org.bouncycastle.x509.f) {
                org.bouncycastle.x509.e eVar = (org.bouncycastle.x509.e) certPathParameters;
                bVar.d(eVar.y());
                bVar.f(eVar.A());
                arrayList = eVar.i();
            }
            jVarE = bVar.e();
        } else {
            jVarE = (jq.j) certPathParameters;
        }
        ArrayList arrayList2 = new ArrayList();
        jq.k kVarA = jVarE.a();
        org.bouncycastle.util.q qVarU = kVarA.u();
        if (!(qVarU instanceof org.bouncycastle.x509.k)) {
            throw new CertPathBuilderException("TargetConstraints must be an instance of " + org.bouncycastle.x509.k.class.getName() + " for " + getClass().getName() + " class.");
        }
        try {
            Collection collectionB = b((org.bouncycastle.x509.k) qVarU, arrayList);
            if (collectionB.isEmpty()) {
                throw new CertPathBuilderException("No attribute certificate found matching targetConstraints.");
            }
            CertPathBuilderResult certPathBuilderResultA = null;
            Iterator it2 = collectionB.iterator();
            while (it2.hasNext() && certPathBuilderResultA == null) {
                org.bouncycastle.x509.l lVar = (org.bouncycastle.x509.l) it2.next();
                org.bouncycastle.x509.o oVar = new org.bouncycastle.x509.o();
                Principal[] principalArrB = lVar.m().b();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (int i10 = 0; i10 < principalArrB.length; i10++) {
                    try {
                        if (principalArrB[i10] instanceof X500Principal) {
                            oVar.setSubject(((X500Principal) principalArrB[i10]).getEncoded());
                        }
                        jq.i<? extends Certificate> iVarA = new i.b(oVar).a();
                        e.b(linkedHashSet, iVarA, kVarA.m());
                        e.b(linkedHashSet, iVarA, kVarA.n());
                    } catch (IOException e10) {
                        throw new ExtCertPathBuilderException("cannot encode X500Principal.", e10);
                    } catch (AnnotatedException e11) {
                        throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", e11);
                    }
                }
                if (linkedHashSet.isEmpty()) {
                    throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
                }
                Iterator it3 = linkedHashSet.iterator();
                while (it3.hasNext() && certPathBuilderResultA == null) {
                    certPathBuilderResultA = a(lVar, (X509Certificate) it3.next(), jVarE, arrayList2);
                }
            }
            if (certPathBuilderResultA == null && this.f45495a != null) {
                throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.f45495a);
            }
            if (certPathBuilderResultA == null && this.f45495a == null) {
                throw new CertPathBuilderException("Unable to find certificate chain.");
            }
            return certPathBuilderResultA;
        } catch (AnnotatedException e12) {
            throw new ExtCertPathBuilderException("Error finding target attribute certificate.", e12);
        }
    }
}
