package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimeoutTimed<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f34373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final xi.h0 f34374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.e0<? extends T> f34375e;

    public static final class TimeoutFallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, io.reactivex.disposables.b, b {
        private static final long serialVersionUID = 3764492702657003550L;
        public final xi.g0<? super T> downstream;
        public xi.e0<? extends T> fallback;
        public final long timeout;
        public final TimeUnit unit;
        public final h0.c worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicLong index = new AtomicLong();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public TimeoutFallbackObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar, xi.e0<? extends T> e0Var) {
            this.downstream = g0Var;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = e0Var;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                xi.e0<? extends T> e0Var = this.fallback;
                this.fallback = null;
                e0Var.c(new a(this.downstream, this));
                this.worker.dispose();
            }
        }

        public void c(long j10) {
            this.task.a(this.worker.c(new c(j10, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.index.compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t10);
                    c(j11);
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public static final class TimeoutObserver<T> extends AtomicLong implements xi.g0<T>, io.reactivex.disposables.b, b {
        private static final long serialVersionUID = 3764492702657003550L;
        public final xi.g0<? super T> downstream;
        public final long timeout;
        public final TimeUnit unit;
        public final h0.c worker;
        public final SequentialDisposable task = new SequentialDisposable();
        public final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public TimeoutObserver(xi.g0<? super T> g0Var, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.downstream = g0Var;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableTimeoutTimed.b
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(ExceptionHelper.e(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        public void c(long j10) {
            this.task.a(this.worker.c(new c(j10, this), this.timeout, this.unit));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // xi.g0
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                kj.a.Y(th2);
                return;
            }
            this.task.dispose();
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // xi.g0
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

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public static final class a<T> implements xi.g0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final xi.g0<? super T> f34376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference<io.reactivex.disposables.b> f34377b;

        public a(xi.g0<? super T> g0Var, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.f34376a = g0Var;
            this.f34377b = atomicReference;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34376a.onComplete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34376a.onError(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34376a.onNext(t10);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this.f34377b, bVar);
        }
    }

    public interface b {
        void a(long j10);
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f34378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f34379b;

        public c(long j10, b bVar) {
            this.f34379b = j10;
            this.f34378a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34378a.a(this.f34379b);
        }
    }

    public ObservableTimeoutTimed(xi.z<T> zVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, xi.e0<? extends T> e0Var) {
        super(zVar);
        this.f34372b = j10;
        this.f34373c = timeUnit;
        this.f34374d = h0Var;
        this.f34375e = e0Var;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        if (this.f34375e == null) {
            TimeoutObserver timeoutObserver = new TimeoutObserver(g0Var, this.f34372b, this.f34373c, this.f34374d.d());
            g0Var.onSubscribe(timeoutObserver);
            timeoutObserver.c(0L);
            this.f34421a.c(timeoutObserver);
            return;
        }
        TimeoutFallbackObserver timeoutFallbackObserver = new TimeoutFallbackObserver(g0Var, this.f34372b, this.f34373c, this.f34374d.d(), this.f34375e);
        g0Var.onSubscribe(timeoutFallbackObserver);
        timeoutFallbackObserver.c(0L);
        this.f34421a.c(timeoutFallbackObserver);
    }
}
