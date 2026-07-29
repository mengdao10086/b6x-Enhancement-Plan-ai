package okhttp3.logging;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.blankj.utilcode.util.i0;
import com.efs.sdk.base.Constants;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.net.HttpHeaders;
import com.umeng.socialize.handler.UMTencentSSOHandler;
import em.b;
import hk.e;
import hk.i;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.collections.d1;
import kotlin.collections.x;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import kotlin.t0;
import kotlin.text.u;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.e0;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okio.j;
import okio.l;
import yt.k;
import zc.f;
import zl.h;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002#\tB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR*\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00068\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001e\u0010 ¨\u0006$"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/v;", "", "name", "Lkotlin/z1;", "f", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", UMTencentSSOHandler.LEVEL, "g", "a", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "Lokhttp3/v$a;", "chain", "Lokhttp3/d0;", "intercept", "Lokhttp3/t;", IOptionConstant.headers, "", "i", "e", "", "b", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "logger", "", "c", "Ljava/util/Set;", "headersToRedact", "<set-?>", "d", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$a;)V", "Level", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
public final class HttpLoggingInterceptor implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final a f43895a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public volatile Set<String> f43896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public volatile Level f43897d;

    @d0(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", HlsPlaylistParser.M, "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$a;", "", "", "message", "Lkotlin/z1;", "a", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final C0494a f43898a = C0494a.f43900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @e
        @k
        public static final a f43899b = new C0494a.C0495a();

        /* JADX INFO: renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$a$a;", "", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "<init>", "()V", "a", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
        public static final class C0494a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ C0494a f43900a = new C0494a();

            /* JADX INFO: renamed from: okhttp3.logging.HttpLoggingInterceptor$a$a$a, reason: collision with other inner class name */
            @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$a$a$a;", "Lokhttp3/logging/HttpLoggingInterceptor$a;", "", "message", "Lkotlin/z1;", "a", "<init>", "()V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0})
            public static final class C0495a implements a {
                @Override // okhttp3.logging.HttpLoggingInterceptor.a
                public void a(@k String message) {
                    f0.p(message, "message");
                    h.n(h.f58636a.g(), message, 0, null, 6, null);
                }
            }
        }

        void a(@k String str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i
    public HttpLoggingInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @i
    public HttpLoggingInterceptor(@k a logger) {
        f0.p(logger, "logger");
        this.f43895a = logger;
        this.f43896c = d1.k();
        this.f43897d = Level.NONE;
    }

    @hk.h(name = "-deprecated_level")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @t0(expression = UMTencentSSOHandler.LEVEL, imports = {}))
    @k
    public final Level a() {
        return this.f43897d;
    }

    public final boolean b(t tVar) {
        String strD = tVar.d(HttpHeaders.CONTENT_ENCODING);
        return (strD == null || u.L1(strD, HlsPlaylistParser.S, true) || u.L1(strD, Constants.CP_GZIP, true)) ? false : true;
    }

    @k
    public final Level c() {
        return this.f43897d;
    }

    @hk.h(name = UMTencentSSOHandler.LEVEL)
    public final void d(@k Level level) {
        f0.p(level, "<set-?>");
        this.f43897d = level;
    }

    public final void e(t tVar, int i10) {
        String strR = this.f43896c.contains(tVar.j(i10)) ? "██" : tVar.r(i10);
        this.f43895a.a(tVar.j(i10) + ": " + strR);
    }

    public final void f(@k String name) {
        f0.p(name, "name");
        TreeSet treeSet = new TreeSet(u.T1(v0.f37964a));
        x.n0(treeSet, this.f43896c);
        treeSet.add(name);
        this.f43896c = treeSet;
    }

    @k
    public final HttpLoggingInterceptor g(@k Level level) {
        f0.p(level, "level");
        d(level);
        return this;
    }

    @Override // okhttp3.v
    @k
    public okhttp3.d0 intercept(@k v.a chain) throws Exception {
        String str;
        char c10;
        String string;
        Charset charset;
        Long lValueOf;
        f0.p(chain, "chain");
        Level level = this.f43897d;
        b0 b0VarT = chain.T();
        if (level == Level.NONE) {
            return chain.e(b0VarT);
        }
        boolean z10 = level == Level.BODY;
        boolean z11 = z10 || level == Level.HEADERS;
        c0 c0VarF = b0VarT.f();
        okhttp3.i iVarF = chain.f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(b0VarT.m());
        sb2.append(f.f58383m);
        sb2.append(b0VarT.q());
        sb2.append(iVarF != null ? f0.C(i0.f11861z, iVarF.a()) : "");
        String string2 = sb2.toString();
        if (!z11 && c0VarF != null) {
            string2 = string2 + " (" + c0VarF.a() + "-byte body)";
        }
        this.f43895a.a(string2);
        if (z11) {
            t tVarK = b0VarT.k();
            if (c0VarF != null) {
                w wVarB = c0VarF.b();
                if (wVarB != null && tVarK.d("Content-Type") == null) {
                    this.f43895a.a(f0.C("Content-Type: ", wVarB));
                }
                if (c0VarF.a() != -1 && tVarK.d(HttpHeaders.CONTENT_LENGTH) == null) {
                    this.f43895a.a(f0.C("Content-Length: ", Long.valueOf(c0VarF.a())));
                }
            }
            int size = tVarK.size();
            for (int i10 = 0; i10 < size; i10++) {
                e(tVarK, i10);
            }
            if (!z10 || c0VarF == null) {
                this.f43895a.a(f0.C("--> END ", b0VarT.m()));
            } else if (b(b0VarT.k())) {
                this.f43895a.a("--> END " + b0VarT.m() + " (encoded body omitted)");
            } else if (c0VarF.p()) {
                this.f43895a.a("--> END " + b0VarT.m() + " (duplex request body omitted)");
            } else if (c0VarF.q()) {
                this.f43895a.a("--> END " + b0VarT.m() + " (one-shot body omitted)");
            } else {
                j jVar = new j();
                c0VarF.r(jVar);
                w wVarB2 = c0VarF.b();
                Charset UTF_8 = wVarB2 == null ? null : wVarB2.f(StandardCharsets.UTF_8);
                if (UTF_8 == null) {
                    UTF_8 = StandardCharsets.UTF_8;
                    f0.o(UTF_8, "UTF_8");
                }
                this.f43895a.a("");
                if (b.a(jVar)) {
                    this.f43895a.a(jVar.O0(UTF_8));
                    this.f43895a.a("--> END " + b0VarT.m() + " (" + c0VarF.a() + "-byte body)");
                } else {
                    this.f43895a.a("--> END " + b0VarT.m() + " (binary " + c0VarF.a() + "-byte body omitted)");
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            okhttp3.d0 d0VarE = chain.e(b0VarT);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            e0 e0VarL = d0VarE.L();
            f0.m(e0VarL);
            long jContentLength = e0VarL.contentLength();
            String str2 = jContentLength != -1 ? jContentLength + "-byte" : "unknown-length";
            a aVar = this.f43895a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("<-- ");
            sb3.append(d0VarE.W());
            if (d0VarE.m1().length() == 0) {
                str = "-byte body omitted)";
                string = "";
                c10 = f.f58383m;
            } else {
                String strM1 = d0VarE.m1();
                StringBuilder sb4 = new StringBuilder();
                str = "-byte body omitted)";
                c10 = f.f58383m;
                sb4.append(f.f58383m);
                sb4.append(strM1);
                string = sb4.toString();
            }
            sb3.append(string);
            sb3.append(c10);
            sb3.append(d0VarE.V1().q());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            sb3.append(z11 ? "" : ", " + str2 + " body");
            sb3.append(')');
            aVar.a(sb3.toString());
            if (z11) {
                t tVarH1 = d0VarE.h1();
                int size2 = tVarH1.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    e(tVarH1, i11);
                }
                if (!z10 || !vl.e.c(d0VarE)) {
                    this.f43895a.a("<-- END HTTP");
                } else if (b(d0VarE.h1())) {
                    this.f43895a.a("<-- END HTTP (encoded body omitted)");
                } else {
                    l lVarSource = e0VarL.source();
                    lVarSource.request(Long.MAX_VALUE);
                    j jVarG = lVarSource.g();
                    if (u.L1(Constants.CP_GZIP, tVarH1.d(HttpHeaders.CONTENT_ENCODING), true)) {
                        lValueOf = Long.valueOf(jVarG.m2());
                        okio.x xVar = new okio.x(jVarG.clone());
                        try {
                            jVarG = new j();
                            jVarG.X0(xVar);
                            charset = null;
                            kotlin.io.b.a(xVar, null);
                        } finally {
                        }
                    } else {
                        charset = null;
                        lValueOf = null;
                    }
                    w wVarContentType = e0VarL.contentType();
                    Charset UTF_82 = wVarContentType == null ? charset : wVarContentType.f(StandardCharsets.UTF_8);
                    if (UTF_82 == null) {
                        UTF_82 = StandardCharsets.UTF_8;
                        f0.o(UTF_82, "UTF_8");
                    }
                    if (!b.a(jVarG)) {
                        this.f43895a.a("");
                        this.f43895a.a("<-- END HTTP (binary " + jVarG.m2() + str);
                        return d0VarE;
                    }
                    if (jContentLength != 0) {
                        this.f43895a.a("");
                        this.f43895a.a(jVarG.clone().O0(UTF_82));
                    }
                    if (lValueOf != null) {
                        this.f43895a.a("<-- END HTTP (" + jVarG.m2() + "-byte, " + lValueOf + "-gzipped-byte body)");
                    } else {
                        this.f43895a.a("<-- END HTTP (" + jVarG.m2() + "-byte body)");
                    }
                }
            }
            return d0VarE;
        } catch (Exception e10) {
            this.f43895a.a(f0.C("<-- HTTP FAILED: ", e10));
            throw e10;
        }
    }

    public /* synthetic */ HttpLoggingInterceptor(a aVar, int i10, kotlin.jvm.internal.u uVar) {
        this((i10 & 1) != 0 ? a.f43899b : aVar);
    }
}
