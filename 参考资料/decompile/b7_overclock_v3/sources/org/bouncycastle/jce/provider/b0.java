package org.bouncycastle.jce.provider;

import gm.j2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
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
import jq.i;
import jq.j;
import jq.k;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;

/* JADX INFO: loaded from: classes5.dex */
public class b0 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f45401p = "2.5.29.32.0";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f45402q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f45403r = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f45386a = ar.f.a(b0.class, "java.security.cert.PKIXRevocationChecker");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f45387b = zn.y.f59075t.L();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f45388c = zn.y.f59076u.L();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f45389d = zn.y.f59082z.L();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f45390e = zn.y.f59071p.L();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f45391f = zn.y.f59081y.L();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f45392g = zn.y.f59070o.L();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f45393h = zn.y.f59079w.L();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f45394i = zn.y.f59063j.L();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f45395j = zn.y.f59074s.L();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f45396k = zn.y.f59061h.L();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f45397l = zn.y.f59073r.L();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f45398m = zn.y.f59077v.L();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f45399n = zn.y.f59059f.L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f45400o = zn.y.f59064k.L();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f45404s = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    public static void A(CertPath certPath, int i10, v vVar, boolean z10) throws CertPathValidatorException {
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i10);
        int size = certificates.size();
        int i11 = size - i10;
        if (!e.x(x509Certificate) || (i11 >= size && !z10)) {
            try {
                gm.f0 f0VarJ = gm.f0.J(x.f(x509Certificate));
                try {
                    vVar.e(f0VarJ);
                    vVar.c(f0VarJ);
                    try {
                        zn.c0 c0VarA = zn.c0.A(e.n(x509Certificate, f45396k));
                        xn.c[] cVarArrD = xn.d.A(f0VarJ).D(yn.c.I);
                        for (int i12 = 0; i12 != cVarArrD.length; i12++) {
                            zn.b0 b0Var = new zn.b0(1, ((gm.k0) cVarArrD[i12].z().z()).d());
                            try {
                                vVar.d(b0Var);
                                vVar.b(b0Var);
                            } catch (PKIXNameConstraintValidatorException e10) {
                                throw new CertPathValidatorException("Subtree check for certificate subject alternative email failed.", e10, certPath, i10);
                            }
                        }
                        if (c0VarA != null) {
                            try {
                                zn.b0[] b0VarArrB = c0VarA.B();
                                for (int i13 = 0; i13 < b0VarArrB.length; i13++) {
                                    try {
                                        vVar.d(b0VarArrB[i13]);
                                        vVar.b(b0VarArrB[i13]);
                                    } catch (PKIXNameConstraintValidatorException e11) {
                                        throw new CertPathValidatorException("Subtree check for certificate subject alternative name failed.", e11, certPath, i10);
                                    }
                                }
                            } catch (Exception e12) {
                                throw new CertPathValidatorException("Subject alternative name contents could not be decoded.", e12, certPath, i10);
                            }
                        }
                    } catch (Exception e13) {
                        throw new CertPathValidatorException("Subject alternative name extension could not be decoded.", e13, certPath, i10);
                    }
                } catch (PKIXNameConstraintValidatorException e14) {
                    throw new CertPathValidatorException("Subtree check for certificate subject failed.", e14, certPath, i10);
                }
            } catch (Exception e15) {
                throw new CertPathValidatorException("Exception extracting subject name when checking subtrees.", e15, certPath, i10);
            }
        }
    }

    public static w B(CertPath certPath, int i10, Set set, w wVar, List[] listArr, int i11, boolean z10) throws CertPathValidatorException {
        String strL;
        int i12;
        List<? extends Certificate> certificates = certPath.getCertificates();
        X509Certificate x509Certificate = (X509Certificate) certificates.get(i10);
        int size = certificates.size();
        int i13 = size - i10;
        try {
            gm.f0 f0VarJ = gm.f0.J(e.n(x509Certificate, f45387b));
            if (f0VarJ == null || wVar == null) {
                return null;
            }
            Enumeration enumerationL = f0VarJ.L();
            HashSet hashSet = new HashSet();
            while (enumerationL.hasMoreElements()) {
                zn.s0 s0VarX = zn.s0.x(enumerationL.nextElement());
                gm.y yVarY = s0VarX.y();
                hashSet.add(yVarY.L());
                if (!"2.5.29.32.0".equals(yVarY.L())) {
                    try {
                        Set setQ = e.q(s0VarX.z());
                        if (!e.A(i13, listArr, yVarY, setQ)) {
                            e.B(i13, listArr, yVarY, setQ);
                        }
                    } catch (CertPathValidatorException e10) {
                        throw new ExtCertPathValidatorException("Policy qualifier info set could not be build.", e10, certPath, i10);
                    }
                }
            }
            if (set.isEmpty() || set.contains("2.5.29.32.0")) {
                set.clear();
                set.addAll(hashSet);
            } else {
                HashSet hashSet2 = new HashSet();
                for (Object obj : set) {
                    if (hashSet.contains(obj)) {
                        hashSet2.add(obj);
                    }
                }
                set.clear();
                set.addAll(hashSet2);
            }
            if (i11 > 0 || ((i13 < size || z10) && e.x(x509Certificate))) {
                Enumeration enumerationL2 = f0VarJ.L();
                while (true) {
                    if (!enumerationL2.hasMoreElements()) {
                        break;
                    }
                    zn.s0 s0VarX2 = zn.s0.x(enumerationL2.nextElement());
                    if ("2.5.29.32.0".equals(s0VarX2.y().L())) {
                        Set setQ2 = e.q(s0VarX2.z());
                        List list = listArr[i13 - 1];
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            w wVar2 = (w) list.get(i14);
                            for (Object obj2 : wVar2.getExpectedPolicies()) {
                                if (obj2 instanceof String) {
                                    strL = (String) obj2;
                                } else if (obj2 instanceof gm.y) {
                                    strL = ((gm.y) obj2).L();
                                }
                                String str = strL;
                                Iterator children = wVar2.getChildren();
                                boolean z11 = false;
                                while (children.hasNext()) {
                                    if (str.equals(((w) children.next()).getValidPolicy())) {
                                        z11 = true;
                                    }
                                }
                                if (!z11) {
                                    HashSet hashSet3 = new HashSet();
                                    hashSet3.add(str);
                                    w wVar3 = new w(new ArrayList(), i13, hashSet3, wVar2, setQ2, str, false);
                                    wVar2.a(wVar3);
                                    listArr[i13].add(wVar3);
                                }
                            }
                        }
                    }
                }
            }
            w wVarC = wVar;
            for (int i15 = i13 - 1; i15 >= 0; i15--) {
                List list2 = listArr[i15];
                while (i12 < list2.size()) {
                    w wVar4 = (w) list2.get(i12);
                    i12 = (wVar4.c() || (wVarC = e.C(wVarC, listArr, wVar4)) != null) ? i12 + 1 : 0;
                }
            }
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                boolean zContains = criticalExtensionOIDs.contains(f45387b);
                List list3 = listArr[i13];
                for (int i16 = 0; i16 < list3.size(); i16++) {
                    ((w) list3.get(i16)).e(zContains);
                }
            }
            return wVarC;
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e11, certPath, i10);
        }
    }

    public static w C(CertPath certPath, int i10, w wVar) throws CertPathValidatorException {
        try {
            if (gm.f0.J(e.n((X509Certificate) certPath.getCertificates().get(i10), f45387b)) == null) {
                return null;
            }
            return wVar;
        } catch (AnnotatedException e10) {
            throw new ExtCertPathValidatorException("Could not read certificate policies extension from certificate.", e10, certPath, i10);
        }
    }

    public static void D(CertPath certPath, int i10, w wVar, int i11) throws CertPathValidatorException {
        if (i11 <= 0 && wVar == null) {
            throw new ExtCertPathValidatorException("No valid policy tree found when one expected.", null, certPath, i10);
        }
    }

    public static int E(int i10, X509Certificate x509Certificate) {
        return (e.x(x509Certificate) || i10 == 0) ? i10 : i10 - 1;
    }

    public static int F(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        try {
            gm.f0 f0VarJ = gm.f0.J(e.n((X509Certificate) certPath.getCertificates().get(i10), f45393h));
            if (f0VarJ != null) {
                Enumeration enumerationL = f0VarJ.L();
                while (enumerationL.hasMoreElements()) {
                    gm.n0 n0Var = (gm.n0) enumerationL.nextElement();
                    if (n0Var.q() == 0) {
                        try {
                            if (gm.t.H(n0Var, false).Q() == 0) {
                                return 0;
                            }
                        } catch (Exception e10) {
                            throw new ExtCertPathValidatorException("Policy constraints requireExplicitPolicy field could not be decoded.", e10, certPath, i10);
                        }
                    }
                }
            }
            return i11;
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Policy constraints could not be decoded.", e11, certPath, i10);
        }
    }

    public static void G(CertPath certPath, int i10, List list, Set set) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i10);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                ((PKIXCertPathChecker) it2.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e10) {
                throw new ExtCertPathValidatorException(e10.getMessage(), e10, certPath, i10);
            } catch (Exception e11) {
                throw new CertPathValidatorException("Additional certificate path checker failed.", e11, certPath, i10);
            }
        }
        if (set.isEmpty()) {
            return;
        }
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, null, certPath, i10);
    }

    public static w H(CertPath certPath, jq.k kVar, Set set, int i10, List[] listArr, w wVar, Set set2) throws CertPathValidatorException {
        int size = certPath.getCertificates().size();
        if (wVar == null) {
            if (kVar.A()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i10);
            }
            return null;
        }
        if (!e.u(set)) {
            HashSet<w> hashSet = new HashSet();
            for (List list : listArr) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    w wVar2 = (w) list.get(i11);
                    if ("2.5.29.32.0".equals(wVar2.getValidPolicy())) {
                        Iterator children = wVar2.getChildren();
                        while (children.hasNext()) {
                            w wVar3 = (w) children.next();
                            if (!"2.5.29.32.0".equals(wVar3.getValidPolicy())) {
                                hashSet.add(wVar3);
                            }
                        }
                    }
                }
            }
            for (w wVar4 : hashSet) {
                if (!set.contains(wVar4.getValidPolicy())) {
                    wVar = e.C(wVar, listArr, wVar4);
                }
            }
            if (wVar != null) {
                for (int i12 = size - 1; i12 >= 0; i12--) {
                    List list2 = listArr[i12];
                    for (int i13 = 0; i13 < list2.size(); i13++) {
                        w wVar5 = (w) list2.get(i13);
                        if (!wVar5.c()) {
                            wVar = e.C(wVar, listArr, wVar5);
                        }
                    }
                }
            }
        } else if (kVar.A()) {
            if (set2.isEmpty()) {
                throw new ExtCertPathValidatorException("Explicit policy requested but none available.", null, certPath, i10);
            }
            HashSet hashSet2 = new HashSet();
            for (List list3 : listArr) {
                for (int i14 = 0; i14 < list3.size(); i14++) {
                    w wVar6 = (w) list3.get(i14);
                    if ("2.5.29.32.0".equals(wVar6.getValidPolicy())) {
                        Iterator children2 = wVar6.getChildren();
                        while (children2.hasNext()) {
                            hashSet2.add(children2.next());
                        }
                    }
                }
            }
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                set2.contains(((w) it2.next()).getValidPolicy());
            }
            for (int i15 = size - 1; i15 >= 0; i15--) {
                List list4 = listArr[i15];
                for (int i16 = 0; i16 < list4.size(); i16++) {
                    w wVar7 = (w) list4.get(i16);
                    if (!wVar7.c()) {
                        wVar = e.C(wVar, listArr, wVar7);
                    }
                }
            }
        }
        return wVar;
    }

    public static void a(jq.g gVar, zn.v vVar, jq.k kVar, Date date, Date date2, X509Certificate x509Certificate, X509Certificate x509Certificate2, PublicKey publicKey, f fVar, d0 d0Var, List list, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException, RecoverableCertPathValidatorException {
        Iterator it2;
        X509CRL x509crlW;
        Set<String> criticalExtensionOIDs;
        if (date2.getTime() > date.getTime()) {
            throw new AnnotatedException("Validation time is in future.");
        }
        Iterator it3 = e.l(gVar, vVar, x509Certificate, kVar, date2).iterator();
        AnnotatedException e10 = null;
        boolean z10 = false;
        while (it3.hasNext() && fVar.a() == 11 && !d0Var.e()) {
            try {
                X509CRL x509crl = (X509CRL) it3.next();
                d0 d0VarT = t(x509crl, vVar);
                if (d0VarT.c(d0Var)) {
                    it2 = it3;
                    try {
                        PublicKey publicKeyV = v(x509crl, u(x509crl, x509Certificate, x509Certificate2, publicKey, kVar, list, dVar));
                        if (kVar.D()) {
                            try {
                                x509crlW = w(e.m(date2, x509crl, kVar.m(), kVar.k(), dVar), publicKeyV);
                            } catch (AnnotatedException e11) {
                                e10 = e11;
                                it3 = it2;
                            }
                        } else {
                            x509crlW = null;
                        }
                        if (kVar.x() != 1) {
                            try {
                                if (x509Certificate.getNotAfter().getTime() < x509crl.getThisUpdate().getTime()) {
                                    throw new AnnotatedException("No valid CRL for current time found.");
                                }
                            } catch (AnnotatedException e12) {
                                e10 = e12;
                                it3 = it2;
                            }
                        }
                        q(vVar, x509Certificate, x509crl);
                        r(vVar, x509Certificate, x509crl);
                        s(x509crlW, x509crl, kVar);
                        x(date2, x509crlW, x509Certificate, fVar, kVar);
                        y(date2, x509crl, x509Certificate, fVar);
                        if (fVar.a() == 8) {
                            fVar.c(11);
                        }
                        d0Var.a(d0VarT);
                        Set<String> criticalExtensionOIDs2 = x509crl.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(zn.y.f59071p.L());
                            hashSet.remove(zn.y.f59070o.L());
                            if (!hashSet.isEmpty()) {
                                throw new AnnotatedException("CRL contains unsupported critical extensions.");
                            }
                        }
                        if (x509crlW != null && (criticalExtensionOIDs = x509crlW.getCriticalExtensionOIDs()) != null) {
                            HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                            hashSet2.remove(zn.y.f59071p.L());
                            hashSet2.remove(zn.y.f59070o.L());
                            if (!hashSet2.isEmpty()) {
                                throw new AnnotatedException("Delta CRL contains unsupported critical extension.");
                            }
                        }
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

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0109 A[PHI: r0
  0x0109: PHI (r0v13 'e' org.bouncycastle.jce.provider.AnnotatedException) = 
  (r0v12 'e' org.bouncycastle.jce.provider.AnnotatedException)
  (r0v27 'e' org.bouncycastle.jce.provider.AnnotatedException)
  (r0v12 'e' org.bouncycastle.jce.provider.AnnotatedException)
 binds: [B:35:0x00bb, B:41:0x00fe, B:37:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(jq.g r23, jq.k r24, java.util.Date r25, java.util.Date r26, java.security.cert.X509Certificate r27, java.security.cert.X509Certificate r28, java.security.PublicKey r29, java.util.List r30, org.bouncycastle.jcajce.util.d r31) throws org.bouncycastle.jce.provider.AnnotatedException, org.bouncycastle.jce.provider.RecoverableCertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.b0.b(jq.g, jq.k, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List, org.bouncycastle.jcajce.util.d):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        r7 = ((gm.f0) org.bouncycastle.jce.provider.e.n(r4, org.bouncycastle.jce.provider.b0.f45387b)).L();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00dc, code lost:
    
        if (r7.hasMoreElements() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
    
        r9 = zn.s0.x(r7.nextElement());
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f2, code lost:
    
        if ("2.5.29.32.0".equals(r9.y().L()) == false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f4, code lost:
    
        r5 = org.bouncycastle.jce.provider.e.q(r9.z());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0105, code lost:
    
        throw new org.bouncycastle.jce.exception.ExtCertPathValidatorException("Policy qualifier info set could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0106, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010e, code lost:
    
        throw new java.security.cert.CertPathValidatorException("Policy information could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010f, code lost:
    
        r10 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0114, code lost:
    
        if (r4.getCriticalExtensionOIDs() == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0116, code lost:
    
        r12 = r4.getCriticalExtensionOIDs().contains(org.bouncycastle.jce.provider.b0.f45387b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0122, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0123, code lost:
    
        r9 = (org.bouncycastle.jce.provider.w) r6.getParent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        if ("2.5.29.32.0".equals(r9.getValidPolicy()) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0134, code lost:
    
        r8 = new org.bouncycastle.jce.provider.w(new java.util.ArrayList(), r3, (java.util.Set) r13.get(r11), r9, r10, r11, r12);
        r9.a(r8);
        r21[r3].add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0158, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0160, code lost:
    
        throw new org.bouncycastle.jce.exception.ExtCertPathValidatorException("Certificate policies extension could not be decoded.", r0, r19, r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b5, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.bouncycastle.jce.provider.w c(java.security.cert.CertPath r19, int r20, java.util.List[] r21, org.bouncycastle.jce.provider.w r22, int r23) throws java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.b0.c(java.security.cert.CertPath, int, java.util.List[], org.bouncycastle.jce.provider.w, int):org.bouncycastle.jce.provider.w");
    }

    public static void d(CertPath certPath, int i10) throws CertPathValidatorException {
        try {
            gm.f0 f0VarJ = gm.f0.J(e.n((X509Certificate) certPath.getCertificates().get(i10), f45388c));
            if (f0VarJ != null) {
                for (int i11 = 0; i11 < f0VarJ.size(); i11++) {
                    try {
                        gm.f0 f0VarJ2 = gm.f0.J(f0VarJ.K(i11));
                        gm.y yVarN = gm.y.N(f0VarJ2.K(0));
                        gm.y yVarN2 = gm.y.N(f0VarJ2.K(1));
                        if ("2.5.29.32.0".equals(yVarN.L())) {
                            throw new CertPathValidatorException("IssuerDomainPolicy is anyPolicy", null, certPath, i10);
                        }
                        if ("2.5.29.32.0".equals(yVarN2.L())) {
                            throw new CertPathValidatorException("SubjectDomainPolicy is anyPolicy", null, certPath, i10);
                        }
                    } catch (Exception e10) {
                        throw new ExtCertPathValidatorException("Policy mappings extension contents could not be decoded.", e10, certPath, i10);
                    }
                }
            }
        } catch (AnnotatedException e11) {
            throw new ExtCertPathValidatorException("Policy mappings extension could not be decoded.", e11, certPath, i10);
        }
    }

    public static void e(CertPath certPath, int i10, v vVar) throws CertPathValidatorException {
        try {
            gm.f0 f0VarJ = gm.f0.J(e.n((X509Certificate) certPath.getCertificates().get(i10), f45397l));
            zn.m0 m0VarA = f0VarJ != null ? zn.m0.A(f0VarJ) : null;
            if (m0VarA != null) {
                zn.e0[] e0VarArrB = m0VarA.B();
                if (e0VarArrB != null) {
                    try {
                        vVar.h(e0VarArrB);
                    } catch (Exception e10) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e10, certPath, i10);
                    }
                }
                zn.e0[] e0VarArrZ = m0VarA.z();
                if (e0VarArrZ != null) {
                    for (int i11 = 0; i11 != e0VarArrZ.length; i11++) {
                        try {
                            vVar.a(e0VarArrZ[i11]);
                        } catch (Exception e11) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e11, certPath, i10);
                        }
                    }
                }
            }
        } catch (Exception e12) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e12, certPath, i10);
        }
    }

    public static int f(CertPath certPath, int i10, int i11) {
        return (e.x((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    public static int g(CertPath certPath, int i10, int i11) {
        return (e.x((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    public static int h(CertPath certPath, int i10, int i11) {
        return (e.x((X509Certificate) certPath.getCertificates().get(i10)) || i11 == 0) ? i11 : i11 - 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        r3 = gm.t.H(r1, false).Q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r3 >= r5) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int i(java.security.cert.CertPath r3, int r4, int r5) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r3.getCertificates()
            java.lang.Object r0 = r0.get(r4)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = org.bouncycastle.jce.provider.b0.f45393h     // Catch: java.lang.Exception -> L44
            gm.c0 r0 = org.bouncycastle.jce.provider.e.n(r0, r1)     // Catch: java.lang.Exception -> L44
            gm.f0 r0 = gm.f0.J(r0)     // Catch: java.lang.Exception -> L44
            if (r0 == 0) goto L43
            java.util.Enumeration r0 = r0.L()
        L1a:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto L43
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.IllegalArgumentException -> L3a
            gm.n0 r1 = gm.n0.T(r1)     // Catch: java.lang.IllegalArgumentException -> L3a
            int r2 = r1.q()     // Catch: java.lang.IllegalArgumentException -> L3a
            if (r2 != 0) goto L1a
            r0 = 0
            gm.t r0 = gm.t.H(r1, r0)     // Catch: java.lang.IllegalArgumentException -> L3a
            int r3 = r0.Q()     // Catch: java.lang.IllegalArgumentException -> L3a
            if (r3 >= r5) goto L43
            return r3
        L3a:
            r5 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension contents cannot be decoded."
            r0.<init>(r1, r5, r3, r4)
            throw r0
        L43:
            return r5
        L44:
            r5 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension cannot be decoded."
            r0.<init>(r1, r5, r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.b0.i(java.security.cert.CertPath, int, int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
    
        r4 = gm.t.H(r1, false).Q();
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        if (r4 >= r6) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int j(java.security.cert.CertPath r4, int r5, int r6) throws java.security.cert.CertPathValidatorException {
        /*
            java.util.List r0 = r4.getCertificates()
            java.lang.Object r0 = r0.get(r5)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r1 = org.bouncycastle.jce.provider.b0.f45393h     // Catch: java.lang.Exception -> L45
            gm.c0 r0 = org.bouncycastle.jce.provider.e.n(r0, r1)     // Catch: java.lang.Exception -> L45
            gm.f0 r0 = gm.f0.J(r0)     // Catch: java.lang.Exception -> L45
            if (r0 == 0) goto L44
            java.util.Enumeration r0 = r0.L()
        L1a:
            boolean r1 = r0.hasMoreElements()
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.IllegalArgumentException -> L3b
            gm.n0 r1 = gm.n0.T(r1)     // Catch: java.lang.IllegalArgumentException -> L3b
            int r2 = r1.q()     // Catch: java.lang.IllegalArgumentException -> L3b
            r3 = 1
            if (r2 != r3) goto L1a
            r0 = 0
            gm.t r0 = gm.t.H(r1, r0)     // Catch: java.lang.IllegalArgumentException -> L3b
            int r4 = r0.Q()     // Catch: java.lang.IllegalArgumentException -> L3b
            if (r4 >= r6) goto L44
            return r4
        L3b:
            r6 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension contents cannot be decoded."
            r0.<init>(r1, r6, r4, r5)
            throw r0
        L44:
            return r6
        L45:
            r6 = move-exception
            org.bouncycastle.jce.exception.ExtCertPathValidatorException r0 = new org.bouncycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r1 = "Policy constraints extension cannot be decoded."
            r0.<init>(r1, r6, r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.b0.j(java.security.cert.CertPath, int, int):int");
    }

    public static int k(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        int iQ;
        try {
            gm.t tVarI = gm.t.I(e.n((X509Certificate) certPath.getCertificates().get(i10), f45389d));
            return (tVarI == null || (iQ = tVarI.Q()) >= i11) ? i11 : iQ;
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Inhibit any-policy extension cannot be decoded.", e10, certPath, i10);
        }
    }

    public static void l(CertPath certPath, int i10) throws CertPathValidatorException {
        try {
            zn.j jVarZ = zn.j.z(e.n((X509Certificate) certPath.getCertificates().get(i10), f45394i));
            if (jVarZ == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints", null, certPath, i10);
            }
            if (!jVarZ.B()) {
                throw new CertPathValidatorException("Not a CA certificate", null, certPath, i10);
            }
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e10, certPath, i10);
        }
    }

    public static int m(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        if (e.x((X509Certificate) certPath.getCertificates().get(i10))) {
            return i11;
        }
        if (i11 > 0) {
            return i11 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", null, certPath, i10);
    }

    public static int n(CertPath certPath, int i10, int i11) throws CertPathValidatorException {
        BigInteger bigIntegerA;
        int iIntValue;
        try {
            zn.j jVarZ = zn.j.z(e.n((X509Certificate) certPath.getCertificates().get(i10), f45394i));
            return (jVarZ == null || (bigIntegerA = jVarZ.A()) == null || (iIntValue = bigIntegerA.intValue()) >= i11) ? i11 : iIntValue;
        } catch (Exception e10) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e10, certPath, i10);
        }
    }

    public static void o(CertPath certPath, int i10) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i10)).getKeyUsage();
        if (keyUsage != null) {
            if (keyUsage.length <= 5 || !keyUsage[5]) {
                throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", null, certPath, i10);
            }
        }
    }

    public static void p(CertPath certPath, int i10, Set set, List list) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i10);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            try {
                ((PKIXCertPathChecker) it2.next()).check(x509Certificate, set);
            } catch (CertPathValidatorException e10) {
                throw new CertPathValidatorException(e10.getMessage(), e10.getCause(), certPath, i10);
            }
        }
        if (set.isEmpty()) {
            return;
        }
        throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + set, null, certPath, i10);
    }

    public static void q(zn.v vVar, Object obj, X509CRL x509crl) throws AnnotatedException {
        gm.c0 c0VarN = e.n(x509crl, f45390e);
        int i10 = 0;
        boolean z10 = c0VarN != null && zn.i0.B(c0VarN).D();
        try {
            byte[] encoded = x.d(x509crl).getEncoded();
            if (vVar.y() != null) {
                zn.b0[] b0VarArrB = vVar.y().B();
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
            } else if (x.d(x509crl).equals(x.c(obj))) {
                i10 = 1;
            }
            if (i10 == 0) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.");
            }
        } catch (IOException e11) {
            throw new AnnotatedException("Exception encoding CRL issuer: " + e11.getMessage(), e11);
        }
    }

    public static void r(zn.v vVar, Object obj, X509CRL x509crl) throws AnnotatedException {
        zn.b0[] b0VarArrB;
        try {
            zn.i0 i0VarB = zn.i0.B(e.n(x509crl, f45390e));
            if (i0VarB != null) {
                if (i0VarB.z() != null) {
                    zn.w wVarZ = zn.i0.B(i0VarB).z();
                    ArrayList arrayList = new ArrayList();
                    boolean z10 = false;
                    if (wVarZ.B() == 0) {
                        for (zn.b0 b0Var : zn.c0.A(wVarZ.A()).B()) {
                            arrayList.add(b0Var);
                        }
                    }
                    if (wVarZ.B() == 1) {
                        gm.i iVar = new gm.i();
                        try {
                            Enumeration enumerationL = gm.f0.J(x.d(x509crl)).L();
                            while (enumerationL.hasMoreElements()) {
                                iVar.a((gm.h) enumerationL.nextElement());
                            }
                            iVar.a(wVarZ.A());
                            arrayList.add(new zn.b0(xn.d.A(new j2(iVar))));
                        } catch (Exception e10) {
                            throw new AnnotatedException("Could not read CRL issuer.", e10);
                        }
                    }
                    if (vVar.z() != null) {
                        zn.w wVarZ2 = vVar.z();
                        zn.b0[] b0VarArrB2 = wVarZ2.B() == 0 ? zn.c0.A(wVarZ2.A()).B() : null;
                        if (wVarZ2.B() == 1) {
                            if (vVar.y() != null) {
                                b0VarArrB = vVar.y().B();
                            } else {
                                b0VarArrB = new zn.b0[1];
                                try {
                                    b0VarArrB[0] = new zn.b0(x.c(obj));
                                } catch (Exception e11) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e11);
                                }
                            }
                            b0VarArrB2 = b0VarArrB;
                            for (int i10 = 0; i10 < b0VarArrB2.length; i10++) {
                                Enumeration enumerationL2 = gm.f0.J(b0VarArrB2[i10].A().b()).L();
                                gm.i iVar2 = new gm.i();
                                while (enumerationL2.hasMoreElements()) {
                                    iVar2.a((gm.h) enumerationL2.nextElement());
                                }
                                iVar2.a(wVarZ2.A());
                                b0VarArrB2[i10] = new zn.b0(xn.d.A(new j2(iVar2)));
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
                        zn.b0[] b0VarArrB3 = vVar.y().B();
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
                    zn.j jVarZ = zn.j.z(e.n((X509Extension) obj, f45394i));
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

    public static void s(X509CRL x509crl, X509CRL x509crl2, jq.k kVar) throws AnnotatedException {
        if (x509crl == null) {
            return;
        }
        if (x509crl.hasUnsupportedCriticalExtension()) {
            throw new AnnotatedException("delta CRL has unsupported critical extensions");
        }
        try {
            String str = f45390e;
            zn.i0 i0VarB = zn.i0.B(e.n(x509crl2, str));
            if (kVar.D()) {
                if (!x.d(x509crl).equals(x.d(x509crl2))) {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.");
                }
                try {
                    zn.i0 i0VarB2 = zn.i0.B(e.n(x509crl, str));
                    boolean z10 = false;
                    if (i0VarB != null ? i0VarB.equals(i0VarB2) : i0VarB2 == null) {
                        z10 = true;
                    }
                    if (!z10) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.");
                    }
                    try {
                        String str2 = f45398m;
                        gm.c0 c0VarN = e.n(x509crl2, str2);
                        try {
                            gm.c0 c0VarN2 = e.n(x509crl, str2);
                            if (c0VarN == null) {
                                throw new AnnotatedException("CRL authority key identifier is null.");
                            }
                            if (c0VarN2 == null) {
                                throw new AnnotatedException("Delta CRL authority key identifier is null.");
                            }
                            if (!c0VarN.C(c0VarN2)) {
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
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e13);
        }
    }

    public static d0 t(X509CRL x509crl, zn.v vVar) throws AnnotatedException {
        try {
            zn.i0 i0VarB = zn.i0.B(e.n(x509crl, f45390e));
            if (i0VarB != null && i0VarB.C() != null && vVar.C() != null) {
                return new d0(vVar.C()).d(new d0(i0VarB.C()));
            }
            if ((i0VarB == null || i0VarB.C() == null) && vVar.C() == null) {
                return d0.f45419b;
            }
            return (vVar.C() == null ? d0.f45419b : new d0(vVar.C())).d(i0VarB == null ? d0.f45419b : new d0(i0VarB.C()));
        } catch (Exception e10) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e10);
        }
    }

    public static Set u(X509CRL x509crl, Object obj, X509Certificate x509Certificate, PublicKey publicKey, jq.k kVar, List list, org.bouncycastle.jcajce.util.d dVar) throws AnnotatedException {
        int i10;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(x.d(x509crl).getEncoded());
            jq.i<? extends Certificate> iVarA = new i.b(x509CertSelector).a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                e.b(linkedHashSet, iVarA, kVar.n());
                e.b(linkedHashSet, iVarA, kVar.m());
                linkedHashSet.add(x509Certificate);
                Iterator it2 = linkedHashSet.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
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
                            CertPathBuilderSpi sVar = f45386a != null ? new s(true) : new r(true);
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            k.b bVarS = new k.b(kVar).s(new i.b(x509CertSelector2).a());
                            if (list.contains(x509Certificate2)) {
                                bVarS.r(false);
                            } else {
                                bVarS.r(true);
                            }
                            List<? extends Certificate> certificates = sVar.engineBuild(new j.b(bVarS.q()).e()).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(e.o(certificates, 0, dVar));
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
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e14);
        }
    }

    public static PublicKey v(X509CRL x509crl, Set set) throws AnnotatedException {
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

    public static X509CRL w(Set set, PublicKey publicKey) throws AnnotatedException {
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

    public static void x(Date date, X509CRL x509crl, Object obj, f fVar, jq.k kVar) throws AnnotatedException {
        if (!kVar.D() || x509crl == null) {
            return;
        }
        e.k(date, x509crl, obj, fVar);
    }

    public static void y(Date date, X509CRL x509crl, Object obj, f fVar) throws AnnotatedException {
        if (fVar.a() == 11) {
            e.k(date, x509crl, obj, fVar);
        }
    }

    public static void z(CertPath certPath, jq.k kVar, Date date, jq.f fVar, int i10, PublicKey publicKey, boolean z10, xn.d dVar, X509Certificate x509Certificate) throws CertPathValidatorException {
        X509Certificate x509Certificate2 = (X509Certificate) certPath.getCertificates().get(i10);
        if (!z10) {
            try {
                e.E(x509Certificate2, publicKey, kVar.t());
            } catch (GeneralSecurityException e10) {
                throw new ExtCertPathValidatorException("Could not validate certificate signature.", e10, certPath, i10);
            }
        }
        try {
            Date dateS = e.s(date, kVar.x(), certPath, i10);
            try {
                x509Certificate2.checkValidity(dateS);
                if (fVar != null) {
                    fVar.b(new jq.g(kVar, dateS, certPath, i10, x509Certificate, publicKey));
                    fVar.check(x509Certificate2);
                }
                xn.d dVarE = x.e(x509Certificate2);
                if (dVarE.equals(dVar)) {
                    return;
                }
                throw new ExtCertPathValidatorException("IssuerName(" + dVarE + ") does not match SubjectName(" + dVar + ") of signing certificate.", null, certPath, i10);
            } catch (CertificateExpiredException e11) {
                throw new ExtCertPathValidatorException("Could not validate certificate: " + e11.getMessage(), e11, certPath, i10);
            } catch (CertificateNotYetValidException e12) {
                throw new ExtCertPathValidatorException("Could not validate certificate: " + e12.getMessage(), e12, certPath, i10);
            }
        } catch (AnnotatedException e13) {
            throw new ExtCertPathValidatorException("Could not validate time of certificate.", e13, certPath, i10);
        }
    }
}
