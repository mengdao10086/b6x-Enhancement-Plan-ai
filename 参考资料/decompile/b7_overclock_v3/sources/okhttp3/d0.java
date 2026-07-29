package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.t0;
import okhttp3.t;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u001eB}\b\u0000\u0012\u0006\u00103\u001a\u00020\u0002\u0012\u0006\u00107\u001a\u00020\u0005\u0012\u0006\u0010:\u001a\u00020\u000b\u0012\u0006\u0010<\u001a\u00020\b\u0012\b\u0010@\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010C\u001a\u00020\u0016\u0012\b\u0010G\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010R\u001a\u00020\u001a\u0012\u0006\u0010T\u001a\u00020\u001a\u0012\b\u0010Y\u001a\u0004\u0018\u00010U¢\u0006\u0004\bd\u0010eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\u0006\u0010\u0011\u001a\u00020\u000bJ\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0007J\u000f\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010!\u001a\u00020 J\u0011\u0010\"\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b\"\u0010#J\u0011\u0010$\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b$\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b%\u0010#J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0012J\u000f\u0010)\u001a\u00020(H\u0007¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u001aH\u0007¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u001aH\u0007¢\u0006\u0004\b-\u0010,J\b\u0010/\u001a\u00020.H\u0016J\b\u00100\u001a\u00020\u000bH\u0016R\u0017\u00103\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001e\u00101\u001a\u0004\b2\u0010\u0004R\u0017\u00107\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u0007R\u0017\u0010:\u001a\u00020\u000b8\u0007¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\b9\u0010\rR\u0017\u0010<\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b$\u0010+\u001a\u0004\b;\u0010\nR\u0019\u0010@\u001a\u0004\u0018\u00010\u000e8\u0007¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010\u0010R\u0017\u0010C\u001a\u00020\u00168\u0007¢\u0006\f\n\u0004\b\t\u0010A\u001a\u0004\bB\u0010\u0018R\u0019\u0010G\u001a\u0004\u0018\u00010\u001c8\u0007¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u001fR\u0019\u0010J\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u000f\u0010H\u001a\u0004\bI\u0010#R\u0019\u0010L\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b\u0017\u0010H\u001a\u0004\bK\u0010#R\u0019\u0010O\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\bM\u0010H\u001a\u0004\bN\u0010#R\u0017\u0010R\u001a\u00020\u001a8\u0007¢\u0006\f\n\u0004\b\f\u0010P\u001a\u0004\bQ\u0010,R\u0017\u0010T\u001a\u00020\u001a8\u0007¢\u0006\f\n\u0004\b\"\u0010P\u001a\u0004\bS\u0010,R\u001c\u0010Y\u001a\u0004\u0018\u00010U8\u0001X\u0080\u0004¢\u0006\f\n\u0004\b%\u0010V\u001a\u0004\bW\u0010XR\u0018\u0010[\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010ZR\u0011\u0010_\u001a\u00020\\8F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0011\u0010a\u001a\u00020\\8F¢\u0006\u0006\u001a\u0004\b`\u0010^R\u0011\u0010c\u001a\u00020(8G¢\u0006\u0006\u001a\u0004\bb\u0010*¨\u0006f"}, d2 = {"Lokhttp3/d0;", "Ljava/io/Closeable;", "Lokhttp3/b0;", an.aD, "()Lokhttp3/b0;", "Lokhttp3/Protocol;", "n", "()Lokhttp3/Protocol;", "", "f", "()I", "", "k", "()Ljava/lang/String;", "Lokhttp3/Handshake;", "h", "()Lokhttp3/Handshake;", "name", "", m9.h.f40774q, "defaultValue", "G0", "Lokhttp3/t;", "i", "()Lokhttp3/t;", "f2", "", "byteCount", "Lokhttp3/e0;", "u1", "a", "()Lokhttp3/e0;", "Lokhttp3/d0$a;", "s1", com.flydigi.sdk.bluetooth.l.f16298a, "()Lokhttp3/d0;", "d", m0.k.f40564b, "Lokhttp3/g;", i1.a.f31577d5, "Lokhttp3/d;", "c", "()Lokhttp3/d;", "I", "()J", "u", "Lkotlin/z1;", "close", "toString", "Lokhttp3/b0;", "V1", SocialConstants.TYPE_REQUEST, "b", "Lokhttp3/Protocol;", "C1", "protocol", "Ljava/lang/String;", "m1", "message", i1.a.T4, "code", "e", "Lokhttp3/Handshake;", "b0", "handshake", "Lokhttp3/t;", "h1", IOptionConstant.headers, "g", "Lokhttp3/e0;", "L", "body", "Lokhttp3/d0;", "p1", "networkResponse", "P", "cacheResponse", xf.j.f55230b, "z1", "priorResponse", "J", "Y1", "sentRequestAtMillis", "L1", "receivedResponseAtMillis", "Lokhttp3/internal/connection/c;", "Lokhttp3/internal/connection/c;", "Z", "()Lokhttp3/internal/connection/c;", "exchange", "Lokhttp3/d;", "lazyCacheControl", "", m9.h.B, "()Z", "isSuccessful", "i1", "isRedirect", "M", "cacheControl", "<init>", "(Lokhttp3/b0;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/t;Lokhttp3/e0;Lokhttp3/d0;Lokhttp3/d0;Lokhttp3/d0;JJLokhttp3/internal/connection/c;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d0 implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final b0 f43581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Protocol f43582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final String f43583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public final Handshake f43585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final t f43586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public final e0 f43587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public final d0 f43588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public final d0 f43589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public final d0 f43590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f43591k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f43592l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.l
    public final okhttp3.internal.connection.c f43593m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.l
    public d f43594n;

    public d0(@yt.k b0 request, @yt.k Protocol protocol, @yt.k String message, int i10, @yt.l Handshake handshake, @yt.k t headers, @yt.l e0 e0Var, @yt.l d0 d0Var, @yt.l d0 d0Var2, @yt.l d0 d0Var3, long j10, long j11, @yt.l okhttp3.internal.connection.c cVar) {
        kotlin.jvm.internal.f0.p(request, "request");
        kotlin.jvm.internal.f0.p(protocol, "protocol");
        kotlin.jvm.internal.f0.p(message, "message");
        kotlin.jvm.internal.f0.p(headers, "headers");
        this.f43581a = request;
        this.f43582b = protocol;
        this.f43583c = message;
        this.f43584d = i10;
        this.f43585e = handshake;
        this.f43586f = headers;
        this.f43587g = e0Var;
        this.f43588h = d0Var;
        this.f43589i = d0Var2;
        this.f43590j = d0Var3;
        this.f43591k = j10;
        this.f43592l = j11;
        this.f43593m = cVar;
    }

    public static /* synthetic */ String M0(d0 d0Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return d0Var.G0(str, str2);
    }

    @hk.h(name = "protocol")
    @yt.k
    public final Protocol C1() {
        return this.f43582b;
    }

    @hk.i
    @yt.l
    public final String F0(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return M0(this, name, null, 2, null);
    }

    @hk.i
    @yt.l
    public final String G0(@yt.k String name, @yt.l String str) {
        kotlin.jvm.internal.f0.p(name, "name");
        String strD = this.f43586f.d(name);
        return strD == null ? str : strD;
    }

    @hk.h(name = "-deprecated_sentRequestAtMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "sentRequestAtMillis", imports = {}))
    public final long I() {
        return this.f43591k;
    }

    @hk.h(name = "body")
    @yt.l
    public final e0 L() {
        return this.f43587g;
    }

    @hk.h(name = "receivedResponseAtMillis")
    public final long L1() {
        return this.f43592l;
    }

    @hk.h(name = "cacheControl")
    @yt.k
    public final d M() {
        d dVar = this.f43594n;
        if (dVar != null) {
            return dVar;
        }
        d dVarC = d.f43557n.c(this.f43586f);
        this.f43594n = dVarC;
        return dVarC;
    }

    @hk.h(name = "cacheResponse")
    @yt.l
    public final d0 P() {
        return this.f43589i;
    }

    @yt.k
    public final List<g> T() {
        String str;
        t tVar = this.f43586f;
        int i10 = this.f43584d;
        if (i10 == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else {
            if (i10 != 407) {
                return CollectionsKt__CollectionsKt.E();
            }
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return vl.e.b(tVar, str);
    }

    @hk.h(name = SocialConstants.TYPE_REQUEST)
    @yt.k
    public final b0 V1() {
        return this.f43581a;
    }

    @hk.h(name = "code")
    public final int W() {
        return this.f43584d;
    }

    @hk.h(name = "sentRequestAtMillis")
    public final long Y1() {
        return this.f43591k;
    }

    @hk.h(name = "exchange")
    @yt.l
    public final okhttp3.internal.connection.c Z() {
        return this.f43593m;
    }

    @hk.h(name = "-deprecated_body")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "body", imports = {}))
    @yt.l
    public final e0 a() {
        return this.f43587g;
    }

    @hk.h(name = "handshake")
    @yt.l
    public final Handshake b0() {
        return this.f43585e;
    }

    @hk.h(name = "-deprecated_cacheControl")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cacheControl", imports = {}))
    @yt.k
    public final d c() {
        return M();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e0 e0Var = this.f43587g;
        if (e0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        e0Var.close();
    }

    @hk.h(name = "-deprecated_cacheResponse")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "cacheResponse", imports = {}))
    @yt.l
    public final d0 d() {
        return this.f43589i;
    }

    @yt.k
    public final List<String> d1(@yt.k String name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return this.f43586f.s(name);
    }

    @hk.h(name = "-deprecated_code")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "code", imports = {}))
    public final int f() {
        return this.f43584d;
    }

    @yt.k
    public final t f2() throws IOException {
        okhttp3.internal.connection.c cVar = this.f43593m;
        if (cVar != null) {
            return cVar.u();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    @hk.h(name = "-deprecated_handshake")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "handshake", imports = {}))
    @yt.l
    public final Handshake h() {
        return this.f43585e;
    }

    @hk.h(name = IOptionConstant.headers)
    @yt.k
    public final t h1() {
        return this.f43586f;
    }

    @hk.h(name = "-deprecated_headers")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.headers, imports = {}))
    @yt.k
    public final t i() {
        return this.f43586f;
    }

    public final boolean i1() {
        int i10 = this.f43584d;
        if (i10 != 307 && i10 != 308) {
            switch (i10) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    @hk.h(name = "-deprecated_message")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "message", imports = {}))
    @yt.k
    public final String k() {
        return this.f43583c;
    }

    public final boolean k1() {
        int i10 = this.f43584d;
        return 200 <= i10 && i10 < 300;
    }

    @hk.h(name = "-deprecated_networkResponse")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "networkResponse", imports = {}))
    @yt.l
    public final d0 l() {
        return this.f43588h;
    }

    @hk.h(name = "-deprecated_priorResponse")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "priorResponse", imports = {}))
    @yt.l
    public final d0 m() {
        return this.f43590j;
    }

    @hk.h(name = "message")
    @yt.k
    public final String m1() {
        return this.f43583c;
    }

    @hk.h(name = "-deprecated_protocol")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "protocol", imports = {}))
    @yt.k
    public final Protocol n() {
        return this.f43582b;
    }

    @hk.h(name = "networkResponse")
    @yt.l
    public final d0 p1() {
        return this.f43588h;
    }

    @yt.k
    public final a s1() {
        return new a(this);
    }

    @yt.k
    public String toString() {
        return "Response{protocol=" + this.f43582b + ", code=" + this.f43584d + ", message=" + this.f43583c + ", url=" + this.f43581a.q() + '}';
    }

    @hk.h(name = "-deprecated_receivedResponseAtMillis")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "receivedResponseAtMillis", imports = {}))
    public final long u() {
        return this.f43592l;
    }

    @yt.k
    public final e0 u1(long j10) throws IOException {
        e0 e0Var = this.f43587g;
        kotlin.jvm.internal.f0.m(e0Var);
        okio.l lVarPeek = e0Var.source().peek();
        okio.j jVar = new okio.j();
        lVarPeek.request(j10);
        jVar.g1(lVarPeek, Math.min(j10, lVarPeek.g().m2()));
        return e0.Companion.f(jVar, this.f43587g.contentType(), jVar.m2());
    }

    @hk.h(name = "-deprecated_request")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = SocialConstants.TYPE_REQUEST, imports = {}))
    @yt.k
    public final b0 z() {
        return this.f43581a;
    }

    @hk.h(name = "priorResponse")
    @yt.l
    public final d0 z1() {
        return this.f43590j;
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b!\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\bh\u0010iB\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bh\u0010XJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010&\u001a\u00020\u00002\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020'H\u0016J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010-\u001a\u00020,H\u0000¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u0010\u001a\u00020\u000f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010;\u001a\u0004\b<\u0010=\"\u0004\b;\u0010>R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b$\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010\u001c\u001a\u00020I8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010!\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bP\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010T\u001a\u0004\bY\u0010V\"\u0004\bZ\u0010XR$\u0010%\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010T\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\"\u0010*\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u0010^\u001a\u0004\bc\u0010`\"\u0004\bd\u0010bR$\u0010g\u001a\u0004\u0018\u00010,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bK\u0010e\u001a\u0004\b]\u0010f\"\u0004\b^\u0010/¨\u0006j"}, d2 = {"Lokhttp3/d0$a;", "", "", "name", "Lokhttp3/d0;", "response", "Lkotlin/z1;", "f", "e", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, i1.a.S4, "Lokhttp3/Protocol;", "protocol", "B", "", "code", "g", "message", "y", "Lokhttp3/Handshake;", "handshake", "u", "value", "v", "a", "D", "Lokhttp3/t;", IOptionConstant.headers, "w", "Lokhttp3/e0;", "body", "b", "networkResponse", an.aD, "cacheResponse", "d", "priorResponse", i1.a.W4, "", "sentRequestAtMillis", "F", "receivedResponseAtMillis", "C", "Lokhttp3/internal/connection/c;", "deferredTrailers", "x", "(Lokhttp3/internal/connection/c;)V", "c", "Lokhttp3/b0;", an.aB, "()Lokhttp3/b0;", "R", "(Lokhttp3/b0;)V", "Lokhttp3/Protocol;", "q", "()Lokhttp3/Protocol;", "P", "(Lokhttp3/Protocol;)V", "I", xf.j.f55230b, "()I", "(I)V", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "M", "(Ljava/lang/String;)V", "Lokhttp3/Handshake;", com.flydigi.sdk.bluetooth.l.f16298a, "()Lokhttp3/Handshake;", "K", "(Lokhttp3/Handshake;)V", "Lokhttp3/t$a;", "Lokhttp3/t$a;", m0.k.f40564b, "()Lokhttp3/t$a;", "L", "(Lokhttp3/t$a;)V", "Lokhttp3/e0;", "h", "()Lokhttp3/e0;", "G", "(Lokhttp3/e0;)V", "Lokhttp3/d0;", "o", "()Lokhttp3/d0;", "N", "(Lokhttp3/d0;)V", "i", "H", "p", "O", "k", "J", "t", "()J", i1.a.R4, "(J)V", SsManifestParser.e.J, "Q", "Lokhttp3/internal/connection/c;", "()Lokhttp3/internal/connection/c;", "exchange", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public b0 f43595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public Protocol f43596b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        public String f43598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.l
        public Handshake f43599e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.k
        public t.a f43600f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.l
        public e0 f43601g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.l
        public d0 f43602h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @yt.l
        public d0 f43603i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @yt.l
        public d0 f43604j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f43605k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f43606l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @yt.l
        public okhttp3.internal.connection.c f43607m;

        public a() {
            this.f43597c = -1;
            this.f43600f = new t.a();
        }

        @yt.k
        public a A(@yt.l d0 d0Var) {
            e(d0Var);
            O(d0Var);
            return this;
        }

        @yt.k
        public a B(@yt.k Protocol protocol) {
            kotlin.jvm.internal.f0.p(protocol, "protocol");
            P(protocol);
            return this;
        }

        @yt.k
        public a C(long j10) {
            Q(j10);
            return this;
        }

        @yt.k
        public a D(@yt.k String name) {
            kotlin.jvm.internal.f0.p(name, "name");
            m().l(name);
            return this;
        }

        @yt.k
        public a E(@yt.k b0 request) {
            kotlin.jvm.internal.f0.p(request, "request");
            R(request);
            return this;
        }

        @yt.k
        public a F(long j10) {
            S(j10);
            return this;
        }

        public final void G(@yt.l e0 e0Var) {
            this.f43601g = e0Var;
        }

        public final void H(@yt.l d0 d0Var) {
            this.f43603i = d0Var;
        }

        public final void I(int i10) {
            this.f43597c = i10;
        }

        public final void J(@yt.l okhttp3.internal.connection.c cVar) {
            this.f43607m = cVar;
        }

        public final void K(@yt.l Handshake handshake) {
            this.f43599e = handshake;
        }

        public final void L(@yt.k t.a aVar) {
            kotlin.jvm.internal.f0.p(aVar, "<set-?>");
            this.f43600f = aVar;
        }

        public final void M(@yt.l String str) {
            this.f43598d = str;
        }

        public final void N(@yt.l d0 d0Var) {
            this.f43602h = d0Var;
        }

        public final void O(@yt.l d0 d0Var) {
            this.f43604j = d0Var;
        }

        public final void P(@yt.l Protocol protocol) {
            this.f43596b = protocol;
        }

        public final void Q(long j10) {
            this.f43606l = j10;
        }

        public final void R(@yt.l b0 b0Var) {
            this.f43595a = b0Var;
        }

        public final void S(long j10) {
            this.f43605k = j10;
        }

        @yt.k
        public a a(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            m().b(name, value);
            return this;
        }

        @yt.k
        public a b(@yt.l e0 e0Var) {
            G(e0Var);
            return this;
        }

        @yt.k
        public d0 c() {
            int i10 = this.f43597c;
            if (!(i10 >= 0)) {
                throw new IllegalStateException(kotlin.jvm.internal.f0.C("code < 0: ", Integer.valueOf(j())).toString());
            }
            b0 b0Var = this.f43595a;
            if (b0Var == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.f43596b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f43598d;
            if (str != null) {
                return new d0(b0Var, protocol, str, i10, this.f43599e, this.f43600f.i(), this.f43601g, this.f43602h, this.f43603i, this.f43604j, this.f43605k, this.f43606l, this.f43607m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        @yt.k
        public a d(@yt.l d0 d0Var) {
            f("cacheResponse", d0Var);
            H(d0Var);
            return this;
        }

        public final void e(d0 d0Var) {
            if (d0Var == null) {
                return;
            }
            if (!(d0Var.L() == null)) {
                throw new IllegalArgumentException("priorResponse.body != null".toString());
            }
        }

        public final void f(String str, d0 d0Var) {
            if (d0Var == null) {
                return;
            }
            if (!(d0Var.L() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C(str, ".body != null").toString());
            }
            if (!(d0Var.p1() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C(str, ".networkResponse != null").toString());
            }
            if (!(d0Var.P() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C(str, ".cacheResponse != null").toString());
            }
            if (!(d0Var.z1() == null)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C(str, ".priorResponse != null").toString());
            }
        }

        @yt.k
        public a g(int i10) {
            I(i10);
            return this;
        }

        @yt.l
        public final e0 h() {
            return this.f43601g;
        }

        @yt.l
        public final d0 i() {
            return this.f43603i;
        }

        public final int j() {
            return this.f43597c;
        }

        @yt.l
        public final okhttp3.internal.connection.c k() {
            return this.f43607m;
        }

        @yt.l
        public final Handshake l() {
            return this.f43599e;
        }

        @yt.k
        public final t.a m() {
            return this.f43600f;
        }

        @yt.l
        public final String n() {
            return this.f43598d;
        }

        @yt.l
        public final d0 o() {
            return this.f43602h;
        }

        @yt.l
        public final d0 p() {
            return this.f43604j;
        }

        @yt.l
        public final Protocol q() {
            return this.f43596b;
        }

        public final long r() {
            return this.f43606l;
        }

        @yt.l
        public final b0 s() {
            return this.f43595a;
        }

        public final long t() {
            return this.f43605k;
        }

        @yt.k
        public a u(@yt.l Handshake handshake) {
            K(handshake);
            return this;
        }

        @yt.k
        public a v(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            m().m(name, value);
            return this;
        }

        @yt.k
        public a w(@yt.k t headers) {
            kotlin.jvm.internal.f0.p(headers, "headers");
            L(headers.m());
            return this;
        }

        public final void x(@yt.k okhttp3.internal.connection.c deferredTrailers) {
            kotlin.jvm.internal.f0.p(deferredTrailers, "deferredTrailers");
            this.f43607m = deferredTrailers;
        }

        @yt.k
        public a y(@yt.k String message) {
            kotlin.jvm.internal.f0.p(message, "message");
            M(message);
            return this;
        }

        @yt.k
        public a z(@yt.l d0 d0Var) {
            f("networkResponse", d0Var);
            N(d0Var);
            return this;
        }

        public a(@yt.k d0 response) {
            kotlin.jvm.internal.f0.p(response, "response");
            this.f43597c = -1;
            this.f43595a = response.V1();
            this.f43596b = response.C1();
            this.f43597c = response.W();
            this.f43598d = response.m1();
            this.f43599e = response.b0();
            this.f43600f = response.h1().m();
            this.f43601g = response.L();
            this.f43602h = response.p1();
            this.f43603i = response.P();
            this.f43604j = response.z1();
            this.f43605k = response.Y1();
            this.f43606l = response.L1();
            this.f43607m = response.Z();
        }
    }
}
