package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRetryPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.r<? super Throwable> f33417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33418d;

    public static final class RetrySubscriber<T> extends AtomicInteger implements xi.o<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final bu.d<? super T> downstream;
        public final dj.r<? super Throwable> predicate;
        public long produced;
        public long remaining;

        /* JADX INFO: renamed from: sa, reason: collision with root package name */
        public final SubscriptionArbiter f33419sa;
        public final bu.c<? extends T> source;

        public RetrySubscriber(bu.d<? super T> dVar, long j10, dj.r<? super Throwable> rVar, SubscriptionArbiter subscriptionArbiter, bu.c<? extends T> cVar) {
            this.downstream = dVar;
            this.f33419sa = subscriptionArbiter;
            this.source = cVar;
            this.predicate = rVar;
            this.remaining = j10;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f33419sa.f()) {
                    long j10 = this.produced;
                    if (j10 != 0) {
                        this.produced = 0L;
                        this.f33419sa.i(j10);
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
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            long j10 = this.remaining;
            if (j10 != Long.MAX_VALUE) {
                this.remaining = j10 - 1;
            }
            if (j10 == 0) {
                this.downstream.onError(th2);
                return;
            }
            try {
                if (this.predicate.a(th2)) {
                    a();
                } else {
                    this.downstream.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.downstream.onError(new CompositeException(th2, th3));
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            this.f33419sa.k(eVar);
        }
    }

    public FlowableRetryPredicate(xi.j<T> jVar, long j10, dj.r<? super Throwable> rVar) {
        super(jVar);
        this.f33417c = rVar;
        this.f33418d = j10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        dVar.onSubscribe(subscriptionArbiter);
        new RetrySubscriber(dVar, this.f33418d, this.f33417c, subscriptionArbiter, this.f33524b).a();
    }
}
