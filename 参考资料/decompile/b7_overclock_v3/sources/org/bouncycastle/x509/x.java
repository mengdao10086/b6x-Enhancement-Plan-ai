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
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.c1;
import zn.e1;
import zn.j1;
import zn.l1;
import zn.w1;

/* JADX INFO: loaded from: classes6.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f46150a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CertificateFactory f46151b = new CertificateFactory();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l1 f46152c = new l1();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.y f46153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zn.b f46154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f46155f;

    public X509Certificate a(PrivateKey privateKey) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateEncodingException {
        return d(privateKey, null);
    }

    public X509Certificate b(PrivateKey privateKey, String str) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException, CertificateEncodingException {
        return c(privateKey, str, null);
    }

    public X509Certificate c(PrivateKey privateKey, String str, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, NoSuchProviderException, CertificateEncodingException {
        e1 e1VarA = this.f46152c.a();
        try {
            return e(e1VarA, w.a(this.f46153d, this.f46155f, str, privateKey, secureRandom, e1VarA));
        } catch (IOException e10) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e10);
        }
    }

    public X509Certificate d(PrivateKey privateKey, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateEncodingException {
        e1 e1VarA = this.f46152c.a();
        try {
            return e(e1VarA, w.b(this.f46153d, this.f46155f, privateKey, secureRandom, e1VarA));
        } catch (IOException e10) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e10);
        }
    }

    public final X509Certificate e(e1 e1Var, byte[] bArr) throws CertificateEncodingException {
        gm.i iVar = new gm.i();
        iVar.a(e1Var);
        iVar.a(this.f46154e);
        iVar.a(new u1(bArr));
        try {
            return (X509Certificate) this.f46151b.engineGenerateCertificate(new ByteArrayInputStream(new j2(iVar).v(gm.j.f29713a)));
        } catch (Exception e10) {
            throw new ExtCertificateEncodingException("exception producing certificate object", e10);
        }
    }

    public X509Certificate f(PrivateKey privateKey) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return h(privateKey, BouncyCastleProvider.f45329b, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509Certificate g(PrivateKey privateKey, String str) throws SignatureException, SecurityException, InvalidKeyException, NoSuchProviderException {
        return h(privateKey, str, null);
    }

    public X509Certificate h(PrivateKey privateKey, String str, SecureRandom secureRandom) throws SignatureException, InvalidKeyException, SecurityException, NoSuchProviderException {
        try {
            return c(privateKey, str, secureRandom);
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

    public X509Certificate i(PrivateKey privateKey, SecureRandom secureRandom) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return h(privateKey, BouncyCastleProvider.f45329b, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator j() {
        return w.e();
    }

    public void k() {
        this.f46152c = new l1();
    }

    public void l(X500Principal x500Principal) {
        try {
            this.f46152c.e(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't process principal: " + e10);
        }
    }

    public void m(w1 w1Var) {
        this.f46152c.e(w1Var);
    }

    public void n(Date date) {
        this.f46152c.c(new j1(date));
    }

    public void o(Date date) {
        this.f46152c.i(new j1(date));
    }

    public void p(PublicKey publicKey) {
        try {
            this.f46152c.l(c1.A(publicKey.getEncoded()));
        } catch (Exception e10) {
            throw new IllegalArgumentException("unable to process key - " + e10.toString());
        }
    }

    public void q(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("serial number must be a positive integer");
        }
        this.f46152c.f(new gm.t(bigInteger));
    }

    public void r(String str) {
        this.f46155f = str;
        try {
            gm.y yVarF = w.f(str);
            this.f46153d = yVarF;
            zn.b bVarJ = w.j(yVarF, str);
            this.f46154e = bVarJ;
            this.f46152c.g(bVarJ);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void s(X500Principal x500Principal) {
        try {
            this.f46152c.k(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't process principal: " + e10);
        }
    }

    public void t(w1 w1Var) {
        this.f46152c.k(w1Var);
    }
}
