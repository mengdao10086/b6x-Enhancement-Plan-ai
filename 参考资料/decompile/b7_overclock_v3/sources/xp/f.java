package xp;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CRL;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertStore;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import zn.j0;
import zn.k0;
import zn.x;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    public static class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public static class b implements X509TrustManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f55740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CRL[] f55741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ X509Certificate[] f55742c;

        public b(Set set, CRL[] crlArr, X509Certificate[] x509CertificateArr) {
            this.f55740a = set;
            this.f55741b = crlArr;
            this.f55742c = x509CertificateArr;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                CertStore certStore = CertStore.getInstance("Collection", new CollectionCertStoreParameters(Arrays.asList(x509CertificateArr)), BouncyCastleProvider.f45329b);
                CertPathBuilder certPathBuilder = CertPathBuilder.getInstance("PKIX", BouncyCastleProvider.f45329b);
                X509CertSelector x509CertSelector = new X509CertSelector();
                x509CertSelector.setCertificate(x509CertificateArr[0]);
                PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters((Set<TrustAnchor>) this.f55740a, x509CertSelector);
                pKIXBuilderParameters.addCertStore(certStore);
                if (this.f55741b != null) {
                    pKIXBuilderParameters.setRevocationEnabled(true);
                    pKIXBuilderParameters.addCertStore(CertStore.getInstance("Collection", new CollectionCertStoreParameters(Arrays.asList(this.f55741b))));
                } else {
                    pKIXBuilderParameters.setRevocationEnabled(false);
                }
                f.d(x509CertificateArr[0]);
            } catch (CertificateException e10) {
                throw e10;
            } catch (GeneralSecurityException e11) {
                throw new CertificateException("unable to process certificates: " + e11.getMessage(), e11);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            X509Certificate[] x509CertificateArr = this.f55742c;
            int length = x509CertificateArr.length;
            X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
            System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
            return x509CertificateArr2;
        }
    }

    public static KeyManagerFactory a(String str, String str2, KeyStore keyStore, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, NoSuchProviderException {
        KeyManagerFactory keyManagerFactory;
        if (str != null || str2 != null) {
            if (str2 != null) {
                keyManagerFactory = KeyManagerFactory.getInstance(str, str2);
            }
            keyManagerFactory.init(keyStore, cArr);
            return keyManagerFactory;
        }
        str = KeyManagerFactory.getDefaultAlgorithm();
        keyManagerFactory = KeyManagerFactory.getInstance(str);
        keyManagerFactory.init(keyStore, cArr);
        return keyManagerFactory;
    }

    public static X509TrustManager[] b(Set<TrustAnchor> set, CRL[] crlArr) {
        X509Certificate[] x509CertificateArr = new X509Certificate[set.size()];
        Iterator<TrustAnchor> it2 = set.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            x509CertificateArr[i10] = it2.next().getTrustedCert();
            i10++;
        }
        return new X509TrustManager[]{new b(set, crlArr, x509CertificateArr)};
    }

    public static X509TrustManager c() {
        return new a();
    }

    public static void d(X509Certificate x509Certificate) throws CertificateException {
        try {
            X509CertificateHolder x509CertificateHolder = new X509CertificateHolder(x509Certificate.getEncoded());
            k0 k0VarX = k0.x(x509CertificateHolder.d());
            if (k0VarX != null) {
                if (k0VarX.A(4)) {
                    throw new CertificateException("Key usage must not contain keyCertSign");
                }
                if (!k0VarX.A(128) && !k0VarX.A(32)) {
                    throw new CertificateException("Key usage must be none, digitalSignature or keyEncipherment");
                }
            }
            x xVarX = x.x(x509CertificateHolder.d());
            if (xVarX != null && !xVarX.B(j0.f58778d) && !xVarX.B(j0.f58799y) && !xVarX.B(j0.f58800z)) {
                throw new CertificateException("Certificate extended key usage must include serverAuth, msSGC or nsSGC");
            }
        } catch (CertificateException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new CertificateException(e11.getMessage(), e11);
        }
    }
}
