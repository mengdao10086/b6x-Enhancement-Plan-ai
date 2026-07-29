package org.bouncycastle.jce.provider;

import gm.d2;
import gm.u1;
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
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
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
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class X509CertificateObject extends X509Certificate implements er.g {
    private er.g attrCarrier = new org.bouncycastle.jcajce.provider.asymmetric.util.m();
    private zn.j basicConstraints;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zn.o f45357c;
    private int hashValue;
    private boolean hashValueSet;
    private boolean[] keyUsage;

    public X509CertificateObject(zn.o oVar) throws CertificateParsingException {
        this.f45357c = oVar;
        try {
            byte[] bArrN = n("2.5.29.19");
            if (bArrN != null) {
                this.basicConstraints = zn.j.z(gm.c0.D(bArrN));
            }
            try {
                byte[] bArrN2 = n("2.5.29.15");
                if (bArrN2 == null) {
                    this.keyUsage = null;
                    return;
                }
                u1 u1VarS = u1.S(gm.c0.D(bArrN2));
                byte[] bArrH = u1VarS.H();
                int length = (bArrH.length * 8) - u1VarS.m();
                int i10 = 9;
                if (length >= 9) {
                    i10 = length;
                }
                this.keyUsage = new boolean[i10];
                for (int i11 = 0; i11 != length; i11++) {
                    this.keyUsage[i11] = (bArrH[i11 / 8] & (128 >>> (i11 % 8))) != 0;
                }
            } catch (Exception e10) {
                throw new CertificateParsingException("cannot construct KeyUsage: " + e10);
            }
        } catch (Exception e11) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e11);
        }
    }

    public static Collection l(byte[] bArr) throws CertificateParsingException {
        String strD;
        if (bArr == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration enumerationL = gm.f0.J(bArr).L();
            while (enumerationL.hasMoreElements()) {
                zn.b0 b0VarZ = zn.b0.z(enumerationL.nextElement());
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
                        strD = ((gm.k0) b0VarZ.A()).d();
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
                            strD = InetAddress.getByAddress(gm.z.I(b0VarZ.A()).J()).getHostAddress();
                            arrayList2.add(strD);
                            arrayList.add(Collections.unmodifiableList(arrayList2));
                        } catch (UnknownHostException unused) {
                        }
                        break;
                    case 8:
                        strD = gm.y.N(b0VarZ.A()).L();
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

    public final int a() {
        try {
            byte[] encoded = getEncoded();
            int i10 = 0;
            for (int i11 = 1; i11 < encoded.length; i11++) {
                i10 += encoded[i11] * i11;
            }
            return i10;
        } catch (CertificateEncodingException unused) {
            return 0;
        }
    }

    public final void b(PublicKey publicKey, Signature signature) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        if (!o(this.f45357c.D(), this.f45357c.H().E())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        m0.c(signature, this.f45357c.D().A());
        signature.initVerify(publicKey);
        signature.update(getTBSCertificate());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("certificate does not verify with supplied key");
        }
    }

    @Override // er.g
    public gm.h c(gm.y yVar) {
        return this.attrCarrier.c(yVar);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.f45357c.x().A());
        }
        if (date.getTime() >= getNotBefore().getTime()) {
            return;
        }
        throw new CertificateNotYetValidException("certificate not valid till " + this.f45357c.E().A());
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Certificate)) {
            return false;
        }
        try {
            return org.bouncycastle.util.a.g(getEncoded(), ((Certificate) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // er.g
    public Enumeration f() {
        return this.attrCarrier.f();
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        zn.j jVar = this.basicConstraints;
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
        zn.z zVarY = this.f45357c.H().y();
        if (zVarY == null) {
            return null;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            if (zVarY.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.f45357c.v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] bArrN = n("2.5.29.37");
        if (bArrN == null) {
            return null;
        }
        try {
            gm.f0 f0Var = (gm.f0) new gm.s(bArrN).n();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 != f0Var.size(); i10++) {
                arrayList.add(((gm.y) f0Var.K(i10)).L());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        zn.y yVarZ;
        zn.z zVarY = this.f45357c.H().y();
        if (zVarY == null || (yVarZ = zVarY.z(new gm.y(str))) == null) {
            return null;
        }
        try {
            return yVarZ.A().getEncoded();
        } catch (Exception e10) {
            throw new IllegalStateException("error parsing " + e10.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return l(n(zn.y.f59062i.L()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new org.bouncycastle.jce.j(this.f45357c.A());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        gm.d dVarC = this.f45357c.H().C();
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
            return new X500Principal(this.f45357c.A().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        zn.z zVarY = this.f45357c.H().y();
        if (zVarY == null) {
            return null;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            if (!zVarY.z(yVar).D()) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f45357c.x().x();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f45357c.E().x();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.p(this.f45357c.G());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f45357c.B().K();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        Provider provider = Security.getProvider(BouncyCastleProvider.f45329b);
        if (provider != null) {
            String property = provider.getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i10 = 0; i10 != providers.length; i10++) {
            String property2 = providers[i10].getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property2 != null) {
                return property2;
            }
        }
        return getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f45357c.D().x().L();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.f45357c.D().A() != null) {
            try {
                return this.f45357c.D().A().b().v(gm.j.f29713a);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f45357c.C().L();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return l(n(zn.y.f59061h.L()));
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new org.bouncycastle.jce.j(this.f45357c.F());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        gm.d dVarI = this.f45357c.H().I();
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
            return new X500Principal(this.f45357c.F().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f45357c.H().v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new CertificateEncodingException(e10.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f45357c.J();
    }

    @Override // er.g
    public void h(gm.y yVar, gm.h hVar) {
        this.attrCarrier.h(yVar, hVar);
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        zn.z zVarY;
        if (getVersion() != 3 || (zVarY = this.f45357c.H().y()) == null) {
            return false;
        }
        Enumeration enumerationI = zVarY.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            String strL = yVar.L();
            if (!strL.equals(b0.f45399n) && !strL.equals(b0.f45387b) && !strL.equals(b0.f45388c) && !strL.equals(b0.f45389d) && !strL.equals(b0.f45395j) && !strL.equals(b0.f45390e) && !strL.equals(b0.f45392g) && !strL.equals(b0.f45393h) && !strL.equals(b0.f45394i) && !strL.equals(b0.f45396k) && !strL.equals(b0.f45397l) && zVarY.z(yVar).D()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.cert.Certificate
    public synchronized int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = a();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    public final byte[] n(String str) {
        zn.y yVarZ;
        zn.z zVarY = this.f45357c.H().y();
        if (zVarY == null || (yVarZ = zVarY.z(new gm.y(str))) == null) {
            return null;
        }
        return yVarZ.A().J();
    }

    public final boolean o(zn.b bVar, zn.b bVar2) {
        if (bVar.x().C(bVar2.x())) {
            return bVar.A() == null ? bVar2.A() == null || bVar2.A().equals(d2.f29657b) : bVar2.A() == null ? bVar.A() == null || bVar.A().equals(d2.f29657b) : bVar.A().equals(bVar2.A());
        }
        return false;
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
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ");
        stringBuffer.append(new String(jt.h.i(signature, 0, 20)));
        stringBuffer.append(strE);
        int i10 = 20;
        while (i10 < signature.length) {
            int length = signature.length - 20;
            stringBuffer.append("                       ");
            stringBuffer.append(i10 < length ? new String(jt.h.i(signature, i10, 20)) : new String(jt.h.i(signature, i10, signature.length - i10)));
            stringBuffer.append(strE);
            i10 += 20;
        }
        zn.z zVarY = this.f45357c.H().y();
        if (zVarY != null) {
            Enumeration enumerationI = zVarY.I();
            if (enumerationI.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
            }
            while (enumerationI.hasMoreElements()) {
                gm.y yVar = (gm.y) enumerationI.nextElement();
                zn.y yVarZ = zVarY.z(yVar);
                if (yVarZ.A() != null) {
                    gm.s sVar = new gm.s(yVarZ.A().J());
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
                        gVar = zn.j.z(sVar.n());
                    } else if (yVar.C(zn.y.f59059f)) {
                        gVar = zn.k0.z(sVar.n());
                    } else if (yVar.C(in.c.f32546b)) {
                        gVar = new in.d((u1) sVar.n());
                    } else if (yVar.C(in.c.f32548d)) {
                        gVar = new in.e((gm.r) sVar.n());
                    } else if (yVar.C(in.c.f32555k)) {
                        gVar = new in.g((gm.r) sVar.n());
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
        Signature signature;
        String strB = m0.b(this.f45357c.D());
        try {
            signature = Signature.getInstance(strB, BouncyCastleProvider.f45329b);
        } catch (Exception unused) {
            signature = Signature.getInstance(strB);
        }
        b(publicKey, signature);
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        String strB = m0.b(this.f45357c.D());
        b(publicKey, str != null ? Signature.getInstance(strB, str) : Signature.getInstance(strB));
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey publicKey, Provider provider) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException {
        String strB = m0.b(this.f45357c.D());
        b(publicKey, provider != null ? Signature.getInstance(strB, provider) : Signature.getInstance(strB));
    }
}
