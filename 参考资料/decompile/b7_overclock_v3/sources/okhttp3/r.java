package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b&\u0018\u0000 @2\u00020\u0001:\u0002ABB\u0007¢\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J+\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0011\u0010\f\u001a\r\u0012\t\u0012\u00070\n¢\u0006\u0002\b\u000b0\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J+\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0011\u0010\u0012\u001a\r\u0012\t\u0012\u00070\u0011¢\u0006\u0002\b\u000b0\tH\u0016J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J*\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J2\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010<\u001a\u000200H\u0016¨\u0006C"}, d2 = {"Lokhttp3/r;", "", "Lokhttp3/e;", f0.v.E0, "Lkotlin/z1;", "callStart", "Lokhttp3/u;", "url", "proxySelectStart", "", "Ljava/net/Proxy;", "Lhk/n;", "proxies", "proxySelectEnd", "", "domainName", "dnsStart", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "Ljava/net/InetSocketAddress;", "inetSocketAddress", IOptionConstant.proxy, "connectStart", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "Lokhttp3/Protocol;", "protocol", "connectEnd", "Ljava/io/IOException;", "ioe", "connectFailed", "Lokhttp3/i;", xl.e.f55522j, "connectionAcquired", "connectionReleased", "requestHeadersStart", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "requestHeadersEnd", "requestBodyStart", "", "byteCount", "requestBodyEnd", "requestFailed", "responseHeadersStart", "Lokhttp3/d0;", "response", "responseHeadersEnd", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "<init>", "()V", "Companion", "b", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public abstract class r {

    @yt.k
    public static final b Companion = new b(null);

    @hk.e
    @yt.k
    public static final r NONE = new a();

    @kotlin.d0(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"okhttp3/r$a", "Lokhttp3/r;", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends r {
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/r$b;", "", "Lokhttp3/r;", HlsPlaylistParser.M, "Lokhttp3/r;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lokhttp3/r$c;", "", "Lokhttp3/e;", f0.v.E0, "Lokhttp3/r;", "create", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface c {
        @yt.k
        r create(@yt.k e eVar);
    }

    public void cacheConditionalHit(@yt.k e call, @yt.k d0 cachedResponse) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(cachedResponse, "cachedResponse");
    }

    public void cacheHit(@yt.k e call, @yt.k d0 response) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(response, "response");
    }

    public void cacheMiss(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void callEnd(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void callFailed(@yt.k e call, @yt.k IOException ioe) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(ioe, "ioe");
    }

    public void callStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void canceled(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void connectEnd(@yt.k e call, @yt.k InetSocketAddress inetSocketAddress, @yt.k Proxy proxy, @yt.l Protocol protocol) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.f0.p(proxy, "proxy");
    }

    public void connectFailed(@yt.k e call, @yt.k InetSocketAddress inetSocketAddress, @yt.k Proxy proxy, @yt.l Protocol protocol, @yt.k IOException ioe) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.f0.p(proxy, "proxy");
        kotlin.jvm.internal.f0.p(ioe, "ioe");
    }

    public void connectStart(@yt.k e call, @yt.k InetSocketAddress inetSocketAddress, @yt.k Proxy proxy) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(inetSocketAddress, "inetSocketAddress");
        kotlin.jvm.internal.f0.p(proxy, "proxy");
    }

    public void connectionAcquired(@yt.k e call, @yt.k i connection) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(connection, "connection");
    }

    public void connectionReleased(@yt.k e call, @yt.k i connection) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(connection, "connection");
    }

    public void dnsEnd(@yt.k e call, @yt.k String domainName, @yt.k List<InetAddress> inetAddressList) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(domainName, "domainName");
        kotlin.jvm.internal.f0.p(inetAddressList, "inetAddressList");
    }

    public void dnsStart(@yt.k e call, @yt.k String domainName) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(domainName, "domainName");
    }

    public void proxySelectEnd(@yt.k e call, @yt.k u url, @yt.k List<Proxy> proxies) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(url, "url");
        kotlin.jvm.internal.f0.p(proxies, "proxies");
    }

    public void proxySelectStart(@yt.k e call, @yt.k u url) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(url, "url");
    }

    public void requestBodyEnd(@yt.k e call, long j10) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void requestBodyStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void requestFailed(@yt.k e call, @yt.k IOException ioe) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(ioe, "ioe");
    }

    public void requestHeadersEnd(@yt.k e call, @yt.k b0 request) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(request, "request");
    }

    public void requestHeadersStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void responseBodyEnd(@yt.k e call, long j10) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void responseBodyStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void responseFailed(@yt.k e call, @yt.k IOException ioe) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(ioe, "ioe");
    }

    public void responseHeadersEnd(@yt.k e call, @yt.k d0 response) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(response, "response");
    }

    public void responseHeadersStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void satisfactionFailure(@yt.k e call, @yt.k d0 response) {
        kotlin.jvm.internal.f0.p(call, "call");
        kotlin.jvm.internal.f0.p(response, "response");
    }

    public void secureConnectEnd(@yt.k e call, @yt.l Handshake handshake) {
        kotlin.jvm.internal.f0.p(call, "call");
    }

    public void secureConnectStart(@yt.k e call) {
        kotlin.jvm.internal.f0.p(call, "call");
    }
}
