package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMapEager<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends R>> f33204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33205d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33206e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ErrorMode f33207f;

    public static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements xi.o<T>, bu.e, hj.g<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        public volatile boolean cancelled;
        public volatile InnerQueuedSubscriber<R> current;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public final ErrorMode errorMode;
        public final dj.o<? super T, ? extends bu.c<? extends R>> mapper;
        public final int maxConcurrency;
        public final int prefetch;
        public final io.reactivex.internal.queue.a<InnerQueuedSubscriber<R>> subscribers;
        public bu.e upstream;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public ConcatMapEagerDelayErrorSubscriber(bu.d<? super R> dVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, int i11, ErrorMode errorMode) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode;
            this.subscribers = new io.reactivex.internal.queue.a<>(Math.min(i11, i10));
        }

        @Override // hj.g
        public void a(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.d();
            b();
        }

        @Override // hj.g
        public void b() {
            InnerQueuedSubscriber<R> innerQueuedSubscriberPoll;
            int i10;
            long j10;
            boolean z10;
            fj.o<R> oVarB;
            if (getAndIncrement() != 0) {
                return;
            }
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            bu.d<? super R> dVar = this.downstream;
            ErrorMode errorMode = this.errorMode;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested.get();
                if (innerQueuedSubscriber != null) {
                    innerQueuedSubscriberPoll = innerQueuedSubscriber;
                } else {
                    if (errorMode != ErrorMode.END && this.errors.get() != null) {
                        f();
                        dVar.onError(this.errors.c());
                        return;
                    }
                    boolean z11 = this.done;
                    innerQueuedSubscriberPoll = this.subscribers.poll();
                    if (z11 && innerQueuedSubscriberPoll == null) {
                        Throwable thC = this.errors.c();
                        if (thC != null) {
                            dVar.onError(thC);
                            return;
                        } else {
                            dVar.onComplete();
                            return;
                        }
                    }
                    if (innerQueuedSubscriberPoll != null) {
                        this.current = innerQueuedSubscriberPoll;
                    }
                }
                if (innerQueuedSubscriberPoll == null || (oVarB = innerQueuedSubscriberPoll.b()) == null) {
                    i10 = iAddAndGet;
                    j10 = 0;
                    z10 = false;
                } else {
                    i10 = iAddAndGet;
                    j10 = 0;
                    while (j10 != j11) {
                        if (this.cancelled) {
                            f();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            f();
                            dVar.onError(this.errors.c());
                            return;
                        }
                        boolean zA = innerQueuedSubscriberPoll.a();
                        try {
                            R rPoll = oVarB.poll();
                            boolean z12 = rPoll == null;
                            if (zA && z12) {
                                this.current = null;
                                this.upstream.request(1L);
                                innerQueuedSubscriberPoll = null;
                                z10 = true;
                                break;
                            }
                            if (z12) {
                                break;
                            }
                            dVar.onNext(rPoll);
                            j10++;
                            innerQueuedSubscriberPoll.c();
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            f();
                            dVar.onError(th2);
                            return;
                        }
                    }
                    z10 = false;
                    if (j10 == j11) {
                        if (this.cancelled) {
                            f();
                            return;
                        }
                        if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                            this.current = null;
                            innerQueuedSubscriberPoll.cancel();
                            f();
                            dVar.onError(this.errors.c());
                            return;
                        }
                        boolean zA2 = innerQueuedSubscriberPoll.a();
                        boolean zIsEmpty = oVarB.isEmpty();
                        if (zA2 && zIsEmpty) {
                            this.current = null;
                            this.upstream.request(1L);
                            innerQueuedSubscriberPoll = null;
                            z10 = true;
                        }
                    }
                }
                if (j10 != 0 && j11 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j10);
                }
                if (z10) {
                    innerQueuedSubscriber = innerQueuedSubscriberPoll;
                    iAddAndGet = i10;
                } else {
                    iAddAndGet = addAndGet(-i10);
                    if (iAddAndGet == 0) {
                        return;
                    } else {
                        innerQueuedSubscriber = innerQueuedSubscriberPoll;
                    }
                }
            }
        }

        @Override // hj.g
        public void c(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r10) {
            if (innerQueuedSubscriber.b().offer(r10)) {
                b();
            } else {
                innerQueuedSubscriber.cancel();
                d(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            h();
        }

        @Override // hj.g
        public void d(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            innerQueuedSubscriber.d();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            b();
        }

        public void f() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> innerQueuedSubscriberPoll = this.subscribers.poll();
                if (innerQueuedSubscriberPoll == null) {
                    return;
                } else {
                    innerQueuedSubscriberPoll.cancel();
                }
            }
        }

        public void h() {
            if (getAndIncrement() == 0) {
                do {
                    f();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                b();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                cVar.d(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    h();
                }
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
                eVar.request(i10 == Integer.MAX_VALUE ? Long.MAX_VALUE : i10);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public FlowableConcatMapEager(xi.j<T> jVar, dj.o<? super T, ? extends bu.c<? extends R>> oVar, int i10, int i11, ErrorMode errorMode) {
        super(jVar);
        this.f33204c = oVar;
        this.f33205d = i10;
        this.f33206e = i11;
        this.f33207f = errorMode;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33524b.j6(new ConcatMapEagerDelayErrorSubscriber(dVar, this.f33204c, this.f33205d, this.f33206e, this.f33207f));
    }
}
