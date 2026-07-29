package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSampleTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f34309e;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        public final AtomicInteger wip;

        public SampleTimedEmitLast(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(g0Var, j10, timeUnit, h0Var);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
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

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        public SampleTimedNoLast(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(g0Var, j10, timeUnit, h0Var);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void b() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            c();
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        public final xi.g0<? super T> downstream;
        public final long period;
        public final xi.h0 scheduler;
        public final AtomicReference<io.reactivex.disposables.b> timer = new AtomicReference<>();
        public final TimeUnit unit;
        public io.reactivex.disposables.b upstream;

        public SampleTimedObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            this.downstream = g0Var;
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
                this.downstream.onNext(andSet);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            a();
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            a();
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            a();
            this.downstream.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            lazySet(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                xi.h0 h0Var = this.scheduler;
                long j10 = this.period;
                DisposableHelper.replace(this.timer, h0Var.h(this, j10, j10, this.unit));
            }
        }
    }

    public ObservableSampleTimed(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var, boolean z10) {
        super(e0Var);
        this.f34306b = j10;
        this.f34307c = timeUnit;
        this.f34308d = h0Var;
        this.f34309e = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        io.reactivex.observers.l lVar = new io.reactivex.observers.l(g0Var);
        if (this.f34309e) {
            this.f34421a.c(new SampleTimedEmitLast(lVar, this.f34306b, this.f34307c, this.f34308d));
        } else {
            this.f34421a.c(new SampleTimedNoLast(lVar, this.f34306b, this.f34307c, this.f34308d));
        }
    }
}
