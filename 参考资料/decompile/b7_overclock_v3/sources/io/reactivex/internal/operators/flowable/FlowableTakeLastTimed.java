package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableTakeLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33463d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f33464e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xi.h0 f33465f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f33466g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f33467h;

    public static final class TakeLastTimedSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
        public final long count;
        public final boolean delayError;
        public volatile boolean done;
        public final bu.d<? super T> downstream;
        public Throwable error;
        public final io.reactivex.internal.queue.a<Object> queue;
        public final AtomicLong requested = new AtomicLong();
        public final xi.h0 scheduler;
        public final long time;
        public final TimeUnit unit;
        public bu.e upstream;

        public TakeLastTimedSubscriber(bu.d<? super T> dVar, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
            this.downstream = dVar;
            this.count = j10;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = h0Var;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.delayError = z10;
        }

        public boolean a(boolean z10, bu.d<? super T> dVar, boolean z11) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z11) {
                if (!z10) {
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
            if (!z10) {
                return false;
            }
            dVar.onComplete();
            return true;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z10 = this.delayError;
            int iAddAndGet = 1;
            do {
                if (this.done) {
                    if (a(aVar.isEmpty(), dVar, z10)) {
                        return;
                    }
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        if (a(aVar.peek() == null, dVar, z10)) {
                            return;
                        }
                        if (j10 != j11) {
                            aVar.poll();
                            dVar.onNext(aVar.poll());
                            j11++;
                        } else if (j11 != 0) {
                            io.reactivex.internal.util.b.e(this.requested, j11);
                        }
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void c(long j10, io.reactivex.internal.queue.a<Object> aVar) {
            long j11 = this.time;
            long j12 = this.count;
            boolean z10 = j12 == Long.MAX_VALUE;
            while (!aVar.isEmpty()) {
                if (((Long) aVar.peek()).longValue() >= j10 - j11 && (z10 || (aVar.p() >> 1) <= j12)) {
                    return;
                }
                aVar.poll();
                aVar.poll();
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // bu.d
        public void onComplete() {
            c(this.scheduler.e(this.unit), this.queue);
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.delayError) {
                c(this.scheduler.e(this.unit), this.queue);
            }
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // bu.d
        public void onNext(T t10) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long jE = this.scheduler.e(this.unit);
            aVar.offer(Long.valueOf(jE), t10);
            c(jE, aVar);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
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

    public FlowableTakeLastTimed(xi.j<T> jVar, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
        super(jVar);
        this.f33462c = j10;
        this.f33463d = j11;
        this.f33464e = timeUnit;
        this.f33465f = h0Var;
        this.f33466g = i10;
        this.f33467h = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new TakeLastTimedSubscriber(dVar, this.f33462c, this.f33463d, this.f33464e, this.f33465f, this.f33466g, this.f33467h));
    }
}
