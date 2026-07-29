package zl;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import hk.m;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.t;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m0.k;
import okhttp3.Protocol;
import okhttp3.a0;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0011\u0010\u0011\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J&\u0010!\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010$\u001a\u00020\u0002H\u0016J\u001a\u0010'\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020\u0006H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010(\u001a\u00020\u0006H\u0016J\u0010\u0010-\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016¨\u00062"}, d2 = {"Lzl/h;", "", "", "i", "Ljavax/net/ssl/SSLContext;", "p", "Ljavax/net/ssl/X509TrustManager;", SsManifestParser.e.J, "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", an.aB, "Ljavax/net/ssl/SSLSocket;", "sslSocket", "hostname", "", "Lokhttp3/Protocol;", "Lhk/n;", "protocols", "Lkotlin/z1;", "f", "c", j.f55230b, "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", m7.a.f40701a, "", "connectTimeout", "g", "message", UMTencentSSOHandler.LEVEL, "", "t", k.f40564b, "", l.f16298a, "closer", "k", "stackTrace", "o", "trustManager", "Lcm/c;", "d", "Lcm/e;", "e", "q", "toString", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f58636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static volatile h f58637b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f58638c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58639d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f58640e;

    @d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0014\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u001a\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001c\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u001c\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010#¨\u0006&"}, d2 = {"Lzl/h$a;", "", "Lzl/h;", "g", Constants.PARAM_PLATFORM, "Lkotlin/z1;", l.f16298a, "", "Lokhttp3/Protocol;", "protocols", "", "b", "", "c", "f", "d", "e", "", "h", "()Z", "isAndroid", j.f55230b, "isConscryptPreferred", "k", "isOpenJSSEPreferred", "i", "isBouncyCastlePreferred", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "Lzl/h;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public static /* synthetic */ void m(a aVar, h hVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                hVar = aVar.f();
            }
            aVar.l(hVar);
        }

        @yt.k
        public final List<String> b(@yt.k List<? extends Protocol> protocols) {
            f0.p(protocols, "protocols");
            ArrayList arrayList = new ArrayList();
            for (Object obj : protocols) {
                if (((Protocol) obj) != Protocol.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(t.Y(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((Protocol) it2.next()).toString());
            }
            return arrayList2;
        }

        @yt.k
        public final byte[] c(@yt.k List<? extends Protocol> protocols) {
            f0.p(protocols, "protocols");
            okio.j jVar = new okio.j();
            for (String str : b(protocols)) {
                jVar.writeByte(str.length());
                jVar.H0(str);
            }
            return jVar.S();
        }

        public final h d() {
            am.c.f777a.b();
            h hVarA = zl.a.f58606g.a();
            if (hVarA != null) {
                return hVarA;
            }
            h hVarA2 = b.f58609h.a();
            f0.m(hVarA2);
            return hVarA2;
        }

        public final h e() {
            g gVarA;
            c cVarA;
            d dVarC;
            if (j() && (dVarC = d.f58618g.c()) != null) {
                return dVarC;
            }
            if (i() && (cVarA = c.f58615g.a()) != null) {
                return cVarA;
            }
            if (k() && (gVarA = g.f58633g.a()) != null) {
                return gVarA;
            }
            f fVarA = f.f58631f.a();
            if (fVarA != null) {
                return fVarA;
            }
            h hVarA = e.f58622k.a();
            return hVarA != null ? hVarA : new h();
        }

        public final h f() {
            return h() ? d() : e();
        }

        @m
        @yt.k
        public final h g() {
            return h.f58637b;
        }

        public final boolean h() {
            return f0.g("Dalvik", System.getProperty("java.vm.name"));
        }

        public final boolean i() {
            return f0.g(BouncyCastleProvider.f45329b, Security.getProviders()[0].getName());
        }

        public final boolean j() {
            return f0.g("Conscrypt", Security.getProviders()[0].getName());
        }

        public final boolean k() {
            return f0.g("OpenJSSE", Security.getProviders()[0].getName());
        }

        public final void l(@yt.k h platform) {
            f0.p(platform, "platform");
            h.f58637b = platform;
        }
    }

    static {
        a aVar = new a(null);
        f58636a = aVar;
        f58637b = aVar.f();
        f58640e = Logger.getLogger(a0.class.getName());
    }

    @m
    @yt.k
    public static final h h() {
        return f58636a.g();
    }

    public static /* synthetic */ void n(h hVar, String str, int i10, Throwable th2, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i11 & 2) != 0) {
            i10 = 4;
        }
        if ((i11 & 4) != 0) {
            th2 = null;
        }
        hVar.m(str, i10, th2);
    }

    public void c(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
    }

    @yt.k
    public cm.c d(@yt.k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        return new cm.a(e(trustManager));
    }

    @yt.k
    public cm.e e(@yt.k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        f0.o(acceptedIssuers, "trustManager.acceptedIssuers");
        return new cm.b((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void f(@yt.k SSLSocket sslSocket, @yt.l String str, @yt.k List<Protocol> protocols) {
        f0.p(sslSocket, "sslSocket");
        f0.p(protocols, "protocols");
    }

    public void g(@yt.k Socket socket, @yt.k InetSocketAddress address, int i10) throws IOException {
        f0.p(socket, "socket");
        f0.p(address, "address");
        socket.connect(address, i10);
    }

    @yt.k
    public final String i() {
        return "OkHttp";
    }

    @yt.l
    public String j(@yt.k SSLSocket sslSocket) {
        f0.p(sslSocket, "sslSocket");
        return null;
    }

    @yt.l
    public Object k(@yt.k String closer) {
        f0.p(closer, "closer");
        if (f58640e.isLoggable(Level.FINE)) {
            return new Throwable(closer);
        }
        return null;
    }

    public boolean l(@yt.k String hostname) {
        f0.p(hostname, "hostname");
        return true;
    }

    public void m(@yt.k String message, int i10, @yt.l Throwable th2) {
        f0.p(message, "message");
        f58640e.log(i10 == 5 ? Level.WARNING : Level.INFO, message, th2);
    }

    public void o(@yt.k String message, @yt.l Object obj) {
        f0.p(message, "message");
        if (obj == null) {
            message = f0.C(message, " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        m(message, 5, (Throwable) obj);
    }

    @yt.k
    public SSLContext p() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        f0.o(sSLContext, "getInstance(\"TLS\")");
        return sSLContext;
    }

    @yt.k
    public SSLSocketFactory q(@yt.k X509TrustManager trustManager) {
        f0.p(trustManager, "trustManager");
        try {
            SSLContext sSLContextP = p();
            sSLContextP.init(null, new TrustManager[]{trustManager}, null);
            SSLSocketFactory socketFactory = sSLContextP.getSocketFactory();
            f0.o(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e10) {
            throw new AssertionError(f0.C("No System TLS: ", e10), e10);
        }
    }

    @yt.k
    public X509TrustManager r() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    @yt.l
    public X509TrustManager s(@yt.k SSLSocketFactory sslSocketFactory) {
        f0.p(sslSocketFactory, "sslSocketFactory");
        try {
            Class<?> sslContextClass = Class.forName("sun.security.ssl.SSLContextImpl");
            f0.o(sslContextClass, "sslContextClass");
            Object objU = rl.f.U(sslSocketFactory, sslContextClass, com.umeng.analytics.pro.d.R);
            if (objU == null) {
                return null;
            }
            return (X509TrustManager) rl.f.U(objU, X509TrustManager.class, "trustManager");
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e10) {
            if (f0.g(e10.getClass().getName(), "java.lang.reflect.InaccessibleObjectException")) {
                return null;
            }
            throw e10;
        }
    }

    @yt.k
    public String toString() {
        String simpleName = getClass().getSimpleName();
        f0.o(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
