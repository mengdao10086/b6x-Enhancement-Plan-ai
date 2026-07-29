package lj;

import bj.e;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<b> f39810c = new PriorityBlockingQueue(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f39811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile long f39812e;

    public final class a extends h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f39813a;

        /* JADX INFO: renamed from: lj.c$a$a, reason: collision with other inner class name */
        public final class RunnableC0445a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f39815a;

            public RunnableC0445a(b bVar) {
                this.f39815a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f39810c.remove(this.f39815a);
            }
        }

        public a() {
        }

        @Override // xi.h0.c
        public long a(@e TimeUnit timeUnit) {
            return c.this.e(timeUnit);
        }

        @Override // xi.h0.c
        @e
        public io.reactivex.disposables.b b(@e Runnable runnable) {
            if (this.f39813a) {
                return EmptyDisposable.INSTANCE;
            }
            c cVar = c.this;
            long j10 = cVar.f39811d;
            cVar.f39811d = 1 + j10;
            b bVar = new b(this, 0L, runnable, j10);
            c.this.f39810c.add(bVar);
            return io.reactivex.disposables.c.f(new RunnableC0445a(bVar));
        }

        @Override // xi.h0.c
        @e
        public io.reactivex.disposables.b c(@e Runnable runnable, long j10, @e TimeUnit timeUnit) {
            if (this.f39813a) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = c.this.f39812e + timeUnit.toNanos(j10);
            c cVar = c.this;
            long j11 = cVar.f39811d;
            cVar.f39811d = 1 + j11;
            b bVar = new b(this, nanos, runnable, j11);
            c.this.f39810c.add(bVar);
            return io.reactivex.disposables.c.f(new RunnableC0445a(bVar));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f39813a = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f39813a;
        }
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f39817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f39818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f39819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f39820d;

        public b(a aVar, long j10, Runnable runnable, long j11) {
            this.f39817a = j10;
            this.f39818b = runnable;
            this.f39819c = aVar;
            this.f39820d = j11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j10 = this.f39817a;
            long j11 = bVar.f39817a;
            return j10 == j11 ? io.reactivex.internal.functions.a.b(this.f39820d, bVar.f39820d) : io.reactivex.internal.functions.a.b(j10, j11);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", Long.valueOf(this.f39817a), this.f39818b.toString());
        }
    }

    public c() {
    }

    @Override // xi.h0
    @e
    public h0.c d() {
        return new a();
    }

    @Override // xi.h0
    public long e(@e TimeUnit timeUnit) {
        return timeUnit.convert(this.f39812e, TimeUnit.NANOSECONDS);
    }

    public void l(long j10, TimeUnit timeUnit) {
        m(this.f39812e + timeUnit.toNanos(j10), TimeUnit.NANOSECONDS);
    }

    public void m(long j10, TimeUnit timeUnit) {
        o(timeUnit.toNanos(j10));
    }

    public void n() {
        o(this.f39812e);
    }

    public final void o(long j10) {
        while (true) {
            b bVarPeek = this.f39810c.peek();
            if (bVarPeek == null) {
                break;
            }
            long j11 = bVarPeek.f39817a;
            if (j11 > j10) {
                break;
            }
            if (j11 == 0) {
                j11 = this.f39812e;
            }
            this.f39812e = j11;
            this.f39810c.remove(bVarPeek);
            if (!bVarPeek.f39819c.f39813a) {
                bVarPeek.f39818b.run();
            }
        }
        this.f39812e = j10;
    }

    public c(long j10, TimeUnit timeUnit) {
        this.f39812e = timeUnit.toNanos(j10);
    }
}
