package rl;

import com.tencent.open.SocialConstants;
import hk.h;
import javax.net.ssl.SSLSocket;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.b0;
import okhttp3.m;
import okhttp3.t;
import okhttp3.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "Internal")
@d0(bv = {}, d1 = {"\u0000R\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t\u001a\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004\u001a\u001e\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015\u001a\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\t¨\u0006 "}, d2 = {"", "currentTimeMillis", "Lokhttp3/u;", "url", "", "setCookie", "Lokhttp3/m;", "f", "cookie", "", "forObsoleteRfc2965", "e", "Lokhttp3/t$a;", "builder", "line", "a", "name", "value", "b", "Lokhttp3/c;", "cache", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/d0;", "d", "Lokhttp3/k;", "connectionSpec", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "isFallback", "Lkotlin/z1;", "c", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class b {
    @k
    public static final t.a a(@k t.a builder, @k String line) {
        f0.p(builder, "builder");
        f0.p(line, "line");
        return builder.f(line);
    }

    @k
    public static final t.a b(@k t.a builder, @k String name, @k String value) {
        f0.p(builder, "builder");
        f0.p(name, "name");
        f0.p(value, "value");
        return builder.g(name, value);
    }

    public static final void c(@k okhttp3.k connectionSpec, @k SSLSocket sslSocket, boolean z10) {
        f0.p(connectionSpec, "connectionSpec");
        f0.p(sslSocket, "sslSocket");
        connectionSpec.f(sslSocket, z10);
    }

    @l
    public static final okhttp3.d0 d(@k okhttp3.c cache, @k b0 request) {
        f0.p(cache, "cache");
        f0.p(request, "request");
        return cache.i(request);
    }

    @k
    public static final String e(@k m cookie, boolean z10) {
        f0.p(cookie, "cookie");
        return cookie.y(z10);
    }

    @l
    public static final m f(long j10, @k u url, @k String setCookie) {
        f0.p(url, "url");
        f0.p(setCookie, "setCookie");
        return m.f43901j.f(j10, url, setCookie);
    }
}
