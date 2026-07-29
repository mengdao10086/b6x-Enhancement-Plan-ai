package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.common.net.HttpHeaders;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.DeprecationLevel;
import kotlin.t0;
import okhttp3.c0;
import okhttp3.t;
import okhttp3.w;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 12\u00020\u0001:\u0003\u0013\u0007\u001eB'\b\u0000\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0017\u0010!\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\tR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f8\u0007¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010\u0011R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001fR\u0016\u0010*\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0011\u0010,\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\b+\u0010\fR\u0011\u0010.\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b-\u0010\u000e¨\u00062"}, d2 = {"Lokhttp3/x;", "Lokhttp3/c0;", "", "index", "Lokhttp3/x$c;", "x", "Lokhttp3/w;", "b", "v", "()Lokhttp3/w;", "", an.aB, "()Ljava/lang/String;", "u", "()I", "", "t", "()Ljava/util/List;", "", "a", "Lokio/k;", "sink", "Lkotlin/z1;", SsManifestParser.e.J, "", "countBytes", "B", "Lokio/ByteString;", "Lokio/ByteString;", "boundaryByteString", "c", "Lokhttp3/w;", i1.a.W4, "type", "d", "Ljava/util/List;", "y", "parts", "e", so.d.f50127a, "f", "J", "contentLength", "w", "boundary", an.aD, "size", "<init>", "(Lokio/ByteString;Lokhttp3/w;Ljava/util/List;)V", "g", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class x extends c0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final b f43993g = new b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f43994h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f43995i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f43996j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f43997k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final w f43998l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.k
    public static final byte[] f43999m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.k
    public static final byte[] f44000n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public static final byte[] f44001o;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ByteString f44002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final w f44003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final List<c> f44004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final w f44005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f44006f;

    @kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000b¨\u0006\u0017"}, d2 = {"Lokhttp3/x$b;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "Lkotlin/z1;", "a", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "Lokhttp3/w;", "ALTERNATIVE", "Lokhttp3/w;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final void a(@yt.k StringBuilder sb2, @yt.k String key) {
            kotlin.jvm.internal.f0.p(sb2, "<this>");
            kotlin.jvm.internal.f0.p(key, "key");
            sb2.append(kotlin.text.y.f38188b);
            int length = key.length();
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                char cCharAt = key.charAt(i10);
                if (cCharAt == '\n') {
                    sb2.append("%0A");
                } else if (cCharAt == '\r') {
                    sb2.append("%0D");
                } else if (cCharAt == '\"') {
                    sb2.append("%22");
                } else {
                    sb2.append(cCharAt);
                }
                i10 = i11;
            }
            sb2.append(kotlin.text.y.f38188b);
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\u0006B\u001b\b\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\u0007¨\u0006\u0010"}, d2 = {"Lokhttp3/x$c;", "", "Lokhttp3/t;", "b", "()Lokhttp3/t;", "Lokhttp3/c0;", "a", "()Lokhttp3/c0;", "Lokhttp3/t;", "h", IOptionConstant.headers, "Lokhttp3/c0;", "c", "body", "<init>", "(Lokhttp3/t;Lokhttp3/c0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public static final a f44010c = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public final t f44011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final c0 f44012b;

        @kotlin.d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0011"}, d2 = {"Lokhttp3/x$c$a;", "", "Lokhttp3/c0;", "body", "Lokhttp3/x$c;", "b", "Lokhttp3/t;", IOptionConstant.headers, "a", "", "name", "value", "c", "filename", "d", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }

            @hk.m
            @yt.k
            public final c a(@yt.l t tVar, @yt.k c0 body) {
                kotlin.jvm.internal.f0.p(body, "body");
                kotlin.jvm.internal.u uVar = null;
                if (!((tVar == null ? null : tVar.d("Content-Type")) == null)) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
                }
                if ((tVar == null ? null : tVar.d(HttpHeaders.CONTENT_LENGTH)) == null) {
                    return new c(tVar, body, uVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }

            @hk.m
            @yt.k
            public final c b(@yt.k c0 body) {
                kotlin.jvm.internal.f0.p(body, "body");
                return a(null, body);
            }

            @hk.m
            @yt.k
            public final c c(@yt.k String name, @yt.k String value) {
                kotlin.jvm.internal.f0.p(name, "name");
                kotlin.jvm.internal.f0.p(value, "value");
                return d(name, null, c0.a.o(c0.f43548a, value, null, 1, null));
            }

            @hk.m
            @yt.k
            public final c d(@yt.k String name, @yt.l String str, @yt.k c0 body) {
                kotlin.jvm.internal.f0.p(name, "name");
                kotlin.jvm.internal.f0.p(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                b bVar = x.f43993g;
                bVar.a(sb2, name);
                if (str != null) {
                    sb2.append("; filename=");
                    bVar.a(sb2, str);
                }
                String string = sb2.toString();
                kotlin.jvm.internal.f0.o(string, "StringBuilder().apply(builderAction).toString()");
                return a(new t.a().h(HttpHeaders.CONTENT_DISPOSITION, string).i(), body);
            }
        }

        public c(t tVar, c0 c0Var) {
            this.f44011a = tVar;
            this.f44012b = c0Var;
        }

        public /* synthetic */ c(t tVar, c0 c0Var, kotlin.jvm.internal.u uVar) {
            this(tVar, c0Var);
        }

        @hk.m
        @yt.k
        public static final c d(@yt.l t tVar, @yt.k c0 c0Var) {
            return f44010c.a(tVar, c0Var);
        }

        @hk.m
        @yt.k
        public static final c e(@yt.k c0 c0Var) {
            return f44010c.b(c0Var);
        }

        @hk.m
        @yt.k
        public static final c f(@yt.k String str, @yt.k String str2) {
            return f44010c.c(str, str2);
        }

        @hk.m
        @yt.k
        public static final c g(@yt.k String str, @yt.l String str2, @yt.k c0 c0Var) {
            return f44010c.d(str, str2, c0Var);
        }

        @hk.h(name = "-deprecated_body")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "body", imports = {}))
        @yt.k
        public final c0 a() {
            return this.f44012b;
        }

        @hk.h(name = "-deprecated_headers")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = IOptionConstant.headers, imports = {}))
        @yt.l
        public final t b() {
            return this.f44011a;
        }

        @hk.h(name = "body")
        @yt.k
        public final c0 c() {
            return this.f44012b;
        }

        @hk.h(name = IOptionConstant.headers)
        @yt.l
        public final t h() {
            return this.f44011a;
        }
    }

    static {
        w.a aVar = w.f43984e;
        f43994h = aVar.c("multipart/mixed");
        f43995i = aVar.c("multipart/alternative");
        f43996j = aVar.c("multipart/digest");
        f43997k = aVar.c("multipart/parallel");
        f43998l = aVar.c("multipart/form-data");
        f43999m = new byte[]{58, 32};
        f44000n = new byte[]{13, 10};
        f44001o = new byte[]{rc.a.f48413e0, rc.a.f48413e0};
    }

    public x(@yt.k ByteString boundaryByteString, @yt.k w type, @yt.k List<c> parts) {
        kotlin.jvm.internal.f0.p(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.f0.p(type, "type");
        kotlin.jvm.internal.f0.p(parts, "parts");
        this.f44002b = boundaryByteString;
        this.f44003c = type;
        this.f44004d = parts;
        this.f44005e = w.f43984e.c(type + "; boundary=" + w());
        this.f44006f = -1L;
    }

    @hk.h(name = "type")
    @yt.k
    public final w A() {
        return this.f44003c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long B(okio.k kVar, boolean z10) throws IOException {
        okio.j jVar;
        if (z10) {
            kVar = new okio.j();
            jVar = kVar;
        } else {
            jVar = 0;
        }
        int size = this.f44004d.size();
        long j10 = 0;
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            c cVar = this.f44004d.get(i10);
            t tVarH = cVar.h();
            c0 c0VarC = cVar.c();
            kotlin.jvm.internal.f0.m(kVar);
            kVar.write(f44001o);
            kVar.B1(this.f44002b);
            kVar.write(f44000n);
            if (tVarH != null) {
                int size2 = tVarH.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    kVar.H0(tVarH.j(i12)).write(f43999m).H0(tVarH.r(i12)).write(f44000n);
                }
            }
            w wVarB = c0VarC.b();
            if (wVarB != null) {
                kVar.H0("Content-Type: ").H0(wVarB.toString()).write(f44000n);
            }
            long jA = c0VarC.a();
            if (jA != -1) {
                kVar.H0("Content-Length: ").W1(jA).write(f44000n);
            } else if (z10) {
                kotlin.jvm.internal.f0.m(jVar);
                jVar.d();
                return -1L;
            }
            byte[] bArr = f44000n;
            kVar.write(bArr);
            if (z10) {
                j10 += jA;
            } else {
                c0VarC.r(kVar);
            }
            kVar.write(bArr);
            i10 = i11;
        }
        kotlin.jvm.internal.f0.m(kVar);
        byte[] bArr2 = f44001o;
        kVar.write(bArr2);
        kVar.B1(this.f44002b);
        kVar.write(bArr2);
        kVar.write(f44000n);
        if (!z10) {
            return j10;
        }
        kotlin.jvm.internal.f0.m(jVar);
        long jM2 = j10 + jVar.m2();
        jVar.d();
        return jM2;
    }

    @Override // okhttp3.c0
    public long a() throws IOException {
        long j10 = this.f44006f;
        if (j10 != -1) {
            return j10;
        }
        long jB = B(null, true);
        this.f44006f = jB;
        return jB;
    }

    @Override // okhttp3.c0
    @yt.k
    public w b() {
        return this.f44005e;
    }

    @Override // okhttp3.c0
    public void r(@yt.k okio.k sink) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        B(sink, false);
    }

    @hk.h(name = "-deprecated_boundary")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "boundary", imports = {}))
    @yt.k
    public final String s() {
        return w();
    }

    @hk.h(name = "-deprecated_parts")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "parts", imports = {}))
    @yt.k
    public final List<c> t() {
        return this.f44004d;
    }

    @hk.h(name = "-deprecated_size")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "size", imports = {}))
    public final int u() {
        return z();
    }

    @hk.h(name = "-deprecated_type")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "type", imports = {}))
    @yt.k
    public final w v() {
        return this.f44003c;
    }

    @hk.h(name = "boundary")
    @yt.k
    public final String w() {
        return this.f44002b.O0();
    }

    @yt.k
    public final c x(int i10) {
        return this.f44004d.get(i10);
    }

    @hk.h(name = "parts")
    @yt.k
    public final List<c> y() {
        return this.f44004d;
    }

    @hk.h(name = "size")
    public final int z() {
        return this.f44004d.size();
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b¢\u0006\u0004\b\u001d\u0010\u001eJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ \u0010\u0010\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u001b¨\u0006\u001f"}, d2 = {"Lokhttp3/x$a;", "", "Lokhttp3/w;", "type", "g", "Lokhttp3/c0;", "body", "e", "Lokhttp3/t;", IOptionConstant.headers, "c", "", "name", "value", "a", "filename", "b", "Lokhttp3/x$c;", "part", "d", "Lokhttp3/x;", "f", "Lokio/ByteString;", "Lokio/ByteString;", "boundary", "Lokhttp3/w;", "", "Ljava/util/List;", "parts", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final ByteString f44007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public w f44008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final List<c> f44009c;

        /* JADX WARN: Multi-variable type inference failed */
        @hk.i
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @hk.i
        public a(@yt.k String boundary) {
            kotlin.jvm.internal.f0.p(boundary, "boundary");
            this.f44007a = ByteString.f44029c.l(boundary);
            this.f44008b = x.f43994h;
            this.f44009c = new ArrayList();
        }

        @yt.k
        public final a a(@yt.k String name, @yt.k String value) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(value, "value");
            d(c.f44010c.c(name, value));
            return this;
        }

        @yt.k
        public final a b(@yt.k String name, @yt.l String str, @yt.k c0 body) {
            kotlin.jvm.internal.f0.p(name, "name");
            kotlin.jvm.internal.f0.p(body, "body");
            d(c.f44010c.d(name, str, body));
            return this;
        }

        @yt.k
        public final a c(@yt.l t tVar, @yt.k c0 body) {
            kotlin.jvm.internal.f0.p(body, "body");
            d(c.f44010c.a(tVar, body));
            return this;
        }

        @yt.k
        public final a d(@yt.k c part) {
            kotlin.jvm.internal.f0.p(part, "part");
            this.f44009c.add(part);
            return this;
        }

        @yt.k
        public final a e(@yt.k c0 body) {
            kotlin.jvm.internal.f0.p(body, "body");
            d(c.f44010c.b(body));
            return this;
        }

        @yt.k
        public final x f() {
            if (!this.f44009c.isEmpty()) {
                return new x(this.f44007a, this.f44008b, rl.f.h0(this.f44009c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @yt.k
        public final a g(@yt.k w type) {
            kotlin.jvm.internal.f0.p(type, "type");
            if (!kotlin.jvm.internal.f0.g(type.l(), "multipart")) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("multipart != ", type).toString());
            }
            this.f44008b = type;
            return this;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.u uVar) {
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                kotlin.jvm.internal.f0.o(str, "randomUUID().toString()");
            }
            this(str);
        }
    }
}
