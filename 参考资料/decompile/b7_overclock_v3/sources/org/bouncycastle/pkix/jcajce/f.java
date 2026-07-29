package org.bouncycastle.pkix.jcajce;

import gm.t;
import gm.z;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import jq.e;
import jq.i;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.util.s;
import zn.b0;
import zn.c0;
import zn.i0;
import zn.k;
import zn.v;
import zn.w;
import zn.y;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45669a = y.f59071p.L();

    public static void a(Set set, Object obj) throws CRLNotFoundException {
        if (set.isEmpty()) {
            throw new CRLNotFoundException("No CRLs found for issuer \"" + yn.e.V.h(j((X509Certificate) obj)) + "\"");
        }
    }

    public static void b(LinkedHashSet linkedHashSet, i iVar, List list) throws AnnotatedException {
        for (Object obj : list) {
            if (obj instanceof s) {
                try {
                    linkedHashSet.addAll(((s) obj).a(iVar));
                } catch (StoreException e10) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e10);
                }
            } else {
                try {
                    linkedHashSet.addAll(i.c(iVar, (CertStore) obj));
                } catch (CertStoreException e11) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e11);
                }
            }
        }
    }

    public static List<jq.d> c(k kVar, Map<b0, jq.d> map) throws AnnotatedException {
        if (kVar == null) {
            return Collections.emptyList();
        }
        try {
            v[] vVarArrY = kVar.y();
            ArrayList arrayList = new ArrayList();
            for (v vVar : vVarArrY) {
                w wVarZ = vVar.z();
                if (wVarZ != null && wVarZ.B() == 0) {
                    for (b0 b0Var : c0.A(wVarZ.A()).B()) {
                        jq.d dVar = map.get(b0Var);
                        if (dVar != null) {
                            arrayList.add(dVar);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e10) {
            throw new AnnotatedException("Distribution points could not be read.", e10);
        }
    }

    public static void d(v vVar, Collection collection, X509CRLSelector x509CRLSelector) throws AnnotatedException {
        ArrayList arrayList = new ArrayList();
        if (vVar.y() != null) {
            b0[] b0VarArrB = vVar.y().B();
            for (int i10 = 0; i10 < b0VarArrB.length; i10++) {
                if (b0VarArrB[i10].q() == 4) {
                    try {
                        arrayList.add(xn.d.A(b0VarArrB[i10].A()));
                    } catch (IllegalArgumentException e10) {
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

    public static void e(Date date, X509CRL x509crl, Object obj, a aVar) throws AnnotatedException {
        X509CRLEntry revokedCertificate;
        try {
            boolean zP = p(x509crl);
            X509Certificate x509Certificate = (X509Certificate) obj;
            xn.d dVarJ = j(x509Certificate);
            if ((zP || dVarJ.equals(i(x509crl))) && (revokedCertificate = x509crl.getRevokedCertificate(x509Certificate.getSerialNumber())) != null) {
                if (zP) {
                    X500Principal certificateIssuer = revokedCertificate.getCertificateIssuer();
                    if (!dVarJ.equals(certificateIssuer == null ? i(x509crl) : n(certificateIssuer))) {
                        return;
                    }
                }
                int iM = 0;
                if (revokedCertificate.hasExtensions()) {
                    try {
                        gm.k kVarI = gm.k.I(h(revokedCertificate, y.f59067l));
                        if (kVarI != null) {
                            iM = kVarI.M();
                        }
                    } catch (Exception e10) {
                        throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e10);
                    }
                }
                Date revocationDate = revokedCertificate.getRevocationDate();
                if (!date.before(revocationDate) || iM == 0 || iM == 1 || iM == 2 || iM == 10) {
                    aVar.c(iM);
                    aVar.d(revocationDate);
                }
            }
        } catch (CRLException e11) {
            throw new AnnotatedException("Failed check for indirect CRL.", e11);
        }
    }

    public static Set f(v vVar, Object obj, Date date, List list, List list2) throws AnnotatedException, CRLNotFoundException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(j((X509Certificate) obj));
            d(vVar, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            Set setA = c.a(new e.b(x509CRLSelector).h(true).g(), date, list, list2);
            a(setA, obj);
            return setA;
        } catch (AnnotatedException e10) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e10);
        }
    }

    public static Set g(Date date, X509CRL x509crl, List<CertStore> list, List<jq.d> list2) throws AnnotatedException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(x509crl.getIssuerX500Principal().getEncoded());
            try {
                gm.c0 c0VarH = h(x509crl, y.f59064k);
                BigInteger bigIntegerJ = c0VarH != null ? t.I(c0VarH).J() : null;
                try {
                    byte[] extensionValue = x509crl.getExtensionValue(f45669a);
                    x509CRLSelector.setMinCRLNumber(bigIntegerJ != null ? bigIntegerJ.add(BigInteger.valueOf(1L)) : null);
                    e.b bVar = new e.b(x509CRLSelector);
                    bVar.j(extensionValue);
                    bVar.k(true);
                    bVar.l(bigIntegerJ);
                    Set<X509CRL> setA = c.a(bVar.g(), date, list, list2);
                    HashSet hashSet = new HashSet();
                    for (X509CRL x509crl2 : setA) {
                        if (o(x509crl2)) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e10) {
                    throw new AnnotatedException("issuing distribution point extension value could not be read", e10);
                }
            } catch (Exception e11) {
                throw new AnnotatedException("cannot extract CRL number extension from CRL", e11);
            }
        } catch (IOException e12) {
            throw new AnnotatedException("cannot extract issuer from CRL.", e12);
        }
    }

    public static gm.c0 h(X509Extension x509Extension, gm.y yVar) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(yVar.L());
        if (extensionValue == null) {
            return null;
        }
        return l(yVar, extensionValue);
    }

    public static xn.d i(X509CRL x509crl) {
        return n(x509crl.getIssuerX500Principal());
    }

    public static xn.d j(X509Certificate x509Certificate) {
        return n(x509Certificate.getIssuerX500Principal());
    }

    public static PublicKey k(List list, int i10, org.bouncycastle.jcajce.util.d dVar) throws CertPathValidatorException {
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

    public static gm.c0 l(gm.y yVar, byte[] bArr) throws AnnotatedException {
        try {
            return gm.c0.D(z.I(bArr).J());
        } catch (Exception e10) {
            throw new AnnotatedException("exception processing extension " + yVar, e10);
        }
    }

    public static Date m(jq.k kVar, Date date) {
        Date dateW = kVar.w();
        return dateW == null ? date : dateW;
    }

    public static xn.d n(X500Principal x500Principal) {
        return xn.d.A(x500Principal.getEncoded());
    }

    public static boolean o(X509CRL x509crl) {
        Set<String> criticalExtensionOIDs = x509crl.getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        return criticalExtensionOIDs.contains(d.f45662c);
    }

    public static boolean p(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(y.f59071p.L());
            if (extensionValue != null) {
                if (i0.B(z.I(extensionValue).J()).D()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            throw new CRLException("exception reading IssuingDistributionPoint", e10);
        }
    }
}
