package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRepeatUntil<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.e f33391c;

    public static final class RepeatSubscriber<T> extends AtomicInteger implements xi.o<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final bu.d<? super T> downstream;
        public long produced;

        /* JADX INFO: renamed from: sa, reason: collision with root package name */
        public final SubscriptionArbiter f33392sa;
        public final bu.c<? extends T> source;
        public final dj.e stop;

        public RepeatSubscriber(bu.d<? super T> dVar, dj.e eVar, SubscriptionArbiter subscriptionArbiter, bu.c<? extends T> cVar) {
            this.downstream = dVar;
            this.f33392sa = subscriptionArbiter;
            this.source = cVar;
            this.stop = eVar;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f33392sa.f()) {
                    long j10 = this.produced;
                    if (j10 != 0) {
                        this.produced = 0L;
                        this.f33392sa.i(j10);
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
            try {
                if (this.stop.a()) {
                    this.downstream.onComplete();
                } else {
                    a();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
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
            this.f33392sa.k(eVar);
        }
    }

    public FlowableRepeatUntil(xi.j<T> jVar, dj.e eVar) {
        super(jVar);
        this.f33391c = eVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        dVar.onSubscribe(subscriptionArbiter);
        new RepeatSubscriber(dVar, this.f33391c, subscriptionArbiter, this.f33524b).a();
    }
}
