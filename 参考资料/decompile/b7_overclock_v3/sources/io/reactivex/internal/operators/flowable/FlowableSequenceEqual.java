package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSequenceEqual<T> extends xi.j<Boolean> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T> f33431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<? extends T> f33432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.d<? super T, ? super T> f33433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33434e;

    public static final class EqualCoordinator<T> extends DeferredScalarSubscription<Boolean> implements a {
        private static final long serialVersionUID = -6178010334400373240L;
        public final dj.d<? super T, ? super T> comparer;
        public final AtomicThrowable error;
        public final EqualSubscriber<T> first;
        public final EqualSubscriber<T> second;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public T f33435v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public T f33436v2;
        public final AtomicInteger wip;

        public EqualCoordinator(bu.d<? super Boolean> dVar, int i10, dj.d<? super T, ? super T> dVar2) {
            super(dVar);
            this.comparer = dVar2;
            this.wip = new AtomicInteger();
            this.first = new EqualSubscriber<>(this, i10);
            this.second = new EqualSubscriber<>(this, i10);
            this.error = new AtomicThrowable();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void a(Throwable th2) {
            if (this.error.a(th2)) {
                b();
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void b() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                fj.o<T> oVar = this.first.queue;
                fj.o<T> oVar2 = this.second.queue;
                if (oVar != null && oVar2 != null) {
                    while (!h()) {
                        if (this.error.get() != null) {
                            n();
                            this.downstream.onError(this.error.c());
                            return;
                        }
                        boolean z10 = this.first.done;
                        T tPoll = this.f33435v1;
                        if (tPoll == null) {
                            try {
                                tPoll = oVar.poll();
                                this.f33435v1 = tPoll;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                n();
                                this.error.a(th2);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                        boolean z11 = tPoll == null;
                        boolean z12 = this.second.done;
                        T tPoll2 = this.f33436v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = oVar2.poll();
                                this.f33436v2 = tPoll2;
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                n();
                                this.error.a(th3);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                        boolean z13 = tPoll2 == null;
                        if (z10 && z12 && z11 && z13) {
                            c(Boolean.TRUE);
                            return;
                        }
                        if (z10 && z12 && z11 != z13) {
                            n();
                            c(Boolean.FALSE);
                            return;
                        }
                        if (!z11 && !z13) {
                            try {
                                if (!this.comparer.a(tPoll, tPoll2)) {
                                    n();
                                    c(Boolean.FALSE);
                                    return;
                                } else {
                                    this.f33435v1 = null;
                                    this.f33436v2 = null;
                                    this.first.b();
                                    this.second.b();
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.b(th4);
                                n();
                                this.error.a(th4);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (h()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    n();
                    this.downstream.onError(this.error.c());
                    return;
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            super.cancel();
            this.first.a();
            this.second.a();
            if (this.wip.getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        public void n() {
            this.first.a();
            this.first.clear();
            this.second.a();
            this.second.clear();
        }

        public void o(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
            cVar.d(this.first);
            cVar2.d(this.second);
        }
    }

    public static final class EqualSubscriber<T> extends AtomicReference<bu.e> implements xi.o<T> {
        private static final long serialVersionUID = 4804128302091633067L;
        public volatile boolean done;
        public final int limit;
        public final a parent;
        public final int prefetch;
        public long produced;
        public volatile fj.o<T> queue;
        public int sourceMode;

        public EqualSubscriber(a aVar, int i10) {
            this.parent = aVar;
            this.limit = i10 - (i10 >> 2);
            this.prefetch = i10;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void b() {
            if (this.sourceMode != 1) {
                long j10 = this.produced + 1;
                if (j10 < this.limit) {
                    this.produced = j10;
                } else {
                    this.produced = 0L;
                    get().request(j10);
                }
            }
        }

        public void clear() {
            fj.o<T> oVar = this.queue;
            if (oVar != null) {
                oVar.clear();
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            this.parent.b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.a(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.sourceMode != 0 || this.queue.offer(t10)) {
                this.parent.b();
            } else {
                onError(new MissingBackpressureException());
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.b();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                eVar.request(this.prefetch);
            }
        }
    }

    public interface a {
        void a(Throwable th2);

        void b();
    }

    public FlowableSequenceEqual(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, dj.d<? super T, ? super T> dVar, int i10) {
        this.f33431b = cVar;
        this.f33432c = cVar2;
        this.f33433d = dVar;
        this.f33434e = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super Boolean> dVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(dVar, this.f33434e, this.f33433d);
        dVar.onSubscribe(equalCoordinator);
        equalCoordinator.o(this.f33431b, this.f33432c);
    }
}
