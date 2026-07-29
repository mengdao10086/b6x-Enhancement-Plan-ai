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
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jq.k;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import zn.e1;

/* JADX INFO: loaded from: classes5.dex */
public class t extends CertPathValidatorSpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f45508b;

    public t() {
        this(false);
    }

    public t(boolean z10) {
        this.f45507a = new org.bouncycastle.jcajce.util.b();
        this.f45508b = z10;
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
        int iJ;
        ArrayList[] arrayListArr;
        List list2;
        int i11;
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
        int i12 = -1;
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
                int i13 = size + 1;
                ArrayList[] arrayListArr2 = new ArrayList[i13];
                for (int i14 = 0; i14 < i13; i14++) {
                    arrayListArr2[i14] = new ArrayList();
                }
                HashSet hashSet3 = new HashSet();
                hashSet3.add("2.5.29.32.0");
                w wVar = new w(new ArrayList(), 0, hashSet3, null, new HashSet(), "2.5.29.32.0", false);
                arrayListArr2[0].add(wVar);
                v vVar = new v();
                HashSet hashSet4 = new HashSet();
                int i15 = kVarQ.A() ? 0 : i13;
                int i16 = kVarQ.y() ? 0 : i13;
                if (kVarQ.B()) {
                    i13 = 0;
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
                        i12 = e.i(cAPublicKey);
                        i12.x();
                        i12.A();
                        if (kVarQ.u() != null && !kVarQ.u().M((X509Certificate) certificates.get(0))) {
                            throw new ExtCertPathValidatorException("Target certificate in certification path does not match targetConstraints.", null, certPath, 0);
                        }
                        List listL = kVarQ.l();
                        Iterator it2 = listL.iterator();
                        while (it2.hasNext()) {
                            ((PKIXCertPathChecker) it2.next()).init(false);
                        }
                        y yVar = kVarQ.C() ? new y(this.f45507a) : null;
                        TrustAnchor trustAnchor = trustAnchorF;
                        int iN = size;
                        X509Certificate x509Certificate = null;
                        int i17 = i13;
                        int i18 = i16;
                        w wVar2 = wVar;
                        int i19 = i15;
                        int size2 = certificates.size() - 1;
                        int i20 = i19;
                        while (size2 >= 0) {
                            int i21 = size - size2;
                            int i22 = size;
                            X509Certificate x509Certificate2 = (X509Certificate) certificates.get(size2);
                            boolean z10 = size2 == certificates.size() + (-1);
                            try {
                                a(x509Certificate2);
                                int i23 = i18;
                                List<? extends Certificate> list3 = certificates;
                                int i24 = i20;
                                int i25 = size2;
                                Date date = dateT;
                                Date date2 = dateT;
                                int i26 = i17;
                                y yVar2 = yVar;
                                y yVar3 = yVar;
                                v vVar2 = vVar;
                                ArrayList[] arrayListArr3 = arrayListArr2;
                                boolean z11 = z10;
                                TrustAnchor trustAnchor2 = trustAnchor;
                                jq.k kVar = kVarQ;
                                List list4 = listL;
                                b0.z(certPath, kVarQ, date, yVar2, i25, cAPublicKey, z11, dVarA, trustedCert);
                                b0.A(certPath, i25, vVar2, this.f45508b);
                                w wVarC = b0.C(certPath, i25, b0.B(certPath, i25, hashSet4, wVar2, arrayListArr3, i23, this.f45508b));
                                b0.D(certPath, i25, wVarC, i24);
                                if (i21 == i22) {
                                    iJ = i26;
                                    arrayListArr = arrayListArr3;
                                    list2 = list4;
                                    wVar2 = wVarC;
                                    i18 = i23;
                                    iN = iN;
                                    i11 = i24;
                                } else if (x509Certificate2 == null || x509Certificate2.getVersion() != 1) {
                                    b0.d(certPath, i25);
                                    arrayListArr = arrayListArr3;
                                    w wVarC2 = b0.c(certPath, i25, arrayListArr, wVarC, i26);
                                    b0.e(certPath, i25, vVar2);
                                    int iF = b0.f(certPath, i25, i24);
                                    int iG = b0.g(certPath, i25, i26);
                                    int iH = b0.h(certPath, i25, i23);
                                    i11 = b0.i(certPath, i25, iF);
                                    iJ = b0.j(certPath, i25, iG);
                                    int iK = b0.k(certPath, i25, iH);
                                    b0.l(certPath, i25);
                                    iN = b0.n(certPath, i25, b0.m(certPath, i25, iN));
                                    b0.o(certPath, i25);
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
                                    list2 = list4;
                                    b0.p(certPath, i25, hashSet2, list2);
                                    xn.d dVarF = x.f(x509Certificate2);
                                    try {
                                        PublicKey publicKeyO = e.o(certPath.getCertificates(), i25, this.f45507a);
                                        zn.b bVarI = e.i(publicKeyO);
                                        bVarI.x();
                                        bVarI.A();
                                        wVar2 = wVarC2;
                                        i18 = iK;
                                        dVarA = dVarF;
                                        cAPublicKey = publicKeyO;
                                        trustedCert = x509Certificate2;
                                    } catch (CertPathValidatorException e10) {
                                        throw new CertPathValidatorException("Next working key could not be retrieved.", e10, certPath, i25);
                                    }
                                } else {
                                    if (i21 != 1 || !x509Certificate2.equals(trustAnchor2.getTrustedCert())) {
                                        throw new CertPathValidatorException("Version 1 certificates can't be used as CA ones.", null, certPath, i25);
                                    }
                                    iJ = i26;
                                    arrayListArr = arrayListArr3;
                                    list2 = list4;
                                    wVar2 = wVarC;
                                    i18 = i23;
                                    iN = iN;
                                    i11 = i24;
                                }
                                arrayListArr2 = arrayListArr;
                                listL = list2;
                                x509Certificate = x509Certificate2;
                                certificates = list3;
                                dateT = date2;
                                kVarQ = kVar;
                                size = i22;
                                i20 = i11;
                                trustAnchor = trustAnchor2;
                                i17 = iJ;
                                size2 = i25 - 1;
                                vVar = vVar2;
                                yVar = yVar3;
                            } catch (AnnotatedException e11) {
                                throw new CertPathValidatorException(e11.getMessage(), e11.a(), certPath, size2);
                            }
                        }
                        TrustAnchor trustAnchor3 = trustAnchor;
                        jq.k kVar2 = kVarQ;
                        ArrayList[] arrayListArr4 = arrayListArr2;
                        List list5 = listL;
                        int i27 = size2;
                        int i28 = i27 + 1;
                        int iF2 = b0.F(certPath, i28, b0.E(i20, x509Certificate));
                        Set<String> criticalExtensionOIDs2 = x509Certificate.getCriticalExtensionOIDs();
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
                        b0.G(certPath, i28, list5, hashSet);
                        w wVarH = b0.H(certPath, kVar2, setP, i28, arrayListArr4, wVar2, hashSet4);
                        if (iF2 > 0 || wVarH != null) {
                            return new PKIXCertPathValidatorResult(trustAnchor3, wVarH, x509Certificate.getPublicKey());
                        }
                        throw new CertPathValidatorException("Path processing failed on policy.", null, certPath, i27);
                    } catch (CertPathValidatorException e12) {
                        throw new ExtCertPathValidatorException("Algorithm identifier of public key of trust anchor could not be read.", e12, certPath, -1);
                    }
                } catch (RuntimeException e13) {
                    throw new ExtCertPathValidatorException("Subject of trust anchor could not be (re)encoded.", e13, certPath, i12);
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
