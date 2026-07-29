package io.reactivex.internal.operators.parallel;

import fj.l;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelFromPublisher<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f34826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34828c;

    public static final class ParallelDispatcher<T> extends AtomicInteger implements o<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final long[] emissions;
        public Throwable error;
        public int index;
        public final int limit;
        public final int prefetch;
        public int produced;
        public fj.o<T> queue;
        public final AtomicLongArray requests;
        public int sourceMode;
        public final AtomicInteger subscriberCount = new AtomicInteger();
        public final bu.d<? super T>[] subscribers;
        public bu.e upstream;

        public final class a implements bu.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f34829a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f34830b;

            public a(int i10, int i11) {
                this.f34829a = i10;
                this.f34830b = i11;
            }

            @Override // bu.e
            public void cancel() {
                if (ParallelDispatcher.this.requests.compareAndSet(this.f34829a + this.f34830b, 0L, 1L)) {
                    ParallelDispatcher parallelDispatcher = ParallelDispatcher.this;
                    int i10 = this.f34830b;
                    parallelDispatcher.a(i10 + i10);
                }
            }

            @Override // bu.e
            public void request(long j10) {
                long j11;
                if (SubscriptionHelper.validate(j10)) {
                    AtomicLongArray atomicLongArray = ParallelDispatcher.this.requests;
                    do {
                        j11 = atomicLongArray.get(this.f34829a);
                        if (j11 == Long.MAX_VALUE) {
                            return;
                        }
                    } while (!atomicLongArray.compareAndSet(this.f34829a, j11, io.reactivex.internal.util.b.c(j11, j10)));
                    if (ParallelDispatcher.this.subscriberCount.get() == this.f34830b) {
                        ParallelDispatcher.this.b();
                    }
                }
            }
        }

        public ParallelDispatcher(bu.d<? super T>[] dVarArr, int i10) {
            this.subscribers = dVarArr;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
            int length = dVarArr.length;
            int i11 = length + length;
            AtomicLongArray atomicLongArray = new AtomicLongArray(i11 + 1);
            this.requests = atomicLongArray;
            atomicLongArray.lazySet(i11, length);
            this.emissions = new long[length];
        }

        public void a(int i10) {
            if (this.requests.decrementAndGet(i10) == 0) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.sourceMode == 1) {
                d();
            } else {
                c();
            }
        }

        public void c() {
            Throwable th2;
            fj.o<T> oVar = this.queue;
            bu.d<? super T>[] dVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int i11 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                int i12 = 0;
                int i13 = 0;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (z10 && (th2 = this.error) != null) {
                        oVar.clear();
                        int length2 = dVarArr.length;
                        while (i12 < length2) {
                            dVarArr[i12].onError(th2);
                            i12++;
                        }
                        return;
                    }
                    boolean zIsEmpty = oVar.isEmpty();
                    if (z10 && zIsEmpty) {
                        int length3 = dVarArr.length;
                        while (i12 < length3) {
                            dVarArr[i12].onComplete();
                            i12++;
                        }
                        return;
                    }
                    if (!zIsEmpty) {
                        long j10 = atomicLongArray.get(i10);
                        long j11 = jArr[i10];
                        if (j10 == j11 || atomicLongArray.get(length + i10) != 0) {
                            i13++;
                        } else {
                            try {
                                T tPoll = oVar.poll();
                                if (tPoll != null) {
                                    dVarArr[i10].onNext(tPoll);
                                    jArr[i10] = j11 + 1;
                                    i11++;
                                    if (i11 == this.limit) {
                                        this.upstream.request(i11);
                                        i11 = 0;
                                    }
                                    i13 = 0;
                                }
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                this.upstream.cancel();
                                int length4 = dVarArr.length;
                                while (i12 < length4) {
                                    dVarArr[i12].onError(th3);
                                    i12++;
                                }
                                return;
                            }
                        }
                        i10++;
                        if (i10 == length) {
                            i10 = 0;
                        }
                        if (i13 == length) {
                        }
                    }
                    int i14 = get();
                    if (i14 == iAddAndGet) {
                        this.index = i10;
                        this.produced = i11;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i14;
                    }
                }
                oVar.clear();
                return;
            }
        }

        public void d() {
            fj.o<T> oVar = this.queue;
            bu.d<? super T>[] dVarArr = this.subscribers;
            AtomicLongArray atomicLongArray = this.requests;
            long[] jArr = this.emissions;
            int length = jArr.length;
            int i10 = this.index;
            int iAddAndGet = 1;
            while (true) {
                int i11 = 0;
                int i12 = 0;
                while (!this.cancelled) {
                    if (oVar.isEmpty()) {
                        int length2 = dVarArr.length;
                        while (i11 < length2) {
                            dVarArr[i11].onComplete();
                            i11++;
                        }
                        return;
                    }
                    long j10 = atomicLongArray.get(i10);
                    long j11 = jArr[i10];
                    if (j10 == j11 || atomicLongArray.get(length + i10) != 0) {
                        i12++;
                    } else {
                        try {
                            T tPoll = oVar.poll();
                            if (tPoll == null) {
                                int length3 = dVarArr.length;
                                while (i11 < length3) {
                                    dVarArr[i11].onComplete();
                                    i11++;
                                }
                                return;
                            }
                            dVarArr[i10].onNext(tPoll);
                            jArr[i10] = j11 + 1;
                            i12 = 0;
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.upstream.cancel();
                            int length4 = dVarArr.length;
                            while (i11 < length4) {
                                dVarArr[i11].onError(th2);
                                i11++;
                            }
                            return;
                        }
                    }
                    i10++;
                    if (i10 == length) {
                        i10 = 0;
                    }
                    if (i12 == length) {
                        int i13 = get();
                        if (i13 == iAddAndGet) {
                            this.index = i10;
                            iAddAndGet = addAndGet(-iAddAndGet);
                            if (iAddAndGet == 0) {
                                return;
                            }
                        } else {
                            iAddAndGet = i13;
                        }
                    }
                }
                oVar.clear();
                return;
            }
        }

        public void f() {
            bu.d<? super T>[] dVarArr = this.subscribers;
            int length = dVarArr.length;
            int i10 = 0;
            while (i10 < length && !this.cancelled) {
                int i11 = i10 + 1;
                this.subscriberCount.lazySet(i11);
                dVarArr[i10].onSubscribe(new a(i10, length));
                i10 = i11;
            }
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.sourceMode != 0 || this.queue.offer(t10)) {
                b();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof l) {
                    l lVar = (l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.done = true;
                        f();
                        b();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        f();
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                f();
                eVar.request(this.prefetch);
            }
        }
    }

    public ParallelFromPublisher(bu.c<? extends T> cVar, int i10, int i11) {
        this.f34826a = cVar;
        this.f34827b = i10;
        this.f34828c = i11;
    }

    @Override // jj.a
    public int F() {
        return this.f34827b;
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            this.f34826a.d(new ParallelDispatcher(dVarArr, this.f34828c));
        }
    }
}
