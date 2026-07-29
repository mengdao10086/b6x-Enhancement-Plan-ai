package org.bouncycastle.jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends PKIXRevocationChecker implements jq.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f45370e = 15000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45371f = 32768;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f45372g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f45374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f45375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jq.g f45376d;

    static {
        HashMap map = new HashMap();
        f45372g = map;
        map.put(new gm.y("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        map.put(pn.s.K3, "SHA224WITHRSA");
        map.put(pn.s.H3, "SHA256WITHRSA");
        map.put(pn.s.I3, "SHA384WITHRSA");
        map.put(pn.s.J3, "SHA512WITHRSA");
        map.put(qm.a.f47464n, "GOST3411WITHGOST3410");
        map.put(qm.a.f47465o, "GOST3411WITHECGOST3410");
        map.put(qn.a.f47519i, "GOST3411-2012-256WITHECGOST3410-2012-256");
        map.put(qn.a.f47520j, "GOST3411-2012-512WITHECGOST3410-2012-512");
        map.put(bq.a.f9545d, "SHA1WITHPLAIN-ECDSA");
        map.put(bq.a.f9546e, "SHA224WITHPLAIN-ECDSA");
        map.put(bq.a.f9547f, "SHA256WITHPLAIN-ECDSA");
        map.put(bq.a.f9548g, "SHA384WITHPLAIN-ECDSA");
        map.put(bq.a.f9549h, "SHA512WITHPLAIN-ECDSA");
        map.put(bq.a.f9550i, "RIPEMD160WITHPLAIN-ECDSA");
        map.put(dq.a.f26466s, "SHA1WITHCVC-ECDSA");
        map.put(dq.a.f26467t, "SHA224WITHCVC-ECDSA");
        map.put(dq.a.f26468u, "SHA256WITHCVC-ECDSA");
        map.put(dq.a.f26469v, "SHA384WITHCVC-ECDSA");
        map.put(dq.a.f26470w, "SHA512WITHCVC-ECDSA");
        map.put(bn.a.f9499a, "XMSS");
        map.put(bn.a.f9500b, "XMSSMT");
        map.put(new gm.y("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        map.put(new gm.y("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        map.put(new gm.y("1.2.840.10040.4.3"), "SHA1WITHDSA");
        map.put(co.r.f11170i0, "SHA1WITHECDSA");
        map.put(co.r.f11178n0, "SHA224WITHECDSA");
        map.put(co.r.f11180o0, "SHA256WITHECDSA");
        map.put(co.r.f11182p0, "SHA384WITHECDSA");
        map.put(co.r.f11184q0, "SHA512WITHECDSA");
        map.put(on.b.f44367k, "SHA1WITHRSA");
        map.put(on.b.f44366j, "SHA1WITHDSA");
        map.put(kn.d.X, "SHA224WITHDSA");
        map.put(kn.d.Y, "SHA256WITHDSA");
    }

    public a0(org.bouncycastle.jcajce.util.d dVar) {
        this.f45373a = dVar;
        this.f45374b = new y(dVar);
        this.f45375c = new z(this, dVar);
    }

    @Override // jq.f
    public void a(String str, Object obj) {
    }

    @Override // jq.f
    public void b(jq.g gVar) {
        this.f45376d = gVar;
        this.f45374b.b(gVar);
        this.f45375c.b(gVar);
    }

    public final boolean c(PKIXRevocationChecker.Option option) {
        return getOptions().contains(option);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate certificate, Collection<String> collection) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (!c(PKIXRevocationChecker.Option.ONLY_END_ENTITY) || x509Certificate.getBasicConstraints() == -1) {
            if (c(PKIXRevocationChecker.Option.PREFER_CRLS)) {
                try {
                    this.f45374b.check(certificate);
                    return;
                } catch (RecoverableCertPathValidatorException e10) {
                    if (c(PKIXRevocationChecker.Option.NO_FALLBACK)) {
                        throw e10;
                    }
                    this.f45375c.check(certificate);
                    return;
                }
            }
            try {
                this.f45375c.check(certificate);
            } catch (RecoverableCertPathValidatorException e11) {
                if (c(PKIXRevocationChecker.Option.NO_FALLBACK)) {
                    throw e11;
                }
                this.f45374b.check(certificate);
            }
        }
    }

    @Override // java.security.cert.PKIXRevocationChecker
    public List<CertPathValidatorException> getSoftFailExceptions() {
        return this.f45375c.k();
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean z10) throws CertPathValidatorException {
        this.f45376d = null;
        this.f45374b.c(z10);
        this.f45375c.m(z10);
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }
}
