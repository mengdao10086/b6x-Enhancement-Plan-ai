package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.DeprecationLevel;
import kotlin.t0;
import okhttp3.u;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b&\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010M\u001a\u00020+\u0012\u0006\u0010N\u001a\u00020&\u0012\u0006\u0010/\u001a\u00020\u0005\u0012\u0006\u00102\u001a\u00020\b\u0012\b\u00105\u001a\u0004\u0018\u00010\u001a\u0012\b\u00108\u001a\u0004\u0018\u00010\u001d\u0012\b\u0010;\u001a\u0004\u0018\u00010 \u0012\u0006\u0010>\u001a\u00020\u000b\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0017\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e\u0012\u0006\u0010D\u001a\u00020\u0014¢\u0006\u0004\bO\u0010PJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0007¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010!\u001a\u0004\u0018\u00010 H\u0007¢\u0006\u0004\b!\u0010\"J\u0013\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010'\u001a\u00020&H\u0016J\u0017\u0010)\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0000H\u0000¢\u0006\u0004\b)\u0010*J\b\u0010,\u001a\u00020+H\u0016R\u0017\u0010/\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b!\u0010-\u001a\u0004\b.\u0010\u0007R\u0017\u00102\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b1\u0010\nR\u0019\u00105\u001a\u0004\u0018\u00010\u001a8\u0007¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b4\u0010\u001cR\u0019\u00108\u001a\u0004\u0018\u00010\u001d8\u0007¢\u0006\f\n\u0004\b\u001e\u00106\u001a\u0004\b7\u0010\u001fR\u0019\u0010;\u001a\u0004\u0018\u00010 8\u0007¢\u0006\f\n\u0004\b\u0010\u00109\u001a\u0004\b:\u0010\"R\u0017\u0010>\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b\u0018\u0010<\u001a\u0004\b=\u0010\rR\u0019\u0010A\u001a\u0004\u0018\u00010\u00178\u0007¢\u0006\f\n\u0004\b\f\u0010?\u001a\u0004\b@\u0010\u0019R\u0017\u0010D\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010B\u001a\u0004\bC\u0010\u0016R\u0017\u0010G\u001a\u00020\u00028G¢\u0006\f\n\u0004\b\t\u0010E\u001a\u0004\bF\u0010\u0004R\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8G¢\u0006\f\n\u0004\b\u001b\u0010H\u001a\u0004\bI\u0010\u0011R\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e8G¢\u0006\f\n\u0004\b\u0003\u0010H\u001a\u0004\bK\u0010\u0011¨\u0006Q"}, d2 = {"Lokhttp3/a;", "", "Lokhttp3/u;", "k", "()Lokhttp3/u;", "Lokhttp3/q;", "c", "()Lokhttp3/q;", "Ljavax/net/SocketFactory;", "i", "()Ljavax/net/SocketFactory;", "Lokhttp3/b;", "g", "()Lokhttp3/b;", "", "Lokhttp3/Protocol;", "e", "()Ljava/util/List;", "Lokhttp3/k;", "b", "Ljava/net/ProxySelector;", "h", "()Ljava/net/ProxySelector;", "Ljava/net/Proxy;", "f", "()Ljava/net/Proxy;", "Ljavax/net/ssl/SSLSocketFactory;", xf.j.f55230b, "()Ljavax/net/ssl/SSLSocketFactory;", "Ljavax/net/ssl/HostnameVerifier;", "d", "()Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/CertificatePinner;", "a", "()Lokhttp3/CertificatePinner;", "other", "", "equals", "", "hashCode", "that", "o", "(Lokhttp3/a;)Z", "", "toString", "Lokhttp3/q;", "n", "dns", "Ljavax/net/SocketFactory;", "u", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "v", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "p", "hostnameVerifier", "Lokhttp3/CertificatePinner;", com.flydigi.sdk.bluetooth.l.f16298a, "certificatePinner", "Lokhttp3/b;", an.aB, "proxyAuthenticator", "Ljava/net/Proxy;", SsManifestParser.e.J, IOptionConstant.proxy, "Ljava/net/ProxySelector;", "t", "proxySelector", "Lokhttp3/u;", "w", "url", "Ljava/util/List;", "q", "protocols", m0.k.f40564b, "connectionSpecs", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/q;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/b;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final q f43425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final SocketFactory f43426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final SSLSocketFactory f43427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final HostnameVerifier f43428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final CertificatePinner f43429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final b f43430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final Proxy f43431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public final ProxySelector f43432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final u f43433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public final List<Protocol> f43434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public final List<k> f43435k;

    public a(@yt.k String uriHost, int i10, @yt.k q dns, @yt.k SocketFactory socketFactory, @yt.l SSLSocketFactory sSLSocketFactory, @yt.l HostnameVerifier hostnameVerifier, @yt.l CertificatePinner certificatePinner, @yt.k b proxyAuthenticator, @yt.l Proxy proxy, @yt.k List<? extends Protocol> protocols, @yt.k List<k> connectionSpecs, @yt.k ProxySelector proxySelector) {
        kotlin.jvm.internal.f0.p(uriHost, "uriHost");
        kotlin.jvm.internal.f0.p(dns, "dns");
        kotlin.jvm.internal.f0.p(socketFactory, "socketFactory");
        kotlin.jvm.internal.f0.p(proxyAuthenticator, "proxyAuthenticator");
        kotlin.jvm.internal.f0.p(protocols, "protocols");
        kotlin.jvm.internal.f0.p(connectionSpecs, "connectionSpecs");
        kotlin.jvm.internal.f0.p(proxySelector, "proxySelector");
        this.f43425a = dns;
        this.f43426b = socketFactory;
        this.f43427c = sSLSocketFactory;
        this.f43428d = hostnameVerifier;
        this.f43429e = certificatePinner;
        this.f43430f = proxyAuthenticator;
        this.f43431g = proxy;
        this.f43432h = proxySelector;
        this.f43433i = new u.a().M(sSLSocketFactory != null ? "https" : "http").x(uriHost).D(i10).h();
        this.f43434j = rl.f.h0(protocols);
        this.f43435k = rl.f.h0(connectionSpecs);
    }

    @hk.h(name = "-deprecated_certificatePinner")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "certificatePinner", imports = {}))
    @yt.l
    public final CertificatePinner a() {
        return this.f43429e;
    }

    @hk.h(name = "-deprecated_connectionSpecs")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "connectionSpecs", imports = {}))
    @yt.k
    public final List<k> b() {
        return this.f43435k;
    }

    @hk.h(name = "-deprecated_dns")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "dns", imports = {}))
    @yt.k
    public final q c() {
        return this.f43425a;
    }

    @hk.h(name = "-deprecated_hostnameVerifier")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "hostnameVerifier", imports = {}))
    @yt.l
    public final HostnameVerifier d() {
        return this.f43428d;
    }

    @hk.h(name = "-deprecated_protocols")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "protocols", imports = {}))
    @yt.k
    public final List<Protocol> e() {
        return this.f43434j;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (kotlin.jvm.internal.f0.g(this.f43433i, aVar.f43433i) && o(aVar)) {
                return true;
            }
        }
        return false;
    }

    @hk.h(name = "-deprecated_proxy")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.proxy, imports = {}))
    @yt.l
    public final Proxy f() {
        return this.f43431g;
    }

    @hk.h(name = "-deprecated_proxyAuthenticator")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "proxyAuthenticator", imports = {}))
    @yt.k
    public final b g() {
        return this.f43430f;
    }

    @hk.h(name = "-deprecated_proxySelector")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "proxySelector", imports = {}))
    @yt.k
    public final ProxySelector h() {
        return this.f43432h;
    }

    public int hashCode() {
        return ((((((((((((((((((527 + this.f43433i.hashCode()) * 31) + this.f43425a.hashCode()) * 31) + this.f43430f.hashCode()) * 31) + this.f43434j.hashCode()) * 31) + this.f43435k.hashCode()) * 31) + this.f43432h.hashCode()) * 31) + Objects.hashCode(this.f43431g)) * 31) + Objects.hashCode(this.f43427c)) * 31) + Objects.hashCode(this.f43428d)) * 31) + Objects.hashCode(this.f43429e);
    }

    @hk.h(name = "-deprecated_socketFactory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "socketFactory", imports = {}))
    @yt.k
    public final SocketFactory i() {
        return this.f43426b;
    }

    @hk.h(name = "-deprecated_sslSocketFactory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "sslSocketFactory", imports = {}))
    @yt.l
    public final SSLSocketFactory j() {
        return this.f43427c;
    }

    @hk.h(name = "-deprecated_url")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "url", imports = {}))
    @yt.k
    public final u k() {
        return this.f43433i;
    }

    @hk.h(name = "certificatePinner")
    @yt.l
    public final CertificatePinner l() {
        return this.f43429e;
    }

    @hk.h(name = "connectionSpecs")
    @yt.k
    public final List<k> m() {
        return this.f43435k;
    }

    @hk.h(name = "dns")
    @yt.k
    public final q n() {
        return this.f43425a;
    }

    public final boolean o(@yt.k a that) {
        kotlin.jvm.internal.f0.p(that, "that");
        return kotlin.jvm.internal.f0.g(this.f43425a, that.f43425a) && kotlin.jvm.internal.f0.g(this.f43430f, that.f43430f) && kotlin.jvm.internal.f0.g(this.f43434j, that.f43434j) && kotlin.jvm.internal.f0.g(this.f43435k, that.f43435k) && kotlin.jvm.internal.f0.g(this.f43432h, that.f43432h) && kotlin.jvm.internal.f0.g(this.f43431g, that.f43431g) && kotlin.jvm.internal.f0.g(this.f43427c, that.f43427c) && kotlin.jvm.internal.f0.g(this.f43428d, that.f43428d) && kotlin.jvm.internal.f0.g(this.f43429e, that.f43429e) && this.f43433i.N() == that.f43433i.N();
    }

    @hk.h(name = "hostnameVerifier")
    @yt.l
    public final HostnameVerifier p() {
        return this.f43428d;
    }

    @hk.h(name = "protocols")
    @yt.k
    public final List<Protocol> q() {
        return this.f43434j;
    }

    @hk.h(name = IOptionConstant.proxy)
    @yt.l
    public final Proxy r() {
        return this.f43431g;
    }

    @hk.h(name = "proxyAuthenticator")
    @yt.k
    public final b s() {
        return this.f43430f;
    }

    @hk.h(name = "proxySelector")
    @yt.k
    public final ProxySelector t() {
        return this.f43432h;
    }

    @yt.k
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f43433i.F());
        sb2.append(':');
        sb2.append(this.f43433i.N());
        sb2.append(", ");
        Object obj = this.f43431g;
        if (obj != null) {
            str = "proxy=";
        } else {
            obj = this.f43432h;
            str = "proxySelector=";
        }
        sb2.append(kotlin.jvm.internal.f0.C(str, obj));
        sb2.append('}');
        return sb2.toString();
    }

    @hk.h(name = "socketFactory")
    @yt.k
    public final SocketFactory u() {
        return this.f43426b;
    }

    @hk.h(name = "sslSocketFactory")
    @yt.l
    public final SSLSocketFactory v() {
        return this.f43427c;
    }

    @hk.h(name = "url")
    @yt.k
    public final u w() {
        return this.f43433i;
    }
}
