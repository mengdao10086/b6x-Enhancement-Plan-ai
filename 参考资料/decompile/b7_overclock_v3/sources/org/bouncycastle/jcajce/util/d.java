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
import java.security.NoSuchProviderException;
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
public interface d {
    Signature a(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyFactory b(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertStore c(String str, CertStoreParameters certStoreParameters) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException;

    KeyPairGenerator d(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    SecureRandom e(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    MessageDigest g(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    KeyGenerator h(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    Cipher i(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException;

    KeyStore j(String str) throws KeyStoreException, NoSuchProviderException;

    KeyAgreement k(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    MessageDigest l(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    Mac n(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    ExemptionMechanism p(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    AlgorithmParameterGenerator q(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertPathValidator r(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertificateFactory s(String str) throws CertificateException, NoSuchProviderException;

    AlgorithmParameters t(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    SecretKeyFactory u(String str) throws NoSuchAlgorithmException, NoSuchProviderException;

    CertPathBuilder v(String str) throws NoSuchAlgorithmException, NoSuchProviderException;
}
