package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableThrottleLatest<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34368e;

    public static final class ThrottleLatestObserver<T> extends AtomicInteger implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final xi.g0<? super T> downstream;
        public final boolean emitLast;
        public Throwable error;
        public final AtomicReference<T> latest = new AtomicReference<>();
        public final long timeout;
        public volatile boolean timerFired;
        public boolean timerRunning;
        public final TimeUnit unit;
        public io.reactivex.disposables.b upstream;
        public final h0.c worker;

        public ThrottleLatestObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar, boolean z10) {
            this.downstream = g0Var;
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
            xi.g0<? super T> g0Var = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                if (z10 && this.error != null) {
                    atomicReference.lazySet(null);
                    g0Var.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                boolean z11 = atomicReference.get() == null;
                if (z10) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z11 && this.emitLast) {
                        g0Var.onNext(andSet);
                    }
                    g0Var.onComplete();
                    this.worker.dispose();
                    return;
                }
                if (z11) {
                    if (this.timerFired) {
                        this.timerRunning = false;
                        this.timerFired = false;
                    }
                } else if (!this.timerRunning || this.timerFired) {
                    g0Var.onNext(atomicReference.getAndSet(null));
                    this.timerFired = false;
                    this.timerRunning = true;
                    this.worker.c(this, this.timeout, this.unit);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.latest.set(t10);
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            a();
        }
    }

    public ObservableThrottleLatest(xi.z<T> zVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(zVar);
        this.f34365b = j10;
        this.f34366c = timeUnit;
        this.f34367d = h0Var;
        this.f34368e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new ThrottleLatestObserver(g0Var, this.f34365b, this.f34366c, this.f34367d.d(), this.f34368e));
    }
}
