package org.bouncycastle.jce.provider;

import gm.f2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import jq.e;
import jq.i;
import org.bouncycastle.jce.exception.ExtCertPathBuilderException;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.util.StoreException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f45434n = "2.5.29.32.0";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f45436p = 5;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f45437q = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45421a = zn.y.f59075t.L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f45422b = zn.y.f59063j.L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f45423c = zn.y.f59076u.L();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f45424d = zn.y.f59061h.L();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f45425e = zn.y.f59073r.L();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f45426f = zn.y.f59059f.L();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f45427g = zn.y.f59082z.L();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f45428h = zn.y.f59071p.L();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f45429i = zn.y.f59070o.L();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f45430j = zn.y.f59079w.L();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f45431k = zn.y.f59081y.L();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f45432l = zn.y.f59074s.L();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f45433m = zn.y.f59077v.L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f45435o = zn.y.f59064k.L();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String[] f45438r = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static boolean A(int i10, List[] listArr, gm.y yVar, Set set) {
        List list = listArr[i10 - 1];
        for (int i11 = 0; i11 < list.size(); i11++) {
            w wVar = (w) list.get(i11);
            if (wVar.getExpectedPolicies().contains(yVar.L())) {
                HashSet hashSet = new HashSet();
                hashSet.add(yVar.L());
                w wVar2 = new w(new ArrayList(), i10, hashSet, wVar, set, yVar.L(), false);
                wVar.a(wVar2);
                listArr[i10].add(wVar2);
                return true;
            }
        }
        return false;
    }

    public static void B(int i10, List[] listArr, gm.y yVar, Set set) {
        List list = listArr[i10 - 1];
        for (int i11 = 0; i11 < list.size(); i11++) {
            w wVar = (w) list.get(i11);
            if ("2.5.29.32.0".equals(wVar.getValidPolicy())) {
                HashSet hashSet = new HashSet();
                hashSet.add(yVar.L());
                w wVar2 = new w(new ArrayList(), i10, hashSet, wVar, set, yVar.L(), false);
                wVar.a(wVar2);
                listArr[i10].add(wVar2);
                return;
            }
        }
    }

    public static w C(w wVar, List[] listArr, w wVar2) {
        w wVar3 = (w) wVar2.getParent();
        if (wVar == null) {
            return null;
        }
        if (wVar3 != null) {
            wVar3.d(wVar2);
            D(listArr, wVar2);
            return wVar;
        }
        for (int i10 = 0; i10 < listArr.length; i10++) {
            listArr[i10] = new ArrayList();
        }
        return null;
    }

    public static void D(List[] listArr, w wVar) {
        listArr[wVar.getDepth()].remove(wVar);
        if (wVar.c()) {
            Iterator children = wVar.getChildren();
            while (children.hasNext()) {
                D(listArr, (w) children.next());
            }
        }
    }

    public static void E(X509Certificate x509Certificate, PublicKey publicKey, String str) throws GeneralSecurityException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }

    public static void a(jq.g gVar, Set set, Object obj) throws RecoverableCertPathValidatorException {
        if (set.isEmpty()) {
            if (obj instanceof org.bouncycastle.x509.l) {
                throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + ((org.bouncycastle.x509.l) obj).m().b()[0] + "\"", null, gVar.a(), gVar.b());
            }
            throw new RecoverableCertPathValidatorException("No CRLs found for issuer \"" + yn.e.V.h(x.e((X509Certificate) obj)) + "\"", null, gVar.a(), gVar.b());
        }
    }

    public static void b(LinkedHashSet linkedHashSet, jq.i iVar, List list) throws AnnotatedException {
        for (Object obj : list) {
            if (obj instanceof org.bouncycastle.util.s) {
                try {
                    linkedHashSet.addAll(((org.bouncycastle.util.s) obj).a(iVar));
                } catch (StoreException e10) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e10);
                }
            } else {
                try {
                    linkedHashSet.addAll(jq.i.c(iVar, (CertStore) obj));
                } catch (CertStoreException e11) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e11);
                }
            }
        }
    }

    public static Collection c(X509Certificate x509Certificate, List<CertStore> list, List<jq.h> list2) throws AnnotatedException {
        byte[] bArrC;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(x.e(x509Certificate).getEncoded());
            try {
                byte[] extensionValue = x509Certificate.getExtensionValue(f45433m);
                if (extensionValue != null && (bArrC = zn.i.B(gm.z.I(extensionValue).J()).C()) != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new f2(bArrC).getEncoded());
                }
            } catch (Exception unused) {
            }
            jq.i<? extends Certificate> iVarA = new i.b(x509CertSelector).a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                b(linkedHashSet, iVarA, list);
                b(linkedHashSet, iVarA, list2);
                return linkedHashSet;
            } catch (AnnotatedException e10) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e10);
            }
        } catch (Exception e11) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e11);
        }
    }

    public static Collection d(jq.j jVar) throws CertPathBuilderException {
        jq.k kVarA = jVar.a();
        jq.i iVarU = kVarA.u();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            b(linkedHashSet, iVarU, kVarA.n());
            b(linkedHashSet, iVarU, kVarA.m());
            if (!linkedHashSet.isEmpty()) {
                return linkedHashSet;
            }
            Certificate certificateB = iVarU.b();
            if (certificateB != null) {
                return Collections.singleton(certificateB);
            }
            throw new CertPathBuilderException("No certificate found matching targetConstraints.");
        } catch (AnnotatedException e10) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e10);
        }
    }

    public static TrustAnchor e(X509Certificate x509Certificate, Set set) throws AnnotatedException {
        return f(x509Certificate, set, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006f A[PHI: r5
  0x006f: PHI (r5v5 xn.d) = (r5v1 xn.d), (r5v1 xn.d), (r5v1 xn.d), (r5v2 xn.d), (r5v2 xn.d), (r5v1 xn.d) binds: [B:12:0x0040, B:14:0x0046, B:16:0x004c, B:35:0x006f, B:20:0x0068, B:9:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.security.cert.TrustAnchor f(java.security.cert.X509Certificate r8, java.util.Set r9, java.lang.String r10) throws org.bouncycastle.jce.provider.AnnotatedException {
        /*
            java.security.cert.X509CertSelector r0 = new java.security.cert.X509CertSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r1 = r8.getIssuerX500Principal()
            r0.setSubject(r1)
            java.util.Iterator r9 = r9.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        L15:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto L7a
            if (r3 != 0) goto L7a
            java.lang.Object r3 = r9.next()
            java.security.cert.TrustAnchor r3 = (java.security.cert.TrustAnchor) r3
            java.security.cert.X509Certificate r7 = r3.getTrustedCert()
            if (r7 == 0) goto L3c
            java.security.cert.X509Certificate r7 = r3.getTrustedCert()
            boolean r7 = r0.match(r7)
            if (r7 == 0) goto L6f
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            java.security.PublicKey r6 = r6.getPublicKey()
            goto L70
        L3c:
            javax.security.auth.x500.X500Principal r7 = r3.getCA()
            if (r7 == 0) goto L6f
            java.lang.String r7 = r3.getCAName()
            if (r7 == 0) goto L6f
            java.security.PublicKey r7 = r3.getCAPublicKey()
            if (r7 == 0) goto L6f
            if (r5 != 0) goto L58
            byte[] r5 = r1.getEncoded()
            xn.d r5 = xn.d.A(r5)
        L58:
            javax.security.auth.x500.X500Principal r7 = r3.getCA()     // Catch: java.lang.IllegalArgumentException -> L6f
            byte[] r7 = r7.getEncoded()     // Catch: java.lang.IllegalArgumentException -> L6f
            xn.d r7 = xn.d.A(r7)     // Catch: java.lang.IllegalArgumentException -> L6f
            boolean r7 = r5.equals(r7)     // Catch: java.lang.IllegalArgumentException -> L6f
            if (r7 == 0) goto L6f
            java.security.PublicKey r6 = r3.getCAPublicKey()     // Catch: java.lang.IllegalArgumentException -> L6f
            goto L70
        L6f:
            r3 = r2
        L70:
            if (r6 == 0) goto L15
            E(r8, r6, r10)     // Catch: java.lang.Exception -> L76
            goto L15
        L76:
            r4 = move-exception
            r3 = r2
            r6 = r3
            goto L15
        L7a:
            if (r3 != 0) goto L87
            if (r4 != 0) goto L7f
            goto L87
        L7f:
            org.bouncycastle.jce.provider.AnnotatedException r8 = new org.bouncycastle.jce.provider.AnnotatedException
            java.lang.String r9 = "TrustAnchor found but certificate validation failed."
            r8.<init>(r9, r4)
            throw r8
        L87:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.e.f(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }

    public static List<jq.h> g(byte[] bArr, Map<zn.b0, jq.h> map) throws CertificateParsingException {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        zn.b0[] b0VarArrB = zn.c0.A(gm.z.I(bArr).J()).B();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            jq.h hVar = map.get(b0VarArrB[i10]);
            if (hVar != null) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    public static List<jq.d> h(zn.k kVar, Map<zn.b0, jq.d> map, Date date, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException {
        if (kVar == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            zn.v[] vVarArrY = kVar.y();
            ArrayList arrayList = new ArrayList();
            for (zn.v vVar : vVarArrY) {
                zn.w wVarZ = vVar.z();
                if (wVarZ != null && wVarZ.B() == 0) {
                    for (zn.b0 b0Var : zn.c0.A(wVarZ.A()).B()) {
                        jq.d dVar2 = map.get(b0Var);
                        if (dVar2 != null) {
                            arrayList.add(dVar2);
                        }
                    }
                }
            }
            if (arrayList.isEmpty() && org.bouncycastle.util.p.d("org.bouncycastle.x509.enableCRLDP")) {
                try {
                    CertificateFactory certificateFactoryS = dVar.s("X.509");
                    for (int i10 = 0; i10 < vVarArrY.length; i10++) {
                        zn.w wVarZ2 = vVarArrY[i10].z();
                        if (wVarZ2 != null && wVarZ2.B() == 0) {
                            zn.b0[] b0VarArrB = zn.c0.A(wVarZ2.A()).B();
                            int i11 = 0;
                            while (true) {
                                if (i11 < b0VarArrB.length) {
                                    zn.b0 b0Var2 = b0VarArrB[i10];
                                    if (b0Var2.q() == 6) {
                                        try {
                                            jq.d dVarA = h.a(certificateFactoryS, date, new URI(((gm.k0) b0Var2.A()).d()));
                                            if (dVarA != null) {
                                                arrayList.add(dVarA);
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                            i11++;
                                        }
                                    }
                                    i11++;
                                }
                            }
                        }
                    }
                } catch (Exception e10) {
                    throw new AnnotatedException("cannot create certificate factory: " + e10.getMessage(), e10);
                }
            }
            return arrayList;
        } catch (Exception e11) {
            throw new AnnotatedException("Distribution points could not be read.", e11);
        }
    }

    public static zn.b i(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return c1.A(publicKey.getEncoded()).x();
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e10);
        }
    }

    public static void j(zn.v vVar, Collection collection, X509CRLSelector x509CRLSelector) throws AnnotatedException {
        ArrayList arrayList = new ArrayList();
        if (vVar.y() != null) {
            zn.b0[] b0VarArrB = vVar.y().B();
            for (int i10 = 0; i10 < b0VarArrB.length; i10++) {
                if (b0VarArrB[i10].q() == 4) {
                    try {
                        arrayList.add(xn.d.A(b0VarArrB[i10].A().b().getEncoded()));
                    } catch (IOException e10) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e10);
                    }
                }
            }
        } else {
            if (vVar.z() == null) {
                throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.");
            }
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next());
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            try {
                x509CRLSelector.addIssuerName(((xn.d) it3.next()).getEncoded());
            } catch (IOException e11) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e11);
            }
        }
    }

    public static void k(Date date, X509CRL x509crl, Object obj, f fVar) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        try {
            if (h0.c(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(r(obj));
                if (revokedCertificate == null) {
                    return;
                }
                X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                if (!x.c(obj).equals(certificateIssuer == null ? x.d(x509crl) : x.g(certificateIssuer))) {
                    return;
                }
            } else if (!x.c(obj).equals(x.d(x509crl)) || (revokedCertificate = x509crl.getRevokedCertificate(r(obj))) == null) {
                return;
            }
            gm.k kVarI = null;
            if (revokedCertificate.hasExtensions()) {
                if (revokedCertificate.hasUnsupportedCriticalExtension()) {
                    throw new AnnotatedException("CRL entry has unsupported critical extensions.");
                }
                try {
                    kVarI = gm.k.I(n(revokedCertificate, zn.y.f59067l.L()));
                } catch (Exception e10) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e10);
                }
            }
            int iM = kVarI == null ? 0 : kVarI.M();
            if (date.getTime() >= revokedCertificate.getRevocationDate().getTime() || iM == 0 || iM == 1 || iM == 2 || iM == 10) {
                fVar.c(iM);
                fVar.d(revokedCertificate.getRevocationDate());
            }
        } catch (CRLException e11) {
            throw new AnnotatedException("Failed check for indirect CRL.", e11);
        }
    }

    public static Set l(jq.g gVar, zn.v vVar, Object obj, jq.k kVar, Date date) throws AnnotatedException, RecoverableCertPathValidatorException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(x.c(obj));
            j(vVar, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            Set setA = q.a(new e.b(x509CRLSelector).h(true).g(), date, kVar.m(), kVar.k());
            a(gVar, setA, obj);
            return setA;
        } catch (AnnotatedException e10) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e10);
        }
    }

    public static Set m(Date date, X509CRL x509crl, List<CertStore> list, List<jq.d> list2, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(x.d(x509crl).getEncoded());
            try {
                gm.c0 c0VarN = n(x509crl, f45435o);
                BigInteger bigIntegerJ = c0VarN != null ? gm.t.I(c0VarN).J() : null;
                try {
                    byte[] extensionValue = x509crl.getExtensionValue(f45428h);
                    x509CRLSelector.setMinCRLNumber(bigIntegerJ != null ? bigIntegerJ.add(BigInteger.valueOf(1L)) : null);
                    e.b bVar = new e.b(x509CRLSelector);
                    bVar.j(extensionValue);
                    bVar.k(true);
                    bVar.l(bigIntegerJ);
                    jq.e<? extends CRL> eVarG = bVar.g();
                    Set<X509CRL> setA = q.a(eVarG, date, list, list2);
                    if (setA.isEmpty() && org.bouncycastle.util.p.d("org.bouncycastle.x509.enableCRLDP")) {
                        try {
                            CertificateFactory certificateFactoryS = dVar.s("X.509");
                            zn.v[] vVarArrY = zn.k.A(extensionValue).y();
                            for (int i10 = 0; i10 < vVarArrY.length; i10++) {
                                zn.w wVarZ = vVarArrY[i10].z();
                                if (wVarZ != null && wVarZ.B() == 0) {
                                    zn.b0[] b0VarArrB = zn.c0.A(wVarZ.A()).B();
                                    int i11 = 0;
                                    while (true) {
                                        if (i11 < b0VarArrB.length) {
                                            zn.b0 b0Var = b0VarArrB[i10];
                                            if (b0Var.q() == 6) {
                                                try {
                                                    jq.d dVarA = h.a(certificateFactoryS, date, new URI(((gm.k0) b0Var.A()).d()));
                                                    if (dVarA != null) {
                                                        setA = q.a(eVarG, date, Collections.EMPTY_LIST, Collections.singletonList(dVarA));
                                                    }
                                                } catch (Exception unused) {
                                                    continue;
                                                    i11++;
                                                }
                                            }
                                            i11++;
                                        }
                                    }
                                }
                            }
                        } catch (Exception e10) {
                            throw new AnnotatedException("cannot create certificate factory: " + e10.getMessage(), e10);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    for (X509CRL x509crl2 : setA) {
                        if (v(x509crl2)) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e11) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e11);
                }
            } catch (Exception e12) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e12);
            }
        } catch (IOException e13) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e13);
        }
    }

    public static gm.c0 n(X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return p(str, extensionValue);
    }

    public static PublicKey o(List list, int i10, org.bouncycastle.jcajce.util.d dVar) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i10)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i10++;
            if (i10 >= list.size()) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            PublicKey publicKey2 = ((X509Certificate) list.get(i10)).getPublicKey();
            if (!(publicKey2 instanceof DSAPublicKey)) {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
            dSAPublicKey = (DSAPublicKey) publicKey2;
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return dVar.b("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public static gm.c0 p(String str, byte[] bArr) throws AnnotatedException {
        try {
            return gm.c0.D(gm.z.I(bArr).J());
        } catch (Exception e10) {
            throw new AnnotatedException("exception processing extension " + str, e10);
        }
    }

    public static final Set q(gm.f0 f0Var) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (f0Var == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        gm.b0 b0VarB = gm.b0.b(byteArrayOutputStream);
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            try {
                b0VarB.x((gm.h) enumerationL.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e10) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e10);
            }
        }
        return hashSet;
    }

    public static BigInteger r(Object obj) {
        return ((X509Certificate) obj).getSerialNumber();
    }

    public static Date s(Date date, int i10, CertPath certPath, int i11) throws AnnotatedException {
        if (1 != i10 || i11 <= 0) {
            return date;
        }
        int i12 = i11 - 1;
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i12);
        if (i12 == 0) {
            try {
                byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i12)).getExtensionValue(eq.a.f27096e.L());
                gm.o oVarM = extensionValue != null ? gm.o.M(gm.c0.D(extensionValue)) : null;
                if (oVarM != null) {
                    try {
                        return oVarM.K();
                    } catch (ParseException e10) {
                        throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e10);
                    }
                }
            } catch (IOException unused) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            } catch (IllegalArgumentException unused2) {
                throw new AnnotatedException("Date of cert gen extension could not be read.");
            }
        }
        return x509Certificate.getNotBefore();
    }

    public static Date t(jq.k kVar, Date date) {
        Date dateW = kVar.w();
        return dateW == null ? date : dateW;
    }

    public static boolean u(Set set) {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    public static boolean v(X509CRL x509crl) {
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        return criticalExtensionOIDs.contains(b0.f45392g);
    }

    public static boolean w(X509Certificate x509Certificate, Set set, String str) throws AnnotatedException {
        try {
            return f(x509Certificate, set, str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean x(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
    
        if (r13.getCriticalExtensionOIDs() == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r7 = r13.getCriticalExtensionOIDs().contains(org.bouncycastle.jce.provider.e.f45421a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a1, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a2, code lost:
    
        r13 = (org.bouncycastle.jce.provider.w) r1.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b0, code lost:
    
        if ("2.5.29.32.0".equals(r13.getValidPolicy()) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b2, code lost:
    
        r8 = new org.bouncycastle.jce.provider.w(new java.util.ArrayList(), r9, (java.util.Set) r12.get(r11), r13, r5, r11, r7);
        r13.a(r8);
        r10[r9].add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void y(int r9, java.util.List[] r10, java.lang.String r11, java.util.Map r12, java.security.cert.X509Certificate r13) throws org.bouncycastle.jce.provider.AnnotatedException, java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.e.y(int, java.util.List[], java.lang.String, java.util.Map, java.security.cert.X509Certificate):void");
    }

    public static w z(int i10, List[] listArr, String str, w wVar) {
        int i11;
        Iterator it2 = listArr[i10].iterator();
        while (it2.hasNext()) {
            w wVar2 = (w) it2.next();
            if (wVar2.getValidPolicy().equals(str)) {
                ((w) wVar2.getParent()).d(wVar2);
                it2.remove();
                for (int i12 = i10 - 1; i12 >= 0; i12--) {
                    List list = listArr[i12];
                    while (i11 < list.size()) {
                        w wVar3 = (w) list.get(i11);
                        i11 = (wVar3.c() || (wVar = C(wVar, listArr, wVar3)) != null) ? i11 + 1 : 0;
                    }
                }
            }
        }
        return wVar;
    }
}
