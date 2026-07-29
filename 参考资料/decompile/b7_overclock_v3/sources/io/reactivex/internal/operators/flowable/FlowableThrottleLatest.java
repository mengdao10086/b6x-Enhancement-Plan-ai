package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableThrottleLatest<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33475f;

    public static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public final boolean emitLast;
        public long emitted;
        public Throwable error;
        public final AtomicReference<T> latest = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public final long timeout;
        public volatile boolean timerFired;
        public boolean timerRunning;
        public final TimeUnit unit;
        public bu.e upstream;
        public final h0.c worker;

        public ThrottleLatestSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.downstream = dVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z10;
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.latest;
            AtomicLong atomicLong = this.requested;
            bu.d<? super T> dVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                if (z10 && this.error != null) {
                    atomicReference.lazySet(null);
                    dVar.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                boolean z11 = atomicReference.get() == null;
                if (z10) {
                    if (z11 || !this.emitLast) {
                        atomicReference.lazySet(null);
                        dVar.onComplete();
                    } else {
                        T andSet = atomicReference.getAndSet(null);
                        long j10 = this.emitted;
                        if (j10 != atomicLong.get()) {
                            this.emitted = j10 + 1;
                            dVar.onNext(andSet);
                            dVar.onComplete();
                        } else {
                            dVar.onError(new MissingBackpressureException("Could not emit final value due to lack of requests"));
                        }
                    }
                    this.worker.dispose();
                    return;
                }
                if (z11) {
                    if (this.timerFired) {
                        this.timerRunning = false;
                        this.timerFired = false;
                    }
                } else if (!this.timerRunning || this.timerFired) {
                    T andSet2 = atomicReference.getAndSet(null);
                    long j11 = this.emitted;
                    if (j11 == atomicLong.get()) {
                        this.upstream.cancel();
                        dVar.onError(new MissingBackpressureException("Could not emit value due to lack of requests"));
                        this.worker.dispose();
                        return;
                    } else {
                        dVar.onNext(andSet2);
                        this.emitted = j11 + 1;
                        this.timerFired = false;
                        this.timerRunning = true;
                        this.worker.c(this, this.timeout, this.unit);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.latest.set(t10);
            a();
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
                io.reactivex.internal.util.b.a(this.requested, j10);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            a();
        }
    }

    public FlowableThrottleLatest(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(jVar);
        this.f33472c = j10;
        this.f33473d = timeUnit;
        this.f33474e = h0Var;
        this.f33475f = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new ThrottleLatestSubscriber(dVar, this.f33472c, this.f33473d, this.f33474e.d(), this.f33475f));
    }
}
