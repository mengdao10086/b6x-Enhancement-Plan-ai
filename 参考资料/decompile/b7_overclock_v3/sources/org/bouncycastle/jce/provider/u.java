package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jq.k;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import zn.e1;

/* JADX INFO: loaded from: classes5.dex */
public class u extends CertPathValidatorSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f45511b;

    public u() {
        this(false);
    }

    public u(boolean z10) {
        this.f45510a = new org.bouncycastle.jcajce.util.b();
        this.f45511b = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(X509Certificate x509Certificate) throws AnnotatedException {
        if (x509Certificate instanceof kq.a) {
            RuntimeException runtimeException = null;
            try {
                if (((kq.a) x509Certificate).l() != null) {
                    return;
                }
            } catch (RuntimeException e10) {
                runtimeException = e10;
            }
            throw new AnnotatedException("unable to process TBSCertificate", runtimeException);
        }
        try {
            e1.A(x509Certificate.getTBSCertificate());
        } catch (IllegalArgumentException e11) {
            throw new AnnotatedException(e11.getMessage());
        } catch (CertificateEncodingException e12) {
            throw new AnnotatedException("unable to process TBSCertificate", e12);
        }
    }

    @Override // java.security.cert.CertPathValidatorSpi
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PKIXCertPathChecker engineGetRevocationChecker() {
        return new a0(this.f45510a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v8, types: [zn.b] */
    @Override // java.security.cert.CertPathValidatorSpi
    public CertPathValidatorResult engineValidate(CertPath certPath, CertPathParameters certPathParameters) throws CertPathValidatorException, InvalidAlgorithmParameterException {
        jq.k kVarA;
        List<? extends Certificate> list;
        int i10;
        xn.d dVarA;
        PublicKey cAPublicKey;
        HashSet hashSet;
        int iK;
        ArrayList arrayList;
        int iJ;
        HashSet hashSet2;
        if (certPathParameters instanceof PKIXParameters) {
            k.b bVar = new k.b((PKIXParameters) certPathParameters);
            if (certPathParameters instanceof org.bouncycastle.x509.f) {
                org.bouncycastle.x509.f fVar = (org.bouncycastle.x509.f) certPathParameters;
                bVar.v(fVar.n());
                bVar.w(fVar.l());
            }
            kVarA = bVar.q();
        } else if (certPathParameters instanceof jq.j) {
            kVarA = ((jq.j) certPathParameters).a();
        } else {
            if (!(certPathParameters instanceof jq.k)) {
                throw new InvalidAlgorithmParameterException("Parameters must be a " + PKIXParameters.class.getName() + " instance.");
            }
            kVarA = (jq.k) certPathParameters;
        }
        if (kVarA.v() == null) {
            throw new InvalidAlgorithmParameterException("trustAnchors is null, this is not allowed for certification path validation.");
        }
        List<? extends Certificate> certificates = certPath.getCertificates();
        int size = certificates.size();
        int i11 = -1;
        if (certificates.isEmpty()) {
            throw new CertPathValidatorException("Certification path is empty.", null, certPath, -1);
        }
        Date dateT = e.t(kVarA, new Date());
        Set setP = kVarA.p();
        try {
            TrustAnchor trustAnchorF = e.f((X509Certificate) certificates.get(certificates.size() - 1), kVarA.v(), kVarA.t());
            if (trustAnchorF != null) {
                a(trustAnchorF.getTrustedCert());
                jq.k kVarQ = new k.b(kVarA).t(trustAnchorF).q();
                ArrayList arrayList2 = new ArrayList();
                jq.f a0Var = null;
                for (PKIXCertPathChecker pKIXCertPathChecker : kVarQ.l()) {
                    pKIXCertPathChecker.init(false);
                    if (!(pKIXCertPathChecker instanceof PKIXRevocationChecker)) {
                        arrayList2.add(pKIXCertPathChecker);
                    } else {
                        if (a0Var != null) {
                            throw new CertPathValidatorException("only one PKIXRevocationChecker allowed");
                        }
                        a0Var = pKIXCertPathChecker instanceof jq.f ? (jq.f) pKIXCertPathChecker : new e0(pKIXCertPathChecker);
                    }
                }
                if (kVarQ.C() && a0Var == null) {
                    a0Var = new a0(this.f45510a);
                }
                jq.f fVar2 = a0Var;
                int i12 = size + 1;
                ArrayList[] arrayListArr = new ArrayList[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    arrayListArr[i13] = new ArrayList();
                }
                HashSet hashSet3 = new HashSet();
                hashSet3.add("2.5.29.32.0");
                w wVar = new w(new ArrayList(), 0, hashSet3, null, new HashSet(), "2.5.29.32.0", false);
                arrayListArr[0].add(wVar);
                v vVar = new v();
                HashSet hashSet4 = new HashSet();
                int i14 = kVarQ.A() ? 0 : i12;
                int i15 = kVarQ.y() ? 0 : i12;
                if (kVarQ.B()) {
                    i12 = 0;
                }
                X509Certificate trustedCert = trustAnchorF.getTrustedCert();
                try {
                    if (trustedCert != null) {
                        dVarA = x.f(trustedCert);
                        cAPublicKey = trustedCert.getPublicKey();
                    } else {
                        dVarA = x.a(trustAnchorF);
                        cAPublicKey = trustAnchorF.getCAPublicKey();
                    }
                    try {
                        i11 = e.i(cAPublicKey);
                        i11.x();
                        i11.A();
                        if (kVarQ.u() != null && !kVarQ.u().M((X509Certificate) certificates.get(0))) {
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
                        }
                        int size2 = certificates.size() - 1;
                        int iN = size;
                        X509Certificate x509Certificate = null;
                        int i16 = i15;
                        int i17 = i12;
                        int i18 = i14;
                        w wVar2 = wVar;
                        while (size2 >= 0) {
                            int i19 = size - size2;
                            int i20 = size;
                            X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                            boolean z10 = size2 == certificates.size() + (-1);
                            try {
                                a(x509Certificate2);
                                int i21 = size2;
                                jq.k kVar = kVarQ;
                                List<? extends Certificate> list2 = certificates;
                                v vVar2 = vVar;
                                Date date = dateT;
                                Date date2 = dateT;
                                int i22 = i17;
                                ArrayList[] arrayListArr2 = arrayListArr;
                                jq.k kVar2 = kVarQ;
                                int i23 = i18;
                                ArrayList arrayList3 = arrayList2;
                                boolean z11 = z10;
                                TrustAnchor trustAnchor = trustAnchorF;
                                b0.z(certPath, kVar, date, fVar2, i21, cAPublicKey, z11, dVarA, trustedCert);
                                b0.A(certPath, i21, vVar2, this.f45511b);
                                w wVarC = b0.C(certPath, i21, b0.B(certPath, i21, hashSet4, wVar2, arrayListArr2, i16, this.f45511b));
                                b0.D(certPath, i21, wVarC, i23);
                                if (i19 == i20) {
                                    iK = i16;
                                    arrayListArr = arrayListArr2;
                                    arrayList = arrayList3;
                                    iJ = i22;
                                    wVar2 = wVarC;
                                    iN = iN;
                                } else if (x509Certificate2 == null || x509Certificate2.getVersion() != 1) {
                                    b0.d(certPath, i21);
                                    arrayListArr = arrayListArr2;
                                    w wVarC2 = b0.c(certPath, i21, arrayListArr, wVarC, i22);
                                    b0.e(certPath, i21, vVar2);
                                    int iF = b0.f(certPath, i21, i23);
                                    int iG = b0.g(certPath, i21, i22);
                                    int iH = b0.h(certPath, i21, i16);
                                    i23 = b0.i(certPath, i21, iF);
                                    iJ = b0.j(certPath, i21, iG);
                                    iK = b0.k(certPath, i21, iH);
                                    b0.l(certPath, i21);
                                    iN = b0.n(certPath, i21, b0.m(certPath, i21, iN));
                                    b0.o(certPath, i21);
                                    Set<String> criticalExtensionOIDs = x509Certificate2.getCriticalExtensionOIDs();
                                    if (criticalExtensionOIDs != null) {
                                        hashSet2 = new HashSet(criticalExtensionOIDs);
                                        hashSet2.remove(b0.f45399n);
                                        hashSet2.remove(b0.f45387b);
                                        hashSet2.remove(b0.f45388c);
                                        hashSet2.remove(b0.f45389d);
                                        hashSet2.remove(b0.f45390e);
                                        hashSet2.remove(b0.f45392g);
                                        hashSet2.remove(b0.f45393h);
                                        hashSet2.remove(b0.f45394i);
                                        hashSet2.remove(b0.f45396k);
                                        hashSet2.remove(b0.f45397l);
                                    } else {
                                        hashSet2 = new HashSet();
                                    }
                                    arrayList = arrayList3;
                                    b0.p(certPath, i21, hashSet2, arrayList);
                                    xn.d dVarF = x.f(x509Certificate2);
                                    try {
                                        PublicKey publicKeyO = e.o(certPath.getCertificates(), i21, this.f45510a);
                                        zn.b bVarI = e.i(publicKeyO);
                                        bVarI.x();
                                        bVarI.A();
                                        wVar2 = wVarC2;
                                        dVarA = dVarF;
                                        cAPublicKey = publicKeyO;
                                        trustedCert = x509Certificate2;
                                    } catch (CertPathValidatorException e10) {
                                        throw new CertPathValidatorException("Next working key could not be retrieved.", e10, certPath, i21);
                                    }
                                } else {
                                    if (i19 != 1 || !x509Certificate2.equals(trustAnchor.getTrustedCert())) {
                                        throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, i21);
                                    }
                                    iK = i16;
                                    arrayListArr = arrayListArr2;
                                    arrayList = arrayList3;
                                    iJ = i22;
                                    wVar2 = wVarC;
                                    iN = iN;
                                }
                                i18 = i23;
                                i16 = iK;
                                arrayList2 = arrayList;
                                x509Certificate = x509Certificate2;
                                trustAnchorF = trustAnchor;
                                dateT = date2;
                                size = i20;
                                i17 = iJ;
                                vVar = vVar2;
                                certificates = list2;
                                size2 = i21 - 1;
                                kVarQ = kVar2;
                            } catch (AnnotatedException e11) {
                                throw new CertPathValidatorException(e11.getMessage(), e11.a(), certPath, size2);
                            }
                        }
                        jq.k kVar3 = kVarQ;
                        ArrayList arrayList4 = arrayList2;
                        TrustAnchor trustAnchor2 = trustAnchorF;
                        X509Certificate x509Certificate3 = x509Certificate;
                        int i24 = size2;
                        int i25 = i24 + 1;
                        int iF2 = b0.F(certPath, i25, b0.E(i18, x509Certificate3));
                        Set<String> criticalExtensionOIDs2 = x509Certificate3.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(b0.f45399n);
                            hashSet.remove(b0.f45387b);
                            hashSet.remove(b0.f45388c);
                            hashSet.remove(b0.f45389d);
                            hashSet.remove(b0.f45390e);
                            hashSet.remove(b0.f45392g);
                            hashSet.remove(b0.f45393h);
                            hashSet.remove(b0.f45394i);
                            hashSet.remove(b0.f45396k);
                            hashSet.remove(b0.f45397l);
                            hashSet.remove(b0.f45395j);
                            hashSet.remove(zn.y.f59080x.L());
                        } else {
                            hashSet = new HashSet();
                        }
                        b0.G(certPath, i25, arrayList4, hashSet);
                        w wVarH = b0.H(certPath, kVar3, setP, i25, arrayListArr, wVar2, hashSet4);
                        if (iF2 > 0 || wVarH != null) {
                            return new PKIXCertPathValidatorResult(trustAnchor2, wVarH, x509Certificate3.getPublicKey());
                        }
                        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, i24);
                    } catch (CertPathValidatorException e12) {
                        throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e12, certPath, -1);
                    }
                } catch (RuntimeException e13) {
                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e13, certPath, i11);
                }
            }
            list = certificates;
            i10 = 1;
            try {
                throw new CertPathValidatorException("Trust anchor for certification path not found.", null, certPath, -1);
            } catch (AnnotatedException e14) {
                e = e14;
            }
        } catch (AnnotatedException e15) {
            e = e15;
            list = certificates;
            i10 = 1;
        }
        throw new CertPathValidatorException(e.getMessage(), e.a(), certPath, list.size() - i10);
    }
}
