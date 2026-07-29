package em;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.tencent.open.SocialConstants;
import f0.v;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.b0;
import okhttp3.i;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.r;
import xl.e;
import yt.k;
import yt.l;
import zc.f;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001CB\u0011\b\u0002\u0012\u0006\u0010@\u001a\u00020?¢\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J&\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J*\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J2\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u0010/\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u00103\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0016J\u0018\u00106\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016J\u0018\u0010;\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010=\u001a\u000201H\u0016¨\u0006D"}, d2 = {"Lem/a;", "Lokhttp3/r;", "", "message", "Lkotlin/z1;", "b", "Lokhttp3/e;", v.E0, "callStart", "Lokhttp3/u;", "url", "proxySelectStart", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "domainName", "dnsStart", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "Ljava/net/InetSocketAddress;", "inetSocketAddress", IOptionConstant.proxy, "connectStart", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "Lokhttp3/Protocol;", "protocol", "connectEnd", "Ljava/io/IOException;", "ioe", "connectFailed", "Lokhttp3/i;", e.f55522j, "connectionAcquired", "connectionReleased", "requestHeadersStart", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "requestHeadersEnd", "requestBodyStart", "", "byteCount", "requestBodyEnd", "requestFailed", "responseHeadersStart", "Lokhttp3/d0;", "response", "responseHeadersEnd", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$a;)V", "a", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
public final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final HttpLoggingInterceptor.a f27034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f27035b;

    public a(HttpLoggingInterceptor.a aVar) {
        this.f27034a = aVar;
    }

    public /* synthetic */ a(HttpLoggingInterceptor.a aVar, u uVar) {
        this(aVar);
    }

    public final void b(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.f27035b);
        this.f27034a.a('[' + millis + " ms] " + str);
    }

    @Override // okhttp3.r
    public void cacheConditionalHit(@k okhttp3.e call, @k okhttp3.d0 cachedResponse) {
        f0.p(call, "call");
        f0.p(cachedResponse, "cachedResponse");
        b(f0.C("cacheConditionalHit: ", cachedResponse));
    }

    @Override // okhttp3.r
    public void cacheHit(@k okhttp3.e call, @k okhttp3.d0 response) {
        f0.p(call, "call");
        f0.p(response, "response");
        b(f0.C("cacheHit: ", response));
    }

    @Override // okhttp3.r
    public void cacheMiss(@k okhttp3.e call) {
        f0.p(call, "call");
        b("cacheMiss");
    }

    @Override // okhttp3.r
    public void callEnd(@k okhttp3.e call) {
        f0.p(call, "call");
        b("callEnd");
    }

    @Override // okhttp3.r
    public void callFailed(@k okhttp3.e call, @k IOException ioe) {
        f0.p(call, "call");
        f0.p(ioe, "ioe");
        b(f0.C("callFailed: ", ioe));
    }

    @Override // okhttp3.r
    public void callStart(@k okhttp3.e call) {
        f0.p(call, "call");
        this.f27035b = System.nanoTime();
        b(f0.C("callStart: ", call.T()));
    }

    @Override // okhttp3.r
    public void canceled(@k okhttp3.e call) {
        f0.p(call, "call");
        b("canceled");
    }

    @Override // okhttp3.r
    public void connectEnd(@k okhttp3.e call, @k InetSocketAddress inetSocketAddress, @k Proxy proxy, @l Protocol protocol) {
        f0.p(call, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        b(f0.C("connectEnd: ", protocol));
    }

    @Override // okhttp3.r
    public void connectFailed(@k okhttp3.e call, @k InetSocketAddress inetSocketAddress, @k Proxy proxy, @l Protocol protocol, @k IOException ioe) {
        f0.p(call, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        f0.p(ioe, "ioe");
        b("connectFailed: " + protocol + f.f58383m + ioe);
    }

    @Override // okhttp3.r
    public void connectStart(@k okhttp3.e call, @k InetSocketAddress inetSocketAddress, @k Proxy proxy) {
        f0.p(call, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        b("connectStart: " + inetSocketAddress + f.f58383m + proxy);
    }

    @Override // okhttp3.r
    public void connectionAcquired(@k okhttp3.e call, @k i connection) {
        f0.p(call, "call");
        f0.p(connection, "connection");
        b(f0.C("connectionAcquired: ", connection));
    }

    @Override // okhttp3.r
    public void connectionReleased(@k okhttp3.e call, @k i connection) {
        f0.p(call, "call");
        f0.p(connection, "connection");
        b("connectionReleased");
    }

    @Override // okhttp3.r
    public void dnsEnd(@k okhttp3.e call, @k String domainName, @k List<? extends InetAddress> inetAddressList) {
        f0.p(call, "call");
        f0.p(domainName, "domainName");
        f0.p(inetAddressList, "inetAddressList");
        b(f0.C("dnsEnd: ", inetAddressList));
    }

    @Override // okhttp3.r
    public void dnsStart(@k okhttp3.e call, @k String domainName) {
        f0.p(call, "call");
        f0.p(domainName, "domainName");
        b(f0.C("dnsStart: ", domainName));
    }

    @Override // okhttp3.r
    public void proxySelectEnd(@k okhttp3.e call, @k okhttp3.u url, @k List<? extends Proxy> proxies) {
        f0.p(call, "call");
        f0.p(url, "url");
        f0.p(proxies, "proxies");
        b(f0.C("proxySelectEnd: ", proxies));
    }

    @Override // okhttp3.r
    public void proxySelectStart(@k okhttp3.e call, @k okhttp3.u url) {
        f0.p(call, "call");
        f0.p(url, "url");
        b(f0.C("proxySelectStart: ", url));
    }

    @Override // okhttp3.r
    public void requestBodyEnd(@k okhttp3.e call, long j10) {
        f0.p(call, "call");
        b(f0.C("requestBodyEnd: byteCount=", Long.valueOf(j10)));
    }

    @Override // okhttp3.r
    public void requestBodyStart(@k okhttp3.e call) {
        f0.p(call, "call");
        b("requestBodyStart");
    }

    @Override // okhttp3.r
    public void requestFailed(@k okhttp3.e call, @k IOException ioe) {
        f0.p(call, "call");
        f0.p(ioe, "ioe");
        b(f0.C("requestFailed: ", ioe));
    }

    @Override // okhttp3.r
    public void requestHeadersEnd(@k okhttp3.e call, @k b0 request) {
        f0.p(call, "call");
        f0.p(request, "request");
        b("requestHeadersEnd");
    }

    @Override // okhttp3.r
    public void requestHeadersStart(@k okhttp3.e call) {
        f0.p(call, "call");
        b("requestHeadersStart");
    }

    @Override // okhttp3.r
    public void responseBodyEnd(@k okhttp3.e call, long j10) {
        f0.p(call, "call");
        b(f0.C("responseBodyEnd: byteCount=", Long.valueOf(j10)));
    }

    @Override // okhttp3.r
    public void responseBodyStart(@k okhttp3.e call) {
        f0.p(call, "call");
        b("responseBodyStart");
    }

    @Override // okhttp3.r
    public void responseFailed(@k okhttp3.e call, @k IOException ioe) {
        f0.p(call, "call");
        f0.p(ioe, "ioe");
        b(f0.C("responseFailed: ", ioe));
    }

    @Override // okhttp3.r
    public void responseHeadersEnd(@k okhttp3.e call, @k okhttp3.d0 response) {
        f0.p(call, "call");
        f0.p(response, "response");
        b(f0.C("responseHeadersEnd: ", response));
    }

    @Override // okhttp3.r
    public void responseHeadersStart(@k okhttp3.e call) {
        f0.p(call, "call");
        b("responseHeadersStart");
    }

    @Override // okhttp3.r
    public void satisfactionFailure(@k okhttp3.e call, @k okhttp3.d0 response) {
        f0.p(call, "call");
        f0.p(response, "response");
        b(f0.C("satisfactionFailure: ", response));
    }

    @Override // okhttp3.r
    public void secureConnectEnd(@k okhttp3.e call, @l Handshake handshake) {
        f0.p(call, "call");
        b(f0.C("secureConnectEnd: ", handshake));
    }

    @Override // okhttp3.r
    public void secureConnectStart(@k okhttp3.e call) {
        f0.p(call, "call");
        b("secureConnectStart");
    }

    /* JADX INFO: renamed from: em.a$a, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lem/a$a;", "Lokhttp3/r$c;", "Lokhttp3/e;", v.E0, "Lokhttp3/r;", "create", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$a;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
    public static class C0312a implements r.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final HttpLoggingInterceptor.a f27036a;

        /* JADX WARN: Multi-variable type inference failed */
        @hk.i
        public C0312a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @hk.i
        public C0312a(@k HttpLoggingInterceptor.a logger) {
            f0.p(logger, "logger");
            this.f27036a = logger;
        }

        @Override // okhttp3.r.c
        @k
        public r create(@k okhttp3.e call) {
            f0.p(call, "call");
            return new a(this.f27036a, null);
        }

        public /* synthetic */ C0312a(HttpLoggingInterceptor.a aVar, int i10, u uVar) {
            this((i10 & 1) != 0 ? HttpLoggingInterceptor.a.f43899b : aVar);
        }
    }
}
