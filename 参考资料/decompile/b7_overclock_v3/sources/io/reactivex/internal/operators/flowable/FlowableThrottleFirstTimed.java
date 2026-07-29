package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableThrottleFirstTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33471e;

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = -9102637559663639004L;
        public boolean done;
        public final bu.d<? super T> downstream;
        public volatile boolean gate;
        public final long timeout;
        public final SequentialDisposable timer = new SequentialDisposable();
        public final TimeUnit unit;
        public bu.e upstream;
        public final h0.c worker;

        public DebounceTimedSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.downstream = dVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done || this.gate) {
                return;
            }
            this.gate = true;
            if (get() == 0) {
                this.done = true;
                cancel();
                this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            } else {
                this.downstream.onNext(t10);
                io.reactivex.internal.util.b.e(this, 1L);
                io.reactivex.disposables.b bVar = this.timer.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                this.timer.a(this.worker.c(this, this.timeout, this.unit));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.gate = false;
        }
    }

    public FlowableThrottleFirstTimed(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        super(jVar);
        this.f33469c = j10;
        this.f33470d = timeUnit;
        this.f33471e = h0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new DebounceTimedSubscriber(new io.reactivex.subscribers.e(dVar), this.f33469c, this.f33470d, this.f33471e.d()));
    }
}
