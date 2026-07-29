package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSkipLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f33450g;

    public static final class SkipLastTimedSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -5677354903406201275L;
        public volatile boolean cancelled;
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

        public SkipLastTimedSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
            this.downstream = dVar;
            this.time = j10;
            this.unit = timeUnit;
            this.scheduler = h0Var;
            this.queue = new io.reactivex.internal.queue.a<>(i10);
            this.delayError = z10;
        }

        public boolean a(boolean z10, boolean z11, bu.d<? super T> dVar, boolean z12) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (z12) {
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

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z10 = this.delayError;
            TimeUnit timeUnit = this.unit;
            xi.h0 h0Var = this.scheduler;
            long j10 = this.time;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested.get();
                long j12 = 0;
                while (j12 != j11) {
                    boolean z11 = this.done;
                    Long l10 = (Long) aVar.peek();
                    boolean z12 = l10 == null;
                    boolean z13 = (z12 || l10.longValue() <= h0Var.e(timeUnit) - j10) ? z12 : true;
                    if (a(z11, z13, dVar, z10)) {
                        return;
                    }
                    if (z13) {
                        break;
                    }
                    aVar.poll();
                    dVar.onNext(aVar.poll());
                    j12++;
                }
                if (j12 != 0) {
                    io.reactivex.internal.util.b.e(this.requested, j12);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
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
            this.queue.offer(Long.valueOf(this.scheduler.e(this.unit)), t10);
            b();
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

    public FlowableSkipLastTimed(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var, int i10, boolean z10) {
        super(jVar);
        this.f33446c = j10;
        this.f33447d = timeUnit;
        this.f33448e = h0Var;
        this.f33449f = i10;
        this.f33450g = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new SkipLastTimedSubscriber(dVar, this.f33446c, this.f33447d, this.f33448e, this.f33449f, this.f33450g));
    }
}
