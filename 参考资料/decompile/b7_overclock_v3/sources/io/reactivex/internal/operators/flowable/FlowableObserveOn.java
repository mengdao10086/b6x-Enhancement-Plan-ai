package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.h0 f33330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33332e;

    public static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements xi.o<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public Throwable error;
        public final int limit;
        public boolean outputFused;
        public final int prefetch;
        public long produced;
        public fj.o<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public int sourceMode;
        public bu.e upstream;
        public final h0.c worker;

        public BaseObserveOnSubscriber(h0.c cVar, boolean z10, int i10) {
            this.worker = cVar;
            this.delayError = z10;
            this.prefetch = i10;
            this.limit = i10 - (i10 >> 2);
        }

        public final boolean c(boolean z10, boolean z11, bu.d<?> dVar) {
            if (this.cancelled) {
                clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                this.cancelled = true;
                Throwable th2 = this.error;
                if (th2 != null) {
                    dVar.onError(th2);
                } else {
                    dVar.onComplete();
                }
                this.worker.dispose();
                return true;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                this.cancelled = true;
                clear();
                dVar.onError(th3);
                this.worker.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.cancelled = true;
            dVar.onComplete();
            this.worker.dispose();
            return true;
        }

        @Override // bu.e
        public final void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // fj.o
        public final void clear() {
            this.queue.clear();
        }

        public abstract void h();

        @Override // fj.o
        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public abstract void k();

        public abstract void n();

        public final void o() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.worker.b(this);
        }

        @Override // bu.d
        public final void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            o();
        }

        @Override // bu.d
        public final void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.error = th2;
            this.done = true;
            o();
        }

        @Override // bu.d
        public final void onNext(T t10) {
            if (this.done) {
                return;
            }
            if (this.sourceMode == 2) {
                o();
                return;
            }
            if (!this.queue.offer(t10)) {
                this.upstream.cancel();
                this.error = new MissingBackpressureException("Queue is full?!");
                this.done = true;
            }
            o();
        }

        @Override // bu.e
        public final void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                o();
            }
        }

        @Override // fj.k
        public final int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.outputFused) {
                k();
            } else if (this.sourceMode == 1) {
                n();
            } else {
                h();
            }
        }
    }

    public static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        private static final long serialVersionUID = 644624475404284533L;
        public long consumed;
        public final fj.a<? super T> downstream;

        public ObserveOnConditionalSubscriber(fj.a<? super T> aVar, h0.c cVar, boolean z10, int i10) {
            super(cVar, z10, i10);
            this.downstream = aVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void h() {
            fj.a<? super T> aVar = this.downstream;
            fj.o<T> oVar = this.queue;
            long j10 = this.produced;
            long j11 = this.consumed;
            int iAddAndGet = 1;
            while (true) {
                long j12 = this.requested.get();
                while (j10 != j12) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z11 = tPoll == null;
                        if (c(z10, z11, aVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        if (aVar.m(tPoll)) {
                            j10++;
                        }
                        j11++;
                        if (j11 == this.limit) {
                            this.upstream.request(j11);
                            j11 = 0;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        oVar.clear();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j10 == j12 && c(this.done, oVar.isEmpty(), aVar)) {
                    return;
                }
                int i10 = get();
                if (iAddAndGet == i10) {
                    this.produced = j10;
                    this.consumed = j11;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i10;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void k() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.downstream.onNext(null);
                if (z10) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void n() {
            fj.a<? super T> aVar = this.downstream;
            fj.o<T> oVar = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    try {
                        T tPoll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (aVar.m(tPoll)) {
                            j10++;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        aVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (oVar.isEmpty()) {
                    this.cancelled = true;
                    aVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i10 = get();
                    if (iAddAndGet == i10) {
                        this.produced = j10;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i10;
                    }
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.downstream.onSubscribe(this);
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j10 = this.consumed + 1;
                if (j10 == this.limit) {
                    this.consumed = 0L;
                    this.upstream.request(j10);
                } else {
                    this.consumed = j10;
                }
            }
            return tPoll;
        }
    }

    public static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements xi.o<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        public final bu.d<? super T> downstream;

        public ObserveOnSubscriber(bu.d<? super T> dVar, h0.c cVar, boolean z10, int i10) {
            super(cVar, z10, i10);
            this.downstream = dVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void h() {
            bu.d<? super T> dVar = this.downstream;
            fj.o<T> oVar = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.requested.get();
                while (j10 != jAddAndGet) {
                    boolean z10 = this.done;
                    try {
                        T tPoll = oVar.poll();
                        boolean z11 = tPoll == null;
                        if (c(z10, z11, dVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        dVar.onNext(tPoll);
                        j10++;
                        if (j10 == this.limit) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.requested.addAndGet(-j10);
                            }
                            this.upstream.request(j10);
                            j10 = 0;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        oVar.clear();
                        dVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (j10 == jAddAndGet && c(this.done, oVar.isEmpty(), dVar)) {
                    return;
                }
                int i10 = get();
                if (iAddAndGet == i10) {
                    this.produced = j10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i10;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void k() {
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z10 = this.done;
                this.downstream.onNext(null);
                if (z10) {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.downstream.onError(th2);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableObserveOn.BaseObserveOnSubscriber
        public void n() {
            bu.d<? super T> dVar = this.downstream;
            fj.o<T> oVar = this.queue;
            long j10 = this.produced;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    try {
                        T tPoll = oVar.poll();
                        if (this.cancelled) {
                            return;
                        }
                        if (tPoll == null) {
                            this.cancelled = true;
                            dVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        dVar.onNext(tPoll);
                        j10++;
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.cancelled = true;
                        this.upstream.cancel();
                        dVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (this.cancelled) {
                    return;
                }
                if (oVar.isEmpty()) {
                    this.cancelled = true;
                    dVar.onComplete();
                    this.worker.dispose();
                    return;
                } else {
                    int i10 = get();
                    if (iAddAndGet == i10) {
                        this.produced = j10;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i10;
                    }
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    fj.l lVar = (fj.l) eVar;
                    int iRequestFusion = lVar.requestFusion(7);
                    if (iRequestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = lVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = lVar;
                        this.downstream.onSubscribe(this);
                        eVar.request(this.prefetch);
                        return;
                    }
                }
                this.queue = new SpscArrayQueue(this.prefetch);
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.queue.poll();
            if (tPoll != null && this.sourceMode != 1) {
                long j10 = this.produced + 1;
                if (j10 == this.limit) {
                    this.produced = 0L;
                    this.upstream.request(j10);
                } else {
                    this.produced = j10;
                }
            }
            return tPoll;
        }
    }

    public FlowableObserveOn(xi.j<T> jVar, xi.h0 h0Var, boolean z10, int i10) {
        super(jVar);
        this.f33330c = h0Var;
        this.f33331d = z10;
        this.f33332e = i10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        h0.c cVarD = this.f33330c.d();
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new ObserveOnConditionalSubscriber((fj.a) dVar, cVarD, this.f33331d, this.f33332e));
        } else {
            this.f33524b.j6(new ObserveOnSubscriber(dVar, cVarD, this.f33331d, this.f33332e));
        }
    }
}
