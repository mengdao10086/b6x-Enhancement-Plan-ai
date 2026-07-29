package okhttp3;

import com.arialyy.aria.core.inf.IOptionConstant;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.i0;
import okio.t0;
import okio.v0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0003\n\u000e\u0014B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b'\u0010(B\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001c\u0010&\u001a\b\u0018\u00010#R\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lokhttp3/y;", "Ljava/io/Closeable;", "Lokhttp3/y$b;", com.flydigi.sdk.bluetooth.l.f16298a, "Lkotlin/z1;", "close", "", "maxResult", "k", "Lokio/l;", "a", "Lokio/l;", "source", "", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "boundary", "Lokio/ByteString;", "c", "Lokio/ByteString;", "dashDashBoundary", "d", "crlfDashDashBoundary", "", "e", "I", "partCount", "", "f", "Z", "closed", "g", "noMoreParts", "Lokhttp3/y$c;", "h", "Lokhttp3/y$c;", "currentPart", "<init>", "(Lokio/l;Ljava/lang/String;)V", "Lokhttp3/e0;", "response", "(Lokhttp3/e0;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class y implements Closeable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f44013i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public static final i0 f44014j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final okio.l f44015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f44016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final ByteString f44017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ByteString f44018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f44019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f44021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public c f44022h;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lokhttp3/y$a;", "", "Lokio/i0;", "afterBoundaryOptions", "Lokio/i0;", "a", "()Lokio/i0;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final i0 a() {
            return y.f44014j;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0001R\u0017\u0010\t\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0005\u0010\r¨\u0006\u0011"}, d2 = {"Lokhttp3/y$b;", "Ljava/io/Closeable;", "Lkotlin/z1;", "close", "Lokhttp3/t;", "a", "Lokhttp3/t;", "c", "()Lokhttp3/t;", IOptionConstant.headers, "Lokio/l;", "b", "Lokio/l;", "()Lokio/l;", "body", "<init>", "(Lokhttp3/t;Lokio/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final t f44023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final okio.l f44024b;

        public b(@yt.k t headers, @yt.k okio.l body) {
            kotlin.jvm.internal.f0.p(headers, "headers");
            kotlin.jvm.internal.f0.p(body, "body");
            this.f44023a = headers;
            this.f44024b = body;
        }

        @hk.h(name = "body")
        @yt.k
        public final okio.l a() {
            return this.f44024b;
        }

        @hk.h(name = IOptionConstant.headers)
        @yt.k
        public final t c() {
            return this.f44023a;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f44024b.close();
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lokhttp3/y$c;", "Lokio/t0;", "Lkotlin/z1;", "close", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/v0;", "U", "a", "Lokio/v0;", "timeout", "<init>", "(Lokhttp3/y;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class c implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final v0 f44025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y f44026b;

        public c(y this$0) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f44026b = this$0;
            this.f44025a = new v0();
        }

        @Override // okio.t0
        public long F1(@yt.k okio.j sink, long j10) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!kotlin.jvm.internal.f0.g(this.f44026b.f44022h, this)) {
                throw new IllegalStateException("closed".toString());
            }
            v0 v0VarU = this.f44026b.f44015a.U();
            v0 v0Var = this.f44025a;
            y yVar = this.f44026b;
            long j11 = v0VarU.j();
            long jA = v0.f44219d.a(v0Var.j(), v0VarU.j());
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            v0VarU.i(jA, timeUnit);
            if (!v0VarU.f()) {
                if (v0Var.f()) {
                    v0VarU.e(v0Var.d());
                }
                try {
                    long jK = yVar.k(j10);
                    long jF1 = jK == 0 ? -1L : yVar.f44015a.F1(sink, jK);
                    v0VarU.i(j11, timeUnit);
                    if (v0Var.f()) {
                        v0VarU.a();
                    }
                    return jF1;
                } catch (Throwable th2) {
                    v0VarU.i(j11, TimeUnit.NANOSECONDS);
                    if (v0Var.f()) {
                        v0VarU.a();
                    }
                    throw th2;
                }
            }
            long jD = v0VarU.d();
            if (v0Var.f()) {
                v0VarU.e(Math.min(v0VarU.d(), v0Var.d()));
            }
            try {
                long jK2 = yVar.k(j10);
                long jF12 = jK2 == 0 ? -1L : yVar.f44015a.F1(sink, jK2);
                v0VarU.i(j11, timeUnit);
                if (v0Var.f()) {
                    v0VarU.e(jD);
                }
                return jF12;
            } catch (Throwable th3) {
                v0VarU.i(j11, TimeUnit.NANOSECONDS);
                if (v0Var.f()) {
                    v0VarU.e(jD);
                }
                throw th3;
            }
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return this.f44025a;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (kotlin.jvm.internal.f0.g(this.f44026b.f44022h, this)) {
                this.f44026b.f44022h = null;
            }
        }
    }

    static {
        i0.a aVar = i0.f44070d;
        ByteString.a aVar2 = ByteString.f44029c;
        f44014j = aVar.d(aVar2.l("\r\n"), aVar2.l("--"), aVar2.l(com.blankj.utilcode.util.i0.f11861z), aVar2.l("\t"));
    }

    public y(@yt.k okio.l source, @yt.k String boundary) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(boundary, "boundary");
        this.f44015a = source;
        this.f44016b = boundary;
        this.f44017c = new okio.j().H0("--").H0(boundary).Z0();
        this.f44018d = new okio.j().H0("\r\n--").H0(boundary).Z0();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f44020f) {
            return;
        }
        this.f44020f = true;
        this.f44022h = null;
        this.f44015a.close();
    }

    @hk.h(name = "boundary")
    @yt.k
    public final String i() {
        return this.f44016b;
    }

    public final long k(long j10) throws IOException {
        this.f44015a.U1(this.f44018d.x0());
        long jV = this.f44015a.g().V(this.f44018d);
        return jV == -1 ? Math.min(j10, (this.f44015a.g().m2() - ((long) this.f44018d.x0())) + 1) : Math.min(j10, jV);
    }

    @yt.l
    public final b l() throws IOException {
        if (!(!this.f44020f)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.f44021g) {
            return null;
        }
        if (this.f44019e == 0 && this.f44015a.N0(0L, this.f44017c)) {
            this.f44015a.skip(this.f44017c.x0());
        } else {
            while (true) {
                long jK = k(8192L);
                if (jK == 0) {
                    break;
                }
                this.f44015a.skip(jK);
            }
            this.f44015a.skip(this.f44018d.x0());
        }
        boolean z10 = false;
        while (true) {
            int iG2 = this.f44015a.g2(f44014j);
            if (iG2 == -1) {
                throw new ProtocolException("unexpected characters after boundary");
            }
            if (iG2 == 0) {
                this.f44019e++;
                t tVarB = new wl.a(this.f44015a).b();
                c cVar = new c(this);
                this.f44022h = cVar;
                return new b(tVarB, okio.f0.e(cVar));
            }
            if (iG2 == 1) {
                if (z10) {
                    throw new ProtocolException("unexpected characters after boundary");
                }
                if (this.f44019e == 0) {
                    throw new ProtocolException("expected at least 1 part");
                }
                this.f44021g = true;
                return null;
            }
            if (iG2 == 2 || iG2 == 3) {
                z10 = true;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public y(@yt.k e0 response) throws IOException {
        kotlin.jvm.internal.f0.p(response, "response");
        okio.l lVarSource = response.source();
        w wVarContentType = response.contentType();
        String strI = wVarContentType == null ? null : wVarContentType.i("boundary");
        if (strI != null) {
            this(lVarSource, strI);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }
}
