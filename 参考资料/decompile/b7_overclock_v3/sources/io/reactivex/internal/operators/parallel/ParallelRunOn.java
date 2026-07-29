package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import xi.h0;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelRunOn<T> extends jj.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jj.a<? extends T> f34840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f34841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f34842c;

    public static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements o<T>, bu.e, Runnable {
        private static final long serialVersionUID = 9222303586456402150L;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public final int prefetch;
        public final SpscArrayQueue<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public bu.e upstream;
        public final h0.c worker;

        public BaseRunOnSubscriber(int i10, SpscArrayQueue<T> spscArrayQueue, h0.c cVar) {
            this.prefetch = i10;
            this.queue = spscArrayQueue;
            this.limit = i10 - (i10 >> 2);
            this.worker = cVar;
        }

        public final void a() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        @Override // bu.e
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // bu.d
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            a();
        }

        @Override // bu.d
        public final void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // bu.d
        public final void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.queue.offer(t10)) {
                a();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
            }
        }

        @Override // bu.e
        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                a();
            }
        }
    }

    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        public final fj.a<? super T> downstream;

        public RunOnConditionalSubscriber(fj.a<? super T> aVar, int i10, SpscArrayQueue<T> spscArrayQueue, h0.c cVar) {
            super(i10, spscArrayQueue, cVar);
            this.downstream = aVar;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2;
            int i10 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            fj.a<? super T> aVar = this.downstream;
            int i11 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && (th2 = this.error) != null) {
                        spscArrayQueue.clear();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = spscArrayQueue.poll();
                    boolean z11 = tPoll == null;
                    if (z10 && z11) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z11) {
                            break;
                        }
                        if (aVar.m(tPoll)) {
                            j11++;
                        }
                        i10++;
                        if (i10 == i11) {
                            this.upstream.request(i10);
                            i10 = 0;
                        }
                    }
                }
                if (j11 == j10) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            aVar.onError(th3);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j11);
                }
                int i12 = get();
                if (i12 == iAddAndGet) {
                    this.consumed = i10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i12;
                }
            }
        }
    }

    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        public final bu.d<? super T> downstream;

        public RunOnSubscriber(bu.d<? super T> dVar, int i10, SpscArrayQueue<T> spscArrayQueue, h0.c cVar) {
            super(i10, spscArrayQueue, cVar);
            this.downstream = dVar;
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th2;
            int i10 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            bu.d<? super T> dVar = this.downstream;
            int i11 = this.limit;
            int iAddAndGet = 1;
            while (true) {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z10 = this.done;
                    if (z10 && (th2 = this.error) != null) {
                        spscArrayQueue.clear();
                        dVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                    T tPoll = spscArrayQueue.poll();
                    boolean z11 = tPoll == null;
                    if (z10 && z11) {
                        dVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else {
                        if (z11) {
                            break;
                        }
                        dVar.onNext(tPoll);
                        j11++;
                        i10++;
                        if (i10 == i11) {
                            this.upstream.request(i10);
                            i10 = 0;
                        }
                    }
                }
                if (j11 == j10) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    if (this.done) {
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            spscArrayQueue.clear();
                            dVar.onError(th3);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            dVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j11);
                }
                int i12 = get();
                if (i12 == iAddAndGet) {
                    this.consumed = i10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i12;
                }
            }
        }
    }

    public final class a implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final bu.d<? super T>[] f34843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bu.d<T>[] f34844b;

        public a(bu.d<? super T>[] dVarArr, bu.d<T>[] dVarArr2) {
            this.f34843a = dVarArr;
            this.f34844b = dVarArr2;
        }

        @Override // io.reactivex.internal.schedulers.i.a
        public void a(int i10, h0.c cVar) {
            ParallelRunOn.this.V(i10, this.f34843a, this.f34844b, cVar);
        }
    }

    public ParallelRunOn(jj.a<? extends T> aVar, h0 h0Var, int i10) {
        this.f34840a = aVar;
        this.f34841b = h0Var;
        this.f34842c = i10;
    }

    @Override // jj.a
    public int F() {
        return this.f34840a.F();
    }

    @Override // jj.a
    public void Q(bu.d<? super T>[] dVarArr) {
        if (U(dVarArr)) {
            int length = dVarArr.length;
            bu.d<T>[] dVarArr2 = new bu.d[length];
            Object obj = this.f34841b;
            if (obj instanceof io.reactivex.internal.schedulers.i) {
                ((io.reactivex.internal.schedulers.i) obj).a(length, new a(dVarArr, dVarArr2));
            } else {
                for (int i10 = 0; i10 < length; i10++) {
                    V(i10, dVarArr, dVarArr2, this.f34841b.d());
                }
            }
            this.f34840a.Q(dVarArr2);
        }
    }

    public void V(int i10, bu.d<? super T>[] dVarArr, bu.d<T>[] dVarArr2, h0.c cVar) {
        bu.d<? super T> dVar = dVarArr[i10];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.f34842c);
        if (dVar instanceof fj.a) {
            dVarArr2[i10] = new RunOnConditionalSubscriber((fj.a) dVar, this.f34842c, spscArrayQueue, cVar);
        } else {
            dVarArr2[i10] = new RunOnSubscriber(dVar, this.f34842c, spscArrayQueue, cVar);
        }
    }
}
