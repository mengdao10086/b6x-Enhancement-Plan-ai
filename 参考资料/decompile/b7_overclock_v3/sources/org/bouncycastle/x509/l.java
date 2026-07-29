package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Extension;
import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public interface l extends X509Extension {
    void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException;

    void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException;

    j[] d();

    byte[] getEncoded() throws IOException;

    boolean[] getIssuerUniqueID();

    Date getNotAfter();

    Date getNotBefore();

    BigInteger getSerialNumber();

    byte[] getSignature();

    int getVersion();

    a i();

    j[] k(String str);

    b m();

    void verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException;
}
