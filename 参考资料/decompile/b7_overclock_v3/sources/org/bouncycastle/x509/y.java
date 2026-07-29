package org.bouncycastle.x509;

import gm.f0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class y implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.f f46156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Date f46157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Date f46158c;

    public y(InputStream inputStream) throws IOException {
        this(b(inputStream));
    }

    public y(zn.f fVar) throws IOException {
        this.f46156a = fVar;
        try {
            this.f46158c = fVar.x().x().y().K();
            this.f46157b = fVar.x().x().z().K();
        } catch (ParseException unused) {
            throw new IOException("invalid data structure in certificate!");
        }
    }

    public y(byte[] bArr) throws IOException {
        this(new ByteArrayInputStream(bArr));
    }

    public static zn.f b(InputStream inputStream) throws IOException {
        try {
            return zn.f.y(new gm.s(inputStream).n());
        } catch (IOException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new IOException("exception decoding certificate structure: " + e11.toString());
        }
    }

    public final Set a(boolean z10) {
        zn.z zVarZ = this.f46156a.x().z();
        if (zVarZ == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumerationI = zVarZ.I();
        while (enumerationI.hasMoreElements()) {
            gm.y yVar = (gm.y) enumerationI.nextElement();
            if (zVarZ.z(yVar).D() == z10) {
                hashSet.add(yVar.L());
            }
        }
        return hashSet;
    }

    @Override // org.bouncycastle.x509.l
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        checkValidity(new Date());
    }

    @Override // org.bouncycastle.x509.l
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        if (date.after(getNotAfter())) {
            throw new CertificateExpiredException("certificate expired on " + getNotAfter());
        }
        if (date.before(getNotBefore())) {
            throw new CertificateNotYetValidException("certificate not valid till " + getNotBefore());
        }
    }

    @Override // org.bouncycastle.x509.l
    public j[] d() {
        f0 f0VarY = this.f46156a.x().y();
        j[] jVarArr = new j[f0VarY.size()];
        for (int i10 = 0; i10 != f0VarY.size(); i10++) {
            jVarArr[i10] = new j(f0VarY.K(i10));
        }
        return jVarArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        try {
            return org.bouncycastle.util.a.g(getEncoded(), ((l) obj).getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return a(true);
    }

    @Override // org.bouncycastle.x509.l
    public byte[] getEncoded() throws IOException {
        return this.f46156a.getEncoded();
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        zn.y yVarZ;
        zn.z zVarZ = this.f46156a.x().z();
        if (zVarZ == null || (yVarZ = zVarZ.z(new gm.y(str))) == null) {
            return null;
        }
        try {
            return yVarZ.A().v(gm.j.f29713a);
        } catch (Exception e10) {
            throw new RuntimeException("error encoding " + e10.toString());
        }
    }

    @Override // org.bouncycastle.x509.l
    public boolean[] getIssuerUniqueID() {
        gm.d dVarE = this.f46156a.x().E();
        if (dVarE == null) {
            return null;
        }
        byte[] bArrH = dVarE.H();
        int length = (bArrH.length * 8) - dVarE.m();
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 != length; i10++) {
            zArr[i10] = (bArrH[i10 / 8] & (128 >>> (i10 % 8))) != 0;
        }
        return zArr;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return a(false);
    }

    @Override // org.bouncycastle.x509.l
    public Date getNotAfter() {
        return this.f46158c;
    }

    @Override // org.bouncycastle.x509.l
    public Date getNotBefore() {
        return this.f46157b;
    }

    @Override // org.bouncycastle.x509.l
    public BigInteger getSerialNumber() {
        return this.f46156a.x().F().K();
    }

    @Override // org.bouncycastle.x509.l
    public byte[] getSignature() {
        return this.f46156a.A().L();
    }

    @Override // org.bouncycastle.x509.l
    public int getVersion() {
        return this.f46156a.x().H().Q() + 1;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        return (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) ? false : true;
    }

    public int hashCode() {
        try {
            return org.bouncycastle.util.a.s0(getEncoded());
        } catch (IOException unused) {
            return 0;
        }
    }

    @Override // org.bouncycastle.x509.l
    public a i() {
        return new a((f0) this.f46156a.x().A().b());
    }

    @Override // org.bouncycastle.x509.l
    public j[] k(String str) {
        f0 f0VarY = this.f46156a.x().y();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != f0VarY.size(); i10++) {
            j jVar = new j(f0VarY.K(i10));
            if (jVar.x().equals(str)) {
                arrayList.add(jVar);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return (j[]) arrayList.toArray(new j[arrayList.size()]);
    }

    @Override // org.bouncycastle.x509.l
    public b m() {
        return new b(this.f46156a.x().D());
    }

    @Override // org.bouncycastle.x509.l
    public final void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (!this.f46156a.z().equals(this.f46156a.x().G())) {
            throw new CertificateException("Signature algorithm in certificate info not same as outer certificate");
        }
        Signature signature = Signature.getInstance(this.f46156a.z().x().L(), str);
        signature.initVerify(publicKey);
        try {
            signature.update(this.f46156a.x().getEncoded());
            if (!signature.verify(getSignature())) {
                throw new InvalidKeyException("Public key presented not for certificate signature");
            }
        } catch (IOException unused) {
            throw new SignatureException("Exception encoding certificate info object");
        }
    }
}
