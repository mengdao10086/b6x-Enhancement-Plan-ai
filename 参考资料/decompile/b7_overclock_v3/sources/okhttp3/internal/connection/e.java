package okhttp3.internal.connection;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.tencent.open.SocialConstants;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import f0.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.z1;
import m0.k;
import okhttp3.CertificatePinner;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.p;
import okhttp3.r;
import okhttp3.u;
import xf.j;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016*\u0001Q\u0018\u00002\u00020\u0001:\u0002<AB\u001f\u0012\u0006\u0010@\u001a\u00020;\u0012\u0006\u0010E\u001a\u00020\u0013\u0012\u0006\u0010H\u001a\u00020\u0016¢\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0000H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\u000f\u0010\u001e\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0016J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b&\u0010'J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(J;\u0010.\u001a\u00028\u0000\"\n\b\u0000\u0010\u0005*\u0004\u0018\u00010\u00042\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000H\u0000¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b0\u0010\u0007J\u0011\u00102\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0004\b2\u00103J\u0006\u00104\u001a\u00020\u0002J\u0017\u00106\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0016H\u0000¢\u0006\u0004\b6\u00107J\u0006\u00108\u001a\u00020\u0016J\u000f\u00109\u001a\u00020\u000eH\u0000¢\u0006\u0004\b9\u0010:R\u0017\u0010@\u001a\u00020;8\u0006¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010E\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\u0017\u0010H\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010JR\u001a\u0010P\u001a\u00020L8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010RR\u0014\u0010V\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010[R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010]\u001a\u0004\u0018\u00010(8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b>\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\u001dR(\u0010f\u001a\u0004\u0018\u00010%2\b\u0010]\u001a\u0004\u0018\u00010%8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010\u001dR\u0016\u0010h\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010\u001dR\u0016\u0010i\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010\u001dR\u0016\u0010j\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010\u001dR\u0018\u0010+\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010cR$\u0010m\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010^\u001a\u0004\bb\u0010`\"\u0004\bk\u0010l¨\u0006p"}, d2 = {"Lokhttp3/internal/connection/e;", "Lokhttp3/e;", "Lkotlin/z1;", "e", "Ljava/io/IOException;", i1.a.S4, "d", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "B", "Lokhttp3/u;", "url", "Lokhttp3/a;", "g", "", "C", "Lokio/h;", "y", "f", "Lokhttp3/b0;", i1.a.f31577d5, CommonNetImpl.CANCEL, "", i1.a.T4, "Lokhttp3/d0;", "X", "Lokhttp3/f;", "responseCallback", "b0", "Z", "q", "()Lokhttp3/d0;", SocialConstants.TYPE_REQUEST, "newExchangeFinder", "h", "Lvl/g;", "chain", "Lokhttp3/internal/connection/c;", SsManifestParser.e.J, "(Lvl/g;)Lokhttp3/internal/connection/c;", "Lokhttp3/internal/connection/RealConnection;", xl.e.f55522j, "c", "exchange", "requestDone", "responseDone", an.aB, "(Lokhttp3/internal/connection/c;ZZLjava/io/IOException;)Ljava/io/IOException;", "t", "Ljava/net/Socket;", "v", "()Ljava/net/Socket;", i1.a.W4, "closeExchange", "i", "(Z)V", "w", "u", "()Ljava/lang/String;", "Lokhttp3/a0;", "a", "Lokhttp3/a0;", j.f55230b, "()Lokhttp3/a0;", "client", "b", "Lokhttp3/b0;", "p", "()Lokhttp3/b0;", "originalRequest", "n", "()Z", "forWebSocket", "Lokhttp3/internal/connection/f;", "Lokhttp3/internal/connection/f;", "connectionPool", "Lokhttp3/r;", "Lokhttp3/r;", k.f40564b, "()Lokhttp3/r;", "eventListener", "okhttp3/internal/connection/e$c", "Lokhttp3/internal/connection/e$c;", "timeout", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "", "Ljava/lang/Object;", "callStackTrace", "Lokhttp3/internal/connection/d;", "Lokhttp3/internal/connection/d;", "exchangeFinder", "<set-?>", "Lokhttp3/internal/connection/RealConnection;", "k", "()Lokhttp3/internal/connection/RealConnection;", "timeoutEarlyExit", l.f16298a, "Lokhttp3/internal/connection/c;", "o", "()Lokhttp3/internal/connection/c;", "interceptorScopedExchange", "requestBodyOpen", "responseBodyOpen", "expectMoreExchanges", "canceled", "x", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionToCancel", "<init>", "(Lokhttp3/a0;Lokhttp3/b0;Z)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class e implements okhttp3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final a0 f43827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final b0 f43828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f43829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final f f43830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final r f43831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final c f43832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public final AtomicBoolean f43833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public Object f43834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.l
    public d f43835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @yt.l
    public RealConnection f43836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f43837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @yt.l
    public okhttp3.internal.connection.c f43838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f43839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f43840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f43841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f43842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @yt.l
    public volatile okhttp3.internal.connection.c f43843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @yt.l
    public volatile RealConnection f43844r;

    @d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR$\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u001c¨\u0006 "}, d2 = {"Lokhttp3/internal/connection/e$a;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/e;", "other", "Lkotlin/z1;", "f", "Ljava/util/concurrent/ExecutorService;", "executorService", "a", "run", "Lokhttp3/f;", "Lokhttp3/f;", "responseCallback", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "()Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "", "d", "()Ljava/lang/String;", xl.e.f55523k, "Lokhttp3/b0;", "e", "()Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "()Lokhttp3/internal/connection/e;", v.E0, "<init>", "(Lokhttp3/internal/connection/e;Lokhttp3/f;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final okhttp3.f f43845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public volatile AtomicInteger f43846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f43847c;

        public a(@yt.k e this$0, okhttp3.f responseCallback) {
            f0.p(this$0, "this$0");
            f0.p(responseCallback, "responseCallback");
            this.f43847c = this$0;
            this.f43845a = responseCallback;
            this.f43846b = new AtomicInteger(0);
        }

        public final void a(@yt.k ExecutorService executorService) {
            f0.p(executorService, "executorService");
            p pVarQ = this.f43847c.j().Q();
            if (rl.f.f48803h && Thread.holdsLock(pVarQ)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + pVarQ);
            }
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e10) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e10);
                    this.f43847c.t(interruptedIOException);
                    this.f43845a.d(this.f43847c, interruptedIOException);
                    this.f43847c.j().Q().h(this);
                }
            } catch (Throwable th2) {
                this.f43847c.j().Q().h(this);
                throw th2;
            }
        }

        @yt.k
        public final e b() {
            return this.f43847c;
        }

        @yt.k
        public final AtomicInteger c() {
            return this.f43846b;
        }

        @yt.k
        public final String d() {
            return this.f43847c.p().q().F();
        }

        @yt.k
        public final b0 e() {
            return this.f43847c.p();
        }

        public final void f(@yt.k a other) {
            f0.p(other, "other");
            this.f43846b = other.f43846b;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2;
            boolean z10;
            IOException e10;
            p pVarQ;
            String strC = f0.C("OkHttp ", this.f43847c.u());
            e eVar = this.f43847c;
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(strC);
            try {
                try {
                    eVar.f43832f.w();
                    try {
                        z10 = true;
                        try {
                            this.f43845a.c(eVar, eVar.q());
                            pVarQ = eVar.j().Q();
                        } catch (IOException e11) {
                            e10 = e11;
                            if (z10) {
                                zl.h.f58636a.g().m(f0.C("Callback failure for ", eVar.C()), 4, e10);
                            } else {
                                this.f43845a.d(eVar, e10);
                            }
                            pVarQ = eVar.j().Q();
                        } catch (Throwable th3) {
                            th2 = th3;
                            eVar.cancel();
                            if (!z10) {
                                IOException iOException = new IOException(f0.C("canceled due to ", th2));
                                o.a(iOException, th2);
                                this.f43845a.d(eVar, iOException);
                            }
                            throw th2;
                        }
                    } catch (IOException e12) {
                        e10 = e12;
                        z10 = false;
                    } catch (Throwable th4) {
                        th2 = th4;
                        z10 = false;
                    }
                    pVarQ.h(this);
                } catch (Throwable th5) {
                    eVar.j().Q().h(this);
                    throw th5;
                }
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/connection/e$b;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/e;", "", "a", "Ljava/lang/Object;", "()Ljava/lang/Object;", "callStackTrace", "referent", "<init>", "(Lokhttp3/internal/connection/e;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class b extends WeakReference<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.l
        public final Object f43848a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@yt.k e referent, @yt.l Object obj) {
            super(referent);
            f0.p(referent, "referent");
            this.f43848a = obj;
        }

        @yt.l
        public final Object a() {
            return this.f43848a;
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, d2 = {"okhttp3/internal/connection/e$c", "Lokio/h;", "Lkotlin/z1;", "C", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class c extends okio.h {
        public c() {
        }

        @Override // okio.h
        public void C() {
            e.this.cancel();
        }
    }

    public e(@yt.k a0 client, @yt.k b0 originalRequest, boolean z10) {
        f0.p(client, "client");
        f0.p(originalRequest, "originalRequest");
        this.f43827a = client;
        this.f43828b = originalRequest;
        this.f43829c = z10;
        this.f43830d = client.N().c();
        this.f43831e = client.S().create(this);
        c cVar = new c();
        cVar.i(j().I(), TimeUnit.MILLISECONDS);
        this.f43832f = cVar;
        this.f43833g = new AtomicBoolean();
        this.f43841o = true;
    }

    public final void A() {
        if (!(!this.f43837k)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f43837k = true;
        this.f43832f.x();
    }

    public final <E extends IOException> E B(E e10) {
        if (this.f43837k || !this.f43832f.x()) {
            return e10;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    public final String C() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(W() ? "canceled " : "");
        sb2.append(this.f43829c ? "web socket" : v.E0);
        sb2.append(" to ");
        sb2.append(u());
        return sb2.toString();
    }

    @Override // okhttp3.e
    @yt.k
    public b0 T() {
        return this.f43828b;
    }

    @Override // okhttp3.e
    public boolean W() {
        return this.f43842p;
    }

    @Override // okhttp3.e
    @yt.k
    public okhttp3.d0 X() {
        if (!this.f43833g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f43832f.w();
        e();
        try {
            this.f43827a.Q().d(this);
            return q();
        } finally {
            this.f43827a.Q().i(this);
        }
    }

    @Override // okhttp3.e
    public boolean Z() {
        return this.f43833g.get();
    }

    @Override // okhttp3.e
    public void b0(@yt.k okhttp3.f responseCallback) {
        f0.p(responseCallback, "responseCallback");
        if (!this.f43833g.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        e();
        this.f43827a.Q().c(new a(this, responseCallback));
    }

    public final void c(@yt.k RealConnection connection) {
        f0.p(connection, "connection");
        if (!rl.f.f48803h || Thread.holdsLock(connection)) {
            if (!(this.f43836j == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            this.f43836j = connection;
            connection.s().add(new b(this, this.f43834h));
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
    }

    @Override // okhttp3.e
    public void cancel() {
        if (this.f43842p) {
            return;
        }
        this.f43842p = true;
        okhttp3.internal.connection.c cVar = this.f43843q;
        if (cVar != null) {
            cVar.b();
        }
        RealConnection realConnection = this.f43844r;
        if (realConnection != null) {
            realConnection.i();
        }
        this.f43831e.canceled(this);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <E extends IOException> E d(E e10) {
        Socket socketV;
        boolean z10 = rl.f.f48803h;
        if (z10 && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        RealConnection realConnection = this.f43836j;
        if (realConnection != null) {
            if (z10 && Thread.holdsLock(realConnection)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + realConnection);
            }
            synchronized (realConnection) {
                socketV = v();
            }
            if (this.f43836j == null) {
                if (socketV != null) {
                    rl.f.q(socketV);
                }
                this.f43831e.connectionReleased(this, realConnection);
            } else {
                if (!(socketV == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        E e11 = (E) B(e10);
        if (e10 != null) {
            r rVar = this.f43831e;
            f0.m(e11);
            rVar.callFailed(this, e11);
        } else {
            this.f43831e.callEnd(this);
        }
        return e11;
    }

    public final void e() {
        this.f43834h = zl.h.f58636a.g().k("response.body().close()");
        this.f43831e.callStart(this);
    }

    @Override // okhttp3.e
    @yt.k
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public e mo11clone() {
        return new e(this.f43827a, this.f43828b, this.f43829c);
    }

    public final okhttp3.a g(u uVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifierC0;
        CertificatePinner certificatePinnerK;
        if (uVar.G()) {
            SSLSocketFactory sSLSocketFactoryP0 = this.f43827a.p0();
            hostnameVerifierC0 = this.f43827a.c0();
            sSLSocketFactory = sSLSocketFactoryP0;
            certificatePinnerK = this.f43827a.K();
        } else {
            sSLSocketFactory = null;
            hostnameVerifierC0 = null;
            certificatePinnerK = null;
        }
        return new okhttp3.a(uVar.F(), uVar.N(), this.f43827a.R(), this.f43827a.o0(), sSLSocketFactory, hostnameVerifierC0, certificatePinnerK, this.f43827a.k0(), this.f43827a.j0(), this.f43827a.i0(), this.f43827a.O(), this.f43827a.l0());
    }

    public final void h(@yt.k b0 request, boolean z10) {
        f0.p(request, "request");
        if (!(this.f43838l == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        synchronized (this) {
            if (!(!this.f43840n)) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
            }
            if (!(!this.f43839m)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        if (z10) {
            this.f43835i = new d(this.f43830d, g(request.q()), this, this.f43831e);
        }
    }

    public final void i(boolean z10) {
        okhttp3.internal.connection.c cVar;
        synchronized (this) {
            if (!this.f43841o) {
                throw new IllegalStateException("released".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        if (z10 && (cVar = this.f43843q) != null) {
            cVar.d();
        }
        this.f43838l = null;
    }

    @yt.k
    public final a0 j() {
        return this.f43827a;
    }

    @yt.l
    public final RealConnection k() {
        return this.f43836j;
    }

    @yt.l
    public final RealConnection l() {
        return this.f43844r;
    }

    @yt.k
    public final r m() {
        return this.f43831e;
    }

    public final boolean n() {
        return this.f43829c;
    }

    @yt.l
    public final okhttp3.internal.connection.c o() {
        return this.f43838l;
    }

    @yt.k
    public final b0 p() {
        return this.f43828b;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a2  */
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final okhttp3.d0 q() throws java.lang.Throwable {
        /*
            r10 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.a0 r0 = r10.f43827a
            java.util.List r0 = r0.d0()
            kotlin.collections.x.n0(r2, r0)
            vl.j r0 = new vl.j
            okhttp3.a0 r1 = r10.f43827a
            r0.<init>(r1)
            r2.add(r0)
            vl.a r0 = new vl.a
            okhttp3.a0 r1 = r10.f43827a
            okhttp3.n r1 = r1.P()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.a r0 = new okhttp3.internal.cache.a
            okhttp3.a0 r1 = r10.f43827a
            okhttp3.c r1 = r1.H()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.a r0 = okhttp3.internal.connection.a.f43795a
            r2.add(r0)
            boolean r0 = r10.f43829c
            if (r0 != 0) goto L46
            okhttp3.a0 r0 = r10.f43827a
            java.util.List r0 = r0.f0()
            kotlin.collections.x.n0(r2, r0)
        L46:
            vl.b r0 = new vl.b
            boolean r1 = r10.f43829c
            r0.<init>(r1)
            r2.add(r0)
            vl.g r9 = new vl.g
            r3 = 0
            r4 = 0
            okhttp3.b0 r5 = r10.f43828b
            okhttp3.a0 r0 = r10.f43827a
            int r6 = r0.L()
            okhttp3.a0 r0 = r10.f43827a
            int r7 = r0.m0()
            okhttp3.a0 r0 = r10.f43827a
            int r8 = r0.r0()
            r0 = r9
            r1 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.b0 r2 = r10.f43828b     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            okhttp3.d0 r2 = r9.e(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            boolean r3 = r10.W()     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            if (r3 != 0) goto L7f
            r10.t(r1)
            return r2
        L7f:
            rl.f.o(r2)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
            throw r2     // Catch: java.lang.Throwable -> L8a java.io.IOException -> L8c
        L8a:
            r2 = move-exception
            goto La0
        L8c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r10.t(r0)     // Catch: java.lang.Throwable -> L9d
            if (r0 != 0) goto L9c
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch: java.lang.Throwable -> L9d
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Throwable"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L9d
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9c:
            throw r0     // Catch: java.lang.Throwable -> L9d
        L9d:
            r0 = move-exception
            r2 = r0
            r0 = 1
        La0:
            if (r0 != 0) goto La5
            r10.t(r1)
        La5:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.e.q():okhttp3.d0");
    }

    @yt.k
    public final okhttp3.internal.connection.c r(@yt.k vl.g chain) throws IOException {
        f0.p(chain, "chain");
        synchronized (this) {
            if (!this.f43841o) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!this.f43840n)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!this.f43839m)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            z1 z1Var = z1.f38230a;
        }
        d dVar = this.f43835i;
        f0.m(dVar);
        okhttp3.internal.connection.c cVar = new okhttp3.internal.connection.c(this, this.f43831e, dVar, dVar.a(this.f43827a, chain));
        this.f43838l = cVar;
        this.f43843q = cVar;
        synchronized (this) {
            this.f43839m = true;
            this.f43840n = true;
        }
        if (this.f43842p) {
            throw new IOException("Canceled");
        }
        return cVar;
    }

    public final <E extends IOException> E s(@yt.k okhttp3.internal.connection.c exchange, boolean z10, boolean z11, E e10) {
        boolean z12;
        boolean z13;
        f0.p(exchange, "exchange");
        if (!f0.g(exchange, this.f43843q)) {
            return e10;
        }
        synchronized (this) {
            z12 = false;
            if (z10) {
                try {
                    if (!this.f43839m) {
                        if (z11 || !this.f43840n) {
                            z13 = false;
                        }
                    }
                    if (z10) {
                        this.f43839m = false;
                    }
                    if (z11) {
                        this.f43840n = false;
                    }
                    boolean z14 = this.f43839m;
                    boolean z15 = (z14 || this.f43840n) ? false : true;
                    if (!z14 && !this.f43840n && !this.f43841o) {
                        z12 = true;
                    }
                    z13 = z12;
                    z12 = z15;
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                if (z11) {
                }
                z13 = false;
            }
            z1 z1Var = z1.f38230a;
        }
        if (z12) {
            this.f43843q = null;
            RealConnection realConnection = this.f43836j;
            if (realConnection != null) {
                realConnection.x();
            }
        }
        return z13 ? (E) d(e10) : e10;
    }

    @yt.l
    public final IOException t(@yt.l IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f43841o) {
                this.f43841o = false;
                if (!this.f43839m && !this.f43840n) {
                    z10 = true;
                }
            }
            z1 z1Var = z1.f38230a;
        }
        return z10 ? d(iOException) : iOException;
    }

    @yt.k
    public final String u() {
        return this.f43828b.q().V();
    }

    @yt.l
    public final Socket v() {
        RealConnection realConnection = this.f43836j;
        f0.m(realConnection);
        if (rl.f.f48803h && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List<Reference<e>> listS = realConnection.s();
        Iterator<Reference<e>> it2 = listS.iterator();
        int i10 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i10 = -1;
                break;
            }
            if (f0.g(it2.next().get(), this)) {
                break;
            }
            i10++;
        }
        if (!(i10 != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        listS.remove(i10);
        this.f43836j = null;
        if (listS.isEmpty()) {
            realConnection.G(System.nanoTime());
            if (this.f43830d.c(realConnection)) {
                return realConnection.d();
            }
        }
        return null;
    }

    public final boolean w() {
        d dVar = this.f43835i;
        f0.m(dVar);
        return dVar.e();
    }

    public final void x(@yt.l RealConnection realConnection) {
        this.f43844r = realConnection;
    }

    @Override // okhttp3.e
    @yt.k
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public okio.h U() {
        return this.f43832f;
    }
}
