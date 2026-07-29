package io.reactivex.internal.operators.completable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableMerge extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends xi.g> f33051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33053c;

    public static final class CompletableMergeSubscriber extends AtomicInteger implements xi.o<xi.g>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -2108443387387077490L;
        public final boolean delayErrors;
        public final xi.d downstream;
        public final int maxConcurrency;
        public bu.e upstream;
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        public final AtomicThrowable error = new AtomicThrowable();

        public final class MergeInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d, io.reactivex.disposables.b {
            private static final long serialVersionUID = 251330541679988317L;

            public MergeInnerObserver() {
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
                CompletableMergeSubscriber.this.a(this);
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                CompletableMergeSubscriber.this.b(this, th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public CompletableMergeSubscriber(xi.d dVar, int i10, boolean z10) {
            this.downstream = dVar;
            this.maxConcurrency = i10;
            this.delayErrors = z10;
            lazySet(1);
        }

        public void a(MergeInnerObserver mergeInnerObserver) {
            this.set.c(mergeInnerObserver);
            if (decrementAndGet() != 0) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1L);
                }
            } else {
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    this.downstream.onError(th2);
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        public void b(MergeInnerObserver mergeInnerObserver, Throwable th2) {
            this.set.c(mergeInnerObserver);
            if (!this.delayErrors) {
                this.upstream.cancel();
                this.set.dispose();
                if (!this.error.a(th2)) {
                    kj.a.Y(th2);
                    return;
                } else {
                    if (getAndSet(0) > 0) {
                        this.downstream.onError(this.error.c());
                        return;
                    }
                    return;
                }
            }
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else if (decrementAndGet() == 0) {
                this.downstream.onError(this.error.c());
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1L);
            }
        }

        @Override // bu.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.g gVar) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.set.b(mergeInnerObserver);
            gVar.a(mergeInnerObserver);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // bu.d
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.downstream.onError(this.error.c());
                } else {
                    this.downstream.onComplete();
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.delayErrors) {
                if (!this.error.a(th2)) {
                    kj.a.Y(th2);
                    return;
                } else {
                    if (decrementAndGet() == 0) {
                        this.downstream.onError(this.error.c());
                        return;
                    }
                    return;
                }
            }
            this.set.dispose();
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
            } else if (getAndSet(0) > 0) {
                this.downstream.onError(this.error.c());
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

    public CompletableMerge(bu.c<? extends xi.g> cVar, int i10, boolean z10) {
        this.f33051a = cVar;
        this.f33052b = i10;
        this.f33053c = z10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33051a.d(new CompletableMergeSubscriber(dVar, this.f33052b, this.f33053c));
    }
}
