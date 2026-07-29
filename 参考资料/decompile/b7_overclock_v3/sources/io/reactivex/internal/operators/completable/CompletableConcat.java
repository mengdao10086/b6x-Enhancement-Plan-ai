package io.reactivex.internal.operators.completable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class CompletableConcat extends xi.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends xi.g> f33037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33038b;

    public static final class CompletableConcatSubscriber extends AtomicInteger implements xi.o<xi.g>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 9032184911934499404L;
        public volatile boolean active;
        public int consumed;
        public volatile boolean done;
        public final xi.d downstream;
        public final int limit;
        public final int prefetch;
        public fj.o<xi.g> queue;
        public int sourceFused;
        public bu.e upstream;
        public final ConcatInnerObserver inner = new ConcatInnerObserver(this);
        public final AtomicBoolean once = new AtomicBoolean();

        public static final class ConcatInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d {
            private static final long serialVersionUID = -5454794857847146511L;
            public final CompletableConcatSubscriber parent;

            public ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.parent = completableConcatSubscriber;
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                this.parent.b();
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                this.parent.c(th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }
        }

        public CompletableConcatSubscriber(xi.d dVar, int i10) {
            this.downstream = dVar;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            while (!isDisposed()) {
                if (!this.active) {
                    boolean z10 = this.done;
                    try {
                        xi.g gVarPoll = this.queue.poll();
                        boolean z11 = gVarPoll == null;
                        if (z10 && z11) {
                            if (this.once.compareAndSet(false, true)) {
                                this.downstream.onComplete();
                                return;
                            }
                            return;
                        } else if (!z11) {
                            this.active = true;
                            gVarPoll.a(this.inner);
                            f();
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        c(th2);
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        public void b() {
            this.active = false;
            a();
        }

        public void c(Throwable th2) {
            if (!this.once.compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                this.upstream.cancel();
                this.downstream.onError(th2);
            }
        }

        @Override // bu.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.g gVar) {
            if (this.sourceFused != 0 || this.queue.offer(gVar)) {
                a();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.inner);
        }

        public void f() {
            if (this.sourceFused != 1) {
                int i10 = this.consumed + 1;
                if (i10 != this.limit) {
                    this.consumed = i10;
                } else {
                    this.consumed = 0;
                    this.upstream.request(i10);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.inner.get());
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.once.compareAndSet(false, true)) {
                kj.a.Y(th2);
            } else {
                DisposableHelper.dispose(this.inner);
                this.downstream.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                int i10 = this.prefetch;
                long j10 = i10 == Integer.MAX_VALUE ? Long.MAX_VALUE : i10;
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceFused = iRequestFusion;
                        this.queue = lVar;
                        this.downstream.onSubscribe(this);
                        eVar.request(j10);
                        return;
                    }
                }
                if (this.prefetch == Integer.MAX_VALUE) {
                    this.queue = new io.reactivex.internal.queue.a(xi.j.Y());
                } else {
                    this.queue = new SpscArrayQueue(this.prefetch);
                }
                this.downstream.onSubscribe(this);
                eVar.request(j10);
            }
        }
    }

    public CompletableConcat(bu.c<? extends xi.g> cVar, int i10) {
        this.f33037a = cVar;
        this.f33038b = i10;
    }

    @Override // xi.a
    public void I0(xi.d dVar) {
        this.f33037a.d(new CompletableConcatSubscriber(dVar, this.f33038b));
    }
}
