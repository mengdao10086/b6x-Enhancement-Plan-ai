package org.bouncycastle.x509;

import gm.b0;
import gm.c0;
import gm.f0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.StoreException;
import zn.c1;
import zn.i0;
import zn.t1;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f46087l = "2.5.29.32.0";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f46088m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f46089n = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f46076a = zn.y.f59075t.L();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f46077b = zn.y.f59063j.L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f46078c = zn.y.f59076u.L();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f46079d = zn.y.f59061h.L();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f46080e = zn.y.f59073r.L();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f46081f = zn.y.f59059f.L();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f46082g = zn.y.f59082z.L();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f46083h = zn.y.f59071p.L();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f46084i = zn.y.f59070o.L();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f46085j = zn.y.f59079w.L();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f46086k = zn.y.f59064k.L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f46090o = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static Collection a(jq.i iVar, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof org.bouncycastle.util.s) {
                try {
                    hashSet.addAll(((org.bouncycastle.util.s) obj).a(iVar));
                } catch (StoreException e10) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e10);
                }
            } else {
                try {
                    hashSet.addAll(jq.i.c(iVar, (CertStore) obj));
                } catch (CertStoreException e11) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e11);
                }
            }
        }
        return hashSet;
    }

    public static Collection b(k kVar, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        for (Object obj : list) {
            if (obj instanceof r) {
                try {
                    hashSet.addAll(((r) obj).a(kVar));
                } catch (StoreException e10) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e10);
                }
            }
        }
        return hashSet;
    }

    public static Collection c(o oVar, List list) throws AnnotatedException {
        HashSet hashSet = new HashSet();
        CertificateFactory certificateFactory = new CertificateFactory();
        for (Object obj : list) {
            if (obj instanceof org.bouncycastle.util.s) {
                try {
                    for (Object objEngineGenerateCertificate : ((org.bouncycastle.util.s) obj).a(oVar)) {
                        if (objEngineGenerateCertificate instanceof org.bouncycastle.util.g) {
                            objEngineGenerateCertificate = certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(((org.bouncycastle.util.g) objEngineGenerateCertificate).getEncoded()));
                        } else if (!(objEngineGenerateCertificate instanceof Certificate)) {
                            throw new AnnotatedException("Unknown object found in certificate store.");
                        }
                        hashSet.add(objEngineGenerateCertificate);
                    }
                } catch (IOException e10) {
                    throw new AnnotatedException("Problem while extracting certificates from X.509 store.", e10);
                } catch (CertificateException e11) {
                    throw new AnnotatedException("Problem while extracting certificates from X.509 store.", e11);
                } catch (StoreException e12) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e12);
                }
            } else {
                try {
                    hashSet.addAll(((CertStore) obj).getCertificates(oVar));
                } catch (CertStoreException e13) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e13);
                }
            }
        }
        return hashSet;
    }

    public static zn.b d(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return c1.A(new gm.s(publicKey.getEncoded()).n()).y();
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e10);
        }
    }

    public static void e(Date date, X509CRL x509crl, Object obj, d dVar) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        try {
            if (p(x509crl)) {
                revokedCertificate = x509crl.getRevokedCertificate(l(obj));
                if (revokedCertificate == null) {
                    return;
                }
                X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                if (certificateIssuer == null) {
                    certificateIssuer = h(x509crl);
                }
                if (!f(obj).equals(certificateIssuer)) {
                    return;
                }
            } else if (!f(obj).equals(h(x509crl)) || (revokedCertificate = x509crl.getRevokedCertificate(l(obj))) == null) {
                return;
            }
            gm.k kVarI = null;
            if (revokedCertificate.hasExtensions()) {
                try {
                    kVarI = gm.k.I(g(revokedCertificate, t1.f58954k.L()));
                } catch (Exception e10) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e10);
                }
            }
            int iM = kVarI == null ? 0 : kVarI.M();
            if (date.getTime() >= revokedCertificate.getRevocationDate().getTime() || iM == 0 || iM == 1 || iM == 2 || iM == 10) {
                dVar.c(iM);
                dVar.d(revokedCertificate.getRevocationDate());
            }
        } catch (CRLException e11) {
            throw new AnnotatedException("Failed check for indirect CRL.", e11);
        }
    }

    public static X500Principal f(Object obj) {
        return obj instanceof X509Certificate ? ((X509Certificate) obj).getIssuerX500Principal() : (X500Principal) ((l) obj).m().b()[0];
    }

    public static c0 g(X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        return j(str, extensionValue);
    }

    public static X500Principal h(X509CRL x509crl) {
        return x509crl.getIssuerX500Principal();
    }

    public static PublicKey i(List list, int i10) throws CertPathValidatorException {
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
            return KeyFactory.getInstance("DSA", BouncyCastleProvider.f45329b).generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage());
        }
    }

    public static c0 j(String str, byte[] bArr) throws AnnotatedException {
        try {
            return new gm.s(((gm.z) new gm.s(bArr).n()).J()).n();
        } catch (Exception e10) {
            throw new AnnotatedException("exception processing extension " + str, e10);
        }
    }

    public static final Set k(f0 f0Var) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (f0Var == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        b0 b0VarB = b0.b(byteArrayOutputStream);
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

    public static BigInteger l(Object obj) {
        return obj instanceof X509Certificate ? ((X509Certificate) obj).getSerialNumber() : ((l) obj).getSerialNumber();
    }

    public static X500Principal m(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectX500Principal();
    }

    public static Date n(PKIXParameters pKIXParameters, Date date) {
        Date date2 = pKIXParameters.getDate();
        return date2 == null ? date : date2;
    }

    public static boolean o(Set set) {
        return set == null || set.contains("2.5.29.32.0") || set.isEmpty();
    }

    public static boolean p(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(zn.y.f59071p.L());
            if (extensionValue != null) {
                if (i0.B(gm.z.I(extensionValue).J()).D()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            throw new CRLException("Exception reading IssuingDistributionPoint: " + e10);
        }
    }

    public static boolean q(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008f, code lost:
    
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
    
        if (r13.getCriticalExtensionOIDs() == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
    
        r7 = r13.getCriticalExtensionOIDs().contains(org.bouncycastle.x509.c.f46076a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a2, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a3, code lost:
    
        r13 = (org.bouncycastle.jce.provider.w) r1.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b1, code lost:
    
        if ("2.5.29.32.0".equals(r13.getValidPolicy()) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
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
    public static void r(int r9, java.util.List[] r10, java.lang.String r11, java.util.Map r12, java.security.cert.X509Certificate r13) throws org.bouncycastle.jce.provider.AnnotatedException, java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.c.r(int, java.util.List[], java.lang.String, java.util.Map, java.security.cert.X509Certificate):void");
    }

    public static org.bouncycastle.jce.provider.w s(int i10, List[] listArr, String str, org.bouncycastle.jce.provider.w wVar) {
        int i11;
        Iterator it2 = listArr[i10].iterator();
        while (it2.hasNext()) {
            org.bouncycastle.jce.provider.w wVar2 = (org.bouncycastle.jce.provider.w) it2.next();
            if (wVar2.getValidPolicy().equals(str)) {
                ((org.bouncycastle.jce.provider.w) wVar2.getParent()).d(wVar2);
                it2.remove();
                for (int i12 = i10 - 1; i12 >= 0; i12--) {
                    List list = listArr[i12];
                    while (i11 < list.size()) {
                        org.bouncycastle.jce.provider.w wVar3 = (org.bouncycastle.jce.provider.w) list.get(i11);
                        i11 = (wVar3.c() || (wVar = v(wVar, listArr, wVar3)) != null) ? i11 + 1 : 0;
                    }
                }
            }
        }
        return wVar;
    }

    public static boolean t(int i10, List[] listArr, gm.y yVar, Set set) {
        List list = listArr[i10 - 1];
        for (int i11 = 0; i11 < list.size(); i11++) {
            org.bouncycastle.jce.provider.w wVar = (org.bouncycastle.jce.provider.w) list.get(i11);
            if (wVar.getExpectedPolicies().contains(yVar.L())) {
                HashSet hashSet = new HashSet();
                hashSet.add(yVar.L());
                org.bouncycastle.jce.provider.w wVar2 = new org.bouncycastle.jce.provider.w(new ArrayList(), i10, hashSet, wVar, set, yVar.L(), false);
                wVar.a(wVar2);
                listArr[i10].add(wVar2);
                return true;
            }
        }
        return false;
    }

    public static void u(int i10, List[] listArr, gm.y yVar, Set set) {
        List list = listArr[i10 - 1];
        for (int i11 = 0; i11 < list.size(); i11++) {
            org.bouncycastle.jce.provider.w wVar = (org.bouncycastle.jce.provider.w) list.get(i11);
            if ("2.5.29.32.0".equals(wVar.getValidPolicy())) {
                HashSet hashSet = new HashSet();
                hashSet.add(yVar.L());
                org.bouncycastle.jce.provider.w wVar2 = new org.bouncycastle.jce.provider.w(new ArrayList(), i10, hashSet, wVar, set, yVar.L(), false);
                wVar.a(wVar2);
                listArr[i10].add(wVar2);
                return;
            }
        }
    }

    public static org.bouncycastle.jce.provider.w v(org.bouncycastle.jce.provider.w wVar, List[] listArr, org.bouncycastle.jce.provider.w wVar2) {
        org.bouncycastle.jce.provider.w wVar3 = (org.bouncycastle.jce.provider.w) wVar2.getParent();
        if (wVar == null) {
            return null;
        }
        if (wVar3 != null) {
            wVar3.d(wVar2);
            w(listArr, wVar2);
            return wVar;
        }
        for (int i10 = 0; i10 < listArr.length; i10++) {
            listArr[i10] = new ArrayList();
        }
        return null;
    }

    public static void w(List[] listArr, org.bouncycastle.jce.provider.w wVar) {
        listArr[wVar.getDepth()].remove(wVar);
        if (wVar.c()) {
            Iterator children = wVar.getChildren();
            while (children.hasNext()) {
                w(listArr, (org.bouncycastle.jce.provider.w) children.next());
            }
        }
    }

    public static void x(X509Certificate x509Certificate, PublicKey publicKey, String str) throws GeneralSecurityException {
        if (str == null) {
            x509Certificate.verify(publicKey);
        } else {
            x509Certificate.verify(publicKey, str);
        }
    }
}
