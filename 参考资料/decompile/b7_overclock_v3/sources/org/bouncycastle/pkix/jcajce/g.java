package org.bouncycastle.pkix.jcajce;

import gm.y;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.CRL;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.x500.X500Principal;
import jq.k;
import org.bouncycastle.jcajce.util.i;
import org.bouncycastle.util.k;
import org.bouncycastle.util.q;
import org.bouncycastle.util.s;
import zn.b0;
import zn.c0;
import zn.v;
import zn.w;

/* JADX INFO: loaded from: classes6.dex */
public class g extends PKIXCertPathChecker {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f45670o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f45671p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static Logger f45672q = Logger.getLogger(g.class.getName());

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Map<b0, WeakReference<X509CRL>> f45673r = Collections.synchronizedMap(new WeakHashMap());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String[] f45674s = {"unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<X500Principal, Long> f45675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<TrustAnchor> f45676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f45677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f45678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<s<CRL>> f45679e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<CertStore> f45680f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45681g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f45682h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f45683i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f45684j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Date f45685k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public X500Principal f45686l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PublicKey f45687m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public X509Certificate f45688n;

    public class a extends X509CRLSelector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45689a;

        public a(List list) {
            this.f45689a = list;
        }

        @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
        public boolean match(CRL crl) {
            if (!(crl instanceof X509CRL)) {
                return false;
            }
            this.f45689a.add(((X509CRL) crl).getIssuerX500Principal());
            return false;
        }
    }

    public class b implements q<CRL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f45691a;

        public b(List list) {
            this.f45691a = list;
        }

        @Override // org.bouncycastle.util.q
        public Object clone() {
            return this;
        }

        @Override // org.bouncycastle.util.q
        /* JADX INFO: renamed from: match, reason: merged with bridge method [inline-methods] */
        public boolean M(CRL crl) {
            if (!(crl instanceof X509CRL)) {
                return false;
            }
            this.f45691a.add(((X509CRL) crl).getIssuerX500Principal());
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<TrustAnchor> f45693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<CertStore> f45694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<s<CRL>> f45695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f45696d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f45697e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Provider f45698f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f45699g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f45700h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f45701i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f45702j;

        public c(KeyStore keyStore) throws KeyStoreException {
            this.f45694b = new ArrayList();
            this.f45695c = new ArrayList();
            this.f45697e = 0;
            this.f45693a = new HashSet();
            Enumeration<String> enumerationAliases = keyStore.aliases();
            while (enumerationAliases.hasMoreElements()) {
                String strNextElement = enumerationAliases.nextElement();
                if (keyStore.isCertificateEntry(strNextElement)) {
                    this.f45693a.add(new TrustAnchor((X509Certificate) keyStore.getCertificate(strNextElement), null));
                }
            }
        }

        public c(TrustAnchor trustAnchor) {
            this.f45694b = new ArrayList();
            this.f45695c = new ArrayList();
            this.f45697e = 0;
            this.f45693a = Collections.singleton(trustAnchor);
        }

        public c(Set<TrustAnchor> set) {
            this.f45694b = new ArrayList();
            this.f45695c = new ArrayList();
            this.f45697e = 0;
            this.f45693a = new HashSet(set);
        }

        public c k(CertStore certStore) {
            this.f45694b.add(certStore);
            return this;
        }

        public c l(s<CRL> sVar) {
            this.f45695c.add(sVar);
            return this;
        }

        public g m() {
            return new g(this, null);
        }

        public c n(boolean z10) {
            this.f45696d = z10;
            return this;
        }

        public c o(boolean z10, long j10) {
            this.f45700h = z10;
            this.f45701i = j10;
            this.f45702j = -1L;
            return this;
        }

        public c p(boolean z10, long j10) {
            this.f45700h = z10;
            this.f45701i = (3 * j10) / 4;
            this.f45702j = j10;
            return this;
        }

        public c q(int i10) {
            this.f45697e = i10;
            return this;
        }

        public c r(String str) {
            this.f45699g = str;
            return this;
        }

        public c s(Provider provider) {
            this.f45698f = provider;
            return this;
        }
    }

    public class d implements jq.d<CRL>, k<CRL> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Collection<CRL> f45703a;

        public d(s<CRL> sVar) {
            this.f45703a = new ArrayList(sVar.a(null));
        }

        @Override // jq.d, org.bouncycastle.util.s
        public Collection<CRL> a(q<CRL> qVar) {
            if (qVar == null) {
                return new ArrayList(this.f45703a);
            }
            ArrayList arrayList = new ArrayList();
            for (CRL crl : this.f45703a) {
                if (qVar.M(crl)) {
                    arrayList.add(crl);
                }
            }
            return arrayList;
        }

