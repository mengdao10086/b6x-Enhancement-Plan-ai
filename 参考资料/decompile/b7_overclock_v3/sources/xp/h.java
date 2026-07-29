package xp;

import java.net.Socket;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.est.m;
import org.bouncycastle.est.n;

/* JADX INFO: loaded from: classes5.dex */
public class h extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f55745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f55746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f55747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public xp.a f55748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Set<String> f55749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f55750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public l f55751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f55752k;

    public class a implements xp.a {
        public a() {
        }

        @Override // xp.a
        public boolean a(Socket socket) {
            return false;
        }

        @Override // xp.a
        public byte[] b(Socket socket, String str) {
            return null;
        }
    }

    public h(String str) {
        super(str);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        this.f55751j = new l(f.c());
    }

    public h(String str, int i10, X509TrustManager x509TrustManager) {
        super(str + ":" + i10);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        this.f55751j = new l(x509TrustManager);
    }

    public h(String str, int i10, k kVar) {
        super(str + ":" + i10);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        Objects.requireNonNull(kVar, "No socket factory creator.");
        this.f55745d = kVar;
    }

    public h(String str, int i10, X509TrustManager[] x509TrustManagerArr) {
        this(str + ":" + i10, x509TrustManagerArr);
    }

    public h(String str, X509TrustManager x509TrustManager) {
        super(str);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        this.f55751j = new l(x509TrustManager);
    }

    public h(String str, k kVar) {
        super(str);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        Objects.requireNonNull(kVar, "No socket factory creator.");
        this.f55745d = kVar;
    }

    public h(String str, X509TrustManager[] x509TrustManagerArr) {
        super(str);
        this.f55746e = new g(null);
        this.f55747f = 0;
        this.f55749h = new HashSet();
        this.f55752k = true;
        this.f55751j = new l(x509TrustManagerArr);
    }

    @Override // org.bouncycastle.est.n
    public m a() {
        if (this.f55748g == null) {
            this.f55748g = new a();
        }
        if (this.f55745d == null) {
            this.f55745d = this.f55751j.a();
        }
        if (this.f44840b == null) {
            this.f44840b = new d(this.f55746e, this.f55745d, this.f55747f, this.f55748g, this.f55749h, this.f55750i, this.f55752k);
        }
        return super.a();
    }

    public h d(String str) {
        this.f55749h.add(str);
        return this;
    }

    public h e(String[] strArr) {
        this.f55749h.addAll(Arrays.asList(strArr));
        return this;
    }

    public h f(xp.a aVar) {
        this.f55748g = aVar;
        return this;
    }

    @Override // org.bouncycastle.est.n
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public h b(org.bouncycastle.est.g gVar) {
        this.f44840b = gVar;
        return this;
    }

    public h h(boolean z10) {
        this.f55752k = z10;
        return this;
    }

    public h i(i iVar) {
        this.f55746e = iVar;
        return this;
    }

    public h j(KeyManager keyManager) {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.b(keyManager);
        return this;
    }

    public h k(KeyManager[] keyManagerArr) {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.c(keyManagerArr);
        return this;
    }

    public h l(String str) throws NoSuchProviderException {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.d(str);
        return this;
    }

    public h m(Provider provider) {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.e(provider);
        return this;
    }

    public h n(long j10) {
        this.f55750i = Long.valueOf(j10);
        return this;
    }

    public h o(SecureRandom secureRandom) {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.f(secureRandom);
        return this;
    }

    public h p(String str) {
        if (this.f55745d != null) {
            throw new IllegalStateException("Socket Factory Creator was defined in the constructor.");
        }
        this.f55751j.g(str);
        return this;
    }

    public h q(int i10) {
        this.f55747f = i10;
        return this;
    }
}
