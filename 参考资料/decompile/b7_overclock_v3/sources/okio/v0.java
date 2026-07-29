package okio;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u000f\u001a\u00020\u0000H\u0016J\b\u0010\u0010\u001a\u00020\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0001J/\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {"Lokio/v0;", "", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", xf.j.f55230b, "", "f", "d", "deadlineNanoTime", "e", "duration", "c", "b", "a", "Lkotlin/z1;", "h", "monitor", "k", i1.a.f31577d5, "other", "Lkotlin/Function0;", "block", "g", "(Lokio/v0;Lik/a;)Ljava/lang/Object;", "Z", "hasDeadline", "J", "timeoutNanos", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public class v0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final b f44219d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final v0 f44220e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f44222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f44223c;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"okio/v0$a", "Lokio/v0;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "i", "deadlineNanoTime", "e", "Lkotlin/z1;", "h", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a extends v0 {
        @Override // okio.v0
        @yt.k
        public v0 e(long j10) {
            return this;
        }

        @Override // okio.v0
        public void h() {
        }

        @Override // okio.v0
        @yt.k
        public v0 i(long j10, @yt.k TimeUnit unit) {
            kotlin.jvm.internal.f0.p(unit, "unit");
            return this;
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lokio/v0$b;", "", "", "aNanos", "bNanos", "a", "Lokio/v0;", HlsPlaylistParser.M, "Lokio/v0;", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final long a(long j10, long j11) {
            return (j10 != 0 && (j11 == 0 || j10 < j11)) ? j10 : j11;
        }
    }

    @yt.k
    public v0 a() {
        this.f44221a = false;
        return this;
    }

    @yt.k
    public v0 b() {
        this.f44223c = 0L;
        return this;
    }

    @yt.k
    public final v0 c(long j10, @yt.k TimeUnit unit) {
        kotlin.jvm.internal.f0.p(unit, "unit");
        if (j10 > 0) {
            return e(System.nanoTime() + unit.toNanos(j10));
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("duration <= 0: ", Long.valueOf(j10)).toString());
    }

    public long d() {
        if (this.f44221a) {
            return this.f44222b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    @yt.k
    public v0 e(long j10) {
        this.f44221a = true;
        this.f44222b = j10;
        return this;
    }

    public boolean f() {
        return this.f44221a;
    }

    public final <T> T g(@yt.k v0 other, @yt.k ik.a<? extends T> block) {
        kotlin.jvm.internal.f0.p(other, "other");
        kotlin.jvm.internal.f0.p(block, "block");
        long j10 = j();
        long jA = f44219d.a(other.j(), j());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        i(jA, timeUnit);
        if (!f()) {
            if (other.f()) {
                e(other.d());
            }
            try {
                T tO = block.o();
                kotlin.jvm.internal.c0.d(1);
                i(j10, timeUnit);
                if (other.f()) {
                    a();
                }
                kotlin.jvm.internal.c0.c(1);
                return tO;
            } catch (Throwable th2) {
                kotlin.jvm.internal.c0.d(1);
                i(j10, TimeUnit.NANOSECONDS);
                if (other.f()) {
                    a();
                }
                kotlin.jvm.internal.c0.c(1);
                throw th2;
            }
        }
        long jD = d();
        if (other.f()) {
            e(Math.min(d(), other.d()));
        }
        try {
            T tO2 = block.o();
            kotlin.jvm.internal.c0.d(1);
            i(j10, timeUnit);
            if (other.f()) {
                e(jD);
            }
            kotlin.jvm.internal.c0.c(1);
            return tO2;
        } catch (Throwable th3) {
            kotlin.jvm.internal.c0.d(1);
            i(j10, TimeUnit.NANOSECONDS);
            if (other.f()) {
                e(jD);
            }
            kotlin.jvm.internal.c0.c(1);
            throw th3;
        }
    }

    public void h() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.f44221a && this.f44222b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @yt.k
    public v0 i(long j10, @yt.k TimeUnit unit) {
        kotlin.jvm.internal.f0.p(unit, "unit");
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("timeout < 0: ", Long.valueOf(j10)).toString());
        }
        this.f44223c = unit.toNanos(j10);
        return this;
    }

    public long j() {
        return this.f44223c;
    }

    public final void k(@yt.k Object monitor) throws InterruptedIOException {
        kotlin.jvm.internal.f0.p(monitor, "monitor");
        try {
            boolean zF = f();
            long j10 = j();
            long jNanoTime = 0;
            if (!zF && j10 == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zF && j10 != 0) {
                j10 = Math.min(j10, d() - jNanoTime2);
            } else if (zF) {
                j10 = d() - jNanoTime2;
            }
            if (j10 > 0) {
                long j11 = j10 / 1000000;
                Long.signum(j11);
                monitor.wait(j11, (int) (j10 - (1000000 * j11)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= j10) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }
}
