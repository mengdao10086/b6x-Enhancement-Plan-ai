package okhttp3;

import cm.c;
import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.t0;
import okhttp3.e;
import okhttp3.g0;
import okhttp3.r;
import okhttp3.v;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import xf.k0;
import zl.h;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 t2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\t\rB\u0014\b\u0000\u0012\u0007\u0010¦\u0001\u001a\u00020\u000e¢\u0006\u0006\b§\u0001\u0010¨\u0001B\u000b\b\u0016¢\u0006\u0006\b§\u0001\u0010©\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\"\u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u001eH\u0007¢\u0006\u0004\b$\u0010 J\u000f\u0010%\u001a\u00020\u001eH\u0007¢\u0006\u0004\b%\u0010 J\u000f\u0010'\u001a\u00020&H\u0007¢\u0006\u0004\b'\u0010(J\u0011\u0010*\u001a\u0004\u0018\u00010)H\u0007¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0007¢\u0006\u0004\b-\u0010.J\u0011\u00100\u001a\u0004\u0018\u00010/H\u0007¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0007¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020!H\u0007¢\u0006\u0004\b5\u0010#J\u000f\u00107\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0007¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u0016H\u0007¢\u0006\u0004\b=\u0010\u0019J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0016H\u0007¢\u0006\u0004\b?\u0010\u0019J\u000f\u0010A\u001a\u00020@H\u0007¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0007¢\u0006\u0004\bD\u0010EJ\u000f\u0010G\u001a\u00020FH\u0007¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020FH\u0007¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020FH\u0007¢\u0006\u0004\bJ\u0010HJ\u000f\u0010K\u001a\u00020FH\u0007¢\u0006\u0004\bK\u0010HJ\u000f\u0010L\u001a\u00020FH\u0007¢\u0006\u0004\bL\u0010HR\u0017\u0010O\u001a\u00020\u00108G¢\u0006\f\n\u0004\b\t\u0010M\u001a\u0004\bN\u0010\u0012R\u0017\u0010R\u001a\u00020\u00138G¢\u0006\f\n\u0004\b\r\u0010P\u001a\u0004\bQ\u0010\u0015R\u001d\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168G¢\u0006\f\n\u0004\b\"\u0010S\u001a\u0004\bT\u0010\u0019R\u001d\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168G¢\u0006\f\n\u0004\b*\u0010S\u001a\u0004\bV\u0010\u0019R\u0017\u0010Z\u001a\u00020\u001b8G¢\u0006\f\n\u0004\bG\u0010X\u001a\u0004\bY\u0010\u001dR\u0017\u0010]\u001a\u00020\u001e8G¢\u0006\f\n\u0004\bD\u0010[\u001a\u0004\b\\\u0010 R\u0017\u0010`\u001a\u00020!8G¢\u0006\f\n\u0004\bI\u0010^\u001a\u0004\b_\u0010#R\u0017\u0010b\u001a\u00020\u001e8G¢\u0006\f\n\u0004\b\u0014\u0010[\u001a\u0004\ba\u0010 R\u0017\u0010d\u001a\u00020\u001e8G¢\u0006\f\n\u0004\b=\u0010[\u001a\u0004\bc\u0010 R\u0017\u0010g\u001a\u00020&8G¢\u0006\f\n\u0004\b'\u0010e\u001a\u0004\bf\u0010(R\u0019\u0010j\u001a\u0004\u0018\u00010)8G¢\u0006\f\n\u0004\b\u0011\u0010h\u001a\u0004\bi\u0010+R\u0017\u0010m\u001a\u00020,8G¢\u0006\f\n\u0004\b-\u0010k\u001a\u0004\bl\u0010.R\u0019\u0010p\u001a\u0004\u0018\u00010/8G¢\u0006\f\n\u0004\b\u001c\u0010n\u001a\u0004\bo\u00101R\u0017\u0010s\u001a\u0002028G¢\u0006\f\n\u0004\b$\u0010q\u001a\u0004\br\u00104R\u0017\u0010u\u001a\u00020!8G¢\u0006\f\n\u0004\b%\u0010^\u001a\u0004\bt\u0010#R\u0017\u0010x\u001a\u0002068G¢\u0006\f\n\u0004\bA\u0010v\u001a\u0004\bw\u00108R\u0016\u0010z\u001a\u0004\u0018\u0001098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010yR\u0019\u0010\u007f\u001a\u0004\u0018\u00010{8G¢\u0006\f\n\u0004\b\u001a\u0010|\u001a\u0004\b}\u0010~R\u001f\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020<0\u00168G¢\u0006\r\n\u0004\bL\u0010S\u001a\u0005\b\u0080\u0001\u0010\u0019R\u001f\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020>0\u00168G¢\u0006\r\n\u0004\b?\u0010S\u001a\u0005\b\u0082\u0001\u0010\u0019R\u001a\u0010\u0086\u0001\u001a\u00020@8G¢\u0006\u000e\n\u0005\b0\u0010\u0084\u0001\u001a\u0005\b\u0085\u0001\u0010BR\u001a\u0010\u0089\u0001\u001a\u00020C8G¢\u0006\u000e\n\u0005\b5\u0010\u0087\u0001\u001a\u0005\b\u0088\u0001\u0010ER\u001a\u0010\u008b\u0001\u001a\u00020F8G¢\u0006\u000e\n\u0005\bJ\u0010\u008a\u0001\u001a\u0005\b\u008a\u0001\u0010HR\u001a\u0010\u008d\u0001\u001a\u00020F8G¢\u0006\u000e\n\u0005\b\u001f\u0010\u008a\u0001\u001a\u0005\b\u008c\u0001\u0010HR\u001b\u0010\u0090\u0001\u001a\u00020F8G¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010\u008a\u0001\u001a\u0005\b\u008f\u0001\u0010HR\u001a\u0010\u0092\u0001\u001a\u00020F8G¢\u0006\u000e\n\u0005\b7\u0010\u008a\u0001\u001a\u0005\b\u0091\u0001\u0010HR\u001a\u0010\u0094\u0001\u001a\u00020F8G¢\u0006\u000e\n\u0005\b:\u0010\u008a\u0001\u001a\u0005\b\u0093\u0001\u0010HR\u001c\u0010\u0099\u0001\u001a\u00030\u0095\u00018G¢\u0006\u000f\n\u0005\bK\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010\u009f\u0001\u001a\u00030\u009a\u00018\u0006¢\u0006\u0010\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0013\u0010¡\u0001\u001a\u0002098G¢\u0006\u0007\u001a\u0005\b \u0001\u0010;R\u001f\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018G¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b\u0096\u0001\u0010¥\u0001¨\u0006ª\u0001"}, d2 = {"Lokhttp3/a0;", "", "Lokhttp3/e$a;", "Lokhttp3/g0$a;", "Lkotlin/z1;", "q0", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/e;", "a", "Lokhttp3/h0;", "listener", "Lokhttp3/g0;", "b", "Lokhttp3/a0$a;", "g0", "Lokhttp3/p;", "k", "()Lokhttp3/p;", "Lokhttp3/j;", "h", "()Lokhttp3/j;", "", "Lokhttp3/v;", "q", "()Ljava/util/List;", SsManifestParser.e.J, "Lokhttp3/r$c;", m0.k.f40564b, "()Lokhttp3/r$c;", "", "y", "()Z", "Lokhttp3/b;", "c", "()Lokhttp3/b;", "n", "o", "Lokhttp3/n;", xf.j.f55230b, "()Lokhttp3/n;", "Lokhttp3/c;", "d", "()Lokhttp3/c;", "Lokhttp3/q;", com.flydigi.sdk.bluetooth.l.f16298a, "()Lokhttp3/q;", "Ljava/net/Proxy;", "u", "()Ljava/net/Proxy;", "Ljava/net/ProxySelector;", "w", "()Ljava/net/ProxySelector;", "v", "Ljavax/net/SocketFactory;", i1.a.W4, "()Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "B", "()Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/k;", "i", "Lokhttp3/Protocol;", "t", "Ljavax/net/ssl/HostnameVerifier;", "p", "()Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "f", "()Lokhttp3/CertificatePinner;", "", "e", "()I", "g", "x", "C", an.aB, "Lokhttp3/p;", "Q", "dispatcher", "Lokhttp3/j;", "N", "connectionPool", "Ljava/util/List;", "d0", "interceptors", "f0", "networkInterceptors", "Lokhttp3/r$c;", i1.a.R4, "eventListenerFactory", "Z", "n0", "retryOnConnectionFailure", "Lokhttp3/b;", "G", "authenticator", i1.a.X4, "followRedirects", "Y", "followSslRedirects", "Lokhttp3/n;", "P", "cookieJar", "Lokhttp3/c;", "H", "cache", "Lokhttp3/q;", "R", "dns", "Ljava/net/Proxy;", "j0", IOptionConstant.proxy, "Ljava/net/ProxySelector;", "l0", "proxySelector", k0.f55262g, "proxyAuthenticator", "Ljavax/net/SocketFactory;", "o0", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/X509TrustManager;", "s0", "()Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "O", "connectionSpecs", "i0", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "c0", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "K", "certificatePinner", "I", "callTimeoutMillis", "L", "connectTimeoutMillis", an.aD, "m0", "readTimeoutMillis", "r0", "writeTimeoutMillis", "h0", "pingIntervalMillis", "", "J", "e0", "()J", "minWebSocketMessageToCompress", "Lokhttp3/internal/connection/g;", "D", "Lokhttp3/internal/connection/g;", "a0", "()Lokhttp3/internal/connection/g;", "routeDatabase", "p0", "sslSocketFactory", "Lcm/c;", "certificateChainCleaner", "Lcm/c;", "()Lcm/c;", "builder", "<init>", "(Lokhttp3/a0$a;)V", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public class a0 implements Cloneable, e.a, g0.a {
    public final int A;
    public final int B;
    public final long C;

    @yt.k
    public final okhttp3.internal.connection.g D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final p f43438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final j f43439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final List<v> f43440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final List<v> f43441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final r.c f43442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f43443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final okhttp3.b f43444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f43445h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f43446i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public final n f43447j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.l
    public final c f43448k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public final q f43449l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.l
    public final Proxy f43450m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public final ProxySelector f43451n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public final okhttp3.b f43452o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @yt.k
    public final SocketFactory f43453p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.l
    public final SSLSocketFactory f43454q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.l
    public final X509TrustManager f43455r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @yt.k
    public final List<k> f43456s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public final List<Protocol> f43457t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public final HostnameVerifier f43458u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @yt.k
    public final CertificatePinner f43459v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @yt.l
    public final cm.c f43460w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f43461x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f43462y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f43463z;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    @yt.k
    public static final b f43436k0 = new b(null);

    @yt.k
    public static final List<Protocol> K0 = rl.f.C(Protocol.HTTP_2, Protocol.HTTP_1_1);

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    @yt.k
    public static final List<k> f43437k1 = rl.f.C(k.f43884i, k.f43886k);

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lokhttp3/a0$b;", "", "", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lokhttp3/k;", "DEFAULT_CONNECTION_SPECS", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final List<k> a() {
            return a0.f43437k1;
        }

        @yt.k
        public final List<Protocol> b() {
            return a0.K0;
        }
    }

    public a0(@yt.k a builder) {
        ProxySelector proxySelectorR;
        kotlin.jvm.internal.f0.p(builder, "builder");
        this.f43438a = builder.E();
        this.f43439b = builder.B();
        this.f43440c = rl.f.h0(builder.K());
        this.f43441d = rl.f.h0(builder.M());
        this.f43442e = builder.G();
        this.f43443f = builder.T();
        this.f43444g = builder.v();
        this.f43445h = builder.H();
        this.f43446i = builder.I();
        this.f43447j = builder.D();
        this.f43448k = builder.w();
        this.f43449l = builder.F();
        this.f43450m = builder.P();
        if (builder.P() != null) {
            proxySelectorR = bm.a.f9498a;
        } else {
            proxySelectorR = builder.R();
            proxySelectorR = proxySelectorR == null ? ProxySelector.getDefault() : proxySelectorR;
            if (proxySelectorR == null) {
                proxySelectorR = bm.a.f9498a;
            }
        }
        this.f43451n = proxySelectorR;
        this.f43452o = builder.Q();
        this.f43453p = builder.V();
        List<k> listC = builder.C();
        this.f43456s = listC;
        this.f43457t = builder.O();
        this.f43458u = builder.J();
        this.f43461x = builder.x();
        this.f43462y = builder.A();
        this.f43463z = builder.S();
        this.A = builder.X();
        this.B = builder.N();
        this.C = builder.L();
        okhttp3.internal.connection.g gVarU = builder.U();
        this.D = gVarU == null ? new okhttp3.internal.connection.g() : gVarU;
        boolean z10 = true;
        if (!(listC instanceof Collection) || !listC.isEmpty()) {
            Iterator<T> it2 = listC.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (((k) it2.next()).i()) {
                    z10 = false;
                    break;
                }
            }
        }
        if (z10) {
            this.f43454q = null;
            this.f43460w = null;
            this.f43455r = null;
            this.f43459v = CertificatePinner.f43413d;
        } else if (builder.W() != null) {
            this.f43454q = builder.W();
            cm.c cVarY = builder.y();
            kotlin.jvm.internal.f0.m(cVarY);
            this.f43460w = cVarY;
            X509TrustManager x509TrustManagerY = builder.Y();
            kotlin.jvm.internal.f0.m(x509TrustManagerY);
            this.f43455r = x509TrustManagerY;
            CertificatePinner certificatePinnerZ = builder.z();
            kotlin.jvm.internal.f0.m(cVarY);
            this.f43459v = certificatePinnerZ.j(cVarY);
        } else {
            h.a aVar = zl.h.f58636a;
            X509TrustManager x509TrustManagerR = aVar.g().r();
            this.f43455r = x509TrustManagerR;
            zl.h hVarG = aVar.g();
            kotlin.jvm.internal.f0.m(x509TrustManagerR);
            this.f43454q = hVarG.q(x509TrustManagerR);
            c.a aVar2 = cm.c.f10963a;
            kotlin.jvm.internal.f0.m(x509TrustManagerR);
            cm.c cVarA = aVar2.a(x509TrustManagerR);
            this.f43460w = cVarA;
            CertificatePinner certificatePinnerZ2 = builder.z();
            kotlin.jvm.internal.f0.m(cVarA);
            this.f43459v = certificatePinnerZ2.j(cVarA);
        }
        q0();
    }

    @hk.h(name = "-deprecated_socketFactory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "socketFactory", imports = {}))
    @yt.k
    public final SocketFactory A() {
        return this.f43453p;
    }

    @hk.h(name = "-deprecated_sslSocketFactory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "sslSocketFactory", imports = {}))
    @yt.k
    public final SSLSocketFactory B() {
        return p0();
    }

    @hk.h(name = "-deprecated_writeTimeoutMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "writeTimeoutMillis", imports = {}))
    public final int C() {
        return this.A;
    }

    @hk.h(name = "authenticator")
    @yt.k
    public final okhttp3.b G() {
        return this.f43444g;
    }

    @hk.h(name = "cache")
    @yt.l
    public final c H() {
        return this.f43448k;
    }

    @hk.h(name = "callTimeoutMillis")
    public final int I() {
        return this.f43461x;
    }

    @hk.h(name = "certificateChainCleaner")
    @yt.l
    public final cm.c J() {
        return this.f43460w;
    }

    @hk.h(name = "certificatePinner")
    @yt.k
    public final CertificatePinner K() {
        return this.f43459v;
    }

    @hk.h(name = "connectTimeoutMillis")
    public final int L() {
        return this.f43462y;
    }

    @hk.h(name = "connectionPool")
    @yt.k
    public final j N() {
        return this.f43439b;
    }

    @hk.h(name = "connectionSpecs")
    @yt.k
    public final List<k> O() {
        return this.f43456s;
    }

    @hk.h(name = "cookieJar")
    @yt.k
    public final n P() {
        return this.f43447j;
    }

    @hk.h(name = "dispatcher")
    @yt.k
    public final p Q() {
        return this.f43438a;
    }

    @hk.h(name = "dns")
    @yt.k
    public final q R() {
        return this.f43449l;
    }

    @hk.h(name = "eventListenerFactory")
    @yt.k
    public final r.c S() {
        return this.f43442e;
    }

    @hk.h(name = "followRedirects")
    public final boolean V() {
        return this.f43445h;
    }

    @hk.h(name = "followSslRedirects")
    public final boolean Y() {
        return this.f43446i;
    }

    @Override // okhttp3.e.a
    @yt.k
    public e a(@yt.k b0 request) {
        kotlin.jvm.internal.f0.p(request, "request");
        return new okhttp3.internal.connection.e(this, request, false);
    }

    @yt.k
    public final okhttp3.internal.connection.g a0() {
        return this.D;
    }

    @Override // okhttp3.g0.a
    @yt.k
    public g0 b(@yt.k b0 request, @yt.k h0 listener) {
        kotlin.jvm.internal.f0.p(request, "request");
        kotlin.jvm.internal.f0.p(listener, "listener");
        dm.e eVar = new dm.e(ul.d.f52208i, request, listener, new Random(), this.B, null, this.C);
        eVar.q(this);
        return eVar;
    }

    @hk.h(name = "-deprecated_authenticator")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "authenticator", imports = {}))
    @yt.k
    public final okhttp3.b c() {
        return this.f43444g;
    }

    @hk.h(name = "hostnameVerifier")
    @yt.k
    public final HostnameVerifier c0() {
        return this.f43458u;
    }

    @yt.k
    public Object clone() {
        return super.clone();
    }

    @hk.h(name = "-deprecated_cache")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cache", imports = {}))
    @yt.l
    public final c d() {
        return this.f43448k;
    }

    @hk.h(name = "interceptors")
    @yt.k
    public final List<v> d0() {
        return this.f43440c;
    }

    @hk.h(name = "-deprecated_callTimeoutMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "callTimeoutMillis", imports = {}))
    public final int e() {
        return this.f43461x;
    }

    @hk.h(name = "minWebSocketMessageToCompress")
    public final long e0() {
        return this.C;
    }

    @hk.h(name = "-deprecated_certificatePinner")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "certificatePinner", imports = {}))
    @yt.k
    public final CertificatePinner f() {
        return this.f43459v;
    }

    @hk.h(name = "networkInterceptors")
    @yt.k
    public final List<v> f0() {
        return this.f43441d;
    }

    @hk.h(name = "-deprecated_connectTimeoutMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "connectTimeoutMillis", imports = {}))
    public final int g() {
        return this.f43462y;
    }

    @yt.k
    public a g0() {
        return new a(this);
    }

    @hk.h(name = "-deprecated_connectionPool")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "connectionPool", imports = {}))
    @yt.k
    public final j h() {
        return this.f43439b;
    }

    @hk.h(name = "pingIntervalMillis")
    public final int h0() {
        return this.B;
    }

    @hk.h(name = "-deprecated_connectionSpecs")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "connectionSpecs", imports = {}))
    @yt.k
    public final List<k> i() {
        return this.f43456s;
    }

    @hk.h(name = "protocols")
    @yt.k
    public final List<Protocol> i0() {
        return this.f43457t;
    }

    @hk.h(name = "-deprecated_cookieJar")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cookieJar", imports = {}))
    @yt.k
    public final n j() {
        return this.f43447j;
    }

    @hk.h(name = IOptionConstant.proxy)
    @yt.l
    public final Proxy j0() {
        return this.f43450m;
    }

    @hk.h(name = "-deprecated_dispatcher")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "dispatcher", imports = {}))
    @yt.k
    public final p k() {
        return this.f43438a;
    }

    @hk.h(name = "proxyAuthenticator")
    @yt.k
    public final okhttp3.b k0() {
        return this.f43452o;
    }

    @hk.h(name = "-deprecated_dns")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "dns", imports = {}))
    @yt.k
    public final q l() {
        return this.f43449l;
    }

    @hk.h(name = "proxySelector")
    @yt.k
    public final ProxySelector l0() {
        return this.f43451n;
    }

    @hk.h(name = "-deprecated_eventListenerFactory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "eventListenerFactory", imports = {}))
    @yt.k
    public final r.c m() {
        return this.f43442e;
    }

    @hk.h(name = "readTimeoutMillis")
    public final int m0() {
        return this.f43463z;
    }

    @hk.h(name = "-deprecated_followRedirects")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "followRedirects", imports = {}))
    public final boolean n() {
        return this.f43445h;
    }

    @hk.h(name = "retryOnConnectionFailure")
    public final boolean n0() {
        return this.f43443f;
    }

    @hk.h(name = "-deprecated_followSslRedirects")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "followSslRedirects", imports = {}))
    public final boolean o() {
        return this.f43446i;
    }

    @hk.h(name = "socketFactory")
    @yt.k
    public final SocketFactory o0() {
        return this.f43453p;
    }

    @hk.h(name = "-deprecated_hostnameVerifier")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "hostnameVerifier", imports = {}))
    @yt.k
    public final HostnameVerifier p() {
        return this.f43458u;
    }

    @hk.h(name = "sslSocketFactory")
    @yt.k
    public final SSLSocketFactory p0() {
        SSLSocketFactory sSLSocketFactory = this.f43454q;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    @hk.h(name = "-deprecated_interceptors")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "interceptors", imports = {}))
    @yt.k
    public final List<v> q() {
        return this.f43440c;
    }

    public final void q0() {
        boolean z10;
        if (!(!this.f43440c.contains(null))) {
            throw new IllegalStateException(kotlin.jvm.internal.f0.C("Null interceptor: ", d0()).toString());
        }
        if (!(!this.f43441d.contains(null))) {
            throw new IllegalStateException(kotlin.jvm.internal.f0.C("Null network interceptor: ", f0()).toString());
        }
        List<k> list = this.f43456s;
        if ((list instanceof Collection) && list.isEmpty()) {
            z10 = true;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((k) it2.next()).i()) {
                    z10 = false;
                    break;
                }
            }
            z10 = true;
        }
        if (!z10) {
            if (this.f43454q == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.f43460w == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.f43455r == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.f43454q == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f43460w == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.f43455r == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!kotlin.jvm.internal.f0.g(this.f43459v, CertificatePinner.f43413d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @hk.h(name = "-deprecated_networkInterceptors")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "networkInterceptors", imports = {}))
    @yt.k
    public final List<v> r() {
        return this.f43441d;
    }

    @hk.h(name = "writeTimeoutMillis")
    public final int r0() {
        return this.A;
    }

    @hk.h(name = "-deprecated_pingIntervalMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "pingIntervalMillis", imports = {}))
    public final int s() {
        return this.B;
    }

    @hk.h(name = "x509TrustManager")
    @yt.l
    public final X509TrustManager s0() {
        return this.f43455r;
    }

    @hk.h(name = "-deprecated_protocols")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "protocols", imports = {}))
    @yt.k
    public final List<Protocol> t() {
        return this.f43457t;
    }

    @hk.h(name = "-deprecated_proxy")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.proxy, imports = {}))
    @yt.l
    public final Proxy u() {
        return this.f43450m;
    }

    @hk.h(name = "-deprecated_proxyAuthenticator")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "proxyAuthenticator", imports = {}))
    @yt.k
    public final okhttp3.b v() {
        return this.f43452o;
    }

    @hk.h(name = "-deprecated_proxySelector")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "proxySelector", imports = {}))
    @yt.k
    public final ProxySelector w() {
        return this.f43451n;
    }

    @hk.h(name = "-deprecated_readTimeoutMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "readTimeoutMillis", imports = {}))
    public final int x() {
        return this.f43463z;
    }

    @hk.h(name = "-deprecated_retryOnConnectionFailure")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "retryOnConnectionFailure", imports = {}))
    public final boolean y() {
        return this.f43443f;
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b_\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\bè\u0001\u0010é\u0001B\u0014\b\u0010\u0012\u0007\u0010ê\u0001\u001a\u00020c¢\u0006\u0006\bè\u0001\u0010ë\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ8\u0010\u0014\u001a\u00020\u00002#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\tJ8\u0010\u0018\u001a\u00020\u00002#\b\u0004\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u001fJ\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u0010\u0010.\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010,J\u000e\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020/J\u0010\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000102J\u000e\u00107\u001a\u00020\u00002\u0006\u00106\u001a\u000205J\u000e\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020\"J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:J\u0010\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=H\u0007J\u0016\u0010B\u001a\u00020\u00002\u0006\u0010>\u001a\u00020=2\u0006\u0010A\u001a\u00020@J\u0014\u0010F\u001a\u00020\u00002\f\u0010E\u001a\b\u0012\u0004\u0012\u00020D0CJ\u0014\u0010I\u001a\u00020\u00002\f\u0010H\u001a\b\u0012\u0004\u0012\u00020G0CJ\u000e\u0010L\u001a\u00020\u00002\u0006\u0010K\u001a\u00020JJ\u000e\u0010O\u001a\u00020\u00002\u0006\u0010N\u001a\u00020MJ\u0016\u0010T\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RJ\u0010\u0010W\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007J\u0016\u0010X\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RJ\u0010\u0010Y\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007J\u0016\u0010Z\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RJ\u0010\u0010[\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007J\u0016\u0010\\\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RJ\u0010\u0010]\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007J\u0016\u0010_\u001a\u00020\u00002\u0006\u0010^\u001a\u00020P2\u0006\u0010S\u001a\u00020RJ\u0010\u0010`\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0007J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010a\u001a\u00020PJ\u0006\u0010d\u001a\u00020cR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR \u0010r\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010o\u001a\u0004\bp\u0010qR \u0010t\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0017\u0010o\u001a\u0004\bs\u0010qR\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\"\u0010 \u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bd\u0010L\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R%\u0010#\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b.\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R$\u0010%\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bT\u0010L\u001a\u0005\b\u0083\u0001\u0010{\"\u0005\b\u0084\u0001\u0010}R%\u0010\u0087\u0001\u001a\u00020\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\bW\u0010L\u001a\u0005\b\u0085\u0001\u0010{\"\u0005\b\u0086\u0001\u0010}R'\u0010*\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bO\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R)\u0010-\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bX\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u00100\u001a\u00020/8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bY\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R)\u00103\u001a\u0004\u0018\u0001028\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0007\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u00106\u001a\u0004\u0018\u0001058\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bF\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010 \u0001R&\u00108\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b+\u0010~\u001a\u0006\b¡\u0001\u0010\u0080\u0001\"\u0006\b¢\u0001\u0010\u0082\u0001R'\u0010;\u001a\u00020:8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u0004\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R*\u0010\u00ad\u0001\u001a\u0004\u0018\u00010=8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b1\u0010¨\u0001\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0006\b«\u0001\u0010¬\u0001R*\u0010³\u0001\u001a\u0004\u0018\u00010@8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u001b\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R+\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b\u001e\u0010o\u001a\u0005\b´\u0001\u0010q\"\u0006\bµ\u0001\u0010¶\u0001R+\u0010H\u001a\b\u0012\u0004\u0012\u00020G0C8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b&\u0010o\u001a\u0005\b·\u0001\u0010q\"\u0006\b¸\u0001\u0010¶\u0001R'\u0010K\u001a\u00020J8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b(\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R'\u0010N\u001a\u00020M8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b\u007f\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R*\u0010È\u0001\u001a\u00030Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÄ\u0001\u0010\u0085\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R*\u0010Ì\u0001\u001a\u00030Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÉ\u0001\u0010\u0085\u0001\u001a\u0006\bÊ\u0001\u0010Å\u0001\"\u0006\bË\u0001\u0010Ç\u0001R*\u0010Ï\u0001\u001a\u00030Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¿\u0001\u0010\u0085\u0001\u001a\u0006\bÍ\u0001\u0010Å\u0001\"\u0006\bÎ\u0001\u0010Ç\u0001R*\u0010Ò\u0001\u001a\u00030Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bÊ\u0001\u0010\u0085\u0001\u001a\u0006\bÐ\u0001\u0010Å\u0001\"\u0006\bÑ\u0001\u0010Ç\u0001R)\u0010Õ\u0001\u001a\u00030Ã\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\bk\u0010\u0085\u0001\u001a\u0006\bÓ\u0001\u0010Å\u0001\"\u0006\bÔ\u0001\u0010Ç\u0001R)\u0010Ú\u0001\u001a\u00020P8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010º\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R,\u0010á\u0001\u001a\u0005\u0018\u00010Û\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R,\u0010ã\u0001\u001a\u0005\u0018\u00010â\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\bã\u0001\u0010ä\u0001\u001a\u0006\bÉ\u0001\u0010å\u0001\"\u0006\bæ\u0001\u0010ç\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006ì\u0001"}, d2 = {"Lokhttp3/a0$a;", "", "Lokhttp3/p;", "dispatcher", "p", "Lokhttp3/j;", "connectionPool", m0.k.f40564b, "", "Lokhttp3/v;", "a0", "interceptor", "c", "Lkotlin/Function1;", "Lokhttp3/v$a;", "Lkotlin/n0;", "name", "chain", "Lokhttp3/d0;", "block", "a", "(Lik/l;)Lokhttp3/a0$a;", "c0", "d", "b", "Lokhttp3/r;", "eventListener", SsManifestParser.e.J, "Lokhttp3/r$c;", "eventListenerFactory", an.aB, "", "retryOnConnectionFailure", "l0", "Lokhttp3/b;", "authenticator", "e", "followRedirects", "t", "followProtocolRedirects", "u", "Lokhttp3/n;", "cookieJar", "o", "Lokhttp3/c;", "cache", "g", "Lokhttp3/q;", "dns", "q", "Ljava/net/Proxy;", IOptionConstant.proxy, "g0", "Ljava/net/ProxySelector;", "proxySelector", "i0", "proxyAuthenticator", "h0", "Ljavax/net/SocketFactory;", "socketFactory", "O0", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "P0", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Q0", "", "Lokhttp3/k;", "connectionSpecs", "n", "Lokhttp3/Protocol;", "protocols", "f0", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Z", "Lokhttp3/CertificatePinner;", "certificatePinner", xf.j.f55230b, "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "h", "Ljava/time/Duration;", "duration", "i", "k", com.flydigi.sdk.bluetooth.l.f16298a, "j0", k0.f55262g, "R0", "S0", an.aU, "d0", "e0", "bytes", "b0", "Lokhttp3/a0;", "f", "Lokhttp3/p;", i1.a.S4, "()Lokhttp3/p;", "v0", "(Lokhttp3/p;)V", "Lokhttp3/j;", "B", "()Lokhttp3/j;", "s0", "(Lokhttp3/j;)V", "Ljava/util/List;", "K", "()Ljava/util/List;", "interceptors", "M", "networkInterceptors", "Lokhttp3/r$c;", "G", "()Lokhttp3/r$c;", "x0", "(Lokhttp3/r$c;)V", i1.a.f31577d5, "()Z", "I0", "(Z)V", "Lokhttp3/b;", "v", "()Lokhttp3/b;", "m0", "(Lokhttp3/b;)V", "H", "y0", "I", "z0", "followSslRedirects", "Lokhttp3/n;", "D", "()Lokhttp3/n;", "u0", "(Lokhttp3/n;)V", "Lokhttp3/c;", "w", "()Lokhttp3/c;", "n0", "(Lokhttp3/c;)V", "Lokhttp3/q;", "F", "()Lokhttp3/q;", "w0", "(Lokhttp3/q;)V", "Ljava/net/Proxy;", "P", "()Ljava/net/Proxy;", "E0", "(Ljava/net/Proxy;)V", "Ljava/net/ProxySelector;", "R", "()Ljava/net/ProxySelector;", "G0", "(Ljava/net/ProxySelector;)V", "Q", "F0", "Ljavax/net/SocketFactory;", i1.a.X4, "()Ljavax/net/SocketFactory;", "K0", "(Ljavax/net/SocketFactory;)V", "Ljavax/net/ssl/SSLSocketFactory;", i1.a.T4, "()Ljavax/net/ssl/SSLSocketFactory;", "L0", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "Y", "()Ljavax/net/ssl/X509TrustManager;", "N0", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "C", "t0", "(Ljava/util/List;)V", "O", "D0", "Ljavax/net/ssl/HostnameVerifier;", "J", "()Ljavax/net/ssl/HostnameVerifier;", "A0", "(Ljavax/net/ssl/HostnameVerifier;)V", "Lokhttp3/CertificatePinner;", an.aD, "()Lokhttp3/CertificatePinner;", "q0", "(Lokhttp3/CertificatePinner;)V", "", "x", "()I", "o0", "(I)V", "callTimeout", "y", i1.a.W4, "r0", "connectTimeout", i1.a.R4, "H0", "readTimeout", "X", "M0", "writeTimeout", "N", "C0", "pingInterval", "L", "()J", "B0", "(J)V", "minWebSocketMessageToCompress", "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "U", "()Lokhttp3/internal/connection/g;", "J0", "(Lokhttp3/internal/connection/g;)V", "routeDatabase", "Lcm/c;", "certificateChainCleaner", "Lcm/c;", "()Lcm/c;", "p0", "(Lcm/c;)V", "<init>", "()V", "okHttpClient", "(Lokhttp3/a0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public int A;
        public int B;
        public long C;

        @yt.l
        public okhttp3.internal.connection.g D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public p f43464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public j f43465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<v> f43466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final List<v> f43467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public r.c f43468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f43469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public okhttp3.b f43470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f43471h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f43472i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @yt.k
        public n f43473j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @yt.l
        public c f43474k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @yt.k
        public q f43475l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @yt.l
        public Proxy f43476m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @yt.l
        public ProxySelector f43477n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @yt.k
        public okhttp3.b f43478o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @yt.k
        public SocketFactory f43479p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @yt.l
        public SSLSocketFactory f43480q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @yt.l
        public X509TrustManager f43481r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @yt.k
        public List<k> f43482s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @yt.k
        public List<? extends Protocol> f43483t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @yt.k
        public HostnameVerifier f43484u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @yt.k
        public CertificatePinner f43485v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @yt.l
        public cm.c f43486w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f43487x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f43488y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f43489z;

        /* JADX INFO: renamed from: okhttp3.a0$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "(Lokhttp3/v$a;)Lokhttp3/d0;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        public static final class C0488a implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ik.l<v.a, d0> f43490a;

            /* JADX WARN: Multi-variable type inference failed */
            public C0488a(ik.l<? super v.a, d0> lVar) {
                this.f43490a = lVar;
            }

            @Override // okhttp3.v
            @yt.k
            public final d0 intercept(@yt.k v.a chain) {
                kotlin.jvm.internal.f0.p(chain, "chain");
                return this.f43490a.i(chain);
            }
        }

        @kotlin.d0(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "(Lokhttp3/v$a;)Lokhttp3/d0;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        public static final class b implements v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ik.l<v.a, d0> f43491a;

            /* JADX WARN: Multi-variable type inference failed */
            public b(ik.l<? super v.a, d0> lVar) {
                this.f43491a = lVar;
            }

            @Override // okhttp3.v
            @yt.k
            public final d0 intercept(@yt.k v.a chain) {
                kotlin.jvm.internal.f0.p(chain, "chain");
                return this.f43491a.i(chain);
            }
        }

        public a() {
            this.f43464a = new p();
            this.f43465b = new j();
            this.f43466c = new ArrayList();
            this.f43467d = new ArrayList();
            this.f43468e = rl.f.g(r.NONE);
            this.f43469f = true;
            okhttp3.b bVar = okhttp3.b.f43493b;
            this.f43470g = bVar;
            this.f43471h = true;
            this.f43472i = true;
            this.f43473j = n.f43925b;
            this.f43475l = q.f43936b;
            this.f43478o = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            kotlin.jvm.internal.f0.o(socketFactory, "getDefault()");
            this.f43479p = socketFactory;
            b bVar2 = a0.f43436k0;
            this.f43482s = bVar2.a();
            this.f43483t = bVar2.b();
            this.f43484u = cm.d.f10964a;
            this.f43485v = CertificatePinner.f43413d;
            this.f43488y = 10000;
            this.f43489z = 10000;
            this.A = 10000;
            this.C = 1024L;
        }

        public final int A() {
            return this.f43488y;
        }

        public final void A0(@yt.k HostnameVerifier hostnameVerifier) {
            kotlin.jvm.internal.f0.p(hostnameVerifier, "<set-?>");
            this.f43484u = hostnameVerifier;
        }

        @yt.k
        public final j B() {
            return this.f43465b;
        }

        public final void B0(long j10) {
            this.C = j10;
        }

        @yt.k
        public final List<k> C() {
            return this.f43482s;
        }

        public final void C0(int i10) {
            this.B = i10;
        }

        @yt.k
        public final n D() {
            return this.f43473j;
        }

        public final void D0(@yt.k List<? extends Protocol> list) {
            kotlin.jvm.internal.f0.p(list, "<set-?>");
            this.f43483t = list;
        }

        @yt.k
        public final p E() {
            return this.f43464a;
        }

        public final void E0(@yt.l Proxy proxy) {
            this.f43476m = proxy;
        }

        @yt.k
        public final q F() {
            return this.f43475l;
        }

        public final void F0(@yt.k okhttp3.b bVar) {
            kotlin.jvm.internal.f0.p(bVar, "<set-?>");
            this.f43478o = bVar;
        }

        @yt.k
        public final r.c G() {
            return this.f43468e;
        }

        public final void G0(@yt.l ProxySelector proxySelector) {
            this.f43477n = proxySelector;
        }

        public final boolean H() {
            return this.f43471h;
        }

        public final void H0(int i10) {
            this.f43489z = i10;
        }

        public final boolean I() {
            return this.f43472i;
        }

        public final void I0(boolean z10) {
            this.f43469f = z10;
        }

        @yt.k
        public final HostnameVerifier J() {
            return this.f43484u;
        }

        public final void J0(@yt.l okhttp3.internal.connection.g gVar) {
            this.D = gVar;
        }

        @yt.k
        public final List<v> K() {
            return this.f43466c;
        }

        public final void K0(@yt.k SocketFactory socketFactory) {
            kotlin.jvm.internal.f0.p(socketFactory, "<set-?>");
            this.f43479p = socketFactory;
        }

        public final long L() {
            return this.C;
        }

        public final void L0(@yt.l SSLSocketFactory sSLSocketFactory) {
            this.f43480q = sSLSocketFactory;
        }

        @yt.k
        public final List<v> M() {
            return this.f43467d;
        }

        public final void M0(int i10) {
            this.A = i10;
        }

        public final int N() {
            return this.B;
        }

        public final void N0(@yt.l X509TrustManager x509TrustManager) {
            this.f43481r = x509TrustManager;
        }

        @yt.k
        public final List<Protocol> O() {
            return this.f43483t;
        }

        @yt.k
        public final a O0(@yt.k SocketFactory socketFactory) {
            kotlin.jvm.internal.f0.p(socketFactory, "socketFactory");
            if (!(!(socketFactory instanceof SSLSocketFactory))) {
                throw new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            }
            if (!kotlin.jvm.internal.f0.g(socketFactory, V())) {
                J0(null);
            }
            K0(socketFactory);
            return this;
        }

        @yt.l
        public final Proxy P() {
            return this.f43476m;
        }

        @kotlin.k(level = DeprecationLevel.ERROR, message = "Use the sslSocketFactory overload that accepts a X509TrustManager.")
        @yt.k
        public final a P0(@yt.k SSLSocketFactory sslSocketFactory) {
            kotlin.jvm.internal.f0.p(sslSocketFactory, "sslSocketFactory");
            if (!kotlin.jvm.internal.f0.g(sslSocketFactory, W())) {
                J0(null);
            }
            L0(sslSocketFactory);
            h.a aVar = zl.h.f58636a;
            X509TrustManager x509TrustManagerS = aVar.g().s(sslSocketFactory);
            if (x509TrustManagerS != null) {
                N0(x509TrustManagerS);
                zl.h hVarG = aVar.g();
                X509TrustManager x509TrustManagerY = Y();
                kotlin.jvm.internal.f0.m(x509TrustManagerY);
                p0(hVarG.d(x509TrustManagerY));
                return this;
            }
            throw new IllegalStateException("Unable to extract the trust manager on " + aVar.g() + ", sslSocketFactory is " + sslSocketFactory.getClass());
        }

        @yt.k
        public final okhttp3.b Q() {
            return this.f43478o;
        }

        @yt.k
        public final a Q0(@yt.k SSLSocketFactory sslSocketFactory, @yt.k X509TrustManager trustManager) {
            kotlin.jvm.internal.f0.p(sslSocketFactory, "sslSocketFactory");
            kotlin.jvm.internal.f0.p(trustManager, "trustManager");
            if (!kotlin.jvm.internal.f0.g(sslSocketFactory, W()) || !kotlin.jvm.internal.f0.g(trustManager, Y())) {
                J0(null);
            }
            L0(sslSocketFactory);
            p0(cm.c.f10963a.a(trustManager));
            N0(trustManager);
            return this;
        }

        @yt.l
        public final ProxySelector R() {
            return this.f43477n;
        }

        @yt.k
        public final a R0(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            M0(rl.f.m("timeout", j10, unit));
            return this;
        }

        public final int S() {
            return this.f43489z;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a S0(@yt.k Duration duration) {
            kotlin.jvm.internal.f0.p(duration, "duration");
            R0(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public final boolean T() {
            return this.f43469f;
        }

        @yt.l
        public final okhttp3.internal.connection.g U() {
            return this.D;
        }

        @yt.k
        public final SocketFactory V() {
            return this.f43479p;
        }

        @yt.l
        public final SSLSocketFactory W() {
            return this.f43480q;
        }

        public final int X() {
            return this.A;
        }

        @yt.l
        public final X509TrustManager Y() {
            return this.f43481r;
        }

        @yt.k
        public final a Z(@yt.k HostnameVerifier hostnameVerifier) {
            kotlin.jvm.internal.f0.p(hostnameVerifier, "hostnameVerifier");
            if (!kotlin.jvm.internal.f0.g(hostnameVerifier, J())) {
                J0(null);
            }
            A0(hostnameVerifier);
            return this;
        }

        @hk.h(name = "-addInterceptor")
        @yt.k
        public final a a(@yt.k ik.l<? super v.a, d0> block) {
            kotlin.jvm.internal.f0.p(block, "block");
            return c(new C0488a(block));
        }

        @yt.k
        public final List<v> a0() {
            return this.f43466c;
        }

        @hk.h(name = "-addNetworkInterceptor")
        @yt.k
        public final a b(@yt.k ik.l<? super v.a, d0> block) {
            kotlin.jvm.internal.f0.p(block, "block");
            return d(new b(block));
        }

        @yt.k
        public final a b0(long j10) {
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("minWebSocketMessageToCompress must be positive: ", Long.valueOf(j10)).toString());
            }
            B0(j10);
            return this;
        }

        @yt.k
        public final a c(@yt.k v interceptor) {
            kotlin.jvm.internal.f0.p(interceptor, "interceptor");
            K().add(interceptor);
            return this;
        }

        @yt.k
        public final List<v> c0() {
            return this.f43467d;
        }

        @yt.k
        public final a d(@yt.k v interceptor) {
            kotlin.jvm.internal.f0.p(interceptor, "interceptor");
            M().add(interceptor);
            return this;
        }

        @yt.k
        public final a d0(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            C0(rl.f.m(an.aU, j10, unit));
            return this;
        }

        @yt.k
        public final a e(@yt.k okhttp3.b authenticator) {
            kotlin.jvm.internal.f0.p(authenticator, "authenticator");
            m0(authenticator);
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a e0(@yt.k Duration duration) {
            kotlin.jvm.internal.f0.p(duration, "duration");
            d0(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @yt.k
        public final a0 f() {
            return new a0(this);
        }

        @yt.k
        public final a f0(@yt.k List<? extends Protocol> protocols) {
            kotlin.jvm.internal.f0.p(protocols, "protocols");
            List listT5 = CollectionsKt___CollectionsKt.T5(protocols);
            Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!(listT5.contains(protocol) || listT5.contains(Protocol.HTTP_1_1))) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("protocols must contain h2_prior_knowledge or http/1.1: ", listT5).toString());
            }
            if (!(!listT5.contains(protocol) || listT5.size() <= 1)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("protocols containing h2_prior_knowledge cannot use other protocols: ", listT5).toString());
            }
            if (!(!listT5.contains(Protocol.HTTP_1_0))) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("protocols must not contain http/1.0: ", listT5).toString());
            }
            if (!(!listT5.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            listT5.remove(Protocol.SPDY_3);
            if (!kotlin.jvm.internal.f0.g(listT5, O())) {
                J0(null);
            }
            List<? extends Protocol> listUnmodifiableList = Collections.unmodifiableList(listT5);
            kotlin.jvm.internal.f0.o(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
            D0(listUnmodifiableList);
            return this;
        }

        @yt.k
        public final a g(@yt.l c cVar) {
            n0(cVar);
            return this;
        }

        @yt.k
        public final a g0(@yt.l Proxy proxy) {
            if (!kotlin.jvm.internal.f0.g(proxy, P())) {
                J0(null);
            }
            E0(proxy);
            return this;
        }

        @yt.k
        public final a h(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            o0(rl.f.m("timeout", j10, unit));
            return this;
        }

        @yt.k
        public final a h0(@yt.k okhttp3.b proxyAuthenticator) {
            kotlin.jvm.internal.f0.p(proxyAuthenticator, "proxyAuthenticator");
            if (!kotlin.jvm.internal.f0.g(proxyAuthenticator, Q())) {
                J0(null);
            }
            F0(proxyAuthenticator);
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a i(@yt.k Duration duration) {
            kotlin.jvm.internal.f0.p(duration, "duration");
            h(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @yt.k
        public final a i0(@yt.k ProxySelector proxySelector) {
            kotlin.jvm.internal.f0.p(proxySelector, "proxySelector");
            if (!kotlin.jvm.internal.f0.g(proxySelector, R())) {
                J0(null);
            }
            G0(proxySelector);
            return this;
        }

        @yt.k
        public final a j(@yt.k CertificatePinner certificatePinner) {
            kotlin.jvm.internal.f0.p(certificatePinner, "certificatePinner");
            if (!kotlin.jvm.internal.f0.g(certificatePinner, z())) {
                J0(null);
            }
            q0(certificatePinner);
            return this;
        }

        @yt.k
        public final a j0(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            H0(rl.f.m("timeout", j10, unit));
            return this;
        }

        @yt.k
        public final a k(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            r0(rl.f.m("timeout", j10, unit));
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a k0(@yt.k Duration duration) {
            kotlin.jvm.internal.f0.p(duration, "duration");
            j0(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @yt.k
        @IgnoreJRERequirement
        public final a l(@yt.k Duration duration) {
            kotlin.jvm.internal.f0.p(duration, "duration");
            k(duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        @yt.k
        public final a l0(boolean z10) {
            I0(z10);
            return this;
        }

        @yt.k
        public final a m(@yt.k j connectionPool) {
            kotlin.jvm.internal.f0.p(connectionPool, "connectionPool");
            s0(connectionPool);
            return this;
        }

        public final void m0(@yt.k okhttp3.b bVar) {
            kotlin.jvm.internal.f0.p(bVar, "<set-?>");
            this.f43470g = bVar;
        }

        @yt.k
        public final a n(@yt.k List<k> connectionSpecs) {
            kotlin.jvm.internal.f0.p(connectionSpecs, "connectionSpecs");
            if (!kotlin.jvm.internal.f0.g(connectionSpecs, C())) {
                J0(null);
            }
            t0(rl.f.h0(connectionSpecs));
            return this;
        }

        public final void n0(@yt.l c cVar) {
            this.f43474k = cVar;
        }

        @yt.k
        public final a o(@yt.k n cookieJar) {
            kotlin.jvm.internal.f0.p(cookieJar, "cookieJar");
            u0(cookieJar);
            return this;
        }

        public final void o0(int i10) {
            this.f43487x = i10;
        }

        @yt.k
        public final a p(@yt.k p dispatcher) {
            kotlin.jvm.internal.f0.p(dispatcher, "dispatcher");
            v0(dispatcher);
            return this;
        }

        public final void p0(@yt.l cm.c cVar) {
            this.f43486w = cVar;
        }

        @yt.k
        public final a q(@yt.k q dns) {
            kotlin.jvm.internal.f0.p(dns, "dns");
            if (!kotlin.jvm.internal.f0.g(dns, F())) {
                J0(null);
            }
            w0(dns);
            return this;
        }

        public final void q0(@yt.k CertificatePinner certificatePinner) {
            kotlin.jvm.internal.f0.p(certificatePinner, "<set-?>");
            this.f43485v = certificatePinner;
        }

        @yt.k
        public final a r(@yt.k r eventListener) {
            kotlin.jvm.internal.f0.p(eventListener, "eventListener");
            x0(rl.f.g(eventListener));
            return this;
        }

        public final void r0(int i10) {
            this.f43488y = i10;
        }

        @yt.k
        public final a s(@yt.k r.c eventListenerFactory) {
            kotlin.jvm.internal.f0.p(eventListenerFactory, "eventListenerFactory");
            x0(eventListenerFactory);
            return this;
        }

        public final void s0(@yt.k j jVar) {
            kotlin.jvm.internal.f0.p(jVar, "<set-?>");
            this.f43465b = jVar;
        }

        @yt.k
        public final a t(boolean z10) {
            y0(z10);
            return this;
        }

        public final void t0(@yt.k List<k> list) {
            kotlin.jvm.internal.f0.p(list, "<set-?>");
            this.f43482s = list;
        }

        @yt.k
        public final a u(boolean z10) {
            z0(z10);
            return this;
        }

        public final void u0(@yt.k n nVar) {
            kotlin.jvm.internal.f0.p(nVar, "<set-?>");
            this.f43473j = nVar;
        }

        @yt.k
        public final okhttp3.b v() {
            return this.f43470g;
        }

        public final void v0(@yt.k p pVar) {
            kotlin.jvm.internal.f0.p(pVar, "<set-?>");
            this.f43464a = pVar;
        }

        @yt.l
        public final c w() {
            return this.f43474k;
        }

        public final void w0(@yt.k q qVar) {
            kotlin.jvm.internal.f0.p(qVar, "<set-?>");
            this.f43475l = qVar;
        }

        public final int x() {
            return this.f43487x;
        }

        public final void x0(@yt.k r.c cVar) {
            kotlin.jvm.internal.f0.p(cVar, "<set-?>");
            this.f43468e = cVar;
        }

        @yt.l
        public final cm.c y() {
            return this.f43486w;
        }

        public final void y0(boolean z10) {
            this.f43471h = z10;
        }

        @yt.k
        public final CertificatePinner z() {
            return this.f43485v;
        }

        public final void z0(boolean z10) {
            this.f43472i = z10;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@yt.k a0 okHttpClient) {
            this();
            kotlin.jvm.internal.f0.p(okHttpClient, "okHttpClient");
            this.f43464a = okHttpClient.Q();
            this.f43465b = okHttpClient.N();
            kotlin.collections.x.n0(this.f43466c, okHttpClient.d0());
            kotlin.collections.x.n0(this.f43467d, okHttpClient.f0());
            this.f43468e = okHttpClient.S();
            this.f43469f = okHttpClient.n0();
            this.f43470g = okHttpClient.G();
            this.f43471h = okHttpClient.V();
            this.f43472i = okHttpClient.Y();
            this.f43473j = okHttpClient.P();
            this.f43474k = okHttpClient.H();
            this.f43475l = okHttpClient.R();
            this.f43476m = okHttpClient.j0();
            this.f43477n = okHttpClient.l0();
            this.f43478o = okHttpClient.k0();
            this.f43479p = okHttpClient.o0();
            this.f43480q = okHttpClient.f43454q;
            this.f43481r = okHttpClient.s0();
            this.f43482s = okHttpClient.O();
            this.f43483t = okHttpClient.i0();
            this.f43484u = okHttpClient.c0();
            this.f43485v = okHttpClient.K();
            this.f43486w = okHttpClient.J();
            this.f43487x = okHttpClient.I();
            this.f43488y = okHttpClient.L();
            this.f43489z = okHttpClient.m0();
            this.A = okHttpClient.r0();
            this.B = okHttpClient.h0();
            this.C = okHttpClient.e0();
            this.D = okHttpClient.a0();
        }
    }

    public a0() {
        this(new a());
    }
}
