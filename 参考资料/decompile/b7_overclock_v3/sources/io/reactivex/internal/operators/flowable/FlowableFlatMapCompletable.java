package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMapCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends xi.g> f33238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33239d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33240e;

    public static final class FlatMapCompletableMainSubscriber<T> extends BasicIntQueueSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public final bu.d<? super T> downstream;
        public final dj.o<? super T, ? extends xi.g> mapper;
        public final int maxConcurrency;
        public bu.e upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        public final class InnerConsumer extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            public InnerConsumer() {
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
                FlatMapCompletableMainSubscriber.this.c(this);
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                FlatMapCompletableMainSubscriber.this.h(this, th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public FlatMapCompletableMainSubscriber(bu.d<? super T> dVar, dj.o<? super T, ? extends xi.g> oVar, boolean z10, int i10) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            lazySet(1);
        }

        public void c(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer) {
            this.set.c(innerConsumer);
            onComplete();
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // fj.o
        public void clear() {
        }

        public void h(FlatMapCompletableMainSubscriber<T>.InnerConsumer innerConsumer, Throwable th2) {
            this.set.c(innerConsumer);
            onError(th2);
        }

        @Override // fj.o
        public boolean isEmpty() {
            return true;
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
                cancel();
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
                InnerConsumer innerConsumer = new InnerConsumer();
                if (this.cancelled || !this.set.b(innerConsumer)) {
                    return;
                }
                gVar.a(innerConsumer);
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

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            return null;
        }

        @Override // bu.e
        public void request(long j10) {
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            return i10 & 2;
        }
    }

    public FlowableFlatMapCompletable(xi.j<T> jVar, dj.o<? super T, ? extends xi.g> oVar, boolean z10, int i10) {
        super(jVar);
        this.f33238c = oVar;
        this.f33240e = z10;
        this.f33239d = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new FlatMapCompletableMainSubscriber(dVar, this.f33238c, this.f33240e, this.f33239d));
    }
}
