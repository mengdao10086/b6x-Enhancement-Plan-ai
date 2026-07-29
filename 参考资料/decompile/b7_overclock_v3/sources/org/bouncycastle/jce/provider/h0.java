package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import zn.d1;

/* JADX INFO: loaded from: classes5.dex */
public class h0 extends X509CRL {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.p f45456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f45457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f45458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45460e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f45461f;

    public h0(zn.p pVar) throws CRLException {
        this.f45456a = pVar;
        try {
            this.f45457b = m0.b(pVar.E());
            if (pVar.E().A() != null) {
                this.f45458c = pVar.E().A().b().v(gm.j.f29713a);
            } else {
                this.f45458c = null;
            }
            this.f45459d = c(this);
        } catch (Exception e10) {
            throw new CRLException("CRL contents invalid: " + e10);
        }
    }

    public static boolean c(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(zn.y.f59071p.L());
            if (extensionValue != null) {
                if (zn.i0.B(gm.z.I(extensionValue).J()).D()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            throw new ExtCRLException("Exception reading IssuingDistributionPoint", e10);
        }
    }

    public final void a(PublicKey publicKey, Signature signature) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, CRLException {
        if (!this.f45456a.E().equals(this.f45456a.F().E())) {
            throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
        }
        signature.initVerify(publicKey);
        signature.update(getTBSCertList());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("CRL does not verify with supplied public key.");
        }
    }

    public final Set b(boolean z10) {
        zn.z zVarX;
        if (getVersion() != 2 || (zVarX = this.f45456a.F().x()) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumerationI = zVarX.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            if (z10 == zVarX.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    public final Set e() {
        zn.y yVarZ;
        HashSet hashSet = new HashSet();
        Enumeration enumerationB = this.f45456a.B();
        xn.d dVarA = null;
        while (enumerationB.hasMoreElements()) {
            d1.b bVar = (d1.b) enumerationB.nextElement();
            hashSet.add(new g0(bVar, this.f45459d, dVarA));
            if (this.f45459d && bVar.B() && (yVarZ = bVar.x().z(zn.y.f59072q)) != null) {
                dVarA = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509CRL
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        if (!(obj instanceof h0)) {
            return super.equals(obj);
        }
        h0 h0Var = (h0) obj;
        if (this.f45460e && h0Var.f45460e && h0Var.f45461f != this.f45461f) {
            return false;
        }
        return this.f45456a.equals(h0Var.f45456a);
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return b(true);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        try {
            return this.f45456a.v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        zn.y yVarZ;
        zn.z zVarX = this.f45456a.F().x();
        if (zVarX == null || (yVarZ = zVarX.z(new gm.y(str))) == null) {
            return null;
        }
        try {
            return yVarZ.A().getEncoded();
        } catch (Exception e10) {
            throw new IllegalStateException("error parsing " + e10.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new org.bouncycastle.jce.j(xn.d.A(this.f45456a.z().b()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f45456a.z().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        if (this.f45456a.A() != null) {
            return this.f45456a.A().x();
        }
        return null;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return b(false);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        zn.y yVarZ;
        Enumeration enumerationB = this.f45456a.B();
        xn.d dVarA = null;
        while (enumerationB.hasMoreElements()) {
            d1.b bVar = (d1.b) enumerationB.nextElement();
            if (bVar.A().N(bigInteger)) {
                return new g0(bVar, this.f45459d, dVarA);
            }
            if (this.f45459d && bVar.B() && (yVarZ = bVar.x().z(zn.y.f59072q)) != null) {
                dVarA = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set setE = e();
        if (setE.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableSet(setE);
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.f45457b;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.f45456a.E().x().L();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        byte[] bArr = this.f45458c;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.f45456a.D().L();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        try {
            return this.f45456a.F().v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.f45456a.G().x();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f45456a.H();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(b0.f45390e);
        criticalExtensionOIDs.remove(b0.f45392g);
        return !criticalExtensionOIDs.isEmpty();
    }

    @Override // java.security.cert.X509CRL
    public int hashCode() {
        if (!this.f45460e) {
            this.f45460e = true;
            this.f45461f = super.hashCode();
        }
        return this.f45461f;
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        xn.d dVarA;
        zn.y yVarZ;
        if (!certificate.getType().equals("X.509")) {
            throw new RuntimeException("X.509 CRL used with non X.509 Cert");
        }
        Enumeration enumerationB = this.f45456a.B();
        xn.d dVarZ = this.f45456a.z();
        if (enumerationB != null) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            BigInteger serialNumber = x509Certificate.getSerialNumber();
            while (enumerationB.hasMoreElements()) {
                d1.b bVarY = d1.b.y(enumerationB.nextElement());
                if (this.f45459d && bVarY.B() && (yVarZ = bVarY.x().z(zn.y.f59072q)) != null) {
                    dVarZ = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
                }
                if (bVarY.A().N(serialNumber)) {
                    if (certificate instanceof X509Certificate) {
                        dVarA = xn.d.A(x509Certificate.getIssuerX500Principal().getEncoded());
                    } else {
                        try {
                            dVarA = zn.o.z(certificate.getEncoded()).A();
                        } catch (CertificateEncodingException unused) {
                            throw new RuntimeException("Cannot process certificate");
                        }
                    }
                    return dVarZ.equals(dVarA);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00c1  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:42:0x0183
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // java.security.cert.CRL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.provider.h0.toString():java.lang.String");
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, CRLException, NoSuchProviderException {
        Signature signature;
        try {
            signature = Signature.getInstance(getSigAlgName(), BouncyCastleProvider.f45329b);
        } catch (Exception unused) {
            signature = Signature.getInstance(getSigAlgName());
        }
        a(publicKey, signature);
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, String str) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, CRLException, NoSuchProviderException {
        a(publicKey, str != null ? Signature.getInstance(getSigAlgName(), str) : Signature.getInstance(getSigAlgName()));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, Provider provider) throws SignatureException, NoSuchAlgorithmException, InvalidKeyException, CRLException {
        a(publicKey, provider != null ? Signature.getInstance(getSigAlgName(), provider) : Signature.getInstance(getSigAlgName()));
    }
}
