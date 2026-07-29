package okhttp3.internal.connection;

import com.arialyy.aria.core.inf.IOptionConstant;
import f0.v;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.collections.x;
import kotlin.d0;
import kotlin.jvm.internal.u;
import okhttp3.f0;
import okhttp3.r;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0002\u0003\fB'\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0015\u0012\u0006\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020!0\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001c¨\u0006+"}, d2 = {"Lokhttp3/internal/connection/h;", "", "", "a", "Lokhttp3/internal/connection/h$b;", "c", "Lokhttp3/u;", "url", "Ljava/net/Proxy;", IOptionConstant.proxy, "Lkotlin/z1;", "f", "b", "d", "e", "Lokhttp3/a;", "Lokhttp3/a;", m7.a.f40701a, "Lokhttp3/internal/connection/g;", "Lokhttp3/internal/connection/g;", "routeDatabase", "Lokhttp3/e;", "Lokhttp3/e;", v.E0, "Lokhttp3/r;", "Lokhttp3/r;", "eventListener", "", "Ljava/util/List;", "proxies", "", "I", "nextProxyIndex", "Ljava/net/InetSocketAddress;", "g", "inetSocketAddresses", "", "Lokhttp3/f0;", "h", "postponedRoutes", "<init>", "(Lokhttp3/a;Lokhttp3/internal/connection/g;Lokhttp3/e;Lokhttp3/r;)V", "i", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final a f43858i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final okhttp3.a f43859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final g f43860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final okhttp3.e f43861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final r f43862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public List<? extends Proxy> f43863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f43864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public List<? extends InetSocketAddress> f43865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final List<f0> f43866h;

    @d0(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lokhttp3/internal/connection/h$a;", "", "Ljava/net/InetSocketAddress;", "", "a", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final String a(@k InetSocketAddress inetSocketAddress) {
            kotlin.jvm.internal.f0.p(inetSocketAddress, "<this>");
            InetAddress address = inetSocketAddress.getAddress();
            if (address == null) {
                String hostName = inetSocketAddress.getHostName();
                kotlin.jvm.internal.f0.o(hostName, "hostName");
                return hostName;
            }
            String hostAddress = address.getHostAddress();
            kotlin.jvm.internal.f0.o(hostAddress, "address.hostAddress");
            return hostAddress;
        }
    }

    @d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/connection/h$b;", "", "", "b", "Lokhttp3/f0;", "c", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "routes", "", "I", "nextRouteIndex", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final List<f0> f43867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f43868b;

        public b(@k List<f0> routes) {
            kotlin.jvm.internal.f0.p(routes, "routes");
            this.f43867a = routes;
        }

        @k
        public final List<f0> a() {
            return this.f43867a;
        }

        public final boolean b() {
            return this.f43868b < this.f43867a.size();
        }

        @k
        public final f0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<f0> list = this.f43867a;
            int i10 = this.f43868b;
            this.f43868b = i10 + 1;
            return list.get(i10);
        }
    }

    public h(@k okhttp3.a address, @k g routeDatabase, @k okhttp3.e call, @k r eventListener) {
        kotlin.jvm.internal.f0.p(address, "address");
        kotlin.jvm.internal.f0.p(routeDatabase, "routeDatabase");
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(eventListener, "eventListener");
        this.f43859a = address;
        this.f43860b = routeDatabase;
        this.f43861c = call;
        this.f43862d = eventListener;
        this.f43863e = CollectionsKt__CollectionsKt.E();
        this.f43865g = CollectionsKt__CollectionsKt.E();
        this.f43866h = new ArrayList();
        f(address.w(), address.r());
    }

    public static final List<Proxy> g(Proxy proxy, okhttp3.u uVar, h hVar) {
        if (proxy != null) {
            return s.k(proxy);
        }
        URI uriZ = uVar.Z();
        if (uriZ.getHost() == null) {
            return rl.f.C(Proxy.NO_PROXY);
        }
        List<Proxy> proxiesOrNull = hVar.f43859a.t().select(uriZ);
        if (proxiesOrNull == null || proxiesOrNull.isEmpty()) {
            return rl.f.C(Proxy.NO_PROXY);
        }
        kotlin.jvm.internal.f0.o(proxiesOrNull, "proxiesOrNull");
        return rl.f.h0(proxiesOrNull);
    }

    public final boolean a() {
        return b() || (this.f43866h.isEmpty() ^ true);
    }

    public final boolean b() {
        return this.f43864f < this.f43863e.size();
    }

    @k
    public final b c() throws IOException {
        if (!a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (b()) {
            Proxy proxyD = d();
            Iterator<? extends InetSocketAddress> it2 = this.f43865g.iterator();
            while (it2.hasNext()) {
                f0 f0Var = new f0(this.f43859a, proxyD, it2.next());
                if (this.f43860b.c(f0Var)) {
                    this.f43866h.add(f0Var);
                } else {
                    arrayList.add(f0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            x.n0(arrayList, this.f43866h);
            this.f43866h.clear();
        }
        return new b(arrayList);
    }

    public final Proxy d() throws IOException {
        if (b()) {
            List<? extends Proxy> list = this.f43863e;
            int i10 = this.f43864f;
            this.f43864f = i10 + 1;
            Proxy proxy = list.get(i10);
            e(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f43859a.w().F() + "; exhausted proxy configurations: " + this.f43863e);
    }

    public final void e(Proxy proxy) throws IOException {
        String strF;
        int iN;
        ArrayList arrayList = new ArrayList();
        this.f43865g = arrayList;
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            strF = this.f43859a.w().F();
            iN = this.f43859a.w().N();
        } else {
            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Proxy.address() is not an InetSocketAddress: ", proxyAddress.getClass()).toString());
            }
            a aVar = f43858i;
            kotlin.jvm.internal.f0.o(proxyAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress = (InetSocketAddress) proxyAddress;
            strF = aVar.a(inetSocketAddress);
            iN = inetSocketAddress.getPort();
        }
        boolean z10 = false;
        if (1 <= iN && iN < 65536) {
            z10 = true;
        }
        if (!z10) {
            throw new SocketException("No route to " + strF + ':' + iN + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            arrayList.add(InetSocketAddress.createUnresolved(strF, iN));
            return;
        }
        this.f43862d.dnsStart(this.f43861c, strF);
        List<InetAddress> listA = this.f43859a.n().a(strF);
        if (listA.isEmpty()) {
            throw new UnknownHostException(this.f43859a.n() + " returned no addresses for " + strF);
        }
        this.f43862d.dnsEnd(this.f43861c, strF, listA);
        Iterator<InetAddress> it2 = listA.iterator();
        while (it2.hasNext()) {
            arrayList.add(new InetSocketAddress(it2.next(), iN));
        }
    }

    public final void f(okhttp3.u uVar, Proxy proxy) {
        this.f43862d.proxySelectStart(this.f43861c, uVar);
        List<Proxy> listG = g(proxy, uVar, this);
        this.f43863e = listG;
        this.f43864f = 0;
        this.f43862d.proxySelectEnd(this.f43861c, uVar, listG);
    }
}
