package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableRetryBiPredicate<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super Integer, ? super Throwable> f33415c;

    public static final class RetryBiSubscriber<T> extends AtomicInteger implements xi.o<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        public final bu.d<? super T> downstream;
        public final dj.d<? super Integer, ? super Throwable> predicate;
        public long produced;
        public int retries;

        /* JADX INFO: renamed from: sa, reason: collision with root package name */
        public final SubscriptionArbiter f33416sa;
        public final bu.c<? extends T> source;

        public RetryBiSubscriber(bu.d<? super T> dVar, dj.d<? super Integer, ? super Throwable> dVar2, SubscriptionArbiter subscriptionArbiter, bu.c<? extends T> cVar) {
            this.downstream = dVar;
            this.f33416sa = subscriptionArbiter;
            this.source = cVar;
            this.predicate = dVar2;
        }

        public void a() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                while (!this.f33416sa.f()) {
                    long j10 = this.produced;
                    if (j10 != 0) {
                        this.produced = 0L;
                        this.f33416sa.i(j10);
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
            try {
                dj.d<? super Integer, ? super Throwable> dVar = this.predicate;
                int i10 = this.retries + 1;
                this.retries = i10;
                if (dVar.a(Integer.valueOf(i10), th2)) {
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
            this.f33416sa.k(eVar);
        }
    }

    public FlowableRetryBiPredicate(xi.j<T> jVar, dj.d<? super Integer, ? super Throwable> dVar) {
        super(jVar);
        this.f33415c = dVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SubscriptionArbiter subscriptionArbiter = new SubscriptionArbiter(false);
        dVar.onSubscribe(subscriptionArbiter);
        new RetryBiSubscriber(dVar, this.f33415c, subscriptionArbiter, this.f33524b).a();
    }
}
