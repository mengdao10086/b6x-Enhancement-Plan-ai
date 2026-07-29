package org.bouncycastle.jce.provider;

import gm.d2;
import gm.f2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.jce.exception.ExtCertPathValidatorException;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class z implements jq.f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45524f = 15000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45525g = 32768;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map f45526h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f45527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jq.g f45529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f45531e;

    static {
        HashMap map = new HashMap();
        f45526h = map;
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

    public z(a0 a0Var, org.bouncycastle.jcajce.util.d dVar) {
        this.f45527a = a0Var;
        this.f45528b = dVar;
    }

    public static byte[] c(MessageDigest messageDigest, PublicKey publicKey) {
        return messageDigest.digest(c1.A(publicKey.getEncoded()).C().H());
    }

    public static String g(gm.y yVar) {
        String strA = org.bouncycastle.jcajce.util.f.a(yVar);
        int iIndexOf = strA.indexOf(45);
        if (iIndexOf <= 0 || strA.startsWith("SHA3")) {
            return strA;
        }
        return strA.substring(0, iIndexOf) + strA.substring(iIndexOf + 1);
    }

    public static URI h(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(zn.y.A.L());
        if (extensionValue == null) {
            return null;
        }
        zn.a[] aVarArrZ = zn.h.A(gm.z.I(extensionValue).J()).z();
        for (int i10 = 0; i10 != aVarArrZ.length; i10++) {
            zn.a aVar = aVarArrZ[i10];
            if (zn.a.f58659d.C(aVar.y())) {
                zn.b0 b0VarX = aVar.x();
                if (b0VarX.q() == 6) {
                    try {
                        return new URI(((gm.k0) b0VarX.A()).d());
                    } catch (URISyntaxException unused) {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static String i(zn.b bVar) {
        gm.h hVarA = bVar.A();
        if (hVarA == null || d2.f29657b.B(hVarA) || !bVar.x().C(pn.s.G3)) {
            Map map = f45526h;
            boolean zContainsKey = map.containsKey(bVar.x());
            gm.y yVarX = bVar.x();
            return zContainsKey ? (String) map.get(yVarX) : yVarX.L();
        }
        return g(pn.a0.y(hVarA).x().x()) + "WITHRSAANDMGF1";
    }

    public static X509Certificate j(nn.a aVar, X509Certificate x509Certificate, X509Certificate x509Certificate2, org.bouncycastle.jcajce.util.d dVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        nn.j jVarA = aVar.C().A();
        byte[] bArrZ = jVarA.z();
        if (bArrZ != null) {
            MessageDigest messageDigestG = dVar.g("SHA1");
            if (x509Certificate2 != null && org.bouncycastle.util.a.g(bArrZ, c(messageDigestG, x509Certificate2.getPublicKey()))) {
                return x509Certificate2;
            }
            if (x509Certificate == null || !org.bouncycastle.util.a.g(bArrZ, c(messageDigestG, x509Certificate.getPublicKey()))) {
                return null;
            }
            return x509Certificate;
        }
        xn.f fVar = yn.b.R;
        xn.d dVarB = xn.d.B(fVar, jVarA.A());
        if (x509Certificate2 != null && dVarB.equals(xn.d.B(fVar, x509Certificate2.getSubjectX500Principal().getEncoded()))) {
            return x509Certificate2;
        }
        if (x509Certificate == null || !dVarB.equals(xn.d.B(fVar, x509Certificate.getSubjectX500Principal().getEncoded()))) {
            return null;
        }
        return x509Certificate;
    }

    public static boolean o(nn.j jVar, X509Certificate x509Certificate, org.bouncycastle.jcajce.util.d dVar) throws NoSuchAlgorithmException, NoSuchProviderException {
        byte[] bArrZ = jVar.z();
        if (bArrZ != null) {
            return org.bouncycastle.util.a.g(bArrZ, c(dVar.g("SHA1"), x509Certificate.getPublicKey()));
        }
        xn.f fVar = yn.b.R;
        return xn.d.B(fVar, jVar.A()).equals(xn.d.B(fVar, x509Certificate.getSubjectX500Principal().getEncoded()));
    }

    public static boolean p(nn.a aVar, jq.g gVar, byte[] bArr, X509Certificate x509Certificate, org.bouncycastle.jcajce.util.d dVar) throws CertPathValidatorException {
        try {
            gm.f0 f0VarX = aVar.x();
            Signature signatureA = dVar.a(i(aVar.B()));
            X509Certificate x509CertificateJ = j(aVar, gVar.d(), x509Certificate, dVar);
            if (x509CertificateJ == null && f0VarX == null) {
                throw new CertPathValidatorException("OCSP responder certificate not found");
            }
            if (x509CertificateJ != null) {
                signatureA.initVerify(x509CertificateJ.getPublicKey());
            } else {
                X509Certificate x509Certificate2 = (X509Certificate) dVar.s("X.509").generateCertificate(new ByteArrayInputStream(f0VarX.K(0).b().getEncoded()));
                x509Certificate2.verify(gVar.d().getPublicKey());
                x509Certificate2.checkValidity(gVar.e());
                if (!o(aVar.C().A(), x509Certificate2, dVar)) {
                    throw new CertPathValidatorException("responder certificate does not match responderID", null, gVar.a(), gVar.b());
                }
                List<String> extendedKeyUsage = x509Certificate2.getExtendedKeyUsage();
                if (extendedKeyUsage == null || !extendedKeyUsage.contains(zn.j0.f58786l.x())) {
                    throw new CertPathValidatorException("responder certificate not valid for signing OCSP responses", null, gVar.a(), gVar.b());
                }
                signatureA.initVerify(x509Certificate2);
            }
            signatureA.update(aVar.C().v(gm.j.f29713a));
            if (!signatureA.verify(aVar.A().H())) {
                return false;
            }
            if (bArr != null && !org.bouncycastle.util.a.g(bArr, aVar.C().B().z(nn.e.f42258c).A().J())) {
                throw new CertPathValidatorException("nonce mismatch in OCSP response", null, gVar.a(), gVar.b());
            }
            return true;
        } catch (IOException e10) {
            throw new CertPathValidatorException("OCSP response failure: " + e10.getMessage(), e10, gVar.a(), gVar.b());
        } catch (CertPathValidatorException e11) {
            throw e11;
        } catch (GeneralSecurityException e12) {
            throw new CertPathValidatorException("OCSP response failure: " + e12.getMessage(), e12, gVar.a(), gVar.b());
        }
    }

    @Override // jq.f
    public void a(String str, Object obj) {
    }

    @Override // jq.f
    public void b(jq.g gVar) {
        this.f45529c = gVar;
        this.f45530d = org.bouncycastle.util.p.d("ocsp.enable");
        this.f45531e = org.bouncycastle.util.p.c("ocsp.responderURL");
    }

    @Override // jq.f
    public void check(Certificate certificate) throws CertPathValidatorException {
        byte[] bArr;
        boolean z10;
        X509Certificate x509Certificate = (X509Certificate) certificate;
        Map<X509Certificate, byte[]> ocspResponses = this.f45527a.getOcspResponses();
        URI ocspResponder = this.f45527a.getOcspResponder();
        if (ocspResponder == null) {
            if (this.f45531e != null) {
                try {
                    ocspResponder = new URI(this.f45531e);
                } catch (URISyntaxException e10) {
                    throw new CertPathValidatorException("configuration error: " + e10.getMessage(), e10, this.f45529c.a(), this.f45529c.b());
                }
            } else {
                ocspResponder = h(x509Certificate);
            }
        }
        URI uri = ocspResponder;
        if (ocspResponses.get(x509Certificate) != null || uri == null) {
            List<Extension> ocspExtensions = this.f45527a.getOcspExtensions();
            bArr = null;
            for (int i10 = 0; i10 != ocspExtensions.size(); i10++) {
                Extension extension = ocspExtensions.get(i10);
                byte[] value = extension.getValue();
                if (nn.e.f42258c.L().equals(extension.getId())) {
                    bArr = value;
                }
            }
            z10 = false;
        } else {
            if (this.f45531e == null && this.f45527a.getOcspResponder() == null && !this.f45530d) {
                throw new RecoverableCertPathValidatorException("OCSP disabled by \"ocsp.enable\" setting", null, this.f45529c.a(), this.f45529c.b());
            }
            try {
                ocspResponses.put(x509Certificate, l.a(e(new zn.b(on.b.f44365i), f(), new gm.t(x509Certificate.getSerialNumber())), this.f45529c, uri, this.f45527a.getOcspResponderCert(), this.f45527a.getOcspExtensions(), this.f45528b).getEncoded());
                bArr = null;
                z10 = true;
            } catch (IOException e11) {
                throw new CertPathValidatorException("unable to encode OCSP response", e11, this.f45529c.a(), this.f45529c.b());
            }
        }
        if (ocspResponses.isEmpty()) {
            throw new RecoverableCertPathValidatorException("no OCSP response found for any certificate", null, this.f45529c.a(), this.f45529c.b());
        }
        nn.g gVarY = nn.g.y(ocspResponses.get(x509Certificate));
        gm.t tVar = new gm.t(x509Certificate.getSerialNumber());
        if (gVarY == null) {
            throw new RecoverableCertPathValidatorException("no OCSP response found for certificate", null, this.f45529c.a(), this.f45529c.b());
        }
        if (gVarY.A().y() != 0) {
            throw new CertPathValidatorException("OCSP response failed: " + gVarY.A().z(), null, this.f45529c.a(), this.f45529c.b());
        }
        nn.k kVarY = nn.k.y(gVarY.z());
        if (kVarY.A().C(nn.e.f42257b)) {
            try {
                nn.a aVarZ = nn.a.z(kVarY.z().J());
                if (z10 || p(aVarZ, this.f45529c, bArr, this.f45527a.getOcspResponderCert(), this.f45528b)) {
                    gm.f0 f0VarC = nn.l.y(aVarZ.C()).C();
                    nn.b bVarD = null;
                    for (int i11 = 0; i11 != f0VarC.size(); i11++) {
                        nn.p pVarA = nn.p.A(f0VarC.K(i11));
                        if (tVar.C(pVarA.x().C())) {
                            gm.o oVarB = pVarA.B();
                            if (oVarB != null && this.f45529c.e().after(oVarB.K())) {
                                throw new ExtCertPathValidatorException("OCSP response expired");
                            }
                            if (bVarD == null || !bVarD.x().equals(pVarA.x().x())) {
                                bVarD = d(pVarA.x(), f(), tVar);
                            }
                            if (bVarD.equals(pVarA.x())) {
                                if (pVarA.y().q() == 0) {
                                    return;
                                }
                                if (pVarA.y().q() != 1) {
                                    throw new CertPathValidatorException("certificate revoked, details unknown", null, this.f45529c.a(), this.f45529c.b());
                                }
                                nn.m mVarY = nn.m.y(pVarA.y().z());
                                throw new CertPathValidatorException("certificate revoked, reason=(" + mVarY.z() + "), date=" + mVarY.A().K(), null, this.f45529c.a(), this.f45529c.b());
                            }
                        }
                    }
                }
            } catch (CertPathValidatorException e12) {
                throw e12;
            } catch (Exception e13) {
                throw new CertPathValidatorException("unable to process OCSP response", e13, this.f45529c.a(), this.f45529c.b());
            }
        }
    }

    public final nn.b d(nn.b bVar, zn.o oVar, gm.t tVar) throws CertPathValidatorException {
        return e(bVar.x(), oVar, tVar);
    }

    public final nn.b e(zn.b bVar, zn.o oVar, gm.t tVar) throws CertPathValidatorException {
        try {
            MessageDigest messageDigestG = this.f45528b.g(org.bouncycastle.jcajce.util.f.a(bVar.x()));
            return new nn.b(bVar, new f2(messageDigestG.digest(oVar.F().v(gm.j.f29713a))), new f2(messageDigestG.digest(oVar.G().C().H())), tVar);
        } catch (Exception e10) {
            throw new CertPathValidatorException("problem creating ID: " + e10, e10);
        }
    }

    public final zn.o f() throws CertPathValidatorException {
        try {
            return zn.o.z(this.f45529c.d().getEncoded());
        } catch (Exception e10) {
            throw new CertPathValidatorException("cannot process signing cert: " + e10.getMessage(), e10, this.f45529c.a(), this.f45529c.b());
        }
    }

    public List<CertPathValidatorException> k() {
        return null;
    }

    public Set<String> l() {
        return null;
    }

    public void m(boolean z10) throws CertPathValidatorException {
        if (z10) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.f45529c = null;
        this.f45530d = org.bouncycastle.util.p.d("ocsp.enable");
        this.f45531e = org.bouncycastle.util.p.c("ocsp.responderURL");
    }

    public boolean n() {
        return false;
    }
}
