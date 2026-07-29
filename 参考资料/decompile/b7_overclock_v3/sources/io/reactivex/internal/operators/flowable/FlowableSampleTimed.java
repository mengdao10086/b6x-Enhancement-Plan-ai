package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSampleTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33428f;

    public static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger wip;

        public SampleTimedEmitLast(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(dVar, j10, timeUnit, h0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        public void b() {
            c();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                c();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(dVar, j10, timeUnit, h0Var);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        public void b() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final bu.d<? super T> downstream;
        public final long period;
        public final xi.h0 scheduler;
        public final TimeUnit unit;
        public bu.e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final SequentialDisposable timer = new SequentialDisposable();

        public SampleTimedSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.downstream = dVar;
            this.period = j10;
            this.unit = timeUnit;
            this.scheduler = h0Var;
        }

        public void a() {
            DisposableHelper.dispose(this.timer);
        }

        public abstract void b();

        public void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    io.reactivex.internal.util.b.e(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            a();
            this.upstream.cancel();
        }

        @Override // bu.d
        public void onComplete() {
            a();
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            a();
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.timer;
                xi.h0 h0Var = this.scheduler;
                long j10 = this.period;
                sequentialDisposable.a(h0Var.h(this, j10, j10, this.unit));
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
            }
        }
    }

    public FlowableSampleTimed(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(jVar);
        this.f33425c = j10;
        this.f33426d = timeUnit;
        this.f33427e = h0Var;
        this.f33428f = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        io.reactivex.subscribers.e eVar = new io.reactivex.subscribers.e(dVar);
        if (this.f33428f) {
            this.f33524b.j6(new SampleTimedEmitLast(eVar, this.f33425c, this.f33426d, this.f33427e));
        } else {
            this.f33524b.j6(new SampleTimedNoLast(eVar, this.f33425c, this.f33426d, this.f33427e));
        }
    }
}
