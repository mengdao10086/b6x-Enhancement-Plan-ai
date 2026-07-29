package org.bouncycastle.pkix.jcajce;

import gm.c0;
import gm.f0;
import gm.h;
import gm.i;
import gm.j2;
import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jq.e;
import jq.i;
import jq.j;
import jq.k;
import zn.b0;
import zn.i0;
import zn.j;
import zn.v;
import zn.w;
import zn.y;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45660a = y.f59071p.L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f45661b = y.f59081y.L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f45662c = y.f59070o.L();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f45663d = y.f59063j.L();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f45664e = y.f59077v.L();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45665f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45666g = 6;

    public static void a(v vVar, k kVar, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, a aVar, e eVar, List list, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException, CRLNotFoundException {
        Iterator it2;
        Set<String> criticalExtensionOIDs;
        if (date2.getTime() > date.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it3 = f.f(vVar, x509Certificate, date2, kVar.m(), kVar.k()).iterator();
        AnnotatedException e10 = null;
        boolean z10 = false;
        while (it3.hasNext() && aVar.a() == 11 && !eVar.e()) {
            try {
                X509CRL x509crl = (X509CRL) it3.next();
                e eVarG = g(x509crl, vVar);
                if (eVarG.c(eVar)) {
                    it2 = it3;
                    try {
                        X509CRL x509crlJ = kVar.D() ? j(f.g(date2, x509crl, kVar.m(), kVar.k()), i(x509crl, h(x509crl, x509Certificate, x509Certificate2, publicKey, kVar, list, dVar))) : null;
                        if (kVar.x() != 1) {
                            try {
                                if (x509Certificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            } catch (AnnotatedException e11) {
                                e10 = e11;
                                it3 = it2;
                            }
                        }
                        d(vVar, x509Certificate, x509crl);
                        e(vVar, x509Certificate, x509crl);
                        f(x509crlJ, x509crl, kVar);
                        k(date2, x509crlJ, x509Certificate, aVar, kVar);
                        l(date2, x509crl, x509Certificate, aVar);
                        if (aVar.a() == 8) {
                            aVar.c(11);
                        }
                        eVar.a(eVarG);
                        Set<String> criticalExtensionOIDs2 = x509crl.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(y.f59071p.L());
                            hashSet.remove(y.f59070o.L());
                            if (!hashSet.isEmpty()) {
                                throw new AnnotatedException("CRL contains unsupported critical extensions.");
                            }
                        }
                        if (x509crlJ != null && (criticalExtensionOIDs = x509crlJ.getCriticalExtensionOIDs()) != null) {
                            HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                            hashSet2.remove(y.f59071p.L());
                            hashSet2.remove(y.f59070o.L());
                            if (!hashSet2.isEmpty()) {
                                throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                            }
                        }
                        it3 = it2;
                        z10 = true;
                    } catch (AnnotatedException e12) {
                        e10 = e12;
                        it3 = it2;
                    }
                } else {
                    continue;
                }
            } catch (AnnotatedException e13) {
                e10 = e13;
                it2 = it3;
            }
        }
        if (!z10) {
            throw e10;
        }
    }

    public static Set b(k kVar, Date date, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        if (kVar.D()) {
            try {
                gm.y yVar = y.f59081y;
                zn.k kVarA = zn.k.A(f.h(x509Certificate, yVar));
                if (kVarA == null) {
                    try {
                        kVarA = zn.k.A(f.h(x509crl, yVar));
                    } catch (AnnotatedException e10) {
                        throw new AnnotatedException("Freshest CRL extension could not be decoded from CRL.", e10);
                    }
                }
                if (kVarA != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(kVar.k());
                    try {
                        arrayList.addAll(f.c(kVarA, kVar.q()));
                        try {
                            hashSet.addAll(f.g(date, x509crl, kVar.m(), arrayList));
                        } catch (AnnotatedException e11) {
                            throw new AnnotatedException("Exception obtaining delta CRLs.", e11);
                        }
                    } catch (AnnotatedException e12) {
                        throw new AnnotatedException("No new delta CRL locations could be added from Freshest CRL extension.", e12);
                    }
                }
            } catch (AnnotatedException e13) {
                throw new AnnotatedException("Freshest CRL extension could not be decoded from certificate.", e13);
            }
        }
        return hashSet;
    }

    public static Set[] c(k kVar, Date date, Date date2, X509Certificate x509Certificate, X509CRL x509crl) throws AnnotatedException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        x509CRLSelector.setCertificateChecking(x509Certificate);
        try {
            x509CRLSelector.addIssuerName(x509crl.getIssuerX500Principal().getEncoded());
            Set setA = c.a(new e.b(x509CRLSelector).h(true).g(), date2, kVar.m(), kVar.k());
            HashSet hashSet = new HashSet();
            if (kVar.D()) {
                try {
                    hashSet.addAll(f.g(date2, x509crl, kVar.m(), kVar.k()));
                } catch (AnnotatedException e10) {
                    throw new AnnotatedException("Exception obtaining delta CRLs.", e10);
                }
            }
            return new Set[]{setA, hashSet};
        } catch (IOException e11) {
            throw new AnnotatedException("Cannot extract issuer from CRL." + e11, e11);
        }
    }

    public static void d(v vVar, Object obj, X509CRL x509crl) throws AnnotatedException {
        c0 c0VarH = f.h(x509crl, y.f59071p);
        int i10 = 0;
        boolean z10 = c0VarH != null && i0.B(c0VarH).D();
        byte[] encoded = x509crl.getIssuerX500Principal().getEncoded();
        if (vVar.y() != null) {
            b0[] b0VarArrB = vVar.y().B();
            int i11 = 0;
            while (i10 < b0VarArrB.length) {
                if (b0VarArrB[i10].q() == 4) {
                    try {
                        if (org.bouncycastle.util.a.g(b0VarArrB[i10].A().b().getEncoded(), encoded)) {
                            i11 = 1;
                        }
                    } catch (IOException e10) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e10);
                    }
                }
                i10++;
            }
            if (i11 != 0 && !z10) {
                throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.");
            }
            if (i11 == 0) {
                throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.");
            }
            i10 = i11;
        } else if (x509crl.getIssuerX500Principal().equals(((X509Certificate) obj).getIssuerX500Principal())) {
            i10 = 1;
        }
        if (i10 == 0) {
            throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
        }
    }

    public static void e(v vVar, Object obj, X509CRL x509crl) throws AnnotatedException {
        b0[] b0VarArrB;
        try {
            i0 i0VarB = i0.B(f.h(x509crl, y.f59071p));
            if (i0VarB != null) {
                if (i0VarB.z() != null) {
                    w wVarZ = i0.B(i0VarB).z();
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    if (wVarZ.B() == 0) {
                        for (b0 b0Var : zn.c0.A(wVarZ.A()).B()) {
                            arrayList.add(b0Var);
                        }
                    }
                    if (wVarZ.B() == 1) {
                        i iVar = new i();
                        try {
                            Enumeration enumerationL = f0.J(x509crl.getIssuerX500Principal().getEncoded()).L();
                            while (enumerationL.hasMoreElements()) {
                                iVar.a((h) enumerationL.nextElement());
                            }
                            iVar.a(wVarZ.A());
                            arrayList.add(new b0(xn.d.A(new j2(iVar))));
                        } catch (Exception e10) {
                            throw new AnnotatedException("Could not read CRL issuer.", e10);
                        }
                    }
                    if (vVar.z() != null) {
                        w wVarZ2 = vVar.z();
                        b0[] b0VarArrB2 = wVarZ2.B() == 0 ? zn.c0.A(wVarZ2.A()).B() : null;
                        if (wVarZ2.B() == 1) {
                            if (vVar.y() != null) {
                                b0VarArrB = vVar.y().B();
                            } else {
                                b0VarArrB = new b0[1];
                                try {
                                    b0VarArrB[0] = new b0(xn.d.A(((X509Certificate) obj).getIssuerX500Principal().getEncoded()));
                                } catch (Exception e11) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e11);
                                }
                            }
                            b0VarArrB2 = b0VarArrB;
                            for (int i10 = 0; i10 < b0VarArrB2.length; i10++) {
                                Enumeration enumerationL2 = f0.J(b0VarArrB2[i10].A().b()).L();
                                i iVar2 = new i();
                                while (enumerationL2.hasMoreElements()) {
                                    iVar2.a((h) enumerationL2.nextElement());
                                }
                                iVar2.a(wVarZ2.A());
                                b0VarArrB2[i10] = new b0(xn.d.A(new j2(iVar2)));
                            }
                        }
                        if (b0VarArrB2 != null) {
                            int i11 = 0;
                            while (true) {
                                if (i11 >= b0VarArrB2.length) {
                                    break;
                                }
                                if (arrayList.contains(b0VarArrB2[i11])) {
                                    z10 = true;
                                    break;
                                }
                                i11++;
                            }
                        }
                        if (!z10) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    } else {
                        if (vVar.y() == null) {
                            throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.");
                        }
                        b0[] b0VarArrB3 = vVar.y().B();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= b0VarArrB3.length) {
                                break;
                            }
                            if (arrayList.contains(b0VarArrB3[i12])) {
                                z10 = true;
                                break;
                            }
                            i12++;
                        }
                        if (!z10) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.");
                        }
                    }
                }
                try {
                    j jVarZ = j.z(f.h((X509Extension) obj, y.f59063j));
                    if (obj instanceof X509Certificate) {
                        if (i0VarB.G() && jVarZ != null && jVarZ.B()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.");
                        }
                        if (i0VarB.F() && (jVarZ == null || !jVarZ.B())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.");
                        }
                    }
                    if (i0VarB.E()) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.");
                    }
                } catch (Exception e12) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e12);
                }
            }
        } catch (Exception e13) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e13);
        }
    }

    public static void f(X509CRL x509crl, X509CRL x509crl2, k kVar) throws AnnotatedException {
        if (x509crl == null) {
            return;
        }
        try {
            gm.y yVar = y.f59071p;
            i0 i0VarB = i0.B(f.h(x509crl2, yVar));
            if (kVar.D()) {
                if (!x509crl.getIssuerX500Principal().equals(x509crl2.getIssuerX500Principal())) {
                    throw new AnnotatedException("complete CRL issuer does not match delta CRL issuer");
                }
                try {
                    i0 i0VarB2 = i0.B(f.h(x509crl, yVar));
                    boolean z10 = false;
                    if (i0VarB != null ? i0VarB.equals(i0VarB2) : i0VarB2 == null) {
                        z10 = true;
                    }
                    if (!z10) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                    }
                    try {
                        gm.y yVar2 = y.f59077v;
                        c0 c0VarH = f.h(x509crl2, yVar2);
                        try {
                            c0 c0VarH2 = f.h(x509crl, yVar2);
                            if (c0VarH == null) {
                                throw new AnnotatedException("CRL authority key identifier is null.");
                            }
                            if (c0VarH2 == null) {
                                throw new AnnotatedException("Delta CRL authority key identifier is null.");
                            }
                            if (!c0VarH.C(c0VarH2)) {
                                throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.");
                            }
                        } catch (AnnotatedException e10) {
                            throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e10);
                        }
                    } catch (AnnotatedException e11) {
                        throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e11);
                    }
                } catch (Exception e12) {
                    throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e12);
                }
            }
        } catch (Exception e13) {
            throw new AnnotatedException("issuing distribution point extension could not be decoded.", e13);
        }
    }

    public static e g(X509CRL x509crl, v vVar) throws AnnotatedException {
        try {
            i0 i0VarB = i0.B(f.h(x509crl, y.f59071p));
            if (i0VarB != null && i0VarB.C() != null && vVar.C() != null) {
                return new e(vVar.C()).d(new e(i0VarB.C()));
            }
            if ((i0VarB == null || i0VarB.C() == null) && vVar.C() == null) {
                return e.f45667b;
            }
            return (vVar.C() == null ? e.f45667b : new e(vVar.C())).d(i0VarB == null ? e.f45667b : new e(i0VarB.C()));
        } catch (Exception e10) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e10);
        }
    }

    public static Set h(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, k kVar, List list, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException {
        int i10;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(x509crl.getIssuerX500Principal().getEncoded());
            jq.i<? extends Certificate> iVarA = new i.b(x509CertSelector).a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                f.b(linkedHashSet, iVarA, kVar.n());
                f.b(linkedHashSet, iVarA, kVar.m());
                linkedHashSet.add(x509Certificate);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = linkedHashSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it2.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            CertPathBuilder certPathBuilderV = dVar.v("PKIX");
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            k.b bVarS = new k.b(kVar).s(new i.b(x509CertSelector2).a());
                            if (list.contains(x509Certificate2)) {
                                bVarS.r(false);
                            } else {
                                bVarS.r(true);
                            }
                            List<? extends Certificate> certificates = certPathBuilderV.build(new j.b(bVarS.q()).e()).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(f.k(certificates, 0, dVar));
                        } catch (CertPathBuilderException e10) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", e10);
                        } catch (CertPathValidatorException e11) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e11);
                        } catch (Exception e12) {
                            throw new AnnotatedException(e12.getMessage());
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i10 = 0; i10 < arrayList.size(); i10++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i10)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length > 6 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i10));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.");
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.");
                }
                if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                }
                throw annotatedException;
            } catch (AnnotatedException e13) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e13);
            }
        } catch (IOException e14) {
            throw new AnnotatedException("subject criteria for certificate selector to find issuer certificate for CRL could not be set", e14);
        }
    }

    public static PublicKey i(X509CRL x509crl, Set set) throws AnnotatedException {
        Iterator it2 = set.iterator();
        Exception e10 = null;
        while (it2.hasNext()) {
            PublicKey publicKey = (PublicKey) it2.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e11) {
                e10 = e11;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e10);
    }

    public static X509CRL j(Set set, PublicKey publicKey) throws AnnotatedException {
        Iterator it2 = set.iterator();
        Exception e10 = null;
        while (it2.hasNext()) {
            X509CRL x509crl = (X509CRL) it2.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e11) {
                e10 = e11;
            }
        }
        if (e10 == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e10);
    }

    public static void k(Date date, X509CRL x509crl, Object obj, a aVar, k kVar) throws AnnotatedException {
        if (!kVar.D() || x509crl == null) {
            return;
        }
        f.e(date, x509crl, obj, aVar);
    }

    public static void l(Date date, X509CRL x509crl, Object obj, a aVar) throws AnnotatedException {
        if (aVar.a() == 11) {
            f.e(date, x509crl, obj, aVar);
        }
    }
}
