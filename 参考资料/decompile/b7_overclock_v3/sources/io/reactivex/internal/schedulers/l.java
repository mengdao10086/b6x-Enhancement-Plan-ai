package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f35221c = new l();

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f35222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f35223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f35224c;

        public a(Runnable runnable, c cVar, long j10) {
            this.f35222a = runnable;
            this.f35223b = cVar;
            this.f35224c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35223b.f35232d) {
                return;
            }
            long jA = this.f35223b.a(TimeUnit.MILLISECONDS);
            long j10 = this.f35224c;
            if (j10 > jA) {
                try {
                    Thread.sleep(j10 - jA);
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    kj.a.Y(e10);
                    return;
                }
            }
            if (this.f35223b.f35232d) {
                return;
            }
            this.f35222a.run();
        }
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f35225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f35226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f35228d;

        public b(Runnable runnable, Long l10, int i10) {
            this.f35225a = runnable;
            this.f35226b = l10.longValue();
            this.f35227c = i10;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int iB = io.reactivex.internal.functions.a.b(this.f35226b, bVar.f35226b);
            return iB == 0 ? io.reactivex.internal.functions.a.a(this.f35227c, bVar.f35227c) : iB;
        }
    }

    public static final class c extends h0.c implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityBlockingQueue<b> f35229a = new PriorityBlockingQueue<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f35230b = new AtomicInteger();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f35231c = new AtomicInteger();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f35232d;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f35233a;

            public a(b bVar) {
                this.f35233a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f35233a.f35228d = true;
                c.this.f35229a.remove(this.f35233a);
            }
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b b(@bj.e Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // xi.h0.c
        @bj.e
        public io.reactivex.disposables.b c(@bj.e Runnable runnable, long j10, @bj.e TimeUnit timeUnit) {
            long jA = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return e(new a(runnable, this, jA), jA);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f35232d = true;
        }

        public io.reactivex.disposables.b e(Runnable runnable, long j10) {
            if (this.f35232d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f35231c.incrementAndGet());
            this.f35229a.add(bVar);
            if (this.f35230b.getAndIncrement() != 0) {
                return io.reactivex.disposables.c.f(new a(bVar));
            }
            int iAddAndGet = 1;
            while (!this.f35232d) {
                b bVarPoll = this.f35229a.poll();
                if (bVarPoll == null) {
                    iAddAndGet = this.f35230b.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!bVarPoll.f35228d) {
                    bVarPoll.f35225a.run();
                }
            }
            this.f35229a.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f35232d;
        }
    }

    public static l l() {
        return f35221c;
    }

    @Override // xi.h0
    @bj.e
    public h0.c d() {
        return new c();
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b f(@bj.e Runnable runnable) {
        kj.a.b0(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // xi.h0
    @bj.e
    public io.reactivex.disposables.b g(@bj.e Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            kj.a.b0(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            kj.a.Y(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}
