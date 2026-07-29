package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.c0;
import gm.f0;
import gm.h;
import gm.j;
import gm.u1;
import gm.z;
import java.io.BufferedOutputStream;
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
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.CompositePublicKey;
import zn.d1;
import zn.j1;
import zn.o;
import zn.p;
import zn.y;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e extends X509CRL {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.jcajce.util.d f45089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f45090b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f45091c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f45092d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45093e;

    public class a implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {
        public a() {
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
            try {
                return e.this.f45089a.a(str);
            } catch (Exception unused) {
                return Signature.getInstance(str);
            }
        }
    }

    public class b implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f45095a;

        public b(String str) {
            this.f45095a = str;
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
            String str2 = this.f45095a;
            return str2 != null ? Signature.getInstance(str, str2) : Signature.getInstance(str);
        }
    }

    public class c implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Provider f45097a;

        public c(Provider provider) {
            this.f45097a = provider;
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
            return this.f45097a != null ? Signature.getInstance(e.this.getSigAlgName(), this.f45097a) : Signature.getInstance(e.this.getSigAlgName());
        }
    }

    public e(org.bouncycastle.jcajce.util.d dVar, p pVar, String str, byte[] bArr, boolean z10) {
        this.f45089a = dVar;
        this.f45090b = pVar;
        this.f45091c = str;
        this.f45092d = bArr;
        this.f45093e = z10;
    }

    public static byte[] e(p pVar, String str) {
        z zVarF = f(pVar, str);
        if (zVarF != null) {
            return zVarF.J();
        }
        return null;
    }

    public static z f(p pVar, String str) {
        y yVarZ;
        zn.z zVarX = pVar.F().x();
        if (zVarX == null || (yVarZ = zVarX.z(new gm.y(str))) == null) {
            return null;
        }
        return yVarZ.A();
    }

    public final void a(PublicKey publicKey, Signature signature, h hVar, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        if (hVar != null) {
            g.g(signature, hVar);
        }
        signature.initVerify(publicKey);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(lq.f.b(signature), 512);
            this.f45090b.F().u(bufferedOutputStream, j.f29713a);
            bufferedOutputStream.close();
            if (!signature.verify(bArr)) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    public final void b(PublicKey publicKey, org.bouncycastle.jcajce.provider.asymmetric.x509.c cVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException, NoSuchProviderException {
        if (!this.f45090b.E().equals(this.f45090b.F().E())) {
            throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
        }
        int i10 = 0;
        if ((publicKey instanceof CompositePublicKey) && g.d(this.f45090b.E())) {
            List<PublicKey> listA = ((CompositePublicKey) publicKey).a();
            f0 f0VarJ = f0.J(this.f45090b.E().A());
            f0 f0VarJ2 = f0.J(u1.S(this.f45090b.D()).H());
            boolean z10 = false;
            while (i10 != listA.size()) {
                if (listA.get(i10) != null) {
                    zn.b bVarZ = zn.b.z(f0VarJ.K(i10));
                    try {
                        a(listA.get(i10), cVar.a(g.c(bVarZ)), bVarZ.A(), u1.S(f0VarJ2.K(i10)).H());
                        e = null;
                        z10 = true;
                    } catch (SignatureException e10) {
                        e = e10;
                    }
                    if (e != null) {
                        throw e;
                    }
                }
                i10++;
            }
            if (!z10) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        if (!g.d(this.f45090b.E())) {
            Signature signatureA = cVar.a(getSigAlgName());
            byte[] bArr = this.f45092d;
            if (bArr == null) {
                a(publicKey, signatureA, null, getSignature());
                return;
            }
            try {
                a(publicKey, signatureA, c0.D(bArr), getSignature());
                return;
            } catch (IOException e11) {
                throw new SignatureException("cannot decode signature parameters: " + e11.getMessage());
            }
        }
        f0 f0VarJ3 = f0.J(this.f45090b.E().A());
        f0 f0VarJ4 = f0.J(u1.S(this.f45090b.D()).H());
        boolean z11 = false;
        while (i10 != f0VarJ4.size()) {
            zn.b bVarZ2 = zn.b.z(f0VarJ3.K(i10));
            try {
                a(publicKey, cVar.a(g.c(bVarZ2)), bVarZ2.A(), u1.S(f0VarJ4.K(i10)).H());
                e = null;
                z11 = true;
            } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
                e = null;
            } catch (SignatureException e12) {
                e = e12;
            }
            if (e != null) {
                throw e;
            }
            i10++;
        }
        if (!z11) {
            throw new InvalidKeyException("no matching key found");
        }
    }

    public final Set c(boolean z10) {
        zn.z zVarX;
        if (getVersion() != 2 || (zVarX = this.f45090b.F().x()) == null) {
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

    public final Set g() {
        y yVarZ;
        HashSet hashSet = new HashSet();
        Enumeration enumerationB = this.f45090b.B();
        xn.d dVarA = null;
        while (enumerationB.hasMoreElements()) {
            d1.b bVar = (d1.b) enumerationB.nextElement();
            hashSet.add(new d(bVar, this.f45093e, dVarA));
            if (this.f45093e && bVar.B() && (yVarZ = bVar.x().z(y.f59072q)) != null) {
                dVarA = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return c(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        z zVarF = f(this.f45090b, str);
        if (zVarF == null) {
            return null;
        }
        try {
            return zVarF.getEncoded();
        } catch (Exception e10) {
            throw new IllegalStateException("error parsing " + e10.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new org.bouncycastle.jce.j(xn.d.A(this.f45090b.z().b()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f45090b.z().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        j1 j1VarA = this.f45090b.A();
        if (j1VarA == null) {
            return null;
        }
        return j1VarA.x();
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return c(false);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        y yVarZ;
        Enumeration enumerationB = this.f45090b.B();
        xn.d dVarA = null;
        while (enumerationB.hasMoreElements()) {
            d1.b bVar = (d1.b) enumerationB.nextElement();
            if (bVar.A().N(bigInteger)) {
                return new d(bVar, this.f45093e, dVarA);
            }
            if (this.f45093e && bVar.B() && (yVarZ = bVar.x().z(y.f59072q)) != null) {
                dVarA = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set setG = g();
        if (setG.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableSet(setG);
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.f45091c;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.f45090b.E().x().L();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return org.bouncycastle.util.a.p(this.f45092d);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.f45090b.D().L();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        try {
            return this.f45090b.F().v(j.f29713a);
        } catch (IOException e10) {
            throw new CRLException(e10.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.f45090b.G().x();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f45090b.H();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(y.f59071p.L());
        criticalExtensionOIDs.remove(y.f59070o.L());
        return !criticalExtensionOIDs.isEmpty();
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        xn.d dVarA;
        y yVarZ;
        if (!certificate.getType().equals("X.509")) {
            throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
        }
        Enumeration enumerationB = this.f45090b.B();
        xn.d dVarZ = this.f45090b.z();
        if (enumerationB.hasMoreElements()) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            BigInteger serialNumber = x509Certificate.getSerialNumber();
            while (enumerationB.hasMoreElements()) {
                d1.b bVarY = d1.b.y(enumerationB.nextElement());
                if (this.f45093e && bVarY.B() && (yVarZ = bVarY.x().z(y.f59072q)) != null) {
                    dVarZ = xn.d.A(zn.c0.A(yVarZ.C()).B()[0].A());
                }
                if (bVarY.A().N(serialNumber)) {
                    if (certificate instanceof X509Certificate) {
                        dVarA = xn.d.A(x509Certificate.getIssuerX500Principal().getEncoded());
                    } else {
                        try {
                            dVarA = o.z(certificate.getEncoded()).A();
                        } catch (CertificateEncodingException e10) {
                            throw new IllegalArgumentException("Cannot process certificate: " + e10.getMessage());
                        }
                    }
                    return dVarZ.equals(dVarA);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0081  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:34:0x0143
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
            Method dump skipped, instruction units count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.x509.e.toString():java.lang.String");
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException, NoSuchProviderException {
        b(publicKey, new a());
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException, NoSuchProviderException {
        b(publicKey, new b(str));
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, Provider provider) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        try {
            b(publicKey, new c(provider));
        } catch (NoSuchProviderException e10) {
            throw new NoSuchAlgorithmException("provider issue: " + e10.getMessage());
        }
    }
}
