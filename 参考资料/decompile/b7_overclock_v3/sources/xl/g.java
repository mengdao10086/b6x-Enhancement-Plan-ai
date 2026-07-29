package xl;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.t;
import okio.r0;
import okio.t0;
import okio.v0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0004+',\u001cB3\b\u0000\u0012\u0006\u0010.\u001a\u00020 \u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010\b¢\u0006\u0004\bd\u0010eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ$\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0016\u001a\u00020\u0014J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\"\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 J\u0016\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010'\u001a\u00020\u0010H\u0000¢\u0006\u0004\b'\u0010(J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)J\u000f\u0010,\u001a\u00020\u0010H\u0000¢\u0006\u0004\b,\u0010(J\u000f\u0010-\u001a\u00020\u0010H\u0000¢\u0006\u0004\b-\u0010(R\u0017\u0010.\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b.\u0010\n\u001a\u0004\b/\u00100R\u0017\u00102\u001a\u0002018\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R*\u00107\u001a\u00020)2\u0006\u00106\u001a\u00020)8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010-\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010<\u001a\u00020)2\u0006\u00106\u001a\u00020)8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010-\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R*\u0010?\u001a\u00020)2\u0006\u00106\u001a\u00020)8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010-\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R*\u0010B\u001a\u00020)2\u0006\u00106\u001a\u00020)8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010-\u001a\u0004\bC\u00109\"\u0004\bD\u0010;R\u001e\u0010\u001f\u001a\u00060ER\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010F\u001a\u0004\bG\u0010HR\u001e\u0010J\u001a\u00060IR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001e\u0010O\u001a\u00060NR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001e\u0010S\u001a\u00060NR\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\bS\u0010P\u001a\u0004\bT\u0010RR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028@@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0011\u0010a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0011\u0010c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bb\u0010`¨\u0006f"}, d2 = {"Lxl/g;", "", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Ljava/io/IOException;", "errorException", "", "e", "Lokhttp3/t;", "H", "I", "", "Lxl/a;", "responseHeaders", "outFinished", "flushHeaders", "Lkotlin/z1;", "K", "trailers", "g", "Lokio/v0;", "x", "L", "Lokio/t0;", "q", "Lokio/r0;", "o", "rstStatusCode", "d", "f", "Lokio/l;", "source", "", fd.c.f28042f, "y", IOptionConstant.headers, "inFinished", an.aD, i1.a.W4, "b", "()V", "", "delta", "a", "c", "J", "id", "k", "()I", "Lxl/d;", e.f55522j, "Lxl/d;", "h", "()Lxl/d;", "<set-?>", "readBytesTotal", m0.k.f40564b, "()J", i1.a.S4, "(J)V", "readBytesAcknowledged", l.f16298a, "D", "writeBytesTotal", "t", "G", "writeBytesMaximum", an.aB, "F", "Lxl/g$c;", "Lxl/g$c;", SsManifestParser.e.J, "()Lxl/g$c;", "Lxl/g$b;", "sink", "Lxl/g$b;", "p", "()Lxl/g$b;", "Lxl/g$d;", "readTimeout", "Lxl/g$d;", "n", "()Lxl/g$d;", "writeTimeout", "u", "Lokhttp3/internal/http2/ErrorCode;", "i", "()Lokhttp3/internal/http2/ErrorCode;", "B", "(Lokhttp3/internal/http2/ErrorCode;)V", "Ljava/io/IOException;", xf.j.f55230b, "()Ljava/io/IOException;", "C", "(Ljava/io/IOException;)V", "w", "()Z", "isOpen", "v", "isLocallyInitiated", "<init>", "(ILxl/d;ZZLokhttp3/t;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class g {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @yt.k
    public static final a f55550o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f55551p = 16384;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final xl.d f55553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f55554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f55555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f55556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f55557f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final ArrayDeque<t> f55558g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f55559h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public final c f55560i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.k
    public final b f55561j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @yt.k
    public final d f55562k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.k
    public final d f55563l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.l
    public ErrorCode f55564m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @yt.l
    public IOException f55565n;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lxl/g$a;", "", "", "EMIT_BUFFER_SIZE", "J", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0013\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017¨\u0006+"}, d2 = {"Lxl/g$c;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/l;", "source", "Lkotlin/z1;", "i", "(Lokio/l;J)V", "Lokio/v0;", "U", "close", "read", "n", "", "finished", "Z", "c", "()Z", l.f16298a, "(Z)V", "receiveBuffer", "Lokio/j;", "f", "()Lokio/j;", "readBuffer", "d", "Lokhttp3/t;", "trailers", "Lokhttp3/t;", "h", "()Lokhttp3/t;", m0.k.f40564b, "(Lokhttp3/t;)V", "closed", "a", "k", "maxByteCount", "<init>", "(Lxl/g;JZ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class c implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f55571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f55572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final okio.j f55573c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public final okio.j f55574d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.l
        public t f55575e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f55576f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ g f55577g;

        public c(g this$0, long j10, boolean z10) {
            f0.p(this$0, "this$0");
            this.f55577g = this$0;
            this.f55571a = j10;
            this.f55572b = z10;
            this.f55573c = new okio.j();
            this.f55574d = new okio.j();
        }

        @Override // okio.t0
        public long F1(@yt.k okio.j sink, long j10) throws IOException {
            long jF1;
            boolean z10;
            f0.p(sink, "sink");
            long j11 = 0;
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            while (true) {
                IOException iOExceptionJ = null;
                g gVar = this.f55577g;
                synchronized (gVar) {
                    gVar.n().w();
                    try {
                        if (gVar.i() != null && (iOExceptionJ = gVar.j()) == null) {
                            ErrorCode errorCodeI = gVar.i();
                            f0.m(errorCodeI);
                            iOExceptionJ = new StreamResetException(errorCodeI);
                        }
                        if (a()) {
                            throw new IOException("stream closed");
                        }
                        if (d().m2() > j11) {
                            jF1 = d().F1(sink, Math.min(j10, d().m2()));
                            gVar.E(gVar.m() + jF1);
                            long jM = gVar.m() - gVar.l();
                            if (iOExceptionJ == null && jM >= gVar.h().k1().e() / 2) {
                                gVar.h().J2(gVar.k(), jM);
                                gVar.D(gVar.m());
                            }
                        } else if (c() || iOExceptionJ != null) {
                            jF1 = -1;
                        } else {
                            gVar.J();
                            jF1 = -1;
                            z10 = true;
                            gVar.n().E();
                            z1 z1Var = z1.f38230a;
                        }
                        z10 = false;
                        gVar.n().E();
                        z1 z1Var2 = z1.f38230a;
                    } catch (Throwable th2) {
                        gVar.n().E();
                        throw th2;
                    }
                }
                if (!z10) {
                    if (jF1 != -1) {
                        n(jF1);
                        return jF1;
                    }
                    if (iOExceptionJ == null) {
                        return -1L;
                    }
                    throw iOExceptionJ;
                }
                j11 = 0;
            }
        }

        @Override // okio.t0
        @yt.k
        public v0 U() {
            return this.f55577g.n();
        }

        public final boolean a() {
            return this.f55576f;
        }

        public final boolean c() {
            return this.f55572b;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long jM2;
            g gVar = this.f55577g;
            synchronized (gVar) {
                k(true);
                jM2 = d().m2();
                d().d();
                gVar.notifyAll();
                z1 z1Var = z1.f38230a;
            }
            if (jM2 > 0) {
                n(jM2);
            }
            this.f55577g.b();
        }

        @yt.k
        public final okio.j d() {
            return this.f55574d;
        }

        @yt.k
        public final okio.j f() {
            return this.f55573c;
        }

        @yt.l
        public final t h() {
            return this.f55575e;
        }

        public final void i(@yt.k okio.l source, long j10) throws IOException {
            boolean zC;
            boolean z10;
            boolean z11;
            long jM2;
            f0.p(source, "source");
            g gVar = this.f55577g;
            if (rl.f.f48803h && Thread.holdsLock(gVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + gVar);
            }
            while (j10 > 0) {
                synchronized (this.f55577g) {
                    zC = c();
                    z10 = true;
                    z11 = d().m2() + j10 > this.f55571a;
                    z1 z1Var = z1.f38230a;
                }
                if (z11) {
                    source.skip(j10);
                    this.f55577g.f(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (zC) {
                    source.skip(j10);
                    return;
                }
                long jF1 = source.F1(this.f55573c, j10);
                if (jF1 == -1) {
                    throw new EOFException();
                }
                j10 -= jF1;
                g gVar2 = this.f55577g;
                synchronized (gVar2) {
                    if (a()) {
                        jM2 = f().m2();
                        f().d();
                    } else {
                        if (d().m2() != 0) {
                            z10 = false;
                        }
                        d().X0(f());
                        if (z10) {
                            gVar2.notifyAll();
                        }
                        jM2 = 0;
                    }
                }
                if (jM2 > 0) {
                    n(jM2);
                }
            }
        }

        public final void k(boolean z10) {
            this.f55576f = z10;
        }

        public final void l(boolean z10) {
            this.f55572b = z10;
        }

        public final void m(@yt.l t tVar) {
            this.f55575e = tVar;
        }

        public final void n(long j10) {
            g gVar = this.f55577g;
            if (!rl.f.f48803h || !Thread.holdsLock(gVar)) {
                this.f55577g.h().B2(j10);
                return;
            }
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + gVar);
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lxl/g$d;", "Lokio/h;", "Lkotlin/z1;", "C", "Ljava/io/IOException;", "cause", "y", i1.a.S4, "<init>", "(Lxl/g;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class d extends okio.h {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ g f55578n;

        public d(g this$0) {
            f0.p(this$0, "this$0");
            this.f55578n = this$0;
        }

        @Override // okio.h
        public void C() {
            this.f55578n.f(ErrorCode.CANCEL);
            this.f55578n.h().s2();
        }

        public final void E() throws IOException {
            if (x()) {
                throw y(null);
            }
        }

        @Override // okio.h
        @yt.k
        public IOException y(@yt.l IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }
    }

    public g(int i10, @yt.k xl.d connection, boolean z10, boolean z11, @yt.l t tVar) {
        f0.p(connection, "connection");
        this.f55552a = i10;
        this.f55553b = connection;
        this.f55557f = connection.m1().e();
        ArrayDeque<t> arrayDeque = new ArrayDeque<>();
        this.f55558g = arrayDeque;
        this.f55560i = new c(this, connection.k1().e(), z11);
        this.f55561j = new b(this, z10);
        this.f55562k = new d(this);
        this.f55563l = new d(this);
        if (tVar == null) {
            if (!v()) {
                throw new IllegalStateException("remotely-initiated streams should have headers".toString());
            }
        } else {
            if (!(!v())) {
                throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
            }
            arrayDeque.add(tVar);
        }
    }

    public final synchronized void A(@yt.k ErrorCode errorCode) {
        f0.p(errorCode, "errorCode");
        if (this.f55564m == null) {
            this.f55564m = errorCode;
            notifyAll();
        }
    }

    public final void B(@yt.l ErrorCode errorCode) {
        this.f55564m = errorCode;
    }

    public final void C(@yt.l IOException iOException) {
        this.f55565n = iOException;
    }

    public final void D(long j10) {
        this.f55555d = j10;
    }

    public final void E(long j10) {
        this.f55554c = j10;
    }

    public final void F(long j10) {
        this.f55557f = j10;
    }

    public final void G(long j10) {
        this.f55556e = j10;
    }

    @yt.k
    public final synchronized t H() throws IOException {
        t tVarRemoveFirst;
        this.f55562k.w();
        while (this.f55558g.isEmpty() && this.f55564m == null) {
            try {
                J();
            } catch (Throwable th2) {
                this.f55562k.E();
                throw th2;
            }
        }
        this.f55562k.E();
        if (!(!this.f55558g.isEmpty())) {
            IOException iOException = this.f55565n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f55564m;
            f0.m(errorCode);
            throw new StreamResetException(errorCode);
        }
        tVarRemoveFirst = this.f55558g.removeFirst();
        f0.o(tVarRemoveFirst, "headersQueue.removeFirst()");
        return tVarRemoveFirst;
    }

    @yt.k
    public final synchronized t I() throws IOException {
        t tVarH;
        if (!this.f55560i.c() || !this.f55560i.f().d0() || !this.f55560i.d().d0()) {
            if (this.f55564m == null) {
                throw new IllegalStateException("too early; can't read the trailers yet");
            }
            IOException iOException = this.f55565n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f55564m;
            f0.m(errorCode);
            throw new StreamResetException(errorCode);
        }
        tVarH = this.f55560i.h();
        if (tVarH == null) {
            tVarH = rl.f.f48797b;
        }
        return tVarH;
    }

    public final void J() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void K(@yt.k List<xl.a> responseHeaders, boolean z10, boolean z11) throws IOException {
        boolean z12;
        f0.p(responseHeaders, "responseHeaders");
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            this.f55559h = true;
            if (z10) {
                p().i(true);
            }
            z1 z1Var = z1.f38230a;
        }
        if (!z11) {
            synchronized (this.f55553b) {
                z12 = h().Y1() >= h().V1();
            }
            z11 = z12;
        }
        this.f55553b.D2(this.f55552a, z10, responseHeaders);
        if (z11) {
            this.f55553b.flush();
        }
    }

    @yt.k
    public final v0 L() {
        return this.f55563l;
    }

    public final void a(long j10) {
        this.f55557f += j10;
        if (j10 > 0) {
            notifyAll();
        }
    }

    public final void b() throws IOException {
        boolean z10;
        boolean zW;
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z10 = !r().c() && r().a() && (p().d() || p().c());
            zW = w();
            z1 z1Var = z1.f38230a;
        }
        if (z10) {
            d(ErrorCode.CANCEL, null);
        } else {
            if (zW) {
                return;
            }
            this.f55553b.r2(this.f55552a);
        }
    }

    public final void c() throws IOException {
        if (this.f55561j.c()) {
            throw new IOException("stream closed");
        }
        if (this.f55561j.d()) {
            throw new IOException("stream finished");
        }
        if (this.f55564m != null) {
            IOException iOException = this.f55565n;
            if (iOException != null) {
                throw iOException;
            }
            ErrorCode errorCode = this.f55564m;
            f0.m(errorCode);
            throw new StreamResetException(errorCode);
        }
    }

    public final void d(@yt.k ErrorCode rstStatusCode, @yt.l IOException iOException) throws IOException {
        f0.p(rstStatusCode, "rstStatusCode");
        if (e(rstStatusCode, iOException)) {
            this.f55553b.H2(this.f55552a, rstStatusCode);
        }
    }

    public final boolean e(ErrorCode errorCode, IOException iOException) {
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (i() != null) {
                return false;
            }
            if (r().c() && p().d()) {
                return false;
            }
            B(errorCode);
            C(iOException);
            notifyAll();
            z1 z1Var = z1.f38230a;
            this.f55553b.r2(this.f55552a);
            return true;
        }
    }

    public final void f(@yt.k ErrorCode errorCode) {
        f0.p(errorCode, "errorCode");
        if (e(errorCode, null)) {
            this.f55553b.I2(this.f55552a, errorCode);
        }
    }

    public final void g(@yt.k t trailers) {
        f0.p(trailers, "trailers");
        synchronized (this) {
            boolean z10 = true;
            if (!(!p().d())) {
                throw new IllegalStateException("already finished".toString());
            }
            if (trailers.size() == 0) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("trailers.size() == 0".toString());
            }
            p().k(trailers);
            z1 z1Var = z1.f38230a;
        }
    }

    @yt.k
    public final xl.d h() {
        return this.f55553b;
    }

    @yt.l
    public final synchronized ErrorCode i() {
        return this.f55564m;
    }

    @yt.l
    public final IOException j() {
        return this.f55565n;
    }

    public final int k() {
        return this.f55552a;
    }

    public final long l() {
        return this.f55555d;
    }

    public final long m() {
        return this.f55554c;
    }

    @yt.k
    public final d n() {
        return this.f55562k;
    }

    @yt.k
    public final r0 o() {
        synchronized (this) {
            if (!(this.f55559h || v())) {
                throw new IllegalStateException("reply before requesting the sink".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        return this.f55561j;
    }

    @yt.k
    public final b p() {
        return this.f55561j;
    }

    @yt.k
    public final t0 q() {
        return this.f55560i;
    }

    @yt.k
    public final c r() {
        return this.f55560i;
    }

    public final long s() {
        return this.f55557f;
    }

    public final long t() {
        return this.f55556e;
    }

    @yt.k
    public final d u() {
        return this.f55563l;
    }

    public final boolean v() {
        return this.f55553b.G0() == ((this.f55552a & 1) == 1);
    }

    public final synchronized boolean w() {
        if (this.f55564m != null) {
            return false;
        }
        if ((this.f55560i.c() || this.f55560i.a()) && (this.f55561j.d() || this.f55561j.c())) {
            if (this.f55559h) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public final v0 x() {
        return this.f55562k;
    }

    public final void y(@yt.k okio.l source, int i10) throws IOException {
        f0.p(source, "source");
        if (!rl.f.f48803h || !Thread.holdsLock(this)) {
            this.f55560i.i(source, i10);
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
    }

    public final void z(@yt.k t headers, boolean z10) {
        boolean zW;
        f0.p(headers, "headers");
        if (rl.f.f48803h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (this.f55559h && z10) {
                r().m(headers);
            } else {
                this.f55559h = true;
                this.f55558g.add(headers);
            }
            if (z10) {
                r().l(true);
            }
            zW = w();
            notifyAll();
            z1 z1Var = z1.f38230a;
        }
        if (zW) {
            return;
        }
        this.f55553b.r2(this.f55552a);
    }

    @d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002R\"\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0010\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014¨\u0006!"}, d2 = {"Lxl/g$b;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "Lokio/v0;", "U", "close", "", "outFinishedOnLastFrame", "a", "finished", "Z", "d", "()Z", "i", "(Z)V", "Lokhttp3/t;", "trailers", "Lokhttp3/t;", "f", "()Lokhttp3/t;", "k", "(Lokhttp3/t;)V", "closed", "c", "h", "<init>", "(Lxl/g;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class b implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f55566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final okio.j f55567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public t f55568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f55569d;

        public b(g this$0, boolean z10) {
            f0.p(this$0, "this$0");
            g.this = this$0;
            this.f55566a = z10;
            this.f55567b = new okio.j();
        }

        @Override // okio.r0
        @yt.k
        public v0 U() {
            return g.this.u();
        }

        @Override // okio.r0
        public void V0(@yt.k okio.j source, long j10) throws IOException {
            f0.p(source, "source");
            g gVar = g.this;
            if (!rl.f.f48803h || !Thread.holdsLock(gVar)) {
                this.f55567b.V0(source, j10);
                while (this.f55567b.m2() >= 16384) {
                    a(false);
                }
            } else {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + gVar);
            }
        }

        public final void a(boolean z10) throws IOException {
            long jMin;
            boolean z11;
            g gVar = g.this;
            synchronized (gVar) {
                gVar.u().w();
                while (gVar.t() >= gVar.s() && !d() && !c() && gVar.i() == null) {
                    try {
                        gVar.J();
                    } finally {
                        gVar.u().E();
                    }
                }
                gVar.u().E();
                gVar.c();
                jMin = Math.min(gVar.s() - gVar.t(), this.f55567b.m2());
                gVar.G(gVar.t() + jMin);
                z11 = z10 && jMin == this.f55567b.m2();
                z1 z1Var = z1.f38230a;
            }
            g.this.u().w();
            try {
                g.this.h().C2(g.this.k(), z11, this.f55567b, jMin);
            } finally {
                gVar = g.this;
            }
        }

        public final boolean c() {
            return this.f55569d;
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            g gVar = g.this;
            if (rl.f.f48803h && Thread.holdsLock(gVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + gVar);
            }
            g gVar2 = g.this;
            synchronized (gVar2) {
                if (c()) {
                    return;
                }
                boolean z10 = gVar2.i() == null;
                z1 z1Var = z1.f38230a;
                if (!g.this.p().f55566a) {
                    boolean z11 = this.f55567b.m2() > 0;
                    if (this.f55568c != null) {
                        while (this.f55567b.m2() > 0) {
                            a(false);
                        }
                        xl.d dVarH = g.this.h();
                        int iK = g.this.k();
                        t tVar = this.f55568c;
                        f0.m(tVar);
                        dVarH.D2(iK, z10, rl.f.b0(tVar));
                    } else if (z11) {
                        while (this.f55567b.m2() > 0) {
                            a(true);
                        }
                    } else if (z10) {
                        g.this.h().C2(g.this.k(), true, null, 0L);
                    }
                }
                synchronized (g.this) {
                    h(true);
                    z1 z1Var2 = z1.f38230a;
                }
                g.this.h().flush();
                g.this.b();
            }
        }

        public final boolean d() {
            return this.f55566a;
        }

        @yt.l
        public final t f() {
            return this.f55568c;
        }

        @Override // okio.r0, java.io.Flushable
        public void flush() throws IOException {
            g gVar = g.this;
            if (rl.f.f48803h && Thread.holdsLock(gVar)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + gVar);
            }
            g gVar2 = g.this;
            synchronized (gVar2) {
                gVar2.c();
                z1 z1Var = z1.f38230a;
            }
            while (this.f55567b.m2() > 0) {
                a(false);
                g.this.h().flush();
            }
        }

        public final void h(boolean z10) {
            this.f55569d = z10;
        }

        public final void i(boolean z10) {
            this.f55566a = z10;
        }

        public final void k(@yt.l t tVar) {
            this.f55568c = tVar;
        }

        public /* synthetic */ b(boolean z10, int i10, u uVar) {
            this(g.this, (i10 & 1) != 0 ? false : z10);
        }
    }
}
