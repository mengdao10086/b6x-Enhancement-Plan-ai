package org.bouncycastle.x509;

import gm.j2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.b0;
import zn.c0;
import zn.f0;
import zn.h0;
import zn.o0;

/* JADX INFO: loaded from: classes6.dex */
public class a implements CertSelector, org.bouncycastle.util.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f46074a;

    public a(int i10, String str, String str2, byte[] bArr) {
        this.f46074a = new f0(new o0(i10, new gm.y(str2), new zn.b(new gm.y(str)), org.bouncycastle.util.a.p(bArr)));
    }

    public a(gm.f0 f0Var) {
        this.f46074a = f0.z(f0Var);
    }

    public a(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            this.f46074a = new f0(new h0(a(org.bouncycastle.jce.g.b(x509Certificate)), new gm.t(x509Certificate.getSerialNumber())));
        } catch (Exception e10) {
            throw new CertificateParsingException(e10.getMessage());
        }
    }

    public a(X500Principal x500Principal) {
        this(w.c(x500Principal));
    }

    public a(X500Principal x500Principal, BigInteger bigInteger) {
        this(w.c(x500Principal), bigInteger);
    }

    public a(org.bouncycastle.jce.j jVar) {
        this.f46074a = new f0(a(jVar));
    }

    public a(org.bouncycastle.jce.j jVar, BigInteger bigInteger) {
        this.f46074a = new f0(new h0(c0.A(new j2(new b0(jVar))), new gm.t(bigInteger)));
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return false;
    }

    public final c0 a(org.bouncycastle.jce.j jVar) {
        return c0.A(new j2(new b0(jVar)));
    }

    public String b() {
        if (this.f46074a.A() != null) {
            return this.f46074a.A().x().x().L();
        }
        return null;
    }

    public int c() {
        if (this.f46074a.A() != null) {
            return this.f46074a.A().y().M();
        }
        return -1;
    }

    @Override // java.security.cert.CertSelector, org.bouncycastle.util.q
    public Object clone() {
        return new a((gm.f0) this.f46074a.b());
    }

    public Principal[] d() {
        if (this.f46074a.y() != null) {
            return i(this.f46074a.y());
        }
        return null;
    }

    public Principal[] e() {
        if (this.f46074a.x() != null) {
            return i(this.f46074a.x().z());
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            return this.f46074a.equals(((a) obj).f46074a);
        }
        return false;
    }

    public final Object[] f(b0[] b0VarArr) {
        ArrayList arrayList = new ArrayList(b0VarArr.length);
        for (int i10 = 0; i10 != b0VarArr.length; i10++) {
            if (b0VarArr[i10].q() == 4) {
                try {
                    arrayList.add(new X500Principal(b0VarArr[i10].A().b().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    public byte[] g() {
        if (this.f46074a.A() != null) {
            return this.f46074a.A().B().H();
        }
        return null;
    }

    public String h() {
        if (this.f46074a.A() == null) {
            return null;
        }
        this.f46074a.A().C().L();
        return null;
    }

    public int hashCode() {
        return this.f46074a.hashCode();
    }

    public final Principal[] i(c0 c0Var) {
        Object[] objArrF = f(c0Var.B());
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 != objArrF.length; i10++) {
            if (objArrF[i10] instanceof Principal) {
                arrayList.add(objArrF[i10]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    public BigInteger j() {
        if (this.f46074a.x() != null) {
            return this.f46074a.x().B().K();
        }
        return null;
    }

    public final boolean k(org.bouncycastle.jce.j jVar, c0 c0Var) {
        b0[] b0VarArrB = c0Var.B();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            b0 b0Var = b0VarArrB[i10];
            if (b0Var.q() == 4) {
                try {
                    if (new org.bouncycastle.jce.j(b0Var.A().b().getEncoded()).equals(jVar)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate certificate) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.f46074a.x() != null) {
            return this.f46074a.x().B().N(x509Certificate.getSerialNumber()) && k(org.bouncycastle.jce.g.b(x509Certificate), this.f46074a.x().z());
        }
        if (this.f46074a.y() != null && k(org.bouncycastle.jce.g.c(x509Certificate), this.f46074a.y())) {
            return true;
        }
        if (this.f46074a.A() != null) {
            MessageDigest messageDigest = MessageDigest.getInstance(b(), BouncyCastleProvider.f45329b);
            int iC = c();
            if (iC == 0) {
                messageDigest.update(certificate.getPublicKey().getEncoded());
            } else if (iC == 1) {
                messageDigest.update(certificate.getEncoded());
            }
            org.bouncycastle.util.a.g(messageDigest.digest(), g());
        }
        return false;
    }
}
