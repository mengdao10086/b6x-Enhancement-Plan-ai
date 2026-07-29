package wl;

import com.arialyy.aria.core.inf.IOptionConstant;
import com.google.common.net.HttpHeaders;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.y;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.n;
import okhttp3.t;
import okhttp3.u;
import okio.j;
import okio.r0;
import okio.t0;
import okio.v;
import okio.v0;
import vl.i;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0007\u001e\u0016\u001a&0\u001d\u0019B)\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u0010:\u001a\u000209¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\u0016\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 J\u0012\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020#H\u0016J\u000e\u0010'\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0017R\u0018\u0010*\u001a\u00020#*\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020#*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001a\u0010.\u001a\u00020-8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0011\u00104\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b2\u00103¨\u0006="}, d2 = {"Lwl/b;", "Lvl/d;", "Lokio/r0;", "w", an.aD, "", fd.c.f28042f, "Lokio/t0;", "y", "Lokhttp3/u;", "url", "x", i1.a.W4, "Lokio/v;", "timeout", "Lkotlin/z1;", an.aB, "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "contentLength", "i", CommonNetImpl.CANCEL, "b", "Lokhttp3/d0;", "response", "g", "c", "Lokhttp3/t;", "h", "f", "a", IOptionConstant.headers, "", "requestLine", "C", "", "expectContinue", "Lokhttp3/d0$a;", "d", "B", "u", "(Lokhttp3/d0;)Z", "isChunked", "t", "(Lokhttp3/b0;)Z", "Lokhttp3/internal/connection/RealConnection;", xl.e.f55522j, "Lokhttp3/internal/connection/RealConnection;", "e", "()Lokhttp3/internal/connection/RealConnection;", "v", "()Z", "isClosed", "Lokhttp3/a0;", "client", "Lokio/l;", "source", "Lokio/k;", "sink", "<init>", "(Lokhttp3/a0;Lokhttp3/internal/connection/RealConnection;Lokio/l;Lokio/k;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b implements vl.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final d f54715j = new d(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f54716k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f54717l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f54718m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f54719n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f54720o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f54721p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f54722q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f54723r = 6;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final a0 f54724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final RealConnection f54725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final okio.l f54726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final okio.k f54727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f54728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final wl.a f54729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @l
    public t f54730i;

    @d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\tR\u001a\u0010\f\u001a\u00020\u000b8\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lwl/b$a;", "Lokio/t0;", "Lokio/v0;", "U", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "d", "Lokio/v;", "timeout", "Lokio/v;", "c", "()Lokio/v;", "", "closed", "Z", "a", "()Z", "f", "(Z)V", "<init>", "(Lwl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public abstract class a implements t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final v f54731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f54732b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f54733c;

        public a(b this$0) {
            f0.p(this$0, "this$0");
            this.f54733c = this$0;
            this.f54731a = new v(this$0.f54726e.U());
        }

        @Override // okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            try {
                return this.f54733c.f54726e.F1(sink, j10);
            } catch (IOException e10) {
                this.f54733c.e().E();
                d();
                throw e10;
            }
        }

        @Override // okio.t0
        @k
        public v0 U() {
            return this.f54731a;
        }

        public final boolean a() {
            return this.f54732b;
        }

        @k
        public final v c() {
            return this.f54731a;
        }

        public final void d() {
            if (this.f54733c.f54728g == 6) {
                return;
            }
            if (this.f54733c.f54728g != 5) {
                throw new IllegalStateException(f0.C("state: ", Integer.valueOf(this.f54733c.f54728g)));
            }
            this.f54733c.s(this.f54731a);
            this.f54733c.f54728g = 6;
        }

        public final void f(boolean z10) {
            this.f54732b = z10;
        }
    }

    /* JADX INFO: renamed from: wl.b$b, reason: collision with other inner class name */
    @d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lwl/b$b;", "Lokio/r0;", "Lokio/v0;", "U", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "<init>", "(Lwl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class C0640b implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final v f54734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f54735b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f54736c;

        public C0640b(b this$0) {
            f0.p(this$0, "this$0");
            this.f54736c = this$0;
            this.f54734a = new v(this$0.f54727f.U());
        }

        @Override // okio.r0
        @k
        public v0 U() {
            return this.f54734a;
        }

        @Override // okio.r0
        public void V0(@k j source, long j10) throws IOException {
            f0.p(source, "source");
            if (!(!this.f54735b)) {
                throw new IllegalStateException("closed".toString());
            }
            if (j10 == 0) {
                return;
            }
            this.f54736c.f54727f.Y0(j10);
            this.f54736c.f54727f.H0("\r\n");
            this.f54736c.f54727f.V0(source, j10);
            this.f54736c.f54727f.H0("\r\n");
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            if (this.f54735b) {
                return;
            }
            this.f54735b = true;
            this.f54736c.f54727f.H0("0\r\n\r\n");
            this.f54736c.s(this.f54734a);
            this.f54736c.f54728g = 3;
        }

        @Override // okio.r0, java.io.Flushable
        public synchronized void flush() {
            if (this.f54735b) {
                return;
            }
            this.f54736c.f54727f.flush();
        }
    }

    @d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0002¨\u0006\u000f"}, d2 = {"Lwl/b$c;", "Lwl/b$a;", "Lwl/b;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "h", "Lokhttp3/u;", "url", "<init>", "(Lwl/b;Lokhttp3/u;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class c extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @k
        public final u f54737d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f54738e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f54739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ b f54740g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@k b this$0, u url) {
            super(this$0);
            f0.p(this$0, "this$0");
            f0.p(url, "url");
            this.f54740g = this$0;
            this.f54737d = url;
            this.f54738e = -1L;
            this.f54739f = true;
        }

        @Override // wl.b.a, okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(true ^ a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (!this.f54739f) {
                return -1L;
            }
            long j11 = this.f54738e;
            if (j11 == 0 || j11 == -1) {
                h();
                if (!this.f54739f) {
                    return -1L;
                }
            }
            long jF1 = super.F1(sink, Math.min(j10, this.f54738e));
            if (jF1 != -1) {
                this.f54738e -= jF1;
                return jF1;
            }
            this.f54740g.e().E();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            d();
            throw protocolException;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f54739f && !rl.f.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.f54740g.e().E();
                d();
            }
            f(true);
        }

        public final void h() throws IOException {
            if (this.f54738e != -1) {
                this.f54740g.f54726e.n1();
            }
            try {
                this.f54738e = this.f54740g.f54726e.d2();
                String string = StringsKt__StringsKt.F5(this.f54740g.f54726e.n1()).toString();
                if (this.f54738e >= 0) {
                    if (!(string.length() > 0) || kotlin.text.u.v2(string, ";", false, 2, null)) {
                        if (this.f54738e == 0) {
                            this.f54739f = false;
                            b bVar = this.f54740g;
                            bVar.f54730i = bVar.f54729h.b();
                            a0 a0Var = this.f54740g.f54724c;
                            f0.m(a0Var);
                            n nVarP = a0Var.P();
                            u uVar = this.f54737d;
                            t tVar = this.f54740g.f54730i;
                            f0.m(tVar);
                            vl.e.g(nVarP, uVar, tVar);
                            d();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f54738e + string + y.f38188b);
            } catch (NumberFormatException e10) {
                throw new ProtocolException(e10.getMessage());
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0007¨\u0006\u0010"}, d2 = {"Lwl/b$d;", "", "", "NO_CHUNK_YET", "J", "", "STATE_CLOSED", "I", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class d {
        public d() {
        }

        public /* synthetic */ d(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"Lwl/b$e;", "Lwl/b$a;", "Lwl/b;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "bytesRemaining", "<init>", "(Lwl/b;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class e extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f54741d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f54742e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(b this$0, long j10) {
            super(this$0);
            f0.p(this$0, "this$0");
            this.f54742e = this$0;
            this.f54741d = j10;
            if (j10 == 0) {
                d();
            }
        }

        @Override // wl.b.a, okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(true ^ a())) {
                throw new IllegalStateException("closed".toString());
            }
            long j11 = this.f54741d;
            if (j11 == 0) {
                return -1L;
            }
            long jF1 = super.F1(sink, Math.min(j11, j10));
            if (jF1 == -1) {
                this.f54742e.e().E();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                d();
                throw protocolException;
            }
            long j12 = this.f54741d - jF1;
            this.f54741d = j12;
            if (j12 == 0) {
                d();
            }
            return jF1;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (this.f54741d != 0 && !rl.f.w(this, 100, TimeUnit.MILLISECONDS)) {
                this.f54742e.e().E();
                d();
            }
            f(true);
        }
    }

    @d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lwl/b$f;", "Lokio/r0;", "Lokio/v0;", "U", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "<init>", "(Lwl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class f implements r0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public final v f54743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f54744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f54745c;

        public f(b this$0) {
            f0.p(this$0, "this$0");
            this.f54745c = this$0;
            this.f54743a = new v(this$0.f54727f.U());
        }

        @Override // okio.r0
        @k
        public v0 U() {
            return this.f54743a;
        }

        @Override // okio.r0
        public void V0(@k j source, long j10) throws IOException {
            f0.p(source, "source");
            if (!(!this.f54744b)) {
                throw new IllegalStateException("closed".toString());
            }
            rl.f.n(source.m2(), 0L, j10);
            this.f54745c.f54727f.V0(source, j10);
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f54744b) {
                return;
            }
            this.f54744b = true;
            this.f54745c.s(this.f54743a);
            this.f54745c.f54728g = 3;
        }

        @Override // okio.r0, java.io.Flushable
        public void flush() throws IOException {
            if (this.f54744b) {
                return;
            }
            this.f54745c.f54727f.flush();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Lwl/b$g;", "Lwl/b$a;", "Lwl/b;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "<init>", "(Lwl/b;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class g extends a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f54746d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f54747e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(b this$0) {
            super(this$0);
            f0.p(this$0, "this$0");
            this.f54747e = this$0;
        }

        @Override // wl.b.a, okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException(f0.C("byteCount < 0: ", Long.valueOf(j10)).toString());
            }
            if (!(!a())) {
                throw new IllegalStateException("closed".toString());
            }
            if (this.f54746d) {
                return -1L;
            }
            long jF1 = super.F1(sink, j10);
            if (jF1 != -1) {
                return jF1;
            }
            this.f54746d = true;
            d();
            return -1L;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (a()) {
                return;
            }
            if (!this.f54746d) {
                d();
            }
            f(true);
        }
    }

    public b(@l a0 a0Var, @k RealConnection connection, @k okio.l source, @k okio.k sink) {
        f0.p(connection, "connection");
        f0.p(source, "source");
        f0.p(sink, "sink");
        this.f54724c = a0Var;
        this.f54725d = connection;
        this.f54726e = source;
        this.f54727f = sink;
        this.f54729h = new wl.a(source);
    }

    public final t0 A() {
        int i10 = this.f54728g;
        if (!(i10 == 4)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54728g = 5;
        e().E();
        return new g(this);
    }

    public final void B(@k okhttp3.d0 response) {
        f0.p(response, "response");
        long jA = rl.f.A(response);
        if (jA == -1) {
            return;
        }
        t0 t0VarY = y(jA);
        rl.f.X(t0VarY, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        t0VarY.close();
    }

    public final void C(@k t headers, @k String requestLine) {
        f0.p(headers, "headers");
        f0.p(requestLine, "requestLine");
        int i10 = this.f54728g;
        if (!(i10 == 0)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54727f.H0(requestLine).H0("\r\n");
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f54727f.H0(headers.j(i11)).H0(": ").H0(headers.r(i11)).H0("\r\n");
        }
        this.f54727f.H0("\r\n");
        this.f54728g = 1;
    }

    @Override // vl.d
    public void a() {
        this.f54727f.flush();
    }

    @Override // vl.d
    public void b(@k b0 request) {
        f0.p(request, "request");
        i iVar = i.f53218a;
        Proxy.Type type = e().b().e().type();
        f0.o(type, "connection.route().proxy.type()");
        C(request.k(), iVar.a(request, type));
    }

    @Override // vl.d
    @k
    public t0 c(@k okhttp3.d0 response) {
        f0.p(response, "response");
        if (!vl.e.c(response)) {
            return y(0L);
        }
        if (u(response)) {
            return x(response.V1().q());
        }
        long jA = rl.f.A(response);
        return jA != -1 ? y(jA) : A();
    }

    @Override // vl.d
    public void cancel() {
        e().i();
    }

    @Override // vl.d
    @l
    public d0.a d(boolean z10) {
        int i10 = this.f54728g;
        boolean z11 = true;
        if (i10 != 1 && i10 != 3) {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        try {
            vl.k kVarB = vl.k.f53222d.b(this.f54729h.c());
            d0.a aVarW = new d0.a().B(kVarB.f53227a).g(kVarB.f53228b).y(kVarB.f53229c).w(this.f54729h.b());
            if (z10 && kVarB.f53228b == 100) {
                return null;
            }
            if (kVarB.f53228b == 100) {
                this.f54728g = 3;
                return aVarW;
            }
            this.f54728g = 4;
            return aVarW;
        } catch (EOFException e10) {
            throw new IOException(f0.C("unexpected end of stream on ", e().b().d().w().V()), e10);
        }
    }

    @Override // vl.d
    @k
    public RealConnection e() {
        return this.f54725d;
    }

    @Override // vl.d
    public void f() throws IOException {
        this.f54727f.flush();
    }

    @Override // vl.d
    public long g(@k okhttp3.d0 response) {
        f0.p(response, "response");
        if (!vl.e.c(response)) {
            return 0L;
        }
        if (u(response)) {
            return -1L;
        }
        return rl.f.A(response);
    }

    @Override // vl.d
    @k
    public t h() {
        if (!(this.f54728g == 6)) {
            throw new IllegalStateException("too early; can't read the trailers yet".toString());
        }
        t tVar = this.f54730i;
        return tVar == null ? rl.f.f48797b : tVar;
    }

    @Override // vl.d
    @k
    public r0 i(@k b0 request, long j10) throws ProtocolException {
        f0.p(request, "request");
        if (request.f() != null && request.f().p()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (t(request)) {
            return w();
        }
        if (j10 != -1) {
            return z();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public final void s(v vVar) {
        v0 v0VarL = vVar.l();
        vVar.m(v0.f44220e);
        v0VarL.a();
        v0VarL.b();
    }

    public final boolean t(b0 b0Var) {
        return kotlin.text.u.L1("chunked", b0Var.i(HttpHeaders.TRANSFER_ENCODING), true);
    }

    public final boolean u(okhttp3.d0 d0Var) {
        return kotlin.text.u.L1("chunked", okhttp3.d0.M0(d0Var, HttpHeaders.TRANSFER_ENCODING, null, 2, null), true);
    }

    public final boolean v() {
        return this.f54728g == 6;
    }

    public final r0 w() {
        int i10 = this.f54728g;
        if (!(i10 == 1)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54728g = 2;
        return new C0640b(this);
    }

    public final t0 x(u uVar) {
        int i10 = this.f54728g;
        if (!(i10 == 4)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54728g = 5;
        return new c(this, uVar);
    }

    public final t0 y(long j10) {
        int i10 = this.f54728g;
        if (!(i10 == 4)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54728g = 5;
        return new e(this, j10);
    }

    public final r0 z() {
        int i10 = this.f54728g;
        if (!(i10 == 1)) {
            throw new IllegalStateException(f0.C("state: ", Integer.valueOf(i10)).toString());
        }
        this.f54728g = 2;
        return new f(this);
    }
}
