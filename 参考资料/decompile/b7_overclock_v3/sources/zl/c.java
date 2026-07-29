package zl;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;
import xf.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J-\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0011\u0010\u0010\u001a\r\u0012\t\u0012\u00070\u000e¢\u0006\u0002\b\u000f0\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0017"}, d2 = {"Lzl/c;", "Lzl/h;", "Ljavax/net/ssl/SSLContext;", "p", "Ljavax/net/ssl/X509TrustManager;", SsManifestParser.e.J, "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", an.aB, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "Lhk/n;", "protocols", "Lkotlin/z1;", "f", j.f55230b, "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c extends h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final a f58615g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f58616h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final Provider f58617f;

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lzl/c$a;", "", "Lzl/c;", "a", "", "isSupported", "Z", "b", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @l
        public final c a() {
            u uVar = null;
            if (b()) {
                return new c(uVar);
            }
            return null;
        }

        public final boolean b() {
            return c.f58616h;
        }
    }

    static {
        a aVar = new a(null);
        f58615g = aVar;
        boolean z10 = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z10 = true;
        } catch (ClassNotFoundException unused) {
        }
        f58616h = z10;
    }

    public c() {
        this.f58617f = new BouncyCastleJsseProvider();
    }

    public /* synthetic */ c(u uVar) {
        this();
    }

    @Override // zl.h
    public void f(@k SSLSocket sslSocket, @l String str, @k List<Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
        if (!(sslSocket instanceof BCSSLSocket)) {
            super.f(sslSocket, str, protocols);
            return;
        }
        BCSSLSocket bCSSLSocket = (BCSSLSocket) sslSocket;
        BCSSLParameters parameters = bCSSLSocket.getParameters();
        Object[] array = h.f58636a.b(protocols).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        parameters.setApplicationProtocols((String[]) array);
        bCSSLSocket.setParameters(parameters);
    }

    @Override // zl.h
    @l
    public String j(@k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        if (!(sslSocket instanceof BCSSLSocket)) {
            return super.j(sslSocket);
        }
        String applicationProtocol = ((BCSSLSocket) sslSocket).getApplicationProtocol();
        if (applicationProtocol == null ? true : f0.g(applicationProtocol, "")) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // zl.h
    @k
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f58617f);
        f0.o(sSLContext, "getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override // zl.h
    @k
    public X509TrustManager r() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        f0.m(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        String string = Arrays.toString(trustManagers);
        f0.o(string, "toString(this)");
        throw new IllegalStateException(f0.C("Unexpected default trust managers: ", string).toString());
    }

    @Override // zl.h
    @l
    public X509TrustManager s(@k SSLSocketFactory sslSocketFactory) {
        f0.p(sslSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
    }
}
