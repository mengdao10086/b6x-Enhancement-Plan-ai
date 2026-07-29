package okhttp3.internal.connection;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import dm.e;
import f0.v;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.r;
import okio.r0;
import okio.t;
import okio.t0;
import okio.u;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002#\u001bB'\u0012\u0006\u0010+\u001a\u00020'\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00105\u001a\u000201\u0012\u0006\u0010C\u001a\u00020B¢\u0006\u0004\bD\u0010EJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J9\u0010#\u001a\u00028\u0000\"\n\b\u0000\u0010\u001e*\u0004\u0018\u00010\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0004J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u001dH\u0002R\u001a\u0010+\u001a\u00020'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b#\u0010(\u001a\u0004\b)\u0010*R\u001a\u00100\u001a\u00020,8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010/R\u001a\u00105\u001a\u0002018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u00104R$\u0010:\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00068\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u000b\u00107\u001a\u0004\b8\u00109R\u001a\u0010?\u001a\u00020;8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b@\u00109¨\u0006F"}, d2 = {"Lokhttp3/internal/connection/c;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lkotlin/z1;", "w", "", "duplex", "Lokio/r0;", "c", "f", "e", an.aB, "expectContinue", "Lokhttp3/d0$a;", "q", "Lokhttp3/d0;", "response", SsManifestParser.e.J, "Lokhttp3/e0;", "p", "Lokhttp3/t;", "u", "Ldm/e$d;", k.f40564b, "v", "n", "b", "d", "Ljava/io/IOException;", i1.a.S4, "", "bytesRead", "responseDone", "requestDone", "a", "(JZZLjava/io/IOException;)Ljava/io/IOException;", "o", "t", "Lokhttp3/internal/connection/e;", "Lokhttp3/internal/connection/e;", "g", "()Lokhttp3/internal/connection/e;", v.E0, "Lokhttp3/r;", "Lokhttp3/r;", "i", "()Lokhttp3/r;", "eventListener", "Lokhttp3/internal/connection/d;", "Lokhttp3/internal/connection/d;", j.f55230b, "()Lokhttp3/internal/connection/d;", "finder", "<set-?>", "Z", l.f16298a, "()Z", "isDuplex", "Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/connection/RealConnection;", "h", "()Lokhttp3/internal/connection/RealConnection;", xl.e.f55522j, "k", "isCoalescedConnection", "Lvl/d;", "codec", "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/r;Lokhttp3/internal/connection/d;Lvl/d;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final e f43800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final r f43801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final d f43802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final vl.d f43803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f43804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final RealConnection f43805f;

    @d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J#\u0010\r\u001a\u00028\u0000\"\n\b\u0000\u0010\u000b*\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u001c"}, d2 = {"Lokhttp3/internal/connection/c$a;", "Lokio/t;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "Ljava/io/IOException;", i1.a.S4, "e", "d", "(Ljava/io/IOException;)Ljava/io/IOException;", "b", "J", "contentLength", "", "c", "Z", "completed", "bytesReceived", "closed", "Lokio/r0;", "delegate", "<init>", "(Lokhttp3/internal/connection/c;Lokio/r0;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f43807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f43808d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f43809e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c f43810f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@yt.k c this$0, r0 delegate, long j10) {
            super(delegate);
            f0.p(this$0, "this$0");
            f0.p(delegate, "delegate");
            this.f43810f = this$0;
            this.f43806b = j10;
        }

        @Override // okio.t, okio.r0
        public void V0(@yt.k okio.j source, long j10) throws IOException {
            f0.p(source, "source");
            if (!(!this.f43809e)) {
                throw new IllegalStateException("closed".toString());
            }
            long j11 = this.f43806b;
            if (j11 == -1 || this.f43808d + j10 <= j11) {
                try {
                    super.V0(source, j10);
                    this.f43808d += j10;
                    return;
                } catch (IOException e10) {
                    throw d(e10);
                }
            }
            throw new ProtocolException("expected " + this.f43806b + " bytes but received " + (this.f43808d + j10));
        }

        @Override // okio.t, okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f43809e) {
                return;
            }
            this.f43809e = true;
            long j10 = this.f43806b;
            if (j10 != -1 && this.f43808d != j10) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                d(null);
            } catch (IOException e10) {
                throw d(e10);
            }
        }

        public final <E extends IOException> E d(E e10) {
            if (this.f43807c) {
                return e10;
            }
            this.f43807c = true;
            return (E) this.f43810f.a(this.f43808d, false, true, e10);
        }

        @Override // okio.t, okio.r0, java.io.Flushable
        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e10) {
                throw d(e10);
            }
        }
    }

    @d0(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J!\u0010\f\u001a\u00028\u0000\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/connection/c$b;", "Lokio/u;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "Ljava/io/IOException;", i1.a.S4, "e", "d", "(Ljava/io/IOException;)Ljava/io/IOException;", "b", "J", "contentLength", "c", "bytesReceived", "", "Z", "invokeStartEvent", "completed", "f", "closed", "Lokio/t0;", "delegate", "<init>", "(Lokhttp3/internal/connection/c;Lokio/t0;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class b extends u {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f43812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f43813d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f43814e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f43815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f43816g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.k c this$0, t0 delegate, long j10) {
            super(delegate);
            f0.p(this$0, "this$0");
            f0.p(delegate, "delegate");
            this.f43816g = this$0;
            this.f43811b = j10;
            this.f43813d = true;
            if (j10 == 0) {
                d(null);
            }
        }

        @Override // okio.u, okio.t0
        public long F1(@yt.k okio.j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            if (!(!this.f43815f)) {
                throw new IllegalStateException("closed".toString());
            }
            try {
                long jF1 = c().F1(sink, j10);
                if (this.f43813d) {
                    this.f43813d = false;
                    this.f43816g.i().responseBodyStart(this.f43816g.g());
                }
                if (jF1 == -1) {
                    d(null);
                    return -1L;
                }
                long j11 = this.f43812c + jF1;
                long j12 = this.f43811b;
                if (j12 != -1 && j11 > j12) {
                    throw new ProtocolException("expected " + this.f43811b + " bytes but received " + j11);
                }
                this.f43812c = j11;
                if (j11 == j12) {
                    d(null);
                }
                return jF1;
            } catch (IOException e10) {
                throw d(e10);
            }
        }

        @Override // okio.u, okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f43815f) {
                return;
            }
            this.f43815f = true;
            try {
                super.close();
                d(null);
            } catch (IOException e10) {
                throw d(e10);
            }
        }

        public final <E extends IOException> E d(E e10) {
            if (this.f43814e) {
                return e10;
            }
            this.f43814e = true;
            if (e10 == null && this.f43813d) {
                this.f43813d = false;
                this.f43816g.i().responseBodyStart(this.f43816g.g());
            }
            return (E) this.f43816g.a(this.f43812c, true, false, e10);
        }
    }

    public c(@yt.k e call, @yt.k r eventListener, @yt.k d finder, @yt.k vl.d codec) {
        f0.p(call, "call");
        f0.p(eventListener, "eventListener");
        f0.p(finder, "finder");
        f0.p(codec, "codec");
        this.f43800a = call;
        this.f43801b = eventListener;
        this.f43802c = finder;
        this.f43803d = codec;
        this.f43805f = codec.e();
    }

    public final <E extends IOException> E a(long j10, boolean z10, boolean z11, E e10) {
        if (e10 != null) {
            t(e10);
        }
        if (z11) {
            if (e10 != null) {
                this.f43801b.requestFailed(this.f43800a, e10);
            } else {
                this.f43801b.requestBodyEnd(this.f43800a, j10);
            }
        }
        if (z10) {
            if (e10 != null) {
                this.f43801b.responseFailed(this.f43800a, e10);
            } else {
                this.f43801b.responseBodyEnd(this.f43800a, j10);
            }
        }
        return (E) this.f43800a.s(this, z11, z10, e10);
    }

    public final void b() {
        this.f43803d.cancel();
    }

    @yt.k
    public final r0 c(@yt.k b0 request, boolean z10) throws IOException {
        f0.p(request, "request");
        this.f43804e = z10;
        c0 c0VarF = request.f();
        f0.m(c0VarF);
        long jA = c0VarF.a();
        this.f43801b.requestBodyStart(this.f43800a);
        return new a(this, this.f43803d.i(request, jA), jA);
    }

    public final void d() {
        this.f43803d.cancel();
        this.f43800a.s(this, true, true, null);
    }

    public final void e() throws IOException {
        try {
            this.f43803d.a();
        } catch (IOException e10) {
            this.f43801b.requestFailed(this.f43800a, e10);
            t(e10);
            throw e10;
        }
    }

    public final void f() throws IOException {
        try {
            this.f43803d.f();
        } catch (IOException e10) {
            this.f43801b.requestFailed(this.f43800a, e10);
            t(e10);
            throw e10;
        }
    }

    @yt.k
    public final e g() {
        return this.f43800a;
    }

    @yt.k
    public final RealConnection h() {
        return this.f43805f;
    }

    @yt.k
    public final r i() {
        return this.f43801b;
    }

    @yt.k
    public final d j() {
        return this.f43802c;
    }

    public final boolean k() {
        return !f0.g(this.f43802c.d().w().F(), this.f43805f.b().d().w().F());
    }

    public final boolean l() {
        return this.f43804e;
    }

    @yt.k
    public final e.d m() throws SocketException {
        this.f43800a.A();
        return this.f43803d.e().C(this);
    }

    public final void n() {
        this.f43803d.e().E();
    }

    public final void o() {
        this.f43800a.s(this, true, false, null);
    }

    @yt.k
    public final e0 p(@yt.k okhttp3.d0 response) throws IOException {
        f0.p(response, "response");
        try {
            String strM0 = okhttp3.d0.M0(response, "Content-Type", null, 2, null);
            long jG = this.f43803d.g(response);
            return new vl.h(strM0, jG, okio.f0.e(new b(this, this.f43803d.c(response), jG)));
        } catch (IOException e10) {
            this.f43801b.responseFailed(this.f43800a, e10);
            t(e10);
            throw e10;
        }
    }

    @yt.l
    public final d0.a q(boolean z10) throws IOException {
        try {
            d0.a aVarD = this.f43803d.d(z10);
            if (aVarD != null) {
                aVarD.x(this);
            }
            return aVarD;
        } catch (IOException e10) {
            this.f43801b.responseFailed(this.f43800a, e10);
            t(e10);
            throw e10;
        }
    }

    public final void r(@yt.k okhttp3.d0 response) {
        f0.p(response, "response");
        this.f43801b.responseHeadersEnd(this.f43800a, response);
    }

    public final void s() {
        this.f43801b.responseHeadersStart(this.f43800a);
    }

    public final void t(IOException iOException) {
        this.f43802c.h(iOException);
        this.f43803d.e().L(this.f43800a, iOException);
    }

    @yt.k
    public final okhttp3.t u() throws IOException {
        return this.f43803d.h();
    }

    public final void v() {
        a(-1L, true, true, null);
    }

    public final void w(@yt.k b0 request) throws IOException {
        f0.p(request, "request");
        try {
            this.f43801b.requestHeadersStart(this.f43800a);
            this.f43803d.b(request);
            this.f43801b.requestHeadersEnd(this.f43800a, request);
        } catch (IOException e10) {
            this.f43801b.requestFailed(this.f43800a, e10);
            t(e10);
            throw e10;
        }
    }
}
