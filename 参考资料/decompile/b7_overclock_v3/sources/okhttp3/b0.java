package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s0;
import kotlin.t0;
import okhttp3.t;
import okhttp3.u;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018BC\b\u0000\u0012\u0006\u0010 \u001a\u00020\u000f\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\u0006\u0010&\u001a\u00020\u0014\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0017\u0012\u0016\u0010.\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010*¢\u0006\u0004\b7\u00108J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001J%\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u000e\u001a\u00020\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0002H\u0016R\u0017\u0010 \u001a\u00020\u000f8\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u001e\u001a\u0004\b\u001f\u0010\u0011R\u0017\u0010#\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001b\u0010!\u001a\u0004\b\"\u0010\u0013R\u0017\u0010&\u001a\u00020\u00148\u0007¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b%\u0010\u0016R\u0019\u0010)\u001a\u0004\u0018\u00010\u00178\u0007¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0019R*\u0010.\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\u00010*8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010+\u001a\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010/R\u0011\u00104\u001a\u0002018F¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00106\u001a\u00020\u001a8G¢\u0006\u0006\u001a\u0004\b5\u0010\u001c¨\u00069"}, d2 = {"Lokhttp3/b0;", "", "", "name", "i", "", xf.j.f55230b, "o", i1.a.f31577d5, "Ljava/lang/Class;", "type", "p", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lokhttp3/b0$a;", "n", "Lokhttp3/u;", "e", "()Lokhttp3/u;", "d", "()Ljava/lang/String;", "Lokhttp3/t;", "c", "()Lokhttp3/t;", "Lokhttp3/c0;", "a", "()Lokhttp3/c0;", "Lokhttp3/d;", "b", "()Lokhttp3/d;", "toString", "Lokhttp3/u;", "q", "url", "Ljava/lang/String;", m0.k.f40564b, xf.z.f55306i, "Lokhttp3/t;", "k", IOptionConstant.headers, "Lokhttp3/c0;", "f", "body", "", "Ljava/util/Map;", "h", "()Ljava/util/Map;", SocializeProtocolConstants.TAGS, "Lokhttp3/d;", "lazyCacheControl", "", com.flydigi.sdk.bluetooth.l.f16298a, "()Z", "isHttps", "g", "cacheControl", "<init>", "(Lokhttp3/u;Ljava/lang/String;Lokhttp3/t;Lokhttp3/c0;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final u f43496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f43497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final t f43498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public final c0 f43499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final Map<Class<?>, Object> f43500e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.l
    public d f43501f;

    public b0(@yt.k u url, @yt.k String method, @yt.k t headers, @yt.l c0 c0Var, @yt.k Map<Class<?>, ? extends Object> tags) {
        kotlin.jvm.internal.f0.p(url, "url");
        kotlin.jvm.internal.f0.p(method, "method");
        kotlin.jvm.internal.f0.p(headers, "headers");
        kotlin.jvm.internal.f0.p(tags, "tags");
        this.f43496a = url;
        this.f43497b = method;
        this.f43498c = headers;
        this.f43499d = c0Var;
        this.f43500e = tags;
    }

    @hk.h(name = "-deprecated_body")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "body", imports = {}))
    @yt.l
    public final c0 a() {
        return this.f43499d;
    }

    @hk.h(name = "-deprecated_cacheControl")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cacheControl", imports = {}))
    @yt.k
    public final d b() {
        return g();
    }

    @hk.h(name = "-deprecated_headers")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.headers, imports = {}))
    @yt.k
    public final t c() {
        return this.f43498c;
    }

    @hk.h(name = "-deprecated_method")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = xf.z.f55306i, imports = {}))
    @yt.k
    public final String d() {
        return this.f43497b;
    }

    @hk.h(name = "-deprecated_url")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "url", imports = {}))
    @yt.k
    public final u e() {
        return this.f43496a;
    }

    @hk.h(name = "body")
    @yt.l
    public final c0 f() {
        return this.f43499d;
    }

    @hk.h(name = "cacheControl")
    @yt.k
    public final d g() {
        d dVar = this.f43501f;
        if (dVar != null) {
            return dVar;
        }
        d dVarC = d.f43557n.c(this.f43498c);
        this.f43501f = dVarC;
        return dVarC;
    }

    @yt.k
    public final Map<Class<?>, Object> h() {
        return this.f43500e;
    }

    @yt.l
    public final String i(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return this.f43498c.d(name);
    }

    @yt.k
    public final List<String> j(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return this.f43498c.s(name);
    }

    @hk.h(name = IOptionConstant.headers)
    @yt.k
    public final t k() {
        return this.f43498c;
    }

    public final boolean l() {
        return this.f43496a.G();
    }

    @hk.h(name = xf.z.f55306i)
    @yt.k
    public final String m() {
        return this.f43497b;
    }

    @yt.k
    public final a n() {
        return new a(this);
    }

    @yt.l
    public final Object o() {
        return p(Object.class);
    }

    @yt.l
    public final <T> T p(@yt.k Class<? extends T> type) {
        kotlin.jvm.internal.f0.p(type, "type");
        return type.cast(this.f43500e.get(type));
    }

    @hk.h(name = "url")
    @yt.k
    public final u q() {
        return this.f43496a;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(m());
        sb2.append(", url=");
        sb2.append(q());
        if (k().size() != 0) {
            sb2.append(", headers=[");
            int i10 = 0;
            for (Pair<? extends String, ? extends String> pair : k()) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strA = pair2.a();
                String strB = pair2.b();
                if (i10 > 0) {
                    sb2.append(", ");
                }
                sb2.append(strA);
                sb2.append(':');
                sb2.append(strB);
                i10 = i11;
            }
            sb2.append(']');
        }
        if (!h().isEmpty()) {
            sb2.append(", tags=");
            sb2.append(h());
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bD\u0010EB\u0011\b\u0010\u0012\u0006\u0010F\u001a\u00020%¢\u0006\u0004\bD\u0010GJ\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0000H\u0016J\b\u0010\u0015\u001a\u00020\u0000H\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0014\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0017J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J/\u0010#\u001a\u00020\u0000\"\u0004\b\u0000\u0010 2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000!2\b\u0010\u001e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b#\u0010$J\b\u0010&\u001a\u00020%H\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u001c\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b&\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u0010\u000f\u001a\u0002018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0013\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R2\u0010C\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030!\u0012\u0004\u0012\u00020\u00010=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006H"}, d2 = {"Lokhttp3/b0$a;", "", "Lokhttp3/u;", "url", "D", "", "B", "Ljava/net/URL;", "C", "name", "value", "n", "a", "t", "Lokhttp3/t;", IOptionConstant.headers, "o", "Lokhttp3/d;", "cacheControl", "c", "g", m0.k.f40564b, "Lokhttp3/c0;", "body", SsManifestParser.e.J, "e", an.aB, "q", xf.z.f55306i, "p", CommonNetImpl.TAG, i1.a.W4, i1.a.f31577d5, "Ljava/lang/Class;", "type", an.aD, "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/b0$a;", "Lokhttp3/b0;", "b", "Lokhttp3/u;", com.flydigi.sdk.bluetooth.l.f16298a, "()Lokhttp3/u;", "y", "(Lokhttp3/u;)V", "Ljava/lang/String;", xf.j.f55230b, "()Ljava/lang/String;", "w", "(Ljava/lang/String;)V", "Lokhttp3/t$a;", "Lokhttp3/t$a;", "i", "()Lokhttp3/t$a;", "v", "(Lokhttp3/t$a;)V", "d", "Lokhttp3/c0;", "h", "()Lokhttp3/c0;", "u", "(Lokhttp3/c0;)V", "", "Ljava/util/Map;", "k", "()Ljava/util/Map;", "x", "(Ljava/util/Map;)V", SocializeProtocolConstants.TAGS, "<init>", "()V", SocialConstants.TYPE_REQUEST, "(Lokhttp3/b0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public u f43502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public String f43503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public t.a f43504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public c0 f43505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.k
        public Map<Class<?>, Object> f43506e;

        public a() {
            this.f43506e = new LinkedHashMap();
            this.f43503b = Constants.HTTP_GET;
            this.f43504c = new t.a();
        }

        public static /* synthetic */ a f(a aVar, c0 c0Var, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i10 & 1) != 0) {
                c0Var = rl.f.f48799d;
            }
            return aVar.e(c0Var);
        }

        @yt.k
        public a A(@yt.l Object obj) {
            return z(Object.class, obj);
        }

        @yt.k
        public a B(@yt.k String url) {
            kotlin.jvm.internal.f0.p(url, "url");
            if (kotlin.text.u.t2(url, "ws:", true)) {
                String strSubstring = url.substring(3);
                kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                url = kotlin.jvm.internal.f0.C("http:", strSubstring);
            } else if (kotlin.text.u.t2(url, "wss:", true)) {
                String strSubstring2 = url.substring(4);
                kotlin.jvm.internal.f0.o(strSubstring2, "this as java.lang.String).substring(startIndex)");
                url = kotlin.jvm.internal.f0.C("https:", strSubstring2);
            }
            return D(u.f43948k.h(url));
        }

        @yt.k
        public a C(@yt.k URL url) {
            kotlin.jvm.internal.f0.p(url, "url");
            u.b bVar = u.f43948k;
            String string = url.toString();
            kotlin.jvm.internal.f0.o(string, "url.toString()");
            return D(bVar.h(string));
        }

        @yt.k
        public a D(@yt.k u url) {
            kotlin.jvm.internal.f0.p(url, "url");
            y(url);
            return this;
        }

        @yt.k
        public a a(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            i().b(name, value);
            return this;
        }

        @yt.k
        public b0 b() {
            u uVar = this.f43502a;
            if (uVar != null) {
                return new b0(uVar, this.f43503b, this.f43504c.i(), this.f43505d, rl.f.i0(this.f43506e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        @yt.k
        public a c(@yt.k d cacheControl) {
            kotlin.jvm.internal.f0.p(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? t(HttpHeaders.CACHE_CONTROL) : n(HttpHeaders.CACHE_CONTROL, string);
        }

        @hk.i
        @yt.k
        public final a d() {
            return f(this, null, 1, null);
        }

        @hk.i
        @yt.k
        public a e(@yt.l c0 c0Var) {
            return p("DELETE", c0Var);
        }

        @yt.k
        public a g() {
            return p(Constants.HTTP_GET, null);
        }

        @yt.l
        public final c0 h() {
            return this.f43505d;
        }

        @yt.k
        public final t.a i() {
            return this.f43504c;
        }

        @yt.k
        public final String j() {
            return this.f43503b;
        }

        @yt.k
        public final Map<Class<?>, Object> k() {
            return this.f43506e;
        }

        @yt.l
        public final u l() {
            return this.f43502a;
        }

        @yt.k
        public a m() {
            return p("HEAD", null);
        }

        @yt.k
        public a n(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            i().m(name, value);
            return this;
        }

        @yt.k
        public a o(@yt.k t headers) {
            kotlin.jvm.internal.f0.p(headers, "headers");
            v(headers.m());
            return this;
        }

        @yt.k
        public a p(@yt.k String method, @yt.l c0 c0Var) {
            kotlin.jvm.internal.f0.p(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (c0Var == null) {
                if (!(true ^ vl.f.e(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!vl.f.b(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            w(method);
            u(c0Var);
            return this;
        }

        @yt.k
        public a q(@yt.k c0 body) {
            kotlin.jvm.internal.f0.p(body, "body");
            return p("PATCH", body);
        }

        @yt.k
        public a r(@yt.k c0 body) {
            kotlin.jvm.internal.f0.p(body, "body");
            return p(Constants.HTTP_POST, body);
        }

        @yt.k
        public a s(@yt.k c0 body) {
            kotlin.jvm.internal.f0.p(body, "body");
            return p("PUT", body);
        }

        @yt.k
        public a t(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            i().l(name);
            return this;
        }

        public final void u(@yt.l c0 c0Var) {
            this.f43505d = c0Var;
        }

        public final void v(@yt.k t.a aVar) {
            kotlin.jvm.internal.f0.p(aVar, "<set-?>");
            this.f43504c = aVar;
        }

        public final void w(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<set-?>");
            this.f43503b = str;
        }

        public final void x(@yt.k Map<Class<?>, Object> map) {
            kotlin.jvm.internal.f0.p(map, "<set-?>");
            this.f43506e = map;
        }

        public final void y(@yt.l u uVar) {
            this.f43502a = uVar;
        }

        @yt.k
        public <T> a z(@yt.k Class<? super T> type, @yt.l T t10) {
            kotlin.jvm.internal.f0.p(type, "type");
            if (t10 == null) {
                k().remove(type);
            } else {
                if (k().isEmpty()) {
                    x(new LinkedHashMap());
                }
                Map<Class<?>, Object> mapK = k();
                T tCast = type.cast(t10);
                kotlin.jvm.internal.f0.m(tCast);
                mapK.put(type, tCast);
            }
            return this;
        }

        public a(@yt.k b0 request) {
            Map<Class<?>, Object> mapJ0;
            kotlin.jvm.internal.f0.p(request, "request");
            this.f43506e = new LinkedHashMap();
            this.f43502a = request.q();
            this.f43503b = request.m();
            this.f43505d = request.f();
            if (request.h().isEmpty()) {
                mapJ0 = new LinkedHashMap<>();
            } else {
                mapJ0 = s0.J0(request.h());
            }
            this.f43506e = mapJ0;
            this.f43504c = request.k().m();
        }
    }
}
