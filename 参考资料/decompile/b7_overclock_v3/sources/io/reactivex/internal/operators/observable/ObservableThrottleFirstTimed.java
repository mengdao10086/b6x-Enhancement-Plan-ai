package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableThrottleFirstTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34364d;

    public static final class DebounceTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        public boolean done;
        public final xi.g0<? super T> downstream;
        public volatile boolean gate;
        public final long timeout;
        public final TimeUnit unit;
        public io.reactivex.disposables.b upstream;
        public final h0.c worker;

        public DebounceTimedObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.downstream = g0Var;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.downstream.onNext(t10);
            io.reactivex.disposables.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            DisposableHelper.replace(this, this.worker.c(this, this.timeout, this.unit));
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
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(xi.e0<T> e0Var, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        super(e0Var);
        this.f34362b = j10;
        this.f34363c = timeUnit;
        this.f34364d = h0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        this.f34421a.c(new DebounceTimedObserver(new io.reactivex.observers.l(g0Var), this.f34362b, this.f34363c, this.f34364d.d()));
    }
}
