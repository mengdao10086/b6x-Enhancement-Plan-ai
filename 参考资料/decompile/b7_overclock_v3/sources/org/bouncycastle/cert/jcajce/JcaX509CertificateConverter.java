package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.cert.X509CertificateHolder;

/* JADX INFO: loaded from: classes5.dex */
public class JcaX509CertificateConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f44482a;

    public class ExCertificateException extends CertificateException {
        private Throwable cause;

        public ExCertificateException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public class ExCertificateParsingException extends CertificateParsingException {
        private Throwable cause;

        public ExCertificateParsingException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public JcaX509CertificateConverter() {
        this.f44482a = new b();
        this.f44482a = new b();
    }

    public X509Certificate a(X509CertificateHolder x509CertificateHolder) throws CertificateException {
        try {
            return (X509Certificate) this.f44482a.b("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e10) {
            throw new ExCertificateParsingException("exception parsing certificate: " + e10.getMessage(), e10);
        } catch (NoSuchProviderException e11) {
            throw new ExCertificateException("cannot find required provider:" + e11.getMessage(), e11);
        }
    }

    public JcaX509CertificateConverter b(String str) {
        this.f44482a = new m(str);
        return this;
    }

    public JcaX509CertificateConverter c(Provider provider) {
        this.f44482a = new n(provider);
        return this;
    }
}
