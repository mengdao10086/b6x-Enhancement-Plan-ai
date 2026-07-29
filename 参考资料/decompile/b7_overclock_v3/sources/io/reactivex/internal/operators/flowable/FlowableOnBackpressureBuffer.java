package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableOnBackpressureBuffer<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f33334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f33335e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.a f33336f;

    public static final class BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        public volatile boolean cancelled;
        public final boolean delayError;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public Throwable error;
        public final dj.a onOverflow;
        public boolean outputFused;
        public final fj.n<T> queue;
        public final AtomicLong requested = new AtomicLong();
        public bu.e upstream;

        public BackpressureBufferSubscriber(bu.d<? super T> dVar, int i10, boolean z10, boolean z11, dj.a aVar) {
            this.downstream = dVar;
            this.onOverflow = aVar;
            this.delayError = z11;
            this.queue = z10 ? new io.reactivex.internal.queue.a<>(i10) : new SpscArrayQueue<>(i10);
        }

        public void b() {
            if (getAndIncrement() == 0) {
                fj.n<T> nVar = this.queue;
                bu.d<? super T> dVar = this.downstream;
                int iAddAndGet = 1;
                while (!c(this.done, nVar.isEmpty(), dVar)) {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (j11 != j10) {
                        boolean z10 = this.done;
                        T tPoll = nVar.poll();
                        boolean z11 = tPoll == null;
                        if (c(z10, z11, dVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        dVar.onNext(tPoll);
                        j11++;
                    }
                    if (j11 == j10 && c(this.done, nVar.isEmpty(), dVar)) {
                        return;
                    }
                    if (j11 != 0 && j10 != Long.MAX_VALUE) {
                        this.requested.addAndGet(-j11);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        public boolean c(boolean z10, boolean z11, bu.d<? super T> dVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.delayError) {
                if (!z11) {
                    return false;
                }
                Throwable th2 = this.error;
                if (th2 != null) {
                    dVar.onError(th2);
                } else {
                    dVar.onComplete();
                }
                return true;
            }
            Throwable th3 = this.error;
            if (th3 != null) {
                this.queue.clear();
                dVar.onError(th3);
                return true;
            }
            if (!z11) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (this.outputFused || getAndIncrement() != 0) {
                return;
            }
            this.queue.clear();
        }

        @Override // fj.o
        public void clear() {
            this.queue.clear();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                b();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th2);
            } else {
                b();
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                if (this.outputFused) {
                    this.downstream.onNext(null);
                    return;
                } else {
                    b();
                    return;
                }
            }
            this.upstream.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                missingBackpressureException.initCause(th2);
            }
            onError(missingBackpressureException);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // bu.e
        public void request(long j10) {
            if (this.outputFused || !SubscriptionHelper.validate(j10)) {
                return;
            }
            io.reactivex.internal.util.b.a(this.requested, j10);
            b();
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public FlowableOnBackpressureBuffer(xi.j<T> jVar, int i10, boolean z10, boolean z11, dj.a aVar) {
        super(jVar);
        this.f33333c = i10;
        this.f33334d = z10;
        this.f33335e = z11;
        this.f33336f = aVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new BackpressureBufferSubscriber(dVar, this.f33333c, this.f33334d, this.f33335e, this.f33336f));
    }
}
