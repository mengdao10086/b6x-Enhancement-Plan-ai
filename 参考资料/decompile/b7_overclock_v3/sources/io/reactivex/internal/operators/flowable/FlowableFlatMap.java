package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableFlatMap<T, U> extends a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<? extends U>> f33231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33234f;

    public static final class InnerSubscriber<T, U> extends AtomicReference<bu.e> implements xi.o<U>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4606175640614850599L;
        public final int bufferSize;
        public volatile boolean done;
        public int fusionMode;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public final long f33235id;
        public final int limit;
        public final MergeSubscriber<T, U> parent;
        public long produced;
        public volatile fj.o<U> queue;

        public InnerSubscriber(MergeSubscriber<T, U> mergeSubscriber, long j10) {
            this.f33235id = j10;
            this.parent = mergeSubscriber;
            int i10 = mergeSubscriber.bufferSize;
            this.bufferSize = i10;
            this.limit = i10 >> 2;
        }

        public void a(long j10) {
            if (this.fusionMode != 1) {
                long j11 = this.produced + j10;
                if (j11 < this.limit) {
                    this.produced = j11;
                } else {
                    this.produced = 0L;
                    get().request(j11);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            this.parent.f();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            lazySet(SubscriptionHelper.CANCELLED);
            this.parent.l(this, th2);
        }

        @Override // bu.d
        public void onNext(U u6) {
            if (this.fusionMode != 2) {
                this.parent.o(u6, this);
            } else {
                this.parent.f();
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.setOnce(this, eVar)) {
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        this.parent.f();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.fusionMode = iRequestFusion;
                        this.queue = lVar;
                    }
                }
                eVar.request(this.bufferSize);
            }
        }
    }

    public static final class MergeSubscriber<T, U> extends AtomicInteger implements xi.o<T>, bu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f33236a = new InnerSubscriber[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final InnerSubscriber<?, ?>[] f33237b = new InnerSubscriber[0];
        private static final long serialVersionUID = -2117620485640801370L;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final bu.d<? super U> downstream;
        public final AtomicThrowable errs = new AtomicThrowable();
        public long lastId;
        public int lastIndex;
        public final dj.o<? super T, ? extends bu.c<? extends U>> mapper;
        public final int maxConcurrency;
        public volatile fj.n<U> queue;
        public final AtomicLong requested;
        public int scalarEmitted;
        public final int scalarLimit;
        public final AtomicReference<InnerSubscriber<?, ?>[]> subscribers;
        public long uniqueId;
        public bu.e upstream;

        public MergeSubscriber(bu.d<? super U> dVar, dj.o<? super T, ? extends bu.c<? extends U>> oVar, boolean z10, int i10, int i11) {
            AtomicReference<InnerSubscriber<?, ?>[]> atomicReference = new AtomicReference<>();
            this.subscribers = atomicReference;
            this.requested = new AtomicLong();
            this.downstream = dVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            this.bufferSize = i11;
            this.scalarLimit = Math.max(1, i10 >> 1);
            atomicReference.lazySet(f33236a);
        }

        public boolean a(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                if (innerSubscriberArr == f33237b) {
                    innerSubscriber.dispose();
                    return false;
                }
                int length = innerSubscriberArr.length;
                innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, (InnerSubscriber<?, ?>[]) innerSubscriberArr2));
            return true;
        }

        public boolean b() {
            if (this.cancelled) {
                c();
                return true;
            }
            if (this.delayErrors || this.errs.get() == null) {
                return false;
            }
            c();
            Throwable thC = this.errs.c();
            if (thC != ExceptionHelper.f35249a) {
                this.downstream.onError(thC);
            }
            return true;
        }

        public void c() {
            fj.n<U> nVar = this.queue;
            if (nVar != null) {
                nVar.clear();
            }
        }

        @Override // bu.e
        public void cancel() {
            fj.n<U> nVar;
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            d();
            if (getAndIncrement() != 0 || (nVar = this.queue) == null) {
                return;
            }
            nVar.clear();
        }

        public void d() {
            InnerSubscriber<?, ?>[] andSet;
            InnerSubscriber<?, ?>[] innerSubscriberArr = this.subscribers.get();
            InnerSubscriber<?, ?>[] innerSubscriberArr2 = f33237b;
            if (innerSubscriberArr == innerSubscriberArr2 || (andSet = this.subscribers.getAndSet(innerSubscriberArr2)) == innerSubscriberArr2) {
                return;
            }
            for (InnerSubscriber<?, ?> innerSubscriber : andSet) {
                innerSubscriber.dispose();
            }
            Throwable thC = this.errs.c();
            if (thC == null || thC == ExceptionHelper.f35249a) {
                return;
            }
            kj.a.Y(thC);
        }

        public void f() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void h() {
            long j10;
            long j11;
            boolean z10;
            InnerSubscriber<T, U>[] innerSubscriberArr;
            int i10;
            long j12;
            Object obj;
            bu.d<? super U> dVar = this.downstream;
            int iAddAndGet = 1;
            while (!b()) {
                fj.n<U> nVar = this.queue;
                long jAddAndGet = this.requested.get();
                boolean z11 = jAddAndGet == Long.MAX_VALUE;
                long j13 = 0;
                long j14 = 0;
                if (nVar != null) {
                    do {
                        long j15 = 0;
                        obj = null;
                        while (true) {
                            if (jAddAndGet == 0) {
                                break;
                            }
                            U uPoll = nVar.poll();
                            if (b()) {
                                return;
                            }
                            if (uPoll == null) {
                                obj = uPoll;
                                break;
                            }
                            dVar.onNext(uPoll);
                            j14++;
                            j15++;
                            jAddAndGet--;
                            obj = uPoll;
                        }
                        if (j15 != 0) {
                            jAddAndGet = z11 ? Long.MAX_VALUE : this.requested.addAndGet(-j15);
                        }
                        if (jAddAndGet == 0) {
                            break;
                        }
                    } while (obj != null);
                }
                boolean z12 = this.done;
                fj.n<U> nVar2 = this.queue;
                InnerSubscriber<?, ?>[] innerSubscriberArr2 = this.subscribers.get();
                int length = innerSubscriberArr2.length;
                if (z12 && ((nVar2 == null || nVar2.isEmpty()) && length == 0)) {
                    Throwable thC = this.errs.c();
                    if (thC != ExceptionHelper.f35249a) {
                        if (thC == null) {
                            dVar.onComplete();
                            return;
                        } else {
                            dVar.onError(thC);
                            return;
                        }
                    }
                    return;
                }
                int i11 = iAddAndGet;
                if (length != 0) {
                    long j16 = this.lastId;
                    int i12 = this.lastIndex;
                    if (length <= i12 || innerSubscriberArr2[i12].f33235id != j16) {
                        if (length <= i12) {
                            i12 = 0;
                        }
                        for (int i13 = 0; i13 < length && innerSubscriberArr2[i12].f33235id != j16; i13++) {
                            i12++;
                            if (i12 == length) {
                                i12 = 0;
                            }
                        }
                        this.lastIndex = i12;
                        this.lastId = innerSubscriberArr2[i12].f33235id;
                    }
                    int i14 = i12;
                    boolean z13 = false;
                    int i15 = 0;
                    while (true) {
                        if (i15 >= length) {
                            innerSubscriberArr = innerSubscriberArr2;
                            z10 = z13;
                            break;
                        }
                        if (b()) {
                            return;
                        }
                        InnerSubscriber<T, U> innerSubscriber = innerSubscriberArr2[i14];
                        U uPoll2 = null;
                        while (!b()) {
                            fj.o<U> oVar = innerSubscriber.queue;
                            if (oVar == null) {
                                innerSubscriberArr = innerSubscriberArr2;
                                i10 = length;
                            } else {
                                innerSubscriberArr = innerSubscriberArr2;
                                i10 = length;
                                long j17 = j13;
                                while (jAddAndGet != j13) {
                                    try {
                                        uPoll2 = oVar.poll();
                                        if (uPoll2 == null) {
                                            break;
                                        }
                                        dVar.onNext(uPoll2);
                                        if (b()) {
                                            return;
                                        }
                                        jAddAndGet--;
                                        j17++;
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.b(th2);
                                        innerSubscriber.dispose();
                                        this.errs.a(th2);
                                        if (!this.delayErrors) {
                                            this.upstream.cancel();
                                        }
                                        if (b()) {
                                            return;
                                        }
                                        n(innerSubscriber);
                                        i15++;
                                        length = i10;
                                        z13 = true;
                                    }
                                }
                                if (j17 != j13) {
                                    jAddAndGet = !z11 ? this.requested.addAndGet(-j17) : Long.MAX_VALUE;
                                    innerSubscriber.a(j17);
                                    j12 = 0;
                                } else {
                                    j12 = j13;
                                }
                                if (jAddAndGet != j12 && uPoll2 != null) {
                                    innerSubscriberArr2 = innerSubscriberArr;
                                    length = i10;
                                    j13 = 0;
                                }
                            }
                            boolean z14 = innerSubscriber.done;
                            fj.o<U> oVar2 = innerSubscriber.queue;
                            if (z14 && (oVar2 == null || oVar2.isEmpty())) {
                                n(innerSubscriber);
                                if (b()) {
                                    return;
                                }
                                j14++;
                                z13 = true;
                            }
                            if (jAddAndGet == 0) {
                                z10 = z13;
                                break;
                            }
                            i14++;
                            length = i10;
                            if (i14 == length) {
                                i14 = 0;
                            }
                            i15++;
                            innerSubscriberArr2 = innerSubscriberArr;
                            j13 = 0;
                        }
                        return;
                    }
                    this.lastIndex = i14;
                    this.lastId = innerSubscriberArr[i14].f33235id;
                    j11 = j14;
                    j10 = 0;
                } else {
                    j10 = 0;
                    j11 = j14;
                    z10 = false;
                }
                if (j11 != j10 && !this.cancelled) {
                    this.upstream.request(j11);
                }
                if (z10) {
                    iAddAndGet = i11;
                } else {
                    iAddAndGet = addAndGet(-i11);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        public fj.o<U> i(InnerSubscriber<T, U> innerSubscriber) {
            fj.o<U> oVar = innerSubscriber.queue;
            if (oVar != null) {
                return oVar;
            }
            SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.bufferSize);
            innerSubscriber.queue = spscArrayQueue;
            return spscArrayQueue;
        }

        public fj.o<U> k() {
            fj.n<U> aVar = this.queue;
            if (aVar == null) {
                aVar = this.maxConcurrency == Integer.MAX_VALUE ? new io.reactivex.internal.queue.a<>(this.bufferSize) : new SpscArrayQueue<>(this.maxConcurrency);
                this.queue = aVar;
            }
            return aVar;
        }

        public void l(InnerSubscriber<T, U> innerSubscriber, Throwable th2) {
            if (!this.errs.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            innerSubscriber.done = true;
            if (!this.delayErrors) {
                this.upstream.cancel();
                for (InnerSubscriber<?, ?> innerSubscriber2 : this.subscribers.getAndSet(f33237b)) {
                    innerSubscriber2.dispose();
                }
            }
            f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void n(InnerSubscriber<T, U> innerSubscriber) {
            InnerSubscriber<?, ?>[] innerSubscriberArr;
            InnerSubscriber<?, ?>[] innerSubscriberArr2;
            do {
                innerSubscriberArr = this.subscribers.get();
                int length = innerSubscriberArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (innerSubscriberArr[i11] == innerSubscriber) {
                        i10 = i11;
                        break;
                    }
                    i11++;
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    innerSubscriberArr2 = f33236a;
                } else {
                    InnerSubscriber<?, ?>[] innerSubscriberArr3 = new InnerSubscriber[length - 1];
                    System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr3, 0, i10);
                    System.arraycopy(innerSubscriberArr, i10 + 1, innerSubscriberArr3, i10, (length - i10) - 1);
                    innerSubscriberArr2 = innerSubscriberArr3;
                }
            } while (!this.subscribers.compareAndSet(innerSubscriberArr, innerSubscriberArr2));
        }

        public void o(U u6, InnerSubscriber<T, U> innerSubscriber) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j10 = this.requested.get();
                fj.o<U> oVarI = innerSubscriber.queue;
                if (j10 == 0 || !(oVarI == null || oVarI.isEmpty())) {
                    if (oVarI == null) {
                        oVarI = i(innerSubscriber);
                    }
                    if (!oVarI.offer(u6)) {
                        onError(new MissingBackpressureException("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u6);
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    innerSubscriber.a(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                fj.o spscArrayQueue = innerSubscriber.queue;
                if (spscArrayQueue == null) {
                    spscArrayQueue = new SpscArrayQueue(this.bufferSize);
                    innerSubscriber.queue = spscArrayQueue;
                }
                if (!spscArrayQueue.offer(u6)) {
                    onError(new MissingBackpressureException("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            h();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            f();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            if (!this.errs.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            if (!this.delayErrors) {
                for (InnerSubscriber<?, ?> innerSubscriber : this.subscribers.getAndSet(f33237b)) {
                    innerSubscriber.dispose();
                }
            }
            f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.mapper.apply(t10), "The mapper returned a null Publisher");
                if (!(cVar instanceof Callable)) {
                    long j10 = this.uniqueId;
                    this.uniqueId = 1 + j10;
                    InnerSubscriber innerSubscriber = new InnerSubscriber(this, j10);
                    if (a(innerSubscriber)) {
                        cVar.d(innerSubscriber);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) cVar).call();
                    if (objCall != null) {
                        p(objCall);
                        return;
                    }
                    if (this.maxConcurrency == Integer.MAX_VALUE || this.cancelled) {
                        return;
                    }
                    int i10 = this.scalarEmitted + 1;
                    this.scalarEmitted = i10;
                    int i11 = this.scalarLimit;
                    if (i10 == i11) {
                        this.scalarEmitted = 0;
                        this.upstream.request(i11);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.errs.a(th2);
                    f();
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.upstream.cancel();
                onError(th3);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                if (this.cancelled) {
                    return;
                }
                int i10 = this.maxConcurrency;
                if (i10 == Integer.MAX_VALUE) {
                    eVar.request(Long.MAX_VALUE);
                } else {
                    eVar.request(i10);
                }
            }
        }

        public void p(U u6) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j10 = this.requested.get();
                fj.o<U> oVarK = this.queue;
                if (j10 == 0 || !(oVarK == null || oVarK.isEmpty())) {
                    if (oVarK == null) {
                        oVarK = k();
                    }
                    if (!oVarK.offer(u6)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.downstream.onNext(u6);
                    if (j10 != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i10 = this.scalarEmitted + 1;
                        this.scalarEmitted = i10;
                        int i11 = this.scalarLimit;
                        if (i10 == i11) {
                            this.scalarEmitted = 0;
                            this.upstream.request(i11);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!k().offer(u6)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            h();
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                f();
            }
        }
    }

    public FlowableFlatMap(xi.j<T> jVar, dj.o<? super T, ? extends bu.c<? extends U>> oVar, boolean z10, int i10, int i11) {
        super(jVar);
        this.f33231c = oVar;
        this.f33232d = z10;
        this.f33233e = i10;
        this.f33234f = i11;
    }

    public static <T, U> xi.o<T> M8(bu.d<? super U> dVar, dj.o<? super T, ? extends bu.c<? extends U>> oVar, boolean z10, int i10, int i11) {
        return new MergeSubscriber(dVar, oVar, z10, i10, i11);
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        if (w0.b(this.f33524b, dVar, this.f33231c)) {
            return;
        }
        this.f33524b.j6(M8(dVar, this.f33231c, this.f33232d, this.f33233e, this.f33234f));
    }
}
