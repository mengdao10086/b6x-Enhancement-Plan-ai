package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRepeat<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33389c;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements xi.o<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final bu.d<? super T> downstream;
        public long produced;
        public long remaining;

        /* JADX INFO: renamed from: sa, reason: collision with root package name */
        public final SubscriptionArbiter f33390sa;
        public final bu.c<? extends T> source;

        public RepeatSubscriber(bu.d<? super T> dVar, long j10, SubscriptionArbiter subscriptionArbiter, bu.c<? extends T> cVar) {
            this.downstream = dVar;
            this.f33390sa = subscriptionArbiter;
            this.source = cVar;
            this.remaining = j10;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f33390sa.f()) {
                    long j10 = this.produced;
                    if (j10 != 0) {
                        this.produced = 0L;
                        this.f33390sa.i(j10);
                    }
                    this.source.d(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // bu.d
        public void onComplete() {
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 != 0) {
                a();
            } else {
                this.downstream.onComplete();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            this.f33390sa.k(eVar);
        }
    }

    public FlowableRepeat(xi.j<T> jVar, long j10) {
        super(jVar);
        this.f33389c = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        dVar.onSubscribe(subscriptionArbiter);
        long j10 = this.f33389c;
        new RepeatSubscriber(dVar, j10 != Long.MAX_VALUE ? j10 - 1 : Long.MAX_VALUE, subscriptionArbiter, this.f33524b).a();
    }
}
