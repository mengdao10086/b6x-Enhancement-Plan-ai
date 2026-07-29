package org.bouncycastle.jcajce.provider.asymmetric.x509;

import gm.c0;
import gm.d2;
import gm.f0;
import gm.h;
import gm.k0;
import gm.r;
import gm.s;
import gm.u1;
import gm.y;
import gm.z;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.CompositePublicKey;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.p;
import zn.b0;
import zn.e1;
import zn.j;
import zn.o;

/* JADX INFO: loaded from: classes7.dex */
abstract class X509CertificateImpl extends X509Certificate implements kq.a {
    public j basicConstraints;
    public org.bouncycastle.jcajce.util.d bcHelper;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o f45075c;
    public boolean[] keyUsage;
    public String sigAlgName;
    public byte[] sigAlgParams;

    public class a implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {
        public a() {
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException {
            try {
                return X509CertificateImpl.this.bcHelper.a(str);
            } catch (Exception unused) {
                return Signature.getInstance(str);
            }
        }
    }

    public class b implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f45077a;

        public b(String str) {
            this.f45077a = str;
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException {
            String str2 = this.f45077a;
            return str2 != null ? Signature.getInstance(str, str2) : Signature.getInstance(str);
        }
    }

    public class c implements org.bouncycastle.jcajce.provider.asymmetric.x509.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Provider f45079a;

        public c(Provider provider) {
            this.f45079a = provider;
        }

        @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.c
        public Signature a(String str) throws NoSuchAlgorithmException {
            Provider provider = this.f45079a;
            return provider != null ? Signature.getInstance(str, provider) : Signature.getInstance(str);
        }
    }

    public X509CertificateImpl(org.bouncycastle.jcajce.util.d dVar, o oVar, j jVar, boolean[] zArr, String str, byte[] bArr) {
        this.bcHelper = dVar;
        this.f45075c = oVar;
        this.basicConstraints = jVar;
        this.keyUsage = zArr;
        this.sigAlgName = str;
        this.sigAlgParams = bArr;
    }

