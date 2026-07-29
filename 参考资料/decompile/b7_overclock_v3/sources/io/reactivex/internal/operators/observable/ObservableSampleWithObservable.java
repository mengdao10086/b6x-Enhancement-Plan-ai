package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSampleWithObservable<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<?> f34310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34311c;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        public volatile boolean done;
        public final AtomicInteger wip;

        public SampleMainEmitLast(xi.g0<? super T> g0Var, xi.e0<?> e0Var) {
            super(g0Var, e0Var);
            this.wip = new AtomicInteger();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void b() {
            this.done = true;
            if (this.wip.getAndIncrement() == 0) {
                c();
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void d() {
            if (this.wip.getAndIncrement() == 0) {
                do {
                    boolean z10 = this.done;
                    c();
                    if (z10) {
                        this.downstream.onComplete();
                        return;
                    }
                } while (this.wip.decrementAndGet() != 0);
            }
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        public SampleMainNoLast(xi.g0<? super T> g0Var, xi.e0<?> e0Var) {
            super(g0Var, e0Var);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void b() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void d() {
            c();
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements xi.g0<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3517602651313910099L;
        public final xi.g0<? super T> downstream;
        public final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();
        public final xi.e0<?> sampler;
        public io.reactivex.disposables.b upstream;

        public SampleMainObserver(xi.g0<? super T> g0Var, xi.e0<?> e0Var) {
            this.downstream = g0Var;
            this.sampler = e0Var;
        }

        public void a() {
            this.upstream.dispose();
            b();
        }

        public abstract void b();

        public void c() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }

        public abstract void d();

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        public void e(Throwable th2) {
            this.upstream.dispose();
            this.downstream.onError(th2);
        }

        public boolean f(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.other.get() == DisposableHelper.DISPOSED;
        }

        @Override // xi.g0
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            b();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
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
                if (this.other.get() == null) {
                    this.sampler.c(new a(this));
                }
            }
        }
    }

    public static final class a<T> implements xi.g0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleMainObserver<T> f34312a;

        public a(SampleMainObserver<T> sampleMainObserver) {
            this.f34312a = sampleMainObserver;
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34312a.a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34312a.e(th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            this.f34312a.d();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f34312a.f(bVar);
        }
    }

    public ObservableSampleWithObservable(xi.e0<T> e0Var, xi.e0<?> e0Var2, boolean z10) {
        super(e0Var);
        this.f34310b = e0Var2;
        this.f34311c = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super T> g0Var) {
        io.reactivex.observers.l lVar = new io.reactivex.observers.l(g0Var);
        if (this.f34311c) {
            this.f34421a.c(new SampleMainEmitLast(lVar, this.f34310b));
        } else {
            this.f34421a.c(new SampleMainNoLast(lVar, this.f34310b));
        }
    }
}
