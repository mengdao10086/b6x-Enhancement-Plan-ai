package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB\t\b\u0016¢\u0006\u0004\b\u001c\u0010\u001eJ$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u0007J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0002H\u0002J\f\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0002H\u0002R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018¨\u0006\u001f"}, d2 = {"Lokio/u0;", "", "", "bytesPerSecond", "waitByteCount", "maxByteCount", "Lkotlin/z1;", "d", "byteCount", xf.j.f55230b, "(J)J", "now", "a", "(JJ)J", "Lokio/t0;", "source", "i", "Lokio/r0;", "sink", "h", "g", "f", "nanosToWait", "k", "J", "allocatedUntil", "b", "c", "<init>", "(J)V", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f44210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f44211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f44212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f44213d;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"okio/u0$a", "Lokio/t;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r0 f44215c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r0 r0Var) {
            super(r0Var);
            this.f44215c = r0Var;
        }

        @Override // okio.t, okio.r0
        public void V0(@yt.k j source, long j10) throws IOException {
            kotlin.jvm.internal.f0.p(source, "source");
            while (j10 > 0) {
                try {
                    long j11 = u0.this.j(j10);
                    super.V0(source, j11);
                    j10 -= j11;
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        }
    }

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"okio/u0$b", "Lokio/u;", "Lokio/j;", "sink", "", "byteCount", "F1", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class b extends u {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t0 f44217c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t0 t0Var) {
            super(t0Var);
            this.f44217c = t0Var;
        }

        @Override // okio.u, okio.t0
        public long F1(@yt.k j sink, long j10) throws InterruptedIOException {
            kotlin.jvm.internal.f0.p(sink, "sink");
            try {
                return super.F1(sink, u0.this.j(j10));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException("interrupted");
            }
        }
    }

    public u0(long j10) {
        this.f44210a = j10;
        this.f44212c = 8192L;
        this.f44213d = 262144L;
    }

    public static /* synthetic */ void e(u0 u0Var, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = u0Var.f44212c;
        }
        long j13 = j11;
        if ((i10 & 4) != 0) {
            j12 = u0Var.f44213d;
        }
        u0Var.d(j10, j13, j12);
    }

    public final long a(long j10, long j11) {
        if (this.f44211b == 0) {
            return j11;
        }
        long jMax = Math.max(this.f44210a - j10, 0L);
        long jG = this.f44213d - g(jMax);
        if (jG >= j11) {
            this.f44210a = j10 + jMax + f(j11);
            return j11;
        }
        long j12 = this.f44212c;
        if (jG >= j12) {
            this.f44210a = j10 + f(this.f44213d);
            return jG;
        }
        long jMin = Math.min(j12, j11);
        long jF = jMax + f(jMin - this.f44213d);
        if (jF != 0) {
            return -jF;
        }
        this.f44210a = j10 + f(this.f44213d);
        return jMin;
    }

    @hk.i
    public final void b(long j10) {
        e(this, j10, 0L, 0L, 6, null);
    }

    @hk.i
    public final void c(long j10, long j11) {
        e(this, j10, j11, 0L, 4, null);
    }

    @hk.i
    public final void d(long j10, long j11, long j12) {
        synchronized (this) {
            if (!(j10 >= 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j11 > 0)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(j12 >= j11)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f44211b = j10;
            this.f44212c = j11;
            this.f44213d = j12;
            notifyAll();
            z1 z1Var = z1.f38230a;
        }
    }

    public final long f(long j10) {
        return (j10 * ya.g.f56695j) / this.f44211b;
    }

    public final long g(long j10) {
        return (j10 * this.f44211b) / ya.g.f56695j;
    }

    @yt.k
    public final r0 h(@yt.k r0 sink) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        return new a(sink);
    }

    @yt.k
    public final t0 i(@yt.k t0 source) {
        kotlin.jvm.internal.f0.p(source, "source");
        return new b(source);
    }

    public final long j(long j10) {
        long jA;
        if (!(j10 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            while (true) {
                jA = a(System.nanoTime(), j10);
                if (jA < 0) {
                    k(-jA);
                }
            }
        }
        return jA;
    }

    public final void k(long j10) throws InterruptedException {
        long j11 = j10 / 1000000;
        wait(j11, (int) (j10 - (1000000 * j11)));
    }

    public u0() {
        this(System.nanoTime());
    }
}
