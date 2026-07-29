package org.bouncycastle.cert.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.X509CRL;
import org.bouncycastle.cert.X509CRLHolder;

/* JADX INFO: loaded from: classes5.dex */
public class JcaX509CRLConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f44481a;

    public class ExCRLException extends CRLException {
        private Throwable cause;

        public ExCRLException(String str, Throwable th2) {
            super(str);
            this.cause = th2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public JcaX509CRLConverter() {
        this.f44481a = new b();
        this.f44481a = new b();
    }

    public X509CRL a(X509CRLHolder x509CRLHolder) throws CRLException {
        try {
            return (X509CRL) this.f44481a.b("X.509").generateCRL(new ByteArrayInputStream(x509CRLHolder.getEncoded()));
        } catch (IOException e10) {
            throw new ExCRLException("exception parsing certificate: " + e10.getMessage(), e10);
        } catch (NoSuchProviderException e11) {
            throw new ExCRLException("cannot find required provider:" + e11.getMessage(), e11);
        } catch (CertificateException e12) {
            throw new ExCRLException("cannot create factory: " + e12.getMessage(), e12);
        }
    }

    public JcaX509CRLConverter b(String str) {
        this.f44481a = new m(str);
        return this;
    }

    public JcaX509CRLConverter c(Provider provider) {
        this.f44481a = new n(provider);
        return this;
    }
}