        @Override // org.bouncycastle.util.k, java.lang.Iterable
        public Iterator<CRL> iterator() {
            return a(null).iterator();
        }
    }

    public g(c cVar) {
        org.bouncycastle.jcajce.util.d gVar;
        this.f45675a = new HashMap();
        this.f45679e = new ArrayList(cVar.f45695c);
        this.f45680f = new ArrayList(cVar.f45694b);
        this.f45677c = cVar.f45696d;
        this.f45678d = cVar.f45697e;
        this.f45676b = cVar.f45693a;
        this.f45682h = cVar.f45700h;
        this.f45683i = cVar.f45701i;
        this.f45684j = cVar.f45702j;
        if (cVar.f45698f != null) {
            gVar = new i(cVar.f45698f);
        } else {
            if (cVar.f45699g == null) {
                this.f45681g = new org.bouncycastle.jcajce.util.c();
                return;
            }
            gVar = new org.bouncycastle.jcajce.util.g(cVar.f45699g);
        }
        this.f45681g = gVar;
    }

    public /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public static List<jq.d> e(zn.k kVar, Map<b0, jq.d> map) throws AnnotatedException {
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
            throw new AnnotatedException("could not read distribution points could not be read", e10);
        }
    }

    public final void a(List<X500Principal> list, CertStore certStore) throws CertStoreException {
        certStore.getCRLs(new a(list));
    }

    public final void b(List<X500Principal> list, s<CRL> sVar) {
        sVar.a(new b(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(jq.k r22, java.util.Date r23, java.util.Date r24, java.security.cert.X509Certificate r25, java.security.cert.X509Certificate r26, java.security.PublicKey r27, java.util.List r28, org.bouncycastle.jcajce.util.d r29) throws org.bouncycastle.pkix.jcajce.AnnotatedException, java.security.cert.CertPathValidatorException {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pkix.jcajce.g.c(jq.k, java.util.Date, java.util.Date, java.security.cert.X509Certificate, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List, org.bouncycastle.jcajce.util.d):void");
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException {
        Logger logger;
        Level level;
        StringBuilder sb2;
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.f45677c && x509Certificate.getBasicConstraints() != -1) {
            this.f45686l = x509Certificate.getSubjectX500Principal();
            this.f45687m = x509Certificate.getPublicKey();
            this.f45688n = x509Certificate;
            return;
        }
        TrustAnchor trustAnchor = null;
        if (this.f45686l == null) {
            this.f45686l = x509Certificate.getIssuerX500Principal();
            for (TrustAnchor trustAnchor2 : this.f45676b) {
                if (this.f45686l.equals(trustAnchor2.getCA()) || this.f45686l.equals(trustAnchor2.getTrustedCert().getSubjectX500Principal())) {
                    trustAnchor = trustAnchor2;
                }
            }
            if (trustAnchor == null) {
                throw new CertPathValidatorException("no trust anchor found for " + this.f45686l);
            }
            X509Certificate trustedCert = trustAnchor.getTrustedCert();
            this.f45688n = trustedCert;
            this.f45687m = trustedCert.getPublicKey();
        }
        ArrayList arrayList = new ArrayList();
        try {
            PKIXParameters pKIXParameters = new PKIXParameters(this.f45676b);
            pKIXParameters.setRevocationEnabled(false);
            pKIXParameters.setDate(this.f45685k);
            for (int i10 = 0; i10 != this.f45680f.size(); i10++) {
                if (f45672q.isLoggable(Level.INFO)) {
                    a(arrayList, this.f45680f.get(i10));
                }
                pKIXParameters.addCertStore(this.f45680f.get(i10));
            }
            k.b bVar = new k.b(pKIXParameters);
            bVar.w(this.f45678d);
            for (int i11 = 0; i11 != this.f45679e.size(); i11++) {
                if (f45672q.isLoggable(Level.INFO)) {
                    b(arrayList, this.f45679e.get(i11));
                }
                bVar.m(new d(this.f45679e.get(i11)));
            }
            if (arrayList.isEmpty()) {
                f45672q.log(Level.INFO, "configured with 0 pre-loaded CRLs");
            } else if (f45672q.isLoggable(Level.FINE)) {
                for (int i12 = 0; i12 != arrayList.size(); i12++) {
                    f45672q.log(Level.FINE, "configuring with CRL for issuer \"" + arrayList.get(i12) + "\"");
                }
            } else {
                f45672q.log(Level.INFO, "configured with " + arrayList.size() + " pre-loaded CRLs");
            }
            jq.k kVarQ = bVar.q();
            try {
                c(kVarQ, this.f45685k, f.m(kVarQ, this.f45685k), x509Certificate, this.f45688n, this.f45687m, new ArrayList(), this.f45681g);
            } catch (AnnotatedException e10) {
                throw new CertPathValidatorException(e10.getMessage(), e10.getCause());
            } catch (CRLNotFoundException e11) {
                y yVar = zn.y.f59074s;
                if (x509Certificate.getExtensionValue(yVar.L()) == null) {
                    throw e11;
                }
                try {
                    CRL crlD = d(x509Certificate.getIssuerX500Principal(), this.f45685k, f.h(x509Certificate, yVar), this.f45681g);
                    if (crlD != null) {
                        try {
                            bVar.m(new d(new org.bouncycastle.util.e(Collections.singleton(crlD))));
                            jq.k kVarQ2 = bVar.q();
                            c(kVarQ2, this.f45685k, f.m(kVarQ2, this.f45685k), x509Certificate, this.f45688n, this.f45687m, new ArrayList(), this.f45681g);
                        } catch (AnnotatedException e12) {
                            throw new CertPathValidatorException(e12.getMessage(), e12.getCause());
                        }
                    } else {
                        if (!this.f45682h) {
                            throw e11;
                        }
                        X500Principal issuerX500Principal = x509Certificate.getIssuerX500Principal();
                        Long l10 = this.f45675a.get(issuerX500Principal);
                        if (l10 != null) {
                            long jCurrentTimeMillis = System.currentTimeMillis() - l10.longValue();
                            long j10 = this.f45684j;
                            if (j10 != -1 && j10 < jCurrentTimeMillis) {
                                throw e11;
                            }
                            if (jCurrentTimeMillis < this.f45683i) {
                                logger = f45672q;
                                level = Level.WARNING;
                                sb2 = new StringBuilder();
                            } else {
                                logger = f45672q;
                                level = Level.SEVERE;
                                sb2 = new StringBuilder();
                            }
                            sb2.append("soft failing for issuer: \"");
                            sb2.append(issuerX500Principal);
                            sb2.append("\"");
                            logger.log(level, sb2.toString());
                        } else {
                            this.f45675a.put(issuerX500Principal, Long.valueOf(System.currentTimeMillis()));
                        }
                    }
                } catch (AnnotatedException e13) {
                    throw new CertPathValidatorException(e13.getMessage(), e13.getCause());
                }
            }
            this.f45688n = x509Certificate;
            this.f45687m = x509Certificate.getPublicKey();
            this.f45686l = x509Certificate.getSubjectX500Principal();
        } catch (GeneralSecurityException e14) {
            throw new RuntimeException("error setting up baseParams: " + e14.getMessage());
        }
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Object clone() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public final CRL d(X500Principal x500Principal, Date date, gm.c0 c0Var, org.bouncycastle.jcajce.util.d dVar) {
        URL url;
        X509CRL x509crl;
        Logger logger;
        Level level;
        StringBuilder sb2;
        v[] vVarArrY = zn.k.A(c0Var).y();
        for (int i10 = 0; i10 != vVarArrY.length; i10++) {
            w wVarZ = vVarArrY[i10].z();
            if (wVarZ != null && wVarZ.B() == 0) {
                b0[] b0VarArrB = c0.A(wVarZ.A()).B();
                for (int i11 = 0; i11 != b0VarArrB.length; i11++) {
                    b0 b0Var = b0VarArrB[i11];
                    if (b0Var.q() == 6) {
                        Map<b0, WeakReference<X509CRL>> map = f45673r;
                        WeakReference<X509CRL> weakReference = map.get(b0Var);
                        if (weakReference != null) {
                            X509CRL x509crl2 = weakReference.get();
                            if (x509crl2 != null && !date.before(x509crl2.getThisUpdate()) && !date.after(x509crl2.getNextUpdate())) {
                                return x509crl2;
                            }
                            map.remove(b0Var);
                        }
                        try {
                            url = new URL(b0Var.A().toString());
                            try {
                                CertificateFactory certificateFactoryS = dVar.s("X.509");
                                InputStream inputStreamOpenStream = url.openStream();
                                x509crl = (X509CRL) certificateFactoryS.generateCRL(new BufferedInputStream(inputStreamOpenStream));
                                inputStreamOpenStream.close();
                                logger = f45672q;
                                level = Level.INFO;
                                sb2 = new StringBuilder();
                                sb2.append("downloaded CRL from CrlDP ");
                                sb2.append(url);
                                sb2.append(" for issuer \"");
                            } catch (Exception e10) {
                                e = e10;
                            }
                            try {
                                sb2.append(x500Principal);
                                sb2.append("\"");
                                logger.log(level, sb2.toString());
                                map.put(b0Var, new WeakReference<>(x509crl));
                                return x509crl;
                            } catch (Exception e11) {
                                e = e11;
                                Logger logger2 = f45672q;
                                Level level2 = Level.FINE;
                                if (logger2.isLoggable(level2)) {
                                    f45672q.log(level2, "CrlDP " + url + " ignored: " + e.getMessage(), (Throwable) e);
                                } else {
                                    f45672q.log(Level.INFO, "CrlDP " + url + " ignored: " + e.getMessage());
                                }
                            }
                        } catch (Exception e12) {
                            e = e12;
                            url = null;
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean z10) throws CertPathValidatorException {
        if (z10) {
            throw new IllegalArgumentException("forward processing not supported");
        }
        this.f45685k = new Date();
        this.f45686l = null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }
}
