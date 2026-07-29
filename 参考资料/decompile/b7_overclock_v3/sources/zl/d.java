package zl;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0004H\u0016¨\u0006\u001a"}, d2 = {"Lzl/d;", "Lzl/h;", "Ljavax/net/ssl/SSLContext;", "p", "Ljavax/net/ssl/X509TrustManager;", SsManifestParser.e.J, "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", an.aB, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lhk/n;", "protocols", "Lkotlin/z1;", "f", j.f55230b, "trustManager", "q", "<init>", "()V", "a", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final a f58618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f58619h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final Provider f58620f;

    @d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lzl/d$a;", "", "Lzl/d;", "c", "", "major", "minor", "patch", "", "a", "isSupported", "Z", "d", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ boolean b(a aVar, int i10, int i11, int i12, int i13, Object obj) {
            if ((i13 & 2) != 0) {
                i11 = 0;
            }
            if ((i13 & 4) != 0) {
                i12 = 0;
            }
            return aVar.a(i10, i11, i12);
        }

        public final boolean a(int i10, int i11, int i12) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i10 ? version.major() > i10 : version.minor() != i11 ? version.minor() > i11 : version.patch() >= i12;
        }

        @l
        public final d c() {
            u uVar = null;
            if (d()) {
                return new d(uVar);
            }
            return null;
        }

        public final boolean d() {
            return d.f58619h;
        }
    }

    @d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J5\u0010\u000b\u001a\u00020\u00062\u0010\u0010\n\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lzl/d$b;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "", "hostname", "Ljavax/net/ssl/SSLSession;", com.umeng.analytics.pro.d.aw, "", "a", "", "Ljava/security/cert/X509Certificate;", "certs", "b", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b implements ConscryptHostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final b f58621a = new b();

        public final boolean a(@l String str, @l SSLSession sSLSession) {
            return true;
        }

        public boolean b(@l X509Certificate[] x509CertificateArr, @l String str, @l SSLSession sSLSession) {
            return true;
        }
    }

    static {
        a aVar = new a(null);
        f58618g = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.a(2, 1, 0)) {
                    z10 = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f58619h = z10;
    }

    public d() {
        Provider providerNewProvider = Conscrypt.newProvider();
        f0.o(providerNewProvider, "newProvider()");
        this.f58620f = providerNewProvider;
    }

    public /* synthetic */ d(u uVar) {
        this();
    }

    @Override // zl.h
    public void f(@k SSLSocket sslSocket, @l String str, @k List<Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        if (!Conscrypt.isConscrypt(sslSocket)) {
            super.f(sslSocket, str, protocols);
            return;
        }
        Conscrypt.setUseSessionTickets(sslSocket, true);
        Object[] array = h.f58636a.b(protocols).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Conscrypt.setApplicationProtocols(sslSocket, (String[]) array);
    }

    @Override // zl.h
    @l
    public String j(@k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return Conscrypt.isConscrypt(sslSocket) ? Conscrypt.getApplicationProtocol(sslSocket) : super.j(sslSocket);
    }

    @Override // zl.h
    @k
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f58620f);
        f0.o(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // zl.h
    @k
    public SSLSocketFactory q(@k X509TrustManager trustManager) throws NoSuchAlgorithmException, KeyManagementException {
        f0.p(trustManager, "trustManager");
        SSLContext sSLContextP = p();
        sSLContextP.init(null, new TrustManager[]{trustManager}, null);
        SSLSocketFactory socketFactory = sSLContextP.getSocketFactory();
        f0.o(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override // zl.h
    @k
    public X509TrustManager r() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        f0.m(trustManagers);
        if (!(trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager))) {
            String string = Arrays.toString(trustManagers);
            f0.o(string, "toString(this)");
            throw new IllegalStateException(f0.C("Unexpected default trust managers: ", string).toString());
        }
        TrustManager trustManager = trustManagers[0];
        Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        Conscrypt.setHostnameVerifier(x509TrustManager, b.f58621a);
        return x509TrustManager;
    }

    @Override // zl.h
    @l
    public X509TrustManager s(@k SSLSocketFactory sslSocketFactory) {
        f0.p(sslSocketFactory, "sslSocketFactory");
        return null;
    }
}
