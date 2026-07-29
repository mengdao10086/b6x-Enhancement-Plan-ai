package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.p0;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableCombineLatest<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @bj.f
    public final bu.c<? extends T>[] f33192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @bj.f
    public final Iterable<? extends bu.c<? extends T>> f33193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super Object[], ? extends R> f33194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f33196f;

    public static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        private static final long serialVersionUID = -5082275438355852221L;
        public volatile boolean cancelled;
        public final dj.o<? super Object[], ? extends R> combiner;
        public int completedSources;
        public final boolean delayErrors;
        public volatile boolean done;
        public final bu.d<? super R> downstream;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public int nonEmptySources;
        public boolean outputFused;
        public final io.reactivex.internal.queue.a<Object> queue;
        public final AtomicLong requested;
        public final CombineLatestInnerSubscriber<T>[] subscribers;

        public CombineLatestCoordinator(bu.d<? super R> dVar, dj.o<? super Object[], ? extends R> oVar, int i10, int i11, boolean z10) {
            this.downstream = dVar;
            this.combiner = oVar;
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = new CombineLatestInnerSubscriber[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                combineLatestInnerSubscriberArr[i12] = new CombineLatestInnerSubscriber<>(this, i12, i11);
            }
            this.subscribers = combineLatestInnerSubscriberArr;
            this.latest = new Object[i10];
            this.queue = new io.reactivex.internal.queue.a<>(i11);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
            this.delayErrors = z10;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                n();
            } else {
                k();
            }
        }

        public void c() {
            for (CombineLatestInnerSubscriber<T> combineLatestInnerSubscriber : this.subscribers) {
                combineLatestInnerSubscriber.a();
            }
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            c();
        }

        @Override // fj.o
        public void clear() {
            this.queue.clear();
        }

        public boolean h(boolean z10, boolean z11, bu.d<?> dVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                c();
                aVar.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayErrors) {
                if (!z11) {
                    return false;
                }
                c();
                Throwable thC = ExceptionHelper.c(this.error);
                if (thC == null || thC == ExceptionHelper.f35249a) {
                    dVar.onComplete();
                } else {
                    dVar.onError(thC);
                }
                return true;
            }
            Throwable thC2 = ExceptionHelper.c(this.error);
            if (thC2 != null && thC2 != ExceptionHelper.f35249a) {
                c();
                aVar.clear();
                dVar.onError(thC2);
                return true;
            }
            if (!z11) {
                return false;
            }
            c();
            dVar.onComplete();
            return true;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public void k() {
            bu.d<? super R> dVar = this.downstream;
            io.reactivex.internal.queue.a<?> aVar = this.queue;
            int iAddAndGet = 1;
            do {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    boolean z10 = this.done;
                    Object objPoll = aVar.poll();
                    boolean z11 = objPoll == null;
                    if (h(z10, z11, dVar, aVar)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    try {
                        dVar.onNext((Object) io.reactivex.internal.functions.a.g(this.combiner.apply((Object[]) aVar.poll()), "The combiner returned a null value"));
                        ((CombineLatestInnerSubscriber) objPoll).b();
                        j11++;
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        c();
                        ExceptionHelper.a(this.error, th2);
                        dVar.onError(ExceptionHelper.c(this.error));
                        return;
                    }
                }
                if (j11 == j10 && h(this.done, aVar.isEmpty(), dVar, aVar)) {
                    return;
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j11);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void n() {
            bu.d<? super R> dVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    aVar.clear();
                    dVar.onError(th2);
                    return;
                }
                boolean z10 = this.done;
                boolean zIsEmpty = aVar.isEmpty();
                if (!zIsEmpty) {
                    dVar.onNext(null);
                }
                if (z10 && zIsEmpty) {
                    dVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar.clear();
        }

        public void o(int i10) {
            int i11;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr[i10] != null && (i11 = this.completedSources + 1) != objArr.length) {
                    this.completedSources = i11;
                } else {
                    this.done = true;
                    b();
                }
            }
        }

        public void p(int i10, Throwable th2) {
            if (!ExceptionHelper.a(this.error, th2)) {
                kj.a.Y(th2);
            } else {
                if (this.delayErrors) {
                    o(i10);
                    return;
                }
                c();
                this.done = true;
                b();
            }
        }

        @Override // fj.o
        @bj.f
        public R poll() throws Exception {
            Object objPoll = this.queue.poll();
            if (objPoll == null) {
                return null;
            }
            R r10 = (R) io.reactivex.internal.functions.a.g(this.combiner.apply((Object[]) this.queue.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) objPoll).b();
            return r10;
        }

        public void q(int i10, T t10) {
            boolean z10;
            synchronized (this) {
                Object[] objArr = this.latest;
                int i11 = this.nonEmptySources;
                if (objArr[i10] == null) {
                    i11++;
                    this.nonEmptySources = i11;
                }
                objArr[i10] = t10;
                if (objArr.length == i11) {
                    this.queue.offer(this.subscribers[i10], objArr.clone());
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            if (z10) {
                this.subscribers[i10].b();
            } else {
                b();
            }
        }

        public void r(bu.c<? extends T>[] cVarArr, int i10) {
            CombineLatestInnerSubscriber<T>[] combineLatestInnerSubscriberArr = this.subscribers;
            for (int i11 = 0; i11 < i10 && !this.done && !this.cancelled; i11++) {
                cVarArr[i11].d(combineLatestInnerSubscriberArr[i11]);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 4) != 0) {
                return 0;
            }
            int i11 = i10 & 2;
            this.outputFused = i11 != 0;
            return i11;
        }
    }

    public static final class CombineLatestInnerSubscriber<T> extends AtomicReference<bu.e> implements xi.o<T> {
        private static final long serialVersionUID = -8730235182291002949L;
        public final int index;
        public final int limit;
        public final CombineLatestCoordinator<T, ?> parent;
        public final int prefetch;
        public int produced;

        public CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i10, int i11) {
            this.parent = combineLatestCoordinator;
            this.index = i10;
            this.prefetch = i11;
            this.limit = i11 - (i11 >> 2);
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        public void b() {
            int i10 = this.produced + 1;
            if (i10 != this.limit) {
                this.produced = i10;
            } else {
                this.produced = 0;
                get().request(i10);
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.parent.o(this.index);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.p(this.index, th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.parent.q(this.index, t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, this.prefetch);
        }
    }

    public final class a implements dj.o<T, R> {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // dj.o
        public R apply(T t10) throws Exception {
            return FlowableCombineLatest.this.f33194d.apply(new Object[]{t10});
        }
    }

    public FlowableCombineLatest(@bj.e bu.c<? extends T>[] cVarArr, @bj.e dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f33192b = cVarArr;
        this.f33193c = null;
        this.f33194d = oVar;
        this.f33195e = i10;
        this.f33196f = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        int length;
        bu.c<? extends T>[] cVarArr = this.f33192b;
        if (cVarArr == null) {
            cVarArr = new bu.c[8];
            try {
                Iterator it2 = (Iterator) io.reactivex.internal.functions.a.g(this.f33193c.iterator(), "The iterator returned is null");
                length = 0;
                while (it2.hasNext()) {
                    try {
                        try {
                            bu.c<? extends T> cVar = (bu.c) io.reactivex.internal.functions.a.g(it2.next(), "The publisher returned by the iterator is null");
                            if (length == cVarArr.length) {
                                bu.c<? extends T>[] cVarArr2 = new bu.c[(length >> 2) + length];
                                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                                cVarArr = cVarArr2;
                            }
                            cVarArr[length] = cVar;
                            length++;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            EmptySubscription.error(th2, dVar);
                            return;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        EmptySubscription.error(th3, dVar);
                        return;
                    }
                }
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                EmptySubscription.error(th4, dVar);
                return;
            }
        } else {
            length = cVarArr.length;
        }
        int i10 = length;
        if (i10 == 0) {
            EmptySubscription.complete(dVar);
        } else {
            if (i10 == 1) {
                cVarArr[0].d(new p0.b(dVar, new a()));
                return;
            }
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(dVar, this.f33194d, i10, this.f33195e, this.f33196f);
            dVar.onSubscribe(combineLatestCoordinator);
            combineLatestCoordinator.r(cVarArr, i10);
        }
    }

    public FlowableCombineLatest(@bj.e Iterable<? extends bu.c<? extends T>> iterable, @bj.e dj.o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f33192b = null;
        this.f33193c = iterable;
        this.f33194d = oVar;
        this.f33195e = i10;
        this.f33196f = z10;
    }
}
