package org.bouncycastle.jcajce.util;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathValidator;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import javax.crypto.Cipher;
import javax.crypto.ExemptionMechanism;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;

/* JADX INFO: loaded from: classes5.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider f45255a;

    public i(Provider provider) {
        this.f45255a = provider;
    }

    @Override // org.bouncycastle.jcajce.util.d
    public Signature a(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public KeyFactory b(String str) throws NoSuchAlgorithmException {
        return KeyFactory.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public CertStore c(String str, CertStoreParameters certStoreParameters) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        return CertStore.getInstance(str, certStoreParameters, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public KeyPairGenerator d(String str) throws NoSuchAlgorithmException {
        return KeyPairGenerator.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public SecureRandom e(String str) throws NoSuchAlgorithmException {
        return SecureRandom.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public MessageDigest g(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public KeyGenerator h(String str) throws NoSuchAlgorithmException {
        return KeyGenerator.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public Cipher i(String str) throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public KeyStore j(String str) throws KeyStoreException {
        return KeyStore.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public KeyAgreement k(String str) throws NoSuchAlgorithmException {
        return KeyAgreement.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public MessageDigest l(String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public Mac n(String str) throws NoSuchAlgorithmException {
        return Mac.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public ExemptionMechanism p(String str) throws NoSuchAlgorithmException {
        return ExemptionMechanism.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public AlgorithmParameterGenerator q(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameterGenerator.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public CertPathValidator r(String str) throws NoSuchAlgorithmException {
        return CertPathValidator.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public CertificateFactory s(String str) throws CertificateException {
        return CertificateFactory.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public AlgorithmParameters t(String str) throws NoSuchAlgorithmException {
        return AlgorithmParameters.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public SecretKeyFactory u(String str) throws NoSuchAlgorithmException {
        return SecretKeyFactory.getInstance(str, this.f45255a);
    }

    @Override // org.bouncycastle.jcajce.util.d
    public CertPathBuilder v(String str) throws NoSuchAlgorithmException {
        return CertPathBuilder.getInstance(str, this.f45255a);
    }
}
