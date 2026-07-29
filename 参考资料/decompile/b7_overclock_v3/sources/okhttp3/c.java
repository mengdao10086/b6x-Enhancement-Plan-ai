package okhttp3;

import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.d1;
import kotlin.jvm.internal.v0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z1;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.t;
import okio.ByteString;
import okio.r0;
import okio.t0;
import zl.h;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0004&5\u0007\u0018B!\b\u0000\u0012\u0006\u0010F\u001a\u00020%\u0012\u0006\u0010G\u001a\u00020 \u0012\u0006\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KB\u0019\b\u0016\u0012\u0006\u0010F\u001a\u00020%\u0012\u0006\u0010G\u001a\u00020 ¢\u0006\u0004\bJ\u0010LJ\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0018\u00010\u0003R\u00020\u0004H\u0002J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u0019\u001a\u00020\u0006J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020 J\u0006\u0010\"\u001a\u00020 J\b\u0010#\u001a\u00020\u0006H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u000f\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0000¢\u0006\u0004\b,\u0010-J\u0006\u0010.\u001a\u00020\u001dJ\u0006\u0010/\u001a\u00020\u001dJ\u0006\u00100\u001a\u00020\u001dR\u001a\u00104\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b&\u00101\u001a\u0004\b2\u00103R\"\u0010:\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010\"\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010=\u001a\u00020\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u0016\u0010>\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\"R\u0016\u0010@\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010\"R\u0016\u0010B\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010\"R\u0011\u0010D\u001a\u00020C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0011\u0010F\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\bA\u0010'¨\u0006N"}, d2 = {"Lokhttp3/c;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lkotlin/z1;", "c", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/d0;", "i", "(Lokhttp3/b0;)Lokhttp3/d0;", "response", "Lokhttp3/internal/cache/b;", "M", "(Lokhttp3/d0;)Lokhttp3/internal/cache/b;", "P", "(Lokhttp3/b0;)V", "cached", "network", "M0", "(Lokhttp3/d0;Lokhttp3/d0;)V", "u", "d", "h", "", "", m9.h.f40774q, "", "h1", "i1", "", "b0", "I", "flush", "close", "Ljava/io/File;", "a", "()Ljava/io/File;", "Lokhttp3/internal/cache/c;", "cacheStrategy", "G0", "(Lokhttp3/internal/cache/c;)V", "F0", "()V", "L", "n", i1.a.f31577d5, "Lokhttp3/internal/cache/DiskLruCache;", "k", "()Lokhttp3/internal/cache/DiskLruCache;", "cache", "b", m0.k.f40564b, "()I", "Z", "(I)V", "writeSuccessCount", com.flydigi.sdk.bluetooth.l.f16298a, i1.a.T4, "writeAbortCount", "networkCount", "e", "hitCount", "f", "requestCount", "", "isClosed", "()Z", "directory", "maxSize", "Lyl/a;", "fileSystem", "<init>", "(Ljava/io/File;JLyl/a;)V", "(Ljava/io/File;J)V", "g", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public static final b f43507g = new b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43508h = 201105;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f43509i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f43510j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f43511k = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final DiskLruCache f43512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f43514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f43515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f43516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f43517f;

    @kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B'\u0012\n\u0010\r\u001a\u00060\bR\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001b\u0010\r\u001a\u00060\bR\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokhttp3/c$a;", "Lokhttp3/e0;", "Lokhttp3/w;", so.d.f50127a, "", "contentLength", "Lokio/l;", "source", "Lokhttp3/internal/cache/DiskLruCache$c;", "Lokhttp3/internal/cache/DiskLruCache;", "a", "Lokhttp3/internal/cache/DiskLruCache$c;", "()Lokhttp3/internal/cache/DiskLruCache$c;", "snapshot", "", "b", "Ljava/lang/String;", "c", "d", "Lokio/l;", "bodySource", "<init>", "(Lokhttp3/internal/cache/DiskLruCache$c;Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final DiskLruCache.c f43518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public final String f43519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public final String f43520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final okio.l f43521d;

        /* JADX INFO: renamed from: okhttp3.c$a$a, reason: collision with other inner class name */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/c$a$a", "Lokio/u;", "Lkotlin/z1;", "close", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0490a extends okio.u {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t0 f43522b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f43523c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0490a(t0 t0Var, a aVar) {
                super(t0Var);
                this.f43522b = t0Var;
                this.f43523c = aVar;
            }

            @Override // okio.u, okio.t0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.f43523c.a().close();
                super.close();
            }
        }

        public a(@yt.k DiskLruCache.c snapshot, @yt.l String str, @yt.l String str2) {
            kotlin.jvm.internal.f0.p(snapshot, "snapshot");
            this.f43518a = snapshot;
            this.f43519b = str;
            this.f43520c = str2;
            this.f43521d = okio.f0.e(new C0490a(snapshot.d(1), this));
        }

        @yt.k
        public final DiskLruCache.c a() {
            return this.f43518a;
        }

        @Override // okhttp3.e0
        public long contentLength() {
            String str = this.f43520c;
            if (str == null) {
                return -1L;
            }
            return rl.f.j0(str, -1L);
        }

        @Override // okhttp3.e0
        @yt.l
        public w contentType() {
            String str = this.f43519b;
            if (str == null) {
                return null;
            }
            return w.f43984e.d(str);
        }

        @Override // okhttp3.e0
        @yt.k
        public okio.l source() {
            return this.f43521d;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\n\u0010\u0013\u001a\u00020\u0011*\u00020\u000bJ\n\u0010\u0014\u001a\u00020\r*\u00020\u000bJ\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015*\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006!"}, d2 = {"Lokhttp3/c$b;", "", "Lokhttp3/u;", "url", "", "b", "Lokio/l;", "source", "", "c", "(Lokio/l;)I", "Lokhttp3/d0;", "cachedResponse", "Lokhttp3/t;", "cachedRequest", "Lokhttp3/b0;", "newRequest", "", "g", "a", "f", "", "d", "requestHeaders", "responseHeaders", "e", "ENTRY_BODY", "I", "ENTRY_COUNT", "ENTRY_METADATA", "VERSION", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final boolean a(@yt.k d0 d0Var) {
            kotlin.jvm.internal.f0.p(d0Var, "<this>");
            return d(d0Var.h1()).contains("*");
        }

        @hk.m
        @yt.k
        public final String b(@yt.k u url) {
            kotlin.jvm.internal.f0.p(url, "url");
            return ByteString.f44029c.l(url.toString()).Z().B();
        }

        public final int c(@yt.k okio.l source) throws IOException {
            kotlin.jvm.internal.f0.p(source, "source");
            try {
                long jN0 = source.n0();
                String strN1 = source.n1();
                if (jN0 >= 0 && jN0 <= 2147483647L) {
                    if (!(strN1.length() > 0)) {
                        return (int) jN0;
                    }
                }
                throw new IOException("expected an int but was \"" + jN0 + strN1 + kotlin.text.y.f38188b);
            } catch (NumberFormatException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final Set<String> d(t tVar) {
            int size = tVar.size();
            TreeSet treeSet = null;
            int i10 = 0;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (kotlin.text.u.L1(HttpHeaders.VARY, tVar.j(i10), true)) {
                    String strR = tVar.r(i10);
                    if (treeSet == null) {
                        treeSet = new TreeSet(kotlin.text.u.T1(v0.f37964a));
                    }
                    Iterator it2 = StringsKt__StringsKt.T4(strR, new char[]{','}, false, 0, 6, null).iterator();
                    while (it2.hasNext()) {
                        treeSet.add(StringsKt__StringsKt.F5((String) it2.next()).toString());
                    }
                }
                i10 = i11;
            }
            return treeSet == null ? d1.k() : treeSet;
        }

        public final t e(t tVar, t tVar2) {
            Set<String> setD = d(tVar2);
            if (setD.isEmpty()) {
                return rl.f.f48797b;
            }
            t.a aVar = new t.a();
            int i10 = 0;
            int size = tVar.size();
            while (i10 < size) {
                int i11 = i10 + 1;
                String strJ = tVar.j(i10);
                if (setD.contains(strJ)) {
                    aVar.b(strJ, tVar.r(i10));
                }
                i10 = i11;
            }
            return aVar.i();
        }

        @yt.k
        public final t f(@yt.k d0 d0Var) {
            kotlin.jvm.internal.f0.p(d0Var, "<this>");
            d0 d0VarP1 = d0Var.p1();
            kotlin.jvm.internal.f0.m(d0VarP1);
            return e(d0VarP1.V1().k(), d0Var.h1());
        }

        public final boolean g(@yt.k d0 cachedResponse, @yt.k t cachedRequest, @yt.k b0 newRequest) {
            kotlin.jvm.internal.f0.p(cachedResponse, "cachedResponse");
            kotlin.jvm.internal.f0.p(cachedRequest, "cachedRequest");
            kotlin.jvm.internal.f0.p(newRequest, "newRequest");
            Set<String> setD = d(cachedResponse.h1());
            if ((setD instanceof Collection) && setD.isEmpty()) {
                return true;
            }
            for (String str : setD) {
                if (!kotlin.jvm.internal.f0.g(cachedRequest.s(str), newRequest.j(str))) {
                    return false;
                }
            }
            return true;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u00060\u0006R\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\t\u001a\u00060\u0006R\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\"\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\r\u0010\u0012\"\u0004\b\u0010\u0010\u0013¨\u0006\u0017"}, d2 = {"Lokhttp3/c$d;", "Lokhttp3/internal/cache/b;", "Lkotlin/z1;", "abort", "Lokio/r0;", "a", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "editor", "b", "Lokio/r0;", "cacheOut", "c", "body", "", "d", "Z", "()Z", "(Z)V", "done", "<init>", "(Lokhttp3/c;Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class d implements okhttp3.internal.cache.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final DiskLruCache.Editor f43537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final r0 f43538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final r0 f43539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f43540d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c f43541e;

        @kotlin.d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"okhttp3/c$d$a", "Lokio/t;", "Lkotlin/z1;", "close", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a extends okio.t {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f43542b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ d f43543c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, d dVar, r0 r0Var) {
                super(r0Var);
                this.f43542b = cVar;
                this.f43543c = dVar;
            }

            @Override // okio.t, okio.r0, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                c cVar = this.f43542b;
                d dVar = this.f43543c;
                synchronized (cVar) {
                    if (dVar.c()) {
                        return;
                    }
                    dVar.d(true);
                    cVar.Z(cVar.m() + 1);
                    super.close();
                    this.f43543c.f43537a.b();
                }
            }
        }

        public d(@yt.k c this$0, DiskLruCache.Editor editor) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            kotlin.jvm.internal.f0.p(editor, "editor");
            this.f43541e = this$0;
            this.f43537a = editor;
            r0 r0VarF = editor.f(1);
            this.f43538b = r0VarF;
            this.f43539c = new a(this$0, this, r0VarF);
        }

        @Override // okhttp3.internal.cache.b
        @yt.k
        public r0 a() {
            return this.f43539c;
        }

        @Override // okhttp3.internal.cache.b
        public void abort() {
            c cVar = this.f43541e;
            synchronized (cVar) {
                if (c()) {
                    return;
                }
                d(true);
                cVar.W(cVar.l() + 1);
                rl.f.o(this.f43538b);
                try {
                    this.f43537a.a();
                } catch (IOException unused) {
                }
            }
        }

        public final boolean c() {
            return this.f43540d;
        }

        public final void d(boolean z10) {
            this.f43540d = z10;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000'\n\u0000\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u001e\u0010\u000b\u001a\f\u0012\b\u0012\u00060\bR\u00020\t0\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"okhttp3/c$e", "", "", "", "hasNext", "a", "Lkotlin/z1;", "remove", "Lokhttp3/internal/cache/DiskLruCache$c;", "Lokhttp3/internal/cache/DiskLruCache;", "Ljava/util/Iterator;", "delegate", "b", "Ljava/lang/String;", "nextUrl", "c", "Z", "canRemove", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class e implements Iterator<String>, jk.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Iterator<DiskLruCache.c> f43544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public String f43545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f43546c;

        public e() {
            this.f43544a = c.this.k().Y1();
        }

        @Override // java.util.Iterator
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f43545b;
            kotlin.jvm.internal.f0.m(str);
            this.f43545b = null;
            this.f43546c = true;
            return str;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f43545b != null) {
                return true;
            }
            this.f43546c = false;
            while (this.f43544a.hasNext()) {
                try {
                    DiskLruCache.c next = this.f43544a.next();
                    try {
                        continue;
                        this.f43545b = okio.f0.e(next.d(0)).n1();
                        kotlin.io.b.a(next, null);
                        return true;
                    } finally {
                        try {
                            continue;
                        } catch (Throwable th2) {
                        }
                    }
                } catch (IOException unused) {
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f43546c) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            this.f43544a.remove();
        }
    }

    public c(@yt.k File directory, long j10, @yt.k yl.a fileSystem) {
        kotlin.jvm.internal.f0.p(directory, "directory");
        kotlin.jvm.internal.f0.p(fileSystem, "fileSystem");
        this.f43512a = new DiskLruCache(fileSystem, directory, f43508h, 2, j10, ul.d.f52208i);
    }

    @hk.m
    @yt.k
    public static final String z(@yt.k u uVar) {
        return f43507g.b(uVar);
    }

    public final synchronized void F0() {
        this.f43516e++;
    }

    public final synchronized void G0(@yt.k okhttp3.internal.cache.c cacheStrategy) {
        kotlin.jvm.internal.f0.p(cacheStrategy, "cacheStrategy");
        this.f43517f++;
        if (cacheStrategy.b() != null) {
            this.f43515d++;
        } else if (cacheStrategy.a() != null) {
            this.f43516e++;
        }
    }

    public final long I() {
        return this.f43512a.F0();
    }

    public final synchronized int L() {
        return this.f43515d;
    }

    @yt.l
    public final okhttp3.internal.cache.b M(@yt.k d0 response) {
        DiskLruCache.Editor editorL;
        kotlin.jvm.internal.f0.p(response, "response");
        String strM = response.V1().m();
        if (vl.f.f53205a.a(response.V1().m())) {
            try {
                P(response.V1());
            } catch (IOException unused) {
            }
            return null;
        }
        if (!kotlin.jvm.internal.f0.g(strM, Constants.HTTP_GET)) {
            return null;
        }
        b bVar = f43507g;
        if (bVar.a(response)) {
            return null;
        }
        C0491c c0491c = new C0491c(response);
        try {
            editorL = DiskLruCache.L(this.f43512a, bVar.b(response.V1().q()), 0L, 2, null);
            if (editorL == null) {
                return null;
            }
            try {
                c0491c.f(editorL);
                return new d(this, editorL);
            } catch (IOException unused2) {
                c(editorL);
                return null;
            }
        } catch (IOException unused3) {
            editorL = null;
        }
    }

    public final void M0(@yt.k d0 cached, @yt.k d0 network) {
        kotlin.jvm.internal.f0.p(cached, "cached");
        kotlin.jvm.internal.f0.p(network, "network");
        C0491c c0491c = new C0491c(network);
        e0 e0VarL = cached.L();
        Objects.requireNonNull(e0VarL, "null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        DiskLruCache.Editor editorA = null;
        try {
            editorA = ((a) e0VarL).a().a();
            if (editorA == null) {
                return;
            }
            c0491c.f(editorA);
            editorA.b();
        } catch (IOException unused) {
            c(editorA);
        }
    }

    public final void P(@yt.k b0 request) throws IOException {
        kotlin.jvm.internal.f0.p(request, "request");
        this.f43512a.s1(f43507g.b(request.q()));
    }

    public final synchronized int T() {
        return this.f43517f;
    }

    public final void W(int i10) {
        this.f43514c = i10;
    }

    public final void Z(int i10) {
        this.f43513b = i10;
    }

    @hk.h(name = "-deprecated_directory")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "directory", imports = {}))
    @yt.k
    public final File a() {
        return this.f43512a.W();
    }

    public final long b0() throws IOException {
        return this.f43512a.V1();
    }

    public final void c(DiskLruCache.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.a();
        } catch (IOException unused) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f43512a.close();
    }

    public final void d() throws IOException {
        this.f43512a.u();
    }

    @yt.k
    public final Iterator<String> d1() throws IOException {
        return new e();
    }

    @hk.h(name = "directory")
    @yt.k
    public final File f() {
        return this.f43512a.W();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f43512a.flush();
    }

    public final void h() throws IOException {
        this.f43512a.M();
    }

    public final synchronized int h1() {
        return this.f43514c;
    }

    @yt.l
    public final d0 i(@yt.k b0 request) {
        kotlin.jvm.internal.f0.p(request, "request");
        try {
            DiskLruCache.c cVarP = this.f43512a.P(f43507g.b(request.q()));
            if (cVarP == null) {
                return null;
            }
            try {
                C0491c c0491c = new C0491c(cVarP.d(0));
                d0 d0VarD = c0491c.d(cVarP);
                if (c0491c.b(request, d0VarD)) {
                    return d0VarD;
                }
                e0 e0VarL = d0VarD.L();
                if (e0VarL != null) {
                    rl.f.o(e0VarL);
                }
                return null;
            } catch (IOException unused) {
                rl.f.o(cVarP);
                return null;
            }
        } catch (IOException unused2) {
        }
    }

    public final synchronized int i1() {
        return this.f43513b;
    }

    public final boolean isClosed() {
        return this.f43512a.isClosed();
    }

    @yt.k
    public final DiskLruCache k() {
        return this.f43512a;
    }

    public final int l() {
        return this.f43514c;
    }

    public final int m() {
        return this.f43513b;
    }

    public final synchronized int n() {
        return this.f43516e;
    }

    public final void u() throws IOException {
        this.f43512a.M0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@yt.k File directory, long j10) {
        this(directory, j10, yl.a.f57363b);
        kotlin.jvm.internal.f0.p(directory, "directory");
    }

    /* JADX INFO: renamed from: okhttp3.c$c, reason: collision with other inner class name */
    @kotlin.d0(bv = {}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 =2\u00020\u0001:\u0001\u001aB\u0011\b\u0016\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;B\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b:\u0010<J\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002R\u00020\u0003J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\u000f\u001a\u00020\t2\n\u0010\u000e\u001a\u00060\rR\u00020\u0003J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0014\u0010\"\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010'R\u0014\u0010)\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010!R\u0014\u0010+\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u001eR\u0016\u0010/\u001a\u0004\u0018\u00010,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00105\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102R\u0014\u00107\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u00106¨\u0006>"}, d2 = {"Lokhttp3/c$c;", "", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "editor", "Lkotlin/z1;", "f", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/d0;", "response", "", "b", "Lokhttp3/internal/cache/DiskLruCache$c;", "snapshot", "d", "Lokio/l;", "source", "", "Ljava/security/cert/Certificate;", "c", "Lokio/k;", "sink", "certificates", "e", "Lokhttp3/u;", "a", "Lokhttp3/u;", "url", "Lokhttp3/t;", "Lokhttp3/t;", "varyHeaders", "", "Ljava/lang/String;", "requestMethod", "Lokhttp3/Protocol;", "Lokhttp3/Protocol;", "protocol", "", "I", "code", "message", "g", "responseHeaders", "Lokhttp3/Handshake;", "h", "Lokhttp3/Handshake;", "handshake", "", "i", "J", "sentRequestMillis", xf.j.f55230b, "receivedResponseMillis", "()Z", "isHttps", "Lokio/t0;", "rawSource", "<init>", "(Lokio/t0;)V", "(Lokhttp3/d0;)V", "k", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class C0491c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @yt.k
        public static final a f43524k = new a(null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @yt.k
        public static final String f43525l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @yt.k
        public static final String f43526m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final u f43527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final t f43528b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final String f43529c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final Protocol f43530d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f43531e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.k
        public final String f43532f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public final t f43533g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.l
        public final Handshake f43534h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f43535i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f43536j;

        /* JADX INFO: renamed from: okhttp3.c$c$a */
        @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lokhttp3/c$c$a;", "", "", "RECEIVED_MILLIS", "Ljava/lang/String;", "SENT_MILLIS", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }
        }

        static {
            h.a aVar = zl.h.f58636a;
            f43525l = kotlin.jvm.internal.f0.C(aVar.g().i(), "-Sent-Millis");
            f43526m = kotlin.jvm.internal.f0.C(aVar.g().i(), "-Received-Millis");
        }

        public C0491c(@yt.k t0 rawSource) throws IOException {
            kotlin.jvm.internal.f0.p(rawSource, "rawSource");
            try {
                okio.l lVarE = okio.f0.e(rawSource);
                String strN1 = lVarE.n1();
                u uVarL = u.f43948k.l(strN1);
                if (uVarL == null) {
                    IOException iOException = new IOException(kotlin.jvm.internal.f0.C("Cache corruption for ", strN1));
                    zl.h.f58636a.g().m("cache corruption", 5, iOException);
                    throw iOException;
                }
                this.f43527a = uVarL;
                this.f43529c = lVarE.n1();
                t.a aVar = new t.a();
                int iC = c.f43507g.c(lVarE);
                int i10 = 0;
                while (i10 < iC) {
                    i10++;
                    aVar.f(lVarE.n1());
                }
                this.f43528b = aVar.i();
                vl.k kVarB = vl.k.f53222d.b(lVarE.n1());
                this.f43530d = kVarB.f53227a;
                this.f43531e = kVarB.f53228b;
                this.f43532f = kVarB.f53229c;
                t.a aVar2 = new t.a();
                int iC2 = c.f43507g.c(lVarE);
                int i11 = 0;
                while (i11 < iC2) {
                    i11++;
                    aVar2.f(lVarE.n1());
                }
                String str = f43525l;
                String strJ = aVar2.j(str);
                String str2 = f43526m;
                String strJ2 = aVar2.j(str2);
                aVar2.l(str);
                aVar2.l(str2);
                long j10 = 0;
                this.f43535i = strJ == null ? 0L : Long.parseLong(strJ);
                if (strJ2 != null) {
                    j10 = Long.parseLong(strJ2);
                }
                this.f43536j = j10;
                this.f43533g = aVar2.i();
                if (a()) {
                    String strN12 = lVarE.n1();
                    if (strN12.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + strN12 + kotlin.text.y.f38188b);
                    }
                    this.f43534h = Handshake.f43420e.c(!lVarE.d0() ? TlsVersion.Companion.a(lVarE.n1()) : TlsVersion.SSL_3_0, h.f43622b.b(lVarE.n1()), c(lVarE), c(lVarE));
                } else {
                    this.f43534h = null;
                }
                z1 z1Var = z1.f38230a;
                kotlin.io.b.a(rawSource, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    kotlin.io.b.a(rawSource, th2);
                    throw th3;
                }
            }
        }

        public final boolean a() {
            return kotlin.jvm.internal.f0.g(this.f43527a.X(), "https");
        }

        public final boolean b(@yt.k b0 request, @yt.k d0 response) {
            kotlin.jvm.internal.f0.p(request, "request");
            kotlin.jvm.internal.f0.p(response, "response");
            return kotlin.jvm.internal.f0.g(this.f43527a, request.q()) && kotlin.jvm.internal.f0.g(this.f43529c, request.m()) && c.f43507g.g(response, this.f43528b, request);
        }

        public final List<Certificate> c(okio.l lVar) throws IOException {
            int iC = c.f43507g.c(lVar);
            if (iC == -1) {
                return CollectionsKt__CollectionsKt.E();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(iC);
                int i10 = 0;
                while (i10 < iC) {
                    i10++;
                    String strN1 = lVar.n1();
                    okio.j jVar = new okio.j();
                    ByteString byteStringH = ByteString.f44029c.h(strN1);
                    kotlin.jvm.internal.f0.m(byteStringH);
                    jVar.B1(byteStringH);
                    arrayList.add(certificateFactory.generateCertificate(jVar.e2()));
                }
                return arrayList;
            } catch (CertificateException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        @yt.k
        public final d0 d(@yt.k DiskLruCache.c snapshot) {
            kotlin.jvm.internal.f0.p(snapshot, "snapshot");
            String strD = this.f43533g.d("Content-Type");
            String strD2 = this.f43533g.d(HttpHeaders.CONTENT_LENGTH);
            return new d0.a().E(new b0.a().D(this.f43527a).p(this.f43529c, null).o(this.f43528b).b()).B(this.f43530d).g(this.f43531e).y(this.f43532f).w(this.f43533g).b(new a(snapshot, strD, strD2)).u(this.f43534h).F(this.f43535i).C(this.f43536j).c();
        }

        public final void e(okio.k kVar, List<? extends Certificate> list) throws IOException {
            try {
                kVar.W1(list.size()).writeByte(10);
                Iterator<? extends Certificate> it2 = list.iterator();
                while (it2.hasNext()) {
                    byte[] bytes = it2.next().getEncoded();
                    ByteString.a aVar = ByteString.f44029c;
                    kotlin.jvm.internal.f0.o(bytes, "bytes");
                    kVar.H0(ByteString.a.p(aVar, bytes, 0, 0, 3, null).h()).writeByte(10);
                }
            } catch (CertificateEncodingException e10) {
                throw new IOException(e10.getMessage());
            }
        }

        public final void f(@yt.k DiskLruCache.Editor editor) throws IOException {
            kotlin.jvm.internal.f0.p(editor, "editor");
            okio.k kVarD = okio.f0.d(editor.f(0));
            try {
                kVarD.H0(this.f43527a.toString()).writeByte(10);
                kVarD.H0(this.f43529c).writeByte(10);
                kVarD.W1(this.f43528b.size()).writeByte(10);
                int size = this.f43528b.size();
                int i10 = 0;
                while (i10 < size) {
                    int i11 = i10 + 1;
                    kVarD.H0(this.f43528b.j(i10)).H0(": ").H0(this.f43528b.r(i10)).writeByte(10);
                    i10 = i11;
                }
                kVarD.H0(new vl.k(this.f43530d, this.f43531e, this.f43532f).toString()).writeByte(10);
                kVarD.W1(this.f43533g.size() + 2).writeByte(10);
                int size2 = this.f43533g.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    kVarD.H0(this.f43533g.j(i12)).H0(": ").H0(this.f43533g.r(i12)).writeByte(10);
                }
                kVarD.H0(f43525l).H0(": ").W1(this.f43535i).writeByte(10);
                kVarD.H0(f43526m).H0(": ").W1(this.f43536j).writeByte(10);
                if (a()) {
                    kVarD.writeByte(10);
                    Handshake handshake = this.f43534h;
                    kotlin.jvm.internal.f0.m(handshake);
                    kVarD.H0(handshake.g().e()).writeByte(10);
                    e(kVarD, this.f43534h.m());
                    e(kVarD, this.f43534h.k());
                    kVarD.H0(this.f43534h.o().javaName()).writeByte(10);
                }
                z1 z1Var = z1.f38230a;
                kotlin.io.b.a(kVarD, null);
            } finally {
            }
        }

        public C0491c(@yt.k d0 response) {
            kotlin.jvm.internal.f0.p(response, "response");
            this.f43527a = response.V1().q();
            this.f43528b = c.f43507g.f(response);
            this.f43529c = response.V1().m();
            this.f43530d = response.C1();
            this.f43531e = response.W();
            this.f43532f = response.m1();
            this.f43533g = response.h1();
            this.f43534h = response.b0();
            this.f43535i = response.Y1();
            this.f43536j = response.L1();
        }
    }
}
