package okhttp3.internal.connection;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.umeng.analytics.pro.an;
import dm.e;
import f0.v;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.collections.t;
import kotlin.d0;
import kotlin.jvm.internal.u;
import kotlin.text.StringsKt__IndentKt;
import m0.k;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.f0;
import okhttp3.i;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.r;
import okio.v0;
import v7.a;
import xf.j;
import xl.d;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001RB\u0019\u0012\u0006\u0010Y\u001a\u00020U\u0012\u0006\u0010[\u001a\u00020\u001b¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J*\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0016\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0018\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010!\u001a\u00020 H\u0002J\u000f\u0010#\u001a\u00020\u000bH\u0000¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u000bH\u0000¢\u0006\u0004\b%\u0010$J\u000f\u0010&\u001a\u00020\u000bH\u0000¢\u0006\u0004\b&\u0010$J>\u0010(\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ'\u0010,\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020)2\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0000¢\u0006\u0004\b,\u0010-J\u001f\u00103\u001a\u0002022\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0000¢\u0006\u0004\b3\u00104J\u0017\u00108\u001a\u0002072\u0006\u00106\u001a\u000205H\u0000¢\u0006\u0004\b8\u00109J\b\u0010:\u001a\u00020\u001bH\u0016J\u0006\u0010;\u001a\u00020\u000bJ\b\u0010=\u001a\u00020<H\u0016J\u000e\u0010?\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u001dJ\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010G\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020C2\u0006\u0010F\u001a\u00020EH\u0016J\n\u0010H\u001a\u0004\u0018\u00010 H\u0016J'\u0010L\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020.2\u0006\u0010I\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020JH\u0000¢\u0006\u0004\bL\u0010MJ!\u0010O\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020N2\b\u0010G\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0004\bO\u0010PJ\b\u0010R\u001a\u00020QH\u0016J\b\u0010T\u001a\u00020SH\u0016R\u0017\u0010Y\u001a\u00020U8\u0006¢\u0006\f\n\u0004\bH\u0010V\u001a\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010ZR\u0018\u0010]\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010\\R\u0018\u0010^\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010\\R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010eR\u0018\u0010i\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010hR\"\u0010o\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u0016\u0010p\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010jR\"\u0010u\u001a\u00020\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010q\u001a\u0004\br\u0010s\"\u0004\bq\u0010tR\u0016\u0010v\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010qR\u0016\u0010w\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010qR\u0016\u0010x\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010qR#\u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0z0y8\u0006¢\u0006\f\n\u0004\b\u0011\u0010{\u001a\u0004\b|\u0010}R'\u0010\u0084\u0001\u001a\u00020\u007f8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0004\b|\u0010\u0012\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0086\u0001\u001a\u00020\u001d8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u0010l¨\u0006\u0089\u0001"}, d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lxl/d$c;", "Lokhttp3/i;", "", "connectTimeout", "readTimeout", "writeTimeout", "Lokhttp3/e;", v.E0, "Lokhttp3/r;", "eventListener", "Lkotlin/z1;", "o", k.f40564b, "Lokhttp3/internal/connection/b;", "connectionSpecSelector", "pingIntervalMillis", SsManifestParser.e.J, "J", "n", "Lokhttp3/b0;", "tunnelRequest", "Lokhttp3/u;", "url", "p", "q", "", "Lokhttp3/f0;", "candidates", "", "F", "K", "Lokhttp3/Handshake;", "handshake", j.f55230b, i1.a.S4, "()V", "D", "x", "connectionRetryEnabled", "k", "Lokhttp3/a;", m7.a.f40701a, "routes", "y", "(Lokhttp3/a;Ljava/util/List;)Z", "Lokhttp3/a0;", "client", "Lvl/g;", "chain", "Lvl/d;", "B", "(Lokhttp3/a0;Lvl/g;)Lvl/d;", "Lokhttp3/internal/connection/c;", "exchange", "Ldm/e$d;", "C", "(Lokhttp3/internal/connection/c;)Ldm/e$d;", "b", "i", "Ljava/net/Socket;", "d", "doExtensiveChecks", an.aD, "Lxl/g;", "stream", "f", "Lxl/d;", xl.e.f55522j, "Lxl/k;", "settings", "e", "c", "failedRoute", "Ljava/io/IOException;", "failure", l.f16298a, "(Lokhttp3/a0;Lokhttp3/f0;Ljava/io/IOException;)V", "Lokhttp3/internal/connection/e;", "L", "(Lokhttp3/internal/connection/e;Ljava/io/IOException;)V", "Lokhttp3/Protocol;", "a", "", "toString", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "t", "()Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/f0;", "route", "Ljava/net/Socket;", "rawSocket", "socket", "g", "Lokhttp3/Handshake;", "h", "Lokhttp3/Protocol;", "protocol", "Lokio/l;", "Lokio/l;", "source", "Lokio/k;", "Lokio/k;", "sink", "Z", "v", "()Z", "H", "(Z)V", "noNewExchanges", "noCoalescedConnections", "I", "w", "()I", "(I)V", "routeFailureCount", "successCount", "refusedStreamCount", "allocationLimit", "", "Ljava/lang/ref/Reference;", "Ljava/util/List;", an.aB, "()Ljava/util/List;", "calls", "", "u", "()J", "G", "(J)V", "idleAtNs", i1.a.W4, "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/f;Lokhttp3/f0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class RealConnection extends d.c implements i {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @yt.k
    public static final a f43770t = new a(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @yt.k
    public static final String f43771u = "throw with null exception";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f43772v = 21;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final long f43773w = 10000000000L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final f f43774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final f0 f43775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public Socket f43776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public Socket f43777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public Handshake f43778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public Protocol f43779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public xl.d f43780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public okio.l f43781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.l
    public okio.k f43782k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f43783l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f43784m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f43785n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f43786o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f43787p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f43788q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.k
    public final List<Reference<e>> f43789r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f43790s;

    @d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\b8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/connection/RealConnection$a;", "", "Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/f0;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "a", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final RealConnection a(@yt.k f connectionPool, @yt.k f0 route, @yt.k Socket socket, long j10) {
            kotlin.jvm.internal.f0.p(connectionPool, "connectionPool");
            kotlin.jvm.internal.f0.p(route, "route");
            kotlin.jvm.internal.f0.p(socket, "socket");
            RealConnection realConnection = new RealConnection(connectionPool, route);
            realConnection.f43777f = socket;
            realConnection.G(j10);
            return realConnection;
        }
    }

    @d0(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43791a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            f43791a = iArr;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/RealConnection$c", "Ldm/e$d;", "Lkotlin/z1;", "close", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c extends e.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ okio.l f43792d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ okio.k f43793e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ okhttp3.internal.connection.c f43794f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(okio.l lVar, okio.k kVar, okhttp3.internal.connection.c cVar) {
            super(true, lVar, kVar);
            this.f43792d = lVar;
            this.f43793e = kVar;
            this.f43794f = cVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f43794f.a(-1L, true, true, null);
        }
    }

    public RealConnection(@yt.k f connectionPool, @yt.k f0 route) {
        kotlin.jvm.internal.f0.p(connectionPool, "connectionPool");
        kotlin.jvm.internal.f0.p(route, "route");
        this.f43774c = connectionPool;
        this.f43775d = route;
        this.f43788q = 1;
        this.f43789r = new ArrayList();
        this.f43790s = Long.MAX_VALUE;
    }

    public final boolean A() {
        return this.f43780i != null;
    }

    @yt.k
    public final vl.d B(@yt.k a0 client, @yt.k vl.g chain) throws SocketException {
        kotlin.jvm.internal.f0.p(client, "client");
        kotlin.jvm.internal.f0.p(chain, "chain");
        Socket socket = this.f43777f;
        kotlin.jvm.internal.f0.m(socket);
        okio.l lVar = this.f43781j;
        kotlin.jvm.internal.f0.m(lVar);
        okio.k kVar = this.f43782k;
        kotlin.jvm.internal.f0.m(kVar);
        xl.d dVar = this.f43780i;
        if (dVar != null) {
            return new xl.e(client, this, chain, dVar);
        }
        socket.setSoTimeout(chain.b());
        v0 v0VarU = lVar.U();
        long jN = chain.n();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        v0VarU.i(jN, timeUnit);
        kVar.U().i(chain.p(), timeUnit);
        return new wl.b(client, this, lVar, kVar);
    }

    @yt.k
    public final e.d C(@yt.k okhttp3.internal.connection.c exchange) throws SocketException {
        kotlin.jvm.internal.f0.p(exchange, "exchange");
        Socket socket = this.f43777f;
        kotlin.jvm.internal.f0.m(socket);
        okio.l lVar = this.f43781j;
        kotlin.jvm.internal.f0.m(lVar);
        okio.k kVar = this.f43782k;
        kotlin.jvm.internal.f0.m(kVar);
        socket.setSoTimeout(0);
        E();
        return new c(lVar, kVar, exchange);
    }

    public final synchronized void D() {
        this.f43784m = true;
    }

    public final synchronized void E() {
        this.f43783l = true;
    }

    public final boolean F(List<f0> list) {
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (f0 f0Var : list) {
                if (f0Var.e().type() == Proxy.Type.DIRECT && this.f43775d.e().type() == Proxy.Type.DIRECT && kotlin.jvm.internal.f0.g(this.f43775d.g(), f0Var.g())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void G(long j10) {
        this.f43790s = j10;
    }

    public final void H(boolean z10) {
        this.f43783l = z10;
    }

    public final void I(int i10) {
        this.f43785n = i10;
    }

    public final void J(int i10) throws IOException {
        Socket socket = this.f43777f;
        kotlin.jvm.internal.f0.m(socket);
        okio.l lVar = this.f43781j;
        kotlin.jvm.internal.f0.m(lVar);
        okio.k kVar = this.f43782k;
        kotlin.jvm.internal.f0.m(kVar);
        socket.setSoTimeout(0);
        xl.d dVarA = new d.a(true, ul.d.f52208i).y(socket, this.f43775d.d().w().F(), lVar, kVar).k(this).l(i10).a();
        this.f43780i = dVarA;
        this.f43788q = xl.d.D.a().f();
        xl.d.A2(dVarA, false, null, 3, null);
    }

    public final boolean K(okhttp3.u uVar) {
        Handshake handshake;
        if (rl.f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        okhttp3.u uVarW = this.f43775d.d().w();
        if (uVar.N() != uVarW.N()) {
            return false;
        }
        if (kotlin.jvm.internal.f0.g(uVar.F(), uVarW.F())) {
            return true;
        }
        if (this.f43784m || (handshake = this.f43778g) == null) {
            return false;
        }
        kotlin.jvm.internal.f0.m(handshake);
        return j(uVar, handshake);
    }

    public final synchronized void L(@yt.k e call, @yt.l IOException iOException) {
        kotlin.jvm.internal.f0.p(call, "call");
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i10 = this.f43787p + 1;
                this.f43787p = i10;
                if (i10 > 1) {
                    this.f43783l = true;
                    this.f43785n++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !call.W()) {
                this.f43783l = true;
                this.f43785n++;
            }
        } else if (!A() || (iOException instanceof ConnectionShutdownException)) {
            this.f43783l = true;
            if (this.f43786o == 0) {
                if (iOException != null) {
                    l(call.j(), this.f43775d, iOException);
                }
                this.f43785n++;
            }
        }
    }

    @Override // okhttp3.i
    @yt.k
    public Protocol a() {
        Protocol protocol = this.f43779h;
        kotlin.jvm.internal.f0.m(protocol);
        return protocol;
    }

    @Override // okhttp3.i
    @yt.k
    public f0 b() {
        return this.f43775d;
    }

    @Override // okhttp3.i
    @yt.l
    public Handshake c() {
        return this.f43778g;
    }

    @Override // okhttp3.i
    @yt.k
    public Socket d() {
        Socket socket = this.f43777f;
        kotlin.jvm.internal.f0.m(socket);
        return socket;
    }

    @Override // xl.d.c
    public synchronized void e(@yt.k xl.d connection, @yt.k xl.k settings) {
        kotlin.jvm.internal.f0.p(connection, "connection");
        kotlin.jvm.internal.f0.p(settings, "settings");
        this.f43788q = settings.f();
    }

    @Override // xl.d.c
    public void f(@yt.k xl.g stream) throws IOException {
        kotlin.jvm.internal.f0.p(stream, "stream");
        stream.d(ErrorCode.REFUSED_STREAM, null);
    }

    public final void i() {
        Socket socket = this.f43776e;
        if (socket == null) {
            return;
        }
        rl.f.q(socket);
    }

    public final boolean j(okhttp3.u uVar, Handshake handshake) {
        List<Certificate> listM = handshake.m();
        return (listM.isEmpty() ^ true) && cm.d.f10964a.e(uVar.F(), (X509Certificate) listM.get(0));
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r17, int r18, int r19, int r20, boolean r21, @yt.k okhttp3.e r22, @yt.k okhttp3.r r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.k(int, int, int, int, boolean, okhttp3.e, okhttp3.r):void");
    }

    public final void l(@yt.k a0 client, @yt.k f0 failedRoute, @yt.k IOException failure) {
        kotlin.jvm.internal.f0.p(client, "client");
        kotlin.jvm.internal.f0.p(failedRoute, "failedRoute");
        kotlin.jvm.internal.f0.p(failure, "failure");
        if (failedRoute.e().type() != Proxy.Type.DIRECT) {
            okhttp3.a aVarD = failedRoute.d();
            aVarD.t().connectFailed(aVarD.w().Z(), failedRoute.e().address(), failure);
        }
        client.a0().b(failedRoute);
    }

    public final void m(int i10, int i11, okhttp3.e eVar, r rVar) throws IOException {
        Socket socketCreateSocket;
        Proxy proxyE = this.f43775d.e();
        okhttp3.a aVarD = this.f43775d.d();
        Proxy.Type type = proxyE.type();
        int i12 = type == null ? -1 : b.f43791a[type.ordinal()];
        if (i12 == 1 || i12 == 2) {
            socketCreateSocket = aVarD.u().createSocket();
            kotlin.jvm.internal.f0.m(socketCreateSocket);
        } else {
            socketCreateSocket = new Socket(proxyE);
        }
        this.f43776e = socketCreateSocket;
        rVar.connectStart(eVar, this.f43775d.g(), proxyE);
        socketCreateSocket.setSoTimeout(i11);
        try {
            zl.h.f58636a.g().g(socketCreateSocket, this.f43775d.g(), i10);
            try {
                this.f43781j = okio.f0.e(okio.f0.v(socketCreateSocket));
                this.f43782k = okio.f0.d(okio.f0.q(socketCreateSocket));
            } catch (NullPointerException e10) {
                if (kotlin.jvm.internal.f0.g(e10.getMessage(), f43771u)) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException(kotlin.jvm.internal.f0.C("Failed to connect to ", this.f43775d.g()));
            connectException.initCause(e11);
            throw connectException;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void n(okhttp3.internal.connection.b bVar) throws Throwable {
        final okhttp3.a aVarD = this.f43775d.d();
        SSLSocketFactory sSLSocketFactoryV = aVarD.v();
        SSLSocket sSLSocket = null;
        try {
            kotlin.jvm.internal.f0.m(sSLSocketFactoryV);
            Socket socketCreateSocket = sSLSocketFactoryV.createSocket(this.f43776e, aVarD.w().F(), aVarD.w().N(), true);
            if (socketCreateSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) socketCreateSocket;
            try {
                okhttp3.k kVarA = bVar.a(sSLSocket2);
                if (kVarA.k()) {
                    zl.h.f58636a.g().f(sSLSocket2, aVarD.w().F(), aVarD.q());
                }
                sSLSocket2.startHandshake();
                SSLSession sslSocketSession = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.f43420e;
                kotlin.jvm.internal.f0.o(sslSocketSession, "sslSocketSession");
                final Handshake handshakeB = companion.b(sslSocketSession);
                HostnameVerifier hostnameVerifierP = aVarD.p();
                kotlin.jvm.internal.f0.m(hostnameVerifierP);
                if (hostnameVerifierP.verify(aVarD.w().F(), sslSocketSession)) {
                    final CertificatePinner certificatePinnerL = aVarD.l();
                    kotlin.jvm.internal.f0.m(certificatePinnerL);
                    this.f43778g = new Handshake(handshakeB.o(), handshakeB.g(), handshakeB.k(), new ik.a<List<? extends Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // ik.a
                        @yt.k
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final List<Certificate> o() {
                            cm.c cVarE = certificatePinnerL.e();
                            kotlin.jvm.internal.f0.m(cVarE);
                            return cVarE.a(handshakeB.m(), aVarD.w().F());
                        }
                    });
                    certificatePinnerL.c(aVarD.w().F(), new ik.a<List<? extends X509Certificate>>() { // from class: okhttp3.internal.connection.RealConnection$connectTls$2
                        {
                            super(0);
                        }

                        @Override // ik.a
                        @yt.k
                        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                        public final List<X509Certificate> o() {
                            Handshake handshake = this.this$0.f43778g;
                            kotlin.jvm.internal.f0.m(handshake);
                            List<Certificate> listM = handshake.m();
                            ArrayList arrayList = new ArrayList(t.Y(listM, 10));
                            Iterator<T> it2 = listM.iterator();
                            while (it2.hasNext()) {
                                arrayList.add((X509Certificate) ((Certificate) it2.next()));
                            }
                            return arrayList;
                        }
                    });
                    String strJ = kVarA.k() ? zl.h.f58636a.g().j(sSLSocket2) : null;
                    this.f43777f = sSLSocket2;
                    this.f43781j = okio.f0.e(okio.f0.v(sSLSocket2));
                    this.f43782k = okio.f0.d(okio.f0.q(sSLSocket2));
                    this.f43779h = strJ != null ? Protocol.Companion.a(strJ) : Protocol.HTTP_1_1;
                    zl.h.f58636a.g().c(sSLSocket2);
                    return;
                }
                List<Certificate> listM = handshakeB.m();
                if (!(!listM.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVarD.w().F() + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) listM.get(0);
                throw new SSLPeerUnverifiedException(StringsKt__IndentKt.r("\n              |Hostname " + aVarD.w().F() + " not verified:\n              |    certificate: " + CertificatePinner.f43412c.a(x509Certificate) + "\n              |    DN: " + ((Object) x509Certificate.getSubjectDN().getName()) + "\n              |    subjectAltNames: " + cm.d.f10964a.a(x509Certificate) + "\n              ", null, 1, null));
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    zl.h.f58636a.g().c(sSLSocket);
                }
                if (sSLSocket != null) {
                    rl.f.q(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final void o(int i10, int i11, int i12, okhttp3.e eVar, r rVar) throws IOException {
        b0 b0VarQ = q();
        okhttp3.u uVarQ = b0VarQ.q();
        int i13 = 0;
        while (i13 < 21) {
            i13++;
            m(i10, i11, eVar, rVar);
            b0VarQ = p(i11, i12, b0VarQ, uVarQ);
            if (b0VarQ == null) {
                return;
            }
            Socket socket = this.f43776e;
            if (socket != null) {
                rl.f.q(socket);
            }
            this.f43776e = null;
            this.f43782k = null;
            this.f43781j = null;
            rVar.connectEnd(eVar, this.f43775d.g(), this.f43775d.e(), null);
        }
    }

    public final b0 p(int i10, int i11, b0 b0Var, okhttp3.u uVar) throws IOException {
        String str = "CONNECT " + rl.f.f0(uVar, true) + " HTTP/1.1";
        while (true) {
            okio.l lVar = this.f43781j;
            kotlin.jvm.internal.f0.m(lVar);
            okio.k kVar = this.f43782k;
            kotlin.jvm.internal.f0.m(kVar);
            wl.b bVar = new wl.b(null, this, lVar, kVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            lVar.U().i(i10, timeUnit);
            kVar.U().i(i11, timeUnit);
            bVar.C(b0Var.k(), str);
            bVar.a();
            d0.a aVarD = bVar.d(false);
            kotlin.jvm.internal.f0.m(aVarD);
            okhttp3.d0 d0VarC = aVarD.E(b0Var).c();
            bVar.B(d0VarC);
            int iW = d0VarC.W();
            if (iW == 200) {
                if (lVar.g().d0() && kVar.g().d0()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (iW != 407) {
                throw new IOException(kotlin.jvm.internal.f0.C("Unexpected response code for CONNECT: ", Integer.valueOf(d0VarC.W())));
            }
            b0 b0VarA = this.f43775d.d().s().a(this.f43775d, d0VarC);
            if (b0VarA == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (kotlin.text.u.L1("close", okhttp3.d0.M0(d0VarC, HttpHeaders.CONNECTION, null, 2, null), true)) {
                return b0VarA;
            }
            b0Var = b0VarA;
        }
    }

    public final b0 q() throws IOException {
        b0 b0VarB = new b0.a().D(this.f43775d.d().w()).p("CONNECT", null).n(HttpHeaders.HOST, rl.f.f0(this.f43775d.d().w(), true)).n("Proxy-Connection", "Keep-Alive").n("User-Agent", rl.f.f48805j).b();
        b0 b0VarA = this.f43775d.d().s().a(this.f43775d, new d0.a().E(b0VarB).B(Protocol.HTTP_1_1).g(a.c.F).y("Preemptive Authenticate").b(rl.f.f48798c).F(-1L).C(-1L).v(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").c());
        return b0VarA == null ? b0VarB : b0VarA;
    }

    public final void r(okhttp3.internal.connection.b bVar, int i10, okhttp3.e eVar, r rVar) throws Throwable {
        if (this.f43775d.d().v() != null) {
            rVar.secureConnectStart(eVar);
            n(bVar);
            rVar.secureConnectEnd(eVar, this.f43778g);
            if (this.f43779h == Protocol.HTTP_2) {
                J(i10);
                return;
            }
            return;
        }
        List<Protocol> listQ = this.f43775d.d().q();
        Protocol protocol = Protocol.H2_PRIOR_KNOWLEDGE;
        if (!listQ.contains(protocol)) {
            this.f43777f = this.f43776e;
            this.f43779h = Protocol.HTTP_1_1;
        } else {
            this.f43777f = this.f43776e;
            this.f43779h = protocol;
            J(i10);
        }
    }

    @yt.k
    public final List<Reference<e>> s() {
        return this.f43789r;
    }

    @yt.k
    public final f t() {
        return this.f43774c;
    }

    @yt.k
    public String toString() {
        okhttp3.h hVarG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.f43775d.d().w().F());
        sb2.append(':');
        sb2.append(this.f43775d.d().w().N());
        sb2.append(", proxy=");
        sb2.append(this.f43775d.e());
        sb2.append(" hostAddress=");
        sb2.append(this.f43775d.g());
        sb2.append(" cipherSuite=");
        Handshake handshake = this.f43778g;
        Object obj = "none";
        if (handshake != null && (hVarG = handshake.g()) != null) {
            obj = hVarG;
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.f43779h);
        sb2.append('}');
        return sb2.toString();
    }

    public final long u() {
        return this.f43790s;
    }

    public final boolean v() {
        return this.f43783l;
    }

    public final int w() {
        return this.f43785n;
    }

    public final synchronized void x() {
        this.f43786o++;
    }

    public final boolean y(@yt.k okhttp3.a address, @yt.l List<f0> list) {
        kotlin.jvm.internal.f0.p(address, "address");
        if (rl.f.f48803h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
        }
        if (this.f43789r.size() >= this.f43788q || this.f43783l || !this.f43775d.d().o(address)) {
            return false;
        }
        if (kotlin.jvm.internal.f0.g(address.w().F(), b().d().w().F())) {
            return true;
        }
        if (this.f43780i == null || list == null || !F(list) || address.p() != cm.d.f10964a || !K(address.w())) {
            return false;
        }
        try {
            CertificatePinner certificatePinnerL = address.l();
            kotlin.jvm.internal.f0.m(certificatePinnerL);
            String strF = address.w().F();
            Handshake handshakeC = c();
            kotlin.jvm.internal.f0.m(handshakeC);
            certificatePinnerL.a(strF, handshakeC.m());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean z(boolean z10) {
        long jU;
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        long jNanoTime = System.nanoTime();
        Socket socket = this.f43776e;
        kotlin.jvm.internal.f0.m(socket);
        Socket socket2 = this.f43777f;
        kotlin.jvm.internal.f0.m(socket2);
        okio.l lVar = this.f43781j;
        kotlin.jvm.internal.f0.m(lVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        xl.d dVar = this.f43780i;
        if (dVar != null) {
            return dVar.h2(jNanoTime);
        }
        synchronized (this) {
            jU = jNanoTime - u();
        }
        if (jU < f43773w || !z10) {
            return true;
        }
        return rl.f.N(socket2, lVar);
    }
}
