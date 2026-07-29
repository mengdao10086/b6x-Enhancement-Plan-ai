package org.bouncycastle.x509;

import gm.j2;
import gm.u1;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.c1;
import zn.e1;
import zn.j1;
import zn.p1;
import zn.v1;
import zn.w1;

/* JADX INFO: loaded from: classes6.dex */
public class z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.y f46162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f46163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f46164f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f46159a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateFactory f46160b = new CertificateFactory();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p1 f46161c = new p1();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v1 f46165g = new v1();

    public void A(String str) {
        this.f46164f = str;
        try {
            gm.y yVarF = w.f(str);
            this.f46162d = yVarF;
            zn.b bVarJ = w.j(yVarF, str);
            this.f46163e = bVarJ;
            this.f46161c.j(bVarJ);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested: " + str);
        }
    }

    public void B(X500Principal x500Principal) {
        try {
            this.f46161c.n(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't process principal: " + e10);
        }
    }

    public void C(w1 w1Var) {
        this.f46161c.n(w1Var);
    }

    public void D(boolean[] zArr) {
        this.f46161c.p(e(zArr));
    }

    public void a(gm.y yVar, boolean z10, gm.h hVar) {
        this.f46165g.a(new gm.y(yVar.L()), z10, hVar);
    }

    public void b(gm.y yVar, boolean z10, byte[] bArr) {
        this.f46165g.b(new gm.y(yVar.L()), z10, bArr);
    }

    public void c(String str, boolean z10, gm.h hVar) {
        a(new gm.y(str), z10, hVar);
    }

    public void d(String str, boolean z10, byte[] bArr) {
        b(new gm.y(str), z10, bArr);
    }

    public final u1 e(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i10 = 0; i10 != zArr.length; i10++) {
            int i11 = i10 / 8;
            bArr[i11] = (byte) (bArr[i11] | (zArr[i10] ? 1 << (7 - (i10 % 8)) : 0));
        }
        int length = zArr.length % 8;
        return length == 0 ? new u1(bArr) : new u1(bArr, 8 - length);
    }

    public void f(gm.y yVar, boolean z10, X509Certificate x509Certificate) throws CertificateParsingException {
        g(yVar.L(), z10, x509Certificate);
    }

    public void g(String str, boolean z10, X509Certificate x509Certificate) throws CertificateParsingException {
        byte[] extensionValue = x509Certificate.getExtensionValue(str);
        if (extensionValue != null) {
            try {
                c(str, z10, nt.b.a(extensionValue));
            } catch (IOException e10) {
                throw new CertificateParsingException(e10.toString());
            }
        } else {
            throw new CertificateParsingException("extension " + str + " not present");
        }
    }

    public X509Certificate h(PrivateKey privateKey) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateEncodingException {
        return k(privateKey, null);
    }

    public X509Certificate i(PrivateKey privateKey, String str) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException, CertificateEncodingException {
        return j(privateKey, str, null);
    }

    public X509Certificate j(PrivateKey privateKey, String str, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException, CertificateEncodingException {
        e1 e1VarM = m();
        try {
            try {
                return l(e1VarM, w.a(this.f46162d, this.f46164f, str, privateKey, secureRandom, e1VarM));
            } catch (Exception e10) {
                throw new ExtCertificateEncodingException("exception producing certificate object", e10);
            }
        } catch (IOException e11) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e11);
        }
    }

    public X509Certificate k(PrivateKey privateKey, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateEncodingException {
        e1 e1VarM = m();
        try {
            try {
                return l(e1VarM, w.b(this.f46162d, this.f46164f, privateKey, secureRandom, e1VarM));
            } catch (Exception e10) {
                throw new ExtCertificateEncodingException("exception producing certificate object", e10);
            }
        } catch (IOException e11) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e11);
        }
    }

    public final X509Certificate l(e1 e1Var, byte[] bArr) throws Exception {
        gm.i iVar = new gm.i();
        iVar.a(e1Var);
        iVar.a(this.f46163e);
        iVar.a(new u1(bArr));
        return (X509Certificate) this.f46160b.engineGenerateCertificate(new ByteArrayInputStream(new j2(iVar).v(gm.j.f29713a)));
    }

    public final e1 m() {
        if (!this.f46165g.d()) {
            this.f46161c.e(this.f46165g.c());
        }
        return this.f46161c.a();
    }

    public X509Certificate n(PrivateKey privateKey) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return p(privateKey, BouncyCastleProvider.f45329b, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate o(PrivateKey privateKey, String str) throws SignatureException, SecurityException, InvalidKeyException, NoSuchProviderException {
        return p(privateKey, str, null);
    }

    public X509Certificate p(PrivateKey privateKey, String str, SecureRandom secureRandom) throws SignatureException, InvalidKeyException, SecurityException, NoSuchProviderException {
        try {
            return j(privateKey, str, secureRandom);
        } catch (InvalidKeyException e10) {
            throw e10;
        } catch (NoSuchProviderException e11) {
            throw e11;
        } catch (SignatureException e12) {
            throw e12;
        } catch (GeneralSecurityException e13) {
            throw new SecurityException("exception: " + e13);
        }
    }

    public X509Certificate q(PrivateKey privateKey, SecureRandom secureRandom) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return p(privateKey, BouncyCastleProvider.f45329b, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator r() {
        return w.e();
    }

    public void s() {
        this.f46161c = new p1();
        this.f46165g.e();
    }

    public void t(X500Principal x500Principal) {
        try {
            this.f46161c.g(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't process principal: " + e10);
        }
    }

    public void u(w1 w1Var) {
        this.f46161c.g(w1Var);
    }

    public void v(boolean[] zArr) {
        this.f46161c.h(e(zArr));
    }

    public void w(Date date) {
        this.f46161c.c(new j1(date));
    }

    public void x(Date date) {
        this.f46161c.l(new j1(date));
    }

    public void y(PublicKey publicKey) throws IllegalArgumentException {
        try {
            this.f46161c.o(c1.A(new gm.s(publicKey.getEncoded()).n()));
        } catch (Exception e10) {
            throw new IllegalArgumentException("unable to process key - " + e10.toString());
        }
    }

    public void z(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("serial number must be a positive integer");
        }
        this.f46161c.i(new gm.t(bigInteger));
    }
}
