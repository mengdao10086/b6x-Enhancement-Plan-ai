package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends xi.a implements fj.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.g> f33242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33244d;

    public static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements xi.o<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8443155186132538303L;
        public final boolean delayErrors;
        public volatile boolean disposed;
        public final xi.d downstream;
        public final dj.o<? super T, ? extends xi.g> mapper;
        public final int maxConcurrency;
        public bu.e upstream;
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
                FlatMapCompletableMainSubscriber.this.a(this);
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                FlatMapCompletableMainSubscriber.this.b(this, th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public FlatMapCompletableMainSubscriber(xi.d dVar, dj.o<? super T, ? extends xi.g> oVar, boolean z10, int i10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            lazySet(1);
        }

        public void a(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        public void b(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th2) {
            this.set.c(innerObserver);
            onError(th2);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // bu.d
        public void onComplete() {
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
            } else {
                Throwable thC = this.errors.c();
                if (thC != null) {
                    this.downstream.onError(thC);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (!this.delayErrors) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.downstream.onError(this.errors.c());
                    return;
                }
                return;
            }
            if (decrementAndGet() == 0) {
                this.downstream.onError(this.errors.c());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
        }

        @Override // bu.d
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
                this.upstream.cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    eVar.request(Long.MAX_VALUE);
                } else {
                    eVar.request(i10);
                }
            }
        }
    }

    public FlowableFlatMapCompletableCompletable(xi.j<T> jVar, dj.o<? super T, ? extends xi.g> oVar, boolean z10, int i10) {
        this.f33241a = jVar;
        this.f33242b = oVar;
        this.f33244d = z10;
        this.f33243c = i10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33241a.j6(new FlatMapCompletableMainSubscriber(dVar, this.f33242b, this.f33244d, this.f33243c));
    }

    @Override // fj.b
    public xi.j<T> d() {
        return kj.a.S(new FlowableFlatMapCompletable(this.f33241a, this.f33242b, this.f33244d, this.f33243c));
    }
}
