package org.bouncycastle.cms.jcajce;

import gm.f2;
import gm.j2;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import org.bouncycastle.cms.CMSException;
import so.e1;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends e1 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static l0 f44501m = new o0();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cs.f0 f44502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f44503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f44504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PublicKey f44505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PrivateKey f44506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c f44507i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public SecureRandom f44508j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public KeyPair f44509k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f44510l;

    public a0(gm.y yVar, PrivateKey privateKey, PublicKey publicKey, gm.y yVar2) {
        super(yVar, c1.A(publicKey.getEncoded()), yVar2);
        this.f44502d = new cs.k();
        this.f44503e = new ArrayList();
        this.f44504f = new ArrayList();
        this.f44507i = new c(new b());
        this.f44505g = publicKey;
        this.f44506h = a.a(privateKey);
    }

    @Override // so.e1
    public gm.f0 c(zn.b bVar, zn.b bVar2, cs.q qVar) throws CMSException {
        cr.w wVar;
        AlgorithmParameterSpec nVar;
        f2 f2Var;
        if (this.f44503e.isEmpty()) {
            throw new CMSException("No recipients associated with generator - use addRecipient()");
        }
        g(bVar.x());
        PrivateKey privateKey = this.f44506h;
        gm.y yVarX = bVar.x();
        gm.i iVar = new gm.i();
        for (int i10 = 0; i10 != this.f44503e.size(); i10++) {
            PublicKey publicKey = (PublicKey) this.f44504f.get(i10);
            mm.b0 b0Var = (mm.b0) this.f44503e.get(i10);
            try {
                gm.y yVarX2 = bVar2.x();
                if (a.i(yVarX)) {
                    nVar = new cr.n(this.f44509k, publicKey, this.f44510l);
                } else {
                    if (a.g(yVarX)) {
                        wVar = new cr.w(f44501m.a(bVar2, this.f44502d.b(yVarX2), this.f44510l));
                    } else if (a.j(yVarX)) {
                        byte[] bArr = this.f44510l;
                        if (bArr != null) {
                            wVar = new cr.w(bArr);
                        } else {
                            if (yVarX.C(pn.s.f46844s6)) {
                                throw new CMSException("User keying material must be set for static keys.");
                            }
                            nVar = null;
                        }
                    } else {
                        if (!a.h(yVarX)) {
                            throw new CMSException("Unknown key agreement algorithm: " + yVarX);
                        }
                        byte[] bArr2 = this.f44510l;
                        if (bArr2 == null) {
                            throw new CMSException("User keying material must be set for static keys.");
                        }
                        wVar = new cr.w(bArr2);
                    }
                    nVar = wVar;
                }
                KeyAgreement keyAgreementI = this.f44507i.i(yVarX);
                keyAgreementI.init(privateKey, nVar, this.f44508j);
                keyAgreementI.doPhase(publicKey, true);
                SecretKey secretKeyGenerateSecret = keyAgreementI.generateSecret(yVarX2.L());
                Cipher cipherF = this.f44507i.f(yVarX2);
                if (yVarX2.C(qm.a.f47454d) || yVarX2.C(qm.a.f47455e)) {
                    cipherF.init(3, secretKeyGenerateSecret, new cr.k(qm.a.f47458h, this.f44510l));
                    byte[] bArrWrap = cipherF.wrap(this.f44507i.v(qVar));
                    f2Var = new f2(new qm.h(org.bouncycastle.util.a.W(bArrWrap, 0, bArrWrap.length - 4), org.bouncycastle.util.a.W(bArrWrap, bArrWrap.length - 4, bArrWrap.length)).v(gm.j.f29713a));
                } else {
                    cipherF.init(3, secretKeyGenerateSecret, this.f44508j);
                    f2Var = new f2(cipherF.wrap(this.f44507i.v(qVar)));
                }
                iVar.a(new mm.m0(b0Var, f2Var));
            } catch (IOException e10) {
                throw new CMSException("unable to encode wrapped key: " + e10.getMessage(), e10);
            } catch (GeneralSecurityException e11) {
                throw new CMSException("cannot perform agreement step: " + e11.getMessage(), e11);
            }
        }
        return new j2(iVar);
    }

    @Override // so.e1
    public byte[] d(zn.b bVar) throws CMSException {
        g(bVar.x());
        KeyPair keyPair = this.f44509k;
        if (keyPair == null) {
            return this.f44510l;
        }
        mm.h0 h0VarB = b(c1.A(keyPair.getPublic().getEncoded()));
        try {
            return this.f44510l != null ? new nm.b(h0VarB, new f2(this.f44510l)).getEncoded() : new nm.b(h0VarB, null).getEncoded();
        } catch (IOException e10) {
            throw new CMSException("unable to encode user keying material: " + e10.getMessage(), e10);
        }
    }

    public a0 e(X509Certificate x509Certificate) throws CertificateEncodingException {
        this.f44503e.add(new mm.b0(a.e(x509Certificate)));
        this.f44504f.add(x509Certificate.getPublicKey());
        return this;
    }

    public a0 f(byte[] bArr, PublicKey publicKey) throws CertificateEncodingException {
        this.f44503e.add(new mm.b0(new mm.p0(bArr)));
        this.f44504f.add(publicKey);
        return this;
    }

    public final void g(gm.y yVar) throws CMSException {
        if (this.f44508j == null) {
            this.f44508j = new SecureRandom();
        }
        if (a.i(yVar) && this.f44509k == null) {
            try {
                c1 c1VarA = c1.A(this.f44505g.getEncoded());
                AlgorithmParameters algorithmParametersC = this.f44507i.c(yVar);
                algorithmParametersC.init(c1VarA.x().A().b().getEncoded());
                KeyPairGenerator keyPairGeneratorL = this.f44507i.l(yVar);
                keyPairGeneratorL.initialize(algorithmParametersC.getParameterSpec(AlgorithmParameterSpec.class), this.f44508j);
                this.f44509k = keyPairGeneratorL.generateKeyPair();
            } catch (Exception e10) {
                throw new CMSException("cannot determine MQV ephemeral key pair parameters from public key: " + e10, e10);
            }
        }
    }

    public a0 h(String str) {
        this.f44507i = new c(new m0(str));
        return this;
    }

    public a0 i(Provider provider) {
        this.f44507i = new c(new n0(provider));
        return this;
    }

    public a0 j(SecureRandom secureRandom) {
        this.f44508j = secureRandom;
        return this;
    }

    public a0 k(byte[] bArr) {
        this.f44510l = org.bouncycastle.util.a.p(bArr);
        return this;
    }
}
