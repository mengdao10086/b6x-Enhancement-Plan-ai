package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.util.concurrent.TimeUnit;
import kotlin.DeprecationLevel;
import kotlin.t0;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b \u0018\u0000 \u00182\u00020\u0001:\u0002\u000f\u0007Bs\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\b\u0010-\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000e\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000f\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0017\u0010\u0014\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0016\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0015\u0010\u0004R\u0017\u0010\u0019\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001d\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u001c\u0010\u0004R\u0017\u0010\u001f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u001e\u0010\u0004R\u0017\u0010!\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b \u0010\u0004R\u0017\u0010#\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\"\u0010\bR\u0017\u0010%\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b$\u0010\bR\u0017\u0010'\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0012\u001a\u0004\b&\u0010\u0004R\u0017\u0010*\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0004R\u0017\u0010+\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b(\u0010\u0004R\u0018\u0010-\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010,¨\u00060"}, d2 = {"Lokhttp3/d;", "", "", "f", "()Z", "g", "", "b", "()I", xf.j.f55230b, "e", "c", "d", "i", "h", "a", "", "toString", "Z", SsManifestParser.e.J, "noCache", an.aB, "noStore", "I", "n", "maxAgeSeconds", "w", "sMaxAgeSeconds", com.flydigi.sdk.bluetooth.l.f16298a, "isPrivate", m0.k.f40564b, "isPublic", "q", "mustRevalidate", "o", "maxStaleSeconds", "p", "minFreshSeconds", "u", "onlyIfCached", "k", "t", "noTransform", "immutable", "Ljava/lang/String;", "headerValue", "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public static final b f43557n = new b(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final d f43558o = new a().g().a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final d f43559p = new a().j().e(Integer.MAX_VALUE, TimeUnit.SECONDS).a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f43560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f43561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f43562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f43563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f43564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f43565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f43566g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f43567h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f43568i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f43569j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f43570k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f43571l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.l
    public String f43572m;

    @kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0003\u001a\u00020\u0000J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0000J\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0010J\f\u0010\u0013\u001a\u00020\u0004*\u00020\u0012H\u0002R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006!"}, d2 = {"Lokhttp3/d$a;", "", "g", "h", "", "maxAge", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "d", "maxStale", "e", "minFresh", "f", xf.j.f55230b, "i", "c", "Lokhttp3/d;", "a", "", "b", "", "Z", "noCache", "noStore", "I", "maxAgeSeconds", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f43573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f43574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43575c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f43576d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f43577e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f43578f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f43579g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f43580h;

        @yt.k
        public final d a() {
            return new d(this.f43573a, this.f43574b, this.f43575c, -1, false, false, false, this.f43576d, this.f43577e, this.f43578f, this.f43579g, this.f43580h, null, null);
        }

        public final int b(long j10) {
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j10;
        }

        @yt.k
        public final a c() {
            this.f43580h = true;
            return this;
        }

        @yt.k
        public final a d(int i10, @yt.k TimeUnit timeUnit) {
            kotlin.jvm.internal.f0.p(timeUnit, "timeUnit");
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("maxAge < 0: ", Integer.valueOf(i10)).toString());
            }
            this.f43575c = b(timeUnit.toSeconds(i10));
            return this;
        }

        @yt.k
        public final a e(int i10, @yt.k TimeUnit timeUnit) {
            kotlin.jvm.internal.f0.p(timeUnit, "timeUnit");
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("maxStale < 0: ", Integer.valueOf(i10)).toString());
            }
            this.f43576d = b(timeUnit.toSeconds(i10));
            return this;
        }

        @yt.k
        public final a f(int i10, @yt.k TimeUnit timeUnit) {
            kotlin.jvm.internal.f0.p(timeUnit, "timeUnit");
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("minFresh < 0: ", Integer.valueOf(i10)).toString());
            }
            this.f43577e = b(timeUnit.toSeconds(i10));
            return this;
        }

        @yt.k
        public final a g() {
            this.f43573a = true;
            return this;
        }

        @yt.k
        public final a h() {
            this.f43574b = true;
            return this;
        }

        @yt.k
        public final a i() {
            this.f43579g = true;
            return this;
        }

        @yt.k
        public final a j() {
            this.f43578f = true;
            return this;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\n\u001a\u00020\b*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/d$b;", "", "Lokhttp3/t;", IOptionConstant.headers, "Lokhttp3/d;", "c", "", "characters", "", "startIndex", "a", "FORCE_CACHE", "Lokhttp3/d;", "FORCE_NETWORK", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ int b(b bVar, String str, String str2, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return bVar.a(str, str2, i10);
        }

        public final int a(String str, String str2, int i10) {
            int length = str.length();
            while (i10 < length) {
                int i11 = i10 + 1;
                if (StringsKt__StringsKt.V2(str2, str.charAt(i10), false, 2, null)) {
                    return i10;
                }
                i10 = i11;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
        @hk.m
        @yt.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.d c(@yt.k okhttp3.t r31) {
            /*
                Method dump skipped, instruction units count: 398
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.d.b.c(okhttp3.t):okhttp3.d");
        }
    }

    public d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f43560a = z10;
        this.f43561b = z11;
        this.f43562c = i10;
        this.f43563d = i11;
        this.f43564e = z12;
        this.f43565f = z13;
        this.f43566g = z14;
        this.f43567h = i12;
        this.f43568i = i13;
        this.f43569j = z15;
        this.f43570k = z16;
        this.f43571l = z17;
        this.f43572m = str;
    }

    public /* synthetic */ d(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str, kotlin.jvm.internal.u uVar) {
        this(z10, z11, i10, i11, z12, z13, z14, i12, i13, z15, z16, z17, str);
    }

    @hk.m
    @yt.k
    public static final d v(@yt.k t tVar) {
        return f43557n.c(tVar);
    }

    @hk.h(name = "-deprecated_immutable")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "immutable", imports = {}))
    public final boolean a() {
        return this.f43571l;
    }

    @hk.h(name = "-deprecated_maxAgeSeconds")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "maxAgeSeconds", imports = {}))
    public final int b() {
        return this.f43562c;
    }

    @hk.h(name = "-deprecated_maxStaleSeconds")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "maxStaleSeconds", imports = {}))
    public final int c() {
        return this.f43567h;
    }

    @hk.h(name = "-deprecated_minFreshSeconds")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "minFreshSeconds", imports = {}))
    public final int d() {
        return this.f43568i;
    }

    @hk.h(name = "-deprecated_mustRevalidate")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "mustRevalidate", imports = {}))
    public final boolean e() {
        return this.f43566g;
    }

    @hk.h(name = "-deprecated_noCache")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "noCache", imports = {}))
    public final boolean f() {
        return this.f43560a;
    }

    @hk.h(name = "-deprecated_noStore")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "noStore", imports = {}))
    public final boolean g() {
        return this.f43561b;
    }

    @hk.h(name = "-deprecated_noTransform")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "noTransform", imports = {}))
    public final boolean h() {
        return this.f43570k;
    }

    @hk.h(name = "-deprecated_onlyIfCached")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "onlyIfCached", imports = {}))
    public final boolean i() {
        return this.f43569j;
    }

    @hk.h(name = "-deprecated_sMaxAgeSeconds")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "sMaxAgeSeconds", imports = {}))
    public final int j() {
        return this.f43563d;
    }

    @hk.h(name = "immutable")
    public final boolean k() {
        return this.f43571l;
    }

    public final boolean l() {
        return this.f43564e;
    }

    public final boolean m() {
        return this.f43565f;
    }

    @hk.h(name = "maxAgeSeconds")
    public final int n() {
        return this.f43562c;
    }

    @hk.h(name = "maxStaleSeconds")
    public final int o() {
        return this.f43567h;
    }

    @hk.h(name = "minFreshSeconds")
    public final int p() {
        return this.f43568i;
    }

    @hk.h(name = "mustRevalidate")
    public final boolean q() {
        return this.f43566g;
    }

    @hk.h(name = "noCache")
    public final boolean r() {
        return this.f43560a;
    }

    @hk.h(name = "noStore")
    public final boolean s() {
        return this.f43561b;
    }

    @hk.h(name = "noTransform")
    public final boolean t() {
        return this.f43570k;
    }

    @yt.k
    public String toString() {
        String str = this.f43572m;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        if (r()) {
            sb2.append("no-cache, ");
        }
        if (s()) {
            sb2.append("no-store, ");
        }
        if (n() != -1) {
            sb2.append("max-age=");
            sb2.append(n());
            sb2.append(", ");
        }
        if (w() != -1) {
            sb2.append("s-maxage=");
            sb2.append(w());
            sb2.append(", ");
        }
        if (l()) {
            sb2.append("private, ");
        }
        if (m()) {
            sb2.append("public, ");
        }
        if (q()) {
            sb2.append("must-revalidate, ");
        }
        if (o() != -1) {
            sb2.append("max-stale=");
            sb2.append(o());
            sb2.append(", ");
        }
        if (p() != -1) {
            sb2.append("min-fresh=");
            sb2.append(p());
            sb2.append(", ");
        }
        if (u()) {
            sb2.append("only-if-cached, ");
        }
        if (t()) {
            sb2.append("no-transform, ");
        }
        if (k()) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
        this.f43572m = string;
        return string;
    }

    @hk.h(name = "onlyIfCached")
    public final boolean u() {
        return this.f43569j;
    }

    @hk.h(name = "sMaxAgeSeconds")
    public final int w() {
        return this.f43563d;
    }
}
