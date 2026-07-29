package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapCompletableCompletable<T> extends xi.a implements fj.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.g> f34178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f34179c;

    public static final class FlatMapCompletableMainObserver<T> extends AtomicInteger implements io.reactivex.disposables.b, xi.g0<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final xi.d downstream;
        public final dj.o<? super T, ? extends xi.g> mapper;
        public io.reactivex.disposables.b upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        public final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                FlatMapCompletableMainObserver.this.a(this);
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                FlatMapCompletableMainObserver.this.b(this, th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public FlatMapCompletableMainObserver(xi.d dVar, dj.o<? super T, ? extends xi.g> oVar, boolean z10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainObserver<T>.InnerObserver innerObserver, Throwable th2) {
            this.set.c(innerObserver);
            onError(th2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // xi.g0
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thC = this.errors.c();
                if (thC != null) {
                    this.downstream.onError(thC);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.delayErrors) {
                if (decrementAndGet() == 0) {
                    this.downstream.onError(this.errors.c());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.downstream.onError(this.errors.c());
            }
        }

        @Override // xi.g0
        public void onNext(T t10) {
            try {
                xi.g gVar = (xi.g) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.disposed || !this.set.b(innerObserver)) {
                    return;
                }
                gVar.a(innerObserver);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapCompletableCompletable(xi.e0<T> e0Var, dj.o<? super T, ? extends xi.g> oVar, boolean z10) {
        this.f34177a = e0Var;
        this.f34178b = oVar;
        this.f34179c = z10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f34177a.c(new FlatMapCompletableMainObserver(dVar, this.f34178b, this.f34179c));
    }

    @Override // fj.d
    public xi.z<T> b() {
        return kj.a.U(new ObservableFlatMapCompletable(this.f34177a, this.f34178b, this.f34179c));
    }
}
