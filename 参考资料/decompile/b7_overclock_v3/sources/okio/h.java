package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.analytics.pro.an;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\b\u0016\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\"\u0010#J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ'\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0001J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006'"}, d2 = {"Lokio/h;", "Lokio/v0;", "Lkotlin/z1;", "w", "", "x", "C", "Lokio/r0;", "sink", i1.a.W4, "Lokio/t0;", "source", "B", i1.a.f31577d5, "Lkotlin/Function0;", "block", "D", "(Lik/a;)Ljava/lang/Object;", "Ljava/io/IOException;", "cause", "q", "y", "", "now", an.aD, "f", "Z", "inQueue", "g", "Lokio/h;", "next", "h", "J", "timeoutAt", "<init>", "()V", "i", "a", "b", "okio"}, k = 1, mv = {1, 5, 1})
public class h extends v0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f44058i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f44059j = 65536;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final long f44060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f44061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @yt.l
    public static h f44062m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f44063f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.l
    public h f44064g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f44065h;

    @kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0002R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lokio/h$a;", "", "Lokio/h;", "c", "()Lokio/h;", "node", "", "timeoutNanos", "", "hasDeadline", "Lkotlin/z1;", "e", "d", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "", "TIMEOUT_WRITE_SIZE", "I", xc.d.f55085o, "Lokio/h;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.l
        public final h c() throws InterruptedException {
            h hVar = h.f44062m;
            kotlin.jvm.internal.f0.m(hVar);
            h hVar2 = hVar.f44064g;
            if (hVar2 == null) {
                long jNanoTime = System.nanoTime();
                h.class.wait(h.f44060k);
                h hVar3 = h.f44062m;
                kotlin.jvm.internal.f0.m(hVar3);
                if (hVar3.f44064g != null || System.nanoTime() - jNanoTime < h.f44061l) {
                    return null;
                }
                return h.f44062m;
            }
            long jZ = hVar2.z(System.nanoTime());
            if (jZ > 0) {
                long j10 = jZ / 1000000;
                h.class.wait(j10, (int) (jZ - (1000000 * j10)));
                return null;
            }
            h hVar4 = h.f44062m;
            kotlin.jvm.internal.f0.m(hVar4);
            hVar4.f44064g = hVar2.f44064g;
            hVar2.f44064g = null;
            return hVar2;
        }

        public final boolean d(h hVar) {
            synchronized (h.class) {
                if (!hVar.f44063f) {
                    return false;
                }
                hVar.f44063f = false;
                for (h hVar2 = h.f44062m; hVar2 != null; hVar2 = hVar2.f44064g) {
                    if (hVar2.f44064g == hVar) {
                        hVar2.f44064g = hVar.f44064g;
                        hVar.f44064g = null;
                        return false;
                    }
                }
                return true;
            }
        }

        public final void e(h hVar, long j10, boolean z10) {
            synchronized (h.class) {
                if (!(!hVar.f44063f)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                hVar.f44063f = true;
                if (h.f44062m == null) {
                    a aVar = h.f44058i;
                    h.f44062m = new h();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z10) {
                    hVar.f44065h = Math.min(j10, hVar.d() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    hVar.f44065h = j10 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    hVar.f44065h = hVar.d();
                }
                long jZ = hVar.z(jNanoTime);
                h hVar2 = h.f44062m;
                kotlin.jvm.internal.f0.m(hVar2);
                while (hVar2.f44064g != null) {
                    h hVar3 = hVar2.f44064g;
                    kotlin.jvm.internal.f0.m(hVar3);
                    if (jZ < hVar3.z(jNanoTime)) {
                        break;
                    }
                    hVar2 = hVar2.f44064g;
                    kotlin.jvm.internal.f0.m(hVar2);
                }
                hVar.f44064g = hVar2.f44064g;
                hVar2.f44064g = hVar;
                if (hVar2 == h.f44062m) {
                    h.class.notify();
                }
                z1 z1Var = z1.f38230a;
            }
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lokio/h$b;", "Ljava/lang/Thread;", "Lkotlin/z1;", "run", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            h hVarC;
            while (true) {
                try {
                    synchronized (h.class) {
                        hVarC = h.f44058i.c();
                        if (hVarC == h.f44062m) {
                            h.f44062m = null;
                            return;
                        }
                        z1 z1Var = z1.f38230a;
                    }
                    if (hVarC != null) {
                        hVarC.C();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"okio/h$c", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "flush", "close", "Lokio/h;", "a", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class c implements r0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r0 f44067b;

        public c(r0 r0Var) {
            this.f44067b = r0Var;
        }

        @Override // okio.r0
        public void V0(@yt.k j source, long j10) throws IOException {
            kotlin.jvm.internal.f0.p(source, "source");
            a1.e(source.m2(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                p0 p0Var = source.f44116a;
                kotlin.jvm.internal.f0.m(p0Var);
                while (true) {
                    if (j11 >= PlaybackStateCompat.C) {
                        break;
                    }
                    j11 += (long) (p0Var.f44176c - p0Var.f44175b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        p0Var = p0Var.f44179f;
                        kotlin.jvm.internal.f0.m(p0Var);
                    }
                }
                h hVar = h.this;
                r0 r0Var = this.f44067b;
                hVar.w();
                try {
                    r0Var.V0(source, j11);
                    z1 z1Var = z1.f38230a;
                    if (hVar.x()) {
                        throw hVar.q(null);
                    }
                    j10 -= j11;
                } catch (IOException e10) {
                    if (!hVar.x()) {
                        throw e10;
                    }
                    throw hVar.q(e10);
                } finally {
                    hVar.x();
                }
            }
        }

        @Override // okio.r0
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h U() {
            return h.this;
        }

        @Override // okio.r0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            h hVar = h.this;
            r0 r0Var = this.f44067b;
            hVar.w();
            try {
                r0Var.close();
                z1 z1Var = z1.f38230a;
                if (hVar.x()) {
                    throw hVar.q(null);
                }
            } catch (IOException e10) {
                if (!hVar.x()) {
                    throw e10;
                }
                throw hVar.q(e10);
            } finally {
                hVar.x();
            }
        }

        @Override // okio.r0, java.io.Flushable
        public void flush() throws IOException {
            h hVar = h.this;
            r0 r0Var = this.f44067b;
            hVar.w();
            try {
                r0Var.flush();
                z1 z1Var = z1.f38230a;
                if (hVar.x()) {
                    throw hVar.q(null);
                }
            } catch (IOException e10) {
                if (!hVar.x()) {
                    throw e10;
                }
                throw hVar.q(e10);
            } finally {
                hVar.x();
            }
        }

        @yt.k
        public String toString() {
            return "AsyncTimeout.sink(" + this.f44067b + ')';
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"okio/h$d", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lkotlin/z1;", "close", "Lokio/h;", "a", "", "toString", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class d implements t0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t0 f44069b;

        public d(t0 t0Var) {
            this.f44069b = t0Var;
        }

        @Override // okio.t0
        public long F1(@yt.k j sink, long j10) throws IOException {
            kotlin.jvm.internal.f0.p(sink, "sink");
            h hVar = h.this;
            t0 t0Var = this.f44069b;
            hVar.w();
            try {
                long jF1 = t0Var.F1(sink, j10);
                if (hVar.x()) {
                    throw hVar.q(null);
                }
                return jF1;
            } catch (IOException e10) {
                if (hVar.x()) {
                    throw hVar.q(e10);
                }
                throw e10;
            } finally {
                hVar.x();
            }
        }

        @Override // okio.t0
        @yt.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h U() {
            return h.this;
        }

        @Override // okio.t0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            h hVar = h.this;
            t0 t0Var = this.f44069b;
            hVar.w();
            try {
                t0Var.close();
                z1 z1Var = z1.f38230a;
                if (hVar.x()) {
                    throw hVar.q(null);
                }
            } catch (IOException e10) {
                if (!hVar.x()) {
                    throw e10;
                }
                throw hVar.q(e10);
            } finally {
                hVar.x();
            }
        }

        @yt.k
        public String toString() {
            return "AsyncTimeout.source(" + this.f44069b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f44060k = millis;
        f44061l = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @yt.k
    public final r0 A(@yt.k r0 sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return new c(sink);
    }

    @yt.k
    public final t0 B(@yt.k t0 source) {
        kotlin.jvm.internal.f0.p(source, "source");
        return new d(source);
    }

    public void C() {
    }

    public final <T> T D(@yt.k ik.a<? extends T> block) throws IOException {
        kotlin.jvm.internal.f0.p(block, "block");
        w();
        try {
            try {
                T tO = block.o();
                kotlin.jvm.internal.c0.d(1);
                if (x()) {
                    throw q(null);
                }
                kotlin.jvm.internal.c0.c(1);
                return tO;
            } catch (IOException e10) {
                if (x()) {
                    throw q(e10);
                }
                throw e10;
            }
        } catch (Throwable th2) {
            kotlin.jvm.internal.c0.d(1);
            x();
            kotlin.jvm.internal.c0.c(1);
            throw th2;
        }
    }

    @kotlin.s0
    @yt.k
    public final IOException q(@yt.l IOException iOException) {
        return y(iOException);
    }

    public final void w() {
        long j10 = j();
        boolean zF = f();
        if (j10 != 0 || zF) {
            f44058i.e(this, j10, zF);
        }
    }

    public final boolean x() {
        return f44058i.d(this);
    }

    @yt.k
    public IOException y(@yt.l IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long z(long j10) {
        return this.f44065h - j10;
    }
}
