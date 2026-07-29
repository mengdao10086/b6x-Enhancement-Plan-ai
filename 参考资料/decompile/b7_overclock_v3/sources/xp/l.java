package xp;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Objects;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f55757a = "TLS";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Provider f55758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public KeyManager[] f55759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public X509TrustManager[] f55760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SecureRandom f55761e;

    public class a implements k {
        public a() {
        }

        @Override // xp.k
        public boolean a() {
            int i10 = 0;
            while (true) {
                X509TrustManager[] x509TrustManagerArr = l.this.f55760d;
                if (i10 == x509TrustManagerArr.length) {
                    return false;
                }
                if (x509TrustManagerArr[i10].getAcceptedIssuers().length > 0) {
                    return true;
                }
                i10++;
            }
        }

        @Override // xp.k
        public SSLSocketFactory b() throws NoSuchAlgorithmException, KeyManagementException, NoSuchProviderException {
            l lVar = l.this;
            Provider provider = lVar.f55758b;
            String str = lVar.f55757a;
            SSLContext sSLContext = provider != null ? SSLContext.getInstance(str, provider) : SSLContext.getInstance(str);
            l lVar2 = l.this;
            sSLContext.init(lVar2.f55759c, lVar2.f55760d, lVar2.f55761e);
            return sSLContext.getSocketFactory();
        }
    }

    public l(X509TrustManager x509TrustManager) {
        Objects.requireNonNull(x509TrustManager, "Trust managers can not be null");
        this.f55760d = new X509TrustManager[]{x509TrustManager};
    }

    public l(X509TrustManager[] x509TrustManagerArr) {
        Objects.requireNonNull(x509TrustManagerArr, "Trust managers can not be null");
        this.f55760d = x509TrustManagerArr;
    }

    public k a() {
        return new a();
    }

    public l b(KeyManager keyManager) {
        if (keyManager == null) {
            this.f55759c = null;
        } else {
            this.f55759c = new KeyManager[]{keyManager};
        }
        return this;
    }

    public l c(KeyManager[] keyManagerArr) {
        this.f55759c = keyManagerArr;
        return this;
    }

    public l d(String str) throws NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        this.f55758b = provider;
        if (provider != null) {
            return this;
        }
        throw new NoSuchProviderException("JSSE provider not found: " + str);
    }

    public l e(Provider provider) {
        this.f55758b = provider;
        return this;
    }

    public l f(SecureRandom secureRandom) {
        this.f55761e = secureRandom;
        return this;
    }

    public l g(String str) {
        this.f55757a = str;
        return this;
    }
}
