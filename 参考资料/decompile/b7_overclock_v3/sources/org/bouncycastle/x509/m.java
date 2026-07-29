package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;

/* JADX INFO: loaded from: classes6.dex */
public class m extends X509CRLSelector implements org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f46128a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f46129b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f46130c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f46131d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f46132e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public l f46133f;

    public static m b(X509CRLSelector x509CRLSelector) {
        if (x509CRLSelector == null) {
            throw new IllegalArgumentException("cannot create from null selector");
        }
        m mVar = new m();
        mVar.setCertificateChecking(x509CRLSelector.getCertificateChecking());
        mVar.setDateAndTime(x509CRLSelector.getDateAndTime());
        try {
            mVar.setIssuerNames(x509CRLSelector.getIssuerNames());
            mVar.setIssuers(x509CRLSelector.getIssuers());
            mVar.setMaxCRLNumber(x509CRLSelector.getMaxCRL());
            mVar.setMinCRLNumber(x509CRLSelector.getMinCRL());
            return mVar;
        } catch (IOException e10) {
            throw new IllegalArgumentException(e10.getMessage());
        }
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        X509CRL x509crl = (X509CRL) obj;
        try {
            byte[] extensionValue = x509crl.getExtensionValue(zn.y.f59070o.L());
            gm.t tVarI = extensionValue != null ? gm.t.I(nt.b.a(extensionValue)) : null;
            if (f() && tVarI == null) {
                return false;
            }
            if (e() && tVarI != null) {
                return false;
            }
            if (tVarI != null && this.f46130c != null && tVarI.J().compareTo(this.f46130c) == 1) {
                return false;
            }
            if (this.f46132e) {
                byte[] extensionValue2 = x509crl.getExtensionValue(zn.y.f59071p.L());
                byte[] bArr = this.f46131d;
                if (bArr == null) {
                    if (extensionValue2 != null) {
                        return false;
                    }
                } else if (!org.bouncycastle.util.a.g(extensionValue2, bArr)) {
                    return false;
                }
            }
            return super.match(x509crl);
        } catch (Exception unused) {
            return false;
        }
    }

    public l a() {
        return this.f46133f;
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f46131d);
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector, org.bouncycastle.util.q
    public Object clone() {
        m mVarB = b(this);
        mVarB.f46128a = this.f46128a;
        mVarB.f46129b = this.f46129b;
        mVarB.f46130c = this.f46130c;
        mVarB.f46133f = this.f46133f;
        mVarB.f46132e = this.f46132e;
        mVarB.f46131d = org.bouncycastle.util.a.p(this.f46131d);
        return mVarB;
    }

    public BigInteger d() {
        return this.f46130c;
    }

    public boolean e() {
        return this.f46129b;
    }

    public boolean f() {
        return this.f46128a;
    }

    public boolean g() {
        return this.f46132e;
    }

    public void h(l lVar) {
        this.f46133f = lVar;
    }

    public void i(boolean z10) {
        this.f46129b = z10;
    }

    public void j(boolean z10) {
        this.f46128a = z10;
    }

    public void k(byte[] bArr) {
        this.f46131d = org.bouncycastle.util.a.p(bArr);
    }

    public void l(boolean z10) {
        this.f46132e = z10;
    }

    public void m(BigInteger bigInteger) {
        this.f46130c = bigInteger;
    }

    @Override // java.security.cert.X509CRLSelector, java.security.cert.CRLSelector
    public boolean match(CRL crl) {
        return M(crl);
    }
}
