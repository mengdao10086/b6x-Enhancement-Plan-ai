package org.bouncycastle.x509;

import gm.f0;
import gm.j2;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.h0;
import zn.d1;
import zn.j1;
import zn.o1;
import zn.u1;
import zn.v1;
import zn.w1;

/* JADX INFO: loaded from: classes6.dex */
public class X509V2CRLGenerator {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.y f46070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public zn.b f46071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f46072e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f46068a = new org.bouncycastle.jcajce.util.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o1 f46069b = new o1();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v1 f46073f = new v1();

    public static class ExtCRLException extends CRLException {
        public Throwable cause;

        public ExtCRLException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public void a(X509CRL x509crl) throws CRLException {
        Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
        if (revokedCertificates != null) {
            Iterator<? extends X509CRLEntry> it2 = revokedCertificates.iterator();
            while (it2.hasNext()) {
                try {
                    this.f46069b.e(f0.J(new gm.s(it2.next().getEncoded()).n()));
                } catch (IOException e10) {
                    throw new CRLException("exception processing encoding of CRL: " + e10.toString());
                }
            }
        }
    }

    public void b(BigInteger bigInteger, Date date, int i10) {
        this.f46069b.b(new gm.t(bigInteger), new j1(date), i10);
    }

    public void c(BigInteger bigInteger, Date date, int i10, Date date2) {
        this.f46069b.c(new gm.t(bigInteger), new j1(date), i10, new gm.o(date2));
    }

    public void d(BigInteger bigInteger, Date date, u1 u1Var) {
        this.f46069b.d(new gm.t(bigInteger), new j1(date), zn.z.G(u1Var));
    }

    public void e(gm.y yVar, boolean z10, gm.h hVar) {
        this.f46073f.a(new gm.y(yVar.L()), z10, hVar);
    }

    public void f(gm.y yVar, boolean z10, byte[] bArr) {
        this.f46073f.b(new gm.y(yVar.L()), z10, bArr);
    }

    public void g(String str, boolean z10, gm.h hVar) {
        e(new gm.y(str), z10, hVar);
    }

    public void h(String str, boolean z10, byte[] bArr) {
        f(new gm.y(str), z10, bArr);
    }

    public X509CRL i(PrivateKey privateKey) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        return l(privateKey, null);
    }

    public X509CRL j(PrivateKey privateKey, String str) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException, NoSuchProviderException {
        return k(privateKey, str, null);
    }

    public X509CRL k(PrivateKey privateKey, String str, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException, NoSuchProviderException {
        d1 d1VarM = m();
        try {
            return n(d1VarM, w.a(this.f46070c, this.f46072e, str, privateKey, secureRandom, d1VarM));
        } catch (IOException e10) {
            throw new ExtCRLException("cannot generate CRL encoding", e10);
        }
    }

    public X509CRL l(PrivateKey privateKey, SecureRandom secureRandom) throws IllegalStateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException, CRLException {
        d1 d1VarM = m();
        try {
            return n(d1VarM, w.b(this.f46070c, this.f46072e, privateKey, secureRandom, d1VarM));
        } catch (IOException e10) {
            throw new ExtCRLException("cannot generate CRL encoding", e10);
        }
    }

    public final d1 m() {
        if (!this.f46073f.d()) {
            this.f46069b.k(this.f46073f.c());
        }
        return this.f46069b.h();
    }

    public final X509CRL n(d1 d1Var, byte[] bArr) throws CRLException {
        gm.i iVar = new gm.i();
        iVar.a(d1Var);
        iVar.a(this.f46071d);
        iVar.a(new gm.u1(bArr));
        return new h0(zn.p.y(new j2(iVar)));
    }

    public X509CRL o(PrivateKey privateKey) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return q(privateKey, BouncyCastleProvider.f45329b, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public X509CRL p(PrivateKey privateKey, String str) throws SignatureException, SecurityException, InvalidKeyException, NoSuchProviderException {
        return q(privateKey, str, null);
    }

    public X509CRL q(PrivateKey privateKey, String str, SecureRandom secureRandom) throws SignatureException, InvalidKeyException, SecurityException, NoSuchProviderException {
        try {
            return k(privateKey, str, secureRandom);
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

    public X509CRL r(PrivateKey privateKey, SecureRandom secureRandom) throws SignatureException, SecurityException, InvalidKeyException {
        try {
            return q(privateKey, BouncyCastleProvider.f45329b, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator s() {
        return w.e();
    }

    public void t() {
        this.f46069b = new o1();
        this.f46073f.e();
    }

    public void u(X500Principal x500Principal) {
        try {
            this.f46069b.m(new org.bouncycastle.jce.j(x500Principal.getEncoded()));
        } catch (IOException e10) {
            throw new IllegalArgumentException("can't process principal: " + e10);
        }
    }

    public void v(w1 w1Var) {
        this.f46069b.m(w1Var);
    }

    public void w(Date date) {
        this.f46069b.o(new j1(date));
    }

    public void x(String str) {
        this.f46072e = str;
        try {
            gm.y yVarF = w.f(str);
            this.f46070c = yVarF;
            zn.b bVarJ = w.j(yVarF, str);
            this.f46071d = bVarJ;
            this.f46069b.p(bVarJ);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void y(Date date) {
        this.f46069b.r(new j1(date));
    }
}
