package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import jq.i;
import jq.j;
import jq.k;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import zn.h1;
import zn.u1;

/* JADX INFO: loaded from: classes5.dex */
public class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45408a = zn.y.f59078v1.L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f45409b = zn.y.f59066k1.L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f45410c = zn.y.f59074s.L();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f45411d = zn.y.A.L();

    public static void a(org.bouncycastle.x509.l lVar, Set set, Set set2) throws CertPathValidatorException {
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (lVar.k(str) != null) {
                throw new CertPathValidatorException("Attribute certificate contains prohibited attribute: " + str + j3.b.f36044h);
            }
        }
        Iterator it3 = set2.iterator();
        while (it3.hasNext()) {
            String str2 = (String) it3.next();
            if (lVar.k(str2) == null) {
                throw new CertPathValidatorException("Attribute certificate does not contain necessary attribute: " + str2 + j3.b.f36044h);
            }
        }
    }

    public static void b(zn.v vVar, org.bouncycastle.x509.l lVar, jq.k kVar, Date date, Date date2, X509Certificate x509Certificate, f fVar, d0 d0Var, List list, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException, RecoverableCertPathValidatorException {
        Iterator it2;
        X509CRL x509crlW;
        if (lVar.getExtensionValue(u1.K0.L()) != null) {
            return;
        }
        if (date2.getTime() > date.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it3 = e.l(new jq.g(kVar, date2, null, -1, x509Certificate, null), vVar, lVar, kVar, date2).iterator();
        AnnotatedException e10 = null;
        boolean z10 = false;
        while (it3.hasNext() && fVar.a() == 11 && !d0Var.e()) {
            try {
                X509CRL x509crl = (X509CRL) it3.next();
                d0 d0VarT = b0.t(x509crl, vVar);
                if (d0VarT.c(d0Var)) {
                    it2 = it3;
                    try {
                        PublicKey publicKeyV = b0.v(x509crl, b0.u(x509crl, lVar, null, null, kVar, list, dVar));
                        if (kVar.D()) {
                            try {
                                x509crlW = b0.w(e.m(date, x509crl, kVar.m(), kVar.k(), dVar), publicKeyV);
                            } catch (AnnotatedException e11) {
                                e10 = e11;
                                it3 = it2;
                            }
                        } else {
                            x509crlW = null;
                        }
                        if (kVar.x() != 1) {
                            try {
                                if (lVar.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            } catch (AnnotatedException e12) {
                                e10 = e12;
                                it3 = it2;
                            }
                        }
                        b0.q(vVar, lVar, x509crl);
                        b0.r(vVar, lVar, x509crl);
                        b0.s(x509crlW, x509crl, kVar);
                        b0.x(date2, x509crlW, lVar, fVar, kVar);
                        b0.y(date2, x509crl, lVar, fVar);
                        if (fVar.a() == 8) {
                            fVar.c(11);
                        }
                        d0Var.a(d0VarT);
                        it3 = it2;
                        z10 = true;
                    } catch (AnnotatedException e13) {
                        e10 = e13;
                    }
                } else {
                    continue;
                }
            } catch (AnnotatedException e14) {
                e10 = e14;
                it2 = it3;
            }
        }
        if (!z10) {
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0111 A[PHI: r0
  0x0111: PHI (r0v17 org.bouncycastle.jce.provider.AnnotatedException) = 
  (r0v16 org.bouncycastle.jce.provider.AnnotatedException)
  (r0v16 org.bouncycastle.jce.provider.AnnotatedException)
  (r0v31 org.bouncycastle.jce.provider.AnnotatedException)
 binds: [B:38:0x00c2, B:40:0x00c8, B:47:0x010b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(org.bouncycastle.x509.l r20, jq.k r21, java.util.Date r22, java.util.Date r23, java.security.cert.X509Certificate r24, java.util.List r25, org.bouncycastle.jcajce.util.d r26) throws java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.c0.c(org.bouncycastle.x509.l, jq.k, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.util.List, org.bouncycastle.jcajce.util.d):void");
    }

    public static CertPath d(org.bouncycastle.x509.l lVar, jq.k kVar) throws CertPathValidatorException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (lVar.i().e() != null) {
            X509CertSelector x509CertSelector = new X509CertSelector();
            x509CertSelector.setSerialNumber(lVar.i().j());
            Principal[] principalArrE = lVar.i().e();
            for (int i10 = 0; i10 < principalArrE.length; i10++) {
                try {
                    if (principalArrE[i10] instanceof X500Principal) {
                        x509CertSelector.setIssuer(((X500Principal) principalArrE[i10]).getEncoded());
                    }
                    e.b(linkedHashSet, new i.b(x509CertSelector).a(), kVar.m());
                } catch (IOException e10) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e10);
                } catch (AnnotatedException e11) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e11);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in base certificate ID for attribute certificate cannot be found.");
            }
        }
        if (lVar.i().d() != null) {
            org.bouncycastle.x509.o oVar = new org.bouncycastle.x509.o();
            Principal[] principalArrD = lVar.i().d();
            for (int i11 = 0; i11 < principalArrD.length; i11++) {
                try {
                    if (principalArrD[i11] instanceof X500Principal) {
                        oVar.setIssuer(((X500Principal) principalArrD[i11]).getEncoded());
                    }
                    e.b(linkedHashSet, new i.b(oVar).a(), kVar.m());
                } catch (IOException e12) {
                    throw new ExtCertPathValidatorException("Unable to encode X500 principal.", e12);
                } catch (AnnotatedException e13) {
                    throw new ExtCertPathValidatorException("Public key certificate for attribute certificate cannot be searched.", e13);
                }
            }
            if (linkedHashSet.isEmpty()) {
                throw new CertPathValidatorException("Public key certificate specified in entity name for attribute certificate cannot be found.");
            }
        }
        k.b bVar = new k.b(kVar);
        Iterator it2 = linkedHashSet.iterator();
        ExtCertPathValidatorException extCertPathValidatorException = null;
        CertPathBuilderResult certPathBuilderResultBuild = null;
        while (it2.hasNext()) {
            org.bouncycastle.x509.o oVar2 = new org.bouncycastle.x509.o();
            oVar2.setCertificate((X509Certificate) it2.next());
            bVar.s(new i.b(oVar2).a());
            try {
                try {
                    certPathBuilderResultBuild = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.f45329b).build(new j.b(bVar.q()).e());
                } catch (InvalidAlgorithmParameterException e14) {
                    throw new RuntimeException(e14.getMessage());
                } catch (CertPathBuilderException e15) {
                    extCertPathValidatorException = new ExtCertPathValidatorException("Certification path for public key certificate of attribute certificate could not be build.", e15);
                }
            } catch (NoSuchAlgorithmException e16) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e16);
            } catch (NoSuchProviderException e17) {
                throw new ExtCertPathValidatorException("Support class could not be created.", e17);
            }
        }
        if (extCertPathValidatorException == null) {
            return certPathBuilderResultBuild.getCertPath();
        }
        throw extCertPathValidatorException;
    }

    public static CertPathValidatorResult e(CertPath certPath, jq.k kVar) throws CertPathValidatorException {
        try {
            try {
                return CertPathValidator.getInstance("PKIX", BouncyCastleProvider.f45329b).validate(certPath, kVar);
            } catch (InvalidAlgorithmParameterException e10) {
                throw new RuntimeException(e10.getMessage());
            } catch (CertPathValidatorException e11) {
                throw new ExtCertPathValidatorException("Certification path for issuer certificate of attribute certificate could not be validated.", e11);
            }
        } catch (NoSuchAlgorithmException e12) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e12);
        } catch (NoSuchProviderException e13) {
            throw new ExtCertPathValidatorException("Support class could not be created.", e13);
        }
    }

    public static void f(X509Certificate x509Certificate, jq.k kVar) throws CertPathValidatorException {
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (keyUsage != null && ((keyUsage.length <= 0 || !keyUsage[0]) && (keyUsage.length <= 1 || !keyUsage[1]))) {
            throw new CertPathValidatorException("Attribute certificate issuer public key cannot be used to validate digital signatures.");
        }
        if (x509Certificate.getBasicConstraints() != -1) {
            throw new CertPathValidatorException("Attribute certificate issuer is also a public key certificate issuer.");
        }
    }

    public static void g(X509Certificate x509Certificate, Set set) throws CertPathValidatorException {
        Iterator it2 = set.iterator();
        boolean z10 = false;
        while (it2.hasNext()) {
            TrustAnchor trustAnchor = (TrustAnchor) it2.next();
            if (x509Certificate.getSubjectX500Principal().getName("RFC2253").equals(trustAnchor.getCAName()) || x509Certificate.equals(trustAnchor.getTrustedCert())) {
                z10 = true;
            }
        }
        if (!z10) {
            throw new CertPathValidatorException("Attribute certificate issuer is not directly trusted.");
        }
    }

    public static void h(org.bouncycastle.x509.l lVar, Date date) throws CertPathValidatorException {
        try {
            lVar.checkValidity(date);
        } catch (CertificateExpiredException e10) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e10);
        } catch (CertificateNotYetValidException e11) {
            throw new ExtCertPathValidatorException("Attribute certificate is not valid.", e11);
        }
    }

    public static void i(org.bouncycastle.x509.l lVar, CertPath certPath, CertPath certPath2, jq.k kVar, Set set) throws CertPathValidatorException {
        Set<String> criticalExtensionOIDs = lVar.getCriticalExtensionOIDs();
        String str = f45408a;
        if (criticalExtensionOIDs.contains(str)) {
            try {
                h1.x(e.n(lVar, str));
            } catch (IllegalArgumentException e10) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e10);
            } catch (AnnotatedException e11) {
                throw new ExtCertPathValidatorException("Target information extension could not be read.", e11);
            }
        }
        criticalExtensionOIDs.remove(str);
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            ((org.bouncycastle.x509.g) it2.next()).a(lVar, certPath, certPath2, criticalExtensionOIDs);
        }
        if (criticalExtensionOIDs.isEmpty()) {
            return;
        }
        throw new CertPathValidatorException("Attribute certificate contains unsupported critical extensions: " + criticalExtensionOIDs);
    }
}