    private void n(PublicKey publicKey, Signature signature, h hVar, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        if (!t(this.f45075c.D(), this.f45075c.H().E())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        g.g(signature, hVar);
        signature.initVerify(publicKey);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(lq.f.b(signature), 512);
            this.f45075c.H().u(bufferedOutputStream, gm.j.f29713a);
            bufferedOutputStream.close();
            if (!signature.verify(bArr)) {
                throw new SignatureException("certificate does not verify with supplied key");
            }
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    private void o(PublicKey publicKey, org.bouncycastle.jcajce.provider.asymmetric.x509.c cVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        boolean z10 = publicKey instanceof CompositePublicKey;
        int i10 = 0;
        if (z10 && g.d(this.f45075c.D())) {
            List<PublicKey> listA = ((CompositePublicKey) publicKey).a();
            f0 f0VarJ = f0.J(this.f45075c.D().A());
            f0 f0VarJ2 = f0.J(u1.S(this.f45075c.C()).H());
            boolean z11 = false;
            while (i10 != listA.size()) {
                if (listA.get(i10) != null) {
                    zn.b bVarZ = zn.b.z(f0VarJ.K(i10));
                    try {
                        n(listA.get(i10), cVar.a(g.c(bVarZ)), bVarZ.A(), u1.S(f0VarJ2.K(i10)).H());
                        e = null;
                        z11 = true;
                    } catch (SignatureException e10) {
                        e = e10;
                    }
                    if (e != null) {
                        throw e;
                    }
                }
                i10++;
            }
            if (!z11) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        if (!g.d(this.f45075c.D())) {
            Signature signatureA = cVar.a(g.c(this.f45075c.D()));
            if (!z10) {
                n(publicKey, signatureA, this.f45075c.D().A(), getSignature());
                return;
            }
            List<PublicKey> listA2 = ((CompositePublicKey) publicKey).a();
            while (i10 != listA2.size()) {
                try {
                    n(listA2.get(i10), signatureA, this.f45075c.D().A(), getSignature());
                    return;
                } catch (InvalidKeyException unused) {
                    i10++;
                }
            }
            throw new InvalidKeyException("no matching signature found");
        }
        f0 f0VarJ3 = f0.J(this.f45075c.D().A());
        f0 f0VarJ4 = f0.J(u1.S(this.f45075c.C()).H());
        boolean z12 = false;
        while (i10 != f0VarJ4.size()) {
            zn.b bVarZ2 = zn.b.z(f0VarJ3.K(i10));
            try {
                n(publicKey, cVar.a(g.c(bVarZ2)), bVarZ2.A(), u1.S(f0VarJ4.K(i10)).H());
                e = null;
                z12 = true;
            } catch (InvalidKeyException | NoSuchAlgorithmException unused2) {
                e = null;
            } catch (SignatureException e11) {
                e = e11;
            }
            if (e != null) {
                throw e;
            }
            i10++;
        }
        if (!z12) {
            throw new InvalidKeyException("no matching key found");
        }
    }

    public static Collection p(o oVar, String str) throws CertificateParsingException {
        String strD;
        byte[] bArrQ = q(oVar, str);
        if (bArrQ == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration enumerationL = f0.J(bArrQ).L();
            while (enumerationL.hasMoreElements()) {
                b0 b0VarZ = b0.z(enumerationL.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(org.bouncycastle.util.j.g(b0VarZ.q()));
                switch (b0VarZ.q()) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(b0VarZ.getEncoded());
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                        break;
                    case 1:
                    case 2:
                    case 6:
                        strD = ((k0) b0VarZ.A()).d();
                        arrayList2.add(strD);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                        break;
                    case 4:
                        strD = xn.d.B(yn.e.V, b0VarZ.A()).toString();
                        arrayList2.add(strD);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                        break;
                    case 7:
                        try {
                            strD = InetAddress.getByAddress(z.I(b0VarZ.A()).J()).getHostAddress();
                            arrayList2.add(strD);
                            arrayList.add(Collections.unmodifiableList(arrayList2));
                        } catch (UnknownHostException unused) {
                        }
                        break;
                    case 8:
                        strD = y.N(b0VarZ.A()).L();
                        arrayList2.add(strD);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                        break;
                    default:
                        throw new IOException("Bad tag number: " + b0VarZ.q());
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e10) {
            throw new CertificateParsingException(e10.getMessage());
        }
    }

    public static byte[] q(o oVar, String str) {
        z zVarR = r(oVar, str);
        if (zVarR != null) {
            return zVarR.J();
        }
        return null;
    }

    public static z r(o oVar, String str) {
        zn.y yVarZ;
        zn.z zVarY = oVar.H().y();
        if (zVarY == null || (yVarZ = zVarY.z(new y(str))) == null) {
            return null;
        }
        return yVarZ.A();
    }

    @Override // kq.a
    public xn.d a() {
        return this.f45075c.A();
    }

    @Override // kq.a
    public xn.d b() {
        return this.f45075c.F();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.f45075c.x().A());
        }
        if (date.getTime() >= getNotBefore().getTime()) {
            return;
        }
        throw new CertificateNotYetValidException("certificate not valid till " + this.f45075c.E().A());
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        j jVar = this.basicConstraints;
        if (jVar == null || !jVar.B()) {
            return -1;
        }
        if (this.basicConstraints.A() == null) {
            return Integer.MAX_VALUE;
        }
        return this.basicConstraints.A().intValue();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        zn.z zVarY = this.f45075c.H().y();
        if (zVarY == null) {
            return null;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            y yVar = (y) enumerationI.nextElement();
            if (zVarY.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] bArrQ = q(this.f45075c, "2.5.29.37");
        if (bArrQ == null) {
            return null;
        }
        try {
            f0 f0VarJ = f0.J(c0.D(bArrQ));
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 != f0VarJ.size(); i10++) {
                arrayList.add(((y) f0VarJ.K(i10)).L());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        z zVarR = r(this.f45075c, str);
        if (zVarR == null) {
            return null;
        }
        try {
            return zVarR.getEncoded();
        } catch (Exception e10) {
            throw new IllegalStateException("error parsing " + e10.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return p(this.f45075c, zn.y.f59062i.L());
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new org.bouncycastle.jce.j(this.f45075c.A());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        gm.d dVarC = this.f45075c.H().C();
        if (dVarC == null) {
            return null;
        }
        byte[] bArrH = dVarC.H();
        int length = (bArrH.length * 8) - dVarC.m();
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 != length; i10++) {
            zArr[i10] = (bArrH[i10 / 8] & (128 >>> (i10 % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f45075c.A().v(gm.j.f29713a));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return org.bouncycastle.util.a.x(this.keyUsage);
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        zn.z zVarY = this.f45075c.H().y();
        if (zVarY == null) {
            return null;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            y yVar = (y) enumerationI.nextElement();
            if (!zVarY.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f45075c.x().x();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f45075c.E().x();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.p(this.f45075c.G());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f45075c.B().K();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f45075c.D().x().L();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return org.bouncycastle.util.a.p(this.sigAlgParams);
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f45075c.C().L();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return p(this.f45075c, zn.y.f59061h.L());
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new org.bouncycastle.jce.j(this.f45075c.F());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        gm.d dVarI = this.f45075c.H().I();
        if (dVarI == null) {
            return null;
        }
        byte[] bArrH = dVarI.H();
        int length = (bArrH.length * 8) - dVarI.m();
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 != length; i10++) {
            zArr[i10] = (bArrH[i10 / 8] & (128 >>> (i10 % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        try {
            return new X500Principal(this.f45075c.F().v(gm.j.f29713a));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode subject DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f45075c.H().v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f45075c.J();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        zn.z zVarY;
        if (getVersion() != 3 || (zVarY = this.f45075c.H().y()) == null) {
            return false;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            y yVar = (y) enumerationI.nextElement();
            if (!yVar.C(zn.y.f59059f) && !yVar.C(zn.y.f59075t) && !yVar.C(zn.y.f59076u) && !yVar.C(zn.y.f59082z) && !yVar.C(zn.y.f59074s) && !yVar.C(zn.y.f59071p) && !yVar.C(zn.y.f59070o) && !yVar.C(zn.y.f59079w) && !yVar.C(zn.y.f59063j) && !yVar.C(zn.y.f59061h) && !yVar.C(zn.y.f59073r) && zVarY.z(yVar).D()) {
                return true;
            }
        }
        return false;
    }

    @Override // kq.a
    public e1 l() {
        return this.f45075c.H();
    }

    public final boolean t(zn.b bVar, zn.b bVar2) {
        if (!bVar.x().C(bVar2.x())) {
            return false;
        }
        if (p.d("org.bouncycastle.x509.allow_absent_equiv_NULL")) {
            if (bVar.A() == null) {
                return bVar2.A() == null || bVar2.A().equals(d2.f29657b);
            }
            if (bVar2.A() == null) {
                return bVar.A() == null || bVar.A().equals(d2.f29657b);
            }
        }
        if (bVar.A() != null) {
            return bVar.A().equals(bVar2.A());
        }
        if (bVar2.A() != null) {
            return bVar2.A().equals(bVar.A());
        }
        return true;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        Object gVar;
        StringBuffer stringBuffer = new StringBuffer();
        String strE = Strings.e();
        stringBuffer.append("  [0]         Version: ");
        stringBuffer.append(getVersion());
        stringBuffer.append(strE);
        stringBuffer.append("         SerialNumber: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(strE);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(strE);
        stringBuffer.append("           Start Date: ");
        stringBuffer.append(getNotBefore());
        stringBuffer.append(strE);
        stringBuffer.append("           Final Date: ");
        stringBuffer.append(getNotAfter());
        stringBuffer.append(strE);
        stringBuffer.append("            SubjectDN: ");
        stringBuffer.append(getSubjectDN());
        stringBuffer.append(strE);
        stringBuffer.append("           Public Key: ");
        stringBuffer.append(getPublicKey());
        stringBuffer.append(strE);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(strE);
        g.f(getSignature(), stringBuffer, strE);
        zn.z zVarY = this.f45075c.H().y();
        if (zVarY != null) {
            Enumeration enumerationI = zVarY.I();
            if (enumerationI.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (enumerationI.hasMoreElements()) {
                y yVar = (y) enumerationI.nextElement();
                zn.y yVarZ = zVarY.z(yVar);
                if (yVarZ.A() != null) {
                    s sVar = new s(yVarZ.A().J());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(yVarZ.D());
                    stringBuffer.append(") ");
                    try {
                    } catch (Exception unused) {
                        stringBuffer.append(yVar.L());
                        stringBuffer.append(" value = ");
                        stringBuffer.append("*****");
                        stringBuffer.append(strE);
                    }
                    if (yVar.C(zn.y.f59063j)) {
                        gVar = j.z(sVar.n());
                    } else if (yVar.C(zn.y.f59059f)) {
                        gVar = zn.k0.z(sVar.n());
                    } else if (yVar.C(in.c.f32546b)) {
                        gVar = new in.d(u1.S(sVar.n()));
                    } else if (yVar.C(in.c.f32548d)) {
                        gVar = new in.e(r.I(sVar.n()));
                    } else if (yVar.C(in.c.f32555k)) {
                        gVar = new in.g(r.I(sVar.n()));
                    } else {
                        stringBuffer.append(yVar.L());
                        stringBuffer.append(" value = ");
                        stringBuffer.append(wn.a.c(sVar.n()));
                        stringBuffer.append(strE);
                    }
                    stringBuffer.append(gVar);
                    stringBuffer.append(strE);
                }
                stringBuffer.append(strE);
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        o(publicKey, new a());
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        o(publicKey, new b(str));
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey publicKey, Provider provider) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        try {
            o(publicKey, new c(provider));
        } catch (NoSuchProviderException e10) {
            throw new NoSuchAlgorithmException("provider issue: " + e10.getMessage());
        }
    }
}
