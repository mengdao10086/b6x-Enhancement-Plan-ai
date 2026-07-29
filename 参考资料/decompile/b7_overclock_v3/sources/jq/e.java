package jq;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509Certificate;
import java.util.Collection;
import org.bouncycastle.util.q;

/* JADX INFO: loaded from: classes7.dex */
public class e<T extends CRL> implements q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CRLSelector f36836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f36837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f36838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BigInteger f36839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f36840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f36841f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CRLSelector f36842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f36843b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f36844c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BigInteger f36845d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f36846e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f36847f = false;

        public b(CRLSelector cRLSelector) {
            this.f36842a = (CRLSelector) cRLSelector.clone();
        }

        public e<? extends CRL> g() {
            return new e<>(this);
        }

        public b h(boolean z10) {
            this.f36844c = z10;
            return this;
        }

        public b i(boolean z10) {
            this.f36843b = z10;
            return this;
        }

        public void j(byte[] bArr) {
            this.f36846e = org.bouncycastle.util.a.p(bArr);
        }

        public void k(boolean z10) {
            this.f36847f = z10;
        }

        public void l(BigInteger bigInteger) {
            this.f36845d = bigInteger;
        }
    }

    public static class c extends X509CRLSelector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f36848a;

        public c(e eVar) {
            this.f36848a = eVar;
            if (eVar.f36836a instanceof X509CRLSelector) {
                X509CRLSelector x509CRLSelector = (X509CRLSelector) eVar.f36836a;
                setCertificateChecking(x509CRLSelector.getCertificateChecking());
                setDateAndTime(x509CRLSelector.getDateAndTime());
                setIssuers(x509CRLSelector.getIssuers());
                setMinCRLNumber(x509CRLSelector.getMinCRL());
                setMaxCRLNumber(x509CRLSelector.getMaxCRL());
            }
        }

        @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
        public boolean match(CRL crl) {
            e eVar = this.f36848a;
            return eVar == null ? crl != null : eVar.M(crl);
        }
    }

    public e(b bVar) {
        this.f36836a = bVar.f36842a;
        this.f36837b = bVar.f36843b;
        this.f36838c = bVar.f36844c;
        this.f36839d = bVar.f36845d;
        this.f36840e = bVar.f36846e;
        this.f36841f = bVar.f36847f;
    }

    public static Collection<? extends CRL> b(e eVar, CertStore certStore) throws CertStoreException {
        return certStore.getCRLs(new c(eVar));
    }

    public X509Certificate c() {
        CRLSelector cRLSelector = this.f36836a;
        if (cRLSelector instanceof X509CRLSelector) {
            return ((X509CRLSelector) cRLSelector).getCertificateChecking();
        }
        return null;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return this;
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f36840e);
    }

    public BigInteger e() {
        return this.f36839d;
    }

    public boolean f() {
        return this.f36838c;
    }

    public boolean g() {
        return this.f36837b;
    }

    public boolean h() {
        return this.f36841f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        if (org.bouncycastle.util.a.g(r0, r1) == false) goto L32;
     */
    @Override // org.bouncycastle.util.q
    /* JADX INFO: renamed from: match, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean M(java.security.cert.CRL r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.security.cert.X509CRL
            if (r0 != 0) goto Lb
        L4:
            java.security.cert.CRLSelector r0 = r4.f36836a
            boolean r5 = r0.match(r5)
            return r5
        Lb:
            r0 = r5
            java.security.cert.X509CRL r0 = (java.security.cert.X509CRL) r0
            r1 = 0
            r2 = 0
            gm.y r3 = zn.y.f59070o     // Catch: java.lang.Exception -> L69
            java.lang.String r3 = r3.L()     // Catch: java.lang.Exception -> L69
            byte[] r3 = r0.getExtensionValue(r3)     // Catch: java.lang.Exception -> L69
            if (r3 == 0) goto L28
            gm.z r1 = gm.z.I(r3)     // Catch: java.lang.Exception -> L69
            byte[] r1 = r1.J()     // Catch: java.lang.Exception -> L69
            gm.t r1 = gm.t.I(r1)     // Catch: java.lang.Exception -> L69
        L28:
            boolean r3 = r4.g()
            if (r3 == 0) goto L31
            if (r1 != 0) goto L31
            return r2
        L31:
            boolean r3 = r4.f()
            if (r3 == 0) goto L3a
            if (r1 == 0) goto L3a
            return r2
        L3a:
            if (r1 == 0) goto L4e
            java.math.BigInteger r3 = r4.f36839d
            if (r3 == 0) goto L4e
            java.math.BigInteger r1 = r1.J()
            java.math.BigInteger r3 = r4.f36839d
            int r1 = r1.compareTo(r3)
            r3 = 1
            if (r1 != r3) goto L4e
            return r2
        L4e:
            boolean r1 = r4.f36841f
            if (r1 == 0) goto L4
            gm.y r1 = zn.y.f59071p
            java.lang.String r1 = r1.L()
            byte[] r0 = r0.getExtensionValue(r1)
            byte[] r1 = r4.f36840e
            if (r1 != 0) goto L63
            if (r0 == 0) goto L4
            return r2
        L63:
            boolean r0 = org.bouncycastle.util.a.g(r0, r1)
            if (r0 != 0) goto L4
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: jq.e.M(java.security.cert.CRL):boolean");
    }
}
