package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTimeoutTimed<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bu.c<? extends T> f33482f;

    public static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements xi.o<T>, b {
        private static final long serialVersionUID = 3764492702657003550L;
        public long consumed;
        public final bu.d<? super T> downstream;
        public bu.c<? extends T> fallback;
        public final AtomicLong index;
        public final SequentialDisposable task;
        public final long timeout;
        public final TimeUnit unit;
        public final AtomicReference<bu.e> upstream;
        public final h0.c worker;

        public TimeoutFallbackSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar, bu.c<? extends T> cVar2) {
            super(true);
            this.downstream = dVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = cVar2;
            this.task = new SequentialDisposable();
            this.upstream = new AtomicReference<>();
            this.index = new AtomicLong();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                long j11 = this.consumed;
                if (j11 != 0) {
                    i(j11);
                }
                bu.c<? extends T> cVar = this.fallback;
                this.fallback = null;
                cVar.d(new a(this.downstream, this));
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.internal.subscriptions.SubscriptionArbiter, bu.e
        public void cancel() {
            super.cancel();
            this.worker.dispose();
        }

        public void l(long j10) {
            this.task.a(this.worker.c(new c(j10, this), this.timeout, this.unit));
        }

        @Override // bu.d
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = j10 + 1;
                if (this.index.compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.consumed++;
                    this.downstream.onNext(t10);
                    l(j11);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this.upstream, eVar)) {
                k(eVar);
            }
        }
    }

    public static final class TimeoutSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e, b {
        private static final long serialVersionUID = 3764492702657003550L;
        public final bu.d<? super T> downstream;
        public final long timeout;
        public final TimeUnit unit;
        public final h0.c worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<bu.e> upstream = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();

        public TimeoutSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.downstream = dVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableTimeoutTimed.b
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                SubscriptionHelper.cancel(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.e(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        public void c(long j10) {
            this.task.a(this.worker.c(new c(j10, this), this.timeout, this.unit));
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.upstream);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t10);
                    c(j11);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.upstream, this.requested, j10);
        }
    }

    public static final class a<T> implements xi.o<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T> f33483a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SubscriptionArbiter f33484b;

        public a(bu.d<? super T> dVar, SubscriptionArbiter subscriptionArbiter) {
            this.f33483a = dVar;
            this.f33484b = subscriptionArbiter;
        }

        @Override // bu.d
        public void onComplete() {
            this.f33483a.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33483a.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33483a.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            this.f33484b.k(eVar);
        }
    }

    public interface b {
        void a(long j10);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f33485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f33486b;

        public c(long j10, b bVar) {
            this.f33486b = j10;
            this.f33485a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f33485a.a(this.f33486b);
        }
    }

    public FlowableTimeoutTimed(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, bu.c<? extends T> cVar) {
        super(jVar);
        this.f33479c = j10;
        this.f33480d = timeUnit;
        this.f33481e = h0Var;
        this.f33482f = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (this.f33482f == null) {
            TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(dVar, this.f33479c, this.f33480d, this.f33481e.d());
            dVar.onSubscribe(timeoutSubscriber);
            timeoutSubscriber.c(0L);
            this.f33524b.j6(timeoutSubscriber);
            return;
        }
        TimeoutFallbackSubscriber timeoutFallbackSubscriber = new TimeoutFallbackSubscriber(dVar, this.f33479c, this.f33480d, this.f33481e.d(), this.f33482f);
        dVar.onSubscribe(timeoutFallbackSubscriber);
        timeoutFallbackSubscriber.l(0L);
        this.f33524b.j6(timeoutFallbackSubscriber);
    }
}
